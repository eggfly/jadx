package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer.RoundedDrawable;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class RoundedVignetteBitmapDisplayer extends RoundedBitmapDisplayer {

    protected static class RoundedVignetteDrawable extends RoundedDrawable {
        RoundedVignetteDrawable(Bitmap bitmap, int i, int i2) {
            super(bitmap, i, i2);
        }

        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            Shader radialGradient = new RadialGradient(this.mRect.centerX(), (this.mRect.centerY() * 1.0f) / 0.7f, this.mRect.centerX() * 1.3f, new int[]{0, 0, 2130706432}, new float[]{0.0f, 0.7f, 1.0f}, TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 0.7f);
            radialGradient.setLocalMatrix(matrix);
            this.paint.setShader(new ComposeShader(this.bitmapShader, radialGradient, Mode.SRC_OVER));
        }
    }

    public RoundedVignetteBitmapDisplayer(int i, int i2) {
        super(i, i2);
    }

    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware instanceof ImageViewAware) {
            imageAware.setImageDrawable(new RoundedVignetteDrawable(bitmap, this.cornerRadius, this.margin));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
