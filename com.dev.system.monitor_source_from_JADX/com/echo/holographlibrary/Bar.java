package com.echo.holographlibrary;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.support.v4.view.MotionEventCompat;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class Bar {
    public int mAnimateSpecial;
    private int mColor;
    private int mColorAlpha;
    private float mGoalValue;
    private int mLabelColor;
    private String mName;
    private float mOldValue;
    private final Path mPath;
    private final Region mRegion;
    private int mSelectedColor;
    private float mValue;
    private int mValueColor;
    private String mValuePrefix;
    private String mValueString;
    private String mValueSuffix;

    public Bar() {
        this.mPath = new Path();
        this.mRegion = new Region();
        this.mColor = -13388315;
        this.mLabelColor = -1;
        this.mSelectedColor = -1;
        this.mValueColor = -1;
        this.mColorAlpha = MotionEventCompat.ACTION_MASK;
        this.mName = null;
        this.mValueString = null;
        this.mValuePrefix = null;
        this.mValueSuffix = null;
        this.mAnimateSpecial = 0;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getColorAlpha() {
        return this.mColorAlpha;
    }

    public void setColor(int color) {
        this.mColor = color;
        this.mColorAlpha = Color.alpha(color);
    }

    public int getLabelColor() {
        return this.mLabelColor == -1 ? this.mColor : this.mLabelColor;
    }

    public void setLabelColor(int labelColor) {
        this.mLabelColor = labelColor;
    }

    public int getSelectedColor() {
        if (-1 == this.mSelectedColor) {
            this.mSelectedColor = Utils.darkenColor(this.mColor);
        }
        return this.mSelectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        this.mSelectedColor = selectedColor;
    }

    public int getValueColor() {
        return this.mValueColor;
    }

    public void setValueColor(int valueColor) {
        this.mValueColor = valueColor;
    }

    public String getName() {
        return this.mName == null ? BuildConfig.VERSION_NAME : this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float value) {
        this.mValue = value;
    }

    public float getOldValue() {
        return this.mOldValue;
    }

    public void setOldValue(float oldValue) {
        this.mOldValue = oldValue;
    }

    public float getGoalValue() {
        return this.mGoalValue;
    }

    public void setGoalValue(float goalValue) {
        this.mGoalValue = goalValue;
    }

    public String getValueString() {
        if (this.mValueString != null) {
            return this.mValueString;
        }
        return String.valueOf(this.mValue);
    }

    public void setValueString(String valueString) {
        this.mValueString = valueString;
    }

    public String getValuePrefix() {
        return this.mValuePrefix;
    }

    public void setValuePrefix(String valuePrefix) {
        this.mValuePrefix = valuePrefix;
    }

    public String getValueSuffix() {
        return this.mValueSuffix;
    }

    public void setValueSuffix(String valueSuffix) {
        this.mValueSuffix = valueSuffix;
    }

    public void makeValueString(int decimalPrecision) {
        String base = String.format("%." + String.valueOf(decimalPrecision) + "f", new Object[]{Float.valueOf(this.mValue)});
        if (getValuePrefix() != null) {
            base = getValuePrefix() + base;
        }
        if (getValueSuffix() != null) {
            base = base + getValueSuffix();
        }
        setValueString(base);
    }

    public Path getPath() {
        return this.mPath;
    }

    public Region getRegion() {
        return this.mRegion;
    }
}
