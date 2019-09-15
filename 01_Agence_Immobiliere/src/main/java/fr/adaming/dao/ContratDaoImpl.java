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
		// 1. Première méthode: "persist"
		// EntityManager em =
		// Persistence.createEntityManagerFactory("01_Agence_Immobiliere").createEntityManager();
		// EntityTransaction transaction = em.getTransaction();
		// transaction.begin();
		// c.setAgent(a);
		// em.persist(c);
		// transaction.commit();
		// return c;

		// 2. Deuxième méthode: requête JPQL
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

		// A voir si les "idContrat" etc correspondent bien à ce qu'il faut mettre dans
		// la requête, il me semble qu'avec hibernate on parle aux entités mais du coup
		// JPA je sais plus, enfin quand on testera si ça marche pas éventuellement
		// regarder
		// si c'est pas juste pcq j'ai pas appelé les bonnes colonnes
	}

	@Override
	public void deleteContrat(int idContrat, Agent a) {

		// Récup d'une transaction:
		em.getTransaction().begin();

		// String requête:
		String requeteDelete = "DELETE FROM Contrat contrat WHERE contrat.idContrat=:pIdContrat"; // and
																									// contrat.idAgent=???
																									// je ne sais pas
																									// comment faire là

		// Construction de la requête via l'EM:
		Query deleteQuery = em.createQuery(requeteDelete);

		// Passage de params:
		deleteQuery.setParameter("pIdContrat", idContrat);

		// Execution de la requête:
		deleteQuery.executeUpdate();

		// Validation de la tx:
		em.getTransaction().commit();
	}

	@Override
	public void updateContrat(Contrat c, Agent a) {
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
