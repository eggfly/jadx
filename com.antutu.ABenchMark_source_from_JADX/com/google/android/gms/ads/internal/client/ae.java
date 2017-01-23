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

public interface ae extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.client.ae.a */
    public static abstract class C2746a extends Binder implements ae {

        /* renamed from: com.google.android.gms.ads.internal.client.ae.a.a */
        private static class C2745a implements ae {
            private IBinder f9355a;

            C2745a(IBinder iBinder) {
                this.f9355a = iBinder;
            }

            public IBinder m10553a(C2687a c2687a, AdSizeParcel adSizeParcel, String str, du duVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (duVar != null) {
                        iBinder = duVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f9355a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder m10554a(C2687a c2687a, AdSizeParcel adSizeParcel, String str, du duVar, int i, int i2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (duVar != null) {
                        iBinder = duVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f9355a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9355a;
            }
        }

        public static ae m10555a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ae)) ? new C2745a(iBinder) : (ae) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AdSizeParcel adSizeParcel = null;
            C2687a a;
            IBinder a2;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    a = C2689a.m10261a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.m10729a(parcel);
                    }
                    a2 = m10551a(a, adSizeParcel, parcel.readString(), C3150a.m12359a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    a = C2689a.m10261a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.m10729a(parcel);
                    }
                    a2 = m10552a(a, adSizeParcel, parcel.readString(), C3150a.m12359a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder m10551a(C2687a c2687a, AdSizeParcel adSizeParcel, String str, du duVar, int i);

    IBinder m10552a(C2687a c2687a, AdSizeParcel adSizeParcel, String str, du duVar, int i, int i2);
}
