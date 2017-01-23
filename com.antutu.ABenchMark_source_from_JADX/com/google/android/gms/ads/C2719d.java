package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2784w;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import com.taobao.accs.ErrorCode;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.ads.d */
public final class C2719d {
    public static final C2719d f9257a;
    public static final C2719d f9258b;
    public static final C2719d f9259c;
    public static final C2719d f9260d;
    public static final C2719d f9261e;
    public static final C2719d f9262f;
    public static final C2719d f9263g;
    public static final C2719d f9264h;
    private final int f9265i;
    private final int f9266j;
    private final String f9267k;

    static {
        f9257a = new C2719d(320, 50, "320x50_mb");
        f9258b = new C2719d(468, 60, "468x60_as");
        f9259c = new C2719d(320, 100, "320x100_as");
        f9260d = new C2719d(728, 90, "728x90_as");
        f9261e = new C2719d(ErrorCode.APP_NOT_BIND, 250, "300x250_as");
        f9262f = new C2719d(160, OtherError.CONTAINER_INVISIBLE_ERROR, "160x600_as");
        f9263g = new C2719d(-1, -2, "smart_banner");
        f9264h = new C2719d(-3, -4, "fluid");
    }

    public C2719d(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    C2719d(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.f9265i = i;
            this.f9266j = i2;
            this.f9267k = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public int m10344a() {
        return this.f9266j;
    }

    public int m10345a(Context context) {
        switch (this.f9266j) {
            case ErrorCode.MESSAGE_TOO_LARGE /*-4*/:
            case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                return -1;
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                return AdSizeParcel.m10501b(context.getResources().getDisplayMetrics());
            default:
                return C2784w.m10741a().m11560a(context, this.f9266j);
        }
    }

    public int m10346b() {
        return this.f9265i;
    }

    public int m10347b(Context context) {
        switch (this.f9265i) {
            case ErrorCode.MESSAGE_TOO_LARGE /*-4*/:
            case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                return -1;
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                return AdSizeParcel.m10498a(context.getResources().getDisplayMetrics());
            default:
                return C2784w.m10741a().m11560a(context, this.f9265i);
        }
    }

    public boolean m10348c() {
        return this.f9265i == -3 && this.f9266j == -4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2719d)) {
            return false;
        }
        C2719d c2719d = (C2719d) obj;
        return this.f9265i == c2719d.f9265i && this.f9266j == c2719d.f9266j && this.f9267k.equals(c2719d.f9267k);
    }

    public int hashCode() {
        return this.f9267k.hashCode();
    }

    public String toString() {
        return this.f9267k;
    }
}
