package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Contrat;
import fr.adaming.service.ICategorieService;

@RestController
@RequestMapping("/categorie")
public class CategorieRestController {
	
	@Autowired
	ICategorieService categorieService;

	
	//méthodes 
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll", produces="application/json")
	public List<Categorie> getAllCategorieRest(){
		return categorieService.getAllCategorie();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add", produces="application/json", consumes="application/json")
	public void addCategorieRest(@RequestBody Categorie c) {
		categorieService.addCategorie(c);
	}
	
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE)
	public void deleteCategorie(@PathVariable ("pId") int id) {
		categorieService.deleteCategorie(id);
	}
	
	@RequestMapping(value="/getById/{pId}", method=RequestMethod.GET, produces="application/json" )
	public Categorie getCategorieById(@PathVariable("pId") int id) {
		return categorieService.getCategorieById(id);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	public void updateCategorie(@RequestBody Categorie c) {
		categorieService.updateCategorie(c);
	}

}
