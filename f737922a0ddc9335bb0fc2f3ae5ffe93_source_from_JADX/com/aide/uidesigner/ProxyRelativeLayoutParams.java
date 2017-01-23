package com.aide.uidesigner;

import android.widget.RelativeLayout.LayoutParams;

public class ProxyRelativeLayoutParams {
    private LayoutParams params;

    public ProxyRelativeLayoutParams(Object obj) {
        this.params = (LayoutParams) obj;
    }

    public void setBelow(int i) {
        this.params.addRule(3, i);
    }

    public void setAlignLeft(int i) {
        this.params.addRule(5, i);
    }

    public void setAlignRight(int i) {
        this.params.addRule(7, i);
    }

    public void setAlignStart(int i) {
        this.params.addRule(18, i);
    }

    public void setAlignEnd(int i) {
        this.params.addRule(19, i);
    }

    public void setAlignTop(int i) {
        this.params.addRule(6, i);
    }

    public void setAlignBottom(int i) {
        this.params.addRule(8, i);
    }

    public void setAlignBaseline(int i) {
        this.params.addRule(4, i);
    }

    public void setEndOf(int i) {
        this.params.addRule(17, i);
    }

    public void setStartOf(int i) {
        this.params.addRule(16, i);
    }

    public void setLeftOf(int i) {
        this.params.addRule(0, i);
    }

    public void setRightOf(int i) {
        this.params.addRule(1, i);
    }

    public void setAbove(int i) {
        this.params.addRule(2, i);
    }

    public void setAlignParentBottom(boolean z) {
        if (z) {
            this.params.addRule(12);
        }
    }

    public void setAlignParentTop(boolean z) {
        if (z) {
            this.params.addRule(10);
        }
    }

    public void setAlignParentLeft(boolean z) {
        if (z) {
            this.params.addRule(9);
        }
    }

    public void setAlignParentRight(boolean z) {
        if (z) {
            this.params.addRule(11);
        }
    }

    public void setAlignParentStart(boolean z) {
        if (z) {
            this.params.addRule(20);
        }
    }

    public void setAlignParentEnd(boolean z) {
        if (z) {
            this.params.addRule(21);
        }
    }

    public void setCenterInParent(boolean z) {
        if (z) {
            this.params.addRule(13);
        }
    }

    public void setCenterVertical(boolean z) {
        if (z) {
            this.params.addRule(15);
        }
    }

    public void setCenterHorizontal(boolean z) {
        if (z) {
            this.params.addRule(14);
        }
    }
}
