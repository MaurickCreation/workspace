package dao;

import org.hibernate.Session;

import donnees.CommandeEntete;


import java.util.List;

import util.HibernateUtil;

public class DaoCommandeEntete {

	public DaoCommandeEntete() {

	}

	public void createAndStoreCommandeEntete(String dateCommande,Long numClient, String dateValidation, String datelivraison) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		CommandeEntete newCommandeEntete = new CommandeEntete();
		newCommandeEntete.setDateCommande(dateCommande);

		newCommandeEntete.setNumClient(numClient);
		newCommandeEntete.setDatelivraison(datelivraison);
		newCommandeEntete.setDateValidation(dateValidation);

		session.save(newCommandeEntete);

		session.getTransaction().commit();
		session.close();

	}
	public List<CommandeEntete> listArticles() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    session.beginTransaction();

	    List<CommandeEntete> result = session.createQuery("from CommandeEntete").list();

	    session.getTransaction().commit();
	    session.close();

	    return result;
	}
}