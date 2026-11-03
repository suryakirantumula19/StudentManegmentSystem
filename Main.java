
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        StudentFileManager.loadStudents(students);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    
System.out.print("Enter student ID: ");
int id = sc.nextInt();
sc.nextLine();

boolean idExists = false;

for (Student s : students) {
    if (s.id == id) {
        idExists = true;
        break;
    }
}

if (idExists) {
    System.out.println("Student ID already exists!");
    break;
}


                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    
System.out.print("Enter student marks: ");
double marks = sc.nextDouble();

if (marks < 0 || marks > 100) {
    System.out.println("Marks must be between 0 and 100.");
    break;
}


                    Student student = new Student(id, name, marks);
                    students.add(student);
                    StudentFileManager.saveStudents(students);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            s.displayStudent();
                            System.out.println("----------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == searchId) {
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                
case 4:
    System.out.print("Enter student ID to delete: ");
    int deleteId = sc.nextInt();

    boolean removed = false;

    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).id == deleteId) {
            students.remove(i);
            StudentFileManager.saveStudents(students);
            removed = true;
            System.out.println("Student deleted successfully!");
            break;
        }
    }

    if (!removed) {
        System.out.println("Student not found.");
    }
    break;      
               
case 5:
    System.out.print("Enter student ID to update: ");
    int updateId = sc.nextInt();
    sc.nextLine();

    boolean updated = false;

    for (Student s : students) {
        if (s.id == updateId) {
            System.out.print("Enter new name: ");
            String newName = sc.nextLine();

            System.out.print("Enter new marks: ");
            double newMarks = sc.nextDouble();

            if (newMarks < 0 || newMarks > 100) {
                System.out.println("Marks must be between 0 and 100.");
                break;
            }

            s.name = newName;
            s.marks = newMarks;
            StudentFileManager.saveStudents(students);
            System.out.println("Student updated successfully!");
            updated = true;
            break;
        }
    }

    if (!updated) {
        System.out.println("Student not found or update unsuccessful.");
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
