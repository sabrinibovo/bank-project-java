package com.sabrinibovo.bank.app;

import com.sabrinibovo.bank.model.Account;
import com.sabrinibovo.bank.model.Bank;
import com.sabrinibovo.bank.model.Person;
import java.math.BigDecimal;
import java.util.List;

public class Principal4 {

    public static void main(String[] args) {
         Bank bank = new Bank();

         List<Person> owners =  bank.getAccounts().stream()
                 .map(Account::getOwner)
                 .distinct()
                 .toList();


        System.out.println(owners);

      BigDecimal totalBalance = bank.getAccounts().stream()
                 .map(Account::getBalance)
                 .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totalBalance);

         bank.getAccounts().stream()
                 .filter(account -> account.getBalance().compareTo(new BigDecimal("50")) > 0)
                 .filter(account -> account.getNumber() > 200)
                 .map(Account::getOwner)
                 .distinct()
                 .forEach(System.out::println);



    }

}
