package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void addContrat(Contrat c) {
		em.persist(c);
	}

	@Transactional
	@Override
	public void deleteContrat(int idContrat) {
		Query deleteQuery = em.createQuery("DELETE FROM Contrat c WHERE c.idContrat= :pIdContrat");
		deleteQuery.setParameter("pIdContrat", idContrat);
		deleteQuery.executeUpdate();
	}

	@Transactional
	@Override
	public void updateContrat(Contrat c) {
		Query updateQuery = em.createQuery("UPDATE Contrat c SET c.prixContrat = :pPrixContrat , c.dateTransactionContrat = :pDateTransactionContrat   WHERE c.idContrat= :pIdContrat");
		// Passage des params
		updateQuery.setParameter("pPrixContrat", c.getPrixContrat());
		updateQuery.setParameter("pDateTransactionContrat", c.getDateTransactionContrat());
		updateQuery.setParameter("pIdContrat", c.getIdContrat());
		updateQuery.executeUpdate();
	}
	
	@Transactional
	@Override
	public List<Contrat> getAllContrat() {
		Query query = em.createQuery("FROM Contrat c");
		List<Contrat> contrats = query.getResultList();
		return contrats;

	}

	@Transactional
	@Override
	public Contrat getContratById(int idContrat) {
		Query query = em.createQuery("FROM Contrat c WHERE c.idContrat= :pIdContrat");
		query.setParameter("pIdContrat", idContrat);
		Contrat contrat = (Contrat) query.getSingleResult();
		return contrat;
	}

}
