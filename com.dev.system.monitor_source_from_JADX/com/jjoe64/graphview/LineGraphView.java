package com.jjoe64.graphview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.media.TransportMediator;
import android.util.AttributeSet;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;

public class LineGraphView extends GraphView {
    private float dataPointsRadius;
    private boolean drawBackground;
    private boolean drawDataPoints;
    private final Paint paintBackground;

    public LineGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.dataPointsRadius = 10.0f;
        this.paintBackground = new Paint();
        this.paintBackground.setColor(Color.rgb(20, 40, 60));
        this.paintBackground.setStrokeWidth(4.0f);
        this.paintBackground.setAlpha(TransportMediator.FLAG_KEY_MEDIA_NEXT);
    }

    public LineGraphView(Context context, String title) {
        super(context, title);
        this.dataPointsRadius = 10.0f;
        this.paintBackground = new Paint();
        this.paintBackground.setColor(Color.rgb(20, 40, 60));
        this.paintBackground.setStrokeWidth(4.0f);
        this.paintBackground.setAlpha(TransportMediator.FLAG_KEY_MEDIA_NEXT);
    }

    public void drawSeries(Canvas canvas, GraphViewDataInterface[] values, float graphwidth, float graphheight, float border, double minX, double minY, double diffX, double diffY, float horstart, GraphViewSeriesStyle style) {
        this.paint.setStrokeWidth((float) style.thickness);
        this.paint.setColor(style.color);
        Path bgPath = null;
        if (this.drawBackground) {
            bgPath = new Path();
        }
        double lastEndY = 0.0d;
        double lastEndX = 0.0d;
        float firstX = 0.0f;
        for (int i = 0; i < values.length; i++) {
            double y = ((double) graphheight) * ((values[i].getY() - minY) / diffY);
            double x = ((double) graphwidth) * ((values[i].getX() - minX) / diffX);
            if (i > 0) {
                float startX = ((float) lastEndX) + (1.0f + horstart);
                float startY = ((float) (((double) border) - lastEndY)) + graphheight;
                float endX = ((float) x) + (1.0f + horstart);
                float endY = ((float) (((double) border) - y)) + graphheight;
                if (this.drawDataPoints) {
                    canvas.drawCircle(endX, endY, this.dataPointsRadius, this.paint);
                }
                canvas.drawLine(startX, startY, endX, endY, this.paint);
                if (bgPath != null) {
                    if (i == 1) {
                        firstX = startX;
                        bgPath.moveTo(startX, startY);
                    }
                    bgPath.lineTo(endX, endY);
                }
            } else if (this.drawDataPoints) {
                canvas.drawCircle(((float) x) + (1.0f + horstart), ((float) (((double) border) - y)) + graphheight, this.dataPointsRadius, this.paint);
            }
            lastEndY = y;
            lastEndX = x;
        }
        if (bgPath != null) {
            bgPath.lineTo((float) lastEndX, graphheight + border);
            bgPath.lineTo(firstX, graphheight + border);
            bgPath.close();
            canvas.drawPath(bgPath, this.paintBackground);
        }
    }

    public int getBackgroundColor() {
        return this.paintBackground.getColor();
    }

    public float getDataPointsRadius() {
        return this.dataPointsRadius;
    }

    public boolean getDrawBackground() {
        return this.drawBackground;
    }

    public boolean getDrawDataPoints() {
        return this.drawDataPoints;
    }

    public void setBackgroundColor(int color) {
        this.paintBackground.setColor(color);
    }

    public void setDataPointsRadius(float dataPointsRadius) {
        this.dataPointsRadius = dataPointsRadius;
    }

    public void setDrawBackground(boolean drawBackground) {
        this.drawBackground = drawBackground;
    }

    public void setDrawDataPoints(boolean drawDataPoints) {
        this.drawDataPoints = drawDataPoints;
    }
}
