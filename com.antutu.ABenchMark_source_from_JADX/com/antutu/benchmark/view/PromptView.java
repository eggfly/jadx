package com.antutu.benchmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;

public class PromptView extends LinearLayout {
    private boolean f5850a;
    private Context f5851b;
    private TextView f5852c;
    private ImageView f5853d;
    private LinearLayout f5854e;

    /* renamed from: com.antutu.benchmark.view.PromptView.1 */
    class C16361 implements OnClickListener {
        final /* synthetic */ PromptView f5849a;

        C16361(PromptView promptView) {
            this.f5849a = promptView;
        }

        public void onClick(View view) {
            this.f5849a.m6470b();
        }
    }

    public PromptView(Context context) {
        this(context, null, 0);
    }

    public PromptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5850a = false;
        this.f5851b = context;
        LayoutInflater.from(context).inflate(C1082R.layout.view_prompt, this);
        m6468e();
        m6467d();
    }

    private void m6467d() {
        this.f5853d.setOnClickListener(new C16361(this));
    }

    private void m6468e() {
        this.f5852c = (TextView) findViewById(C1082R.id.tv_prompt);
        this.f5853d = (ImageView) findViewById(C1082R.id.iv_close);
        this.f5853d.setVisibility(8);
        this.f5854e = (LinearLayout) findViewById(C1082R.id.ll_bg);
    }

    public void m6469a() {
        setVisibility(0);
        this.f5850a = true;
    }

    public void m6470b() {
        setVisibility(8);
        this.f5850a = false;
    }

    public boolean m6471c() {
        return this.f5850a;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f5854e.setOnClickListener(onClickListener);
    }

    public void setText(int i) {
        this.f5852c.setText(i);
    }

    public void setText(String str) {
        this.f5852c.setText(str);
    }
}
