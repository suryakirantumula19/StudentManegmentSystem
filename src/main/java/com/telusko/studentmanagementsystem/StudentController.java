
package com.telusko.studentmanagementsystem;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Add a new student
   @PostMapping
public Student addStudent(@Valid @RequestBody Student student) {
    student.setId(null);
    return repository.save(student);
}

    // Update an existing student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @Valid @RequestBody Student updatedStudent) {
        return repository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setMarks(updatedStudent.getMarks());
            return repository.save(student);
        }).orElse(null);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return "Student not found";
        }

        repository.deleteById(id);
        return "Student deleted successfully";
    }
}
