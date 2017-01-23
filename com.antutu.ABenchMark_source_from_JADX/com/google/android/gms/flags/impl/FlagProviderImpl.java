package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.flags.impl.C3534a.C3535a;
import com.google.android.gms.flags.impl.C3534a.C3537b;
import com.google.android.gms.flags.impl.C3534a.C3539c;
import com.google.android.gms.flags.impl.C3534a.C3541d;
import com.google.android.gms.p146b.jw.C3325a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;

public class FlagProviderImpl extends C3325a {
    private boolean f12214a;
    private SharedPreferences f12215b;

    public FlagProviderImpl() {
        this.f12214a = false;
    }

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return C3535a.m14739a(this.f12215b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return C3537b.m14741a(this.f12215b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return C3539c.m14743a(this.f12215b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return C3541d.m14745a(this.f12215b, str, str2);
    }

    public void init(C2687a c2687a) {
        Context context = (Context) C2690b.m10263a(c2687a);
        if (!this.f12214a) {
            try {
                this.f12215b = C3543b.m14747a(context.createPackageContext("com.google.android.gms", 0));
                this.f12214a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
