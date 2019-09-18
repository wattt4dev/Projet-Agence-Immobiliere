package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Alouer;
import fr.adaming.entity.Contrat;

@Repository
public class ALouerDaoImpl implements IAlouerDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addAlouer(Alouer aLouer) {
		em.persist(aLouer);
	}

	@Override
	public void deleteAlouer(int idBienImmobilier) {
		Query deleteQuery = em.createQuery("DELETE FROM Alouer al WHERE al.idBienImmobilier= :pIdBienImmobilier");
		deleteQuery.setParameter("pIdBienImmobilier", idBienImmobilier);
		deleteQuery.executeUpdate();
	}

	@Override
	public void updateAlouer(Alouer al) {
		Query updateQuery = em.createQuery("UPDATE Alouer al SET al.statutBienImmobilier = :pStatutBienImmobilier , al.dateSoumissionBienImmobilier = :pDateSoumissionBienImmobilier , al.localisationBienImmobilier = :pLocalisationBienImmobilier , al.dateDispoBienImmobilier = :pDateDispoBienImmobilier , al.revenuCadastralBienImmobilier = :pRevenuCadastralBienImmobilier , al.paysBienImmobilier = :pPaysBienImmobilier , al.cautionALouer = :pCautionALouer , al.loyerALouer = :pLoyerALouer , al.chargesALouer = :pChargesALouer , al.bailALouer = :pBailALouer , al.garnituresALouer = :pGarnituresALouer , al.numeroFactureBienImmobilier = :pNumeroFactureBienImmobilier , al.dateFactureBienImmobilier = :pDateFactureBienImmobilier , al.numeroAffaireBienImmobilier = :pNumeroAffaireBienImmobilier , al.typeDeBienImmobilier = :pTypeDeBienImmobilier  WHERE al.idBienImmobilier= :pIdBienImmobilier");
		// Passage des params
		updateQuery.setParameter("pStatutBienImmobilier", al.getStatutBienImmobilier());
		updateQuery.setParameter("pDateSoumissionBienImmobilier", al.getDateSoumissionBienImmobilier());
		updateQuery.setParameter("pLocalisationBienImmobilier", al.getLocalisationBienImmobilier());
		updateQuery.setParameter("pDateDispoBienImmobilier", al.getDateDispoBienImmobilier());
		updateQuery.setParameter("pRevenuCadastralBienImmobilier", al.getRevenuCadastralBienImmobilier());
		updateQuery.setParameter("pPaysBienImmobilier", al.getPaysBienImmobilier());
		updateQuery.setParameter("pCautionALouer", al.getCautionALouer());
		updateQuery.setParameter("pLoyerALouer", al.getLoyerALouer());
		updateQuery.setParameter("pChargesALouer", al.getChargesALouer());
		updateQuery.setParameter("pBailALouer", al.getBailALouer());
		updateQuery.setParameter("pGarnituresALouer", al.getGarnituresALouer());
		updateQuery.setParameter("pIdBienImmobilier", al.getIdBienImmobilier());
		updateQuery.setParameter("pNumeroFactureBienImmobilier", al.getNumeroFactureBienImmobilier());
		updateQuery.setParameter("pDateFactureBienImmobilier", al.getDateFactureBienImmobilier());
		updateQuery.setParameter("pNumeroAffaireBienImmobilier", al.getNumeroAffaireBienImmobilier());
		updateQuery.setParameter("pTypeDeBienImmobilier", al.getTypeDeBienImmobilier());
		updateQuery.executeUpdate();
	}

	@Override
	public List<Alouer> getAllAlouer() {
		Query query = em.createQuery("FROM Alouer al");
		List<Alouer> alouers = query.getResultList();
		return alouers;
	}

	@Override
	public Alouer getAlouerById(int idBienImmobilier) {
		Query query = em.createQuery("FROM Alouer al WHERE al.idBienImmobilier = :pIdBienImmobilier");
		query.setParameter("pIdBienImmobilier", idBienImmobilier);
		Alouer aLouer = (Alouer) query.getSingleResult();
		return aLouer;
	}

//	@Override
//	public List<Alouer> getAlouerByDepartement(String departement) {
//		Query query = em.createQuery("FROM Alouer al WHERE al.idBienImmobilier = :pIdBienImmobilier");
//		query.setParameter("pIdBienImmobilier", departement);
//		Alouer aLouer = (Alouer) query.getSingleResult();
//		return aLouer;
//	}
	
	

}
