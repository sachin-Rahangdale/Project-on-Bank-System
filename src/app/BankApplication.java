package app;

import constants.AccountType;
import model.Account;
import model.SavingsAccount;
import model.User;
import repository.BankRepository;
import service.BankServiceImpl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
    public static void main(String [] args){

        BankServiceImpl b = new BankServiceImpl();;
        boolean run = true;
        Scanner sc = new Scanner(System.in);//


        while(run){
            System.out.println("ENTER THE CHOICE");
            System.out.println("1 to create an Account");
            System.out.println("2 to deposit Money");
            System.out.print("3 to withdraw Money");
            System.out.println("4 to get account details");
            System.out.println("5 to get details of all existing accounts");
            System.out.println("6 to view transactions");
            System.out.println("7 to exit   ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    b.createAccount();
                    break;
                case 2:
                    b.depositAmount();
                    break;
                case 3:
                    b.withdrawMoney();
                    break;
                case 4:
                    b.showAccountDetails();
                    break;
                case 5:
                    b.showAllAccounts();
                    break;
                case 6 :
                    b.getTransaction(1,10);
                    break;
                case 7:
                    run = false;
                    break;
                default:
                    System.out.println(" please enter a valid number of choice");
            }

        }

        /*ArrayList<ArrayList<Integer>> list2d = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(23);
        row1.add(53);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(643);
        row2.add(234);

        list2d.add(row1);
        list2d.add(row2);

        int target = 23;

        for (int row = 0; row < list2d.size(); row++) {          // rows
            for (int column = 0; column < list2d.get(row).size(); column++) { // column
               //to find target
                if(target == list2d.get(row).get(column)){
                    System.out.println("element found at row: "+row +"and colummn : "+column);
                }
            }
            System.out.println();
        }

// to print the elements
        for (int i = 0; i < list2d.size(); i++) {          // rows
            for (int j = 0; j < list2d.get(i).size(); j++) { // columns
                System.out.print(list2d.get(i).get(j) + " ");
            }
            System.out.println();
        }



        System.out.println(list2d);
/*
        BankServiceImpl b = new BankServiceImpl();

        b.createAccount();
        b.createAccount();

        b.showAccountDetails();
        b.showAllAccounts();
        b.depositAmount();
        b.withdrawMoney();*/

    }
}
