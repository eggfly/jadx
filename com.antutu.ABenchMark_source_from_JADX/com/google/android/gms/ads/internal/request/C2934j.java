package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.request.C2929k.C2930a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.request.j */
public interface C2934j extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.request.j.a */
    public static abstract class C2936a extends Binder implements C2934j {

        /* renamed from: com.google.android.gms.ads.internal.request.j.a.a */
        private static class C2935a implements C2934j {
            private IBinder f9981a;

            C2935a(IBinder iBinder) {
                this.f9981a = iBinder;
            }

            public AdResponseParcel m11419a(AdRequestInfoParcel adRequestInfoParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f9981a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    AdResponseParcel a = obtain2.readInt() != 0 ? AdResponseParcel.CREATOR.m11412a(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return a;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11420a(AdRequestInfoParcel adRequestInfoParcel, C2929k c2929k) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c2929k != null ? c2929k.asBinder() : null);
                    this.f9981a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9981a;
            }
        }

        public C2936a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static C2934j m11421a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2934j)) ? new C2935a(iBinder) : (C2934j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AdRequestInfoParcel adRequestInfoParcel = null;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        adRequestInfoParcel = AdRequestInfoParcel.CREATOR.m11406a(parcel);
                    }
                    AdResponseParcel a = m11417a(adRequestInfoParcel);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        adRequestInfoParcel = AdRequestInfoParcel.CREATOR.m11406a(parcel);
                    }
                    m11418a(adRequestInfoParcel, C2930a.m11409a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    AdResponseParcel m11417a(AdRequestInfoParcel adRequestInfoParcel);

    void m11418a(AdRequestInfoParcel adRequestInfoParcel, C2929k c2929k);
}
