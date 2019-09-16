package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;

@Service
public class CategorieServiceImpl implements ICategorieService{
	
	@Autowired
	private ICategorieDao categorieDao;

	@Override
	public Categorie addCategorie(Categorie c, Agent a) {
		return categorieDao.addCategorie(c, a);
	}

	@Override
	public void deleteCategorie(int idCategorie, Agent a) {
		categorieDao.deleteCategorie(idCategorie, a);
		
	}

	@Override
	public void updateCategorie(Categorie c, Agent a) {
		categorieDao.updateCategorie(c, a);
		
	}

	@Override
	public List<Categorie> getAllCategorie(Agent a) {
		return categorieDao.getAllCategorie(a);
	}

	@Override
	public Categorie getCategorieById(int idCategorie, Agent a) {
		return categorieDao.getCategorieById(idCategorie, a);
	}

}
