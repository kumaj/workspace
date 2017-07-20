
public class PrintNatural {

    public static void main(String args[]) {
        Object obj = new Object();
        Runnable r = new PrintOdd(obj);
        Thread printOdd = new Thread(r);

        Runnable r2 = new PrintEven(obj);
        Thread printEven = new Thread(r2);

        printOdd.start();
        printEven.start();

    }
}
