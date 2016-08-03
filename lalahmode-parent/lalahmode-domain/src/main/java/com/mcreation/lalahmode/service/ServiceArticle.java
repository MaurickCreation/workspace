package com.mcreation.lalahmode.service;

import java.math.BigDecimal;
import java.util.List;

import com.mcreation.lalahmode.dao.DaoArticle;
import com.mcreation.lalahmode.donnees.Article;


public class ServiceArticle {
	

	public ServiceArticle (){
		
	}
	
	/** Instance unique pré-initialisée */
	private static ServiceArticle INSTANCE = new ServiceArticle();
	
	public static ServiceArticle getInstance()
	{	return INSTANCE;
	}
	
	

	public void creerArticle (String codeArt, String libelle,
			BigDecimal prix, String nomImage){
		DaoArticle daoArticle = new DaoArticle();
		daoArticle.persist(o);
		(codeArt, libelle, prix, nomImage);
		
	}
	
	public List<Article> listerArticles (){
		DaoArticle daoArticle = new DaoArticle();
		return daoArticle.listArticles();
	}

}
