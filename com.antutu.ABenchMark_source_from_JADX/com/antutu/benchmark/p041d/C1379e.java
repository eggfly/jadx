package com.antutu.benchmark.p041d;

import com.igexin.download.Downloads;
import com.umeng.message.proguard.C4233j;

/* renamed from: com.antutu.benchmark.d.e */
public class C1379e extends C1374b {
    private static C1379e f4691d;

    static {
        f4691d = null;
    }

    private C1379e(String str) {
        this.a = str;
    }

    public static C1379e m5457b() {
        if (f4691d == null) {
            f4691d = new C1379e(C4233j.f14376C);
        }
        return f4691d;
    }

    public String m5458a() {
        return C4233j.f14392o + this.a + " (" + C4233j.f14384g + " INTEGER PRIMARY KEY," + "message_id" + " TEXT UNIQUE ON CONFLICT REPLACE," + Downloads.COLUMN_TITLE + " TEXT," + "summary" + " TEXT," + "content" + " TEXT," + "url" + " TEXT," + "is_html" + " INTEGER," + C4233j.f14377D + " INTEGER," + "is_read" + " INTEGER);";
    }
}
