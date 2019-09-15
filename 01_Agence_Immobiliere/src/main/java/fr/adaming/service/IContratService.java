package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

public interface IContratService {
	
	public Contrat addContratService(Contrat c, Agent a);
	public void deleteContratService(int idContrat, Agent a);
	public void updateContratService(Contrat c, Agent a);
	public List<Contrat> getAllContratService(Agent a);
	public Contrat getContratByIdService(int idContrat, Agent a);

}
