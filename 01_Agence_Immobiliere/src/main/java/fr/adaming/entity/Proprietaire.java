package fr.adaming.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Proprietaire extends Personne{
	
	// Attributs:
	private String telephoneProfessionnel;
	private String adresseProprietaire;
	
	//attribut UML
	// one proprietaire to many BienImmobiliers
	@OneToMany(mappedBy="proprietaire", cascade = CascadeType.ALL)
	private List<BienImmobilier> listeBienImmobiliersProprietaire;
	
	// Constructeurs:
	public Proprietaire() {
		super();
	}

	public Proprietaire(String nomPersonne, String telephonePrive, String telephoneProfessionnel,
			String adresseProprietaire) {
		super(nomPersonne, telephonePrive);
		this.telephoneProfessionnel = telephoneProfessionnel;
		this.adresseProprietaire = adresseProprietaire;
	}

	public Proprietaire(int idPersonne, String nomPersonne, String telephonePrive, String telephoneProfessionnel,
			String adresseProprietaire) {
		super(idPersonne, nomPersonne, telephonePrive);
		this.telephoneProfessionnel = telephoneProfessionnel;
		this.adresseProprietaire = adresseProprietaire;
	}

	// Getters et setters:
	public String getTelephoneProfessionnel() {
		return telephoneProfessionnel;
	}

	public void setTelephoneProfessionnel(String telephoneProfessionnel) {
		this.telephoneProfessionnel = telephoneProfessionnel;
	}

	public String getAdresseProprietaire() {
		return adresseProprietaire;
	}

	public void setAdresseProprietaire(String adresseProprietaire) {
		this.adresseProprietaire = adresseProprietaire;
	}

}
