package com.sabrinibovo.bank.app;

import com.sabrinibovo.bank.model.Account;

import java.util.function.ToIntFunction;

public class AccountNumberFunction implements ToIntFunction<Account> {

    @Override
    public int applyAsInt(Account account) {
        return account.getNumber();
    }
}
