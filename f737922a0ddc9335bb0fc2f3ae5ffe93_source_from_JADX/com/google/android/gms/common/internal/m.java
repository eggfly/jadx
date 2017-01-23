package com.google.android.gms.common.internal;

import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class m {
    public static final m DW;
    public static final m EQ;
    public static final m FH;
    public static final m Hw;
    public static final m J0;
    public static final m J8;
    public static final m VH;
    public static final m Ws;
    public static final m Zo;
    public static final m gn;
    public static final m j6;
    public static final m tp;
    public static final m u7;
    public static final m v5;
    public static final m we;

    class 10 extends m {
        10() {
        }

        public boolean DW(char c) {
            return Character.isLowerCase(c);
        }
    }

    class 11 extends m {
        11() {
        }

        public boolean DW(char c) {
            return true;
        }

        public boolean DW(CharSequence charSequence) {
            b.j6((Object) charSequence);
            return true;
        }

        public m j6(m mVar) {
            b.j6((Object) mVar);
            return this;
        }
    }

    class 1 extends m {
        1() {
        }

        public boolean DW(char c) {
            return Character.isDigit(c);
        }
    }

    class 2 extends m {
        2() {
        }

        public boolean DW(char c) {
            return false;
        }

        public boolean DW(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public m j6(m mVar) {
            return (m) b.j6((Object) mVar);
        }
    }

    class 3 extends m {
        final /* synthetic */ char QX;

        3(char c) {
            this.QX = c;
        }

        public boolean DW(char c) {
            return c == this.QX;
        }

        public m j6(m mVar) {
            return mVar.DW(this.QX) ? mVar : super.j6(mVar);
        }
    }

    class 4 extends m {
        final /* synthetic */ char QX;
        final /* synthetic */ char XL;

        4(char c, char c2) {
            this.QX = c;
            this.XL = c2;
        }

        public boolean DW(char c) {
            return c == this.QX || c == this.XL;
        }
    }

    class 5 extends m {
        final /* synthetic */ char[] QX;

        5(char[] cArr) {
            this.QX = cArr;
        }

        public boolean DW(char c) {
            return Arrays.binarySearch(this.QX, c) >= 0;
        }
    }

    class 6 extends m {
        final /* synthetic */ char QX;
        final /* synthetic */ char XL;

        6(char c, char c2) {
            this.QX = c;
            this.XL = c2;
        }

        public boolean DW(char c) {
            return this.QX <= c && c <= this.XL;
        }
    }

    class 7 extends m {
        7() {
        }

        public boolean DW(char c) {
            return Character.isLetter(c);
        }
    }

    class 8 extends m {
        8() {
        }

        public boolean DW(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    class 9 extends m {
        9() {
        }

        public boolean DW(char c) {
            return Character.isUpperCase(c);
        }
    }

    private static class a extends m {
        List<m> QX;

        a(List<m> list) {
            this.QX = list;
        }

        public boolean DW(char c) {
            for (m DW : this.QX) {
                if (DW.DW(c)) {
                    return true;
                }
            }
            return false;
        }

        public m j6(m mVar) {
            List arrayList = new ArrayList(this.QX);
            arrayList.add((m) b.j6((Object) mVar));
            return new a(arrayList);
        }
    }

    static {
        j6 = j6((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").j6(j6('\u2000', '\u200a'));
        DW = j6((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").j6(j6('\u2000', '\u2006')).j6(j6('\u2008', '\u200a'));
        FH = j6('\u0000', '\u007f');
        m j6 = j6('0', '9');
        m mVar = j6;
        for (char c : "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray()) {
            mVar = mVar.j6(j6(c, (char) (c + 9)));
        }
        Hw = mVar;
        v5 = j6('\t', '\r').j6(j6('\u001c', ' ')).j6(j6('\u1680')).j6(j6('\u180e')).j6(j6('\u2000', '\u2006')).j6(j6('\u2008', '\u200b')).j6(j6('\u2028', '\u2029')).j6(j6('\u205f')).j6(j6('\u3000'));
        Zo = new 1();
        VH = new 7();
        gn = new 8();
        u7 = new 9();
        tp = new 10();
        EQ = j6('\u0000', '\u001f').j6(j6('\u007f', '\u009f'));
        we = j6('\u0000', ' ').j6(j6('\u007f', '\u00a0')).j6(j6('\u00ad')).j6(j6('\u0600', '\u0603')).j6(j6((CharSequence) "\u06dd\u070f\u1680\u17b4\u17b5\u180e")).j6(j6('\u2000', '\u200f')).j6(j6('\u2028', '\u202f')).j6(j6('\u205f', '\u2064')).j6(j6('\u206a', '\u206f')).j6(j6('\u3000')).j6(j6('\ud800', '\uf8ff')).j6(j6((CharSequence) "\ufeff\ufff9\ufffa\ufffb"));
        J0 = j6('\u0000', '\u04f9').j6(j6('\u05be')).j6(j6('\u05d0', '\u05ea')).j6(j6('\u05f3')).j6(j6('\u05f4')).j6(j6('\u0600', '\u06ff')).j6(j6('\u0750', '\u077f')).j6(j6('\u0e00', '\u0e7f')).j6(j6('\u1e00', '\u20af')).j6(j6('\u2100', '\u213a')).j6(j6('\ufb50', '\ufdff')).j6(j6('\ufe70', '\ufeff')).j6(j6('\uff61', '\uffdc'));
        J8 = new 11();
        Ws = new 2();
    }

    public static m j6(char c) {
        return new 3(c);
    }

    public static m j6(char c, char c2) {
        b.DW(c2 >= c);
        return new 6(c, c2);
    }

    public static m j6(CharSequence charSequence) {
        switch (charSequence.length()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return Ws;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return j6(charSequence.charAt(0));
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return new 4(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new 5(toCharArray);
        }
    }

    public abstract boolean DW(char c);

    public boolean DW(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!DW(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public m j6(m mVar) {
        return new a(Arrays.asList(new m[]{this, (m) b.j6((Object) mVar)}));
    }
}
