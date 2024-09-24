package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.AppDAO;
import com.luv2code.springboot.demo.learningapp.entity.Course;
import com.luv2code.springboot.demo.learningapp.entity.Instructor;
import com.luv2code.springboot.demo.learningapp.entity.InstructorDetail;
import com.luv2code.springboot.demo.learningapp.entity.Review;
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

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructorById(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetailById(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done.");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		Course course = appDAO.findCourseAndReviewsById(theId);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course = new Course("course1");

		course.addReview(new Review("review1"));
		course.addReview(new Review("review2"));
		course.addReview(new Review("review3"));

		System.out.println("Saving course: " + course);
		System.out.println("Saving course reviews: " + course.getReviews());
		appDAO.save(course);
		System.out.println("Done.");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Finding course with id " + theId);
		Course temCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course with id " + temCourse.getId());
		temCourse.setTitle("updatedCourseTitle");

		appDAO.update(temCourse);
		System.out.println("Done.");
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor with id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor with id " + tempInstructor.getId());
		tempInstructor.setLastName("updatedLastName");

		appDAO.update(tempInstructor);
		System.out.println("Done.");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor with id " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("Found courses: " + tempInstructor.getCourses());

	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding instructor with id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId); // retrieves the instructor without courses (lazy fetch)
		System.out.println("Found instructor: " + tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);  // BIND THE DATA!

		System.out.println("Found courses: " + tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor with id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Found instructor: " + tempInstructor);
		System.out.println("Found courses: " + tempInstructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Susan", "Darwin", "susan@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.susan101/youtube", "elephant watching");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course course1 = new Course("course1");
		Course course2 = new Course("course2");
		Course course3 = new Course("course3");

		tempInstructor.add(course1);
		tempInstructor.add(course2);
		tempInstructor.add(course3);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("Saving instructor detail: " + tempInstructorDetail);
		System.out.println("Saving course: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor); // saves the courses -> used CascadeType.PERSIST
		System.out.println("Done.");
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {

		int theId = 5;
		System.out.println("Deleting instructor details with id " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done. Only instructor detail has been deleted.");

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

		Instructor tempInstructor = new Instructor("Mark", "Darwin", "mark@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.mark101/youtube", "elephant watching");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done.");
	}

}
