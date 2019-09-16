package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAAcheterDao;
import fr.adaming.entity.Aacheter;

@Service
@Transactional
public class AAcheterServiceImpl implements IAAcheterService{
	
	@Autowired
	IAAcheterDao aAcheterDao;

	@Override
	public void addAacheter(Aacheter achat) {
		aAcheterDao.addAacheter(achat);
		
	}

	@Override
	public void deleteAacheter(int idBienImmobilier) {
		aAcheterDao.deleteAacheter(idBienImmobilier);
		
	}

	@Override
	public void updateAacheter(Aacheter achat) {
		aAcheterDao.updateAacheter(achat);
		
	}

	@Override
	public List<Aacheter> getAllAacheter() {
		return aAcheterDao.getAllAacheter();
	}

	@Override
	public Aacheter getAacheterById(int idBienImmobilier) {
		return aAcheterDao.getAacheterById(idBienImmobilier);
	}
	
	
	

}
