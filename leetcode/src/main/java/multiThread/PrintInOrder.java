package multiThread;


public class PrintInOrder {
    private volatile boolean isOneDone = false;
    private volatile boolean isTwoDone = false;

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (this) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();

            isOneDone = true;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!isOneDone) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();

            isTwoDone = true;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (!isTwoDone) {
                this.wait();
            }
        }

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
