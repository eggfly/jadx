package com.antutu.utils.cache;

public class ImageTask implements Runnable {
    public final String TAG;
    private String mKey;
    private ImageTaskBack mTaskBack;
    public long myTime;

    public ImageTask(String str, ImageTaskBack imageTaskBack) {
        this.TAG = "ImageTask";
        this.myTime = System.currentTimeMillis();
        this.mKey = str;
        this.mTaskBack = imageTaskBack;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = 0;
        r0 = r8.mKey;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x000f;
    L_0x000b:
        r0 = r8.mTaskBack;
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return;
    L_0x0010:
        r3 = new org.apache.http.util.ByteArrayBuffer;
        r3.<init>(r2);
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00cd, Exception -> 0x0079, OutOfMemoryError -> 0x008e, all -> 0x00a5 }
        r2 = r8.mKey;	 Catch:{ MalformedURLException -> 0x00cd, Exception -> 0x0079, OutOfMemoryError -> 0x008e, all -> 0x00a5 }
        r0.<init>(r2);	 Catch:{ MalformedURLException -> 0x00cd, Exception -> 0x0079, OutOfMemoryError -> 0x008e, all -> 0x00a5 }
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x00cd, Exception -> 0x0079, OutOfMemoryError -> 0x008e, all -> 0x00a5 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x00cd, Exception -> 0x0079, OutOfMemoryError -> 0x008e, all -> 0x00a5 }
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setConnectTimeout(r2);	 Catch:{ MalformedURLException -> 0x00d1, Exception -> 0x00c8, OutOfMemoryError -> 0x00c3, all -> 0x00b2 }
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setReadTimeout(r2);	 Catch:{ MalformedURLException -> 0x00d1, Exception -> 0x00c8, OutOfMemoryError -> 0x00c3, all -> 0x00b2 }
        r2 = new java.io.BufferedInputStream;	 Catch:{ MalformedURLException -> 0x00d1, Exception -> 0x00c8, OutOfMemoryError -> 0x00c3, all -> 0x00b2 }
        r4 = r0.getInputStream();	 Catch:{ MalformedURLException -> 0x00d1, Exception -> 0x00c8, OutOfMemoryError -> 0x00c3, all -> 0x00b2 }
        r2.<init>(r4);	 Catch:{ MalformedURLException -> 0x00d1, Exception -> 0x00c8, OutOfMemoryError -> 0x00c3, all -> 0x00b2 }
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = new byte[r4];	 Catch:{ MalformedURLException -> 0x0045, Exception -> 0x00ca, OutOfMemoryError -> 0x00c5, all -> 0x00b8 }
    L_0x0039:
        r5 = r2.read(r4);	 Catch:{ MalformedURLException -> 0x0045, Exception -> 0x00ca, OutOfMemoryError -> 0x00c5, all -> 0x00b8 }
        r6 = -1;
        if (r5 == r6) goto L_0x005a;
    L_0x0040:
        r6 = 0;
        r3.append(r4, r6, r5);	 Catch:{ MalformedURLException -> 0x0045, Exception -> 0x00ca, OutOfMemoryError -> 0x00c5, all -> 0x00b8 }
        goto L_0x0039;
    L_0x0045:
        r1 = move-exception;
        r1 = r2;
    L_0x0047:
        r2 = r8.mTaskBack;	 Catch:{ all -> 0x00bd }
        r3 = r8.mKey;	 Catch:{ all -> 0x00bd }
        r4 = 0;
        r2.imageBack(r3, r4);	 Catch:{ all -> 0x00bd }
        if (r1 == 0) goto L_0x000f;
    L_0x0051:
        r0.disconnect();	 Catch:{ IOException -> 0x0058 }
        r1.close();	 Catch:{ IOException -> 0x0058 }
        goto L_0x000f;
    L_0x0058:
        r0 = move-exception;
        goto L_0x000f;
    L_0x005a:
        r4 = r3.toByteArray();	 Catch:{ OutOfMemoryError -> 0x00d4, MalformedURLException -> 0x0045, Exception -> 0x00ca, all -> 0x00b8 }
        r5 = 0;
        r3 = r3.length();	 Catch:{ OutOfMemoryError -> 0x00d4, MalformedURLException -> 0x0045, Exception -> 0x00ca, all -> 0x00b8 }
        r1 = android.graphics.BitmapFactory.decodeByteArray(r4, r5, r3);	 Catch:{ OutOfMemoryError -> 0x00d4, MalformedURLException -> 0x0045, Exception -> 0x00ca, all -> 0x00b8 }
    L_0x0067:
        r3 = r8.mTaskBack;	 Catch:{ MalformedURLException -> 0x0045, Exception -> 0x00ca, OutOfMemoryError -> 0x00c5, all -> 0x00b8 }
        r4 = r8.mKey;	 Catch:{ MalformedURLException -> 0x0045, Exception -> 0x00ca, OutOfMemoryError -> 0x00c5, all -> 0x00b8 }
        r3.imageBack(r4, r1);	 Catch:{ MalformedURLException -> 0x0045, Exception -> 0x00ca, OutOfMemoryError -> 0x00c5, all -> 0x00b8 }
        if (r2 == 0) goto L_0x000f;
    L_0x0070:
        r0.disconnect();	 Catch:{ IOException -> 0x0077 }
        r2.close();	 Catch:{ IOException -> 0x0077 }
        goto L_0x000f;
    L_0x0077:
        r0 = move-exception;
        goto L_0x000f;
    L_0x0079:
        r0 = move-exception;
        r0 = r1;
    L_0x007b:
        r2 = r8.mTaskBack;	 Catch:{ all -> 0x00bd }
        r3 = r8.mKey;	 Catch:{ all -> 0x00bd }
        r4 = 0;
        r2.imageBack(r3, r4);	 Catch:{ all -> 0x00bd }
        if (r1 == 0) goto L_0x000f;
    L_0x0085:
        r0.disconnect();	 Catch:{ IOException -> 0x008c }
        r1.close();	 Catch:{ IOException -> 0x008c }
        goto L_0x000f;
    L_0x008c:
        r0 = move-exception;
        goto L_0x000f;
    L_0x008e:
        r0 = move-exception;
        r0 = r1;
    L_0x0090:
        r2 = r8.mTaskBack;	 Catch:{ all -> 0x00bd }
        r3 = r8.mKey;	 Catch:{ all -> 0x00bd }
        r4 = 0;
        r2.imageBack(r3, r4);	 Catch:{ all -> 0x00bd }
        if (r1 == 0) goto L_0x000f;
    L_0x009a:
        r0.disconnect();	 Catch:{ IOException -> 0x00a2 }
        r1.close();	 Catch:{ IOException -> 0x00a2 }
        goto L_0x000f;
    L_0x00a2:
        r0 = move-exception;
        goto L_0x000f;
    L_0x00a5:
        r0 = move-exception;
        r2 = r1;
    L_0x00a7:
        if (r2 == 0) goto L_0x000f;
    L_0x00a9:
        r1.disconnect();	 Catch:{ IOException -> 0x00b0 }
        r2.close();	 Catch:{ IOException -> 0x00b0 }
    L_0x00af:
        throw r0;
    L_0x00b0:
        r1 = move-exception;
        goto L_0x00af;
    L_0x00b2:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00a7;
    L_0x00b8:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00a7;
    L_0x00bd:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00a7;
    L_0x00c3:
        r2 = move-exception;
        goto L_0x0090;
    L_0x00c5:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0090;
    L_0x00c8:
        r2 = move-exception;
        goto L_0x007b;
    L_0x00ca:
        r1 = move-exception;
        r1 = r2;
        goto L_0x007b;
    L_0x00cd:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0047;
    L_0x00d1:
        r2 = move-exception;
        goto L_0x0047;
    L_0x00d4:
        r3 = move-exception;
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.cache.ImageTask.run():void");
    }
}
