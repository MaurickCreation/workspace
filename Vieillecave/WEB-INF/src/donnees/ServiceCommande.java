package donnees;
import xml.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jaxen.JaxenException;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class ServiceCommande {
	
	public ServiceCommande() {}
	
	public Commande getInstanceCommande(Element e){
		String id=e.getAttributeValue("id");
		String client = e.getChildText("CLIENT");
		String date = e.getChildText("DATE");
		String date_valid = e.getChildText("DATE_VALID");
		List cuvees = getCuvees(e.getChildren("CUVEE"));
		List quantite = getQuantite(e.getChildren("CUVEE"));;
		return new Commande(id,client,date,date_valid,cuvees,quantite);
	}
	
	public List getCuvees(List l){
		List result = new Vector();
		for (int i=0;i<l.size();i++) {
			//result.add(l.get(i).getAttributeValue("id"));
			result.add(l.get(i).toString());
		}
		return result;
	}
	
	public List getQuantite(List l){
		List result = new Vector();
		for (int i=0;i<l.size();i++) {
//			result.add(l.get(i).getChildText("NOMBRE"));
			result.add(l.get(i).toString());
		}
		return result;
	}
	
	public Commande getElementCommande(String idCommande){
		Element result;	
		Document doc;
		Commande c = new Commande();
		JDOMXPath xpath;
		SAXBuilder builder = new SAXBuilder();		
		ServiceXML Xml = new ServiceXML("LISTE_COMMANDES");
		try {
			doc = builder.build(Xml.ficPath("commande.xml"));
			String requete = "/LISTE_COMMANDES/COMMANDE[@id="+idCommande+"]";
			xpath = new JDOMXPath(requete);
			result = (Element)xpath.selectSingleNode(doc);
			c = this.getInstanceCommande(result);
		} catch (JDOMException e) {
			System.out.println("err "+e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("err "+e);
			e.printStackTrace();
		} catch (JaxenException e) {
			System.out.println("err "+e);
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List getListCommande(String idClient){
		List results;
		List commande = new ArrayList();
		Document doc;
		JDOMXPath xpath;
		SAXBuilder builder = new SAXBuilder();		
		ServiceXML Xml = new ServiceXML("LISTE_COMMANDES");
		try {
			doc = builder.build(Xml.ficPath("commande.xml"));
			xpath = new JDOMXPath("/LISTE_COMMANDES/COMMANDE[CLIENT='"+idClient+"']");
			results = xpath.selectNodes(doc);
			Iterator resultIter = results.iterator();
			Element el;
			while (resultIter.hasNext())
			{
				el = (Element) resultIter.next();
				Commande c = this.getInstanceCommande(el);
				commande.add(c);
			}
		} catch (JDOMException e) {
			System.out.println("err "+e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("err "+e);
			e.printStackTrace();
		} catch (JaxenException e) {
			System.out.println("err "+e);
			e.printStackTrace();
		}
		
		return commande;
	}
	
}
