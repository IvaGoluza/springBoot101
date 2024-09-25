package com.luv2code.springboot.demo.learningapp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    private String name;

    public String getName() {
        System.out.println("Get name method called");
        return name;
    }

    public void setName(String name) {
        System.out.println("Set name method called");
        this.name = name;
    }

    @Override
    public boolean addMember() {

        System.out.println(getClass() + ": Adding new membership.");
        return true;
    }
}
