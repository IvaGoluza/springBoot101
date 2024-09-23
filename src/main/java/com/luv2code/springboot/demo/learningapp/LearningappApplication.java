package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.AppDAO;
import com.luv2code.springboot.demo.learningapp.entity.Instructor;
import com.luv2code.springboot.demo.learningapp.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.InstantSource;


@SpringBootApplication
public class LearningappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructorById(appDAO);
		};

	}

	private void deleteInstructorById(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor with id " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done.");

	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding instructor with id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Anna", "Darwin", "anna@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.anna101/youtube", "sheep watching");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done.");
	}

}
