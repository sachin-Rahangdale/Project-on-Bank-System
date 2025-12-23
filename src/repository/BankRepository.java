package repository;

import model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {
    public static Map<String, Account> account = new HashMap<>();
    public static Map<String,ArrayList> transactions = new HashMap<>();
    private BankRepository(){

    }
}
