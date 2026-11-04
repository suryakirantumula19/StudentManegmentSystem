
# Student Management System

A console-based Student Management System developed using Java.
It allows users to manage student records through a menu-driven
application and stores records in a local text file.

## Features

- Add new students
- View all students
- Search students by ID
- Delete student records
- Update student details
- Prevent duplicate student IDs
- Validate marks between 0 and 100
- Save and load student records using file handling
- Handle invalid numeric input

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList and Collections
- Exception and input handling
- File Handling
- Git and GitHub

## Project Structure

StudentManagementSystem/
├── Main.java
├── Student.java
├── StudentService.java
├── StudentFileManager.java
├── students.txt (created when data is saved)
└── README.md

## How to Run

1. Install the Java Development Kit (JDK).
2. Clone or download this repository.
3. Open a terminal in the project folder.
4. Compile the Java files:

   javac Student.java StudentFileManager.java StudentService.java Main.java

5. Run the application:

   java Main

## Data Storage

Student records are saved in a local text file named
students.txt and loaded when the application starts.

## Future Improvements

- Store student records in a MySQL database
- Add a graphical user interface
- Add sorting and filtering
- Improve input validation
