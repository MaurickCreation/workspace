package com.mcreation.lalahmode.xml;
import java.io.*;
import java.net.URL;
import java.util.*;

import org.jdom.Element;
import org.jdom.*;
import org.jdom.output.*;
import org.jdom.input.*;
/*
 * Created on 21 mars 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * Classe permettant de faire les lectures et �critures dans les fichiers XML
 * @author Groupe de Nicolas,Maurick, Renaud et Benoit
 */
public class ServiceXML {
    
    Element racine;
    org.jdom.Document document;
    String path;
        
    /**
     * constructeur
     * @param balise nom de la balise racine de l'arbre XML
     */
    public ServiceXML (String balise) {                
        racine = new Element(balise);
        document = new Document(racine);
    }
    
    /**
     * Fonction qui retourne le chemin absolu du fichier.
     * Il se base sur l'emplacement du fichier .class et remonte de 4 crans dans l'arborescence pour aller dans le dossier web.
     * @param fichier le nom du fichier
     * @return le chemin absolu du fichier
     */
    public String ficPath(String fichier){
        path = this.getClass().getSimpleName() + ".class";
        URL url = this.getClass().getResource(path);
        File fic1 = new File(url.getPath().replace("%20"," "));
        File fic2 = fic1.getParentFile().getParentFile().getParentFile().getParentFile();
        File fic3 = new File(fic2, fichier);
        return fic3.getAbsolutePath(); 
    }
    
    /**
     * Lit le fichier XML et le charge en m�moire
     * @param fichier nom du fichier XML
     * @throws java.lang.Exception Exception en cas de probl�me
     */
    public void lireFichier(String fichier) throws Exception{
    	SAXBuilder sxb = new SAXBuilder();
    	document = sxb.build(new File(fichier));
    	racine = document.getRootElement();
    }
    
    
//On fait des modifications sur un Element
    /**
     * Supprime un �l�ment dans l'arbre
     * @param r la racine
     * @param element l'�l�ment � supprimer
     */
    public void supprElement(String r, String element) {
        //Dans un premier temps on liste tous les �tudiants
        List listElement = racine.getChildren(r);
        Iterator i = listElement.iterator();
        //On parcours la liste gr�ce � un iterator
        while(i.hasNext()) {
            Element courant = (Element)i.next();
            //Si l'etudiant poss�de l'Element en question on applique
            //les modifications.
            if(courant.getChild(element)!=null) {
                //On supprime l'Element en question
                courant.removeChild(element);
                //On renomme l'Element p�re sachant qu'une balise XML n'accepte
                //ni les espaces ni les caract�res sp�ciaux
                //"etudiant modifi�" devient "etudiant_modifie"
                courant.setName("Element_modifie");
            }
        }
    }
        
    /**
     * Ajoute un �l�ment � la racine de l'arbre
     * @param e l'�l�ment � rajouter
     */
    public void ajoutRacine(Element e){
        racine.addContent(e);
    }
    
    /**
     * Ajoute un �l�ment � un autre �l�ment
     * @param e1 l'�l�ment p�re
     * @param e2 l'�l�ment fils
     */
    public void ajout(Element e1, Element e2){
        e1.addContent(e2);
    }
  
	
    /**
     * affiche le fichier XML
     */
    public void affiche(){
	try{
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, System.out);
	}
            catch (java.io.IOException e){}
    }
    
    
    /**
     * Enregistre l'arbre XML dans le fichier XML
     * @param fichier le nom du fichier XML cible
     * @throws java.lang.Exception Exception en cas de probl�mes
     */
    public void enregistre(String fichier) throws Exception{
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            //Remarquez qu'il suffit simplement de cr�er une instance de FileOutputStream
            //avec en argument le nom du fichier pour effectuer la s�rialisation.
            sortie.output(document, new FileOutputStream(fichier));
    }
}
