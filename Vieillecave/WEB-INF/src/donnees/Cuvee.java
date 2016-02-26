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
 * Repr�sente une cuv�e
 * Une cuv�e appartient � un et un seul type de bouteilles et peut �tre utilis� dans plusieurs commandes
 * @author Groupe de Nicolas,Maurick, Renaud et Benoit
 */
public class Cuvee {
    
    private String id, annee;
    private int nombre, prix;
    private Bouteille bouteille;
    private XPath serv;
    private ServiceXML xml;
    
    /**
     * constructeur
     * @param id n� de la cuv�e
     * @param bouteille type de bouteille
     * @param annee ann�e de vendange
     * @param nombre nombre en stock
     * @param prix prix unitaire
     */
    public Cuvee(){}
    
    public Cuvee(String id, Bouteille bouteille, String annee, int nombre, int prix){
        
        this.setId(id);
        this.setBouteille(bouteille);
        this.setAnnee(annee);
        this.setNombre(nombre);
        this.setPrix(prix);
        xml = new ServiceXML("cave");
        serv = new XPath();
    }
    
    public static Cuvee getInstanceCuvee(Element e){
        String id= e.getAttributeValue("id");
        String annee = e.getAttributeValue("annee");
        String nombre = e.getChildText("NOMBRE");
        String prix = e.getChildText("PRIX");
        Bouteille bouteille = Bouteille.getInstanceBouteille(e.getParentElement());
        return new Cuvee(id, bouteille, annee, Integer.parseInt(nombre),Integer.parseInt( prix));
    }
    
    public ArrayList getListCuvee(String idBouteille){
        String req = "/CAVE/APPELLATION/CHATEAU/BOUTEILLE/CUVEE[parent::BOUTEILLE[@id="+idBouteille+"]]";
        ArrayList c = new ArrayList();
        ArrayList temp = serv.getList("cuvee", req);
        for(int i=0;i<temp.size();i++){
            c.add((Cuvee)temp.get(i));
        }
        return c;
    }
    
    public ArrayList getListCuvee(){
    	String req = "//CUVEE";
    	ArrayList c = new ArrayList();
    	ArrayList temp=serv.getList("cuvee", req);
    	for(int i=0;i<temp.size();i++){
            c.add((Cuvee)temp.get(i));
        }
        return c;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Bouteille getBouteille() {
        return bouteille;
    }
    
    public void setBouteille(Bouteille bouteille) {
        this.bouteille = bouteille;
    }
    
    public String getAnnee() {
        return annee;
    }
    
    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
    public int getNombre() {
        return nombre;
    }
    
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    public int getPrix() {
        return prix;
    }
    
    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public void afficheCuvee(){
    	System.out.println("Id cuvee: "+this.id);
    	System.out.println("Nom annee: "+this.annee);
    	System.out.println("Nombre cuvee: "+this.nombre);
    	System.out.println("prix cuvee: "+this.prix);
    	System.out.println("id de la bouteille: "+this.bouteille.getId());
    	
    }
    
}
