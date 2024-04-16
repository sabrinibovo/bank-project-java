package com.sabrinibovo.bank.model.payment;

import java.math.BigDecimal;

public interface PayableDocument {

    BigDecimal getTotalValue();
    boolean isPaid();
    void pay();

    default void printReceipt() {
        System.out.println("RECEIPT: ");
        System.out.println("Total Value: " + getTotalValue());
        System.out.println("Paid: " + isPaid());
    }
}
