import java.util.Objects;

public class Course {
    private String courseName;
    private String courseSemester;
    private String courseField;



    public Course(String courseName, String courseSemester, String courseField) {
        this.courseName = courseName;
        this.courseSemester = courseSemester;
        this.courseField = courseField; 
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }

    public String getCourseField() {
        return courseField;
    }

    public void setCourseField(String courseField) {
        this.courseField = courseField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseSemester, course.courseSemester) &&
                Objects.equals(courseField, course.courseField); // Include courseField in equality check
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseSemester, courseField); // Include courseField in hash code calculation
    }

    @Override
    public String toString() {
        return "Course {" +
                "courseName='" + courseName + '\'' +
                ", courseSemester='" + courseSemester + '\'' +
                ", courseField='" + courseField + '\'' + // Include courseField in toString method
                '}';
    }
}
