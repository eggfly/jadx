package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p146b.bf.C2801a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.ea */
public interface ea extends IInterface {

    /* renamed from: com.google.android.gms.b.ea.a */
    public static abstract class C3161a extends Binder implements ea {

        /* renamed from: com.google.android.gms.b.ea.a.a */
        private static class C3160a implements ea {
            private IBinder f10728a;

            C3160a(IBinder iBinder) {
                this.f10728a = iBinder;
            }

            public String m12462a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12463a(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10728a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10728a;
            }

            public List m12464b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    List readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    return readArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12465b(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f10728a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m12466c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public bf m12467d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    bf a = C2801a.m10788a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m12468e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String m12469f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12470g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m12471h() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(11, obtain, obtain2, 0);
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

            public boolean m12472i() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(12, obtain, obtain2, 0);
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

            public Bundle m12473j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    this.f10728a.transact(13, obtain, obtain2, 0);
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
        }

        public C3161a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
        }

        public static ea m12474a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ea)) ? new C3160a(iBinder) : (ea) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            String a;
            boolean h;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    a = m12450a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    List b = m12452b();
                    parcel2.writeNoException();
                    parcel2.writeList(b);
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    a = m12454c();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    bf d = m12455d();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(d != null ? d.asBinder() : null);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    a = m12456e();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    a = m12457f();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    m12458g();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    m12451a(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    m12453b(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    h = m12459h();
                    parcel2.writeNoException();
                    if (h) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    h = m12460i();
                    parcel2.writeNoException();
                    if (h) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    Bundle j = m12461j();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String m12450a();

    void m12451a(C2687a c2687a);

    List m12452b();

    void m12453b(C2687a c2687a);

    String m12454c();

    bf m12455d();

    String m12456e();

    String m12457f();

    void m12458g();

    boolean m12459h();

    boolean m12460i();

    Bundle m12461j();
}
