package com.aide.ui.scm;

import android.content.Context;
import android.util.AttributeSet;
import com.aide.common.KeyStrokeDetector;
import com.aide.common.e;
import com.aide.engine.FileHighlightings;
import com.aide.engine.f;
import com.aide.engine.h;
import com.aide.ui.views.CodeEditText;
import com.aide.ui.views.editor.n;
import com.aide.ui.views.editor.v;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qh;
import qt;

public class DiffView extends CodeEditText {
    private Object DW;
    private int FH;
    private int Hw;
    private a j6;
    private KeyStrokeDetector v5;

    class 1 implements com.aide.ui.views.editor.v.a {
        final /* synthetic */ StringBuilder DW;
        final /* synthetic */ DiffView FH;
        final /* synthetic */ ArrayList j6;

        1(DiffView diffView, ArrayList arrayList, StringBuilder stringBuilder) {
            this.FH = diffView;
            this.j6 = arrayList;
            this.DW = stringBuilder;
        }

        public boolean j6(int i, char[] cArr, int i2, int i3) {
            this.j6.add(new String(cArr, i2, i3));
            return true;
        }

        public void DW(int i, char[] cArr, int i2, int i3) {
            this.j6.add(new String(cArr, i2, i3));
        }

        public void j6(String str) {
            this.DW.append(str);
        }
    }

    public class a extends b {
        private List<c> Hw;
        private ArrayList<Integer> VH;
        private ArrayList<Integer> Zo;
        private h gn;
        final /* synthetic */ DiffView j6;
        private h u7;
        private ArrayList<Integer> v5;

        public /* bridge */ /* synthetic */ int DW(int i, int i2) {
            return super.DW(i, i2);
        }

        public /* bridge */ /* synthetic */ void DW(char c, int i, int i2) {
            super.DW(c, i, i2);
        }

        public /* bridge */ /* synthetic */ void DW(f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
            super.DW(fVarArr, iArr, iArr2, iArr3, iArr4, i);
        }

        public /* bridge */ /* synthetic */ void FH(int i, int i2) {
            super.FH(i, i2);
        }

        public /* bridge */ /* synthetic */ boolean Hw(int i, int i2) {
            return super.Hw(i, i2);
        }

        public /* bridge */ /* synthetic */ n Zo(int i) {
            return super.Zo(i);
        }

        public /* bridge */ /* synthetic */ void j6(int i, int i2, int i3, int i4, String str) {
            super.j6(i, i2, i3, i4, str);
        }

        public /* bridge */ /* synthetic */ void j6(f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
            super.j6(fVarArr, iArr, iArr2, iArr3, iArr4, i);
        }

        public /* bridge */ /* synthetic */ void tp() {
            super.tp();
        }

        public /* bridge */ /* synthetic */ int v5() {
            return super.v5();
        }

        public /* bridge */ /* synthetic */ void v5(int i, int i2) {
            super.v5(i, i2);
        }

        public a(DiffView diffView) {
            this.j6 = diffView;
            super(diffView);
            this.Hw = new ArrayList();
            aM();
        }

        public void j6(boolean z, f[] fVarArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
            if (z) {
                this.u7 = new h();
                this.u7.j6(fVarArr, iArr, iArr2, iArr3, iArr4, i);
            } else {
                this.gn = new h();
                this.gn.j6(fVarArr, iArr, iArr2, iArr3, iArr4, i);
            }
            if (this.u7 != null && this.gn != null) {
                int i2;
                int intValue;
                h we = we();
                we.j6();
                for (i2 = 0; i2 < this.Zo.size(); i2++) {
                    intValue = ((Integer) this.Zo.get(i2)).intValue();
                    if (intValue != -1) {
                        we.j6(i2, this.u7, intValue);
                    }
                }
                for (i2 = 0; i2 < this.VH.size(); i2++) {
                    intValue = ((Integer) this.VH.get(i2)).intValue();
                    if (intValue != -1) {
                        we.j6(i2, this.gn, intValue);
                    }
                }
                EQ();
            }
        }

