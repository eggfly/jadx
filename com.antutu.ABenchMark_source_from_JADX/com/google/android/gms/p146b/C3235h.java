package com.google.android.gms.p146b;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import anet.channel.security.ISecurity;
import com.google.ads.p147a.p148a.C2630b.C2627a;
import com.google.android.gms.common.api.C3427c;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.b.h */
public abstract class C3235h implements C2827g {
    protected static C3427c f11243i;
    protected MotionEvent f11244a;
    protected LinkedList<MotionEvent> f11245b;
    protected long f11246c;
    protected long f11247d;
    protected long f11248e;
    protected long f11249f;
    protected DisplayMetrics f11250g;
    protected C3158m f11251h;
    private boolean f11252j;

    protected C3235h(Context context, C3158m c3158m) {
        this.f11245b = new LinkedList();
        this.f11246c = 0;
        this.f11247d = 0;
        this.f11248e = 0;
        this.f11249f = 0;
        this.f11252j = false;
        this.f11251h = c3158m;
        try {
            this.f11250g = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f11250g = new DisplayMetrics();
            this.f11250g.density = 1.0f;
        }
    }

    private String m12958a(Context context, String str, boolean z) {
        C2627a c;
        if (z) {
            try {
                c = m12968c(context);
                this.f11252j = true;
            } catch (NoSuchAlgorithmException e) {
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e2) {
                return Integer.toString(7);
            } catch (IOException e3) {
                return Integer.toString(3);
            }
        }
        c = m12967b(context);
        return (c == null || c.m10120e() == 0) ? Integer.toString(5) : m12961a(c, str);
    }

    public String m12959a(Context context) {
        return m12958a(context, null, false);
    }

    public String m12960a(Context context, String str) {
        return m12958a(context, str, true);
    }

    protected String m12961a(C2627a c2627a, String str) {
        return m12963a(km.m10116a((km) c2627a), str);
    }

    protected String m12962a(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return this.f11251h.m12446a(bArr, true);
    }

    String m12963a(byte[] bArr, String str) {
        byte[] bArr2;
        if (bArr.length > 239) {
            km c2627a = new C2627a();
            c2627a.f9150t = Long.valueOf(1);
            bArr = km.m10116a(c2627a);
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        new C3190f().m12678a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m12966a(str, bArr3);
        }
        return this.f11251h.m12446a(bArr3, true);
    }

    public void m12964a(int i, int i2, int i3) {
        if (this.f11244a != null) {
            this.f11244a.recycle();
        }
        this.f11244a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f11250g.density, ((float) i2) * this.f11250g.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    public void m12965a(MotionEvent motionEvent) {
        if (this.f11252j) {
            this.f11249f = 0;
            this.f11248e = 0;
            this.f11247d = 0;
            this.f11246c = 0;
            Iterator it = this.f11245b.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.f11245b.clear();
            this.f11244a = null;
            this.f11252j = false;
        }
        switch (motionEvent.getAction()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f11246c++;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f11244a = MotionEvent.obtain(motionEvent);
                this.f11245b.add(this.f11244a);
                if (this.f11245b.size() > 6) {
                    ((MotionEvent) this.f11245b.remove()).recycle();
                }
                this.f11248e++;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f11247d += (long) (motionEvent.getHistorySize() + 1);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                this.f11249f++;
            default:
        }
    }

    void m12966a(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new kf(str.getBytes(HttpRequest.f14548a)).m13618a(bArr);
    }

    protected abstract C2627a m12967b(Context context);

    protected abstract C2627a m12968c(Context context);
}
