package multiThread;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Timer;

public class MultiThrdPQTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> producers = new ArrayList<>();
        ArrayList<Thread> consumers = new ArrayList<>();

        PriorityQueue<String> que = new PriorityQueue<>();

        int pn = 5, cn = 5;
        for (int i = 0; i < pn; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                while (true) {
                    String s = "produce #" + finalI + " ts:" + System.currentTimeMillis();
                    synchronized (que) {
                        que.add(s);
                        que.notify();
                        System.out.println(s);
                    }
                    try {
                        Thread.sleep(new Random(3).nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            producers.add(t);
        }

        for (int i = 0; i < cn; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {
                while (true) {
                    System.out.println(que.size());
                    synchronized (que) {
                        while (que.size() == 0) {
                            try {
                                que.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        String poll = que.poll();
                        System.out.println("Consume: " + poll);
                    }
                    try {
                        Thread.sleep(new Random(3).nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            producers.add(t);
        }

        for (int i = 0; i < pn; i++) {
            producers.get(i).join();
        }

        for (int i = 0; i < cn; i++) {
            consumers.get(i).join();
        }
    }
}
