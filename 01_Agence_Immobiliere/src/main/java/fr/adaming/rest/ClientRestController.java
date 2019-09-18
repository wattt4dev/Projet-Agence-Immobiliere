package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	//méthodes (à tester)
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll", produces="application/json")
	public List<Client> getAllClientRest(){
		return clientService.getAllClient();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add", produces="application/json", consumes="application/json")
	public void addClientRest(@RequestBody Client c) {
		clientService.addClient(c);
	}
	
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE)
	public void deleteClient(@PathVariable ("pId") int id) {
		clientService.deleteClient(id);
	}
	
	@RequestMapping(value="/getById/{pId}", method=RequestMethod.GET, produces="application/json" )
	public Client getClientById(@PathVariable("pId") int id) {
		return clientService.getClientById(id);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	public void updateCategorie(@RequestBody Client c) {
		clientService.updateClient(c);
	}
	
	
	
	

}
