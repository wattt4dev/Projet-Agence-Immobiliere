package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ContratDaoImpl;
import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

@Service
public class ContratServiceImpl implements IContratService{
	
	@Autowired
	private ContratDaoImpl contratDao;

	@Override
	public Contrat addContratService(Contrat c, Agent a) {
		return contratDao.addContrat(c, a);
	}

	@Override
	public void deleteContratService(int idContrat, Agent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContratService(Contrat c, Agent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contrat> getAllContratService(Agent a) {
		return contratDao.getAllContrat(a);
	}

	@Override
	public Contrat getContratByIdService(int idContrat, Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

}
