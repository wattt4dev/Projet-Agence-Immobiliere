package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Client;

public interface IClientDao {
	
	public Client addClient(Client c, Agent a);
	public void deleteClient(int idPersonne, Agent a);
	public void updateClient(Client c, Agent a);
	public List<Client> getAllClient(Agent a);
	public Client getClientById(int idPersonne, Agent a);

}
