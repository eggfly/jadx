package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.bc.C3038a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.bd */
public interface bd extends IInterface {

    /* renamed from: com.google.android.gms.b.bd.a */
    public static abstract class C3041a extends Binder implements bd {

        /* renamed from: com.google.android.gms.b.bd.a.a */
        private static class C3040a implements bd {
            private IBinder f10357a;

            C3040a(IBinder iBinder) {
                this.f10357a = iBinder;
            }

            public void m11878a(bc bcVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
                    obtain.writeStrongBinder(bcVar != null ? bcVar.asBinder() : null);
                    this.f10357a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10357a;
            }
        }

        public C3041a() {
            attachInterface(this, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
        }

        public static bd m11879a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bd)) ? new C3040a(iBinder) : (bd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
                    m11877a(C3038a.m11866a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m11877a(bc bcVar);
}
