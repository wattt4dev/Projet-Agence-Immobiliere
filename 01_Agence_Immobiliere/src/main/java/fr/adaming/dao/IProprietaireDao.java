package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Proprietaire;

public interface IProprietaireDao {
	
	public Proprietaire addProprietaire(Proprietaire p);
	public void deleteProprietaire(int idProprietaire);
	public void updateProprietaire(Proprietaire p);
	public List<Proprietaire> getAllProprietaire();
	public Proprietaire getProprietaireById(int idProprietaire);

}
