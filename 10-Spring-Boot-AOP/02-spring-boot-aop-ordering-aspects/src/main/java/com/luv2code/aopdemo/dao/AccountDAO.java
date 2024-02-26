package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount();

    int addAndReturnAccountNum();

    int returnAccountNum(int accountNum, String accountName);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

}
