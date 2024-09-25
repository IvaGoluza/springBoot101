package com.luv2code.springboot.demo.learningapp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {

        System.out.println(getClass() + ": Adding new membership.");

    }
}
