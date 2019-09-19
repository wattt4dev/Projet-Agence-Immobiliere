package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Override
	public void updateVisite(Visite v) {
		Query updateQuery = em.createQuery("UPDATE Visite v SET v.dateVisite = :pDateVisite , v.bienImmobilier = :pBienImmobilier   WHERE v.idVisite= :pIdVisite");
		// Passage des params
		updateQuery.setParameter("pDateVisite", v.getDateVisite());
		updateQuery.setParameter("pBienImmobilier", v.getBienImmobilier());
		updateQuery.setParameter("pIdVisite", v.getIdVisite() );
		updateQuery.executeUpdate();
	}

	@Override
	public List<Visite> getAllVisite() {
		Query query = em.createQuery("FROM Visite v ");
		List<Visite> visites = query.getResultList();
		return visites;
		
	}

	@Transactional
	@Override
	public Visite getVisiteById(int idVisite) {
		Query query = em.createQuery("SELECT v FROM Visite v WHERE v.idVisite= :pId");
		query.setParameter("pId", idVisite);
		Visite visite = (Visite) query.getSingleResult();	
		return visite;
	}

}