        public void j6(List<String> list, List<String> list2, List<com.aide.ui.scm.a.a> list3) {
            this.gn = null;
            this.u7 = null;
            this.Hw = new ArrayList();
            this.v5 = new ArrayList();
            this.Zo = new ArrayList();
            this.VH = new ArrayList();
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            int i = 0;
            int i2 = -1;
            while (i < list3.size()) {
                com.aide.ui.scm.a.a aVar = (com.aide.ui.scm.a.a) list3.get(i);
                int DW = aVar.DW() - 3;
                while (DW < aVar.DW()) {
                    if (DW >= i2 && DW >= 0) {
                        printWriter.println((String) list2.get(DW));
                        this.Zo.add(Integer.valueOf(-1));
                        this.VH.add(Integer.valueOf(DW));
                        this.Hw.add(c.normal);
                        this.v5.add(Integer.valueOf(DW));
                    }
                    DW++;
                }
                for (i2 = 0; i2 < aVar.Hw(); i2++) {
                    printWriter.println((String) list.get(aVar.j6() + i2));
                    this.Zo.add(Integer.valueOf(aVar.j6() + i2));
                    this.VH.add(Integer.valueOf(-1));
                    this.Hw.add(c.deleted);
                    this.v5.add(Integer.valueOf(aVar.DW()));
                }
                for (i2 = 0; i2 < aVar.FH(); i2++) {
                    printWriter.println((String) list2.get(aVar.DW() + i2));
                    this.Zo.add(Integer.valueOf(-1));
                    this.VH.add(Integer.valueOf(aVar.DW() + i2));
                    this.Hw.add(c.inserted);
                    this.v5.add(Integer.valueOf(aVar.DW() + i2));
                }
                if (i + 1 < list3.size()) {
                    i2 = ((com.aide.ui.scm.a.a) list3.get(i + 1)).DW();
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                int FH = aVar.FH() + aVar.DW();
                int i3 = FH + 3;
                DW = FH;
                while (DW < i3 && DW < i2 && DW < list2.size()) {
                    printWriter.println((String) list2.get(DW));
                    this.Zo.add(Integer.valueOf(-1));
                    this.VH.add(Integer.valueOf(DW));
                    this.Hw.add(c.normal);
                    this.v5.add(Integer.valueOf(DW));
                    DW++;
                }
                if (i3 < i2 - 3 && i != list3.size() - 1) {
                    printWriter.println("");
                    this.Zo.add(Integer.valueOf(-1));
                    this.VH.add(Integer.valueOf(-1));
                    this.Hw.add(c.separator);
                    this.v5.add(Integer.valueOf(0));
                }
                i++;
                i2 = i3;
            }
            printWriter.flush();
            DW(stringWriter.toString());
        }

        private void j6(String str) {
            this.Hw.clear();
            DW(str);
        }

        private void DW(String str) {
            int FH = FH() - 1;
            int Hw = Hw(FH) - 1;
            if (!(Hw == -1 && FH == 0)) {
                j6(new qt(0, 0, FH, Hw), (Object) this);
            }
            try {
                j6(0, 0, new b(str), (Object) this);
            } catch (IOException e) {
            }
        }

        public boolean c_(int i, int i2) {
            return this.Hw.size() > i2 && this.Hw.get(i2) == c.inserted;
        }

        public boolean we(int i, int i2) {
            return this.Hw.size() > i2 && this.Hw.get(i2) == c.deleted;
        }

        public boolean j6(int i) {
            return false;
        }

        public boolean v5(int i) {
            return i > 0 && this.Hw.size() > i - 1 && this.Hw.get(i - 1) == c.separator;
        }
    }

    private static class b extends Reader {
        private int DW;
        private int FH;
        private String j6;

        public b(String str) {
            j6(str);
        }

        public void j6(String str) {
            this.j6 = str;
            this.DW = str.length();
            this.FH = 0;
        }

        public int read() {
            if (this.FH < this.DW) {
                String str = this.j6;
                int i = this.FH;
                this.FH = i + 1;
                return str.charAt(i);
            } else if (this.FH != this.DW) {
                return -1;
            } else {
                this.FH++;
                return 10;
            }
        }

