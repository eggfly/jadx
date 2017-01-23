package com.antutu.benchmark;

import android.util.SparseArray;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.h */
public class C1511h {
    SparseArray<String> f5184a;

    public C1511h() {
        this.f5184a = new SparseArray();
        this.f5184a.clear();
        this.f5184a.append(30, "SID_RAM");
        this.f5184a.append(31, "SID_CPU_MATH");
        this.f5184a.append(32, "SID_CPU_APP");
        this.f5184a.append(33, "SID_CPU_MULTI");
        this.f5184a.append(34, "SID_UX_SEC");
        this.f5184a.append(35, "SID_UX_DATA");
        this.f5184a.append(36, "SID_UX_GAME");
        this.f5184a.append(37, "SID_UX_IMG");
        this.f5184a.append(38, "SID_UX_IO");
        this.f5184a.append(39, "SID_3D_GARDEN");
        this.f5184a.append(40, "SID_3D_MAROONED");
        this.f5184a.append(3, "BID_FFT");
        this.f5184a.append(4, "BID_GEMM");
        this.f5184a.append(5, "BID_MAP");
        this.f5184a.append(1, "BID_RAM_Speed");
        this.f5184a.append(2, "BID_RAM_Access");
        this.f5184a.append(7, "BID_PNG_Decode");
        this.f5184a.append(8, "BID_2D_Physics");
        this.f5184a.append(6, "BID_HASH");
        this.f5184a.append(12, "BID_Storage");
        this.f5184a.append(10, "BID_MultiThread");
        this.f5184a.append(11, "BID_MultiTask");
        this.f5184a.append(20, "BID_IMG_Decode");
        this.f5184a.append(21, "BID_IMG_Fisheye");
        this.f5184a.append(22, "BID_IMG_Blur");
        this.f5184a.append(16, "BID_Secure");
        this.f5184a.append(17, "BID_ChineseChess");
        this.f5184a.append(18, "BID_Chess");
        this.f5184a.append(19, "BID_Gobang");
        this.f5184a.append(13, "BID_Database");
        this.f5184a.append(14, "BID_XML");
        this.f5184a.append(15, "BID_Json");
        this.f5184a.append(9, "BID_3D_Physics");
        this.f5184a.append(23, "BID_3D_Garden");
        this.f5184a.append(24, "BID_3D_Marooned");
        this.f5184a.append(25, "BID_RandomIO");
    }

    public String m5995a(int i) {
        return this.f5184a == null ? BuildConfig.FLAVOR : (String) this.f5184a.get(i, BuildConfig.FLAVOR);
    }
}
