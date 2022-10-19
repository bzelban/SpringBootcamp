package kodlamaIoDemo;

import java.util.ArrayList;
import java.util.List;

import kodlamaIoDemo.business.CategoryManager;
import kodlamaIoDemo.business.CourseManager;
import kodlamaIoDemo.business.InstructorManager;
import kodlamaIoDemo.dataAccess.HibernateDao;
import kodlamaIoDemo.dataAccess.JdbcDao;
import kodlamaIoDemo.entities.Category;
import kodlamaIoDemo.entities.Course;
import kodlamaIoDemo.entities.Instructor;
import kodlamaIoDemo.logging.DatabaseLogger;
import kodlamaIoDemo.logging.Logger;
import kodlamaIoDemo.logging.MailLogger;

public class Main {

	public static void main(String[] args) {

		
		List loggers = new ArrayList<>();	
        loggers.add(new DatabaseLogger());
        loggers.add(new MailLogger());

        Category category = new Category("Development");

        Course course = new Course("Java Course",0);
        Instructor instructor = new Instructor("Engin","Demiroğ");

        CategoryManager categoryManager = new CategoryManager(new JdbcDao(), loggers);
        CourseManager courseManager = new CourseManager(new HibernateDao(), loggers);
        InstructorManager instructorManager = new InstructorManager(new JdbcDao(), loggers);

        try {
			categoryManager.add(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			courseManager.add(course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        instructorManager.add(instructor);




	}

}
