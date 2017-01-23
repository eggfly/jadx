package com.aide.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.aide.common.KeyStrokeDetector;
import com.aide.common.KeyStrokeDetector.a;
import com.aide.uidesigner.ProxyTextView;

public class CompletionListView extends CustomKeysListView {
    private a DW;
    private KeyStrokeDetector j6;

    public void setKeyStrokeDetector(KeyStrokeDetector keyStrokeDetector) {
        this.j6 = keyStrokeDetector;
    }

    public void setKeyStrokeHandler(a aVar) {
        this.DW = aVar;
    }

    public CompletionListView(Context context) {
        super(context);
    }

    public CompletionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompletionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.imeOptions = 1073741825;
        return this.j6.j6((View) this, this.DW);
    }

    public boolean onCheckIsTextEditor() {
        return this.j6 != null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 19:
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 23:
            case 66:
            case 92:
            case 93:
            case 96:
            case 122:
            case 123:
                return j6(i, keyEvent);
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 19:
            case ProxyTextView.INPUTTYPE_date /*20*/:
            case 23:
            case 66:
            case 92:
            case 93:
            case 96:
            case 122:
            case 123:
                return DW(i, keyEvent);
            default:
                return super.onKeyUp(i, keyEvent);
        }
    }
}
