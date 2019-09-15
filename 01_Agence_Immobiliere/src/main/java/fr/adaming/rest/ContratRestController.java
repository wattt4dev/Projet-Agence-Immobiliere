package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;
import fr.adaming.service.ContratServiceImpl;

@RestController
@RequestMapping("/contrat")
@CrossOrigin(origins= {"http://localhost:4200"})
public class ContratRestController {
	
	@Autowired
	private ContratServiceImpl contratService; 

	@RequestMapping(method=RequestMethod.POST, value="/add", produces="application/json", consumes="application/json")
	public Contrat addContratRest(Contrat c, Agent a) {
		return contratService.addContratService(c, a);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll", produces="application/json")
	public List<Contrat> getAllContratRest(Agent a){
		return contratService.getAllContratService(a);
	}
	
	
	
}
