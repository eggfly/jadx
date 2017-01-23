package com.aide.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.aide.common.KeyStrokeDetector;
import com.aide.common.k;
import com.aide.ui.views.CodeEditText;
import com.aide.ui.views.CodeEditText.d;
import com.aide.ui.views.editor.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import ok;
import pj$a;
import qf;
import qg;
import qi;

public class LogCatConsole extends CodeEditText {
    private g DW;
    private qf<pj$a> FH;
    private g j6;

    class 1 implements d {
        final /* synthetic */ LogCatConsole j6;

        1(LogCatConsole logCatConsole) {
            this.j6 = logCatConsole;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.j6(i, i2, i3, i4);
            this.j6.a8();
            this.j6.BT();
            this.j6.DW.j6(true);
        }
    }

    class 2 implements d {
        final /* synthetic */ LogCatConsole j6;

        2(LogCatConsole logCatConsole) {
            this.j6 = logCatConsole;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.j6(i, i2, i, i2);
            this.j6.lg();
            this.j6.BT();
            pj$a FH = this.j6.getLogCatModel().FH(i - 1);
            if (FH != null) {
                this.j6.DW(FH);
            }
        }
    }

    private class a extends com.aide.ui.views.editor.d {
        private qf<pj$a> DW;
        private qf<CharSequence> FH;
        private int Hw;
        private String VH;
        private String Zo;
        private String gn;
        final /* synthetic */ LogCatConsole j6;
        private String v5;

        private a(LogCatConsole logCatConsole) {
            this.j6 = logCatConsole;
            this.DW = new qf(200);
            this.FH = new qf(200);
        }

        public pj$a FH(int i) {
            pj$a pj_a;
            synchronized (this.DW) {
                if (i >= 0) {
                    if (i < this.DW.j6()) {
                        pj_a = (pj$a) this.DW.j6(i);
                    }
                }
                pj_a = null;
            }
            return pj_a;
        }

        public void j6(String str, qf<pj$a> qfVar) {
            this.gn = str;
            this.v5 = null;
            this.Zo = null;
            this.VH = null;
            DW((qf) qfVar);
        }

        public void DW(String str, qf<pj$a> qfVar) {
            this.gn = null;
            this.v5 = null;
            this.Zo = str;
            this.VH = null;
            DW((qf) qfVar);
        }

        public void FH(String str, qf<pj$a> qfVar) {
            this.gn = null;
            this.v5 = str;
            this.VH = null;
            this.Zo = null;
            DW((qf) qfVar);
        }

        public void Hw(String str, qf<pj$a> qfVar) {
            this.gn = null;
            this.v5 = null;
            this.VH = str;
            this.Zo = null;
            DW((qf) qfVar);
        }

        public void j6(qf<pj$a> qfVar) {
            this.gn = null;
            this.v5 = null;
            this.Zo = null;
            this.VH = null;
            DW((qf) qfVar);
        }

        public boolean j6() {
            return (this.v5 == null && this.Zo == null && this.VH == null) ? false : true;
        }

        public void DW() {
            DW(new qf(1));
        }

        private void DW(qf<pj$a> qfVar) {
            synchronized (this.DW) {
                int j6;
                ArrayList arrayList = new ArrayList();
                for (j6 = qfVar.j6() - 1; j6 >= 0 && arrayList.size() < this.DW.FH(); j6--) {
                    pj$a pj_a = (pj$a) qfVar.j6(j6);
                    if (j6(pj_a)) {
                        arrayList.add(pj_a);
                    }
                }
                this.DW.DW();
                this.FH.DW();
                this.Hw = 10;
                for (j6 = arrayList.size() - 1; j6 >= 0; j6--) {
                    Object obj = (pj$a) arrayList.get(j6);
                    this.DW.j6(obj);
                    obj = obj.j6();
                    this.FH.j6(obj);
                    this.Hw = Math.max(this.Hw, obj.length());
                }
                J0();
            }
        }

        public boolean j6(pj$a pj_a) {
            return (this.Zo == null || pj_a.Zo.equals(this.Zo)) && ((this.VH == null || pj_a.v5.equals(this.VH)) && ((this.v5 == null || pj_a.Hw.equals(this.v5)) && (this.gn == null || pj_a.j6(this.gn))));
        }

        public void DW(pj$a pj_a) {
            if (j6(pj_a)) {
                synchronized (this.DW) {
                    pj$a pj_a2 = (pj$a) this.DW.j6((Object) pj_a);
                    Object j6 = pj_a.j6();
                    this.FH.j6(j6);
                    this.Hw = Math.max(this.Hw, j6.length());
                    if (pj_a2 != null) {
                        this.j6.getOEditorView().J0();
                    }
                    J0();
                }
            }
        }

