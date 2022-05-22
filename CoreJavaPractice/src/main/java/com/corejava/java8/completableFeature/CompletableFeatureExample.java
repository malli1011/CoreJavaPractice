package com.corejava.java8.completableFeature;

import javax.print.attribute.standard.PrinterStateReason;
import javax.sound.midi.Soundbank;
import java.util.concurrent.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CompletableFeatureExample {
    private static Object obj = new Object();

    public static void simpleExample() throws Exception {
       /* Runnable even = () -> task(i -> i % 2 == 0);
        Runnable odd = () -> task(i -> i % 2 != 0);
        CompletableFuture.runAsync(even);
        CompletableFuture.runAsync(odd);*/
        System.out.println(Thread.currentThread().getName() + " completed but waiting for children to complete");

        CompletableFuture.supplyAsync(() -> CompletableFeatureExample.getData(1)).thenAccept(System.out::println);

        IntStream.rangeClosed(1, 5).forEach(
                value -> CompletableFuture.supplyAsync(() -> CompletableFeatureExample.getData(value))
                        .exceptionally(throwable -> {
                            System.out.println("Input value " + value);
                            System.out.println(throwable.getMessage());
                            return 0;
                        })
                        .thenApply(i -> i * 10)
                        .thenApply(String::valueOf)
                        .thenApply(String::length)
                        .thenAccept(val -> {
                            System.out.println("Input value " + value);
                            System.out.println(val);
                        })
        );

        Thread.sleep(1000);
    }

    public static void simpleExampleWithExecutor() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        /*Runnable even = () -> task(i -> i % 2 == 0);
        Runnable odd = () -> task(i -> i % 2 != 0);
        Future<?> f1 = executorService.submit(even);
        f1.get();
        Future<?> f2 = executorService.submit(odd);
        f2.get();*/
        Future<Integer> future = executorService.submit(() -> CompletableFeatureExample.getData(1));
        System.out.println(future.get());
        System.out.println(Thread.currentThread().getName() + " completed but waiting for children to complete");
    }

    public static void handleExceptionInCompletableFeature() throws Exception {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> CompletableFeatureExample.getData(1))
                .handle((val, ex) -> {
                    if (ex != null) {
                        System.out.println(ex.getMessage());
                        return null;
                    } else {
                        System.out.println("Value: " + val);
                        return val;
                    }
                });
        System.out.println("Value from future: " + completableFuture.get());
    }

    public static void completableFeatureWithTimeout() {
        try {
            CompletableFuture<Integer> completableFuture = CompletableFuture
                    .supplyAsync(() -> CompletableFeatureExample.getData(1))
                    .completeOnTimeout(0, 500, TimeUnit.MILLISECONDS);
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void task(IntPredicate predicate) {
        IntStream.rangeClosed(1, 10).filter(predicate).forEach(CompletableFeatureExample::print);
    }

    private static void print(Integer val) {
        System.out.println(Thread.currentThread().getName() + " - " + val);
    }

    private static Integer getData(Integer val) {
        try {
            Thread.sleep(1000L);
            if (val == 3) {
                throw new RuntimeException("Error occurred at value " + val);
            }
            return val;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
