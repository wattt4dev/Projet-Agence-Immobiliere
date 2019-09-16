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
	public Categorie addCategorie(Categorie c) {
		return categorieDao.addCategorie(c);
	}

	@Override
	public void deleteCategorie(int idCategorie) {
		categorieDao.deleteCategorie(idCategorie);
		
	}

	@Override
	public void updateCategorie(Categorie c) {
		categorieDao.updateCategorie(c);
		
	}

	@Override
	public List<Categorie> getAllCategorie() {
		return categorieDao.getAllCategorie();
	}

	@Override
	public Categorie getCategorieById(int idCategorie) {
		return categorieDao.getCategorieById(idCategorie);
	}

}
