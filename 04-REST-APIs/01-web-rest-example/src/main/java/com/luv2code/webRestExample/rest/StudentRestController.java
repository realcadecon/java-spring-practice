package com.luv2code.webRestExample.rest;

import com.luv2code.webRestExample.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> studentList;

    @PostConstruct
    public void setup() {
        studentList = new ArrayList<>();

        studentList.add(new Student("Sydney", "R"));
        studentList.add(new Student("Paul", "A"));
        studentList.add(new Student("Matthew", "M"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if(studentId >= studentList.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return studentList.get(studentId);
    }

    //student not found exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //generic exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
