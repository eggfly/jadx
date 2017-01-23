package com.aide.ui.browsers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.aide.common.l;
import com.aide.ui.MainActivity;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.f;
import com.aide.ui.g;
import com.aide.ui.j;
import com.aide.ui.views.CustomKeysListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pe$a;
import qa;
import qh;

public class FileBrowser extends LinearLayout implements a, pe$a {
    private g DW;
    private g FH;
    private com.aide.common.KeyStrokeDetector.a Hw;
    protected View j6;
    private a v5;

    class 1 implements OnItemSelectedListener {
        final /* synthetic */ FileBrowser DW;
        final /* synthetic */ CustomKeysListView j6;

        1(FileBrowser fileBrowser, CustomKeysListView customKeysListView) {
            this.DW = fileBrowser;
            this.j6 = customKeysListView;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.DW.j6((b) this.j6.getItemAtPosition(i));
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
            this.DW.j6(null);
        }
    }

    class 2 implements com.aide.ui.views.CustomKeysListView.a {
        final /* synthetic */ FileBrowser j6;

        2(FileBrowser fileBrowser) {
            this.j6 = fileBrowser;
        }

        public boolean DW(int i, KeyEvent keyEvent) {
            return e.u7().cb().j6(i, keyEvent, this.j6.Hw);
        }

        public boolean j6(int i, KeyEvent keyEvent) {
            return e.u7().cb().DW(i, keyEvent, this.j6.Hw);
        }
    }

    class 3 implements OnItemLongClickListener {
        final /* synthetic */ FileBrowser DW;
        final /* synthetic */ CustomKeysListView j6;

