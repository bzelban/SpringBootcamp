package kodlama.io.devs.homework.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.homework.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.homework.entities.concretes.*;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;
	
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language> ();
		languages.add(new Language(1, "Yarak"));
		languages.add(new Language(2, "Kürek"));
		languages.add(new Language(3, "Yürek"));
		
	}

	
	@Override
	public List<Language> getAll() {

		return languages;
	}

	
	@Override
	public void addLanguage(String newLanguage) {
		
		int lastId = languages.get(languages.size() -1).getId() + 1;
		boolean checkIfSame = false;
		for (int i = 0; i < languages.size(); i++) {
			if(languages.get(i).getName().equalsIgnoreCase(newLanguage)) {
				checkIfSame = true;
			}
		}
		if(checkIfSame) {
			System.out.println("AYNI KAYIT TEKRAR OLUSTURULAMAZ");
			return;
		}
		languages.add(new Language(lastId, newLanguage));
		
		
	}

	@Override
	public void deleteLanguage(int id) {
		
		id = id -1;

		if(id > languages.size()) {
			throw new IllegalArgumentException("BOYLE BIR KAYIT YOKTUR");
		}
		else {
			languages.remove(id);
		}
		
	}

	
	@Override
	public void updateLanguage(int id, String name) {

		if(id - 1 > languages.size()) {
			throw new IllegalArgumentException("BOYLE BIR KAYIT YOKTUR");
		} else {
			languages.get(id).setName(name);
		}
		
	}
	
	@Override
	public Language getLanguageById(int id) {
		
		
		if (id-1 >languages.size()) {
			throw new IllegalArgumentException("BOYLE BIR KAYIT YOKTUR");
			
		}
		else {
			return languages.get(id -1);
		}
	}
}
