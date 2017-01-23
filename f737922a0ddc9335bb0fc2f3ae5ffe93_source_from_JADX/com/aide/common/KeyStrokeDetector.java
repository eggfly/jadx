package com.aide.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.InputConnection;
import com.aide.uidesigner.ProxyTextView;

public class KeyStrokeDetector {
    private boolean DW;
    private boolean EQ;
    private boolean FH;
    private boolean Hw;
    private Context J0;
    private boolean VH;
    private boolean Zo;
    private boolean gn;
    private boolean j6;
    private int tp;
    private boolean u7;
    private boolean v5;
    private KeyCharacterMap we;

    class 1 extends BaseInputConnection {
        final /* synthetic */ View DW;
        final /* synthetic */ KeyStrokeDetector FH;
        final /* synthetic */ a j6;

        1(KeyStrokeDetector keyStrokeDetector, View view, boolean z, a aVar, View view2) {
            this.FH = keyStrokeDetector;
            this.j6 = aVar;
            this.DW = view2;
            super(view, z);
        }

        public boolean performEditorAction(int i) {
            this.FH.j6("performEditorAction" + i);
            return super.performEditorAction(i);
        }

        public boolean setComposingText(CharSequence charSequence, int i) {
            this.FH.j6("setComposingText '" + charSequence + "'");
            for (int i2 = 0; i2 < this.FH.tp; i2++) {
                this.j6.j6(new k(67, false, false, false));
            }
            this.FH.tp = charSequence.length();
            j6(charSequence, this.FH.EQ, this.j6);
            return true;
        }

        public boolean beginBatchEdit() {
            this.FH.j6("beginBatchEdit");
            return super.beginBatchEdit();
        }

        public boolean endBatchEdit() {
            this.FH.j6("endBatchEdit");
            return super.endBatchEdit();
        }

        public boolean commitCompletion(CompletionInfo completionInfo) {
            this.FH.j6("commitCompletion");
            return super.commitCompletion(completionInfo);
        }

        public boolean commitCorrection(CorrectionInfo correctionInfo) {
            this.FH.j6("commitCorrection");
            return super.commitCorrection(correctionInfo);
        }

        public boolean finishComposingText() {
            this.FH.j6("finishComposingText");
            return super.finishComposingText();
        }

        public boolean commitText(CharSequence charSequence, int i) {
            this.FH.j6("commitText '" + charSequence + "'");
            if (VERSION.SDK_INT >= 17) {
                for (int i2 = 0; i2 < this.FH.tp; i2++) {
                    this.j6.j6(new k(67, false, false, false));
                }
                this.FH.tp = 0;
                if ("\n".equals(charSequence.toString())) {
                    j6(charSequence, this.FH.EQ, this.j6);
                } else {
                    j6(charSequence, this.FH.EQ, this.DW);
                }
            } else {
                if (this.FH.tp > 0 && charSequence.length() == 1 && charSequence.charAt(0) == ' ') {
                    this.FH.tp = 0;
                }
                this.FH.tp = 0;
                if ("\n".equals(charSequence.toString())) {
                    j6(charSequence, this.FH.EQ, this.j6);
                } else {
                    j6(charSequence, this.FH.EQ, this.DW);
                }
            }
            return true;
        }

        public boolean deleteSurroundingText(int i, int i2) {
            this.FH.j6("deleteSurroundingText " + i + " " + i2);
            this.FH.tp = 0;
            for (int i3 = 0; i3 < i; i3++) {
                this.j6.j6(new k(67, false, false, false));
            }
            return super.deleteSurroundingText(i, i2);
        }

        private void j6(CharSequence charSequence, boolean z, a aVar) {
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (!z) {
                    if (this.FH.u7 || this.FH.gn) {
                        charAt = Character.toUpperCase(charAt);
                    } else {
                        charAt = Character.toLowerCase(charAt);
                    }
                }
                new char[1][0] = charAt;
                if (aVar != null) {
                    aVar.j6(this.FH.j6(charAt));
                }
            }
        }

