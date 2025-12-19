package util;

import constants.AccountType;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class IdGenerator {
    public static int counter = 1000;
    public String generateAccountNo(AccountType accountType){
        String accountNo = "ACC";

        if(accountType== AccountType.SAVING){
            accountNo+= "_sav_"+ LocalDateTime.now().getYear()
                    +counter;
        }else{
            accountNo+= "_cur_"+ LocalDateTime.now().getYear()
                    +counter;
        }
        return accountNo;
    }
    public String generateUserId(){
        return UUID.randomUUID().toString();
    }
}
