
package com.mcreation.lalahmode.dao;



import com.mcreation.lalahmode.donnees.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;




@Named(value = "articleDao")
public class DaoArticle extends AbstractDao<Article, Integer> implements IDaoArticle {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DaoArticle() {

	}



	@Override
	public List<Article> listArticles ( final String strCritereRecherche) {

		 Map<String, Object> parametres = new HashMap<>();

	        parametres.put("nomActeur", String.format("%s%%", strCritereRecherche.toLowerCase()));

	        return this.executeNamedQuery(DaoArticle.CHERCHE_LISTE_ARTICLES, parametres);
	}



	@Override
	public List<Article> listArticles() {
		// TODO Auto-generated method stub
		return null;
	}



	


	

	
}