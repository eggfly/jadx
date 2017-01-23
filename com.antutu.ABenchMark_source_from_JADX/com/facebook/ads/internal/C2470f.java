package com.facebook.ads.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2498g.C2497a;
import com.facebook.ads.internal.util.C2510r;
import com.google.android.gms.ads.p153c.C2715a;
import com.google.android.gms.ads.p153c.C2715a.C2713a;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.f */
public class C2470f {
    public static final String f8497a;
    private final String f8498b;
    private final boolean f8499c;
    private final C2413c f8500d;

    /* renamed from: com.facebook.ads.internal.f.a */
    private static final class C2411a implements IInterface {
        private IBinder f8343a;

        C2411a(IBinder iBinder) {
            this.f8343a = iBinder;
        }

        public String m9263a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f8343a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f8343a;
        }

        public boolean m9264b() {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f8343a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.f.b */
    private static final class C2412b implements ServiceConnection {
        private AtomicBoolean f8344a;
        private final BlockingQueue<IBinder> f8345b;

        private C2412b() {
            this.f8344a = new AtomicBoolean(false);
            this.f8345b = new LinkedBlockingDeque();
        }

        public IBinder m9265a() {
            if (!this.f8344a.compareAndSet(true, true)) {
                return (IBinder) this.f8345b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f8345b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c */
    public enum C2413c {
        SHARED_PREFS,
        FB4A,
        DIRECT,
        REFLECTION,
        SERVICE
    }

    static {
        f8497a = C2470f.class.getSimpleName();
    }

    private C2470f(String str, boolean z, C2413c c2413c) {
        this.f8498b = str;
        this.f8499c = z;
        this.f8500d = c2413c;
    }

    private static C2470f m9391a(Context context) {
        try {
            C2713a b = C2715a.m10326b(context);
            if (b != null) {
                return new C2470f(b.m10319a(), b.m10320b(), C2413c.DIRECT);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static C2470f m9392a(Context context, C2497a c2497a) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (c2497a != null && !C2510r.m9516a(c2497a.f8582b)) {
            return new C2470f(c2497a.f8582b, c2497a.f8583c, C2413c.FB4A);
        } else {
            C2470f a = C2470f.m9391a(context);
            if (a == null || C2510r.m9516a(a.m9395a())) {
                a = C2470f.m9393b(context);
            }
            return (a == null || C2510r.m9516a(a.m9395a())) ? C2470f.m9394c(context) : a;
        }
    }

    private static C2470f m9393b(Context context) {
        Method a = C2498g.m9475a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (a == null) {
            return null;
        }
        Object a2 = C2498g.m9470a(null, a, context);
        if (a2 == null || ((Integer) a2).intValue() != 0) {
            return null;
        }
        a = C2498g.m9475a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (a == null) {
            return null;
        }
        Object a3 = C2498g.m9470a(null, a, context);
        if (a3 == null) {
            return null;
        }
        a = C2498g.m9474a(a3.getClass(), "getId", new Class[0]);
        Method a4 = C2498g.m9474a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        return (a == null || a4 == null) ? null : new C2470f((String) C2498g.m9470a(a3, a, new Object[0]), ((Boolean) C2498g.m9470a(a3, a4, new Object[0])).booleanValue(), C2413c.REFLECTION);
    }

    private static C2470f m9394c(Context context) {
        ServiceConnection c2412b = new C2412b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, c2412b, 1)) {
            C2470f c2470f;
            try {
                C2411a c2411a = new C2411a(c2412b.m9265a());
                c2470f = new C2470f(c2411a.m9263a(), c2411a.m9264b(), C2413c.SERVICE);
                return c2470f;
            } catch (Exception e) {
                c2470f = e;
            } finally {
                context.unbindService(c2412b);
            }
        }
        return null;
    }

    public String m9395a() {
        return this.f8498b;
    }

    public boolean m9396b() {
        return this.f8499c;
    }

    public C2413c m9397c() {
        return this.f8500d;
    }
}
