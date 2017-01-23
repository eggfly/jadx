package com.xiaomi.mistatistic.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.xiaomi.mistatistic.sdk.data.StatEventPojo;
import java.util.List;

/* renamed from: com.xiaomi.mistatistic.sdk.a */
public interface C0520a extends IInterface {

    /* renamed from: com.xiaomi.mistatistic.sdk.a.a */
    public static abstract class C0521a extends Binder implements C0520a {

        /* renamed from: com.xiaomi.mistatistic.sdk.a.a.a */
        private static class C0529a implements C0520a {
            private IBinder f4661a;

            C0529a(IBinder iBinder) {
                this.f4661a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4661a;
            }

            public StatEventPojo m6278a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    StatEventPojo statEventPojo;
                    obtain.writeInterfaceToken("com.xiaomi.mistatistic.sdk.IBaseService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f4661a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        statEventPojo = (StatEventPojo) StatEventPojo.CREATOR.createFromParcel(obtain2);
                    } else {
                        statEventPojo = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return statEventPojo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<StatEventPojo> m6279a(long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.mistatistic.sdk.IBaseService");
                    obtain.writeLong(j);
                    this.f4661a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    List<StatEventPojo> createTypedArrayList = obtain2.createTypedArrayList(StatEventPojo.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int m6277a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaomi.mistatistic.sdk.IBaseService");
                    this.f4661a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0521a() {
            attachInterface(this, "com.xiaomi.mistatistic.sdk.IBaseService");
        }

        public static C0520a m6235a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaomi.mistatistic.sdk.IBaseService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0520a)) {
                return new C0529a(iBinder);
            }
            return (C0520a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    parcel.enforceInterface("com.xiaomi.mistatistic.sdk.IBaseService");
                    StatEventPojo a = m6233a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    parcel.enforceInterface("com.xiaomi.mistatistic.sdk.IBaseService");
                    List a2 = m6234a(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a2);
                    return true;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    parcel.enforceInterface("com.xiaomi.mistatistic.sdk.IBaseService");
                    int a3 = m6232a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.xiaomi.mistatistic.sdk.IBaseService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int m6232a();

    StatEventPojo m6233a(String str, String str2);

    List<StatEventPojo> m6234a(long j);
}
