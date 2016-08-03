package com.mcreation.lalahmode.dao;

import java.io.Serializable;
import java.util.List;

import com.mcreation.lalahmode.donnees.Article;

public interface IDaoArticle  extends IDao<Article, Integer>, Serializable{
	
	List<Article> listArticles();

}