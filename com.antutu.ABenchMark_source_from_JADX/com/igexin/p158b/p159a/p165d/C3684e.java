package com.igexin.p158b.p159a.p165d;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.support.v7.widget.LinearLayoutManager;
import com.igexin.p158b.p159a.p161b.p162a.p163a.C3671d;
import com.igexin.p158b.p159a.p165d.p166a.C3664f;
import com.igexin.p158b.p159a.p165d.p166a.C3690c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.p182d.p185c.C3891p;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.d.e */
public class C3684e extends BroadcastReceiver implements Comparator {
    public static final String f12413g;
    public static final long f12414u;
    private boolean f12415a;
    final C3699i f12416h;
    final HashMap f12417i;
    final ConcurrentLinkedQueue f12418j;
    final C3695c f12419k;
    final ReentrantLock f12420l;
    PowerManager f12421m;
    AlarmManager f12422n;
    Intent f12423o;
    PendingIntent f12424p;
    Intent f12425q;
    PendingIntent f12426r;
    String f12427s;
    volatile boolean f12428t;

    static {
        f12413g = C3684e.class.getName();
        f12414u = TimeUnit.SECONDS.toMillis(2);
    }

    protected C3684e() {
        this.f12420l = new ReentrantLock();
        this.f12415a = false;
        this.f12417i = new HashMap(7);
        this.f12419k = new C3695c(this, this);
        this.f12418j = new ConcurrentLinkedQueue();
        this.f12416h = new C3699i(this);
        C3666d.f12327E = this;
    }

    public final int m15047a(C3666d c3666d, C3666d c3666d2) {
        int i = c3666d.f12328A > c3666d2.f12328A ? -1 : c3666d.f12328A < c3666d2.f12328A ? 1 : c3666d.f12349v < c3666d2.f12349v ? -1 : c3666d.f12349v > c3666d2.f12349v ? 1 : 0;
        if (c3666d.f12348u != c3666d2.f12348u) {
            i = c3666d.f12348u < c3666d2.f12348u ? -1 : 1;
        }
        return i == 0 ? c3666d.hashCode() - c3666d2.hashCode() : i;
    }

