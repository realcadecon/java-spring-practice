package com.luv2code.aopdemo;

import com.luv2code.aopdemo.customFunctions.CustomFunc;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.AccountDAOImpl;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(String[] args, AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {

			//demoTheBeforeAdvice(accountDAO, membershipDAO);
			//demoTheAfterAdvice(accountDAO);

			demoAroundAdvice(trafficFortuneService);

		};
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("\tcalling getFortune()");

		String fortune = trafficFortuneService.getFortune(true);

		System.out.println("\nFortune is: " + fortune);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Main Program: caught runtime exception");
			return;
		}
		System.out.print("\nMy Accounts:\n");
		accounts.stream().forEach(System.out::println);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> accounts = null;

		try {
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Main Program: caught runtime exception");
			return;
		}
		System.out.print("\nMy Accounts:\n");
		accounts.stream().forEach(System.out::println);
	}


}
