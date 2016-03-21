package service;

import java.math.BigDecimal;
import java.util.List;

import dao.DaoCommandeEntete;
import donnees.CommandeEntete;

public class ServiceCommandeEntete {

	public ServiceCommandeEntete (){
		
	}
	
	/** Instance unique pré-initialisée */
	private static ServiceCommandeEntete INSTANCE = new ServiceCommandeEntete();
	
	public static ServiceCommandeEntete getInstance()
	{	return INSTANCE;
	}
	
	

	public void creerCommandeEntete (String dateCommande, Long numClient,
			String dateValidation, String datelivraison){
		DaoCommandeEntete daoCommandeEntete = new DaoCommandeEntete();
		daoCommandeEntete.createAndStoreCommandeEntete(dateCommande, numClient, dateValidation, datelivraison);
		
	}
	
	public List<CommandeEntete> listerCommandes (){
		DaoCommandeEntete daoCommandeEntete = new DaoCommandeEntete();
		return daoCommandeEntete.listCommandeEntetes();
	}

}
