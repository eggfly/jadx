package com.aide.ui.views;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.aide.common.KeyStrokeDetector;
import com.aide.common.e;
import com.aide.engine.FileHighlightings;
import com.aide.engine.f;
import com.aide.engine.h;
import com.aide.ui.views.editor.OEditor;
import com.aide.ui.views.editor.g;
import com.aide.ui.views.editor.j;
import com.aide.ui.views.editor.k;
import com.aide.ui.views.editor.n;
import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import qi;
import qj;
import qt;

public class CodeEditText extends ViewGroup {
    private List<d> DW;
    private List<d> FH;
    private List<d> Hw;
    private List<d> VH;
    private List<d> Zo;
    private List<qi> gn;
    private boolean j6;
    private boolean u7;
    private List<d> v5;

    public interface d {
        void j6(int i, int i2, int i3, int i4);
    }

    protected class a extends com.aide.ui.views.editor.d {
        final /* synthetic */ CodeEditText DW;

        public a(CodeEditText codeEditText, Reader reader, int i) {
            this.DW = codeEditText;
            super(reader, false, false, i);
        }

        public a(CodeEditText codeEditText) {
            this.DW = codeEditText;
        }

        public void v5(int i, int i2) {
        }

        public void j6(char c, int i, int i2) {
        }

        public void DW(char c, int i, int i2) {
        }

        public boolean Hw(int i, int i2) {
            return false;
        }

        public void FH(int i, int i2) {
        }

        public void j6(int i, int i2, int i3) {
        }

        public void tp() {
        }

        public void j6(int i, int i2, int i3, int i4, String str) {
            j6(new qt(i - 1, i2 - 1, i3 - 1, i4 - 2), (Object) this);
            try {
                j6(i2 - 1, i - 1, new StringReader(str), (Object) this);
            } catch (IOException e) {
            }
        }
    }

    protected class b extends a {
        final /* synthetic */ CodeEditText FH;
        private h Hw;
        private h VH;
        private Object Zo;
        private h gn;
        private Object j6;
        private h v5;

        class 1 implements k {
            final /* synthetic */ b j6;

            1(b bVar) {
                this.j6 = bVar;
            }

            public void DW(j jVar, int i, int i2, int i3, int i4) {
                synchronized (this.j6.j6) {
                    this.j6.Hw.j6(i2, i, i4, i3);
                }
                synchronized (this.j6.Zo) {
                    this.j6.VH.j6(i2, i, i4, i3);
                }
            }

            public void j6(j jVar, int i, int i2, int i3, int i4) {
                synchronized (this.j6.j6) {
                    this.j6.Hw.DW(i2, i, i4, i3);
                }
                synchronized (this.j6.Zo) {
                    this.j6.VH.DW(i2, i, i4, i3);
                }
            }

            public void j6(j jVar, int i, int i2, int i3, char[] cArr) {
            }

            public void j6(j jVar) {
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ b j6;

            2(b bVar) {
                this.j6 = bVar;
            }

            public void run() {
                this.j6.FH(0, 0, 0, this.j6.FH());
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ b j6;

            3(b bVar) {
                this.j6 = bVar;
            }

            public void run() {
                this.j6.FH(0, 0, 0, this.j6.FH());
            }
        }

        public b(CodeEditText codeEditText, Reader reader, int i) {
            this.FH = codeEditText;
            super(codeEditText, reader, i);
            this.j6 = new Object();
            this.Hw = new h();
            this.v5 = new h();
            this.Zo = new Object();
            this.VH = new h();
            this.gn = new h();
            j6();
        }

        public b(CodeEditText codeEditText) {
            this.FH = codeEditText;
            super(codeEditText);
            this.j6 = new Object();
            this.Hw = new h();
            this.v5 = new h();
            this.Zo = new Object();
            this.VH = new h();
            this.gn = new h();
            j6();
        }

        private void j6() {
            j6(new 1(this));
        }

        public void DW(FileHighlightings fileHighlightings) {
            DW(fileHighlightings.DW, fileHighlightings.FH, fileHighlightings.Hw, fileHighlightings.v5, fileHighlightings.Zo, fileHighlightings.VH);
        }

        public void j6(FileHighlightings fileHighlightings) {
            j6(fileHighlightings.DW, fileHighlightings.FH, fileHighlightings.Hw, fileHighlightings.v5, fileHighlightings.Zo, fileHighlightings.VH);
        }

        public void DW(f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
            this.v5.j6(fVarArr, iArr, iArr2, iArr3, iArr4, i);
            EQ();
        }

        protected void EQ() {
            synchronized (this.j6) {
                h hVar = this.Hw;
                this.Hw = this.v5;
                this.v5 = hVar;
            }
            this.FH.post(new 2(this));
        }

        protected h we() {
            return this.v5;
        }

        public void j6(f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
            this.gn.j6(fVarArr, iArr, iArr2, iArr3, iArr4, i);
            synchronized (this.Zo) {
                h hVar = this.VH;
                this.VH = this.gn;
                this.gn = hVar;
            }
            this.FH.post(new 3(this));
        }

        public int DW(int i, int i2) {
            int j6 = this.VH.j6(i2, i);
            if (j6 == 0) {
                return this.Hw.j6(i2, i);
            }
            return j6;
        }

        public int v5() {
            return f.values().length;
        }

        public n Zo(int i) {
            f fVar = f.values()[i];
            int j6 = fVar.j6(this.FH.getContext(), this.FH.rN());
            int i2 = 0;
            switch (fVar.j6()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i2 = 1;
                    break;
            }
            return new n(j6, i2);
        }
    }

