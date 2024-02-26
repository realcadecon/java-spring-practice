package com.luv2code.aopdemo;

import com.luv2code.aopdemo.customFunctions.CustomFunc;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(String[] args, AccountDAO accountDAO, MembershipDAO membershipDAO, CustomFunc customFunc) {
		return runner -> {

			demoTheBeforeAdvice(accountDAO, membershipDAO, customFunc);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO, CustomFunc customFunc) {
		accountDAO.addAccount();
		accountDAO.addAndReturnAccountNum();
		accountDAO.returnAccountNum(27);

		membershipDAO.addAccount();
		membershipDAO.addAccount();

		customFunc.doCustomFunction(true);
	}


}
