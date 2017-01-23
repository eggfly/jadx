package com.google.android.gms.p146b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.facebook.ads.C2279R;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.C2963a;
import com.google.android.gms.ads.internal.reward.mediation.client.C2963a.C2965a;
import com.google.android.gms.p146b.dw.C3141a;
import com.google.android.gms.p146b.dz.C3157a;
import com.google.android.gms.p146b.ea.C3161a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2687a.C2689a;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.b.dv */
public interface dv extends IInterface {

    /* renamed from: com.google.android.gms.b.dv.a */
    public static abstract class C3153a extends Binder implements dv {

        /* renamed from: com.google.android.gms.b.dv.a.a */
        private static class C3152a implements dv {
            private IBinder f10724a;

            C3152a(IBinder iBinder) {
                this.f10724a = iBinder;
            }

            public C2687a m12387a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C2687a a = C2689a.m10261a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12388a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, C2963a c2963a, String str2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (c2963a != null) {
                        iBinder = c2963a.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str2);
                    this.f10724a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12389a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, dw dwVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (dwVar != null) {
                        iBinder = dwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10724a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12390a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dwVar != null) {
                        iBinder = dwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10724a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12391a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dwVar != null) {
                        iBinder = dwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    this.f10724a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12392a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, dw dwVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (dwVar != null) {
                        iBinder = dwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10724a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12393a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c2687a != null ? c2687a.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dwVar != null) {
                        iBinder = dwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f10724a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12394a(AdRequestParcel adRequestParcel, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f10724a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12395a(AdRequestParcel adRequestParcel, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f10724a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f10724a;
            }

            public void m12396b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12397c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12398d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12399e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m12400f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean m12401g() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(13, obtain, obtain2, 0);
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

            public dz m12402h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    dz a = C3157a.m12445a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ea m12403i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    ea a = C3161a.m12474a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle m12404j() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle m12405k() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle m12406l() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f10724a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C3153a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static dv m12407a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof dv)) ? new C3152a(iBinder) : (dv) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AdRequestParcel adRequestParcel = null;
            C2687a a;
            IBinder asBinder;
            Bundle j;
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12372a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.m10729a(parcel) : null, parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m10724a(parcel) : null, parcel.readString(), C3141a.m12301a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    a = m12367a();
                    parcel2.writeNoException();
                    if (a != null) {
                        asBinder = a.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    a = C2689a.m10261a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        adRequestParcel = AdRequestParcel.CREATOR.m10724a(parcel);
                    }
                    m12369a(a, adRequestParcel, parcel.readString(), C3141a.m12301a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.QUIC /*4*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12376b();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12377c();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12373a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.m10729a(parcel) : null, parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m10724a(parcel) : null, parcel.readString(), parcel.readString(), C3141a.m12301a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12370a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m10724a(parcel) : null, parcel.readString(), parcel.readString(), C3141a.m12301a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12378d();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12379e();
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12368a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m10724a(parcel) : null, parcel.readString(), C2965a.m11508a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (parcel.readInt() != 0) {
                        adRequestParcel = AdRequestParcel.CREATOR.m10724a(parcel);
                    }
                    m12374a(adRequestParcel, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12380f();
                    parcel2.writeNoException();
                    return true;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean g = m12381g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g ? 1 : 0);
                    return true;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    m12371a(C2689a.m10261a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdRequestParcel.CREATOR.m10724a(parcel) : null, parcel.readString(), parcel.readString(), C3141a.m12301a(parcel.readStrongBinder()), parcel.readInt() != 0 ? NativeAdOptionsParcel.CREATOR.m10903a(parcel) : null, parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    dz h = m12382h();
                    parcel2.writeNoException();
                    if (h != null) {
                        asBinder = h.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case SpdyProtocol.CUSTOM /*16*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    ea i3 = m12383i();
                    parcel2.writeNoException();
                    if (i3 != null) {
                        asBinder = i3.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = m12384j();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = m12385k();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    j = m12386l();
                    parcel2.writeNoException();
                    if (j != null) {
                        parcel2.writeInt(1);
                        j.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (parcel.readInt() != 0) {
                        adRequestParcel = AdRequestParcel.CREATOR.m10724a(parcel);
                    }
                    m12375a(adRequestParcel, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C2687a m12367a();

    void m12368a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, C2963a c2963a, String str2);

    void m12369a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, dw dwVar);

    void m12370a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar);

    void m12371a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list);

    void m12372a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, dw dwVar);

    void m12373a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar);

    void m12374a(AdRequestParcel adRequestParcel, String str);

    void m12375a(AdRequestParcel adRequestParcel, String str, String str2);

    void m12376b();

    void m12377c();

    void m12378d();

    void m12379e();

    void m12380f();

    boolean m12381g();

    dz m12382h();

    ea m12383i();

    Bundle m12384j();

    Bundle m12385k();

    Bundle m12386l();
}
