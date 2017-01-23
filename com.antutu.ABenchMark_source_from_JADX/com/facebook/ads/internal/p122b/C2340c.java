package com.facebook.ads.internal.p122b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.facebook.ads.internal.p127e.p128a.C2360a;
import com.facebook.ads.internal.p127e.p128a.C2373n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* renamed from: com.facebook.ads.internal.b.c */
public class C2340c {
    private static final String f8150a;
    private static C2340c f8151b;
    private final Context f8152c;

    static {
        f8150a = C2340c.class.getSimpleName();
    }

    private C2340c(Context context) {
        this.f8152c = context;
    }

    public static C2340c m9025a(Context context) {
        if (f8151b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f8151b == null) {
                    f8151b = new C2340c(applicationContext);
                }
            }
        }
        return f8151b;
    }

    private Bitmap m9026b(String str) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring("file://".length())), null, null);
            m9029a(str, decodeStream);
            return decodeStream;
        } catch (Throwable e) {
            Log.e(f8150a, "Failed to copy local image into cache (url=" + str + ").", e);
            return null;
        }
    }

    private Bitmap m9027c(String str) {
        C2373n a = new C2360a(this.f8152c).m9096a(str, null);
        if (a == null || a.m9137d() == null) {
            return null;
        }
        byte[] d = a.m9137d();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length);
        m9029a(str, decodeByteArray);
        return decodeByteArray;
    }

    public Bitmap m9028a(String str) {
        File file = new File(this.f8152c.getCacheDir(), str.hashCode() + ".png");
        return !file.exists() ? str.startsWith("file://") ? m9026b(str) : m9027c(str) : BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public void m9029a(String str, Bitmap bitmap) {
        File file = new File(this.f8152c.getCacheDir(), str.hashCode() + ".png");
        try {
            OutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable e) {
            Log.e(f8150a, "Bad output destination (file=" + file.getAbsolutePath() + ").", e);
        } catch (Throwable e2) {
            Log.e(f8150a, "Unable to write bitmap to file (url=" + str + ").", e2);
        }
    }
}
