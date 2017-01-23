package com.miui.support.util.async.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.miui.support.util.AppConstants;
import com.miui.support.util.async.Cacheable;
import com.miui.support.util.async.Task;

public class ResourceBitmapTask extends Task<Bitmap> implements Cacheable {
    private String f3819a;
    private int f3820b;
    private Options f3821c;

    public /* synthetic */ Object m5577h() {
        return m5578i();
    }

    public String m5576d() {
        if (this.f3819a == null) {
            this.f3819a = "resource_" + this.f3820b;
        }
        return this.f3819a;
    }

    public Bitmap m5578i() {
        FileBitmapTask.f3805a.acquireUninterruptibly();
        try {
            Bitmap decodeResource = BitmapFactory.decodeResource(AppConstants.m4227a().getResources(), this.f3820b, this.f3821c);
            return decodeResource;
        } finally {
            FileBitmapTask.f3805a.release();
        }
    }

    public String m5575a() {
        return m5576d();
    }

    public int m5574a(Object obj) {
        if (obj instanceof Bitmap) {
            return ((Bitmap) obj).getByteCount();
        }
        return 0;
    }
}
