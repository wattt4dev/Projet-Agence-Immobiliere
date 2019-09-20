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
		Query updateQuery = em.createQuery("UPDATE Aacheter achat SET achat.statutBienImmobilier = :pStatutBienImmobilier , achat.dateSoumissionBienImmobilier = :pDateSoumissionBienImmobilier , achat.localisationBienImmobilier = :pLocalisationBienImmobilier , achat.dateDispoBienImmobilier = :pDateDispoBienImmobilier , achat.revenuCadastralBienImmobilier = :pRevenuCadastralBienImmobilier , achat.paysBienImmobilier = :pPaysBienImmobilier , achat.prixDemandeAAcheter = :pPrixDemandeAAcheter , achat.etatAAcheter = :pEtatAAcheter , achat.numeroFactureBienImmobilier = :pNumeroFactureBienImmobilier , achat.dateFactureBienImmobilier = :pDateFactureBienImmobilier , achat.numeroAffaireBienImmobilier = :pNumeroAffaireBienImmobilier , achat.typeDeBienImmobilier = :pTypeDeBienImmobilier WHERE achat.idBienImmobilier= :pIdBienImmobilier");
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
		updateQuery.setParameter("pNumeroFactureBienImmobilier", achat.getNumeroFactureBienImmobilier());
		updateQuery.setParameter("pDateFactureBienImmobilier", achat.getDateFactureBienImmobilier());
		updateQuery.setParameter("pNumeroAffaireBienImmobilier", achat.getNumeroAffaireBienImmobilier());
		updateQuery.setParameter("pTypeDeBienImmobilier", achat.getTypeDeBienImmobilier());
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

	@Override
	public List<Aacheter> getAacheterByDepartement(String region) {
		Query query = em.createQuery("FROM Aacheter aa WHERE aa.region = :pRegion");
		query.setParameter("pRegion", region);
		List<Aacheter> aachterRegion =query.getResultList();
		for(Aacheter elem: aachterRegion) {
		System.out.println("dao------------"+elem);
		}
		return aachterRegion;
	}

}
