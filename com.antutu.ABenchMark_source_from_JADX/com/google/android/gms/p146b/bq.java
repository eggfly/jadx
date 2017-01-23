package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.bn.C2808a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.bq */
public interface bq extends IInterface {

    /* renamed from: com.google.android.gms.b.bq.a */
    public static abstract class C3054a extends Binder implements bq {

        /* renamed from: com.google.android.gms.b.bq.a.a */
        private static class C3053a implements bq {
            private IBinder f10377a;

            C3053a(IBinder iBinder) {
                this.f10377a = iBinder;
            }

            public void m11947a(bn bnVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    obtain.writeStrongBinder(bnVar != null ? bnVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f10377a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10377a;
            }
        }

        public static bq m11948a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bq)) ? new C3053a(iBinder) : (bq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    m11946a(C2808a.m10852a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m11946a(bn bnVar, String str);
}
