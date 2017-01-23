package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.dy */
public interface dy extends IInterface {

    /* renamed from: com.google.android.gms.b.dy.a */
    public static abstract class C3143a extends Binder implements dy {

        /* renamed from: com.google.android.gms.b.dy.a.a */
        private static class C3155a implements dy {
            private IBinder f10726a;

            C3155a(IBinder iBinder) {
                this.f10726a = iBinder;
            }

            public int m12416a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    this.f10726a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10726a;
            }
        }

        public C3143a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
        }

        public static dy m12312a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof dy)) ? new C3155a(iBinder) : (dy) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    int a = m12311a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int m12311a();
}
