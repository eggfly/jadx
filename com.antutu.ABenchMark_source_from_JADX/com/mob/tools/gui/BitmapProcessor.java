package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BitmapProcessor {
    private static final int CAPACITY = 3;
    private static final int MAX_CACHE_SIZE = 50;
    private static final int MAX_CACHE_TIME = 60000;
    private static final int MAX_REQ_TIME = 200;
    private static final int MAX_SIZE = 100;
    private static final int OVERFLOW_SIZE = 120;
    private static BitmapProcessor instance;
    private File cacheDir;
    private CachePool<String, Bitmap> cachePool;
    private ManagerThread manager;
    private int maxReqCount;
    private ArrayList<ImageReq> netReqTPS;
    private int overflowReqCount;
    private ArrayList<ImageReq> reqList;
    private int reqTimeout;
    private boolean work;
    private WorkerThread[] workerList;

    public interface BitmapCallback {
        void onImageGot(String str, Bitmap bitmap);
    }

    public static class ImageReq {
        private BitmapCallback callback;
        private Bitmap image;
        private long reqTime;
        private String url;
        private WorkerThread worker;

        public ImageReq() {
            this.reqTime = System.currentTimeMillis();
        }

        private void throwComplete(Bitmap bitmap) {
            this.image = bitmap;
            if (this.callback != null) {
                this.callback.onImageGot(this.url, this.image);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("url=").append(this.url);
            stringBuilder.append("time=").append(this.reqTime);
            stringBuilder.append("worker=").append(this.worker.getName()).append(" (").append(this.worker.getId()).append(BuildConfig.FLAVOR);
            return stringBuilder.toString();
        }
    }

    private static class ManagerThread extends Timer {
        private BitmapProcessor processor;

        /* renamed from: com.mob.tools.gui.BitmapProcessor.ManagerThread.1 */
        class C40061 extends TimerTask {
            private int counter;

            C40061() {
            }

            public void run() {
                if (ManagerThread.this.processor.work) {
                    this.counter--;
                    if (this.counter <= 0) {
                        this.counter = BitmapProcessor.MAX_SIZE;
                        ManagerThread.this.scan();
                    }
                }
            }
        }

        public ManagerThread(BitmapProcessor bitmapProcessor) {
            this.processor = bitmapProcessor;
            schedule(new C40061(), 0, (long) this.processor.reqTimeout);
        }

        private void scan() {
            if (this.processor.cachePool != null) {
                this.processor.cachePool.trimBeforeTime(System.currentTimeMillis() - 60000);
            }
            MobLog.getInstance().m4375d(">>>> BitmapProcessor.cachePool: " + (this.processor.cachePool == null ? 0 : this.processor.cachePool.size()), new Object[0]);
            MobLog.getInstance().m4375d(">>>> BitmapProcessor.reqList: " + (this.processor.reqList == null ? 0 : this.processor.reqList.size()), new Object[0]);
            if (this.processor.work) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (i < this.processor.workerList.length) {
                    if (this.processor.workerList[i] == null) {
                        this.processor.workerList[i] = new WorkerThread(this.processor);
                        this.processor.workerList[i].setName("worker " + i);
                        this.processor.workerList[i].localType = i == 0;
                        this.processor.workerList[i].start();
                    } else if (currentTimeMillis - this.processor.workerList[i].lastReport > ((long) (this.processor.reqTimeout * BitmapProcessor.MAX_SIZE))) {
                        this.processor.workerList[i].interrupt();
                        boolean access$900 = this.processor.workerList[i].localType;
                        this.processor.workerList[i] = new WorkerThread(this.processor);
                        this.processor.workerList[i].setName("worker " + i);
                        this.processor.workerList[i].localType = access$900;
                        this.processor.workerList[i].start();
                    }
                    i++;
                }
            }
        }
    }

    private static class PatchInputStream extends FilterInputStream {
        InputStream in;

        protected PatchInputStream(InputStream inputStream) {
            super(inputStream);
            this.in = inputStream;
        }

        public long skip(long j) {
            long j2 = 0;
            while (j2 < j) {
                long skip = this.in.skip(j - j2);
                if (skip == 0) {
                    break;
                }
                j2 += skip;
            }
            return j2;
        }
    }

    private static class WorkerThread extends Thread {
        private ImageReq curReq;
        private long lastReport;
        private boolean localType;
        private BitmapProcessor processor;

        /* renamed from: com.mob.tools.gui.BitmapProcessor.WorkerThread.1 */
        class C40071 implements RawNetworkCallback {
            final /* synthetic */ File val$file;
            final /* synthetic */ ImageReq val$req;
            final /* synthetic */ boolean val$saveAsPng;

            C40071(File file, boolean z, ImageReq imageReq) {
                this.val$file = file;
                this.val$saveAsPng = z;
                this.val$req = imageReq;
            }

            public void onResponse(InputStream inputStream) {
                Bitmap bitmap = BitmapHelper.getBitmap(new PatchInputStream(inputStream), 1);
                if (bitmap == null || bitmap.isRecycled()) {
                    WorkerThread.this.curReq = null;
                    return;
                }
                WorkerThread.this.saveFile(bitmap, this.val$file, this.val$saveAsPng);
                if (bitmap != null) {
                    WorkerThread.this.processor.cachePool.put(this.val$req.url, bitmap);
                    this.val$req.throwComplete(bitmap);
                }
                WorkerThread.this.curReq = null;
            }
        }

        public WorkerThread(BitmapProcessor bitmapProcessor) {
            this.processor = bitmapProcessor;
            this.lastReport = System.currentTimeMillis();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void doLocalTask() {
            /*
            r5 = this;
            r0 = 0;
            r1 = r5.processor;
            r2 = r1.reqList;
            monitor-enter(r2);
            r1 = r5.processor;	 Catch:{ all -> 0x0048 }
            r1 = r1.reqList;	 Catch:{ all -> 0x0048 }
            r1 = r1.size();	 Catch:{ all -> 0x0048 }
            if (r1 <= 0) goto L_0x00d1;
        L_0x0014:
            r0 = r5.processor;	 Catch:{ all -> 0x0048 }
            r0 = r0.reqList;	 Catch:{ all -> 0x0048 }
            r1 = 0;
            r0 = r0.remove(r1);	 Catch:{ all -> 0x0048 }
            r0 = (com.mob.tools.gui.BitmapProcessor.ImageReq) r0;	 Catch:{ all -> 0x0048 }
            r1 = r0;
        L_0x0022:
            monitor-exit(r2);	 Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x00c1;
        L_0x0025:
            r0 = r5.processor;
            r0 = r0.cachePool;
            r2 = r1.url;
            r0 = r0.get(r2);
            r0 = (android.graphics.Bitmap) r0;
            if (r0 == 0) goto L_0x004b;
        L_0x0037:
            r5.curReq = r1;
            r2 = r5.curReq;
            r2.worker = r5;
            r1.throwComplete(r0);
        L_0x0041:
            r0 = java.lang.System.currentTimeMillis();
            r5.lastReport = r0;
        L_0x0047:
            return;
        L_0x0048:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0048 }
            throw r0;
        L_0x004b:
            r0 = new java.io.File;
            r2 = r5.processor;
            r2 = r2.cacheDir;
            r3 = r1.url;
            r3 = com.mob.tools.utils.Data.MD5(r3);
            r0.<init>(r2, r3);
            r0 = r0.exists();
            if (r0 == 0) goto L_0x006e;
        L_0x0064:
            r5.doTask(r1);
            r0 = java.lang.System.currentTimeMillis();
            r5.lastReport = r0;
            goto L_0x0047;
        L_0x006e:
            r0 = r5.processor;
            r2 = r0.reqList;
            monitor-enter(r2);
            r0 = r5.processor;	 Catch:{ all -> 0x00a8 }
            r0 = r0.netReqTPS;	 Catch:{ all -> 0x00a8 }
            r0 = r0.size();	 Catch:{ all -> 0x00a8 }
            r3 = r5.processor;	 Catch:{ all -> 0x00a8 }
            r3 = r3.maxReqCount;	 Catch:{ all -> 0x00a8 }
            if (r0 <= r3) goto L_0x00b6;
        L_0x0087:
            r0 = r5.processor;	 Catch:{ all -> 0x00a8 }
            r3 = r0.reqList;	 Catch:{ all -> 0x00a8 }
            monitor-enter(r3);	 Catch:{ all -> 0x00a8 }
        L_0x008e:
            r0 = r5.processor;	 Catch:{ all -> 0x00a5 }
            r0 = r0.reqList;	 Catch:{ all -> 0x00a5 }
            r0 = r0.size();	 Catch:{ all -> 0x00a5 }
            if (r0 <= 0) goto L_0x00ab;
        L_0x009a:
            r0 = r5.processor;	 Catch:{ all -> 0x00a5 }
            r0 = r0.reqList;	 Catch:{ all -> 0x00a5 }
            r4 = 0;
            r0.remove(r4);	 Catch:{ all -> 0x00a5 }
            goto L_0x008e;
        L_0x00a5:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00a5 }
            throw r0;	 Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x00a8 }
            throw r0;
        L_0x00ab:
            monitor-exit(r3);	 Catch:{ all -> 0x00a5 }
            r0 = r5.processor;	 Catch:{ all -> 0x00a8 }
            r0 = r0.netReqTPS;	 Catch:{ all -> 0x00a8 }
            r3 = 0;
            r0.remove(r3);	 Catch:{ all -> 0x00a8 }
        L_0x00b6:
            monitor-exit(r2);	 Catch:{ all -> 0x00a8 }
            r0 = r5.processor;
            r0 = r0.netReqTPS;
            r0.add(r1);
            goto L_0x0041;
        L_0x00c1:
            r0 = java.lang.System.currentTimeMillis();
            r5.lastReport = r0;
            r0 = 30;
            java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x00ce }
            goto L_0x0047;
        L_0x00ce:
            r0 = move-exception;
            goto L_0x0047;
        L_0x00d1:
            r1 = r0;
            goto L_0x0022;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.BitmapProcessor.WorkerThread.doLocalTask():void");
        }

        private void doNetworkTask() {
            ImageReq imageReq;
            ImageReq imageReq2 = null;
            synchronized (this.processor.netReqTPS) {
                if (this.processor.netReqTPS.size() > 0) {
                    imageReq2 = (ImageReq) this.processor.netReqTPS.remove(0);
                }
            }
            if (imageReq2 == null) {
                synchronized (this.processor.reqList) {
                    if (this.processor.reqList.size() > 0) {
                        imageReq2 = (ImageReq) this.processor.reqList.remove(0);
                    }
                }
                imageReq = imageReq2;
            } else {
                imageReq = imageReq2;
            }
            if (imageReq != null) {
                Bitmap bitmap = (Bitmap) this.processor.cachePool.get(imageReq.url);
                if (bitmap != null) {
                    this.curReq = imageReq;
                    this.curReq.worker = this;
                    imageReq.throwComplete(bitmap);
                } else {
                    doTask(imageReq);
                }
                this.lastReport = System.currentTimeMillis();
                return;
            }
            this.lastReport = System.currentTimeMillis();
            try {
                Thread.sleep(30);
            } catch (Throwable th) {
            }
        }

        private void doTask(ImageReq imageReq) {
            Bitmap bitmap;
            this.curReq = imageReq;
            this.curReq.worker = this;
            boolean z = imageReq.url.toLowerCase().endsWith("png") || imageReq.url.toLowerCase().endsWith("gif");
            File file = new File(this.processor.cacheDir, Data.MD5(imageReq.url));
            if (file.exists()) {
                bitmap = BitmapHelper.getBitmap(file.getAbsolutePath());
                if (bitmap != null) {
                    this.processor.cachePool.put(imageReq.url, bitmap);
                    imageReq.throwComplete(bitmap);
                }
                this.curReq = null;
            } else {
                new NetworkHelper().rawGet(imageReq.url, new C40071(file, z, imageReq), null);
                bitmap = null;
            }
            if (bitmap != null) {
                this.processor.cachePool.put(imageReq.url, bitmap);
                imageReq.throwComplete(bitmap);
            }
            this.curReq = null;
        }

        private void saveFile(Bitmap bitmap, File file, boolean z) {
            try {
                if (file.exists()) {
                    file.delete();
                }
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                CompressFormat compressFormat = z ? CompressFormat.PNG : CompressFormat.JPEG;
                OutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(compressFormat, BitmapProcessor.MAX_SIZE, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        public void interrupt() {
            try {
                super.interrupt();
            } catch (Throwable th) {
            }
        }

        public void run() {
            while (this.processor.work) {
                try {
                    if (this.localType) {
                        doLocalTask();
                    } else {
                        doNetworkTask();
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().m4388w(th);
                }
            }
        }
    }

    private BitmapProcessor(Context context, int i, int i2, int i3, float f, int i4) {
        if (i2 <= 0) {
            i2 = MAX_REQ_TIME;
        }
        this.reqTimeout = i2;
        this.maxReqCount = i3 > 0 ? i3 : MAX_SIZE;
        this.overflowReqCount = f > 1.0f ? (int) (((float) i3) * f) : OVERFLOW_SIZE;
        this.reqList = new ArrayList();
        this.netReqTPS = new ArrayList();
        if (i <= 0) {
            i = CAPACITY;
        }
        this.workerList = new WorkerThread[i];
        if (i4 <= 0) {
            i4 = MAX_CACHE_SIZE;
        }
        this.cachePool = new CachePool(i4);
        this.cacheDir = new File(C4021R.getImageCachePath(context));
        this.manager = new ManagerThread(this);
    }

    public static Bitmap getBitmapFromCache(String str) {
        return instance == null ? null : (Bitmap) instance.cachePool.get(str);
    }

    public static synchronized void prepare(Context context) {
        synchronized (BitmapProcessor.class) {
            prepare(context, 0, 0, 0, 0.0f, 0);
        }
    }

    public static synchronized void prepare(Context context, int i, int i2, int i3, float f, int i4) {
        synchronized (BitmapProcessor.class) {
            if (instance == null) {
                instance = new BitmapProcessor(context.getApplicationContext(), i, i2, i3, f, i4);
            }
        }
    }

    public static synchronized void process(String str, BitmapCallback bitmapCallback) {
        synchronized (BitmapProcessor.class) {
            if (!(instance == null || str == null)) {
                ImageReq imageReq;
                Object obj;
                if (instance.reqList != null) {
                    synchronized (instance.reqList) {
                        int size = instance.reqList.size();
                        for (int i = 0; i < size; i++) {
                            imageReq = (ImageReq) instance.reqList.get(i);
                            if (imageReq.url.equals(str) && imageReq.callback.equals(bitmapCallback)) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                    }
                } else {
                    obj = null;
                }
                if (obj == null) {
                    imageReq = new ImageReq();
                    imageReq.url = str;
                    imageReq.callback = bitmapCallback;
                    instance.reqList.add(imageReq);
                    synchronized (instance.reqList) {
                        if (instance.reqList.size() > instance.overflowReqCount) {
                            while (instance.reqList.size() > instance.maxReqCount) {
                                instance.reqList.remove(0);
                            }
                        }
                    }
                    start();
                }
            }
        }
    }

    public static synchronized void start() {
        synchronized (BitmapProcessor.class) {
            if (instance == null) {
                throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
            }
            instance.work = true;
        }
    }

    public static synchronized void stop() {
        synchronized (BitmapProcessor.class) {
            if (instance != null) {
                instance.work = false;
                synchronized (instance.reqList) {
                    instance.reqList.clear();
                }
                instance.manager.cancel();
                for (int i = 0; i < instance.workerList.length; i++) {
                    if (instance.workerList[i] != null) {
                        instance.workerList[i].interrupt();
                    }
                }
                instance = null;
            }
        }
    }
}
