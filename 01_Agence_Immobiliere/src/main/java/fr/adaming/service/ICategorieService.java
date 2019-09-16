package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;

public interface ICategorieService {
	
	public Categorie addCategorie(Categorie c, Agent a);
	public void deleteCategorie(int idCategorie, Agent a);
	public void updateCategorie(Categorie c, Agent a);
	public List<Categorie> getAllCategorie(Agent a);
	public Categorie getCategorieById(int idCategorie, Agent a);

}
