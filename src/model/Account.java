package model;

import constants.AccountType;
import util.IdGenerator;

public class Account {
    protected String accountNo;//to access in child class
    protected User user;
    public void setBalance(double balance) {
        this.balance = balance;
    }
    protected double balance;
    protected AccountType accountType;
    IdGenerator id = new IdGenerator();

    public Account( User user, double balance, AccountType accountType) {
        this.user = user;
        this.balance = balance;
        this.accountType = accountType;
        this.accountNo = id.generateAccountNo(accountType);
    }

    public String getAccountNo() {
        return accountNo;
    }
    public User getUser() {
        return user;
    }


    public double getBalance() {
        return balance;
    }



    public AccountType getAccountType() {
        return accountType;
    }

    public void deposit(double amount){

        balance +=amount;
    }
    public String withdraw(double amount){
        if(balance>amount){
            balance = balance - amount;
            return "amount withdrawn succesfully";

        }else{
            return " Insufficient Balance";
        }
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNo='" + accountNo + '\'' +
                ", user=" + user +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }


}
