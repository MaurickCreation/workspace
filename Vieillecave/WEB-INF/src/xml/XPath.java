package xml;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import org.jdom.Element;
import org.jaxen.JaxenException;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import xml.ServiceXML;
import donnees.*;

public class XPath {
    
    private ServiceXML xml;
    private Document doc;
    private SAXBuilder builder;
    
    public XPath(){
        xml = new ServiceXML("cave");
        builder = new SAXBuilder();
        try {
            doc = builder.build(xml.ficPath("cave.xml"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList getList(String type, String req){
        
        List results;
        ArrayList objet = new ArrayList();
        JDOMXPath xpath;
        try {
            xpath = new JDOMXPath(req);
            results = xpath.selectNodes(doc);
            Iterator resultIter = results.iterator();
            Element el;
            if(type.equals("chateau")){
                while (resultIter.hasNext()) {
                    el = (Element) resultIter.next();
                    Chateau c = Chateau.getInstanceChateau(el);
                    objet.add(c);
                }
            }else{
                if(type.equals("bouteille")){
                    while (resultIter.hasNext()) {
                        el = (Element) resultIter.next();
                        Bouteille b = Bouteille.getInstanceBouteille(el);
                        objet.add(b);
                    }
                }else{
                    if(type.equals("cuvee")){
                        while (resultIter.hasNext()) {
                            el = (Element) resultIter.next();
                            Cuvee cu = Cuvee.getInstanceCuvee(el);
                            objet.add(cu);
                        }
                    }else{
                        if(type.equals("appellation")){
                            while (resultIter.hasNext()) {
                                el = (Element) resultIter.next();
                                Appellation a = Appellation.getInstanceAppellation(el);
                                objet.add(a);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("err "+e);
            e.printStackTrace();
        }
        return objet;
    }
	
	public static boolean loginDispo(String login){
		ServiceXML Xml = new ServiceXML("annu_client");
		List results;
		boolean boolDispo = true;
		Document doc;
		JDOMXPath xpath;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build(Xml.ficPath("client.xml"));
			xpath = new JDOMXPath("//client[login='"+login+"']");
			results = xpath.selectNodes(doc);
			if (results.size()> 0) boolDispo = false;
			
		} catch (Exception e) {
			System.out.println("err "+e);
			e.printStackTrace();
		}
		
		return boolDispo;
	}
        
	public static boolean authentification(String login, String mdp){
		ServiceXML Xml = new ServiceXML("annu_client");
		boolean boolOK = false;
		List results;
		Document doc;
		JDOMXPath xpath;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build(Xml.ficPath("client.xml"));
			xpath = new JDOMXPath("//client[login='" + login + "' and mdp='" + mdp + "']");
			results = xpath.selectNodes(doc);
			if (results.size()> 0) boolOK = true;
			
		} catch (Exception e) {
			System.out.println("err "+e);
			e.printStackTrace();
		}
		return boolOK;
	}
	
	public static int cuveeDispo(String id){
		
		List results;
		int nbCuvee = 0;
		Document doc;
		JDOMXPath xpath;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build("cave.xml");
			xpath = new JDOMXPath("//CUVEE[@id='"+id+"']/NOMBRE");
			results = xpath.selectNodes(doc);
			Iterator resultIter = results.iterator();
			if (results.size() >0){
				Integer itgTmp = new Integer((String)((Element)resultIter.next()).getValue());
				nbCuvee = itgTmp.intValue();
			}
		} catch (Exception e) {
			System.out.println("err "+e);
			e.printStackTrace();
		}
		
		return nbCuvee;
	}

    /**
	 * change la valeur "NOMBRE" de CUVEE dans le fichier cave.xml
	 * @param id 
	 * @param nombre : positif dans le cas de 
	 * l'ajout de bouteille et n�gatif lors de 
	 * la validation d'une commande
	 * @return 	1, si OK 
	 * 			2, si aucune cuv�e avec cet identifiant existe
	 * 			3, si plus d'une cuv�e a �t� trouv�e avec le m�me identifiant			
	 * 			n�gatif, si on retire plus de bouteilles que dispo dans le stock
	 * 					 le chiffre retourn� indiquant le nombre de bouteilles demand�es en trop
	 */		
	public static int modifBouteille(String id, int nombre){
		
		ServiceXML x = new ServiceXML("CAVE");
		int error = 1; 
		List results;
		JDOMXPath xpath;
		String fichier = x.ficPath("cave.xml");//A MODIF
		
		try {
			x.lireFichier(fichier);
			xpath = new JDOMXPath("//CUVEE[@id='"+id+"']/NOMBRE");
			results = xpath.selectNodes(x.document);
			Iterator resultIter = results.iterator();
			if (results.size() == 0) error = 2;
			else if (results.size()> 1) error = 3;
			else{ 
				Element el = (Element)resultIter.next();
				int nbActuel = (new Integer(el.getText())).intValue();
				if ((nombre + nbActuel) < 0) {
					error = nombre + nbActuel;
				}
				else {
					String newValue = new Integer(nbActuel + nombre).toString();
					el.setText(newValue);
					XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
					sortie.output(x.document, new FileOutputStream(fichier));
					if ((nombre + nbActuel)==0) {
						if (chateauVide(x,id))
							supprChateau(x,id);
					}
				}
			}	
		}
		catch (Exception e) {
			System.out.println("err "+e);
			e.printStackTrace();
		}
		return error;
	}
	
	
	/**
	 * Renvoie true si le chateau qui propose la cuv�e d'identifiant
	 * idCuvee n'a plus une seule cuv�e dont le stock est 
	 * sup�rieur � z�ro. Dans ce cas l�, on supprime le
	 * chateau � l'aide de la fonction supprChateau.
	 * @param x : ServiceXML
	 * @param idCuvee
	 * @return
	 */
	public static boolean chateauVide(ServiceXML x, String idCuvee ){
		
		JDOMXPath xpath;
		List results;
		boolean vide = true;
		try {
			xpath = new JDOMXPath("//CUVEE[@id='" + idCuvee + "']/ancestor::CHATEAU/BOUTEILLE/CUVEE/NOMBRE");
			results = xpath.selectNodes(x.document);
			Iterator resultIter = results.iterator();
			while (resultIter.hasNext()){
				if (!((Element) resultIter.next()).getText().equals("0")) vide = false;
			}
		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vide;
	}
	
	/**
	 * Supprime le chateau qui propose la cuv�e d'identifiant idCuvee
	 * @param x : instance de ServiceXML
	 * @param idCuvee
	 */
	public static void supprChateau(ServiceXML x, String idCuvee ){
		
		JDOMXPath xpath;
		List results;
		boolean trouve = false;
		Element eltChateau, eltAppellation;
		Iterator resultIter;
		String strIdChateau;
		
		try {
			
			//r�cup�ration de l'identifiant du chateau
			xpath = new JDOMXPath("//CUVEE[@id='" + idCuvee + "']/ancestor::CHATEAU");
			results = xpath.selectNodes(x.document);
			resultIter = results.iterator();
			strIdChateau=((Element)resultIter.next()).getAttributeValue("id");
			
			//r�cup�ration du noeud appellation contenant le chateau recherch�
			xpath = new JDOMXPath("//CHATEAU[@id='" + strIdChateau + "']/ancestor::APPELLATION");
			results = xpath.selectNodes(x.document);
			resultIter = results.iterator();
			List chateaux;
			eltAppellation = (Element)resultIter.next();
			chateaux = eltAppellation.getChildren();
			Iterator resultIterChateaux = chateaux.iterator();
			resultIterChateaux.next();//pour ignorer la balise <NOM_APPELLATION>
			System.out.println(trouve);
			//recherche et suppression du chateau parmi les chateaux de l'appellation
			while (!trouve && resultIterChateaux.hasNext()){
				eltChateau = ((Element)resultIterChateaux.next());
				System.out.println("fdsq " + strIdChateau);
				if (eltChateau.getAttributeValue("id").equals(strIdChateau)){
					trouve = true;
					eltAppellation.removeContent(eltChateau);
					try {
						x.enregistre("cave.xml");//A MODIF
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
}


