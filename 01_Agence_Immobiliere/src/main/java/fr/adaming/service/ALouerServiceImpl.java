package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAlouerDao;
import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;

@Service
@Transactional
public class ALouerServiceImpl implements IALouerService {

	@Autowired
	IAlouerDao aLouerDao;
	
	
	@Override
	public void addAlouerService(Alouer aLouer) {
		aLouerDao.addAlouer(aLouer);
	}

	@Override
	public void deleteAlouerService(int idBienImmobilier) {
		aLouerDao.deleteAlouer(idBienImmobilier);
	}

	@Override
	public void updateAlouerService(Alouer al) {
		aLouerDao.updateAlouer(al);
	}

	@Override
	public List<Alouer> getAllAlouerService() {
		return aLouerDao.getAllAlouer();
	}

	@Override
	public Alouer getAlouerByIdService(int idBienImmobilier) {
		return aLouerDao.getAlouerById(idBienImmobilier);
	}

	@Override
	public List<Alouer> getAlouerByDepartement(String departement) {
		return aLouerDao.getAlouerByDepartement(departement);
	}

	

}
