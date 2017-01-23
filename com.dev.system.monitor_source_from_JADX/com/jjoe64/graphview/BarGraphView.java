package com.jjoe64.graphview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;

public class BarGraphView extends GraphView {
    private boolean drawValuesOnTop;
    private int valuesOnTopColor;

    public BarGraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.valuesOnTopColor = -1;
    }

    public BarGraphView(Context context, String title) {
        super(context, title);
        this.valuesOnTopColor = -1;
    }

    protected void drawHorizontalLabels(Canvas canvas, float border, float horstart, float height, String[] horlabels, float graphwidth) {
        this.paint.setTextAlign(Align.CENTER);
        int hors = horlabels.length;
        float barwidth = graphwidth / ((float) horlabels.length);
        float textOffset = barwidth / 2.0f;
        for (int i = 0; i < horlabels.length; i++) {
            float x = ((graphwidth / ((float) hors)) * ((float) i)) + horstart;
            this.paint.setColor(this.graphViewStyle.getGridColor());
            canvas.drawLine(x, height - border, x, border, this.paint);
            if (getShowHorizontalLabels()) {
                x = ((((float) i) * barwidth) + textOffset) + horstart;
                this.paint.setColor(this.graphViewStyle.getHorizontalLabelsColor());
                canvas.drawText(horlabels[i], x, height - 4.0f, this.paint);
            }
        }
    }

    public void drawSeries(Canvas canvas, GraphViewDataInterface[] values, float graphwidth, float graphheight, float border, double minX, double minY, double diffX, double diffY, float horstart, GraphViewSeriesStyle style) {
        float colwidth = graphwidth / ((float) values.length);
        this.paint.setStrokeWidth((float) style.thickness);
        for (int i = 0; i < values.length; i++) {
            float y = graphheight * ((float) (((double) ((float) (values[i].getY() - minY))) / diffY));
            if (style.getValueDependentColor() != null) {
                this.paint.setColor(style.getValueDependentColor().get(values[i]));
            } else {
                this.paint.setColor(style.color);
            }
            float left = ((((float) i) * colwidth) + horstart) - 0.0f;
            float top = (border - y) + graphheight;
            float right = (((((float) i) * colwidth) + horstart) + (colwidth - 1.0f)) - 0.0f;
            canvas.drawRect(left, top, right, (graphheight + border) - 1.0f, this.paint);
            if (this.drawValuesOnTop) {
                top -= 4.0f;
                if (top <= border) {
                    top += 4.0f + border;
                }
                this.paint.setTextAlign(Align.CENTER);
                this.paint.setColor(this.valuesOnTopColor);
                canvas.drawText(formatLabel(values[i].getY(), false), (left + right) / 2.0f, top, this.paint);
            }
        }
    }

    public boolean getDrawValuesOnTop() {
        return this.drawValuesOnTop;
    }

    public int getValuesOnTopColor() {
        return this.valuesOnTopColor;
    }

    public void setDrawValuesOnTop(boolean drawValuesOnTop) {
        this.drawValuesOnTop = drawValuesOnTop;
    }

    public void setValuesOnTopColor(int valuesOnTopColor) {
        this.valuesOnTopColor = valuesOnTopColor;
    }
}
