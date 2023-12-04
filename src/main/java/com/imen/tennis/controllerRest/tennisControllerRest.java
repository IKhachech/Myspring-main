package com.imen.tennis.controllerRest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imen.tennis.entities.WTA_Tour;
import com.imen.tennis.services.TennisServices;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class tennisControllerRest {
	@Autowired
	TennisServices tennisService;

	@GetMapping("all")
	public List<WTA_Tour> getAllWTA_Tour() {
		return tennisService.getAllWTA_Tour();
	 } 
	
	@GetMapping("/getbyid/{id}")
	public WTA_Tour getWTA_TourById(@PathVariable("id") Long id) { return tennisService.getWTA_Tour(id);
	}
	
	@PostMapping("/addprod")
	public WTA_Tour createWTA_Tour(@RequestBody WTA_Tour t) {
	return tennisService.saveWTA_Tour(t);
	}
	
	@PutMapping("/updateprod")
	public WTA_Tour updateWTA_Tour(@RequestBody WTA_Tour t) {
	return tennisService.updateWTA_Tour(t);
	}
	
	@DeleteMapping("/delprod/{id}")
	public void deleteWTA_Tour(@PathVariable("id") Long id)
	{
	tennisService.deleteWTA_TourById(id);
	}
	
	@GetMapping("/prodscat/{idStat}")
	public List<WTA_Tour> getProduitsByCatId(@PathVariable("idStat") Long idStat) {
	return tennisService.findByStatsIdStat(idStat);
	}
	
	@GetMapping("/prodsByName/{name}")
	public List<WTA_Tour> findByNomProduitContains(@PathVariable("name") String name) {
	return tennisService.findByNameTourContains(name);
	}
	
	
	
	
}
