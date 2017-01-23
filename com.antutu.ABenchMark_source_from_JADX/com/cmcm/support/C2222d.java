package com.cmcm.support;

import android.util.Log;
import com.cmcm.support.C2239j.C2238a;
import com.cmcm.support.jni.C2240i;
import com.cmcm.support.p116a.C2190c;
import com.cmcm.support.p116a.C2193f;
import com.cmcm.support.p117b.C2202c;
import com.cmcm.support.p117b.C2203d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.cmcm.support.d */
public class C2222d {
    static Pattern f7659a;
    private static boolean f7660c;
    private C2203d f7661b;

    static {
        f7660c = false;
        f7659a = Pattern.compile(".*_(\\d+).ich");
    }

    public C2222d() {
        this.f7661b = new C2203d();
    }

    private int m8353a(String str, File[] fileArr, int i, int i2, C2193f c2193f, C2239j c2239j, String str2) {
        byte[] a = C2246o.m8500a(str2);
        if (C2222d.m8360a(a)) {
            return -2;
        }
        C2222d.m8356a(" * ENCODED HEADER : " + a.length + " LIMIT=" + 9000);
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = 9000 - a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        int i3 = 0;
        int i4 = length;
        for (File file : fileArr) {
            if (i4 <= 0) {
                C2222d.m8356a(" * REACH LIMITAIONS @BREAK");
                break;
            }
            byte[] a2;
            if (file.isFile()) {
                if (C2222d.m8357a(C2222d.m8363b(file.getName()), i2)) {
                    file.delete();
                    C2222d.m8356a(" * IS EXPIRED : " + file.getName());
                } else {
                    a2 = m8366a(file, i4);
                    if (C2222d.m8360a(a2)) {
                        C2222d.m8356a(" * EMPTY DATA : " + file.getName());
                    } else {
                        i4 -= a2.length;
                        i3 += a2.length;
                        allocate.put(a2);
                        arrayList.add(file);
                        arrayList2.add(Integer.valueOf(a2.length));
                        if (c2193f != null) {
                            c2193f.m8251a(true, "ich_cache", file.getName());
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            C2222d.m8356a(" * NO ICHS NEED REPORT");
            return 0;
        }
        allocate.rewind();
        a2 = new byte[i3];
        allocate.get(a2);
        int size = arrayList.size() + 1;
        int[] iArr = new int[arrayList2.size()];
        for (i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = ((Integer) arrayList2.get(i4)).intValue();
        }
        if (!m8358a(str, m8362a(a, a2, size, i), size, iArr, a.length, c2239j)) {
            return -1;
        }
        C2222d.m8359a(arrayList);
        C2222d.m8356a(" * REPORT SUCCESS : DC+H=" + size + " DC=" + arrayList.size() + " SIZE=" + (a.length + a2.length));
        C2222d.m8355a(2000);
        return 0;
    }

    private int m8354a(String str, File[] fileArr, String str2, String str3, int i, String str4, int i2, C2193f c2193f, C2239j c2239j) {
        byte[] a = C2246o.m8501a(str2, str3, i, str4);
        if (C2222d.m8360a(a)) {
            return -2;
        }
        C2222d.m8356a(" * ENCODED HEADER : " + a.length + " LIMIT=" + 9000);
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = 9000 - a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        int i3 = 0;
        int i4 = length;
        for (File file : fileArr) {
            if (i4 <= 0) {
                C2222d.m8356a(" * REACH LIMITAIONS @BREAK");
                break;
            }
            byte[] a2;
            if (file.isFile()) {
                if (C2222d.m8357a(C2222d.m8363b(file.getName()), i2)) {
                    file.delete();
                    C2222d.m8356a(" * IS EXPIRED : " + file.getName());
                } else {
                    a2 = m8366a(file, i4);
                    if (C2222d.m8360a(a2)) {
                        C2222d.m8356a(" * EMPTY DATA : " + file.getName());
                    } else {
                        i4 -= a2.length;
                        i3 += a2.length;
                        allocate.put(a2);
                        arrayList.add(file);
                        arrayList2.add(Integer.valueOf(a2.length));
                        if (c2193f != null) {
                            c2193f.m8251a(true, "ich_cache", file.getName());
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            C2222d.m8356a(" * NO ICHS NEED REPORT");
            return 0;
        }
        allocate.rewind();
        a2 = new byte[i3];
        allocate.get(a2);
        int size = arrayList.size() + 1;
        int[] iArr = new int[arrayList2.size()];
        for (i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = ((Integer) arrayList2.get(i4)).intValue();
        }
        if (!m8358a(str, m8362a(a, a2, size, i), size, iArr, a.length, c2239j)) {
            return -1;
        }
        C2222d.m8359a(arrayList);
        C2222d.m8356a(" * REPORT SUCCESS : DC+H=" + size + " DC=" + arrayList.size() + " SIZE=" + (a.length + a2.length));
        C2222d.m8355a(2000);
        return 0;
    }

    public static void m8355a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m8356a(String str) {
        if (f7660c) {
            Log.d("KSupport", str);
        }
    }

    public static boolean m8357a(long j, int i) {
        return j <= 0 || C2246o.m8495a(j) >= ((long) i);
    }

    private boolean m8358a(String str, byte[] bArr, int i, int[] iArr, int i2, C2239j c2239j) {
        if (this.f7661b == null || bArr == null || iArr == null) {
            return false;
        }
        C2238a a = c2239j.m8457a();
        byte[] c2 = C2240i.c2(bArr, (int) a.m8453a(), a.m8456b(), i2, iArr);
        if (c2 == null) {
            return false;
        }
        C2202c c2202c = new C2202c();
        c2202c.m8271a(bArr);
        c2202c.m8273b(c2);
        c2202c.m8272b("batchdata_table_" + String.valueOf(i));
        return this.f7661b.m8278a(c2202c, str, null);
    }

    public static boolean m8359a(List<File> list) {
        if (list == null) {
            return true;
        }
        int i = 0;
        for (File delete : list) {
            i = delete.delete() ? i + 1 : i;
        }
        return i == list.size();
    }

    public static boolean m8360a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] m8361a(byte[] bArr, byte[] bArr2) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + bArr2.length);
        allocate.put(bArr);
        allocate.put(bArr2);
        return allocate.array();
    }

    private byte[] m8362a(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] a = C2222d.m8361a(bArr, bArr2);
        return C2240i.m8461d(a, a.length, i, i2);
    }

    public static long m8363b(String str) {
        long j = 0;
        try {
            Matcher matcher = f7659a.matcher(str);
            if (matcher.matches()) {
                j = Long.parseLong(matcher.group(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    private static boolean m8364c(String str) {
        return !str.startsWith("kav_event");
    }

    public int m8365a(String str, File[] fileArr, String str2, String str3, int i, String str4, int i2, C2193f c2193f, C2239j c2239j, String str5) {
        if (str == null || fileArr == null || fileArr.length == 0 || str3 == null || -1 == i || str4 == null || str5 == null) {
            return -2;
        }
        File[] fileArr2;
        int i3 = 0;
        int i4 = 0;
        int length = fileArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6;
            if (C2222d.m8364c(fileArr[i5].getName())) {
                i3++;
                i6 = i4;
            } else {
                i6 = i4 + 1;
            }
            i5++;
            i4 = i6;
        }
        if (i3 > 0) {
            fileArr2 = new File[i3];
            i6 = 0;
            for (File file : fileArr) {
                if (C2222d.m8364c(file.getName())) {
                    fileArr2[i6] = file;
                    i6++;
                }
            }
            i6 = m8354a(str, fileArr2, str2, str3, i, str4, i2, c2193f, c2239j);
        } else {
            i6 = 0;
        }
        if (i4 <= 0) {
            return i6;
        }
        fileArr2 = new File[i4];
        i6 = 0;
        for (File file2 : fileArr) {
            if (!C2222d.m8364c(file2.getName())) {
                fileArr2[i6] = file2;
                i6++;
            }
        }
        return m8353a(str, fileArr2, i, i2, c2193f, c2239j, str5);
    }

    public byte[] m8366a(File file, int i) {
        byte[] a;
        try {
            a = C2190c.m8234a(file);
        } catch (IOException e) {
            e.printStackTrace();
            a = null;
        }
        return (a != null && a.length <= Math.abs(i)) ? a : null;
    }
}
