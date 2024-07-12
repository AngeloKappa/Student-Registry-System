import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentsRegistry studentsRegistry = new StudentsRegistry();
        Scanner keyboard = new Scanner(System.in);
        int action = -1;
        boolean validInput;

        while (action != 8) {

            System.out.println("\nPlease select an action from below:\n");
            System.out.println("1. Add, edit or remove a student.");
            System.out.println("2. Add, edit or remove a teacher.");
            System.out.println("3. Add, edit or remove a course.");
            System.out.println("4. Assign course/courses to a teacher.");
            System.out.println("5. Assign course/courses to a student.");
            System.out.println("6. Display all students.");
            System.out.println("7. Display all teachers.");
            System.out.println("8. Display all available courses.");
            System.out.println("9. Exit.");
            System.out.print("\nAction number: ");

            validInput = false;
            while (!validInput) {
                if (keyboard.hasNextInt()) {
                    action = keyboard.nextInt();
                    keyboard.nextLine();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    keyboard.nextLine();
                }
            }

            switch (action) {

                case 1:
                    System.out.println("You want to Add (type a), Edit (type e) or Remove (type r) a student? If you want to exit press x");
                    switch (keyboard.nextLine().toLowerCase()) {
                        case "a":
                            studentsRegistry.addStudent();
                            break;
                        case "e":
                            System.out.print("Enter the name of the student you want to edit: ");
                            String editStudent = keyboard.nextLine();
                            studentsRegistry.editStudent(editStudent);
                            break;
                        case "r":
                            System.out.print("Enter the name of the student you want to remove: ");
                            String removeStudent = keyboard.nextLine();
                            studentsRegistry.removeStudent(removeStudent);
                            break;
                        case "x":
                            break;
                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
                    break;

                case 2:
                    System.out.println("You want to Add (type a), Edit (type e) or Remove (type r) a teacher? If you want to exit press x");
                    switch (keyboard.nextLine().toLowerCase()) {
                        case "a":
                            studentsRegistry.addTeacher();
                            break;
                        case "e":
                            System.out.print("Enter the name of the teacher you want to edit: ");
                            String editTeacher = keyboard.nextLine();
                            studentsRegistry.editTeacher(editTeacher);
                            break;
                        case "r":
                            System.out.print("Enter the name of the teacher you want to remove: ");
                            String removeTeacher = keyboard.nextLine();
                            studentsRegistry.removeTeacher(removeTeacher);
                            break;
                        case "x":
                            break;
                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("You want to Add (type a), Edit (type e) or Remove (type r) a course? If you want to exit press x");
                    switch (keyboard.nextLine().toLowerCase()) {
                        case "a":
                            studentsRegistry.addCourse();
                            break;
                        case "e":
                            System.out.print("Enter the name of the course you want to edit: ");
                            String editCourse = keyboard.nextLine();
                            studentsRegistry.editCourse(editCourse);
                            break;
                        case "r":
                            System.out.print("Enter the name of the course you want to remove: ");
                            String removeCourse = keyboard.nextLine();
                            studentsRegistry.removeCourse(removeCourse);
                            break;
                        case "x":
                            break;
                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
                    break;

                case 4:
                    studentsRegistry.addCourseToTeacher();
                    break;

                case 5:
                    studentsRegistry.addCourseToStudent();
                    break;

                case 6:
                    studentsRegistry.displayAllStudents();
                    break;

                case 7:
                    studentsRegistry.displayAllTeachers();
                    break;

                case 8:
                    studentsRegistry.displayAllCourses();
                    break;

                case 9:
                    System.out.println("Bye Bye");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
