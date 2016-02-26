package service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import dao.DaoUtilisateur;
import donnees.Utilisateur;

public class ServiceUtilisateur {

	public ServiceUtilisateur() {

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

		if (this.getUtilisateurByLogin(login).isEmpty())
			return true;
		else
			return false;

	}
	
	public boolean authentification (String login, String mdp){
		return false;
	}

}
