package com.corejava.java8.jspi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceProviderInterfaceExample {
    private final ServiceLoader<PaymentInterface> loader = ServiceLoader.load(PaymentInterface.class);

    public Iterator<PaymentInterface> providers(boolean refresh) {
        if (refresh) {
            loader.reload();
        }
        return loader.iterator();
    }

    public static void main(String... args) {
        var paymentLoader = new ServiceProviderInterfaceExample();
        Iterator<PaymentInterface> providers = paymentLoader.providers(true);
        while (providers.hasNext()) {
            providers.next().pay();
        }

    }

}

