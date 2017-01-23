package com.aide.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.aide.ui.R;
import com.aide.uidesigner.XmlLayoutDesignActivity;
import java.util.ArrayList;
import java.util.List;

public class q extends m {
    private String DW;
    private List<a> j6;

    public interface a {
        String DW();

        int FH();

        String Hw();

        void j6();

        boolean v5();
    }

    class 1 implements OnItemClickListener {
        final /* synthetic */ q DW;
        final /* synthetic */ AlertDialog j6;

        1(q qVar, AlertDialog alertDialog) {
            this.DW = qVar;
            this.j6 = alertDialog;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.j6.dismiss();
            ((a) this.DW.j6.get(i)).j6();
        }
    }

    private static class b extends ArrayAdapter<a> {

        class 1 implements OnClickListener {
            final /* synthetic */ b DW;
            final /* synthetic */ String j6;

            1(b bVar, String str) {
                this.DW = bVar;
                this.j6 = str;
            }

            public void onClick(View view) {
                ((XmlLayoutDesignActivity) this.DW.getContext()).j6(this.j6);
            }
        }

        public b(Context context, List<a> list) {
            super(context, R.c.propertydialog_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.c.propertydialog_entry, viewGroup, false);
            }
            a aVar = (a) getItem(i);
            ((TextView) view.findViewById(R.b.widgetmenuEntryName)).setText(Html.fromHtml(aVar.DW()));
            ((ImageView) view.findViewById(R.b.widgetmenuEntryImage)).setImageResource(d.DW(getContext(), aVar.FH()));
            String Hw = aVar.Hw();
            View findViewById = view.findViewById(R.b.widgetmenuHelpButton);
            findViewById.setVisibility(Hw == null ? 8 : 0);
            if (Hw != null) {
                findViewById.setOnClickListener(new 1(this, Hw));
            }
            return view;
        }
    }

    public q(String str, List<? extends a> list) {
        this.DW = str;
        this.j6 = new ArrayList();
        for (a aVar : list) {
            if (aVar.v5()) {
                this.j6.add(aVar);
            }
        }
    }

    protected Dialog j6(Activity activity) {
        View listView = new ListView(activity);
        listView.setAdapter(new b(activity, this.j6));
        Dialog create = new Builder(activity).setCancelable(true).setView(listView).setTitle(this.DW).create();
        create.setCanceledOnTouchOutside(true);
        listView.setOnItemClickListener(new 1(this, create));
        return create;
    }
}
