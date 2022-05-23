package com.corejava.java8.jspi;

public class Paytm implements PaymentInterface{
    @Override
    public void pay() {
        System.out.println("Pay with Paytm!!");
    }
}
