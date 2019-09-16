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

	@Override
	public void updateContrat(Contrat c) {
		// Récup d'une transaction:
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();

		// String requête:
		String requeteMAJ = "UPDATE Contrat contrat SET contrat.prixContrat=:pPrixContrat , contrat.dateTransactionContrat=:pDateTransactionContrat WHERE contrat.idContrat=:pIdContrat";

		// Construction de la requête via l'EM:
		Query updateQuery = em.createQuery(requeteMAJ);

		// Passage de params:
		updateQuery.setParameter("pPrixContrat", c.getPrixContrat());
		updateQuery.setParameter("pDateTransactionContrat", c.getDateTransactionContrat());
		updateQuery.setParameter("pIdContrat", c.getIdContrat());

		// Execution de la requête:
		updateQuery.executeUpdate();

		// Validation de la tx:
		entityTransaction.commit();

		// Eventuellement rajouter dans la requête la modif du bien immobilier associé?
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
