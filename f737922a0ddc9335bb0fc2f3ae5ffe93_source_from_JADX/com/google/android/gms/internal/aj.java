package com.google.android.gms.internal;

import aga;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

@eh
public class aj {
    public static byte[] DW(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i);
        return allocate.array();
    }

    public static String[] DW(String str) {
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
            if (j6(codePointAt)) {
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

    private static boolean FH(int i) {
        return (i >= 65382 && i <= 65437) || (i >= 65441 && i <= 65500);
    }

    public static int j6(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        return aga.j6(bytes, 0, bytes.length, 0);
    }

    static boolean j6(int i) {
        return Character.isLetter(i) && (j6(UnicodeBlock.of(i)) || FH(i));
    }

    private static boolean j6(UnicodeBlock unicodeBlock) {
        return unicodeBlock == UnicodeBlock.BOPOMOFO || unicodeBlock == UnicodeBlock.BOPOMOFO_EXTENDED || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock == UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || unicodeBlock == UnicodeBlock.HANGUL_JAMO || unicodeBlock == UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == UnicodeBlock.HIRAGANA || unicodeBlock == UnicodeBlock.KATAKANA || unicodeBlock == UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }
}
