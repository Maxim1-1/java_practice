package com.Maxim.multithreading;

public class Run {
    public static void main(String[] args) {


        Foo foo = new Foo();
        Thread thread1 = new Thread(() -> {
            foo.first();
        });
        Thread thread2 = new Thread(() -> {
            foo.second();
        });
        Thread thread3 = new Thread(() -> {
            foo.third();
        });


        thread2.start();
        thread1.start();
        thread3.start();

    }
}
