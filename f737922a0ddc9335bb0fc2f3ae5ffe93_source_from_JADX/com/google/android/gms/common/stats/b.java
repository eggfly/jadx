package com.google.android.gms.common.stats;

import afp;
import agc;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.c.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class b {
    private static b DW;
    private static Integer gn;
    private static final Object j6;
    private final List<String> FH;
    private final List<String> Hw;
    private e VH;
    private final List<String> Zo;
    private e u7;
    private final List<String> v5;

    static {
        j6 = new Object();
    }

    private b() {
        if (FH() == d.DW) {
            this.FH = Collections.EMPTY_LIST;
            this.Hw = Collections.EMPTY_LIST;
            this.v5 = Collections.EMPTY_LIST;
            this.Zo = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) a.DW.j6();
        this.FH = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.FH.j6();
        this.Hw = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.Hw.j6();
        this.v5 = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.v5.j6();
        this.Zo = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.VH = new e(1024, ((Long) a.Zo.j6()).longValue());
        this.u7 = new e(1024, ((Long) a.Zo.j6()).longValue());
    }

    private static ServiceInfo DW(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), j6(3, 20)}));
            return null;
        } else if (queryIntentServices.size() <= 1) {
            return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
        } else {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), j6(3, 20)}));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        }
    }

    private boolean DW() {
        return false;
    }

    private static int FH() {
        if (gn == null) {
            try {
                gn = Integer.valueOf(afp.j6() ? ((Integer) a.j6.j6()).intValue() : d.DW);
            } catch (SecurityException e) {
                gn = Integer.valueOf(d.DW);
            }
        }
        return gn.intValue();
    }

    public static b j6() {
        synchronized (j6) {
            if (DW == null) {
                DW = new b();
            }
        }
        return DW;
    }

    private static String j6(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(j6(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    private String j6(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private static String j6(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        return new StringBuilder((String.valueOf(valueOf).length() + 13) + String.valueOf(valueOf2).length()).append(valueOf).append(".").append(valueOf2).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    private void j6(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((FH() & d.Zo) == 0 || i == 13)) {
            str6 = j6(3, 5);
        }
        long j = 0;
        if ((FH() & d.gn) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(d.j6).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void j6(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (DW() && this.VH != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo DW = DW(context, intent);
                if (DW == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = DW.processName;
                str5 = DW.name;
                str3 = agc.j6();
                if (j6(str3, str2, str4, str5)) {
                    this.VH.j6(str);
                } else {
                    return;
                }
            } else if (this.VH.DW(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            j6(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean j6(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component != null ? afp.j6(context, component.getPackageName()) : false;
    }

    private boolean j6(String str, String str2, String str3, String str4) {
        return (this.FH.contains(str) || this.Hw.contains(str2) || this.v5.contains(str3) || this.Zo.contains(str4) || (str3.equals(str) && (FH() & d.VH) != 0)) ? false : true;
    }

    public void DW(Context context, ServiceConnection serviceConnection) {
        j6(context, j6(serviceConnection), null, null, 4);
    }

    @SuppressLint({"UntrackedBindService"})
    public void j6(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        j6(context, j6(serviceConnection), null, null, 1);
    }

    public void j6(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        j6(context, j6(serviceConnection), str, intent, 3);
    }

    public boolean j6(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return j6(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean j6(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (j6(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            j6(context, j6(serviceConnection), str, intent, 2);
        }
        return bindService;
    }
}
