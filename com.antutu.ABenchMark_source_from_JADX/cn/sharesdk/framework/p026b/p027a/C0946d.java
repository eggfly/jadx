package cn.sharesdk.framework.p026b.p027a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import cn.sharesdk.framework.utils.C0979d;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;

/* renamed from: cn.sharesdk.framework.b.a.d */
public class C0946d {
    public static int f3210a;
    public static int f3211b;
    public static int f3212c;

    static {
        f3210a = 0;
        f3211b = 1;
        f3212c = 2;
    }

    public static synchronized long m4130a(Context context, String str, long j) {
        long a;
        synchronized (C0946d.class) {
            if (str != null) {
                if (str.trim() != BuildConfig.FLAVOR) {
                    C0944b a2 = C0944b.m4125a(context);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("post_time", Long.valueOf(j));
                    contentValues.put("message_data", str.toString());
                    a = a2.m4128a(C4233j.f14376C, contentValues);
                }
            }
            a = -1;
        }
        return a;
    }

    public static synchronized long m4131a(Context context, ArrayList<String> arrayList) {
        long j;
        synchronized (C0946d.class) {
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
                C0979d.m4390a().m4381i("delete COUNT == %s", Integer.valueOf(C0944b.m4125a(context).m4127a(C4233j.f14376C, "_id in ( " + stringBuilder.toString().substring(0, stringBuilder.length() - 1) + " )", null)));
                j = (long) C0944b.m4125a(context).m4127a(C4233j.f14376C, "_id in ( " + stringBuilder.toString().substring(0, stringBuilder.length() - 1) + " )", null);
            }
        }
        return j;
    }

    public static synchronized ArrayList<C0945c> m4132a(Context context) {
        ArrayList<C0945c> a;
        synchronized (C0946d.class) {
            a = C0944b.m4125a(context).m4126a(C4233j.f14376C) > 0 ? C0946d.m4133a(context, null, null) : new ArrayList();
        }
        return a;
    }

    private static synchronized ArrayList<C0945c> m4133a(Context context, String str, String[] strArr) {
        ArrayList<C0945c> arrayList;
        synchronized (C0946d.class) {
            arrayList = new ArrayList();
            C0945c c0945c = new C0945c();
            StringBuilder stringBuilder = new StringBuilder();
            Cursor a = C0944b.m4125a(context).m4129a(C4233j.f14376C, new String[]{C4233j.f14384g, "post_time", "message_data"}, str, strArr, null);
            StringBuilder stringBuilder2 = stringBuilder;
            C0945c c0945c2 = c0945c;
            while (a != null && a.moveToNext()) {
                c0945c2.f3209b.add(a.getString(0));
                if (c0945c2.f3209b.size() == 100) {
                    stringBuilder2.append(a.getString(2));
                    c0945c2.f3208a = stringBuilder2.toString();
                    arrayList.add(c0945c2);
                    c0945c2 = new C0945c();
                    stringBuilder2 = new StringBuilder();
                } else {
                    stringBuilder2.append(a.getString(2) + "\n");
                }
            }
            a.close();
            if (c0945c2.f3209b.size() != 0) {
                c0945c2.f3208a = stringBuilder2.toString().substring(0, stringBuilder2.length() - 1);
                arrayList.add(c0945c2);
            }
        }
        return arrayList;
    }
}
