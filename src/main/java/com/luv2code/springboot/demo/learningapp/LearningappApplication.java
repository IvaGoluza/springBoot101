package com.luv2code.springboot.demo.learningapp;

import com.luv2code.springboot.demo.learningapp.dao.AccountDAO;
import com.luv2code.springboot.demo.learningapp.dao.MembershipDAO;
import com.luv2code.springboot.demo.learningapp.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {

		return runner -> {
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturnAdvice(accountDAO);
			// demoTheAfterThrowingAdvice(accountDAO);
			// demoTheAfterAdvice(accountDAO);
			demoTheAroundAdvice(trafficFortuneService);
		};

	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("Main program: demoTheAroundAdvice. Calling getFortune().");
		boolean trip = false;  // set to true to simulate exception handling

        try {
            String data = trafficFortuneService.getFortune(trip);
			System.out.println("Main program: " + data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

	private void demoTheAfterAdvice(AccountDAO accountDAO) {

		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exc
			boolean trip = false;
			accounts = accountDAO.findAccounts(trip);
		} catch (Exception e) {
			System.out.println("Main program: " + e.getMessage());
		}

		System.out.println("Main program. Accounts:");
		System.out.println(accounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			// add a boolean flag to simulate exc
			boolean trip = true;
			accounts = accountDAO.findAccounts(trip);
		} catch (Exception e) {
			System.out.println("Main program: " + e.getMessage());
		}

		System.out.println("Main program. Accounts:");
		System.out.println(accounts);
	}

	private void demoTheAfterReturnAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts(false);

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
