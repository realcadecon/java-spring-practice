package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findByID(int id);

    List<Student> findAll();

    List<Student> findStudentByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    void deleteByFirstName(String firstName);

}