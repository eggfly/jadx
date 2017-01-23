package com.aide.uidesigner;

import com.aide.uidesigner.h.b;
import org.w3c.dom.Attr;

public class a {
    public final String DW;
    public final Attr FH;
    public final com.aide.uidesigner.h.a j6;

    public a(com.aide.uidesigner.h.a aVar, String str) {
        this.j6 = aVar;
        this.DW = str;
        this.FH = null;
    }

    public a(com.aide.uidesigner.h.a aVar, Attr attr) {
        this.j6 = aVar;
        this.DW = attr.getValue();
        this.FH = attr;
    }

    public a(com.aide.uidesigner.h.a aVar) {
        this.j6 = aVar;
        this.DW = null;
        this.FH = null;
    }

    public String j6() {
        if (this.j6.v5 == b.Text) {
            return "&quot;" + this.DW + "&quot;";
        }
        return j6(this.DW);
    }

    public static String j6(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.startsWith("@id/")) {
            return str.substring("@id/".length());
        }
        if (str.startsWith("?android:attr/")) {
            str = "Android_" + str.substring("?android:attr/".length());
        }
        if (!Character.isLetter(str.charAt(0))) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Character.toUpperCase(str.charAt(0)));
        int i = 0;
        for (int i2 = 1; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (i != 0) {
                stringBuffer.append(Character.toUpperCase(charAt));
                i = 0;
            } else if (charAt == '|') {
                stringBuffer.append(" | ");
                i = 1;
            } else if (charAt == '_') {
                stringBuffer.append(" ");
                i = 1;
            } else {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public boolean DW() {
        return this.DW != null;
    }

    public boolean FH() {
        return DW() && this.FH == null;
    }
}
