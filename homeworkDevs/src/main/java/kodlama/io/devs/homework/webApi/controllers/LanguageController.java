package kodlama.io.devs.homework.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlama.io.devs.homework.dataAccess.concretes.InMemoryLanguageRepository;
import kodlama.io.devs.homework.entities.concretes.Language;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

	
	@Autowired
	InMemoryLanguageRepository controlAction;
	
	
	@GetMapping
	public List<Language> getAllLanguages(){
		return controlAction.getAll();
	}
	
	@PostMapping("/add")
	public void addLanguage(@RequestBody String name){
		controlAction.addLanguage(name);
	}
		
	
	
	@DeleteMapping("/{id}")
	public void deleteLanguage(@PathVariable int id) {
		controlAction.deleteLanguage(id);
		
	}
	
	@PostMapping("/{id}")
	public void updateLanguage(@PathVariable int id, @RequestBody String name) {
		controlAction.updateLanguage(id, name);
	}
	
	@GetMapping("/{id}")
	public Language getLanguageId(@PathVariable int id) {
		return controlAction.getLanguageById(id);
	}
	
}
