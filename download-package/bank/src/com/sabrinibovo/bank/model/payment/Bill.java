package com.sabrinibovo.bank.model.payment;

import com.sabrinibovo.bank.model.Person;

import java.math.BigDecimal;

public class Bill implements PayableDocument, ReversiblePaymentDocument{

   private Person beneficiary;
   private BigDecimal value;
   private boolean paid;

    public Bill(Person beneficiary, BigDecimal value) {
        this.beneficiary = beneficiary;
        this.value = value;
    }

    @Override
    public BigDecimal getTotalValue() {
        return value;
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public void reversePayment() {
        paid = false;
    }

    @Override
    public void pay() {
        paid = true;
    }
}
