package kodlamaIoDemo.dataAccess;

import kodlamaIoDemo.entities.Category;
import kodlamaIoDemo.entities.Course;
import kodlamaIoDemo.entities.Instructor;

public interface BasicDao {
    void addCategory(Category category);
    void addCourse(Course course);
    void addInstructor(Instructor instructor);

}
