package com.aide.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.activities.TrainerCourseActivity;
import com.aide.ui.marketing.WhatsNewDialog;
import com.aide.ui.trainer.a;
import com.aide.ui.trainer.c.c;
import com.aide.ui.trainer.d;
import nm;

public class q {

    static class 1 implements Runnable {
        final /* synthetic */ Activity j6;

        1(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            q.gn(this.j6);
        }
    }

    static class 2 implements Runnable {
        final /* synthetic */ Activity j6;

        2(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            e.Mr().Hw(this.j6, "key_outdated");
            q.u7(this.j6);
        }
    }

    static class 3 implements Runnable {
        final /* synthetic */ Activity j6;

        3(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            q.u7(this.j6);
        }
    }

    static class 4 implements Runnable {
        final /* synthetic */ Activity j6;

        4(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            q.EQ(this.j6);
        }
    }

    static class 5 extends m {
        private boolean DW;
        private AlertDialog j6;

        class 1 implements OnShowListener {
            final /* synthetic */ 5 DW;
            final /* synthetic */ Activity j6;

            1(5 5, Activity activity) {
                this.DW = 5;
                this.j6 = activity;
            }

            public void onShow(DialogInterface dialogInterface) {
                View findViewById = this.DW.j6.findViewById(this.j6.getResources().getIdentifier("android:id/title_template", null, null));
                if (findViewById != null) {
                    findViewById.setBackgroundColor(-1);
                }
                findViewById = this.DW.j6.findViewById(this.j6.getResources().getIdentifier("android:id/alertTitle", null, null));
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setTextColor(-4473925);
                }
            }
        }

        class 2 implements y<c> {
            final /* synthetic */ 5 DW;
            final /* synthetic */ Activity j6;

            2(5 5, Activity activity) {
                this.DW = 5;
                this.j6 = activity;
            }

            public void j6(c cVar) {
                this.DW.j6.dismiss();
                com.aide.analytics.c.j6(this.j6, "StartupChoice", cVar.FH() + 1);
                if (cVar.Hw() > 0) {
                    e.u7().j6(true, cVar.gn(), null);
                } else {
                    TrainerCourseActivity.j6(this.j6, cVar.gn());
                }
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ LinearLayout DW;
            final /* synthetic */ 5 FH;
            final /* synthetic */ Activity j6;

            3(5 5, Activity activity, LinearLayout linearLayout) {
                this.FH = 5;
                this.j6 = activity;
                this.DW = linearLayout;
            }

            public void run() {
                this.FH.DW = false;
                this.FH.j6(this.j6, this.DW);
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ 5 DW;
            final /* synthetic */ Activity j6;

            4(5 5, Activity activity) {
                this.DW = 5;
                this.j6 = activity;
            }

            public void run() {
                this.DW.j6.dismiss();
                com.aide.analytics.c.j6(this.j6, "StartupChoice", 0);
                e.j6(false);
                q.DW(this.j6, true, "after_selecting_expert_2");
                PromoNotificationAlarmReceiver.j6(e.gn());
            }
        }

        5() {
            this.DW = true;
        }

        protected Dialog j6(Activity activity) {
            View inflate = LayoutInflater.from(activity).inflate(R.c.trainer_dialog, null);
            j6(activity, (LinearLayout) inflate.findViewById(R.b.trainerDialogLayout));
            this.j6 = new Builder(activity).setTitle(R.f.trainer_option_question).setView(inflate).setCancelable(false).create();
            this.j6.setOnShowListener(new 1(this, activity));
            return this.j6;
        }

        private void j6(Activity activity, LinearLayout linearLayout) {
            d.j6(linearLayout, e.QX().BT(), this.DW, false, new 2(this, activity), new 3(this, activity, linearLayout), null, new 4(this, activity), null);
        }
    }

    public static void j6(Activity activity) {
        if (e.u7().Hw(true) == null || !WhatsNewDialog.j6(activity, new 1(activity))) {
            gn(activity);
        }
    }

    private static void gn(Activity activity) {
        if (e.Mr().u7()) {
            m.j6(activity, "AIDE Premium key outdated", "Your AIDE Premium Key is outdated. Premium features have been disabled. Please upgrade it to the latest version.", true, "Update", new 2(activity), "Not now", new 3(activity));
            return;
        }
        u7(activity);
    }

    private static void u7(Activity activity) {
        if (e.a8().J0() || e.j3().EQ()) {
            if (!e.a8().gn()) {
                if (e.VH()) {
                    Hw(activity);
                } else {
                    DW(activity, false, "startup");
                }
            }
        } else if (!e.QX().vy()) {
            EQ(activity);
        } else if (com.aide.common.d.DW((Context) activity)) {
            TrainerCourseActivity.j6(activity);
        } else {
            tp(activity);
        }
    }

    public static void DW(Activity activity) {
        a.j6(activity, new 4(activity));
    }

    private static void tp(Activity activity) {
        com.aide.analytics.a.DW("App init: Showing select mode dialog");
        m.j6(activity, new 5());
    }

    private static void DW(Activity activity, boolean z, String str) {
        if (!e.Mr().Zo()) {
            e.Mr().j6(activity, z ? 16 : 0, str, false, true);
        } else if (z) {
            DW(activity);
        }
    }

    public static void FH(Activity activity) {
        e.a8().gn();
    }

    public static void j6(Activity activity, String str) {
        if (!e.Mr().XL() && !e.Mr().QX()) {
            e.Mr().j6(e.u7(), str, "GCM notification");
        }
    }

    public static void Hw(Activity activity) {
        if (!e.Mr().QX()) {
            e.Mr().j6(activity, 0, 0, "after_mayShowPrimeSalesDialog", true);
        }
    }

    private static void EQ(Activity activity) {
        com.aide.analytics.a.DW("App init: Showing create project dialog");
        m.j6(activity, new nm(e.er().DW(), e.u7().v5()));
    }
}
