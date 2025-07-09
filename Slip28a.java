// public class Slip28a {
//     private int counter = 0;
//     public synchronized void increment() {
//         counter++;
//         System.out.println("Counter: " + counter);
//     }
//     public static void main(String[] args) {
//         Slip28a obj = new Slip28a();
//         Runnable task = obj::increment;
//         Thread t1 = new Thread(task);
//         Thread t2 = new Thread(task);
//         t1.start();
//         t2.start();
//         try {
//             t1.join();
//             t2.join();
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//         System.out.println("Final Counter value: " + obj.counter);
//     }
// }

class Table {
    synchronized void printTable(int n) {  
        for(int i = 1; i <= 5; i++) {   
            System.out.println(n * i);  
            try {   
                Thread.sleep(400);  
            } catch(Exception e) {   
                System.out.println(e);  
            }  
        }  
    }  
}  
class MyThread1 extends Thread {  
    Table t;  
    MyThread1(Table t) {  
        this.t = t;  
    }  
    public void run() {  
        t.printTable(5);  
    }  
}  
class MyThread2 extends Thread {  
    Table t;  
    MyThread2(Table t) {  
        this.t = t;  
    }  
    public void run() {  
        t.printTable(100);  
    }  
}  
public class Slip28a {  
    public static void main(String args[]) {  
        Table obj = new Table();  
        MyThread1 t1 = new MyThread1(obj);  
        MyThread2 t2 = new MyThread2(obj);  
        t1.start();  
        t2.start();  
    }  
}  