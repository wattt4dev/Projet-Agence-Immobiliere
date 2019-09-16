package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Proprietaire;

public interface IProprietaireDao {
	
<<<<<<< HEAD
	public Proprietaire addProprietaire(Proprietaire p);
	public void deleteProprietaire(int idProprietaire);
	public void updateProprietaire(Proprietaire p);
	public List<Proprietaire> getAllProprietaire();
	public Proprietaire getProprietaireById(int idProprietaire);
=======
	public Proprietaire addProprietaire(Proprietaire p, Agent a);
	public void deleteProprietaire(int idPersonne, Agent a);
	public void updateProprietaire(Proprietaire p, Agent a);
	public List<Proprietaire> getAllProprietaire(Agent a);
	public Proprietaire getProprietaireById(int idProprietaire, Agent a);
>>>>>>> branch 'master' of https://github.com/wattt4dev/Projet-Agence-Immobiliere.git

}
