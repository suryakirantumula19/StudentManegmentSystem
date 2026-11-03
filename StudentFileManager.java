
import java.io.*;
import java.util.ArrayList;

public class StudentFileManager {

    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(ArrayList<Student> students) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student s : students) {
                writer.write(s.id + "," + s.name + "," + s.marks);
                writer.newLine();
            }

            System.out.println("Student data saved.");

        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public static void loadStudents(ArrayList<Student> students) {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 3);

                if (data.length == 3) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double marks = Double.parseDouble(data[2]);

                    students.add(new Student(id, name, marks));
                }
            }

            System.out.println("Student data loaded.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}
