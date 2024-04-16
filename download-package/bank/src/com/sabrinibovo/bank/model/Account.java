package com.sabrinibovo.bank.model;

import com.sabrinibovo.bank.model.exception.NotEnoughBalanceException;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Account {

    private Person owner;
    private int agency;
    private int number;
    private BigDecimal balance = BigDecimal.ZERO;

    Account(){
    }

    public Account(Person owner, int agency, int number) {
           Objects.requireNonNull(owner);
           this.owner = owner;
           this.agency = agency;
           this.number = number;
    }

    public void deposit(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Value must be bigger than 0");
        }
        balance = balance.add(value);
    }

    public void sacking(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Value must be bigger than 0");
        }
        if (getAvailableBalance().subtract(value).compareTo(BigDecimal.ZERO)< 0) {
            throw new NotEnoughBalanceException("Not Enough Balance");
        }
        balance = balance.subtract(value);
    }

    public void sacking(BigDecimal value, BigDecimal sackingRate) {
        sacking(value.add(sackingRate));
    }

    public abstract void debitMonthlyTax();

    public Person getOwner() {
        return owner;
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }
    public BigDecimal getBalance() {
        return balance;
    }



    public BigDecimal getAvailableBalance() {
        return getBalance();
    }


}

