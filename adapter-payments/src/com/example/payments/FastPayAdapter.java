package com.example.payments;
public class FastPayAdapter implements PaymentGateway {
    private final FastPayClient client;
    FastPayAdapter(FastPayClient client){
        this.client= client;
    }
    public String charge(String customerId, int amountCents){
        return client.payNow(customerId, amountCents);
    }
}
