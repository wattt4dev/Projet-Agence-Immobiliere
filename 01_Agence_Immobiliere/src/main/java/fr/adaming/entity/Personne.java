package fr.adaming.entity;

public class Personne {

	// Attributs:
	private int idPersonne;
	private String nomPersonne;
	private String telephonePrive;

	// Constructeurs:
	public Personne() {
		super();
	}

	public Personne(String nomPersonne, String telephonePrive) {
		super();
		this.nomPersonne = nomPersonne;
		this.telephonePrive = telephonePrive;
	}

	public Personne(int idPersonne, String nomPersonne, String telephonePrive) {
		super();
		this.idPersonne = idPersonne;
		this.nomPersonne = nomPersonne;
		this.telephonePrive = telephonePrive;
	}

	// Getters et setters
	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getTelephonePrive() {
		return telephonePrive;
	}

	public void setTelephonePrive(String telephonePrive) {
		this.telephonePrive = telephonePrive;
	}

}
