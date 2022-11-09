package kodlama.io.devs.homework.business.abstracts;

import java.util.List;

import kodlama.io.devs.homework.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.homework.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.homework.business.responses.GetAllTechnologyResponse;

public interface TechnologyService {


	List<GetAllTechnologyResponse> getAll();
	
	void add(CreateTechnologyRequest createTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest, int id);
	void delete(int id);
	
}
