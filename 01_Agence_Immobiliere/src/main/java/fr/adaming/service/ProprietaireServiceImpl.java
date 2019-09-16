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
	public void addProprietaire(Proprietaire p) {
		proprietaireDao.addProprietaire(p);
	}

	@Override
	public void deleteProprietaire(int idProprietaire) {
		proprietaireDao.deleteProprietaire(idProprietaire);
		
	}

	@Override
	public void updateProprietaire(Proprietaire p) {
		proprietaireDao.updateProprietaire(p);
		
	}

	@Override
	public List<Proprietaire> getAllProprietaire() {
		return proprietaireDao.getAllProprietaire();
	}

	@Override
	public Proprietaire getProprietaireById(int idProprietaire) {
		return proprietaireDao.getProprietaireById(idProprietaire);
	}

}
