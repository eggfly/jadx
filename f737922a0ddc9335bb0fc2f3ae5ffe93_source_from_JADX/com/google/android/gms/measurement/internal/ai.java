package com.google.android.gms.measurement.internal;

import afq;
import agl;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.ht.b;
import com.google.android.gms.internal.ht.c;
import com.google.android.gms.internal.ht.d;
import com.google.android.gms.internal.ht.e;
import com.google.android.gms.internal.ht.g;
import com.google.android.gms.internal.m;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import l;

public class ai {
    private static volatile ai DW;
    private int BT;
    private final l EQ;
    private final Context FH;
    private final o Hw;
    private final ab J0;
    private final afq J8;
    private final i Mr;
    private final r QX;
    private final n U2;
    private final ah VH;
    private final d Ws;
    private final c XL;
    private final aa Zo;
    private final boolean a8;
    private final y aM;
    private FileLock er;
    private List<Long> gW;
    private final f gn;
    private final ac j3;
    public final agl j6;
    private boolean lg;
    private Boolean rN;
    private final AppMeasurement tp;
    private final ag u7;
    private final ae v5;
    private int vy;
    private final p we;
    private FileChannel yS;

    class 1 implements Runnable {
        final /* synthetic */ ai j6;

        1(ai aiVar) {
            this.j6 = aiVar;
        }

        public void run() {
            this.j6.FH();
        }
    }

    class 2 implements a {
        final /* synthetic */ ai j6;

        2(ai aiVar) {
            this.j6 = aiVar;
        }

        public void j6(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.j6.j6(i, th, bArr);
        }
    }

    class 3 implements a {
        final /* synthetic */ ai j6;

        3(ai aiVar) {
            this.j6 = aiVar;
        }

        public void j6(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.j6.j6(str, i, th, bArr, map);
        }
    }

    private class a implements b {
        List<Long> DW;
        List<b> FH;
        long Hw;
        e j6;
        final /* synthetic */ ai v5;

        private a(ai aiVar) {
            this.v5 = aiVar;
        }

        private long j6(b bVar) {
            return ((bVar.FH.longValue() / 1000) / 60) / 60;
        }

        public void j6(e eVar) {
            com.google.android.gms.common.internal.b.j6((Object) eVar);
            this.j6 = eVar;
        }

        boolean j6() {
            return this.FH == null || this.FH.isEmpty();
        }

        public boolean j6(long j, b bVar) {
            com.google.android.gms.common.internal.b.j6((Object) bVar);
            if (this.FH == null) {
                this.FH = new ArrayList();
            }
            if (this.DW == null) {
                this.DW = new ArrayList();
            }
            if (this.FH.size() > 0 && j6((b) this.FH.get(0)) != j6(bVar)) {
                return false;
            }
            long VH = this.Hw + ((long) bVar.VH());
            if (VH >= ((long) this.v5.Hw().sy())) {
                return false;
            }
            this.Hw = VH;
            this.FH.add(bVar);
            this.DW.add(Long.valueOf(j));
            return this.FH.size() < this.v5.Hw().aj();
        }
    }

