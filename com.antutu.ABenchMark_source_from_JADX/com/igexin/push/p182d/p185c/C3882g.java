package com.igexin.push.p182d.p185c;

import android.support.v4.view.MotionEventCompat;
import com.igexin.download.Downloads;

/* renamed from: com.igexin.push.d.c.g */
public class C3882g {
    public int f13070a;
    public int f13071b;
    public int f13072c;
    public int f13073d;
    public int f13074e;
    public int f13075f;
    public byte f13076g;
    public byte f13077h;
    public byte f13078i;
    public byte f13079j;
    public byte f13080k;
    public byte f13081l;
    public byte f13082m;
    public byte[] f13083n;
    public int f13084o;
    public int f13085p;
    public int f13086q;

    public int m15970a() {
        this.f13073d |= this.f13076g;
        this.f13073d |= this.f13077h;
        this.f13073d |= this.f13078i;
        return this.f13073d;
    }

    public void m15971a(byte b) {
        this.f13073d = b & MotionEventCompat.ACTION_MASK;
        this.f13076g = (byte) (b & Downloads.STATUS_RUNNING);
        this.f13077h = (byte) (b & 48);
        this.f13078i = (byte) (b & 15);
    }

    public int m15972b() {
        this.f13075f |= this.f13079j;
        this.f13075f |= this.f13080k;
        this.f13075f |= this.f13081l;
        this.f13075f |= this.f13082m;
        return this.f13075f;
    }
}
