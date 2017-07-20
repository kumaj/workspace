class PrintOdd implements Runnable {
    int count = -1;
    private Object common;

    PrintOdd(Object common) {
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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}