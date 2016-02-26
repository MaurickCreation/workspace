package donnees;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import xml.*;
/*
 * Created on 23 mars 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 *Repr�sente un type de bouteilles
 *Une bouteille appartient � un et un seul chateau et poss�de une ou plusieurs cuv�es
 * @author Groupe de Nicolas,Maurick, Renaud et Benoit
 */
public class Bouteille {
    
    private String id, nom;
    private Chateau chateau;
    private XPath serv;
    private ServiceXML xml;
    
    /**
     * constructeur
     * @param id n� du type
     * @param nom libell�
     * @param chateau chateau poss�dant ce type de bouteilles
     */
    public Bouteille(String id, String nom, Chateau chateau){
        
        this.setId(id);
        this.setNom(nom);
        this.setChateau(chateau);
        xml = new ServiceXML("cave");
        serv = new XPath();
    }
    
    
    public ArrayList getListBouteille(String idChateau){
        String req = "/CAVE/APPELLATION/CHATEAU/BOUTEILLE[parent::CHATEAU[@id="+idChateau+"]]";
        ArrayList b = new ArrayList();
        ArrayList temp = serv.getList("bouteille", req);
        for(int i=0;i<temp.size();i++){
            b.add((Bouteille)temp.get(i));
        }
        return b;
    }
    
    public static Bouteille getInstanceBouteille(Element e){
        String id =e.getAttributeValue("id");
        String nom = e.getChildText("NOM");
        Chateau chateau = Chateau.getInstanceChateau(e.getParentElement());
        return new Bouteille(id, nom, chateau);
    }
    
    public String getId() {
        return id;
    }
    
    public String gettest() {
        return "test";
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Chateau getChateau() {
        return chateau;
    }
    
    public void setChateau(Chateau chateau) {
        this.chateau = chateau;
    }
}