package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.entity.Agent;
import fr.adaming.entity.Proprietaire;

@Service
public class ProprietaireServiceImpl implements IProprietaireService {

	@Autowired
	private IProprietaireDao proprietaireDao;
	
	@Override
	public Proprietaire addProprietaire(Proprietaire p, Agent a) {
		return proprietaireDao.addProprietaire(p, a);
	}

	@Override
	public void deleteProprietaire(int idProprietaire, Agent a) {
		proprietaireDao.deleteProprietaire(idProprietaire, a);
		
	}

	@Override
	public void updateProprietaire(Proprietaire p, Agent a) {
		proprietaireDao.updateProprietaire(p, a);
		
	}

	@Override
	public List<Proprietaire> getAllProprietaire(Agent a) {
		return proprietaireDao.getAllProprietaire(a);
	}

	@Override
	public Proprietaire getProprietaireById(int idProprietaire, Agent a) {
		return proprietaireDao.getProprietaireById(idProprietaire, a);
	}

}