        public int FH() {
            int max;
            synchronized (this.DW) {
                max = Math.max(1, this.DW.j6());
            }
            return max;
        }

        public int e_() {
            int i;
            synchronized (this.DW) {
                i = this.Hw;
            }
            return i;
        }

        public int Hw(int i) {
            int length;
            synchronized (this.DW) {
                if (i >= 0) {
                    if (i < this.FH.j6()) {
                        length = ((CharSequence) this.FH.j6(i)).length();
                    }
                }
                length = Zo().length();
            }
            return length;
        }

        private String Zo() {
            if (this.j6.getLogCatModel().j6()) {
                return "<" + this.j6.getContext().getResources().getString(R.f.view_logcat_no_match) + ">";
            }
            return "<" + this.j6.getContext().getResources().getString(R.f.view_logcat_run_app) + ">";
        }

        public char j6(int i, int i2) {
            char c;
            synchronized (this.DW) {
                if (i2 >= 0) {
                    if (i2 < this.FH.j6()) {
                        CharSequence charSequence = (CharSequence) this.FH.j6(i2);
                        if (i >= charSequence.length()) {
                            c = ' ';
                        } else {
                            c = charSequence.charAt(i);
                        }
                    }
                }
                c = Zo().charAt(i);
            }
            return c;
        }

        public void j6(int i, char[] cArr) {
            synchronized (this.DW) {
                CharSequence charSequence;
                int min;
                int i2;
                if (i >= 0) {
                    if (i < this.FH.j6()) {
                        charSequence = (CharSequence) this.FH.j6(i);
                        min = Math.min(cArr.length, charSequence.length());
                        for (i2 = 0; i2 < min; i2++) {
                            cArr[i2] = charSequence.charAt(i2);
                        }
                    }
                }
                charSequence = Zo();
                min = Math.min(cArr.length, charSequence.length());
                for (i2 = 0; i2 < min; i2++) {
                    cArr[i2] = charSequence.charAt(i2);
                }
            }
        }

        public boolean v5(int i) {
            pj$a FH = FH(i - 1);
            pj$a FH2 = FH(i);
            return (FH == null || FH2 == null || FH.DW == FH2.DW) ? false : true;
        }

        public int DW(int i, int i2) {
            synchronized (this.DW) {
                if (i2 >= 0) {
                    if (i2 < this.DW.j6()) {
                        pj$a pj_a = (pj$a) this.DW.j6(i2);
                        if (pj_a.j6(i)) {
                            if (pj_a.FH()) {
                                return 5;
                            } else if (pj_a.DW()) {
                                return 7;
                            } else if (pj_a.Hw()) {
                                return 6;
                            } else {
                                return 4;
                            }
                        } else if (pj_a.FH()) {
                            return 1;
                        } else if (pj_a.DW()) {
                            return 3;
                        } else if (pj_a.Hw()) {
                            return 2;
                        } else {
                            return 0;
                        }
                    }
                }
                return 0;
            }
        }

        public int v5() {
            return 8;
        }

        public n Zo(int i) {
            int i2 = -16777216;
            if (i == 0) {
                if (!this.j6.rN()) {
                    i2 = -3355444;
                }
                return new n(i2, 0);
            } else if (i == 1) {
                return new n(-16738048, 0);
            } else {
                if (i == 2) {
                    return new n(-48128, 0);
                }
                if (i == 3) {
                    return new n(-65536, 0);
                }
                if (i == 4) {
                    if (!this.j6.rN()) {
                        i2 = -3355444;
                    }
                    return new n(i2, 1);
                } else if (i == 5) {
                    return new n(-16738048, 1);
                } else {
                    if (i == 6) {
                        return new n(-48128, 1);
                    }
                    return new n(-65536, 1);
                }
            }
        }
    }

    public LogCatConsole(Context context) {
        super(context);
        this.j6 = new g(e.u7(), R.d.logcatbrowser_menu);
        this.DW = new g(e.u7(), R.d.logcatbrowser_context_menu);
        this.FH = new qf(10000);
        u7();
    }

    public LogCatConsole(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new g(e.u7(), R.d.logcatbrowser_menu);
        this.DW = new g(e.u7(), R.d.logcatbrowser_context_menu);
        this.FH = new qf(10000);
        u7();
    }

    public LogCatConsole(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j6 = new g(e.u7(), R.d.logcatbrowser_menu);
        this.DW = new g(e.u7(), R.d.logcatbrowser_context_menu);
        this.FH = new qf(10000);
        u7();
    }

