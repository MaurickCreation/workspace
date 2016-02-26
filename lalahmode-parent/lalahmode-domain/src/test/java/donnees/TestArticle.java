package donnees;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import donnees.Article;



public class TestArticle extends TestCase {
	 
		public void testApp() {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
		
		
			String codeArt = String.valueOf("A01");
				 String libelle = String.valueOf("Article test premier");
				 BigDecimal prix = BigDecimal.valueOf(10);
				 String nomImage = String.valueOf("Image premier");
	 
		Article aritlce = new Article( codeArt,libelle,prix,nomImage);
			//session.save(user);
			
	 
			//session.getTransaction().commit();
			session.close();
		}
	}


