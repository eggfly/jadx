package com.baidu.mobads.openad.p088c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.p080j.C1991m;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.mobads.openad.c.g */
public class C2016g {
    private C2018i f7033a;
    private String f7034b;

    public C2016g(Context context) {
        this.f7033a = new C2018i(context);
        this.f7034b = C1991m.m7449a().m7465n().getCurrentProcessName(context);
    }

    public void m7519a(List<C2017h> list) {
        SQLiteDatabase writableDatabase = this.f7033a.getWritableDatabase();
        for (C2017h c2017h : list) {
            try {
                writableDatabase.execSQL("insert into download_info(thread_id,url,local_file,start_pos,end_pos,compelete_size,process_name) values (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(c2017h.m7529c()), c2017h.m7526b(), c2017h.m7534f(), Integer.valueOf(c2017h.m7531d()), Integer.valueOf(c2017h.m7533e()), Integer.valueOf(c2017h.m7523a()), this.f7034b});
            } catch (Exception e) {
                C1991m.m7449a().m7457f().m7400e("OAdSqlLiteAccessObj", e.getMessage());
            }
        }
    }

    public boolean m7520a(String str, String str2) {
        Cursor rawQuery = this.f7033a.getReadableDatabase().rawQuery("select count(*)  from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.f7034b});
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i > 0;
    }

    public List<C2017h> m7521b(String str, String str2) {
        List<C2017h> arrayList = new ArrayList();
        Cursor rawQuery = this.f7033a.getReadableDatabase().rawQuery("select thread_id, url, local_file, start_pos, end_pos,compelete_size from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.f7034b});
        while (rawQuery.moveToNext()) {
            arrayList.add(new C2017h(rawQuery.getInt(0), rawQuery.getString(1), rawQuery.getString(2), rawQuery.getInt(3), rawQuery.getInt(4), rawQuery.getInt(5)));
        }
        rawQuery.close();
        return arrayList;
    }

    public void m7522b(List<C2017h> list) {
        SQLiteDatabase readableDatabase = this.f7033a.getReadableDatabase();
        for (C2017h c2017h : list) {
            try {
                readableDatabase.execSQL("update download_info set compelete_size=? where thread_id=? and url=? and local_file=? and process_name=?", new Object[]{Integer.valueOf(c2017h.m7523a()), Integer.valueOf(c2017h.m7529c()), c2017h.m7526b(), c2017h.m7534f(), this.f7034b});
            } catch (Exception e) {
                C1991m.m7449a().m7457f().m7400e("OAdSqlLiteAccessObj", e.getMessage());
            }
        }
    }
}
