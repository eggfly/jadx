package com.facebook.ads;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2510r;

public class AdChoicesView extends RelativeLayout {
    private final Context f7747a;
    private final NativeAd f7748b;
    private final DisplayMetrics f7749c;
    private boolean f7750d;
    private TextView f7751e;
    private String f7752f;

    /* renamed from: com.facebook.ads.AdChoicesView.1 */
    class C22481 implements OnTouchListener {
        final /* synthetic */ AdChoicesView f7738a;

        C22481(AdChoicesView adChoicesView) {
            this.f7738a = adChoicesView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!this.f7738a.f7750d) {
                this.f7738a.m8508a();
            } else if (!C2510r.m9516a(this.f7738a.f7748b.getAdChoicesLinkUrl())) {
                C2498g.m9476a(this.f7738a.f7747a, Uri.parse(this.f7738a.f7748b.getAdChoicesLinkUrl()));
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.AdChoicesView.2 */
    class C22492 extends Animation {
        final /* synthetic */ int f7739a;
        final /* synthetic */ int f7740b;
        final /* synthetic */ AdChoicesView f7741c;

        C22492(AdChoicesView adChoicesView, int i, int i2) {
            this.f7741c = adChoicesView;
            this.f7739a = i;
            this.f7740b = i2;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            int i = (int) (((float) this.f7739a) + (((float) (this.f7740b - this.f7739a)) * f));
            this.f7741c.getLayoutParams().width = i;
            this.f7741c.requestLayout();
            this.f7741c.f7751e.getLayoutParams().width = i - this.f7739a;
            this.f7741c.f7751e.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    /* renamed from: com.facebook.ads.AdChoicesView.3 */
    class C22523 implements AnimationListener {
        final /* synthetic */ int f7744a;
        final /* synthetic */ int f7745b;
        final /* synthetic */ AdChoicesView f7746c;

        /* renamed from: com.facebook.ads.AdChoicesView.3.1 */
        class C22511 implements Runnable {
            final /* synthetic */ C22523 f7743a;

            /* renamed from: com.facebook.ads.AdChoicesView.3.1.1 */
            class C22501 extends Animation {
                final /* synthetic */ C22511 f7742a;

                C22501(C22511 c22511) {
                    this.f7742a = c22511;
                }

                protected void applyTransformation(float f, Transformation transformation) {
                    int i = (int) (((float) this.f7742a.f7743a.f7744a) + (((float) (this.f7742a.f7743a.f7745b - this.f7742a.f7743a.f7744a)) * f));
                    this.f7742a.f7743a.f7746c.getLayoutParams().width = i;
                    this.f7742a.f7743a.f7746c.requestLayout();
                    this.f7742a.f7743a.f7746c.f7751e.getLayoutParams().width = i - this.f7742a.f7743a.f7745b;
                    this.f7742a.f7743a.f7746c.f7751e.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            }

            C22511(C22523 c22523) {
                this.f7743a = c22523;
            }

            public void run() {
                if (this.f7743a.f7746c.f7750d) {
                    this.f7743a.f7746c.f7750d = false;
                    Animation c22501 = new C22501(this);
                    c22501.setDuration(300);
                    c22501.setFillAfter(true);
                    this.f7743a.f7746c.startAnimation(c22501);
                }
            }
        }

        C22523(AdChoicesView adChoicesView, int i, int i2) {
            this.f7746c = adChoicesView;
            this.f7744a = i;
            this.f7745b = i2;
        }

        public void onAnimationEnd(Animation animation) {
            new Handler().postDelayed(new C22511(this), 3000);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public AdChoicesView(Context context, NativeAd nativeAd) {
        this(context, nativeAd, false);
    }

    public AdChoicesView(Context context, NativeAd nativeAd, boolean z) {
        super(context);
        this.f7750d = false;
        this.f7747a = context;
        this.f7748b = nativeAd;
        this.f7749c = this.f7747a.getResources().getDisplayMetrics();
        if (!this.f7748b.isAdLoaded() || this.f7748b.m8619a().m8736g()) {
            this.f7752f = this.f7748b.m8622b();
            if (C2510r.m9516a(this.f7752f)) {
                this.f7752f = "AdChoices";
            }
            Image adChoicesIcon = this.f7748b.getAdChoicesIcon();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            setOnTouchListener(new C22481(this));
            this.f7751e = new TextView(this.f7747a);
            addView(this.f7751e);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (!z || adChoicesIcon == null) {
                this.f7750d = true;
            } else {
                layoutParams2.addRule(11, m8507a(adChoicesIcon).getId());
                layoutParams2.width = 0;
                layoutParams.width = Math.round(((float) (adChoicesIcon.getWidth() + 4)) * this.f7749c.density);
                layoutParams.height = Math.round(((float) (adChoicesIcon.getHeight() + 2)) * this.f7749c.density);
                this.f7750d = false;
            }
            setLayoutParams(layoutParams);
            layoutParams2.addRule(15, -1);
            this.f7751e.setLayoutParams(layoutParams2);
            this.f7751e.setSingleLine();
            this.f7751e.setText(this.f7752f);
            this.f7751e.setTextSize(10.0f);
            this.f7751e.setTextColor(-4341303);
            return;
        }
        setVisibility(8);
    }

    private ImageView m8507a(Image image) {
        View imageView = new ImageView(this.f7747a);
        addView(imageView);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(((float) image.getWidth()) * this.f7749c.density), Math.round(((float) image.getHeight()) * this.f7749c.density));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(4.0f * this.f7749c.density), Math.round(this.f7749c.density * 2.0f), Math.round(this.f7749c.density * 2.0f), Math.round(this.f7749c.density * 2.0f));
        imageView.setLayoutParams(layoutParams);
        NativeAd.downloadAndDisplayImage(image, imageView);
        return imageView;
    }

    private void m8508a() {
        Paint paint = new Paint();
        paint.setTextSize(this.f7751e.getTextSize());
        int round = Math.round(paint.measureText(this.f7752f) + (4.0f * this.f7749c.density));
        int width = getWidth();
        round += width;
        this.f7750d = true;
        Animation c22492 = new C22492(this, width, round);
        c22492.setAnimationListener(new C22523(this, round, width));
        c22492.setDuration(300);
        c22492.setFillAfter(true);
        startAnimation(c22492);
    }
}
