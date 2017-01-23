package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.Future;

@eh
public final class eq {

    private static abstract class a extends en {
        private a() {
        }
    }

    class 1 extends a {
        final /* synthetic */ boolean DW;
        final /* synthetic */ Context j6;

        public void j6() {
            Editor edit = eq.j6(this.j6).edit();
            edit.putBoolean("use_https", this.DW);
            edit.apply();
        }
    }

    class 2 extends a {
        final /* synthetic */ String DW;
        final /* synthetic */ long FH;
        final /* synthetic */ Context j6;

        2(Context context, String str, long j) {
            this.j6 = context;
            this.DW = str;
            this.FH = j;
            super();
        }

        public void j6() {
            Editor edit = eq.j6(this.j6).edit();
            edit.putString("app_settings_json", this.DW);
            edit.putLong("app_settings_last_update_ms", this.FH);
            edit.apply();
        }
    }

    public static SharedPreferences j6(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    public static Future j6(Context context, String str, long j) {
        return (Future) new 2(context, str, j).FH();
    }
}
