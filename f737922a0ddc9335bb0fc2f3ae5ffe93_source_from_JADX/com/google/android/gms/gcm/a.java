package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.zzc;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    public static int DW;
    public static int FH;
    static a Hw;
    public static int j6;
    private static final AtomicInteger u7;
    private PendingIntent VH;
    private Context Zo;
    private Map<String, Handler> gn;
    private final BlockingQueue<Intent> tp;
    final Messenger v5;

    class 1 extends Handler {
        final /* synthetic */ a j6;

        1(a aVar, Looper looper) {
            this.j6 = aVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message == null || !(message.obj instanceof Intent)) {
                Log.w("GCM", "Dropping invalid message");
            }
            Intent intent = (Intent) message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                this.j6.tp.add(intent);
            } else if (!this.j6.FH(intent)) {
                intent.setPackage(this.j6.Zo.getPackageName());
                this.j6.Zo.sendBroadcast(intent);
            }
        }
    }

    static {
        j6 = 5000000;
        DW = 6500000;
        FH = 7000000;
        u7 = new AtomicInteger(1);
    }

    public a() {
        this.tp = new LinkedBlockingQueue();
        this.gn = Collections.synchronizedMap(new HashMap());
        this.v5 = new Messenger(new 1(this, Looper.getMainLooper()));
    }

    public static String DW(Context context) {
        return zzc.j6(context);
    }

    public static int FH(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(DW(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private boolean FH(Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.gn.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static synchronized a j6(Context context) {
        a aVar;
        synchronized (a.class) {
            if (Hw == null) {
                Hw = new a();
                Hw.Zo = context.getApplicationContext();
            }
            aVar = Hw;
        }
        return aVar;
    }

    private String j6() {
        String valueOf = String.valueOf("google.rpc");
        String valueOf2 = String.valueOf(String.valueOf(u7.getAndIncrement()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static String j6(Intent intent, String str) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private String j6(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        return com.google.android.gms.iid.a.FH(this.Zo).FH().j6("", str, "GCM");
    }

    private void j6(String str, String str2, long j, int i, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        DW(intent);
        intent.setPackage(DW(this.Zo));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        intent.putExtra("google.from", j6(str));
        if (DW(this.Zo).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                String str32;
                Object obj = bundle.get(str32);
                if (obj instanceof String) {
                    String str4 = "gcm.";
                    str32 = String.valueOf(str32);
                    bundle2.putString(str32.length() != 0 ? str4.concat(str32) : new String(str4), (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            com.google.android.gms.iid.a.FH(this.Zo).DW("GCM", "upstream", bundle2);
            return;
        }
        this.Zo.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    String DW(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    synchronized void DW(Intent intent) {
        if (this.VH == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.VH = PendingIntent.getBroadcast(this.Zo, 0, intent2, 0);
        }
        intent.putExtra("app", this.VH);
    }

    @Deprecated
    Intent j6(Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (FH(this.Zo) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(DW(this.Zo));
            DW(intent);
            intent.putExtra("google.message_id", j6());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.v5);
            this.Zo.startService(intent);
            try {
                return (Intent) this.tp.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public String j6(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? "gcm" : stringExtra;
    }

    @Deprecated
    public synchronized String j6(String... strArr) {
        String DW;
        DW = DW(strArr);
        Bundle bundle = new Bundle();
        if (DW(this.Zo).contains(".gsf")) {
            bundle.putString("legacy.sender", DW);
            DW = com.google.android.gms.iid.a.FH(this.Zo).j6(DW, "GCM", bundle);
        } else {
            bundle.putString("sender", DW);
            DW = j6(j6(bundle), "registration_id");
        }
        return DW;
    }

    public void j6(String str, String str2, long j, Bundle bundle) {
        j6(str, str2, j, -1, bundle);
    }
}
