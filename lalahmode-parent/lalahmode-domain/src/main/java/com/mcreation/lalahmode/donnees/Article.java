package com.mcreation.lalahmode.donnees;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
 

@Entity
@Table(name = "TA_ARTICLE")
@XmlRootElement
public class Article implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_article")
    @SequenceGenerator(name = "sequence_article", sequenceName = "SEQ_TA_ARTICLE", allocationSize=1)
	@Basic(optional = false)
	@Column(name = "ID_ARTICLE", nullable = false)
	private Long idArticle;
	
	 @Basic(optional = false)
	    @Column(name = "CODE_ART", nullable = false)
	private String codeArt;
	 
	 @Basic(optional = true)
	    @Column(name = "LIBELLE", nullable = true)
	private String libelle; 
	 
	 @Basic(optional = true)
	    @Column(name = "PRIX", nullable = true)
	private BigDecimal prix;
	 
	 @Basic(optional = true)
	    @Column(name = "NOM_IMAGE", nullable = true)
	private String nomImage;
	
	public Article() {
	};
	
	
	public Article(Long idArticle) {
		
		this.idArticle = idArticle;
	};
	
	public Article( String codeArt, String libelle,
			BigDecimal prix, String nomImage) {
		super();
		this.codeArt = codeArt;

		this.libelle = libelle;
		this.prix = prix;
		this.nomImage = nomImage;
	}
	
	public Article( Long idArticle, String codeArt, String libelle,
			BigDecimal prix, String nomImage) {
		super();
		this.idArticle = idArticle;
		this.codeArt = codeArt;

		this.libelle = libelle;
		this.prix = prix;
		this.nomImage = nomImage;
	}
	public Long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}
	public String getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(String codeArt) {
		this.codeArt = codeArt;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public String getNomImage() {
		return nomImage;
	}
	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}
	
	
	
	

}
