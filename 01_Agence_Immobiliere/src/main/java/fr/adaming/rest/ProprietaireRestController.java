package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
@RequestMapping("/proprietaire")
public class ProprietaireRestController {

	@Autowired
	private IProprietaireService proprietaireService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Proprietaire> getAllProprietaireRest() {
		return proprietaireService.getAllProprietaire();
	}

	@RequestMapping(value = "/getById/{pIdProprietaire}", method = RequestMethod.GET, produces = "application/json")
	public Proprietaire recupProprietaireRest(@PathVariable("pIdProprietaire") int idProprietaire) {
		return proprietaireService.getProprietaireById(idProprietaire);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void addProprietaireRest(@RequestBody Proprietaire proprietaireIn) {
		proprietaireService.addProprietaire(proprietaireIn);
	}

	@RequestMapping(value = "/delete/{pIdProprietaire}", method = RequestMethod.DELETE)
	public void deleteProprietaireRest(@PathVariable("pIdProprietaire") int idProprietaire) {
		proprietaireService.deleteProprietaire(idProprietaire);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public void updateProprietaireRest(@RequestBody Proprietaire proprietaireIn) {
		proprietaireService.updateProprietaire(proprietaireIn);
	}

}
