package com.jjoe64.graphview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint.Align;
import android.view.ContextThemeWrapper;

public class GraphViewStyle {
    private int gridColor;
    private GridStyle gridStyle;
    private int horizontalLabelsColor;
    private int legendBorder;
    private int legendMarginBottom;
    private int legendSpacing;
    private int legendWidth;
    private int numHorizontalLabels;
    private int numVerticalLabels;
    private float textSize;
    private Align verticalLabelsAlign;
    private int verticalLabelsColor;
    private int verticalLabelsWidth;

    public enum GridStyle {
        BOTH,
        VERTICAL,
        HORIZONTAL,
        NONE;

        public boolean drawVertical() {
            return this == BOTH || (this == VERTICAL && this != NONE);
        }

        public boolean drawHorizontal() {
            return this == BOTH || (this == HORIZONTAL && this != NONE);
        }
    }

    public GraphViewStyle() {
        this.gridStyle = GridStyle.BOTH;
        setDefaults();
    }

    public GraphViewStyle(int vLabelsColor, int hLabelsColor, int gridColor) {
        this.gridStyle = GridStyle.BOTH;
        setDefaults();
        this.verticalLabelsColor = vLabelsColor;
        this.horizontalLabelsColor = hLabelsColor;
        this.gridColor = gridColor;
    }

    public int getGridColor() {
        return this.gridColor;
    }

    public GridStyle getGridStyle() {
        return this.gridStyle;
    }

    public int getHorizontalLabelsColor() {
        return this.horizontalLabelsColor;
    }

    public int getLegendBorder() {
        return this.legendBorder;
    }

    public int getLegendSpacing() {
        return this.legendSpacing;
    }

    public int getLegendWidth() {
        return this.legendWidth;
    }

    public int getLegendMarginBottom() {
        return this.legendMarginBottom;
    }

    public int getNumHorizontalLabels() {
        return this.numHorizontalLabels;
    }

    public int getNumVerticalLabels() {
        return this.numVerticalLabels;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public Align getVerticalLabelsAlign() {
        return this.verticalLabelsAlign;
    }

    public int getVerticalLabelsColor() {
        return this.verticalLabelsColor;
    }

    public int getVerticalLabelsWidth() {
        return this.verticalLabelsWidth;
    }

    private void setDefaults() {
        this.verticalLabelsColor = -1;
        this.horizontalLabelsColor = -1;
        this.gridColor = -12303292;
        this.textSize = 30.0f;
        this.legendWidth = 120;
        this.legendBorder = 10;
        this.legendSpacing = 10;
        this.legendMarginBottom = 0;
        this.verticalLabelsAlign = Align.LEFT;
    }

    public void setGridStyle(GridStyle style) {
        this.gridStyle = style;
    }

    public void setGridColor(int c) {
        this.gridColor = c;
    }

    public void setHorizontalLabelsColor(int c) {
        this.horizontalLabelsColor = c;
    }

    public void setLegendBorder(int legendBorder) {
        this.legendBorder = legendBorder;
    }

    public void setLegendSpacing(int legendSpacing) {
        this.legendSpacing = legendSpacing;
    }

    public void setLegendWidth(int legendWidth) {
        this.legendWidth = legendWidth;
    }

    public void setLegendMarginBottom(int legendMarginBottom) {
        this.legendMarginBottom = legendMarginBottom;
    }

    public void setNumHorizontalLabels(int numHorizontalLabels) {
        this.numHorizontalLabels = numHorizontalLabels;
    }

    public void setNumVerticalLabels(int numVerticalLabels) {
        this.numVerticalLabels = numVerticalLabels;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public void setVerticalLabelsAlign(Align verticalLabelsAlign) {
        this.verticalLabelsAlign = verticalLabelsAlign;
    }

    public void setVerticalLabelsColor(int c) {
        this.verticalLabelsColor = c;
    }

    public void setVerticalLabelsWidth(int verticalLabelsWidth) {
        this.verticalLabelsWidth = verticalLabelsWidth;
    }

    public void useTextColorFromTheme(Context context) {
        if (context instanceof ContextThemeWrapper) {
            TypedArray array = ((ContextThemeWrapper) context).getTheme().obtainStyledAttributes(new int[]{16842806});
            int color = array.getColor(0, getVerticalLabelsColor());
            array.recycle();
            setVerticalLabelsColor(color);
            setHorizontalLabelsColor(color);
        }
    }
}
