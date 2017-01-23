package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import cn.sharesdk.framework.Platform;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C3508b {
    public static int m14554a(Parcel parcel) {
        return C3508b.m14572b(parcel, 20293);
    }

    public static void m14555a(Parcel parcel, int i) {
        C3508b.m14575c(parcel, i);
    }

    public static void m14556a(Parcel parcel, int i, float f) {
        C3508b.m14573b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m14557a(Parcel parcel, int i, int i2) {
        C3508b.m14573b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m14558a(Parcel parcel, int i, long j) {
        C3508b.m14573b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m14559a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.writeBundle(bundle);
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14560a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14561a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14562a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C3508b.m14572b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14563a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C3508b.m14573b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14564a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C3508b.m14573b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14565a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.writeString(str);
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14566a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.writeStringList(list);
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14567a(Parcel parcel, int i, boolean z) {
        C3508b.m14573b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m14568a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.writeByteArray(bArr);
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static void m14569a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.writeIntArray(iArr);
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m14570a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C3508b.m14572b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C3508b.m14571a(parcel, parcelable, i2);
                }
            }
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m14571a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m14572b(Parcel parcel, int i) {
        parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m14573b(Parcel parcel, int i, int i2) {
        if (i2 >= Platform.CUSTOMER_ACTION_MASK) {
            parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void m14574b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = C3508b.m14572b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C3508b.m14571a(parcel, parcelable, 0);
                }
            }
            C3508b.m14575c(parcel, b);
        } else if (z) {
            C3508b.m14573b(parcel, i, 0);
        }
    }

    private static void m14575c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }
}
