package com.sabrinibovo.bank.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestmentAccount extends Account {

    public InvestmentAccount(Person owner, int agency, int number) {
        super(owner, agency, number);
    }

    @Override
    public void debitMonthlyTax() {
        if (getBalance().compareTo(new BigDecimal("10000")) < 0) {
            sacking(new BigDecimal("30"));
        }
    }
    public void rentCredit(BigDecimal interestRate) {
        BigDecimal rentValue = getBalance().multiply(interestRate)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);
        deposit(rentValue);
    }
}
