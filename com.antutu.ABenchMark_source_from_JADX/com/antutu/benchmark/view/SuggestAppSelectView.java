package com.antutu.benchmark.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;

public class SuggestAppSelectView extends RelativeLayout {
    private Context f5875a;
    private boolean f5876b;
    private ImageView f5877c;
    private ImageView f5878d;
    private TextView f5879e;
    private RelativeLayout f5880f;
    private C1178a f5881g;
    private OnClickListener f5882h;

    /* renamed from: com.antutu.benchmark.view.SuggestAppSelectView.a */
    public interface C1178a {
        void m4945a(boolean z);
    }

    /* renamed from: com.antutu.benchmark.view.SuggestAppSelectView.1 */
    class C16391 implements OnClickListener {
        final /* synthetic */ SuggestAppSelectView f5874a;

        C16391(SuggestAppSelectView suggestAppSelectView) {
            this.f5874a = suggestAppSelectView;
        }

        public void onClick(View view) {
            this.f5874a.m6480a();
        }
    }

    public SuggestAppSelectView(Context context) {
        this(context, null, 0);
    }

    public SuggestAppSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SuggestAppSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5876b = true;
        this.f5882h = new C16391(this);
        m6479a(context, attributeSet, i);
    }

    private void m6479a(Context context, AttributeSet attributeSet, int i) {
        this.f5875a = context;
        View.inflate(context, C1082R.layout.view_suggest_app, this);
        this.f5880f = (RelativeLayout) findViewById(C1082R.id.rl_bg);
        this.f5877c = (ImageView) findViewById(C1082R.id.iv_image);
        this.f5878d = (ImageView) findViewById(C1082R.id.iv_checked_image);
        this.f5879e = (TextView) findViewById(C1082R.id.tv_bottom_text);
        this.f5880f.setOnClickListener(this.f5882h);
    }

    public void m6480a() {
        setChecked(!this.f5876b);
    }

    public boolean getChecked() {
        return this.f5876b;
    }

    public void setChecked(boolean z) {
        this.f5876b = z;
        if (z) {
            this.f5878d.setImageResource(C1082R.drawable.choosed);
        } else {
            this.f5878d.setImageResource(C1082R.drawable.not_choose);
        }
        if (this.f5881g != null) {
            this.f5881g.m4945a(z);
        }
    }

    public void setImage(int i) {
        this.f5877c.setImageResource(i);
    }

    public void setImage(Bitmap bitmap) {
        this.f5877c.setImageBitmap(bitmap);
    }

    public void setImage(Drawable drawable) {
        this.f5877c.setImageDrawable(drawable);
    }

    public void setOnChangeCheckListener(C1178a c1178a) {
        this.f5881g = c1178a;
    }

    public void setText(String str) {
        this.f5879e.setText(str);
    }
}
