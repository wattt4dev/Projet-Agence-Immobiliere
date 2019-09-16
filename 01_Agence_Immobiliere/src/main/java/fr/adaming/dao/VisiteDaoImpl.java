package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public void addVisite(Visite v) {
		em.persist(v);	
	}

	@Transactional
	@Override
	public void deleteVisite(int idVisite) {
		Query deleteQuery = em.createQuery("DELETE FROM Visite v WHERE v.idVisite= :pIdvisite");
		deleteQuery.setParameter("pIdvisite", idVisite);
		deleteQuery.executeUpdate();
	}

	@Override
	public void updateVisite(Visite v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Visite> getAllVisite() {
		Query query = em.createQuery("FROM Visite v ");
		List<Visite> visites = query.getResultList();
		return visites;
		
	}

	@Override
	public Visite getVisiteById(int idVisite) {
		Query query = em.createQuery("FROM Visite v ");
		List<Visite> visites = query.getResultList();	
		return null;
	}

}
