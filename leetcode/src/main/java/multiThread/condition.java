package multiThread;

import com.google.common.base.Supplier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class condition {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await(); // lock is released here, and re-fetched when returned from wait().
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        multiThread.condition condition = new condition();
        Supplier<Thread> sup = () -> new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        String task = condition.getTask();
                        System.out.println("thread: " + Thread.currentThread().getName() + " task: " + task);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(sup.get());
            threads.get(threads.size()-1).start();
        }

        for(int i=0; i<100; i++){
            condition.addTask("task: " + i);
        }


        for (int i = 0; i < 10; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(condition.queue.size());
    }
}
