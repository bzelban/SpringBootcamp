package kodlama.io.devs.homework.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.devs.homework.business.requests.CreateLanguageRequest;
import kodlama.io.devs.homework.business.abstracts.LanguagesService;
import kodlama.io.devs.homework.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.homework.business.responses.GetAllLanguageResponse;
import kodlama.io.devs.homework.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.homework.entities.concretes.Language;

@Service
public class LanguageManager implements LanguagesService{

	private LanguageRepository languageRepository;
	
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponses = new ArrayList<>();
		
		for (Language language : languages) {
			GetAllLanguageResponse response = new GetAllLanguageResponse();
			response.setId(language.getId());
			response.setName(language.getName());
			languageResponses.add(response);
		}
		
		return languageResponses;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		languageRepository.save(language);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, int id) {
		for (Language language : languageRepository.findAll()) {
			if (language.getId() == id) {
				language.setName(updateLanguageRequest.getName());
				languageRepository.save(language);
			}
		}
	}

	@Override
	public void delete(int id) {
		
		if(!languageRepository.existsById(id)) {
			return;
		}
		languageRepository.deleteById(id);
		
	}
	
	
	
	
}
