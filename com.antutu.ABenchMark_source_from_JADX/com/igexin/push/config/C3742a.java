package com.igexin.push.config;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.push.core.p175b.C3741a;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.igexin.push.config.a */
public class C3742a implements C3741a {
    public static final String f12632a;
    private static C3742a f12633b;

    static {
        f12632a = C3742a.class.getName();
    }

    public static C3742a m15382a() {
        if (f12633b == null) {
            f12633b = new C3742a();
        }
        return f12633b;
    }

    private void m15383a(SQLiteDatabase sQLiteDatabase, int i) {
        sQLiteDatabase.delete("config", "id = ?", new String[]{String.valueOf(i)});
    }

    private void m15384a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("value", str);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    private void m15385a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    public void m15389a(SQLiteDatabase sQLiteDatabase) {
    }

    public void m15390a(String str) {
        C3685c.m15060b().m15053a(new C3750i(this, str), true, false);
    }

    public void m15391b() {
        C3685c.m15060b().m15053a(new C3744c(this), false, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15392b(android.database.sqlite.SQLiteDatabase r7) {
        /*
        r6 = this;
        r3 = 0;
        r2 = 0;
        r0 = "select id, value from config order by id";
        r1 = 0;
        r1 = r7.rawQuery(r0, r1);	 Catch:{ Exception -> 0x03b3, all -> 0x03af }
        if (r1 == 0) goto L_0x036b;
    L_0x000b:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 == 0) goto L_0x036b;
    L_0x0011:
        r0 = 0;
        r4 = 1;
        r5 = r1.getInt(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = 20;
        if (r5 == r0) goto L_0x002b;
    L_0x001b:
        r0 = 21;
        if (r5 == r0) goto L_0x002b;
    L_0x001f:
        r0 = 22;
        if (r5 == r0) goto L_0x002b;
    L_0x0023:
        r0 = 24;
        if (r5 == r0) goto L_0x002b;
    L_0x0027:
        r0 = 26;
        if (r5 != r0) goto L_0x00d8;
    L_0x002b:
        r0 = r1.getBlob(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4 = r2;
    L_0x0030:
        switch(r5) {
            case 1: goto L_0x0034;
            case 2: goto L_0x00e0;
            case 3: goto L_0x00fb;
            case 4: goto L_0x010f;
            case 5: goto L_0x0123;
            case 6: goto L_0x0137;
            case 7: goto L_0x014b;
            case 8: goto L_0x015f;
            case 9: goto L_0x0173;
            case 10: goto L_0x0033;
            case 11: goto L_0x0187;
            case 12: goto L_0x019b;
            case 13: goto L_0x01af;
            case 14: goto L_0x01c3;
            case 15: goto L_0x01d7;
            case 16: goto L_0x01eb;
            case 17: goto L_0x01ff;
            case 18: goto L_0x0213;
            case 19: goto L_0x0227;
            case 20: goto L_0x023b;
            case 21: goto L_0x027c;
            case 22: goto L_0x028d;
            case 23: goto L_0x029e;
            case 24: goto L_0x02b2;
            case 25: goto L_0x02c8;
            case 26: goto L_0x02dc;
            case 27: goto L_0x02fa;
            case 28: goto L_0x030e;
            case 29: goto L_0x031a;
            case 30: goto L_0x0033;
            case 31: goto L_0x0033;
            case 32: goto L_0x0033;
            case 33: goto L_0x0033;
            case 34: goto L_0x0033;
            case 35: goto L_0x0033;
            case 36: goto L_0x0033;
            case 37: goto L_0x0033;
            case 38: goto L_0x0033;
            case 39: goto L_0x0033;
            case 40: goto L_0x032e;
            case 41: goto L_0x0342;
            case 42: goto L_0x0357;
            default: goto L_0x0033;
        };	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
    L_0x0033:
        goto L_0x000b;
    L_0x0034:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x003c:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12657a = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0047:
        r0 = move-exception;
        r0 = r1;
    L_0x0049:
        if (r0 == 0) goto L_0x004e;
    L_0x004b:
        r0.close();
    L_0x004e:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = f12632a;
        r0 = r0.append(r1);
        r1 = "|current ver = ";
        r0 = r0.append(r1);
        r1 = "2.9.3.0";
        r0 = r0.append(r1);
        r1 = ", last ver = ";
        r0 = r0.append(r1);
        r1 = com.igexin.push.core.C3855g.f12950N;
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);
        r0 = "2.9.3.0";
        r1 = com.igexin.push.core.C3855g.f12950N;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0389;
    L_0x0082:
        r0 = com.igexin.push.config.C3754m.f12675s;
        if (r0 == 0) goto L_0x038a;
    L_0x0086:
        r0 = com.igexin.push.config.C3754m.f12675s;
        r0 = r0.m15734b();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0372;
    L_0x0092:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = f12632a;
        r0 = r0.append(r1);
        r1 = "|extMap is empty  = false";
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);
        r0 = com.igexin.push.config.C3754m.f12675s;
        r0 = r0.m15734b();
        r0 = r0.keySet();
        r1 = r0.iterator();
    L_0x00b8:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0372;
    L_0x00be:
        r0 = com.igexin.push.config.C3754m.f12675s;
        r0 = r0.m15734b();
        r3 = r1.next();
        r0 = r0.get(r3);
        r0 = (com.igexin.push.core.bean.C3826f) r0;
        if (r0 == 0) goto L_0x00b8;
    L_0x00d0:
        r0 = r0.m15719c();
        com.igexin.push.util.C3926e.m16166b(r0);
        goto L_0x00b8;
    L_0x00d8:
        r0 = r1.getString(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4 = r0;
        r0 = r2;
        goto L_0x0030;
    L_0x00e0:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x00e8:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12658b = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x00f4:
        r0 = move-exception;
    L_0x00f5:
        if (r1 == 0) goto L_0x00fa;
    L_0x00f7:
        r1.close();
    L_0x00fa:
        throw r0;
    L_0x00fb:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0103:
        r0 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4 = r0.longValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12659c = r4;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x010f:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0117:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12662f = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0123:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x012b:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12663g = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0137:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x013f:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12664h = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x014b:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0153:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12665i = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x015f:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0167:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12666j = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0173:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x017b:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12667k = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0187:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x018f:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12670n = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x019b:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x01a3:
        r0 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4 = r0.longValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12671o = r4;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x01af:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x01b7:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12668l = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x01c3:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x01cb:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12669m = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x01d7:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x01df:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12660d = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x01eb:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x01f3:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12661e = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x01ff:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0207:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12672p = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0213:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x021b:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12673q = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0227:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x022f:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12674r = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x023b:
        if (r0 == 0) goto L_0x000b;
    L_0x023d:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        r5 = com.igexin.push.core.C3855g.f12939C;	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        r0 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r0, r5);	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        r0 = com.igexin.push.core.p176a.C3777e.m15491a();	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        r0 = r0.m15508a(r5);	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12675s = r0;	 Catch:{ Exception -> 0x0259, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0259:
        r0 = move-exception;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4.<init>();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r5 = f12632a;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r5 = "|";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x027c:
        if (r0 == 0) goto L_0x000b;
    L_0x027e:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r5 = com.igexin.push.core.C3855g.f12939C;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r0, r5);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12676t = r4;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x028d:
        if (r0 == 0) goto L_0x000b;
    L_0x028f:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r5 = com.igexin.push.core.C3855g.f12939C;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r0, r5);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12677u = r4;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x029e:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x02a6:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12678v = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x02b2:
        if (r0 == 0) goto L_0x000b;
    L_0x02b4:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x02c5, all -> 0x00f4 }
        r5 = com.igexin.push.core.C3855g.f12939C;	 Catch:{ Exception -> 0x02c5, all -> 0x00f4 }
        r0 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r0, r5);	 Catch:{ Exception -> 0x02c5, all -> 0x00f4 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x02c5, all -> 0x00f4 }
        r0 = 0;
        com.igexin.push.config.C3756o.m15416a(r4, r0);	 Catch:{ Exception -> 0x02c5, all -> 0x00f4 }
        goto L_0x000b;
    L_0x02c5:
        r0 = move-exception;
        goto L_0x000b;
    L_0x02c8:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x02d0:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12680x = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x02dc:
        if (r0 == 0) goto L_0x000b;
    L_0x02de:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        r5 = com.igexin.push.core.C3855g.f12939C;	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        r0 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r0, r5);	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        r0 = new org.json.JSONArray;	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        r0 = com.igexin.push.core.p176a.C3789q.m15599a(r0);	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        com.igexin.push.config.SDKUrlConfig.setIdcConfigUrl(r0);	 Catch:{ Exception -> 0x02f7, all -> 0x00f4 }
        goto L_0x000b;
    L_0x02f7:
        r0 = move-exception;
        goto L_0x000b;
    L_0x02fa:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0302:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12651E = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x030e:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0316:
        com.igexin.push.config.C3754m.f12652F = r4;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x031a:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0322:
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12653G = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x032e:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x0336:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12654H = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0342:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x034a:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r4 = (long) r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12655I = r4;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x0357:
        r0 = "null";
        r0 = r4.equals(r0);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        if (r0 != 0) goto L_0x000b;
    L_0x035f:
        r0 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        com.igexin.push.config.C3754m.f12656J = r0;	 Catch:{ Exception -> 0x0047, all -> 0x00f4 }
        goto L_0x000b;
    L_0x036b:
        if (r1 == 0) goto L_0x004e;
    L_0x036d:
        r1.close();
        goto L_0x004e;
    L_0x0372:
        com.igexin.push.config.C3754m.f12675s = r2;
        r6.m15400h();
    L_0x0377:
        r0 = com.igexin.push.core.p175b.C3799f.m15623a();
        r1 = "2.9.3.0";
        r0.m15657c(r1);
        r0 = com.igexin.push.core.p175b.C3799f.m15623a();
        r2 = 0;
        r0.m15660d(r2);
    L_0x0389:
        return;
    L_0x038a:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x03ad }
        r1 = com.igexin.push.core.C3855g.ac;	 Catch:{ Exception -> 0x03ad }
        r0.<init>(r1);	 Catch:{ Exception -> 0x03ad }
        r1 = r0.listFiles();	 Catch:{ Exception -> 0x03ad }
        r2 = r1.length;	 Catch:{ Exception -> 0x03ad }
        r0 = r3;
    L_0x0397:
        if (r0 >= r2) goto L_0x0377;
    L_0x0399:
        r3 = r1[r0];	 Catch:{ Exception -> 0x03ad }
        r4 = r3.getName();	 Catch:{ Exception -> 0x03ad }
        r5 = "tdata_";
        r4 = r4.startsWith(r5);	 Catch:{ Exception -> 0x03ad }
        if (r4 == 0) goto L_0x03aa;
    L_0x03a7:
        r3.delete();	 Catch:{ Exception -> 0x03ad }
    L_0x03aa:
        r0 = r0 + 1;
        goto L_0x0397;
    L_0x03ad:
        r0 = move-exception;
        goto L_0x0377;
    L_0x03af:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00f5;
    L_0x03b3:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.a.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public void m15393b(String str) {
        C3685c.m15060b().m15053a(new C3751j(this, str), true, false);
    }

    public void m15394c() {
        C3685c.m15060b().m15053a(new C3745d(this), false, true);
    }

    public void m15395c(SQLiteDatabase sQLiteDatabase) {
        m15384a(sQLiteDatabase, 1, String.valueOf(C3754m.f12657a));
        m15384a(sQLiteDatabase, 2, String.valueOf(C3754m.f12658b));
        m15384a(sQLiteDatabase, 3, String.valueOf(C3754m.f12659c));
        m15384a(sQLiteDatabase, 4, String.valueOf(C3754m.f12662f));
        m15384a(sQLiteDatabase, 5, String.valueOf(C3754m.f12663g));
        m15384a(sQLiteDatabase, 6, String.valueOf(C3754m.f12664h));
        m15384a(sQLiteDatabase, 7, String.valueOf(C3754m.f12665i));
        m15384a(sQLiteDatabase, 8, String.valueOf(C3754m.f12666j));
        m15384a(sQLiteDatabase, 9, String.valueOf(C3754m.f12667k));
        m15384a(sQLiteDatabase, 11, String.valueOf(C3754m.f12670n));
        m15384a(sQLiteDatabase, 12, String.valueOf(C3754m.f12671o));
        m15384a(sQLiteDatabase, 13, String.valueOf(C3754m.f12668l));
        m15384a(sQLiteDatabase, 14, String.valueOf(C3754m.f12669m));
        m15384a(sQLiteDatabase, 15, String.valueOf(C3754m.f12660d));
        m15384a(sQLiteDatabase, 3, String.valueOf(C3754m.f12659c));
        m15384a(sQLiteDatabase, 17, String.valueOf(C3754m.f12672p));
        m15384a(sQLiteDatabase, 18, String.valueOf(C3754m.f12673q));
        m15384a(sQLiteDatabase, 19, String.valueOf(C3754m.f12674r));
        m15384a(sQLiteDatabase, 25, String.valueOf(C3754m.f12680x));
    }

    public void m15396d() {
        C3685c.m15060b().m15053a(new C3746e(this), false, true);
    }

    public void m15397e() {
        C3685c.m15060b().m15053a(new C3747f(this), false, true);
    }

    public void m15398f() {
        C3685c.m15060b().m15053a(new C3748g(this), false, true);
    }

    public void m15399g() {
        C3685c.m15060b().m15053a(new C3749h(this), true, false);
    }

    public void m15400h() {
        C3685c.m15060b().m15053a(new C3743b(this), true, false);
    }
}
