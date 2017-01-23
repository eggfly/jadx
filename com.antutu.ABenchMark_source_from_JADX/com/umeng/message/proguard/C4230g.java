package com.umeng.message.proguard;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.widget.Toast;
import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.C4135a;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.Ucode;
import com.umeng.message.proguard.C4230g.19.C42201;
import com.umeng.message.proguard.g.AnonymousClass10;
import com.umeng.message.proguard.g.AnonymousClass11;
import com.umeng.message.proguard.g.AnonymousClass12;
import com.umeng.message.proguard.g.AnonymousClass13;
import com.umeng.message.proguard.g.AnonymousClass14;
import com.umeng.message.proguard.g.AnonymousClass15;
import com.umeng.message.proguard.g.AnonymousClass16;
import com.umeng.message.proguard.g.AnonymousClass17;
import com.umeng.message.proguard.g.AnonymousClass18;
import com.umeng.message.proguard.g.AnonymousClass19;
import com.umeng.message.proguard.g.AnonymousClass20;
import com.umeng.message.proguard.g.AnonymousClass21;
import com.umeng.message.proguard.g.AnonymousClass22;
import com.umeng.message.proguard.g.AnonymousClass23;
import com.umeng.message.proguard.g.AnonymousClass24;
import com.umeng.message.proguard.g.AnonymousClass25;
import com.umeng.message.proguard.g.AnonymousClass26;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.umeng.message.proguard.g */
public class C4230g {
    public static final String f14371a;
    private static final String f14372b = "Helper";

    /* renamed from: com.umeng.message.proguard.g.10 */
    static class AnonymousClass10 implements Runnable {
        final /* synthetic */ Context f14343a;

        AnonymousClass10(Context context) {
            this.f14343a = context;
        }

