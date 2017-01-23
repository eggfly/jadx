package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.Data;
import com.umeng.message.common.C4209a;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;

/* renamed from: cn.sharesdk.sina.weibo.e */
public class C1005e {
    private static final Uri f3395a;
    private static C1005e f3396b;
    private static C1004a f3397c;
    private Context f3398d;

    /* renamed from: cn.sharesdk.sina.weibo.e.a */
    public static class C1004a {
        private String f3393a;
        private int f3394b;

        private void m4463a(int i) {
            this.f3394b = i;
        }

        private void m4466a(String str) {
            this.f3393a = str;
        }

        public String m4467a() {
            return this.f3393a;
        }

        public int m4468b() {
            return this.f3394b;
        }

        public String toString() {
            return "WeiboInfo: PackageName = " + this.f3393a + ", supportApi = " + this.f3394b;
        }
    }

    static {
        f3395a = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
        f3397c = null;
    }

    private C1005e(Context context) {
        this.f3398d = context.getApplicationContext();
    }

    public static synchronized C1005e m4469a(Context context) {
        C1005e c1005e;
        synchronized (C1005e.class) {
            if (f3396b == null) {
                f3396b = new C1005e(context);
            }
            c1005e = f3396b;
        }
        return c1005e;
    }

    public static boolean m4470a(Context context, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        try {
            return C1005e.m4471a(context.getPackageManager().getPackageInfo(str, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
        } catch (NameNotFoundException e) {
            return z;
        }
    }

    private static boolean m4471a(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature toByteArray : signatureArr) {
            if (str.equals(Data.MD5(toByteArray.toByteArray()))) {
                C0979d.m4390a().m4375d("check pass", new Object[0]);
                return true;
            }
        }
        return false;
    }

    private C1004a m4472b(Context context) {
        Object obj = 1;
        C1004a c = m4473c(context);
        C1004a d = m4474d(context);
        Object obj2 = c != null ? 1 : null;
        if (d == null) {
            obj = null;
        }
        return (obj2 == null || obj == null) ? obj2 == null ? obj != null ? d : null : c : c.m4468b() >= d.m4468b() ? c : d;
    }

    private C1004a m4473c(Context context) {
        Cursor query;
        Exception e;
        Throwable th;
        try {
            query = context.getContentResolver().query(f3395a, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                int columnIndex = query.getColumnIndex("support_api");
                int columnIndex2 = query.getColumnIndex(C4209a.f14200c);
                if (query.moveToFirst()) {
                    int i = -1;
                    try {
                        columnIndex = Integer.parseInt(query.getString(columnIndex));
                    } catch (Throwable e2) {
                        C0979d.m4390a().m4376d(e2);
                        columnIndex = i;
                    }
                    String string = query.getString(columnIndex2);
                    if (!TextUtils.isEmpty(string) && C1005e.m4470a(context, string)) {
                        C1004a c1004a = new C1004a();
                        c1004a.m4466a(string);
                        c1004a.m4463a(columnIndex);
                        if (query == null) {
                            return c1004a;
                        }
                        query.close();
                        return c1004a;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C0979d.m4390a().m4378e(e.getMessage(), new Object[0]);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e4) {
            e = e4;
            query = null;
            C0979d.m4390a().m4378e(e.getMessage(), new Object[0]);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private C1004a m4474d(Context context) {
        C1004a c1004a = null;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (!(queryIntentServices == null || queryIntentServices.isEmpty())) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                C1004a a;
                if (!(resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName))) {
                    a = m4475a(resolveInfo.serviceInfo.applicationInfo.packageName);
                    if (a != null) {
                        if (c1004a != null) {
                            if (c1004a.m4468b() < a.m4468b()) {
                            }
                        }
                        c1004a = a;
                    }
                }
                a = c1004a;
                c1004a = a;
            }
        }
        return c1004a;
    }

    public C1004a m4475a(String str) {
        InputStream open;
        NameNotFoundException e;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            open = this.f3398d.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int read = open.read(bArr, 0, SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                    if (read == -1) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read));
                }
                if (!TextUtils.isEmpty(stringBuilder.toString()) && C1005e.m4470a(this.f3398d, str)) {
                    int optInt = new JSONObject(stringBuilder.toString()).optInt("support_api", -1);
                    C1004a c1004a = new C1004a();
                    c1004a.m4466a(str);
                    c1004a.m4463a(optInt);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e3) {
                            C0979d.m4390a().m4378e(e3.getMessage(), new Object[0]);
                        }
                    }
                    return c1004a;
                } else if (open == null) {
                    return null;
                } else {
                    try {
                        open.close();
                        return null;
                    } catch (IOException e4) {
                        C0979d.m4390a().m4378e(e4.getMessage(), new Object[0]);
                        return null;
                    }
                }
            } catch (NameNotFoundException e5) {
                e = e5;
                try {
                    C0979d.m4390a().m4378e(e.getMessage(), new Object[0]);
                    if (open != null) {
                        return null;
                    }
                    try {
                        open.close();
                        return null;
                    } catch (IOException e42) {
                        C0979d.m4390a().m4378e(e42.getMessage(), new Object[0]);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e422) {
                            C0979d.m4390a().m4378e(e422.getMessage(), new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e2 = e6;
                C0979d.m4390a().m4378e(e2.getMessage(), new Object[0]);
                if (open != null) {
                    return null;
                }
                try {
                    open.close();
                    return null;
                } catch (IOException e4222) {
                    C0979d.m4390a().m4378e(e4222.getMessage(), new Object[0]);
                    return null;
                }
            }
        } catch (NameNotFoundException e7) {
            e = e7;
            open = null;
            C0979d.m4390a().m4378e(e.getMessage(), new Object[0]);
            if (open != null) {
                return null;
            }
            open.close();
            return null;
        } catch (Exception e8) {
            e2 = e8;
            open = null;
            C0979d.m4390a().m4378e(e2.getMessage(), new Object[0]);
            if (open != null) {
                return null;
            }
            open.close();
            return null;
        } catch (Throwable th3) {
            open = null;
            th = th3;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    public synchronized String m4476a() {
        if (f3397c == null) {
            f3397c = m4472b(this.f3398d);
        }
        return f3397c.m4467a();
    }
}
