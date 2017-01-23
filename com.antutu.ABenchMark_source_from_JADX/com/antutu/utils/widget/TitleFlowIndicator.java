package com.antutu.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import java.util.ArrayList;

public class TitleFlowIndicator extends TextView implements FlowIndicator {
    private static final float CLIP_PADDING = 0.0f;
    private static final int FOOTER_COLOR = -15291;
    private static final float FOOTER_LINE_HEIGHT = 4.0f;
    private static final float FOOTER_TRIANGLE_HEIGHT = 10.0f;
    private static final int FOOTER_TYPE_LINE = 1;
    private static final int FOOTER_TYPE_NORMAL = 0;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final boolean SELECTED_BOLD = false;
    private static final int SELECTED_COLOR = -15291;
    private static final int SERIF = 2;
    private static final int TEXT_COLOR = -5592406;
    private static final float TITLE_PADDING = 10.0f;
    private int TEXT_SIZE;
    private float clipPadding;
    private int currentPosition;
    private int currentScroll;
    private int defCount;
    private float footerLineHeight;
    private float footerTriangleHeight;
    private int ifooterType;
    private Paint paintFooterLine;
    private Paint paintFooterTriangle;
    private Paint paintSelected;
    private Paint paintText;
    private Path path;
    private float titlePadding;
    private TitleProvider titleProvider;
    private Typeface typeface;
    private ViewFlow viewFlow;

    public TitleFlowIndicator(Context context) {
        super(context);
        this.currentScroll = FOOTER_TYPE_NORMAL;
        this.titleProvider = null;
        this.currentPosition = FOOTER_TYPE_NORMAL;
        this.defCount = SANS;
        this.TEXT_SIZE = 15;
        this.defCount = SANS;
        try {
            float f = (float) this.TEXT_SIZE;
            this.TEXT_SIZE = (int) (context.getResources().getDisplayMetrics().density * f);
        } catch (Exception e) {
        }
        initDraw(TEXT_COLOR, (float) this.TEXT_SIZE, SELECTED_COLOR, SELECTED_BOLD, (float) this.TEXT_SIZE, FOOTER_LINE_HEIGHT, SELECTED_COLOR);
    }

