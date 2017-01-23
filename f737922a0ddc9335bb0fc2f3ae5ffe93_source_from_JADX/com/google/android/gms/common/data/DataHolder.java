package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Creator<DataHolder> CREATOR;
    private static final a we;
    int[] DW;
    private boolean EQ;
    int FH;
    boolean Hw;
    private final CursorWindow[] VH;
    private final String[] Zo;
    private final int gn;
    Bundle j6;
    private Object tp;
    private final Bundle u7;
    private final int v5;

    public static class a {
        private final ArrayList<HashMap<String, Object>> DW;
        private final String FH;
        private final HashMap<Object, Integer> Hw;
        private String Zo;
        private final String[] j6;
        private boolean v5;

        private a(String[] strArr, String str) {
            this.j6 = (String[]) b.j6((Object) strArr);
            this.DW = new ArrayList();
            this.FH = str;
            this.Hw = new HashMap();
            this.v5 = false;
            this.Zo = null;
        }
    }

    class 1 extends a {
        1(String[] strArr, String str) {
            super(str, null);
        }
    }

    static {
        CREATOR = new b();
        we = new 1(new String[0], null);
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.Hw = false;
        this.EQ = true;
        this.v5 = i;
        this.Zo = strArr;
        this.VH = cursorWindowArr;
        this.gn = i2;
        this.u7 = bundle;
    }

    int DW() {
        return this.v5;
    }

    String[] FH() {
        return this.Zo;
    }

    CursorWindow[] Hw() {
        return this.VH;
    }

    public boolean VH() {
        boolean z;
        synchronized (this) {
            z = this.Hw;
        }
        return z;
    }

    public Bundle Zo() {
        return this.u7;
    }

    public void close() {
        synchronized (this) {
            if (!this.Hw) {
                this.Hw = true;
                for (CursorWindow close : this.VH) {
                    close.close();
                }
            }
        }
    }

    protected void finalize() {
        try {
            if (this.EQ && this.VH.length > 0 && !VH()) {
                String valueOf;
                if (this.tp == null) {
                    String str = "internal object: ";
                    valueOf = String.valueOf(toString());
                    valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
                } else {
                    valueOf = this.tp.toString();
                }
                Log.e("DataBuffer", new StringBuilder(String.valueOf(valueOf).length() + ProxyTextView.INPUTTYPE_textWebEditText).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(valueOf).append(")").toString());
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void j6() {
        int i;
        int i2 = 0;
        this.j6 = new Bundle();
        for (i = 0; i < this.Zo.length; i++) {
            this.j6.putInt(this.Zo[i], i);
        }
        this.DW = new int[this.VH.length];
        i = 0;
        while (i2 < this.VH.length) {
            this.DW[i2] = i;
            i += this.VH[i2].getNumRows() - (i - this.VH[i2].getStartPosition());
            i2++;
        }
        this.FH = i;
    }

    public int v5() {
        return this.gn;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
