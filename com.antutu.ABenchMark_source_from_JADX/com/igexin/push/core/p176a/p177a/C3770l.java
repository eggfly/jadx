package com.igexin.push.core.p176a.p177a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.facebook.ads.AdError;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3794a;
import com.igexin.push.core.C3820b;
import com.igexin.push.core.C3854f;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C3835o;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p176a.C3777e;
import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.l */
public class C3770l implements C3759a {
    private static final String f12691b;
    private static final String f12692c;
    private static final String f12693d;
    private PackageManager f12694a;

    static {
        f12691b = C3794a.f12734n;
        f12692c = C3794a.f12736p;
        f12693d = C3794a.f12735o;
    }

    private String m15460a(String str) {
        try {
            List<PackageInfo> installedPackages = C3855g.f12969g.getPackageManager().getInstalledPackages(4);
            if (installedPackages != null) {
                for (PackageInfo packageInfo : installedPackages) {
                    if (str.equals(packageInfo.packageName)) {
                        for (ServiceInfo serviceInfo : packageInfo.services) {
                            if (f12691b.equals(serviceInfo.name) || f12693d.equals(serviceInfo.name) || f12692c.equals(serviceInfo.name)) {
                                return serviceInfo.name;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            C3688a.m15097b(e.toString());
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List m15461a(int r14, java.lang.String r15) {
        /*
        r13 = this;
        r6 = new java.io.File;
        r0 = "/sdcard/libs";
        r6.<init>(r0);
        r0 = r6.exists();
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        r1 = 0;
    L_0x000e:
        return r1;
    L_0x000f:
        r7 = r6.list();
        if (r7 != 0) goto L_0x0017;
    L_0x0015:
        r1 = 0;
        goto L_0x000e;
    L_0x0017:
        r1 = 0;
        r0 = 0;
        r2 = r0;
    L_0x001a:
        r0 = r7.length;
        if (r2 >= r0) goto L_0x0201;
    L_0x001d:
        r0 = r7[r2];
        r3 = ".db";
        r0 = r0.indexOf(r3);
        if (r0 <= 0) goto L_0x024b;
    L_0x0027:
        r0 = r7[r2];
        r3 = "app.db";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x024b;
    L_0x0031:
        r0 = r7[r2];
        r3 = "imsi.db";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x024b;
    L_0x003b:
        r0 = r7[r2];
        r3 = "com.igexin.sdk.deviceId.db";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x024b;
    L_0x0045:
        r3 = 0;
        r4 = 0;
        r0 = r7[r2];	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5 = 0;
        r8 = r7[r2];	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r8 = r8.length();	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r8 = r8 + -3;
        r8 = r0.substring(r5, r8);	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5.<init>();	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r9 = "/";
        r5 = r5.append(r9);	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r9 = r7[r2];	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5 = r5.append(r9);	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r0.<init>(r5);	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r9 = new byte[r5];	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r5.<init>(r0);	 Catch:{ Exception -> 0x0236, all -> 0x022d }
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x023f, all -> 0x0232 }
        r3.<init>();	 Catch:{ Exception -> 0x023f, all -> 0x0232 }
    L_0x0082:
        r0 = r5.read(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r4 = -1;
        if (r0 == r4) goto L_0x00bd;
    L_0x0089:
        r4 = 0;
        r3.write(r9, r4, r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        goto L_0x0082;
    L_0x008e:
        r0 = move-exception;
        r4 = r5;
        r11 = r0;
        r0 = r1;
        r1 = r11;
    L_0x0093:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0229 }
        r5.<init>();	 Catch:{ all -> 0x0229 }
        r8 = "WakeupAction";
        r5 = r5.append(r8);	 Catch:{ all -> 0x0229 }
        r1 = r1.toString();	 Catch:{ all -> 0x0229 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x0229 }
        r1 = r1.toString();	 Catch:{ all -> 0x0229 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r1);	 Catch:{ all -> 0x0229 }
        if (r4 == 0) goto L_0x00b2;
    L_0x00af:
        r4.close();	 Catch:{ IOException -> 0x01eb }
    L_0x00b2:
        if (r3 == 0) goto L_0x00b7;
    L_0x00b4:
        r3.close();	 Catch:{ IOException -> 0x01f1 }
    L_0x00b7:
        r1 = r2 + 1;
        r2 = r1;
        r1 = r0;
        goto L_0x001a;
    L_0x00bd:
        r4 = r3.toByteArray();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0 = com.igexin.push.core.C3855g.f12984v;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        if (r0 != 0) goto L_0x0179;
    L_0x00c5:
        r0 = "cantgetimei";
    L_0x00c7:
        r0 = com.igexin.p158b.p168b.C3700a.m15132a(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r4, r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9.<init>(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0 = "\\|";
        r4 = r9.split(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0 = java.lang.System.out;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9.<init>();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r10 = "length=";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r10 = r4.length;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = r9.toString();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0.println(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0 = 0;
        r0 = r4[r0];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = "v";
        r0 = r0.startsWith(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        if (r0 == 0) goto L_0x0114;
    L_0x00fe:
        r0 = 0;
        r0 = r4[r0];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = "null";
        r0 = r0.contains(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        if (r0 == 0) goto L_0x017d;
    L_0x0109:
        r0 = 0;
        r9 = 0;
        r9 = r4[r9];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r10 = 7;
        r9 = r9.substring(r10);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r4[r0] = r9;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
    L_0x0114:
        r0 = 0;
        r9 = r4.length;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r10 = 2;
        if (r9 <= r10) goto L_0x013d;
    L_0x0119:
        r0 = 2;
        r0 = r4[r0];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        if (r0 == 0) goto L_0x013d;
    L_0x011e:
        r9 = "null";
        r9 = r0.equals(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        if (r9 == 0) goto L_0x0127;
    L_0x0126:
        r0 = 0;
    L_0x0127:
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9.<init>();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r10 = "WakeupAction get check form db file : ";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = r9.append(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = r9.toString();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
    L_0x013d:
        if (r0 != 0) goto L_0x015c;
    L_0x013f:
        r0 = 0;
        r0 = r4[r0];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0 = com.igexin.p158b.p168b.C3700a.m15132a(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9.<init>();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r10 = "WakeupAction check cid form md5 session : ";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = r9.append(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = r9.toString();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
    L_0x015c:
        if (r14 != 0) goto L_0x01a0;
    L_0x015e:
        r0 = r15.equals(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        if (r0 == 0) goto L_0x01d3;
    L_0x0164:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0.<init>();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0.add(r8);	 Catch:{ Exception -> 0x0247, all -> 0x018a }
        if (r5 == 0) goto L_0x0171;
    L_0x016e:
        r5.close();	 Catch:{ IOException -> 0x0196 }
    L_0x0171:
        if (r3 == 0) goto L_0x0176;
    L_0x0173:
        r3.close();	 Catch:{ IOException -> 0x019b }
    L_0x0176:
        r1 = r0;
        goto L_0x000e;
    L_0x0179:
        r0 = com.igexin.push.core.C3855g.f12984v;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        goto L_0x00c7;
    L_0x017d:
        r0 = 0;
        r9 = 0;
        r9 = r4[r9];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r10 = 20;
        r9 = r9.substring(r10);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r4[r0] = r9;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        goto L_0x0114;
    L_0x018a:
        r0 = move-exception;
    L_0x018b:
        if (r5 == 0) goto L_0x0190;
    L_0x018d:
        r5.close();	 Catch:{ IOException -> 0x01f7 }
    L_0x0190:
        if (r3 == 0) goto L_0x0195;
    L_0x0192:
        r3.close();	 Catch:{ IOException -> 0x01fc }
    L_0x0195:
        throw r0;
    L_0x0196:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0171;
    L_0x019b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0176;
    L_0x01a0:
        r0 = r4.length;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = 1;
        if (r0 <= r9) goto L_0x01d3;
    L_0x01a4:
        r0 = 1;
        r0 = r4[r0];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0 = r15.equals(r0);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        if (r0 == 0) goto L_0x01b8;
    L_0x01ad:
        if (r1 != 0) goto L_0x01b5;
    L_0x01af:
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r0.<init>();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r1 = r0;
    L_0x01b5:
        r1.add(r8);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
    L_0x01b8:
        r0 = "WakeupAction";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r8.<init>();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = "check from appid=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r9 = 1;
        r4 = r4[r9];	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r4 = r8.append(r4);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        r4 = r4.toString();	 Catch:{ Exception -> 0x008e, all -> 0x018a }
        com.igexin.p158b.p159a.p167c.C3688a.m15096a(r0, r4);	 Catch:{ Exception -> 0x008e, all -> 0x018a }
    L_0x01d3:
        r0 = r1;
        if (r5 == 0) goto L_0x01d9;
    L_0x01d6:
        r5.close();	 Catch:{ IOException -> 0x01e6 }
    L_0x01d9:
        if (r3 == 0) goto L_0x00b7;
    L_0x01db:
        r3.close();	 Catch:{ IOException -> 0x01e0 }
        goto L_0x00b7;
    L_0x01e0:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00b7;
    L_0x01e6:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01d9;
    L_0x01eb:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00b2;
    L_0x01f1:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00b7;
    L_0x01f7:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0190;
    L_0x01fc:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0195;
    L_0x0201:
        if (r1 == 0) goto L_0x000e;
    L_0x0203:
        r0 = r1.size();
        r2 = 1;
        if (r0 != r2) goto L_0x000e;
    L_0x020a:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "WakeupAction check finished, final pkg is  : ";
        r2 = r0.append(r2);
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);
        goto L_0x000e;
    L_0x0229:
        r0 = move-exception;
        r5 = r4;
        goto L_0x018b;
    L_0x022d:
        r0 = move-exception;
        r5 = r3;
        r3 = r4;
        goto L_0x018b;
    L_0x0232:
        r0 = move-exception;
        r3 = r4;
        goto L_0x018b;
    L_0x0236:
        r0 = move-exception;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        r12 = r3;
        r3 = r4;
        r4 = r12;
        goto L_0x0093;
    L_0x023f:
        r0 = move-exception;
        r3 = r4;
        r4 = r5;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x0093;
    L_0x0247:
        r1 = move-exception;
        r4 = r5;
        goto L_0x0093;
    L_0x024b:
        r0 = r1;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.l.a(int, java.lang.String):java.util.List");
    }

    private void m15463a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C3855g.f12969g.getPackageName());
        stringBuilder.append("#");
        stringBuilder.append(str4);
        stringBuilder.append("#");
        stringBuilder.append(str5);
        stringBuilder.append("#");
        stringBuilder.append("-1");
        m15469b("30025", stringBuilder.toString(), str, str2, str3);
        C3688a.m15097b("feedback actionId=30025 result=" + stringBuilder.toString());
    }

    private void m15464a(String str, boolean z, PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            String a = m15460a(str);
            String messageId = pushTaskBean.getMessageId();
            String taskId = pushTaskBean.getTaskId();
            String a2 = ((C3835o) baseAction).m15787a();
            m15468b(str);
            if (a != null) {
                Map hashMap = new HashMap();
                hashMap.put("messageId", messageId);
                hashMap.put("taskId", taskId);
                hashMap.put(AgooConstants.MESSAGE_ID, a2);
                hashMap.put("pkgName", str);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(C3855g.f12969g.getPackageName());
                stringBuffer.append("#");
                stringBuffer.append(m15472d(str));
                stringBuffer.append("#");
                stringBuffer.append(str);
                stringBuffer.append("/");
                if (a.equals(f12691b)) {
                    stringBuffer.append(f12691b);
                    stringBuffer.append("#");
                    if (C3770l.m15467a(str, f12691b)) {
                        stringBuffer.append(MessageService.MSG_DB_READY_REPORT);
                    } else {
                        if (z) {
                            try {
                                Intent intent = new Intent();
                                intent.setClassName(str, a);
                                intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
                                intent.putExtra("op_app", C3855g.f12967e);
                                intent.putExtra("isSlave", true);
                                C3855g.f12969g.startService(intent);
                            } catch (Exception e) {
                                C3688a.m15097b(e.toString());
                                m15465a(stringBuffer, messageId, taskId, a2);
                                return;
                            }
                        } else if (!m15470b(str, a)) {
                            m15465a(stringBuffer, messageId, taskId, a2);
                            return;
                        }
                        hashMap.put("serviceName", f12691b);
                        m15466a(hashMap);
                        stringBuffer.append(MessageService.MSG_DB_NOTIFY_REACHED);
                    }
                } else if (a.equals(f12693d)) {
                    stringBuffer.append(f12693d);
                    stringBuffer.append("#");
                    if (C3770l.m15467a(str, f12693d)) {
                        stringBuffer.append(MessageService.MSG_DB_READY_REPORT);
                    } else if (m15470b(str, a)) {
                        hashMap.put("serviceName", f12693d);
                        m15466a(hashMap);
                        stringBuffer.append(MessageService.MSG_DB_NOTIFY_REACHED);
                    } else {
                        m15465a(stringBuffer, messageId, taskId, a2);
                        return;
                    }
                } else if (a.equals(f12692c)) {
                    stringBuffer.append(f12692c);
                    stringBuffer.append("#");
                    if (C3770l.m15467a(str, f12692c)) {
                        stringBuffer.append(MessageService.MSG_DB_READY_REPORT);
                    } else if (m15470b(str, a)) {
                        hashMap.put("serviceName", f12692c);
                        m15466a(hashMap);
                        stringBuffer.append(MessageService.MSG_DB_NOTIFY_REACHED);
                    } else {
                        m15465a(stringBuffer, messageId, taskId, a2);
                        return;
                    }
                }
                m15469b("30025", stringBuffer.toString(), messageId, taskId, a2);
                C3688a.m15097b("feedback actionId=30025 result=" + stringBuffer.toString());
                return;
            }
            m15463a(messageId, taskId, a2, ((C3835o) baseAction).m15794d() != null ? ((C3835o) baseAction).m15794d() : BuildConfig.FLAVOR, ((C3835o) baseAction).m15792c() != null ? ((C3835o) baseAction).m15792c() : BuildConfig.FLAVOR);
        } catch (Exception e2) {
            C3688a.m15097b(e2.toString());
        }
    }

    private void m15465a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("-1");
        m15469b("30025", stringBuffer.toString(), str, str2, str3);
        C3688a.m15097b("feedback actionId=30025 result=" + stringBuffer.toString());
    }

    private void m15466a(Map map) {
        C3854f.m15859a().m15868a(new C3771m(this, 180000, map));
    }

    public static boolean m15467a(String str, String str2) {
        List runningServices = ((ActivityManager) C3855g.f12969g.getSystemService("activity")).getRunningServices(AdError.SERVER_ERROR_CODE);
        if (runningServices.size() <= 0) {
            return false;
        }
        int i = 0;
        while (i < runningServices.size()) {
            if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().equals(str2) && ((RunningServiceInfo) runningServices.get(i)).service.getPackageName().equals(str)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private void m15468b(String str) {
        if (m15471c(str)) {
            try {
                Cursor query = C3855g.f12969g.getContentResolver().query(Uri.parse("content://downloads." + str + "/download"), null, null, null, null);
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                C3688a.m15097b(e.toString());
            }
        }
    }

    private void m15469b(String str, String str2, String str3, String str4, String str5) {
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(C3855g.f12963a);
        pushTaskBean.setMessageId(str3);
        pushTaskBean.setTaskId(str4);
        pushTaskBean.setId(str5);
        pushTaskBean.setAppKey(C3855g.f12964b);
        C3777e.m15491a().m15518a(pushTaskBean, str, str2);
    }

    private boolean m15470b(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            C3855g.f12969g.startService(intent);
            return true;
        } catch (Exception e) {
            C3688a.m15097b(e.toString());
            return false;
        }
    }

    private boolean m15471c(String str) {
        try {
            this.f12694a = C3855g.f12969g.getPackageManager();
            PackageInfo packageInfo = this.f12694a.getPackageInfo(str, 8);
            if (packageInfo == null) {
                return false;
            }
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return false;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo.name.equals("com.igexin.download.DownloadProvider") && providerInfo.authority.equals("downloads." + str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private String m15472d(String str) {
        try {
            this.f12694a = C3855g.f12969g.getPackageManager();
            Bundle bundle = this.f12694a.getApplicationInfo(str, SpdyProtocol.SLIGHTSSLV2).metaData;
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    if (str2.equals("PUSH_APPID")) {
                        return bundle.get(str2).toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return BuildConfig.FLAVOR;
    }

    public C3820b m15473a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return C3820b.success;
    }

    public BaseAction m15474a(JSONObject jSONObject) {
        try {
            if (C3754m.f12673q && jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has(C4233j.f14402y) && (jSONObject.has("pkgname") || jSONObject.has(ACTD.APPID_KEY) || jSONObject.has(IXAdRequestInfo.CELL_ID))) {
                BaseAction c3835o = new C3835o();
                c3835o.setType("wakeupsdk");
                c3835o.setActionId(jSONObject.getString("actionid"));
                c3835o.setDoActionId(jSONObject.getString("do"));
                if (jSONObject.has("pkgname")) {
                    c3835o.m15790b(jSONObject.getString("pkgname"));
                } else if (jSONObject.has(IXAdRequestInfo.CELL_ID)) {
                    c3835o.m15795d(jSONObject.getString(IXAdRequestInfo.CELL_ID));
                } else if (jSONObject.has(ACTD.APPID_KEY)) {
                    c3835o.m15793c(jSONObject.getString(ACTD.APPID_KEY));
                }
                if (jSONObject.has("is_forcestart")) {
                    c3835o.m15789a(jSONObject.getBoolean("is_forcestart"));
                }
                if (!jSONObject.has(AgooConstants.MESSAGE_ID)) {
                    return c3835o;
                }
                c3835o.m15788a(jSONObject.getString(AgooConstants.MESSAGE_ID));
                return c3835o;
            }
        } catch (JSONException e) {
            C3688a.m15097b(e.toString());
        }
        return null;
    }

    public boolean m15475b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null)) {
            boolean z;
            boolean z2;
            C3835o c3835o = (C3835o) baseAction;
            String c = c3835o.m15792c();
            if (c != null || c3835o.m15796e() == null) {
                z = true;
            } else {
                List a = m15461a(0, c3835o.m15796e());
                if (a == null || a.size() != 1) {
                    z = false;
                } else {
                    c = (String) a.get(0);
                    z = true;
                }
            }
            if (c != null) {
                m15464a(c, c3835o.m15791b(), pushTaskBean, baseAction);
                z2 = z;
            } else if (c3835o.m15794d() != null) {
                List<String> a2 = m15461a(1, c3835o.m15794d());
                if (a2 == null || a2.size() <= 0) {
                    z2 = false;
                } else {
                    for (String c2 : a2) {
                        m15464a(c2, c3835o.m15791b(), pushTaskBean, baseAction);
                    }
                    z2 = z;
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                m15463a(pushTaskBean.getMessageId(), pushTaskBean.getTaskId(), ((C3835o) baseAction).m15787a(), ((C3835o) baseAction).m15794d() != null ? ((C3835o) baseAction).m15794d() : BuildConfig.FLAVOR, ((C3835o) baseAction).m15792c() != null ? ((C3835o) baseAction).m15792c() : BuildConfig.FLAVOR);
            }
            if (!baseAction.getDoActionId().equals(BuildConfig.FLAVOR)) {
                C3777e.m15491a().m15532a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
            }
        }
        return true;
    }
}
