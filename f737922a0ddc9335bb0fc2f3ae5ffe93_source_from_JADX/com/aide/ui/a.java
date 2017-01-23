package com.aide.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.aide.common.b;
import com.aide.common.d;
import com.aide.common.e;
import com.aide.engine.SourceEntity;
import com.aide.ui.views.CompletionListView;
import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a {
    private int DW;
    private int FH;
    private List<SourceEntity> Hw;
    private boolean VH;
    private boolean Zo;
    private boolean gn;
    private AIDEEditor j6;
    private boolean u7;
    private String v5;

    class 1 extends com.aide.engine.service.c.a {
        private List<SourceEntity> DW;
        final /* synthetic */ a j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                e.u7().J0();
            }
        }

        class 2 implements Comparator<SourceEntity> {
            final /* synthetic */ 1 j6;

            2(1 1) {
                this.j6 = 1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return j6((SourceEntity) obj, (SourceEntity) obj2);
            }

            public int j6(SourceEntity sourceEntity, SourceEntity sourceEntity2) {
                return sourceEntity.J8().toLowerCase().compareTo(sourceEntity2.J8().toLowerCase());
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ int DW;
            final /* synthetic */ List FH;
            final /* synthetic */ 1 Hw;
            final /* synthetic */ int j6;

            3(1 1, int i, int i2, List list) {
                this.Hw = 1;
                this.j6 = i;
                this.DW = i2;
                this.FH = list;
            }

            public void run() {
                e.u7().J0();
                this.Hw.j6.j6(this.j6, this.DW, this.FH);
            }
        }

        1(a aVar) {
            this.j6 = aVar;
            this.DW = new ArrayList();
        }

        public void j6(String str, long j, int i, int i2) {
            if (str.equals(e.j3().Hw())) {
                e.j6(new 1(this));
            }
        }

        public void j6() {
            this.DW = new ArrayList();
        }

        public void j6(List list) {
            for (SourceEntity sourceEntity : list) {
                if (this.j6.gn || !sourceEntity.FH()) {
                    this.DW.add(sourceEntity);
                }
            }
        }

        public void j6(String str, long j, int i, int i2, int i3, SourceEntity sourceEntity, String str2) {
            if (str.equals(e.j3().Hw()) && j == e.j3().Zo()) {
                if (this.DW.size() < 1000) {
                    Collections.sort(this.DW, new 2(this));
                }
                List list = this.DW;
                this.DW = null;
                e.j6(new 3(this, i, i3, list));
            }
        }
    }

    class 2 implements com.aide.ui.views.CustomKeysListView.a {
        final /* synthetic */ a j6;

        2(a aVar) {
            this.j6 = aVar;
        }

        public boolean j6(int i, KeyEvent keyEvent) {
            return this.j6.j6.j6(i, keyEvent);
        }

        public boolean DW(int i, KeyEvent keyEvent) {
            return this.j6.j6.DW(i, keyEvent);
        }
    }

    class 3 implements OnItemClickListener {
        final /* synthetic */ a DW;
        final /* synthetic */ CompletionListView j6;

        3(a aVar, CompletionListView completionListView) {
            this.DW = aVar;
            this.j6 = completionListView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object itemAtPosition = this.j6.getItemAtPosition(i);
            if (itemAtPosition instanceof SourceEntity) {
                this.DW.VH();
                SourceEntity sourceEntity = (SourceEntity) itemAtPosition;
                if (sourceEntity.v5()) {
                    this.DW.j6.j6(this.DW.DW, this.DW.FH, this.DW.DW, this.DW.EQ(), "");
                    e.u7().we();
                    e.XL().j6(e.j3().Hw(), this.DW.DW, this.DW.FH, sourceEntity);
                } else if (sourceEntity.FH()) {
                    this.DW.j6(sourceEntity.aM());
                    e.u7().we();
                    e.XL().j6(e.j3().Hw(), sourceEntity);
                } else {
                    this.DW.j6(sourceEntity.aM());
                }
            }
        }
    }

    class 4 implements OnItemLongClickListener {
        final /* synthetic */ a DW;
        final /* synthetic */ CompletionListView j6;

        4(a aVar, CompletionListView completionListView) {
            this.DW = aVar;
            this.j6 = completionListView;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            Object itemAtPosition = this.j6.getItemAtPosition(i);
            if (itemAtPosition instanceof SourceEntity) {
                SourceEntity sourceEntity = (SourceEntity) itemAtPosition;
                if (sourceEntity.QX() != null) {
                    e.u7().sh().QX();
                    b.j6(e.u7(), sourceEntity.QX(), com.aide.ui.activities.a.EQ().toString());
                    return true;
                }
            }
            return false;
        }
    }

    static /* synthetic */ class 5 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[com.aide.engine.SourceEntity.a.values().length];
            try {
                j6[com.aide.engine.SourceEntity.a.Method.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[com.aide.engine.SourceEntity.a.Field.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[com.aide.engine.SourceEntity.a.Variable.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[com.aide.engine.SourceEntity.a.Class.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[com.aide.engine.SourceEntity.a.Keyword.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                j6[com.aide.engine.SourceEntity.a.Package.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private class a extends ArrayAdapter<SourceEntity> {
        final /* synthetic */ a j6;

        class 1 implements OnClickListener {
            final /* synthetic */ a DW;
            final /* synthetic */ String j6;

            1(a aVar, String str) {
                this.DW = aVar;
                this.j6 = str;
            }

            public void onClick(View view) {
                e.u7().sh().QX();
                b.j6(e.u7(), this.j6, com.aide.ui.activities.a.EQ().toString());
            }
        }

        public a(a aVar, Context context, List<SourceEntity> list) {
            this.j6 = aVar;
            super(context, R.c.completion_list_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.c.completion_list_entry, viewGroup, false);
            }
            SourceEntity sourceEntity = (SourceEntity) getItem(i);
            if (sourceEntity == null) {
                ((TextView) view.findViewById(R.b.completionEntryName)).setText("No matches");
                ((ImageView) view.findViewById(R.b.completionEntryImage)).setImageResource(R.drawable.browser_empty);
                view.findViewById(R.b.completionHelpButton).setVisibility(8);
            } else {
                int i2;
                TextView textView = (TextView) view.findViewById(R.b.completionEntryName);
                Object J8 = sourceEntity.J8();
                Object obj;
                switch (5.j6[sourceEntity.DW().ordinal()]) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        String XL = sourceEntity.XL();
                        if (XL == null) {
                            textView.setText(J8);
                            break;
                        }
                        obj = J8 + XL;
                        textView.setText(obj, BufferType.SPANNABLE);
                        j6(textView, J8.length(), obj.length(), this.j6.j6.getResources().getColor(2131230745));
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        if (!sourceEntity.FH()) {
                            textView.setText(J8);
                            break;
                        }
                        obj = J8 + " - " + sourceEntity.we();
                        textView.setText(obj, BufferType.SPANNABLE);
                        j6(textView, J8.length(), obj.length(), this.j6.j6.getResources().getColor(2131230745));
                        break;
                    case 5:
                        textView.setText(J8, BufferType.SPANNABLE);
                        j6(textView, 0, J8.length());
                        break;
                    default:
                        textView.setText(J8);
                        break;
                }
                ImageView imageView = (ImageView) view.findViewById(R.b.completionEntryImage);
                switch (5.j6[sourceEntity.DW().ordinal()]) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        if (!sourceEntity.Zo()) {
                            imageView.setImageResource(R.drawable.box_red);
                            break;
                        }
                        imageView.setImageResource(R.drawable.box_light_red);
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        if (!sourceEntity.Zo()) {
                            imageView.setImageResource(R.drawable.box_blue);
                            break;
                        }
                        imageView.setImageResource(R.drawable.box_light_blue);
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        imageView.setImageResource(R.drawable.box_blue);
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        if (!sourceEntity.Zo()) {
                            imageView.setImageResource(R.drawable.objects);
                            break;
                        }
                        imageView.setImageResource(R.drawable.objects_light);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.pakage);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.browser_empty);
                        break;
                }
                View findViewById = view.findViewById(R.b.completionHelpButton);
                String QX = sourceEntity.QX();
                if (QX != null) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                findViewById.setVisibility(i2);
                if (QX != null) {
                    findViewById.setOnClickListener(new 1(this, QX));
                }
            }
            return view;
        }

        private void j6(TextView textView, int i, int i2, int i3) {
            ((Spannable) textView.getText()).setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        private void j6(TextView textView, int i, int i2) {
            ((Spannable) textView.getText()).setSpan(new StyleSpan(1), i, i2, 33);
        }
    }

    public a(AIDEEditor aIDEEditor) {
        this.j6 = aIDEEditor;
    }

    public void j6() {
        this.Zo = h.we();
        this.VH = h.tp();
        this.gn = h.u7();
    }

    public void DW() {
        this.Hw = null;
    }

    public boolean FH() {
        return e.u7().lp() != null && j6(e.u7().lp()).hasFocus();
    }

    private CompletionListView j6(View view) {
        return (CompletionListView) view.findViewById(R.b.completionList);
    }

    public void j6(boolean z) {
        if (!z && Zo() && !this.j6.isInTouchMode()) {
            ListView j6 = j6(e.u7().lp());
            j6.setFocusable(true);
            j6.requestFocus();
        }
    }

    public void j6(char c, int i, int i2) {
        if (!Zo() && DW(c) && j6(this.j6.tp(i, i2))) {
            DW(true);
        }
    }

    private boolean j6(char c) {
        return !Character.isJavaIdentifierPart(c);
    }

    private boolean DW(char c) {
        boolean z = true;
        if (c == '<' && this.Zo) {
            if (this.j6.getFilePath().toLowerCase().endsWith(".xml") || this.j6.getFilePath().toLowerCase().endsWith(".html") || this.j6.getFilePath().toLowerCase().endsWith(".htm")) {
                return true;
            }
            return false;
        } else if (c == '-' && this.Zo) {
            return this.j6.getFilePath().toLowerCase().endsWith(".css");
        } else {
            if (!((Character.isJavaIdentifierStart(c) && this.Zo) || (c == '.' && this.VH))) {
                z = false;
            }
            return z;
        }
    }

    public void j6(int i, int i2) {
        if (Zo()) {
            int EQ = EQ();
            if (i != this.DW || i2 < this.FH || i2 > EQ) {
                this.Hw = null;
                VH();
                return;
            }
            J0();
            return;
        }
        this.Hw = null;
    }

    public void Hw() {
        if (gn()) {
            v5();
        } else {
            this.j6.vy();
        }
    }

    public void v5() {
        if (Zo()) {
            tp();
        } else {
            DW(false);
        }
    }

    private boolean gn() {
        int selectionStartLine = this.j6.getSelectionStartLine();
        int selectionStartColumn = this.j6.getSelectionStartColumn();
        if (selectionStartColumn == 1) {
            return false;
        }
        char tp = this.j6.tp(selectionStartLine, selectionStartColumn - 1);
        if (Character.isJavaIdentifierPart(tp)) {
            return true;
        }
        if (tp == '.') {
            return true;
        }
        return false;
    }

    private void u7() {
        e.XL().j6(new 1(this));
    }

    private void DW(boolean z) {
        this.u7 = z;
        if (!z) {
            e.u7().we();
        }
        u7();
        e.XL().j6(e.j3().Hw(), this.j6.getSelectionStartLine(), this.j6.getSelectionStartColumn());
    }

    private void j6(int i, int i2, List<SourceEntity> list) {
        if (!Zo() || this.DW != i || this.FH != i2) {
            this.DW = i;
            this.FH = i2;
            this.Hw = list;
            if (i == this.j6.getSelectionStartLine() && EQ() >= this.j6.getSelectionStartColumn() && i2 <= this.j6.getSelectionStartColumn()) {
                if (this.u7 || !tp()) {
                    j6((List) list, this.u7);
                }
            }
        }
    }

    private boolean tp() {
        String we = we();
        String j6 = j6(this.Hw, we);
        if (j6.length() <= we.length()) {
            return false;
        }
        j6(j6);
        return true;
    }

    private int EQ() {
        int i = this.FH;
        while (this.j6.v5(this.DW) >= i && FH(this.j6.tp(this.DW, i))) {
            i++;
        }
        return i;
    }

    private boolean FH(char c) {
        return Character.isJavaIdentifierPart(c) || c == '-';
    }

    private String we() {
        return this.j6.j6(this.DW, this.FH, EQ());
    }

    private void j6(String str) {
        int indexOf = str.indexOf(124);
        String replace = str.replace("|", "");
        this.j6.getKeyStrokeDetector().j6();
        this.j6.j6(this.DW, this.FH, this.DW, EQ(), replace);
        if (indexOf > 0) {
            int i = this.FH + indexOf;
            this.j6.j6(this.DW, i, this.DW, i);
            return;
        }
        this.j6.VH();
    }

    private String j6(List<SourceEntity> list, String str) {
        List<SourceEntity> DW = DW(list, str);
        if (DW.size() == 0) {
            return "";
        }
        if (DW.size() == 1) {
            return ((SourceEntity) DW.get(0)).j3();
        }
        String str2 = "";
        while (true) {
            String j3 = ((SourceEntity) DW.get(0)).j3();
            if (j3.length() <= str2.length()) {
                return str2;
            }
            String str3 = str2 + j3.charAt(str2.length());
            for (SourceEntity j32 : DW) {
                if (!j32.j3().startsWith(str3)) {
                    return str2;
                }
            }
            str2 = str3;
        }
    }

    private List<SourceEntity> DW(List<SourceEntity> list, String str) {
        String toLowerCase = str.toLowerCase();
        List<SourceEntity> arrayList = new ArrayList();
        for (SourceEntity sourceEntity : list) {
            if (sourceEntity.J8().toLowerCase().startsWith(toLowerCase)) {
                if (sourceEntity.v5() || sourceEntity.FH()) {
                    return new ArrayList();
                }
                arrayList.add(sourceEntity);
            }
        }
        return arrayList;
    }

    private void j6(List<SourceEntity> list, boolean z) {
        e.j6("openPopup");
        VH();
        View inflate = LayoutInflater.from(this.j6.getContext()).inflate(R.c.completion_list, null);
        ListView j6 = j6(inflate);
        boolean j62 = j6(j6, we());
        if (!z || !j62) {
            this.j6.getKeyStrokeDetector().j6();
            j6.setKeyStrokeDetector(this.j6.getKeyStrokeDetector());
            j6.setKeyStrokeHandler(this.j6.getKeyStrokeHandler());
            j6.setOnKeyEventListener(new 2(this));
            j6.setOnItemClickListener(new 3(this, j6));
            j6.setOnItemLongClickListener(new 4(this, j6));
            float f = this.j6.getContext().getResources().getDisplayMetrics().density;
            int u7 = (int) (d.u7(this.j6.getContext()) * f);
            int VH = (int) (d.VH(this.j6.getContext()) * f);
            int min = (int) Math.min(Math.max(500.0f * f, (float) (u7 / 2)), (float) u7);
            VH = (int) Math.max(Math.min(Math.min(350.0f * f, (float) (VH / 2)), ((float) VH) - (250.0f * f)), f * 90.0f);
            this.j6.EQ(this.DW, VH);
            Rect DW = this.j6.DW(this.DW, this.FH, this.FH);
            int i = DW.left;
            int i2 = DW.bottom;
            if (i + min > u7) {
                i = u7 - min;
            }
            e.u7().j6(inflate, new Rect(i, i2, min + i, VH + i2));
            if (this.j6.isInTouchMode() || this.j6.QX()) {
                j6.setFocusable(false);
            } else {
                j6.requestFocus();
            }
        }
    }

    public boolean Zo() {
        return e.u7().lp() != null;
    }

    private void J0() {
        String we = we();
        if (!we.equals(this.v5)) {
            ListView j6 = j6(e.u7().lp());
            j6(j6, we);
            if (j6.isFocusable()) {
                j6.requestFocus();
            }
        }
    }

    private boolean j6(ListView listView, String str) {
        boolean z;
        this.v5 = str;
        String toLowerCase = str.toLowerCase();
        List<SourceEntity> arrayList = new ArrayList();
        for (SourceEntity sourceEntity : this.Hw) {
            if (sourceEntity.J8().toLowerCase().startsWith(toLowerCase)) {
                arrayList.add(sourceEntity);
            }
        }
        if (arrayList.size() == 0) {
            arrayList.add(null);
            z = true;
        } else {
            z = false;
        }
        if (listView.getAdapter() instanceof a) {
            a aVar = (a) listView.getAdapter();
            aVar.clear();
            for (SourceEntity add : arrayList) {
                aVar.add(add);
            }
        } else {
            listView.setAdapter(new a(this, this.j6.getContext(), arrayList));
        }
        return z;
    }

    public void VH() {
        if (Zo()) {
            e.u7().aj();
            this.j6.BT();
        }
    }
}
