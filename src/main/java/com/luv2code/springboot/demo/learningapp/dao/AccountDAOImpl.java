package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + ": Adding new account.");
    }

    @Override
    public List<Account> findAccounts() {

        Account account1 = new Account("account1", "1");
        Account account2 = new Account("account2", "2");
        Account account3 = new Account("account3", "3");

        return List.of(account1, account2, account3);
    }
}
