package p000a.p001a.p007f;

import java.io.File;
import java.io.IOException;

/* renamed from: a.a.f.a */
public interface C0085a {
    public static final C0085a f330a;

    /* renamed from: a.a.f.a.1 */
    static class C00861 implements C0085a {
        C00861() {
        }

        public void m377a(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public void m378a(File file, File file2) {
            m377a(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public boolean m379b(File file) {
            return file.exists();
        }

        public long m380c(File file) {
            return file.length();
        }
    }

    static {
        f330a = new C00861();
    }

    void m373a(File file);

    void m374a(File file, File file2);

    boolean m375b(File file);

    long m376c(File file);
}
