package com.antutu.utils;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.model.C1519k;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

public class DownloadTask extends AsyncTask<Void, Integer, C1519k> {
    private static final boolean DEBUG = true;
    private static final String TAG = "DOWNLOAD_TASK";
    private int mHttpStatusCode;
    DownloadJob mJob;
    private boolean needDecode;
    private int returnType;
    private int timeout;

    public DownloadTask(DownloadJob downloadJob) {
        this.mHttpStatusCode = 0;
        this.mJob = downloadJob;
        this.timeout = 50;
        this.needDecode = false;
        this.returnType = 1;
    }

    public DownloadTask(DownloadJob downloadJob, int i) {
        this.mHttpStatusCode = 0;
        this.mJob = downloadJob;
        this.needDecode = false;
        this.returnType = 1;
        this.timeout = i;
    }

    public DownloadTask(DownloadJob downloadJob, boolean z, int i) {
        this.mHttpStatusCode = 0;
        this.mJob = downloadJob;
        this.timeout = 50;
        this.needDecode = z;
        this.returnType = i;
    }

    public DownloadTask(DownloadJob downloadJob, boolean z, int i, int i2) {
        this.mHttpStatusCode = 0;
        this.mJob = downloadJob;
        this.needDecode = z;
        this.returnType = i;
        this.timeout = i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getXMLFromServer(com.antutu.utils.DownloadJob r7) {
        /*
        r6 = this;
        r0 = 0;
        r1 = r7.getRequestPaht();	 Catch:{ Exception -> 0x0086 }
        r2 = r6.timeout;	 Catch:{ Exception -> 0x0086 }
        r1 = com.antutu.utils.HttpUtil.getInputStream(r1, r2);	 Catch:{ Exception -> 0x0086 }
        r2 = 0;
        r6.mHttpStatusCode = r2;	 Catch:{ Exception -> 0x0086 }
        if (r1 == 0) goto L_0x0080;
    L_0x0010:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r6.mHttpStatusCode = r2;	 Catch:{ Exception -> 0x0086 }
        r3 = android.util.Xml.newPullParser();	 Catch:{ Exception -> 0x0086 }
        r2 = "UTF-8";
        r3.setInput(r1, r2);	 Catch:{ Exception -> 0x0086 }
        r1 = r3.getEventType();	 Catch:{ Exception -> 0x0086 }
        r2 = r1;
        r1 = r0;
    L_0x0023:
        r4 = 1;
        if (r2 == r4) goto L_0x0081;
    L_0x0026:
        switch(r2) {
            case 0: goto L_0x0032;
            case 1: goto L_0x0029;
            case 2: goto L_0x0039;
            case 3: goto L_0x0073;
            default: goto L_0x0029;
        };	 Catch:{ Exception -> 0x0086 }
    L_0x0029:
        r2 = r1;
    L_0x002a:
        r1 = r3.next();	 Catch:{ Exception -> 0x0086 }
        r5 = r1;
        r1 = r2;
        r2 = r5;
        goto L_0x0023;
    L_0x0032:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0086 }
        r1.<init>();	 Catch:{ Exception -> 0x0086 }
        r2 = r1;
        goto L_0x002a;
    L_0x0039:
        r2 = "updateinfo";
        r4 = r3.getName();	 Catch:{ Exception -> 0x0086 }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x0086 }
        if (r2 == 0) goto L_0x0045;
    L_0x0045:
        r2 = "version";
        r4 = r3.getName();	 Catch:{ Exception -> 0x0086 }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x0086 }
        if (r2 == 0) goto L_0x005c;
    L_0x0051:
        r2 = "version";
        r4 = r3.nextText();	 Catch:{ Exception -> 0x0086 }
        r1.put(r2, r4);	 Catch:{ Exception -> 0x0086 }
        r2 = r1;
        goto L_0x002a;
    L_0x005c:
        r2 = "url";
        r4 = r3.getName();	 Catch:{ Exception -> 0x0086 }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x0086 }
        if (r2 == 0) goto L_0x0029;
    L_0x0068:
        r2 = "url";
        r4 = r3.nextText();	 Catch:{ Exception -> 0x0086 }
        r1.put(r2, r4);	 Catch:{ Exception -> 0x0086 }
        r2 = r1;
        goto L_0x002a;
    L_0x0073:
        r2 = "book";
        r4 = r3.getName();	 Catch:{ Exception -> 0x0086 }
        r2 = r2.equals(r4);	 Catch:{ Exception -> 0x0086 }
        if (r2 == 0) goto L_0x0029;
    L_0x007f:
        goto L_0x0029;
    L_0x0080:
        r1 = r0;
    L_0x0081:
        r0 = r1.toString();	 Catch:{ Exception -> 0x0086 }
    L_0x0085:
        return r0;
    L_0x0086:
        r1 = move-exception;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.DownloadTask.getXMLFromServer(com.antutu.utils.DownloadJob):java.lang.String");
    }

    private void handleException(String str) {
    }

    private String post(String str, HashMap<String, String> hashMap, int i) {
        try {
            this.mHttpStatusCode = 0;
            HttpResponse postRequestForStream = HttpUtil.postRequestForStream(ABenchmarkApplication.getContext(), str, hashMap, i);
            this.mHttpStatusCode = postRequestForStream.getStatusLine().getStatusCode();
            return NetUtils.toString(postRequestForStream.getEntity(), "utf-8");
        } catch (ConnectTimeoutException e) {
            this.mHttpStatusCode = -1;
            return null;
        } catch (SocketTimeoutException e2) {
            this.mHttpStatusCode = -1;
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    private String post(String str, HashMap<String, String> hashMap, MultipartForm multipartForm, int i) {
        try {
            this.mHttpStatusCode = 0;
            HttpResponse postRequestForMultipart = HttpUtil.postRequestForMultipart(ABenchmarkApplication.getContext(), str, hashMap, multipartForm, i);
            this.mHttpStatusCode = postRequestForMultipart.getStatusLine().getStatusCode();
            return NetUtils.toString(postRequestForMultipart.getEntity(), "utf-8");
        } catch (ConnectTimeoutException e) {
            this.mHttpStatusCode = -1;
            return null;
        } catch (SocketTimeoutException e2) {
            this.mHttpStatusCode = -1;
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    private C1519k requestJson(DownloadJob downloadJob, boolean z, int i, int i2) {
        if (downloadJob == null) {
            return null;
        }
        try {
            Object post;
            if (downloadJob.getmParams() != null) {
                if (i == 1) {
                    int type = downloadJob.getType();
                    post = type == 1 ? post(downloadJob.getRequestPaht(), downloadJob.getmParams(), i2) : type == 2 ? post(downloadJob.getRequestPaht(), downloadJob.getmParams(), downloadJob.getMultipartForm(), i2) : null;
                } else {
                    post = getXMLFromServer(downloadJob);
                }
            } else if (i == 1) {
                post = HttpUtil.get(downloadJob.getRequestPaht(), i2);
                this.mHttpStatusCode = HttpUtil.getHttpStatusCode();
            } else {
                post = getXMLFromServer(downloadJob);
            }
            if (z) {
                post = jni.getStringSafe(post, BuildConfig.FLAVOR);
            }
            if (downloadJob != null) {
                this.mJob.setJsonString(post);
            }
            return !TextUtils.isEmpty(post) ? downloadJob.getModel().m6041a(post) : null;
        } catch (Exception e) {
            return null;
        }
    }

    public C1519k doInBackground(Void... voidArr) {
        try {
            return requestJson(this.mJob, this.needDecode, this.returnType, this.timeout);
        } catch (SocketException e) {
            handleException(e.toString());
            return null;
        } catch (Exception e2) {
            handleException(e2.toString());
            return null;
        }
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public void onPostExecute(C1519k c1519k) {
        try {
            this.mJob.notifyDownloadEnd(this.mHttpStatusCode, c1519k);
            super.onPostExecute(c1519k);
        } catch (Exception e) {
        }
    }

    public void onPreExecute() {
        this.mJob.notifyDownloadStart();
        super.onPreExecute();
    }

    protected void onProgressUpdate(Integer... numArr) {
    }
}
