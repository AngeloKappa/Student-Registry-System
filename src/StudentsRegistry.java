import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsRegistry {

    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    public StudentsRegistry() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Student Id: ");
        int id = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Full Name: ");
        String name = keyboard.nextLine();
        System.out.print("Phone number: ");
        String phone = keyboard.nextLine();
        System.out.print("E-mail: ");
        String email = keyboard.nextLine();
        System.out.print("Semester: ");
        String semester = keyboard.nextLine();
        Student newStudent = new Student(id, name, phone, email, semester);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    public void editStudent(String s) {
        Scanner keyboard = new Scanner(System.in);
        boolean found = false;
        for (Student student : students) {
            if (s.equalsIgnoreCase(student.getFullName())) {
                System.out.println(student);
                System.out.print("Enter new student ID: ");
                student.setId(keyboard.nextInt());
                keyboard.nextLine();
                System.out.print("Enter new name: ");
                student.setFullName(keyboard.nextLine());
                System.out.print("Enter new telephone number: ");
                student.setTelephoneNumber(keyboard.nextLine());
                System.out.print("Enter new e-mail: ");
                student.setEmail(keyboard.nextLine());
                System.out.print("Enter new semester: ");
                student.setSemester(keyboard.nextLine());
                found = true;
                System.out.println("Student edited successfully.");
                System.out.println(student);
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with the name " + s);
        }
    }

    public void removeStudent(String s) {
        boolean found = students.removeIf(student -> s.equalsIgnoreCase(student.getFullName()));
        if (found) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("No student found with the name " + s);
        }
    }

    public void addTeacher() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Teacher Id: ");
        int id = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Full Name: ");
        String name = keyboard.nextLine();
        System.out.print("Phone number: ");
        String phone = keyboard.nextLine();
        System.out.print("E-mail: ");
        String email = keyboard.nextLine();
        System.out.print("Field: ");
        String field = keyboard.nextLine();
        Teacher newTeacher = new Teacher(id, name, phone, email);
        teachers.add(newTeacher);
        System.out.println("Teacher added successfully.");
    }

    public void editTeacher(String s) {
        Scanner keyboard = new Scanner(System.in);
        boolean found = false;
        for (Teacher teacher : teachers) {
            if (s.equalsIgnoreCase(teacher.getFullName())) {
                System.out.println(teacher);
                System.out.print("Enter new teacher ID: ");
                teacher.setId(keyboard.nextInt());
                keyboard.nextLine();
                System.out.print("Enter new name: ");
                teacher.setFullName(keyboard.nextLine());
                System.out.print("Enter new telephone number: ");
                teacher.setTelephoneNumber(keyboard.nextLine());
                System.out.print("Enter new e-mail: ");
                teacher.setEmail(keyboard.nextLine());
                found = true;
                System.out.println("Teacher edited successfully.");
                System.out.println(teacher);
                break;
            }
        }
        if (!found) {
            System.out.println("No teacher found with the name " + s);
        }
    }

    public void removeTeacher(String s) {
        boolean found = teachers.removeIf(teacher -> s.equalsIgnoreCase(teacher.getFullName()));
        if (found) {
            System.out.println("Teacher removed successfully.");
        } else {
            System.out.println("No teacher found with the name " + s);
        }
    }

    public void addCourse() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Course Id: ");
        int id = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Course Name: ");
        String name = keyboard.nextLine();
        System.out.print("Course Semester: ");
        String semester = keyboard.nextLine();
        System.out.print("Field: ");
        String field = keyboard.nextLine();
        Course newCourse = new Course(name, semester, field);
        courses.add(newCourse);
        System.out.println("Course added successfully.");
    }

    public void editCourse(String s) {
        Scanner keyboard = new Scanner(System.in);
        boolean found = false;
        for (Course course : courses) {
            if (s.equalsIgnoreCase(course.getCourseName())) {
                System.out.println(course);
                keyboard.nextLine();
                System.out.print("Enter new name: ");
                course.setCourseName(keyboard.nextLine());
                System.out.print("Enter new course field: ");
                course.setCourseField(keyboard.nextLine());
                System.out.print("Enter new course's semester: ");
                course.setCourseSemester(keyboard.nextLine());
                found = true;
                System.out.println("Course edited successfully.");
                System.out.println(course);
                break;
            }
        }
        if (!found) {
            System.out.println("No course found with the name " + s);
        }
    }

    public void removeCourse(String s) {
        boolean found = courses.removeIf(course -> s.equalsIgnoreCase(course.getCourseName()));
        if (found) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("No course found with the name " + s);
        }
    }

    public void addCourseToTeacher() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the teacher: ");
        String teacherName = keyboard.nextLine();
        System.out.print("Enter the name of the course: ");
        String courseName = keyboard.nextLine();

        Teacher teacher = findTeacherByName(teacherName);
        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        Course course = findCourseByName(courseName);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        teacher.addCourse(course);
    }

    public void addCourseToStudent() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        String studentName = keyboard.nextLine();
        System.out.print("Enter the name of the course: ");
        String courseName = keyboard.nextLine();

        Student student = findStudentByName(studentName);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Course course = findCourseByName(courseName);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.addCourse(course);
    }

    private Teacher findTeacherByName(String name) {
        return teachers.stream()
                .filter(teacher -> name.equalsIgnoreCase(teacher.getFullName()))
                .findFirst()
                .orElse(null);
    }

    private Student findStudentByName(String name) {
        return students.stream()
                .filter(student -> name.equalsIgnoreCase(student.getFullName()))
                .findFirst()
                .orElse(null);
    }

    private Course findCourseByName(String name) {
        return courses.stream()
                .filter(course -> name.equalsIgnoreCase(course.getCourseName()))
                .findFirst()
                .orElse(null);
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void displayAllTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
        } else {
            System.out.println("Teachers:");
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        }
    }
}
