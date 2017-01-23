package com.antutu.utils.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;

public class MultiButton extends SurfaceView implements Callback {
    private float bigR;
    private Bitmap bitmap;
    private Paint cmPaint;
    private int color;
    private Paint colorPaint;
    private int[] colors;
    private Paint ctxtPaint;
    private float fColorWidth;
    private float fWhiteWidth;
    private int height;
    private PositionText[] list;
    private int mMaxCountPosy;
    private PositionImage mPosImg;
    private PositionText mPosText;
    private TextView mText;
    private int max_count;
    private float scale;
    private float smallR;
    private String tip_str;
    private Paint txtPaint;
    private Paint whitePaint;
    private int width;
    private float f6311x;
    private float f6312y;

    class PositionImage {
        private int f6307x;
        private int f6308y;

        public PositionImage(int i, int i2) {
            this.f6307x = i;
            this.f6308y = i2;
        }
    }

    class PositionText {
        private int f6309x;
        private int f6310y;

        public PositionText(int i, int i2) {
            this.f6309x = i;
            this.f6310y = i2;
        }
    }

    public MultiButton(Context context) {
        super(context);
        this.f6312y = 0.0f;
        this.max_count = 0;
        this.colors = new int[]{-1862336512, -1879047937, -1878982912, -1878982657, -1862336257, -1862271232, -1870100344, -1865626420};
        this.list = new PositionText[20];
    }

