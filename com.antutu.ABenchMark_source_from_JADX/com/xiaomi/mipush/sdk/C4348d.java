package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.umeng.message.MsgConstant;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.mipush.sdk.d */
public class C4348d {

    /* renamed from: com.xiaomi.mipush.sdk.d.a */
    public static class C4346a extends RuntimeException {
        public C4346a(String str) {
            super(str);
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.d.b */
    public static class C4347b {
        public String f14804a;
        public boolean f14805b;
        public boolean f14806c;
        public String f14807d;

        public C4347b(String str, boolean z, boolean z2, String str2) {
            this.f14804a = str;
            this.f14805b = z;
            this.f14806c = z2;
            this.f14807d = str2;
        }
    }

    private static ActivityInfo m17822a(PackageManager packageManager, Intent intent, Class<?> cls) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, SpdyProtocol.SLIGHTSSL_L7E)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void m17823a(Context context) {
        new Thread(new C4349e(context)).start();
    }

    private static void m17825a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new C4346a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[]{activityInfo.name, boolArr[0]}));
        } else if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new C4346a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[]{activityInfo.name, boolArr[1]}));
        }
    }

    private static boolean m17826a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (C4348d.m17827a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean m17827a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        for (CharSequence equals : strArr) {
            if (TextUtils.equals(equals, str)) {
                return true;
            }
        }
        return false;
    }

    private static void m17830c(Context context) {
        ActivityInfo a;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(aa.f14991o);
        intent.setPackage(packageName);
        try {
            a = C4348d.m17822a(packageManager, intent, Class.forName("com.xiaomi.push.service.receivers.PingReceiver"));
            if (MiPushClient.shouldUseMIUIPush(context)) {
                if (a != null) {
                    C4348d.m17825a(a, new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(false)});
                }
            } else if (a == null) {
                throw new C4346a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[]{"com.xiaomi.push.service.receivers.PingReceiver"}));
            } else {
                C4348d.m17825a(a, new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(false)});
            }
        } catch (Throwable e) {
            C4302b.m17651a(e);
        }
        intent = new Intent(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intent.setPackage(packageName);
        a = C4348d.m17822a(packageManager, intent, NetworkStatusReceiver.class);
        if (a == null) {
            throw new C4346a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[]{NetworkStatusReceiver.class.getCanonicalName()}));
        }
        boolean z;
        C4348d.m17825a(a, new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(true)});
        intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(packageName);
        boolean z2 = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, SpdyProtocol.SLIGHTSSL_L7E)) {
            a = resolveInfo.activityInfo;
            if (a != null) {
                try {
                    if (!TextUtils.isEmpty(a.name) && PushMessageReceiver.class.isAssignableFrom(Class.forName(a.name)) && a.enabled) {
                        z = true;
                        if (z) {
                            break;
                        }
                        z2 = z;
                    }
                } catch (Throwable e2) {
                    C4302b.m17651a(e2);
                    z = z2;
                }
            }
            z = false;
            if (z) {
                break;
            }
            z2 = z;
        }
        z = z2;
        if (!z) {
            throw new C4346a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
        }
    }

    private static void m17831c(Context context, PackageInfo packageInfo) {
        int i;
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(new String[]{MsgConstant.PERMISSION_INTERNET, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName() + ".permission.MIPUSH_RECEIVE", MsgConstant.PERMISSION_ACCESS_WIFI_STATE, MsgConstant.PERMISSION_READ_PHONE_STATE, MsgConstant.PERMISSION_GET_TASKS, "android.permission.VIBRATE"}));
        if (packageInfo.permissions != null) {
            for (PermissionInfo permissionInfo : packageInfo.permissions) {
                if (r4.equals(permissionInfo.name)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i == 0) {
            throw new C4346a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", new Object[]{r4}));
        }
        if (packageInfo.requestedPermissions != null) {
            for (CharSequence charSequence : packageInfo.requestedPermissions) {
                if (!TextUtils.isEmpty(charSequence) && hashSet.contains(charSequence)) {
                    hashSet.remove(charSequence);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new C4346a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", new Object[]{hashSet.iterator().next()}));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m17832d(android.content.Context r13, android.content.pm.PackageInfo r14) {
        /*
        r12 = 2;
        r2 = 0;
        r11 = 1;
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = new java.util.HashMap;
        r4.<init>();
        r0 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r0 = r0.getCanonicalName();
        r1 = new com.xiaomi.mipush.sdk.d$b;
        r5 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r5 = r5.getCanonicalName();
        r6 = "";
        r1.<init>(r5, r11, r11, r6);
        r4.put(r0, r1);
        r0 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r0 = r0.getCanonicalName();
        r1 = new com.xiaomi.mipush.sdk.d$b;
        r5 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r5 = r5.getCanonicalName();
        r6 = "";
        r1.<init>(r5, r11, r2, r6);
        r4.put(r0, r1);
        r0 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r13);
        if (r0 == 0) goto L_0x004f;
    L_0x003f:
        r0 = new java.lang.String[r12];
        r1 = "com.xiaomi.push.service.XMJobService";
        r0[r2] = r1;
        r1 = "com.xiaomi.push.service.XMPushService";
        r0[r11] = r1;
        r0 = com.xiaomi.mipush.sdk.C4348d.m17826a(r14, r0);
        if (r0 == 0) goto L_0x006b;
    L_0x004f:
        r0 = "com.xiaomi.push.service.XMJobService";
        r1 = new com.xiaomi.mipush.sdk.d$b;
        r5 = "com.xiaomi.push.service.XMJobService";
        r6 = "android.permission.BIND_JOB_SERVICE";
        r1.<init>(r5, r11, r2, r6);
        r4.put(r0, r1);
        r0 = "com.xiaomi.push.service.XMPushService";
        r1 = new com.xiaomi.mipush.sdk.d$b;
        r5 = "com.xiaomi.push.service.XMPushService";
        r6 = "";
        r1.<init>(r5, r11, r2, r6);
        r4.put(r0, r1);
    L_0x006b:
        r0 = r14.services;
        if (r0 == 0) goto L_0x00fc;
    L_0x006f:
        r5 = r14.services;
        r6 = r5.length;
        r1 = r2;
    L_0x0073:
        if (r1 >= r6) goto L_0x00fc;
    L_0x0075:
        r7 = r5[r1];
        r0 = r7.name;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x011e;
    L_0x007f:
        r0 = r7.name;
        r0 = r4.containsKey(r0);
        if (r0 == 0) goto L_0x011e;
    L_0x0087:
        r0 = r7.name;
        r0 = r4.remove(r0);
        r0 = (com.xiaomi.mipush.sdk.C4348d.C4347b) r0;
        r8 = r0.f14805b;
        r9 = r0.f14806c;
        r0 = r0.f14807d;
        r10 = r7.enabled;
        if (r8 == r10) goto L_0x00b1;
    L_0x0099:
        r0 = new com.xiaomi.mipush.sdk.d$a;
        r1 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.";
        r3 = new java.lang.Object[r12];
        r4 = r7.name;
        r3[r2] = r4;
        r2 = java.lang.Boolean.valueOf(r8);
        r3[r11] = r2;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        throw r0;
    L_0x00b1:
        r8 = r7.exported;
        if (r9 == r8) goto L_0x00cd;
    L_0x00b5:
        r0 = new com.xiaomi.mipush.sdk.d$a;
        r1 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.";
        r3 = new java.lang.Object[r12];
        r4 = r7.name;
        r3[r2] = r4;
        r2 = java.lang.Boolean.valueOf(r9);
        r3[r11] = r2;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        throw r0;
    L_0x00cd:
        r8 = android.text.TextUtils.isEmpty(r0);
        if (r8 != 0) goto L_0x00ef;
    L_0x00d3:
        r8 = r7.permission;
        r8 = android.text.TextUtils.equals(r0, r8);
        if (r8 != 0) goto L_0x00ef;
    L_0x00db:
        r1 = new com.xiaomi.mipush.sdk.d$a;
        r3 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".";
        r4 = new java.lang.Object[r12];
        r5 = r7.name;
        r4[r2] = r5;
        r4[r11] = r0;
        r0 = java.lang.String.format(r3, r4);
        r1.<init>(r0);
        throw r1;
    L_0x00ef:
        r0 = r7.name;
        r7 = r7.processName;
        r3.put(r0, r7);
        r0 = r4.isEmpty();
        if (r0 == 0) goto L_0x011e;
    L_0x00fc:
        r0 = r4.isEmpty();
        if (r0 != 0) goto L_0x0123;
    L_0x0102:
        r0 = new com.xiaomi.mipush.sdk.d$a;
        r1 = "<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.";
        r3 = new java.lang.Object[r11];
        r4 = r4.keySet();
        r4 = r4.iterator();
        r4 = r4.next();
        r3[r2] = r4;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        throw r0;
    L_0x011e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0073;
    L_0x0123:
        r0 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r0 = r0.getCanonicalName();
        r0 = r3.get(r0);
        r0 = (java.lang.CharSequence) r0;
        r1 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r1 = r1.getCanonicalName();
        r1 = r3.get(r1);
        r1 = (java.lang.CharSequence) r1;
        r0 = android.text.TextUtils.equals(r0, r1);
        if (r0 != 0) goto L_0x015f;
    L_0x0141:
        r0 = new com.xiaomi.mipush.sdk.d$a;
        r1 = "\"%1$s\" and \"%2$s\" must be running in the same process.";
        r3 = new java.lang.Object[r12];
        r4 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r4 = r4.getCanonicalName();
        r3[r2] = r4;
        r2 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r2 = r2.getCanonicalName();
        r3[r11] = r2;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        throw r0;
    L_0x015f:
        r0 = "com.xiaomi.push.service.XMJobService";
        r0 = r3.containsKey(r0);
        if (r0 == 0) goto L_0x019b;
    L_0x0167:
        r0 = "com.xiaomi.push.service.XMPushService";
        r0 = r3.containsKey(r0);
        if (r0 == 0) goto L_0x019b;
    L_0x016f:
        r0 = "com.xiaomi.push.service.XMJobService";
        r0 = r3.get(r0);
        r0 = (java.lang.CharSequence) r0;
        r1 = "com.xiaomi.push.service.XMPushService";
        r1 = r3.get(r1);
        r1 = (java.lang.CharSequence) r1;
        r0 = android.text.TextUtils.equals(r0, r1);
        if (r0 != 0) goto L_0x019b;
    L_0x0185:
        r0 = new com.xiaomi.mipush.sdk.d$a;
        r1 = "\"%1$s\" and \"%2$s\" must be running in the same process.";
        r3 = new java.lang.Object[r12];
        r4 = "com.xiaomi.push.service.XMJobService";
        r3[r2] = r4;
        r2 = "com.xiaomi.push.service.XMPushService";
        r3[r11] = r2;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        throw r0;
    L_0x019b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.d.d(android.content.Context, android.content.pm.PackageInfo):void");
    }
}
