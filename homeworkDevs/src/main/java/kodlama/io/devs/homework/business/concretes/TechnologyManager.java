package kodlama.io.devs.homework.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.devs.homework.business.abstracts.TechnologyService;
import kodlama.io.devs.homework.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.homework.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.homework.business.responses.GetAllTechnologyResponse;
import kodlama.io.devs.homework.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.homework.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.homework.entities.concretes.Language;
import kodlama.io.devs.homework.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	
	private LanguageRepository languageRepository;
	private TechnologyRepository technologyRepository;
	
	public TechnologyManager(LanguageRepository languageRepository, TechnologyRepository technologdyRepository) {
		
		this.languageRepository = languageRepository;
		this.technologyRepository = technologyRepository;
		
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponses = new ArrayList<>();
		
		for(Technology technology : technologies) {
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			response.setId(technology.getId());
			response.setName(technology.getName());
			technologyResponses.add(response);
		}
		return technologyResponses;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		Language language = languageRepository.findById(createTechnologyRequest.getId()).get();
		technology.setName(createTechnologyRequest.getName());
		technology.setLanguage(language);
		technologyRepository.save(technology);
		
		
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest, int id) {
		Language language = languageRepository.findById(updateTechnologyRequest.getId()).get();
		for (Technology technology : technologyRepository.findAll()) {
			if (technology.getId() == id) {
				technology.setName(updateTechnologyRequest.getName());
				technology.setLanguage(language);
				technologyRepository.save(technology);
			}
		}
		
	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);		
	}

}
