package com.mcreation.lalahmode.service;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
<<<<<<< HEAD
import javax.transaction.Transactional;
=======


>>>>>>> branch 'master' of https://github.com/MaurickCreation/workspace.git

import com.mcreation.lalahmode.dao.IDaoArticle;
import com.mcreation.lalahmode.donnees.Article;


@Named

@Named
@Transactional
public class ServiceArticle {
	

	public ServiceArticle (){
		
	}
	
	  /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** Le DAO des acteurs. */
    @Inject
    private IDaoArticle articleDao;
	

	public void creerArticle (String codeArt, String libelle,
			BigDecimal prix, String nomImage){
		Article article = new Article();
		article.setCodeArt(codeArt);
		article.setLibelle(libelle);
		article.setPrix(prix);
		article.setNomImage(nomImage);
		articleDao.persist(article);
		
	}
	
	public List<Article> listerArticles (){

		return articleDao.listArticles();
	}

}
