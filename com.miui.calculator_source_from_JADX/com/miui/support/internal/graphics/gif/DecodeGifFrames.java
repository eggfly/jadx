package com.miui.support.internal.graphics.gif;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.miui.support.internal.graphics.gif.DecodeGifImageHelper.GifDecodeResult;
import com.miui.support.io.ResettableInputStream;

class DecodeGifFrames extends Handler {
    GifDecodeResult f2358a;
    HandlerThread f2359b;
    private Handler f2360c;
    private ResettableInputStream f2361d;
    private long f2362e;

    protected void finalize() {
        this.f2359b.quit();
        super.finalize();
    }

    public void m3961a(int i) {
        if (this.f2358a == null) {
            this.f2358a = new GifDecodeResult();
            sendMessage(obtainMessage(1, i, 0));
        }
    }

    public GifDecodeResult m3960a() {
        GifDecodeResult gifDecodeResult = this.f2358a;
        this.f2358a = null;
        return gifDecodeResult;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            GifDecodeResult a = DecodeGifImageHelper.m3964a(this.f2361d, this.f2362e, message.arg1);
            this.f2358a.f2364a = a.f2364a;
            this.f2358a.f2365b = a.f2365b;
            this.f2360c.sendEmptyMessage(1);
        }
    }
}
