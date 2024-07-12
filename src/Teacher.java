import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<Course> courses = new ArrayList<>();

    public Teacher(int teacherId, String fullName, String email, String telephoneNumber) {
        super(teacherId, fullName, email, telephoneNumber);
    }

    public void addCourse(Course course) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Course added successfully.");
            } else {
                System.out.println("Course already exists.");
            }
    }

    @Override
    public String toString() {
        return "Teacher {" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telephoneNumber='" + getTelephoneNumber() + '\'' +
                ", courses=" + courses +
                '}';
    }
}
