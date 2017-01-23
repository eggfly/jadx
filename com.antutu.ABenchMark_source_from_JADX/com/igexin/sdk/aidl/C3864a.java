package com.igexin.sdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.sdk.aidl.a */
public abstract class C3864a extends Binder implements IGexinMsgService {
    public C3864a() {
        attachInterface(this, "com.igexin.sdk.aidl.IGexinMsgService");
    }

    public static IGexinMsgService m15908a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.igexin.sdk.aidl.IGexinMsgService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof IGexinMsgService)) ? new C3944b(iBinder) : (IGexinMsgService) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int startService;
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = startService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = stopService(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = isStarted(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.QUIC /*4*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = setSilentTime(parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                byte[] extFunction = extFunction(parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeByteArray(extFunction);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = onASNLConnected(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = onPSNLConnected(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = sendByASNL(parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = receiveToPSNL(parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = onASNLNetworkConnected();
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                parcel.enforceInterface("com.igexin.sdk.aidl.IGexinMsgService");
                startService = onASNLNetworkDisconnected();
                parcel2.writeNoException();
                parcel2.writeInt(startService);
                return true;
            case 1598968902:
                parcel2.writeString("com.igexin.sdk.aidl.IGexinMsgService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
