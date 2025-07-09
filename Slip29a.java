// public class Slip29a{
//     public static void main(String args[]){
//         int n = 10;
//         Thread oddThread = new Thread(new oddNumberPrinter(n));
//         Thread primeThread = new Thread(new primeNumberPrinter(n));
//         oddThread.start();
//         primeThread.start();
//     }

//     static class oddNumberPrinter implements Runnable{
//         private final int n;

//         public oddNumberPrinter(int n){
//             this.n = n;
//         }

//         public void run(){
//             System.out.println("odd numbers between 1 to " + n + ": ");
//             for(int i=1; i<=n; i+=2){
//                 System.out.print(i + " ");
//             }
//             System.out.println();
//         }
//     }

//     static class primeNumberPrinter implements Runnable{
//         private final int n;

//         public primeNumberPrinter(int n){
//             this.n = n;
//         }

//         public void run(){
//             System.out.println("prime numbers between 1 to " + n + ": ");
//             for(int i=2; i<=n; i++){
//                 if(isPrime(i)){
//                     System.out.print(i + " ");
//                 }
//             }
//             System.out.println();
//         }

//         private boolean isPrime(int num){
//             if (num <= 1){
//                 return false;
//             }
//             for(int i=2; i<=Math.sqrt(num); i++){
//                 if(num % i == 0){
//                     return false;
//                 }
//             }
//             return true;
//         }
//     }
// }

class NumberPrinter {
    synchronized void printOddNumbers(int n) {
        System.out.println("Odd numbers between 1 to " + n + ": ");
        for (int i = 1; i <= n; i += 2) {
            System.out.print(i + " ");
            try {
                Thread.sleep(300); // Small delay to simulate processing
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }

    synchronized void printPrimeNumbers(int n) {
        System.out.println("Prime numbers between 1 to " + n + ": ");
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(300); // Small delay to simulate processing
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println();
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

class OddThread extends Thread {
    NumberPrinter printer;
    int n;

    OddThread(NumberPrinter printer, int n) {
        this.printer = printer;
        this.n = n;
    }

    public void run() {
        printer.printOddNumbers(n);
    }
}

class PrimeThread extends Thread {
    NumberPrinter printer;
    int n;

    PrimeThread(NumberPrinter printer, int n) {
        this.printer = printer;
        this.n = n;
    }

    public void run() {
        printer.printPrimeNumbers(n);
    }
}

public class Slip29a {
    public static void main(String args[]) {
        int n = 20; // Set n value as needed
        NumberPrinter obj = new NumberPrinter();

        OddThread t1 = new OddThread(obj, n);
        PrimeThread t2 = new PrimeThread(obj, n);

        t1.start();
        t2.start();
    }
}