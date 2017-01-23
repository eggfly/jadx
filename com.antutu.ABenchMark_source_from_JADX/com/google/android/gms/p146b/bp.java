package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.bl.C2806a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.bp */
public interface bp extends IInterface {

    /* renamed from: com.google.android.gms.b.bp.a */
    public static abstract class C3052a extends Binder implements bp {

        /* renamed from: com.google.android.gms.b.bp.a.a */
        private static class C3051a implements bp {
            private IBinder f10376a;

            C3051a(IBinder iBinder) {
                this.f10376a = iBinder;
            }

            public void m11944a(bl blVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                    obtain.writeStrongBinder(blVar != null ? blVar.asBinder() : null);
                    this.f10376a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10376a;
            }
        }

        public C3052a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        }

        public static bp m11945a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bp)) ? new C3051a(iBinder) : (bp) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                    m11943a(C2806a.m10832a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m11943a(bl blVar);
}
