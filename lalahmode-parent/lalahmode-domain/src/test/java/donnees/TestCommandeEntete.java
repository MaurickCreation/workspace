package donnees;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import junit.framework.TestCase;

public class TestCommandeEntete  extends TestCase{

		 
		public void testApp() {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
		

				 
				 String dateCommande = String.valueOf("201603116");
				 Long numClient =Long.valueOf(50) ;
				 String  dateValidation = String.valueOf("201603117");
				 String datelivraison = String.valueOf("201603118");
	 
		CommandeEntete commande  = new CommandeEntete(dateCommande, numClient, dateValidation,datelivraison );
			//session.save(user);
			
	 
			//session.getTransaction().commit();
			session.close();
		}


}
