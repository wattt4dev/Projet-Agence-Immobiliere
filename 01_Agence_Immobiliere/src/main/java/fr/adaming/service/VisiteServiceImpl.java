package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAAcheterDao;
import fr.adaming.dao.IAlouerDao;
import fr.adaming.dao.IVisiteDao;
import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;
import fr.adaming.entity.Visite;

@Service
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	IVisiteDao vDao;

	@Autowired
	IAAcheterDao aDao;

	@Autowired
	IAlouerDao lDao;

	@Override
	public void addVisite(Visite v, String type, int idImmo) {
		/*if (type.equals("achat")) {
			v.setBienImmobilier(aDao.getAacheterById(idImmo));
		} else if (type.equals("location")) {
			v.setBienImmobilier(lDao.getAlouerById(idImmo));
		}*/

		vDao.addVisite(v, type, idImmo);

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
