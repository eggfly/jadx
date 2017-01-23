package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.bf.C2801a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.bj */
public interface bj extends IInterface {

    /* renamed from: com.google.android.gms.b.bj.a */
    public static abstract class C2803a extends Binder implements bj {

        /* renamed from: com.google.android.gms.b.bj.a.a */
        private static class C3046a implements bj {
            private IBinder f10366a;

            C3046a(IBinder iBinder) {
                this.f10366a = iBinder;
            }

            public String m11894a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10366a;
            }

            public List m11895b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m11896c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public bf m11897d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    bf a = C2801a.m10788a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m11898e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public double m11899f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    double readDouble = obtain2.readDouble();
                    return readDouble;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m11900g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m11901h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C2687a m11902i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C2687a a = C2689a.m10261a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle m11903m() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m11904n() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    this.f10366a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C2803a() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        }

        public static bj m10803a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bj)) ? new C3046a(iBinder) : (bj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            String a;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    C2687a i3 = m10800i();
                    parcel2.writeNoException();
                    if (i3 != null) {
                        iBinder = i3.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    a = m10792a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    List b = m10793b();
                    parcel2.writeNoException();
                    parcel2.writeList(b);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    a = m10794c();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    bf d = m10795d();
                    parcel2.writeNoException();
                    if (d != null) {
                        iBinder = d.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    a = m10796e();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double f = m10797f();
                    parcel2.writeNoException();
                    parcel2.writeDouble(f);
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    a = m10798g();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    a = m10799h();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    Bundle m = m10801m();
                    parcel2.writeNoException();
                    if (m != null) {
                        parcel2.writeInt(1);
                        m.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    m10802n();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String m10792a();

    List m10793b();

    String m10794c();

    bf m10795d();

    String m10796e();

    double m10797f();

    String m10798g();

    String m10799h();

    C2687a m10800i();

    Bundle m10801m();

    void m10802n();
}
