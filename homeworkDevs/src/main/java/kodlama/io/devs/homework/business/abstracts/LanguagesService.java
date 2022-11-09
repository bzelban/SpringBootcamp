package kodlama.io.devs.homework.business.abstracts;

import java.util.List;

import kodlama.io.devs.homework.business.requests.CreateLanguageRequest;
import kodlama.io.devs.homework.business.requests.UpdateLanguageRequest;
import kodlama.io.devs.homework.business.responses.GetAllLanguageResponse;


public interface LanguagesService {
	
	List<GetAllLanguageResponse> getAll();
	
	void add(CreateLanguageRequest createLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest, int id);
	void delete(int id);

}
