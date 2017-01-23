package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class IndicatorView extends View {
    private static final int DESIGN_BOTTOM_HEIGHT = 52;
    private static final int DESIGN_INDICATOR_DISTANCE = 14;
    private static final int DESIGN_INDICATOR_RADIUS = 6;
    private int count;
    private int current;

    public IndicatorView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        if (this.count <= 1) {
            setVisibility(8);
            return;
        }
        float height = (float) getHeight();
        float f = (6.0f * height) / 52.0f;
        float f2 = (14.0f * height) / 52.0f;
        float width = (((float) getWidth()) - (((f * 2.0f) * ((float) this.count)) + (((float) (this.count - 1)) * f2))) / 2.0f;
        float f3 = height / 2.0f;
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (int i = 0; i < this.count; i++) {
            if (i == this.current) {
                paint.setColor(-10653280);
            } else {
                paint.setColor(-5262921);
            }
            canvas.drawCircle((((f * 2.0f) + f2) * ((float) i)) + width, f3, f, paint);
        }
    }

    public void onScreenChange(int i, int i2) {
        if (i != this.current) {
            this.current = i;
            postInvalidate();
        }
    }

    public void setScreenCount(int i) {
        this.count = i;
    }
}
