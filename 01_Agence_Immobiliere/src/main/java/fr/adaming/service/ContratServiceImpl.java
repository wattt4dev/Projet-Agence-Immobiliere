package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

@Service
public class ContratServiceImpl implements IContratService{
	
	@Autowired
	IContratDao contratDao;

	@Override
	public void addContratService(Contrat c) {
		contratDao.addContrat(c);
	}

	@Override
	public void deleteContratService(int idContrat) {
		contratDao.deleteContrat(idContrat);
	}

	@Override
	public void updateContratService(Contrat c) {
		contratDao.updateContrat(c);	
	}

	@Override
	public List<Contrat> getAllContratService() {
		return contratDao.getAllContrat();
	}

	@Override
	public Contrat getContratByIdService(int idContrat) {
		return contratDao.getContratById(idContrat);
	}

}
