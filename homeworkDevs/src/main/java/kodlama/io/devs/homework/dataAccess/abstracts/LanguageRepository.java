package kodlama.io.devs.homework.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.homework.entities.concretes.Language;



public interface LanguageRepository{

	List<Language> getAll();
		
	void addLanguage(String newLanguage);
		
	void deleteLanguage(int id);
	
	void updateLanguage(int id, String name);
	
	Language getLanguageById(int id);
}



