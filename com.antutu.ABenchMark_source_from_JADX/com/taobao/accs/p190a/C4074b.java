package com.taobao.accs.p190a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.p190a.C4073a.C4072a;
import com.taobao.accs.utl.ALog;
import com.umeng.message.common.C4209a;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.taobao.accs.a.b */
final class C4074b implements Runnable {
    final /* synthetic */ Context f13568a;
    final /* synthetic */ C4072a f13569b;

    C4074b(Context context, C4072a c4072a) {
        this.f13568a = context;
        this.f13569b = c4072a;
    }

    public void run() {
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable th2;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (C4073a.f13564b == null) {
                Context context = this.f13568a;
                C4073a.m16614a();
            }
            if (C4073a.f13564b != null) {
                C4073a.f13564b.mkdirs();
            }
            ALog.m16904i(C4073a.TAG, "saveElectionResult electionFile", "path", C4073a.f13565c.getPath(), C4103b.ELECTION_KEY_HOST, this.f13569b.f13561a, "retry", Integer.valueOf(this.f13569b.f13562b));
            fileOutputStream = new FileOutputStream(C4073a.f13565c);
            try {
                Map hashMap = new HashMap();
                hashMap.put(C4209a.f14200c, TextUtils.isEmpty(this.f13569b.f13561a) ? BuildConfig.FLAVOR : this.f13569b.f13561a);
                hashMap.put("retry", this.f13569b.f13562b + BuildConfig.FLAVOR);
                if (C4073a.f13566d <= 0 || C4073a.f13566d >= System.currentTimeMillis()) {
                    hashMap.put("lastFlushTime", System.currentTimeMillis() + BuildConfig.FLAVOR);
                } else {
                    hashMap.put("lastFlushTime", C4073a.f13566d + BuildConfig.FLAVOR);
                }
                fileOutputStream.write(new JSONObject(hashMap).toString().getBytes(HttpRequest.f14548a));
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (IOException e) {
                fileOutputStream2 = fileOutputStream;
                try {
                    C4073a.f13564b = new File(this.f13568a.getFilesDir().getPath() + C4073a.m16621c());
                    ALog.m16904i(C4073a.TAG, "path invailable, new path=" + C4073a.f13564b, new Object[0]);
                    C4073a.f13565c = new File(C4073a.f13564b, C4103b.ELECTION_SERVICE_ID);
                    C4073a.f13563a = C4073a.f13565c.getPath();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th4) {
                }
            } catch (Throwable th5) {
                th = th5;
                try {
                    ALog.m16903e(C4073a.TAG, "saveElectionResult is error,e=" + th.toString(), new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th6) {
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th8) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e2) {
            C4073a.f13564b = new File(this.f13568a.getFilesDir().getPath() + C4073a.m16621c());
            ALog.m16904i(C4073a.TAG, "path invailable, new path=" + C4073a.f13564b, new Object[0]);
            C4073a.f13565c = new File(C4073a.f13564b, C4103b.ELECTION_SERVICE_ID);
            C4073a.f13563a = C4073a.f13565c.getPath();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th9) {
            th2 = th9;
            fileOutputStream = null;
            th = th2;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