    @TargetApi(19)
    public final void m15048a(long j) {
        if (this.f12428t) {
            C3688a.m15097b("setnioalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j)));
            if (j < 0) {
                j = System.currentTimeMillis() + f12414u;
            }
            try {
                if (this.f12424p == null) {
                    return;
                }
                if (VERSION.SDK_INT < 19) {
                    this.f12422n.set(0, j, this.f12424p);
                } else {
                    this.f12422n.setExact(0, j, this.f12424p);
                }
            } catch (Throwable th) {
                C3688a.m15097b("TaskService" + th.toString());
            }
        }
    }

    public final void m15049a(Context context) {
        if (!this.f12415a) {
            this.f12421m = (PowerManager) context.getSystemService("power");
            this.f12428t = true;
            this.f12422n = (AlarmManager) context.getSystemService(NotificationCompatApi21.CATEGORY_ALARM);
            context.registerReceiver(this, new IntentFilter("AlarmTaskSchedule." + context.getPackageName()));
            context.registerReceiver(this, new IntentFilter("AlarmTaskScheduleBak." + context.getPackageName()));
            context.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_OFF"));
            context.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_ON"));
            this.f12427s = "AlarmNioTaskSchedule." + context.getPackageName();
            context.registerReceiver(this, new IntentFilter(this.f12427s));
            this.f12423o = new Intent("AlarmTaskSchedule." + context.getPackageName());
            this.f12424p = PendingIntent.getBroadcast(context, hashCode(), this.f12423o, 134217728);
            this.f12425q = new Intent(this.f12427s);
            this.f12426r = PendingIntent.getBroadcast(context, hashCode() + 2, this.f12425q, 134217728);
            this.f12416h.start();
            try {
                Thread.yield();
            } catch (Throwable th) {
            }
            this.f12415a = true;
        }
    }

    public final boolean m15050a(C3690c c3690c) {
        if (c3690c == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.f12420l;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            if (this.f12417i.keySet().contains(Long.valueOf(c3690c.m15103o()))) {
                return false;
            }
            this.f12417i.put(Long.valueOf(c3690c.m15103o()), c3690c);
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            C3688a.m15097b("TaskService|" + th.toString());
        } finally {
            reentrantLock.unlock();
        }
    }

    final boolean m15051a(C3664f c3664f, C3690c c3690c) {
        int b = c3664f.m14947b();
        if (b <= LinearLayoutManager.INVALID_OFFSET || b >= 0) {
            return (b < 0 || b >= Integer.MAX_VALUE) ? false : c3690c.m15100a(c3664f, this);
        } else {
            C3666d c3666d = (C3666d) c3664f;
            boolean a = c3666d.f12347t ? c3690c.m15101a(c3666d, this) : c3690c.m15100a(c3664f, this);
            if (a) {
                c3666d.m14960c();
            }
            return a;
        }
    }

    public final boolean m15052a(C3666d c3666d, boolean z) {
        int i = 0;
        if (c3666d == null) {
            throw new NullPointerException();
        } else if (c3666d.f12343p || c3666d.f12339k) {
            return false;
        } else {
            C3695c c3695c = this.f12419k;
            if (z) {
                i = c3695c.f12452e.incrementAndGet();
            }
            c3666d.f12328A = i;
            return c3695c.m15114a(c3666d);
        }
    }

    public final boolean m15053a(C3666d c3666d, boolean z, boolean z2) {
        boolean z3 = true;
        if (c3666d == null) {
            throw new NullPointerException();
        } else if (c3666d.f12340m) {
            return false;
        } else {
            if (!z || z2) {
                if (!(z2 && z)) {
                    z3 = false;
                }
                return m15052a(c3666d, z3);
            }
            c3666d.m14961d();
            try {
                c3666d.a_();
                c3666d.m14969s();
                c3666d.m14971u();
                if (!c3666d.f12347t) {
                    c3666d.m14960c();
                }
                return true;
            } catch (Exception e) {
                c3666d.f12347t = true;
                c3666d.f12329B = e;
                c3666d.m14966p();
                c3666d.m14972v();
                m15055a((Object) c3666d);
                m15058f();
                if (c3666d.f12347t) {
                    return false;
                }
                c3666d.m14960c();
                return false;
            } catch (Throwable th) {
                if (!c3666d.f12347t) {
                    c3666d.m14960c();
                }
            }
        }
    }

    public final boolean m15054a(Class cls) {
        C3695c c3695c = this.f12419k;
        return c3695c != null && c3695c.m15115a(cls);
    }

    public final boolean m15055a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (obj instanceof C3891p) {
                C3688a.m15095a("TaskService|responseTask|" + obj.getClass().getName() + "|" + obj.hashCode() + "|" + ((String) ((C3891p) obj).f13116e));
            } else {
                C3688a.m15095a("TaskService|responseTask|" + obj.getClass().getName() + "|" + obj.hashCode());
            }
        } catch (Exception e) {
        }
        if (obj instanceof C3664f) {
            C3664f c3664f = (C3664f) obj;
            if (c3664f.m14949l()) {
                return false;
            }
            c3664f.m14948c(false);
            this.f12418j.offer(c3664f);
            return true;
        }
        throw new ClassCastException("response Obj is not a TaskResult ");
    }

    @TargetApi(19)
    public final void m15056b(long j) {
        C3688a.m15097b("setnioalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j)));
        if (j < 0) {
            j = System.currentTimeMillis() + f12414u;
        }
        try {
            if (VERSION.SDK_INT < 19) {
                this.f12422n.set(0, j, this.f12426r);
            } else {
                this.f12422n.setExact(0, j, this.f12426r);
            }
        } catch (Exception e) {
            this.f12422n.set(0, j, this.f12426r);
        } catch (Throwable th) {
        }
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15047a((C3666d) obj, (C3666d) obj2);
    }

    public final void m15057e() {
        try {
            if (this.f12426r != null) {
                this.f12422n.cancel(this.f12426r);
            }
        } catch (Throwable th) {
        }
    }

    protected final void m15058f() {
        if (this.f12416h != null && !this.f12416h.isInterrupted()) {
            this.f12416h.interrupt();
        }
    }

    final void m15059g() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x008d in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r9 = this;
        r8 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x0002:
        r0 = r9.f12418j;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00a6;
    L_0x000a:
        r0 = r9.f12418j;
        r0 = r0.poll();
        r0 = (com.igexin.p158b.p159a.p165d.p166a.C3664f) r0;
        r1 = 1;
        r0.m14948c(r1);
        r2 = 0;
        r3 = r9.f12420l;
        r3.lock();
        r1 = r9.f12417i;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        if (r1 != 0) goto L_0x0047;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x0024:
        r4 = r0.m14950m();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r6 = 0;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        if (r1 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x002e:
        r1 = r9.f12417i;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r1 = r1.get(r4);	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r1 = (com.igexin.p158b.p159a.p165d.p166a.C3690c) r1;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        if (r1 == 0) goto L_0x00a7;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x003c:
        r4 = r1.m15102n();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        if (r4 == 0) goto L_0x00a7;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x0042:
        r1 = r9.m15051a(r0, r1);	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x0046:
        r2 = r1;
    L_0x0047:
        if (r2 != 0) goto L_0x0056;
    L_0x0049:
        r1 = r0.m14947b();
        if (r1 <= r8) goto L_0x0056;
    L_0x004f:
        if (r1 >= 0) goto L_0x0056;
    L_0x0051:
        r0 = (com.igexin.p158b.p159a.p165d.C3666d) r0;
        r0.m14960c();
    L_0x0056:
        r3.unlock();
        goto L_0x0002;
    L_0x005a:
        r1 = r9.f12417i;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r1 = r1.values();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r4 = r1.iterator();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x0064:
        r1 = r4.hasNext();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        if (r1 == 0) goto L_0x0047;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x006a:
        r1 = r4.next();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r1 = (com.igexin.p158b.p159a.p165d.p166a.C3690c) r1;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        r5 = r1.m15102n();	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        if (r5 == 0) goto L_0x0064;	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
    L_0x0076:
        r2 = r9.m15051a(r0, r1);	 Catch:{ Exception -> 0x007d, all -> 0x0092 }
        if (r2 == 0) goto L_0x0064;
    L_0x007c:
        goto L_0x0047;
    L_0x007d:
        r1 = move-exception;
        if (r2 != 0) goto L_0x008d;
    L_0x0080:
        r1 = r0.m14947b();
        if (r1 <= r8) goto L_0x008d;
    L_0x0086:
        if (r1 >= 0) goto L_0x008d;
    L_0x0088:
        r0 = (com.igexin.p158b.p159a.p165d.C3666d) r0;
        r0.m14960c();
    L_0x008d:
        r3.unlock();
        goto L_0x0002;
    L_0x0092:
        r1 = move-exception;
        if (r2 != 0) goto L_0x00a2;
    L_0x0095:
        r2 = r0.m14947b();
        if (r2 <= r8) goto L_0x00a2;
    L_0x009b:
        if (r2 >= 0) goto L_0x00a2;
    L_0x009d:
        r0 = (com.igexin.p158b.p159a.p165d.C3666d) r0;
        r0.m14960c();
    L_0x00a2:
        r3.unlock();
        throw r1;
    L_0x00a6:
        return;
    L_0x00a7:
        r1 = r2;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.e.g():void");
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f12428t = true;
            C3688a.m15097b("screenoff");
            if (this.f12419k.f12455h.get() > 0) {
                m15048a(this.f12419k.f12455h.get());
            }
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.f12428t = false;
            C3688a.m15097b("screenon");
        } else if (intent.getAction().startsWith("AlarmTaskSchedule.") || intent.getAction().startsWith("AlarmTaskScheduleBak.")) {
            C3688a.m15097b("receivealarm|" + this.f12428t);
            m15058f();
        } else if (this.f12427s.equals(intent.getAction())) {
            C3688a.m15097b("receive nioalarm");
            try {
                C3688a.m15097b("TaskService|alarm time out #######");
                C3671d.m14981a().m15013d();
            } catch (Exception e) {
            }
        }
    }
}
