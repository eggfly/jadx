package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;

class IMediaBrowserServiceAdapterApi21 {

    static abstract class Stub extends Binder implements IInterface {
        private static final String DESCRIPTOR = "android.service.media.IMediaBrowserService";
        private static final int TRANSACTION_addSubscription = 3;
        private static final int TRANSACTION_connect = 1;
        private static final int TRANSACTION_disconnect = 2;
        private static final int TRANSACTION_getMediaItem = 5;
        private static final int TRANSACTION_removeSubscription = 4;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public abstract void addSubscription(String str, Object obj);

        public IBinder asBinder() {
            return this;
        }

        public abstract void connect(String str, Bundle bundle, Object obj);

        public abstract void disconnect(Object obj);

        public abstract void getMediaItem(String str, ResultReceiver resultReceiver);

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ResultReceiver resultReceiver = null;
            String readString;
            switch (i) {
                case TRANSACTION_connect /*1*/:
                    Bundle bundle;
                    parcel.enforceInterface(DESCRIPTOR);
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    connect(readString, bundle, Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case TRANSACTION_disconnect /*2*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    disconnect(Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case TRANSACTION_addSubscription /*3*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    addSubscription(parcel.readString(), Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case TRANSACTION_removeSubscription /*4*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeSubscription(parcel.readString(), Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case TRANSACTION_getMediaItem /*5*/:
                    parcel.enforceInterface(DESCRIPTOR);
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                    }
                    getMediaItem(readString, resultReceiver);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public abstract void removeSubscription(String str, Object obj);
    }

    IMediaBrowserServiceAdapterApi21() {
    }
}
