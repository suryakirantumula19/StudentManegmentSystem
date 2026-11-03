
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        StudentFileManager.loadStudents(students);

        StudentService service = new StudentService(students);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter student ID: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID! Enter a number.");
                        sc.next();
                        break;
                    }

                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter student marks: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid marks! Enter a number.");
                        sc.next();
                        break;
                    }

                    double marks = sc.nextDouble();

                    if (marks < 0 || marks > 100) {
                        System.out.println(
                            "Marks must be between 0 and 100."
                        );
                        break;
                    }

                    Student student = new Student(id, name, marks);

                    if (service.addStudent(student)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Student ID already exists!");
                    }
                    break;

                case 2:
                    ArrayList<Student> allStudents =
                            service.getAllStudents();

                    if (allStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : allStudents) {
                            s.displayStudent();
                            System.out.println("----------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID! Enter a number.");
                        sc.next();
                        break;
                    }

                    int searchId = sc.nextInt();

                    Student result = service.searchStudent(searchId);

                    if (result != null) {
                        result.displayStudent();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID! Enter a number.");
                        sc.next();
                        break;
                    }

                    int deleteId = sc.nextInt();

                    if (service.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID to update: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid ID! Enter a number.");
                        sc.next();
                        break;
                    }

                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Student existing = service.searchStudent(updateId);

                    if (existing == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new marks: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid marks! Enter a number.");
                        sc.next();
                        break;
                    }

                    double newMarks = sc.nextDouble();

                    if (service.updateStudent(
                            updateId, newName, newMarks)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println(
                            "Update failed. Marks must be between 0 and 100."
                        );
                    }
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
