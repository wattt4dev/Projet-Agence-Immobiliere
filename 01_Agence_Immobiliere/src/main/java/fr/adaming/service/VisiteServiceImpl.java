package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.entity.Visite;

@Repository
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	IVisiteDao vDao;
	
		@Override
	public void addVisite(Visite v) {
		vDao.addVisite(v);
		
	}

	@Override
	public void deleteVisite(int idVisite) {
		vDao.deleteVisite(idVisite);
	}

	@Override
	public void updateVisite(Visite v) {
		vDao.updateVisite(v);
	}

	@Override
	public List<Visite> getAllVisite() {
		
		return vDao.getAllVisite();
	}

	@Override
	public Visite getVisiteById(int idVisite) {
		
		return vDao.getVisiteById(idVisite);
	}

}
