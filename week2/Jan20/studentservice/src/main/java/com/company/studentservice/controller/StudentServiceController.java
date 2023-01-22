package com.company.studentservice.controller;

import com.company.studentservice.models.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentServiceController {

    List<Student> studentList = new ArrayList<>();

    public StudentServiceController() {
        studentList.add(new Student("Sam"));
        studentList.add(new Student("Lisa"));
        studentList.add(new Student("Ming"));
        studentList.add(new Student("Lynda"));
    }
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentList;
    }
    @RequestMapping(value = "/students/{index}", method = RequestMethod.GET)
    public Student getStudentByIndex(@PathVariable int index) {
        return studentList.get(index);
    }
    @RequestMapping(value = "/students/name/{name}", method = RequestMethod.GET)
    public Student getStudentByName(@PathVariable String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equals(name)) {
                return studentList.get(i);
            }
        }
        return null;
    }
}
