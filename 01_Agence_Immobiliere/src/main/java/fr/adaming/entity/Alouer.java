package fr.adaming.entity;

import java.util.Date;

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
	public Alouer(String statutBienImmobilier, Date dateSoumissionBienImmobilier, String localisationBienImmobilier,
			Date dateDispoBienImmobilier, String revenuCadastralBienImmobilier, String paysBienImmobilier,
			double cautionALouer, double loyerALouer, double chargesALouer, String bailALouer,
			String garnituresALouer) {
		super(statutBienImmobilier, dateSoumissionBienImmobilier, localisationBienImmobilier, dateDispoBienImmobilier,
				revenuCadastralBienImmobilier, paysBienImmobilier);
		this.cautionALouer = cautionALouer;
		this.loyerALouer = loyerALouer;
		this.chargesALouer = chargesALouer;
		this.bailALouer = bailALouer;
		this.garnituresALouer = garnituresALouer;
	}
	public Alouer(int idBienImmobilier, String statutBienImmobilier, Date dateSoumissionBienImmobilier,
			String localisationBienImmobilier, Date dateDispoBienImmobilier, String revenuCadastralBienImmobilier,
			String paysBienImmobilier, double cautionALouer, double loyerALouer, double chargesALouer,
			String bailALouer, String garnituresALouer) {
		super(idBienImmobilier, statutBienImmobilier, dateSoumissionBienImmobilier, localisationBienImmobilier,
				dateDispoBienImmobilier, revenuCadastralBienImmobilier, paysBienImmobilier);
		this.cautionALouer = cautionALouer;
		this.loyerALouer = loyerALouer;
		this.chargesALouer = chargesALouer;
		this.bailALouer = bailALouer;
		this.garnituresALouer = garnituresALouer;
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
