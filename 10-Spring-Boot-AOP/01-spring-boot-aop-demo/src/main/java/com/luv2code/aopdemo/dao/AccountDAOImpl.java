package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {
         System.out.println(getClass() + ": Doing DB work - Adding an account.");
    }

    @Override
    public int addAndReturnAccountNum() {
        System.out.println(getClass() + ": Doing DB work - Adding an account 20");
        return 20;
    }

    @Override
    public int returnAccountNum(int accountNum) {
        System.out.println(getClass() + ": Doing DB work - Getting an account - " + accountNum);
        return accountNum;
    }

}
