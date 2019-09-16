package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
	public Contrat addContrat(Contrat c) {
		em.persist(c);
		return c;
	}

	@Override
	public void deleteContrat(int idContrat) {

		// R�cup d'une transaction:
		em.getTransaction().begin();

		// String requ�te:
		String requeteDelete = "DELETE FROM Contrat contrat WHERE contrat.idContrat=:pIdContrat"; // and
																									// contrat.idAgent=???
																									// je ne sais pas
																									// comment faire l�

		// Construction de la requ�te via l'EM:
		Query deleteQuery = em.createQuery(requeteDelete);

		// Passage de params:
		deleteQuery.setParameter("pIdContrat", idContrat);

		// Execution de la requ�te:
		deleteQuery.executeUpdate();

		// Validation de la tx:
		em.getTransaction().commit();
	}

	@Override
	public void updateContrat(Contrat c) {
		// R�cup d'une transaction:
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();

		// String requ�te:
		String requeteMAJ = "UPDATE Contrat contrat SET contrat.prixContrat=:pPrixContrat , contrat.dateTransactionContrat=:pDateTransactionContrat WHERE contrat.idContrat=:pIdContrat";

		// Construction de la requ�te via l'EM:
		Query updateQuery = em.createQuery(requeteMAJ);

		// Passage de params:
		updateQuery.setParameter("pPrixContrat", c.getPrixContrat());
		updateQuery.setParameter("pDateTransactionContrat", c.getDateTransactionContrat());
		updateQuery.setParameter("pIdContrat", c.getIdContrat());

		// Execution de la requ�te:
		updateQuery.executeUpdate();

		// Validation de la tx:
		entityTransaction.commit();

		// Eventuellement rajouter dans la requ�te la modif du bien immobilier associ�?
	}

	@Override
	public List<Contrat> getAllContrat() {
		Query query = em.createQuery("FROM Contrat c");
		List<Contrat> contrats = query.getResultList();
		return contrats;

	}

	@Override
	public Contrat getContratById(int idContrat) {
		em.getTransaction().begin();
		String getByIdRequete = "SELECT contrat FROM Contrat contrat WHERE contrat.idContrat = :pIdContrat";
		Query getByIdJpqlReq = em.createQuery(getByIdRequete);
		getByIdJpqlReq.setParameter("pIdContrat", idContrat);
		Contrat contratById = (Contrat) getByIdJpqlReq.getSingleResult();
		return contratById;
	}

}
