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
	public Contrat addContratService(Contrat c) {
		return contratDao.addContrat(c);
	}

	@Override
	public void deleteContratService(int idContrat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContratService(Contrat c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contrat> getAllContratService() {
		return contratDao.getAllContrat();
	}

	@Override
	public Contrat getContratByIdService(int idContrat) {
		// TODO Auto-generated method stub
		return null;
	}

}
