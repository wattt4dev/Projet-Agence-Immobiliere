package fr.adaming.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="aAcheter")
public class Aacheter extends BienImmobilier {

	// Attributs:
	private double prixDemandeAAcheter;
	private String etatAAcheter;

	// Constructeurs:
	public Aacheter() {
		super();
	}



	// Getters et setters:
	public double getPrixDemandeAAcheter() {
		return prixDemandeAAcheter;
	}

	public void setPrixDemandeAAcheter(double prixDemandeAAcheter) {
		this.prixDemandeAAcheter = prixDemandeAAcheter;
	}

	public String getEtatAAcheter() {
		return etatAAcheter;
	}

	public void setEtatAAcheter(String etatAAcheter) {
		this.etatAAcheter = etatAAcheter;
	}

	
}
