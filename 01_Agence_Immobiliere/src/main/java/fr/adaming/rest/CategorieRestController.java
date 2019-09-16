package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.adaming.entity.Agent;
import fr.adaming.entity.Categorie;
import fr.adaming.entity.Contrat;
import fr.adaming.service.ICategorieService;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins= {"http://localhost:4200"})
public class CategorieRestController {
	
	@Autowired
	private ICategorieService categorieService;

	
	//méthodes 
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll", produces="application/json")
	public List<Categorie> getAllCategorieRest(){
		return categorieService.getAllCategorie();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add", produces="application/json", consumes="application/json")
	public Categorie addCategorieRest(Categorie c) {
		return categorieService.addCategorie(c);
	}
	
	
}
