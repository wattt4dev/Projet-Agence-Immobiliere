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

import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;
import fr.adaming.entity.Visite;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping("/visite")
public class VisiteRestController {
	
	@Autowired
	IVisiteService visiteService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll", produces="application/json")
	public List<Visite> getAllVisiteRest(){
		return visiteService.getAllVisite();
		}
	
	@RequestMapping(method=RequestMethod.POST, value="/add", produces="application/json", consumes="application/json")
	public void addVisiteRest(@RequestBody Visite v,@RequestParam("idImmobil") int idImmo,@RequestParam("type") String type) {
		
		
		visiteService.addVisite(v, type, idImmo);
	}
	
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE)
	public void deleteVisite(@PathVariable ("pId") int id) {
		visiteService.deleteVisite(id);
	}
	
	@RequestMapping(value="/getById/{pId}", method=RequestMethod.GET, produces="application/json" )
	public Visite getVisiteById(@PathVariable("pId") int id) {
		return visiteService.getVisiteById(id);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json")
	public void updateVisite(@RequestBody Visite v) {
		visiteService.updateVisite(v);
	}

}
