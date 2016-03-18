package donnees;

import java.math.BigDecimal;
import java.util.List;

import service.ServiceUtilisateur;
import junit.framework.TestCase;

public class TestServiceUtilisateur extends TestCase{
	
	
	public void testCreateUtilisateur (){
		
		
		 
		 ServiceUtilisateur serviceUtilisateur = ServiceUtilisateur.getInstance();
		 
		 String login = String.valueOf("logintest");
		 String mdp = String.valueOf("mdptest");
		 String nom = String.valueOf("RAMILI");
		 String prenom = String.valueOf("Momo");
		 String tel = String.valueOf("0544615");
		 String adresse = String.valueOf("dfqtfsergd");
		 
		 serviceUtilisateur.creerUtilisateur(login, mdp, nom, prenom, tel, adresse);
		 
	}
	
	public void testgetUtilisateurByLogin(){
		ServiceUtilisateur serviceUtilisateur = ServiceUtilisateur.getInstance();
		
		String login = String.valueOf("logintest");
		 
		List<Utilisateur> resultatTest = serviceUtilisateur.getUtilisateurByLogin(login);
	
	}
	
	public void testIsLoginDIspoTrue(){
		
		
		 
		 ServiceUtilisateur serviceUtilisateur = ServiceUtilisateur.getInstance();

		 
		 String login = String.valueOf("logintest");
		 
		 boolean resultatTest = serviceUtilisateur.isLoginDispo(login);
		 
		 System.out.println("normalement c false : " +resultatTest );
		 
	}
	
	public void testIsLoginDIspoFalse(){
		
		
		 
		 ServiceUtilisateur serviceUtilisateur = ServiceUtilisateur.getInstance();
		 
		 String login = String.valueOf("loginNotexist");
		 
		 boolean resultatTest = serviceUtilisateur.isLoginDispo(login);
		 
		 System.out.println("normalement c true : " +resultatTest );
		 
	}
	
	

}
