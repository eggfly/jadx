package com.jjoe64.graphview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.compatible.ScaleGestureDetector;
import com.jjoe64.graphview.compatible.ScaleGestureDetector.SimpleOnScaleGestureListener;
import it.gmariotti.cardslib.library.internal.Card;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public abstract class GraphView extends LinearLayout {
    private CustomLabelFormatter customLabelFormatter;
    private boolean disableTouch;
    private final List<GraphViewSeries> graphSeries;
    private final GraphViewContentView graphViewContentView;
    protected GraphViewStyle graphViewStyle;
    private Integer horLabelTextWidth;
    private String[] horlabels;
    private Integer labelTextHeight;
    private LegendAlign legendAlign;
    private boolean manualMaxY;
    private double manualMaxYValue;
    private boolean manualMinY;
    private double manualMinYValue;
    private boolean manualYAxis;
    private final NumberFormat[] numberformatter;
    protected final Paint paint;
    private boolean scalable;
    private ScaleGestureDetector scaleDetector;
    private boolean scrollable;
    private boolean showHorizontalLabels;
    private boolean showLegend;
    private boolean showVerticalLabels;
    private boolean staticHorizontalLabels;
    private boolean staticVerticalLabels;
    private final Rect textBounds;
    private String title;
    private Integer verLabelTextWidth;
    private String[] verlabels;
    private final View viewVerLabels;
    private double viewportSize;
    private double viewportStart;

    /* renamed from: com.jjoe64.graphview.GraphView.2 */
    static /* synthetic */ class C01622 {
        static final /* synthetic */ int[] $SwitchMap$com$jjoe64$graphview$GraphView$LegendAlign;

        static {
            $SwitchMap$com$jjoe64$graphview$GraphView$LegendAlign = new int[LegendAlign.values().length];
            try {
                $SwitchMap$com$jjoe64$graphview$GraphView$LegendAlign[LegendAlign.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$jjoe64$graphview$GraphView$LegendAlign[LegendAlign.MIDDLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static final class GraphViewConfig {
        static final float BORDER = 20.0f;

        private GraphViewConfig() {
        }
    }

    private class GraphViewContentView extends View {
        private float graphwidth;
        private float lastTouchEventX;
        private boolean scrollingStarted;

        public GraphViewContentView(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(-1, -1));
        }

        protected void onDraw(Canvas canvas) {
            int i;
            GraphView.this.paint.setAntiAlias(true);
            GraphView.this.paint.setStrokeWidth(0.0f);
            float height = (float) getHeight();
            float width = (float) (getWidth() - 1);
            double maxY = GraphView.this.getMaxY();
            double minY = GraphView.this.getMinY();
            double maxX = GraphView.this.getMaxX(false);
            double minX = GraphView.this.getMinX(false);
            double diffX = maxX - minX;
            if (GraphView.this.labelTextHeight == null || GraphView.this.horLabelTextWidth == null) {
                GraphView.this.paint.setTextSize(GraphView.this.getGraphViewStyle().getTextSize());
                String testLabel = GraphView.this.formatLabel(((GraphView.this.getMaxX(true) - GraphView.this.getMinX(true)) * 0.783d) + GraphView.this.getMinX(true), true);
                GraphView.this.paint.getTextBounds(testLabel, 0, testLabel.length(), GraphView.this.textBounds);
                int lines = 1;
                for (int i2 : testLabel.getBytes()) {
                    if (i2 == 10) {
                        lines++;
                    }
                }
                GraphView.this.labelTextHeight = Integer.valueOf(GraphView.this.textBounds.height() * lines);
                GraphView.this.horLabelTextWidth = Integer.valueOf(GraphView.this.textBounds.width());
            }
            float border = 20.0f + ((float) GraphView.this.labelTextHeight.intValue());
            float graphheight = height - (2.0f * border);
            this.graphwidth = width;
            if (GraphView.this.horlabels == null) {
                GraphView.this.horlabels = GraphView.this.generateHorlabels(this.graphwidth);
            } else if (GraphView.this.getGraphViewStyle().getNumHorizontalLabels() > 0) {
                Log.w("GraphView", "when you use static labels (via setHorizontalLabels) the labels will just be shown exactly in that way, that you have set it. setNumHorizontalLabels does not have any effect.");
            }
            if (GraphView.this.verlabels == null) {
                GraphView.this.verlabels = GraphView.this.generateVerlabels(graphheight);
            } else if (GraphView.this.getGraphViewStyle().getNumVerticalLabels() > 0) {
                Log.w("GraphView", "when you use static labels (via setVerticalLabels) the labels will just be shown exactly in that way, that you have set it. setNumVerticalLabels does not have any effect.");
            }
            if (GraphView.this.graphViewStyle.getGridStyle().drawHorizontal()) {
                GraphView.this.paint.setTextAlign(Align.LEFT);
                int vers = GraphView.this.verlabels.length - 1;
                for (i = 0; i < GraphView.this.verlabels.length; i++) {
                    GraphView.this.paint.setColor(GraphView.this.graphViewStyle.getGridColor());
                    float y = ((graphheight / ((float) vers)) * ((float) i)) + border;
                    canvas.drawLine(0.0f, y, width, y, GraphView.this.paint);
                }
            }
            GraphView.this.drawHorizontalLabels(canvas, border, 0.0f, height, GraphView.this.horlabels, this.graphwidth);
            GraphView.this.paint.setColor(GraphView.this.graphViewStyle.getHorizontalLabelsColor());
            GraphView.this.paint.setTextAlign(Align.CENTER);
            canvas.drawText(GraphView.this.title, (this.graphwidth / 2.0f) + 0.0f, border - 4.0f, GraphView.this.paint);
            if (maxY == minY) {
                if (maxY == 0.0d) {
                    maxY = 1.0d;
                    minY = 0.0d;
                } else {
                    maxY *= 1.05d;
                    minY *= 0.95d;
                }
            }
            double diffY = maxY - minY;
            GraphView.this.paint.setStrokeCap(Cap.ROUND);
            for (i = 0; i < GraphView.this.graphSeries.size(); i++) {
                GraphView.this.drawSeries(canvas, GraphView.this._values(i), this.graphwidth, graphheight, border, minX, minY, diffX, diffY, 0.0f, ((GraphViewSeries) GraphView.this.graphSeries.get(i)).style);
            }
            if (GraphView.this.showLegend) {
                GraphView.this.drawLegend(canvas, height, width);
            }
        }

        private void onMoveGesture(float f) {
            if (GraphView.this.viewportSize != 0.0d) {
                GraphView.access$1226(GraphView.this, (((double) f) * GraphView.this.viewportSize) / ((double) this.graphwidth));
                double minX = GraphView.this.getMinX(true);
                double maxX = GraphView.this.getMaxX(true);
                if (GraphView.this.viewportStart < minX) {
                    GraphView.this.viewportStart = minX;
                } else if (GraphView.this.viewportStart + GraphView.this.viewportSize > maxX) {
                    GraphView.this.viewportStart = maxX - GraphView.this.viewportSize;
                }
                if (!GraphView.this.staticHorizontalLabels) {
                    GraphView.this.horlabels = null;
                }
                if (!GraphView.this.staticVerticalLabels) {
                    GraphView.this.verlabels = null;
                }
                GraphView.this.viewVerLabels.invalidate();
            }
            invalidate();
        }

        public boolean onTouchEvent(MotionEvent event) {
            if (!GraphView.this.isScrollable() || GraphView.this.isDisableTouch()) {
                return super.onTouchEvent(event);
            }
            boolean handled = false;
            if (GraphView.this.scalable && GraphView.this.scaleDetector != null) {
                GraphView.this.scaleDetector.onTouchEvent(event);
                handled = GraphView.this.scaleDetector.isInProgress();
            }
            if (handled) {
                this.scrollingStarted = false;
                this.lastTouchEventX = 0.0f;
                return handled;
            }
            if ((event.getAction() & 0) == 0 && (event.getAction() & 2) == 0) {
                this.scrollingStarted = true;
                handled = true;
            }
            if ((event.getAction() & 1) == 1) {
                this.scrollingStarted = false;
                this.lastTouchEventX = 0.0f;
                handled = true;
            }
            if ((event.getAction() & 2) == 2 && this.scrollingStarted) {
                if (this.lastTouchEventX != 0.0f) {
                    onMoveGesture(event.getX() - this.lastTouchEventX);
                }
                this.lastTouchEventX = event.getX();
                handled = true;
            }
            if (!handled) {
                return handled;
            }
            invalidate();
            return handled;
        }
    }

    public enum LegendAlign {
        TOP,
        MIDDLE,
        BOTTOM
    }

    private class VerLabelsView extends View {
        public VerLabelsView(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(GraphView.this.getGraphViewStyle().getVerticalLabelsWidth() == 0 ? 100 : GraphView.this.getGraphViewStyle().getVerticalLabelsWidth(), -1));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void onDraw(android.graphics.Canvas r25) {
            /*
            r24 = this;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r20;
            r0 = r0.paint;
            r20 = r0;
            r21 = 0;
            r20.setStrokeWidth(r21);
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.labelTextHeight;
            if (r20 == 0) goto L_0x0029;
        L_0x001d:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.verLabelTextWidth;
            if (r20 != 0) goto L_0x00de;
        L_0x0029:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r20;
            r0 = r0.paint;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r21 = r21.getGraphViewStyle();
            r21 = r21.getTextSize();
            r20.setTextSize(r21);
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.getMaxY();
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r22 = r0;
            r22 = r22.getMinY();
            r20 = r20 - r22;
            r22 = 4605227856561738613; // 0x3fe90e5604189375 float:1.7935223E-36 double:0.783;
            r20 = r20 * r22;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r22 = r0;
            r22 = r22.getMinY();
            r16 = r20 + r22;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r21 = 0;
            r0 = r20;
            r1 = r16;
            r3 = r21;
            r14 = r0.formatLabel(r1, r3);
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r20;
            r0 = r0.paint;
            r20 = r0;
            r21 = 0;
            r22 = r14.length();
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r23 = r0;
            r23 = r23.textBounds;
            r0 = r20;
            r1 = r21;
            r2 = r22;
            r3 = r23;
            r0.getTextBounds(r14, r1, r2, r3);
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r21 = r21.textBounds;
            r21 = r21.height();
            r21 = java.lang.Integer.valueOf(r21);
            r20.labelTextHeight = r21;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r21 = r21.textBounds;
            r21 = r21.width();
            r21 = java.lang.Integer.valueOf(r21);
            r20.verLabelTextWidth = r21;
        L_0x00de:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.getGraphViewStyle();
            r20 = r20.getVerticalLabelsWidth();
            if (r20 != 0) goto L_0x0270;
        L_0x00ee:
            r20 = r24.getLayoutParams();
            r0 = r20;
            r0 = r0.width;
            r20 = r0;
            r0 = r20;
            r0 = (float) r0;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r21 = r21.verLabelTextWidth;
            r21 = r21.intValue();
            r0 = r21;
            r0 = (float) r0;
            r21 = r0;
            r22 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
            r21 = r21 + r22;
            r20 = (r20 > r21 ? 1 : (r20 == r21 ? 0 : -1));
            if (r20 == 0) goto L_0x0270;
        L_0x0118:
            r20 = new android.widget.LinearLayout$LayoutParams;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r21 = r21.verLabelTextWidth;
            r21 = r21.intValue();
            r0 = r21;
            r0 = (float) r0;
            r21 = r0;
            r22 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
            r21 = r21 + r22;
            r0 = r21;
            r0 = (int) r0;
            r21 = r0;
            r22 = -1;
            r20.<init>(r21, r22);
            r0 = r24;
            r1 = r20;
            r0.setLayoutParams(r1);
        L_0x0142:
            r6 = 1101004800; // 0x41a00000 float:20.0 double:5.439686476E-315;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.labelTextHeight;
            r20 = r20.intValue();
            r0 = r20;
            r0 = (float) r0;
            r20 = r0;
            r6 = r6 + r20;
            r20 = r24.getHeight();
            r0 = r20;
            r8 = (float) r0;
            r20 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            r20 = r20 * r6;
            r7 = r8 - r20;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.verlabels;
            if (r20 != 0) goto L_0x02bc;
        L_0x0172:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r0 = r21;
            r21 = r0.generateVerlabels(r7);
            r20.verlabels = r21;
        L_0x0187:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r20;
            r0 = r0.paint;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r21 = r21.getGraphViewStyle();
            r21 = r21.getVerticalLabelsAlign();
            r20.setTextAlign(r21);
            r11 = r24.getWidth();
            r10 = 0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.getGraphViewStyle();
            r20 = r20.getVerticalLabelsAlign();
            r21 = android.graphics.Paint.Align.RIGHT;
            r0 = r20;
            r1 = r21;
            if (r0 != r1) goto L_0x02d5;
        L_0x01bf:
            r10 = r11;
        L_0x01c0:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.verlabels;
            r0 = r20;
            r0 = r0.length;
            r20 = r0;
            r15 = r20 + -1;
            r9 = 0;
        L_0x01d2:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.verlabels;
            r0 = r20;
            r0 = r0.length;
            r20 = r0;
            r0 = r20;
            if (r9 >= r0) goto L_0x02f3;
        L_0x01e5:
            r0 = (float) r15;
            r20 = r0;
            r20 = r7 / r20;
            r0 = (float) r9;
            r21 = r0;
            r20 = r20 * r21;
            r18 = r20 + r6;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r20;
            r0 = r0.paint;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r0 = r21;
            r0 = r0.graphViewStyle;
            r21 = r0;
            r21 = r21.getVerticalLabelsColor();
            r20.setColor(r21);
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.verlabels;
            r20 = r20[r9];
            r21 = "\n";
            r13 = r20.split(r21);
            r12 = 0;
        L_0x0223:
            r0 = r13.length;
            r20 = r0;
            r0 = r20;
            if (r12 >= r0) goto L_0x02ef;
        L_0x022a:
            r0 = r13.length;
            r20 = r0;
            r20 = r20 - r12;
            r20 = r20 + -1;
            r0 = r20;
            r0 = (float) r0;
            r20 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r0 = r21;
            r0 = r0.graphViewStyle;
            r21 = r0;
            r21 = r21.getTextSize();
            r20 = r20 * r21;
            r21 = 1066192077; // 0x3f8ccccd float:1.1 double:5.26768877E-315;
            r20 = r20 * r21;
            r19 = r18 - r20;
            r20 = r13[r12];
            r0 = (float) r10;
            r21 = r0;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r22 = r0;
            r0 = r22;
            r0 = r0.paint;
            r22 = r0;
            r0 = r25;
            r1 = r20;
            r2 = r21;
            r3 = r19;
            r4 = r22;
            r0.drawText(r1, r2, r3, r4);
            r12 = r12 + 1;
            goto L_0x0223;
        L_0x0270:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.getGraphViewStyle();
            r20 = r20.getVerticalLabelsWidth();
            if (r20 == 0) goto L_0x0142;
        L_0x0280:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.getGraphViewStyle();
            r20 = r20.getVerticalLabelsWidth();
            r21 = r24.getLayoutParams();
            r0 = r21;
            r0 = r0.width;
            r21 = r0;
            r0 = r20;
            r1 = r21;
            if (r0 == r1) goto L_0x0142;
        L_0x029e:
            r20 = new android.widget.LinearLayout$LayoutParams;
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r21 = r0;
            r21 = r21.getGraphViewStyle();
            r21 = r21.getVerticalLabelsWidth();
            r22 = -1;
            r20.<init>(r21, r22);
            r0 = r24;
            r1 = r20;
            r0.setLayoutParams(r1);
            goto L_0x0142;
        L_0x02bc:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.getGraphViewStyle();
            r20 = r20.getNumVerticalLabels();
            if (r20 <= 0) goto L_0x0187;
        L_0x02cc:
            r20 = "GraphView";
            r21 = "when you use static labels (via setVerticalLabels) the labels will just be shown exactly in that way, that you have set it. setNumVerticalLabels does not have any effect.";
            android.util.Log.w(r20, r21);
            goto L_0x0187;
        L_0x02d5:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r20 = r20.getGraphViewStyle();
            r20 = r20.getVerticalLabelsAlign();
            r21 = android.graphics.Paint.Align.CENTER;
            r0 = r20;
            r1 = r21;
            if (r0 != r1) goto L_0x01c0;
        L_0x02eb:
            r10 = r11 / 2;
            goto L_0x01c0;
        L_0x02ef:
            r9 = r9 + 1;
            goto L_0x01d2;
        L_0x02f3:
            r0 = r24;
            r0 = com.jjoe64.graphview.GraphView.this;
            r20 = r0;
            r0 = r20;
            r0 = r0.paint;
            r20 = r0;
            r21 = android.graphics.Paint.Align.LEFT;
            r20.setTextAlign(r21);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jjoe64.graphview.GraphView.VerLabelsView.onDraw(android.graphics.Canvas):void");
        }
    }

    /* renamed from: com.jjoe64.graphview.GraphView.1 */
    class C02481 implements SimpleOnScaleGestureListener {
        C02481() {
        }

        public boolean onScale(ScaleGestureDetector detector) {
            double center = GraphView.this.viewportStart + (GraphView.this.viewportSize / 2.0d);
            GraphView.access$1142(GraphView.this, detector.getScaleFactor());
            GraphView.this.viewportStart = center - (GraphView.this.viewportSize / 2.0d);
            double minX = GraphView.this.getMinX(true);
            if (GraphView.this.viewportStart < minX) {
                GraphView.this.viewportStart = minX;
            }
            double maxX = GraphView.this.getMaxX(true);
            if (GraphView.this.viewportSize == 0.0d) {
                GraphView.this.viewportSize = maxX;
            }
            double overlap = (GraphView.this.viewportStart + GraphView.this.viewportSize) - maxX;
            if (overlap > 0.0d) {
                if (GraphView.this.viewportStart - overlap > minX) {
                    GraphView.access$1226(GraphView.this, overlap);
                } else {
                    GraphView.this.viewportStart = minX;
                    GraphView.this.viewportSize = maxX - GraphView.this.viewportStart;
                }
            }
            GraphView.this.redrawAll();
            return true;
        }
    }

    public static class GraphViewData implements GraphViewDataInterface {
        public final double valueX;
        public final double valueY;

        public GraphViewData(double valueX, double valueY) {
            this.valueX = valueX;
            this.valueY = valueY;
        }

        public double getX() {
            return this.valueX;
        }

        public double getY() {
            return this.valueY;
        }
    }

    protected abstract void drawSeries(Canvas canvas, GraphViewDataInterface[] graphViewDataInterfaceArr, float f, float f2, float f3, double d, double d2, double d3, double d4, float f4, GraphViewSeriesStyle graphViewSeriesStyle);

    static /* synthetic */ double access$1142(GraphView x0, double x1) {
        double d = x0.viewportSize / x1;
        x0.viewportSize = d;
        return d;
    }

    static /* synthetic */ double access$1226(GraphView x0, double x1) {
        double d = x0.viewportStart - x1;
        x0.viewportStart = d;
        return d;
    }

    public GraphView(Context context, AttributeSet attrs) {
        this(context, attrs.getAttributeValue(null, "title"));
        setLayoutParams(new LayoutParams(attrs.getAttributeIntValue("android", "layout_width", -1), attrs.getAttributeIntValue("android", "layout_height", -1)));
    }

    public GraphView(Context context, String title) {
        super(context);
        this.numberformatter = new NumberFormat[2];
        this.showLegend = false;
        this.legendAlign = LegendAlign.MIDDLE;
        this.textBounds = new Rect();
        this.showHorizontalLabels = true;
        this.showVerticalLabels = true;
        setLayoutParams(new LayoutParams(-1, -1));
        if (title == null) {
            this.title = BuildConfig.VERSION_NAME;
        } else {
            this.title = title;
        }
        this.graphViewStyle = new GraphViewStyle();
        this.graphViewStyle.useTextColorFromTheme(context);
        this.paint = new Paint();
        this.graphSeries = new ArrayList();
        this.viewVerLabels = new VerLabelsView(context);
        addView(this.viewVerLabels);
        this.graphViewContentView = new GraphViewContentView(context);
        addView(this.graphViewContentView, new LayoutParams(-1, -1, 1.0f));
    }

    private GraphViewDataInterface[] _values(int idxSeries) {
        GraphViewDataInterface[] values = ((GraphViewSeries) this.graphSeries.get(idxSeries)).values;
        synchronized (values) {
            if (this.viewportStart == 0.0d && this.viewportSize == 0.0d) {
                return values;
            }
            List<GraphViewDataInterface> listData = new ArrayList();
            for (int i = 0; i < values.length; i++) {
                if (values[i].getX() < this.viewportStart) {
                    if (listData.isEmpty()) {
                        listData.add(values[i]);
                    }
                    listData.set(0, values[i]);
                } else if (values[i].getX() > this.viewportStart + this.viewportSize) {
                    listData.add(values[i]);
                    break;
                } else {
                    listData.add(values[i]);
                }
            }
            GraphViewDataInterface[] graphViewDataInterfaceArr = (GraphViewDataInterface[]) listData.toArray(new GraphViewDataInterface[listData.size()]);
            return graphViewDataInterfaceArr;
        }
    }

    public void addSeries(GraphViewSeries series) {
        series.addGraphView(this);
        this.graphSeries.add(series);
        redrawAll();
    }

    protected void drawHorizontalLabels(Canvas canvas, float border, float horstart, float height, String[] horlabels, float graphwidth) {
        int hors = horlabels.length - 1;
        for (int i = 0; i < horlabels.length; i++) {
            this.paint.setColor(this.graphViewStyle.getGridColor());
            float x = ((graphwidth / ((float) hors)) * ((float) i)) + horstart;
            if (this.graphViewStyle.getGridStyle().drawVertical()) {
                canvas.drawLine(x, height - border, x, border, this.paint);
            }
            if (this.showHorizontalLabels) {
                this.paint.setTextAlign(Align.CENTER);
                if (i == horlabels.length - 1) {
                    this.paint.setTextAlign(Align.RIGHT);
                }
                if (i == 0) {
                    this.paint.setTextAlign(Align.LEFT);
                }
                this.paint.setColor(this.graphViewStyle.getHorizontalLabelsColor());
                String[] lines = horlabels[i].split("\n");
                for (int li = 0; li < lines.length; li++) {
                    canvas.drawText(lines[li], x, (height - 4.0f) - ((((float) ((lines.length - li) - 1)) * this.graphViewStyle.getTextSize()) * 1.1f), this.paint);
                }
            }
        }
    }

    protected void drawLegend(Canvas canvas, float height, float width) {
        float lTop;
        float textSize = this.paint.getTextSize();
        int spacing = getGraphViewStyle().getLegendSpacing();
        int border = getGraphViewStyle().getLegendBorder();
        int legendWidth = getGraphViewStyle().getLegendWidth();
        int shapeSize = (int) (((double) textSize) * 0.8d);
        this.paint.setARGB(180, 100, 100, 100);
        float legendHeight = (float) ((((shapeSize + spacing) * this.graphSeries.size()) + (border * 2)) - spacing);
        float lLeft = (width - ((float) legendWidth)) - ((float) (border * 2));
        switch (C01622.$SwitchMap$com$jjoe64$graphview$GraphView$LegendAlign[this.legendAlign.ordinal()]) {
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                lTop = 0.0f;
                break;
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                lTop = (height / 2.0f) - (legendHeight / 2.0f);
                break;
            default:
                lTop = ((height - 20.0f) - legendHeight) - ((float) getGraphViewStyle().getLegendMarginBottom());
                break;
        }
        canvas.drawRoundRect(new RectF(lLeft, lTop, lLeft + ((float) legendWidth), lTop + legendHeight), 8.0f, 8.0f, this.paint);
        for (int i = 0; i < this.graphSeries.size(); i++) {
            this.paint.setColor(((GraphViewSeries) this.graphSeries.get(i)).style.color);
            float f = (float) shapeSize;
            float f2 = (float) ((shapeSize + spacing) * i);
            f2 = (float) shapeSize;
            canvas.drawRect(new RectF(((float) border) + lLeft, (((float) border) + lTop) + ((float) ((shapeSize + spacing) * i)), (((float) border) + lLeft) + r0, ((((float) border) + lTop) + r0) + r0), this.paint);
            if (((GraphViewSeries) this.graphSeries.get(i)).description != null) {
                this.paint.setColor(-1);
                this.paint.setTextAlign(Align.LEFT);
                float f3 = (float) ((shapeSize + spacing) * i);
                canvas.drawText(((GraphViewSeries) this.graphSeries.get(i)).description, ((((float) border) + lLeft) + ((float) shapeSize)) + ((float) spacing), ((((float) border) + lTop) + ((float) shapeSize)) + r0, this.paint);
            }
        }
    }

    @Deprecated
    protected String formatLabel(double value, boolean isValueX) {
        int i;
        if (this.customLabelFormatter != null) {
            String label = this.customLabelFormatter.formatLabel(value, isValueX);
            if (label != null) {
                return label;
            }
        }
        if (isValueX) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.numberformatter[i] == null) {
            this.numberformatter[i] = NumberFormat.getNumberInstance();
            double highestvalue = isValueX ? getMaxX(false) : getMaxY();
            double lowestvalue = isValueX ? getMinX(false) : getMinY();
            if (highestvalue - lowestvalue < 0.1d) {
                this.numberformatter[i].setMaximumFractionDigits(6);
            } else if (highestvalue - lowestvalue < 1.0d) {
                this.numberformatter[i].setMaximumFractionDigits(4);
            } else if (highestvalue - lowestvalue < 20.0d) {
                this.numberformatter[i].setMaximumFractionDigits(3);
            } else if (highestvalue - lowestvalue < 100.0d) {
                this.numberformatter[i].setMaximumFractionDigits(1);
            } else {
                this.numberformatter[i].setMaximumFractionDigits(0);
            }
        }
        return this.numberformatter[i].format(value);
    }

    private String[] generateHorlabels(float graphwidth) {
        int numLabels = getGraphViewStyle().getNumHorizontalLabels() - 1;
        if (numLabels < 0) {
            if (graphwidth <= 0.0f) {
                graphwidth = 1.0f;
            }
            numLabels = (int) (graphwidth / ((float) (this.horLabelTextWidth.intValue() * 2)));
        }
        String[] labels = new String[(numLabels + 1)];
        double min = getMinX(false);
        double max = getMaxX(false);
        for (int i = 0; i <= numLabels; i++) {
            labels[i] = formatLabel((((max - min) * ((double) i)) / ((double) numLabels)) + min, true);
        }
        return labels;
    }

    private synchronized String[] generateVerlabels(float graphheight) {
        String[] labels;
        int numLabels = getGraphViewStyle().getNumVerticalLabels() - 1;
        if (numLabels < 0) {
            if (graphheight <= 0.0f) {
                graphheight = 1.0f;
            }
            numLabels = (int) (graphheight / ((float) (this.labelTextHeight.intValue() * 3)));
            if (numLabels == 0) {
                Log.w("GraphView", "Height of Graph is smaller than the label text height, so no vertical labels were shown!");
            }
        }
        labels = new String[(numLabels + 1)];
        double min = getMinY();
        double max = getMaxY();
        if (max == min) {
            if (max == 0.0d) {
                max = 1.0d;
                min = 0.0d;
            } else {
                max *= 1.05d;
                min *= 0.95d;
            }
        }
        for (int i = 0; i <= numLabels; i++) {
            labels[numLabels - i] = formatLabel((((max - min) * ((double) i)) / ((double) numLabels)) + min, false);
        }
        return labels;
    }

    public CustomLabelFormatter getCustomLabelFormatter() {
        return this.customLabelFormatter;
    }

    public GraphViewStyle getGraphViewStyle() {
        return this.graphViewStyle;
    }

    public LegendAlign getLegendAlign() {
        return this.legendAlign;
    }

    @Deprecated
    public float getLegendWidth() {
        return (float) getGraphViewStyle().getLegendWidth();
    }

    protected double getMaxX(boolean ignoreViewport) {
        if (!ignoreViewport && this.viewportSize != 0.0d) {
            return this.viewportStart + this.viewportSize;
        }
        if (this.graphSeries.size() <= 0) {
            return 0.0d;
        }
        double highest;
        GraphViewDataInterface[] values = ((GraphViewSeries) this.graphSeries.get(0)).values;
        if (values.length == 0) {
            highest = 0.0d;
        } else {
            highest = values[values.length - 1].getX();
        }
        for (int i = 1; i < this.graphSeries.size(); i++) {
            values = ((GraphViewSeries) this.graphSeries.get(i)).values;
            if (values.length > 0) {
                highest = Math.max(highest, values[values.length - 1].getX());
            }
        }
        return highest;
    }

    protected double getMaxY() {
        if (this.manualYAxis || this.manualMaxY) {
            return this.manualMaxYValue;
        }
        double largest = -2.147483648E9d;
        for (int i = 0; i < this.graphSeries.size(); i++) {
            GraphViewDataInterface[] values = _values(i);
            for (int ii = 0; ii < values.length; ii++) {
                if (values[ii].getY() > largest) {
                    largest = values[ii].getY();
                }
            }
        }
        return largest;
    }

    protected double getMinX(boolean ignoreViewport) {
        if (!ignoreViewport && this.viewportSize != 0.0d) {
            return this.viewportStart;
        }
        if (this.graphSeries.size() <= 0) {
            return 0.0d;
        }
        double lowest;
        GraphViewDataInterface[] values = ((GraphViewSeries) this.graphSeries.get(0)).values;
        if (values.length == 0) {
            lowest = 0.0d;
        } else {
            lowest = values[0].getX();
        }
        for (int i = 1; i < this.graphSeries.size(); i++) {
            values = ((GraphViewSeries) this.graphSeries.get(i)).values;
            if (values.length > 0) {
                lowest = Math.min(lowest, values[0].getX());
            }
        }
        return lowest;
    }

    protected double getMinY() {
        if (this.manualYAxis || this.manualMinY) {
            return this.manualMinYValue;
        }
        double smallest = 2.147483647E9d;
        for (int i = 0; i < this.graphSeries.size(); i++) {
            GraphViewDataInterface[] values = _values(i);
            for (int ii = 0; ii < values.length; ii++) {
                if (values[ii].getY() < smallest) {
                    smallest = values[ii].getY();
                }
            }
        }
        return smallest;
    }

    public double getViewportSize() {
        return this.viewportSize;
    }

    public boolean isDisableTouch() {
        return this.disableTouch;
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    public boolean isShowLegend() {
        return this.showLegend;
    }

    public void redrawAll() {
        if (!this.staticVerticalLabels) {
            this.verlabels = null;
        }
        if (!this.staticHorizontalLabels) {
            this.horlabels = null;
        }
        this.numberformatter[0] = null;
        this.numberformatter[1] = null;
        this.labelTextHeight = null;
        this.horLabelTextWidth = null;
        this.verLabelTextWidth = null;
        invalidate();
        this.viewVerLabels.invalidate();
        this.graphViewContentView.invalidate();
    }

    public void removeAllSeries() {
        for (GraphViewSeries s : this.graphSeries) {
            s.removeGraphView(this);
        }
        while (!this.graphSeries.isEmpty()) {
            this.graphSeries.remove(0);
        }
        redrawAll();
    }

    public void removeSeries(GraphViewSeries series) {
        series.removeGraphView(this);
        this.graphSeries.remove(series);
        redrawAll();
    }

    public void removeSeries(int index) {
        if (index < 0 || index >= this.graphSeries.size()) {
            throw new IndexOutOfBoundsException("No series at index " + index);
        }
        removeSeries((GraphViewSeries) this.graphSeries.get(index));
    }

    public void scrollToEnd() {
        if (this.scrollable) {
            this.viewportStart = getMaxX(true) - this.viewportSize;
            if (!this.staticVerticalLabels) {
                this.verlabels = null;
            }
            if (!this.staticHorizontalLabels) {
                this.horlabels = null;
            }
            invalidate();
            this.viewVerLabels.invalidate();
            this.graphViewContentView.invalidate();
            return;
        }
        throw new IllegalStateException("This GraphView is not scrollable.");
    }

    public void setCustomLabelFormatter(CustomLabelFormatter customLabelFormatter) {
        this.customLabelFormatter = customLabelFormatter;
    }

    public void setDisableTouch(boolean disableTouch) {
        this.disableTouch = disableTouch;
    }

    public void setGraphViewStyle(GraphViewStyle style) {
        this.graphViewStyle = style;
        this.labelTextHeight = null;
    }

    public void setHorizontalLabels(String[] horlabels) {
        this.staticHorizontalLabels = horlabels != null;
        this.horlabels = horlabels;
    }

    public void setLegendAlign(LegendAlign legendAlign) {
        this.legendAlign = legendAlign;
    }

    @Deprecated
    public void setLegendWidth(float legendWidth) {
        getGraphViewStyle().setLegendWidth((int) legendWidth);
    }

    public void setManualYAxis(boolean manualYAxis) {
        this.manualYAxis = manualYAxis;
    }

    public void setManualMaxY(boolean manualMaxY) {
        this.manualMaxY = manualMaxY;
    }

    public void setManualMinY(boolean manualMinY) {
        this.manualMinY = manualMinY;
    }

    public void setManualYAxisBounds(double max, double min) {
        this.manualMaxYValue = max;
        this.manualMinYValue = min;
        this.manualYAxis = true;
    }

    public void setManualYMaxBound(double max) {
        this.manualMaxYValue = max;
        this.manualMaxY = true;
    }

    public void setManualYMinBound(double min) {
        this.manualMinYValue = min;
        this.manualMinY = true;
    }

    public synchronized void setScalable(boolean scalable) {
        this.scalable = scalable;
        if (scalable && this.scaleDetector == null) {
            this.scrollable = true;
            this.scaleDetector = new ScaleGestureDetector(getContext(), new C02481());
        }
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }

    public void setShowLegend(boolean showLegend) {
        this.showLegend = showLegend;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVerticalLabels(String[] verlabels) {
        this.staticVerticalLabels = verlabels != null;
        this.verlabels = verlabels;
    }

    public void setViewPort(double start, double size) {
        if (size < 0.0d) {
            throw new IllegalArgumentException("Viewport size must be greater than 0!");
        }
        this.viewportStart = start;
        this.viewportSize = size;
    }

    public void setShowHorizontalLabels(boolean showHorizontalLabels) {
        this.showHorizontalLabels = showHorizontalLabels;
        redrawAll();
    }

    public boolean getShowHorizontalLabels() {
        return this.showHorizontalLabels;
    }

    public void setShowVerticalLabels(boolean showVerticalLabels) {
        this.showVerticalLabels = showVerticalLabels;
        if (this.showVerticalLabels) {
            addView(this.viewVerLabels, 0);
        } else {
            removeView(this.viewVerLabels);
        }
    }

    public boolean getShowVerticalLabels() {
        return this.showVerticalLabels;
    }
}
