package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class b {
    private static int DW(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void DW(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void DW(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int DW = DW(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    j6(parcel, parcelable, 0);
                }
            }
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    private static void FH(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static int j6(Parcel parcel) {
        return DW(parcel, 20293);
    }

    public static void j6(Parcel parcel, int i) {
        FH(parcel, i);
    }

    public static void j6(Parcel parcel, int i, double d) {
        DW(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void j6(Parcel parcel, int i, float f) {
        DW(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void j6(Parcel parcel, int i, int i2) {
        DW(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void j6(Parcel parcel, int i, long j) {
        DW(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void j6(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int DW = DW(parcel, i);
            parcel.writeBundle(bundle);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int DW = DW(parcel, i);
            parcel.writeStrongBinder(iBinder);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int DW = DW(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int DW = DW(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            DW(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            DW(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            DW(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            DW(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int DW = DW(parcel, i);
            parcel.writeString(str);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int DW = DW(parcel, i);
            parcel.writeStringList(list);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, boolean z) {
        DW(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void j6(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int DW = DW(parcel, i);
            parcel.writeByteArray(bArr);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int DW = DW(parcel, i);
            parcel.writeIntArray(iArr);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void j6(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int DW = DW(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    j6(parcel, parcelable, i2);
                }
            }
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    public static void j6(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int DW = DW(parcel, i);
            parcel.writeStringArray(strArr);
            FH(parcel, DW);
        } else if (z) {
            DW(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void j6(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
