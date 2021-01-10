package com.example.MongoApp.demoMongoApp.Service;

import com.example.MongoApp.demoMongoApp.Model.Student;
import com.example.MongoApp.demoMongoApp.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    //getting all Student record by using the method findaAll() of CrudRepository
    public List<Student> getAllBooks()
    {
        List<Student> students = new ArrayList<Student>();
        studentRepo.findAll().forEach(student1 -> students.add(student1));
        return students;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Optional<Student> getStudentById(int id)
    {
        return studentRepo.findById(id);
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Student student)
    {
        studentRepo.save(student);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        studentRepo.deleteById(id);
    }

    //updating a record
    public void update(Student student)
    {
        studentRepo.save(student);
    }
}
