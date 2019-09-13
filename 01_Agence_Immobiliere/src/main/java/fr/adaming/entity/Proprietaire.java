package fr.adaming.entity;

public class Proprietaire extends Personne{
	
	// Attributs:
	private String telephoneProfessionnel;
	private String adresseProprietaire;
	
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
