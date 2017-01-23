package com.baidu.mobads.p080j;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.baidu.mobads.j.p */
class C1994p implements Comparator<ScanResult> {
    final /* synthetic */ C1992n f6970a;

    C1994p(C1992n c1992n) {
        this.f6970a = c1992n;
    }

    public int m7472a(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7472a((ScanResult) obj, (ScanResult) obj2);
    }
}
