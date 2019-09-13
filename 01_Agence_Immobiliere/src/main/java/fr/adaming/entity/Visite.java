package fr.adaming.entity;

import java.util.Date;

public class Visite {

	// Attributs:
	private int idVisite;
	private Date dateVisite;

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
