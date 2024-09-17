package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void deleteById(int id);

    int deleteByLastName(String lastName);
}
