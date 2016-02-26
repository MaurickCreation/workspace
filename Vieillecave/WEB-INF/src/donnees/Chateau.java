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
 * Repr�sente un chateau
 * Un chateau poss�de un ou plusieurs type de bouteilles et appartient � une seule appellation
 * @author Groupe de Nicolas,Maurick, Renaud et Benoit
 */

public class Chateau {
    
    private String id, nomChateau, adresse, departement, telephone;
    private Appellation appellation;
    private XPath serv;
    private ServiceXML xml;
    
    
    /**
     * constructeur
     * @param id n� du chateau
     * @param nomChateau son nom
     * @param departement le d�partement administratif
     * @param adresse son adresse
     * @param telephone son n� de t�l�phone (peut �tre un num�ro internationale)
     * @param appellation son appellation
     */
    public Chateau(String id, String nomChateau, String departement, String adresse, String telephone, Appellation appellation){
        
        this.setId(id);
        this.setAppellation(appellation);
        this.setNomChateau(nomChateau);
        this.setAdresse(adresse);
        this.setDepartement(departement);
        this.setTelephone(telephone);
        xml = new ServiceXML("cave");
        serv = new XPath();
        
    }
    
    /**
     * constructeur
     */
    public Chateau(){
        xml = new ServiceXML("cave");
        serv = new XPath();
    }
    
    public static Chateau getInstanceChateau(Element e){
        String id=e.getAttributeValue("id");
        String departement = e.getAttributeValue("dep");
        String nomChateau = e.getChildText("NOM_CHATEAU");
        String adresse = e.getChildText("ADRESSE_CHATEAU");
        String telephone = e.getChildText("TEL_CHATEAU");
        Appellation appellation = Appellation.getInstanceAppellation(e.getParentElement());
        return new Chateau(id, nomChateau, departement, adresse, telephone, appellation);
    }
    
    public Chateau getElementChateau(String idChateau){
        String req = "/CAVE/APPELLATION/CHATEAU[@id="+idChateau+"]";
        Chateau c= (Chateau) serv.getList("chateau",req).get(0);
        return c;
    }
   
    
    public ArrayList getListChateau(String idAppellation){
        String req = "/CAVE/APPELLATION/CHATEAU[parent::APPELLATION[@id="+idAppellation+"]]";
        ArrayList c = new ArrayList();
        ArrayList temp = serv.getList("chateau",req);
        for(int i=0;i<temp.size();i++){
            c.add((Chateau)temp.get(i));
        }
        return c;
    }
    
    public ArrayList getListChateau(){
        String req = "/CAVE/APPELLATION/CHATEAU";
        ArrayList c = new ArrayList();
        ArrayList temp = serv.getList("chateau",req);
        for(int i=0;i<temp.size();i++){
            c.add((Chateau)temp.get(i));
        }
        return c;
    }
    
    public ArrayList getListDepartement(){
        List chateau = (new Chateau()).getListChateau();
        ArrayList dep = new ArrayList();
        for(int i=0;i<chateau.size();i++){
            Chateau tempC = (Chateau) chateau.get(i);
            if(dep.isEmpty()){
                dep.add(tempC.getDepartement());
            }else{//il faut tester si dep n'est aps deja dans la liste
                int j=0;
                boolean trouve=false;
                String temp = tempC.getDepartement();
                while(j<dep.size() && !trouve){
                    if(temp.equals((String) dep.get(j))){
                        trouve=true;
                    }
                    j++;
                }
                if(!trouve){
                    dep.add(temp);
                }
            }
        }
        //trie dans l'ordre croissant
        Collections.sort(dep);
        return dep;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Appellation getAppellation() {
        return appellation;
    }
    
    public void setAppellation(Appellation appellation) {
        this.appellation = appellation;
    }
    
    public String getNomChateau() {
        return nomChateau;
    }
    
    public void setNomChateau(String nomChateau) {
        this.nomChateau = nomChateau;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public String getDepartement() {
        return departement;
    }
    
    public void setDepartement(String departement) {
        this.departement = departement;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
