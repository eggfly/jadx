package com.antutu.benchmark.p041d;

/* renamed from: com.antutu.benchmark.d.f */
public class C1380f extends C1374b {
    private static C1380f f4692d;

    static {
        f4692d = null;
    }

    private C1380f(String str) {
        this.a = str;
    }

    public static C1380f m5459b() {
        if (f4692d == null) {
            f4692d = new C1380f("news_info");
        }
        return f4692d;
    }

    public String m5460a() {
        return "CREATE TABLE IF NOT EXISTS news_info (t_id integer PRIMARY KEY AUTOINCREMENT,id TEXT,picture TEXT,title TEXT,addtime long,origin TEXT,hits TEXT,url TEXT,summary TEXT,style TEXT,IMG1 TEXT,IMG2 TEXT,IMG3 TEXT,extend_type TEXT,apk_url TEXT,love long,comment long )";
    }
}
