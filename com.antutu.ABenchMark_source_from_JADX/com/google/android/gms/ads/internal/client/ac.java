package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.du.C3150a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import org.android.spdy.SpdyProtocol;

public interface ac extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.client.ac.a */
    public static abstract class C2743a extends Binder implements ac {

        /* renamed from: com.google.android.gms.ads.internal.client.ac.a.a */
        private static class C2742a implements ac {
            private IBinder f9353a;

            C2742a(IBinder iBinder) {
                this.f9353a = iBinder;
            }

            public IBinder m10528a(C2687a c2687a, String str, du duVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    obtain.writeString(str);
                    if (duVar != null) {
                        iBinder = duVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f9353a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9353a;
            }
        }

        public static ac m10529a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ac)) ? new C2742a(iBinder) : (ac) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    IBinder a = m10527a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readString(), C3150a.m12359a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder m10527a(C2687a c2687a, String str, du duVar, int i);
}
