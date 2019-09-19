package fr.adaming.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="agent")
public class Agent extends Personne  {

	// Attributs: 
	private String mdpAgent;
	private int idAgent;
	
	@OneToMany(mappedBy="agent", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BienImmobilier> bienImmobiliers;

	
	// Constructeurs:
	public Agent() {
		super();
	}

	public Agent(String nomPersonne, String telephonePrive, String mdpAgent) {
		super(nomPersonne, telephonePrive);
		this.mdpAgent = mdpAgent;
	}
	
	public Agent(int idPersonne, String nomPersonne, String telephonePrive, String mdpAgent) {
		super(idPersonne, nomPersonne, telephonePrive);
		this.mdpAgent = mdpAgent;
	}

	// Getters et setters:
	public String getMdpAgent() {
		return mdpAgent;
	}

	public void setMdpAgent(String mdpAgent) {
		this.mdpAgent = mdpAgent;
	}

	public int getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public List<BienImmobilier> getBienImmobiliers() {
		return bienImmobiliers;
	}

	public void setBienImmobiliers(List<BienImmobilier> bienImmobiliers) {
		this.bienImmobiliers = bienImmobiliers;
	}

	@Override
	public String toString() {
		return "Agent [mdpAgent=" + mdpAgent + ", idAgent=" + idAgent+ ", getIdPersonne()=" + getIdPersonne() 
				+ ", getNomPersonne()=" + getNomPersonne()
				+ ", getTelephonePrive()=" + getTelephonePrive() + "]";
	}
	
	


}
