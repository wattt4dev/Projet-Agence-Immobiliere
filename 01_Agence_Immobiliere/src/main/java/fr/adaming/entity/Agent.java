package fr.adaming.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agent")
public class Agent extends Personne  {

	// Attributs: 
	private String mdpAgent;
	private int idAgent;
	
	@OneToMany(mappedBy="agent", cascade = CascadeType.ALL)
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
	
	


}
