package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.ImageView;

public class RotateImageView extends ImageView {
    private float rotation;

    public RotateImageView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        canvas.rotate(this.rotation, (float) (getWidth() / 2), (float) (getHeight() / 2));
        super.onDraw(canvas);
    }

    public void setRotation(float f) {
        this.rotation = f;
        invalidate();
    }
}
