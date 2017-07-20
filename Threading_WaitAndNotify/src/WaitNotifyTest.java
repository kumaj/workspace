// Test class that will create multiple threads of Waiter and Notifier and start them.
public class WaitNotifyTest {

    public static void main(String[] args) {
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter_0").start();
        
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter_1").start();
        
        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        //System.out.println("All the threads are started");
    }
}
