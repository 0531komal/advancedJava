public class Slip15a implements Runnable {
    @Override
    public void run() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println(c);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Slip15a());
        t.start();
    }
}