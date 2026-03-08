package com.example.payments;
public class SafeCashAdapter implements PaymentGateway {
    private final SafeCashClient client;

    SafeCashAdapter(SafeCashClient client){
        this.client= client;
    }

    public String charge(String customerId, int amountCents) {
        SafeCashPayment temp =  client.createPayment(amountCents, customerId);
        return temp.confirm();
    }
}