        3(FileBrowser fileBrowser, CustomKeysListView customKeysListView) {
            this.DW = fileBrowser;
            this.j6 = customKeysListView;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) this.j6.getItemAtPosition(i);
            if (bVar != null) {
                this.DW.j6(bVar);
                this.DW.j6(view, true);
            }
            return true;
        }
    }

    class 4 implements OnItemClickListener {
        final /* synthetic */ FileBrowser DW;
        final /* synthetic */ CustomKeysListView j6;

        4(FileBrowser fileBrowser, CustomKeysListView customKeysListView) {
            this.DW = fileBrowser;
            this.j6 = customKeysListView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) this.j6.getItemAtPosition(i);
            if (bVar != null) {
                if (bVar.Hw != null) {
                    this.DW.j6 = view;
                    com.aide.analytics.a.DW("Browser command: " + bVar.Hw.FH());
                    bVar.Hw.DW();
                } else if (bVar.DW) {
                    this.DW.getActivity().FH(bVar.FH);
                } else if (bVar.DW()) {
                    r0 = bVar.FH;
                    if (r0 != null) {
                        e.er().j6(r0);
                    }
                    this.DW.getListView().setSelection(0);
                } else {
                    r0 = bVar.FH;
                    if (r0 != null) {
                        this.DW.DW(r0);
                    }
                    this.DW.getListView().setSelection(0);
                }
            }
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ FileBrowser DW;
        final /* synthetic */ ImageView j6;

        5(FileBrowser fileBrowser, ImageView imageView) {
            this.DW = fileBrowser;
            this.j6 = imageView;
        }

        public void onClick(View view) {
            e.er().DW(null);
            this.DW.j6(this.j6, true);
        }
    }

    class 6 implements Comparator<String> {
        final /* synthetic */ FileBrowser j6;

        6(FileBrowser fileBrowser) {
            this.j6 = fileBrowser;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((String) obj, (String) obj2);
        }

        public int j6(String str, String str2) {
            boolean EQ = qh.EQ(str);
            boolean EQ2 = qh.EQ(str2);
            String toLowerCase = qh.Zo(str).toLowerCase();
            String toLowerCase2 = qh.Zo(str2).toLowerCase();
            if (EQ && !EQ2) {
                return -1;
            }
            if (!EQ && EQ2) {
                return 1;
            }
            if (EQ && EQ2) {
                EQ = FileBrowser.FH(toLowerCase);
                EQ2 = FileBrowser.FH(toLowerCase2);
                if (EQ && !EQ2) {
                    return 1;
                }
                if (EQ || !EQ2) {
                    return toLowerCase.compareTo(toLowerCase2);
                }
                return -1;
            }
            int lastIndexOf = toLowerCase.lastIndexOf(".");
            String substring = lastIndexOf > 0 ? toLowerCase.substring(lastIndexOf) : "";
            int lastIndexOf2 = toLowerCase2.lastIndexOf(".");
            lastIndexOf = substring.compareTo(lastIndexOf2 > 0 ? toLowerCase2.substring(lastIndexOf2) : "");
            return lastIndexOf == 0 ? toLowerCase.compareTo(toLowerCase2) : lastIndexOf;
        }
    }

    private class a extends l<b> {
        final /* synthetic */ FileBrowser j6;

        private a(FileBrowser fileBrowser) {
            this.j6 = fileBrowser;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.j6.getContext()).inflate(R.c.filebrowser_entry, viewGroup, false);
            }
            b bVar = (b) j6(i);
            ((TextView) view.findViewById(R.b.filebrowserEntryName)).setText(bVar.j6);
            ((ImageView) view.findViewById(R.b.filebrowserEntryFileImage)).setImageResource(bVar.v5);
            return view;
        }
    }

    private class b {
        public boolean DW;
        public String FH;
        public qa Hw;
        final /* synthetic */ FileBrowser Zo;
        public String j6;
        public int v5;

        public b(FileBrowser fileBrowser, String str, String str2, boolean z) {
            this.Zo = fileBrowser;
            this.FH = str;
            this.j6 = str2;
            this.DW = z;
            if (this.DW) {
                this.v5 = j.j6(str);
            } else if (DW()) {
                this.v5 = R.drawable.folder_open;
            } else if (FileBrowser.FH(str2)) {
                this.v5 = R.drawable.folder_hidden;
            } else {
                this.v5 = R.drawable.folder;
            }
        }

        public b(FileBrowser fileBrowser, qa qaVar) {
            this.Zo = fileBrowser;
            this.Hw = qaVar;
            this.v5 = qaVar.j6();
            int FH = qaVar.FH();
            if (FH != 0) {
                this.j6 = fileBrowser.getContext().getResources().getString(FH);
            }
        }

        public boolean j6() {
            return (this.DW || DW()) ? false : true;
        }

        public boolean DW() {
            return !this.DW && this.j6.equals("..");
        }
    }

    public FileBrowser(Context context) {
        super(context);
        this.DW = new g(e.u7(), R.d.filebrowser_context_menu);
        this.FH = new g(e.u7(), R.d.git_context_menu);
        this.Hw = new com.aide.ui.b(f.DW());
        VH();
    }

    public FileBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DW = new g(e.u7(), R.d.filebrowser_context_menu);
        this.FH = new g(e.u7(), R.d.git_context_menu);
        this.Hw = new com.aide.ui.b(f.DW());
        VH();
    }

    private MainActivity getActivity() {
        return (MainActivity) getContext();
    }

    private void VH() {
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        View inflate = from.inflate(R.c.filebrowser, null);
        removeAllViews();
        addView(inflate);
        getListView().addHeaderView(from.inflate(R.c.browser_header, null), null, false);
        e.er().j6((pe$a) this);
        CustomKeysListView listView = getListView();
        ListAdapter aVar = new a();
        this.v5 = aVar;
        listView.setAdapter(aVar);
        listView.setOnItemSelectedListener(new 1(this, listView));
        listView.setOnKeyEventListener(new 2(this));
        listView.setOnItemLongClickListener(new 3(this, listView));
        listView.setOnItemClickListener(new 4(this, listView));
        FH();
    }

    public void FH() {
        String j6 = e.er().j6();
        e.er().DW(null);
        CustomKeysListView listView = getListView();
        ((TextView) listView.findViewById(R.b.browserHeaderLabel)).setText(j6);
        ((ImageView) listView.findViewById(R.b.browserHeaderIcon)).setImageResource(R.drawable.folder_open);
        ImageView imageView = (ImageView) listView.findViewById(R.b.browserHeaderMenuButton);
        imageView.setOnClickListener(new 5(this, imageView));
        List arrayList = new ArrayList();
        String v5 = qh.v5(j6);
        if (v5 != null) {
            arrayList.add(new b(this, v5, "..", false));
        }
        for (qa qaVar : f.VH()) {
            if (qaVar.j6(false)) {
                arrayList.add(new b(this, qaVar));
            }
        }
        try {
            List<String> QX = qh.QX(j6);
            j6((List) QX);
            for (String v52 : QX) {
                arrayList.add(new b(this, v52, qh.Zo(v52), qh.J8(v52)));
            }
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
        }
        this.v5.j6(arrayList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void DW(java.lang.String r4) {
        /*
        r3 = this;
        r0 = com.aide.ui.e.a8();
        r0 = r0.v5(r4);
        if (r0 == 0) goto L_0x002c;
    L_0x000a:
        r1 = qh.QX(r4);	 Catch:{ IOException -> 0x002b }
        r0 = r1.size();	 Catch:{ IOException -> 0x002b }
        r2 = 1;
        if (r0 != r2) goto L_0x002c;
    L_0x0015:
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ IOException -> 0x002b }
        r0 = (java.lang.String) r0;	 Catch:{ IOException -> 0x002b }
        r0 = qh.EQ(r0);	 Catch:{ IOException -> 0x002b }
        if (r0 == 0) goto L_0x002c;
    L_0x0022:
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ IOException -> 0x002b }
        r0 = (java.lang.String) r0;	 Catch:{ IOException -> 0x002b }
        r4 = r0;
        goto L_0x000a;
    L_0x002b:
        r0 = move-exception;
    L_0x002c:
        r0 = com.aide.ui.e.er();
        r0.j6(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.browsers.FileBrowser.DW(java.lang.String):void");
    }

    private CustomKeysListView getListView() {
        return (CustomKeysListView) findViewById(R.b.filebrowserFileList);
    }

    public void Hw() {
        Object selectedItem = getListView().getSelectedItem();
        if (selectedItem instanceof b) {
            j6((b) selectedItem);
            j6(getListView().getSelectedView(), false);
        }
    }

    public void v5() {
        j6(this.j6);
    }

    private void j6(b bVar) {
        String str = null;
        if (bVar != null && (bVar.DW || bVar.j6())) {
            str = bVar.FH;
        }
        e.er().DW(str);
    }

    private void j6(View view, boolean z) {
        this.DW.j6(view, z);
    }

    private void j6(View view) {
        this.FH.j6(view, true);
    }

    private void j6(List<String> list) {
        Collections.sort(list, new 6(this));
    }

    private static boolean FH(String str) {
        return str.startsWith(".") || "bin".equals(str) || "obj".equals(str) || "build".equals(str) || "gradle".equals(str);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (e.u7().cb().j6(i, keyEvent, this.Hw)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (e.u7().cb().DW(i, keyEvent, this.Hw)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void j6() {
        getListView().requestFocus();
    }

    public void Zo() {
        FH();
    }

    public void DW() {
    }
}
