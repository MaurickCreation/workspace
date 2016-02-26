package donnees;
import java.util.*;
import org.jdom.*;
import xml.*;
/*
 * Created on 23 mars 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * Repr�sente une appellation, soit un regroupement de chateaux
 * 
 * String id : le n� de l'appellation
 * String nomAppellation : son libell�
 * @author Groupe de Nicolas,Maurick, Renaud et Benoit
 */
public class Appellation {
	
	
	private String id, nomAppellation;
        private XPath serv;
	
    /**
     * Constructeur d'une appellation
     * @param id n� de l'appellation
     * @param nomAppelation son libell�
     */
	public Appellation(String id, String nomAppellation){
		
		this.setId(id);
		this.setNomAppellation(nomAppellation);	
                serv = new XPath();
	}
        
        /**
     * Constructeur d'une appellation
     */
	public Appellation(){
            serv = new XPath();
        }
        
         public static Appellation getInstanceAppellation(Element e){
        String id = e.getAttributeValue("id");
        String nomAppellation = e.getChildText("NOM_APPELLATION");
        return new Appellation(id,nomAppellation);
    }
         
         public Appellation getElementAppellation(String idAppellation){
        String req = "/CAVE/APPELLATION[@id="+idAppellation+"]";
        Appellation a = (Appellation) serv.getList("appellation",req).get(0);
        return a;
    }
         
      /*   public List<Appellation> getListAppellation(){
        String req = "//APPELLATION";
        List<Appellation> a = new ArrayList();
        List<Object> temp = serv.getList("appellation", req);
        for(int i=0;i<temp.size();i++){
            a.add((Appellation)temp.get(i));
        }
        return a;
    }*/
    public ArrayList getListAppellation(){
             String req = "//APPELLATION";
             ArrayList a = new ArrayList();
             ArrayList temp = serv.getList("appellation", req);
             for(int i=0;i<temp.size();i++){
                 a.add((Appellation)temp.get(i));
             }
             return a;
    }  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomAppellation() {
        return nomAppellation;
    }

    public void setNomAppellation(String nomAppellation) {
        this.nomAppellation = nomAppellation;
    }
	
}