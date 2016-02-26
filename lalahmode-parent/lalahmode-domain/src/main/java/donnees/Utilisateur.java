package donnees;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TA_UTILISATEUR")
@XmlRootElement
public class Utilisateur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 93341634279973093L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_utilisateur")
    @SequenceGenerator(name = "sequence_utilisateur", sequenceName = "seq_ta_utilisateur", allocationSize=1)
	@Basic(optional = false)
	@Column(name = "ID_UTIL", nullable = false)
	private Long idUtilisateur;
	
	 @Basic(optional = false)
	    @Column(name = "LOGIN", nullable = false)
	private String login;
	 
	 @Basic(optional = false)
	    @Column(name = "MDP", nullable = false)
	private String mdp;
	 
	 @Basic(optional = false)
	    @Column(name = "NOM", nullable = false)
	private String nom;
	 
	 @Basic(optional = true)
	    @Column(name = "PRENOM", nullable = true)
		private String prenom;
	 
	 @Basic(optional = true)
	    @Column(name = "TEL", nullable = true)
	 private String tel;
	
	 @Basic(optional = true)
	    @Column(name = "ADRESSE", nullable = true)
	 private String adresse;
	 
	 public Utilisateur( String login, String mdp,
				String nom, String prenom, String tel, String adresse) {
			super();
	
			this.login = login;
			this.mdp = mdp;
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
			this.adresse = adresse;
		}
	 

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(Long idUtilisateur, String login, String mdp,
			String nom, String prenom, String tel, String adresse) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

}
