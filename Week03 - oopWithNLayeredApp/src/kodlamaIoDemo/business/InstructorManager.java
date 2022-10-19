package kodlamaIoDemo.business;

import java.util.List;

import kodlamaIoDemo.dataAccess.BasicDao;
import kodlamaIoDemo.entities.Instructor;
import kodlamaIoDemo.logging.Logger;


public class InstructorManager {

	private List<Logger> loggers;
	private BasicDao basicDao;
	
	public InstructorManager(BasicDao basicDao, List<Logger> loggers) {
		this.loggers = loggers;
		this.basicDao = basicDao;
	}
	
	public void add(Instructor instructor) {
		
		basicDao.addInstructor(instructor);
		
		for(Logger logger: loggers) {
			logger.log(instructor.getName() + " " + instructor.getSurname() );
		}
	}
	
}
