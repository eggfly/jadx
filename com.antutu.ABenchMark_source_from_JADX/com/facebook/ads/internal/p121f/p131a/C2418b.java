package com.facebook.ads.internal.p121f.p131a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.p121f.C2463j;
import com.facebook.ads.internal.p121f.C2465l;

/* renamed from: com.facebook.ads.internal.f.a.b */
public class C2418b extends LinearLayout {
    private ImageView f8359a;
    private C2417a f8360b;
    private TextView f8361c;
    private LinearLayout f8362d;

    public C2418b(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes, boolean z, int i) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setVerticalGravity(16);
        setOrientation(1);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density));
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        this.f8362d = new LinearLayout(getContext());
        layoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.f8362d.setOrientation(0);
        this.f8362d.setGravity(16);
        layoutParams.weight = 3.0f;
        this.f8362d.setLayoutParams(layoutParams);
        linearLayout.addView(this.f8362d);
        this.f8359a = new C2419c(getContext());
        int a = m9267a(z, i);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Math.round(((float) a) * displayMetrics.density), Math.round(((float) a) * displayMetrics.density));
        layoutParams2.setMargins(0, 0, Math.round(15.0f * displayMetrics.density), 0);
        this.f8359a.setLayoutParams(layoutParams2);
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), this.f8359a);
        this.f8362d.addView(this.f8359a);
        View linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        this.f8362d.addView(linearLayout2);
        this.f8360b = new C2417a(getContext(), nativeAd, nativeAdViewAttributes);
        layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.setMargins(0, 0, Math.round(15.0f * displayMetrics.density), 0);
        layoutParams2.weight = 0.5f;
        this.f8360b.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.f8360b);
        this.f8361c = new TextView(getContext());
        this.f8361c.setPadding(Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density));
        this.f8361c.setText(nativeAd.getAdCallToAction());
        this.f8361c.setTextColor(nativeAdViewAttributes.getButtonTextColor());
        this.f8361c.setTextSize(14.0f);
        this.f8361c.setTypeface(nativeAdViewAttributes.getTypeface(), 1);
        this.f8361c.setMaxLines(2);
        this.f8361c.setEllipsize(TruncateAt.END);
        this.f8361c.setGravity(17);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(nativeAdViewAttributes.getButtonColor());
        gradientDrawable.setCornerRadius(displayMetrics.density * 5.0f);
        gradientDrawable.setStroke(1, nativeAdViewAttributes.getButtonBorderColor());
        this.f8361c.setBackgroundDrawable(gradientDrawable);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.weight = 0.25f;
        this.f8361c.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.f8361c);
        if (z) {
            View c2465l = new C2465l(getContext());
            c2465l.setText(nativeAd.getAdBody());
            C2463j.m9385b(c2465l, nativeAdViewAttributes);
            c2465l.setMinTextSize((float) (nativeAdViewAttributes.getDescriptionTextSize() - 1));
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            c2465l.setLayoutParams(layoutParams);
            c2465l.setGravity(80);
            linearLayout.addView(c2465l);
        }
    }

    private int m9267a(boolean z, int i) {
        return (int) (((double) (i - 30)) * (3.0d / ((double) ((z ? 1 : 0) + 3))));
    }

    public TextView getCallToActionView() {
        return this.f8361c;
    }

    public ImageView getIconView() {
        return this.f8359a;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        TextView titleTextView = this.f8360b.getTitleTextView();
        if (titleTextView.getLayout().getLineEnd(titleTextView.getLineCount() - 1) < this.f8360b.getMinVisibleTitleCharacters()) {
            this.f8362d.removeView(this.f8359a);
            super.onMeasure(i, i2);
        }
    }
}
