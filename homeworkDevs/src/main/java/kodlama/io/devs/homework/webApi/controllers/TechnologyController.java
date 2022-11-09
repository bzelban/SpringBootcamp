package kodlama.io.devs.homework.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.homework.business.abstracts.TechnologyService;
import kodlama.io.devs.homework.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.homework.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.homework.business.responses.GetAllTechnologyResponse;


@RestController
@RequestMapping("/api/tech")
public class TechnologyController {
	
	private TechnologyService technologyService;

	
	
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	
	@GetMapping("/getall")
	List<GetAllTechnologyResponse> getall() throws NullPointerException{
		
		return technologyService.getAll();
		
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateTechnologyRequest createTechnologyRequest) {
		
		technologyService.add(createTechnologyRequest);
		
	}
	
	@PostMapping("/{id}")
	public void update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest, @PathVariable int id) {
		technologyService.update(updateTechnologyRequest, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		technologyService.delete(id);
	}
}
