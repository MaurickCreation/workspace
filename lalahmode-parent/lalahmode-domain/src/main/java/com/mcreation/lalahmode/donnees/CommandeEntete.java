package com.mcreation.lalahmode.donnees;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
 

	
	@Entity
	@Table(name = "TA_ENTETE_COMMANDE")
	@XmlRootElement
	public class CommandeEntete implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_numcommande")
	    @SequenceGenerator(name = "sequence_numcommande", sequenceName = "SEQ_TA_ENTETE_COMMANDE", allocationSize=1)
		@Basic(optional = false)
		@Column(name = "NUM_COMMANDE", nullable = false)
		private Long numCommande;
		
		 @Basic(optional = false)
		    @Column(name = "DATE_COMMANDE", nullable = false)
		private String dateCommande;
	
		 /**
		 * @param numCommande
		 * @param dateCommande
		 * @param numClient
		 * @param dateValidation
		 * @param datelivraison
		 */
		public CommandeEntete(Long numCommande, String dateCommande, Long numClient, String dateValidation,
				String datelivraison) {
			super();
			this.numCommande = numCommande;
			this.dateCommande = dateCommande;
			this.numClient = numClient;
			this.dateValidation = dateValidation;
			this.datelivraison = datelivraison;
		}
		
		public CommandeEntete( String dateCommande, Long numClient, String dateValidation,
				String datelivraison) {
			super();
			this.dateCommande = dateCommande;
			this.numClient = numClient;
			this.dateValidation = dateValidation;
			this.datelivraison = datelivraison;
		}
		
		public CommandeEntete(Long numCommande) {

			this.numCommande = numCommande;
		}
		
		public CommandeEntete() {
		}

		@Basic(optional = false)
		    @Column(name = "NUM_CLIENT", nullable = false)
		private Long numClient;
		 
		 @Basic(optional = true)
		    @Column(name = "DATE_VALIDATION", nullable = false)
		private String dateValidation ;
		 
		 @Basic(optional = true)
		    @Column(name = "DATE_LIVRAISON", nullable = false)
		private String datelivraison ;

		public Long getNumCommande() {
			return numCommande;
		}

		public void setNumCommande(Long numCommande) {
			this.numCommande = numCommande;
		}

		public String getDateCommande() {
			return dateCommande;
		}

		public void setDateCommande(String dateCommande) {
			this.dateCommande = dateCommande;
		}

		public Long getNumClient() {
			return numClient;
		}

		public void setNumClient(Long numClient) {
			this.numClient = numClient;
		}

		public String getDateValidation() {
			return dateValidation;
		}

		public void setDateValidation(String dateValidation) {
			this.dateValidation = dateValidation;
		}

		public String getDatelivraison() {
			return datelivraison;
		}

		public void setDatelivraison(String datelivraison) {
			this.datelivraison = datelivraison;
		}
		 
		 

}
