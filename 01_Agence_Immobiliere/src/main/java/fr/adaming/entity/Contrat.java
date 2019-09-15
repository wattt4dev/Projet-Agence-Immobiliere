package fr.adaming.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Contrat {
	
	// Attributs:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContrat;
	private double prixContrat;
	private String dateTransactionContrat;
	
	//Relation UML
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="id_BienImmobilier", referencedColumnName="idBienImmobilier")
	private BienImmobilier bienImmobilier;
	
	// Constructeurs:
	public Contrat() {
		super();
	}

	public Contrat(double prixContrat, String dateTransactionContrat) {
		super();
		this.prixContrat = prixContrat;
		this.dateTransactionContrat = dateTransactionContrat;
	}
	public Contrat(int idContrat, double prixContrat, String dateTransactionContrat) {
		super();
		this.idContrat = idContrat;
		this.prixContrat = prixContrat;
		this.dateTransactionContrat = dateTransactionContrat;
	}

	// Getters et setters:
	public int getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public double getPrixContrat() {
		return prixContrat;
	}

	public void setPrixContrat(double prixContrat) {
		this.prixContrat = prixContrat;
	}

	public String getDateTransactionContrat() {
		return dateTransactionContrat;
	}

	public void setDateTransactionContrat(String dateTransactionContrat) {
		this.dateTransactionContrat = dateTransactionContrat;
	}

	
	
	

}
