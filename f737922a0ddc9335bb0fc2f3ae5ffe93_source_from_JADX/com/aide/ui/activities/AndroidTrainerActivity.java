package com.aide.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.aide.common.UndoManager;
import com.aide.common.d;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.uidesigner.f;
import com.aide.uidesigner.l;
import java.io.File;

public class AndroidTrainerActivity extends Activity {

    class 1 implements OnClickListener {
        final /* synthetic */ AndroidTrainerActivity j6;

        1(AndroidTrainerActivity androidTrainerActivity) {
            this.j6 = androidTrainerActivity;
        }

        public void onClick(View view) {
            this.j6.j6();
            this.j6.finish();
        }
    }

    class 2 implements OnFocusChangeListener {
        final /* synthetic */ AndroidTrainerActivity DW;
        final /* synthetic */ TextView j6;

        2(AndroidTrainerActivity androidTrainerActivity, TextView textView) {
            this.DW = androidTrainerActivity;
            this.j6 = textView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                Animation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.0f, 1, 0.5f);
                scaleAnimation.setDuration((long) 400);
                scaleAnimation.setFillAfter(true);
                this.j6.startAnimation(scaleAnimation);
                return;
            }
            Animation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.0f, 1, 0.5f);
            scaleAnimation2.setDuration((long) 400);
            scaleAnimation2.setFillAfter(true);
            this.j6.startAnimation(scaleAnimation2);
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ AndroidTrainerActivity DW;
        final /* synthetic */ View j6;

        class 1 implements AnimationListener {
            final /* synthetic */ 3 j6;

            1(3 3) {
                this.j6 = 3;
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (this.j6.DW.getWindow().getCurrentFocus() == null) {
                    this.j6.j6.findViewById(R.b.trainerToast).requestFocus();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 3 j6;

            class 1 implements AnimationListener {
                final /* synthetic */ 2 j6;

                1(2 2) {
                    this.j6 = 2;
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    this.j6.j6.j6.setVisibility(8);
                }
            }

            2(3 3) {
                this.j6 = 3;
            }

            public void run() {
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setAnimationListener(new 1(this));
                alphaAnimation.setDuration(500);
                this.j6.j6.startAnimation(alphaAnimation);
            }
        }

        3(AndroidTrainerActivity androidTrainerActivity, View view) {
            this.DW = androidTrainerActivity;
            this.j6 = view;
        }

        public void run() {
            if (!e.J0()) {
                e.QX().VH();
                if (!this.DW.getIntent().getBooleanExtra("EXTRA_PLAYGROUND", false)) {
                    Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(500);
                    this.j6.startAnimation(alphaAnimation);
                    this.j6.setVisibility(0);
                    alphaAnimation.setAnimationListener(new 1(this));
                    new Handler().postDelayed(new 2(this), (long) (this.DW.getIntent().getIntExtra("EXTRA_DURATION", 10) * 1000));
                }
            }
        }
    }

    class 4 extends l {
        final /* synthetic */ AndroidTrainerActivity j6;

        4(AndroidTrainerActivity androidTrainerActivity, ViewGroup viewGroup, String str, String str2, UndoManager undoManager) {
            this.j6 = androidTrainerActivity;
            super(viewGroup, str, str2, undoManager);
        }

        protected void j6() {
        }

        protected void j6(f fVar) {
        }

        protected void j6(boolean z) {
        }

        protected void DW() {
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ AndroidTrainerActivity j6;

        5(AndroidTrainerActivity androidTrainerActivity) {
            this.j6 = androidTrainerActivity;
        }

        public void run() {
            e.QX().u7();
        }
    }

    public static void j6(Activity activity, String str, String str2, String str3, String str4, int i, boolean z) {
        Intent intent = new Intent(activity, AndroidTrainerActivity.class);
        intent.putExtra("EXTRA_FILE", str);
        intent.putExtra("EXTRA_TITLE", str2);
        intent.putExtra("EXTRA_TEXT", str3);
        intent.putExtra("EXTRA_BUTTON", str4);
        intent.putExtra("EXTRA_DURATION", i);
        intent.putExtra("EXTRA_PLAYGROUND", z);
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.c.trainer_app_android);
        d.j6(findViewById(R.b.trainerAppActivityLayout), true);
        ViewGroup viewGroup = (FrameLayout) findViewById(R.b.trainerAppActivityLayout);
        String stringExtra = getIntent().getStringExtra("EXTRA_FILE");
        j6(viewGroup, stringExtra, new File(stringExtra).getParentFile().getParentFile().getPath());
        j6(viewGroup);
    }

    private void j6(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this).inflate(R.c.trainer_toast, null);
        inflate.setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.b.trainerToastTitle);
        TextView textView2 = (TextView) inflate.findViewById(R.b.trainerToastText);
        TextView textView3 = (TextView) inflate.findViewById(R.b.trainerToastButton);
        textView.setText(getIntent().getStringExtra("EXTRA_TITLE"));
        textView2.setText(Html.fromHtml(getIntent().getStringExtra("EXTRA_TEXT")));
        textView3.setText(getIntent().getStringExtra("EXTRA_BUTTON"));
        textView.setTextSize(d.J0(this));
        textView2.setTextSize(d.EQ(this));
        textView3.setTextSize(d.we(this));
        inflate.findViewById(R.b.trainerToast).setOnClickListener(new 1(this));
        inflate.findViewById(R.b.trainerToast).setOnFocusChangeListener(new 2(this, textView3));
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = (int) (getResources().getDisplayMetrics().density * 20.0f);
        layoutParams.bottomMargin = (int) (getResources().getDisplayMetrics().density * 20.0f);
        layoutParams.leftMargin = (int) (getResources().getDisplayMetrics().density * 20.0f);
        layoutParams.rightMargin = (int) (getResources().getDisplayMetrics().density * 20.0f);
        viewGroup.addView(inflate, layoutParams);
        new Handler().postDelayed(new 3(this, inflate), 2000);
    }

    public void onBackPressed() {
        super.onBackPressed();
        j6();
    }

    private void j6(ViewGroup viewGroup, String str, String str2) {
        l 4 = new 4(this, viewGroup, str, str2, new UndoManager());
        4.Hw();
        4.DW(false);
    }

    private void j6() {
        if (!e.J0() && !getIntent().getBooleanExtra("EXTRA_PLAYGROUND", false)) {
            new Handler().postDelayed(new 5(this), 500);
        }
    }
}
