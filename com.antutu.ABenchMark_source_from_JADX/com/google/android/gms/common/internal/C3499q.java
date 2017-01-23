package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.google.android.gms.common.internal.C3482p.C3483a;
import com.handmark.pulltorefresh.library.C3628R;
import com.nostra13.universalimageloader.BuildConfig;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.internal.q */
public interface C3499q extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.q.a */
    public static abstract class C3501a extends Binder implements C3499q {

        /* renamed from: com.google.android.gms.common.internal.q.a.a */
        private static class C3500a implements C3499q {
            private IBinder f12114a;

            C3500a(IBinder iBinder) {
                this.f12114a = iBinder;
            }

            public void m14467a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    this.f12114a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14468a(C3482p c3482p, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    this.f12114a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14469a(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14470a(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14471a(C3482p c3482p, int i, String str, IBinder iBinder, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14472a(C3482p c3482p, int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f12114a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14473a(C3482p c3482p, int i, String str, String str2, String str3, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.f12114a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14474a(C3482p c3482p, int i, String str, String str2, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.f12114a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14475a(C3482p c3482p, int i, String str, String str2, String[] strArr, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14476a(C3482p c3482p, int i, String str, String str2, String[] strArr, String str3, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14477a(C3482p c3482p, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14478a(C3482p c3482p, int i, String str, String[] strArr, String str2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14479a(C3482p c3482p, GetServiceRequest getServiceRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14480a(C3482p c3482p, ValidateAccountRequest validateAccountRequest) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    if (validateAccountRequest != null) {
                        obtain.writeInt(1);
                        validateAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f12114a;
            }

            public void m14481b(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14482b(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14483c(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14484c(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14485d(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14486d(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14487e(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14488e(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14489f(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14490f(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14491g(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14492g(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14493h(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14494h(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14495i(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14496i(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14497j(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14498j(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14499k(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14500k(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14501l(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14502l(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14503m(C3482p c3482p, int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f12114a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14504m(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14505n(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14506o(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14507p(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14508q(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14509r(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14510s(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m14511t(C3482p c3482p, int i, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(c3482p != null ? c3482p.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12114a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C3499q m14512a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C3499q)) ? new C3500a(iBinder) : (C3499q) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ValidateAccountRequest validateAccountRequest = null;
            C3482p a;
            int readInt;
            String readString;
            Bundle bundle;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14431a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14425a(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14424a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14423a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14437b(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14439c(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14441d(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14443e(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14432a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14429a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14445f(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14447g(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14449h(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14451i(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14453j(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.CUSTOM /*16*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14455k(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14457l(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14459m(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14426a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14433a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14436b(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C4209a.f14215r /*22*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14438c(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C2279R.styleable.Toolbar_titleTextColor /*23*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14460n(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C4209a.f14216s /*24*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14440d(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C2279R.styleable.ActionBar_popupTheme /*25*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14461o(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14442e(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_actionModeStyle /*27*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14462p(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14422a();
                    parcel2.writeNoException();
                    return true;
                case jni.SID_RAM /*30*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14430a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case jni.SID_CPU_MATH /*31*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14444f(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C4574a.ORDERED /*32*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14446g(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case jni.SID_CPU_MULTI /*33*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14428a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case jni.SID_UX_SEC /*34*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14427a(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case jni.SID_UX_DATA /*35*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14448h(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case jni.SID_UX_GAME /*36*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14450i(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case jni.SID_UX_IMG /*37*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14463q(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case jni.SID_UX_IO /*38*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14464r(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case BuildConfig.VERSION_CODE /*40*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14452j(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case jni.SID_MAX /*41*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14465s(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_dialogTheme /*42*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14454k(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    readInt = parcel.readInt();
                    readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m14466t(a, readInt, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14456l(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    m14458m(C3483a.m14371a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                    GetServiceRequest getServiceRequest;
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        getServiceRequest = (GetServiceRequest) GetServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    m14434a(a, getServiceRequest);
                    parcel2.writeNoException();
                    return true;
                case C1692R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    a = C3483a.m14371a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        validateAccountRequest = (ValidateAccountRequest) ValidateAccountRequest.CREATOR.createFromParcel(parcel);
                    }
                    m14435a(a, validateAccountRequest);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m14422a();

    void m14423a(C3482p c3482p, int i);

    void m14424a(C3482p c3482p, int i, String str);

    void m14425a(C3482p c3482p, int i, String str, Bundle bundle);

    void m14426a(C3482p c3482p, int i, String str, IBinder iBinder, Bundle bundle);

    void m14427a(C3482p c3482p, int i, String str, String str2);

    void m14428a(C3482p c3482p, int i, String str, String str2, String str3, String[] strArr);

    void m14429a(C3482p c3482p, int i, String str, String str2, String[] strArr);

    void m14430a(C3482p c3482p, int i, String str, String str2, String[] strArr, Bundle bundle);

    void m14431a(C3482p c3482p, int i, String str, String str2, String[] strArr, String str3, Bundle bundle);

    void m14432a(C3482p c3482p, int i, String str, String str2, String[] strArr, String str3, IBinder iBinder, String str4, Bundle bundle);

    void m14433a(C3482p c3482p, int i, String str, String[] strArr, String str2, Bundle bundle);

    void m14434a(C3482p c3482p, GetServiceRequest getServiceRequest);

    void m14435a(C3482p c3482p, ValidateAccountRequest validateAccountRequest);

    void m14436b(C3482p c3482p, int i, String str);

    void m14437b(C3482p c3482p, int i, String str, Bundle bundle);

    void m14438c(C3482p c3482p, int i, String str);

    void m14439c(C3482p c3482p, int i, String str, Bundle bundle);

    void m14440d(C3482p c3482p, int i, String str);

    void m14441d(C3482p c3482p, int i, String str, Bundle bundle);

    void m14442e(C3482p c3482p, int i, String str);

    void m14443e(C3482p c3482p, int i, String str, Bundle bundle);

    void m14444f(C3482p c3482p, int i, String str);

    void m14445f(C3482p c3482p, int i, String str, Bundle bundle);

    void m14446g(C3482p c3482p, int i, String str);

    void m14447g(C3482p c3482p, int i, String str, Bundle bundle);

    void m14448h(C3482p c3482p, int i, String str);

    void m14449h(C3482p c3482p, int i, String str, Bundle bundle);

    void m14450i(C3482p c3482p, int i, String str);

    void m14451i(C3482p c3482p, int i, String str, Bundle bundle);

    void m14452j(C3482p c3482p, int i, String str);

    void m14453j(C3482p c3482p, int i, String str, Bundle bundle);

    void m14454k(C3482p c3482p, int i, String str);

    void m14455k(C3482p c3482p, int i, String str, Bundle bundle);

    void m14456l(C3482p c3482p, int i, String str);

    void m14457l(C3482p c3482p, int i, String str, Bundle bundle);

    void m14458m(C3482p c3482p, int i, String str);

    void m14459m(C3482p c3482p, int i, String str, Bundle bundle);

    void m14460n(C3482p c3482p, int i, String str, Bundle bundle);

    void m14461o(C3482p c3482p, int i, String str, Bundle bundle);

    void m14462p(C3482p c3482p, int i, String str, Bundle bundle);

    void m14463q(C3482p c3482p, int i, String str, Bundle bundle);

    void m14464r(C3482p c3482p, int i, String str, Bundle bundle);

    void m14465s(C3482p c3482p, int i, String str, Bundle bundle);

    void m14466t(C3482p c3482p, int i, String str, Bundle bundle);
}
