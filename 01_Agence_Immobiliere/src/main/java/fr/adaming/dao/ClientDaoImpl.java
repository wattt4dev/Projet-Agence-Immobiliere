package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;

@Repository
public class ClientDaoImpl implements IClientDao{
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void addClient(Client c) {
		em.persist(c);
	}

	@Transactional
	@Override
	public void deleteClient(int idPersonne) {
		Query deleteQuery = em.createQuery("DELETE FROM Client c WHERE c.idPersonne= :pIdPersonne");
		deleteQuery.setParameter("pIdPersonne", idPersonne);
		deleteQuery.executeUpdate();
			}
			
	@Transactional
	@Override
	public void updateClient(Client c) {
	

		// String requête:
		String requeteMAJ = "UPDATE Client client SET client.acquereur=:pAcquereur , client.adresseClient=:pAdresseClient, client.nomPersonne=:pNomPersonne, client.telephonePrive=:pTelephonePrive WHERE client.idPersonne=:pIdPersonne";

		// Construction de la requête via l'EM:
		Query updateQuery = em.createQuery(requeteMAJ);

	   // Passage de params:
	   updateQuery.setParameter("pAcquereur", c.isAcquereur());
	   updateQuery.setParameter("pAdresseClient", c.getAdresseClient());
	   updateQuery.setParameter("pNomPersonne", c.getNomPersonne());
	   updateQuery.setParameter("pTelephonePrive", c.getTelephonePrive());
	   updateQuery.setParameter("pIdPersonne", c.getIdPersonne());

		// Execution de la requête:
		updateQuery.executeUpdate();

	   
		
	}

	@Override
	public List<Client> getAllClient() {
		Query query = em.createQuery("FROM Client c");
		List<Client> clients = query.getResultList();
		return clients;
		
	}

	@Override
	public Client getClientById(int idPersonne) {
		Query query = em.createQuery("FROM Client c WHERE c.idPersonne= :pIdPersonne");
		query.setParameter("pIdPersonne", idPersonne);
		Client client = (Client) query.getSingleResult();
		return client;
	}

}
