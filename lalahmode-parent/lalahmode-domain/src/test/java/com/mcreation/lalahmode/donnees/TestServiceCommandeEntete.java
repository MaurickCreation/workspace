package com.mcreation.lalahmode.donnees;


import com.mcreation.lalahmode.service.ServiceCommandeEntete;

import junit.framework.TestCase;

public class TestServiceCommandeEntete extends TestCase{
	
	
	public void testCreateCommandeEntete (){
		
		 String dateCommande = String.valueOf("20160316");
		 Long numClient =Long.valueOf(50) ;
		 String  dateValidation = String.valueOf("20160317");
		 String datelivraison = String.valueOf("20160318");

		 
		 ServiceCommandeEntete serviceCommandeEntete = ServiceCommandeEntete.getInstance();
		 
		 serviceCommandeEntete.creerCommandeEntete(dateCommande, numClient, dateValidation, datelivraison);
		 
	}

}
