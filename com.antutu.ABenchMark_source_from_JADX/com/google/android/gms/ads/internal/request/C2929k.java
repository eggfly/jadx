package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.request.k */
public interface C2929k extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.request.k.a */
    public static abstract class C2930a extends Binder implements C2929k {

        /* renamed from: com.google.android.gms.ads.internal.request.k.a.a */
        private static class C2937a implements C2929k {
            private IBinder f9982a;

            C2937a(IBinder iBinder) {
                this.f9982a = iBinder;
            }

            public void m11422a(AdResponseParcel adResponseParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (adResponseParcel != null) {
                        obtain.writeInt(1);
                        adResponseParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f9982a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9982a;
            }
        }

        public C2930a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
        }

        public static C2929k m11409a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2929k)) ? new C2937a(iBinder) : (C2929k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    m11408a(parcel.readInt() != 0 ? AdResponseParcel.CREATOR.m11412a(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m11408a(AdResponseParcel adResponseParcel);
}
