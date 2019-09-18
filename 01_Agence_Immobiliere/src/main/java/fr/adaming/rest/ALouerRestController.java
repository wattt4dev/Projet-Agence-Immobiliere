package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Alouer;
import fr.adaming.service.IALouerService;

@RestController
@RequestMapping("/aLouer")
public class ALouerRestController {
	
	@Autowired
	IALouerService aLouerService;
	
	@RequestMapping(method=RequestMethod.POST, value="/add", consumes="application/json")
	public void addALouerRest(@RequestBody Alouer aLouer) {
		aLouerService.addAlouerService(aLouer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{pId}")
	public void deleteALouerRest(@PathVariable("pId") int idBienImmobilier) {
		aLouerService.deleteAlouerService(idBienImmobilier);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json", value="/update")
	public void updateALouerRest(@RequestBody Alouer alouer) {
		aLouerService.updateAlouerService(alouer);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json", value="/getAll")
	public List<Alouer> getAllALouerRest(){
		return aLouerService.getAllAlouerService();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getById/{pId}", produces="application/json")
	public Alouer getByIdALouerRest(@PathVariable("pId") int idBienImmobilier) {
		return aLouerService.getAlouerByIdService(idBienImmobilier);
	}

}
