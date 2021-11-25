package multiThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue2 {
    int head = 0;
    int tail = 0;
    int[] que;
    int cap;
    AtomicInteger atomicInteger;

    public BoundedBlockingQueue2(int capacity) {
        atomicInteger = new AtomicInteger(0);
        cap = capacity;
        que = new int[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        while (atomicInteger.get()==cap) {}

        que[head]=element;
        head = (head+1)%cap;
        atomicInteger.incrementAndGet();
    }

    public int dequeue() throws InterruptedException {
        while (atomicInteger.get()==0){ }

        int i = que[tail];
        tail=(tail+1)%cap;
        atomicInteger.decrementAndGet();
        return i;
    }

    public int size() {
        return atomicInteger.get();
    }

}
