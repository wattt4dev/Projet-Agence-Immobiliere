package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.entity.Agent;
import fr.adaming.entity.Client;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientDao clientDao;

	@Override
	public Client addClient(Client c, Agent a) {
		return clientDao.addClient(c, a);
	}

	@Override
	public void deleteClient(int idClient, Agent a) {
		clientDao.deleteClient(idClient, a);
		
	}

	@Override
	public void updateClient(Client c, Agent a) {
		clientDao.updateClient(c, a);
		
	}

	@Override
	public List<Client> getAllClient(Agent a) {
		return clientDao.getAllClient(a);
	}

	@Override
	public Client getClientById(int idClient, Agent a) {
		return clientDao.getClientById(idClient, a);
	}

}
