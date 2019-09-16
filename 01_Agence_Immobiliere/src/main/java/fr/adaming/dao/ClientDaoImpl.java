package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Client;
import fr.adaming.entity.Contrat;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Client addClient(Client c, Agent a) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createNativeQuery(
				"INSERT INTO Client (idClient, acquereur, adresseClient, nomPersonne, telephonePrive ) VALUES (?,?,?,?,?)");
		query.setParameter(1, c.getIdClient());
		query.setParameter(2, c.isAcquereur());
		query.setParameter(3, c.getAdresseClient());
		query.setParameter(4, c.getNomPersonne());
		query.setParameter(5, c.getTelephonePrive());
		query.executeUpdate();
		transaction.commit();
		return c;
	}

	@Override
	public void deleteClient(int idClient, Agent a) {
		
	em.getTransaction().begin();

	String requeteDelete = "DELETE FROM Client client WHERE client.idClient=:pIdClient";

	// Construction de la requête via l'EM:
	Query deleteQuery = em.createQuery(requeteDelete);

	// Passage de params:
	deleteQuery.setParameter("pIdClient", idClient);

	// Execution de la requête:
	deleteQuery.executeUpdate();

	// Validation de la tx:
	em.getTransaction().commit();
			}
		
	

	@Override
	public void updateClient(Client c, Agent a) {
		// Récup d'une transaction:
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();

		// String requête:
		String requeteMAJ = "UPDATE Client client SET client.acquereur=:pAcquereur , client.adresseClient=:pAdresseClient, client.nomPersonne=:pNomPersonne, client.telephonePrive=:pTelephonePrive WHERE client.idClient=:pIdClient";

		// Construction de la requête via l'EM:
		Query updateQuery = em.createQuery(requeteMAJ);

	   // Passage de params:
	   updateQuery.setParameter("pAcquereur", c.isAcquereur());
	   updateQuery.setParameter("pAdresseClient", c.getAdresseClient());
	   updateQuery.setParameter("pNomPersonne", c.getNomPersonne());
	   updateQuery.setParameter("pTelephonePrive", c.getTelephonePrive());
	   updateQuery.setParameter("pIdClient", c.getIdClient());

		// Execution de la requête:
		updateQuery.executeUpdate();

	    // Validation de la tx:
	    entityTransaction.commit();
		
	}

	@Override
	public List<Client> getAllClient(Agent a) {
		Query query = em.createQuery("FROM Client c");
		List<Client> clients = query.getResultList();
		return clients;
		
	}

	@Override
	public Client getClientById(int idClient, Agent a) {
		em.getTransaction().begin();
		String getByIdRequete = "SELECT client FROM Client client WHERE client.idClient = :pIdClient";
		Query getByIdJpqlReq = em.createQuery(getByIdRequete);
		getByIdJpqlReq.setParameter("pIdClient", idClient);
		Client clientById = (Client) getByIdJpqlReq.getSingleResult();
		return clientById;
	}

}
