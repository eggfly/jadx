package com.google.firebase.iid;

import android.text.TextUtils;

public class d {
    private static final Object j6;
    private final zzg DW;

    static {
        j6 = new Object();
    }

    d(zzg com_google_firebase_iid_zzg) {
        this.DW = com_google_firebase_iid_zzg;
    }

    String j6() {
        String str = null;
        synchronized (j6) {
            String string = this.DW.j6().getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    boolean j6(String str) {
        boolean z;
        synchronized (j6) {
            String string = this.DW.j6().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                valueOf = String.valueOf(",");
                valueOf2 = String.valueOf(str);
                this.DW.j6().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
