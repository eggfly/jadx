package com.aide.ui.browsers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.LogCatConsole;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.uidesigner.ProxyTextView;
import ok;
import pj;
import pj$a;
import pj$b;

public class LogCatBrowser extends LinearLayout implements a, pj$b {
    private boolean DW;
    private boolean j6;

    class 1 implements OnClickListener {
        final /* synthetic */ LogCatBrowser DW;
        final /* synthetic */ ImageView j6;

        1(LogCatBrowser logCatBrowser, ImageView imageView) {
            this.DW = logCatBrowser;
            this.j6 = imageView;
        }

        public void onClick(View view) {
            this.DW.getConsole().j6(this.j6, false);
        }
    }

    class 2 implements y<String> {
        final /* synthetic */ LogCatBrowser j6;

        2(LogCatBrowser logCatBrowser) {
            this.j6 = logCatBrowser;
        }

        public void j6(String str) {
            this.j6.j6(2, str);
            this.j6.getConsole().DW(str);
        }
    }

    class 3 implements y<String> {
        final /* synthetic */ LogCatBrowser j6;

        3(LogCatBrowser logCatBrowser) {
            this.j6 = logCatBrowser;
        }

        public void j6(String str) {
            this.j6.j6(1, str);
            this.j6.getConsole().Hw(str);
        }
    }

    class 4 implements y<String> {
        final /* synthetic */ LogCatBrowser j6;

        4(LogCatBrowser logCatBrowser) {
            this.j6 = logCatBrowser;
        }

        public void j6(String str) {
            this.j6.j6(0, str);
            this.j6.getConsole().FH(str);
        }
    }

    public LogCatBrowser(Context context) {
        super(context);
        QX();
    }

    public LogCatBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        QX();
    }

    private void QX() {
        setLayoutParams(new LayoutParams(-1, -1));
        View inflate = LayoutInflater.from(getContext()).inflate(R.c.logcatbrowser, null);
        removeAllViews();
        addView(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.b.logcatHeaderMenuButton);
        imageView.setOnClickListener(new 1(this, imageView));
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Logcat", 0);
        int i = sharedPreferences.getInt("FilterType", -1);
        String string = sharedPreferences.getString("FilterValue", "");
        this.DW = i >= 0;
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                getConsole().FH(string);
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                getConsole().Hw(string);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                getConsole().DW(string);
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                getConsole().j6(string);
                break;
        }
        e.P8().j6((pj$b) this);
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        XL();
    }

    private void XL() {
        pj P8 = e.P8();
        boolean z = isShown() && !this.j6;
        P8.j6(z);
    }

    public void FH() {
        this.j6 = false;
        XL();
    }

    public boolean Hw() {
        return this.j6;
    }

    public void v5() {
        this.j6 = true;
        XL();
    }

    public void Zo() {
        getConsole().gn();
    }

    public void j6(pj$a pj_a) {
        getConsole().j6(pj_a);
    }

    public void VH() {
        getConsole().DW();
    }

    private LogCatConsole getConsole() {
        return (LogCatConsole) findViewById(R.b.logcatConsole);
    }

    private void j6(int i, String str) {
        boolean z = false;
        Editor edit = getContext().getSharedPreferences("Logcat", 0).edit();
        edit.putInt("FilterType", i);
        edit.putString("FilterValue", str);
        edit.commit();
        if (i >= 0) {
            z = true;
        }
        this.DW = z;
    }

    public void gn() {
        String u7 = e.a8().u7();
        if (ok.P8(u7)) {
            u7 = ok.DW(u7, e.a8().v5());
            j6(3, u7);
            getConsole().j6(u7);
        }
    }

    public void u7() {
        m.j6(e.u7(), "Process", getConsole().getAllProcesses(), new 2(this));
    }

    public void tp() {
        m.j6(e.u7(), "Tag", getConsole().getAllTags(), new 3(this));
    }

    public void EQ() {
        m.j6(e.u7(), "Priority", getConsole().getAllPriortities(), new 4(this));
    }

    public boolean we() {
        return this.DW;
    }

    public void J0() {
        j6(-1, "");
        getConsole().VH();
    }

    public void j6() {
        getConsole().BT();
    }

    public void J8() {
        getConsole().j6();
    }

    public void DW() {
        XL();
        e.P8().DW();
    }

    public void Ws() {
        getConsole().yS();
    }
}
