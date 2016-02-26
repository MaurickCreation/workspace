package donnees;
import java.util.*;
import java.lang.*;

/*
 * Created on 23 mars 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * 
 * Cette classe permet la gestion des 
 * 
 * String id = n� de la commande
 * String dateCommande = date � laquelle elle a �t� faite de format "jj-mm-aaaa"
 * String dateValidation = date de validation de la commande de format "jj-mm-aaaa" = "" si la commande n'a pas �t� valid�e
 * int total = prix total de la commande
 * List cuvees = liste des cuvees command�es
 * List quantite = liste des quantites command�es
 * Client client = celui qui a pass� la commande
 * @author Groupe de Nicolas,Maurick, Renaud et Benoit
 */

public class Commande {
	
	private String id, dateCommande, dateValidation, client; 
        private int total;
        private List cuvees, quantite;
        //private Client client;
	
        /**
     * Constructeur
     * @param client le client
     * @param dateCommande la date � laquelle la commande a �t� pass�e
     */
     
    public Commande() {}
     
	public Commande(String id, String client, String dateCommande, String dateValidation, List cuvees, List quantite){
		
			this.id = id;
			this.client = client;
			this.dateValidation = dateValidation;
			this.dateCommande = dateCommande;
			this.cuvees = cuvees;
			this.quantite = quantite;
	}
    
        /**
     * Calcul et met � jour la valeur
     * @return int le total
     */
    public int calculTotal(){
        int tot = 0;
        for(int i=0; i<cuvees.size(); i++){
            Cuvee cu = (Cuvee)cuvees.get(i);
            Integer qtt = (Integer)quantite.get(i);
            tot += cu.getPrix()*qtt.intValue();
        }
        this.setTotal(tot);
        return tot;
    }
    
    /**
     * Ajoute ou modifie un article
     * Si l'article n'est pas dans la commande il l'ajoute en bout de liste, sinon il rajoute la nouvelle quantite � l'ancienne
     * @param cuvee l'article � ajouter
     * @param qtt la quantit� voulue
     */
    public void ajoutArticle(Cuvee cuvee, int qtt){
        //recherche si l'article n'y est pas deja
        for(int i=0; i<cuvees.size(); i++){
            if(((Cuvee)cuvees.get(i)).getId() == cuvee.getId() ){
                //alors modification, on ajoute la qtt � la pr�c�dente
                Integer qttTemp = (Integer)quantite.get(i);
                int tot = qttTemp.intValue() + qtt;
                qttTemp = new Integer(tot);
                quantite.set(i,qttTemp);
            }else{
                //ajout en bout de liste
                cuvees.add(cuvee);
                Integer qttTemp = new Integer(qtt);
                quantite.add(qttTemp);
            }
        }
        calculTotal();
    }
    
    /**
     * Supprime un article et recalcule le total
     * @param cuvee l'article � supprimer
     * @return retourne vrai si la suppression a �t� faite sinon false
     */
    public boolean supArticle(Cuvee cuvee){
        boolean flag = false;
        for(int i=0; i<cuvees.size(); i++){
            if(((Cuvee)cuvees.get(i)).getId() == cuvee.getId() ){
                cuvees.remove(i);
                quantite.remove(i);
                flag = true;
            }
        }
        
        if(flag){
            calculTotal();
        }        
        return flag;        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(String dateValidation) {
        this.dateValidation = dateValidation;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getCuvees() {
        return cuvees;
    }

    public void setCuvees(List cuvees) {
        this.cuvees = cuvees;
    }

    public List getQuantite() {
        return quantite;
    }

    public void setQuantite(List quantite) {
        this.quantite = quantite;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

}
