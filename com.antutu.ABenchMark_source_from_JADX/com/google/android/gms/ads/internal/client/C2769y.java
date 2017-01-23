package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.client.y */
public interface C2769y extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.client.y.a */
    public static abstract class C2770a extends Binder implements C2769y {

        /* renamed from: com.google.android.gms.ads.internal.client.y.a.a */
        private static class C2786a implements C2769y {
            private IBinder f9465a;

            C2786a(IBinder iBinder) {
                this.f9465a = iBinder;
            }

            public void m10748a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdClickListener");
                    this.f9465a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9465a;
            }
        }

        public C2770a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdClickListener");
        }

        public static C2769y m10699a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2769y)) ? new C2786a(iBinder) : (C2769y) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    m10698a();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m10698a();
}
