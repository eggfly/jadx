package p023b.p024a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: b.a.aj */
public class aj {

    /* renamed from: b.a.aj.a */
    private static final class C0817a {
        private final String f2671a;
        private final boolean f2672b;

        C0817a(String str, boolean z) {
            this.f2671a = str;
            this.f2672b = z;
        }

        private String m3313a() {
            return this.f2671a;
        }
    }

    /* renamed from: b.a.aj.b */
    private static final class C0818b implements ServiceConnection {
        boolean f2673a;
        private final LinkedBlockingQueue<IBinder> f2674b;

        private C0818b() {
            this.f2673a = false;
            this.f2674b = new LinkedBlockingQueue(1);
        }

        public IBinder m3315a() {
            if (this.f2673a) {
                throw new IllegalStateException();
            }
            this.f2673a = true;
            return (IBinder) this.f2674b.take();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f2674b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: b.a.aj.c */
    private static final class C0819c implements IInterface {
        private IBinder f2675a;

        public C0819c(IBinder iBinder) {
            this.f2675a = iBinder;
        }

        public String m3316a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f2675a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean m3317a(boolean z) {
            boolean z2 = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f2675a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z2;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f2675a;
        }
    }

    public static String m3318a(Context context) {
        String str = null;
        try {
            C0817a b = aj.m3319b(context);
            if (b != null) {
                str = b.m3313a();
            }
        } catch (Exception e) {
        }
        return str;
    }

    private static C0817a m3319b(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnection c0818b = new C0818b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, c0818b, 1)) {
                try {
                    C0819c c0819c = new C0819c(c0818b.m3315a());
                    C0817a c0817a = new C0817a(c0819c.m3316a(), c0819c.m3317a(true));
                    context.unbindService(c0818b);
                    return c0817a;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    context.unbindService(c0818b);
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
