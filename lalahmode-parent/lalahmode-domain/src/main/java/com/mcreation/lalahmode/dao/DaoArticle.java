
package com.mcreation.lalahmode.dao;

import org.hibernate.Session;

import com.mcreation.lalahmode.dao.IDaoArticle;
import com.mcreation.lalahmode.donnees.Article;
import com.mcreation.lalahmode.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.inject.Named;




@Named(value = "articleDao")
public class DaoArticle implements IDaoArticle {

	public DaoArticle() {

	}

	

	public List<Article> listArticles() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    session.beginTransaction();

	    List<Article> result = session.createQuery("from Article").list();

	    session.getTransaction().commit();
	    session.close();

	    return result;
	}



	


	@Override
	public void detache(Article o) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void refresh(Article o) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void persist(Article o) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Article merge(Article o) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void remove(Article o) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Article find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Article getReference(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void lock(Article o) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Article> chercheParLibelle(String label) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Article> executeNamedQuery(String queryName, String pParamKey, Object pParamValue) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Article> executeNamedQuery(String queryName, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Article> executeNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<?> executeStoredProcedure(String queryName, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int executeNamedQueryForUpdate(String queryName, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	
}