package kodlamaIoDemo.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaIoDemo.dataAccess.BasicDao;
import kodlamaIoDemo.entities.Course;
import kodlamaIoDemo.logging.Logger;

public class CourseManager {
	
	private List<Logger> loggers;
	private BasicDao basicDao;
	
	
    public CourseManager(BasicDao basicDao, List<Logger> loggers) {
        this.basicDao = basicDao;
        this.loggers = loggers;
    }
    
    List<Course> courseList = new ArrayList<>();
    public void add(Course newCourse) throws Exception {

        for (Course course : courseList){
            if (course.getName().equals(newCourse.getName())){
                throw new Exception("NO REPEAT");
            }
            if (course.getPrice() < 0) {
                throw new Exception("PRICE BETWEEN 0 TO INF");
            }
        }
        
        courseList.add(newCourse);
        basicDao.addCourse(newCourse);

        for (Logger logger : loggers){
            logger.log(newCourse.getName());
        }

    }
}
