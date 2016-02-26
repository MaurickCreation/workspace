package service;

import java.math.BigDecimal;
import java.util.List;

import dao.DaoArticle;
import donnees.Article;

public class ServiceArticle {

	public ServiceArticle (){
		
	}
	
	

	public void creerArticle (String codeArt, String libelle,
			BigDecimal prix, String nomImage){
		DaoArticle daoArticle = new DaoArticle();
		daoArticle.createAndStoreArticle(codeArt, libelle, prix, nomImage);
		
	}
	
	public List<Article> listerArticles (){
		DaoArticle daoArticle = new DaoArticle();
		return daoArticle.listArticles();
	}

}
