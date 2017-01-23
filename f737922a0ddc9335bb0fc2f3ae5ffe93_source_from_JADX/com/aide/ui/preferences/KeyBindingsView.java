package com.aide.ui.preferences;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.aide.common.k;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pz;
import qi;

public class KeyBindingsView extends LinearLayout {

    class 1 implements Comparator<b> {
        final /* synthetic */ KeyBindingsView j6;

        1(KeyBindingsView keyBindingsView) {
            this.j6 = keyBindingsView;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((b) obj, (b) obj2);
        }

        public int j6(b bVar, b bVar2) {
            return bVar.FH.compareTo(bVar2.FH);
        }
    }

    class 2 implements OnItemClickListener {
        final /* synthetic */ KeyBindingsView DW;
        final /* synthetic */ ListView j6;

        class 1 implements y<k> {
            final /* synthetic */ 2 DW;
            final /* synthetic */ b j6;

            1(2 2, b bVar) {
                this.DW = 2;
                this.j6 = bVar;
            }

            public void j6(k kVar) {
                e.BT().j6(this.j6.j6, kVar);
                this.DW.DW.j6();
            }
        }

        2(KeyBindingsView keyBindingsView, ListView listView) {
            this.DW = keyBindingsView;
            this.j6 = listView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (e.Mr().j6((Activity) this.DW.getContext(), "custom_keybindings")) {
                b bVar = (b) this.j6.getItemAtPosition(i);
                m.j6((Activity) this.DW.getContext(), "Change Keybinding", "Type key binding for \"" + bVar.FH + "\"", (k) bVar.DW.get(0), new 1(this, bVar));
            }
        }
    }

    private class a extends ArrayAdapter<b> {
        final /* synthetic */ KeyBindingsView j6;

        public a(KeyBindingsView keyBindingsView, Context context, List<b> list) {
            this.j6 = keyBindingsView;
            super(context, R.c.keybindings_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.c.keybindings_entry, viewGroup, false);
            }
            b bVar = (b) getItem(i);
            ((TextView) view.findViewById(R.b.keybindingsEntryName)).setText(bVar.FH);
            ((TextView) view.findViewById(R.b.keybindingsEntryBinding)).setText(bVar.Hw + " ");
            return view;
        }
    }

    private class b {
        public List<k> DW;
        public String FH;
        public String Hw;
        public qi j6;
        final /* synthetic */ KeyBindingsView v5;

        public b(KeyBindingsView keyBindingsView, qi qiVar) {
            this.v5 = keyBindingsView;
            this.j6 = qiVar;
            this.FH = qiVar.v5();
            this.DW = e.BT().j6(qiVar);
            this.Hw = "";
            for (k kVar : this.DW) {
                if (this.Hw.length() > 0) {
                    this.Hw += "\n";
                }
                this.Hw += kVar.toString();
            }
        }
    }

    public KeyBindingsView(Context context) {
        super(context);
        DW();
    }

    public KeyBindingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DW();
    }

    public KeyBindingsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DW();
    }

    private void DW() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.c.keybindings, null);
        removeAllViews();
        addView(inflate);
        j6();
    }

    public void j6() {
        List arrayList = new ArrayList();
        for (pz pzVar : f.Zo()) {
            if (pzVar instanceof qi) {
                arrayList.add(new b(this, (qi) pzVar));
            }
        }
        for (qi bVar : e.u7().sh().getBasicEditorCommands()) {
            arrayList.add(new b(this, bVar));
        }
        Collections.sort(arrayList, new 1(this));
        ListView listView = (ListView) findViewById(R.b.keybindingsList);
        listView.setAdapter(new a(this, getContext(), arrayList));
        listView.setOnItemClickListener(new 2(this, listView));
    }
}
