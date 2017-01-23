package p000a.p001a.p004e;

import java.util.List;
import okio.BufferedSource;

/* renamed from: a.a.e.m */
public interface C0081m {
    public static final C0081m f326a;

    /* renamed from: a.a.e.m.1 */
    static class C00821 implements C0081m {
        C00821() {
        }

        public void m359a(int i, C0048b c0048b) {
        }

        public boolean m360a(int i, List<C0049c> list) {
            return true;
        }

        public boolean m361a(int i, List<C0049c> list, boolean z) {
            return true;
        }

        public boolean m362a(int i, BufferedSource bufferedSource, int i2, boolean z) {
            bufferedSource.skip((long) i2);
            return true;
        }
    }

    static {
        f326a = new C00821();
    }

    void m355a(int i, C0048b c0048b);

    boolean m356a(int i, List<C0049c> list);

    boolean m357a(int i, List<C0049c> list, boolean z);

    boolean m358a(int i, BufferedSource bufferedSource, int i2, boolean z);
}
