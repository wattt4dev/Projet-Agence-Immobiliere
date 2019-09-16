package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Client;

public interface IClientService {
	
	public void addClient(Client c);
	public void deleteClient(int idPersonne);
	public void updateClient(Client c);
	public List<Client> getAllClient();
	public Client getClientById(int idPersonne);

}
