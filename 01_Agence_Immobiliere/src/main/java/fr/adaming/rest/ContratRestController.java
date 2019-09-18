package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Contrat;
import fr.adaming.service.IContratService;

@RestController
@RequestMapping("/contrat")
public class ContratRestController {
	
	@Autowired
	IContratService contratService; 

	@RequestMapping(method=RequestMethod.POST, value="/add", consumes="application/json")
	public void addContratRest(@RequestBody Contrat c) {
		contratService.addContratService(c);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{pId}")
	public void deleteContratRest(@PathVariable("pId") int idContrat) {
		contratService.deleteContratService(idContrat);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/update")
	public void updateContratRest(@RequestBody Contrat contrat) {
		contratService.updateContratService(contrat);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll", produces="application/json")
	public List<Contrat> getAllContratRest(){
		return contratService.getAllContratService();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getById/{pId}", produces="application/json")
	public Contrat getByIdContratRest(@PathVariable("pId") int idContrat) {
		return contratService.getContratByIdService(idContrat);
	}
	
	
	
	
}
