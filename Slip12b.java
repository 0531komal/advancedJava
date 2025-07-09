public class Slip12b implements Runnable {
    private String name;

    public Slip12b(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is created.");

            int sleepTime = (int) (Math.random() * 5000);
            System.out.println(name + " will sleep for " + sleepTime + " milliseconds.");

            Thread.sleep(sleepTime);

            System.out.println(name + " is now dead.");
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Slip12b("Thread-1"));
        Thread t2 = new Thread(new Slip12b("Thread-2"));

        t1.start();
        t2.start();
    }
}