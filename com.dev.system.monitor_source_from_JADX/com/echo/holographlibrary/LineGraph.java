package com.echo.holographlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import it.gmariotti.cardslib.library.internal.Card;
import java.util.ArrayList;
import java.util.Iterator;

public class LineGraph extends View {
    private static final int DEFAULT_PADDING = 10;
    private final int mAxisColor;
    private Canvas mCanvas;
    private final int mDipPadding;
    private final int mFillColor;
    private Bitmap mFullImage;
    private int mLineToFill;
    private ArrayList<Line> mLines;
    private OnPointClickedListener mListener;
    private float mMaxX;
    private float mMaxY;
    private float mMinX;
    private float mMinY;
    private Paint mPaint;
    private Path mPath;
    private double mRangeXRatio;
    private double mRangeYRatio;
    private int mSelectedIndex;
    private final int mStrokeSpacing;
    private final float mStrokeWidth;
    private boolean mUseDips;
    private boolean mUserSetMaxX;
    private PorterDuffXfermode mXfermode;

    public interface OnPointClickedListener {
        void onClick(int i, int i2);
    }

    public LineGraph(Context context) {
        this(context, null);
    }

    public LineGraph(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineGraph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mLines = new ArrayList();
        this.mPaint = new Paint();
        this.mMinY = 0.0f;
        this.mMinX = 0.0f;
        this.mMaxY = 0.0f;
        this.mMaxX = 0.0f;
        this.mRangeYRatio = 0.0d;
        this.mRangeXRatio = 0.0d;
        this.mUserSetMaxX = false;
        this.mLineToFill = -1;
        this.mSelectedIndex = -1;
        this.mPath = new Path();
        this.mXfermode = new PorterDuffXfermode(Mode.CLEAR);
        this.mDipPadding = getPixelForDip(DEFAULT_PADDING);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, C0147R.styleable.LineGraph, 0, 0);
        this.mFillColor = a.getColor(C0147R.styleable.LineGraph_lineStrokeColor, ViewCompat.MEASURED_STATE_MASK);
        this.mAxisColor = a.getColor(C0147R.styleable.LineGraph_lineAxisColor, -3355444);
        this.mStrokeWidth = a.getDimension(C0147R.styleable.LineGraph_lineStrokeWidth, 2.0f);
        this.mStrokeSpacing = a.getDimensionPixelSize(C0147R.styleable.LineGraph_lineStrokeSpacing, DEFAULT_PADDING);
        this.mUseDips = a.getBoolean(C0147R.styleable.LineGraph_lineUseDip, false);
    }

    public boolean isUsingDips() {
        return this.mUseDips;
    }

    public void setUsingDips(boolean treatSizesAsDips) {
        this.mUseDips = treatSizesAsDips;
    }

    public void removeAllLines() {
        while (this.mLines.size() > 0) {
            this.mLines.remove(0);
        }
        postInvalidate();
    }

    public void addLine(Line line) {
        this.mLines.add(line);
        postInvalidate();
    }

    public void addPointToLine(int lineIndex, double x, double y) {
        addPointToLine(lineIndex, (float) x, (float) y);
    }

    public void addPointToLine(int lineIndex, float x, float y) {
        addPointToLine(lineIndex, new LinePoint(x, y));
    }

    public double getRangeYRatio() {
        return this.mRangeYRatio;
    }

    public void setRangeYRatio(double rr) {
        this.mRangeYRatio = rr;
    }

    public double getRangeXRatio() {
        return this.mRangeXRatio;
    }

    public void setRangeXRatio(double rr) {
        this.mRangeXRatio = rr;
    }

    public void addPointToLine(int lineIndex, LinePoint point) {
        Line line = getLine(lineIndex);
        line.addPoint(point);
        this.mLines.set(lineIndex, line);
        resetLimits();
        postInvalidate();
    }

    public void addPointsToLine(int lineIndex, LinePoint[] points) {
        Line line = getLine(lineIndex);
        for (LinePoint point : points) {
            line.addPoint(point);
        }
        this.mLines.set(lineIndex, line);
        resetLimits();
        postInvalidate();
    }

    public void removeAllPointsAfter(int lineIndex, double x) {
        removeAllPointsBetween(lineIndex, x, (double) getMaxX());
    }

    public void removeAllPointsBefore(int lineIndex, double x) {
        removeAllPointsBetween(lineIndex, (double) getMinX(), x);
    }

    public void removeAllPointsBetween(int lineIndex, double startX, double finishX) {
        Line line = getLine(lineIndex);
        for (LinePoint point : (LinePoint[]) line.getPoints().toArray(new LinePoint[line.getPoints().size()])) {
            if (((double) point.getX()) >= startX && ((double) point.getX()) <= finishX) {
                line.removePoint(point);
            }
        }
        this.mLines.set(lineIndex, line);
        resetLimits();
        postInvalidate();
    }

    public void removePointsFromLine(int lineIndex, LinePoint[] points) {
        Line line = getLine(lineIndex);
        for (LinePoint point : points) {
            line.removePoint(point);
        }
        this.mLines.set(lineIndex, line);
        resetLimits();
        postInvalidate();
    }

    public void removePointFromLine(int lineIndex, float x, float y) {
        removePointFromLine(lineIndex, getLine(lineIndex).getPoint(x, y));
    }

    public void removePointFromLine(int lineIndex, LinePoint point) {
        Line line = getLine(lineIndex);
        line.removePoint(point);
        this.mLines.set(lineIndex, line);
        resetLimits();
        postInvalidate();
    }

    public void resetYLimits() {
        float range = getMaxY() - getMinY();
        setRangeY(((double) getMinY()) - (((double) range) * getRangeYRatio()), ((double) getMaxY()) + (((double) range) * getRangeYRatio()));
    }

    public void resetXLimits() {
        float range = getMaxX() - getMinX();
        setRangeX(((double) getMinX()) - (((double) range) * getRangeXRatio()), ((double) getMaxX()) + (((double) range) * getRangeXRatio()));
    }

    public void resetLimits() {
        resetYLimits();
        resetXLimits();
    }

    public ArrayList<Line> getLines() {
        return this.mLines;
    }

    public void setLineToFill(int indexOfLine) {
        this.mLineToFill = indexOfLine;
        postInvalidate();
    }

    public int getLineToFill() {
        return this.mLineToFill;
    }

    public void setLines(ArrayList<Line> lines) {
        this.mLines = lines;
    }

    public Line getLine(int index) {
        return (Line) this.mLines.get(index);
    }

    public int getSize() {
        return this.mLines.size();
    }

    public void setRangeY(float min, float max) {
        this.mMinY = min;
        this.mMaxY = max;
    }

    private void setRangeY(double min, double max) {
        this.mMinY = (float) min;
        this.mMaxY = (float) max;
    }

    public void setRangeX(float min, float max) {
        this.mMinX = min;
        this.mMaxX = max;
        this.mUserSetMaxX = true;
    }

    private void setRangeX(double min, double max) {
        this.mMinX = (float) min;
        this.mMaxX = (float) max;
    }

    public float getMaxY() {
        float max = ((Line) this.mLines.get(0)).getPoint(0).getY();
        Iterator it = this.mLines.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Line) it.next()).getPoints().iterator();
            while (it2.hasNext()) {
                LinePoint point = (LinePoint) it2.next();
                if (point.getY() > max) {
                    max = point.getY();
                }
            }
        }
        this.mMaxY = max;
        return this.mMaxY;
    }

    public float getMinY() {
        float min = ((Line) this.mLines.get(0)).getPoint(0).getY();
        Iterator it = this.mLines.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Line) it.next()).getPoints().iterator();
            while (it2.hasNext()) {
                LinePoint point = (LinePoint) it2.next();
                if (point.getY() < min) {
                    min = point.getY();
                }
            }
        }
        this.mMinY = min;
        return this.mMinY;
    }

    public float getMinLimY() {
        return this.mMinY;
    }

    public float getMaxLimY() {
        return this.mMaxY;
    }

    public float getMinLimX() {
        return this.mMinX;
    }

    public float getMaxLimX() {
        if (this.mUserSetMaxX) {
            return this.mMaxX;
        }
        return getMaxX();
    }

    public float getMaxX() {
        float max = this.mLines.size() > 0 ? ((Line) this.mLines.get(0)).getPoint(0).getX() : 0.0f;
        Iterator it = this.mLines.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Line) it.next()).getPoints().iterator();
            while (it2.hasNext()) {
                LinePoint point = (LinePoint) it2.next();
                if (point.getX() > max) {
                    max = point.getX();
                }
            }
        }
        this.mMaxX = max;
        return this.mMaxX;
    }

    public float getMinX() {
        float min = this.mLines.size() > 0 ? ((Line) this.mLines.get(0)).getPoint(0).getX() : 0.0f;
        Iterator it = this.mLines.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Line) it.next()).getPoints().iterator();
            while (it2.hasNext()) {
                LinePoint point = (LinePoint) it2.next();
                if (point.getX() < min) {
                    min = point.getX();
                }
            }
        }
        this.mMinX = min;
        return this.mMinX;
    }

    public void onDraw(Canvas canvas) {
        Iterator it;
        float yPercent;
        if (this.mFullImage == null) {
            this.mFullImage = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
            this.mCanvas = new Canvas(this.mFullImage);
        }
        this.mCanvas.drawColor(-1);
        this.mPaint.reset();
        float bottomPadding = 10.0f;
        float topPadding = 10.0f;
        float sidePadding = 10.0f;
        if (this.mUseDips) {
            bottomPadding = (float) this.mDipPadding;
            topPadding = (float) this.mDipPadding;
            sidePadding = (float) this.mDipPadding;
        }
        float usableHeight = (((float) getHeight()) - bottomPadding) - topPadding;
        float usableWidth = ((float) getWidth()) - (2.0f * sidePadding);
        float maxY = getMaxLimY();
        float minY = getMinLimY();
        float maxX = getMaxLimX();
        float minX = getMinLimX();
        int lineCount = 0;
        Iterator it2 = this.mLines.iterator();
        while (it2.hasNext()) {
            float newXPixels;
            float lastYPixels;
            float newYPixels;
            float lastXPixels;
            float xPercent;
            Line line = (Line) it2.next();
            int count = 0;
            if (lineCount == this.mLineToFill) {
                this.mPaint.setColor(this.mFillColor);
                this.mPaint.setStrokeWidth(this.mStrokeWidth);
                int i = DEFAULT_PADDING;
                while (i - getWidth() < getHeight()) {
                    this.mCanvas.drawLine((float) i, ((float) getHeight()) - bottomPadding, 0.0f, (((float) getHeight()) - bottomPadding) - ((float) i), this.mPaint);
                    i += this.mStrokeSpacing;
                }
                this.mPaint.reset();
                this.mPaint.setXfermode(this.mXfermode);
                it = line.getPoints().iterator();
                newXPixels = 0.0f;
                lastYPixels = 0.0f;
                newYPixels = 0.0f;
                lastXPixels = 0.0f;
                while (it.hasNext()) {
                    LinePoint p = (LinePoint) it.next();
                    yPercent = (p.getY() - minY) / (maxY - minY);
                    xPercent = (p.getX() - minX) / (maxX - minX);
                    if (count == 0) {
                        lastXPixels = sidePadding + (xPercent * usableWidth);
                        lastYPixels = (((float) getHeight()) - bottomPadding) - (usableHeight * yPercent);
                        this.mPath.moveTo(lastXPixels, lastYPixels);
                    } else {
                        newXPixels = sidePadding + (xPercent * usableWidth);
                        newYPixels = (((float) getHeight()) - bottomPadding) - (usableHeight * yPercent);
                        this.mPath.lineTo(newXPixels, newYPixels);
                        this.mPath.moveTo(lastXPixels, lastYPixels);
                        this.mPath.lineTo(newXPixels, newYPixels);
                        this.mPath.lineTo(newXPixels, 0.0f);
                        this.mPath.lineTo(lastXPixels, 0.0f);
                        this.mPath.close();
                        this.mCanvas.drawPath(this.mPath, this.mPaint);
                        lastXPixels = newXPixels;
                        lastYPixels = newYPixels;
                    }
                    count++;
                }
                this.mPath.reset();
                this.mPath.moveTo(0.0f, ((float) getHeight()) - bottomPadding);
                this.mPath.lineTo(sidePadding, ((float) getHeight()) - bottomPadding);
                this.mPath.lineTo(sidePadding, 0.0f);
                this.mPath.lineTo(0.0f, 0.0f);
                this.mPath.close();
                this.mCanvas.drawPath(this.mPath, this.mPaint);
                this.mPath.reset();
                this.mPath.moveTo((float) getWidth(), ((float) getHeight()) - bottomPadding);
                this.mPath.lineTo(((float) getWidth()) - sidePadding, ((float) getHeight()) - bottomPadding);
                this.mPath.lineTo(((float) getWidth()) - sidePadding, 0.0f);
                this.mPath.lineTo((float) getWidth(), 0.0f);
                this.mPath.close();
                this.mCanvas.drawPath(this.mPath, this.mPaint);
            } else {
                newXPixels = 0.0f;
                lastYPixels = 0.0f;
                newYPixels = 0.0f;
                lastXPixels = 0.0f;
            }
            lineCount++;
        }
        this.mPaint.reset();
        this.mPaint.setColor(this.mAxisColor);
        this.mPaint.setStrokeWidth(2.0f * getResources().getDisplayMetrics().density);
        this.mPaint.setAntiAlias(true);
        this.mCanvas.drawLine(sidePadding, ((float) getHeight()) - bottomPadding, ((float) getWidth()) - sidePadding, ((float) getHeight()) - bottomPadding, this.mPaint);
        this.mPaint.reset();
        it2 = this.mLines.iterator();
        while (it2.hasNext()) {
            line = (Line) it2.next();
            count = 0;
            lastXPixels = 0.0f;
            lastYPixels = 0.0f;
            this.mPaint.setColor(line.getColor());
            this.mPaint.setStrokeWidth((float) getStrokeWidth(line));
            Iterator it3 = line.getPoints().iterator();
            while (it3.hasNext()) {
                p = (LinePoint) it3.next();
                yPercent = (p.getY() - minY) / (maxY - minY);
                xPercent = (p.getX() - minX) / (maxX - minX);
                if (count == 0) {
                    lastXPixels = sidePadding + (xPercent * usableWidth);
                    lastYPixels = (((float) getHeight()) - bottomPadding) - (usableHeight * yPercent);
                } else {
                    newXPixels = sidePadding + (xPercent * usableWidth);
                    newYPixels = (((float) getHeight()) - bottomPadding) - (usableHeight * yPercent);
                    this.mCanvas.drawLine(lastXPixels, lastYPixels, newXPixels, newYPixels, this.mPaint);
                    lastXPixels = newXPixels;
                    lastYPixels = newYPixels;
                }
                count++;
            }
        }
        int pointCount = 0;
        it = this.mLines.iterator();
        while (it.hasNext()) {
            line = (Line) it.next();
            this.mPaint.setColor(line.getColor());
            this.mPaint.setStrokeWidth((float) getStrokeWidth(line));
            this.mPaint.setStrokeCap(Cap.ROUND);
            if (line.isShowingPoints()) {
                Iterator it4 = line.getPoints().iterator();
                while (it4.hasNext()) {
                    int outerRadius;
                    p = (LinePoint) it4.next();
                    yPercent = (p.getY() - minY) / (maxY - minY);
                    float xPixels = sidePadding + (((p.getX() - minX) / (maxX - minX)) * usableWidth);
                    float yPixels = (((float) getHeight()) - bottomPadding) - (usableHeight * yPercent);
                    if (line.isUsingDips()) {
                        outerRadius = getPixelForDip(line.getStrokeWidth() + 4);
                    } else {
                        outerRadius = line.getStrokeWidth() + 4;
                    }
                    int innerRadius = outerRadius / 2;
                    this.mPaint.setColor(p.getColor());
                    this.mCanvas.drawCircle(xPixels, yPixels, (float) outerRadius, this.mPaint);
                    this.mPaint.setColor(-1);
                    this.mCanvas.drawCircle(xPixels, yPixels, (float) innerRadius, this.mPaint);
                    Path path = p.getPath();
                    path.reset();
                    outerRadius *= 2;
                    path.addCircle(xPixels, yPixels, (float) outerRadius, Direction.CW);
                    p.getRegion().set((int) (xPixels - ((float) outerRadius)), (int) (yPixels - ((float) outerRadius)), (int) (((float) outerRadius) + xPixels), (int) (((float) outerRadius) + yPixels));
                    int i2 = this.mSelectedIndex;
                    if (r0 == pointCount && this.mListener != null) {
                        this.mPaint.setColor(p.getSelectedColor());
                        this.mCanvas.drawPath(p.getPath(), this.mPaint);
                        this.mPaint.setAlpha(MotionEventCompat.ACTION_MASK);
                    }
                    pointCount++;
                }
            }
        }
        canvas.drawBitmap(this.mFullImage, 0.0f, 0.0f, null);
    }

    private int getStrokeWidth(Line line) {
        if (line.isUsingDips()) {
            return getPixelForDip(line.getStrokeWidth());
        }
        return line.getStrokeWidth();
    }

    private int getPixelForDip(int dipValue) {
        return (int) TypedValue.applyDimension(1, (float) dipValue, getResources().getDisplayMetrics());
    }

    public boolean onTouchEvent(MotionEvent event) {
        Point point = new Point();
        point.x = (int) event.getX();
        point.y = (int) event.getY();
        int count = 0;
        int lineCount = 0;
        Region r = new Region();
        Iterator it = this.mLines.iterator();
        while (it.hasNext()) {
            int pointCount = 0;
            Iterator it2 = ((Line) it.next()).getPoints().iterator();
            while (it2.hasNext()) {
                LinePoint p = (LinePoint) it2.next();
                r.setPath(p.getPath(), p.getRegion());
                switch (event.getAction()) {
                    case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                        if (!r.contains(point.x, point.y)) {
                            break;
                        }
                        this.mSelectedIndex = count;
                        postInvalidate();
                        break;
                    case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                        if (count == this.mSelectedIndex && this.mListener != null && r.contains(point.x, point.y)) {
                            this.mListener.onClick(lineCount, pointCount);
                            break;
                        }
                    default:
                        break;
                }
                pointCount++;
                count++;
            }
            lineCount++;
        }
        if (1 == event.getAction() || 3 == event.getAction()) {
            this.mSelectedIndex = -1;
            postInvalidate();
        }
        return true;
    }

    public void setOnPointClickedListener(OnPointClickedListener listener) {
        this.mListener = listener;
    }
}
