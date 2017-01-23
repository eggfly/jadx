package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.antutu.utils.widget.SystemBarTintManager;
import com.mob.tools.MobLog;
import com.mob.tools.gui.BitmapProcessor.BitmapCallback;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.UIHandler;
import com.taobao.accs.ErrorCode;
import java.util.Random;

public class AsyncImageView extends ImageView implements Callback, BitmapCallback {
    private static final int MSG_IMG_GOT = 1;
    private static final Random rnd;
    private Bitmap defaultBm;
    private int defaultRes;
    private Path path;
    private float[] rect;
    private boolean scaleToCrop;
    private String url;

    static {
        rnd = new Random();
    }

    public AsyncImageView(Context context) {
        super(context);
        init(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private int[] getSize() {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                width = layoutParams.width;
                height = layoutParams.height;
            }
        }
        if (width == 0 || r0 == 0) {
            measure(0, 0);
            width = getMeasuredWidth();
            height = getMeasuredHeight();
        }
        return new int[]{width, height};
    }

    private Bitmap goCrop(Bitmap bitmap) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        if (!(width == 0.0f || height == 0.0f)) {
            int[] size = getSize();
            if (!(size[0] == 0 || size[MSG_IMG_GOT] == 0)) {
                float f = (((float) size[MSG_IMG_GOT]) * width) / ((float) size[0]);
                if (f != height) {
                    int[] iArr = new int[4];
                    if (f < height) {
                        iArr[MSG_IMG_GOT] = (int) ((height - f) / 2.0f);
                        iArr[3] = iArr[MSG_IMG_GOT];
                    } else {
                        iArr[0] = (int) ((width - ((height * ((float) size[0])) / ((float) size[MSG_IMG_GOT]))) / 2.0f);
                        iArr[2] = iArr[0];
                    }
                    try {
                        bitmap = BitmapHelper.cropBitmap(bitmap, iArr[0], iArr[MSG_IMG_GOT], iArr[2], iArr[3]);
                    } catch (Throwable th) {
                        MobLog.getInstance().m4388w(th);
                    }
                }
            }
        }
        return bitmap;
    }

    private void init(Context context) {
        if (isInEditMode()) {
            setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        } else {
            BitmapProcessor.prepare(context);
        }
    }

    public void execute(String str, int i) {
        this.url = str;
        this.defaultRes = i;
        if (TextUtils.isEmpty(str)) {
            setImageResource(i);
            return;
        }
        Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(str);
        if (bitmapFromCache == null || bitmapFromCache.isRecycled()) {
            if (i > 0) {
                setImageResource(i);
            }
            BitmapProcessor.process(str, this);
            return;
        }
        setBitmap(bitmapFromCache);
    }

    public void execute(String str, Bitmap bitmap) {
        this.url = str;
        this.defaultBm = bitmap;
        if (TextUtils.isEmpty(str)) {
            setImageBitmap(bitmap);
            return;
        }
        Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(str);
        if (bitmapFromCache == null || bitmapFromCache.isRecycled()) {
            if (!(bitmap == null || bitmap.isRecycled())) {
                setImageBitmap(bitmap);
            }
            BitmapProcessor.process(str, this);
            return;
        }
        setBitmap(bitmapFromCache);
    }

    public boolean handleMessage(Message message) {
        if (message.what == MSG_IMG_GOT) {
            Object obj = ((Object[]) message.obj)[0];
            Object obj2 = ((Object[]) message.obj)[MSG_IMG_GOT];
            if (obj2 != null && obj != null && obj.equals(this.url)) {
                setImageBitmap((Bitmap) obj2);
            } else if (this.defaultBm == null || this.defaultBm.isRecycled()) {
                setImageResource(this.defaultRes);
            } else {
                setImageBitmap(this.defaultBm);
            }
        }
        return false;
    }

    protected void onDraw(Canvas canvas) {
        if (this.rect != null) {
            if (this.path == null) {
                int width = getWidth();
                int height = getHeight();
                this.path = new Path();
                this.path.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), this.rect, Direction.CW);
            }
            canvas.clipPath(this.path);
        }
        super.onDraw(canvas);
    }

    public void onImageGot(String str, Bitmap bitmap) {
        Bitmap bitmap2 = null;
        if (str != null && str.trim().length() > 0 && str.equals(this.url)) {
            bitmap2 = bitmap;
        }
        if (bitmap2 != null && this.scaleToCrop) {
            bitmap2 = goCrop(bitmap2);
        }
        Message message = new Message();
        message.what = MSG_IMG_GOT;
        message.obj = new Object[]{str, bitmap2};
        UIHandler.sendMessageDelayed(message, (long) rnd.nextInt(ErrorCode.APP_NOT_BIND), this);
        UIHandler.sendMessage(message, this);
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.scaleToCrop) {
            bitmap = goCrop(bitmap);
        }
        setImageBitmap(bitmap);
    }

    public void setRound(float f) {
        setRound(f, f, f, f);
    }

    public void setRound(float f, float f2, float f3, float f4) {
        this.rect = new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    public void setScaleToCropCenter(boolean z) {
        this.scaleToCrop = z;
    }
}
