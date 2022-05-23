package com.corejava.java8.jspi;

public class AmazonPay implements PaymentInterface{
    @Override
    public void pay() {
        System.out.println("Pay with Amazon Pay!!");
    }
}
