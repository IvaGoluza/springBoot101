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
			// deleteInstructorById(appDAO);
			// findInstructorDetail(appDAO);
			deleteInstructorDetailById(appDAO);
		};

	}

	private void deleteInstructorDetailById(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor details with id " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done. Both instructor details and associated instructor have been deleted.");

	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor detail with id " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Found instructor details: " + tempInstructorDetail);
		System.out.println("Because of the used bi-directional one-to-one mapping we can print out associated instructor for found instructor details: " + tempInstructorDetail.getInstructor());
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
