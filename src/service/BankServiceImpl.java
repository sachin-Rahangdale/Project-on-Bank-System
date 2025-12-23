package service;
import constants.AccountType;
import model.Account;
import model.User;
import repository.BankRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import static repository.BankRepository.account;

public class BankServiceImpl implements BankService {


    @Override
    public void createAccount() {
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
        BankRepository.account.put(account.getAccountNo(), account);
        String record = LocalDateTime.now() + " | " + "credit " + balance;
        ArrayList<String> transaction = new ArrayList<>();
        transaction.add(record);
        BankRepository.transactions.put(account.getAccountNo(), transaction);

    }

    public void depositAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the account no: ");
        String acc_no = sc.nextLine();
        Account account = BankRepository.account.get(acc_no);
        if (account == null) {
            System.out.println("Account with entered doesnt exist");
        } else {
            System.out.println("Enter the amount to be deposited");
            double depositamount = sc.nextDouble();
            double newBalance = account.getBalance() + depositamount;
            String record = LocalDateTime.now() + " | " + "deposited " + depositamount;
            account.setBalance(newBalance);
            ArrayList<String> transaction = BankRepository.transactions.get(account.getAccountNo());
            transaction.add(record);
            BankRepository.transactions.put(account.getAccountNo(), transaction);
            System.out.println("Updated balance is " + account.getBalance());
            System.out.println(record);
        }
    }

    @Override
    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the account no: ");
        String acc_no = sc.nextLine();
        Account account = BankRepository.account.get(acc_no);
        if (account == null) {
            throw new RuntimeException("Account with entered doesnt exist");
        } else {
            System.out.println("Enter the amount to withdraw");
            double withdrawAmount = sc.nextDouble();
            if (withdrawAmount > account.getBalance()) {
                System.out.println("you dont have enough amount to withdraw");
            } else {
                double newBalance = account.getBalance() - withdrawAmount;
                account.setBalance(newBalance);
                String record = LocalDateTime.now() + " | " + "withdraw " + withdrawAmount;
                ArrayList<String> transaction = BankRepository.transactions.get(account.getAccountNo());
                transaction.add(record);
                BankRepository.transactions.put(account.getAccountNo(), transaction);
                System.out.println("remaining balance is " + account.getBalance());
                System.out.println(record);
            }
        }
    }
    @Override
    public Account showAccountDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the account no to get details ");
        String acc_no = sc.nextLine();
        Account account = BankRepository.account.get(acc_no);
        if (account == null) {
            System.out.println(" no account exist with this account number please enter the correct one");
        }
        return account;
    }
    @Override
    public void showAllAccounts() {
        if (account.isEmpty()) {
            System.out.println(" no account has been created till now: ");
        } else {
            System.out.println(" Created Accounts are: ");
            for (Account acc : account.values()) {
                System.out.println(acc);
                System.out.println("---------");
            }
        }
    }
    public void getTransaction(int page, int limit) {
        int skip = limit * (page - 1);

        Account account = showAccountDetails();
        if (account == null) return;

        ArrayList<String> tr =
                BankRepository.transactions.get(account.getAccountNo());

        if (tr == null || tr.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }

        if (skip >= tr.size()) {
            System.out.println("do not have enough Transactions");
            return;
        }

        int endIndex = Math.min(skip + limit, tr.size());

        for (int i = skip; i < endIndex; i++) {
            System.out.println(tr.get(i));
        }
    }

}

