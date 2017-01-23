package com.miui.support.util.async.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.miui.support.graphics.BitmapFactory;
import com.miui.support.net.http.HttpResponse;
import com.miui.support.util.async.Cacheable;

public class HttpBitmapTask extends HttpTask<Bitmap> implements Cacheable {
    private Options f3813a;

    public /* synthetic */ Object m5563h() {
        return m5564i();
    }

    public String m5562a() {
        return m5559d();
    }

    public int m5561a(Object obj) {
        if (obj instanceof Bitmap) {
            return ((Bitmap) obj).getByteCount();
        }
        return 0;
    }

    public Bitmap m5564i() {
        HttpResponse j = m5560j();
        FileBitmapTask.f3805a.acquireUninterruptibly();
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(j.m5096a(), null, this.f3813a);
            return decodeStream;
        } finally {
            j.m5100e();
            FileBitmapTask.f3805a.release();
        }
    }
}
