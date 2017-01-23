package com.umeng.message.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;
import com.umeng.message.common.UmengMessageDeviceConfig;

/* renamed from: com.umeng.message.provider.a */
public class C4243a {
    public static String f14474a;
    public static Uri f14475b;
    public static Uri f14476c;
    public static Uri f14477d;
    public static Uri f14478e;
    public static Uri f14479f;
    public static Uri f14480g;
    public static Uri f14481h;
    public static Uri f14482i;
    public static Uri f14483j;
    private static Context f14484k;
    private static C4243a f14485l;
    private static String f14486m;

    /* renamed from: com.umeng.message.provider.a.a */
    public static class C4242a implements BaseColumns {
        public static final String f14462a = "/MessageStores/";
        public static final String f14463b = "/MsgTemps/";
        public static final String f14464c = "/MsgAlias/";
        public static final String f14465d = "/MsgAliasDeleteAll/";
        public static final String f14466e = "/MsgLogStores/";
        public static final String f14467f = "/MsgLogIdTypeStores/";
        public static final String f14468g = "/MsgLogStoreForAgoos/";
        public static final String f14469h = "/MsgLogIdTypeStoreForAgoos/";
        public static final String f14470i = "/MsgConfigInfos/";
        public static final String f14471j = "vnd.android.cursor.dir/vnd.umeng.message";
        public static final String f14472k = "vnd.android.cursor.item/vnd.umeng.message";
        private static final String f14473l = "content://";

        private C4242a() {
        }
    }

    static {
        f14474a = null;
        f14475b = null;
        f14476c = null;
        f14477d = null;
        f14478e = null;
        f14479f = null;
        f14480g = null;
        f14481h = null;
        f14482i = null;
        f14483j = null;
    }

    private C4243a() {
    }

    public static C4243a m17332a(Context context) {
        f14484k = context;
        if (f14485l == null) {
            f14485l = new C4243a();
            f14486m = UmengMessageDeviceConfig.getPackageName(context);
            f14474a = f14486m + ".umeng.message";
            f14475b = Uri.parse("content://" + f14474a + C4242a.f14462a);
            f14476c = Uri.parse("content://" + f14474a + C4242a.f14463b);
            f14477d = Uri.parse("content://" + f14474a + C4242a.f14464c);
            f14478e = Uri.parse("content://" + f14474a + C4242a.f14465d);
            f14479f = Uri.parse("content://" + f14474a + C4242a.f14466e);
            f14480g = Uri.parse("content://" + f14474a + C4242a.f14467f);
            f14481h = Uri.parse("content://" + f14474a + C4242a.f14468g);
            f14482i = Uri.parse("content://" + f14474a + C4242a.f14469h);
            f14483j = Uri.parse("content://" + f14474a + C4242a.f14470i);
        }
        return f14485l;
    }
}
