package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.gb;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.b */
class C2800b extends RelativeLayout {
    private static final float[] f9499a;
    private final RelativeLayout f9500b;
    private AnimationDrawable f9501c;

    static {
        f9499a = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    }

    public C2800b(Context context, C2799a c2799a) {
        super(context);
        C3512u.m14580a((Object) c2799a);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f9499a, null, null));
        shapeDrawable.getPaint().setColor(c2799a.m10780c());
        this.f9500b = new RelativeLayout(context);
        this.f9500b.setLayoutParams(layoutParams);
        C2968s.m11527g().m13082a(this.f9500b, shapeDrawable);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(c2799a.m10778a())) {
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            View textView = new TextView(context);
            textView.setLayoutParams(layoutParams2);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(c2799a.m10778a());
            textView.setTextColor(c2799a.m10781d());
            textView.setTextSize((float) c2799a.m10782e());
            textView.setPadding(C2784w.m10741a().m11560a(context, 4), 0, C2784w.m10741a().m11560a(context, 4), 0);
            this.f9500b.addView(textView);
            layoutParams.addRule(1, textView.getId());
        }
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(1195835394);
        List<Drawable> b = c2799a.m10779b();
        if (b.size() > 1) {
            this.f9501c = new AnimationDrawable();
            for (Drawable addFrame : b) {
                this.f9501c.addFrame(addFrame, c2799a.m10783f());
            }
            C2968s.m11527g().m13082a(imageView, this.f9501c);
        } else if (b.size() == 1) {
            imageView.setImageDrawable((Drawable) b.get(0));
        }
        this.f9500b.addView(imageView);
        addView(this.f9500b);
    }

    public ViewGroup m10784a() {
        return this.f9500b;
    }

    public void onAttachedToWindow() {
        if (this.f9501c != null) {
            this.f9501c.start();
        }
        super.onAttachedToWindow();
    }
}
