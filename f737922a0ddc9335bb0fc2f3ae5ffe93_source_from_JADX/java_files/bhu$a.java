import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.aide.uidesigner.ProxyTextView;
import tv.ouya.console.api.Purchasable;

public abstract class bhu$a extends Binder implements bhu {
    public static bhu j6(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("tv.ouya.console.internal.IIapServiceDefinition");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof bhu)) {
            return new bhu$a$a(iBinder);
        }
        return (bhu) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                parcel.enforceInterface("tv.ouya.console.internal.IIapServiceDefinition");
                j6();
                parcel2.writeNoException();
                return true;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                parcel.enforceInterface("tv.ouya.console.internal.IIapServiceDefinition");
                j6(parcel.readString(), parcel.createTypedArrayList(Purchasable.CREATOR), bhv$a.j6(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                Purchasable purchasable;
                parcel.enforceInterface("tv.ouya.console.internal.IIapServiceDefinition");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    purchasable = (Purchasable) Purchasable.CREATOR.createFromParcel(parcel);
                } else {
                    purchasable = null;
                }
                j6(readString, purchasable, bhw$a.j6(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                parcel.enforceInterface("tv.ouya.console.internal.IIapServiceDefinition");
                j6(parcel.readString(), bhw$a.j6(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("tv.ouya.console.internal.IIapServiceDefinition");
                DW(parcel.readString(), bhw$a.j6(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("tv.ouya.console.internal.IIapServiceDefinition");
                j6(parcel.readString(), parcel.readInt(), parcel.createTypedArrayList(Purchasable.CREATOR), bhv$a.j6(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("tv.ouya.console.internal.IIapServiceDefinition");
                FH(parcel.readString(), bhw$a.j6(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("tv.ouya.console.internal.IIapServiceDefinition");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
