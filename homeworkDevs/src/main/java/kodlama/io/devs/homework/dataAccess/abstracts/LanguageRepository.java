package kodlama.io.devs.homework.dataAccess.abstracts;

import kodlama.io.devs.homework.entities.concretes.Language;

import org.springframework.data.jpa.repository.JpaRepository;



public interface LanguageRepository extends JpaRepository<Language, Integer>{
}



