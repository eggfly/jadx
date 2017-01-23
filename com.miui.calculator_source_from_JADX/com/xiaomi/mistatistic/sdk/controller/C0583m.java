package com.xiaomi.mistatistic.sdk.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.data.AbstractEvent;
import com.xiaomi.mistatistic.sdk.data.C0607h;
import com.xiaomi.mistatistic.sdk.data.C0608i;
import com.xiaomi.mistatistic.sdk.data.C0609j;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.m */
public class C0583m {
    private static C0583m f4775a;
    private static long f4776c;
    private static final List<C0607h> f4777d;
    private Handler f4778b;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.m.1 */
    class C05801 extends Handler {
        final /* synthetic */ C0583m f4767a;

        C05801(C0583m c0583m, Looper looper) {
            this.f4767a = c0583m;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 31415927:
                    long a = C0573k.m6444a(C0551c.m6352a(), "session_begin", 0);
                    long a2 = C0573k.m6444a(C0551c.m6352a(), "last_deactivate", 0);
                    String a3 = C0573k.m6446a(C0551c.m6352a(), "pv_path", "");
                    if (a > 0 && a2 > a) {
                        this.f4767a.m6476a(C0551c.m6352a(), a, a2);
                    }
                    if (!TextUtils.isEmpty(a3)) {
                        this.f4767a.m6482b(C0551c.m6352a(), a3);
                    }
                default:
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.m.2 */
    class C05812 implements C0523a {
        final /* synthetic */ Context f4768a;
        final /* synthetic */ String f4769b;
        final /* synthetic */ String f4770c;
        final /* synthetic */ C0583m f4771d;

        C05812(C0583m c0583m, Context context, String str, String str2) {
            this.f4771d = c0583m;
            this.f4768a = context;
            this.f4769b = str;
            this.f4770c = str2;
        }

        public void m6472a() {
            this.f4771d.m6483b(this.f4768a, this.f4769b, this.f4770c);
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.m.3 */
    class C05823 implements C0523a {
        final /* synthetic */ String f4772a;
        final /* synthetic */ Context f4773b;
        final /* synthetic */ C0583m f4774c;

        C05823(C0583m c0583m, String str, Context context) {
            this.f4774c = c0583m;
            this.f4772a = str;
            this.f4773b = context;
        }

        public void m6473a() {
            this.f4774c.m6481a(this.f4772a, this.f4773b);
        }
    }

    static {
        f4776c = 30000;
        f4777d = new ArrayList();
    }

    public static C0583m m6474a() {
        if (f4775a == null) {
            f4775a = new C0583m();
        }
        return f4775a;
    }

    private C0583m() {
        this.f4778b = new C05801(this, Looper.getMainLooper());
    }

    public void m6486a(Context context, String str, String str2) {
        if (context == null) {
            C0566h.m6418a("record pageStart without context.", null);
            return;
        }
        this.f4778b.removeMessages(31415927);
        C0555d.m6362a().m6365a(new C05812(this, context, str, str2));
    }

    private void m6483b(Context context, String str, String str2) {
        try {
            String str3;
            long currentTimeMillis = System.currentTimeMillis();
            long a = C0573k.m6444a(context.getApplicationContext(), "session_begin", 0);
            long a2 = C0573k.m6444a(context.getApplicationContext(), "last_deactivate", 0);
            String a3 = C0573k.m6446a(context.getApplicationContext(), "pv_path", "");
            if (a <= 0) {
                C0573k.m6451b(context.getApplicationContext(), "session_begin", currentTimeMillis);
            } else if (a2 <= 0) {
                C0573k.m6451b(context.getApplicationContext(), "session_begin", currentTimeMillis);
                if (!TextUtils.isEmpty(a3)) {
                    m6482b(context, a3);
                    a3 = "";
                }
            }
            if (a2 <= 0 || currentTimeMillis - a2 <= f4776c) {
                str3 = a3;
            } else {
                m6476a(context, a, a2);
                if (TextUtils.isEmpty(a3)) {
                    str3 = a3;
                } else {
                    m6482b(context, a3);
                    str3 = "";
                }
                C0573k.m6451b(context.getApplicationContext(), "session_begin", currentTimeMillis);
            }
            String c = m6484c(context, str);
            if (!(str3.endsWith(c) && TextUtils.isEmpty(str2))) {
                C0573k.m6452b(context.getApplicationContext(), "pv_path", m6475a(str3, c));
                C0573k.m6452b(C0551c.m6352a(), "source_path", m6475a(C0573k.m6446a(C0551c.m6352a(), "source_path", ""), str2));
            }
            f4777d.add(new C0607h(c, Long.valueOf(currentTimeMillis)));
        } catch (Throwable e) {
            C0566h.m6418a("processActActivated exception: ", e);
        }
    }

    public void m6485a(Context context, String str) {
        C0555d.m6362a().m6365a(new C05823(this, str, context));
        this.f4778b.sendEmptyMessageDelayed(31415927, f4776c);
    }

    private void m6481a(String str, Context context) {
        try {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            C0573k.m6451b(C0551c.m6352a(), "last_deactivate", valueOf.longValue());
            if (!f4777d.isEmpty()) {
                int size;
                if (TextUtils.isEmpty(str)) {
                    size = f4777d.size() - 1;
                } else {
                    CharSequence c = m6484c(context, str);
                    size = f4777d.size() - 1;
                    while (size >= 0) {
                        if (TextUtils.equals(((C0607h) f4777d.get(size)).m6573e(), c)) {
                            break;
                        }
                        size--;
                    }
                    size = -1;
                }
                if (size >= 0) {
                    AbstractEvent abstractEvent = (C0607h) f4777d.get(size);
                    CharSequence e = abstractEvent.m6573e();
                    long d = abstractEvent.m6572d();
                    long longValue = valueOf.longValue() - d;
                    if (!TextUtils.isEmpty(e) && d > 0 && longValue > 0) {
                        abstractEvent.m6569a(Long.valueOf(longValue));
                        LocalEventRecorder.m6297a(abstractEvent);
                        f4777d.remove(size);
                    }
                }
            }
        } catch (Throwable e2) {
            C0566h.m6418a("processActDeativated exception: ", e2);
        }
    }

    private void m6476a(Context context, long j, long j2) {
        String b = C0571j.m6438b(context.getApplicationContext());
        if (TextUtils.isEmpty(b)) {
            b = "NULL";
        }
        LocalEventRecorder.m6297a(new C0609j(j, j2, b));
        C0573k.m6451b(context.getApplicationContext(), "session_begin", 0);
        C0573k.m6451b(C0551c.m6352a(), "last_deactivate", 0);
    }

    private void m6482b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            LocalEventRecorder.m6297a(new C0608i(str, C0573k.m6446a(context, "source_path", "")));
            C0573k.m6452b(context, "source_path", "");
            C0573k.m6452b(context, "pv_path", "");
        }
    }

    private String m6475a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return "," + str2;
    }

    private String m6484c(Context context, String str) {
        if (context == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getClass().getName();
        }
        CharSequence packageName = context.getPackageName();
        if (str.startsWith(packageName)) {
            return str.replace(packageName, "");
        }
        return str;
    }
}
