package com.taobao.accs.antibrush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService.ExtHeaderType;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.C4095e;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.util.HttpRequest;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.intent.IntentUtil;

public class AntiBrush {
    private static final String ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    public static final int STATUS_BRUSH = 419;
    private static final String TAG = "AntiBrush";
    private static String mHost;
    private static volatile boolean mIsInCheckCodeActivity;
    private static ScheduledFuture<?> mTimeoutTask;
    private BroadcastReceiver mAntiAttackReceiver;
    private Context mContext;

    public static class AntiReceiver extends BroadcastReceiver {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r6, android.content.Intent r7) {
            /*
            r5 = this;
            r0 = 0;
            r1 = "Result";
            r1 = r7.getStringExtra(r1);	 Catch:{ Exception -> 0x0033 }
            r2 = "AntiBrush";
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0033 }
            r3.<init>();	 Catch:{ Exception -> 0x0033 }
            r4 = "anti onReceive result: ";
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x0033 }
            r3 = r3.append(r1);	 Catch:{ Exception -> 0x0033 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x0033 }
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0033 }
            com.taobao.accs.utl.ALog.m16903e(r2, r3, r4);	 Catch:{ Exception -> 0x0033 }
            r2 = "success";
            r1 = r1.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x0033 }
            if (r1 == 0) goto L_0x002b;
        L_0x002a:
            r0 = 1;
        L_0x002b:
            r1 = com.taobao.accs.client.GlobalClientInfo.getContext();
            com.taobao.accs.antibrush.AntiBrush.onResult(r1, r0);
        L_0x0032:
            return;
        L_0x0033:
            r1 = move-exception;
            r2 = "AntiBrush";
            r3 = "anti onReceive";
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0046 }
            com.taobao.accs.utl.ALog.m16902e(r2, r3, r1, r4);	 Catch:{ all -> 0x0046 }
            r1 = com.taobao.accs.client.GlobalClientInfo.getContext();
            com.taobao.accs.antibrush.AntiBrush.onResult(r1, r0);
            goto L_0x0032;
        L_0x0046:
            r1 = move-exception;
            r2 = com.taobao.accs.client.GlobalClientInfo.getContext();
            com.taobao.accs.antibrush.AntiBrush.onResult(r2, r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.antibrush.AntiBrush.AntiReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    static {
        mIsInCheckCodeActivity = false;
    }

    public AntiBrush(Context context) {
        this.mAntiAttackReceiver = null;
        this.mContext = context.getApplicationContext();
    }

    private void handleantiBrush(String str) {
        if (mIsInCheckCodeActivity) {
            ALog.m16903e(TAG, "handleantiBrush return", "mIsInCheckCodeActivity", Boolean.valueOf(mIsInCheckCodeActivity));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
            intent.putExtra(HttpRequest.f14565r, str);
            ALog.m16903e(TAG, "handleAntiBrush:", new Object[0]);
            this.mContext.startActivity(intent);
            mIsInCheckCodeActivity = true;
            if (this.mAntiAttackReceiver == null) {
                this.mAntiAttackReceiver = new AntiReceiver();
            }
            this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION));
        } catch (Throwable th) {
            ALog.m16902e(TAG, "handleantiBrush", th, new Object[0]);
        }
    }

    public static void onResult(Context context, boolean z) {
        mIsInCheckCodeActivity = false;
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra(IntentUtil.AGOO_COMMAND, Constants.COMMAND_ANTI_BRUSH);
        intent.putExtra(Constants.KEY_ANTI_BRUSH_RET, z);
        C4095e.m16711a(context, intent);
        if (mTimeoutTask != null) {
            mTimeoutTask.cancel(true);
            mTimeoutTask = null;
        }
        if (mHost != null) {
            UtilityImpl.storeCookie(context, C4077b.m16628a(mHost));
        }
    }

    public boolean checkAntiBrush(URL url, Map<ExtHeaderType, String> map) {
        boolean z;
        if (map != null) {
            try {
                if (UtilityImpl.isForeground(this.mContext)) {
                    String str = (String) map.get(ExtHeaderType.TYPE_STATUS);
                    if ((TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue()) == STATUS_BRUSH) {
                        str = (String) map.get(ExtHeaderType.TYPE_LOCATION);
                        if (!TextUtils.isEmpty(str)) {
                            ALog.m16903e(TAG, "start anti bursh location:" + str, new Object[0]);
                            handleantiBrush(str);
                            if (mTimeoutTask != null) {
                                mTimeoutTask.cancel(true);
                                mTimeoutTask = null;
                            }
                            mTimeoutTask = C4089a.m16687a(new C4076a(this), 60000, TimeUnit.MILLISECONDS);
                            mHost = url == null ? null : url.getHost();
                            z = true;
                            if (!TextUtils.isEmpty(GlobalClientInfo.f13606a) && TextUtils.isEmpty(C4077b.m16628a(mHost))) {
                                ALog.m16903e(TAG, "cookie invalid, clear", new Object[0]);
                                UtilityImpl.clearCookie(this.mContext);
                            }
                            return z;
                        }
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                z = false;
                ALog.m16902e(TAG, "checkAntiBrush error", th2, new Object[0]);
                return z;
            }
        }
        z = false;
        try {
            ALog.m16903e(TAG, "cookie invalid, clear", new Object[0]);
            UtilityImpl.clearCookie(this.mContext);
        } catch (Throwable th3) {
            th2 = th3;
            ALog.m16902e(TAG, "checkAntiBrush error", th2, new Object[0]);
            return z;
        }
        return z;
    }
}
