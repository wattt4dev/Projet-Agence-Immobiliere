package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

public interface IContratDao {
	
	public void addContrat(Contrat c);
	public void deleteContrat(int idContrat);
	public void updateContrat(Contrat c);
	public List<Contrat> getAllContrat();
	public Contrat getContratById(int idContrat);

}
