package com.facebook.ads.internal.p127e.p129b.p130a;

import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.internal.e.b.a.e */
abstract class C2383e implements C2375a {
    private final ExecutorService f8276a;

    /* renamed from: com.facebook.ads.internal.e.b.a.e.a */
    private class C2382a implements Callable<Void> {
        final /* synthetic */ C2383e f8274a;
        private final File f8275b;

        public C2382a(C2383e c2383e, File file) {
            this.f8274a = c2383e;
            this.f8275b = file;
        }

        public Void m9167a() {
            this.f8274a.m9171b(this.f8275b);
            return null;
        }

        public /* synthetic */ Object call() {
            return m9167a();
        }
    }

    C2383e() {
        this.f8276a = Executors.newSingleThreadExecutor();
    }

    private void m9169a(List<File> list) {
        long b = m9170b((List) list);
        int size = list.size();
        int i = size;
        for (File file : list) {
            if (!m9173a(file, b, i)) {
                long length = file.length();
                if (file.delete()) {
                    i--;
                    b -= length;
                    Log.i("ProxyCache", "Cache file " + file + " is deleted because it exceeds cache limit");
                    size = i;
                    i = size;
                } else {
                    Log.e("ProxyCache", "Error deleting file " + file + " for trimming cache");
                }
            }
            size = i;
            i = size;
        }
    }

    private long m9170b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j = length.length() + j;
        }
        return j;
    }

    private void m9171b(File file) {
        C2381d.m9164c(file);
        m9169a(C2381d.m9163b(file.getParentFile()));
    }

    public void m9172a(File file) {
        this.f8276a.submit(new C2382a(this, file));
    }

    protected abstract boolean m9173a(File file, long j, int i);
}
