package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        //this will cascade instructor detail
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructorToDelete = entityManager.find(Instructor.class, id);
        entityManager.remove(instructorToDelete);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getResultList();

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courseList " +
                        "JOIN FETCH i.instructorDetail " +
                        "where i.id = :data", Instructor.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Transactional
    @Override
    public void deleteCourseById(int id) {
        Course courseToRemove = entityManager.find(Course.class, id);
        entityManager.remove(courseToRemove);
    }

    @Transactional
    @Override
    public Course saveCourse(Course course) {
        return entityManager.merge(course);
    }

    @Transactional
    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }


    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> myQuery = entityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.reviews " +
                        "where c.id = :data", Course.class);
        myQuery.setParameter("data", id);

        Course course = myQuery.getSingleResult();
        return course;
    }

    @Override
    public Student findStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> myQuery = entityManager.createQuery(
                "select s from Student s " +
                        "JOIN FETCH s.courses " +
                        "where s.id = :data", Student.class);
        myQuery.setParameter("data", id);

        return myQuery.getSingleResult();
    }


    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> myQuery = entityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.students " +
                        "where c.id = :data", Course.class);
        myQuery.setParameter("data", id);

        return myQuery.getSingleResult();
    }

}
