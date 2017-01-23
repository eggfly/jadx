package com.antutu.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask.Status;
import com.antutu.benchmark.model.C1519k;
import com.antutu.redacc.C1692R;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.util.HashMap;

public class DownloadJob {
    public static final int COMMON_REQUEST_TYPE = 1;
    public static final Context HIDE_DIALOG;
    public static final int MULTIPART_REQUEST_TYPE = 2;
    private C1519k iModel;
    private Context mContext;
    private DownloadTask mDownloadTask;
    private String mJsonString;
    private DownloadJobListener mListener;
    private HashMap<String, String> mParams;
    private ProgressDialog mPrgDlg;
    private String mRequestPath;
    private MultipartForm multipart;
    private boolean needDecode;
    private int returnType;
    private int timeout;
    private int type;

    /* renamed from: com.antutu.utils.DownloadJob.1 */
    class C17911 implements OnCancelListener {
        C17911() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            DownloadJob.this.hidePrgDlg();
        }
    }

    static {
        HIDE_DIALOG = null;
    }

    public DownloadJob(Context context, String str, C1519k c1519k) {
        this(str, c1519k);
        this.mContext = context;
    }

    public DownloadJob(Context context, String str, C1519k c1519k, HashMap<String, String> hashMap) {
        this(str, c1519k, (HashMap) hashMap, false, (int) COMMON_REQUEST_TYPE);
        this.mContext = context;
    }

    public DownloadJob(Context context, String str, C1519k c1519k, HashMap<String, String> hashMap, int i) {
        this(str, c1519k, (HashMap) hashMap, false, (int) COMMON_REQUEST_TYPE);
        this.timeout = i;
        this.mContext = context;
    }

    public DownloadJob(Context context, String str, C1519k c1519k, HashMap<String, String> hashMap, boolean z, int i) {
        this(str, c1519k, (HashMap) hashMap, z, i);
        this.mContext = context;
    }

    public DownloadJob(String str, C1519k c1519k) {
        this.type = COMMON_REQUEST_TYPE;
        HttpUtil.setUrlEncode(HttpRequest.f14548a);
        this.mRequestPath = str;
        this.iModel = c1519k;
    }

    private DownloadJob(String str, C1519k c1519k, HashMap<String, String> hashMap, boolean z, int i) {
        this.type = COMMON_REQUEST_TYPE;
        HttpUtil.setUrlEncode(HttpRequest.f14548a);
        this.mRequestPath = str;
        this.iModel = c1519k;
        this.mParams = hashMap;
        this.timeout = 50;
        this.needDecode = z;
        this.returnType = i;
    }

    private void hidePrgDlg() {
        try {
            if (this.mPrgDlg != null) {
                this.mPrgDlg.dismiss();
                this.mPrgDlg = null;
            }
        } catch (Exception e) {
        }
    }

    private void showNetErrorDlg() {
        try {
            if (!HttpUtil.isConnected()) {
            }
        } catch (Exception e) {
        }
    }

    private void showPrgDlg() {
        try {
            if (this.mContext != null && this.mPrgDlg == null) {
                this.mPrgDlg = ProgressDialog.show(this.mContext, null, this.mContext.getString(C1692R.string.loading), true, true);
                this.mPrgDlg.setOnCancelListener(new C17911());
            }
        } catch (Exception e) {
        }
    }

    public void cancel() {
        hidePrgDlg();
        if (this.mDownloadTask != null) {
            this.mDownloadTask.cancel(true);
            this.mDownloadTask = null;
        }
    }

    public boolean cancelTask() {
        hidePrgDlg();
        if (this.mDownloadTask == null) {
            return false;
        }
        this.mDownloadTask.cancel(true);
        return this.mDownloadTask.isCancelled();
    }

    public int getHttpStatusCode() {
        return this.mDownloadTask != null ? this.mDownloadTask.getHttpStatusCode() : -1;
    }

    public String getJsonString() {
        return this.mJsonString != null ? this.mJsonString : "null";
    }

    public C1519k getModel() {
        return this.iModel;
    }

    public MultipartForm getMultipartForm() {
        return this.multipart;
    }

    public String getRequestPaht() {
        return this.mRequestPath;
    }

    public int getType() {
        return this.type;
    }

    public HashMap<String, String> getmParams() {
        return this.mParams;
    }

    public boolean isHttpOk() {
        return this.mDownloadTask != null && this.mDownloadTask.getHttpStatusCode() == Constants.COMMAND_HANDSHAKE;
    }

    public boolean isRunning() {
        if (this.mDownloadTask == null) {
            return false;
        }
        Status status = this.mDownloadTask.getStatus();
        return status == Status.RUNNING || status == Status.PENDING;
    }

    public void notifyDownloadEnd(int i, C1519k c1519k) {
        try {
            hidePrgDlg();
            if (c1519k == null) {
                showNetErrorDlg();
            }
            if (this.mListener != null) {
                this.mListener.downloadEnded(c1519k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notifyDownloadStart() {
        if (this.mListener == null) {
        }
    }

    public void setDownloadJobListener(DownloadJobListener downloadJobListener) {
        this.mListener = downloadJobListener;
    }

    public void setJsonString(String str) {
        this.mJsonString = str;
    }

    public void setModel(C1519k c1519k) {
        this.iModel = c1519k;
    }

    public void setMultipartForm(MultipartForm multipartForm) {
        this.multipart = multipartForm;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setmParams(HashMap<String, String> hashMap) {
        this.mParams = hashMap;
    }

    public void start() {
        this.mDownloadTask = new DownloadTask(this, this.timeout);
        this.mDownloadTask.execute(new Void[0]);
    }

    public void start(boolean z) {
        if (z) {
            showPrgDlg();
        }
        start();
    }
}
