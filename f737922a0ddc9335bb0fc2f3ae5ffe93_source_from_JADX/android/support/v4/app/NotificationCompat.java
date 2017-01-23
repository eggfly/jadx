package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class NotificationCompat {
    private static final f j6;

    public static class Builder {
        public Notification BT;
        public CharSequence DW;
        boolean EQ;
        public CharSequence FH;
        PendingIntent Hw;
        public o J0;
        public CharSequence J8;
        String Mr;
        int QX;
        public ArrayList<a> U2;
        public Bitmap VH;
        int Ws;
        boolean XL;
        RemoteViews Zo;
        boolean a8;
        String aM;
        int er;
        Notification gW;
        public CharSequence gn;
        boolean j3;
        public Context j6;
        String lg;
        Bundle rN;
        int tp;
        public int u7;
        PendingIntent v5;
        public ArrayList<String> vy;
        public boolean we;
        int yS;

        public Builder(Context context) {
            this.EQ = true;
            this.U2 = new ArrayList();
            this.a8 = false;
            this.er = 0;
            this.yS = 0;
            this.BT = new Notification();
            this.j6 = context;
            this.BT.when = System.currentTimeMillis();
            this.BT.audioStreamType = -1;
            this.tp = 0;
            this.vy = new ArrayList();
        }

        public Builder j6(long j) {
            this.BT.when = j;
            return this;
        }

        public Builder j6(int i) {
            this.BT.icon = i;
            return this;
        }

        public Builder j6(CharSequence charSequence) {
            this.DW = Hw(charSequence);
            return this;
        }

        public Builder DW(CharSequence charSequence) {
            this.FH = Hw(charSequence);
            return this;
        }

        public Builder DW(int i) {
            this.u7 = i;
            return this;
        }

        public Builder j6(PendingIntent pendingIntent) {
            this.Hw = pendingIntent;
            return this;
        }

        public Builder FH(CharSequence charSequence) {
            this.BT.tickerText = Hw(charSequence);
            return this;
        }

        public Builder j6(boolean z) {
            j6(16, z);
            return this;
        }

        public Builder FH(int i) {
            this.BT.defaults = i;
            if ((i & 4) != 0) {
                Notification notification = this.BT;
                notification.flags |= 1;
            }
            return this;
        }

        private void j6(int i, boolean z) {
            if (z) {
                Notification notification = this.BT;
                notification.flags |= i;
                return;
            }
            notification = this.BT;
            notification.flags &= i ^ -1;
        }

        public Builder Hw(int i) {
            this.tp = i;
            return this;
        }

        public Notification j6() {
            return NotificationCompat.j6.j6(this, DW());
        }

        protected d DW() {
            return new d();
        }

        protected static CharSequence Hw(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    public static class a extends android.support.v4.app.z.a {
        public static final android.support.v4.app.z.a.a Hw;
        public CharSequence DW;
        public PendingIntent FH;
        private final af[] Zo;
        public int j6;
        private final Bundle v5;

        static class 1 implements android.support.v4.app.z.a.a {
            1() {
            }
        }

        public /* synthetic */ android.support.v4.app.ah.a[] Zo() {
            return v5();
        }

        public int j6() {
            return this.j6;
        }

        public CharSequence DW() {
            return this.DW;
        }

        public PendingIntent FH() {
            return this.FH;
        }

        public Bundle Hw() {
            return this.v5;
        }

        public af[] v5() {
            return this.Zo;
        }

        static {
            Hw = new 1();
        }
    }

    public static abstract class o {
        CharSequence Hw;
        boolean Zo;
        CharSequence v5;

        public o() {
            this.Zo = false;
        }
    }

    public static class b extends o {
        Bitmap DW;
        boolean FH;
        Bitmap j6;
    }

    public static class c extends o {
        CharSequence j6;
    }

    protected static class d {
        protected d() {
        }

        public Notification j6(Builder builder, w wVar) {
            return wVar.DW();
        }
    }

    public static class e extends o {
        ArrayList<CharSequence> j6;

        public e() {
            this.j6 = new ArrayList();
        }
    }

    interface f {
        Notification j6(Builder builder, d dVar);
    }

    static class i implements f {
        i() {
        }

        public Notification j6(Builder builder, d dVar) {
            Notification notification = builder.BT;
            notification.setLatestEventInfo(builder.j6, builder.DW, builder.FH, builder.Hw);
            if (builder.tp > 0) {
                notification.flags |= 128;
            }
            return notification;
        }
    }

    static class m extends i {
        m() {
        }

        public Notification j6(Builder builder, d dVar) {
            w aVar = new android.support.v4.app.ad.a(builder.j6, builder.BT, builder.DW, builder.FH, builder.gn, builder.Zo, builder.u7, builder.Hw, builder.v5, builder.VH, builder.Ws, builder.QX, builder.XL, builder.we, builder.tp, builder.J8, builder.a8, builder.rN, builder.aM, builder.j3, builder.Mr);
            NotificationCompat.DW((v) aVar, builder.U2);
            NotificationCompat.DW(aVar, builder.J0);
            return dVar.j6(builder, aVar);
        }
    }

    static class n extends m {
        n() {
        }

        public Notification j6(Builder builder, d dVar) {
            w aVar = new android.support.v4.app.ae.a(builder.j6, builder.BT, builder.DW, builder.FH, builder.gn, builder.Zo, builder.u7, builder.Hw, builder.v5, builder.VH, builder.Ws, builder.QX, builder.XL, builder.EQ, builder.we, builder.tp, builder.J8, builder.a8, builder.vy, builder.rN, builder.aM, builder.j3, builder.Mr);
            NotificationCompat.DW((v) aVar, builder.U2);
            NotificationCompat.DW(aVar, builder.J0);
            return dVar.j6(builder, aVar);
        }
    }

    static class g extends n {
        g() {
        }

        public Notification j6(Builder builder, d dVar) {
            w aVar = new android.support.v4.app.x.a(builder.j6, builder.BT, builder.DW, builder.FH, builder.gn, builder.Zo, builder.u7, builder.Hw, builder.v5, builder.VH, builder.Ws, builder.QX, builder.XL, builder.EQ, builder.we, builder.tp, builder.J8, builder.a8, builder.vy, builder.rN, builder.aM, builder.j3, builder.Mr);
            NotificationCompat.DW((v) aVar, builder.U2);
            NotificationCompat.DW(aVar, builder.J0);
            return dVar.j6(builder, aVar);
        }
    }

    static class h extends g {
        h() {
        }

        public Notification j6(Builder builder, d dVar) {
            w aVar = new android.support.v4.app.y.a(builder.j6, builder.BT, builder.DW, builder.FH, builder.gn, builder.Zo, builder.u7, builder.Hw, builder.v5, builder.VH, builder.Ws, builder.QX, builder.XL, builder.EQ, builder.we, builder.tp, builder.J8, builder.a8, builder.lg, builder.vy, builder.rN, builder.er, builder.yS, builder.gW, builder.aM, builder.j3, builder.Mr);
            NotificationCompat.DW((v) aVar, builder.U2);
            NotificationCompat.DW(aVar, builder.J0);
            return dVar.j6(builder, aVar);
        }
    }

    static class j extends i {
        j() {
        }

        public Notification j6(Builder builder, d dVar) {
            Notification notification = builder.BT;
            notification.setLatestEventInfo(builder.j6, builder.DW, builder.FH, builder.Hw);
            notification = aa.j6(notification, builder.j6, builder.DW, builder.FH, builder.Hw, builder.v5);
            if (builder.tp > 0) {
                notification.flags |= 128;
            }
            return notification;
        }
    }

    static class k extends i {
        k() {
        }

        public Notification j6(Builder builder, d dVar) {
            return ab.j6(builder.j6, builder.BT, builder.DW, builder.FH, builder.gn, builder.Zo, builder.u7, builder.Hw, builder.v5, builder.VH);
        }
    }

    static class l extends i {
        l() {
        }

        public Notification j6(Builder builder, d dVar) {
            return dVar.j6(builder, new android.support.v4.app.ac.a(builder.j6, builder.BT, builder.DW, builder.FH, builder.gn, builder.Zo, builder.u7, builder.Hw, builder.v5, builder.VH, builder.Ws, builder.QX, builder.XL));
        }
    }

    private static void DW(v vVar, ArrayList<a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            vVar.j6((a) it.next());
        }
    }

    private static void DW(w wVar, o oVar) {
        if (oVar == null) {
            return;
        }
        if (oVar instanceof c) {
            c cVar = (c) oVar;
            ad.j6(wVar, cVar.Hw, cVar.Zo, cVar.v5, cVar.j6);
        } else if (oVar instanceof e) {
            e eVar = (e) oVar;
            ad.j6(wVar, eVar.Hw, eVar.Zo, eVar.v5, eVar.j6);
        } else if (oVar instanceof b) {
            b bVar = (b) oVar;
            ad.j6(wVar, bVar.Hw, bVar.Zo, bVar.v5, bVar.j6, bVar.DW, bVar.FH);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            j6 = new h();
        } else if (VERSION.SDK_INT >= 20) {
            j6 = new g();
        } else if (VERSION.SDK_INT >= 19) {
            j6 = new n();
        } else if (VERSION.SDK_INT >= 16) {
            j6 = new m();
        } else if (VERSION.SDK_INT >= 14) {
            j6 = new l();
        } else if (VERSION.SDK_INT >= 11) {
            j6 = new k();
        } else if (VERSION.SDK_INT >= 9) {
            j6 = new j();
        } else {
            j6 = new i();
        }
    }
}
