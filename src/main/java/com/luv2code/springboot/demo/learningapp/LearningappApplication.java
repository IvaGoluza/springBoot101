package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.StudentDAO;
import com.luv2code.springboot.demo.learningapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LearningappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningappApplication.class, args);
	}

	// will be executed after the beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			crudStudent(studentDAO);
		};
	}

	private void crudStudent(StudentDAO studentDAO) {

		// create Student object
		System.out.println("Creating student...");
		Student student = new Student("andre", "flego", "goluzaiva@gmail.com");

		// save student
		System.out.println("Saving student...");
        studentDAO.save(student);

		// print id of the saved student
		System.out.println("Done! Generated id:" + student.getId());

		// retrieve student based on pk
		Student savedStudent = studentDAO.findById(student.getId());
		System.out.println("Found last saved student: " + savedStudent);

		// update student name
		savedStudent.setFirstName("Ella");
		studentDAO.update(savedStudent);

		// retrieve all students from db
		List<Student> students = studentDAO.findAll();
		for (Student s : students) {
			System.out.println("Found student: " + s);
		}

		// retrieve students by last name
		List<Student> studentsByLastName = studentDAO.findByLastName("Goluza");
		for (Student s : studentsByLastName) {
			System.out.println("Found student by lastname: " + s);
		}

		//delete student with id == 2
		//studentDAO.deleteById(2);

		//delete students with lastname == Flego
		//int rowsDeleted = studentDAO.deleteByLastName("flego");
		//System.out.println("Rows deleted: " + rowsDeleted);
	}


}
