package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("from Student order by lastName desc", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s where lastName=:theData", Student.class);
        query.setParameter("theData", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteByLastName(String lastName) {
        // do not provide Student.class (query result type param) since this query returns rows affected by delete, not list of entities
        return entityManager.createQuery("delete from Student s where s.lastName=:theData")
                .setParameter("theData", lastName).executeUpdate();  // returns deleted rows number
    }

}
