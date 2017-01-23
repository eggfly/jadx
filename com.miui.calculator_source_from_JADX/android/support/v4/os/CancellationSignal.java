package android.support.v4.os;

import android.os.Build.VERSION;

public final class CancellationSignal {
    private boolean f631a;
    private OnCancelListener f632b;
    private Object f633c;
    private boolean f634d;

    public interface OnCancelListener {
        void m1000a();
    }

    public boolean m1001a() {
        boolean z;
        synchronized (this) {
            z = this.f631a;
        }
        return z;
    }

    public void m1002b() {
        if (m1001a()) {
            throw new OperationCanceledException();
        }
    }

    public void m1003c() {
        synchronized (this) {
            if (this.f631a) {
                return;
            }
            this.f631a = true;
            this.f634d = true;
            OnCancelListener onCancelListener = this.f632b;
            Object obj = this.f633c;
            if (onCancelListener != null) {
                try {
                    onCancelListener.m1000a();
                } catch (Throwable th) {
                    synchronized (this) {
                    }
                    this.f634d = false;
                    notifyAll();
                }
            }
            if (obj != null) {
                CancellationSignalCompatJellybean.m1006a(obj);
            }
            synchronized (this) {
                this.f634d = false;
                notifyAll();
            }
        }
    }

    public Object m1004d() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.f633c == null) {
                this.f633c = CancellationSignalCompatJellybean.m1005a();
                if (this.f631a) {
                    CancellationSignalCompatJellybean.m1006a(this.f633c);
                }
            }
            obj = this.f633c;
        }
        return obj;
    }
}
