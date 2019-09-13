package fr.adaming.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Client extends Personne{
	
	// Attributs:
	private boolean acquereur;
	private String adresseClient;
	
	//Approche UML
	//One Client to Many BienImmobilier
	@OneToMany (mappedBy="client", cascade = CascadeType.ALL)
	private List<BienImmobilier> listeBienImmobilierClient;
	
	// Constructeurs:
	public Client() {
		super();
	}

	public Client(String nomPersonne, String telephonePrive, boolean acquereur, String adresseClient) {
		super(nomPersonne, telephonePrive);
		this.acquereur = acquereur;
		this.adresseClient = adresseClient;
	}

	public Client(int idPersonne, String nomPersonne, String telephonePrive, boolean acquereur, String adresseClient) {
		super(idPersonne, nomPersonne, telephonePrive);
		this.acquereur = acquereur;
		this.adresseClient = adresseClient;
	}

	// Getters et setters:
	public boolean isAcquereur() {
		return acquereur;
	}

	public void setAcquereur(boolean acquereur) {
		this.acquereur = acquereur;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	
}
