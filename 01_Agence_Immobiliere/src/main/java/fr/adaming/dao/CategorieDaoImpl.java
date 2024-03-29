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
import fr.adaming.entity.Contrat;
import fr.adaming.entity.Visite;

@Repository
public class CategorieDaoImpl implements ICategorieDao{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public void addCategorie(Categorie c) {
	em.persist(c);
	
	}

	@Transactional
	@Override
	public void deleteCategorie(int idCategorie) {
		Query deleteQuery = em.createQuery("DELETE FROM Categorie c WHERE c.idCategorie= :pIdCategorie");
		deleteQuery.setParameter("pIdCategorie", idCategorie);
		deleteQuery.executeUpdate();
	}

	@Transactional
	@Override
	public void updateCategorie(Categorie c) {

		Query updateQuery = em.createQuery("UPDATE Categorie c SET c.typeCategorie = :pTypeCategorie , c.modeCategorie = :pModeCategorie , c.superficieCategorie = :pSuperficieCategorie, c.nombreDeChambresCategorie = :pNombreDeChambresCategorie WHERE c.idCategorie= :pIdCategorie");
		// Passage des params
		updateQuery.setParameter("pTypeCategorie", c.getTypeCategorie());
		updateQuery.setParameter("pModeCategorie", c.getModeCategorie());
		updateQuery.setParameter("pSuperficieCategorie", c.getSuperficieCategorie());
		updateQuery.setParameter("pNombreDeChambresCategorie", c.getNombreDeChambresCategorie());
		updateQuery.setParameter("pIdCategorie", c.getIdCategorie());
		updateQuery.executeUpdate();
	}

	@Override
	public List<Categorie> getAllCategorie() {
		Query query = em.createQuery("FROM Categorie c");
		List<Categorie> categories = query.getResultList();
		return categories;
	}

	@Override
	public Categorie getCategorieById(int idCategorie) {
		Query query = em.createQuery("FROM Categorie c WHERE c.idCategorie= :pIdCategorie");
		query.setParameter("pIdCategorie", idCategorie);
		Categorie categorie = (Categorie) query.getSingleResult();
		return categorie;
	}

}
