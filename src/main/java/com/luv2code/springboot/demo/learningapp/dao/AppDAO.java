package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.entity.Course;
import com.luv2code.springboot.demo.learningapp.entity.Instructor;
import com.luv2code.springboot.demo.learningapp.entity.InstructorDetail;
import com.luv2code.springboot.demo.learningapp.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id); // this will not delete associated instructor since CascadeType.ALL is no longer used

    List<Course> findCoursesByInstructorId(int id);

    Course findCourseById(int id);

    void update(Instructor instructor);

    void update(Course course);

    void save (Course course);

    Course findCourseAndReviewsById(int id);

    void deleteCourseById(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);
}
