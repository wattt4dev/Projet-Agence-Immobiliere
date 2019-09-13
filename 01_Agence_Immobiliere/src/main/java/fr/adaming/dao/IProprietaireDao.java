package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Proprietaire;

public interface IProprietaireDao {
	
	public Proprietaire addProprietaire(Proprietaire p, Agent a);
	public void deleteProprietaire(int idPersonne, Agent a);
	public void updateProprietaire(Proprietaire p, Agent a);
	public List<Proprietaire> getAllProprietaire(Agent a);
	public Proprietaire getProprietaireById(int idPersonne, Agent a);

}
