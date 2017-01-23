package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

/* renamed from: anetwork.channel.aidl.d */
public interface C0751d extends IInterface {

    /* renamed from: anetwork.channel.aidl.d.a */
    public static abstract class C0752a extends Binder implements C0751d {

        /* renamed from: anetwork.channel.aidl.d.a.a */
        private static class C0760a implements C0751d {
            private IBinder f2475a;

            C0760a(IBinder iBinder) {
                this.f2475a = iBinder;
            }

            public int m3020a(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableBodyHandler");
                    obtain.writeByteArray(bArr);
                    this.f2475a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m3021a() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("anetwork.channel.aidl.ParcelableBodyHandler");
                    this.f2475a.transact(2, obtain, obtain2, 0);
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
                return this.f2475a;
            }
        }

        public static C0751d m2998a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("anetwork.channel.aidl.ParcelableBodyHandler");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0751d)) ? new C0760a(iBinder) : (C0751d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableBodyHandler");
                    byte[] createByteArray = parcel.createByteArray();
                    int a = m2996a(createByteArray);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    parcel2.writeByteArray(createByteArray);
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("anetwork.channel.aidl.ParcelableBodyHandler");
                    boolean a2 = m2997a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("anetwork.channel.aidl.ParcelableBodyHandler");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int m2996a(byte[] bArr);

    boolean m2997a();
}
