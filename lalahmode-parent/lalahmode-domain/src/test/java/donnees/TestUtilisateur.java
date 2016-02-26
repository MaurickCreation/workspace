package donnees;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import donnees.Utilisateur;



public class TestUtilisateur extends TestCase {
	 
		public void testApp() {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			String login = String.valueOf("rickim");
			String mdp = String.valueOf("mdptest");
			String nom = String.valueOf("RAMILIJAONA");
			String prenom = String.valueOf("maurick");
			String tel = String.valueOf("0554791254");
			String adresse = String.valueOf("rue des cepages");
		
		
	 
		Utilisateur user = new Utilisateur(  login,  mdp,
				 nom,  prenom,  tel,  adresse ) ;
			//session.save(user);
			
	 
			//session.getTransaction().commit();
			session.close();
		}
	}


