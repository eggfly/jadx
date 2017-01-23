package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.internal.C2472h;
import com.facebook.ads.internal.p121f.C2451e;
import com.facebook.ads.internal.p122b.C2340c;

/* renamed from: com.facebook.ads.internal.util.k */
public class C2502k extends AsyncTask<String, Void, Bitmap[]> {
    private static final String f8594a;
    private final Context f8595b;
    private final ImageView f8596c;
    private final C2451e f8597d;
    private C2315l f8598e;

    static {
        f8594a = C2502k.class.getSimpleName();
    }

    public C2502k(ImageView imageView) {
        this.f8595b = imageView.getContext();
        this.f8597d = null;
        this.f8596c = imageView;
    }

    public C2502k(C2451e c2451e) {
        this.f8595b = c2451e.getContext();
        this.f8597d = c2451e;
        this.f8596c = null;
    }

    public C2502k m9500a(C2315l c2315l) {
        this.f8598e = c2315l;
        return this;
    }

    protected void m9501a(Bitmap[] bitmapArr) {
        if (this.f8596c != null) {
            this.f8596c.setImageBitmap(bitmapArr[0]);
        }
        if (this.f8597d != null) {
            this.f8597d.m9348a(bitmapArr[0], bitmapArr[1]);
        }
        if (this.f8598e != null) {
            this.f8598e.m8820a();
        }
    }

    public void m9502a(String... strArr) {
        if (C2472h.m9400b(this.f8595b)) {
            executeOnExecutor(THREAD_POOL_EXECUTOR, strArr);
        } else {
            execute(strArr);
        }
    }

    protected Bitmap[] m9503b(String... strArr) {
        Bitmap a;
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        String str;
        String str2 = null;
        String str3 = strArr[0];
        try {
            a = C2340c.m9025a(this.f8595b).m9028a(str3);
            try {
                if (!(this.f8597d == null || a == null)) {
                    try {
                        C2509q c2509q = new C2509q(a);
                        c2509q.m9515a(Math.round(((float) a.getWidth()) / 40.0f));
                        str2 = c2509q.m9514a();
                    } catch (Throwable th2) {
                        th = th2;
                        obj = a;
                        Log.e(f8594a, "Error downloading image: " + str3, th);
                        C2490c.m9456a(C2489b.m9453a(th, str2));
                        obj2 = a;
                        obj3 = str;
                        return new Bitmap[]{a, str2};
                    }
                }
            } catch (Throwable th22) {
                th = th22;
                obj = a;
                obj3 = str2;
                Log.e(f8594a, "Error downloading image: " + str3, th);
                C2490c.m9456a(C2489b.m9453a(th, str2));
                obj2 = a;
                obj3 = str;
                return new Bitmap[]{a, str2};
            }
        } catch (Throwable th3) {
            th = th3;
            str = str2;
            a = str2;
            Log.e(f8594a, "Error downloading image: " + str3, th);
            C2490c.m9456a(C2489b.m9453a(th, str2));
            obj2 = a;
            obj3 = str;
            return new Bitmap[]{a, str2};
        }
        return new Bitmap[]{a, str2};
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9503b((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m9501a((Bitmap[]) obj);
    }
}
