package com.sabrinibovo.bank.model.payment;


public interface ReversiblePaymentDocument extends PayableDocument{
    void reversePayment();
}
