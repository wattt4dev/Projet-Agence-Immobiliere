package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Client;

public interface IClientService {
	
	public Client addClient(Client c, Agent a);
	public void deleteClient(int idClient, Agent a);
	public void updateClient(Client c, Agent a);
	public List<Client> getAllClient(Agent a);
	public Client getClientById(int idClient, Agent a);

}
