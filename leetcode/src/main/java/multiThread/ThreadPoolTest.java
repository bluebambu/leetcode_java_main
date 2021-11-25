package multiThread;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.*;


public class ThreadPoolTest {
    public static BlockingQueue<Runnable> que3 = new SynchronousQueue<>();
    public static BlockingQueue<Runnable> que2 = new LinkedBlockingQueue<>(4);
    public static BlockingQueue<Runnable> que = que3;

    public static class Task implements Runnable {
        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("start task " + name + ". cur que sz: " + que.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("end task " + name + ". cur que sz: " + que.size());
        }
    }
    public static void main(String[] args) {
        // 创建一个固定大小的线程池:
        ExecutorService es = new ThreadPoolExecutor(4, 12,
                60L, TimeUnit.MINUTES,  que);
        for (int i = 0; i < 16; i++) {
            Future<?> submit = es.submit(new Task("" + i));
            try {
                Object o = submit.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("enque. cur size: " + que.size());
        }
        // 关闭线程池:
        es.shutdown();
    }
}

