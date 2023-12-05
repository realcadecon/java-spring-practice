package com.luv2code.crudDemo;

import com.luv2code.crudDemo.dao.StudentDAO;
import com.luv2code.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createMultipleStudents(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(4);

	}

	private void deleteMultipleStudents(StudentDAO studentDAO) {
		studentDAO.deleteByFirstName("Paul");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		System.out.println("Getting student with id: " + id);

		Student myStudent = studentDAO.findByID(id);
		System.out.format("Found Student with id=%d: %s\n", id, myStudent);
		System.out.println("Updating first name of Student...");

		myStudent.setFirstName("John");
		studentDAO.update(myStudent);

		System.out.format("Updated student: %s", myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findStudentByLastName("Doe");
		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> allStudents = studentDAO.findAll();
		for (Student tempStudent : allStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Daffy", "Duck", "testemail.gmail.com");
		studentDAO.save(student);

		System.out.println("Student ID: " + student.getId());

		System.out.println("Looking up student by ID = " + student.getId());
		Student readStudent = studentDAO.findByID(student.getId());
		System.out.println("Found Student: " + readStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		//save student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of saved student
		System.out.println("ID of Saved Student: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating student objects...");
		Student tempStudent1 = new Student("John", "Doe", "paul@luv2code.com");
		Student tempStudent2 = new Student("Matthew", "Doe", "matthew@luv2code.com");
		Student tempStudent3 = new Student("Luke", "Doe", "luke@luv2code.com");

		//save student object
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display id of saved student
		System.out.println("ID of " + tempStudent1.getFirstName() + ": " + tempStudent1.getId());
		System.out.println("ID of " + tempStudent2.getFirstName() + ": " + tempStudent2.getId());
		System.out.println("ID of " + tempStudent3.getFirstName() + ": " + tempStudent3.getId());
	}

}
