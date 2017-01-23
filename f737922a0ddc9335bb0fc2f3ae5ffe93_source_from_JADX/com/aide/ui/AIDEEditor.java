package com.aide.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.PorterDuff.Mode;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import bh;
import bj;
import com.aide.common.KeyStrokeDetector;
import com.aide.common.m;
import com.aide.common.s;
import com.aide.common.w;
import com.aide.engine.SyntaxError;
import com.aide.engine.aa;
import com.aide.engine.service.l;
import com.aide.ui.views.CodeEditText;
import com.aide.ui.views.CodeEditText.d;
import com.aide.ui.views.CodeEditTextScrollView;
import com.aide.ui.views.editor.OConsole;
import com.aide.ui.views.editor.d.e;
import com.aide.ui.views.editor.d.f;
import com.aide.ui.views.editor.i;
import com.aide.ui.views.editor.j;
import com.aide.ui.views.editor.k;
import com.aide.ui.views.editor.o;
import com.aide.ui.views.editor.z;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import pc$a;
import pl$a;
import pv;
import pw;
import px;
import qg;
import qh;
import qi;
import qo;
import qq;
import qr;
import qt;

public class AIDEEditor extends CodeEditText implements pc$a {
    private String DW;
    private boolean EQ;
    private String FH;
    private String Hw;
    private int VH;
    private String Zo;
    private boolean gn;
    private a j6;
    private AnimatorSet tp;
    private boolean u7;
    private String v5;

    class 10 implements Runnable {
        final /* synthetic */ AIDEEditor j6;

        10(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void run() {
            this.j6.getScrollView().VH();
            this.j6.gn();
        }
    }

    class 11 implements d {
        final /* synthetic */ AIDEEditor j6;

        11(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.FH(i, i2, i4);
        }
    }

    class 12 implements d {
        final /* synthetic */ AIDEEditor j6;

        12(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.j6(i, i2, i3, i4);
            this.j6.getEditorPager().gn();
            this.j6.BT();
        }
    }

    class 13 implements d {
        final /* synthetic */ AIDEEditor j6;

        13(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.j6(i, i2, i3, i4);
            this.j6.Ws();
        }
    }

    class 14 implements d {
        final /* synthetic */ AIDEEditor j6;

        14(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.j6(i, i2, i3, i4);
            this.j6.Ws();
        }
    }

    class 15 implements d {
        final /* synthetic */ AIDEEditor j6;

        15(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.we(i, i2);
        }
    }

    class 16 implements i {
        final /* synthetic */ AIDEEditor j6;

        16(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(OConsole oConsole, int i, int i2, boolean z) {
            this.j6.j6.j6(this.j6.getOEditorView().getCaretLine() + 1, this.j6.getOEditorView().getCaretColumn() + 1);
        }
    }

    class 17 implements i {
        final /* synthetic */ AIDEEditor j6;

        17(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(OConsole oConsole, int i, int i2, boolean z) {
            e.rN().j6(new qg(this.j6.getFilePath(), this.j6.getOEditorView().getCaretLine() + 1, this.j6.getOEditorView().getCaretColumn() + 1, this.j6.getOEditorView().getCaretLine() + 1, this.j6.getOEditorView().getCaretColumn() + 1));
        }
    }

    class 18 implements i {
        final /* synthetic */ AIDEEditor j6;

        18(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(OConsole oConsole, int i, int i2, boolean z) {
            this.j6.getEditorPager().VH();
        }
    }

    class 1 implements d {
        final /* synthetic */ AIDEEditor j6;

        1(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(int i, int i2, int i3, int i4) {
            com.aide.analytics.a.DW("Navigate mode: Identifier click");
            e.yS().j6(this.j6.getFilePath(), i, i2, i, i4, new String(this.j6.getEditorModel().DW(i2 - 1, i - 1, i4 - i2)));
        }
    }

    class 2 implements o {
        final /* synthetic */ AIDEEditor j6;

