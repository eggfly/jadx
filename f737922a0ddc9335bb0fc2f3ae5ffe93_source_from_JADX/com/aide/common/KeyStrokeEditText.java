package com.aide.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.aide.common.KeyStrokeDetector.a;

public class KeyStrokeEditText extends EditText {
    private KeyStrokeDetector DW;
    private a FH;
    private k j6;

    class 1 implements a {
        final /* synthetic */ KeyStrokeEditText j6;

        1(KeyStrokeEditText keyStrokeEditText) {
            this.j6 = keyStrokeEditText;
        }

        public boolean j6(k kVar) {
            this.j6.setKeyStroke(kVar);
            return true;
        }
    }

    public KeyStrokeEditText(Context context) {
        super(context);
        this.FH = new 1(this);
        j6();
    }

    public KeyStrokeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FH = new 1(this);
        j6();
    }

    public KeyStrokeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FH = new 1(this);
        j6();
    }

    private void j6() {
        this.DW = new KeyStrokeDetector(getContext());
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.imeOptions = 1073741825;
        return this.DW.j6((View) this, this.FH);
    }

    public boolean onCheckIsTextEditor() {
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.DW.j6(i, keyEvent, this.FH)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.DW.DW(i, keyEvent, this.FH)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public k getKeyStroke() {
        return this.j6;
    }

    public void setKeyStroke(k kVar) {
        this.j6 = kVar;
        setText(kVar.toString());
    }
}
