package com.antutu.utils;

import android.content.Context;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.p047k.C1516b;

public class SpecialHelper {
    private static final String CPUID = "0x41-7-0x3-0xc09-0";
    private static final String CPU_INFO = "Dual-Core ARMv7 Processor (VFPv3, NEON)";
    private static final String GL_RENDER = "Mali-400 MP";
    private static final String STR2 = "NUFRONT-TL7689-PAD-706";

    public static int updateCoreNum() {
        return 0;
    }

    public static String updateFilterCoreNum(Context context, String str) {
        C1503b.m5915c().m5944e(context);
        return (CPUID.equals(C1503b.m5915c().m5961n()) && STR2.equals(str) && CPU_INFO.equals(C1503b.m5915c().m5952j()) && GL_RENDER.equals(C1516b.m6036j())) ? "2+2" : null;
    }
}
