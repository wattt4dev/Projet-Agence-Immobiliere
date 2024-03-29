package fr.adaming.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.List;

import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {
	
	// Attributs:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategorie;
	private String typeCategorie;
	private String modeCategorie;
	private String superficieCategorie;
	private int nombreDeChambresCategorie;
	@Column(name = "photo", columnDefinition="longblob")
	private byte[] photo;
	
	//Approche UML
	//one categorie to many bienImmobiliers
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categorie")
	private List<BienImmobilier> listeBienImmobiliersCategorie;

	// Constructeurs:
	public Categorie() {
		super();
	}
	
	public Categorie(String typeCategorie, String modeCategorie, String superficieCategorie,
			int nombreDeChambresCategorie, byte[] photo, List<BienImmobilier> listeBienImmobiliersCategorie) {
		super();
		this.typeCategorie = typeCategorie;
		this.modeCategorie = modeCategorie;
		this.superficieCategorie = superficieCategorie;
		this.nombreDeChambresCategorie = nombreDeChambresCategorie;
		this.photo = photo;
		this.listeBienImmobiliersCategorie = listeBienImmobiliersCategorie;
	}
	
	public Categorie(int idCategorie, String typeCategorie, String modeCategorie, String superficieCategorie,
			int nombreDeChambresCategorie, byte[] photo, List<BienImmobilier> listeBienImmobiliersCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.typeCategorie = typeCategorie;
		this.modeCategorie = modeCategorie;
		this.superficieCategorie = superficieCategorie;
		this.nombreDeChambresCategorie = nombreDeChambresCategorie;
		this.photo = photo;
		this.listeBienImmobiliersCategorie = listeBienImmobiliersCategorie;
	}

	// Getters et setters:
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getTypeCategorie() {
		return typeCategorie;
	}
	public void setTypeCategorie(String typeCategorie) {
		this.typeCategorie = typeCategorie;
	}
	public String getModeCategorie() {
		return modeCategorie;
	}
	public void setModeCategorie(String modeCategorie) {
		this.modeCategorie = modeCategorie;
	}
	public String getSuperficieCategorie() {
		return superficieCategorie;
	}
	public void setSuperficieCategorie(String superficieCategorie) {
		this.superficieCategorie = superficieCategorie;
	}
	public int getNombreDeChambresCategorie() {
		return nombreDeChambresCategorie;
	}
	public void setNombreDeChambresCategorie(int nombreDeChambresCategorie) {
		this.nombreDeChambresCategorie = nombreDeChambresCategorie;
	}

	public List<BienImmobilier> getListeBienImmobiliersCategorie() {
		return listeBienImmobiliersCategorie;
	}

	public void setListeBienImmobiliersCategorie(List<BienImmobilier> listeBienImmobiliersCategorie) {
		this.listeBienImmobiliersCategorie = listeBienImmobiliersCategorie;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
}