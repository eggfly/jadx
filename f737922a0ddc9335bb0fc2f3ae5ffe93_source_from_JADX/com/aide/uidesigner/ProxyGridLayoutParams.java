package com.aide.uidesigner;

import android.widget.GridLayout;
import android.widget.GridLayout.Alignment;
import android.widget.GridLayout.LayoutParams;
import java.lang.reflect.Field;

public class ProxyGridLayoutParams {
    private int column;
    private int columnSpan;
    private int gravity;
    private LayoutParams params;
    private int row;
    private int rowSpan;

    public ProxyGridLayoutParams(Object obj) {
        this.column = 0;
        this.row = 0;
        this.columnSpan = 1;
        this.rowSpan = 1;
        this.gravity = 0;
        this.params = (LayoutParams) obj;
        updateSpecs();
    }

    public void setColumn(int i) {
        this.column = i;
        updateSpecs();
    }

    public void setColumnSpan(int i) {
        this.columnSpan = i;
        updateSpecs();
    }

    public void setRow(int i) {
        this.row = i;
        updateSpecs();
    }

    public void setRowSpan(int i) {
        this.rowSpan = i;
        updateSpecs();
    }

    public void setGravity(int i) {
        this.gravity = i;
        updateSpecs();
    }

    private void updateSpecs() {
        this.params.columnSpec = GridLayout.spec(this.column, this.columnSpan, getAlignment(this.gravity, true));
        this.params.rowSpec = GridLayout.spec(this.row, this.rowSpan, getAlignment(this.gravity, false));
    }

    private static Alignment getAlignment(int i, boolean z) {
        switch (((z ? 7 : 112) & i) >> (z ? 0 : 4)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return GridLayout.CENTER;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return z ? GridLayout.LEFT : GridLayout.TOP;
            case 5:
                return z ? GridLayout.RIGHT : GridLayout.BOTTOM;
            case 7:
                return GridLayout.FILL;
            default:
                try {
                    Field declaredField = GridLayout.class.getDeclaredField("UNDEFINED_ALIGNMENT");
                    declaredField.setAccessible(true);
                    return (Alignment) declaredField.get(null);
                } catch (Throwable th) {
                    return GridLayout.CENTER;
                }
        }
    }
}