        private void j6(CharSequence charSequence, boolean z, View view) {
            if (this.FH.we == null) {
                this.FH.we = KeyCharacterMap.load(0);
            }
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (!z) {
                    if (this.FH.u7 || this.FH.gn) {
                        charAt = Character.toUpperCase(charAt);
                    } else {
                        charAt = Character.toLowerCase(charAt);
                    }
                }
                KeyEvent[] events = this.FH.we.getEvents(new char[]{charAt});
                if (events != null) {
                    for (KeyEvent sendKeyEvent : events) {
                        sendKeyEvent(sendKeyEvent);
                    }
                }
            }
        }

        private KeyEvent j6(KeyEvent keyEvent) {
            return new KeyEvent(keyEvent.getDownTime(), keyEvent.getEventTime(), keyEvent.getAction(), keyEvent.getKeyCode(), keyEvent.getRepeatCount(), keyEvent.getMetaState(), keyEvent.getDeviceId(), keyEvent.getScanCode(), (keyEvent.getFlags() | 4) | 2);
        }

        public boolean sendKeyEvent(KeyEvent keyEvent) {
            this.FH.j6("sendKeyEvent " + keyEvent.getKeyCode());
            this.FH.tp = 0;
            return super.sendKeyEvent(j6(keyEvent));
        }

        public CharSequence getTextBeforeCursor(int i, int i2) {
            if (j6() || d.DW(this.FH.J0)) {
                return super.getTextBeforeCursor(i, i2);
            }
            int min = Math.min(i, 1024);
            CharSequence stringBuilder = new StringBuilder(min);
            for (int i3 = 0; i3 < min; i3++) {
                stringBuilder.append(' ');
            }
            return stringBuilder;
        }

        private boolean j6() {
            String str = null;
            try {
                str = Secure.getString(this.FH.J0.getContentResolver(), "default_input_method");
                this.FH.j6("Default IME: " + str);
            } catch (Exception e) {
            }
            if (str == null || !str.startsWith("com.sonyericsson.")) {
                return false;
            }
            return true;
        }
    }

    public interface a {
        boolean j6(k kVar);
    }

    public KeyStrokeDetector(Context context) {
        boolean z = true;
        this.J0 = context;
        if (context.getResources().getConfiguration().keyboard != 1) {
            z = false;
        }
        this.EQ = z;
        j6("new KeyStrokeDetector() - isSoftKeyboard: " + this.EQ);
    }

    public void j6(Context context) {
        boolean z = true;
        if (context.getResources().getConfiguration().keyboard != 1) {
            z = false;
        }
        this.EQ = z;
        j6("KeyStrokeDetector.onConfigChange() - isSoftKeyboard: " + this.EQ);
        this.we = null;
    }

    public void j6() {
        this.tp = 0;
    }

    public boolean DW() {
        return this.v5 || this.Zo;
    }

    public InputConnection j6(View view, a aVar) {
        return new 1(this, view, true, aVar, view);
    }

    public boolean j6(int i, KeyEvent keyEvent, a aVar) {
        int i2;
        j6("onKeyDown", i, keyEvent);
        if (i == 84) {
            i2 = 57;
        } else {
            i2 = i;
        }
        j6(i2, (keyEvent.getFlags() & 2) != 0);
        k FH = FH(i2, keyEvent);
        if (FH != null && aVar.j6(FH)) {
            j6(FH);
            return true;
        } else if (i != 84) {
            return false;
        } else {
            return true;
        }
    }

    private void j6(String str) {
    }

    private void j6(k kVar) {
        j6("onKeyStroke " + kVar.toString());
    }

    private void j6(String str, int i, KeyEvent keyEvent) {
        j6(str + " " + i + "  " + keyEvent.getFlags() + (keyEvent.isAltPressed() ? " alt" : "") + (keyEvent.isShiftPressed() ? " shift" : "") + " " + (j6(keyEvent.getMetaState()) ? " ctrl" : ""));
    }

    private boolean j6(int i) {
        return (i & 12288) != 0;
    }

    public boolean DW(int i, KeyEvent keyEvent, a aVar) {
        int i2;
        boolean z;
        j6("onKeyUp", i, keyEvent);
        if (i == 84) {
            i2 = 57;
        } else {
            i2 = i;
        }
        if ((keyEvent.getFlags() & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        DW(i2, z);
        if (i == 84) {
            return true;
        }
        return false;
    }

    private k j6(char c) {
        return new k(-1, c, Character.isUpperCase(c) | (this.u7 | this.gn), false, false);
    }

    private k FH(int i, KeyEvent keyEvent) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 57:
            case 58:
            case 59:
            case 60:
            case ProxyTextView.INPUTTYPE_textPostalAddress /*113*/:
            case 114:
                return null;
            default:
                boolean isShiftPressed = (this.FH | this.Hw) | keyEvent.isShiftPressed();
                boolean j6 = (this.v5 | this.Zo) | j6(keyEvent.getMetaState());
                boolean isAltPressed = (this.j6 | this.DW) | keyEvent.isAltPressed();
                char c = '\uffff';
                int unicodeChar = keyEvent.getUnicodeChar();
                if (!(unicodeChar == 0 || Character.isISOControl(unicodeChar))) {
                    c = (char) unicodeChar;
                }
                return new k(i, c, isShiftPressed, j6, isAltPressed);
        }
    }

    public void j6(int i, KeyEvent keyEvent) {
        DW(i, (keyEvent.getFlags() & 2) != 0);
    }

    public void DW(int i, KeyEvent keyEvent) {
        j6(i, (keyEvent.getFlags() & 2) != 0);
    }

    private void j6(int i, boolean z) {
        int i2;
        int i3 = 1;
        j6("onMetaKeysDown " + i);
        this.j6 = (i == 57 ? 1 : 0) | this.j6;
        boolean z2 = this.DW;
        if (i == 58) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.DW = i2 | z2;
        z2 = this.FH;
        if (i == 59) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.FH = i2 | z2;
        z2 = this.Hw;
        if (i == 60) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.Hw = i2 | z2;
        z2 = this.u7;
        if (i != 59 || z) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.u7 = i2 | z2;
        z2 = this.gn;
        if (i != 60 || z) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.gn = i2 | z2;
        z2 = this.VH;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.VH = i2 | z2;
        z2 = this.v5;
        if (i == ProxyTextView.INPUTTYPE_textPostalAddress) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.v5 = i2 | z2;
        boolean z3 = this.Zo;
        if (i != 114) {
            i3 = 0;
        }
        this.Zo = z3 | i3;
    }

    private void DW(int i, boolean z) {
        int i2;
        int i3 = 1;
        j6("onMetaKeysUp " + i);
        this.j6 = (i != 57 ? 1 : 0) & this.j6;
        boolean z2 = this.DW;
        if (i != 58) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.DW = i2 & z2;
        z2 = this.FH;
        if (i != 59) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.FH = i2 & z2;
        z2 = this.Hw;
        if (i != 60) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.Hw = i2 & z2;
        z2 = this.u7;
        if (i != 59 || z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.u7 = i2 & z2;
        z2 = this.gn;
        if (i != 60 || z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.gn = i2 & z2;
        z2 = this.VH;
        if (i != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.VH = i2 & z2;
        z2 = this.v5;
        if (i != ProxyTextView.INPUTTYPE_textPostalAddress) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.v5 = i2 & z2;
        boolean z3 = this.Zo;
        if (i == 114) {
            i3 = 0;
        }
        this.Zo = z3 & i3;
    }
}