        public int read(char[] cArr, int i, int i2) {
            if (i < 0 || i > cArr.length || i2 < 0 || i + i2 > cArr.length || i + i2 < 0) {
                throw new IndexOutOfBoundsException();
            } else if (i2 == 0) {
                return 0;
            } else {
                if (this.FH > this.DW) {
                    return -1;
                }
                if (this.FH == this.DW) {
                    cArr[i] = '\n';
                    this.FH++;
                    return 1;
                }
                int min = Math.min(this.DW - this.FH, i2);
                this.j6.getChars(this.FH, this.FH + min, cArr, i);
                this.FH += min;
                return min;
            }
        }

        public void close() {
        }
    }

    private enum c {
        deleted,
        inserted,
        normal,
        separator
    }

    public DiffView(Context context) {
        super(context);
        this.DW = new Object();
        VH();
    }

    public DiffView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DW = new Object();
        VH();
    }

    public DiffView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DW = new Object();
        VH();
    }

    private void VH() {
        this.j6 = new a(this);
        getOEditorView().setModel(this.j6);
        getOEditorView().setEditable(false);
        getOEditorView().setCaretVisibility(false);
        this.v5 = new KeyStrokeDetector(getContext());
    }

    public void j6() {
        setIsLightTheme(com.aide.ui.h.cn());
        getOEditorView().setTabSize(com.aide.ui.h.J0());
        getOEditorView().setInsertTabsAsSpaces(com.aide.ui.h.J8());
        getOEditorView().setFontSize((float) com.aide.ui.h.Hw());
    }

    public KeyStrokeDetector getKeyStrokeDetector() {
        return this.v5;
    }

    public void j6(FileHighlightings fileHighlightings) {
        synchronized (this.DW) {
            if (fileHighlightings.gn == this.FH || fileHighlightings.gn == this.Hw) {
                if (fileHighlightings.gn == this.FH) {
                    this.j6.j6(true, fileHighlightings.DW, fileHighlightings.FH, fileHighlightings.Hw, fileHighlightings.v5, fileHighlightings.Zo, fileHighlightings.VH);
                    return;
                } else if (fileHighlightings.gn == this.Hw) {
                    this.j6.j6(false, fileHighlightings.DW, fileHighlightings.FH, fileHighlightings.Hw, fileHighlightings.v5, fileHighlightings.Zo, fileHighlightings.VH);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public a getDiffViewModel() {
        return this.j6;
    }

    private List<String> j6(String str, StringBuilder stringBuilder) {
        if (str == null || !new File(str).exists()) {
            return Collections.emptyList();
        }
        Reader FH;
        try {
            List<String> arrayList = new ArrayList();
            FH = qh.FH(str);
            v.j6(FH, new 1(this, arrayList, stringBuilder), new char[1024]);
            BufferedReader bufferedReader = new BufferedReader(FH);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    arrayList.add(readLine);
                } else {
                    FH.close();
                    return arrayList;
                }
            }
        } catch (Throwable e) {
            e.j6(e);
            return Collections.emptyList();
        } catch (Throwable th) {
            FH.close();
        }
    }

    public void DW() {
        this.j6.j6(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public void setInformationalContent(String str) {
        this.j6.j6("\n >>> " + str + "\n");
        getOEditorView().Zo(0, 0);
        getOEditorView().setSoftMaxWidthRealColumn(-1);
    }

    public void j6(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        List j6 = j6(str, stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder();
        List j62 = j6(str2, stringBuilder2);
        List j63 = a.j6(j6, j62);
        if (j63.size() != 0 || stringBuilder.toString().equals(stringBuilder2.toString())) {
            this.j6.j6(j6, j62, j63);
            getOEditorView().Zo(0, 0);
            getOEditorView().setSoftMaxWidthRealColumn(-1);
            synchronized (this.DW) {
                if (j6.size() != 0) {
                    this.FH = com.aide.ui.e.XL().FH(str3, str);
                }
                if (j62.size() != 0) {
                    this.Hw = com.aide.ui.e.XL().FH(str3, str2);
                }
            }
            return;
        }
        setInformationalContent("Only the line separators differ");
    }
}
