package android.support.v4.database;

import android.text.TextUtils;
import com.umeng.message.proguard.C4233j;

public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0) {
            return strArr2;
        }
        Object obj = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        System.arraycopy(strArr2, 0, obj, strArr.length, strArr2.length);
        return obj;
    }

    public static String concatenateWhere(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : TextUtils.isEmpty(str2) ? str : C4233j.f14396s + str + ") AND (" + str2 + C4233j.f14397t;
    }
}
