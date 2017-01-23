package com.google.android.gms.measurement.internal;

import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hr.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class g {
    final boolean DW;
    final String FH;
    final List<String> Hw;
    final boolean Zo;
    final int j6;
    final String v5;

    public g(f fVar) {
        boolean z;
        boolean z2 = false;
        b.j6((Object) fVar);
        if (fVar.j6 == null || fVar.j6.intValue() == 0) {
            z = false;
        } else {
            if (fVar.j6.intValue() == 6) {
                if (fVar.Hw == null || fVar.Hw.length == 0) {
                    z = false;
                }
            } else if (fVar.DW == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.j6 = fVar.j6.intValue();
            if (fVar.FH != null && fVar.FH.booleanValue()) {
                z2 = true;
            }
            this.DW = z2;
            if (this.DW || this.j6 == 1 || this.j6 == 6) {
                this.FH = fVar.DW;
            } else {
                this.FH = fVar.DW.toUpperCase(Locale.ENGLISH);
            }
            this.Hw = fVar.Hw == null ? null : j6(fVar.Hw, this.DW);
            if (this.j6 == 1) {
                this.v5 = this.FH;
            } else {
                this.v5 = null;
            }
        } else {
            this.j6 = 0;
            this.DW = false;
            this.FH = null;
            this.Hw = null;
            this.v5 = null;
        }
        this.Zo = z;
    }

    private List<String> j6(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean j6(String str) {
        if (!this.Zo || str == null) {
            return null;
        }
        if (!(this.DW || this.j6 == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.j6) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return Boolean.valueOf(Pattern.compile(this.v5, this.DW ? 0 : 66).matcher(str).matches());
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return Boolean.valueOf(str.startsWith(this.FH));
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return Boolean.valueOf(str.endsWith(this.FH));
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return Boolean.valueOf(str.contains(this.FH));
            case 5:
                return Boolean.valueOf(str.equals(this.FH));
            case 6:
                return Boolean.valueOf(this.Hw.contains(str));
            default:
                return null;
        }
    }
}
