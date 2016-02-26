package donnees;
import java.io.File;
import java.io.IOException;
import java.net.*;
import org.jdom.Element;
import xml.ServiceXML;
import java.util.*;

/*
 * Created on 21 mars 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * Représente un client
 * Un client peut avoir une ou plusieurs commandes
 * @author Groupe de Nicolas,Maurick, Renaud et Benoit
 */
public class Client {
    
    ServiceXML Xml;
    String login, mdp, nom, prenom, adresse, telephone, fichier, racine;
    
    /**
     * Constructeur
     * @param login son login
     * @param mdp son mot de passe
     * @param nom son nom
     * @param prenom son prenom
     * @param adresse son adresse postale
     * @param telephone son n° de téléphone
     */
    public Client(String login, String mdp, String nom, String prenom, String adresse, String telephone) {
        
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        racine = "annu_client";
        Xml = new ServiceXML(racine);      
        fichier = "client.xml";     
    }
    
   /* public String ficPath(){
        return Xml.ficPath(fichier);
    }*/
    
    /**
     * Ajoute un client en bout du fichier XML correspondant
     * Lit le fichier, l'ajoute à l'arbre
     * @return retourne true si la création s'est correctement effectué sinon false
     */
    public boolean creer() {
        
        try{
            //creerFic();
            Xml.lireFichier(Xml.ficPath(fichier));
            
            Element eClient = new Element("client");
            Xml.ajoutRacine(eClient);
            Element eLogin = new Element("login");
            eLogin.setText(login);
            Xml.ajout(eClient,eLogin);
            Element eMdp = new Element("mdp");
            eMdp.setText(mdp);
            Xml.ajout(eClient,eMdp);
            Element eNom = new Element("nom");
            eNom.setText(nom);
            Xml.ajout(eClient,eNom);
            Element ePrenom = new Element("prenom");
            ePrenom.setText(prenom);
            Xml.ajout(eClient, ePrenom);
            Element eAdresse = new Element("adresse");
            eAdresse.setText(adresse);
            Xml.ajout(eClient,eAdresse);
            Element eTel = new Element("telephone");
            eTel.setText(telephone);
            Xml.ajout(eClient,eTel);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**
     * Ecrit l'arbre client courant dans le fichier
     * @return retourne true si l'enregistrement s'est effectué correctement sinon false
     */
    public boolean enregistrer() {        
        try{
            Xml.enregistre(Xml.ficPath(fichier));
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**
     * @return Returns the adresse.
     */
    public String getAdresse() {
        return adresse;
    }
    /**
     * @param adresse The adresse to set.
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    /**
     * @return Returns the login.
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param login The login to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * @return Returns the mdp.
     */
    public String getMdp() {
        return mdp;
    }
    /**
     * @param mdp The mdp to set.
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    /**
     * @return Returns the nom.
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param nom The nom to set.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return Returns the prenom.
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param prenom The prenom to set.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * @return Returns the telephone.
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * @param telephone The telephone to set.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
