package com.Maxim.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {

    ReentrantLock lock = new ReentrantLock();

    Condition secondCondition = lock.newCondition();
    Condition thirdCondition = lock.newCondition();
    private boolean isFirstExecuted = false;
    private boolean isSecondExecuted = false;


    public void first() {
        lock.lock();
        try {
            System.out.print("first");
            isFirstExecuted = true;
            secondCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second() {
        lock.lock();
        try {
            while (!isFirstExecuted) {
                secondCondition.await();
            }
            System.out.print("second");
            isSecondExecuted = true;
            thirdCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void third() {
        lock.lock();
        try {
            while (!isSecondExecuted){
                thirdCondition.await();
            }
            System.out.print("third");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }


}
