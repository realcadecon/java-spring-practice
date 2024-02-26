package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

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
    public int returnAccountNum(int accountNum, String accountName) {
        System.out.println(getClass() + ": Doing DB work - Getting an account name and num - " + accountNum + ", " + accountNum);
        return accountNum;
    }

    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire) {
            throw new RuntimeException("trip wire tripped - panic");
        }
        List<Account>  myAccounts = new ArrayList<Account>();
        Account a1 = new Account(1, "John", 100.1);
        Account a2 = new Account(2, "Java", 30000020);
        Account a3 = new Account(3, "Rust", 0.50);

        myAccounts.add(a1);
        myAccounts.add(a2);
        myAccounts.add(a3);

        return myAccounts;
    }

}
