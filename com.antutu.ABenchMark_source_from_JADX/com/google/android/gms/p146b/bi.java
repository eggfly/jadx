package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.bi */
public interface bi extends IInterface {

    /* renamed from: com.google.android.gms.b.bi.a */
    public static abstract class C3045a extends Binder implements bi {

        /* renamed from: com.google.android.gms.b.bi.a.a */
        private static class C3044a implements bi {
            private IBinder f10365a;

            C3044a(IBinder iBinder) {
                this.f10365a = iBinder;
            }

            public IBinder m11892a(C2687a c2687a, C2687a c2687a2, C2687a c2687a3, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    obtain.writeStrongBinder(c2687a2 != null ? c2687a2.asBinder() : null);
                    if (c2687a3 != null) {
                        iBinder = c2687a3.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f10365a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10365a;
            }
        }

        public static bi m11893a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bi)) ? new C3044a(iBinder) : (bi) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    IBinder a = m11891a(C2689a.m10261a(parcel.readStrongBinder()), C2689a.m10261a(parcel.readStrongBinder()), C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder m11891a(C2687a c2687a, C2687a c2687a2, C2687a c2687a3, int i);
}
