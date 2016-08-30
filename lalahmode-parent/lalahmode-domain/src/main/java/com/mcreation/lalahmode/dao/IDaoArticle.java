package com.mcreation.lalahmode.dao;

import java.io.Serializable;
import java.util.List;

import com.mcreation.lalahmode.donnees.Article;

public interface IDaoArticle  extends IDao<Article, Integer>, Serializable{
	
	/** Cherche la liste des utilisateurs. */
    String CHERCHE_LISTE_ARTICLES = "DaoArticle.listArticles";
	
	List<Article> listArticles();
	
	List<Article> listArticles ( final String strCritereRecherche);

}