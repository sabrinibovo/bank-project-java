package com.sabrinibovo.bank.app;

import com.sabrinibovo.bank.model.*;
import com.sabrinibovo.bank.model.atm.CashMachine;
import com.sabrinibovo.bank.model.exception.NotEnoughBalanceException;
import com.sabrinibovo.bank.model.payment.Bill;
import com.sabrinibovo.bank.model.payment.PaySlip;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Principal {

    public static void main(String[] args) {
        Person owner1 = new Person();
        owner1.setName("Pedro Dias");
        owner1.setDocument("15689247700");
        owner1.setPurchase(new BigDecimal("15000"));
        owner1.setType(PersonType.LEGALPERSON);

        owner1.setDateLastUpdate(LocalDateTime.parse("2023-07-19T18:29:00"));
        System.out.println(owner1.getDateLastUpdate());

        Person owner2= new Person();
        owner2.setName("Joao Gomez");
        owner2.setDocument("77751648922");

        CashMachine cashMachine = new CashMachine();

        InvestmentAccount myAccount = new InvestmentAccount(owner1,216,789);
        SpecialAccount yourAccount = new SpecialAccount(owner2,478,456, new BigDecimal("1000"));

        try {
            myAccount.deposit(new BigDecimal("30000"));
            myAccount.sacking(new BigDecimal("1000"));

            yourAccount.deposit(new BigDecimal("15000"));
            yourAccount.sacking(new BigDecimal("15500"));
            yourAccount.debitMonthlyTax();

            Bill hospitalBill = new Bill(owner2, new BigDecimal("35000"));
            PaySlip employeeSalary = new PaySlip(owner2, new BigDecimal("200"), 160);

            cashMachine.pay(hospitalBill, myAccount);
            cashMachine.pay(employeeSalary, myAccount);

            cashMachine.reversePayment(hospitalBill, myAccount);

            hospitalBill.printReceipt();
            employeeSalary.printReceipt();
        } catch (NotEnoughBalanceException e) {
            System.out.println("Error while executing account operation: " + e.getMessage());
        }

        cashMachine.printBalance(myAccount);
        System.out.println();
        cashMachine.printBalance(yourAccount);
    }

}
