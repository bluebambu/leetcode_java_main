package multiThread;

public class deadlock {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public int a = 0;
    public int b = 0;

    public void add(int i) {
        synchronized (lock1) {
            a += i;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                b += 1;
            }
        }
    }

    public void dec(int i) {
        synchronized (lock2) {
            a -= i;
            synchronized (lock1) {
                b -= 1;
            }
        }
    }

    public static void main(String[] args) {
        deadlock d = new deadlock();
        new Thread(()->{
            d.add(1);
        }).start();
        new Thread(()->{
            d.dec(1);
        }).start();
    }
}
