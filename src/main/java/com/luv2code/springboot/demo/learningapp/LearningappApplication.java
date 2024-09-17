package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.StudentDAO;
import com.luv2code.springboot.demo.learningapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningappApplication.class, args);
	}

	// will be executed after the beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// create Student object
		System.out.println("Creating student...");
		Student student = new Student("iva", "goluza", "goluzaiva@gmail.com");

		// save student
		System.out.println("Saving student...");
        studentDAO.save(student);

		// print id of the saved student
		System.out.println("Done! Generated id:" + student.getId());
	}


}
