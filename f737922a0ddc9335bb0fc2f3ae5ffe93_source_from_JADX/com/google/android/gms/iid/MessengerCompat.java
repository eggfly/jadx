package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR;
    c DW;
    Messenger j6;

    class 1 implements Creator<MessengerCompat> {
        1() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return j6(parcel);
        }

        public MessengerCompat j6(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] j6(int i) {
            return new MessengerCompat[i];
        }

        public /* synthetic */ Object[] newArray(int i) {
            return j6(i);
        }
    }

    private final class a extends com.google.android.gms.iid.c.a {
        final /* synthetic */ MessengerCompat DW;
        Handler j6;

        a(MessengerCompat messengerCompat, Handler handler) {
            this.DW = messengerCompat;
            this.j6 = handler;
        }

        public void j6(Message message) {
            message.arg2 = Binder.getCallingUid();
            this.j6.dispatchMessage(message);
        }
    }

    static {
        CREATOR = new 1();
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.j6 = new Messenger(handler);
        } else {
            this.DW = new a(this, handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.j6 = new Messenger(iBinder);
        } else {
            this.DW = com.google.android.gms.iid.c.a.j6(iBinder);
        }
    }

    @TargetApi(21)
    private static int FH(Message message) {
        return message.sendingUid;
    }

    public static int j6(Message message) {
        return VERSION.SDK_INT >= 21 ? FH(message) : message.arg2;
    }

    public void DW(Message message) {
        if (this.j6 != null) {
            this.j6.send(message);
        } else {
            this.DW.j6(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = j6().equals(((MessengerCompat) obj).j6());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return j6().hashCode();
    }

    public IBinder j6() {
        return this.j6 != null ? this.j6.getBinder() : this.DW.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.j6 != null) {
            parcel.writeStrongBinder(this.j6.getBinder());
        } else {
            parcel.writeStrongBinder(this.DW.asBinder());
        }
    }
}
