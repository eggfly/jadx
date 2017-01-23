package com.google.android.gms.p146b;

import com.umeng.message.util.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;

@gb
/* renamed from: com.google.android.gms.b.af */
public class af {
    public static int m11761a(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes(HttpRequest.f14548a);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        return jp.m13566a(bytes, 0, bytes.length, 0);
    }

    static boolean m11762a(int i) {
        return Character.isLetter(i) && (af.m11763a(UnicodeBlock.of(i)) || af.m11764b(i));
    }

    private static boolean m11763a(UnicodeBlock unicodeBlock) {
        return unicodeBlock == UnicodeBlock.BOPOMOFO || unicodeBlock == UnicodeBlock.BOPOMOFO_EXTENDED || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock == UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || unicodeBlock == UnicodeBlock.HANGUL_JAMO || unicodeBlock == UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == UnicodeBlock.HIRAGANA || unicodeBlock == UnicodeBlock.KATAKANA || unicodeBlock == UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    private static boolean m11764b(int i) {
        return (i >= 65382 && i <= 65437) || (i >= 65441 && i <= 65500);
    }

    public static String[] m11765b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        char[] toCharArray = str.toCharArray();
        int length = str.length();
        Object obj = null;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            Object obj2;
            Object obj3;
            int codePointAt = Character.codePointAt(toCharArray, i2);
            int charCount = Character.charCount(codePointAt);
            if (af.m11762a(codePointAt)) {
                if (obj != null) {
                    arrayList.add(new String(toCharArray, i, i2 - i));
                }
                arrayList.add(new String(toCharArray, i2, charCount));
                i3 = i;
                obj2 = null;
            } else if (Character.isLetterOrDigit(codePointAt) || Character.getType(codePointAt) == 6 || Character.getType(codePointAt) == 8) {
                if (obj == null) {
                    i = i2;
                }
                i3 = i;
                i = 1;
            } else if (obj != null) {
                arrayList.add(new String(toCharArray, i, i2 - i));
                i3 = i;
                obj2 = null;
            } else {
                obj3 = obj;
                i3 = i;
                obj2 = obj3;
            }
            i2 += charCount;
            obj3 = obj2;
            i = i3;
            obj = obj3;
        }
        if (obj != null) {
            arrayList.add(new String(toCharArray, i, i2 - i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
