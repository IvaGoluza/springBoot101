package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.AccountDAO;
import com.luv2code.springboot.demo.learningapp.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class LearningappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		return runner -> {
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			demoTheAfterReturnAdvice(accountDAO);
		};

	}

	private void demoTheAfterReturnAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("Main program. Accounts:");
		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		accountDAO.addAccount(new Account("accountName", "accountLevel"), true);
		membershipDAO.getName();
		membershipDAO.setName("name");
		membershipDAO.addMember();
	}

}
