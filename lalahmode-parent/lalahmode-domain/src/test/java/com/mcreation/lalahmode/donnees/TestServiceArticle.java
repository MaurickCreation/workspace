package com.mcreation.lalahmode.donnees;

import java.math.BigDecimal;

import org.junit.Test;

import com.mcreation.lalahmode.service.ServiceArticle;

import junit.framework.TestCase;

public class TestServiceArticle extends TestCase{
	
	
	@Test
	public void testCreateArticle (){
		
		String codeArt = String.valueOf("A02");
		 String libelle = String.valueOf("Article test Service");
		 BigDecimal prix = BigDecimal.valueOf(20);
		 String nomImage = String.valueOf("IXXXXXX");
		 
		 ServiceArticle serviceArticle = new ServiceArticle();
		 
		 serviceArticle.creerArticle(codeArt, libelle, prix, nomImage);
		 
		 assertEquals("", "");
		 
	}

}
