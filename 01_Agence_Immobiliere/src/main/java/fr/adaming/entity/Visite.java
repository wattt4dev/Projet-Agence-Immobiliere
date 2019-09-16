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
	private Date dateVisite;
	
	//Approche UML
	//One BienImmobilier ToMany Visite
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_BienImmobilier", referencedColumnName="idBienImmobilier")//côté porteur FK
	private BienImmobilier bienImmobilier;

	// Constructeurs:
	public Visite() {
		super();
	}

	public Visite(Date dateVisite) {
		super();
		this.dateVisite = dateVisite;
	}

	public Visite(int idVisite, Date dateVisite) {
		super();
		this.idVisite = idVisite;
		this.dateVisite = dateVisite;
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

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

}
