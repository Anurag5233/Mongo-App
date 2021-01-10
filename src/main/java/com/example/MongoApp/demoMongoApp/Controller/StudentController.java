package com.example.MongoApp.demoMongoApp.Controller;

import com.example.MongoApp.demoMongoApp.Model.Student;
import com.example.MongoApp.demoMongoApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class StudentController {

    //autowire the BooksService class
    @Autowired
    StudentService studentService;
    //creating a get mapping that retrieves all the books detail from the database

    @GetMapping("/student")
    private ResponseEntity<List<Student>> getAllBooks()
    {
        System.out.println("Inside controller");
        List<Student>  students= studentService.getAllBooks();
        if(students!=null)
        {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

            return new ResponseEntity<>(null, HttpStatus.OK);


    }
    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/student/{studentId}")
    private ResponseEntity<Student> getBooks(@PathVariable("studentId") int studentId)
    {
        System.out.println("Inside controller getId");
        Optional<Student> s = ((studentService.getStudentById(studentId)));

        if (s.isPresent()) {
            return new ResponseEntity<>(s.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/student/{studentId}")
    private ResponseEntity<HttpStatus> deleteBook(@PathVariable("studentId") int studentId)
    {
        System.out.println("Inside controller delete");

        try {
            studentService.delete(studentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/student")
    private int saveBook(@RequestBody Student student)
    {
        System.out.println("Inside controller postMapping");
        studentService.saveOrUpdate(student);
        return student.getStudent_id();
    }
    //creating put mapping that updates the book detail
    @PutMapping("/student/{id}")
    private Student update(@RequestBody Student student,@PathVariable String id) {
        System.out.println("Inside controller PutMapping");
        studentService.saveOrUpdate(student);
        return student;

    }

}
