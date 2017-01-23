package com.miui.support.util.async.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.miui.support.graphics.BitmapFactory;
import com.miui.support.util.async.Cacheable;
import com.miui.support.util.async.Task;
import java.util.concurrent.Semaphore;

public class FileBitmapTask extends Task<Bitmap> implements Cacheable {
    static final Semaphore f3805a;
    private String f3806b;
    private Options f3807c;

    public /* synthetic */ Object m5557h() {
        return m5558i();
    }

    static {
        f3805a = new Semaphore(2);
    }

    public String m5556d() {
        return this.f3806b;
    }

    public Bitmap m5558i() {
        f3805a.acquireUninterruptibly();
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.f3806b, this.f3807c);
            return decodeFile;
        } finally {
            f3805a.release();
        }
    }

    public String m5555a() {
        return this.f3806b;
    }

    public int m5554a(Object obj) {
        if (obj instanceof Bitmap) {
            return ((Bitmap) obj).getByteCount();
        }
        return 0;
    }
}
