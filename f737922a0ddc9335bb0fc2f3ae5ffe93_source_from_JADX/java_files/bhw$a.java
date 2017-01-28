import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;

public abstract class bhw$a extends Binder implements bhw {
    public bhw$a() {
        attachInterface(this, "tv.ouya.console.internal.IStringListener");
    }

    public static bhw j6(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("tv.ouya.console.internal.IStringListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof bhw)) {
            return new bhw$a$a(iBinder);
        }
        return (bhw) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                parcel.enforceInterface("tv.ouya.console.internal.IStringListener");
                j6(parcel.readString());
                parcel2.writeNoException();
                return true;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                Bundle bundle;
                parcel.enforceInterface("tv.ouya.console.internal.IStringListener");
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                j6(readInt, readString, bundle);
                parcel2.writeNoException();
                return true;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                parcel.enforceInterface("tv.ouya.console.internal.IStringListener");
                j6();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("tv.ouya.console.internal.IStringListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
