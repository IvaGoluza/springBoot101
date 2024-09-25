package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vip);

    List<Account> findAccounts(boolean trip);

}
