package com.sabrinibovo.bank.app;
import com.sabrinibovo.bank.model.Account;
import com.sabrinibovo.bank.model.Bank;
import java.util.Comparator;


public class Principal3 {

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.getAccounts().sort(Comparator.comparingInt(Account::getNumber));

        for (Account account : bank.getAccounts()) {
            System.out.println(account.getAgency() + "/" + account.getNumber());
        }
    }
}
