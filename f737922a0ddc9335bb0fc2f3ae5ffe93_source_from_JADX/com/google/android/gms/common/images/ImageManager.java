package com.google.android.gms.common.images;

import agb;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.internal.hi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import p;

public final class ImageManager {
    private static HashSet<Uri> DW;
    private static final Object j6;
    private final Context FH;
    private final Handler Hw;
    private final hi VH;
    private final zzb Zo;
    private final Map<a, ImageReceiver> gn;
    private final Map<Uri, Long> tp;
    private final Map<Uri, ImageReceiver> u7;
    private final ExecutorService v5;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri DW;
        private final ArrayList<a> FH;
        final /* synthetic */ ImageManager j6;

        public void onReceiveResult(int i, Bundle bundle) {
            this.j6.v5.execute(new c(this.j6, this.DW, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface a {
        void j6(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class b {
        static int j6(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class c implements Runnable {
        private final Uri DW;
        private final ParcelFileDescriptor FH;
        final /* synthetic */ ImageManager j6;

        public c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.j6 = imageManager;
            this.DW = uri;
            this.FH = parcelFileDescriptor;
        }

        public void run() {
            i.DW("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.FH != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.FH.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf = String.valueOf(this.DW);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.FH.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.j6.Hw.post(new d(this.j6, this.DW, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.DW);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class d implements Runnable {
        private final Uri DW;
        private final Bitmap FH;
        private final CountDownLatch Hw;
        final /* synthetic */ ImageManager j6;
        private boolean v5;

        public d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.j6 = imageManager;
            this.DW = uri;
            this.FH = bitmap;
            this.v5 = z;
            this.Hw = countDownLatch;
        }

        private void j6(ImageReceiver imageReceiver, boolean z) {
            ArrayList j6 = imageReceiver.FH;
            int size = j6.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) j6.get(i);
                if (z) {
                    aVar.j6(this.j6.FH, this.FH, false);
                } else {
                    this.j6.tp.put(this.DW, Long.valueOf(SystemClock.elapsedRealtime()));
                    aVar.j6(this.j6.FH, this.j6.VH, false);
                }
                if (!(aVar instanceof com.google.android.gms.common.images.a.b)) {
                    this.j6.gn.remove(aVar);
                }
            }
        }

        public void run() {
            i.j6("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.FH != null;
            if (this.j6.Zo != null) {
                if (this.v5) {
                    this.j6.Zo.j6();
                    System.gc();
                    this.v5 = false;
                    this.j6.Hw.post(this);
                    return;
                } else if (z) {
                    this.j6.Zo.j6(new a(this.DW), this.FH);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.j6.u7.remove(this.DW);
            if (imageReceiver != null) {
                j6(imageReceiver, z);
            }
            this.Hw.countDown();
            synchronized (ImageManager.j6) {
                ImageManager.DW.remove(this.DW);
            }
        }
    }

    private static final class zzb extends p<a, Bitmap> {
        public zzb(Context context) {
            super(j6(context));
        }

        @TargetApi(11)
        private static int j6(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || !agb.j6()) ? activityManager.getMemoryClass() : b.j6(activityManager);
            return (int) (((float) (memoryClass * 1048576)) * 0.33f);
        }

        protected /* synthetic */ int DW(Object obj, Object obj2) {
            return j6((a) obj, (Bitmap) obj2);
        }

        protected int j6(a aVar, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void j6(boolean z, a aVar, Bitmap bitmap, Bitmap bitmap2) {
            super.j6(z, aVar, bitmap, bitmap2);
        }

        protected /* synthetic */ void j6(boolean z, Object obj, Object obj2, Object obj3) {
            j6(z, (a) obj, (Bitmap) obj2, (Bitmap) obj3);
        }
    }

    static {
        j6 = new Object();
        DW = new HashSet();
    }
}
