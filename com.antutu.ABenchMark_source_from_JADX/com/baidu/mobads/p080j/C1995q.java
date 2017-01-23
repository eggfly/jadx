package com.baidu.mobads.p080j;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.baidu.mobads.j.q */
class C1995q implements Comparator<ScanResult> {
    final /* synthetic */ C1992n f6971a;

    C1995q(C1992n c1992n) {
        this.f6971a = c1992n;
    }

    public int m7473a(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7473a((ScanResult) obj, (ScanResult) obj2);
    }
}
