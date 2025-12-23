package service;

import model.Account;

public interface BankService {
    void createAccount();
    void depositAmount();
    void withdrawMoney();
    Account showAccountDetails();
    void showAllAccounts();
    void getTransaction(int page,int limit);

}
