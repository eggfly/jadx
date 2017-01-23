package com.aide.ui.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aide.common.d;
import com.aide.common.m;
import com.aide.common.v;
import com.aide.common.x;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.h;
import com.aide.ui.trainer.c.c;
import com.aide.ui.trainer.c.i;
import com.aide.ui.trainer.c.j;
import java.util.ArrayList;
import java.util.List;
import nn;
import pn$a;

public class TrainerCourseActivity extends Activity {
    private static boolean j6;
    private android.support.v4.app.a DW;
    private c FH;
    private List<c> Hw;
    private boolean VH;
    private boolean Zo;
    private i v5;

    class 10 implements Runnable {
        final /* synthetic */ TrainerCourseActivity j6;

        10(TrainerCourseActivity trainerCourseActivity) {
            this.j6 = trainerCourseActivity;
        }

        public void run() {
            this.j6.Zo = false;
            this.j6.DW();
        }
    }

    class 11 implements Runnable {
        final /* synthetic */ TrainerCourseActivity j6;

        11(TrainerCourseActivity trainerCourseActivity) {
            this.j6 = trainerCourseActivity;
        }

        public void run() {
            this.j6.VH = false;
            this.j6.DW();
        }
    }

    class 12 implements Runnable {
        final /* synthetic */ TrainerCourseActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 12 j6;

            1(12 12) {
                this.j6 = 12;
            }

            public void run() {
                e.a8().J8();
                this.j6.j6.VH();
            }
        }

        12(TrainerCourseActivity trainerCourseActivity) {
            this.j6 = trainerCourseActivity;
        }

