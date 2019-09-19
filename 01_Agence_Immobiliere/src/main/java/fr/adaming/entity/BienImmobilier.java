package fr.adaming.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public class BienImmobilier implements Serializable {

	// Attributs:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBienImmobilier;
	private String statutBienImmobilier;
	
	private String dateSoumissionBienImmobilier;
	
	private String localisationBienImmobilier;
	

	private String dateDispoBienImmobilier;
	
	private String revenuCadastralBienImmobilier;
	private String paysBienImmobilier;
	
	@Column(name = "photo", columnDefinition = "longblob")
	private byte[] photo;
	
	private String numeroFactureBienImmobilier;
	
	
	private String dateFactureBienImmobilier;
	
	private String numeroAffaireBienImmobilier;
	private String typeDeBienImmobilier;

	// Approche UML

	// One BienImmobilier ToMany Visite
	@OneToMany(mappedBy = "bienImmobilier", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Visite> listeVisites;

	// ManyBienImmobilier to One Agent
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_agent", referencedColumnName = "idAgent") // côté porteur FK
	private Agent agent;

	// ManyBienImmobilier to One Categorie
	@ManyToOne
	@JoinColumn(name = "id_categorie", referencedColumnName = "idCategorie") // côté porteur FK
	private Categorie categorie;

	// ManyBienImmobilier to One Client
	@ManyToOne
	@JoinColumn(name = "id_client", referencedColumnName = "idPersonne") // côté porteur FK
	private Client client;

	// ManyBienImmobilier to One Proprietaire
	@ManyToOne
	@JoinColumn(name = "id_proprietaire", referencedColumnName = "idPersonne") // côté porteur FK
	private Proprietaire proprietaire;

	// OneBienImmobilier To One Contrat
	@OneToOne(mappedBy = "bienImmobilier", cascade = CascadeType.ALL)
	private Contrat contrat;

	// Constructeurs:
	public BienImmobilier() {
		super();
	}

	public BienImmobilier(String statutBienImmobilier, String dateSoumissionBienImmobilier,
			String localisationBienImmobilier, String dateDispoBienImmobilier, String revenuCadastralBienImmobilier,
			String paysBienImmobilier, byte[] photo, String numeroFactureBienImmobilier,
			String dateFactureBienImmobilier, String numeroAffaireBienImmobilier, String typeDeBienImmobilier,
			List<Visite> listeVisites, Agent agent, Categorie categorie, Client client, Proprietaire proprietaire,
			Contrat contrat) {
		super();
		this.statutBienImmobilier = statutBienImmobilier;
		this.dateSoumissionBienImmobilier = dateSoumissionBienImmobilier;
		this.localisationBienImmobilier = localisationBienImmobilier;
		this.dateDispoBienImmobilier = dateDispoBienImmobilier;
		this.revenuCadastralBienImmobilier = revenuCadastralBienImmobilier;
		this.paysBienImmobilier = paysBienImmobilier;
		this.photo = photo;
		this.numeroFactureBienImmobilier = numeroFactureBienImmobilier;
		this.dateFactureBienImmobilier = dateFactureBienImmobilier;
		this.numeroAffaireBienImmobilier = numeroAffaireBienImmobilier;
		this.typeDeBienImmobilier = typeDeBienImmobilier;
		this.listeVisites = listeVisites;
		this.agent = agent;
		this.categorie = categorie;
		this.client = client;
		this.proprietaire = proprietaire;
		this.contrat = contrat;
	}

	public BienImmobilier(int idBienImmobilier, String statutBienImmobilier, String dateSoumissionBienImmobilier,
			String localisationBienImmobilier, String dateDispoBienImmobilier, String revenuCadastralBienImmobilier,
			String paysBienImmobilier, byte[] photo, String numeroFactureBienImmobilier,
			String dateFactureBienImmobilier, String numeroAffaireBienImmobilier, String typeDeBienImmobilier,
			List<Visite> listeVisites, Agent agent, Categorie categorie, Client client, Proprietaire proprietaire,
			Contrat contrat) {
		super();
		this.idBienImmobilier = idBienImmobilier;
		this.statutBienImmobilier = statutBienImmobilier;
		this.dateSoumissionBienImmobilier = dateSoumissionBienImmobilier;
		this.localisationBienImmobilier = localisationBienImmobilier;
		this.dateDispoBienImmobilier = dateDispoBienImmobilier;
		this.revenuCadastralBienImmobilier = revenuCadastralBienImmobilier;
		this.paysBienImmobilier = paysBienImmobilier;
		this.photo = photo;
		this.numeroFactureBienImmobilier = numeroFactureBienImmobilier;
		this.dateFactureBienImmobilier = dateFactureBienImmobilier;
		this.numeroAffaireBienImmobilier = numeroAffaireBienImmobilier;
		this.typeDeBienImmobilier = typeDeBienImmobilier;
		this.listeVisites = listeVisites;
		this.agent = agent;
		this.categorie = categorie;
		this.client = client;
		this.proprietaire = proprietaire;
		this.contrat = contrat;
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

	public String getDateSoumissionBienImmobilier() {
		return dateSoumissionBienImmobilier;
	}

	public void setDateSoumissionBienImmobilier(String dateSoumissionBienImmobilier) {
		this.dateSoumissionBienImmobilier = dateSoumissionBienImmobilier;
	}

	public String getLocalisationBienImmobilier() {
		return localisationBienImmobilier;
	}

	public void setLocalisationBienImmobilier(String localisationBienImmobilier) {
		this.localisationBienImmobilier = localisationBienImmobilier;
	}

	public String getDateDispoBienImmobilier() {
		return dateDispoBienImmobilier;
	}

	public void setDateDispoBienImmobilier(String dateDispoBienImmobilier) {
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getNumeroFactureBienImmobilier() {
		return numeroFactureBienImmobilier;
	}

	public void setNumeroFactureBienImmobilier(String numeroFactureBienImmobilier) {
		this.numeroFactureBienImmobilier = numeroFactureBienImmobilier;
	}

	public String getDateFactureBienImmobilier() {
		return dateFactureBienImmobilier;
	}

	public void setDateFactureBienImmobilier(String dateFactureBienImmobilier) {
		this.dateFactureBienImmobilier = dateFactureBienImmobilier;
	}

	public String getNumeroAffaireBienImmobilier() {
		return numeroAffaireBienImmobilier;
	}

	public void setNumeroAffaireBienImmobilier(String numeroAffaireBienImmobilier) {
		this.numeroAffaireBienImmobilier = numeroAffaireBienImmobilier;
	}

	public String getTypeDeBienImmobilier() {
		return typeDeBienImmobilier;
	}

	public void setTypeDeBienImmobilier(String typeDeBienImmobilier) {
		this.typeDeBienImmobilier = typeDeBienImmobilier;
	}

	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

}