    public MultiButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6312y = 0.0f;
        this.max_count = 0;
        this.colors = new int[]{-1862336512, -1879047937, -1878982912, -1878982657, -1862336257, -1862271232, -1870100344, -1865626420};
        this.list = new PositionText[20];
    }

    public MultiButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6312y = 0.0f;
        this.max_count = 0;
        this.colors = new int[]{-1862336512, -1879047937, -1878982912, -1878982657, -1862336257, -1862271232, -1870100344, -1865626420};
        this.list = new PositionText[20];
    }

    private void initPosition(Activity activity, int i) {
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        activity.getWindowManager().getDefaultDisplay().getHeight();
        int dimension = (int) getResources().getDimension(C1082R.dimen.imgPaddingTop);
        this.mPosImg = new PositionImage((width - i) / 2, dimension);
        this.mPosText = new PositionText((width - ((int) this.cmPaint.measureText(getResources().getString(C1082R.string.touch_me)))) / 2, (this.bitmap.getHeight() + dimension) + 40);
        this.mMaxCountPosy = (int) ((((float) ((this.height * 2) / 3)) + this.cmPaint.getTextSize()) + 20.0f);
    }

    private Bitmap resizeImage(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = ((float) i) / ((float) width);
        float f2 = ((float) i) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void init(Activity activity) {
        getHolder().addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.color = activity.getResources().getColor(C1082R.color.dark_blue);
        this.width = activity.getWindowManager().getDefaultDisplay().getWidth();
        this.height = activity.getWindowManager().getDefaultDisplay().getHeight();
        if (this.width < this.height) {
            this.scale = ((float) this.width) / 480.0f;
        } else {
            this.scale = ((float) this.height) / 480.0f;
        }
        this.fWhiteWidth = 12.0f * this.scale;
        this.fColorWidth = 15.0f * this.scale;
        this.smallR = this.scale * 50.0f;
        this.bigR = this.smallR + this.fWhiteWidth;
        this.txtPaint = new Paint();
        this.txtPaint.setTextAlign(Align.LEFT);
        this.txtPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.txtPaint.setTextSize(this.scale * 50.0f);
        this.colorPaint = new Paint();
        this.colorPaint.setTextAlign(Align.LEFT);
        this.colorPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.colorPaint.setAntiAlias(true);
        this.colorPaint.setTextSize(30.0f * this.scale);
        this.colorPaint.setStyle(Style.STROKE);
        this.colorPaint.setStrokeWidth(this.fColorWidth * this.scale);
        this.whitePaint = new Paint();
        this.whitePaint.setTextAlign(Align.LEFT);
        this.whitePaint.setAntiAlias(true);
        this.whitePaint.setColor(-1);
        this.whitePaint.setTextSize(180.0f * this.scale);
        this.whitePaint.setStyle(Style.STROKE);
        this.whitePaint.setAlpha(144);
        this.ctxtPaint = new Paint();
        this.ctxtPaint.setTextAlign(Align.LEFT);
        this.ctxtPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.ctxtPaint.setAntiAlias(true);
        this.ctxtPaint.setColor(-1);
        this.ctxtPaint.setTextSize(200.0f * this.scale);
        this.cmPaint = new Paint();
        this.cmPaint.setAntiAlias(true);
        this.cmPaint.setColor(-16711936);
        this.cmPaint.setTextSize((float) ((int) getResources().getDimension(C1082R.dimen.tipSize)));
        this.bitmap = BitmapFactory.decodeResource(getResources(), C1082R.drawable.mt);
        int dimension = (int) getResources().getDimension(C1082R.dimen.multi_btn_width);
        this.bitmap = resizeImage(this.bitmap, dimension);
        initPosition(activity, dimension);
        this.tip_str = getResources().getString(C1082R.string.touch_me);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount > this.max_count) {
            this.max_count = pointerCount;
        }
        Canvas lockCanvas = getHolder().lockCanvas();
        if (lockCanvas == null) {
            return false;
        }
        int width = getWidth();
        int height = getHeight();
        if (this.f6312y < 2.0f) {
            this.f6311x = ((float) width) / 2.0f;
            this.f6312y = ((float) height) / 2.0f;
        }
        lockCanvas.drawColor(this.color);
        lockCanvas.drawBitmap(this.bitmap, (float) this.mPosImg.f6307x, (float) this.mPosImg.f6308y, null);
        lockCanvas.drawText(this.tip_str, (float) this.mPosText.f6309x, (float) this.mPosText.f6310y, this.cmPaint);
        Rect rect = new Rect();
        String valueOf = String.valueOf(this.max_count);
        this.ctxtPaint.getTextBounds(valueOf, 0, this.max_count > 9 ? 2 : 1, rect);
        if (this.max_count != 0) {
            lockCanvas.drawText(valueOf, this.f6311x - (((float) rect.width()) / 2.0f), (float) this.mMaxCountPosy, this.ctxtPaint);
        }
        int i = 0;
        while (i < pointerCount) {
            lockCanvas.drawCircle(motionEvent.getX(i), motionEvent.getY(i), this.smallR, this.whitePaint);
            this.colorPaint.setColor(this.colors[i % this.colors.length]);
            this.txtPaint.setColor(this.colors[i % this.colors.length]);
            lockCanvas.drawCircle(motionEvent.getX(i), motionEvent.getY(i), this.bigR, this.colorPaint);
            width = (((float) getWidth()) - motionEvent.getX(i) < this.bigR + this.fColorWidth || (motionEvent.getX(i) < this.f6311x && motionEvent.getX(i) > this.bigR + this.fColorWidth)) ? -1 : 1;
            height = (((float) getHeight()) - motionEvent.getY(i) < this.bigR + this.fColorWidth || (motionEvent.getY(i) < this.f6312y && motionEvent.getY(i) > this.bigR + this.fColorWidth)) ? -1 : 1;
            this.txtPaint.getTextBounds(String.valueOf(i + 1), 0, i < 9 ? 1 : 2, rect);
            if (width == 1) {
                if (height == 1) {
                    lockCanvas.drawText(String.valueOf(i + 1), motionEvent.getX(i) + ((this.fColorWidth + this.bigR) * 0.717f), (motionEvent.getY(i) + (((float) rect.height()) / 2.0f)) + ((this.fColorWidth + this.bigR) * 0.717f), this.txtPaint);
                } else {
                    lockCanvas.drawText(String.valueOf(i + 1), motionEvent.getX(i) + ((this.fColorWidth + this.bigR) * 0.717f), motionEvent.getY(i) - ((this.fColorWidth + this.bigR) * 0.717f), this.txtPaint);
                }
            } else if (height == 1) {
                lockCanvas.drawText(String.valueOf(i + 1), motionEvent.getX(i) - (((float) rect.width()) + ((this.fColorWidth + this.bigR) * 0.717f)), (motionEvent.getY(i) + ((float) rect.height())) + ((this.fColorWidth + this.bigR) * 0.717f), this.txtPaint);
            } else {
                lockCanvas.drawText(String.valueOf(i + 1), motionEvent.getX(i) - (((float) rect.width()) + ((this.fColorWidth + this.bigR) * 0.717f)), motionEvent.getY(i) - ((this.fColorWidth + this.bigR) * 0.717f), this.txtPaint);
            }
            i++;
        }
        if (action == 1) {
            if (motionEvent.getPointerCount() == 1) {
                lockCanvas.drawColor(this.color);
                lockCanvas.drawBitmap(this.bitmap, (float) this.mPosImg.f6307x, (float) this.mPosImg.f6308y, null);
                lockCanvas.drawText(this.tip_str, (float) this.mPosText.f6309x, (float) this.mPosText.f6310y, this.cmPaint);
            }
            if (this.max_count != 0) {
                this.ctxtPaint.getTextBounds(valueOf, 0, this.max_count > 9 ? 2 : 1, rect);
                lockCanvas.drawText(valueOf, this.f6311x - (((float) rect.width()) / 2.0f), (float) this.mMaxCountPosy, this.ctxtPaint);
            }
        }
        getHolder().unlockCanvasAndPost(lockCanvas);
        return true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Canvas lockCanvas = getHolder().lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(this.color);
            lockCanvas.drawBitmap(this.bitmap, (float) this.mPosImg.f6307x, (float) this.mPosImg.f6308y, null);
            lockCanvas.drawText(this.tip_str, (float) this.mPosText.f6309x, (float) this.mPosText.f6310y, this.cmPaint);
            getHolder().unlockCanvasAndPost(lockCanvas);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
