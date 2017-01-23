package com.antutu.benchmark.platform.p053d;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.platform.d.a */
public class C1575a {
    double f5474a;
    double f5475b;
    double f5476c;
    double f5477d;
    String f5478e;

    public C1575a(String str) {
        this.f5474a = 0.0d;
        this.f5475b = 0.0d;
        this.f5476c = 0.0d;
        this.f5477d = 0.0d;
        this.f5478e = str;
    }

    private void m6237b(Context context) {
        int i;
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(context.getFilesDir().getAbsolutePath() + "/" + this.f5478e, null);
        openOrCreateDatabase.execSQL("DROP TABLE IF EXISTS TestIndex");
        openOrCreateDatabase.execSQL("create table TestIndex (i integer(8), s text)");
        openOrCreateDatabase.execSQL("create index StrIndex on TestIndex (s)");
        openOrCreateDatabase.execSQL("create index IntIndex on TestIndex (i)");
        openOrCreateDatabase.execSQL("BEGIN TRANSACTION");
        SQLiteStatement compileStatement = openOrCreateDatabase.compileStatement("insert into TestIndex (i,s) values (?,?)");
        double nanoTime = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
        long j = 1999;
        for (i = 0; i < 10000; i++) {
            j = ((j * 3141592621L) + 2718281829L) % 1000000007;
            compileStatement.bindLong(1, j);
            compileStatement.bindString(2, Long.toString(j));
            compileStatement.execute();
        }
        compileStatement.close();
        openOrCreateDatabase.execSQL("END TRANSACTION");
        this.f5474a = 10000.0d / (((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime);
        double nanoTime2 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
        j = 1999;
        int i2 = 0;
        while (i2 < 10000) {
            long j2 = ((j * 3141592621L) + 2718281829L) % 1000000007;
            String l = Long.toString(j2);
            Cursor query = openOrCreateDatabase.query("TestIndex", new String[]{"i", "s"}, "i=?", new String[]{l}, null, null, null);
            Cursor query2 = openOrCreateDatabase.query("TestIndex", new String[]{"i", "s"}, "s=?", new String[]{l}, null, null, null);
            query.moveToFirst();
            query.close();
            query2.moveToFirst();
            query2.close();
            i2++;
            j = j2;
        }
        this.f5475b = 20000.0d / (((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime2);
        double nanoTime3 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
        Cursor query3 = openOrCreateDatabase.query("TestIndex", new String[]{"i", "s"}, null, null, null, null, "i");
        i = 0;
        while (query3.moveToNext()) {
            query3.getLong(1);
            i++;
        }
        query3.close();
        String str = BuildConfig.FLAVOR;
        query3 = openOrCreateDatabase.query("TestIndex", new String[]{"i", "s"}, null, null, null, null, "s");
        i = 0;
        while (query3.moveToNext()) {
            query3.getString(1);
            i++;
        }
        this.f5476c = 20000.0d / (((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime3);
        double nanoTime4 = (((double) System.nanoTime()) / 1000.0d) / 1000.0d;
        j = 1999;
        openOrCreateDatabase.execSQL("BEGIN TRANSACTION");
        SQLiteStatement compileStatement2 = openOrCreateDatabase.compileStatement("delete from TestIndex where i=?");
        for (i = 0; i < 10000; i++) {
            j = ((j * 3141592621L) + 2718281829L) % 1000000007;
            compileStatement2.bindLong(1, j);
            compileStatement2.execute();
        }
        compileStatement2.close();
        openOrCreateDatabase.execSQL("END TRANSACTION");
        this.f5477d = 10000.0d / (((((double) System.nanoTime()) / 1000.0d) / 1000.0d) - nanoTime4);
        openOrCreateDatabase.close();
    }

    public double m6238a(Context context) {
        m6237b(context);
        return Math.pow(((this.f5474a * this.f5475b) * this.f5476c) * this.f5477d, 0.25d) * 0.8d;
    }
}
