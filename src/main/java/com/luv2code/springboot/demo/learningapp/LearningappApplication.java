package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.AppDAO;
import com.luv2code.springboot.demo.learningapp.entity.*;
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
			// deleteCourseAndReviews(appDAO);
			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			// findStudentAndCourses(appDAO);
			// addMoreCoursesToStudent(appDAO);
			deleteStudent(appDAO);
		};

	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Deleting student with id: " + theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Student with id: " + theId + " deleted.");
	}

	private void addMoreCoursesToStudent(AppDAO appDAO) {

		int theId = 1;

		Course course = new Course("New course for student");
		Student student = appDAO.findStudentAndCoursesByStudentId(theId);
		student.addCourse(course);
		appDAO.update(student);

		System.out.println("Added course " + course + " to student " + student);
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding Student and courses with student id " + theId);
		Student student = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Found student:" + student);
		System.out.println("Found courses:" + student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Finding Course with students with id " + theId);
		Course course = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Found Course:" + course);
		System.out.println("Found students:" + course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course = new Course("Course with students");

		Student student1 = new Student("Student1", "First", "1@mail.com");
		Student student2 = new Student("Student2", "Second", "2@mail.com");

		course.addStudent(student1);
		course.addStudent(student2);

		appDAO.save(course);  // saves the course and associated students

		System.out.println("Saved course: " + course);
		System.out.println("Saved students: " + course.getStudents());
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 11;

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
