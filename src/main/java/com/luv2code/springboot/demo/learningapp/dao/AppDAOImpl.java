package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.entity.Instructor;
import com.luv2code.springboot.demo.learningapp.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        entityManager.remove(tempInstructor);
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
}
