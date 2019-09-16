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
	public void addClient(Client c) {
		clientDao.addClient(c);
	}

	@Override
	public void deleteClient(int idPersonne) {
		clientDao.deleteClient(idPersonne);
		
	}

	@Override
	public void updateClient(Client c) {
		clientDao.updateClient(c);
		
	}

	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	@Override
	public Client getClientById(int idPersonne) {
		return clientDao.getClientById(idPersonne);
	}

}
