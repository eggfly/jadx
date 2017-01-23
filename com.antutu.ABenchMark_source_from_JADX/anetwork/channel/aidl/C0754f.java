package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

/* renamed from: anetwork.channel.aidl.f */
public interface C0754f extends IInterface {

    /* renamed from: anetwork.channel.aidl.f.a */
    public static abstract class C0755a extends Binder implements C0754f {

        /* renamed from: anetwork.channel.aidl.f.a.a */
        private static class C0762a implements C0754f {
            private IBinder f2476a;

            C0762a(IBinder iBinder) {
                this.f2476a = iBinder;
            }

            public int m3024a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.f2476a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int m3025a(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    this.f2476a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long m3026a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    obtain.writeInt(i);
                    this.f2476a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2476a;
            }

            public void m3027b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.f2476a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int m3028c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.f2476a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int m3029d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableInputStream");
                    this.f2476a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0754f m3007a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("anetwork.channel.aidl.ParcelableInputStream");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0754f)) ? new C0762a(iBinder) : (C0754f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int a;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    a = m3001a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    m3004b();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    a = m3005c();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    a = parcel.readInt();
                    byte[] bArr = a < 0 ? null : new byte[a];
                    int a2 = m3002a(bArr);
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    parcel2.writeByteArray(bArr);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    long a3 = m3003a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(a3);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableInputStream");
                    a = m3006d();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("anetwork.channel.aidl.ParcelableInputStream");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int m3001a();

    int m3002a(byte[] bArr);

    long m3003a(int i);

    void m3004b();

    int m3005c();

    int m3006d();
}
