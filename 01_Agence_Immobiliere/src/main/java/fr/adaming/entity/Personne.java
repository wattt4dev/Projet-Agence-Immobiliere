package fr.adaming.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {

	// Attributs:
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
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
	
	

//	public List<BienImmobilier> getListeBiensImmobiliersAgent() {
//		return listeBiensImmobiliersAgent;
//	}
//
//	public void setListeBiensImmobiliersAgent(List<BienImmobilier> listeBiensImmobiliersAgent) {
//		this.listeBiensImmobiliersAgent = listeBiensImmobiliersAgent;
//	}

	public String getTelephonePrive() {
		return telephonePrive;
	}

	public void setTelephonePrive(String telephonePrive) {
		this.telephonePrive = telephonePrive;
	}

}
