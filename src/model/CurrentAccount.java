package model;

import constants.AccountType;

public class CurrentAccount extends Account {
    public static double MAX_BALANCE = 500000;
    public CurrentAccount(User user, double balance) {
        super(user, balance, AccountType.CURRENT);
    }

    public double getMaxBalance(){
        return MAX_BALANCE;
    }
}
