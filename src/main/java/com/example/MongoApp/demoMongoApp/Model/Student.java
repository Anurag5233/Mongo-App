package com.example.MongoApp.demoMongoApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student1")
public class Student {


    @Id
    int student_id;
    String name;
    String location;
    String clgName;

    public Student(int student_id, String name, String location, String clgName) {
        this.student_id = student_id;
        this.name = name;
        this.location = location;
        this.clgName = clgName;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }
}
