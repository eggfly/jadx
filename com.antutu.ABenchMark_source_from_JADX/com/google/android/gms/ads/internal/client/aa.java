package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

public interface aa extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.client.aa.a */
    public static abstract class C2739a extends Binder implements aa {

        /* renamed from: com.google.android.gms.ads.internal.client.aa.a.a */
        private static class C2738a implements aa {
            private IBinder f9351a;

            C2738a(IBinder iBinder) {
                this.f9351a = iBinder;
            }

            public void m10508a(AdRequestParcel adRequestParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f9351a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m10509a() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.f9351a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9351a;
            }

            public String m10510b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.f9351a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C2739a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
        }

        public static aa m10511a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aa)) ? new C2738a(iBinder) : (aa) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    m10505a(parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m10724a(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    String b = m10507b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean a = m10506a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoader");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m10505a(AdRequestParcel adRequestParcel);

    boolean m10506a();

    String m10507b();
}
