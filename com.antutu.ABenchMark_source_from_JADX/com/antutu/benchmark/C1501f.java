package com.antutu.benchmark;

import android.content.Context;
import android.util.SparseArray;
import com.antutu.ABenchMark.C1082R;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.f */
public class C1501f {
    SparseArray<String> f5112a;

    public C1501f(Context context) {
        this.f5112a = new SparseArray();
        this.f5112a.clear();
        this.f5112a.append(30, context.getString(C1082R.string.SID_RAM));
        this.f5112a.append(31, context.getString(C1082R.string.SID_CPU_MATH));
        this.f5112a.append(32, context.getString(C1082R.string.SID_CPU_APP));
        this.f5112a.append(33, context.getString(C1082R.string.SID_CPU_MULTI));
        this.f5112a.append(34, context.getString(C1082R.string.SID_UX_SEC));
        this.f5112a.append(35, context.getString(C1082R.string.SID_UX_DATA));
        this.f5112a.append(36, context.getString(C1082R.string.SID_UX_GAME));
        this.f5112a.append(37, context.getString(C1082R.string.SID_UX_IMG));
        this.f5112a.append(38, context.getString(C1082R.string.SID_UX_IO));
        this.f5112a.append(39, context.getString(C1082R.string.SID_3D_GARDEN));
        this.f5112a.append(40, context.getString(C1082R.string.SID_3D_MAROONED));
        this.f5112a.append(41, context.getString(C1082R.string.SID_ALL));
    }

    public String m5905a(int i) {
        return this.f5112a == null ? BuildConfig.FLAVOR : (String) this.f5112a.get(i, BuildConfig.FLAVOR);
    }
}
