import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import tv.ouya.console.api.Product;

public abstract class bhv$a extends Binder implements bhv {
    public static bhv j6(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("tv.ouya.console.internal.IProductListListener");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof bhv)) {
            return new bhv$a$a(iBinder);
        }
        return (bhv) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                parcel.enforceInterface("tv.ouya.console.internal.IProductListListener");
                j6(parcel.createTypedArrayList(Product.CREATOR));
                parcel2.writeNoException();
                return true;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                Bundle bundle;
                parcel.enforceInterface("tv.ouya.console.internal.IProductListListener");
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
                parcel.enforceInterface("tv.ouya.console.internal.IProductListListener");
                j6();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("tv.ouya.console.internal.IProductListListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
