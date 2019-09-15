package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins= {"http://localhost:4200"})
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	//méthodes (à tester)
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllClient", produces="application/json")
	public List<Client> getAllClientRest(Agent a){
		return clientService.getAllClient(a);
	}
	
	
	
	

}
