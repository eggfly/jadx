package com.miui.support.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.miui.support.internal.C0264R;

public class ArrowPopupContentWrapper extends LinearLayout {
    private Paint f3038a;
    private Bitmap f3039b;
    private Bitmap f3040c;
    private Bitmap f3041d;
    private Bitmap f3042e;

    public ArrowPopupContentWrapper(Context context) {
        this(context, null);
    }

    public ArrowPopupContentWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowPopupContentWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3038a = new Paint();
        this.f3038a.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        this.f3038a.setAntiAlias(true);
        Resources resources = getResources();
        this.f3039b = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_1);
        this.f3040c = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_2);
        this.f3041d = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_3);
        this.f3042e = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_4);
    }

    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        super.dispatchDraw(canvas);
        canvas.drawBitmap(this.f3039b, (float) (getPaddingLeft() + 0), (float) (getPaddingTop() + 0), this.f3038a);
        canvas.drawBitmap(this.f3040c, (float) ((getWidth() - this.f3040c.getWidth()) - getPaddingRight()), (float) (getPaddingTop() + 0), this.f3038a);
        canvas.drawBitmap(this.f3041d, (float) (getPaddingLeft() + 0), (float) ((getHeight() - this.f3041d.getHeight()) - getPaddingBottom()), this.f3038a);
        canvas.drawBitmap(this.f3042e, (float) ((getWidth() - this.f3042e.getWidth()) - getPaddingRight()), (float) ((getHeight() - this.f3042e.getHeight()) - getPaddingBottom()), this.f3038a);
        canvas.restore();
    }
}
