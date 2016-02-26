package dao;

import org.hibernate.Session;

import donnees.Article;

import java.math.BigDecimal;
import java.util.List;

import util.HibernateUtil;

public class DaoArticle {

	public DaoArticle() {

	}

	public void createAndStoreArticle(String codeArt, String libelle,
			BigDecimal prix, String nomImage) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Article newArticle = new Article();
		newArticle.setCodeArt(codeArt);

		newArticle.setLibelle(libelle);
		newArticle.setPrix(prix);
		newArticle.setNomImage(nomImage);

		session.save(newArticle);

		session.getTransaction().commit();
		session.close();

	}
	public List<Article> listArticles() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    session.beginTransaction();

	    List<Article> result = session.createQuery("from Article").list();

	    session.getTransaction().commit();
	    session.close();

	    return result;
	}
}