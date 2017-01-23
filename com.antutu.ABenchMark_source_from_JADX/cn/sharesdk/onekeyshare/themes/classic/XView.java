package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class XView extends View {
    private float ratio;

    public XView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-6250336);
        float f = (float) height;
        canvas.drawRect((float) width, 0.0f, (float) getWidth(), f, paint);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3.0f * this.ratio);
        paint.setColor(-1);
        float f2 = 8.0f * this.ratio;
        canvas.drawLine(((float) width) + f2, f2, ((float) getWidth()) - f2, ((float) width) - f2, paint);
        canvas.drawLine(((float) width) + f2, ((float) width) - f2, ((float) getWidth()) - f2, f2, paint);
    }

    public void setRatio(float f) {
        this.ratio = f;
    }
}
