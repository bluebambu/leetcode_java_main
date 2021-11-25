package multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    int head = 0;
    int tail = 0;
    int size = 0;
    int[] que;

    public BoundedBlockingQueue(int capacity) {
        que = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size == que.length) {
                full.await();
            }

            que[head] = element;
            head = (head+1)%(que.length);
            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                empty.await();
            }

            int res = que[tail];
            tail = (tail+1)%(que.length);
            size --;
            full.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }

}
