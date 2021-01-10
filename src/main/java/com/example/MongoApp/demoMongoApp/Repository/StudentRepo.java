package com.example.MongoApp.demoMongoApp.Repository;

import com.example.MongoApp.demoMongoApp.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,Integer> {



}
