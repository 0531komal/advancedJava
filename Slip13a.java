public class Slip13a implements Runnable {
    public static void main(String[] args) {
        Slip13a tn = new Slip13a();
        Thread t1 = new Thread(tn);
        Thread t2 = new Thread(tn);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}