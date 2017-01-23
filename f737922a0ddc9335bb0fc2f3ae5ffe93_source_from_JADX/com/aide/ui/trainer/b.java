package com.aide.ui.trainer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.aide.analytics.a;
import com.aide.common.d;
import com.aide.ui.R;
import com.aide.ui.activities.AndroidTrainerActivity;
import com.aide.ui.e;
import com.aide.ui.h;
import java.util.HashSet;
import java.util.Set;

public class b {
    private Set<Long> DW;
    private Toast FH;
    private boolean j6;

    class 1 implements Runnable {
        final /* synthetic */ b DW;
        final /* synthetic */ Context j6;

        1(b bVar, Context context) {
            this.DW = bVar;
            this.j6 = context;
        }

        public void run() {
            if (this.DW.v5(this.j6)) {
                MediaPlayer.create(this.j6, R.e.success_task).start();
            }
            if (!e.QX().QX()) {
                this.DW.j6(this.j6, this.DW.u7(this.j6), this.DW.gn(this.j6), this.DW.VH(this.j6), this.DW.Zo(this.j6));
            }
        }
    }

    class 2 extends CountDownTimer {
        final /* synthetic */ b j6;

        2(b bVar, long j, long j2) {
            this.j6 = bVar;
            super(j, j2);
        }

        public void onTick(long j) {
            if (this.j6.FH == null) {
                cancel();
            } else {
                this.j6.FH.show();
            }
        }

        public void onFinish() {
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ b j6;

        3(b bVar) {
            this.j6 = bVar;
        }

        public void run() {
            if (e.QX().QX()) {
                e.QX().tp();
            } else {
                e.QX().u7();
            }
        }
    }

    public b() {
        this.j6 = true;
        this.DW = new HashSet();
    }

    public void j6(String str, String str2, String str3) {
        if (str3.length() > 0) {
            AndroidTrainerActivity.j6(e.u7(), str3, e.QX().rN(), e.QX().gW().u7(), e.QX().U2(), e.QX().gW().gn(), e.QX().QX());
            return;
        }
        j6(e.gn(), e.QX().QX(), e.QX().rN(), e.QX().gW().u7(), e.QX().Mr(), e.QX().gW().gn(), h.XL());
        e.ro().j6(str, str2);
    }

    public boolean j6() {
        try {
            Context gn = e.gn();
            boolean z = Secure.getInt(gn.getContentResolver(), "install_non_market_apps") == 1;
            String string;
            if (!z) {
                a.DW("Exercise app was not run unknown sources: " + e.QX().P8());
                string = gn.getResources().getString(R.f.trainer_on_enable_unknown_sources);
                j6(gn, "\u26a0", string, null, 5);
                gn.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
                e.QX().DW(string);
            } else if (!FH(gn)) {
                string = gn.getResources().getString(R.f.trainer_on_first_install);
                j6(gn, "\u26a0", string, null, 5);
                e.QX().DW(string);
            }
            return z;
        } catch (SettingNotFoundException e) {
            return true;
        }
    }

    public void j6(Context context, long j) {
        if (DW(context)) {
            DW(context, false);
            Hw(context);
            if (!this.DW.contains(Long.valueOf(j))) {
                this.DW.add(Long.valueOf(j));
                if (e.J0()) {
                    j6(context, true);
                    new Handler().postDelayed(new 1(this, context), 2000);
                    return;
                }
                a.DW("Exercise app was run: " + e.QX().P8());
                if (this.j6) {
                    e.QX().u7();
                    return;
                }
                j6(context, true);
                e.QX().VH();
                if (!e.QX().QX()) {
                    j6(context, u7(context), gn(context), VH(context), Zo(context));
                }
            }
        }
    }

    private void j6(Context context, String str, String str2, String str3, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.c.trainer_toast, null);
        TextView textView = (TextView) inflate.findViewById(R.b.trainerToastTitle);
        TextView textView2 = (TextView) inflate.findViewById(R.b.trainerToastText);
        TextView textView3 = (TextView) inflate.findViewById(R.b.trainerToastButton);
        textView.setText(str);
        textView2.setText(Html.fromHtml(str2));
        if (str3 != null) {
            textView3.setText(str3);
        } else {
            textView3.setVisibility(8);
        }
        textView.setTextSize(d.J0(context));
        textView2.setTextSize(d.EQ(context));
        textView3.setTextSize(d.we(context));
        if (this.FH != null) {
            this.FH.cancel();
        }
        this.FH = new Toast(context);
        this.FH.setDuration(0);
        this.FH.setGravity(49, this.FH.getXOffset(), this.FH.getYOffset());
        this.FH.setView(inflate);
        this.FH.show();
        if (i > 2) {
            new 2(this, (long) (i * 1000), 1000).start();
        }
    }

    public void DW() {
        this.j6 = true;
        if (j6(e.gn())) {
            j6(e.gn(), false);
            if (this.FH != null) {
                this.FH.cancel();
                this.FH = null;
            }
            new Handler().postDelayed(new 3(this), 500);
        }
    }

    public void FH() {
        this.j6 = false;
    }

    private boolean FH(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getBoolean("HAS_RUN_SETTING", false);
    }

    private void Hw(Context context) {
        Editor edit = context.getSharedPreferences("RunAppController", 0).edit();
        edit.putBoolean("HAS_RUN_SETTING", true);
        edit.commit();
    }

    private void j6(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("RunAppController", 0).edit();
        edit.putBoolean("WAS_RUN_SETTING", z);
        edit.commit();
    }

    public boolean j6(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getBoolean("WAS_RUN_SETTING", false);
    }

    private void j6(Context context, boolean z, String str, String str2, String str3, int i, boolean z2) {
        Editor edit = context.getSharedPreferences("RunAppController", 0).edit();
        edit.putBoolean("WAS_STARTED_SETTING", true);
        edit.putBoolean("IS_PLAYGROUND_SETTING", z);
        edit.putString("TOAST_TITLE_SETTING", str);
        edit.putString("TOAST_MESSAGE_SETTING", str2);
        edit.putString("TOAST_BUTTON_SETTING", str3);
        edit.putInt("TOAST_DURATION_SETTING", i);
        edit.putBoolean("SOUND_ENABLED", z2);
        edit.commit();
    }

    private void DW(Context context, boolean z) {
        Editor edit = context.getSharedPreferences("RunAppController", 0).edit();
        edit.putBoolean("WAS_STARTED_SETTING", z);
        edit.commit();
    }

    public boolean DW(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getBoolean("WAS_STARTED_SETTING", false);
    }

    private boolean v5(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getBoolean("SOUND_ENABLED", false);
    }

    private int Zo(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getInt("TOAST_DURATION_SETTING", 0);
    }

    private String VH(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getString("TOAST_BUTTON_SETTING", "");
    }

    private String gn(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getString("TOAST_MESSAGE_SETTING", "");
    }

    private String u7(Context context) {
        return context.getSharedPreferences("RunAppController", 0).getString("TOAST_TITLE_SETTING", "");
    }
}
