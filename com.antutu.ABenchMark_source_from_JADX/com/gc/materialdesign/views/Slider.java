package com.gc.materialdesign.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.gc.materialdesign.C2513R;
import com.gc.materialdesign.p135a.C2514a;
import com.p063b.p077c.C1889a;
import com.xiaomi.pushsdk.BuildConfig;

public class Slider extends C2515b {
    private int f8677a;
    private C2518a f8678b;
    private Bitmap f8679c;
    private int f8680d;
    private int f8681e;
    private C2520c f8682f;
    private C2521d f8683g;
    private boolean f8684h;
    private boolean f8685i;
    private boolean f8686j;
    private int f8687k;

    /* renamed from: com.gc.materialdesign.views.Slider.1 */
    class C25171 implements Runnable {
        final /* synthetic */ int f8660a;
        final /* synthetic */ Slider f8661b;

        C25171(Slider slider, int i) {
            this.f8661b = slider;
            this.f8660a = i;
        }

        public void run() {
            this.f8661b.setValue(this.f8660a);
        }
    }

    /* renamed from: com.gc.materialdesign.views.Slider.a */
    class C2518a extends View {
        float f8662a;
        float f8663b;
        float f8664c;
        final /* synthetic */ Slider f8665d;

        public C2518a(Slider slider, Context context) {
            this.f8665d = slider;
            super(context);
            setBackgroundResource(C2513R.drawable.background_switch_ball_uncheck);
        }

