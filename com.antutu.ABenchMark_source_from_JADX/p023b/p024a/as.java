package p023b.p024a;

/* renamed from: b.a.as */
public abstract class as implements Runnable {
    public abstract void m3413a();

    public void run() {
        try {
            m3413a();
        } catch (Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }
}
