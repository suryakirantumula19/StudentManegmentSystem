# Student Management System

A Java-based Student Management System built using Spring Boot. This project provides REST APIs to manage student records, including creating, retrieving, updating, and deleting students.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- REST API

## Features
- Add a student
- View all students
- Search for a student by ID
- Update student details
- Delete a student
- Store student data using H2 Database

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get a student by ID |
| POST | `/students` | Add a student |
| PUT | `/students/{id}` | Update a student |
| DELETE | `/students/{id}` | Delete a student |

## How to Run

1. Install JDK and configure `JAVA_HOME`.
2. Clone or download this repository.
3. Open the project folder in VS Code.
4. Run the application:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

5. Test the API using Postman.

## Database

This project uses an H2 in-memory database. Data is reset when the application restarts.

## Learning Objectives
- Building REST APIs with Spring Boot
- Using Spring Data JPA for database operations
- Understanding HTTP methods and CRUD operations
- Testing APIs with Postman

