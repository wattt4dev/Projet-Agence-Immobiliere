package fr.adaming.entity;

public class Categorie {
	
	// Attributs:
	private int idCategorie;
	private String typeCategorie;
	private String modeCategorie;
	private String superficieCategorie;
	private int nombreDeChambresCategorie;

	// Constructeurs:
	public Categorie() {
		super();
	}
	
	public Categorie(String typeCategorie, String modeCategorie, String superficieCategorie,
			int nombreDeChambresCategorie) {
		super();
		this.typeCategorie = typeCategorie;
		this.modeCategorie = modeCategorie;
		this.superficieCategorie = superficieCategorie;
		this.nombreDeChambresCategorie = nombreDeChambresCategorie;
	}
	
	public Categorie(int idCategorie, String typeCategorie, String modeCategorie, String superficieCategorie,
			int nombreDeChambresCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.typeCategorie = typeCategorie;
		this.modeCategorie = modeCategorie;
		this.superficieCategorie = superficieCategorie;
		this.nombreDeChambresCategorie = nombreDeChambresCategorie;
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
	
}