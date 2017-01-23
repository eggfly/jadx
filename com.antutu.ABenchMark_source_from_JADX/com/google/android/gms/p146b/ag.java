package com.google.android.gms.p146b;

import android.support.v4.view.MotionEventCompat;
import com.antutu.utils.widget.SystemBarTintManager;
import java.security.MessageDigest;

@gb
/* renamed from: com.google.android.gms.b.ag */
public class ag extends ad {
    private MessageDigest f10243b;

    byte m11766a(int i) {
        return (byte) ((((i & MotionEventCompat.ACTION_MASK) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((SystemBarTintManager.DEFAULT_TINT_COLOR & i) >> 24));
    }

    public byte[] m11767a(String str) {
        byte[] a = m11768a(str.split(" "));
        this.f10243b = m11752a();
        synchronized (this.a) {
            if (this.f10243b == null) {
                a = new byte[0];
            } else {
                this.f10243b.reset();
                this.f10243b.update(a);
                Object digest = this.f10243b.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                a = new byte[i];
                System.arraycopy(digest, 0, a, 0, a.length);
            }
        }
        return a;
    }

    byte[] m11768a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = m11766a(af.m11761a(strArr[i]));
        }
        return bArr;
    }
}
