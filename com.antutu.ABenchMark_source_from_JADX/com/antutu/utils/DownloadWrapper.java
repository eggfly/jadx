package com.antutu.utils;

import android.content.Context;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1520b;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.model.C1534l;
import com.taobao.accs.common.Constants;
import java.util.HashMap;

public class DownloadWrapper extends Thread {
    private Context context;
    private String currentSession;
    private DownloadJobListener mListener;
    private C1520b mModel;
    private String postData;
    private String requestURL;

    /* renamed from: com.antutu.utils.DownloadWrapper.1 */
    class C17921 implements DownloadJobListener {
        C17921() {
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k != null) {
                C1534l c1534l = (C1534l) c1519k;
                DownloadWrapper.this.currentSession = c1534l.f5342b;
                DownloadWrapper.this.mModel.m6042b(DownloadWrapper.this.currentSession);
                DownloadWrapper.this.requestInfo(c1534l);
            }
        }
    }

    public DownloadWrapper(Context context, String str, String str2, C1520b c1520b, DownloadJobListener downloadJobListener) {
        this.context = context;
        this.requestURL = str;
        this.postData = str2;
        this.mListener = downloadJobListener;
        this.mModel = c1520b;
    }

    private void requestForKey() {
        DownloadJob downloadJob = new DownloadJob(this.context, C1523d.m6060a(C1523d.m6059a(), "/i/api/member/secret"), new C1534l(), new HashMap());
        downloadJob.setDownloadJobListener(new C17921());
        downloadJob.start();
    }

    private void setParams(C1534l c1534l, String str, HashMap<String, String> hashMap) {
        String eightKey = Utils.getEightKey();
        hashMap.put(Constants.KEY_DATA, jni.getDataSafe(str, Utils.getScretKey(eightKey, c1534l)) + eightKey);
        hashMap.put("SESSION-ID", c1534l.f5341a);
    }

    public String getSessionStr() {
        return this.currentSession;
    }

    protected void requestInfo(C1519k c1519k) {
        try {
            HashMap hashMap = new HashMap();
            setParams((C1534l) c1519k, this.postData, hashMap);
            DownloadJob downloadJob = new DownloadJob(this.context, C1523d.m6060a(C1523d.m6059a(), this.requestURL), this.mModel, hashMap);
            downloadJob.setDownloadJobListener(this.mListener);
            downloadJob.start();
        } catch (Exception e) {
        }
    }

    public void run() {
        requestForKey();
    }
}
