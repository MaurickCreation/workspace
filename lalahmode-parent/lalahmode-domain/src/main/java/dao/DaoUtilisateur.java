package dao;

import org.hibernate.Session;

import donnees.Article;
import donnees.Utilisateur;

import java.math.BigDecimal;
import java.util.List;

import util.HibernateUtil;

public class DaoUtilisateur {

	public DaoUtilisateur() {

	}

	public void createAndStoreArticle(String login, String mdp,
			String nom, String prenom, String tel, String adresse) {

		Session session = HibernateUtil.getSessionFactory().openSession();

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

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    session.beginTransaction();

	    List<Utilisateur> result = session.createQuery("from Utilisateur").list();

	    session.getTransaction().commit();
	    session.close();

	    return result;
	}
	
	public List<Utilisateur>  getUtilisateurByLogin (String login){
		
		Session session = HibernateUtil.getSessionFactory().openSession();

	    session.beginTransaction();
	    List<Utilisateur> result = session.createQuery("from Utilisateur where login = '" + login +"'").list();
	    
	    session.getTransaction().commit();
	    session.close();

	    return result;

	}
	
	
}