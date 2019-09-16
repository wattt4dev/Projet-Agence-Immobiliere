package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Proprietaire;

public interface IProprietaireService {
	
	public Proprietaire addProprietaire(Proprietaire p, Agent a);
	public void deleteProprietaire(int idProprietaire, Agent a);
	public void updateProprietaire(Proprietaire p, Agent a);
	public List<Proprietaire> getAllProprietaire(Agent a);
	public Proprietaire getProprietaireById(int idProprietaire, Agent a);

}
