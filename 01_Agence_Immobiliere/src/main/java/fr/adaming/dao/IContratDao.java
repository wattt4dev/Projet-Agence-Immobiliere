package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

public interface IContratDao {
	
	public Contrat addContrat(Contrat c, Agent a);
	public void deleteContrat(int idContrat, Agent a);
	public void updateContrat(Contrat c, Agent a);
	public List<Contrat> getAllContrat(Agent a);
	public Contrat getContratById(int idContrat, Agent a);

}
