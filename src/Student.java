import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private String semester;
    private List<Course> courses = new ArrayList<>();

    public Student(int studentId, String fullName, String email, String telephoneNumber, String semester) {
        super(studentId, fullName, email, telephoneNumber);
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void addCourse(Course course) {
        if (semester.equalsIgnoreCase(course.getCourseSemester())) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Course added successfully.");
            } else {
                System.out.println("Course already exists.");
            }
        } else {
            System.out.println("Student " + getFullName() + " can't take up this course");
        }
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telephoneNumber='" + getTelephoneNumber() + '\'' +
                ", semester='" + semester + '\'' +
                ", courses=" + courses +
                '}';
    }
}