        2(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void j6(OConsole oConsole) {
            this.j6.getEditorPager().VH();
        }

        public void j6(OConsole oConsole, boolean z) {
            this.j6.getEditorPager().VH();
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ AIDEEditor j6;

        3(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void run() {
            this.j6.getScrollView().FH();
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ AIDEEditor j6;

        4(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void run() {
            this.j6.getScrollView().FH();
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ AIDEEditor j6;

        5(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void run() {
            this.j6.getScrollView().Hw();
        }
    }

    class 6 implements OnClickListener {
        final /* synthetic */ AIDEEditor j6;

        6(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void onClick(View view) {
            this.j6.sG();
            e.QX().J0();
        }
    }

    class 7 implements OnFocusChangeListener {
        final /* synthetic */ AIDEEditor DW;
        final /* synthetic */ TextView j6;

        7(AIDEEditor aIDEEditor, TextView textView) {
            this.DW = aIDEEditor;
            this.j6 = textView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                Animation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.0f, 1, 0.5f);
                scaleAnimation.setDuration((long) 400);
                scaleAnimation.setFillAfter(true);
                this.j6.startAnimation(scaleAnimation);
                return;
            }
            Animation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.0f, 1, 0.5f);
            scaleAnimation2.setDuration((long) 400);
            scaleAnimation2.setFillAfter(true);
            this.j6.startAnimation(scaleAnimation2);
        }
    }

    class 8 implements OnClickListener {
        final /* synthetic */ AIDEEditor j6;

        8(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void onClick(View view) {
            e.u7().FH();
        }
    }

    class 9 extends AnimatorListenerAdapter {
        final /* synthetic */ AIDEEditor j6;

        9(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.j6.EQ) {
                this.j6.tp.start();
            }
        }
    }

    private class a extends b implements pl$a {
        private bh EQ;
        private int Hw;
        private qq<SyntaxError> VH;
        private int Zo;
        private qq<Integer> gn;
        final /* synthetic */ AIDEEditor j6;
        private long tp;
        private qq<Boolean> u7;
        private int v5;
        private String we;

        class 1 implements k {
            final /* synthetic */ a j6;

            1(a aVar) {
                this.j6 = aVar;
            }

            public void j6(j jVar, int i, int i2, int i3, int i4) {
                this.j6.j6.getScrollView().VH();
                this.j6.j6.getActivity().QX();
            }

            public void DW(j jVar, int i, int i2, int i3, int i4) {
                this.j6.j6.getScrollView().VH();
                this.j6.j6.getActivity().QX();
            }

            public void j6(j jVar) {
            }

            public void j6(j jVar, int i, int i2, int i3, char[] cArr) {
                this.j6.j6.getScrollView().VH();
                this.j6.j6.getActivity().QX();
            }
        }

        class 2 implements com.aide.ui.views.editor.d.d {
            final /* synthetic */ a j6;

            2(a aVar) {
                this.j6 = aVar;
            }

            public void j6(com.aide.ui.views.editor.d dVar, boolean z) {
                this.j6.j6.getActivity().u7();
                this.j6.j6.getActivity().DW();
            }
        }

        class 3 implements f {
            final /* synthetic */ a j6;

            3(a aVar) {
                this.j6 = aVar;
            }

            public void j6() {
            }

            public void DW() {
            }

            public void j6(com.aide.ui.views.editor.d dVar, boolean z) {
                this.j6.j6.getActivity().u7();
            }

            public void DW(com.aide.ui.views.editor.d dVar, boolean z) {
                this.j6.j6.getActivity().u7();
            }

            public void j6(List<z.j> list) {
            }

            public void FH() {
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ int j6;

            4(a aVar, int i) {
                this.DW = aVar;
                this.j6 = i;
            }

            public void run() {
                if (e.Mr().j6(e.u7())) {
                    e.a8().DW("debug-aide");
                    this.DW.QX(this.j6);
                }
            }
        }

        class 5 implements Runnable {
            final /* synthetic */ a j6;

            5(a aVar) {
                this.j6 = aVar;
            }

            public void run() {
                this.j6.J0(0, this.j6.FH());
            }
        }

        private class a implements k {
            final /* synthetic */ a j6;

            private a(a aVar) {
                this.j6 = aVar;
            }

            public void DW(j jVar, int i, int i2, int i3, int i4) {
                if (this.j6.VH != null) {
                    this.j6.VH.DW(i2, i, i4, i3);
                }
                if (this.j6.gn != null) {
                    this.j6.gn.DW(i2, i, i4, i3);
                }
                if (this.j6.u7 != null) {
                    this.j6.u7.DW(i2, i, i4, i3);
                    this.j6.SI();
                }
                j6();
                e.XL().VH();
            }

            private void j6() {
                if (e.Sf().we() && this.j6.we != null) {
                    if (this.j6.we.endsWith(".java") || this.j6.we.endsWith(".xml")) {
                        e.Sf().FH();
                    }
                }
            }

            public void j6(j jVar, int i, int i2, int i3, int i4) {
                if (this.j6.VH != null) {
                    this.j6.VH.FH(i2, i, i4, i3);
                }
                if (this.j6.gn != null) {
                    this.j6.gn.FH(i2, i, i4, i3);
                }
                if (this.j6.u7 != null) {
                    this.j6.u7.FH(i2, i, i4, i3);
                    this.j6.SI();
                }
                j6();
                e.XL().VH();
            }

            public void j6(j jVar, int i, int i2, int i3, char[] cArr) {
                j6();
                e.XL().VH();
            }

            public void j6(j jVar) {
            }
        }

        public a(AIDEEditor aIDEEditor, String str) {
            this.j6 = aIDEEditor;
            super(aIDEEditor, qh.FH(str), aIDEEditor.getTabSize());
            this.Hw = -1;
            this.tp = qh.U2(str);
            DW(str);
            ei();
        }

        public a(AIDEEditor aIDEEditor) {
            this.j6 = aIDEEditor;
            super(aIDEEditor);
            this.Hw = -1;
            DW(null);
        }

        private void DW(String str) {
            this.we = str;
            if (str != null) {
                this.EQ = l.j6(str, e.DW());
            }
            j6(new a());
            j6(new 1(this));
            j6(new 2(this));
            j6(new 3(this));
        }

        public String j6() {
            return this.we;
        }

        public void j6(String str) {
            this.we = str;
            this.j6.EQ();
        }

        public boolean DW() {
            return !qh.j6(this.tp, qh.U2(j6()));
        }

        public void j6(String str, String... strArr) {
            try {
                String replace = str.replace("\r\n", "\n").replace("$space$", "");
                String str2 = replace;
                for (CharSequence charSequence : strArr) {
                    if (str2.contains(charSequence)) {
                        str2 = str2.replace(charSequence, "");
                    }
                }
                String str3 = replace + "\n";
                j6(new StringReader(str2 + "\n"), (Object) this);
                DW(str3, strArr);
                d_();
            } catch (IOException e) {
            }
            this.tp = qh.U2(j6());
            this.j6.getOEditorView().Zo(0, 0);
        }

        public void c_() {
            int caretLine = this.j6.getOEditorView().getCaretLine();
            int caretColumn = this.j6.getOEditorView().getCaretColumn();
            qq qqVar = this.gn;
            try {
                this.gn = null;
                j6(qh.FH(j6()), (Object) this);
            } catch (IOException e) {
            } finally {
                this.gn = qqVar;
            }
            this.tp = qh.U2(j6());
            this.j6.getOEditorView().Zo(caretColumn, caretLine);
            this.j6.sh();
        }

        public void j6(int i, int i2, int i3, int i4, String str, boolean z, boolean z2) {
            int i5;
            int i6 = 0;
            this.j6.getKeyStrokeDetector().j6();
            if (z || !z2) {
                i5 = 0;
            } else {
                i5 = this.j6.getOEditorView().getCaretLine();
                i6 = this.j6.getOEditorView().getCaretColumn();
            }
            j6(i, i2, i3, i4, str);
            if (!z && z2) {
                this.j6.getOEditorView().Zo(i6, i5);
            }
        }

        public boolean j6(int i) {
            return e.Sf().j6(this.we, i + 1);
        }

        public boolean DW(int i) {
            return this.u7 != null && this.u7.j6(i);
        }

        public List<String> Hw() {
            List<String> arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(Ws());
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (IOException e) {
                }
            }
            return arrayList;
        }

        public void a_(int i, int i2) {
            j6(i, i2, false);
        }

        public void b_(int i, int i2) {
            j6(i, i2, true);
        }

        public void j6(int i, int i2, boolean z) {
            int i3 = 0;
            this.j6.getKeyStrokeDetector().j6();
            if (z && Ws(i) && this.j6.getOEditorView().getCaretLine() + 1 != i) {
                i2 = 0;
            }
            if (FH(i) != i2 && i2 >= 0) {
                StringBuilder stringBuilder;
                int tabSize;
                int tabSize2;
                int i4 = i - 1;
                int i5 = 0;
                while (i5 < Hw(i4)) {
                    switch (j6(i5, i4)) {
                        case '\t':
                        case ' ':
                            i5++;
                        default:
                            break;
                    }
                    j6(0, i4, i5, (Object) this);
                    stringBuilder = new StringBuilder();
                    if (this.j6.ro()) {
                        tabSize = i2 / this.j6.getTabSize();
                        tabSize2 = i2 % this.j6.getTabSize();
                        for (i5 = 0; i5 < tabSize; i5++) {
                            stringBuilder.append('\t');
                        }
                        while (i3 < tabSize2) {
                            stringBuilder.append(' ');
                            i3++;
                        }
                    } else {
                        while (i3 < i2) {
                            stringBuilder.append(' ');
                            i3++;
                        }
                    }
                    j6(0, i4, new StringReader(stringBuilder.toString()), (Object) this);
                }
                j6(0, i4, i5, (Object) this);
                stringBuilder = new StringBuilder();
                if (this.j6.ro()) {
                    tabSize = i2 / this.j6.getTabSize();
                    tabSize2 = i2 % this.j6.getTabSize();
                    for (i5 = 0; i5 < tabSize; i5++) {
                        stringBuilder.append('\t');
                    }
                    while (i3 < tabSize2) {
                        stringBuilder.append(' ');
                        i3++;
                    }
                } else {
                    while (i3 < i2) {
                        stringBuilder.append(' ');
                        i3++;
                    }
                }
                try {
                    j6(0, i4, new StringReader(stringBuilder.toString()), (Object) this);
                } catch (IOException e) {
                }
            }
        }

        private boolean Ws(int i) {
            int i2 = i - 1;
            if (i2 < 0) {
                return false;
            }
            int i3 = 0;
            while (i3 < Hw(i2)) {
                switch (j6(i3, i2)) {
                    case '\t':
                    case ' ':
                        i3++;
                    default:
                        return false;
                }
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int FH(int r5) {
            /*
            r4 = this;
            r0 = 0;
            r2 = r5 + -1;
            if (r2 >= 0) goto L_0x0006;
        L_0x0005:
            return r0;
        L_0x0006:
            r1 = r0;
        L_0x0007:
            r3 = r4.Hw(r2);
            if (r1 >= r3) goto L_0x0005;
        L_0x000d:
            r3 = r4.j6(r1, r2);
            switch(r3) {
                case 9: goto L_0x0015;
                case 32: goto L_0x0021;
                default: goto L_0x0014;
            };
        L_0x0014:
            goto L_0x0005;
        L_0x0015:
            r3 = r4.j6;
            r3 = r3.getTabSize();
            r0 = r0 + r3;
            r0 = r0 / r3;
            r0 = r0 * r3;
        L_0x001e:
            r1 = r1 + 1;
            goto L_0x0007;
        L_0x0021:
            r0 = r0 + 1;
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.AIDEEditor.a.FH(int):int");
        }

        public void j6(int i, int i2, int i3, int i4, int i5, int i6) {
            String Hw = Hw(i, i2, i3, i4);
            j6(i, i2, i3, i4, "");
            j6(i5, i6, i5, i6, Hw);
        }

        public void DW(int i, int i2, int i3, int i4, int i5, int i6) {
            j6(i5, i6, i5, i6, Hw(i, i2, i3, i4));
        }

        private String Hw(int i, int i2, int i3, int i4) {
            String str = "";
            Reader DW = DW(new qt(i - 1, i2 - 1, i3 - 1, i4 - 2));
            Writer stringWriter = new StringWriter();
            try {
                w.j6(DW, stringWriter);
                str = stringWriter.toString();
            } catch (IOException e) {
            }
            return str;
        }

        public void d_() {
            try {
                qh.j6(j6(), Ws());
                this.tp = qh.U2(j6());
                gW();
                nw();
                e.nw().Hw(j6());
            } catch (IOException e) {
                Toast.makeText(e.gn(), j6() + " could not be saved!", 1).show();
            }
        }

        private void ei() {
            this.gn = (qq) s.j6(e.gn().getSharedPreferences("TarinerHintMaps", 0).getString(j6(), null), null);
        }

        private void nw() {
            Editor edit = e.gn().getSharedPreferences("TarinerHintMaps", 0).edit();
            edit.putString(j6(), s.j6(this.gn));
            edit.commit();
        }

        public long Zo() {
            return rN();
        }

        public void j6(aa aaVar) {
            e j6 = j6(aaVar.j6);
            aaVar.FH = j6.FH;
            aaVar.j6 = j6.j6;
            aaVar.DW = j6.DW;
        }

        public boolean VH() {
            return vy();
        }

        public boolean gn() {
            return yS();
        }

        public void j6(int i, boolean z) {
            if (this.gn != null) {
                try {
                    qr j6 = this.gn.j6();
                    while (!this.gn.DW(Integer.valueOf(i), j6.j6(), j6.DW())) {
                        j6 = this.gn.j6(j6);
                    }
                    int j62 = j6.j6() + 1;
                    int DW = j6.DW() + 1;
                    CodeEditTextScrollView scrollView = this.j6.getScrollView();
                    boolean z2 = j62 >= 20 && com.aide.common.d.Hw(this.j6.getContext());
                    scrollView.j6(j62, DW, z, z2);
                } catch (qo e) {
                }
            }
        }

        private void DW(String str, String... strArr) {
            this.gn = new qq();
            String[] split = str.split("\n");
            for (int i = 0; i < split.length; i++) {
                String str2 = split[i];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    Object obj = strArr[i2];
                    if (str2.contains(obj)) {
                        int i3 = 0;
                        String str3 = str2;
                        while (i3 < strArr.length) {
                            if (i2 != i3 && str3.contains(strArr[i3])) {
                                str3 = str3.replace(strArr[i3], "");
                            }
                            i3++;
                        }
                        i3 = str3.indexOf(obj);
                        if (i3 >= 0) {
                            this.gn.j6(Integer.valueOf(i2), (i + 1) - 1, (i3 + 1) - 1);
                        }
                    }
                }
            }
        }

        public void FH(int i, int i2) {
            e.gW().j6(e.XL().j6(j6(), i + 1, i2 + 1, this.j6.getTabSize()));
        }

        public void j6(char c, int i, int i2) {
            this.j6.j6.j6(c, i + 1, i2 + 1);
        }

        public void DW(char c, int i, int i2) {
            Object obj = 1;
            String j6 = j6();
            String toLowerCase = j6.toLowerCase();
            if (toLowerCase.endsWith(".java") || toLowerCase.endsWith(".js") || toLowerCase.endsWith(".c") || toLowerCase.endsWith(".cpp") || toLowerCase.endsWith(".h") || toLowerCase.endsWith(".cc") || toLowerCase.endsWith(".hh") || toLowerCase.endsWith(".hpp") || toLowerCase.endsWith(".gradle")) {
                if (pw.j6(this.j6, c, i + 1, i2 + 1)) {
                    obj = null;
                }
            } else if (toLowerCase.endsWith(".xml") || toLowerCase.endsWith(".html") || toLowerCase.endsWith(".htm")) {
                if (px.j6(this.j6, c, i + 1, i2 + 1)) {
                    obj = null;
                }
            } else if (!toLowerCase.endsWith(".css")) {
                obj = null;
            } else if (pv.j6(this.j6, c, i + 1, i2 + 1)) {
                obj = null;
            }
            if (obj != null && this.EQ != null) {
                for (bj j62 : this.EQ.Zo()) {
                    if (j62.j6(c)) {
                        List j63 = e.XL().j6(j6, i + 1, i2 + 1, c, this.j6.getTabSize());
                        if (j63 != null && j63.size() > 0) {
                            e.gW().j6(j63);
                            return;
                        }
                        return;
                    }
                }
            }
        }

        public boolean Hw(int i, int i2) {
            boolean z;
            String j6 = j6();
            String toLowerCase = j6.toLowerCase();
            if (toLowerCase.endsWith(".java") || toLowerCase.endsWith(".js") || toLowerCase.endsWith(".c") || toLowerCase.endsWith(".cpp") || toLowerCase.endsWith(".h") || toLowerCase.endsWith(".cc") || toLowerCase.endsWith(".hh") || toLowerCase.endsWith(".hpp") || toLowerCase.endsWith(".gradle")) {
                z = !pw.j6(this.j6, i + 1, i2 + 1, this.j6.getIndentationSize());
                if (!z) {
                    return true;
                }
            } else if (toLowerCase.endsWith(".xml") || toLowerCase.endsWith(".html") || toLowerCase.endsWith(".htm")) {
                z = !px.j6(this.j6, i + 1, i2 + 1, this.j6.getIndentationSize());
                if (!z) {
                    return true;
                }
            } else if (toLowerCase.endsWith(".css")) {
                if (pv.j6(this.j6, i + 1, i2 + 1, this.j6.getIndentationSize())) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return true;
                }
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            List DW = e.XL().DW(j6, i + 1, i2 + 1, this.j6.getTabSize());
            if (DW == null || DW.size() <= 0) {
                return false;
            }
            e.gW().j6(DW);
            return true;
        }

        public void v5(int i, int i2) {
            List FH = e.XL().FH(j6(), i + 1, i2 + 1, this.j6.getTabSize());
            if (FH != null && FH.size() > 0) {
                e.gW().j6(FH);
            }
        }

        public void u7() {
        }

        private void SI() {
            if (this.u7 != null) {
                List arrayList = new ArrayList();
                try {
                    qr j6 = this.u7.j6();
                    while (true) {
                        if (this.u7.DW(Boolean.valueOf(true), j6.j6(), j6.DW())) {
                            arrayList.add(Integer.valueOf(j6.j6() + 1));
                        }
                        j6 = this.u7.j6(j6);
                    }
                } catch (qo e) {
                    if (arrayList.size() == 0) {
                        this.u7 = null;
                    }
                    e.Sf().j6(this.we, arrayList);
                }
            }
        }

        public void a_(int i) {
            if (this.u7 != null && this.u7.j6(i - 1)) {
                this.u7.j6(i - 1, 0, i - 1, Integer.MAX_VALUE);
                SI();
                FH(0, i - 1, 0, i);
            } else if ("debug-aide".equals(e.a8().Hw())) {
                QX(i);
            } else {
                m.j6(e.u7(), this.j6.getResources().getString(R.f.dialog_set_breakpoint_title), this.j6.getResources().getString(R.f.dialog_set_breakpoint_message, new Object[]{"debug-aide"}), new 4(this, i));
            }
        }

        private void QX(int i) {
            if (this.u7 == null) {
                this.u7 = new qq();
            }
            this.u7.j6(Boolean.valueOf(true), i - 1, 0);
            SI();
            FH(0, i - 1, 0, i);
        }

        public void j6(List<Integer> list) {
            if (list.size() > 0) {
                qq qqVar = new qq();
                for (Integer intValue : list) {
                    qqVar.j6(Boolean.valueOf(true), intValue.intValue() - 1, 0);
                }
                this.u7 = qqVar;
            } else if (this.u7 != null) {
                this.u7 = new qq();
            }
        }

        public void DW(List<SyntaxError> list) {
            qq qqVar = new qq();
            for (int size = list.size() - 1; size >= 0; size--) {
                qqVar.j6(list.get(size), ((SyntaxError) list.get(size)).FH - 1, ((SyntaxError) list.get(size)).Hw - 1, ((SyntaxError) list.get(size)).v5 - 1, ((SyntaxError) list.get(size)).Zo - 2);
            }
            this.VH = qqVar;
            this.j6.post(new 5(this));
        }

        public boolean Zo(int i, int i2) {
            qq qqVar = this.VH;
            if (qqVar == null) {
                return false;
            }
            if (!qqVar.FH(i2, i)) {
                return false;
            }
            Enumeration DW = qqVar.DW(i2, i);
            while (DW.hasMoreElements()) {
                if (((SyntaxError) DW.nextElement()).DW()) {
                    return true;
                }
            }
            return false;
        }

        public boolean VH(int i, int i2) {
            qq qqVar = this.VH;
            if (qqVar == null) {
                return false;
            }
            if (!qqVar.FH(i2, i)) {
                return false;
            }
            Enumeration DW = qqVar.DW(i2, i);
            while (DW.hasMoreElements()) {
                if (((SyntaxError) DW.nextElement()).FH()) {
                    return true;
                }
            }
            return false;
        }

        public int gn(int i, int i2) {
            SyntaxError u7 = u7(i, i2);
            if (u7 != null) {
                return u7.DW;
            }
            return 0;
        }

        public SyntaxError u7(int i, int i2) {
            qq qqVar = this.VH;
            if (qqVar == null) {
                return null;
            }
            if (!qqVar.FH(i2, i)) {
                return null;
            }
            Enumeration DW = qqVar.DW(i2, i);
            while (DW.hasMoreElements()) {
                SyntaxError syntaxError = (SyntaxError) DW.nextElement();
                if (syntaxError.FH()) {
                    return syntaxError;
                }
            }
            return null;
        }

        public boolean tp(int i, int i2) {
            qq qqVar = this.VH;
            if (qqVar == null) {
                return false;
            }
            if (!qqVar.FH(i2, i)) {
                return false;
            }
            Enumeration DW = qqVar.DW(i2, i);
            while (DW.hasMoreElements()) {
                if (((SyntaxError) DW.nextElement()).Zo()) {
                    return true;
                }
            }
            return false;
        }

        public boolean EQ(int i, int i2) {
            return i2 == this.Hw && i >= this.v5 && i <= this.Zo;
        }

        public void tp() {
            int i = this.Hw;
            this.Hw = -1;
            FH(this.v5, i, this.Zo, i);
        }

        public void j6(int i, int i2, int i3) {
            if (i != this.Hw || i2 != this.v5 || i3 != this.Zo) {
                int i4 = this.Hw;
                int i5 = this.v5;
                int i6 = this.Zo;
                this.v5 = i2;
                this.Zo = i3;
                this.Hw = i;
                if (i4 != -1) {
                    FH(i5, i4, i6, i4);
                }
                FH(this.v5, this.Hw, this.Zo, this.Hw);
            }
        }
    }

    public AIDEEditor(Context context) {
        super(context);
        this.j6 = new a(this);
        cn();
    }

    public AIDEEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new a(this);
        cn();
    }

    public AIDEEditor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j6 = new a(this);
        cn();
    }

    public String getQuickKeys() {
        int i = 0;
        String str = "";
        int indentationSize = getIndentationSize();
        if (indentationSize % getTabSize() == 0) {
            while (i < indentationSize / getTabSize()) {
                str = str + "\t";
                i++;
            }
        } else {
            while (i < indentationSize) {
                str = str + "s";
                i++;
            }
        }
        String toLowerCase = getFilePath().toLowerCase();
        if (toLowerCase.endsWith(".java") || toLowerCase.endsWith(".js")) {
            return str + " { } ( ) ; , . = \" | & ! [ ] < > + - / * ? : _";
        }
        if (toLowerCase.endsWith(".xml") || toLowerCase.endsWith(".html") || toLowerCase.endsWith(".htm")) {
            return str + " < > / = \" : @ + ( ) ; , . | & ! [ ] { } _ -";
        }
        if (toLowerCase.endsWith(".css")) {
            return str + " { } - : . ; # % ( ) \" ' @ > = [ ] / * !";
        }
        return str + " { } ( ) ; , . = \" | & ! [ ] < > + - / *";
    }

    protected int j6(int i, int i2) {
        String toLowerCase = getFilePath().toLowerCase();
        if (toLowerCase.endsWith(".htm") || toLowerCase.endsWith(".html") || toLowerCase.endsWith(".css")) {
            if ('-' == tp(i, i2) || Character.isJavaIdentifierPart(tp(i, i2))) {
                while (true) {
                    if ('-' != tp(i, i2) && !Character.isJavaIdentifierPart(tp(i, i2))) {
                        return i2;
                    }
                    i2++;
                }
            }
        } else if (Character.isJavaIdentifierPart(tp(i, i2))) {
            while (Character.isJavaIdentifierPart(tp(i, i2))) {
                i2++;
            }
            return i2;
        }
        return -1;
    }

    protected int DW(int i, int i2) {
        String toLowerCase = getFilePath().toLowerCase();
        if (toLowerCase.endsWith(".htm") || toLowerCase.endsWith(".html") || toLowerCase.endsWith(".css")) {
            if ('-' == tp(i, i2) || Character.isJavaIdentifierPart(tp(i, i2))) {
                while (i2 >= 1 && ('-' == tp(i, i2) || Character.isJavaIdentifierPart(tp(i, i2)))) {
                    i2--;
                }
                return i2 + 1;
            }
        } else if (Character.isJavaIdentifierPart(tp(i, i2))) {
            while (i2 >= 1 && Character.isJavaIdentifierPart(tp(i, i2))) {
                i2--;
            }
            return i2 + 1;
        }
        return -1;
    }

    private int getIndentationSize() {
        String toLowerCase = getFilePath().toLowerCase();
        if (toLowerCase.endsWith(".java")) {
            return h.ei();
        }
        if (toLowerCase.endsWith(".js")) {
            return h.vy();
        }
        if (toLowerCase.endsWith(".c") || toLowerCase.endsWith(".cpp") || toLowerCase.endsWith(".h") || toLowerCase.endsWith(".cc") || toLowerCase.endsWith(".hh") || toLowerCase.endsWith(".hpp")) {
            return h.P8();
        }
        if (toLowerCase.endsWith(".xml")) {
            return h.nw();
        }
        if (toLowerCase.endsWith(".html") || toLowerCase.endsWith(".htm")) {
            return h.KD();
        }
        if (toLowerCase.endsWith(".css")) {
            return h.SI();
        }
        return getTabSize();
    }

    public String getFilePath() {
        return getModel().j6();
    }

    private MainActivity getActivity() {
        return (MainActivity) getContext();
    }

    private void cn() {
        ef();
        e.aM().j6((pc$a) this);
        v5(new 1(this));
        j6(new 11(this));
        Hw(new 12(this));
        FH(new 13(this));
        DW(new 14(this));
        Zo(new 15(this));
        getOEditorView().j6(new 16(this));
        getOEditorView().j6(new 17(this));
        getOEditorView().j6(new 18(this));
        getOEditorView().j6(new 2(this));
        j6();
    }

    public void j6() {
        setIsLightTheme(h.cn());
        getOEditorView().setTabSize(h.J0());
        getOEditorView().setInsertTabsAsSpaces(h.J8());
        DW();
        if (this.j6 != null) {
            this.j6.j6();
        }
    }

    public float getDefaultFontSize() {
        if (e.VH()) {
            return (float) com.aide.common.d.tp(getContext());
        }
        return (float) h.Hw();
    }

    public void DW() {
        getOEditorView().setFontSize(getDefaultFontSize());
    }

    public AIDEEditorPager getEditorPager() {
        return e.u7().sh();
    }

    public void b_() {
        this.j6.DW();
        getScrollView().j6();
        getOEditorView().v5();
        e.aM().DW((pc$a) this);
    }

    private void sh() {
        getEditorModel().DW(e.aM().j6(getFilePath()));
    }

    private void cb() {
        getEditorModel().j6(e.Sf().DW(getFilePath()));
    }

    public void j6(int i) {
        DW(i);
    }

    public void DW(int i) {
        if (we()) {
            getEditorModel().a_(i);
        }
    }

    protected void Hw() {
        getEditorPager().gn();
    }

    public void j6(int i, int i2, int i3, int i4) {
        super.j6(i, i2, i3, i4);
        e.rN().j6(getCurrentFileSpan());
    }

    protected boolean v5() {
        if (!this.j6.Zo()) {
            return false;
        }
        this.j6.VH();
        return true;
    }

    protected boolean Zo() {
        return this.j6.FH();
    }

    protected int getQuickKeyBarHeight() {
        return getActivity().P8();
    }

    public void VH() {
        getScrollView().FH();
    }

    public void gn() {
        postDelayed(new 3(this), 100);
        postDelayed(new 4(this), 300);
    }

    private void FH(int i, int i2, int i3) {
        SyntaxError j6 = e.aM().j6(getFilePath(), i, i2, i, i3);
        if (j6 != null) {
            e.aM().j6(j6);
        }
        if (!(u7(i, i2) || u7(i, i3))) {
            j6(i, i2, i, i3);
        }
        if (isInTouchMode()) {
            a8();
            BT();
            Ws();
            return;
        }
        Ws();
        View findViewById = e.u7().getWindow().getDecorView().findViewById(getResources().getIdentifier("action_bar_container", "id", "android"));
        if (findViewById != null) {
            findViewById.requestFocus(17);
        }
    }

    private void we(int i, int i2) {
        if (!e.u7().tp()) {
            if (!(getOEditorView().QX() && u7(i, i2) && Sf() && !QX())) {
                j6(i, i2, i, i2);
                a8();
                getEditorPager().gn();
            }
            BT();
            if (getOEditorView().rN()) {
                j3();
            }
        }
    }

    protected int getTextPaddingRight() {
        return (int) (this.FH != null ? 100.0f * getResources().getDisplayMetrics().density : 0.0f);
    }

    public void j6(String str, String... strArr) {
        getEditorModel().j6(str, strArr);
    }

    protected void FH(int i, int i2) {
        we(i + 1, i2 + 1);
        e.QX().Zo();
    }

    public boolean u7() {
        return getScrollView().v5();
    }

    public void j6(String str, int i, boolean z, String str2, String str3, boolean z2, String str4, String str5, int i2, boolean z3) {
        getScrollView().VH();
        this.DW = str2;
        this.FH = str;
        this.u7 = z2;
        this.Hw = str3;
        this.Zo = str4;
        this.v5 = str5;
        this.VH = i;
        this.gn = z;
        EQ();
        DW();
        if (i2 >= 0) {
            getEditorModel().j6(i2, z3);
        }
        postDelayed(new 5(this), 10);
    }

    public void tp() {
        if (!e.u7().tp()) {
            BT();
        }
    }

    public pl$a j6(String str) {
        pl$a DW = e.j3().DW(str);
        if (DW == null) {
            DW = FH(str);
        }
        getOEditorView().setModel((a) DW);
        getOEditorView().setHidden(false);
        getOEditorView().setEditable(!qh.gn(str));
        if (!getOEditorView().rN()) {
            XL();
        }
        sh();
        cb();
        EQ();
        e.XL().VH();
        requestLayout();
        return DW;
    }

    public void EQ() {
        sG();
        View headerView = getScrollView().getHeaderView();
        if (this.FH != null) {
            headerView.setVisibility(0);
            headerView.findViewById(R.b.editorHeaderLearnHeader).setVisibility(0);
            headerView.findViewById(R.b.editorHeaderFileInfo).setVisibility(8);
            TextView textView = (TextView) headerView.findViewById(R.b.editorHeaderLearnTaskText);
            TextView textView2 = (TextView) headerView.findViewById(R.b.editorHeaderLearnTaskTitle);
            TextView textView3 = (TextView) headerView.findViewById(R.b.editorHeaderLearnButton);
            TextView textView4 = (TextView) headerView.findViewById(R.b.editorHeaderLearnErrorText);
            TextView textView5 = (TextView) headerView.findViewById(R.b.editorHeaderLearnErrorTitle);
            ProgressBar progressBar = (ProgressBar) headerView.findViewById(R.b.editorHeaderLearnProgress);
            LinearLayout linearLayout = (LinearLayout) headerView.findViewById(R.b.editorHeaderLearnNewLayout);
            linearLayout.setVisibility(this.gn ? 0 : 8);
            progressBar.setProgress(this.VH);
            progressBar.getProgressDrawable().setColorFilter(-1, Mode.SRC_IN);
            textView2.setText(this.FH);
            if (this.DW != null) {
                textView.setVisibility(0);
                textView3.setVisibility(0);
                textView.setText(Html.fromHtml(this.DW));
                textView3.setText(this.Hw);
            } else {
                textView.setVisibility(8);
                textView3.setVisibility(8);
            }
            if (this.v5 == null) {
                textView4.setVisibility(8);
                textView5.setVisibility(8);
            } else {
                textView4.setVisibility(0);
                textView5.setVisibility(0);
                textView5.setText(this.Zo);
                textView4.setText(Html.fromHtml(this.v5));
            }
            textView2.setTextSize(com.aide.common.d.J8(getContext()));
            textView.setTextSize(com.aide.common.d.EQ(getContext()));
            textView3.setTextSize(com.aide.common.d.we(getContext()));
            textView5.setTextSize(com.aide.common.d.J0(getContext()));
            textView4.setTextSize(com.aide.common.d.EQ(getContext()));
            View findViewById = headerView.findViewById(R.b.editorHeaderLearnTask);
            findViewById.setOnClickListener(new 6(this));
            findViewById.setOnFocusChangeListener(new 7(this, textView3));
            if (dx()) {
                float f = getResources().getDisplayMetrics().density;
                findViewById.setPadding((int) (48.0f * f), (int) (27.0f * f), (int) (f * 48.0f), 0);
            }
            textView4.getLayoutParams().width = com.aide.common.d.Zo(getContext());
            textView.getLayoutParams().width = com.aide.common.d.Zo(getContext());
            progressBar.getLayoutParams().width = com.aide.common.d.Zo(getContext());
            linearLayout.getLayoutParams().width = com.aide.common.d.Zo(getContext());
            headerView.requestLayout();
            if (this.u7) {
                j6(textView3);
                return;
            }
            return;
        }
        headerView.setVisibility(0);
        headerView.findViewById(R.b.editorHeaderLearnHeader).setVisibility(8);
        headerView.findViewById(R.b.editorHeaderFileInfo).setVisibility(0);
        ((TextView) headerView.findViewById(R.b.editorHeaderFileName)).setText(qh.Zo(getFilePath()));
        ((TextView) headerView.findViewById(R.b.editorHeaderDirectoryName)).setText(qh.v5(getFilePath()));
        ((ImageView) headerView.findViewById(R.b.editorHeaderFileIcon)).setImageResource(j.j6(getFilePath()));
        headerView.findViewById(R.b.editorHeaderFileInfoInner).setOnClickListener(new 8(this));
    }

    protected boolean we() {
        return (getFilePath() == null || !getFilePath().endsWith(".java") || e.VH()) ? false : true;
    }

    protected float getSideBarPadding() {
        if (dx()) {
            return getResources().getDisplayMetrics().density * 48.0f;
        }
        return 0.0f;
    }

    private boolean dx() {
        return com.aide.common.d.DW(getContext()) && e.VH();
    }

    private void sG() {
        this.EQ = false;
    }

    private void j6(TextView textView) {
        if (this.tp == null) {
            float f = getResources().getDisplayMetrics().density * 15.0f;
            Animator ofFloat = ObjectAnimator.ofFloat(textView, "translationX", new float[]{0.0f, f});
            ofFloat.setDuration((long) 300);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            Animator ofFloat2 = ObjectAnimator.ofFloat(textView, "translationX", new float[]{f, 0.0f});
            ofFloat2.setDuration((long) 300);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            this.tp = new AnimatorSet();
            this.tp.play(ofFloat).before(ofFloat2);
            this.tp.addListener(new 9(this));
        }
        this.EQ = true;
        if (!this.tp.isRunning()) {
            this.tp.start();
        }
    }

    public pl$a getModel() {
        return (pl$a) getOEditorView().getModel();
    }

    private pl$a FH(String str) {
        return new a(this, str);
    }

    private void ef() {
        getOEditorView().setModel(new a(this));
        getOEditorView().setHidden(true);
        getOEditorView().setEditable(false);
    }

    public List<qi> getCustomEditorCommands() {
        return f.j6();
    }

    public KeyStrokeDetector getKeyStrokeDetector() {
        return e.u7().cb();
    }

    public List<com.aide.common.k> j6(qi qiVar) {
        return e.BT().j6(qiVar);
    }

    public void J0() {
        FH(getSelectionStartLine(), getSelectionStartColumn(), getSelectionStartColumn());
    }

    public void J8() {
        getEditorPager().j6(DW(getSelectionStartLine(), getSelectionStartColumn(), getSelectionStartColumn()));
    }

    public void Ws() {
        getEditorPager().u7();
    }

    public boolean QX() {
        return getEditorPager().Ws();
    }

    public void XL() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getOEditorView().getWindowToken(), 0);
    }

    public void j6(boolean z) {
        this.j6.j6(z);
    }

    protected void aM() {
        getScrollView().Zo();
        int selectionStartLine = getSelectionStartLine();
        int selectionStartColumn = getSelectionStartColumn();
        SyntaxError j6 = e.aM().j6(getFilePath(), selectionStartLine, selectionStartColumn, selectionStartLine, selectionStartColumn);
        if (j6 != null && j6.DW() && j6.gn != null && j6.gn.length > 0) {
            e.aM().j6(j6);
            getScrollView().VH();
            getEditorPager().DW(DW(selectionStartLine, selectionStartColumn, selectionStartColumn));
        } else if (e.a8().rN()) {
            getScrollView().VH();
            getEditorPager().DW(DW(selectionStartLine, selectionStartColumn, selectionStartColumn));
        } else {
            j3();
        }
    }

    public void j3() {
        if (getOEditorView().rN() && Sf() && !QX()) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            inputMethodManager.restartInput(getOEditorView());
            inputMethodManager.showSoftInput(getOEditorView(), 2);
            if (getScrollView().v5()) {
                getScrollView().j6(getSelectionStartLine(), getSelectionStartColumn(), getDefaultFontSize(), new 10(this));
            } else {
                gn();
            }
        }
    }

    private boolean Sf() {
        if (getContext().getResources().getConfiguration().keyboard == 1 || h.gn()) {
            return true;
        }
        return false;
    }

    private a getEditorModel() {
        return (a) getOEditorView().getEditorModel();
    }

    public void DW(String str) {
        if (getFilePath() != null && getFilePath().equals(str)) {
            sh();
        }
    }

    public void Mr() {
    }

    public void U2() {
        this.j6.Hw();
    }

    public qg getCurrentFileSpan() {
        return new qg(getFilePath(), getSelectionStartLine(), getSelectionStartColumn(), getSelectionEndLine(), getSelectionEndColumn());
    }

    public boolean j6(int i, int i2, String str) {
        if (str.length() == 0) {
            return true;
        }
        a editorModel = getEditorModel();
        int i3 = i;
        while (i3 <= editorModel.FH()) {
            int j6 = j6(editorModel.gn(i3 - 1), i3 == i ? i2 - 1 : 0, editorModel.Hw(i3 - 1) - str.length(), str);
            if (j6 >= 0) {
                j6(i3, j6 + 1, i3, (j6 + 1) + str.length());
                return true;
            }
            i3++;
        }
        return false;
    }

    private int j6(char[] cArr, int i, int i2, String str) {
        int i3 = i;
        while (i3 <= i2) {
            int i4 = 0;
            while (i4 < str.length()) {
                if (Character.toUpperCase(str.charAt(i4)) != Character.toUpperCase(cArr[i3 + i4])) {
                    i3++;
                } else {
                    i4++;
                }
            }
            return i3;
        }
        return -1;
    }

    public String getSelectionContent() {
        try {
            Reader j6 = getEditorModel().j6(getOEditorView().getSelectedRegion());
            Writer stringWriter = new StringWriter();
            w.j6(j6, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public String FH(int i) {
        return new String(getEditorModel().gn(i - 1));
    }

    public void Hw(int i, int i2) {
        getOEditorView().Zo(i2 - 1, i - 1);
    }

    public SyntaxError v5(int i, int i2) {
        return getEditorModel().u7(i2 - 1, i - 1);
    }

    public void Zo(int i, int i2) {
        getEditorModel().j6(i - 1, i2 - 1, this);
    }

    public void j6(int i, int i2, char c) {
        getEditorModel().j6(i - 1, i2 - 1, c, (Object) this);
    }

    public void VH(int i, int i2) {
        getEditorModel().DW(i2 - 1, i - 1, (Object) this);
    }

    public int Hw(int i) {
        return getEditorModel().FH(i);
    }

    public void gn(int i, int i2) {
        getEditorModel().a_(i, i2);
    }
}
