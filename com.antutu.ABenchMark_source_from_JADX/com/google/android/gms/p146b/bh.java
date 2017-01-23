package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.bh */
public interface bh extends IInterface {

    /* renamed from: com.google.android.gms.b.bh.a */
    public static abstract class C2766a extends Binder implements bh {

        /* renamed from: com.google.android.gms.b.bh.a.a */
        private static class C3043a implements bh {
            private IBinder f10364a;

            C3043a(IBinder iBinder) {
                this.f10364a = iBinder;
            }

            public C2687a m11887a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeString(str);
                    this.f10364a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C2687a a = C2689a.m10261a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11888a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    this.f10364a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11889a(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10364a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11890a(String str, C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10364a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10364a;
            }
        }

        public C2766a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        }

        public static bh m10690a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bh)) ? new C3043a(iBinder) : (bh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    m10689a(parcel.readString(), C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    C2687a a = m10686a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    m10688a(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    m10687a();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C2687a m10686a(String str);

    void m10687a();

    void m10688a(C2687a c2687a);

    void m10689a(String str, C2687a c2687a);
}
