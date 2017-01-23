package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

public abstract class TransportPerformer {
    public abstract void m700a();

    public abstract void m702a(long j);

    public abstract void m704b();

    public abstract void m706c();

    public abstract long m707d();

    public abstract boolean m708e();

    public boolean m703a(int i, KeyEvent keyEvent) {
        switch (i) {
            case 79:
            case 85:
                if (!m708e()) {
                    m700a();
                    break;
                }
                m704b();
                break;
            case 86:
                m706c();
                break;
            case 126:
                m700a();
                break;
            case 127:
                m704b();
                break;
        }
        return true;
    }

    public boolean m705b(int i, KeyEvent keyEvent) {
        return true;
    }

    public void m701a(int i) {
        int i2 = 0;
        switch (i) {
            case -1:
                i2 = 127;
                break;
        }
        if (i2 != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            m703a(i2, new KeyEvent(uptimeMillis, uptimeMillis, 0, i2, 0));
            m705b(i2, new KeyEvent(uptimeMillis, uptimeMillis, 1, i2, 0));
        }
    }
}
