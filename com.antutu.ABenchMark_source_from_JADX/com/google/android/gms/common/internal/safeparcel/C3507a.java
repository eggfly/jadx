package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import cn.sharesdk.framework.Platform;
import com.umeng.message.proguard.C4233j;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C3507a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a.a */
    public static class C3506a extends RuntimeException {
        public C3506a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static int m14520a(int i) {
        return Platform.CUSTOMER_ACTION_MASK & i;
    }

    public static int m14521a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m14522a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != SupportMenu.CATEGORY_MASK ? (i >> 16) & Platform.CUSTOMER_ACTION_MASK : parcel.readInt();
    }

    public static <T extends Parcelable> T m14523a(Parcel parcel, int i, Creator<T> creator) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m14524a(Parcel parcel, int i, int i2) {
        int a = C3507a.m14522a(parcel, i);
        if (a != i2) {
            throw new C3506a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + C4233j.f14397t, parcel);
        }
    }

    private static void m14525a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C3506a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + C4233j.f14397t, parcel);
        }
    }

    public static int m14526b(Parcel parcel) {
        int a = C3507a.m14521a(parcel);
        int a2 = C3507a.m14522a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C3507a.m14520a(a) != 20293) {
            throw new C3506a("Expected object header. Got 0x" + Integer.toHexString(a), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C3506a("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m14527b(Parcel parcel, int i) {
        parcel.setDataPosition(C3507a.m14522a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m14528b(Parcel parcel, int i, Creator<T> creator) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m14529c(Parcel parcel, int i, Creator<T> creator) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m14530c(Parcel parcel, int i) {
        C3507a.m14524a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int m14531d(Parcel parcel, int i) {
        C3507a.m14524a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m14532e(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        if (a == 0) {
            return null;
        }
        C3507a.m14525a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m14533f(Parcel parcel, int i) {
        C3507a.m14524a(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m14534g(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        if (a == 0) {
            return null;
        }
        C3507a.m14525a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger m14535h(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m14536i(Parcel parcel, int i) {
        C3507a.m14524a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double m14537j(Parcel parcel, int i) {
        C3507a.m14524a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal m14538k(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String m14539l(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m14540m(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m14541n(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m14542o(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static boolean[] m14543p(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    public static int[] m14544q(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static long[] m14545r(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] m14546s(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    public static float[] m14547t(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    public static double[] m14548u(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] m14549v(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }

    public static String[] m14550w(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> m14551x(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m14552y(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    public static Parcel[] m14553z(Parcel parcel, int i) {
        int a = C3507a.m14522a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }
}
