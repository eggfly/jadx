package com.aide.uidesigner;

import android.graphics.drawable.Drawable;
import java.util.Arrays;
import java.util.Comparator;

public class h {
    public static a DW;
    public static a FH;
    public static a Hw;
    public static a[] VH;
    public static a Zo;
    public static a[] gn;
    public static a j6;
    public static a[] u7;
    public static a v5;

    static class 1 implements Comparator<a> {
        1() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((a) obj, (a) obj2);
        }

        public int j6(a aVar, a aVar2) {
            return aVar.j6().compareTo(aVar2.j6());
        }
    }

    public static class a {
        public String DW;
        public Class<?> FH;
        public String Hw;
        public String VH;
        public Class<?> Zo;
        public String gn;
        public Class<?> j6;
        private String tp;
        public boolean u7;
        public b v5;

        public a(String str, String str2, String str3, String str4, b bVar, String str5, String str6) {
            this(str, str2, str4, bVar, str5, str6);
            this.FH = j6(str3);
        }

        public a(String str, String str2, String str3, b bVar, String str4, String str5) {
            this(str, str2, str3, bVar);
            this.Zo = j6(str4);
            this.VH = str4;
            this.gn = str5;
        }

        public a(String str, String str2, String str3, String str4, b bVar) {
            this(str, str2, str4, bVar);
            this.FH = j6(str3);
        }

        public a(String str, String str2, String str3, b bVar) {
            Class j6 = j6(str);
            this.Zo = j6;
            this.j6 = j6;
            this.DW = str3;
            this.Hw = "android:" + str2;
            this.v5 = bVar;
            this.u7 = str2.startsWith("layout_");
            DW();
        }

        private Class<?> j6(String str) {
            try {
                if (str.contains(".")) {
                    return Class.forName(str);
                }
                return Class.forName(h.class.getPackage().getName() + "." + str);
            } catch (ClassNotFoundException e) {
                return null;
            }
        }

        public String j6() {
            return this.tp;
        }

        private void DW() {
            String substring = this.Hw.substring("android:".length());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Character.toUpperCase(substring.charAt(0)));
            int i = 0;
            for (int i2 = 1; i2 < substring.length(); i2++) {
                char charAt = substring.charAt(i2);
                if (i != 0) {
                    stringBuffer.append(Character.toUpperCase(charAt));
                    i = 0;
                } else if (charAt == '_') {
                    stringBuffer.append(" ");
                    i = 1;
                } else {
                    if (Character.isUpperCase(charAt)) {
                        stringBuffer.append(" ");
                    }
                    stringBuffer.append(charAt);
                }
            }
            this.tp = stringBuffer.toString();
        }
    }

    public enum b {
        IntConstant(Integer.TYPE),
        EnumConstant(Enum.class),
        LayoutSize(Integer.TYPE),
        Size(Integer.TYPE),
        FloatSize(Float.TYPE),
        TextSize(Float.TYPE),
        Text(CharSequence.class),
        Float(Float.TYPE),
        Int(Integer.TYPE),
        Bool(Boolean.TYPE),
        ID(Integer.TYPE),
        Color(Integer.TYPE),
        Drawable(Drawable.class),
        DrawableResource(Drawable.class),
        TextAppearance(String.class),
        Event(CharSequence.class);
        
        public Class<?> XL;

        private b(Class<?> cls) {
            this.XL = cls;
        }
    }

    static {
        j6 = new a("android.widget.RelativeLayout$LayoutParams", "layout_toRightOf", "ProxyRelativeLayoutParams", "setRightOf()", b.ID);
        DW = new a("android.widget.RelativeLayout$LayoutParams", "layout_toLeftOf", "ProxyRelativeLayoutParams", "setLeftOf()", b.ID);
        FH = new a("android.widget.RelativeLayout$LayoutParams", "layout_below", "ProxyRelativeLayoutParams", "setBelow()", b.ID);
        Hw = new a("android.widget.RelativeLayout$LayoutParams", "layout_above", "ProxyRelativeLayoutParams", "setAbove()", b.ID);
        v5 = new a("android.view.ViewGroup$LayoutParams", "layout_width", "width", b.LayoutSize);
        Zo = new a("android.view.ViewGroup$LayoutParams", "layout_height", "height", b.LayoutSize);
        VH = new a[]{v5, Zo, new a("android.view.ViewGroup$MarginLayoutParams", "layout_margin", "ProxyMarginLayoutParams", "setMargin()", b.Size), new a("android.view.ViewGroup$MarginLayoutParams", "layout_marginLeft", "leftMargin", b.Size), new a("android.view.ViewGroup$MarginLayoutParams", "layout_marginRight", "rightMargin", b.Size), new a("android.view.ViewGroup$MarginLayoutParams", "layout_marginTop", "topMargin", b.Size), new a("android.view.ViewGroup$MarginLayoutParams", "layout_marginBottom", "bottomMargin", b.Size), new a("android.view.ViewGroup$MarginLayoutParams", "layout_marginStart", "setMarginStart()", b.Size), new a("android.view.ViewGroup$MarginLayoutParams", "layout_marginEnd", "setMarginEnd()", b.Size), new a("android.widget.LinearLayout$LayoutParams", "layout_gravity", "gravity", b.IntConstant, "android.view.Gravity", null), new a("android.widget.LinearLayout$LayoutParams", "layout_weight", "weight", b.Float), FH, Hw, j6, DW, new a("android.widget.RelativeLayout$LayoutParams", "layout_toEndOf", "ProxyRelativeLayoutParams", "setEndOf()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_toStartOf", "ProxyRelativeLayoutParams", "setStartOf()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignBaseline", "ProxyRelativeLayoutParams", "setAlignBaseline()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignBottom", "ProxyRelativeLayoutParams", "setAlignBottom()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignTop", "ProxyRelativeLayoutParams", "setAlignTop()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignEnd", "ProxyRelativeLayoutParams", "setAlignEnd()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignStart", "ProxyRelativeLayoutParams", "setAlignStart()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignRight", "ProxyRelativeLayoutParams", "setAlignRight()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignLeft", "ProxyRelativeLayoutParams", "setAlignLeft()", b.ID), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignParentBottom", "ProxyRelativeLayoutParams", "setAlignParentBottom()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignParentEnd", "ProxyRelativeLayoutParams", "setAlignParentEnd()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignParentLeft", "ProxyRelativeLayoutParams", "setAlignParentLeft()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignParentRight", "ProxyRelativeLayoutParams", "setAlignParentRight()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignParentStart", "ProxyRelativeLayoutParams", "setAlignParentStart()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_alignParentTop", "ProxyRelativeLayoutParams", "setAlignParentTop()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_centerHorizontal", "ProxyRelativeLayoutParams", "setCenterHorizontal()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_centerVertical", "ProxyRelativeLayoutParams", "setCenterVertical()", b.Bool), new a("android.widget.RelativeLayout$LayoutParams", "layout_centerInParent", "ProxyRelativeLayoutParams", "setCenterInParent()", b.Bool), new a("android.widget.GridLayout$LayoutParams", "layout_gravity", "ProxyGridLayoutParams", "setGravity()", b.IntConstant, "android.view.Gravity", null), new a("android.widget.GridLayout$LayoutParams", "layout_column", "ProxyGridLayoutParams", "setColumn()", b.Int), new a("android.widget.GridLayout$LayoutParams", "layout_columnSpan", "ProxyGridLayoutParams", "setColumnSpan()", b.Int), new a("android.widget.GridLayout$LayoutParams", "layout_row", "ProxyGridLayoutParams", "setRow()", b.Int), new a("android.widget.GridLayout$LayoutParams", "layout_rowSpan", "ProxyGridLayoutParams", "setRowSpan()", b.Int), new a("android.widget.FrameLayout$LayoutParams", "layout_gravity", "gravity", b.IntConstant, "android.view.Gravity", null), new a("android.widget.TableRow$LayoutParams", "layout_span", "span", b.Int), new a("android.widget.TableRow$LayoutParams", "layout_column", "column", b.Int), new a("android.widget.AbsoluteLayout$LayoutParams", "layout_x", "x", b.Size), new a("android.widget.AbsoluteLayout$LayoutParams", "layout_y", "y", b.Size)};
        gn = new a[]{new a("android.view.View", "padding", "ProxyViewPaddings", "setPadding()", b.Size), new a("android.view.View", "paddingLeft", "ProxyViewPaddings", "setPaddingLeft()", b.Size), new a("android.view.View", "paddingRight", "ProxyViewPaddings", "setPaddingRight()", b.Size), new a("android.view.View", "paddingTop", "ProxyViewPaddings", "setPaddingTop()", b.Size), new a("android.view.View", "paddingBottom", "ProxyViewPaddings", "setPaddingBottom()", b.Size), new a("android.view.View", "paddingStart", "ProxyViewPaddings", "setPaddingStart()", b.Size), new a("android.view.View", "paddingEnd", "ProxyViewPaddings", "setPaddingEnd()", b.Size), new a("android.view.View", "alpha", "setAlpha()", b.Float), new a("android.view.View", "scaleX", "setScaleX()", b.Float), new a("android.view.View", "scaleY", "setScaleY()", b.Float), new a("android.view.View", "translationX", "setTranslationX()", b.FloatSize), new a("android.view.View", "translationY", "setTranslationY()", b.FloatSize), new a("android.view.View", "translationZ", "setTranslationZ()", b.FloatSize), new a("android.view.View", "rotation", "setRotation()", b.Float), new a("android.view.View", "rotationX", "setRotationX()", b.Float), new a("android.view.View", "rotationY", "setRotationY()", b.Float), new a("android.view.View", "elevation", "setElevation()", b.FloatSize), new a("android.view.View", "minHeight", "setMinimumHeight()", b.Size), new a("android.view.View", "minWidth", "setMinimumWidth()", b.Size), new a("android.view.View", "textAlignment", "setTextAlignment()", b.IntConstant, "android.view.View", "TEXT_ALIGNMENT"), new a("android.view.View", "visibility", "setVisibility()", b.IntConstant), new a("android.view.View", "background", "setBackgroundDrawable()", b.Drawable), new a("android.view.View", "onClick", "", b.Event), new a("android.view.ViewGroup", "clipChildren", "setClipChildren()", b.Bool), new a("android.view.ViewGroup", "clipToPadding", "setClipToPadding()", b.Bool), new a("android.widget.LinearLayout", "orientation", "setOrientation()", b.IntConstant), new a("android.widget.LinearLayout", "gravity", "setGravity()", b.IntConstant, "android.view.Gravity", null), new a("android.widget.LinearLayout", "baselineAligned", "setBaselineAligned()", b.Bool), new a("android.widget.LinearLayout", "baselineAlignedChildIndex", "setBaselineAlignedChildIndex()", b.Int), new a("android.widget.LinearLayout", "measureWithLargestChild", "setMeasureWithLargestChildEnabled()", b.Bool), new a("android.widget.LinearLayout", "weightSum", "setWeightSum()", b.Float), new a("android.widget.RelativeLayout", "gravity", "setGravity()", b.IntConstant, "android.view.Gravity", null), new a("android.widget.RelativeLayout", "ignoreGravity", "setIgnoreGravity()", b.ID), new a("android.widget.FrameLayout", "foregroundGravity", "setForegroundGravity()", b.IntConstant, "android.view.Gravity", null), new a("android.widget.FrameLayout", "measureAllChildren", "setMeasureAllChildren()", b.Bool), new a("android.widget.GridLayout", "columnCount", "setColumnCount()", b.Int), new a("android.widget.GridLayout", "rowCount", "setRowCount()", b.Int), new a("android.widget.GridLayout", "orientation", "setOrientation()", b.IntConstant), new a("android.widget.GridLayout", "columnOrderPreserved", "setColumnOrderPreserved()", b.Bool), new a("android.widget.GridLayout", "rowOrderPreserved", "setRowOrderPreserved()", b.Bool), new a("android.widget.GridLayout", "useDefaultMargins", "setUseDefaultMargins()", b.Bool), new a("android.widget.GridLayout", "alignmentMode", "setAlignmentMode()", b.IntConstant, "android.widget.GridLayout", "ALIGN"), new a("android.widget.TextView", "textAppearance", "ProxyTextView", "setTextAppearance()", b.TextAppearance), new a("android.widget.TextView", "text", "setText()", b.Text), new a("android.widget.TextView", "hint", "setHint()", b.Text), new a("android.widget.TextView", "height", "setHeight()", b.Size), new a("android.widget.TextView", "width", "setWidth()", b.Size), new a("android.widget.TextView", "maxHeight", "setMaxHeight()", b.Size), new a("android.widget.TextView", "maxWidth", "setMaxWidth()", b.Size), new a("android.widget.TextView", "ems", "setEms()", b.Int), new a("android.widget.TextView", "minEms", "setMinEms()", b.Int), new a("android.widget.TextView", "maxEms", "setMaxEms()", b.Int), new a("android.widget.TextView", "gravity", "setGravity()", b.IntConstant, "android.view.Gravity", null), new a("android.widget.TextView", "textScaleX", "setTextScaleX()", b.Float), new a("android.widget.TextView", "textScaleY", "setTextScaleY()", b.Float), new a("android.widget.TextView", "textIsSelectable", "setTextIsSelectable()", b.Bool), new a("android.widget.TextView", "singleLine", "setSingleLine()", b.Bool), new a("android.widget.TextView", "lines", "setLines()", b.Int), new a("android.widget.TextView", "minLines", "setMinLines()", b.Int), new a("android.widget.TextView", "maxLines", "setMaxLines()", b.Int), new a("android.widget.TextView", "textColor", "setTextColor()", b.Color), new a("android.widget.TextView", "textColorHighlight", "setHighlightColor()", b.Color), new a("android.widget.TextView", "textColorHint", "setHintTextColor()", b.Color), new a("android.widget.TextView", "textColorLink", "setLinkTextColor()", b.Color), new a("android.widget.TextView", "ellipsize", "setEllipsize()", b.EnumConstant, "android.text.TextUtils$TruncateAt", null), new a("android.widget.TextView", "textStyle", "ProxyTextView", "setTextStyle()", b.IntConstant, "ProxyTextView", "TEXTSTYLE"), new a("android.widget.TextView", "typeface", "ProxyTextView", "setTypeface()", b.IntConstant, "ProxyTextView", "TYPEFACE"), new a("android.widget.TextView", "inputType", "ProxyTextView", "setInputType()", b.IntConstant, "ProxyTextView", "INPUTTYPE"), new a("android.widget.TextView", "textSize", "setTextSize()", b.TextSize), new a("android.widget.TextView", "shadowColor", "ProxyTextView", "setShadowColor()", b.Color), new a("android.widget.TextView", "shadowDx", "ProxyTextView", "setShadowDx()", b.Float), new a("android.widget.TextView", "shadowDy", "ProxyTextView", "setShadowDy()", b.Float), new a("android.widget.TextView", "shadowRadius", "ProxyTextView", "setShadowRadius()", b.Float), new a("android.widget.ScrollView", "fillViewport", "setFillViewport()", b.Bool), new a("android.widget.ImageView", "src", "setImageDrawable()", b.DrawableResource), new a("android.widget.ImageView", "scaleType", "setScaleType()", b.EnumConstant, "android.widget.ImageView$ScaleType", null), new a("android.widget.ImageView", "adjustViewBounds", "setAdjustViewBounds()", b.Bool), new a("android.widget.ImageView", "baseLine", "setBaseLine()", b.Size), new a("android.widget.ImageView", "baselineAlignBottom", "setBaselineAlignBottom()", b.Bool), new a("android.widget.ImageView", "cropToPadding", "setCropToPadding()", b.Bool), new a("android.widget.ImageView", "maxHeight", "setMaxHeight()", b.Size), new a("android.widget.ImageView", "maxWidth", "setMaxWidth()", b.Size), new a("android.widget.ProgressBar", "indeterminate", "setIndeterminate()", b.Bool), new a("android.widget.ProgressBar", "indeterminateOnly", "setIndeterminate()", b.Bool), new a("android.widget.ProgressBar", "indeterminateDrawable", "setIndeterminateDrawable()", b.DrawableResource), new a("android.widget.ProgressBar", "progressDrawable", "setProgressDrawable()", b.DrawableResource), new a("android.widget.Switch", "switchMinWidth", "setSwitchMinWidth()", b.Size), new a("android.widget.Switch", "switchPadding", "setSwitchPadding()", b.Size), new a("android.widget.Switch", "textOff", "setTextOff()", b.Text), new a("android.widget.Switch", "textOn", "setTextOn()", b.Text), new a("android.widget.Switch", "thumbTextPadding", "setThumbTextPadding()", b.Size), new a("android.widget.Switch", "thumb", "setThumbDrawable()", b.Drawable), new a("android.widget.Switch", "track", "setTrackDrawable()", b.Drawable), new a("android.widget.ToggleButton", "textOff", "setTextOff()", b.Text), new a("android.widget.ToggleButton", "textOn", "setTextOn()", b.Text), new a("android.widget.Spinner", "gravity", "setGravity()", b.IntConstant, "android.view.Gravity", null), new a("android.widget.Spinner", "dropDownWidth", "setDropDownWidth()", b.Size), new a("android.widget.Spinner", "dropDownHorizontalOffset", "setDropDownHorizontalOffset()", b.Size), new a("android.widget.Spinner", "prompt", "setPrompt()", b.Text), new a("android.widget.Spinner", "dropDownVerticalOffset", "setDropDownVerticalOffset()", b.Size), new a("android.widget.Spinner", "popupBackground", "setPopupBackgroundDrawable()", b.Drawable), new a("android.widget.RatingBar", "numStars", "setNumStars()", b.Int), new a("android.widget.RatingBar", "rating", "setRating()", b.Float), new a("android.widget.RatingBar", "stepSize", "setStepSize()", b.Float), new a("android.widget.RatingBar", "isIndicator", "setIsIndicator()", b.Bool), new a("android.widget.DatePicker", "calendarViewShown", "setCalendarViewShown()", b.Bool), new a("android.widget.DatePicker", "spinnersShown", "setSpinnersShown()", b.Bool), new a("android.widget.ListView", "divider", "setDivider()", b.Drawable), new a("android.widget.ListView", "dividerHeight", "setDividerHeight()", b.Size)};
        u7 = new a[(VH.length + gn.length)];
        System.arraycopy(VH, 0, u7, 0, VH.length);
        System.arraycopy(gn, 0, u7, VH.length, gn.length);
        Arrays.sort(u7, new 1());
    }
}