    public void j6() {
        setIsLightTheme(h.cn());
        getOEditorView().setTabSize(h.J0());
        getOEditorView().setInsertTabsAsSpaces(h.J8());
        getOEditorView().setFontSize((float) h.Hw());
    }

    private void u7() {
        getOEditorView().setModel(new a());
        getOEditorView().setHidden(false);
        getOEditorView().setEditable(false);
        j6(new 1(this));
        Zo(new 2(this));
        j6();
    }

    private void DW(pj$a pj_a) {
        if (e.a8().J0() && ok.P8(e.a8().u7()) && pj_a.VH.startsWith("at ")) {
            int indexOf = pj_a.VH.indexOf(40);
            if (indexOf > 0) {
                String substring = pj_a.VH.substring(3, indexOf);
                int lastIndexOf = substring.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    substring = substring.substring(0, lastIndexOf);
                    lastIndexOf = substring.indexOf(36);
                    if (lastIndexOf > 0) {
                        substring = substring.substring(0, lastIndexOf);
                    }
                    String er = e.a8().er(substring.replace('.', '/') + ".java");
                    if (er != null) {
                        int parseInt;
                        indexOf = pj_a.VH.lastIndexOf(58);
                        if (indexOf > 0) {
                            try {
                                parseInt = Integer.parseInt(pj_a.VH.substring(indexOf + 1, pj_a.VH.length() - 1));
                            } catch (Exception e) {
                                parseInt = 1;
                            }
                        } else {
                            parseInt = 1;
                        }
                        e.u7().j6(new qg(er, parseInt, 1, parseInt, 1));
                    }
                }
            }
        }
    }

    public void DW() {
        getScrollView().getHeaderView().setVisibility(0);
    }

    public void j6(View view, boolean z) {
        this.j6.j6(view, z);
    }

    public KeyStrokeDetector getKeyStrokeDetector() {
        return e.u7().cb();
    }

    public List<k> j6(qi qiVar) {
        return e.BT().j6(qiVar);
    }

    public List<qi> getCustomEditorCommands() {
        return f.v5();
    }

    protected boolean FH() {
        return false;
    }

    public List<String> getAllProcesses() {
        List<String> arrayList;
        synchronized (this.FH) {
            Collection hashSet = new HashSet();
            for (int i = 0; i < this.FH.j6(); i++) {
                pj$a pj_a = (pj$a) this.FH.j6(i);
                if (pj_a.Zo.length() > 0) {
                    hashSet.add(pj_a.Zo);
                }
            }
            arrayList = new ArrayList(hashSet);
            Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        }
        return arrayList;
    }

    public List<String> getAllPriortities() {
        return Arrays.asList(new String[]{"E", "W", "I", "D", "V"});
    }

    public List<String> getAllTags() {
        List<String> arrayList;
        synchronized (this.FH) {
            Collection hashSet = new HashSet();
            for (int i = 0; i < this.FH.j6(); i++) {
                pj$a pj_a = (pj$a) this.FH.j6(i);
                if (pj_a.v5.length() > 0) {
                    hashSet.add(pj_a.v5);
                }
            }
            arrayList = new ArrayList(hashSet);
            Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        }
        return arrayList;
    }

    public void j6(String str) {
        synchronized (this.FH) {
            getLogCatModel().j6(str, this.FH);
        }
        setHeader("LogCat - " + str);
    }

    public void DW(String str) {
        synchronized (this.FH) {
            getLogCatModel().DW(str, this.FH);
        }
        setHeader("LogCat - " + str);
    }

    public void FH(String str) {
        synchronized (this.FH) {
            getLogCatModel().FH(str, this.FH);
        }
        setHeader("LogCat - " + str);
    }

    public void Hw(String str) {
        synchronized (this.FH) {
            getLogCatModel().Hw(str, this.FH);
        }
        setHeader("LogCat - " + str);
    }

    public void VH() {
        synchronized (this.FH) {
            getLogCatModel().j6(this.FH);
        }
        setHeader("LogCat");
    }

    public void gn() {
        synchronized (this.FH) {
            this.FH.DW();
            getLogCatModel().DW();
        }
    }

    private void setHeader(String str) {
        ((TextView) getScrollView().getHeaderView().findViewById(R.b.logcatHeaderText)).setText(str);
    }

    public void j6(pj$a pj_a) {
        synchronized (this.FH) {
            this.FH.j6((Object) pj_a);
        }
        getLogCatModel().DW(pj_a);
    }

    private a getLogCatModel() {
        return (a) getOEditorView().getModel();
    }
}
