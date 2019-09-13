package fr.adaming.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class BienImmobilier {
	
	// Attributs:
	private int idBienImmobilier;
	private String statutBienImmobilier;
	private Date dateSoumissionBienImmobilier;
	private String localisationBienImmobilier;
	private Date dateDispoBienImmobilier;
	private String revenuCadastralBienImmobilier;
	private String paysBienImmobilier;
	
	//Approche UML
	//One BienImmobilier ToMany Visite
	@OneToMany(mappedBy="bienImmobilier", cascade = CascadeType.ALL)
	private List<Visite> listeVisites;
	
	// Constructeurs:
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(String statutBienImmobilier, Date dateSoumissionBienImmobilier,
			String localisationBienImmobilier, Date dateDispoBienImmobilier, String revenuCadastralBienImmobilier,
			String paysBienImmobilier) {
		super();
		this.statutBienImmobilier = statutBienImmobilier;
		this.dateSoumissionBienImmobilier = dateSoumissionBienImmobilier;
		this.localisationBienImmobilier = localisationBienImmobilier;
		this.dateDispoBienImmobilier = dateDispoBienImmobilier;
		this.revenuCadastralBienImmobilier = revenuCadastralBienImmobilier;
		this.paysBienImmobilier = paysBienImmobilier;
	}

	public BienImmobilier(int idBienImmobilier, String statutBienImmobilier, Date dateSoumissionBienImmobilier,
			String localisationBienImmobilier, Date dateDispoBienImmobilier, String revenuCadastralBienImmobilier,
			String paysBienImmobilier) {
		super();
		this.idBienImmobilier = idBienImmobilier;
		this.statutBienImmobilier = statutBienImmobilier;
		this.dateSoumissionBienImmobilier = dateSoumissionBienImmobilier;
		this.localisationBienImmobilier = localisationBienImmobilier;
		this.dateDispoBienImmobilier = dateDispoBienImmobilier;
		this.revenuCadastralBienImmobilier = revenuCadastralBienImmobilier;
		this.paysBienImmobilier = paysBienImmobilier;
	}

	// Getters et setters:
	public int getIdBienImmobilier() {
		return idBienImmobilier;
	}

	public void setIdBienImmobilier(int idBienImmobilier) {
		this.idBienImmobilier = idBienImmobilier;
	}

	public String getStatutBienImmobilier() {
		return statutBienImmobilier;
	}

	public void setStatutBienImmobilier(String statutBienImmobilier) {
		this.statutBienImmobilier = statutBienImmobilier;
	}

	public Date getDateSoumissionBienImmobilier() {
		return dateSoumissionBienImmobilier;
	}

	public void setDateSoumissionBienImmobilier(Date dateSoumissionBienImmobilier) {
		this.dateSoumissionBienImmobilier = dateSoumissionBienImmobilier;
	}

	public String getLocalisationBienImmobilier() {
		return localisationBienImmobilier;
	}

	public void setLocalisationBienImmobilier(String localisationBienImmobilier) {
		this.localisationBienImmobilier = localisationBienImmobilier;
	}

	public Date getDateDispoBienImmobilier() {
		return dateDispoBienImmobilier;
	}

	public void setDateDispoBienImmobilier(Date dateDispoBienImmobilier) {
		this.dateDispoBienImmobilier = dateDispoBienImmobilier;
	}

	public String getRevenuCadastralBienImmobilier() {
		return revenuCadastralBienImmobilier;
	}

	public void setRevenuCadastralBienImmobilier(String revenuCadastralBienImmobilier) {
		this.revenuCadastralBienImmobilier = revenuCadastralBienImmobilier;
	}

	public String getPaysBienImmobilier() {
		return paysBienImmobilier;
	}

	public void setPaysBienImmobilier(String paysBienImmobilier) {
		this.paysBienImmobilier = paysBienImmobilier;
	}
	
	

}
