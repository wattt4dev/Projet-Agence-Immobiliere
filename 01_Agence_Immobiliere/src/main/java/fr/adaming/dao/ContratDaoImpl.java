package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

@Repository
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
		EntityManager em = Persistence.createEntityManagerFactory("10_Agence_Immobiliere").createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createNativeQuery("INSERT INTO contrat (idContrat, prixContrat, dateTransactionContrat) VALUES (?,?,?)");
		query.setParameter(1, c.getIdContrat());
	    query.setParameter(2, c.getPrixContrat());
	    query.setParameter(3, c.getDateTransactionContrat());
	    query.executeUpdate();
		transaction.commit();
		return c;
		
		// Pour cette méthode il faudrait INSERT le la FK de agent avec peut-être?
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
