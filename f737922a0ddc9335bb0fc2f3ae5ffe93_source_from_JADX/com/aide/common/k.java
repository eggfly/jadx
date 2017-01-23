package com.aide.common;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import com.aide.uidesigner.ProxyTextView;

public class k {
    private int DW;
    private boolean FH;
    private boolean Hw;
    private char j6;
    private boolean v5;

    public k(int i, char c, boolean z, boolean z2, boolean z3) {
        this.j6 = c;
        this.DW = i;
        this.FH = z;
        this.Hw = z2;
        this.v5 = z3;
    }

    public k(int i, boolean z, boolean z2, boolean z3) {
        this.j6 = '\uffff';
        this.DW = i;
        this.FH = z;
        this.Hw = z2;
        this.v5 = z3;
    }

    public boolean j6() {
        return this.j6 != '\uffff';
    }

    public char DW() {
        return this.j6;
    }

    public int FH() {
        return this.DW;
    }

    public boolean j6(k kVar) {
        if (this.v5 != kVar.v5 || this.Hw != kVar.Hw || this.FH != kVar.FH) {
            return false;
        }
        if (this.DW != -1 && this.DW == kVar.DW) {
            return true;
        }
        if (this.j6 == '\uffff' || this.j6 != kVar.j6) {
            return false;
        }
        return true;
    }

    public String toString() {
        String str = "";
        if (this.FH) {
            str = str + "Shift+";
        }
        if (this.Hw) {
            str = str + "Ctrl+";
        }
        if (this.v5) {
            str = str + "Alt+";
        }
        return str + v5();
    }

    private String v5() {
        switch (this.DW) {
            case -1:
                return Character.toUpperCase(this.j6) + "";
            case 19:
                return "Up";
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return "Down";
            case 21:
                return "Left";
            case 22:
                return "Right";
            case 24:
                return "VolUp";
            case 25:
                return "VolDown";
            case 61:
                return "Tab";
            case 62:
                return "Space";
            case 66:
                return "Enter";
            case 67:
                return "Backspace";
            case 92:
                return "PgUp";
            case 93:
                return "PgDown";
            case 122:
                return "Home";
            case 123:
                return "End";
            case 164:
                return "VolMute";
            default:
                String trim = (KeyCharacterMap.load(0).getDisplayLabel(this.DW) + "").trim();
                if (trim.length() > 0) {
                    return trim;
                }
                trim = KeyEvent.keyCodeToString(this.DW).toLowerCase();
                if (trim.startsWith("keycode_")) {
                    trim = trim.substring("keycode_".length());
                }
                trim = trim.replace("_", " ");
                return trim.substring(0, 1).toUpperCase() + trim.substring(1);
        }
    }

    public String Hw() {
        return this.DW + "," + this.j6 + "," + this.FH + "," + this.Hw + "," + this.v5;
    }

    public static k j6(String str) {
        String[] split = str.split(",");
        if (split.length != 5) {
            return null;
        }
        return new k(Integer.parseInt(split[0]), (char) Integer.parseInt(split[1]), Boolean.parseBoolean(split[2]), Boolean.parseBoolean(split[3]), Boolean.parseBoolean(split[4]));
    }
}
