package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;

public interface ICategorieService {
	
	public Categorie addCategorie(Categorie c);
	public void deleteCategorie(int idCategorie);
	public void updateCategorie(Categorie c);
	public List<Categorie> getAllCategorie();
	public Categorie getCategorieById(int idCategorie);

}
