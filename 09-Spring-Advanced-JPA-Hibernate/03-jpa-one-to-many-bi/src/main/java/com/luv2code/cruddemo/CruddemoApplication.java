package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
			//findInstructor(appDAO);


			//findInstructorWithCourses(appDAO);


			//findInstructorWithCoursesJoinFetch(appDAO);

			//saveInstructorWithCourse(appDAO);

			updateInstructor(appDAO);
		};
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Updating instructor: " + instructor);
		instructor.setFirstName("Mary");
		instructor.setLastName("Jane");
		appDAO.update(instructor);
	}

	private void saveInstructorWithCourse(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		List<Course> courses = instructor.getCourseList();
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(1);
		List<Course> courseList = instructor.getCourseList();
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor's Courses: " + instructor.getCourseList());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor with id = " + id);
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor with Id = "+ id + ": " + instructor);
		System.out.println("Additional Details: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Cad", "Con", "ccon@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
				"knitting");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("Math", instructor);
		Course course2 = new Course("Science", instructor);
		instructor.add(course1);
		instructor.add(course2);

		System.out.println("Saving the Instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with id = " + id);

		//this doesn't bring up courses because they are lazily loaded
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		List<Course> courseList = appDAO.findCoursesByInstructorId(id);
		instructor.setCourseList(courseList);
		System.out.println("Instructor's Courses: " + instructor.getCourseList());

		System.out.println("Done!");

	}


}