        public void m9532a() {
            if (this.f8665d.f8687k != this.f8665d.f8681e) {
                setBackgroundResource(C2513R.drawable.background_checkbox);
                ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(C2513R.id.shape_bacground)).setColor(this.f8665d.f8677a);
                return;
            }
            setBackgroundResource(C2513R.drawable.background_switch_ball_uncheck);
        }
    }

    /* renamed from: com.gc.materialdesign.views.Slider.b */
    class C2519b extends RelativeLayout {
        boolean f8666a;
        float f8667b;
        float f8668c;
        boolean f8669d;
        float f8670e;
        float f8671f;
        float f8672g;
        final /* synthetic */ Slider f8673h;

        public C2519b(Slider slider, Context context) {
            this.f8673h = slider;
            super(context);
            this.f8666a = true;
            this.f8667b = 0.0f;
            this.f8668c = 0.0f;
            this.f8669d = false;
            this.f8670e = 0.0f;
            this.f8671f = 0.0f;
            this.f8672g = 0.0f;
            setBackgroundColor(getResources().getColor(17170445));
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.f8669d) {
                LayoutParams layoutParams = (LayoutParams) this.f8673h.f8682f.f8675b.getLayoutParams();
                layoutParams.height = ((int) this.f8667b) * 2;
                layoutParams.width = ((int) this.f8667b) * 2;
                this.f8673h.f8682f.f8675b.setLayoutParams(layoutParams);
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(this.f8673h.f8677a);
            if (this.f8666a) {
                if (this.f8672g == 0.0f) {
                    this.f8672g = this.f8668c + (this.f8667b * 2.0f);
                }
                this.f8672g -= (float) C2514a.m9521a(6.0f, getResources());
                this.f8670e += (float) C2514a.m9521a(2.0f, getResources());
            }
            canvas.drawCircle((((float) C2514a.m9523b((View) this.f8673h.f8678b.getParent())) + C1889a.m7120a(this.f8673h.f8678b)) + ((float) (this.f8673h.f8678b.getWidth() / 2)), this.f8672g, this.f8670e, paint);
            if (this.f8666a && this.f8670e >= this.f8667b) {
                this.f8666a = false;
            }
            if (!this.f8666a) {
                C1889a.m7121a(this.f8673h.f8682f.f8675b, ((((float) C2514a.m9523b((View) this.f8673h.f8678b.getParent())) + C1889a.m7120a(this.f8673h.f8678b)) + ((float) (this.f8673h.f8678b.getWidth() / 2))) - this.f8670e);
                C1889a.m7123b(this.f8673h.f8682f.f8675b, this.f8672g - this.f8670e);
                this.f8673h.f8682f.f8675b.setText(this.f8673h.f8687k + BuildConfig.FLAVOR);
            }
            invalidate();
        }
    }

    /* renamed from: com.gc.materialdesign.views.Slider.c */
    class C2520c extends Dialog {
        C2519b f8674a;
        TextView f8675b;
        final /* synthetic */ Slider f8676c;

        public C2520c(Slider slider, Context context) {
            this.f8676c = slider;
            super(context, 16973839);
        }

        public void dismiss() {
            super.dismiss();
            this.f8674a.f8672g = 0.0f;
            this.f8674a.f8670e = 0.0f;
            this.f8674a.f8666a = true;
        }

        public void onBackPressed() {
        }

        protected void onCreate(Bundle bundle) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setContentView(C2513R.layout.number_indicator_spinner);
            setCanceledOnTouchOutside(false);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(C2513R.id.number_indicator_spinner_content);
            this.f8674a = new C2519b(this.f8676c, getContext());
            relativeLayout.addView(this.f8674a);
            this.f8675b = new TextView(getContext());
            this.f8675b.setTextColor(-1);
            this.f8675b.setGravity(17);
            relativeLayout.addView(this.f8675b);
            this.f8674a.setLayoutParams(new LayoutParams(-1, -1));
        }
    }

    /* renamed from: com.gc.materialdesign.views.Slider.d */
    public interface C2521d {
        void m9533a(int i);
    }

    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8677a = Color.parseColor("#4CAF50");
        this.f8680d = 100;
        this.f8681e = 0;
        this.f8684h = false;
        this.f8685i = false;
        this.f8686j = false;
        this.f8687k = 0;
        setAttributes(attributeSet);
    }

    private void m9535a() {
        C1889a.m7121a(this.f8678b, (float) ((getHeight() / 2) - (this.f8678b.getWidth() / 2)));
        this.f8678b.f8662a = C1889a.m7120a(this.f8678b);
        this.f8678b.f8663b = (float) ((getWidth() - (getHeight() / 2)) - (this.f8678b.getWidth() / 2));
        this.f8678b.f8664c = (float) ((getWidth() / 2) - (this.f8678b.getWidth() / 2));
        this.f8684h = true;
    }

    public int getMax() {
        return this.f8680d;
    }

    public int getMin() {
        return this.f8681e;
    }

    public C2521d getOnValueChangedListener() {
        return this.f8683g;
    }

    public int getValue() {
        return this.f8687k;
    }

    public void invalidate() {
        this.f8678b.invalidate();
        super.invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f8684h) {
            m9535a();
        }
        Paint paint = new Paint();
        if (this.f8687k == this.f8681e) {
            if (this.f8679c == null) {
                this.f8679c = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Config.ARGB_8888);
            }
            Canvas canvas2 = new Canvas(this.f8679c);
            paint.setColor(Color.parseColor("#B0B0B0"));
            paint.setStrokeWidth((float) C2514a.m9521a(2.0f, getResources()));
            canvas2.drawLine((float) (getHeight() / 2), (float) (getHeight() / 2), (float) (getWidth() - (getHeight() / 2)), (float) (getHeight() / 2), paint);
            Paint paint2 = new Paint();
            paint2.setColor(getResources().getColor(17170445));
            paint2.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
            canvas2.drawCircle(C1889a.m7120a(this.f8678b) + ((float) (this.f8678b.getWidth() / 2)), C1889a.m7122b(this.f8678b) + ((float) (this.f8678b.getHeight() / 2)), (float) (this.f8678b.getWidth() / 2), paint2);
            canvas.drawBitmap(this.f8679c, 0.0f, 0.0f, new Paint());
        } else {
            paint.setColor(Color.parseColor("#B0B0B0"));
            paint.setStrokeWidth((float) C2514a.m9521a(2.0f, getResources()));
            canvas.drawLine((float) (getHeight() / 2), (float) (getHeight() / 2), (float) (getWidth() - (getHeight() / 2)), (float) (getHeight() / 2), paint);
            paint.setColor(this.f8677a);
            canvas.drawLine((float) (getHeight() / 2), (float) (getHeight() / 2), ((float) (getHeight() / 2)) + (((this.f8678b.f8663b - this.f8678b.f8662a) / ((float) (this.f8680d - this.f8681e))) * ((float) (this.f8687k - this.f8681e))), (float) (getHeight() / 2), paint);
        }
        if (this.f8685i && !this.f8686j) {
            paint.setColor(this.f8677a);
            paint.setAntiAlias(true);
            canvas.drawCircle(C1889a.m7120a(this.f8678b) + ((float) (this.f8678b.getWidth() / 2)), (float) (getHeight() / 2), (float) (getHeight() / 3), paint);
        }
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.q = true;
        if (isEnabled()) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                if (!(this.f8682f == null || this.f8682f.isShowing())) {
                    this.f8682f.show();
                }
                if (motionEvent.getX() > ((float) getWidth()) || motionEvent.getX() < 0.0f) {
                    this.f8685i = false;
                    this.q = false;
                    if (this.f8682f != null) {
                        this.f8682f.dismiss();
                    }
                } else {
                    int i;
                    this.f8685i = true;
                    float f = (this.f8678b.f8663b - this.f8678b.f8662a) / ((float) (this.f8680d - this.f8681e));
                    if (motionEvent.getX() > this.f8678b.f8663b) {
                        i = this.f8680d;
                    } else if (motionEvent.getX() < this.f8678b.f8662a) {
                        i = this.f8681e;
                    } else {
                        i = ((int) ((motionEvent.getX() - this.f8678b.f8662a) / f)) + this.f8681e;
                    }
                    if (this.f8687k != i) {
                        this.f8687k = i;
                        if (this.f8683g != null) {
                            this.f8683g.m9533a(i);
                        }
                    }
                    f = motionEvent.getX();
                    if (f < this.f8678b.f8662a) {
                        f = this.f8678b.f8662a;
                    }
                    if (f > this.f8678b.f8663b) {
                        f = this.f8678b.f8663b;
                    }
                    C1889a.m7121a(this.f8678b, f);
                    this.f8678b.m9532a();
                    if (this.f8682f != null) {
                        this.f8682f.f8674a.f8671f = f;
                        this.f8682f.f8674a.f8668c = (float) (C2514a.m9522a(this) - (getHeight() / 2));
                        this.f8682f.f8674a.f8667b = (float) (getHeight() / 2);
                        this.f8682f.f8675b.setText(BuildConfig.FLAVOR);
                    }
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (this.f8682f != null) {
                    this.f8682f.dismiss();
                }
                this.q = false;
                this.f8685i = false;
            }
        }
        return true;
    }

    protected void setAttributes(AttributeSet attributeSet) {
        setBackgroundResource(C2513R.drawable.background_transparent);
        setMinimumHeight(C2514a.m9521a(48.0f, getResources()));
        setMinimumWidth(C2514a.m9521a(80.0f, getResources()));
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (attributeResourceValue != -1) {
            setBackgroundColor(getResources().getColor(attributeResourceValue));
        } else {
            attributeResourceValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
            if (attributeResourceValue != -1) {
                setBackgroundColor(attributeResourceValue);
            }
        }
        this.f8686j = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "showNumberIndicator", false);
        this.f8681e = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "min", 0);
        this.f8680d = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "max", 0);
        this.f8687k = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "value", this.f8681e);
        this.f8678b = new C2518a(this, getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(C2514a.m9521a(20.0f, getResources()), C2514a.m9521a(20.0f, getResources()));
        layoutParams.addRule(15, -1);
        this.f8678b.setLayoutParams(layoutParams);
        addView(this.f8678b);
        if (this.f8686j) {
            this.f8682f = new C2520c(this, getContext());
        }
    }

    public void setBackgroundColor(int i) {
        this.f8677a = i;
        if (isEnabled()) {
            this.p = this.f8677a;
        }
    }

    public void setMax(int i) {
        this.f8680d = i;
    }

    public void setMin(int i) {
        this.f8681e = i;
    }

    public void setOnValueChangedListener(C2521d c2521d) {
        this.f8683g = c2521d;
    }

    public void setShowNumberIndicator(boolean z) {
        this.f8686j = z;
        this.f8682f = z ? new C2520c(this, getContext()) : null;
    }

    public void setValue(int i) {
        if (this.f8684h) {
            this.f8687k = i;
            C1889a.m7121a(this.f8678b, ((((this.f8678b.f8663b - this.f8678b.f8662a) / ((float) this.f8680d)) * ((float) i)) + ((float) (getHeight() / 2))) - ((float) (this.f8678b.getWidth() / 2)));
            this.f8678b.m9532a();
            return;
        }
        post(new C25171(this, i));
    }
}
