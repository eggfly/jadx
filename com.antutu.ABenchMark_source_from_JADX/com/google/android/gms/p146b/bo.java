package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.bj.C2803a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.bo */
public interface bo extends IInterface {

    /* renamed from: com.google.android.gms.b.bo.a */
    public static abstract class C3050a extends Binder implements bo {

        /* renamed from: com.google.android.gms.b.bo.a.a */
        private static class C3049a implements bo {
            private IBinder f10375a;

            C3049a(IBinder iBinder) {
                this.f10375a = iBinder;
            }

            public void m11941a(bj bjVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                    obtain.writeStrongBinder(bjVar != null ? bjVar.asBinder() : null);
                    this.f10375a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10375a;
            }
        }

        public C3050a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        }

        public static bo m11942a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bo)) ? new C3049a(iBinder) : (bo) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                    m11940a(C2803a.m10803a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m11940a(bj bjVar);
}
