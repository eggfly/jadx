package com.google.android.gms.common.stats;

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
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.google.android.gms.common.internal.C3475f;
import com.google.android.gms.common.stats.C3529c.C3528a;
import com.google.android.gms.p146b.jf;
import com.google.android.gms.p146b.jr;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.stats.b */
public class C3527b {
    private static final Object f12185a;
    private static C3527b f12186b;
    private static Integer f12187h;
    private final List<String> f12188c;
    private final List<String> f12189d;
    private final List<String> f12190e;
    private final List<String> f12191f;
    private C3531e f12192g;
    private C3531e f12193i;

    static {
        f12185a = new Object();
    }

    private C3527b() {
        if (C3527b.m14726c() == C3530d.f12203b) {
            this.f12188c = Collections.EMPTY_LIST;
            this.f12189d = Collections.EMPTY_LIST;
            this.f12190e = Collections.EMPTY_LIST;
            this.f12191f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) C3528a.f12195b.m13518c();
        this.f12188c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        str = (String) C3528a.f12196c.m13518c();
        this.f12189d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        str = (String) C3528a.f12197d.m13518c();
        this.f12190e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        str = (String) C3528a.f12198e.m13518c();
        this.f12191f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
        this.f12192g = new C3531e(IXAdIOUtils.BUFFER_SIZE, ((Long) C3528a.f12199f.m13518c()).longValue());
        this.f12193i = new C3531e(IXAdIOUtils.BUFFER_SIZE, ((Long) C3528a.f12199f.m13518c()).longValue());
    }

    public static C3527b m14718a() {
        synchronized (f12185a) {
            if (f12186b == null) {
                f12186b = new C3527b();
            }
        }
        return f12186b;
    }

    private String m14719a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private void m14720a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((C3527b.m14726c() & C3530d.f12207f) == 0 || i == 13)) {
            str6 = jr.m13577a(3, 5);
        }
        long j = 0;
        if ((C3527b.m14726c() & C3530d.f12209h) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(C3530d.f12202a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void m14721a(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (m14725b() && this.f12192g != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo b = C3527b.m14724b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str5 = b.name;
                str3 = jr.m13578a(context);
                if (m14723a(str3, str2, str4, str5)) {
                    this.f12192g.m14733a(str);
                } else {
                    return;
                }
            } else if (this.f12192g.m14734b(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            m14720a(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean m14722a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return (component == null || (C3475f.f12055a && "com.google.android.gms".equals(component.getPackageName()))) ? false : jf.m13542a(context, component.getPackageName());
    }

    private boolean m14723a(String str, String str2, String str3, String str4) {
        return (this.f12188c.contains(str) || this.f12189d.contains(str2) || this.f12190e.contains(str3) || this.f12191f.contains(str4) || (str3.equals(str) && (C3527b.m14726c() & C3530d.f12208g) != 0)) ? false : true;
    }

    private static ServiceInfo m14724b(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, SpdyProtocol.SLIGHTSSLV2);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), jr.m13577a(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), jr.m13577a(3, 20)}));
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private boolean m14725b() {
        return C3475f.f12055a && C3527b.m14726c() != C3530d.f12203b;
    }

    private static int m14726c() {
        if (f12187h == null) {
            try {
                f12187h = Integer.valueOf(jf.m13541a() ? ((Integer) C3528a.f12194a.m13518c()).intValue() : C3530d.f12203b);
            } catch (SecurityException e) {
                f12187h = Integer.valueOf(C3530d.f12203b);
            }
        }
        return f12187h.intValue();
    }

    @SuppressLint({"UntrackedBindService"})
    public void m14727a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m14721a(context, m14719a(serviceConnection), null, null, 1);
    }

    public void m14728a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m14721a(context, m14719a(serviceConnection), str, intent, 3);
    }

    public boolean m14729a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m14730a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m14730a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m14722a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m14721a(context, m14719a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void m14731b(Context context, ServiceConnection serviceConnection) {
        m14721a(context, m14719a(serviceConnection), null, null, 4);
    }
}
