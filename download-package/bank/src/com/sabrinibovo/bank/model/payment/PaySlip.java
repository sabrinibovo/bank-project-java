package com.sabrinibovo.bank.model.payment;

import com.sabrinibovo.bank.model.Person;

import java.math.BigDecimal;

public class PaySlip implements PayableDocument {

    private Person employee;
    private BigDecimal valuePerHour;
    private int amountOfHours;
    private boolean paid;

    public PaySlip(Person employee, BigDecimal valuePerHour, int amountOfHours) {
        this.employee = employee;
        this.valuePerHour = valuePerHour;
        this.amountOfHours = amountOfHours;
    }

    @Override
    public BigDecimal getTotalValue() {
        return valuePerHour.multiply(new BigDecimal(amountOfHours));
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public void pay() {
        paid = true;

    }
}
