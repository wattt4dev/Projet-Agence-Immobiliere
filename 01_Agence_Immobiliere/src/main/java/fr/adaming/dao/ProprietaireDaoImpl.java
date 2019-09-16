package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Proprietaire addProprietaire(Proprietaire p, Agent a) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createNativeQuery(
				"INSERT INTO Proprietaire (idProprietaire, telephoneProfessionnel, adresseProprietaire, nomPersonne, telephonePrive) VALUES (?,?,?,?,?)");
		query.setParameter(1, p.getIdProprietaire());
		query.setParameter(2, p.getTelephoneProfessionnel());
		query.setParameter(3, p.getAdresseProprietaire());
		query.setParameter(4, p.getNomPersonne()); 
		query.setParameter(5, p.getTelephonePrive());
		query.executeUpdate();
		transaction.commit();
		return p;
	}

	@Override
	public void deleteProprietaire(int idProprietaire, Agent a) {
		// Récup d'une transaction:
				em.getTransaction().begin();

				// String requête:
				String requeteDelete = "DELETE FROM Proprietaire proprietaire WHERE proprietaire.idProprietaire=:pIdProprietaire";
				// Construction de la requête via l'EM:
				Query deleteQuery = em.createQuery(requeteDelete);

				// Passage de params:
				deleteQuery.setParameter("pIdProprietaire", idProprietaire);

				// Execution de la requête:
				deleteQuery.executeUpdate();

				// Validation de la tx:
				em.getTransaction().commit();
		
	}

	@Override
	public void updateProprietaire(Proprietaire p, Agent a) {
			// Récup d'une transaction:
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();

		// String requête:
		String requeteMAJ = "UPDATE Proprietaire proprietaire SET proprietaire.telephoneProfessionnel=:pTelephoneProfessionnel , proprietaire.adresseProprietaire=:pAdresseProprietaire , proprietaire.nomPersonne=:pNomPersonne , proprietaire.telephonePrive=:pTelephonePrive WHERE proprietaire.idProprietaire=:pIdProprietaire";

		// Construction de la requête via l'EM:
		Query updateQuery = em.createQuery(requeteMAJ);

		// Passage de params:
		updateQuery.setParameter("pTelephoneProfessionnel",p.getTelephoneProfessionnel());
		updateQuery.setParameter("pAdresseProprietaire", p.getAdresseProprietaire());
		updateQuery.setParameter("pNomPersonne", p.getNomPersonne());
		updateQuery.setParameter("pTelephonePrive", p.getTelephonePrive());
		updateQuery.setParameter("pIdProprietaire", p.getIdProprietaire());

		// Execution de la requête:
		updateQuery.executeUpdate();

		// Validation de la tx:
		entityTransaction.commit();
		
	}

	@Override
	public List<Proprietaire> getAllProprietaire(Agent a) {
		Query query = em.createQuery("FROM Proprietaire p");
		List<Proprietaire> proprietaires = query.getResultList();
		return proprietaires;
	}

	@Override
	public Proprietaire getProprietaireById(int idProprietaire, Agent a) {
		em.getTransaction().begin();
		String getByIdRequete = "SELECT Proprietaire FROM CProprietaire proprietaire WHERE proprietaire.idProprietaire=:pIdProprietaire";
		Query getByIdJpqlReq = em.createQuery(getByIdRequete);
		getByIdJpqlReq.setParameter("pIdProprietaire", idProprietaire);
		Proprietaire proprietaireById = (Proprietaire) getByIdJpqlReq.getSingleResult();
		return proprietaireById;
	}

}
