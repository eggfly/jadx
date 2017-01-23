package com.google.android.gms.p146b;

import android.text.TextUtils;

@gb
/* renamed from: com.google.android.gms.b.at */
public class at {
    public as m11830a(ar arVar) {
        if (arVar == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!arVar.m11816a()) {
            hf.m12982e("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (arVar.m11818c() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(arVar.m11819d())) {
            return new as(arVar.m11818c(), arVar.m11819d(), arVar.m11817b(), arVar.m11820e());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
