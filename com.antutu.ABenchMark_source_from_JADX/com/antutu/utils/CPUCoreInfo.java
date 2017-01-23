package com.antutu.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CPUCoreInfo {
    int coreNum;
    private List<CpuItem> cpuInfo;
    CPULoad mCpuLoad;
    private CpuItem mTotalItem;
    RandomAccessFile statFile;
    String[] strs;

    /* renamed from: com.antutu.utils.CPUCoreInfo.1 */
    class C17901 implements FileFilter {
        C17901() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[\\d+]", file.getName());
        }
    }

    public static class CpuItem {
        public String[] array;
        public boolean isNull;
        public String last;
        public int lastFrequency;
        public long lastIdle_temp;
        public long lastTotal_temp;
        public String pre;
        public int usage_temp;

        public CpuItem() {
            this.isNull = false;
        }
    }

    public CPUCoreInfo() {
        int i = 0;
        this.coreNum = 0;
        this.mCpuLoad = null;
        this.mTotalItem = null;
        this.cpuInfo = new ArrayList();
        this.strs = null;
        this.cpuInfo.clear();
        this.coreNum = getNumCores();
        this.strs = new String[this.coreNum];
        while (i < this.coreNum) {
            this.strs[i] = "cpu" + String.valueOf(i);
            this.cpuInfo.add(new CpuItem());
            i++;
        }
    }

    private int getNumCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C17901()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    public int getCPUCurrentFrequency(int i) {
        try {
            return Utils.readSystemFileAsInt("/sys/devices/system/cpu/cpu" + String.valueOf(i) + "/cpufreq/scaling_cur_freq");
        } catch (Exception e) {
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.antutu.utils.CPUCoreInfo.CpuItem> getInfo() {
        /*
        r15 = this;
        r0 = new com.antutu.utils.CPULoad;	 Catch:{ Exception -> 0x0163 }
        r0.<init>();	 Catch:{ Exception -> 0x0163 }
        r15.mCpuLoad = r0;	 Catch:{ Exception -> 0x0163 }
        r0 = r15.coreNum;	 Catch:{ Exception -> 0x0163 }
        r2 = new int[r0];	 Catch:{ Exception -> 0x0163 }
        r0 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0163 }
        r1 = "/proc/stat";
        r3 = "r";
        r0.<init>(r1, r3);	 Catch:{ Exception -> 0x0163 }
        r15.statFile = r0;	 Catch:{ Exception -> 0x0163 }
        r0 = r15.statFile;	 Catch:{ Exception -> 0x0163 }
        r4 = 0;
        r0.seek(r4);	 Catch:{ Exception -> 0x0163 }
        r0 = 0;
    L_0x001e:
        r1 = r15.coreNum;	 Catch:{ Exception -> 0x0163 }
        if (r0 < r1) goto L_0x0045;
    L_0x0022:
        r0 = r15.mCpuLoad;	 Catch:{ Exception -> 0x0163 }
        if (r0 == 0) goto L_0x002b;
    L_0x0026:
        r0 = r15.mCpuLoad;	 Catch:{ Exception -> 0x0163 }
        r0.getUsage();	 Catch:{ Exception -> 0x0163 }
    L_0x002b:
        r0 = 0;
        r1 = r0;
    L_0x002d:
        r0 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r0 = r0.size();	 Catch:{ Exception -> 0x0163 }
        if (r1 >= r0) goto L_0x004e;
    L_0x0035:
        r0 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x0163 }
        r0 = (com.antutu.utils.CPUCoreInfo.CpuItem) r0;	 Catch:{ Exception -> 0x0163 }
        r3 = r2[r1];	 Catch:{ Exception -> 0x0163 }
        r0.lastFrequency = r3;	 Catch:{ Exception -> 0x0163 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x002d;
    L_0x0045:
        r1 = r15.getCPUCurrentFrequency(r0);	 Catch:{ Exception -> 0x0163 }
        r2[r0] = r1;	 Catch:{ Exception -> 0x0163 }
        r0 = r0 + 1;
        goto L_0x001e;
    L_0x004e:
        r0 = 0;
        r1 = r0;
    L_0x0050:
        r0 = r15.statFile;	 Catch:{ Exception -> 0x0163 }
        r0 = r0.readLine();	 Catch:{ Exception -> 0x0163 }
        if (r0 == 0) goto L_0x0164;
    L_0x0058:
        r10 = new com.antutu.utils.CPUCoreInfo$CpuItem;	 Catch:{ Exception -> 0x0163 }
        r10.<init>();	 Catch:{ Exception -> 0x0163 }
        r2 = "[ ]+";
        r0 = r0.split(r2);	 Catch:{ Exception -> 0x0163 }
        r10.array = r0;	 Catch:{ Exception -> 0x0163 }
        r0 = r10.array;	 Catch:{ Exception -> 0x0163 }
        r2 = 0;
        r0 = r0[r2];	 Catch:{ Exception -> 0x0163 }
        r2 = "cpu";
        r0 = r0.contains(r2);	 Catch:{ Exception -> 0x0163 }
        if (r0 != 0) goto L_0x008f;
    L_0x0072:
        r0 = r1 + 1;
        r1 = r0;
    L_0x0075:
        r0 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r0 = r0.size();	 Catch:{ Exception -> 0x0163 }
        if (r1 >= r0) goto L_0x008c;
    L_0x007d:
        r0 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x0163 }
        r0 = (com.antutu.utils.CPUCoreInfo.CpuItem) r0;	 Catch:{ Exception -> 0x0163 }
        r2 = 1;
        r0.isNull = r2;	 Catch:{ Exception -> 0x0163 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0075;
    L_0x008c:
        r0 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
    L_0x008e:
        return r0;
    L_0x008f:
        r0 = r10.array;	 Catch:{ Exception -> 0x0163 }
        r2 = 4;
        r0 = r0[r2];	 Catch:{ Exception -> 0x0163 }
        r2 = 10;
        r6 = java.lang.Long.parseLong(r0, r2);	 Catch:{ Exception -> 0x0163 }
        r4 = 0;
        r2 = 1;
        r8 = r10.array;	 Catch:{ Exception -> 0x0163 }
        r9 = r8.length;	 Catch:{ Exception -> 0x0163 }
        r0 = 0;
        r14 = r0;
        r0 = r2;
        r2 = r4;
        r4 = r14;
    L_0x00a5:
        if (r4 >= r9) goto L_0x00b7;
    L_0x00a7:
        r5 = r8[r4];	 Catch:{ Exception -> 0x0163 }
        if (r0 == 0) goto L_0x00af;
    L_0x00ab:
        r0 = 0;
    L_0x00ac:
        r4 = r4 + 1;
        goto L_0x00a5;
    L_0x00af:
        r11 = 10;
        r12 = java.lang.Long.parseLong(r5, r11);	 Catch:{ Exception -> 0x0163 }
        r2 = r2 + r12;
        goto L_0x00ac;
    L_0x00b7:
        r0 = r10.array;	 Catch:{ Exception -> 0x0163 }
        r4 = 0;
        r0 = r0[r4];	 Catch:{ Exception -> 0x0163 }
        r4 = "cpu";
        r0 = r0.equals(r4);	 Catch:{ Exception -> 0x0163 }
        if (r0 == 0) goto L_0x00e8;
    L_0x00c4:
        r0 = r15.mTotalItem;	 Catch:{ Exception -> 0x0163 }
        if (r0 != 0) goto L_0x0140;
    L_0x00c8:
        r0 = new com.antutu.utils.CPUCoreInfo$CpuItem;	 Catch:{ Exception -> 0x0163 }
        r0.<init>();	 Catch:{ Exception -> 0x0163 }
        r15.mTotalItem = r0;	 Catch:{ Exception -> 0x0163 }
        r4 = r2;
        r8 = r6;
    L_0x00d1:
        r8 = r4 - r8;
        r0 = (float) r8;	 Catch:{ Exception -> 0x0163 }
        r4 = (float) r4;	 Catch:{ Exception -> 0x0163 }
        r0 = r0 / r4;
        r4 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r0 = r0 * r4;
        r0 = (int) r0;	 Catch:{ Exception -> 0x0163 }
        if (r0 <= 0) goto L_0x00e0;
    L_0x00dc:
        r4 = r15.mTotalItem;	 Catch:{ Exception -> 0x0163 }
        r4.usage_temp = r0;	 Catch:{ Exception -> 0x0163 }
    L_0x00e0:
        r0 = r15.mTotalItem;	 Catch:{ Exception -> 0x0163 }
        r0.lastTotal_temp = r2;	 Catch:{ Exception -> 0x0163 }
        r0 = r15.mTotalItem;	 Catch:{ Exception -> 0x0163 }
        r0.lastIdle_temp = r6;	 Catch:{ Exception -> 0x0163 }
    L_0x00e8:
        r0 = 0;
        r14 = r0;
        r0 = r1;
        r1 = r14;
    L_0x00ec:
        r4 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r4 = r4.size();	 Catch:{ Exception -> 0x0163 }
        if (r1 >= r4) goto L_0x0168;
    L_0x00f4:
        r4 = r10.array;	 Catch:{ Exception -> 0x0163 }
        r5 = 0;
        r4 = r4[r5];	 Catch:{ Exception -> 0x0163 }
        r5 = r15.strs;	 Catch:{ Exception -> 0x0163 }
        r5 = r5[r1];	 Catch:{ Exception -> 0x0163 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0163 }
        if (r4 == 0) goto L_0x013d;
    L_0x0103:
        r4 = 0;
        r0 = r15.cpuInfo;	 Catch:{ Exception -> 0x014d }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x014d }
        r0 = (com.antutu.utils.CPUCoreInfo.CpuItem) r0;	 Catch:{ Exception -> 0x014d }
        r4 = r0.lastFrequency;	 Catch:{ Exception -> 0x014d }
        r5 = r0.isNull;	 Catch:{ Exception -> 0x014d }
        if (r5 == 0) goto L_0x0113;
    L_0x0112:
        r0 = 0;
    L_0x0113:
        if (r0 != 0) goto L_0x0154;
    L_0x0115:
        r0 = new com.antutu.utils.CPUCoreInfo$CpuItem;	 Catch:{ Exception -> 0x0163 }
        r0.<init>();	 Catch:{ Exception -> 0x0163 }
        r0.lastFrequency = r4;	 Catch:{ Exception -> 0x0163 }
        r4 = r6;
        r8 = r2;
    L_0x011e:
        r4 = r8 - r4;
        r4 = (float) r4;	 Catch:{ Exception -> 0x0163 }
        r5 = (float) r8;	 Catch:{ Exception -> 0x0163 }
        r4 = r4 / r5;
        r5 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r4 = r4 * r5;
        r4 = (int) r4;	 Catch:{ Exception -> 0x0163 }
        if (r4 <= 0) goto L_0x012b;
    L_0x0129:
        r0.usage_temp = r4;	 Catch:{ Exception -> 0x0163 }
    L_0x012b:
        r0.lastTotal_temp = r2;	 Catch:{ Exception -> 0x0163 }
        r0.lastIdle_temp = r6;	 Catch:{ Exception -> 0x0163 }
        r4 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r4 = r4.size();	 Catch:{ Exception -> 0x0163 }
        if (r4 != r1) goto L_0x015d;
    L_0x0137:
        r4 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r4.add(r0);	 Catch:{ Exception -> 0x0163 }
    L_0x013c:
        r0 = r1;
    L_0x013d:
        r1 = r1 + 1;
        goto L_0x00ec;
    L_0x0140:
        r0 = r15.mTotalItem;	 Catch:{ Exception -> 0x0163 }
        r4 = r0.lastIdle_temp;	 Catch:{ Exception -> 0x0163 }
        r8 = r6 - r4;
        r0 = r15.mTotalItem;	 Catch:{ Exception -> 0x0163 }
        r4 = r0.lastTotal_temp;	 Catch:{ Exception -> 0x0163 }
        r4 = r2 - r4;
        goto L_0x00d1;
    L_0x014d:
        r0 = move-exception;
        r0 = r4;
        r4 = 0;
        r14 = r0;
        r0 = r4;
        r4 = r14;
        goto L_0x0113;
    L_0x0154:
        r4 = r0.lastIdle_temp;	 Catch:{ Exception -> 0x0163 }
        r4 = r6 - r4;
        r8 = r0.lastTotal_temp;	 Catch:{ Exception -> 0x0163 }
        r8 = r2 - r8;
        goto L_0x011e;
    L_0x015d:
        r4 = r15.cpuInfo;	 Catch:{ Exception -> 0x0163 }
        r4.set(r1, r0);	 Catch:{ Exception -> 0x0163 }
        goto L_0x013c;
    L_0x0163:
        r0 = move-exception;
    L_0x0164:
        r0 = r15.cpuInfo;
        goto L_0x008e;
    L_0x0168:
        r1 = r0;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.CPUCoreInfo.getInfo():java.util.List<com.antutu.utils.CPUCoreInfo$CpuItem>");
    }

    public int getTotalUse() {
        return this.mTotalItem != null ? this.mTotalItem.usage_temp : 0;
    }
}
