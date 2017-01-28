class ew$1 extends Thread {
    ew$1(String str) {
        super(str);
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                synchronized (ew.DW) {
                    ew.j6 = System.currentTimeMillis();
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
