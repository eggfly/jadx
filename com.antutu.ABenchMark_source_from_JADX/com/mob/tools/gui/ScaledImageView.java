package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.utils.BitmapHelper;
import org.android.spdy.SpdyProtocol;

public class ScaledImageView extends ImageView implements OnTouchListener {
    private static final int DRAG_1 = 1;
    private static final int DRAG_2 = 2;
    private static final int NONE = 0;
    private static final int ZOOM = 3;
    private Bitmap bitmap;
    private float distSquare;
    private float[] downPoint;
    private int dragScrollMinDistSquare;
    private OnMatrixChangedListener listener;
    private Matrix matrix;
    private int mode;
    private Matrix savedMatrix;

    public interface OnMatrixChangedListener {
        void onMactrixChage(Matrix matrix);
    }

    public ScaledImageView(Context context) {
        super(context);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.dragScrollMinDistSquare = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dragScrollMinDistSquare *= this.dragScrollMinDistSquare;
        setOnTouchListener(this);
    }

    public Bitmap getCropedBitmap(Rect rect) {
        try {
            Bitmap captureView = BitmapHelper.captureView(this, getWidth(), getHeight());
            if (captureView == null) {
                MobLog.getInstance().m4387w("ivPhoto.getDrawingCache() returns null", new Object[NONE]);
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(captureView, rect.left, rect.top, rect.width(), rect.height());
            captureView.recycle();
            return createBitmap;
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
            return null;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            float[] fArr;
            float x;
            float[] fArr2;
            float f;
            switch (motionEvent.getAction()) {
                case NONE /*0*/:
                    this.matrix = new Matrix();
                    this.matrix.set(getImageMatrix());
                    this.savedMatrix = new Matrix();
                    this.savedMatrix.set(this.matrix);
                    fArr = new float[DRAG_2];
                    fArr[NONE] = motionEvent.getX(NONE);
                    fArr[DRAG_1] = motionEvent.getY(NONE);
                    this.downPoint = fArr;
                    this.mode = DRAG_1;
                    break;
                case DRAG_1 /*1*/:
                    if (this.listener != null) {
                        this.listener.onMactrixChage(this.matrix);
                    }
                    x = motionEvent.getX(NONE) - this.downPoint[NONE];
                    float y = motionEvent.getY(NONE) - this.downPoint[DRAG_1];
                    if (this.mode == DRAG_1 && (x * x) + (y * y) <= ((float) this.dragScrollMinDistSquare)) {
                        performClick();
                    }
                    this.mode = NONE;
                    break;
                case DRAG_2 /*2*/:
                    if (this.mode != DRAG_1) {
                        if (this.mode != DRAG_2) {
                            if (this.mode == ZOOM) {
                                fArr = new float[DRAG_2];
                                fArr[NONE] = motionEvent.getX(NONE);
                                fArr[DRAG_1] = motionEvent.getY(NONE);
                                fArr2 = new float[DRAG_2];
                                fArr2[NONE] = motionEvent.getX(DRAG_1);
                                fArr2[DRAG_1] = motionEvent.getY(DRAG_1);
                                f = fArr[NONE] - fArr2[NONE];
                                float f2 = fArr[DRAG_1] - fArr2[DRAG_1];
                                f = (f * f) + (f2 * f2);
                                this.matrix.set(this.savedMatrix);
                                f = (float) Math.sqrt((double) (f / this.distSquare));
                                float[] fArr3 = new float[DRAG_2];
                                fArr3[NONE] = (fArr[NONE] + fArr2[NONE]) / 2.0f;
                                fArr3[DRAG_1] = (fArr[DRAG_1] + fArr2[DRAG_1]) / 2.0f;
                                this.matrix.postScale(f, f, fArr3[NONE], fArr3[DRAG_1]);
                                break;
                            }
                        }
                        fArr = new float[DRAG_2];
                        fArr[NONE] = motionEvent.getX(DRAG_1);
                        fArr[DRAG_1] = motionEvent.getY(DRAG_1);
                        this.matrix.set(this.savedMatrix);
                        this.matrix.postTranslate(fArr[NONE] - this.downPoint[NONE], fArr[DRAG_1] - this.downPoint[DRAG_1]);
                        break;
                    }
                    fArr = new float[DRAG_2];
                    fArr[NONE] = motionEvent.getX(NONE);
                    fArr[DRAG_1] = motionEvent.getY(NONE);
                    this.matrix.set(this.savedMatrix);
                    this.matrix.postTranslate(fArr[NONE] - this.downPoint[NONE], fArr[DRAG_1] - this.downPoint[DRAG_1]);
                    break;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    fArr = new float[DRAG_2];
                    fArr[NONE] = motionEvent.getX(NONE);
                    fArr[DRAG_1] = motionEvent.getY(NONE);
                    fArr2 = new float[DRAG_2];
                    fArr2[NONE] = motionEvent.getX(DRAG_1);
                    fArr2[DRAG_1] = motionEvent.getY(DRAG_1);
                    f = fArr[NONE] - fArr2[NONE];
                    x = fArr[DRAG_1] - fArr2[DRAG_1];
                    this.distSquare = (x * x) + (f * f);
                    this.mode = ZOOM;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    fArr = new float[DRAG_2];
                    fArr[NONE] = motionEvent.getX(DRAG_1);
                    fArr[DRAG_1] = motionEvent.getY(DRAG_1);
                    this.downPoint = fArr;
                    this.savedMatrix.set(this.matrix);
                    this.mode = DRAG_2;
                    break;
                case 261:
                    fArr = new float[DRAG_2];
                    fArr[NONE] = motionEvent.getX(NONE);
                    fArr[DRAG_1] = motionEvent.getY(NONE);
                    fArr2 = new float[DRAG_2];
                    fArr2[NONE] = motionEvent.getX(DRAG_1);
                    fArr2[DRAG_1] = motionEvent.getY(DRAG_1);
                    f = fArr[NONE] - fArr2[NONE];
                    x = fArr[DRAG_1] - fArr2[DRAG_1];
                    this.distSquare = (x * x) + (f * f);
                    this.mode = ZOOM;
                    break;
                case 262:
                    fArr = new float[DRAG_2];
                    fArr[NONE] = motionEvent.getX(NONE);
                    fArr[DRAG_1] = motionEvent.getY(NONE);
                    this.downPoint = fArr;
                    this.savedMatrix.set(this.matrix);
                    this.mode = DRAG_1;
                    break;
                default:
                    return false;
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
        return true;
    }

    public void rotateLeft() {
        try {
            this.matrix = new Matrix();
            float[] fArr = new float[]{0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            this.matrix.setValues(fArr);
            Bitmap createBitmap = Bitmap.createBitmap(this.bitmap, NONE, NONE, this.bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (!(createBitmap == null || createBitmap.isRecycled())) {
                this.bitmap.recycle();
                this.bitmap = createBitmap;
            }
            setImageBitmap(this.bitmap);
            this.matrix = new Matrix();
            this.matrix.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = new int[DRAG_2];
            iArr[NONE] = getWidth();
            iArr[DRAG_1] = getHeight();
            float[] fArr2 = new float[DRAG_2];
            fArr2[NONE] = fArr[NONE] * ((float) this.bitmap.getWidth());
            fArr2[DRAG_1] = fArr[4] * ((float) this.bitmap.getHeight());
            float[] fArr3 = new float[DRAG_2];
            fArr3[NONE] = (((float) iArr[NONE]) - fArr2[NONE]) / 2.0f;
            fArr3[DRAG_1] = (((float) iArr[DRAG_1]) - fArr2[DRAG_1]) / 2.0f;
            fArr[DRAG_2] = fArr3[NONE];
            fArr[5] = fArr3[DRAG_1];
            this.matrix.setValues(fArr);
            if (this.listener != null) {
                this.listener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    public void rotateRight() {
        try {
            this.matrix = new Matrix();
            float[] fArr = new float[]{0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            this.matrix.setValues(fArr);
            Bitmap createBitmap = Bitmap.createBitmap(this.bitmap, NONE, NONE, this.bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (!(createBitmap == null || createBitmap.isRecycled())) {
                this.bitmap.recycle();
                this.bitmap = createBitmap;
            }
            setImageBitmap(this.bitmap);
            this.matrix = new Matrix();
            this.matrix.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = new int[DRAG_2];
            iArr[NONE] = getWidth();
            iArr[DRAG_1] = getHeight();
            float[] fArr2 = new float[DRAG_2];
            fArr2[NONE] = fArr[NONE] * ((float) this.bitmap.getWidth());
            fArr2[DRAG_1] = fArr[4] * ((float) this.bitmap.getHeight());
            float[] fArr3 = new float[DRAG_2];
            fArr3[NONE] = (((float) iArr[NONE]) - fArr2[NONE]) / 2.0f;
            fArr3[DRAG_1] = (((float) iArr[DRAG_1]) - fArr2[DRAG_1]) / 2.0f;
            fArr[DRAG_2] = fArr3[NONE];
            fArr[5] = fArr3[DRAG_1];
            this.matrix.setValues(fArr);
            if (this.listener != null) {
                this.listener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().m4388w(th);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        setImageBitmap(bitmap);
        int[] iArr = new int[DRAG_2];
        iArr[NONE] = getWidth();
        iArr[DRAG_1] = getHeight();
        int[] iArr2 = new int[DRAG_2];
        iArr2[NONE] = this.bitmap.getWidth();
        iArr2[DRAG_1] = this.bitmap.getHeight();
        int[] fixRect = BitmapHelper.fixRect(iArr2, iArr);
        int[] iArr3 = new int[DRAG_2];
        iArr3[NONE] = (iArr[NONE] - fixRect[NONE]) / DRAG_2;
        iArr3[DRAG_1] = (iArr[DRAG_1] - fixRect[DRAG_1]) / DRAG_2;
        float[] fArr = new float[DRAG_2];
        fArr[NONE] = ((float) fixRect[NONE]) / ((float) iArr2[NONE]);
        fArr[DRAG_1] = ((float) fixRect[DRAG_1]) / ((float) iArr2[DRAG_1]);
        this.matrix = new Matrix();
        this.matrix.set(getImageMatrix());
        this.matrix.postScale(fArr[NONE], fArr[DRAG_1]);
        this.matrix.postTranslate((float) iArr3[NONE], (float) iArr3[DRAG_1]);
        if (this.listener != null) {
            this.listener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void setOnMatrixChangedListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.listener = onMatrixChangedListener;
        if (this.matrix != null) {
            if (this.listener != null) {
                this.listener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        }
    }

    public void zoomIn() {
        this.matrix = new Matrix();
        this.matrix.set(getImageMatrix());
        this.matrix.postScale(1.072f, 1.072f);
        if (this.listener != null) {
            this.listener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void zoomOut() {
        this.matrix = new Matrix();
        this.matrix.set(getImageMatrix());
        this.matrix.postScale(0.933f, 0.933f);
        if (this.listener != null) {
            this.listener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }
}
