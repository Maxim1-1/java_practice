package com.Maxim.multithreading;

public class Run {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread thread1 = new Thread(()->{
            foo.first();
        });
        Thread thread2 = new Thread(()->{
            try {
                thread1.join();
                foo.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3 = new Thread(()->{
            try {
                thread2.join();
                foo.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        thread2.start();
        thread1.start();
        thread3.start();

    }
}
