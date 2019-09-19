package fr.adaming.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="aLouer")
public class Alouer extends BienImmobilier{
	
	// Attributs:
	private double cautionALouer;
	private double loyerALouer;
	private double chargesALouer;
	private String bailALouer;
	private String garnituresALouer;
	
	// Constructeurs:
	public Alouer() {
		super();
	}


	// Getters et setters:
	public double getCautionALouer() {
		return cautionALouer;
	}
	public void setCautionALouer(double cautionALouer) {
		this.cautionALouer = cautionALouer;
	}
	public double getLoyerALouer() {
		return loyerALouer;
	}
	public void setLoyerALouer(double loyerALouer) {
		this.loyerALouer = loyerALouer;
	}
	public double getChargesALouer() {
		return chargesALouer;
	}
	public void setChargesALouer(double chargesALouer) {
		this.chargesALouer = chargesALouer;
	}
	public String getBailALouer() {
		return bailALouer;
	}
	public void setBailALouer(String bailALouer) {
		this.bailALouer = bailALouer;
	}
	public String getGarnituresALouer() {
		return garnituresALouer;
	}
	public void setGarnituresALouer(String garnituresALouer) {
		this.garnituresALouer = garnituresALouer;
	}
	
}
