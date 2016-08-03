package com.mcreation.lalahmode.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import com.mcreation.lalahmode.dao.DaoUtilisateur;
import com.mcreation.lalahmode.donnees.Utilisateur;
import com.mcreation.lalahmode.util.HibernateUtil;

import antlr.StringUtils;

public class ServiceUtilisateur {

	private ServiceUtilisateur() {

	}
	
	/** Instance unique pré-initialisée */
	private static ServiceUtilisateur INSTANCE = new ServiceUtilisateur();
	
	public static ServiceUtilisateur getInstance()
	{	return INSTANCE;
	}

	public void creerUtilisateur(String login, String mdp, String nom,
			String prenom, String tel, String adresse) {
		DaoUtilisateur daoUtilisateur = new DaoUtilisateur();
		daoUtilisateur.createAndStoreArticle(login, mdp, nom, prenom, tel,
				adresse);

	}

	public List<Utilisateur> listerUtilisateurs() {
		DaoUtilisateur daoUtilisateur = new DaoUtilisateur();
		return daoUtilisateur.listUtilisateurs();
	}

	public List<Utilisateur> getUtilisateurByLogin(String login) {

		DaoUtilisateur daoUtilisateur = new DaoUtilisateur();
		return daoUtilisateur.getUtilisateurByLogin(login);

	}

	public boolean isLoginDispo(String login) {

		if (this.getUtilisateurByLogin(login).isEmpty()){
		
			return true;
		}
		else {
		
			return false;
		}
		

	}
	
	public boolean authentification (String login, String mdp){
		
		boolean authentifie  =false;
		List<Utilisateur> test = this.getUtilisateurByLogin(login);
		for (Utilisateur userTest : test){
			if ( !login.isEmpty() && !mdp.isEmpty()) {
				
				if (login.equals(userTest.getLogin()) && mdp.equals(userTest.getMdp() ))
						{
					
					
					 System.out.println("Je suis dans le true");
					authentifie = true;
					break;
						}
				
				
			}
				
		}

		 System.out.println("valeur de authentifie" + authentifie);
		return authentifie;
	}

}
