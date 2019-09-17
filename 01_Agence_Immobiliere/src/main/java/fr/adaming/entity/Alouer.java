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

	public Alouer(String statutBienImmobilier, String dateSoumissionBienImmobilier, String localisationBienImmobilier,
			String dateDispoBienImmobilier, String revenuCadastralBienImmobilier, String paysBienImmobilier, byte[] photo,
			List<Visite> listeVisites, Agent agent, Categorie categorie, Client client, Proprietaire proprietaire,
			Contrat contrat, double cautionALouer, double loyerALouer, double chargesALouer, String bailALouer,
			String garnituresALouer) {
		super(statutBienImmobilier, dateSoumissionBienImmobilier, localisationBienImmobilier, dateDispoBienImmobilier,
				revenuCadastralBienImmobilier, paysBienImmobilier, photo, listeVisites, agent, categorie, client,
				proprietaire, contrat);
		this.cautionALouer = cautionALouer;
		this.loyerALouer = loyerALouer;
		this.chargesALouer = chargesALouer;
		this.bailALouer = bailALouer;
		this.garnituresALouer = garnituresALouer;
	}
	
	public Alouer(int idBienImmobilier, String statutBienImmobilier, String dateSoumissionBienImmobilier,
			String localisationBienImmobilier, String dateDispoBienImmobilier, String revenuCadastralBienImmobilier,
			String paysBienImmobilier, byte[] photo, List<Visite> listeVisites, Agent agent, Categorie categorie,
			Client client, Proprietaire proprietaire, Contrat contrat, double cautionALouer, double loyerALouer,
			double chargesALouer, String bailALouer, String garnituresALouer) {
		super(idBienImmobilier, statutBienImmobilier, dateSoumissionBienImmobilier, localisationBienImmobilier,
				dateDispoBienImmobilier, revenuCadastralBienImmobilier, paysBienImmobilier, photo, listeVisites, agent,
				categorie, client, proprietaire, contrat);
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