        public void run() {
            if (this.j6.j6()) {
                m.j6(this.j6, "Expert Mode", "AIDE will switch to expert mode, where you can create and modify your own apps.", new 1(this));
                return;
            }
            e.a8().J8();
            this.j6.VH();
        }
    }

    class 13 implements Runnable {
        final /* synthetic */ TrainerCourseActivity j6;

        13(TrainerCourseActivity trainerCourseActivity) {
            this.j6 = trainerCourseActivity;
        }

        public void run() {
            com.aide.analytics.a.DW("Trainer Google Plus Community shown");
            v.FH(this.j6);
        }
    }

    class 14 implements Runnable {
        final /* synthetic */ TrainerCourseActivity j6;

        14(TrainerCourseActivity trainerCourseActivity) {
            this.j6 = trainerCourseActivity;
        }

        public void run() {
            this.j6.VH();
        }
    }

    class 15 implements Runnable {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ i j6;

        15(TrainerCourseActivity trainerCourseActivity, i iVar) {
            this.DW = trainerCourseActivity;
            this.j6 = iVar;
        }

        public void run() {
            this.DW.j6(this.j6, true);
        }
    }

    class 1 implements OnFocusChangeListener {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ DrawerLayout j6;

        1(TrainerCourseActivity trainerCourseActivity, DrawerLayout drawerLayout) {
            this.DW = trainerCourseActivity;
            this.j6 = drawerLayout;
        }

        public void onFocusChange(View view, boolean z) {
            if (!this.j6.Zo(3)) {
                this.DW.FH();
            }
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ i j6;

        2(TrainerCourseActivity trainerCourseActivity, i iVar) {
            this.DW = trainerCourseActivity;
            this.j6 = iVar;
        }

        public void run() {
            this.DW.j6(this.j6, false);
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ j j6;

        3(TrainerCourseActivity trainerCourseActivity, j jVar) {
            this.DW = trainerCourseActivity;
            this.j6 = jVar;
        }

        public void onClick(View view) {
            this.DW.j6(this.j6);
        }
    }

    class 4 implements OnFocusChangeListener {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ View j6;

        4(TrainerCourseActivity trainerCourseActivity, View view) {
            this.DW = trainerCourseActivity;
            this.j6 = view;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                Animation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration((long) 400);
                scaleAnimation.setFillAfter(true);
                this.j6.startAnimation(scaleAnimation);
                return;
            }
            Animation scaleAnimation2 = new ScaleAnimation(1.05f, 1.0f, 1.05f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration((long) 400);
            scaleAnimation2.setFillAfter(true);
            this.j6.startAnimation(scaleAnimation2);
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ pn$a j6;

        class 1 implements y<String> {
            final /* synthetic */ 5 j6;

            1(5 5) {
                this.j6 = 5;
            }

            public void j6(String str) {
                this.j6.DW.VH();
            }
        }

        5(TrainerCourseActivity trainerCourseActivity, pn$a pn_a) {
            this.DW = trainerCourseActivity;
            this.j6 = pn_a;
        }

        public void onClick(View view) {
            m.j6(this.DW, new nn(e.er().DW(), this.j6, new 1(this)));
        }
    }

    class 6 implements Runnable {
        final /* synthetic */ TrainerCourseActivity j6;

        6(TrainerCourseActivity trainerCourseActivity) {
            this.j6 = trainerCourseActivity;
        }

        public void run() {
            e.u7().br();
        }
    }

    class 7 implements OnClickListener {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ i j6;

        7(TrainerCourseActivity trainerCourseActivity, i iVar) {
            this.DW = trainerCourseActivity;
            this.j6 = iVar;
        }

        public void onClick(View view) {
            this.DW.j6(this.j6);
        }
    }

    class 8 implements Runnable {
        final /* synthetic */ TrainerCourseActivity DW;
        final /* synthetic */ DrawerLayout j6;

        8(TrainerCourseActivity trainerCourseActivity, DrawerLayout drawerLayout) {
            this.DW = trainerCourseActivity;
            this.j6 = drawerLayout;
        }

        public void run() {
            this.j6.Hw(3);
        }
    }

    class 9 implements y<c> {
        final /* synthetic */ TrainerCourseActivity j6;

        9(TrainerCourseActivity trainerCourseActivity) {
            this.j6 = trainerCourseActivity;
        }

        public void j6(c cVar) {
            if (cVar.Ws()) {
                this.j6.j6(cVar);
            } else {
                e.Mr().Hw(this.j6, cVar.gn(), "show_course");
            }
        }
    }

    private class a extends android.support.v4.view.v {
        private int DW;
        private List<View> FH;
        private List<String> Hw;
        final /* synthetic */ TrainerCourseActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ int j6;

            1(a aVar, int i) {
                this.DW = aVar;
                this.j6 = i;
            }

            public void run() {
                ((View) this.DW.FH.get(this.j6)).requestFocus();
            }
        }

        public a(TrainerCourseActivity trainerCourseActivity, List<View> list, List<String> list2) {
            this.j6 = trainerCourseActivity;
            this.DW = -1;
            this.FH = list;
            this.Hw = list2;
        }

        public CharSequence DW(int i) {
            String str = (String) this.Hw.get(i);
            if (i < this.Hw.size() - 1) {
                return str + " \u226b";
            }
            return str;
        }

        public void j6(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int DW() {
            return this.FH.size();
        }

        public int j6(Object obj) {
            return -2;
        }

        public boolean j6(View view, Object obj) {
            return view.equals(obj);
        }

        public void DW(ViewGroup viewGroup) {
        }

        public void j6(Parcelable parcelable, ClassLoader classLoader) {
        }

        public Parcelable j6() {
            return null;
        }

        public void j6(ViewGroup viewGroup) {
        }

        public void DW(ViewGroup viewGroup, int i, Object obj) {
            super.DW(viewGroup, i, obj);
            if (this.DW != i) {
                this.DW = i;
                viewGroup.postDelayed(new 1(this, i), 100);
            }
        }

        public Object j6(ViewGroup viewGroup, int i) {
            View view = (View) this.FH.get(i);
            viewGroup.addView(view, 0);
            return view;
        }
    }

    public static void j6(Activity activity) {
        j6(activity, null);
    }

    public static void j6(Activity activity, String str) {
        Intent intent = new Intent(activity, TrainerCourseActivity.class);
        intent.putExtra("EXTRA_COURSE", str);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (j6()) {
            setContentView(R.c.trainer_tv);
        } else {
            setContentView(R.c.trainer);
        }
        this.Zo = true;
        this.VH = true;
        if (e.QX().ei() != null) {
            m.j6((Activity) this, "XML Error", e.QX().ei());
        }
        String stringExtra = getIntent().getStringExtra("EXTRA_COURSE");
        if (stringExtra == null && e.QX().er() != null) {
            stringExtra = e.QX().er().gn();
        }
        this.Hw = e.QX().BT();
        this.FH = e.QX().Hw(stringExtra);
        if (this.FH == null) {
            this.FH = e.QX().nw();
        }
        if (j6()) {
            getActionBar().hide();
        } else {
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.b.trainerDrawer);
            this.DW = new android.support.v4.app.a(this, drawerLayout, R.drawable.ic_drawer, 17039370, 17039370);
            drawerLayout.setOnFocusChangeListener(new 1(this, drawerLayout));
            drawerLayout.setDrawerListener(this.DW);
            View findViewById = findViewById(R.b.trainerSideDrawer);
            if (d.v5(this) >= 500.0f) {
                findViewById.getLayoutParams().width = (int) (300.0f * getResources().getDisplayMetrics().density);
                findViewById.requestLayout();
            }
            if (!(j6 && e.VH()) && getIntent().getStringExtra("EXTRA_COURSE") == null) {
                j6 = true;
                drawerLayout.postDelayed(new 8(this, drawerLayout), 300);
            }
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setHomeButtonEnabled(true);
        }
        DW();
        Zo();
        v5();
        if (getIntent().getStringExtra("EXTRA_COURSE") != null && this.FH.Hw() > 0) {
            ((ViewPager) findViewById(R.b.trainerViewPager)).setCurrentItem(1);
        }
    }

    private boolean j6() {
        return d.DW((Context) this) || d.j6();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.DW != null) {
            this.DW.j6();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.DW != null) {
            this.DW.j6(configuration);
        }
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }

    private void DW() {
        com.aide.ui.trainer.d.j6((LinearLayout) findViewById(R.b.trainerLinearLayout2), this.Hw, this.Zo, this.VH, new 9(this), new 10(this), new 11(this), new 12(this), new 13(this));
    }

    private void j6(j jVar) {
        if (e.Mr().XL()) {
            e.J8().j6((Activity) this, jVar, new 14(this));
        } else {
            e.Mr().j6(e.u7(), 1, (int) R.f.shop_feature_samples_and_updates, "selectSample:" + jVar.FH(), false);
        }
    }

    protected void j6(i iVar) {
        if (iVar.j3() && !e.Mr().XL()) {
            this.v5 = iVar;
            e.Mr().j6(e.u7(), 1, (int) R.f.shop_feature_lessons_and_updates, "selectLesson:" + iVar.XL(), false);
        } else if (e.QX().FH(iVar)) {
            m.j6((Activity) this, getResources().getString(R.f.trainer_restart_lesson), getResources().getString(R.f.trainer_restart_lesson_message_2), getResources().getString(R.f.trainer_restart), new 15(this, iVar), getResources().getString(R.f.trainer_continue), new 2(this, iVar), null);
        } else {
            j6(iVar, false);
        }
    }

    private void j6(i iVar, boolean z) {
        finish();
        e.QX().j6(iVar, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1 && this.v5 != null) {
                j6(this.v5);
            }
            this.v5 = null;
        }
    }

    protected void j6(c cVar) {
        if (!cVar.equals(this.FH)) {
            this.FH = cVar;
            Zo();
            v5();
        }
        Hw();
        FH();
    }

    private void FH() {
        findViewById(R.b.trainerViewPager).requestFocus(2);
    }

    private void Hw() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.b.trainerDrawer);
        if (drawerLayout != null) {
            drawerLayout.v5(3);
        }
    }

    private void v5() {
        x.j6(getActionBar(), this.FH.u7(), this.FH.VH());
    }

    private void Zo() {
        LinearLayout j6;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.FH.Hw() > 0) {
            j6 = j6(arrayList, arrayList2, (int) R.f.trainer_section_learn);
            boolean XL = e.Mr().XL();
            for (int i = 0; i < this.FH.Hw(); i++) {
                String EQ = this.FH.DW(i).EQ();
                if (EQ.length() > 0) {
                    int i2 = i + 1;
                    while (i2 < this.FH.Hw() && this.FH.DW(i2).EQ().length() <= 0) {
                        i2++;
                    }
                    if (i != 0) {
                        j6(j6);
                    }
                    j6(j6, EQ);
                    if (i == 0) {
                        j6(j6);
                    }
                    j6(j6, EQ, i, i2 - 1, XL);
                }
            }
        }
        if (!e.v5()) {
            List Zo;
            if (this.FH.v5() > 0) {
                Zo = this.FH.Zo();
                boolean XL2 = e.Mr().XL();
                LinearLayout j62 = j6(arrayList, arrayList2, (int) R.f.trainer_section_explore);
                j6(j62, this.FH.we());
                j6(j62);
                j6(j62, Zo, XL2);
            }
            Zo = e.vy().j6(this.FH.gn());
            if (Zo.size() > 0) {
                j6 = j6(arrayList, arrayList2, (int) R.f.trainer_section_code);
                j6(j6, this.FH.J0());
                j6(j6);
                j6(j6, Zo);
            }
        }
        ((ViewPager) findViewById(R.b.trainerViewPager)).setAdapter(new a(this, arrayList, arrayList2));
    }

    private void j6(LinearLayout linearLayout) {
        int i = (int) (10.0f * getResources().getDisplayMetrics().density);
        int i2 = (int) (5.0f * getResources().getDisplayMetrics().density);
        int i3 = (int) (60.0f * getResources().getDisplayMetrics().density);
        View imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.down_arrow);
        imageView.setPadding(i, i2, i, i2);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.setMargins(i, i2, i, i2);
        linearLayout.addView(imageView, layoutParams);
    }

    private void j6(LinearLayout linearLayout, String str) {
        int i = (int) (10.0f * getResources().getDisplayMetrics().density);
        int i2 = (int) (5.0f * getResources().getDisplayMetrics().density);
        View textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(d.EQ(this));
        textView.setText(str);
        textView.setTextColor(-7829368);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(i, i2, i, i2);
        linearLayout.addView(textView, layoutParams);
    }

    private LinearLayout j6(List<View> list, List<String> list2, int i) {
        View inflate = LayoutInflater.from(this).inflate(R.c.trainer_course, null);
        list.add(inflate);
        list2.add(getResources().getString(i));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.b.trainerCourseLinearLayout1);
        linearLayout.removeAllViews();
        return linearLayout;
    }

    private void j6(LinearLayout linearLayout, List<j> list, boolean z) {
        int i;
        View linearLayout2 = new LinearLayout(this);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        if (d.v5(this) >= 540.0f) {
            i = 2;
        } else {
            i = 1;
        }
        for (int i2 = 0; i2 < i; i2++) {
            View linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            linearLayout3.setClipChildren(false);
            linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2, 1.0f));
            for (int i3 = i2; i3 < list.size(); i3 += i) {
                j jVar = (j) list.get(i3);
                boolean j6 = e.J8().j6(jVar);
                CharSequence charSequence = j6 ? "\u27a5" : "\u27a5 " + getResources().getString(R.f.trainer_explore);
                if (!z) {
                    charSequence = charSequence + " \ud83d\udd12";
                }
                boolean z2 = System.currentTimeMillis() - jVar.u7() < 5184000000L && !j6;
                linearLayout3.addView(j6(jVar.FH(), jVar.Hw(), charSequence, z2, new 3(this, jVar)));
            }
        }
    }

    private View j6(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z, OnClickListener onClickListener) {
        View inflate = LayoutInflater.from(this).inflate(R.c.trainer_lesson, null);
        TextView textView = (TextView) inflate.findViewById(R.b.trainerlistentryTitleView);
        TextView textView2 = (TextView) inflate.findViewById(R.b.trainerlistentryTextView);
        TextView textView3 = (TextView) inflate.findViewById(R.b.trainerlistentryRatingTextView);
        ImageView imageView = (ImageView) inflate.findViewById(R.b.trainerlistentryNewImage);
        textView.setTextSize(d.J8(this));
        textView2.setTextSize(d.EQ(this));
        textView3.setTextSize(d.we(this));
        textView.setText(charSequence);
        textView2.setText(charSequence2);
        textView3.setText(charSequence3);
        imageView.setVisibility(z ? 0 : 8);
        inflate.findViewById(R.b.trainerlistentryBox).setOnClickListener(onClickListener);
        inflate.findViewById(R.b.trainerlistentryBox).setOnFocusChangeListener(new 4(this, inflate));
        return inflate;
    }

    private void j6(LinearLayout linearLayout, List<pn$a> list) {
        View linearLayout2 = new LinearLayout(this);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        int i = d.v5(this) >= 540.0f ? 2 : 1;
        for (int i2 = 0; i2 < i; i2++) {
            View linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            linearLayout3.setClipChildren(false);
            linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2, 1.0f));
            for (int i3 = i2; i3 < list.size(); i3 += i) {
                pn$a pn_a = (pn$a) list.get(i3);
                linearLayout3.addView(j6(getResources().getString(R.f.dialog_create_project_new, new Object[]{pn_a.j6}), Html.fromHtml(this.FH.J8() + ".<br/><br/><b>" + pn_a.Zo.DW + "</b>"), "\u27a5 " + getResources().getString(R.f.trainer_code), false, new 5(this, pn_a)));
            }
        }
    }

    private void VH() {
        finish();
        new Handler().postDelayed(new 6(this), 200);
    }

    private void j6(LinearLayout linearLayout, String str, int i, int i2, boolean z) {
        int i3;
        LayoutInflater.from(this);
        View linearLayout2 = new LinearLayout(this);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        if (d.v5(this) >= 540.0f) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            View linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            linearLayout3.setClipChildren(false);
            linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2, 1.0f));
            for (int i5 = i4 + i; i5 <= i2; i5 += i3) {
                CharSequence charSequence;
                i DW = this.FH.DW(i5);
                CharSequence QX = DW.QX();
                if (e.QX().Hw(DW)) {
                    QX = QX + "  " + e.QX().v5(DW);
                }
                String str2 = DW.Hw() <= 2 ? "x min" : DW.Hw() + " min";
                if (e.QX().Hw(DW)) {
                    charSequence = " \u2714";
                } else if (z || !DW.j3()) {
                    charSequence = "\u27a5 " + str2;
                } else {
                    charSequence = "\u27a5 " + str2 + " \ud83d\udd12";
                }
                linearLayout3.addView(j6(QX, Html.fromHtml(DW.J0()), charSequence, e.QX().DW(DW), new 7(this, DW)));
            }
        }
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        boolean z = false;
        if (this.DW != null && this.DW.j6(menuItem)) {
            return true;
        }
        if (menuItem.getItemId() == R.b.trainerMenuSoundOff || menuItem.getItemId() == R.b.trainerMenuSoundOn) {
            if (!h.XL()) {
                z = true;
            }
            h.DW(z);
            invalidateOptionsMenu();
            return true;
        } else if (menuItem.getItemId() != R.b.trainerMenuVoiceOff && menuItem.getItemId() != R.b.trainerMenuVoiceOn) {
            return super.onMenuItemSelected(i, menuItem);
        } else {
            if (!h.QX()) {
                z = true;
            }
            h.j6(z);
            invalidateOptionsMenu();
            return true;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.d.trainer_options_menu, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.b.trainerMenuSoundOff).setVisible(!h.XL());
        menu.findItem(R.b.trainerMenuSoundOn).setVisible(h.XL());
        MenuItem findItem = menu.findItem(R.b.trainerMenuVoiceOff);
        if (!h.QX()) {
            z = true;
        }
        findItem.setVisible(z);
        menu.findItem(R.b.trainerMenuVoiceOn).setVisible(h.QX());
        return true;
    }
}
