package org.getech.henry.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallbackExample {

    private final CompletableFuture<String> future = new CompletableFuture<>();

    public void getData() {
        future.thenAccept(data -> System.out.println("Received data: " + data));
    }

    public void setData(String data) {
        future.complete(data);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallbackExample example = new CallbackExample();

        Thread t1 = new Thread(example::getData);
        t1.start();

        Thread t3 = new Thread(example::getData);
        t3.start();

        // Simulate some delay
        Thread.sleep(2000);

        System.out.println("-----1---");
        Thread t2 = new Thread(() -> example.setData("hello,world!"));
        t2.start();

        // Simulate some delay
        Thread.sleep(5000);
        System.out.println("-----2---");

        Thread t4 = new Thread(() -> example.setData("hello,world!"));
        t4.start();

    }
}
