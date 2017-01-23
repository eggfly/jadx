package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.mob.tools.MobLog;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.mob.commons.logcollector.f */
public class C4002f {
    public static synchronized long m16500a(Context context, long j, String str, int i, String str2) {
        long j2;
        synchronized (C4002f.class) {
            if (TextUtils.isEmpty(str)) {
                j2 = -1;
            } else {
                C3998b a = C3998b.m16467a(context);
                ContentValues contentValues = new ContentValues();
                contentValues.put("exception_time", Long.valueOf(j));
                contentValues.put("exception_msg", str.toString());
                contentValues.put("exception_level", Integer.valueOf(i));
                contentValues.put("exception_md5", str2);
                j2 = a.m16470a("table_exception", contentValues);
            }
        }
        return j2;
    }

    public static synchronized long m16501a(Context context, ArrayList<String> arrayList) {
        long j;
        synchronized (C4002f.class) {
            if (arrayList == null) {
                j = 0;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    stringBuilder.append("'");
                    stringBuilder.append((String) arrayList.get(i));
                    stringBuilder.append("'");
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                MobLog.getInstance().m4381i("delete COUNT == %s", Integer.valueOf(C3998b.m16467a(context).m16469a("table_exception", "exception_md5 in ( " + stringBuilder.toString().substring(0, stringBuilder.length() - 1) + " )", null)));
                j = (long) C3998b.m16467a(context).m16469a("table_exception", "exception_md5 in ( " + stringBuilder.toString().substring(0, stringBuilder.length() - 1) + " )", null);
            }
        }
        return j;
    }

    private static synchronized ArrayList<C4001e> m16502a(Context context, String str, String[] strArr) {
        ArrayList<C4001e> arrayList;
        synchronized (C4002f.class) {
            arrayList = new ArrayList();
            C4001e c4001e = new C4001e();
            C3998b a = C3998b.m16467a(context);
            String str2 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception group by exception_md5 having max(_id)";
            if (!(TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0)) {
                str2 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception where " + str + " group by exception_md5 having max(_id)";
            }
            Cursor a2 = a.m16471a(str2, strArr);
            while (a2 != null && a2.moveToNext()) {
                c4001e.f13377b.add(a2.getString(0));
                HashMap hashMap = new HashMap();
                hashMap.put(C4233j.f14402y, Integer.valueOf(a2.getInt(1)));
                hashMap.put("errat", Long.valueOf(a2.getLong(2)));
                hashMap.put(XAdErrorCode.ERROR_CODE_MESSAGE, Base64.encodeToString(a2.getString(3).getBytes(), 2));
                hashMap.put("times", Integer.valueOf(a2.getInt(4)));
                c4001e.f13376a.add(hashMap);
                if (c4001e.f13377b.size() == 50) {
                    arrayList.add(c4001e);
                    c4001e = new C4001e();
                    break;
                }
            }
            a2.close();
            if (c4001e.f13377b.size() != 0) {
                arrayList.add(c4001e);
            }
        }
        return arrayList;
    }

    public static synchronized ArrayList<C4001e> m16503a(Context context, String[] strArr) {
        ArrayList<C4001e> a;
        synchronized (C4002f.class) {
            String str = "exception_level = ?";
            if (strArr == null || strArr.length <= 0) {
                str = null;
                strArr = null;
            }
            a = C3998b.m16467a(context).m16468a("table_exception") > 0 ? C4002f.m16502a(context, str, strArr) : new ArrayList();
        }
        return a;
    }
}
