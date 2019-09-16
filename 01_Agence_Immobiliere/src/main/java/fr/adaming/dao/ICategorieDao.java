package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;

public interface ICategorieDao {
	
	public Categorie addCategorie(Categorie c);
	public void deleteCategorie(int idCategorie);
	public void updateCategorie(Categorie c);
	public List<Categorie> getAllCategorie(Agent a);
	public Categorie getCategorieById(int idCategorie, Agent a);

}
