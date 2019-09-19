package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;
import fr.adaming.service.IAAcheterService;

@RestController
@RequestMapping("/aAcheter")
public class AAcheterRestController {

	@Autowired
	IAAcheterService aAcheterService;

	@RequestMapping( value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public void addAAcheterRest(@RequestBody Aacheter aAcheter) {
		aAcheterService.addAacheter(aAcheter);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{pId}")
	public void deleteAAcheterRest(@PathVariable("pId") int idBienImmobilier) {
		aAcheterService.deleteAacheter(idBienImmobilier);
		
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/update")
	public void updateAAcheterRest(@RequestBody Aacheter aAcheter) {
		aAcheterService.updateAacheter(aAcheter);
		
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getAll")
	public List<Aacheter> getAllAAcheterRest() {
		return aAcheterService.getAllAacheter();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getById/{pId}", produces = "application/json")
	public Aacheter getByIdAAcheterRest(@PathVariable("pId") int idBienImmobilier) {
		return aAcheterService.getAacheterById(idBienImmobilier);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getRegionById/{pRegion}", produces="application/json")
	public List<Aacheter> getAAcheterByRegionRest(@PathVariable("pRegion") String region) {
		List<Aacheter> listeachat = aAcheterService.getAacheterByRegion(region);
		
		for(Aacheter elem: listeachat) {
		System.out.println("rest------------"+elem);
		}
		
		return listeachat;
	}

}
