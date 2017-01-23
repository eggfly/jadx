package com.jjoe64.graphview;

import java.util.ArrayList;
import java.util.List;

public class GraphViewSeries {
    final String description;
    private final List<GraphView> graphViews;
    final GraphViewSeriesStyle style;
    GraphViewDataInterface[] values;

    public static class GraphViewSeriesStyle {
        public int color;
        public int thickness;
        private ValueDependentColor valueDependentColor;

        public GraphViewSeriesStyle() {
            this.color = -16746548;
            this.thickness = 3;
        }

        public GraphViewSeriesStyle(int color, int thickness) {
            this.color = -16746548;
            this.thickness = 3;
            this.color = color;
            this.thickness = thickness;
        }

        public ValueDependentColor getValueDependentColor() {
            return this.valueDependentColor;
        }

        public void setValueDependentColor(ValueDependentColor valueDependentColor) {
            this.valueDependentColor = valueDependentColor;
        }
    }

    public GraphViewSeries(GraphViewDataInterface[] values) {
        this.graphViews = new ArrayList();
        this.description = null;
        this.style = new GraphViewSeriesStyle();
        this.values = values;
        checkValueOrder();
    }

    public GraphViewSeries(String description, GraphViewSeriesStyle style, GraphViewDataInterface[] values) {
        this.graphViews = new ArrayList();
        this.description = description;
        if (style == null) {
            style = new GraphViewSeriesStyle();
        }
        this.style = style;
        this.values = values;
        checkValueOrder();
    }

    public void addGraphView(GraphView graphView) {
        this.graphViews.add(graphView);
    }

    @Deprecated
    public void appendData(GraphViewDataInterface value, boolean scrollToEnd) {
        if (this.values.length <= 0 || value.getX() >= this.values[this.values.length - 1].getX()) {
            GraphViewDataInterface[] newValues = new GraphViewDataInterface[(this.values.length + 1)];
            System.arraycopy(this.values, 0, newValues, 0, this.values.length);
            newValues[this.values.length] = value;
            this.values = newValues;
            for (GraphView g : this.graphViews) {
                if (scrollToEnd) {
                    g.scrollToEnd();
                }
            }
            return;
        }
        throw new IllegalArgumentException("new x-value must be greater then the last value. x-values has to be ordered in ASC.");
    }

    public void appendData(GraphViewDataInterface value, boolean scrollToEnd, int maxDataCount) {
        if (this.values.length <= 0 || value.getX() >= this.values[this.values.length - 1].getX()) {
            synchronized (this.values) {
                GraphViewDataInterface[] newValues;
                int curDataCount = this.values.length;
                if (curDataCount < maxDataCount) {
                    newValues = new GraphViewDataInterface[(curDataCount + 1)];
                    System.arraycopy(this.values, 0, newValues, 0, curDataCount);
                    newValues[curDataCount] = value;
                } else {
                    newValues = new GraphViewDataInterface[maxDataCount];
                    System.arraycopy(this.values, (curDataCount - maxDataCount) + 1, newValues, 0, maxDataCount - 1);
                    newValues[maxDataCount - 1] = value;
                }
                this.values = newValues;
            }
            for (GraphView g : this.graphViews) {
                if (scrollToEnd) {
                    g.scrollToEnd();
                }
            }
            return;
        }
        throw new IllegalArgumentException("new x-value must be greater then the last value. x-values has to be ordered in ASC.");
    }

    public GraphViewSeriesStyle getStyle() {
        return this.style;
    }

    public void removeGraphView(GraphView graphView) {
        this.graphViews.remove(graphView);
    }

    public void resetData(GraphViewDataInterface[] values) {
        this.values = values;
        checkValueOrder();
        for (GraphView g : this.graphViews) {
            g.redrawAll();
        }
    }

    private void checkValueOrder() {
        if (this.values.length > 1) {
            double lx = this.values[0].getX();
            for (int i = 1; i < this.values.length; i++) {
                if (this.values[i].getX() != Double.NaN) {
                    if (lx > this.values[i].getX()) {
                        throw new IllegalArgumentException("The order of the values is not correct. X-Values have to be ordered ASC. First the lowest x value and at least the highest x value.");
                    }
                    lx = this.values[i].getX();
                }
            }
        }
    }
}
