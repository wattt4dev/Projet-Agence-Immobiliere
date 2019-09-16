package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity


public class Visite implements Serializable{

	// Attributs:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVisite;
	private String dateVisite;
	
	//Approche UML
	//One BienImmobilier ToMany Visite
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_BienImmobilier", referencedColumnName="idBienImmobilier")//côté porteur FK
	private BienImmobilier bienImmobilier;

	// Constructeurs:
	public Visite() {
		super();
	}


	public Visite(int idVisite, String dateVisite, BienImmobilier bienImmobilier) {
		super();
		this.idVisite = idVisite;
		this.dateVisite = dateVisite;
		this.bienImmobilier = bienImmobilier;
	}


	public Visite(String dateVisite, BienImmobilier bienImmobilier) {
		super();
		this.dateVisite = dateVisite;
		this.bienImmobilier = bienImmobilier;
	}


	// Getters et setters:
	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}
	
	public int getIdVisite() {
		return idVisite;
	}

	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}

	public String getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(String dateVisite) {
		this.dateVisite = dateVisite;
	}

}
