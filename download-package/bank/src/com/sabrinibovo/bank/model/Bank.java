package com.sabrinibovo.bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public Bank() {
        Person person1 = new Person("Jady Bovo", "54748932148");
        Person person2 = new Person("Marcelo Melo", "214974231564");

        Account account1 = new InvestmentAccount(person1, 222, 999);
        Account account2 = new InvestmentAccount(person2, 123, 888);
        Account account3 = new InvestmentAccount(person2, 123, 567);
        Account account4 = new SpecialAccount(person1, 123, 188, new BigDecimal("15000"));
        Account account5 = new SpecialAccount(person2, 123, 222, new BigDecimal("20000"));

        account1.deposit(new BigDecimal("120"));
        account2.deposit(new BigDecimal("150"));
        account3.deposit(new BigDecimal("500"));
        account5.deposit(new BigDecimal("12000"));

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Optional<Account> search(int agency, int accountNumber) {
        for (Account account : getAccounts()) {
            if (account.getAgency() == agency && account.getNumber() == accountNumber) {
               return Optional.of(account);
           }
        }
        return Optional.empty();
    }


}







