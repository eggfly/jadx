package com.miui.support.util.async.tasks;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.miui.support.graphics.BitmapFactory;
import com.miui.support.util.async.Cacheable;

public class DatabaseBitmapTask extends ContentResolverQueryTask<Bitmap> implements Cacheable {
    private Options f3804a;

    public /* synthetic */ Object m5552h() {
        return m5553l();
    }

    public Bitmap m5553l() {
        Bitmap bitmap = null;
        Cursor j = m5543j();
        if (j != null) {
            try {
                if (j.moveToNext()) {
                    byte[] blob = j.getBlob(0);
                    if (blob != null) {
                        FileBitmapTask.f3805a.acquireUninterruptibly();
                        bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length, this.f3804a);
                        FileBitmapTask.f3805a.release();
                        if (j != null) {
                            j.close();
                        }
                    } else if (j != null) {
                        j.close();
                    }
                    return bitmap;
                }
            } catch (Throwable th) {
                if (j != null) {
                    j.close();
                }
            }
        }
        if (j != null) {
            j.close();
        }
        return bitmap;
    }

    public String m5551a() {
        return m5541d();
    }

    public int m5550a(Object obj) {
        if (obj instanceof Bitmap) {
            return ((Bitmap) obj).getByteCount();
        }
        return 0;
    }
}
