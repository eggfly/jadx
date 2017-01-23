package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.a;
import com.google.android.gms.internal.eh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@eh
public class s {
    public static final s j6;

    static {
        j6 = new s();
    }

    protected s() {
    }

    public static s j6() {
        return j6;
    }

    public AdRequestParcel j6(Context context, e eVar) {
        Date j6 = eVar.j6();
        long time = j6 != null ? j6.getTime() : -1;
        String DW = eVar.DW();
        int FH = eVar.FH();
        Collection Hw = eVar.Hw();
        List unmodifiableList = !Hw.isEmpty() ? Collections.unmodifiableList(new ArrayList(Hw)) : null;
        boolean j62 = eVar.j6(context);
        int we = eVar.we();
        Location v5 = eVar.v5();
        Bundle j63 = eVar.j6(AdMobAdapter.class);
        boolean Zo = eVar.Zo();
        String VH = eVar.VH();
        a u7 = eVar.u7();
        SearchAdRequestParcel searchAdRequestParcel = u7 != null ? new SearchAdRequestParcel(u7) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = w.j6().j6(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, j63, FH, unmodifiableList, j62, we, Zo, VH, searchAdRequestParcel, v5, DW, eVar.EQ(), eVar.J0(), Collections.unmodifiableList(new ArrayList(eVar.J8())), eVar.gn(), str, eVar.Ws());
    }
}
