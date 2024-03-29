package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			deleteInstructorDetail(appDAO);

			//createInstructor(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetail(2);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor detail id: " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor Detail: " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting instructor with id = " + id);
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor with Id = "+ id + ": " + instructor);
		System.out.println("Additional Details: " + instructor.getInstructorDetail());


	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor = new Instructor("Syd", "Rut", "srut@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
				"knitting");
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving the Instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done!");
	}


}
