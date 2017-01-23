package com.miui.support.graphics;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.miui.support.util.AppConstants;
import java.util.regex.Pattern;

public class BitmapFactory extends android.graphics.BitmapFactory {
    static RenderScript f2005a;
    static Object f2006b;
    private static byte[] f2007c;
    private static final ThreadLocal<Canvas> f2008d;
    private static final Paint f2009e;
    private static final Pattern f2010f;
    private static final String[] f2011g;

    /* renamed from: com.miui.support.graphics.BitmapFactory.1 */
    final class C02501 extends ContextWrapper {
        C02501(Context context) {
            super(context);
        }

        public Context getApplicationContext() {
            return this;
        }
    }

    public static class CropOption {
    }

    private static native void native_fastBlur(Bitmap bitmap, Bitmap bitmap2, int i);

    static {
        f2006b = new Object();
        f2007c = new byte[]{(byte) -119, (byte) 80, (byte) 78, (byte) 71, (byte) 13, (byte) 10, (byte) 26, (byte) 10};
        if (VERSION.SDK_INT < 17) {
            System.loadLibrary("miuiimageutilities");
        }
        f2008d = new ThreadLocal();
        f2009e = new Paint(1);
        f2009e.setFilterBitmap(true);
        f2009e.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        f2010f = Pattern.compile("[\u3100-\u312d\u31a0-\u31ba\u4e00-\u9fcc\u3400-\u4db5\uf900-\ufad9\u2f00-\u2fd5\u2e80-\u2ef3\u31c0-\u31e3\u1100-\u11ff\ua960-\ua97c\ud7b0-\ud7fb\u3131-\u318e\uac00-\ud7a3\u3040-\u309f\u30a0-\u30ff\u31f0-\u31ff\u3190-\u319f\ua000-\ua48c\ua490-\ua4c6]");
        f2011g = new String[]{"\u8001\u5e08", "\u5148\u751f", "\u8001\u677f", "\u4ed4", "\u624b\u673a", "\u53d4", "\u963f\u59e8", "\u5b85", "\u4f2f", "\u4f2f\u6bcd", "\u4f2f\u7236", "\u54e5", "\u59d0", "\u5f1f", "\u59b9", "\u8205", "\u59d1", "\u7236", "\u4e3b\u4efb", "\u7ecf\u7406", "\u5de5\u4f5c", "\u540c\u4e8b", "\u5f8b\u5e08", "\u53f8\u673a", "\u5e08\u5085", "\u5e08\u7236", "\u7237", "\u5976", "\u4e2d\u4ecb", "\u8463", "\u603b", "\u592a\u592a", "\u4fdd\u59c6", "\u67d0", "\u79d8\u4e66", "\u5904\u957f", "\u5c40\u957f", "\u73ed\u957f", "\u5144", "\u52a9\u7406"};
    }

    protected BitmapFactory() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static Bitmap m3486a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Config config = Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        m3487a(bitmap, createBitmap);
        return createBitmap;
    }

    public static Bitmap m3487a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        if (bitmap.getWidth() == bitmap2.getWidth() && bitmap.getHeight() == bitmap2.getHeight()) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), paint);
        return bitmap2;
    }

    private static Bitmap m3484a(Bitmap bitmap) {
        Config config = Config.ARGB_8888;
        if (bitmap.getConfig() != null) {
            config = bitmap.getConfig();
        }
        return Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
    }

    public static Bitmap m3485a(Bitmap bitmap, int i) {
        Bitmap a = m3484a(bitmap);
        m3488a(bitmap, a, i);
        return a;
    }

    public static Bitmap m3488a(Bitmap bitmap, Bitmap bitmap2, int i) {
        if (bitmap == null) {
            return null;
        }
        if (!(bitmap2 != null && bitmap.getWidth() == bitmap2.getWidth() && bitmap.getHeight() == bitmap2.getHeight())) {
            bitmap2 = m3484a(bitmap);
        }
        if (VERSION.SDK_INT >= 17) {
            m3489b(bitmap, bitmap2, i);
            return bitmap2;
        }
        native_fastBlur(bitmap, bitmap2, i);
        return bitmap2;
    }

    private static Bitmap m3489b(Bitmap bitmap, Bitmap bitmap2, int i) {
        Bitmap bitmap3;
        Context c02501;
        int i2 = 1;
        while (i > 25) {
            i /= 2;
            i2 *= 2;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i2 == 1) {
            bitmap3 = bitmap;
        } else {
            bitmap3 = m3486a(bitmap, Math.max(width / i2, 1), Math.max(height / i2, 1));
        }
        Context a = AppConstants.m4227a();
        if (a.getApplicationContext() == null) {
            c02501 = new C02501(a);
        } else {
            c02501 = a;
        }
        synchronized (f2006b) {
            Bitmap bitmap4;
            if (f2005a == null) {
                f2005a = RenderScript.create(c02501);
            }
            if (i2 == 1) {
                bitmap4 = bitmap2;
            } else {
                bitmap4 = bitmap3;
            }
            if (bitmap3.getRowBytes() != bitmap4.getRowBytes()) {
                bitmap3 = bitmap3.copy(Config.ARGB_8888, true);
            }
            Allocation createFromBitmap = Allocation.createFromBitmap(f2005a, bitmap3);
            Allocation createTyped = Allocation.createTyped(f2005a, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(f2005a, Element.U8_4(f2005a));
            create.setRadius((float) i);
            create.setInput(createFromBitmap);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap4);
            if (bitmap4 != bitmap2) {
                m3487a(bitmap4, bitmap2);
            }
            if (bitmap3 != bitmap) {
                bitmap3.recycle();
            }
            if (bitmap4 != bitmap2) {
                bitmap4.recycle();
            }
        }
        return bitmap2;
    }
}
