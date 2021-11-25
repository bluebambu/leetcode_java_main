package multiThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder3 {
    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s1.release();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        s2.release();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrder3 p = new PrintInOrder3();
        p.first(()->{});
    }
}
