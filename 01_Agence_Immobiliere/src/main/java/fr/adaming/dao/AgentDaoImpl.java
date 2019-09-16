package fr.adaming.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entity.Agent;

@Repository
public class AgentDaoImpl implements IAgentDao{

	private EntityManager em = Persistence.createEntityManagerFactory("UP_01_Agence_Immobiliere").createEntityManager();

	
	@Override
	public Agent isExist(Agent a) {
		//1. Def de la requ�te JPQL => la clause SELECT pr�cise une classe entit� (et non pas une table)
				String requeteJPQL = "SELECT a FROM Agent a WHERE a.mdpAgent=:pMdpAgent and a.idAgent=:pIdAgent"; //e est l'alias cette ligne est l'�quivalent de SELECT *
				Query isExistReq = em.createQuery(requeteJPQL);
				
		//2. Passage des params
				isExistReq.setParameter("pMdpAgent", a.getMdpAgent());
				isExistReq.setParameter("pIdAgent", a.getIdPersonne());
		
		//3. execution et r�cup�ration du r�sultat
				Agent agent1= (Agent) isExistReq.getSingleResult();
				
		return agent1;
	}

}