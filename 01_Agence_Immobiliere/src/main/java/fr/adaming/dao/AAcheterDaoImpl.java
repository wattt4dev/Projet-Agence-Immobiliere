package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;

@Repository
public class AAcheterDaoImpl implements IAAcheterDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addAacheter(Aacheter achat) {
		em.persist(achat);
	}

	@Override
	public void deleteAacheter(int idBienImmobilier) {
		Query deleteQuery = em.createQuery("DELETE FROM Aacheter achat WHERE achat.idBienImmobilier= :pIdBienImmobilier");
		deleteQuery.setParameter("pIdBienImmobilier", idBienImmobilier);
		deleteQuery.executeUpdate();
	}

	@Override
	public void updateAacheter(Aacheter achat) {
		Query updateQuery = em.createQuery("UPDATE Aacheter achat SET achat.statutBienImmobilier = :pStatutBienImmobilier , achat.dateSoumissionBienImmobilier = :pDateSoumissionBienImmobilier , achat.localisationBienImmobilier = :pLocalisationBienImmobilier , achat.dateDispoBienImmobilier = :pDateDispoBienImmobilier , achat.revenuCadastralBienImmobilier = :pRevenuCadastralBienImmobilier , achat.paysBienImmobilier = :pPaysBienImmobilier , achat.prixDemandeAAcheter = :pPrixDemandeAAcheter , achat.etatAAcheter = :pEtatAAcheter  WHERE achat.idBienImmobilier= :pIdBienImmobilier");
		// Passage des params
		updateQuery.setParameter("pStatutBienImmobilier", achat.getStatutBienImmobilier());
		updateQuery.setParameter("pDateSoumissionBienImmobilier", achat.getDateSoumissionBienImmobilier());
		updateQuery.setParameter("pLocalisationBienImmobilier", achat.getLocalisationBienImmobilier());
		updateQuery.setParameter("pDateDispoBienImmobilier", achat.getDateDispoBienImmobilier());
		updateQuery.setParameter("pRevenuCadastralBienImmobilier", achat.getRevenuCadastralBienImmobilier());
		updateQuery.setParameter("pPaysBienImmobilier", achat.getPaysBienImmobilier());
		updateQuery.setParameter("pIdBienImmobilier", achat.getIdBienImmobilier());
		updateQuery.setParameter("pPrixDemandeAAcheter", achat.getPrixDemandeAAcheter());
		updateQuery.setParameter("pEtatAAcheter", achat.getEtatAAcheter());
		updateQuery.executeUpdate();
		
	}

	@Override
	public List<Aacheter> getAllAacheter() {
		Query query = em.createQuery("FROM Aacheter achat");
		List<Aacheter> aAcheter = query.getResultList();
		return aAcheter;
	}

	@Override
	public Aacheter getAacheterById(int idBienImmobilier) {
		Query query = em.createQuery("FROM Aacheter achat WHERE achat.idBienImmobilier = :pIdBienImmobilier");
		query.setParameter("pIdBienImmobilier", idBienImmobilier);
		Aacheter achat = (Aacheter) query.getSingleResult();
		return achat;
	}

}