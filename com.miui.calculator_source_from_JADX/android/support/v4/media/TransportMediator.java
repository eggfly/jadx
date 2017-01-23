package android.support.v4.media;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;

public class TransportMediator extends TransportController {
    final TransportPerformer f513a;
    final Callback f514b;

    /* renamed from: android.support.v4.media.TransportMediator.1 */
    class C00461 implements TransportMediatorCallback {
        final /* synthetic */ TransportMediator f511a;

        public void m692a(KeyEvent keyEvent) {
            keyEvent.dispatch(this.f511a.f514b);
        }

        public void m690a(int i) {
            this.f511a.f513a.m701a(i);
        }

        public long m689a() {
            return this.f511a.f513a.m707d();
        }

        public void m691a(long j) {
            this.f511a.f513a.m702a(j);
        }
    }

    /* renamed from: android.support.v4.media.TransportMediator.2 */
    class C00472 implements Callback {
        final /* synthetic */ TransportMediator f512a;

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            return TransportMediator.m693a(i) ? this.f512a.f513a.m703a(i, keyEvent) : false;
        }

        public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
            return false;
        }

        public boolean onKeyUp(int i, KeyEvent keyEvent) {
            return TransportMediator.m693a(i) ? this.f512a.f513a.m705b(i, keyEvent) : false;
        }

        public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
            return false;
        }
    }

    static boolean m693a(int i) {
        switch (i) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 130:
                return true;
            default:
                return false;
        }
    }
}