        public void run() {
            Toast.makeText(this.f14343a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.11 */
    static class AnonymousClass11 implements Runnable {
        final /* synthetic */ Context f14344a;

        AnonymousClass11(Context context) {
            this.f14344a = context;
        }

        public void run() {
            Toast.makeText(this.f14344a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.12 */
    static class AnonymousClass12 implements Runnable {
        final /* synthetic */ Context f14345a;

        AnonymousClass12(Context context) {
            this.f14345a = context;
        }

        public void run() {
            Toast.makeText(this.f14345a, "Please set umeng appsecret!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.13 */
    static class AnonymousClass13 implements Runnable {
        final /* synthetic */ Context f14346a;

        AnonymousClass13(Context context) {
            this.f14346a = context;
        }

        public void run() {
            Toast.makeText(this.f14346a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.14 */
    static class AnonymousClass14 implements Runnable {
        final /* synthetic */ Context f14347a;

        AnonymousClass14(Context context) {
            this.f14347a = context;
        }

        public void run() {
            Toast.makeText(this.f14347a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.15 */
    static class AnonymousClass15 implements Runnable {
        final /* synthetic */ Context f14348a;

        AnonymousClass15(Context context) {
            this.f14348a = context;
        }

        public void run() {
            Toast.makeText(this.f14348a, "Please add or correct UmengDownloadResourceService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.16 */
    static class AnonymousClass16 implements Runnable {
        final /* synthetic */ Context f14349a;

        AnonymousClass16(Context context) {
            this.f14349a = context;
        }

        public void run() {
            Toast.makeText(this.f14349a, "Please add or correct ChannelService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.17 */
    static class AnonymousClass17 implements Runnable {
        final /* synthetic */ Context f14350a;

        AnonymousClass17(Context context) {
            this.f14350a = context;
        }

        public void run() {
            Toast.makeText(this.f14350a, "Please add or correct UmengMessageIntentReceiverService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.18 */
    static class AnonymousClass18 implements Runnable {
        final /* synthetic */ Context f14351a;

        AnonymousClass18(Context context) {
            this.f14351a = context;
        }

        public void run() {
            Toast.makeText(this.f14351a, "Please add required permission in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.19 */
    static class AnonymousClass19 implements Runnable {
        final /* synthetic */ Context f14353a;
        final /* synthetic */ Handler f14354b;

        /* renamed from: com.umeng.message.proguard.g.19.1 */
        class C42201 implements Runnable {
            final /* synthetic */ AnonymousClass19 f14352a;

            C42201(AnonymousClass19 anonymousClass19) {
                this.f14352a = anonymousClass19;
            }

            public void run() {
                Toast.makeText(this.f14352a.f14353a, "mPushAgent.register should be called in both main process and channel process!", 1).show();
            }
        }

        AnonymousClass19(Context context, Handler handler) {
            this.f14353a = context;
            this.f14354b = handler;
        }

        public void run() {
            if (Integer.valueOf(MessageSharedPrefs.getInstance(this.f14353a).getTempValue(MsgConstant.KEY_REGISTER_TIMES, MessageService.MSG_DB_READY_REPORT)).intValue() <= 1) {
                UmLog.m17138e(C4230g.f14372b, "mPushAgent.register should be called in both main process and channel process!");
                for (int i = 0; i < 3; i++) {
                    this.f14354b.postDelayed(new C42201(this), (long) (i * 3500));
                }
            }
        }
    }

    /* renamed from: com.umeng.message.proguard.g.1 */
    static class C42211 implements Runnable {
        final /* synthetic */ Context f14355a;

        C42211(Context context) {
            this.f14355a = context;
        }

        public void run() {
            Toast.makeText(this.f14355a, "Please set umeng appkey!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.20 */
    static class AnonymousClass20 implements Runnable {
        final /* synthetic */ Context f14356a;

        AnonymousClass20(Context context) {
            this.f14356a = context;
        }

        public void run() {
            Toast.makeText(this.f14356a, "Please add or correct UmengService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.21 */
    static class AnonymousClass21 implements Runnable {
        final /* synthetic */ Context f14357a;

        AnonymousClass21(Context context) {
            this.f14357a = context;
        }

        public void run() {
            Toast.makeText(this.f14357a, "Please add or correct ChannelService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.22 */
    static class AnonymousClass22 implements Runnable {
        final /* synthetic */ Context f14358a;

        AnonymousClass22(Context context) {
            this.f14358a = context;
        }

        public void run() {
            Toast.makeText(this.f14358a, "Please add or correct MsgDistributeService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.23 */
    static class AnonymousClass23 implements Runnable {
        final /* synthetic */ Context f14359a;

        AnonymousClass23(Context context) {
            this.f14359a = context;
        }

        public void run() {
            Toast.makeText(this.f14359a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.24 */
    static class AnonymousClass24 implements Runnable {
        final /* synthetic */ Context f14360a;

        AnonymousClass24(Context context) {
            this.f14360a = context;
        }

        public void run() {
            Toast.makeText(this.f14360a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.25 */
    static class AnonymousClass25 implements Runnable {
        final /* synthetic */ Context f14361a;

        AnonymousClass25(Context context) {
            this.f14361a = context;
        }

        public void run() {
            Toast.makeText(this.f14361a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.26 */
    static class AnonymousClass26 implements Runnable {
        final /* synthetic */ Context f14362a;

        AnonymousClass26(Context context) {
            this.f14362a = context;
        }

        public void run() {
            Toast.makeText(this.f14362a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.2 */
    static class C42222 implements Runnable {
        final /* synthetic */ Context f14363a;

        C42222(Context context) {
            this.f14363a = context;
        }

        public void run() {
            Toast.makeText(this.f14363a, "Please add or correct ServiceReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.3 */
    static class C42233 implements Runnable {
        final /* synthetic */ Context f14364a;

        C42233(Context context) {
            this.f14364a = context;
        }

        public void run() {
            Toast.makeText(this.f14364a, "Please add or correct ServiceReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.4 */
    static class C42244 implements Runnable {
        final /* synthetic */ Context f14365a;

        C42244(Context context) {
            this.f14365a = context;
        }

        public void run() {
            Toast.makeText(this.f14365a, "Please add or correct KernelService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.5 */
    static class C42255 implements Runnable {
        final /* synthetic */ Context f14366a;

        C42255(Context context) {
            this.f14366a = context;
        }

        public void run() {
            Toast.makeText(this.f14366a, "Please add or correct UmengIntentService in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.6 */
    static class C42266 implements Runnable {
        final /* synthetic */ Context f14367a;

        C42266(Context context) {
            this.f14367a = context;
        }

        public void run() {
            Toast.makeText(this.f14367a, "Please replace '${applicationId}.intent.action.COMMAND' with application's applicationId for AgooCommondReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.7 */
    static class C42277 implements Runnable {
        final /* synthetic */ Context f14368a;

        C42277(Context context) {
            this.f14368a = context;
        }

        public void run() {
            Toast.makeText(this.f14368a, "Please add or correct AgooCommondReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.8 */
    static class C42288 implements Runnable {
        final /* synthetic */ Context f14369a;

        C42288(Context context) {
            this.f14369a = context;
        }

        public void run() {
            Toast.makeText(this.f14369a, "Please add or correct BootBroadcastReceiver in AndroidManifest!", 1).show();
        }
    }

    /* renamed from: com.umeng.message.proguard.g.9 */
    static class C42299 implements Runnable {
        final /* synthetic */ Context f14370a;

        C42299(Context context) {
            this.f14370a = context;
        }

        public void run() {
            Toast.makeText(this.f14370a, "Please add or correct NotificationProxyBroadcastReceiver in AndroidManifest!", 1).show();
        }
    }

    static {
        f14371a = System.getProperty("line.separator");
    }

    public static String m17256a() {
        return C4230g.m17262a(new Date());
    }

    public static String m17257a(Context context, int i) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return BuildConfig.FLAVOR;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static String m17258a(Context context, long j) {
        String str = BuildConfig.FLAVOR;
        if (j < 1000) {
            return ((int) j) + "B";
        }
        if (j < 1000000) {
            return Math.round(((double) ((float) j)) / 1000.0d) + "K";
        }
        if (j < 1000000000) {
            return new DecimalFormat("#0.0").format(((double) ((float) j)) / 1000000.0d) + "M";
        }
        return new DecimalFormat("#0.00").format(((double) ((float) j)) / 1.0E9d) + "G";
    }

    public static String m17259a(File file) {
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        try {
            if (!file.isFile()) {
                return BuildConfig.FLAVOR;
            }
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    BigInteger bigInteger = new BigInteger(1, instance.digest());
                    return String.format("%1$032x", new Object[]{bigInteger});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String m17260a(Object obj) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new String(C4217c.m17243c(byteArrayOutputStream.toByteArray()));
        } catch (IOException e) {
            return null;
        }
    }

    public static String m17261a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.reset();
            instance.update(bytes);
            bytes = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bytes[i])}));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", BuildConfig.FLAVOR);
        }
    }

    public static String m17262a(Date date) {
        return date == null ? BuildConfig.FLAVOR : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String m17263a(List<Ucode> list) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        String encode = URLEncoder.encode(byteArrayOutputStream.toString(C4218e.f14336a), HttpRequest.f14548a);
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return encode;
    }

    public static void m17264a(Context context, Class<?> cls) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) > -1) {
                ComponentName componentName = new ComponentName(context, cls);
                int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
                if (componentEnabledSetting != 1 && componentEnabledSetting != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 1, 1);
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void m17265a(Context context, String str) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
    }

    public static void m17266a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static boolean m17267a(Context context) {
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            String packageName = context.getPackageName();
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean m17268a(Context context, Handler handler) {
        if (!PushAgent.getInstance(context).isPushCheck()) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageAppkey())) {
                handler.post(new C42211(context));
                return false;
            } else if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageSecret())) {
                handler.post(new AnonymousClass12(context));
                return false;
            } else {
                Object obj;
                CharSequence charSequence = BuildConfig.FLAVOR;
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_SERVICE);
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo.serviceInfo.name.equals(C4135a.channelService)) {
                        charSequence = resolveInfo.serviceInfo.processName;
                        if (!(TextUtils.isEmpty(charSequence) || TextUtils.equals(charSequence, context.getPackageName()) || !resolveInfo.serviceInfo.exported)) {
                            obj = 1;
                            break;
                        }
                    }
                    charSequence = charSequence;
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass20(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_ELECTION);
                for (ResolveInfo resolveInfo2 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo2.serviceInfo.name.equals(C4135a.channelService) && TextUtils.equals(r2, resolveInfo2.serviceInfo.processName) && resolveInfo2.serviceInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass21(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_RECEIVE);
                for (ResolveInfo resolveInfo22 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo22.serviceInfo.name.equals(C4135a.msgService) && resolveInfo22.serviceInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass22(context));
                    return false;
                }
                CharSequence charSequence2;
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(PushConsts.ACTION_BROADCAST_TO_BOOT);
                for (ResolveInfo resolveInfo222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    CharSequence charSequence3;
                    if (resolveInfo222.activityInfo.name.equals("com.taobao.accs.EventReceiver")) {
                        charSequence3 = resolveInfo222.activityInfo.processName;
                        if (!(TextUtils.isEmpty(charSequence3) || TextUtils.equals(charSequence3, context.getPackageName()))) {
                            charSequence2 = charSequence3;
                            obj = 1;
                            break;
                        }
                    }
                    charSequence3 = charSequence;
                    charSequence = charSequence3;
                }
                obj = null;
                charSequence2 = charSequence;
                if (obj == null) {
                    handler.post(new AnonymousClass23(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                for (ResolveInfo resolveInfo2222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo2222.activityInfo.name.equals("com.taobao.accs.EventReceiver") && TextUtils.equals(r3, resolveInfo2222.activityInfo.processName)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass24(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("android.intent.action.PACKAGE_REMOVED");
                intent.setData(Uri.parse("package:"));
                for (ResolveInfo resolveInfo22222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo22222.activityInfo.name.equals("com.taobao.accs.EventReceiver")) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass25(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
                for (ResolveInfo resolveInfo222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo222222.activityInfo.name.equals("com.taobao.accs.EventReceiver")) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass26(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_COMMAND);
                for (ResolveInfo resolveInfo2222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo2222222.activityInfo.name.equals("com.taobao.accs.ServiceReceiver") && TextUtils.equals(r3, resolveInfo2222222.activityInfo.processName)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42222(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_START_FROM_AGOO);
                for (ResolveInfo resolveInfo22222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo22222222.activityInfo.name.equals("com.taobao.accs.ServiceReceiver") && TextUtils.equals(r3, resolveInfo22222222.activityInfo.processName)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42233(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_RECEIVE);
                for (ResolveInfo resolveInfo222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo222222222.serviceInfo.name.equals("org.android.agoo.accs.AgooService") && resolveInfo222222222.serviceInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42244(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
                for (ResolveInfo resolveInfo2222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo2222222222.serviceInfo.name.equals("com.umeng.message.UmengIntentService") && resolveInfo2222222222.serviceInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42255(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(context.getPackageName() + ".intent.action.COMMAND");
                for (ResolveInfo resolveInfo22222222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo22222222222.activityInfo.name.equals("com.taobao.agoo.AgooCommondReceiver") && resolveInfo22222222222.activityInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42266(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("android.intent.action.PACKAGE_REMOVED");
                intent.setData(Uri.parse("package:"));
                for (ResolveInfo resolveInfo222222222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo222222222222.activityInfo.name.equals("com.taobao.agoo.AgooCommondReceiver") && resolveInfo222222222222.activityInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42277(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(AgooConstants.BINDER_MSGRECEIVER_ACTION);
                for (ResolveInfo resolveInfo2222222222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                    if (resolveInfo2222222222222.activityInfo.name.equals("com.taobao.agoo.TaobaoMessageIntentReceiverService") && resolveInfo2222222222222.activityInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42288(context));
                    return false;
                }
                intent = new Intent();
                intent.setClassName(context.getPackageName(), "com.umeng.message.NotificationProxyBroadcastReceiver");
                for (ResolveInfo resolveInfo22222222222222 : context.getPackageManager().queryBroadcastReceivers(intent, AccessibilityNodeInfoCompat.ACTION_CUT)) {
                    if (resolveInfo22222222222222.activityInfo.name.equals("com.umeng.message.NotificationProxyBroadcastReceiver") && TextUtils.equals(resolveInfo22222222222222.activityInfo.processName, context.getPackageName()) && !resolveInfo22222222222222.activityInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new C42299(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
                for (ResolveInfo resolveInfo222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo222222222222222.serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService") && TextUtils.equals(context.getPackageName(), resolveInfo222222222222222.serviceInfo.processName) && !resolveInfo222222222222222.serviceInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass10(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("com.umeng.message.unregistercallback.action");
                for (ResolveInfo resolveInfo2222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo2222222222222222.serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass11(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
                for (ResolveInfo resolveInfo22222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo22222222222222222.serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass13(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(MsgConstant.MESSAGE_AUTOUPDATE_HANDLER_ACTION);
                for (ResolveInfo resolveInfo222222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo222222222222222222.serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass14(context));
                    return false;
                }
                intent = new Intent();
                intent.setClassName(context.getPackageName(), "com.umeng.message.UmengDownloadResourceService");
                for (ResolveInfo resolveInfo2222222222222222222 : context.getPackageManager().queryIntentServices(intent, AccessibilityNodeInfoCompat.ACTION_CUT)) {
                    if (resolveInfo2222222222222222222.serviceInfo.name.equals("com.umeng.message.UmengDownloadResourceService")) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass15(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("om.taobao.accs.intent.action.SERVICE");
                for (ResolveInfo resolveInfo22222222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo22222222222222222222.serviceInfo.name.equals(C4135a.channelService) && TextUtils.equals(r3, resolveInfo22222222222222222222.serviceInfo.processName) && resolveInfo22222222222222222222.serviceInfo.exported) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass16(context));
                    return false;
                }
                intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("org.android.agoo.client.ElectionReceiverService");
                for (ResolveInfo resolveInfo222222222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo222222222222222222222.serviceInfo.name.equals("com.umeng.message.UmengMessageIntentReceiverService")) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    handler.post(new AnonymousClass17(context));
                    return false;
                }
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                Object obj2 = null;
                Object obj3 = null;
                Object obj4 = null;
                Object obj5 = null;
                Object obj6 = null;
                Object obj7 = null;
                Object obj8 = null;
                Object obj9 = null;
                Object obj10 = null;
                Object obj11 = null;
                Object obj12 = null;
                Object obj13 = null;
                obj = null;
                if (packageInfo.requestedPermissions != null) {
                    int i = 0;
                    while (true) {
                        int length = packageInfo.requestedPermissions.length;
                        if (i >= r0) {
                            break;
                        }
                        if (MsgConstant.PERMISSION_INTERNET.equals(packageInfo.requestedPermissions[i])) {
                            obj2 = 1;
                        } else {
                            if (MsgConstant.PERMISSION_ACCESS_WIFI_STATE.equals(packageInfo.requestedPermissions[i])) {
                                obj4 = 1;
                            } else {
                                if (MsgConstant.PERMISSION_ACCESS_NETWORK_STATE.equals(packageInfo.requestedPermissions[i])) {
                                    obj3 = 1;
                                } else {
                                    if (MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE.equals(packageInfo.requestedPermissions[i])) {
                                        obj5 = 1;
                                    } else {
                                        if (MsgConstant.PERMISSION_WAKE_LOCK.equals(packageInfo.requestedPermissions[i])) {
                                            obj6 = 1;
                                        } else {
                                            if (MsgConstant.PERMISSION_READ_PHONE_STATE.equals(packageInfo.requestedPermissions[i])) {
                                                obj7 = 1;
                                            } else {
                                                if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_ADDED.equals(packageInfo.requestedPermissions[i])) {
                                                    obj8 = 1;
                                                } else {
                                                    if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_CHANGED.equals(packageInfo.requestedPermissions[i])) {
                                                        obj9 = 1;
                                                    } else {
                                                        if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_INSTALL.equals(packageInfo.requestedPermissions[i])) {
                                                            obj10 = 1;
                                                        } else {
                                                            if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_REPLACED.equals(packageInfo.requestedPermissions[i])) {
                                                                obj11 = 1;
                                                            } else {
                                                                if (MsgConstant.PERMISSION_RESTART_PACKAGES.equals(packageInfo.requestedPermissions[i])) {
                                                                    obj12 = 1;
                                                                } else {
                                                                    if (MsgConstant.PERMISSION_GET_TASKS.equals(packageInfo.requestedPermissions[i])) {
                                                                        obj13 = 1;
                                                                    } else {
                                                                        if (MsgConstant.PERMISSION_RECEIVE_BOOT_COMPLETED.equals(packageInfo.requestedPermissions[i])) {
                                                                            obj = 1;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i++;
                    }
                }
                obj = (obj2 == null || obj4 == null || obj3 == null || obj5 == null || obj6 == null || obj7 == null || obj8 == null || obj9 == null || obj10 == null || obj11 == null || obj12 == null || obj13 == null || obj == null) ? null : 1;
                if (obj == null) {
                    handler.post(new AnonymousClass18(context));
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] m17269a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String m17270b() {
        return UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, BuildConfig.FLAVOR);
    }

    public static String m17271b(File file) {
        Throwable th;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String str = BuildConfig.FLAVOR;
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                }
                str = stringBuilder.toString();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static String m17272b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & MotionEventCompat.ACTION_MASK));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            UmLog.m17141i(f14372b, "getMD5 error", e);
            return BuildConfig.FLAVOR;
        }
    }

    public static void m17273b(Context context, Handler handler) {
        MessageSharedPrefs.getInstance(context).setKeyAndValue(MsgConstant.KEY_REGISTER_TIMES, (Integer.valueOf(MessageSharedPrefs.getInstance(context).getTempValue(MsgConstant.KEY_REGISTER_TIMES, MessageService.MSG_DB_READY_REPORT)).intValue() + 1) + BuildConfig.FLAVOR);
        if (C4230g.m17281d(context)) {
            handler.postDelayed(new AnonymousClass19(context, handler), 20000);
        }
    }

    public static final void m17274b(Context context, Class<?> cls) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (cls != null) {
                    try {
                        ComponentName componentName = new ComponentName(context, cls);
                        if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                            UmLog.m17136d(f14372b, "rebootReceiver[" + componentName.toString() + "]--->[ENABLED]");
                            packageManager.setComponentEnabledSetting(componentName, 1, 1);
                        }
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
            }
        }
    }

    public static void m17275b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static boolean m17276b(Context context) {
        String packageName = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
        return packageName != null && packageName.equals(context.getPackageName());
    }

    public static boolean m17277b(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String m17278c(String str) {
        String str2 = BuildConfig.FLAVOR;
        try {
            long longValue = Long.valueOf(str).longValue();
            if (longValue < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                return ((int) longValue) + "B";
            }
            if (longValue < 1048576) {
                return new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1024.0d) + "K";
            } else if (longValue < 1073741824) {
                return new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1048576.0d) + "M";
            } else {
                return new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1.073741824E9d) + "G";
            }
        } catch (NumberFormatException e) {
            return str;
        }
    }

    public static boolean m17279c(Context context) {
        return context.getPackageManager().checkPermission(MsgConstant.PERMISSION_GET_TASKS, context.getPackageName()) == 0;
    }

    public static boolean m17280c(Context context, String str) {
        List runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices == null || runningServices.isEmpty()) {
            return false;
        }
        int i = 0;
        while (i < runningServices.size()) {
            if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().equals(str) && TextUtils.equals(((RunningServiceInfo) runningServices.get(i)).service.getPackageName(), context.getPackageName())) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean m17281d(Context context) {
        String a = C4230g.m17257a(context, Process.myPid());
        return a != null ? a.equals(context.getPackageName()) : false;
    }

    public static boolean m17282d(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean m17283e(String str) {
        if (C4230g.m17282d(str)) {
            return false;
        }
        String toLowerCase = str.trim().toLowerCase(Locale.US);
        return toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://");
    }

    public static Object m17284f(String str) {
        Object obj = null;
        try {
            try {
                obj = new ObjectInputStream(new ByteArrayInputStream(C4217c.m17248h(str.getBytes()))).readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (StreamCorruptedException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return obj;
    }

    public static List<Ucode> m17285g(String str) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(str, HttpRequest.f14548a).getBytes(C4218e.f14336a));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        List<Ucode> list = (List) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return list;
    }
}
