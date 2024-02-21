package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createCourseAndStudents(appDAO);

			//updateAndPopulateNewCourse(appDAO);

			//addCoursesToStudent(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourseById(id);
	}

	private void addCoursesToStudent(AppDAO appDAO) {
		int studentId = 1;
		Course course1 = new Course("Machine Learning");
		Course course2 = new Course("Docker & Kubernetes");
		Student student = appDAO.findStudentAndCoursesByStudentId(studentId);
		student.addCourse(course1);
		student.addCourse(course2);
		appDAO.saveStudent(student);
	}

	private void updateAndPopulateNewCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseAndStudentsByCourseId(10);
		System.out.println("Students in " + course.getTitle() + ":" + course.getStudents());
		Course newCourse = new Course("Math 2");
		for(Student student : course.getStudents()) {
			newCourse.addStudent(student);
		}
		newCourse = appDAO.saveCourse(newCourse);
		System.out.println(newCourse.getTitle() + ": Sucessfully updated with students from " + course.getTitle());

	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course1 = new Course("Math");

		Student student1 = new Student("Bob", "Builder", "email");
		Student student2 = new Student("John", "Doe", "email");


		System.out.println("Saving Course 1 " + course1 + "\n");
		course1.addStudent(student1);
		course1.addStudent(student2);
		appDAO.saveCourse(course1);



		Course course2 = new Course("History");
		System.out.println("Saving Course 2 " + course2 + "\n");
		student2 = appDAO.findStudent(2);
		course2.addStudent(student2);
		appDAO.saveCourse(course2);

	}


}
