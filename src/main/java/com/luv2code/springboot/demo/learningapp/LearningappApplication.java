package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.AccountDAO;
import com.luv2code.springboot.demo.learningapp.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LearningappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		accountDAO.addAccount(new Account("accountName", "accountLevel"), true);
		membershipDAO.addMember();
	}

}
