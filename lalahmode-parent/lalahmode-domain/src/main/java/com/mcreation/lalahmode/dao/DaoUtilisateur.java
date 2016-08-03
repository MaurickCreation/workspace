package com.mcreation.lalahmode.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mcreation.lalahmode.donnees.Utilisateur;

import java.util.List;


@Repository
public class DaoUtilisateur {
	
	  private SessionFactory sessionFactory;

	public DaoUtilisateur() {

	}
	


	    @Autowired
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	public void createAndStoreArticle(String login, String mdp,
			String nom, String prenom, String tel, String adresse) {

		Session session = this.sessionFactory.openSession();

		session.beginTransaction();

		Utilisateur newUtilisateur = new Utilisateur();
		newUtilisateur.setLogin(login);

		newUtilisateur.setMdp(mdp);
		newUtilisateur.setNom(nom);
		newUtilisateur.setPrenom(prenom);
		newUtilisateur.setTel(tel);
		newUtilisateur.setAdresse(adresse);

		session.save(newUtilisateur);

		session.getTransaction().commit();
		session.close();

	}
	public List<Utilisateur> listUtilisateurs() {

	    Session session = this.sessionFactory.openSession();

	    session.beginTransaction();

	    List<Utilisateur> result = session.createQuery("from Utilisateur").list();

	    session.getTransaction().commit();
	    session.close();

	    return result;
	}
	
	public List<Utilisateur>  getUtilisateurByLogin (String login){
		
		Session session = this.sessionFactory.openSession();

	    session.beginTransaction();
	    List<Utilisateur> result = session.createQuery("from Utilisateur where login = '" + login +"'").list();
	    
	    session.getTransaction().commit();
	    session.close();

	    return result;

	}
	
	
}