
import java.util.ArrayList;

public class StudentService {

    private final ArrayList<Student> students;

    public StudentService(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.id == student.id) {
                return false;
            }
        }

        students.add(student);
        StudentFileManager.saveStudents(students);
        return true;
    }

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Student student = searchStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        StudentFileManager.saveStudents(students);
        return true;
    }
    public boolean updateStudent(int id, String name, double marks) {
        Student student = searchStudent(id);

        if (student == null || marks < 0 || marks > 100) {
            return false;
        }

        student.name = name;
        student.marks = marks;

        StudentFileManager.saveStudents(students);
        return true;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
        
    }
}
