package app;

import constants.AccountType;
import model.Account;
import model.SavingsAccount;
import model.User;
import service.BankServiceImpl;

import java.util.Scanner;

public class BankApplication {
    public static void main(String [] args){
        BankServiceImpl b = new BankServiceImpl();

        b.createAccount();
        b.createAccount();

        b.showAccountDetails();
        b.showAllAccounts();
        b.depositAmount();
        b.withdrawMoney();

    }
}
