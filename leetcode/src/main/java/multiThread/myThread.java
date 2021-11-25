package multiThread;

public class myThread {
    public static void main(String[] args) throws InterruptedException {
        /**
         *               0
         *         1           2
         *     3            4
         */

        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums2 = {2, 3, 1, 2, 4, 3};
        int[] nums3 = {1, 2, 3, 4, 5};
        String s = "wreiuy/.,ASDFE";

        thread1 thread1 = new thread1();
        thread1.run();
        thread1.start();
        thread1 thread2 = new thread1();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main thread");
    }

    public static class thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("new thread");
        }
    }
}
