package com.sabrinibovo.bank.model;

import java.math.BigDecimal;

public class SpecialAccount extends Account {

    private BigDecimal limitValue;

    public SpecialAccount(Person owner, int agency, int number, BigDecimal limitValue) {
        super(owner, agency, number);
        this.limitValue = limitValue;
    }

    @Override
    public void debitMonthlyTax() {
        sacking(new BigDecimal("20"));
    }

    @Override
    public BigDecimal getAvailableBalance() {
        return getBalance().add(getLimitValue());
    }

    public BigDecimal getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(BigDecimal limitValue) {
        this.limitValue = limitValue;
    }

}
