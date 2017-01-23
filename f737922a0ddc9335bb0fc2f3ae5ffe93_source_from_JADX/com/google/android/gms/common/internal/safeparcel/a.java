package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class a {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            super(new StringBuilder(String.valueOf(str).length() + 41).append(str).append(" Parcel: pos=").append(dataPosition).append(" size=").append(parcel.dataSize()).toString());
        }
    }

    public static Parcel[] BT(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
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
        parcel.setDataPosition(dataPosition + j6);
        return parcelArr;
    }

    public static int DW(Parcel parcel) {
        int j6 = j6(parcel);
        int j62 = j6(parcel, j6);
        int dataPosition = parcel.dataPosition();
        if (j6(j6) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(j6));
            throw new a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        j6 = dataPosition + j62;
        if (j6 >= dataPosition && j6 <= parcel.dataSize()) {
            return j6;
        }
        throw new a("Size read is invalid start=" + dataPosition + " end=" + j6, parcel);
    }

    public static void DW(Parcel parcel, int i) {
        parcel.setDataPosition(j6(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] DW(Parcel parcel, int i, Creator<T> creator) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(j6 + dataPosition);
        return createTypedArray;
    }

    public static double EQ(Parcel parcel, int i) {
        j6(parcel, i, 8);
        return parcel.readDouble();
    }

    public static <T> ArrayList<T> FH(Parcel parcel, int i, Creator<T> creator) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(j6 + dataPosition);
        return createTypedArrayList;
    }

    public static boolean FH(Parcel parcel, int i) {
        j6(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int Hw(Parcel parcel, int i) {
        j6(parcel, i, 4);
        return parcel.readInt();
    }

    public static BigDecimal J0(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(j6 + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String J8(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(j6 + dataPosition);
        return readString;
    }

    public static long[] Mr(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(j6 + dataPosition);
        return createLongArray;
    }

    public static Bundle QX(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(j6 + dataPosition);
        return readBundle;
    }

    public static BigInteger[] U2(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + j6);
        return bigIntegerArr;
    }

    public static Long VH(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        if (j6 == 0) {
            return null;
        }
        j6(parcel, i, j6, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static IBinder Ws(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(j6 + dataPosition);
        return readStrongBinder;
    }

    public static byte[] XL(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(j6 + dataPosition);
        return createByteArray;
    }

    public static long Zo(Parcel parcel, int i) {
        j6(parcel, i, 8);
        return parcel.readLong();
    }

    public static float[] a8(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(j6 + dataPosition);
        return createFloatArray;
    }

    public static boolean[] aM(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(j6 + dataPosition);
        return createBooleanArray;
    }

    public static String[] er(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(j6 + dataPosition);
        return createStringArray;
    }

    public static Parcel gW(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, j6);
        parcel.setDataPosition(j6 + dataPosition);
        return obtain;
    }

    public static BigInteger gn(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(j6 + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static int[] j3(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(j6 + dataPosition);
        return createIntArray;
    }

    public static int j6(int i) {
        return 65535 & i;
    }

    public static int j6(Parcel parcel) {
        return parcel.readInt();
    }

    public static int j6(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static <T extends Parcelable> T j6(Parcel parcel, int i, Creator<T> creator) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(j6 + dataPosition);
        return parcelable;
    }

    private static void j6(Parcel parcel, int i, int i2) {
        int j6 = j6(parcel, i);
        if (j6 != i2) {
            String valueOf = String.valueOf(Integer.toHexString(j6));
            throw new a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(j6).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void j6(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new a(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static double[] lg(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(j6 + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] rN(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + j6);
        return bigDecimalArr;
    }

    public static Float tp(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        if (j6 == 0) {
            return null;
        }
        j6(parcel, i, j6, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static float u7(Parcel parcel, int i) {
        j6(parcel, i, 4);
        return parcel.readFloat();
    }

    public static Integer v5(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        if (j6 == 0) {
            return null;
        }
        j6(parcel, i, j6, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static Double we(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        if (j6 == 0) {
            return null;
        }
        j6(parcel, i, j6, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static ArrayList<String> yS(Parcel parcel, int i) {
        int j6 = j6(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j6 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(j6 + dataPosition);
        return createStringArrayList;
    }
}