    public TitleFlowIndicator(Context context, AttributeSet attributeSet) {
        float f;
        super(context, attributeSet);
        this.currentScroll = FOOTER_TYPE_NORMAL;
        this.titleProvider = null;
        this.currentPosition = FOOTER_TYPE_NORMAL;
        this.defCount = SANS;
        this.TEXT_SIZE = 15;
        this.defCount = SANS;
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "typeface", FOOTER_TYPE_NORMAL);
        int attributeIntValue2 = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", FOOTER_TYPE_NORMAL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1082R.styleable.TitleFlowIndicator);
        try {
            f = (float) this.TEXT_SIZE;
            this.TEXT_SIZE = (int) (context.getResources().getDisplayMetrics().density * f);
        } catch (Exception e) {
        }
        String string = obtainStyledAttributes.getString(10);
        String string2 = obtainStyledAttributes.getString(11);
        int color = obtainStyledAttributes.getColor(8, SELECTED_COLOR);
        this.footerLineHeight = obtainStyledAttributes.getDimension(7, FOOTER_LINE_HEIGHT);
        this.footerTriangleHeight = obtainStyledAttributes.getDimension(9, TITLE_PADDING);
        int color2 = obtainStyledAttributes.getColor(SERIF, SELECTED_COLOR);
        boolean z = obtainStyledAttributes.getBoolean(MONOSPACE, SELECTED_BOLD);
        int color3 = obtainStyledAttributes.getColor(5, TEXT_COLOR);
        f = obtainStyledAttributes.getDimension(6, (float) this.TEXT_SIZE);
        float dimension = obtainStyledAttributes.getDimension(4, f);
        this.titlePadding = obtainStyledAttributes.getDimension(FOOTER_TYPE_NORMAL, TITLE_PADDING);
        this.clipPadding = obtainStyledAttributes.getDimension(SANS, CLIP_PADDING);
        obtainStyledAttributes.recycle();
        initDraw(color3, f, color2, z, dimension, this.footerLineHeight, color);
        if (string2 == null) {
            this.ifooterType = FOOTER_TYPE_NORMAL;
        } else if (string2.equals("line")) {
            this.ifooterType = SANS;
        } else {
            this.ifooterType = FOOTER_TYPE_NORMAL;
        }
        if (this.ifooterType != 0) {
            this.ifooterType = FOOTER_TYPE_NORMAL;
        }
        if (string != null) {
            this.typeface = Typeface.createFromAsset(context.getAssets(), string);
        } else {
            this.typeface = getTypefaceByIndex(attributeIntValue);
        }
        this.typeface = Typeface.create(this.typeface, attributeIntValue2);
    }

    private Rect calcBounds(int i, Paint paint) {
        String title = getTitle(i);
        Rect rect = new Rect();
        rect.right = (int) paint.measureText(title);
        rect.bottom = (int) (paint.descent() - paint.ascent());
        return rect;
    }

    private ArrayList<Rect> calculateAllBounds(Paint paint) {
        ArrayList<Rect> arrayList = new ArrayList();
        int count = (this.viewFlow == null || this.viewFlow.getAdapter() == null) ? this.defCount : this.viewFlow.getAdapter().getCount();
        for (int i = FOOTER_TYPE_NORMAL; i < count; i += SANS) {
            Rect calcBounds = calcBounds(i, paint);
            int i2 = calcBounds.right - calcBounds.left;
            int i3 = calcBounds.bottom - calcBounds.top;
            calcBounds.left = (((getWidth() / SERIF) - (i2 / SERIF)) - this.currentScroll) + (getWidth() * i);
            calcBounds.right = i2 + calcBounds.left;
            calcBounds.top = FOOTER_TYPE_NORMAL;
            calcBounds.bottom = i3;
            arrayList.add(calcBounds);
        }
        return arrayList;
    }

    private void clipViewOnTheLeft(Rect rect, int i) {
        rect.left = ((int) this.clipPadding) + FOOTER_TYPE_NORMAL;
        rect.right = i;
    }

    private void clipViewOnTheRight(Rect rect, int i) {
        rect.right = (getLeft() + getWidth()) - ((int) this.clipPadding);
        rect.left = rect.right - i;
    }

    private String getTitle(int i) {
        return this.titleProvider != null ? this.titleProvider.getTitle(i) : "title " + i;
    }

    private Typeface getTypefaceByIndex(int i) {
        switch (i) {
            case SANS /*1*/:
                return Typeface.SANS_SERIF;
            case SERIF /*2*/:
                return Typeface.SERIF;
            case MONOSPACE /*3*/:
                return Typeface.MONOSPACE;
            default:
                return Typeface.DEFAULT;
        }
    }

    private void initDraw(int i, float f, int i2, boolean z, float f2, float f3, int i3) {
        this.paintText = new Paint();
        this.paintText.setColor(i);
        this.paintText.setTextSize(f);
        this.paintText.setAntiAlias(true);
        this.paintSelected = new Paint();
        this.paintSelected.setColor(i2);
        this.paintSelected.setTextSize(f2);
        this.paintSelected.setFakeBoldText(z);
        this.paintSelected.setAntiAlias(true);
        this.paintFooterLine = new Paint();
        this.paintFooterLine.setStyle(Style.FILL_AND_STROKE);
        this.paintFooterLine.setStrokeWidth(f3);
        this.paintFooterLine.setColor(i3);
        this.paintFooterTriangle = new Paint();
        this.paintFooterTriangle.setStyle(Style.FILL_AND_STROKE);
        this.paintFooterTriangle.setColor(i3);
    }

    private int measureHeight(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        Rect rect = new Rect();
        rect.bottom = (int) (this.paintText.descent() - this.paintText.ascent());
        return (((rect.bottom - rect.top) + ((int) this.footerTriangleHeight)) + ((int) this.footerLineHeight)) + 10;
    }

    private int measureWidth(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalStateException("ViewFlow can only be used in EXACTLY mode.");
    }

    protected void onDraw(Canvas canvas) {
        int i;
        Rect rect;
        super.onDraw(canvas);
        ArrayList calculateAllBounds = calculateAllBounds(this.paintText);
        int count = (this.viewFlow == null || this.viewFlow.getAdapter() == null) ? this.defCount : this.viewFlow.getAdapter().getCount();
        Rect rect2 = (Rect) calculateAllBounds.get(this.currentPosition);
        int i2 = rect2.right - rect2.left;
        if (rect2.left < 0) {
            clipViewOnTheLeft(rect2, i2);
        }
        if (rect2.right > getLeft() + getWidth()) {
            clipViewOnTheRight(rect2, i2);
        }
        if (this.currentPosition > 0) {
            i = this.currentPosition - 1;
            while (i >= 0) {
                rect2 = (Rect) calculateAllBounds.get(i);
                int i3 = rect2.right - rect2.left;
                if (rect2.left < 0) {
                    clipViewOnTheLeft(rect2, i3);
                    if (i < count - 1 && this.currentPosition != i) {
                        rect = (Rect) calculateAllBounds.get(i + SANS);
                        if (((float) rect2.right) + TITLE_PADDING > ((float) rect.left)) {
                            rect2.left = rect.left - (i3 + ((int) this.titlePadding));
                        }
                    }
                }
                i--;
            }
        }
        if (this.currentPosition < count - 1) {
            i = this.currentPosition + SANS;
            while (i < count) {
                rect2 = (Rect) calculateAllBounds.get(i);
                i2 = rect2.right - rect2.left;
                if (rect2.right > getLeft() + getWidth()) {
                    clipViewOnTheRight(rect2, i2);
                    if (i > 0 && this.currentPosition != i) {
                        rect = (Rect) calculateAllBounds.get(i - 1);
                        if (((float) rect2.left) - TITLE_PADDING < ((float) rect.right)) {
                            rect2.left = rect.right + ((int) this.titlePadding);
                        }
                    }
                }
                i += SANS;
            }
        }
        for (i = FOOTER_TYPE_NORMAL; i < count; i += SANS) {
            String title = getTitle(i);
            rect2 = (Rect) calculateAllBounds.get(i);
            if ((rect2.left > getLeft() && rect2.left < getLeft() + getWidth()) || (rect2.right > getLeft() && rect2.right < getLeft() + getWidth())) {
                Paint paint = this.paintText;
                if (Math.abs(((rect2.left + rect2.right) / SERIF) - (getWidth() / SERIF)) < 20) {
                    paint = this.paintSelected;
                }
                paint.setTypeface(this.typeface);
                canvas.drawText(title, (float) rect2.left, (float) rect2.bottom, paint);
            }
        }
        this.path = new Path();
        int height = (int) (((float) (getHeight() - 1)) - (this.footerLineHeight % 2.0f == 1.0f ? this.footerLineHeight / 2.0f : (this.footerLineHeight / 2.0f) - 1.0f));
        this.path.moveTo(CLIP_PADDING, (float) height);
        this.path.lineTo((float) getWidth(), (float) height);
        this.path.close();
        canvas.drawPath(this.path, this.paintFooterLine);
        this.path = new Path();
        this.path.moveTo((float) (getWidth() / SERIF), (((float) getHeight()) - this.footerLineHeight) - this.footerTriangleHeight);
        this.path.lineTo(((float) (getWidth() / SERIF)) + this.footerTriangleHeight, ((float) getHeight()) - this.footerLineHeight);
        this.path.lineTo(((float) (getWidth() / SERIF)) - this.footerTriangleHeight, ((float) getHeight()) - this.footerLineHeight);
        this.path.close();
        canvas.drawPath(this.path, this.paintFooterTriangle);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    public void onScrolled(int i, int i2, int i3, int i4) {
        this.currentScroll = i;
        invalidate();
    }

    public void onSwitched(View view, int i) {
        this.currentPosition = i;
        invalidate();
    }

    public void setDefaultCount(int i) {
        this.defCount = i;
    }

    public void setTitleProvider(TitleProvider titleProvider) {
        this.titleProvider = titleProvider;
    }

    public void setViewFlow(ViewFlow viewFlow) {
        this.viewFlow = viewFlow;
        invalidate();
    }
}