    ai(zzab com_google_android_gms_measurement_internal_zzab) {
        com.google.android.gms.common.internal.b.j6((Object) com_google_android_gms_measurement_internal_zzab);
        this.FH = com_google_android_gms_measurement_internal_zzab.j6;
        this.J8 = com_google_android_gms_measurement_internal_zzab.we(this);
        this.Hw = com_google_android_gms_measurement_internal_zzab.j6(this);
        ae DW = com_google_android_gms_measurement_internal_zzab.DW(this);
        DW.Hw();
        this.v5 = DW;
        aa FH = com_google_android_gms_measurement_internal_zzab.FH(this);
        FH.Hw();
        this.Zo = FH;
        Zo().vy().j6("App measurement is starting up, version", Long.valueOf(Hw().sG()));
        Zo().vy().j6("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        Zo().P8().j6("Debug logging enabled");
        Zo().P8().j6("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.EQ = com_google_android_gms_measurement_internal_zzab.u7(this);
        r J8 = com_google_android_gms_measurement_internal_zzab.J8(this);
        J8.Hw();
        this.QX = J8;
        y Ws = com_google_android_gms_measurement_internal_zzab.Ws(this);
        Ws.Hw();
        this.aM = Ws;
        p tp = com_google_android_gms_measurement_internal_zzab.tp(this);
        tp.Hw();
        this.we = tp;
        n aM = com_google_android_gms_measurement_internal_zzab.aM(this);
        aM.Hw();
        this.U2 = aM;
        ab EQ = com_google_android_gms_measurement_internal_zzab.EQ(this);
        EQ.Hw();
        this.J0 = EQ;
        d J0 = com_google_android_gms_measurement_internal_zzab.J0(this);
        J0.Hw();
        this.Ws = J0;
        c gn = com_google_android_gms_measurement_internal_zzab.gn(this);
        gn.Hw();
        this.XL = gn;
        i XL = com_google_android_gms_measurement_internal_zzab.XL(this);
        XL.Hw();
        this.Mr = XL;
        this.j3 = com_google_android_gms_measurement_internal_zzab.QX(this);
        this.tp = com_google_android_gms_measurement_internal_zzab.VH(this);
        this.j6 = new agl(this);
        f v5 = com_google_android_gms_measurement_internal_zzab.v5(this);
        v5.Hw();
        this.gn = v5;
        ag Zo = com_google_android_gms_measurement_internal_zzab.Zo(this);
        Zo.Hw();
        this.u7 = Zo;
        ah Hw = com_google_android_gms_measurement_internal_zzab.Hw(this);
        Hw.Hw();
        this.VH = Hw;
        if (this.BT != this.vy) {
            Zo().Zo().j6("Not all components initialized", Integer.valueOf(this.BT), Integer.valueOf(this.vy));
        }
        this.a8 = true;
        if (!(this.Hw.ef() || vy())) {
            if (!(this.FH.getApplicationContext() instanceof Application)) {
                Zo().yS().j6("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                we().Zo();
            } else {
                Zo().P8().j6("Not tracking deep linking pre-ICS");
            }
        }
        this.VH.j6(new 1(this));
    }

    private void DW(b bVar) {
        if (bVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!bVar.j6()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void FH(AppMetadata appMetadata) {
        Object obj = 1;
        er();
        j6();
        com.google.android.gms.common.internal.b.j6((Object) appMetadata);
        com.google.android.gms.common.internal.b.j6(appMetadata.DW);
        a DW = Ws().DW(appMetadata.DW);
        String DW2 = v5().DW(appMetadata.DW);
        Object obj2 = null;
        if (DW == null) {
            a aVar = new a(this, appMetadata.DW);
            aVar.j6(v5().Zo());
            aVar.FH(DW2);
            DW = aVar;
            obj2 = 1;
        } else if (!DW2.equals(DW.v5())) {
            DW.FH(DW2);
            DW.j6(v5().Zo());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.FH) || appMetadata.FH.equals(DW.Hw()))) {
            DW.DW(appMetadata.FH);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.we) || appMetadata.we.equals(DW.Zo()))) {
            DW.Hw(appMetadata.we);
            obj2 = 1;
        }
        if (!(appMetadata.Zo == 0 || appMetadata.Zo == DW.we())) {
            DW.Hw(appMetadata.Zo);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.Hw) || appMetadata.Hw.equals(DW.u7()))) {
            DW.v5(appMetadata.Hw);
            obj2 = 1;
        }
        if (appMetadata.EQ != DW.tp()) {
            DW.FH(appMetadata.EQ);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.v5) || appMetadata.v5.equals(DW.EQ()))) {
            DW.Zo(appMetadata.v5);
            obj2 = 1;
        }
        if (appMetadata.VH != DW.J0()) {
            DW.v5(appMetadata.VH);
            obj2 = 1;
        }
        if (appMetadata.u7 != DW.J8()) {
            DW.j6(appMetadata.u7);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            Ws().j6(DW);
        }
    }

    private boolean cb() {
        er();
        return this.gW != null;
    }

    private boolean dx() {
        er();
        j6();
        return Ws().KD() || !TextUtils.isEmpty(Ws().vy());
    }

    private long ef() {
        long j6 = aM().j6();
        long yO = Hw().yO();
        long XX = Hw().XX();
        long j62 = v5().FH.j6();
        long j63 = v5().Hw.j6();
        long max = Math.max(Ws().nw(), Ws().SI());
        if (max == 0) {
            return 0;
        }
        max = j6 - Math.abs(max - j6);
        j63 = j6 - Math.abs(j63 - j6);
        j6 = Math.max(j6 - Math.abs(j62 - j6), j63);
        yO += max;
        if (!J8().j6(j6, XX)) {
            yO = j6 + XX;
        }
        if (j63 == 0 || j63 < max) {
            return yO;
        }
        for (int i = 0; i < Hw().jJ(); i++) {
            yO += ((long) (1 << i)) * Hw().XG();
            if (yO > j63) {
                return yO;
            }
        }
        return 0;
    }

    public static ai j6(Context context) {
        com.google.android.gms.common.internal.b.j6((Object) context);
        com.google.android.gms.common.internal.b.j6(context.getApplicationContext());
        if (DW == null) {
            synchronized (ai.class) {
                if (DW == null) {
                    DW = new zzab(context).j6();
                }
            }
        }
        return DW;
    }

    private void j6(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        er();
        j6();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.gW;
        this.gW = null;
        if ((i == 200 || i == 204) && th == null) {
            v5().FH.j6(aM().j6());
            v5().Hw.j6(0);
            sG();
            Zo().ei().j6("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            Ws().Zo();
            try {
                for (Long longValue : list) {
                    Ws().j6(longValue.longValue());
                }
                Ws().VH();
                if (QX().Zo() && dx()) {
                    KD();
                } else {
                    sG();
                }
            } finally {
                Ws().yS();
            }
        } else {
            Zo().ei().j6("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            v5().Hw.j6(aM().j6());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                v5().v5.j6(aM().j6());
            }
            sG();
        }
    }

    private void j6(ak akVar) {
        if (akVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void j6(List<Long> list) {
        com.google.android.gms.common.internal.b.DW(!list.isEmpty());
        if (this.gW != null) {
            Zo().Zo().j6("Set uploading progress before finishing the previous upload");
        } else {
            this.gW = new ArrayList(list);
        }
    }

    private boolean j6(String str, long j) {
        Ws().Zo();
        try {
            ai aiVar = this;
            b aVar = new a();
            Ws().j6(str, j, aVar);
            if (aVar.j6()) {
                Ws().VH();
                Ws().yS();
                return false;
            }
            int i;
            e eVar = aVar.j6;
            eVar.DW = new b[aVar.FH.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < aVar.FH.size()) {
                if (tp().DW(aVar.j6.QX, ((b) aVar.FH.get(i3)).DW)) {
                    Zo().yS().j6("Dropping blacklisted raw event", ((b) aVar.FH.get(i3)).DW);
                    J8().j6(11, "_ev", ((b) aVar.FH.get(i3)).DW);
                    i = i2;
                } else {
                    int i4;
                    if (tp().FH(aVar.j6.QX, ((b) aVar.FH.get(i3)).DW)) {
                        int i5;
                        Object obj;
                        c cVar;
                        if (((b) aVar.FH.get(i3)).j6 == null) {
                            ((b) aVar.FH.get(i3)).j6 = new c[0];
                        }
                        for (c cVar2 : ((b) aVar.FH.get(i3)).j6) {
                            if ("_c".equals(cVar2.j6)) {
                                cVar2.FH = Long.valueOf(1);
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            Zo().ei().j6("Marking event as conversion", ((b) aVar.FH.get(i3)).DW);
                            c[] cVarArr = (c[]) Arrays.copyOf(((b) aVar.FH.get(i3)).j6, ((b) aVar.FH.get(i3)).j6.length + 1);
                            cVar = new c();
                            cVar.j6 = "_c";
                            cVar.FH = Long.valueOf(1);
                            cVarArr[cVarArr.length - 1] = cVar;
                            ((b) aVar.FH.get(i3)).j6 = cVarArr;
                        }
                        boolean j6 = l.j6(((b) aVar.FH.get(i3)).DW);
                        if (j6 && Ws().j6(ei(), aVar.j6.QX, false, j6, false).FH - ((long) Hw().j6(aVar.j6.QX)) > 0) {
                            Zo().yS().j6("Too many conversions. Not logging as conversion.");
                            b bVar = (b) aVar.FH.get(i3);
                            Object obj2 = null;
                            c cVar3 = null;
                            c[] cVarArr2 = ((b) aVar.FH.get(i3)).j6;
                            int length = cVarArr2.length;
                            int i6 = 0;
                            while (i6 < length) {
                                Object obj3;
                                cVar = cVarArr2[i6];
                                if ("_c".equals(cVar.j6)) {
                                    obj3 = obj2;
                                } else if ("_err".equals(cVar.j6)) {
                                    c cVar4 = cVar3;
                                    int i7 = 1;
                                    cVar = cVar4;
                                } else {
                                    cVar = cVar3;
                                    obj3 = obj2;
                                }
                                i6++;
                                obj2 = obj3;
                                cVar3 = cVar;
                            }
                            if (obj2 != null && cVar3 != null) {
                                c[] cVarArr3 = new c[(bVar.j6.length - 1)];
                                i4 = 0;
                                cVarArr2 = bVar.j6;
                                length = cVarArr2.length;
                                i5 = 0;
                                while (i5 < length) {
                                    c cVar5 = cVarArr2[i5];
                                    if (cVar5 != cVar3) {
                                        i = i4 + 1;
                                        cVarArr3[i4] = cVar5;
                                    } else {
                                        i = i4;
                                    }
                                    i5++;
                                    i4 = i;
                                }
                                ((b) aVar.FH.get(i3)).j6 = cVarArr3;
                            } else if (cVar3 != null) {
                                cVar3.j6 = "_err";
                                cVar3.FH = Long.valueOf(10);
                            } else {
                                Zo().Zo().j6("Did not find conversion parameter. Error not tracked");
                            }
                        }
                    }
                    i4 = i2 + 1;
                    eVar.DW[i2] = (b) aVar.FH.get(i3);
                    i = i4;
                }
                i3++;
                i2 = i;
            }
            if (i2 < aVar.FH.size()) {
                eVar.DW = (b[]) Arrays.copyOf(eVar.DW, i2);
            }
            eVar.BT = j6(aVar.j6.QX, aVar.j6.FH, eVar.DW);
            eVar.v5 = eVar.DW[0].FH;
            eVar.Zo = eVar.DW[0].FH;
            for (i = 1; i < eVar.DW.length; i++) {
                b bVar2 = eVar.DW[i];
                if (bVar2.FH.longValue() < eVar.v5.longValue()) {
                    eVar.v5 = bVar2.FH;
                }
                if (bVar2.FH.longValue() > eVar.Zo.longValue()) {
                    eVar.Zo = bVar2.FH;
                }
            }
            String str2 = aVar.j6.QX;
            a DW = Ws().DW(str2);
            if (DW == null) {
                Zo().Zo().j6("Bundling raw events w/o app info");
            } else {
                long gn = DW.gn();
                eVar.gn = gn != 0 ? Long.valueOf(gn) : null;
                long VH = DW.VH();
                if (VH != 0) {
                    gn = VH;
                }
                eVar.VH = gn != 0 ? Long.valueOf(gn) : null;
                DW.aM();
                eVar.rN = Integer.valueOf((int) DW.Ws());
                DW.j6(eVar.v5.longValue());
                DW.DW(eVar.Zo.longValue());
                Ws().j6(DW);
            }
            eVar.er = Zo().nw();
            Ws().j6(eVar);
            Ws().j6(aVar.DW);
            Ws().gn(str2);
            Ws().VH();
            return true;
        } finally {
            Ws().yS();
        }
    }

    private com.google.android.gms.internal.ht.a[] j6(String str, g[] gVarArr, b[] bVarArr) {
        com.google.android.gms.common.internal.b.j6(str);
        return rN().j6(str, bVarArr, gVarArr);
    }

    private void sG() {
        er();
        j6();
        if (!sh()) {
            return;
        }
        if (DW() && dx()) {
            long ef = ef();
            if (ef == 0) {
                a8().DW();
                lg().Zo();
                return;
            } else if (QX().Zo()) {
                long j6 = v5().v5.j6();
                long br = Hw().br();
                if (!J8().j6(j6, br)) {
                    ef = Math.max(ef, j6 + br);
                }
                a8().DW();
                ef -= aM().j6();
                if (ef <= 0) {
                    lg().j6(1);
                    return;
                }
                Zo().ei().j6("Upload scheduled in approximately ms", Long.valueOf(ef));
                lg().j6(ef);
                return;
            } else {
                a8().j6();
                lg().Zo();
                return;
            }
        }
        a8().DW();
        lg().Zo();
    }

    boolean BT() {
        er();
        try {
            this.yS = new RandomAccessFile(new File(XL().getFilesDir(), this.we.BT()), "rw").getChannel();
            this.er = this.yS.tryLock();
            if (this.er != null) {
                Zo().ei().j6("Storage concurrent access okay");
                return true;
            }
            Zo().Zo().j6("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            Zo().Zo().j6("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            Zo().Zo().j6("Failed to access storage lock file", e2);
        }
    }

    public void DW(AppMetadata appMetadata) {
        er();
        j6();
        com.google.android.gms.common.internal.b.j6((Object) appMetadata);
        com.google.android.gms.common.internal.b.j6(appMetadata.DW);
        if (!TextUtils.isEmpty(appMetadata.FH)) {
            if (appMetadata.u7) {
                long j6 = aM().j6();
                Ws().Zo();
                try {
                    j6(appMetadata, j6);
                    FH(appMetadata);
                    if (Ws().j6(appMetadata.DW, "_f") == null) {
                        j6(new UserAttributeParcel("_fot", j6, Long.valueOf((1 + (j6 / 3600000)) * 3600000), "auto"), appMetadata);
                        DW(appMetadata, j6);
                        FH(appMetadata, j6);
                    } else if (appMetadata.tp) {
                        Hw(appMetadata, j6);
                    }
                    Ws().VH();
                } finally {
                    Ws().yS();
                }
            } else {
                FH(appMetadata);
            }
        }
    }

    void DW(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        j6(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    void DW(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        er();
        j6();
        if (!TextUtils.isEmpty(appMetadata.FH)) {
            if (appMetadata.u7) {
                Zo().P8().j6("Removing user property", userAttributeParcel.DW);
                Ws().Zo();
                try {
                    FH(appMetadata);
                    Ws().DW(appMetadata.DW, userAttributeParcel.DW);
                    Ws().VH();
                    Zo().P8().j6("User property removed", userAttributeParcel.DW);
                } finally {
                    Ws().yS();
                }
            } else {
                FH(appMetadata);
            }
        }
    }

    protected boolean DW() {
        j6();
        er();
        if (this.rN == null) {
            boolean z = J8().u7("android.permission.INTERNET") && J8().u7("android.permission.ACCESS_NETWORK_STATE") && af.j6(XL()) && e.j6(XL());
            this.rN = Boolean.valueOf(z);
            if (this.rN.booleanValue() && !Hw().ef()) {
                this.rN = Boolean.valueOf(J8().Zo(U2().VH()));
            }
        }
        return this.rN.booleanValue();
    }

    public byte[] DW(EventParcel eventParcel, String str) {
        j6();
        er();
        SI();
        com.google.android.gms.common.internal.b.j6((Object) eventParcel);
        com.google.android.gms.common.internal.b.j6(str);
        d dVar = new d();
        Ws().Zo();
        try {
            a DW = Ws().DW(str);
            byte[] bArr;
            if (DW == null) {
                Zo().P8().j6("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (DW.J8()) {
                long j;
                e eVar = new e();
                dVar.j6 = new e[]{eVar};
                eVar.j6 = Integer.valueOf(1);
                eVar.u7 = "android";
                eVar.QX = DW.DW();
                eVar.Ws = DW.EQ();
                eVar.XL = DW.u7();
                eVar.P8 = Integer.valueOf((int) DW.tp());
                eVar.aM = Long.valueOf(DW.we());
                eVar.yS = DW.Hw();
                eVar.lg = Long.valueOf(DW.J0());
                Pair j6 = v5().j6(DW.DW());
                if (!(j6 == null || TextUtils.isEmpty((CharSequence) j6.first))) {
                    eVar.Mr = (String) j6.first;
                    eVar.U2 = (Boolean) j6.second;
                }
                eVar.EQ = Mr().Zo();
                eVar.tp = Mr().VH();
                eVar.J0 = Integer.valueOf((int) Mr().yS());
                eVar.we = Mr().gW();
                eVar.a8 = DW.FH();
                eVar.vy = DW.Zo();
                List j62 = Ws().j6(DW.DW());
                eVar.FH = new g[j62.size()];
                for (int i = 0; i < j62.size(); i++) {
                    g gVar = new g();
                    eVar.FH[i] = gVar;
                    gVar.DW = ((k) j62.get(i)).DW;
                    gVar.j6 = Long.valueOf(((k) j62.get(i)).FH);
                    J8().j6(gVar, ((k) j62.get(i)).Hw);
                }
                Bundle DW2 = eventParcel.FH.DW();
                if ("_iap".equals(eventParcel.DW)) {
                    DW2.putLong("_c", 1);
                }
                DW2.putString("_o", eventParcel.Hw);
                t j63 = Ws().j6(str, eventParcel.DW);
                if (j63 == null) {
                    Ws().j6(new t(str, eventParcel.DW, 1, 0, eventParcel.v5));
                    j = 0;
                } else {
                    j = j63.v5;
                    Ws().j6(j63.j6(eventParcel.v5).j6());
                }
                s sVar = new s(this, eventParcel.Hw, str, eventParcel.DW, eventParcel.v5, j, DW2);
                b bVar = new b();
                eVar.DW = new b[]{bVar};
                bVar.FH = Long.valueOf(sVar.Hw);
                bVar.DW = sVar.DW;
                bVar.Hw = Long.valueOf(sVar.v5);
                bVar.j6 = new c[sVar.Zo.j6()];
                Iterator it = sVar.Zo.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    c cVar = new c();
                    int i3 = i2 + 1;
                    bVar.j6[i2] = cVar;
                    cVar.j6 = str2;
                    J8().j6(cVar, sVar.Zo.j6(str2));
                    i2 = i3;
                }
                eVar.BT = j6(DW.DW(), eVar.FH, eVar.DW);
                eVar.v5 = bVar.FH;
                eVar.Zo = bVar.FH;
                long gn = DW.gn();
                eVar.gn = gn != 0 ? Long.valueOf(gn) : null;
                long VH = DW.VH();
                if (VH != 0) {
                    gn = VH;
                }
                eVar.VH = gn != 0 ? Long.valueOf(gn) : null;
                DW.aM();
                eVar.rN = Integer.valueOf((int) DW.Ws());
                eVar.j3 = Long.valueOf(Hw().sG());
                eVar.Hw = Long.valueOf(aM().j6());
                eVar.gW = Boolean.TRUE;
                DW.j6(eVar.v5.longValue());
                DW.DW(eVar.Zo.longValue());
                Ws().j6(DW);
                Ws().VH();
                Ws().yS();
                try {
                    bArr = new byte[dVar.VH()];
                    m j64 = m.j6(bArr);
                    dVar.j6(j64);
                    j64.DW();
                    return J8().j6(bArr);
                } catch (IOException e) {
                    Zo().Zo().j6("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            } else {
                Zo().P8().j6("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                Ws().yS();
                return bArr;
            }
        } finally {
            Ws().yS();
        }
    }

    ah EQ() {
        return this.VH;
    }

    protected void FH() {
        er();
        if (!vy() || (this.VH.j6() && !this.VH.DW())) {
            Ws().P8();
            if (DW()) {
                if (!(Hw().ef() || TextUtils.isEmpty(U2().VH()))) {
                    String gW = v5().gW();
                    if (gW == null) {
                        v5().FH(U2().VH());
                    } else if (!gW.equals(U2().VH())) {
                        Zo().vy().j6("Rechecking which service to use due to a GMP App Id change");
                        v5().vy();
                        this.Ws.vy();
                        this.Ws.gW();
                        v5().FH(U2().VH());
                    }
                }
                if (!(Hw().ef() || vy() || TextUtils.isEmpty(U2().VH()))) {
                    we().VH();
                }
            } else if (P8()) {
                if (!J8().u7("android.permission.INTERNET")) {
                    Zo().Zo().j6("App is missing INTERNET permission");
                }
                if (!J8().u7("android.permission.ACCESS_NETWORK_STATE")) {
                    Zo().Zo().j6("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!af.j6(XL())) {
                    Zo().Zo().j6("AppMeasurementReceiver not registered/enabled");
                }
                if (!e.j6(XL())) {
                    Zo().Zo().j6("AppMeasurementService not registered/enabled");
                }
                Zo().Zo().j6("Uploading is not possible. App measurement disabled");
            }
            sG();
            return;
        }
        Zo().Zo().j6("Scheduler shutting down before Scion.start() called");
    }

    void FH(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        j6(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    public o Hw() {
        return this.Hw;
    }

    void Hw(AppMetadata appMetadata, long j) {
        j6(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    public AppMeasurement J0() {
        return this.tp;
    }

    public l J8() {
        j6(this.EQ);
        return this.EQ;
    }

    public void KD() {
        Map map = null;
        int i = 0;
        er();
        j6();
        if (!Hw().ef()) {
            Boolean BT = v5().BT();
            if (BT == null) {
                Zo().yS().j6("Upload data called on the client side before use of service was decided");
                return;
            } else if (BT.booleanValue()) {
                Zo().Zo().j6("Upload called in the client side when service should be used");
                return;
            }
        }
        if (cb()) {
            Zo().yS().j6("Uploading requested multiple times");
        } else if (QX().Zo()) {
            long j6 = aM().j6();
            j6(j6 - Hw().OW());
            long j62 = v5().FH.j6();
            if (j62 != 0) {
                Zo().P8().j6("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(j6 - j62)));
            }
            String vy = Ws().vy();
            if (TextUtils.isEmpty(vy)) {
                String DW = Ws().DW(j6 - Hw().OW());
                if (!TextUtils.isEmpty(DW)) {
                    a DW2 = Ws().DW(DW);
                    if (DW2 != null) {
                        String j63 = Hw().j6(DW2.Hw(), DW2.FH());
                        try {
                            URL url = new URL(j63);
                            Zo().ei().j6("Fetching remote configuration", DW2.DW());
                            hs.b j64 = tp().j6(DW2.DW());
                            CharSequence DW3 = tp().DW(DW2.DW());
                            if (!(j64 == null || TextUtils.isEmpty(DW3))) {
                                map = new l();
                                map.put("If-Modified-Since", DW3);
                            }
                            QX().j6(DW, url, map, new 3(this));
                            return;
                        } catch (MalformedURLException e) {
                            Zo().Zo().j6("Failed to parse config URL. Not fetching", j63);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            List<Pair> j65 = Ws().j6(vy, Hw().Hw(vy), Hw().v5(vy));
            if (!j65.isEmpty()) {
                e eVar;
                Object obj;
                List subList;
                for (Pair pair : j65) {
                    eVar = (e) pair.first;
                    if (!TextUtils.isEmpty(eVar.Mr)) {
                        obj = eVar.Mr;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i2 = 0; i2 < j65.size(); i2++) {
                        eVar = (e) ((Pair) j65.get(i2)).first;
                        if (!TextUtils.isEmpty(eVar.Mr) && !eVar.Mr.equals(obj)) {
                            subList = j65.subList(0, i2);
                            break;
                        }
                    }
                }
                subList = j65;
                d dVar = new d();
                dVar.j6 = new e[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < dVar.j6.length) {
                    dVar.j6[i] = (e) ((Pair) subList.get(i)).first;
                    arrayList.add((Long) ((Pair) subList.get(i)).second);
                    dVar.j6[i].j3 = Long.valueOf(Hw().sG());
                    dVar.j6[i].Hw = Long.valueOf(j6);
                    dVar.j6[i].gW = Boolean.valueOf(Hw().ef());
                    i++;
                }
                Object DW4 = Zo().j6(2) ? l.DW(dVar) : null;
                byte[] j66 = J8().j6(dVar);
                String lp = Hw().lp();
                try {
                    URL url2 = new URL(lp);
                    j6(arrayList);
                    v5().Hw.j6(j6);
                    Object obj2 = "?";
                    if (dVar.j6.length > 0) {
                        obj2 = dVar.j6[0].QX;
                    }
                    Zo().ei().j6("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(j66.length), DW4);
                    QX().j6(vy, url2, j66, null, new 2(this));
                } catch (MalformedURLException e2) {
                    Zo().Zo().j6("Failed to parse upload URL. Not uploading", lp);
                }
            }
        } else {
            Zo().yS().j6("Network not connected, ignoring upload request");
            sG();
        }
    }

    public r Mr() {
        DW(this.QX);
        return this.QX;
    }

    public boolean P8() {
        boolean z = false;
        er();
        j6();
        if (Hw().vJ()) {
            return false;
        }
        Boolean g3 = Hw().g3();
        if (g3 != null) {
            z = g3.booleanValue();
        } else if (!Hw().Mz()) {
            z = true;
        }
        return v5().FH(z);
    }

    public ab QX() {
        DW(this.J0);
        return this.J0;
    }

    void SI() {
        if (!Hw().ef()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public y U2() {
        DW(this.aM);
        return this.aM;
    }

    public aa VH() {
        return (this.Zo == null || !this.Zo.j6()) ? null : this.Zo;
    }

    public p Ws() {
        DW(this.we);
        return this.we;
    }

    public Context XL() {
        return this.FH;
    }

    public aa Zo() {
        DW(this.Zo);
        return this.Zo;
    }

    public ac a8() {
        if (this.j3 != null) {
            return this.j3;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public afq aM() {
        return this.J8;
    }

    void cn() {
        er();
        j6();
        if (!this.lg) {
            Zo().vy().j6("This instance being marked as an uploader");
            gW();
        }
        this.lg = true;
    }

    long ei() {
        return ((((aM().j6() + v5().yS()) / 1000) / 60) / 60) / 24;
    }

    public void er() {
        gn().tp();
    }

    void gW() {
        er();
        j6();
        if (sh() && BT()) {
            j6(j6(yS()), U2().gW());
        }
    }

    public ah gn() {
        DW(this.VH);
        return this.VH;
    }

    public d j3() {
        DW(this.Ws);
        return this.Ws;
    }

    int j6(FileChannel fileChannel) {
        int i = 0;
        er();
        if (fileChannel == null || !fileChannel.isOpen()) {
            Zo().Zo().j6("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read != 4) {
                    Zo().yS().j6("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                } else {
                    allocate.flip();
                    i = allocate.getInt();
                }
            } catch (IOException e) {
                Zo().Zo().j6("Failed to read from channel", e);
            }
        }
        return i;
    }

    void j6() {
        if (!this.a8) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void j6(AppMetadata appMetadata) {
        er();
        j6();
        com.google.android.gms.common.internal.b.j6(appMetadata.DW);
        FH(appMetadata);
    }

    void j6(AppMetadata appMetadata, long j) {
        a DW = Ws().DW(appMetadata.DW);
        if (!(DW == null || DW.Hw() == null || DW.Hw().equals(appMetadata.FH))) {
            Zo().yS().j6("New GMP App Id passed in. Removing cached database data.");
            Ws().VH(DW.DW());
            DW = null;
        }
        if (DW != null && DW.u7() != null && !DW.u7().equals(appMetadata.Hw)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", DW.u7());
            j6(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    void j6(EventParcel eventParcel, AppMetadata appMetadata) {
        long nanoTime = System.nanoTime();
        er();
        j6();
        String str = appMetadata.DW;
        com.google.android.gms.common.internal.b.j6(str);
        if (!TextUtils.isEmpty(appMetadata.FH)) {
            if (!appMetadata.u7) {
                FH(appMetadata);
            } else if (tp().DW(str, eventParcel.DW)) {
                Zo().yS().j6("Dropping blacklisted event", eventParcel.DW);
                J8().j6(11, "_ev", eventParcel.DW);
            } else {
                if (Zo().j6(2)) {
                    Zo().ei().j6("Logging event", eventParcel);
                }
                Ws().Zo();
                try {
                    Bundle DW = eventParcel.FH.DW();
                    FH(appMetadata);
                    if ("_iap".equals(eventParcel.DW) || "ecommerce_purchase".equals(eventParcel.DW)) {
                        long round;
                        Object string = DW.getString("currency");
                        if ("ecommerce_purchase".equals(eventParcel.DW)) {
                            double d = DW.getDouble("value") * 1000000.0d;
                            if (d == 0.0d) {
                                d = ((double) DW.getLong("value")) * 1000000.0d;
                            }
                            if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                                Zo().yS().j6("Data lost. Currency value is too big", Double.valueOf(d));
                                Ws().VH();
                                Ws().yS();
                                return;
                            }
                            round = Math.round(d);
                        } else {
                            round = DW.getLong("value");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String toUpperCase = string.toUpperCase(Locale.US);
                            if (toUpperCase.matches("[A-Z]{3}")) {
                                k kVar;
                                String valueOf = String.valueOf("_ltv_");
                                toUpperCase = String.valueOf(toUpperCase);
                                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                                k FH = Ws().FH(str, concat);
                                if (FH == null || !(FH.Hw instanceof Long)) {
                                    Ws().j6(str, Hw().FH(str) - 1);
                                    kVar = new k(str, concat, aM().j6(), Long.valueOf(round));
                                } else {
                                    kVar = new k(str, concat, aM().j6(), Long.valueOf(round + ((Long) FH.Hw).longValue()));
                                }
                                if (!Ws().j6(kVar)) {
                                    Zo().Zo().j6("Too many unique user properties are set. Ignoring user property.", kVar.DW, kVar.Hw);
                                    J8().j6(9, null, null);
                                }
                            }
                        }
                    }
                    boolean j6 = l.j6(eventParcel.DW);
                    l.j6(DW);
                    boolean equals = "_err".equals(eventParcel.DW);
                    com.google.android.gms.measurement.internal.p.a j62 = Ws().j6(ei(), str, j6, false, equals);
                    long vy = j62.DW - Hw().vy();
                    if (vy > 0) {
                        if (vy % 1000 == 1) {
                            Zo().Zo().j6("Data loss. Too many events logged. count", Long.valueOf(j62.DW));
                        }
                        J8().j6(16, "_ev", eventParcel.DW);
                        Ws().VH();
                        return;
                    }
                    t j63;
                    if (j6) {
                        vy = j62.j6 - Hw().P8();
                        if (vy > 0) {
                            if (vy % 1000 == 1) {
                                Zo().Zo().j6("Data loss. Too many public events logged. count", Long.valueOf(j62.j6));
                            }
                            J8().j6(16, "_ev", eventParcel.DW);
                            Ws().VH();
                            Ws().yS();
                            return;
                        }
                    }
                    if (equals) {
                        vy = j62.Hw - Hw().ei();
                        if (vy > 0) {
                            if (vy == 1) {
                                Zo().Zo().j6("Too many error events logged. count", Long.valueOf(j62.Hw));
                            }
                            Ws().VH();
                            Ws().yS();
                            return;
                        }
                    }
                    J8().j6(DW, "_o", eventParcel.Hw);
                    long FH2 = Ws().FH(str);
                    if (FH2 > 0) {
                        Zo().yS().j6("Data lost. Too many events stored on disk, deleted", Long.valueOf(FH2));
                    }
                    s sVar = new s(this, eventParcel.Hw, str, eventParcel.DW, eventParcel.v5, 0, DW);
                    t j64 = Ws().j6(str, sVar.DW);
                    if (j64 != null) {
                        sVar = sVar.j6(this, j64.v5);
                        j63 = j64.j6(sVar.Hw);
                    } else if (Ws().u7(str) >= ((long) Hw().BT())) {
                        Zo().Zo().j6("Too many event names used, ignoring event. name, supported count", sVar.DW, Integer.valueOf(Hw().BT()));
                        J8().j6(8, null, null);
                        Ws().yS();
                        return;
                    } else {
                        j63 = new t(str, sVar.DW, 0, 0, sVar.Hw);
                    }
                    Ws().j6(j63);
                    j6(sVar, appMetadata);
                    Ws().VH();
                    if (Zo().j6(2)) {
                        Zo().ei().j6("Event recorded", sVar);
                    }
                    Ws().yS();
                    sG();
                    Zo().ei().j6("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    Ws().yS();
                }
            }
        }
    }

    void j6(EventParcel eventParcel, String str) {
        a DW = Ws().DW(str);
        if (DW == null || TextUtils.isEmpty(DW.u7())) {
            Zo().P8().j6("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = XL().getPackageManager().getPackageInfo(str, 0).versionName;
            if (!(DW.u7() == null || DW.u7().equals(str2))) {
                Zo().yS().j6("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.DW)) {
                Zo().yS().j6("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        j6(eventParcel2, new AppMetadata(str, DW.Hw(), DW.u7(), DW.tp(), DW.EQ(), DW.we(), DW.J0(), null, DW.J8(), false, DW.Zo()));
    }

    void j6(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        er();
        j6();
        if (!TextUtils.isEmpty(appMetadata.FH)) {
            if (appMetadata.u7) {
                int FH = J8().FH(userAttributeParcel.DW);
                if (FH != 0) {
                    J8().j6(FH, "_ev", J8().j6(userAttributeParcel.DW, Hw().Hw(), true));
                    return;
                }
                FH = J8().FH(userAttributeParcel.DW, userAttributeParcel.j6());
                if (FH != 0) {
                    J8().j6(FH, "_ev", J8().j6(userAttributeParcel.DW, Hw().Hw(), true));
                    return;
                }
                Object Hw = J8().Hw(userAttributeParcel.DW, userAttributeParcel.j6());
                if (Hw != null) {
                    k kVar = new k(appMetadata.DW, userAttributeParcel.DW, userAttributeParcel.FH, Hw);
                    Zo().P8().j6("Setting user property", kVar.DW, Hw);
                    Ws().Zo();
                    try {
                        FH(appMetadata);
                        boolean j6 = Ws().j6(kVar);
                        Ws().VH();
                        if (j6) {
                            Zo().P8().j6("User property set", kVar.DW, kVar.Hw);
                        } else {
                            Zo().Zo().j6("Too many unique user properties are set. Ignoring user property.", kVar.DW, kVar.Hw);
                            J8().j6(9, null, null);
                        }
                        Ws().yS();
                        return;
                    } catch (Throwable th) {
                        Ws().yS();
                    }
                } else {
                    return;
                }
            }
            FH(appMetadata);
        }
    }

    void j6(b bVar) {
        this.BT++;
    }

    void j6(s sVar, AppMetadata appMetadata) {
        er();
        j6();
        com.google.android.gms.common.internal.b.j6((Object) sVar);
        com.google.android.gms.common.internal.b.j6((Object) appMetadata);
        com.google.android.gms.common.internal.b.j6(sVar.j6);
        com.google.android.gms.common.internal.b.DW(sVar.j6.equals(appMetadata.DW));
        e eVar = new e();
        eVar.j6 = Integer.valueOf(1);
        eVar.u7 = "android";
        eVar.QX = appMetadata.DW;
        eVar.Ws = appMetadata.v5;
        eVar.XL = appMetadata.Hw;
        eVar.P8 = Integer.valueOf((int) appMetadata.EQ);
        eVar.aM = Long.valueOf(appMetadata.Zo);
        eVar.yS = appMetadata.FH;
        eVar.lg = appMetadata.VH == 0 ? null : Long.valueOf(appMetadata.VH);
        Pair j6 = v5().j6(appMetadata.DW);
        if (j6 != null && !TextUtils.isEmpty((CharSequence) j6.first)) {
            eVar.Mr = (String) j6.first;
            eVar.U2 = (Boolean) j6.second;
        } else if (!Mr().j6(this.FH)) {
            String string = Secure.getString(this.FH.getContentResolver(), "android_id");
            if (string == null) {
                Zo().yS().j6("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                Zo().yS().j6("empty secure ID");
            }
            eVar.SI = string;
        }
        eVar.EQ = Mr().Zo();
        eVar.tp = Mr().VH();
        eVar.J0 = Integer.valueOf((int) Mr().yS());
        eVar.we = Mr().gW();
        eVar.j3 = null;
        eVar.Hw = null;
        eVar.v5 = null;
        eVar.Zo = null;
        a DW = Ws().DW(appMetadata.DW);
        if (DW == null) {
            DW = new a(this, appMetadata.DW);
            DW.j6(v5().Zo());
            DW.Hw(appMetadata.we);
            DW.DW(appMetadata.FH);
            DW.FH(v5().DW(appMetadata.DW));
            DW.Zo(0);
            DW.j6(0);
            DW.DW(0);
            DW.v5(appMetadata.Hw);
            DW.FH(appMetadata.EQ);
            DW.Zo(appMetadata.v5);
            DW.Hw(appMetadata.Zo);
            DW.v5(appMetadata.VH);
            DW.j6(appMetadata.u7);
            Ws().j6(DW);
        }
        eVar.a8 = DW.FH();
        eVar.vy = DW.Zo();
        List j62 = Ws().j6(appMetadata.DW);
        eVar.FH = new g[j62.size()];
        for (int i = 0; i < j62.size(); i++) {
            g gVar = new g();
            eVar.FH[i] = gVar;
            gVar.DW = ((k) j62.get(i)).DW;
            gVar.j6 = Long.valueOf(((k) j62.get(i)).FH);
            J8().j6(gVar, ((k) j62.get(i)).Hw);
        }
        try {
            Ws().j6(sVar, Ws().DW(eVar));
        } catch (IOException e) {
            Zo().Zo().j6("Data loss. Failed to insert raw event metadata", e);
        }
    }

    void j6(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        int i2 = 0;
        er();
        j6();
        com.google.android.gms.common.internal.b.j6(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        Ws().Zo();
        try {
            a DW = Ws().DW(str);
            int i3 = ((i == 200 || i == 204 || i == 304) && th == null) ? 1 : 0;
            if (DW == null) {
                Zo().yS().j6("App does not exist in onConfigFetched", str);
            } else if (i3 != 0 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (tp().j6(str) == null && !tp().j6(str, null, null)) {
                        Ws().yS();
                        return;
                    }
                } else if (!tp().j6(str, bArr, str2)) {
                    Ws().yS();
                    return;
                }
                DW.VH(aM().j6());
                Ws().j6(DW);
                if (i == 404) {
                    Zo().yS().j6("Config not found. Using empty config");
                } else {
                    Zo().ei().j6("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (QX().Zo() && dx()) {
                    KD();
                } else {
                    sG();
                }
            } else {
                DW.gn(aM().j6());
                Ws().j6(DW);
                Zo().ei().j6("Fetching config failed. code, error", Integer.valueOf(i), th);
                tp().FH(str);
                v5().Hw.j6(aM().j6());
                if (i == 503 || i == 429) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    v5().v5.j6(aM().j6());
                }
                sG();
            }
            Ws().VH();
        } finally {
            Ws().yS();
        }
    }

    public void j6(boolean z) {
        sG();
    }

    boolean j6(int i, int i2) {
        er();
        if (i > i2) {
            Zo().Zo().j6("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (j6(i2, yS())) {
                Zo().ei().j6("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                Zo().Zo().j6("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    boolean j6(int i, FileChannel fileChannel) {
        er();
        if (fileChannel == null || !fileChannel.isOpen()) {
            Zo().Zo().j6("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            Zo().Zo().j6("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            Zo().Zo().j6("Failed to write to channel", e);
            return false;
        }
    }

    boolean j6(long j) {
        return j6(null, j);
    }

    public i lg() {
        DW(this.Mr);
        return this.Mr;
    }

    void nw() {
        if (Hw().ef()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public n rN() {
        DW(this.U2);
        return this.U2;
    }

    void ro() {
        this.vy++;
    }

    boolean sh() {
        er();
        j6();
        return this.lg || vy();
    }

    public ag tp() {
        DW(this.u7);
        return this.u7;
    }

    public f u7() {
        DW(this.gn);
        return this.gn;
    }

    public ae v5() {
        j6(this.v5);
        return this.v5;
    }

    protected boolean vy() {
        return false;
    }

    public c we() {
        DW(this.XL);
        return this.XL;
    }

    FileChannel yS() {
        return this.yS;
    }
}
