package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Contrat addContrat(Contrat c, Agent a) {
		// 1. Premi�re m�thode: "persist"
		// EntityManager em =
		// Persistence.createEntityManagerFactory("01_Agence_Immobiliere").createEntityManager();
		// EntityTransaction transaction = em.getTransaction();
		// transaction.begin();
		// c.setAgent(a);
		// em.persist(c);
		// transaction.commit();
		// return c;

		// 2. Deuxi�me m�thode: requ�te JPQL
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createNativeQuery(
				"INSERT INTO Contrat (idContrat, prixContrat, dateTransactionContrat, idBienImmobilier) VALUES (?,?,?,?)");
		query.setParameter(1, c.getIdContrat());
		query.setParameter(2, c.getPrixContrat());
		query.setParameter(3, c.getDateTransactionContrat());
		query.setParameter(4, c.getBienImmobilier()); // Ici p-e rajouter un getIdBienImmobilier?
		query.executeUpdate();
		transaction.commit();
		return c;

		// A voir si les "idContrat" etc correspondent bien � ce qu'il faut mettre dans
		// la requ�te, il me semble qu'avec hibernate on parle aux entit�s mais du coup
		// JPA je sais plus, enfin quand on testera si �a marche pas �ventuellement
		// regarder
		// si c'est pas juste pcq j'ai pas appel� les bonnes colonnes
	}

	@Override
	public void deleteContrat(int idContrat, Agent a) {

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
	public void updateContrat(Contrat c, Agent a) {
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
	public List<Contrat> getAllContrat(Agent a) {
		Query query = em.createQuery("FROM Contrat c");
		List<Contrat> contrats = query.getResultList();
		return contrats;

	}

	@Override
	public Contrat getContratById(int idContrat, Agent a) {
		em.getTransaction().begin();
		String getByIdRequete = "SELECT contrat FROM Contrat contrat WHERE contrat.idContrat = :pIdContrat";
		Query getByIdJpqlReq = em.createQuery(getByIdRequete);
		getByIdJpqlReq.setParameter("pIdContrat", idContrat);
		Contrat contratById = (Contrat) getByIdJpqlReq.getSingleResult();
		return contratById;
	}

}
