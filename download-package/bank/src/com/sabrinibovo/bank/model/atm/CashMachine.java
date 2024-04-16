package com.sabrinibovo.bank.model.atm;

import com.sabrinibovo.bank.model.Account;
import com.sabrinibovo.bank.model.payment.PayableDocument;
import com.sabrinibovo.bank.model.payment.ReversiblePaymentDocument;

public class CashMachine {

    public void printBalance(Account account) {
        System.out.println("Account: " + account.getAgency() + "/" + account.getNumber());
        System.out.println("Owner: " + account.getOwner().getName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Available balance: " + account.getAvailableBalance());
    }

    public void pay(PayableDocument document, Account account) {
        if (document.isPaid()) {
            throw new IllegalStateException("Document is already paid");
        }
        account.sacking(document.getTotalValue());
        document.pay();
    }

    public void reversePayment(ReversiblePaymentDocument document, Account account) {
        if (!document.isPaid()){
            throw new IllegalStateException("Document is not paid");
        }
        account.deposit(document.getTotalValue());
        document.reversePayment();
    }
}

