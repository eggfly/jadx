package com.miui.support.internal.graphics.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.io.ResettableInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DecodeGifImageHelper {
    public long f2369a;
    public List<GifFrame> f2370b;
    public int f2371c;
    private int f2372d;
    private DecodeGifFrames f2373e;

    /* renamed from: com.miui.support.internal.graphics.gif.DecodeGifImageHelper.1 */
    class C02811 extends Handler {
        final /* synthetic */ DecodeGifImageHelper f2363a;

        public void handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (this.f2363a.m3967a(this.f2363a.f2373e.m3960a())) {
                        this.f2363a.m3966a();
                    }
                default:
            }
        }
    }

    public static class GifDecodeResult {
        public GifDecoder f2364a;
        public boolean f2365b;
    }

    public static class GifFrame {
        public Bitmap f2366a;
        public int f2367b;
        public int f2368c;

        public GifFrame(Bitmap bitmap, int i, int i2) {
            this.f2366a = bitmap;
            this.f2367b = i;
            this.f2368c = i2;
        }
    }

    public DecodeGifImageHelper() {
        this.f2369a = 1048576;
        this.f2370b = new ArrayList();
    }

    private int m3965b() {
        return ((GifFrame) this.f2370b.get(this.f2370b.size() - 1)).f2368c;
    }

    private int m3962a(int i) {
        return this.f2371c == 0 ? i : i % this.f2371c;
    }

    public void m3966a() {
        Object obj = 1;
        int size = this.f2370b.size();
        if (this.f2372d <= 3) {
            if (size > 2) {
                obj = null;
            }
        } else if (size > this.f2372d / 2) {
            obj = null;
        }
        if (obj != null) {
            this.f2373e.m3961a(m3962a(m3965b() + 1));
        }
    }

    public boolean m3967a(GifDecodeResult gifDecodeResult) {
        int i = 0;
        if (!gifDecodeResult.f2365b || gifDecodeResult.f2364a == null) {
            return false;
        }
        GifDecoder gifDecoder = gifDecodeResult.f2364a;
        Log.d("dumpFrameIndex", String.format("Thread#%d: decoded %d frames [%s] [%d]", new Object[]{Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(gifDecodeResult.f2364a.m3975c()), Boolean.valueOf(gifDecodeResult.f2365b), Integer.valueOf(this.f2371c)}));
        if (gifDecoder.m3972a()) {
            this.f2371c = gifDecoder.m3984j();
        }
        int c = gifDecoder.m3975c();
        if (c <= 0) {
            return true;
        }
        int b = m3965b();
        while (i < c) {
            this.f2370b.add(new GifFrame(gifDecoder.m3976c(i), gifDecoder.m3973b(i), m3962a((b + 1) + i)));
            i++;
        }
        return true;
    }

    public static GifDecodeResult m3964a(ResettableInputStream resettableInputStream, long j, int i) {
        boolean z = false;
        GifDecodeResult gifDecodeResult = new GifDecodeResult();
        gifDecodeResult.f2364a = null;
        gifDecodeResult.f2365b = false;
        try {
            resettableInputStream.reset();
            gifDecodeResult.f2364a = new GifDecoder();
            GifDecoder gifDecoder = gifDecodeResult.f2364a;
            gifDecoder.m3970a(i);
            gifDecoder.m3971a(j);
            if (gifDecoder.m3969a((InputStream) resettableInputStream) == 0) {
                z = true;
            }
            gifDecodeResult.f2365b = z;
            try {
                resettableInputStream.close();
            } catch (IOException e) {
            }
            return gifDecodeResult;
        } catch (IOException e2) {
            return gifDecodeResult;
        }
    }
}
