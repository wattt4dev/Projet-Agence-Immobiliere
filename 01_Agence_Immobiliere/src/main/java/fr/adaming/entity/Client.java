package fr.adaming.entity;

import javax.persistence.Entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Client extends Personne{
	
	// Attributs:
	private boolean acquereur;
	private String adresseClient;
	private int idClient;
	
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

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public List<BienImmobilier> getListeBienImmobilierClient() {
		return listeBienImmobilierClient;
	}

	public void setListeBienImmobilierClient(List<BienImmobilier> listeBienImmobilierClient) {
		this.listeBienImmobilierClient = listeBienImmobilierClient;
	}

	
}
