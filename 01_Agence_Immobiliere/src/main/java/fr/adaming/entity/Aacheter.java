package fr.adaming.entity;

import java.util.Date;

public class Aacheter extends BienImmobilier {

	// Attributs:
	private double prixDemandeAAcheter;
	private String etatAAcheter;

	// Constructeurs:
	public Aacheter() {
		super();
	}

	public Aacheter(String statutBienImmobilier, Date dateSoumissionBienImmobilier, String localisationBienImmobilier,
			Date dateDispoBienImmobilier, String revenuCadastralBienImmobilier, String paysBienImmobilier,
			double prixDemandeAAcheter, String etatAAcheter) {
		super(statutBienImmobilier, dateSoumissionBienImmobilier, localisationBienImmobilier, dateDispoBienImmobilier,
				revenuCadastralBienImmobilier, paysBienImmobilier);
		this.prixDemandeAAcheter = prixDemandeAAcheter;
		this.etatAAcheter = etatAAcheter;
	}

	public Aacheter(int idBienImmobilier, String statutBienImmobilier, Date dateSoumissionBienImmobilier,
			String localisationBienImmobilier, Date dateDispoBienImmobilier, String revenuCadastralBienImmobilier,
			String paysBienImmobilier, double prixDemandeAAcheter, String etatAAcheter) {
		super(idBienImmobilier, statutBienImmobilier, dateSoumissionBienImmobilier, localisationBienImmobilier,
				dateDispoBienImmobilier, revenuCadastralBienImmobilier, paysBienImmobilier);
		this.prixDemandeAAcheter = prixDemandeAAcheter;
		this.etatAAcheter = etatAAcheter;
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
