package com.google.android.gms.measurement.internal;

import age;
import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.measurement.internal.x.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class aj extends a {
    private final boolean DW;
    private final ai j6;

    class 1 implements Runnable {
        final /* synthetic */ aj DW;
        final /* synthetic */ AppMetadata j6;

        1(aj ajVar, AppMetadata appMetadata) {
            this.DW = ajVar;
            this.j6 = appMetadata;
        }

        public void run() {
            this.DW.j6.cn();
            this.DW.j6(this.j6.gn);
            this.DW.j6.j6(this.j6);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ EventParcel DW;
        final /* synthetic */ aj FH;
        final /* synthetic */ AppMetadata j6;

        2(aj ajVar, AppMetadata appMetadata, EventParcel eventParcel) {
            this.FH = ajVar;
            this.j6 = appMetadata;
            this.DW = eventParcel;
        }

        public void run() {
            this.FH.j6.cn();
            this.FH.j6(this.j6.gn);
            this.FH.j6.j6(this.DW, this.j6);
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ EventParcel DW;
        final /* synthetic */ String FH;
        final /* synthetic */ aj Hw;
        final /* synthetic */ String j6;

        3(aj ajVar, String str, EventParcel eventParcel, String str2) {
            this.Hw = ajVar;
            this.j6 = str;
            this.DW = eventParcel;
            this.FH = str2;
        }

        public void run() {
            this.Hw.j6.cn();
            this.Hw.j6(this.j6);
            this.Hw.j6.j6(this.DW, this.FH);
        }
    }

    class 4 implements Callable<byte[]> {
        final /* synthetic */ String DW;
        final /* synthetic */ aj FH;
        final /* synthetic */ EventParcel j6;

        4(aj ajVar, EventParcel eventParcel, String str) {
            this.FH = ajVar;
            this.j6 = eventParcel;
            this.DW = str;
        }

        public /* synthetic */ Object call() {
            return j6();
        }

        public byte[] j6() {
            this.FH.j6.cn();
            return this.FH.j6.DW(this.j6, this.DW);
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ UserAttributeParcel DW;
        final /* synthetic */ aj FH;
        final /* synthetic */ AppMetadata j6;

        5(aj ajVar, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
            this.FH = ajVar;
            this.j6 = appMetadata;
            this.DW = userAttributeParcel;
        }

        public void run() {
            this.FH.j6.cn();
            this.FH.j6(this.j6.gn);
            this.FH.j6.DW(this.DW, this.j6);
        }
    }

    class 6 implements Runnable {
        final /* synthetic */ UserAttributeParcel DW;
        final /* synthetic */ aj FH;
        final /* synthetic */ AppMetadata j6;

        6(aj ajVar, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
            this.FH = ajVar;
            this.j6 = appMetadata;
            this.DW = userAttributeParcel;
        }

        public void run() {
            this.FH.j6.cn();
            this.FH.j6(this.j6.gn);
            this.FH.j6.j6(this.DW, this.j6);
        }
    }

    class 7 implements Callable<List<k>> {
        final /* synthetic */ aj DW;
        final /* synthetic */ AppMetadata j6;

        7(aj ajVar, AppMetadata appMetadata) {
            this.DW = ajVar;
            this.j6 = appMetadata;
        }

        public /* synthetic */ Object call() {
            return j6();
        }

        public List<k> j6() {
            this.DW.j6.cn();
            return this.DW.j6.Ws().j6(this.j6.DW);
        }
    }

    class 8 implements Runnable {
        final /* synthetic */ aj DW;
        final /* synthetic */ AppMetadata j6;

        8(aj ajVar, AppMetadata appMetadata) {
            this.DW = ajVar;
            this.j6 = appMetadata;
        }

        public void run() {
            this.DW.j6.cn();
            this.DW.j6(this.j6.gn);
            this.DW.j6.DW(this.j6);
        }
    }

    public aj(ai aiVar) {
        b.j6((Object) aiVar);
        this.j6 = aiVar;
        this.DW = false;
    }

    public aj(ai aiVar, boolean z) {
        b.j6((Object) aiVar);
        this.j6 = aiVar;
        this.DW = z;
    }

    private void FH(AppMetadata appMetadata) {
        b.j6((Object) appMetadata);
        FH(appMetadata.DW);
        this.j6.J8().Zo(appMetadata.FH);
    }

    private void FH(String str) {
        if (TextUtils.isEmpty(str)) {
            this.j6.Zo().Zo().j6("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            DW(str);
        } catch (SecurityException e) {
            this.j6.Zo().Zo().j6("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    public void DW(AppMetadata appMetadata) {
        FH(appMetadata);
        this.j6.gn().j6(new 1(this, appMetadata));
    }

    protected void DW(String str) {
        int myUid = this.DW ? Process.myUid() : Binder.getCallingUid();
        if (!age.j6(this.j6.XL(), myUid, str)) {
            if (!age.j6(this.j6.XL(), myUid) || this.j6.vy()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }

    public List<UserAttributeParcel> j6(AppMetadata appMetadata, boolean z) {
        Object e;
        FH(appMetadata);
        try {
            List<k> list = (List) this.j6.gn().j6(new 7(this, appMetadata)).get();
            List<UserAttributeParcel> arrayList = new ArrayList(list.size());
            for (k kVar : list) {
                if (z || !l.tp(kVar.DW)) {
                    arrayList.add(new UserAttributeParcel(kVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.j6.Zo().Zo().j6("Failed to get user attributes", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.j6.Zo().Zo().j6("Failed to get user attributes", e);
            return null;
        }
    }

    public void j6(AppMetadata appMetadata) {
        FH(appMetadata);
        this.j6.gn().j6(new 8(this, appMetadata));
    }

    public void j6(EventParcel eventParcel, AppMetadata appMetadata) {
        b.j6((Object) eventParcel);
        FH(appMetadata);
        this.j6.gn().j6(new 2(this, appMetadata, eventParcel));
    }

    public void j6(EventParcel eventParcel, String str, String str2) {
        b.j6((Object) eventParcel);
        b.j6(str);
        FH(str);
        this.j6.gn().j6(new 3(this, str2, eventParcel, str));
    }

    public void j6(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        b.j6((Object) userAttributeParcel);
        FH(appMetadata);
        if (userAttributeParcel.j6() == null) {
            this.j6.gn().j6(new 5(this, appMetadata, userAttributeParcel));
        } else {
            this.j6.gn().j6(new 6(this, appMetadata, userAttributeParcel));
        }
    }

    void j6(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.j6.v5().DW.j6(split[1], longValue);
                    } else {
                        this.j6.Zo().yS().j6("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.j6.Zo().yS().j6("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    public byte[] j6(EventParcel eventParcel, String str) {
        Object e;
        b.j6(str);
        b.j6((Object) eventParcel);
        FH(str);
        this.j6.Zo().P8().j6("Log and bundle. event", eventParcel.DW);
        long FH = this.j6.aM().FH() / 1000000;
        try {
            byte[] bArr = (byte[]) this.j6.gn().DW(new 4(this, eventParcel, str)).get();
            if (bArr == null) {
                this.j6.Zo().Zo().j6("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.j6.Zo().P8().j6("Log and bundle processed. event, size, time_ms", eventParcel.DW, Integer.valueOf(bArr.length), Long.valueOf((this.j6.aM().FH() / 1000000) - FH));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.j6.Zo().Zo().j6("Failed to log and bundle. event, error", eventParcel.DW, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.j6.Zo().Zo().j6("Failed to log and bundle. event, error", eventParcel.DW, e);
            return null;
        }
    }
}
