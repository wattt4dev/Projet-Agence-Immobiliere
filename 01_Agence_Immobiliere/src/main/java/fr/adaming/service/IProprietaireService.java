package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Proprietaire;

public interface IProprietaireService {
	
	public void addProprietaire(Proprietaire p);
	public void deleteProprietaire(int idProprietaire);
	public void updateProprietaire(Proprietaire p);
	public List<Proprietaire> getAllProprietaire();
	public Proprietaire getProprietaireById(int idProprietaire);

}
