package org.cours.web;

import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class VoitureController {
	@Autowired
	private VoitureRepo voitureRepo;

	@RequestMapping("/voitures")
	public Iterable<Voiture> getVoitures(){
		return voitureRepo.findAll();
	}
	
	@PostMapping("/voitures")
	public Voiture addVoiture(@RequestBody Voiture voiture){
		return voitureRepo.save(voiture);
	}
	
	@GetMapping("/voitures/{id}")
	public Voiture getVoiture(@PathVariable Long id){
		return voitureRepo.findById(id).orElse(null);
	}
	
	@PutMapping("/voitures/{id}")
	public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture voiture){
		voiture.setId(id);
		return voitureRepo.save(voiture);
	}
	
	@DeleteMapping("/voitures/{id}")
	public void deleteVoiture(@PathVariable Long id){
		voitureRepo.deleteById(id);
	}
}

