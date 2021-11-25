package multiThread;

import javax.print.attribute.standard.MediaSize;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder2 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private volatile boolean oneDone = false;
    private volatile boolean twoDone = false;

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        oneDone = true;
        condition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!oneDone) {
                condition.await();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            twoDone = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!twoDone) {
                condition.await();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }finally {
            lock.unlock();
        }
    }
}
