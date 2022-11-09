package kodlama.io.devs.homework.webApi.controllers;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlama.io.devs.homework.business.abstracts.LanguagesService;
import kodlama.io.devs.homework.business.requests.CreateLanguageRequest;
import kodlama.io.devs.homework.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.homework.business.responses.GetAllLanguageResponse;
//import kodlama.io.devs.homework.entities.concretes.Language;

@RestController
@RequestMapping("/api/language")
public class LanguageController {
	
	private LanguagesService languageService;
	
	public LanguageController(LanguagesService languageService) {
		this.languageService = languageService;
	}

	
	
	@GetMapping
	public List<GetAllLanguageResponse> getAllLanguages(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void addLanguage(@RequestBody CreateLanguageRequest createLanguageRequest){
		languageService.add(createLanguageRequest);
	}
		
	
	
	@DeleteMapping("/{id}")
	public void deleteLanguage(@PathVariable int id) {
		languageService.delete(id);
		
	}
	
	@PostMapping("/{id}")
	public void updateLanguage(@PathVariable int id, @RequestBody UpdateLanguageRequest updateLanguageRequest) {
		languageService.update(updateLanguageRequest, id);
	}
	
//	@GetMapping("/{id}")
//	public Language getLanguageId(@PathVariable int id) {
//		return controlAction.getLanguageById(id);
//	}
	
}
