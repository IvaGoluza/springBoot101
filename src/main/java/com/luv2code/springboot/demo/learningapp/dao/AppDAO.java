package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
