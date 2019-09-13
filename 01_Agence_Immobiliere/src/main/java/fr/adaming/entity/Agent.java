package fr.adaming.entity;

public class Agent extends Personne {

	// Attributs:
	private String mdpAgent;

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

}
