package com.antutu.benchmark;

import android.content.Context;
import android.util.SparseArray;
import com.antutu.ABenchMark.C1082R;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.g */
public class C1506g {
    SparseArray<String> f5170a;

    public C1506g(Context context) {
        this.f5170a = new SparseArray();
        this.f5170a.clear();
        this.f5170a.append(3, context.getString(C1082R.string.BID_FFT));
        this.f5170a.append(4, context.getString(C1082R.string.BID_GEMM));
        this.f5170a.append(5, context.getString(C1082R.string.BID_MAP));
        this.f5170a.append(1, context.getString(C1082R.string.BID_RAM_Speed));
        this.f5170a.append(2, context.getString(C1082R.string.BID_RAM_Access));
        this.f5170a.append(7, context.getString(C1082R.string.BID_PNG_Decode));
        this.f5170a.append(8, context.getString(C1082R.string.BID_2D_Physics));
        this.f5170a.append(6, context.getString(C1082R.string.BID_HASH));
        this.f5170a.append(12, context.getString(C1082R.string.BID_Storage));
        this.f5170a.append(10, context.getString(C1082R.string.BID_MultiThread));
        this.f5170a.append(11, context.getString(C1082R.string.BID_MultiTask));
        this.f5170a.append(20, context.getString(C1082R.string.BID_IMG_Decode));
        this.f5170a.append(21, context.getString(C1082R.string.BID_IMG_Fisheye));
        this.f5170a.append(22, context.getString(C1082R.string.BID_IMG_Blur));
        this.f5170a.append(16, context.getString(C1082R.string.BID_Secure));
        this.f5170a.append(17, context.getString(C1082R.string.BID_ChineseChess));
        this.f5170a.append(18, context.getString(C1082R.string.BID_Chess));
        this.f5170a.append(19, context.getString(C1082R.string.BID_Gobang));
        this.f5170a.append(13, context.getString(C1082R.string.BID_Database));
        this.f5170a.append(14, context.getString(C1082R.string.BID_XML));
        this.f5170a.append(15, context.getString(C1082R.string.BID_Json));
        this.f5170a.append(9, context.getString(C1082R.string.BID_3D_Physics));
        this.f5170a.append(23, context.getString(C1082R.string.BID_3D_Garden));
        this.f5170a.append(24, context.getString(C1082R.string.BID_3D_Marooned));
        this.f5170a.append(25, context.getString(C1082R.string.BID_RandomIO));
    }

    public String m5989a(int i) {
        try {
            return this.f5170a == null ? BuildConfig.FLAVOR : (String) this.f5170a.get(i, BuildConfig.FLAVOR);
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }
}
