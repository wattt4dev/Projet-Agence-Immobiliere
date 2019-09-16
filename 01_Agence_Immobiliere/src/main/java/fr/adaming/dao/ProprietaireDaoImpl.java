package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void addProprietaire(Proprietaire p) {
		em.persist(p);
	}

	@Transactional
	@Override
	public void deleteProprietaire(int idProprietaire) {

		Query deleteQuery = em
				.createQuery("DELETE FROM Proprietaire proprietaire WHERE proprietaire.idPersonne=:pIdProprietaire");
		deleteQuery.setParameter("pIdProprietaire", idProprietaire);
		deleteQuery.executeUpdate();
	}

	@Transactional
	@Override
	public void updateProprietaire(Proprietaire p) {
		// Récup d'une transaction:
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();

		// String requête:
		String requeteMAJ = "UPDATE Proprietaire proprietaire SET proprietaire.telephoneProfessionnel=:pTelephoneProfessionnel , proprietaire.adresseProprietaire=:pAdresseProprietaire , proprietaire.nomPersonne=:pNomPersonne , proprietaire.telephonePrive=:pTelephonePrive WHERE proprietaire.idPersonne=:pIdProprietaire";

		// Construction de la requête via l'EM:
		Query updateQuery = em.createQuery(requeteMAJ);

		// Passage de params:
		updateQuery.setParameter("pTelephoneProfessionnel", p.getTelephoneProfessionnel());
		updateQuery.setParameter("pAdresseProprietaire", p.getAdresseProprietaire());
		updateQuery.setParameter("pNomPersonne", p.getNomPersonne());
		updateQuery.setParameter("pTelephonePrive", p.getTelephonePrive());

		// Execution de la requête:
		updateQuery.executeUpdate();

		// Validation de la tx:
		entityTransaction.commit();

	}

	@Transactional
	@Override
	public List<Proprietaire> getAllProprietaire() {
		Query query = em.createQuery("FROM Proprietaire p");
		List<Proprietaire> proprietaires = query.getResultList();
		return proprietaires;
	}

	@Transactional
	@Override
	public Proprietaire getProprietaireById(int idProprietaire) {
		em.getTransaction().begin();
		String getByIdRequete = "SELECT Proprietaire FROM Proprietaire proprietaire WHERE proprietaire.idPersonne=:pIdProprietaire";
		Query getByIdJpqlReq = em.createQuery(getByIdRequete);
		getByIdJpqlReq.setParameter("pIdProprietaire", idProprietaire);
		Proprietaire proprietaireById = (Proprietaire) getByIdJpqlReq.getSingleResult();
		return proprietaireById;
	}

}
