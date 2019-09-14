package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

public class ContratDaoImpl implements IContratDao{

	@Override
	public Contrat addContrat(Contrat c, Agent a) {
		// 1. Première méthode: "persist"
//		EntityManager em = Persistence.createEntityManagerFactory("10_Agence_Immobiliere").createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		c.setAgent(a);
//		em.persist(c);
//		transaction.commit();
//		return c;
		
		// 2. Deuxième méthode: requête JPQL
//		EntityManager em = Persistence.createEntityManagerFactory("10_Agence_Immobiliere").createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		em.createNativeQuery("INSERT INTO contrat (idContrat, prixContrat, dateTransactionContrat) VALUES (?,?,?)")
//		.setParameter(1, c.getIdContrat())
//	    .setParameter(2, c.getPrixContrat())
//	    .setParameter(3, c.getDateTransactionContrat())
//	    .executeUpdate();
//		transaction.commit();
//		return c;
		
		// Pour cette méthode il faudrait INSERT le la FK de agent avec peut-être?
		return null;
	}

	@Override
	public void deleteContrat(int idContrat, Agent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContrat(Contrat c, Agent a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contrat> getAllContrat(Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contrat getContratById(int idContrat, Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

}
