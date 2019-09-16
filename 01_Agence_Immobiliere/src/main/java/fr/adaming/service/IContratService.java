package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

public interface IContratService {
	
	public void addContratService(Contrat c);
	public void deleteContratService(int idContrat);
	public void updateContratService(Contrat c);
	public List<Contrat> getAllContratService();
	public Contrat getContratByIdService(int idContrat);

}
