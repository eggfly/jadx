package com.google.android.gms.p151a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.a.a */
public interface C2687a extends IInterface {

    /* renamed from: com.google.android.gms.a.a.a */
    public static abstract class C2689a extends Binder implements C2687a {

        /* renamed from: com.google.android.gms.a.a.a.a */
        private static class C2688a implements C2687a {
            private IBinder f9222a;

            C2688a(IBinder iBinder) {
                this.f9222a = iBinder;
            }

            public IBinder asBinder() {
                return this.f9222a;
            }
        }

        public C2689a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C2687a m10261a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2687a)) ? new C2688a(iBinder) : (C2687a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
