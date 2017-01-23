package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.jw */
public interface jw extends IInterface {

    /* renamed from: com.google.android.gms.b.jw.a */
    public static abstract class C3325a extends Binder implements jw {

        /* renamed from: com.google.android.gms.b.jw.a.a */
        private static class C3324a implements jw {
            private IBinder f11572a;

            C3324a(IBinder iBinder) {
                this.f11572a = iBinder;
            }

            public IBinder asBinder() {
                return this.f11572a;
            }

            public boolean getBooleanFlagValue(String str, boolean z, int i) {
                boolean z2 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    this.f11572a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getIntFlagValue(String str, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f11572a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getLongFlagValue(String str, long j, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    this.f11572a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getStringFlagValue(String str, String str2, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f11572a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void init(C2687a c2687a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    this.f11572a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C3325a() {
            attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
        }

        public static jw asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jw)) ? new C3324a(iBinder) : (jw) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    init(C2689a.m10261a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    if (booleanFlagValue) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(intFlagValue);
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(longFlagValue);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(stringFlagValue);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.flags.IFlagProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean getBooleanFlagValue(String str, boolean z, int i);

    int getIntFlagValue(String str, int i, int i2);

    long getLongFlagValue(String str, long j, int i);

    String getStringFlagValue(String str, String str2, int i);

    void init(C2687a c2687a);
}
