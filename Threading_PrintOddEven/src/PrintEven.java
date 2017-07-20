class PrintEven implements Runnable {

    int count = 0;
    private Object common;

    PrintEven(Object common) {
        this.common = common;
    }

    @Override
    public void run() {
        synchronized (common) {
            while (count < 100) {
                try {
                    common.notifyAll();
                    System.out.println(count += 2);
                    common.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
