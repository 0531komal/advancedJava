public class Slip21a implements Runnable {
    public static void main(String[] args) {
        Slip21a tn = new Slip21a();
        Thread t1 = new Thread(tn);
        Thread t2 = new Thread(tn);
        Thread t3 = new Thread(tn);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.start();
        t3.setPriority(Thread.MIN_PRIORITY);
        t3.start();      
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        System.out.println("Thread Name: " + current.getName());
        System.out.println("Thread Priority: " + current.getPriority());
    }
}