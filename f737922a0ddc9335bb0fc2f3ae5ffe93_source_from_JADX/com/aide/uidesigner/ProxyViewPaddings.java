package com.aide.uidesigner;

import android.os.Build.VERSION;
import android.view.View;

public class ProxyViewPaddings {
    private int padding;
    private int paddingBottom;
    private int paddingEnd;
    private int paddingLeft;
    private int paddingRight;
    private int paddingStart;
    private int paddingTop;
    private View view;

    public ProxyViewPaddings(Object obj) {
        this.view = (View) obj;
    }

    public void setPadding(int i) {
        this.padding = i;
        updatePadding();
    }

    public void setPaddingLeft(int i) {
        this.paddingLeft = i;
        updatePadding();
    }

    public void setPaddingRight(int i) {
        this.paddingRight = i;
        updatePadding();
    }

    public void setPaddingTop(int i) {
        this.paddingTop = i;
        updatePadding();
    }

    public void setPaddingBottom(int i) {
        this.paddingBottom = i;
        updatePadding();
    }

    public void setPaddingStart(int i) {
        this.paddingStart = i;
        updatePadding();
    }

    public void setPaddingEnd(int i) {
        this.paddingEnd = i;
        updatePadding();
    }

    private void updatePadding() {
        if (this.padding > 0) {
            this.view.setPadding(this.padding, this.padding, this.padding, this.padding);
        } else if (this.paddingStart > 0 || this.paddingEnd > 0) {
            if (VERSION.SDK_INT >= 17) {
                this.view.setPaddingRelative(this.paddingStart, this.paddingTop, this.paddingEnd, this.paddingBottom);
            }
        } else if (this.paddingLeft > 0 || this.paddingRight > 0 || this.paddingTop > 0 || this.paddingBottom > 0) {
            this.view.setPadding(this.paddingLeft, this.paddingTop, this.paddingRight, this.paddingBottom);
        }
    }
}
