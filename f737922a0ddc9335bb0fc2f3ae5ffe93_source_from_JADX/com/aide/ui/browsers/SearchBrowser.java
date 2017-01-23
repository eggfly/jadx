package com.aide.ui.browsers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.aide.common.d;
import com.aide.engine.FindResult;
import com.aide.ui.MainActivity;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.f;
import com.aide.ui.j;
import com.aide.ui.views.CustomKeysListView;
import java.util.ArrayList;
import java.util.List;
import pr$a;
import qg;
import qh;

public class SearchBrowser extends LinearLayout implements a, pr$a {
    private com.aide.common.KeyStrokeDetector.a j6;

    class 1 implements com.aide.ui.views.CustomKeysListView.a {
        final /* synthetic */ SearchBrowser j6;

        1(SearchBrowser searchBrowser) {
            this.j6 = searchBrowser;
        }

        public boolean DW(int i, KeyEvent keyEvent) {
            return e.u7().cb().j6(i, keyEvent, this.j6.j6);
        }

        public boolean j6(int i, KeyEvent keyEvent) {
            return e.u7().cb().DW(i, keyEvent, this.j6.j6);
        }
    }

    class 2 implements OnItemClickListener {
        final /* synthetic */ SearchBrowser DW;
        final /* synthetic */ CustomKeysListView j6;

        2(SearchBrowser searchBrowser, CustomKeysListView customKeysListView) {
            this.DW = searchBrowser;
            this.j6 = customKeysListView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) this.j6.getItemAtPosition(i);
            if (bVar != null) {
                this.DW.getActivity().j6(bVar.Hw);
                this.DW.invalidate();
            }
        }
    }

    private class a extends ArrayAdapter<b> {
        final /* synthetic */ SearchBrowser j6;

        public a(SearchBrowser searchBrowser, Context context, List<b> list) {
            this.j6 = searchBrowser;
            super(context, R.c.searchbrowser_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.c.searchbrowser_entry, viewGroup, false);
                d.j6((FindResultTextView) view.findViewById(R.b.searchbrowserCodeLine));
            }
            b bVar = (b) getItem(i);
            if (bVar.j6) {
                view.findViewById(R.b.searchbrowserFile).setVisibility(0);
                view.findViewById(R.b.searchbrowserCode).setVisibility(8);
                ((ImageView) view.findViewById(R.b.searchbrowserEntryFileImage)).setImageResource(j.j6(bVar.DW));
                ((TextView) view.findViewById(R.b.searchbrowserEntryFileName)).setText(bVar.DW);
            } else {
                view.findViewById(R.b.searchbrowserFile).setVisibility(8);
                view.findViewById(R.b.searchbrowserCode).setVisibility(0);
                ((FindResultTextView) view.findViewById(R.b.searchbrowserCodeLine)).setContent(bVar.FH);
            }
            return view;
        }
    }

    private class b {
        public String DW;
        public FindResult FH;
        public qg Hw;
        public boolean j6;
        final /* synthetic */ SearchBrowser v5;

        public b(SearchBrowser searchBrowser, FindResult findResult) {
            this.v5 = searchBrowser;
            this.FH = findResult;
            this.Hw = new qg(findResult.j6, findResult.DW, findResult.FH, findResult.DW, findResult.Hw);
        }

        public b(SearchBrowser searchBrowser, String str) {
            this.v5 = searchBrowser;
            this.j6 = true;
            this.DW = qh.Zo(str);
            this.Hw = new qg(str, 1, 1, 1, 1);
        }
    }

    public SearchBrowser(Context context) {
        super(context);
        this.j6 = new com.aide.ui.b(f.Hw());
        v5();
    }

    public SearchBrowser(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new com.aide.ui.b(f.Hw());
        v5();
    }

    private MainActivity getActivity() {
        return (MainActivity) getContext();
    }

    public void FH() {
        Hw();
        if (!e.yS().DW()) {
            requestFocus();
        }
    }

    private void v5() {
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        View inflate = from.inflate(R.c.searchbrowser, null);
        removeAllViews();
        addView(inflate);
        getListView().addHeaderView(from.inflate(R.c.browser_header, null), null, false);
        e.yS().j6((pr$a) this);
        Hw();
    }

    public void Hw() {
        if (e.yS().DW()) {
            findViewById(R.b.searchbrowserProgress).setVisibility(0);
            findViewById(R.b.searchbrowserResults).setVisibility(8);
            return;
        }
        int i;
        CustomKeysListView listView = getListView();
        findViewById(R.b.searchbrowserProgress).setVisibility(8);
        findViewById(R.b.searchbrowserResults).setVisibility(0);
        TextView textView = (TextView) listView.findViewById(R.b.browserHeaderLabel);
        ImageView imageView = (ImageView) listView.findViewById(R.b.browserHeaderIcon);
        ((ImageView) listView.findViewById(R.b.browserHeaderMenuButton)).setVisibility(8);
        imageView.setImageResource(R.drawable.search);
        textView.setText(R.f.view_search_results);
        List<FindResult> FH = e.yS().FH();
        List arrayList = new ArrayList();
        Object obj = null;
        for (FindResult findResult : FH) {
            if (obj != null && !findResult.j6.equals(obj)) {
                i = 1;
                break;
            }
            String str = findResult.j6;
        }
        i = 0;
        Object obj2 = null;
        for (FindResult findResult2 : FH) {
            if (!(i == 0 || findResult2.j6.equals(r2))) {
                obj2 = findResult2.j6;
                arrayList.add(new b(this, findResult2.j6));
            }
            arrayList.add(new b(this, findResult2));
        }
        listView.setOnKeyEventListener(new 1(this));
        listView.setAdapter(new a(this, getContext(), arrayList));
        listView.setOnItemClickListener(new 2(this, listView));
    }

    private CustomKeysListView getListView() {
        return (CustomKeysListView) findViewById(R.b.searchbrowserList);
    }

    public void j6() {
        requestFocus();
    }

    public void DW() {
    }
}
