package com.miui.support.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import java.text.NumberFormat;

public class ProgressDialog extends AlertDialog {
    private ProgressBar f1925a;
    private TextView f1926b;
    private int f1927c;
    private String f1928d;
    private NumberFormat f1929e;
    private int f1930f;
    private int f1931g;
    private int f1932h;
    private int f1933i;
    private int f1934j;
    private Drawable f1935k;
    private Drawable f1936l;
    private CharSequence f1937m;
    private boolean f1938n;
    private boolean f1939o;
    private Handler f1940p;

    /* renamed from: com.miui.support.app.ProgressDialog.1 */
    class C02381 extends Handler {
        final /* synthetic */ ProgressDialog f1924a;

        C02381(ProgressDialog progressDialog) {
            this.f1924a = progressDialog;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int progress = this.f1924a.f1925a.getProgress();
            int max = this.f1924a.f1925a.getMax();
            if (this.f1924a.f1929e != null) {
                double d = ((double) progress) / ((double) max);
                progress = 0;
                CharSequence spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(this.f1924a.f1937m)) {
                    progress = this.f1924a.f1937m.length();
                    spannableStringBuilder.append(this.f1924a.f1937m);
                }
                Object format = this.f1924a.f1929e.format(d);
                spannableStringBuilder.append(format);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f1924a.getContext().getResources().getColor(C0264R.color.progress_percent_color)), progress, format.length() + progress, 34);
                this.f1924a.f1926b.setText(spannableStringBuilder);
            }
        }
    }

    public ProgressDialog(Context context) {
        super(context);
        this.f1927c = 0;
        m3311a();
    }

    public ProgressDialog(Context context, int i) {
        super(context, i);
        this.f1927c = 0;
        m3311a();
    }

    private void m3311a() {
        this.f1928d = "%1d/%2d";
        this.f1929e = NumberFormat.getPercentInstance();
        this.f1929e.setMaximumFractionDigits(0);
    }

    protected void onCreate(Bundle bundle) {
        View inflate;
        LayoutInflater from = LayoutInflater.from(getContext());
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0264R.styleable.AlertDialog, 16842845, 0);
        if (this.f1927c == 1) {
            this.f1940p = new C02381(this);
            inflate = from.inflate(obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_horizontalProgressLayout, C0264R.layout.alert_dialog_progress), null);
        } else {
            inflate = from.inflate(obtainStyledAttributes.getResourceId(C0264R.styleable.AlertDialog_progressLayout, C0264R.layout.progress_dialog), null);
        }
        this.f1925a = (ProgressBar) inflate.findViewById(16908301);
        this.f1926b = (TextView) inflate.findViewById(C0234R.id.message);
        m2970a(inflate);
        obtainStyledAttributes.recycle();
        if (this.f1930f > 0) {
            m3322c(this.f1930f);
        }
        if (this.f1931g > 0) {
            m3316a(this.f1931g);
        }
        if (this.f1932h > 0) {
            m3320b(this.f1932h);
        }
        if (this.f1933i > 0) {
            m3323d(this.f1933i);
        }
        if (this.f1934j > 0) {
            m3324e(this.f1934j);
        }
        if (this.f1935k != null) {
            m3317a(this.f1935k);
        }
        if (this.f1936l != null) {
            m3321b(this.f1936l);
        }
        if (this.f1937m != null) {
            m3318a(this.f1937m);
        }
        m3319a(this.f1938n);
        m3313b();
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f1939o = true;
    }

    protected void onStop() {
        super.onStop();
        this.f1939o = false;
    }

    public void m3316a(int i) {
        if (this.f1939o) {
            this.f1925a.setProgress(i);
            m3313b();
            return;
        }
        this.f1931g = i;
    }

    public void m3320b(int i) {
        if (this.f1925a != null) {
            this.f1925a.setSecondaryProgress(i);
            m3313b();
            return;
        }
        this.f1932h = i;
    }

    public void m3322c(int i) {
        if (this.f1925a != null) {
            this.f1925a.setMax(i);
            m3313b();
            return;
        }
        this.f1930f = i;
    }

    public void m3323d(int i) {
        if (this.f1925a != null) {
            this.f1925a.incrementProgressBy(i);
            m3313b();
            return;
        }
        this.f1933i += i;
    }

    public void m3324e(int i) {
        if (this.f1925a != null) {
            this.f1925a.incrementSecondaryProgressBy(i);
            m3313b();
            return;
        }
        this.f1934j += i;
    }

    public void m3317a(Drawable drawable) {
        if (this.f1925a != null) {
            this.f1925a.setProgressDrawable(drawable);
        } else {
            this.f1935k = drawable;
        }
    }

    public void m3321b(Drawable drawable) {
        if (this.f1925a != null) {
            this.f1925a.setIndeterminateDrawable(drawable);
        } else {
            this.f1936l = drawable;
        }
    }

    public void m3319a(boolean z) {
        if (this.f1925a != null) {
            this.f1925a.setIndeterminate(z);
        } else {
            this.f1938n = z;
        }
    }

    public void m3318a(CharSequence charSequence) {
        if (this.f1925a != null) {
            if (this.f1927c == 1) {
                this.f1937m = charSequence;
            }
            this.f1926b.setText(charSequence);
            return;
        }
        this.f1937m = charSequence;
    }

    public void m3325f(int i) {
        this.f1927c = i;
    }

    private void m3313b() {
        if (this.f1927c == 1 && this.f1940p != null && !this.f1940p.hasMessages(0)) {
            this.f1940p.sendEmptyMessage(0);
        }
    }
}
