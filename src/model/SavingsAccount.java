package model;

import constants.AccountType;

public class SavingsAccount extends Account {
    public static final double MIN_BALANCE = 5000;

    public SavingsAccount(User user, double balance) {
        super(user, balance,AccountType.SAVING);
    }
    public double getMinimumBalance(){
        return MIN_BALANCE;
    }


}
