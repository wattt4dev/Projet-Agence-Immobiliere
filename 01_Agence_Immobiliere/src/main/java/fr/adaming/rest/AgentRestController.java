package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Agent;
import fr.adaming.service.IAgentService;

@RestController
@RequestMapping("/agent")
public class AgentRestController {

	@Autowired
	IAgentService agentService;

	@RequestMapping(method = RequestMethod.POST, value = "/isExist", produces = "application/json", consumes = "application/json")
	public Agent isExistRest(@RequestBody Agent a) {
		System.out.println("------------       " + a.getIdAgent() + "     " + a.getMdpAgent());

		Agent agent1 = agentService.isExist(a);

		System.out.println("----- rest   :   "+agent1);
		return agent1;
	}
}
