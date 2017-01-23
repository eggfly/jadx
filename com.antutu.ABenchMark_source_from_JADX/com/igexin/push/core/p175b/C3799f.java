package com.igexin.push.core.p175b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.handmark.pulltorefresh.library.C3628R;
import com.igexin.p158b.p159a.p160a.C3658a;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.p158b.p168b.C3700a;
import com.igexin.push.core.C3855g;
import com.igexin.push.p182d.C3875b;
import com.igexin.push.util.C3926e;
import com.igexin.push.util.EncryptUtils;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.core.b.f */
public class C3799f implements C3741a {
    private static final String f12747a;
    private static C3799f f12748b;
    private Map f12749c;
    private boolean f12750d;

    static {
        f12747a = C3799f.class.getName();
    }

    private C3799f() {
        this.f12749c = new TreeMap();
    }

    public static C3799f m15623a() {
        if (f12748b == null) {
            f12748b = new C3799f();
        }
        return f12748b;
    }

    private void m15624a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("value", str);
        sQLiteDatabase.replace("runtime", null, contentValues);
    }

    private void m15625a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("runtime", null, contentValues);
    }

    private byte[] m15629a(SQLiteDatabase sQLiteDatabase, int i) {
        Cursor rawQuery;
        Throwable th;
        byte[] bArr = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("select value from runtime where id=" + i, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        bArr = C3658a.m14937c(rawQuery.getBlob(rawQuery.getColumnIndex("value")), C3855g.f12939C);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return bArr;
                    }
                } catch (Exception e) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            rawQuery = null;
            th = th4;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return bArr;
    }

    private String m15631b(SQLiteDatabase sQLiteDatabase, int i) {
        Cursor rawQuery;
        Throwable th;
        String str = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("select value from runtime where id=" + i, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        str = rawQuery.getString(rawQuery.getColumnIndex("value"));
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return str;
                    }
                } catch (Exception e) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            rawQuery = null;
            th = th4;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15632e(android.database.sqlite.SQLiteDatabase r6) {
        /*
        r5 = this;
        r0 = 0;
        r1 = "select value from runtime where id=25";
        r2 = 0;
        r0 = r6.rawQuery(r1, r2);	 Catch:{ Exception -> 0x0045, all -> 0x004c }
        if (r0 == 0) goto L_0x002f;
    L_0x000a:
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        if (r1 == 0) goto L_0x002f;
    L_0x0010:
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        r2 = "value";
        r2 = r0.getColumnIndex(r2);	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        r2 = r0.getBlob(r2);	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        r3 = com.igexin.push.core.C3855g.f12969g;	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        r3 = com.igexin.p158b.p168b.C3700a.m15132a(r3);	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        r2 = com.igexin.p158b.p159a.p160a.C3658a.m14937c(r2, r3);	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
        com.igexin.push.core.C3855g.f12939C = r1;	 Catch:{ Exception -> 0x0045, all -> 0x0059 }
    L_0x002f:
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r0.close();
    L_0x0034:
        r0 = com.igexin.push.core.C3855g.f12939C;
        if (r0 != 0) goto L_0x0044;
    L_0x0038:
        r0 = com.igexin.push.core.C3855g.f12984v;
        if (r0 != 0) goto L_0x0056;
    L_0x003c:
        r0 = "cantgetimei";
    L_0x003e:
        r0 = com.igexin.p158b.p168b.C3700a.m15132a(r0);
        com.igexin.push.core.C3855g.f12939C = r0;
    L_0x0044:
        return;
    L_0x0045:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0034;
    L_0x0048:
        r0.close();
        goto L_0x0034;
    L_0x004c:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0050:
        if (r1 == 0) goto L_0x0055;
    L_0x0052:
        r1.close();
    L_0x0055:
        throw r0;
    L_0x0056:
        r0 = com.igexin.push.core.C3855g.f12984v;
        goto L_0x003e;
    L_0x0059:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.f.e(android.database.sqlite.SQLiteDatabase):void");
    }

    private boolean m15633e() {
        return C3685c.m15060b().m15053a(new C3811r(this), false, true);
    }

    private byte[] m15634e(String str) {
        return EncryptUtils.getBytesEncrypted(str.getBytes());
    }

    private void m15635f() {
        C3926e.m16156a();
        String c = C3926e.m16167c();
        if (c == null || c.length() <= 5) {
            C3926e.m16170e();
        }
    }

    private void m15636f(SQLiteDatabase sQLiteDatabase) {
        String b = m15631b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            C3855g.f12937A = b;
        }
    }

    private String m15637g() {
        String str = BuildConfig.FLAVOR;
        Random random = new Random(Math.abs(new Random().nextLong()));
        for (int i = 0; i < 15; i++) {
            str = str + random.nextInt(10);
        }
        return str;
    }

    private void m15638g(SQLiteDatabase sQLiteDatabase) {
        String b = m15631b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            C3855g.f12938B = b;
        }
    }

    private void m15639h(SQLiteDatabase sQLiteDatabase) {
        byte[] a = m15629a(sQLiteDatabase, 1);
        if (a != null) {
            try {
                String str = new String(a);
                C3855g.f12981s = str.equals("null") ? 0 : Long.parseLong(str);
            } catch (Exception e) {
            }
            C3688a.m15097b(f12747a + "|db version changed, save session = " + C3855g.f12981s);
        }
    }

    private void m15640i(SQLiteDatabase sQLiteDatabase) {
        byte[] a = m15629a(sQLiteDatabase, 20);
        if (a != null) {
            String str = new String(a);
            if (str.equals("null")) {
                str = null;
            }
            C3855g.f12983u = str;
            C3855g.f12982t = str;
            C3688a.m15097b(f12747a + "|db version changed, save cid = " + str);
        }
    }

    public void m15641a(SQLiteDatabase sQLiteDatabase) {
    }

    public boolean m15642a(int i) {
        C3855g.f12956T = i;
        C3685c.m15060b().m15053a(new C3804k(this), false, true);
        return true;
    }

    public boolean m15643a(long j) {
        C3855g.m15889a(j);
        C3685c.m15060b().m15053a(new C3813t(this), false, true);
        return true;
    }

    public boolean m15644a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C3855g.f12987y = str;
        return C3685c.m15060b().m15053a(new C3812s(this), false, true);
    }

    public boolean m15645a(String str, String str2, long j) {
        C3855g.f12981s = j;
        if (TextUtils.isEmpty(C3855g.f12937A)) {
            C3855g.f12937A = str2;
        }
        C3855g.f12982t = str;
        return m15633e();
    }

    public boolean m15646a(String str, boolean z) {
        String str2 = null;
        if (str == null) {
            return false;
        }
        if (z) {
            if (!str.equals(C3855g.ay)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                C3855g.ay = str2;
                C3685c.m15060b().m15053a(new C3805l(this, str), false, true);
                return true;
            }
        } else if (!str.equals(C3855g.az)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            C3855g.az = str2;
            C3685c.m15060b().m15053a(new C3806m(this, str), false, true);
            return true;
        }
        return false;
    }

    public boolean m15647a(boolean z) {
        if (C3855g.f12951O == z) {
            return false;
        }
        C3855g.f12951O = z;
        C3685c.m15060b().m15053a(new C3801h(this), false, true);
        return true;
    }

    public void m15648b() {
        C3685c.m15060b().m15053a(new C3800g(this), false, true);
    }

    public void m15649b(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        long d;
        String b;
        Cursor cursor = null;
        m15632e(sQLiteDatabase);
        Cursor rawQuery;
        try {
            rawQuery = sQLiteDatabase.rawQuery("select id, value from runtime order by id", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    byte[] blob;
                    String str;
                    int i = rawQuery.getInt(0);
                    if (i == 1 || i == 14 || i == 19 || i == 20 || i == 23 || i == 25 || i == 22 || i == 31 || i == 30) {
                        blob = rawQuery.getBlob(1);
                        str = null;
                    } else {
                        str = rawQuery.getString(1);
                        blob = null;
                    }
                    if (blob != null || str != null) {
                        switch (i) {
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                str = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                try {
                                    C3855g.f12981s = str.equals("null") ? 0 : Long.parseLong(str);
                                    break;
                                } catch (Exception e) {
                                    C3855g.f12981s = 0;
                                    break;
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    cursor = rawQuery;
                                    th = th3;
                                    break;
                                }
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.f12937A = str;
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.f12938B = str;
                                break;
                            case SpdyProtocol.QUIC /*4*/:
                                try {
                                    boolean z = str.equals("null") || Boolean.parseBoolean(str);
                                    C3855g.f12974l = z;
                                    break;
                                } catch (Exception e2) {
                                    break;
                                } catch (Throwable th22) {
                                    Throwable th32 = th22;
                                    cursor = rawQuery;
                                    th = th32;
                                    break;
                                }
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                                C3855g.f12943G = str.equals("null") ? 0 : Long.parseLong(str);
                                break;
                            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                                C3855g.f12944H = str.equals("null") ? 0 : Long.parseLong(str);
                                break;
                            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                                C3855g.f12947K = str.equals("null") ? 0 : Long.parseLong(str);
                                break;
                            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                                C3855g.f12948L = str.equals("null") ? 0 : Long.parseLong(str);
                                break;
                            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.f12950N = str;
                                break;
                            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                                C3855g.at = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                break;
                            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                                if (!str.equals("null")) {
                                    C3855g.f12951O = Boolean.parseBoolean(str);
                                    break;
                                }
                                break;
                            case SpdyProtocol.CUSTOM /*16*/:
                                C3855g.f12952P = str.equals("null") ? 0 : Long.parseLong(str);
                                break;
                            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.f12954R = str;
                                break;
                            case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                                C3855g.f12956T = str.equals("null") ? 0 : Integer.parseInt(str);
                                break;
                            case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                                str = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.f12987y = str;
                                break;
                            case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                                str = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.f12983u = str;
                                C3855g.f12982t = str;
                                break;
                            case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                                C3855g.av = str.equals("null") ? 0 : Long.parseLong(str);
                                break;
                            case C4209a.f14215r /*22*/:
                                str = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.ax = str;
                                C3688a.m15097b(f12747a + "|read last detectWifiLastResult = " + C3855g.ax);
                                break;
                            case C2279R.styleable.Toolbar_titleTextColor /*23*/:
                                str = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.aw = str;
                                C3688a.m15097b(f12747a + "|read last detectMobileLastResult = " + C3855g.aw);
                                break;
                            case jni.SID_RAM /*30*/:
                                str = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.az = str;
                                C3688a.m15097b(f12747a + "|read last domainWifiStatus = " + C3855g.az);
                                break;
                            case jni.SID_CPU_MATH /*31*/:
                                str = new String(C3658a.m14937c(blob, C3855g.f12939C));
                                if (str.equals("null")) {
                                    str = null;
                                }
                                C3855g.ay = str;
                                C3688a.m15097b(f12747a + "|read last domainMobileStatus = " + C3855g.ay);
                                break;
                            case C4574a.ORDERED /*32*/:
                                C3855g.f12949M = str.equals("null") ? 0 : Long.parseLong(str);
                                break;
                            case com.nostra13.universalimageloader.BuildConfig.VERSION_CODE /*40*/:
                                C3875b.m15932a().m15937a(str.equals("null") ? false : Boolean.parseBoolean(str));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (C3855g.f12981s == 0) {
                d = C3926e.m16169d();
                if (d != 0) {
                    C3855g.f12981s = d;
                    m15625a(sQLiteDatabase, 1, EncryptUtils.getBytesEncrypted(String.valueOf(d).getBytes()));
                }
            }
            if (C3855g.f12982t == null) {
                b = C3926e.m16163b();
                if (b != null) {
                    C3855g.f12983u = b;
                    C3855g.f12982t = b;
                    m15625a(sQLiteDatabase, 20, EncryptUtils.getBytesEncrypted(C3855g.f12982t.getBytes()));
                }
            }
            C3855g.f12983u = C3700a.m15132a(String.valueOf(C3855g.f12981s));
            C3855g.m15889a(C3855g.f12981s);
            m15625a(sQLiteDatabase, 20, EncryptUtils.getBytesEncrypted(C3855g.f12982t.getBytes()));
            if (C3855g.f12981s == 0) {
                C3855g.f12983u = null;
                C3855g.f12982t = null;
                C3855g.f12981s = 0;
            } else {
                C3799f.m15623a().m15643a(C3855g.f12981s);
                C3855g.f12983u = C3855g.f12982t;
                C3926e.m16171f();
            }
            C3855g.at = C3700a.m15130a(32);
            m15625a(sQLiteDatabase, 14, EncryptUtils.getBytesEncrypted(C3855g.at.getBytes()));
            b = C3926e.m16167c();
            C3855g.f12937A = b;
            m15624a(sQLiteDatabase, 2, C3855g.f12937A);
            if (C3855g.f12938B == null) {
                b = C3855g.f12984v;
                if (b == null) {
                    b = "V" + m15637g();
                }
                C3855g.f12938B = "A-" + b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + System.currentTimeMillis();
                m15624a(sQLiteDatabase, 3, C3855g.f12938B);
            }
            if (this.f12750d) {
                this.f12750d = false;
                if (!TextUtils.isEmpty(C3855g.f12939C)) {
                    m15625a(sQLiteDatabase, 25, C3658a.m14938d(C3855g.f12939C.getBytes(), C3700a.m15132a(C3855g.f12969g.getPackageName())));
                }
                if (C3855g.f12981s != 0) {
                    m15625a(sQLiteDatabase, 1, EncryptUtils.getBytesEncrypted(String.valueOf(C3855g.f12981s).getBytes()));
                }
                if (!TextUtils.isEmpty(C3855g.f12982t)) {
                    m15625a(sQLiteDatabase, 20, EncryptUtils.getBytesEncrypted(C3855g.f12982t.getBytes()));
                }
                m15624a(sQLiteDatabase, 2, C3855g.f12937A);
                if (!TextUtils.isEmpty(C3855g.f12938B)) {
                    m15624a(sQLiteDatabase, 3, C3855g.f12938B);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (C3855g.f12981s == 0) {
            d = C3926e.m16169d();
            if (d != 0) {
                C3855g.f12981s = d;
                m15625a(sQLiteDatabase, 1, EncryptUtils.getBytesEncrypted(String.valueOf(d).getBytes()));
            }
        }
        if (C3855g.f12982t == null) {
            b = C3926e.m16163b();
            if (b != null) {
                C3855g.f12983u = b;
                C3855g.f12982t = b;
                m15625a(sQLiteDatabase, 20, EncryptUtils.getBytesEncrypted(C3855g.f12982t.getBytes()));
            }
        }
        if (C3855g.f12982t == null && C3855g.f12981s != 0) {
            C3855g.f12983u = C3700a.m15132a(String.valueOf(C3855g.f12981s));
            C3855g.m15889a(C3855g.f12981s);
            m15625a(sQLiteDatabase, 20, EncryptUtils.getBytesEncrypted(C3855g.f12982t.getBytes()));
        }
        if ("cfcd208495d565ef66e7dff9f98764da".equals(C3855g.f12982t) || !(C3855g.f12982t == null || C3855g.f12982t.matches("([a-f]|[0-9]){32}"))) {
            if (C3855g.f12981s == 0) {
                C3799f.m15623a().m15643a(C3855g.f12981s);
                C3855g.f12983u = C3855g.f12982t;
                C3926e.m16171f();
            } else {
                C3855g.f12983u = null;
                C3855g.f12982t = null;
                C3855g.f12981s = 0;
            }
        }
        if (TextUtils.isEmpty(C3855g.at) || "null".equals(C3855g.at)) {
            C3855g.at = C3700a.m15130a(32);
            m15625a(sQLiteDatabase, 14, EncryptUtils.getBytesEncrypted(C3855g.at.getBytes()));
        }
        b = C3926e.m16167c();
        if (C3855g.f12937A == null && b != null && b.length() > 5) {
            C3855g.f12937A = b;
            m15624a(sQLiteDatabase, 2, C3855g.f12937A);
        }
        if (C3855g.f12938B == null) {
            b = C3855g.f12984v;
            if (b == null) {
                b = "V" + m15637g();
            }
            C3855g.f12938B = "A-" + b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + System.currentTimeMillis();
            m15624a(sQLiteDatabase, 3, C3855g.f12938B);
        }
        if (this.f12750d) {
            this.f12750d = false;
            if (TextUtils.isEmpty(C3855g.f12939C)) {
                m15625a(sQLiteDatabase, 25, C3658a.m14938d(C3855g.f12939C.getBytes(), C3700a.m15132a(C3855g.f12969g.getPackageName())));
            }
            if (C3855g.f12981s != 0) {
                m15625a(sQLiteDatabase, 1, EncryptUtils.getBytesEncrypted(String.valueOf(C3855g.f12981s).getBytes()));
            }
            if (TextUtils.isEmpty(C3855g.f12982t)) {
                m15625a(sQLiteDatabase, 20, EncryptUtils.getBytesEncrypted(C3855g.f12982t.getBytes()));
            }
            if (!TextUtils.isEmpty(C3855g.f12937A) && C3855g.f12937A.length() > 5) {
                m15624a(sQLiteDatabase, 2, C3855g.f12937A);
            }
            if (!TextUtils.isEmpty(C3855g.f12938B)) {
                m15624a(sQLiteDatabase, 3, C3855g.f12938B);
            }
        }
    }

    public boolean m15650b(long j) {
        if (C3855g.f12948L == j) {
            return false;
        }
        C3855g.f12948L = j;
        C3685c.m15060b().m15053a(new C3815v(this), false, true);
        return true;
    }

    public boolean m15651b(String str) {
        C3855g.f12937A = str;
        C3685c.m15060b().m15053a(new C3814u(this), false, true);
        return true;
    }

    public boolean m15652b(String str, boolean z) {
        String str2 = null;
        if (str == null) {
            return false;
        }
        if (z) {
            if (!str.equals(C3855g.aw)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                C3855g.aw = str2;
                C3685c.m15060b().m15053a(new C3807n(this, str), false, true);
                return true;
            }
        } else if (!str.equals(C3855g.ax)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            C3855g.ax = str2;
            C3685c.m15060b().m15053a(new C3808o(this, str), false, true);
            return true;
        }
        return false;
    }

    public boolean m15653b(boolean z) {
        C3685c.m15060b().m15053a(new C3810q(this, z), false, true);
        return true;
    }

    public void m15654c(SQLiteDatabase sQLiteDatabase) {
        m15625a(sQLiteDatabase, 1, C3658a.m14938d(String.valueOf(C3855g.f12981s).getBytes(), C3855g.f12939C));
        m15624a(sQLiteDatabase, 4, String.valueOf(C3855g.f12974l));
        m15624a(sQLiteDatabase, 8, String.valueOf(C3855g.f12944H));
        m15624a(sQLiteDatabase, 6, String.valueOf(C3855g.f12943G));
        m15624a(sQLiteDatabase, 32, String.valueOf(C3855g.f12949M));
        m15624a(sQLiteDatabase, 3, C3855g.f12938B);
        m15624a(sQLiteDatabase, 11, String.valueOf(C3855g.f12947K));
        m15624a(sQLiteDatabase, 12, String.valueOf(C3855g.f12948L));
        m15625a(sQLiteDatabase, 20, C3658a.m14938d(C3855g.f12982t.getBytes(), C3855g.f12939C));
        m15624a(sQLiteDatabase, 2, C3855g.f12937A);
        m15625a(sQLiteDatabase, 25, C3658a.m14938d(C3855g.f12939C.getBytes(), C3700a.m15132a(C3855g.f12969g.getPackageName())));
    }

    public boolean m15655c() {
        C3855g.f12981s = 0;
        C3855g.f12982t = null;
        return m15633e();
    }

    public boolean m15656c(long j) {
        C3855g.av = j;
        C3688a.m15097b(f12747a + "|save idc config failed time : " + j);
        C3685c.m15060b().m15053a(new C3816w(this, j), false, true);
        return true;
    }

    public boolean m15657c(String str) {
        if (str == null || str.equals(C3855g.f12950N)) {
            return false;
        }
        C3855g.f12950N = str;
        C3685c.m15060b().m15053a(new C3818y(this), false, true);
        return true;
    }

    public Map m15658d() {
        return this.f12749c;
    }

    public void m15659d(SQLiteDatabase sQLiteDatabase) {
        this.f12750d = true;
        m15632e(sQLiteDatabase);
        m15639h(sQLiteDatabase);
        m15640i(sQLiteDatabase);
        m15638g(sQLiteDatabase);
        m15636f(sQLiteDatabase);
    }

    public boolean m15660d(long j) {
        if (C3855g.f12947K == j) {
            return false;
        }
        C3855g.f12947K = j;
        C3685c.m15060b().m15053a(new C3817x(this), false, true);
        return true;
    }

    public boolean m15661d(String str) {
        if (str.equals(C3855g.f12954R)) {
            return false;
        }
        C3855g.f12954R = str;
        C3685c.m15060b().m15053a(new C3803j(this), false, true);
        return true;
    }

    public boolean m15662e(long j) {
        if (C3855g.f12952P == j) {
            return false;
        }
        C3855g.f12952P = j;
        C3685c.m15060b().m15053a(new C3802i(this), false, true);
        return true;
    }

    public boolean m15663f(long j) {
        if (C3855g.f12949M == j) {
            return false;
        }
        C3855g.f12949M = j;
        C3685c.m15060b().m15053a(new C3809p(this), false, true);
        return true;
    }
}
