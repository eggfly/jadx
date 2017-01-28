import android.os.CancellationSignal;

class f {
    public static Object j6() {
        return new CancellationSignal();
    }

    public static void j6(Object obj) {
        ((CancellationSignal) obj).cancel();
    }
}
