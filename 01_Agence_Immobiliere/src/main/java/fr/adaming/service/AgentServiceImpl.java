package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IAgentDao;
import fr.adaming.entity.Agent;

@Service
public class AgentServiceImpl implements IAgentService{

	@Autowired
	IAgentDao aDao;
	
	@Override
	public Agent isExist(Agent a) {
		
		
		Agent agent1 =aDao.isExist(a);

		System.out.println(agent1);
		return agent1;
	}

}
