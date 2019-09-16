package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Contrat;

@Repository
public class CategorieDaoImpl implements ICategorieDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Categorie addCategorie(Categorie c) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createNativeQuery(
				"INSERT INTO Categorie (idCategorie, typeCategorie, modeCategorie, superficieCategorie, nombreDeChambresCategorie) VALUES (?,?,?,?,?,?)");
		query.setParameter(1, c.getIdCategorie());
		query.setParameter(2, c.getTypeCategorie());
		query.setParameter(3, c.getModeCategorie());
		query.setParameter(4, c.getSuperficieCategorie()); 
		query.setParameter(5, c.getNombreDeChambresCategorie());
		query.executeUpdate();
		transaction.commit();
		return c;
	
	}

	@Override
	public void deleteCategorie(int idCategorie) {
		// Récup d'une transaction:
		em.getTransaction().begin();

		// String requête:
		String requeteDelete = "DELETE FROM Categorie categorie WHERE categorie.idCategorie=:pIdCategorie";
		// Construction de la requête via l'EM:
		Query deleteQuery = em.createQuery(requeteDelete);

		// Passage de params:
		deleteQuery.setParameter("pIdCategorie", idCategorie);


		// Execution de la requête:
		deleteQuery.executeUpdate();

		// Validation de la tx:
		em.getTransaction().commit();
		
	}

	@Override
	public void updateCategorie(Categorie c) {
		// Récup d'une transaction:
				EntityTransaction entityTransaction = em.getTransaction();
				entityTransaction.begin();

				// String requête:
				String requeteMAJ = "UPDATE Categorie categorie SET categorie.typeCategorie=:pTypeCategorie , categorie.modeCategorie=:pModeCategorie , categorie.superficieCategorie=:pSuperficieCategorie , categorie.nombreDeChambresCategorie=:pNombreDeChambresCategorie WHERE categorie.idCategorie=:pIdCategorie";

				// Construction de la requête via l'EM:
				Query updateQuery = em.createQuery(requeteMAJ);

				// Passage de params:
				updateQuery.setParameter("pTypeCategorie", c.getTypeCategorie());
				updateQuery.setParameter("pModeCategorie", c.getModeCategorie());
				updateQuery.setParameter("pNombreDeChambresCategorie", c.getNombreDeChambresCategorie());
				updateQuery.setParameter("pSuperficieCategorie", c.getSuperficieCategorie());
				updateQuery.setParameter("pIdCategorie", c.getIdCategorie());

				// Execution de la requête:
				updateQuery.executeUpdate();

				// Validation de la tx:
				entityTransaction.commit();
	}

	@Override
	public List<Categorie> getAllCategorie() {
		Query query = em.createQuery("FROM Categorie c");
		List<Categorie> categories = query.getResultList();
		return categories;
	}

	@Override
	public Categorie getCategorieById(int idCategorie) {
		em.getTransaction().begin();
		String getByIdRequete = "SELECT Categorie FROM Categorie categorie WHERE categorie.idCategorie = :pIdCategorie";
		Query getByIdJpqlReq = em.createQuery(getByIdRequete);
		getByIdJpqlReq.setParameter("pIdCategorie", idCategorie);
		Categorie categorieById = (Categorie) getByIdJpqlReq.getSingleResult();
		return categorieById;
	}

}
