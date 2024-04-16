package com.sabrinibovo.bank.app;

import com.sabrinibovo.bank.model.Account;
import com.sabrinibovo.bank.model.Bank;
import java.math.BigDecimal;
import java.util.Optional;

public class Principal5 {

    public static void main(String[] args) {
        Bank bank = new Bank();

       Optional<Account> Optionalaccount = bank.search(289, 997);

          bank.search(289,997)
               .ifPresent(account -> System.out.println(account.getBalance()));


                if (Optionalaccount.isPresent()) {
            Account accountFound = Optionalaccount.get();
           System.out.println(accountFound.getBalance());
       }
         Account accountFound = bank.search(289,997)
                 .orElseThrow(() -> new RuntimeException("Account not found"));

        System.out.println(accountFound.getBalance());

        BigDecimal balance = bank.search(289, 997)
                .map(Account::getBalance)
                .orElse(BigDecimal.ZERO);

        System.out.println(balance);
    }
}
