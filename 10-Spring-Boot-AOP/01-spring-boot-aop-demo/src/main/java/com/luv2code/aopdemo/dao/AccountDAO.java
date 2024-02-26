package com.luv2code.aopdemo.dao;

public interface AccountDAO {

    void addAccount();

    int addAndReturnAccountNum();

    int returnAccountNum(int accountNum);

}
