package com.aide.ui.build;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.aide.common.TextToSpeechHelper;
import com.aide.common.m;
import com.aide.common.x;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.h;
import com.aide.ui.trainer.c.a;
import com.aide.ui.trainer.c.d;

public abstract class OutputConsoleActivity extends Activity {
    protected Handler DW;
    private SoundPool FH;
    private int Hw;
    private TextToSpeechHelper Zo;
    protected OutputConsole j6;
    private int v5;

    class 1 implements Runnable {
        final /* synthetic */ OutputConsoleActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.finish();
            }
        }

        1(OutputConsoleActivity outputConsoleActivity) {
            this.j6 = outputConsoleActivity;
        }

        public void run() {
            if (this.j6.v5()) {
                this.j6.FH.play(this.j6.v5, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            if (this.j6.Hw()) {
                this.j6.Zo.j6(this.j6.getIntent().getStringExtra("EXTRA_TRAINER_LOCALE"), this.j6.getIntent().getStringExtra("EXTRA_TRAINER_FAIL"));
            }
            this.j6.j6(this.j6.getIntent().getStringExtra("EXTRA_TRAINER_FAIL_TITLE"), this.j6.getIntent().getStringExtra("EXTRA_TRAINER_FAIL"), this.j6.getIntent().getStringExtra("EXTRA_TRAINER_FAIL_BUTTON"), new 1(this));
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ OutputConsoleActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 2 j6;

            1(2 2) {
                this.j6 = 2;
            }

            public void run() {
                Intent intent = new Intent();
                intent.putExtra("EXTRA_TRAINER_ACTION", true);
                this.j6.j6.setResult(-1, intent);
                this.j6.j6.finish();
            }
        }

        2(OutputConsoleActivity outputConsoleActivity) {
            this.j6 = outputConsoleActivity;
        }

        public void run() {
            if (this.j6.v5()) {
                this.j6.FH.play(this.j6.Hw, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            if (this.j6.Hw()) {
                this.j6.Zo.j6(this.j6.getIntent().getStringExtra("EXTRA_TRAINER_LOCALE"), this.j6.getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS"));
            }
            this.j6.j6(this.j6.getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS_TITLE"), this.j6.getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS"), this.j6.getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS_BUTTON"), new 1(this));
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ OutputConsoleActivity DW;
        final /* synthetic */ Runnable j6;

        3(OutputConsoleActivity outputConsoleActivity, Runnable runnable) {
            this.DW = outputConsoleActivity;
            this.j6 = runnable;
        }

        public void onClick(View view) {
            this.j6.run();
        }
    }

    class 4 implements OnFocusChangeListener {
        final /* synthetic */ OutputConsoleActivity DW;
        final /* synthetic */ TextView j6;

        4(OutputConsoleActivity outputConsoleActivity, TextView textView) {
            this.DW = outputConsoleActivity;
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

    protected abstract int DW();

    protected abstract void j6();

    public static void j6(Activity activity, boolean z, int i, Intent intent) {
        intent.putExtra("EXTRA_THEME", z);
        intent.putExtra("EXTRA_LANGUAGE", e.vJ());
        if (e.VH()) {
            a er = e.QX().er();
            d gW = e.QX().gW();
            intent.putExtra("EXTRA_TRAINER", true);
            intent.putExtra("EXTRA_SOUND", h.XL());
            intent.putExtra("EXTRA_SPEAK", h.QX());
            intent.putExtra("EXTRA_HEADER", er.VH());
            intent.putExtra("EXTRA_TRAINER_HEADER_ICON", er.u7());
            intent.putExtra("EXTRA_TRAINER_LOCALE", gW.j6());
            intent.putExtra("EXTRA_TRAINER_OUTPUT", gW.Zo());
            intent.putExtra("EXTRA_TRAINER_FAIL", gW.Hw());
            intent.putExtra("EXTRA_TRAINER_FAIL_BUTTON", e.QX().j3());
            intent.putExtra("EXTRA_TRAINER_SUCCESS", gW.u7());
            intent.putExtra("EXTRA_TRAINER_FAIL_TITLE", e.QX().XL());
            intent.putExtra("EXTRA_TRAINER_SUCCESS_TITLE", e.QX().rN());
            intent.putExtra("EXTRA_TRAINER_SUCCESS_BUTTON", e.QX().U2());
            activity.startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(402657280);
        activity.startActivity(intent);
    }

    public static void j6(Intent intent) {
        if (!intent.getBooleanExtra("EXTRA_TRAINER_ACTION", false) || e.QX().QX()) {
            e.QX().tp();
        } else {
            e.QX().u7();
        }
    }

    protected void onCreate(Bundle bundle) {
        com.aide.common.d.j6((Activity) this, getIntent().getExtras().getString("EXTRA_LANGUAGE", null));
        boolean z = getIntent().getExtras().getBoolean("EXTRA_THEME", true);
        if (z) {
            setTheme(R.g.ActivityActionbarThemeLight);
        } else {
            setTheme(R.g.ActivityActionbarThemeDark);
        }
        super.onCreate(bundle);
        requestWindowFeature(5);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.c.outputconsole);
        if (!Zo()) {
            com.aide.common.d.j6(findViewById(R.b.outputFrame));
        }
        if (Zo() && com.aide.common.d.DW((Context) this)) {
            getActionBar().hide();
        }
        this.DW = new Handler();
        this.j6 = (OutputConsole) findViewById(R.b.outputConsole);
        this.j6.j6(z, Zo());
        if (Zo()) {
            x.j6(getActionBar(), getIntent().getIntExtra("EXTRA_TRAINER_HEADER_ICON", R.drawable.ic_launcher), getIntent().getStringArrayExtra("EXTRA_HEADER"));
            this.FH = new SoundPool(1, 3, 0);
            this.Hw = this.FH.load(this, R.e.success_task, 1);
            this.v5 = this.FH.load(this, R.e.fail, 1);
            this.Zo = new TextToSpeechHelper(this);
        } else {
            getActionBar().setIcon(DW());
            getActionBar().setTitle("Program Output");
        }
        u7();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.Zo != null) {
            this.Zo.j6();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    protected void FH() {
        setProgressBarIndeterminateVisibility(false);
        if (Zo()) {
            String stringExtra = getIntent().getStringExtra("EXTRA_TRAINER_OUTPUT");
            if (stringExtra == null || stringExtra.length() <= 0) {
                gn();
            } else if (this.j6.j6(stringExtra)) {
                gn();
            } else {
                VH();
            }
        }
    }

    private boolean Zo() {
        return getIntent().getBooleanExtra("EXTRA_TRAINER", false);
    }

    private void VH() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_TRAINER_ACTION", false);
        setResult(-1, intent);
        this.DW.postDelayed(new 1(this), 100);
    }

    private void gn() {
        this.DW.postDelayed(new 2(this), 100);
    }

    private void j6(String str, String str2, String str3, Runnable runnable) {
        View headerView = this.j6.getScrollView().getHeaderView();
        headerView.setVisibility(0);
        TextView textView = (TextView) headerView.findViewById(R.b.outputHeaderLearnMessage);
        TextView textView2 = (TextView) headerView.findViewById(R.b.outputHeaderLearnTitle);
        TextView textView3 = (TextView) headerView.findViewById(R.b.outputHeaderButton);
        if (str2.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(Html.fromHtml(str2));
        }
        textView2.setText(str);
        textView3.setText(str3);
        textView2.setTextSize(com.aide.common.d.J0(this));
        textView.setTextSize(com.aide.common.d.EQ(this));
        textView3.setTextSize(com.aide.common.d.we(this));
        View findViewById = headerView.findViewById(R.b.outputHeaderLearnTask);
        findViewById.setOnClickListener(new 3(this, runnable));
        findViewById.setOnFocusChangeListener(new 4(this, textView3));
        if (Zo() && com.aide.common.d.DW((Context) this)) {
            float f = getResources().getDisplayMetrics().density;
            findViewById.setPadding((int) (48.0f * f), (int) (27.0f * f), (int) (f * 48.0f), 0);
        }
        textView.getLayoutParams().width = com.aide.common.d.Zo(this);
        textView.requestLayout();
        headerView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.j6.getScrollView().Hw();
    }

    protected boolean Hw() {
        return getIntent().getBooleanExtra("EXTRA_SPEAK", false);
    }

    protected boolean v5() {
        return getIntent().getBooleanExtra("EXTRA_SOUND", true);
    }

    private void u7() {
        setProgressBarIndeterminate(true);
        setProgressBarIndeterminateVisibility(true);
        try {
            j6();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }
}
