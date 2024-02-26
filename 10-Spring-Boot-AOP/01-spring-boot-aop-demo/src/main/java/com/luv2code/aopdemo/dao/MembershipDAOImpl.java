package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
         System.out.println(getClass() + ": Doing DB work - Adding a membership account.");
    }

    @Override
    public void addSillyAccount() {
        System.out.println(getClass() + ": Doing DB work - Adding a silly membership account.");
    }
}
