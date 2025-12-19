package app;

import constants.AccountType;
import model.Account;
import model.SavingsAccount;
import model.User;

import java.util.Scanner;

public class BankApplication {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        // -------- USER INPUT --------
        System.out.print("Enter Mobile Number: ");
        String mobileNo = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        User user = new User(mobileNo, name, address, email);

        // -------- ACCOUNT INPUT --------
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter Account Type (1.SAVING  2.CURRENT): ");
        int choice = sc.nextInt();

        AccountType accountType;
        if (choice == 1) {
            accountType = AccountType.SAVING;
        } else {
            accountType = AccountType.CURRENT;
        }

        Account account = new Account(user, balance, accountType);

        // -------- OUTPUT --------
        System.out.println("\n--- ACCOUNT CREATED SUCCESSFULLY ---");
        System.out.println("User ID     : " + user.getUserId());
        System.out.println("Account No  : " + account.getAccountNo());
        System.out.println("Name        : " + name);
        System.out.println("Balance     : " + balance);
        System.out.println("AccountType : " + accountType);

        sc.close();


    }
}
