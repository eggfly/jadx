import android.os.SystemClock;

public final class afs implements afq {
    private static afs j6;

    public static synchronized afq Hw() {
        afq afq;
        synchronized (afs.class) {
            if (j6 == null) {
                j6 = new afs();
            }
            afq = j6;
        }
        return afq;
    }

    public long DW() {
        return SystemClock.elapsedRealtime();
    }

    public long FH() {
        return System.nanoTime();
    }

    public long j6() {
        return System.currentTimeMillis();
    }
}
