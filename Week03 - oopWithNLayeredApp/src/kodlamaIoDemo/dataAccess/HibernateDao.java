package kodlamaIoDemo.dataAccess;

import kodlamaIoDemo.entities.Category;
import kodlamaIoDemo.entities.Course;
import kodlamaIoDemo.entities.Instructor;

public class HibernateDao implements BasicDao {

    @Override
    public void addCategory(Category category) {
        System.out.println(("Added with Hibernate = " + "category name = " + category.getCategoryName()));
    }

    @Override
    public void addCourse(Course course) {
        System.out.println("Added with Hibernate = " + "course name = " + course.getName() + "\n" +
                                                       "course price = " + course.getPrice());
    }

    @Override
    public void addInstructor(Instructor instructor) {
        System.out.println("Added with Hibernate = " + "instructor name = " + instructor.getName());
    }
}
