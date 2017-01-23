package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

public interface af extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.client.af.a */
    public static abstract class C2748a extends Binder implements af {

        /* renamed from: com.google.android.gms.ads.internal.client.af.a.a */
        private static class C2747a implements af {
            private IBinder f9356a;

            C2747a(IBinder iBinder) {
                this.f9356a = iBinder;
            }

            public void m10557a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f9356a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9356a;
            }
        }

        public C2748a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAppEventListener");
        }

        public static af m10558a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof af)) ? new C2747a(iBinder) : (af) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    m10556a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAppEventListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m10556a(String str, String str2);
}
