package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class zzf {
    static int DW;
    static int FH;
    static int Hw;
    static String j6;
    long EQ;
    int J0;
    int J8;
    Messenger VH;
    long Ws;
    Map<String, Object> Zo;
    Messenger gn;
    PendingIntent tp;
    MessengerCompat u7;
    Context v5;
    long we;

    class 1 extends Handler {
        final /* synthetic */ zzf j6;

        1(zzf com_google_firebase_iid_zzf, Looper looper) {
            this.j6 = com_google_firebase_iid_zzf;
            super(looper);
        }

        public void handleMessage(Message message) {
            this.j6.j6(message);
        }
    }

    static {
        j6 = null;
        DW = 0;
        FH = 0;
        Hw = 0;
    }

    public zzf(Context context) {
        this.Zo = new HashMap();
        this.v5 = context;
    }

    private static int DW(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(j6(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private Intent DW(Bundle bundle, KeyPair keyPair) {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String DW = DW();
        synchronized (getClass()) {
            this.Zo.put(DW, conditionVariable);
        }
        j6(bundle, keyPair, DW);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.Zo.remove(DW);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static synchronized String DW() {
        String num;
        synchronized (zzf.class) {
            int i = Hw;
            Hw = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    public static String j6(Context context) {
        if (j6 != null) {
            return j6;
        }
        DW = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    FH = applicationInfo.uid;
                    j6 = resolveInfo.serviceInfo.packageName;
                    return j6;
                } catch (NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(resolveInfo.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        ApplicationInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            j6 = applicationInfo2.packageName;
            FH = applicationInfo2.uid;
            return j6;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                j6 = applicationInfo2.packageName;
                FH = applicationInfo2.uid;
                return j6;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String j6(KeyPair keyPair, String... strArr) {
        String str = null;
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                str = FirebaseInstanceId.j6(instance.sign());
            } catch (Throwable e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
            }
        } catch (Throwable e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
        }
        return str;
    }

    private void j6(Object obj) {
        synchronized (getClass()) {
            for (String str : this.Zo.keySet()) {
                Object obj2 = this.Zo.get(str);
                this.Zo.put(str, obj);
                j6(obj2, obj);
            }
        }
    }

    private void j6(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void j6(String str) {
        if ("com.google.android.gsf".equals(j6)) {
            this.J0++;
            if (this.J0 >= 3) {
                if (this.J0 == 3) {
                    this.J8 = new Random().nextInt(1000) + 1000;
                }
                this.J8 *= 2;
                this.Ws = SystemClock.elapsedRealtime() + ((long) this.J8);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.J8).toString());
            }
        }
    }

    private void j6(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.Zo.get(str);
            this.Zo.put(str, obj);
            j6(obj2, obj);
        }
    }

    String DW(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void FH(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            valueOf = "InstanceID/Rpc";
            String str = "Received InstanceID error ";
            String valueOf2 = String.valueOf(stringExtra);
            Log.d(valueOf, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String str2 = "InstanceID/Rpc";
                String str3 = "Unexpected structured response ";
                valueOf2 = String.valueOf(stringExtra);
                Log.w(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            if (split.length > 2) {
                valueOf2 = split[2];
                valueOf = split[3];
                if (valueOf.startsWith(":")) {
                    valueOf = valueOf.substring(1);
                }
            } else {
                valueOf = "UNKNOWN";
                valueOf2 = null;
            }
            intent.putExtra("error", valueOf);
        } else {
            valueOf2 = null;
            valueOf = stringExtra;
        }
        if (valueOf2 == null) {
            j6((Object) valueOf);
        } else {
            j6(valueOf2, (Object) valueOf);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.we = SystemClock.elapsedRealtime();
            this.J8 = ((int) longExtra) * 1000;
            this.Ws = SystemClock.elapsedRealtime() + ((long) this.J8);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.J8);
        } else if ("SERVICE_NOT_AVAILABLE".equals(valueOf) || "AUTHENTICATION_FAILED".equals(valueOf)) {
            j6(valueOf);
        }
    }

    void Hw(Intent intent) {
        if (intent != null) {
            String stringExtra;
            String str;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                stringExtra = intent.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    FH(intent);
                    return;
                }
                this.EQ = SystemClock.elapsedRealtime();
                this.Ws = 0;
                this.J0 = 0;
                this.J8 = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    Log.d("InstanceID/Rpc", new StringBuilder((String.valueOf(stringExtra).length() + 16) + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
                }
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    if (!"ID".equals(split[1])) {
                        str = "InstanceID/Rpc";
                        String str2 = "Unexpected structured response ";
                        stringExtra = String.valueOf(stringExtra);
                        Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                    }
                    str = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            FirebaseInstanceId.Hw(this.v5);
                        } else if ("RST".equals(split[3])) {
                            FirebaseInstanceId.j6(this.v5, c.j6(this.v5, null).FH());
                            intent.removeExtra("registration_id");
                            j6(str, (Object) intent);
                            return;
                        }
                    }
                    stringExtra = split[split.length - 1];
                    if (stringExtra.startsWith(":")) {
                        stringExtra = stringExtra.substring(1);
                    }
                    intent.putExtra("registration_id", stringExtra);
                    stringExtra = str;
                } else {
                    stringExtra = null;
                }
                if (stringExtra == null) {
                    j6((Object) intent);
                } else {
                    j6(stringExtra, (Object) intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                str = "InstanceID/Rpc";
                String str3 = "Unexpected response ";
                stringExtra = String.valueOf(intent.getAction());
                Log.d(str, stringExtra.length() != 0 ? str3.concat(stringExtra) : new String(str3));
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }

    Intent j6(Bundle bundle, KeyPair keyPair) {
        Intent DW = DW(bundle, keyPair);
        return (DW == null || !DW.hasExtra("google.messenger")) ? DW : DW(bundle, keyPair);
    }

    void j6() {
        if (this.VH == null) {
            j6(this.v5);
            this.VH = new Messenger(new 1(this, Looper.getMainLooper()));
        }
    }

    synchronized void j6(Intent intent) {
        if (this.tp == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.tp = PendingIntent.getBroadcast(this.v5, 0, intent2, 0);
        }
        intent.putExtra("app", this.tp);
    }

    protected void j6(Intent intent, String str) {
        this.EQ = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(j6);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            this.v5.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.VH);
        if (!(this.gn == null && this.u7 == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.gn != null) {
                    this.gn.send(obtain);
                    return;
                } else {
                    this.u7.DW(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.v5.startService(intent);
    }

    public void j6(Bundle bundle, KeyPair keyPair, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.Ws == 0 || elapsedRealtime > this.Ws) {
            j6();
            if (j6 == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.EQ = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(j6);
            bundle.putString("gmsv", Integer.toString(DW(this.v5)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.DW(this.v5)));
            bundle.putString("app_ver_name", FirebaseInstanceId.FH(this.v5));
            bundle.putString("cliv", "1");
            bundle.putString("appid", FirebaseInstanceId.j6(keyPair));
            String j6 = FirebaseInstanceId.j6(this.v5);
            if (j6 != null) {
                bundle.putString("gmp_app_id", j6);
            }
            bundle.putString("pub2", FirebaseInstanceId.j6(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", j6(keyPair, this.v5.getPackageName(), j6));
            intent.putExtras(bundle);
            j6(intent);
            j6(intent, str);
            return;
        }
        elapsedRealtime = this.Ws - elapsedRealtime;
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + elapsedRealtime + " interval: " + this.J8);
        throw new IOException("RETRY_LATER");
    }

    public void j6(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.u7 = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.gn = (Messenger) parcelableExtra;
                    }
                }
                Hw((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }
}
