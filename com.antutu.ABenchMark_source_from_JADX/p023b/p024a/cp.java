package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.MotionEventCompat;
import anet.channel.C0655b;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.message.common.C4209a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import org.json.JSONObject;

/* renamed from: b.a.cp */
public class cp {
    private final byte[] f2857a;
    private final int f2858b;
    private final int f2859c;
    private String f2860d;
    private String f2861e;
    private byte[] f2862f;
    private byte[] f2863g;
    private byte[] f2864h;
    private int f2865i;
    private int f2866j;
    private int f2867k;
    private byte[] f2868l;
    private byte[] f2869m;
    private boolean f2870n;

    private cp(byte[] bArr, String str, byte[] bArr2) {
        this.f2857a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        this.f2858b = 1;
        this.f2859c = 0;
        this.f2860d = BuildConfig.VERSION_NAME;
        this.f2861e = null;
        this.f2862f = null;
        this.f2863g = null;
        this.f2864h = null;
        this.f2865i = 0;
        this.f2866j = 0;
        this.f2867k = 0;
        this.f2868l = null;
        this.f2869m = null;
        this.f2870n = false;
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.f2861e = str;
        this.f2867k = bArr.length;
        this.f2868l = al.m3327a(bArr);
        this.f2866j = (int) (System.currentTimeMillis() / 1000);
        this.f2869m = bArr2;
    }

    public static cp m3775a(Context context, String str, byte[] bArr) {
        try {
            String o = am.m3357o(context);
            String c = am.m3342c(context);
            SharedPreferences a = C0888r.m3932a(context);
            String string = a.getString("signature", null);
            int i = a.getInt(C0655b.HR_SERIAL, 1);
            cp cpVar = new cp(bArr, str, (c + o).getBytes());
            cpVar.m3783a(string);
            cpVar.m3782a(i);
            cpVar.m3785b();
            a.edit().putInt(C0655b.HR_SERIAL, i + 1).putString("signature", cpVar.m3781a()).commit();
            cpVar.m3786b(context);
            return cpVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String m3776a(Context context) {
        SharedPreferences a = C0888r.m3932a(context);
        return a == null ? null : a.getString("signature", null);
    }

    private byte[] m3777a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        byte[] b = ak.m3326b(this.f2869m);
        byte[] b2 = ak.m3326b(this.f2868l);
        int length = b.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (i2 = 0; i2 < length; i2++) {
            bArr2[i2 * 2] = b2[i2];
            bArr2[(i2 * 2) + 1] = b[i2];
        }
        for (i2 = 0; i2 < 2; i2++) {
            bArr2[i2] = bArr[i2];
            bArr2[(bArr2.length - i2) - 1] = bArr[(bArr.length - i2) - 1];
        }
        byte[] bArr3 = new byte[]{(byte) (i & MotionEventCompat.ACTION_MASK), (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK), (byte) ((i >> 16) & MotionEventCompat.ACTION_MASK), (byte) (i >>> 24)};
        while (i3 < bArr2.length) {
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr3[i3 % 4]);
            i3++;
        }
        return bArr2;
    }

    public static cp m3778b(Context context, String str, byte[] bArr) {
        try {
            String o = am.m3357o(context);
            String c = am.m3342c(context);
            SharedPreferences a = C0888r.m3932a(context);
            String string = a.getString("signature", null);
            int i = a.getInt(C0655b.HR_SERIAL, 1);
            cp cpVar = new cp(bArr, str, (c + o).getBytes());
            cpVar.m3784a(true);
            cpVar.m3783a(string);
            cpVar.m3782a(i);
            cpVar.m3785b();
            a.edit().putInt(C0655b.HR_SERIAL, i + 1).putString("signature", cpVar.m3781a()).commit();
            cpVar.m3786b(context);
            return cpVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] m3779d() {
        return m3777a(this.f2857a, (int) (System.currentTimeMillis() / 1000));
    }

    private byte[] m3780e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ak.m3322a(this.f2862f));
        stringBuilder.append(this.f2865i);
        stringBuilder.append(this.f2866j);
        stringBuilder.append(this.f2867k);
        stringBuilder.append(ak.m3322a(this.f2863g));
        return ak.m3326b(stringBuilder.toString().getBytes());
    }

    public String m3781a() {
        return ak.m3322a(this.f2862f);
    }

    public void m3782a(int i) {
        this.f2865i = i;
    }

    public void m3783a(String str) {
        this.f2862f = ak.m3324a(str);
    }

    public void m3784a(boolean z) {
        this.f2870n = z;
    }

    public void m3785b() {
        if (this.f2862f == null) {
            this.f2862f = m3779d();
        }
        if (this.f2870n) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f2862f, 1, bArr, 0, 16);
                this.f2868l = ak.m3325a(this.f2868l, bArr);
            } catch (Exception e) {
            }
        }
        this.f2863g = m3777a(this.f2862f, this.f2866j);
        this.f2864h = m3780e();
    }

    public void m3786b(Context context) {
        String str = this.f2861e;
        String d = ct.m3820a(context).m3828b().m3818d(null);
        String a = ak.m3322a(this.f2862f);
        Object obj = new byte[16];
        System.arraycopy(this.f2862f, 2, obj, 0, 16);
        String a2 = ak.m3322a(ak.m3326b(obj));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C4209a.f14204g, str);
            if (d != null) {
                jSONObject.put("umid", d);
            }
            jSONObject.put("signature", a);
            jSONObject.put("checksum", a2);
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            an.m3372a(new File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C4209a.f14204g, str);
            jSONObject2.put(C4209a.f14201d, AnalyticsConfig.getChannel(context));
            if (d != null) {
                jSONObject2.put("umid", an.m3375b(d));
            }
            an.m3372a(new File(context.getFilesDir(), "exid.dat"), jSONObject2.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public byte[] m3787c() {
        aw aiVar = new ai();
        aiVar.m3286a(this.f2860d);
        aiVar.m3293b(this.f2861e);
        aiVar.m3298c(ak.m3322a(this.f2862f));
        aiVar.m3285a(this.f2865i);
        aiVar.m3292b(this.f2866j);
        aiVar.m3297c(this.f2867k);
        aiVar.m3288a(this.f2868l);
        aiVar.m3301d(this.f2870n ? 1 : 0);
        aiVar.m3302d(ak.m3322a(this.f2863g));
        aiVar.m3305e(ak.m3322a(this.f2864h));
        try {
            return new bb().m3488a(aiVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("version : %s\n", new Object[]{this.f2860d}));
        stringBuilder.append(String.format("address : %s\n", new Object[]{this.f2861e}));
        stringBuilder.append(String.format("signature : %s\n", new Object[]{ak.m3322a(this.f2862f)}));
        stringBuilder.append(String.format("serial : %s\n", new Object[]{Integer.valueOf(this.f2865i)}));
        stringBuilder.append(String.format("timestamp : %d\n", new Object[]{Integer.valueOf(this.f2866j)}));
        stringBuilder.append(String.format("length : %d\n", new Object[]{Integer.valueOf(this.f2867k)}));
        stringBuilder.append(String.format("guid : %s\n", new Object[]{ak.m3322a(this.f2863g)}));
        stringBuilder.append(String.format("checksum : %s ", new Object[]{ak.m3322a(this.f2864h)}));
        String str = "codex : %d";
        Object[] objArr = new Object[1];
        if (!this.f2870n) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
