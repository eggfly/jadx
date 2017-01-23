package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    final ExecutorService DW;
    private final Object FH;
    private int Hw;
    MessengerCompat j6;
    private int v5;

    class 1 extends Handler {
        final /* synthetic */ zzb j6;

        1(zzb com_google_firebase_iid_zzb, Looper looper) {
            this.j6 = com_google_firebase_iid_zzb;
            super(looper);
        }

        public void handleMessage(Message message) {
            int j6 = MessengerCompat.j6(message);
            zzf.j6(this.j6);
            this.j6.getPackageManager();
            if (j6 == zzf.FH || j6 == zzf.DW) {
                this.j6.DW((Intent) message.obj);
                return;
            }
            int i = zzf.DW;
            Log.w("FirebaseInstanceId", "Message from unexpected caller " + j6 + " mine=" + i + " appid=" + zzf.FH);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ zzb DW;
        final /* synthetic */ Intent j6;

        2(zzb com_google_firebase_iid_zzb, Intent intent) {
            this.DW = com_google_firebase_iid_zzb;
            this.j6 = intent;
        }

        public void run() {
            this.DW.DW(this.j6);
            this.DW.DW();
        }
    }

    public zzb() {
        this.j6 = new MessengerCompat(new 1(this, Looper.getMainLooper()));
        this.DW = Executors.newSingleThreadExecutor();
        this.FH = new Object();
        this.v5 = 0;
    }

    protected void DW() {
        synchronized (this.FH) {
            this.v5--;
            if (this.v5 == 0) {
                DW(this.Hw);
            }
        }
    }

    public abstract void DW(Intent intent);

    boolean DW(int i) {
        return stopSelfResult(i);
    }

    protected abstract Intent FH(Intent intent);

    protected int j6(Intent intent) {
        this.DW.execute(new 2(this, intent));
        return 3;
    }

    public final IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) ? null : this.j6.j6();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.FH) {
            this.Hw = i2;
            this.v5++;
        }
        Intent FH = FH(intent);
        if (FH == null) {
            DW();
            return 2;
        }
        try {
            int j6 = j6(FH);
            if (FH.getStringExtra("from") == null) {
                return j6;
            }
            WakefulBroadcastReceiver.j6(FH);
            return j6;
        } catch (Throwable th) {
            if (FH.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.j6(FH);
            }
        }
    }
}
