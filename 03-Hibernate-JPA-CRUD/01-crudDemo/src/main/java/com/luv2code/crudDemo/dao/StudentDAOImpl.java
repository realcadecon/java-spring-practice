package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    // Constructor Injection for the Entity Manager
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Create Objects -----------------------------------------------------------------------------------------
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
    // -------------------------------------------------------------------------------------------------------


    // Read / Retrieve Objects -----------------------------------------------------------------------------------------
    @Override
    public Student findByID(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> findAll() {
       TypedQuery<Student> findStudents = entityManager.createQuery("FROM Student", Student.class);
        return findStudents.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        TypedQuery<Student> findStudents = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        findStudents.setParameter("theData", lastName);
        return findStudents.getResultList();
    }
    // -------------------------------------------------------------------------------------------------------


    // Update Objects -----------------------------------------------------------------------------------------
    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
    // -------------------------------------------------------------------------------------------------------

    // Delete Objects -----------------------------------------------------------------------------------------
    @Override
    @Transactional
    public void delete(int id) {
        Student studentToRemove = entityManager.find(Student.class, id);
        if(studentToRemove != null){
            entityManager.remove(studentToRemove);
        }
    }

    @Override
    @Transactional
    public void deleteByFirstName(String _firstName) {
        Query deleteByFirstName = entityManager.createQuery("DELETE FROM Student WHERE firstName=:theData");
        deleteByFirstName.setParameter("theData", _firstName).executeUpdate();
    }
    // -------------------------------------------------------------------------------------------------------


}