    protected class c extends OEditor {
        private float BT;
        private int Mr;
        private boolean P8;
        private int U2;
        private float XL;
        private Runnable a8;
        private float aM;
        private boolean ei;
        private float er;
        private long gW;
        private float j3;
        final /* synthetic */ CodeEditText j6;
        private boolean lg;
        private com.aide.common.KeyStrokeDetector.a nw;
        private float rN;
        private float vy;
        private long yS;

        class 1 implements com.aide.common.KeyStrokeDetector.a {
            final /* synthetic */ c j6;

            1(c cVar) {
                this.j6 = cVar;
            }

            public boolean j6(com.aide.common.k kVar) {
                int FH = kVar.FH();
                if (FH == 96 || FH == 23) {
                    this.j6.j6.aM();
                    return true;
                }
                qi DW = DW(kVar);
                if (DW != null) {
                    if (!DW.g_()) {
                        return true;
                    }
                    DW.DW();
                    return true;
                } else if (kVar.j6()) {
                    this.j6.j6.j6(kVar.DW());
                    return true;
                } else if (kVar.FH() != 66) {
                    return this.j6.j6.j6(kVar);
                } else {
                    this.j6.j6.j6('\n');
                    return true;
                }
            }

            private qi DW(com.aide.common.k kVar) {
                List<com.aide.common.k> j6;
                List<qi> customEditorCommands = this.j6.j6.getCustomEditorCommands();
                if (customEditorCommands != null) {
                    for (qi qiVar : customEditorCommands) {
                        j6 = this.j6.j6.j6(qiVar);
                        if (j6 != null) {
                            for (com.aide.common.k j62 : j6) {
                                if (j62.j6(kVar)) {
                                    return qiVar;
                                }
                            }
                            continue;
                        }
                    }
                }
                for (qi qiVar2 : this.j6.j6.getBasicEditorCommands()) {
                    j6 = this.j6.j6.j6(qiVar2);
                    if (j6 != null) {
                        for (com.aide.common.k j622 : j6) {
                            if (j622.j6(kVar)) {
                                return qiVar2;
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ c j6;

            2(c cVar) {
                this.j6 = cVar;
            }

            public void run() {
                this.j6.lg = true;
                int j6 = this.j6.Hw(this.j6.rN, this.j6.er);
                int DW = this.j6.v5(this.j6.rN, this.j6.er);
                if (j6 > 0 && DW > 0) {
                    this.j6.performHapticFeedback(0, 1);
                    this.j6.j6.j6(j6, this.j6.J0(j6, DW), j6, this.j6.we(j6, DW), this.j6.j6.FH);
                }
            }
        }

        private class a implements qj {
            private com.aide.ui.views.editor.OEditor.d DW;
            private com.aide.common.k FH;
            private String Hw;
            final /* synthetic */ c j6;
            private String v5;

            public a(c cVar, String str, com.aide.common.k kVar, com.aide.ui.views.editor.OEditor.d dVar) {
                this.j6 = cVar;
                this.v5 = getClass().getName() + "." + dVar.name();
                this.Hw = str;
                this.FH = kVar;
                this.DW = dVar;
            }

            public boolean g_() {
                return true;
            }

            public boolean DW() {
                this.j6.j6(this.DW).j6();
                return true;
            }

            public String v5() {
                return this.Hw;
            }

            public com.aide.common.k j6() {
                return this.FH;
            }

            public String Hw() {
                return this.v5;
            }
        }

        public c(CodeEditText codeEditText, Context context) {
            this.j6 = codeEditText;
            super(context);
            this.ei = true;
            this.nw = new 1(this);
            nw();
        }

        private void nw() {
            setFocusable(true);
            setFocusableInTouchMode(true);
            setNextFocusUpId(this.j6.getNextFocusUpId());
            setId(123412345);
            setCaretVisibility(true);
            this.j6.gn.add(new a(this, "Copy", new com.aide.common.k(31, false, true, false), com.aide.ui.views.editor.OEditor.d.copy_selection));
            this.j6.gn.add(new a(this, "Select All", new com.aide.common.k(29, false, true, false), com.aide.ui.views.editor.OEditor.d.select_all));
            this.j6.gn.add(new a(this, "Delete Character", new com.aide.common.k(67, false, false, false), com.aide.ui.views.editor.OEditor.d.remove_preceding_character));
            this.j6.gn.add(new a(this, "Delete Character Right", new com.aide.common.k(67, true, false, false), com.aide.ui.views.editor.OEditor.d.remove_current_character));
            this.j6.gn.add(new a(this, "Delete Word", new com.aide.common.k(67, false, true, false), com.aide.ui.views.editor.OEditor.d.delete_word_left));
            this.j6.gn.add(new a(this, "Insert Tab", new com.aide.common.k(61, false, false, false), com.aide.ui.views.editor.OEditor.d.insert_tab));
            this.j6.gn.add(new a(this, "Insert Newline", new com.aide.common.k(66, false, false, false), com.aide.ui.views.editor.OEditor.d.insert_line_break));
            this.j6.gn.add(new a(this, "Move to Beginning of File", new com.aide.common.k(19, false, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_beginning_of_text));
            this.j6.gn.add(new a(this, "Move to End of File", new com.aide.common.k(20, false, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_end_of_text));
            this.j6.gn.add(new a(this, "Move to Beginning of Line", new com.aide.common.k(21, false, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_beginning_of_text_in_line));
            this.j6.gn.add(new a(this, "Move to End of Line", new com.aide.common.k(22, false, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_end_of_line));
            this.j6.gn.add(new a(this, "Select to Beginning of File", new com.aide.common.k(19, true, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_beginning_of_text_select));
            this.j6.gn.add(new a(this, "Select to End of File", new com.aide.common.k(20, true, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_end_of_text_select));
            this.j6.gn.add(new a(this, "Select to Beginning of Line", new com.aide.common.k(21, true, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_beginning_of_text_in_line_select));
            this.j6.gn.add(new a(this, "Select to End of Line", new com.aide.common.k(22, true, true, true), com.aide.ui.views.editor.OEditor.d.move_caret_to_end_of_line_select));
            this.j6.gn.add(new a(this, "Move Page Up", new com.aide.common.k(92, false, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_page_up));
            this.j6.gn.add(new a(this, "Move Page Down", new com.aide.common.k(93, false, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_page_down));
            this.j6.gn.add(new a(this, "Move Up", new com.aide.common.k(19, false, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_up));
            this.j6.gn.add(new a(this, "Move Down", new com.aide.common.k(20, false, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_down));
            this.j6.gn.add(new a(this, "Move Left", new com.aide.common.k(21, false, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_left));
            this.j6.gn.add(new a(this, "Move Right", new com.aide.common.k(22, false, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_right));
            this.j6.gn.add(new a(this, "Move Word Left", new com.aide.common.k(21, false, true, false), com.aide.ui.views.editor.OEditor.d.move_caret_word_left));
            this.j6.gn.add(new a(this, "Move Word Right", new com.aide.common.k(22, false, true, false), com.aide.ui.views.editor.OEditor.d.move_caret_word_right));
            this.j6.gn.add(new a(this, "Select Page Up", new com.aide.common.k(92, true, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_page_up_select));
            this.j6.gn.add(new a(this, "Select Page Down", new com.aide.common.k(93, true, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_page_down_select));
            this.j6.gn.add(new a(this, "Select Word Left", new com.aide.common.k(21, true, true, false), com.aide.ui.views.editor.OEditor.d.move_caret_word_left_select));
            this.j6.gn.add(new a(this, "Select Word Right", new com.aide.common.k(22, true, true, false), com.aide.ui.views.editor.OEditor.d.move_caret_word_right_select));
            this.j6.gn.add(new a(this, "Select Up", new com.aide.common.k(19, true, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_up_select));
            this.j6.gn.add(new a(this, "Select Down", new com.aide.common.k(20, true, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_down_select));
            this.j6.gn.add(new a(this, "Select Left", new com.aide.common.k(21, true, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_left_select));
            this.j6.gn.add(new a(this, "Select Right", new com.aide.common.k(22, true, false, false), com.aide.ui.views.editor.OEditor.d.move_caret_right_select));
        }

        protected boolean j6() {
            return super.j6() || this.j6.Zo();
        }

        protected float getSideBarPaddingLeft() {
            return this.j6.getSideBarPadding();
        }

        protected boolean DW() {
            return this.j6.we();
        }

        public void FH() {
            g gVar = null;
            super.FH();
            if (this.j6 != null) {
                g gVar2;
                if (com.aide.common.d.j6(getContext())) {
                    this.tp = new g(getResources().getColor(this.j6.rN() ? 2131230723 : 2131230722));
                } else {
                    this.tp = new g(getResources().getColor(this.j6.rN() ? 2131230780 : 2131230779));
                }
                this.DW = new g(getResources().getColor(this.j6.rN() ? 2131230766 : 2131230765));
                if (this.ei) {
                    gVar2 = new g(getResources().getColor(this.j6.rN() ? 2131230770 : 2131230769));
                } else {
                    gVar2 = null;
                }
                this.FH = gVar2;
                if (this.ei) {
                    gVar = new g(getResources().getColor(this.j6.rN() ? 2131230784 : 2131230783));
                }
                this.EQ = gVar;
                this.v5 = new g(getResources().getColor(this.j6.rN() ? 2131230768 : 2131230767));
                this.Zo = new g(getResources().getColor(this.j6.rN() ? 2131230782 : 2131230781));
                this.u7 = new g(getResources().getColor(this.j6.rN() ? 2131230776 : 2131230775));
                this.gn = new g(getResources().getColor(this.j6.rN() ? 2131230774 : 2131230773));
                this.VH = new g(getResources().getColor(this.j6.rN() ? 2131230772 : 2131230771));
                this.Hw = new g(getResources().getColor(this.j6.rN() ? 2131230778 : 2131230777));
            }
        }

        public void setShowCaretLine(boolean z) {
            this.ei = z;
            FH();
        }

        public com.aide.common.KeyStrokeDetector.a getKeyStrokeHandler() {
            return this.nw;
        }

        protected Parcelable onSaveInstanceState() {
            Parcelable bundle = new Bundle();
            bundle.putParcelable("instanceState", super.onSaveInstanceState());
            bundle.putInt("selStartLine", this.j6.getSelectionStartLine());
            bundle.putInt("selStartColumn", this.j6.getSelectionStartColumn());
            bundle.putInt("selEndLine", this.j6.getSelectionEndLine());
            bundle.putInt("selEndColumn", this.j6.getSelectionEndColumn());
            bundle.putFloat("fontSize", getFontSize());
            return bundle;
        }

        protected void onRestoreInstanceState(Parcelable parcelable) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
                j6(bundle.getInt("selStartLine"), bundle.getInt("selStartColumn"), bundle.getInt("selEndLine"), bundle.getInt("selEndColumn"));
                setFontSize(bundle.getFloat("fontSize"));
                return;
            }
            super.onRestoreInstanceState(parcelable);
        }

        public void j6(int i, int i2) {
            getCodeEditTextEditorModel().v5(i, i2);
        }

        public void j6(char c, int i, int i2) {
            getCodeEditTextEditorModel().DW(c, i, i2);
        }

        public void DW(char c, int i, int i2) {
            getCodeEditTextEditorModel().j6(c, i, i2);
        }

        public void DW(int i, int i2) {
            if (!getCodeEditTextEditorModel().Hw(i, i2)) {
                super.DW(i, i2);
            }
        }

        public void FH(int i, int i2) {
            getCodeEditTextEditorModel().FH(i, i2);
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            if (com.aide.common.d.DW(getContext())) {
                editorInfo.imeOptions = 1342177280;
                editorInfo.inputType = 1;
            } else if (com.aide.common.d.j6()) {
                editorInfo.imeOptions = 1342177281;
                editorInfo.inputType = 1;
            } else {
                editorInfo.imeOptions = 1342177281;
            }
            return this.j6.getKeyStrokeDetector().j6((View) this, this.nw);
        }

        public boolean onCheckIsTextEditor() {
            return true;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            boolean z = true;
            try {
                if (!this.j6.getKeyStrokeDetector().j6(i, keyEvent, this.nw)) {
                    z = super.onKeyDown(i, keyEvent);
                }
            } catch (Throwable th) {
                e.DW(th);
            }
            return z;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onKeyUp(int r4, android.view.KeyEvent r5) {
            /*
            r3 = this;
            r0 = 1;
            r1 = 4;
            if (r4 != r1) goto L_0x000d;
        L_0x0004:
            r1 = r3.j6;	 Catch:{ Throwable -> 0x0020 }
            r1 = r1.v5();	 Catch:{ Throwable -> 0x0020 }
            if (r1 == 0) goto L_0x000d;
        L_0x000c:
            return r0;
        L_0x000d:
            r1 = r3.j6;	 Catch:{ Throwable -> 0x0020 }
            r1 = r1.getKeyStrokeDetector();	 Catch:{ Throwable -> 0x0020 }
            r2 = r3.nw;	 Catch:{ Throwable -> 0x0020 }
            r1 = r1.DW(r4, r5, r2);	 Catch:{ Throwable -> 0x0020 }
            if (r1 != 0) goto L_0x000c;
        L_0x001b:
            r0 = super.onKeyUp(r4, r5);	 Catch:{ Throwable -> 0x0020 }
            goto L_0x000c;
        L_0x0020:
            r1 = move-exception;
            com.aide.common.e.DW(r1);
            goto L_0x000c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.views.CodeEditText.c.onKeyUp(int, android.view.KeyEvent):boolean");
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            width = Math.max(getMeasuredWidth() + this.j6.getTextPaddingRight(), width);
            if (this.j6.FH()) {
                setMeasuredDimension(width, height + getMeasuredHeight());
            } else {
                setMeasuredDimension(width, Math.max(getMeasuredHeight(), height));
            }
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z = false;
            try {
                if (!Zo()) {
                    this.rN = motionEvent.getX();
                    this.er = motionEvent.getY();
                    int action = motionEvent.getAction();
                    boolean j6 = com.aide.common.d.j6(motionEvent);
                    if (this.j6.getKeyStrokeDetector() != null && this.j6.getKeyStrokeDetector().DW()) {
                        z = true;
                    }
                    if (this.rN < this.QX) {
                        if (action == 1) {
                            this.j6.j6(Hw(this.rN, this.er));
                        }
                    } else if (this.j6.j6 || r0) {
                        r1 = Hw(this.rN, this.er);
                        r2 = this.j6.DW(r1, v5(this.rN, this.er));
                        if (action == 0) {
                            KD();
                            this.U2 = -1;
                            this.Mr = -1;
                            if (r2 != -1) {
                                this.Mr = r2;
                                this.U2 = r1;
                                getCodeEditTextEditorModel().j6(r1 - 1, r2 - 1, this.j6.j6(r1, r2) - 2);
                            }
                        } else if (action == 2) {
                            if (!(this.Mr == -1 || (r2 == this.Mr && r1 == this.U2))) {
                                this.U2 = -1;
                                this.Mr = -1;
                                getCodeEditTextEditorModel().tp();
                            }
                        } else if (action == 3) {
                            SI();
                            if (this.Mr != -1) {
                                this.U2 = -1;
                                this.Mr = -1;
                                getCodeEditTextEditorModel().tp();
                            }
                        } else if (action == 1) {
                            SI();
                            if (this.Mr != -1) {
                                if (!this.lg && r2 == this.Mr && r1 == this.U2) {
                                    playSoundEffect(0);
                                    performHapticFeedback(1, 1);
                                    this.j6.j6(r1, r2, r1, this.j6.j6(r1, r2), this.j6.DW);
                                }
                                this.U2 = -1;
                                this.Mr = -1;
                                getCodeEditTextEditorModel().tp();
                            }
                        }
                    } else if (j6) {
                        if (action == 0) {
                            this.P8 = true;
                            this.gW = System.currentTimeMillis();
                            this.BT = this.rN;
                            this.vy = this.er;
                            r1 = Hw(this.rN, this.er);
                            r2 = v5(this.rN, this.er);
                            if (r1 >= 0) {
                                this.j6.j6(r1, r2, r1, r2, this.j6.Hw);
                            }
                        } else if (action == 2) {
                            if (this.P8) {
                                r1 = Hw(this.rN, this.er);
                                r2 = v5(this.rN, this.er);
                                action = Hw(this.BT, this.vy);
                                int v5 = v5(this.BT, this.vy);
                                if (action >= 0 && r1 >= 0 && !(r1 == action && r2 == v5)) {
                                    this.j6.j6(r1, r2, action, v5, this.j6.Zo);
                                }
                            }
                        } else if (action == 3) {
                            this.P8 = false;
                        } else if (action == 1 && this.P8) {
                            this.P8 = false;
                            if (System.currentTimeMillis() - this.yS < 500) {
                                r1 = Hw(this.rN, this.er);
                                action = v5(this.rN, this.er);
                                this.j6.j6(r1, J0(r1, action), r1, we(r1, action), this.j6.v5);
                            }
                            this.yS = System.currentTimeMillis();
                        }
                    } else if (action == 0) {
                        KD();
                    } else if (action != 2) {
                        if (action == 3) {
                            SI();
                        } else if (action == 1) {
                            SI();
                            if (!this.lg) {
                                r1 = Hw(this.rN, this.er);
                                r2 = v5(this.rN, this.er);
                                if (r1 >= 0) {
                                    this.j6.getKeyStrokeDetector().j6();
                                    playSoundEffect(0);
                                    this.j6.j6(r1, r2, r1, r2, this.j6.VH);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                e.DW(th);
            }
            return true;
        }

        private a getCodeEditTextEditorModel() {
            return (a) getEditorModel();
        }

        private void SI() {
            if (this.a8 != null) {
                removeCallbacks(this.a8);
                this.a8 = null;
            }
        }

        private void KD() {
            this.lg = false;
            if (this.a8 == null) {
                this.a8 = new 2(this);
            }
            postDelayed(this.a8, (long) ViewConfiguration.getLongPressTimeout());
        }

        private int we(int i, int i2) {
            int j6 = this.j6.j6(i, i2);
            if (j6 > 0) {
                return j6;
            }
            return i2;
        }

        private int J0(int i, int i2) {
            int DW = this.j6.DW(i, i2);
            if (DW > 0) {
                return DW;
            }
            return i2;
        }

        private int Hw(float f, float f2) {
            return FH(f, f2) + 1;
        }

        private int v5(float f, float f2) {
            return DW(f, f2) + 1;
        }

        public void j6(int i, int i2, int i3, int i4) {
            boolean z = true;
            getEditorModel().lg();
            Zo(i2 - 1, i - 1);
            DW(i2 - 1, i - 1, true);
            u7(i4 - 1, i3 - 1);
            if (i == i3 && i2 == i4) {
                z = false;
            }
            setSelectionVisibility(z);
        }

        public Rect j6(int i, int i2, int i3) {
            float Hw = Hw(i - 1);
            float fontHeight = getFontHeight() + Hw;
            float gn = gn(i2 - 1, i - 1);
            float gn2 = gn(i3 - 1, i - 1);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i4 = iArr[0];
            int i5 = iArr[1];
            return new Rect((int) (gn + ((float) i4)), (int) (Hw + ((float) i5)), (int) (gn2 + ((float) i4)), (int) (fontHeight + ((float) i5)));
        }

        public void Hw() {
            if (!Zo()) {
                this.XL = getFontSize();
                this.aM = getFontHeight();
                this.j3 = getSpaceCharWidth();
            }
        }

        public float[] j6(float f) {
            if (Zo()) {
                return new float[]{1.0f, 1.0f};
            }
            float f2 = 7.0f / this.XL;
            float f3 = 28.0f / this.XL;
            if (f >= f2) {
                f2 = f;
            }
            if (f2 <= f3) {
                f3 = f2;
            }
            setFontSize(f3 * this.XL);
            return new float[]{getSpaceCharWidth() / this.j3, getFontHeight() / this.aM};
        }
    }

    public CodeEditText(Context context) {
        super(context);
        this.DW = new ArrayList();
        this.FH = new ArrayList();
        this.Hw = new ArrayList();
        this.v5 = new ArrayList();
        this.Zo = new ArrayList();
        this.VH = new ArrayList();
        this.gn = new ArrayList();
        j6();
    }

    public CodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DW = new ArrayList();
        this.FH = new ArrayList();
        this.Hw = new ArrayList();
        this.v5 = new ArrayList();
        this.Zo = new ArrayList();
        this.VH = new ArrayList();
        this.gn = new ArrayList();
        j6();
    }

    public CodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DW = new ArrayList();
        this.FH = new ArrayList();
        this.Hw = new ArrayList();
        this.v5 = new ArrayList();
        this.Zo = new ArrayList();
        this.VH = new ArrayList();
        this.gn = new ArrayList();
        j6();
    }

    private void j6() {
        removeAllViews();
        addView(new c(this, getContext()));
    }

    protected boolean v5() {
        return false;
    }

    protected boolean Zo() {
        return false;
    }

    protected int getQuickKeyBarHeight() {
        return 0;
    }

    protected float getSideBarPadding() {
        return 0.0f;
    }

    protected boolean we() {
        return false;
    }

    protected void FH(int i, int i2) {
    }

    protected c getOEditorView() {
        return (c) getChildAt(0);
    }

    public CodeEditTextScrollView getScrollView() {
        if (getParent() == null) {
            return null;
        }
        return (CodeEditTextScrollView) getParent().getParent().getParent();
    }

    public boolean j6(MotionEvent motionEvent) {
        return getScrollView().j6(motionEvent);
    }

    protected void Hw() {
    }

    protected int getTextPaddingRight() {
        return 0;
    }

    protected boolean FH() {
        return true;
    }

    public void a8() {
        getScrollView().gn();
    }

    public void lg() {
        getScrollView().DW();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        getChildAt(0).layout(0, 0, i3 - i, i4 - i2);
    }

    protected void onMeasure(int i, int i2) {
        View childAt = getChildAt(0);
        childAt.measure(i, i2);
        setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    public float getDefaultFontSize() {
        return 10.0f;
    }

    public void setIsLightTheme(boolean z) {
        this.u7 = z;
        getOEditorView().FH();
    }

    public boolean rN() {
        return this.u7;
    }

    public KeyStrokeDetector getKeyStrokeDetector() {
        return null;
    }

    public boolean j6(int i, KeyEvent keyEvent) {
        return getOEditorView().onKeyUp(i, keyEvent);
    }

    public boolean DW(int i, KeyEvent keyEvent) {
        return getOEditorView().onKeyDown(i, keyEvent);
    }

    public void j6(char c) {
        getOEditorView().j6(c);
    }

    protected boolean j6(com.aide.common.k kVar) {
        return false;
    }

    public List<qi> getCustomEditorCommands() {
        return null;
    }

    public List<qi> getBasicEditorCommands() {
        return this.gn;
    }

    public List<com.aide.common.k> j6(qi qiVar) {
        return null;
    }

    public void j6(int i) {
    }

    public void j6(int i, int i2, int i3, int i4) {
        getScrollView().j6(i, i2, i3, i4);
    }

    public void er() {
        getOEditorView().lg();
    }

    public void yS() {
        getOEditorView().a8();
    }

    public void gW() {
        getOEditorView().U2();
    }

    protected void aM() {
    }

    public void BT() {
        if (!getOEditorView().hasFocus()) {
            getOEditorView().requestFocus();
        }
    }

    public boolean u7(int i, int i2) {
        if (i < getSelectionStartLine()) {
            return false;
        }
        if (i > getSelectionEndLine()) {
            return false;
        }
        if (getSelectionStartLine() == getSelectionEndLine()) {
            if (i2 < getSelectionStartColumn() || i2 > getSelectionEndColumn()) {
                return false;
            }
            return true;
        } else if (i == getSelectionStartLine()) {
            if (i2 < getSelectionStartColumn()) {
                return false;
            }
            return true;
        } else if (i != getSelectionEndLine() || i2 <= getSelectionEndColumn()) {
            return true;
        } else {
            return false;
        }
    }

    public int getSelectionStartLine() {
        if (getOEditorView().QX()) {
            return getOEditorView().getSelectedRegion().j6() + 1;
        }
        return getOEditorView().getCaretLine() + 1;
    }

    public int getSelectionStartColumn() {
        if (getOEditorView().QX()) {
            return getOEditorView().getSelectedRegion().DW() + 1;
        }
        return getOEditorView().getCaretColumn() + 1;
    }

    public int getSelectionEndLine() {
        if (getOEditorView().QX()) {
            return getOEditorView().getSelectedRegion().FH() + 1;
        }
        return getSelectionStartLine();
    }

    public int getSelectionEndColumn() {
        if (getOEditorView().QX()) {
            return getOEditorView().getSelectedRegion().Hw() + 2;
        }
        return getSelectionStartColumn();
    }

    private void j6(int i, int i2, int i3, int i4, List<d> list) {
        for (d j6 : list) {
            j6.j6(i, i2, i3, i4);
        }
    }

    public String j6(int i, int i2, int i3) {
        return new String(getOEditorView().getEditorModel().DW(i2 - 1, i - 1, i3 - i2));
    }

    public int v5(int i) {
        return getOEditorView().getEditorModel().Hw(i - 1);
    }

    public char tp(int i, int i2) {
        if (i2 > getOEditorView().getEditorModel().Hw(i - 1)) {
            return '\uffff';
        }
        return getOEditorView().getEditorModel().j6(i2 - 1, i - 1);
    }

    public void j6(int i, int i2, int i3, int i4, String str) {
        getOEditorView().getEditorModel().lg();
        getOEditorView().getCodeEditTextEditorModel().j6(i, i2, i3, i4, str);
    }

    public void vy() {
        getOEditorView().P8();
    }

    public int getLineCount() {
        return getOEditorView().getEditorModel().FH();
    }

    public void EQ(int i, int i2) {
        getScrollView().j6(i, i2);
    }

    public void P8() {
        getKeyStrokeDetector().j6();
        getOEditorView().gW();
    }

    public boolean ei() {
        return getOEditorView().BT();
    }

    public void nw() {
        getKeyStrokeDetector().j6();
        getOEditorView().er();
    }

    public boolean SI() {
        return getOEditorView().yS();
    }

    public void KD() {
        getOEditorView().j3();
    }

    public Rect DW(int i, int i2, int i3) {
        return getOEditorView().j6(i, i2, i3);
    }

    public void setIdentifierClickingEnabled(boolean z) {
        this.j6 = z;
    }

    protected int j6(int i, int i2) {
        if (!Character.isJavaIdentifierPart(tp(i, i2))) {
            return -1;
        }
        while (Character.isJavaIdentifierPart(tp(i, i2))) {
            i2++;
        }
        return i2;
    }

    protected int DW(int i, int i2) {
        if (!Character.isJavaIdentifierPart(tp(i, i2))) {
            return -1;
        }
        while (i2 >= 1 && Character.isJavaIdentifierPart(tp(i, i2))) {
            i2--;
        }
        return i2 + 1;
    }

    public void j6(d dVar) {
        this.FH.add(dVar);
    }

    public void DW(d dVar) {
        this.Zo.add(dVar);
    }

    public void FH(d dVar) {
        this.v5.add(dVar);
    }

    public void Hw(d dVar) {
        this.Hw.add(dVar);
    }

    public void v5(d dVar) {
        this.DW.add(dVar);
    }

    public void Zo(d dVar) {
        this.VH.add(dVar);
    }

    public int getTabSize() {
        return getOEditorView().getTabSize();
    }

    public boolean ro() {
        return getOEditorView().J8();
    }

    public com.aide.common.KeyStrokeDetector.a getKeyStrokeHandler() {
        return getOEditorView().getKeyStrokeHandler();
    }
}
