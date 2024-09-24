package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.entity.Course;
import com.luv2code.springboot.demo.learningapp.entity.Instructor;
import com.luv2code.springboot.demo.learningapp.entity.InstructorDetail;
import com.luv2code.springboot.demo.learningapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);  // saves the instructorDetails object
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id); // returns Instructor object with InstructorDetails (eager fetch)
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor tempInstructor = entityManager.find(Instructor.class, id);

        List<Course> courses = tempInstructor.getCourses();

        // break associations of all courses for instructor
        for (Course course : courses) {
            course.setInstructor(null);
        }

        entityManager.remove(tempInstructor);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id = :data", Instructor.class);  // JOIN FETCH is similar to EAGER LOADING
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id); // retrieves the InstructorDetail AND associated Instructor
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);

        // REMOVE associated Instructor object reference -> break the bidirectional link  !!
        tempInstructorDetail.setInstructor(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course); // saves course and its reviews - used CascadeType.ALL
    }

    @Override
    public Course findCourseAndReviewsById(int id) {

        // have to write a query with JOIN FETCH because of the 1:n lazy fetching

        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id = :data", Course.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course tempCourse = entityManager.find(Course.class, id);
        entityManager.remove(tempCourse);

    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.students where c.id = :data", Course.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {

        TypedQuery<Student> query = entityManager.createQuery("select s from Student s JOIN FETCH s.courses where s.id = :data", Student.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {

        Student tempStudent = entityManager.find(Student.class, id);
        entityManager.remove(tempStudent);
    }

}
