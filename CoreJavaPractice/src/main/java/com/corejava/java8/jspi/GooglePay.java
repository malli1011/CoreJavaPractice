package com.corejava.java8.jspi;

public class GooglePay implements PaymentInterface{
    @Override
    public void pay() {
        System.out.println("Pay with Google Pay!!!");
    }
}
