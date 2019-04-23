public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable run(), name:" + Thread.currentThread().getName());
    }
}
