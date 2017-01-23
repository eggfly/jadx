package com.aide.ui.browsers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.aide.common.l;
import com.aide.engine.SyntaxError;
import com.aide.ui.MainActivity;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.f;
import com.aide.ui.j;
import com.aide.ui.views.CustomKeysListView;
import java.util.ArrayList;
import java.util.List;
import qg;
import qh;

public class ErrorBrowser extends LinearLayout implements a {
    private int DW;
    private a FH;
    private com.aide.common.KeyStrokeDetector.a j6;

    class 1 implements com.aide.ui.views.CustomKeysListView.a {
        final /* synthetic */ ErrorBrowser j6;

        1(ErrorBrowser errorBrowser) {
            this.j6 = errorBrowser;
        }

        public boolean DW(int i, KeyEvent keyEvent) {
            return e.u7().cb().j6(i, keyEvent, this.j6.j6);
        }

        public boolean j6(int i, KeyEvent keyEvent) {
            return e.u7().cb().DW(i, keyEvent, this.j6.j6);
        }
    }

    class 2 implements OnItemLongClickListener {
        final /* synthetic */ ErrorBrowser DW;
        final /* synthetic */ CustomKeysListView j6;

        2(ErrorBrowser errorBrowser, CustomKeysListView customKeysListView) {
            this.DW = errorBrowser;
            this.j6 = customKeysListView;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) this.j6.getItemAtPosition(i);
            if (!(bVar == null || bVar.DW || bVar.j6)) {
                this.DW.getActivity().j6(bVar.Zo);
                this.DW.getActivity().sh().u7();
            }
            return true;
        }
    }

    class 3 implements OnItemClickListener {
        final /* synthetic */ ErrorBrowser DW;
        final /* synthetic */ CustomKeysListView j6;

        3(ErrorBrowser errorBrowser, CustomKeysListView customKeysListView) {
            this.DW = errorBrowser;
            this.j6 = customKeysListView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) this.j6.getItemAtPosition(i);
            if (bVar != null) {
                this.DW.getActivity().j6(bVar.Zo);
            }
        }
    }

    private class a extends l<b> {
        final /* synthetic */ ErrorBrowser j6;

        private a(ErrorBrowser errorBrowser) {
            this.j6 = errorBrowser;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.j6.getContext()).inflate(R.c.errorbrowser_entry, viewGroup, false);
            }
            b bVar = (b) j6(i);
            if (bVar.DW || bVar.j6) {
                view.findViewById(R.b.errorbrowserEntryFile).setVisibility(0);
                view.findViewById(R.b.errorbrowserEntryError).setVisibility(8);
                ImageView imageView = (ImageView) view.findViewById(R.b.errorbrowserEntryFileImage);
                if (bVar.j6) {
                    imageView.setImageResource(R.drawable.folder);
                } else {
                    imageView.setImageResource(j.j6(bVar.FH));
                }
                ((TextView) view.findViewById(R.b.errorbrowserEntryFileName)).setText(bVar.FH);
            } else {
                view.findViewById(R.b.errorbrowserEntryFile).setVisibility(8);
                view.findViewById(R.b.errorbrowserEntryError).setVisibility(0);
                ((ImageView) view.findViewById(R.b.errorbrowserEntryImage)).setImageResource(R.drawable.project_errors);
                ((TextView) view.findViewById(R.b.errorbrowserEntryMessage)).setText(bVar.Hw);
            }
            return view;
        }
    }

    private class b {
        public boolean DW;
        public String FH;
        public String Hw;
        final /* synthetic */ ErrorBrowser VH;
        public qg Zo;
        public boolean j6;
        public SyntaxError v5;

        public b(ErrorBrowser errorBrowser, String str, SyntaxError syntaxError) {
            this.VH = errorBrowser;
            this.v5 = syntaxError;
            this.Hw = syntaxError.j6();
            this.Zo = new qg(str, syntaxError.FH, syntaxError.Hw, syntaxError.v5, syntaxError.Zo);
        }

        public b(ErrorBrowser errorBrowser, String str) {
            this.VH = errorBrowser;
            this.DW = qh.J8(str);
            this.j6 = !this.DW;
            this.FH = qh.Zo(str);
            this.Zo = new qg(str, 1, 1, 1, 1);
        }
    }

    public ErrorBrowser(Context context) {
        super(context);
        this.j6 = new com.aide.ui.b(f.FH());
        v5();
    }

    public ErrorBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new com.aide.ui.b(f.FH());
        v5();
    }

    private MainActivity getActivity() {
        return (MainActivity) getContext();
    }

    private void v5() {
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        View inflate = from.inflate(R.c.errorbrowser, null);
        removeAllViews();
        addView(inflate);
        View inflate2 = from.inflate(R.c.browser_header, null);
        CustomKeysListView listView = getListView();
        listView.addHeaderView(inflate2, null, false);
        ListAdapter aVar = new a();
        this.FH = aVar;
        listView.setAdapter(aVar);
        listView.setOnKeyEventListener(new 1(this));
        listView.setOnItemLongClickListener(new 2(this, listView));
        listView.setOnItemClickListener(new 3(this, listView));
        Hw();
    }

    public void FH() {
        int FH = e.aM().FH();
        if (FH < 100 && this.DW != FH) {
            Hw();
        }
    }

    public void Hw() {
        CharSequence string;
        int i;
        String string2;
        CustomKeysListView listView = getListView();
        boolean hasFocus = listView.hasFocus();
        this.DW = e.aM().FH();
        if (this.DW == 0) {
            string = getContext().getResources().getString(R.f.view_no_errors);
            i = R.drawable.project_no_errors;
        } else {
            if (this.DW == 1) {
                string2 = getContext().getResources().getString(R.f.view_one_error);
            } else {
                string2 = getContext().getResources().getString(R.f.view_errors, new Object[]{this.DW + ""});
            }
            Object obj = string2;
            i = R.drawable.project_errors;
        }
        TextView textView = (TextView) listView.findViewById(R.b.browserHeaderLabel);
        ImageView imageView = (ImageView) listView.findViewById(R.b.browserHeaderIcon);
        ImageView imageView2 = (ImageView) listView.findViewById(R.b.browserHeaderMenuButton);
        imageView.setImageResource(i);
        textView.setText(string);
        imageView2.setVisibility(8);
        List arrayList = new ArrayList();
        for (String string22 : e.aM().gn()) {
            List<SyntaxError> FH = e.aM().FH(string22);
            if (FH.size() > 0) {
                arrayList.add(new b(this, string22));
                for (SyntaxError bVar : FH) {
                    arrayList.add(new b(this, string22, bVar));
                }
            }
        }
        this.FH.j6(arrayList);
        if (hasFocus) {
            com.aide.common.e.j6("Focus error browser after refresh");
            j6();
        }
    }

    private CustomKeysListView getListView() {
        return (CustomKeysListView) findViewById(R.b.errorbrowserErrorList);
    }

    public void j6() {
        getListView().requestFocus();
    }

    public void DW() {
    }
}
