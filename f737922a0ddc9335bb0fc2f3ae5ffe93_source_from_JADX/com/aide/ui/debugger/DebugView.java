package com.aide.ui.debugger;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.aide.common.l;
import com.aide.ui.R;
import com.aide.ui.debugger.Debugger.c;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;
import qh;

public class DebugView extends LinearLayout {
    private String DW;
    private b j6;

    class 1 implements OnItemClickListener {
        final /* synthetic */ DebugView DW;
        final /* synthetic */ ListView j6;

        1(DebugView debugView, ListView listView) {
            this.DW = debugView;
            this.j6 = listView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a aVar = (a) this.j6.getAdapter().getItem(i);
            if (aVar.DW != null) {
                aVar.DW.j6();
            } else if (aVar.j6 != null) {
                aVar.j6.Hw();
            } else if (aVar.FH != null) {
                aVar.FH.DW();
            }
        }
    }

    class 2 implements OnItemLongClickListener {
        final /* synthetic */ DebugView j6;

        2(DebugView debugView) {
            this.j6 = debugView;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ((ClipboardManager) this.j6.getContext().getSystemService("clipboard")).setText(((TextView) view.findViewById(R.b.debuggerEntryName)).getText().toString().replace("\u00a0", " "));
            Toast.makeText(this.j6.getContext(), R.f.view_toast_copied_to_clipboard, 0).show();
            return true;
        }
    }

    private static class a {
        public com.aide.ui.debugger.Debugger.a DW;
        public com.aide.ui.debugger.Debugger.b FH;
        public String Hw;
        public c j6;

        public a(String str) {
            this.Hw = str;
        }

        public a(c cVar) {
            this.j6 = cVar;
        }

        public a(com.aide.ui.debugger.Debugger.a aVar) {
            this.DW = aVar;
        }

        public a(com.aide.ui.debugger.Debugger.b bVar) {
            this.FH = bVar;
        }
    }

    private class b extends l<a> {
        final /* synthetic */ DebugView j6;

        private b(DebugView debugView) {
            this.j6 = debugView;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.j6.getContext()).inflate(R.c.debugger_view_entry, viewGroup, false);
            }
            a aVar = (a) j6(i);
            TextView textView = (TextView) view.findViewById(R.b.debuggerEntryName);
            ImageView imageView = (ImageView) view.findViewById(R.b.debuggerEntryImage);
            String str;
            if (aVar.j6 != null) {
                String str2 = aVar.j6.j6;
                if (aVar.j6.DW.length() > 0) {
                    str = str2 + " = " + aVar.j6.DW;
                } else {
                    str = str2;
                }
                textView.setText(str.replace(" ", "\u00a0"), BufferType.SPANNABLE);
                DebugView.DW(textView, str2.length(), str.length(), this.j6.getResources().getColor(2131230745));
                if (aVar.j6.DW()) {
                    imageView.setImageResource(R.drawable.box_red);
                } else if (aVar.j6.j6()) {
                    imageView.setImageResource(R.drawable.objects);
                } else if (aVar.j6.FH()) {
                    imageView.setImageResource(R.drawable.box_light_blue);
                } else {
                    imageView.setImageResource(R.drawable.box_blue);
                }
            } else if (aVar.FH != null) {
                str = aVar.FH.DW;
                textView.setText(str.replace(" ", "\u00a0"), BufferType.SPANNABLE);
                DebugView.DW(textView, str.indexOf(41) + 1, str.length(), this.j6.getResources().getColor(2131230745));
                if (aVar.FH.j6()) {
                    imageView.setImageResource(R.drawable.box_pink);
                } else {
                    imageView.setImageResource(R.drawable.box_light_pink);
                }
            } else if (aVar.DW != null) {
                str = aVar.DW.DW;
                String str3 = str + ":" + aVar.DW.FH;
                textView.setText(str3.replace(" ", "\u00a0"), BufferType.SPANNABLE);
                DebugView.DW(textView, str.length(), str3.length(), this.j6.getResources().getColor(2131230745));
                imageView.setImageResource(R.drawable.debugger_breakpoint);
            } else if (aVar.Hw != null) {
                textView.setText(aVar.Hw, BufferType.SPANNABLE);
                DebugView.DW(textView, 0, aVar.Hw.length(), this.j6.getResources().getColor(2131230745));
                imageView.setImageResource(R.drawable.debugger_breakpoint);
            }
            return view;
        }
    }

    public DebugView(Context context) {
        super(context);
        DW();
    }

    public DebugView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DW();
    }

    private void DW() {
        LayoutInflater from = LayoutInflater.from(getContext());
        View inflate = from.inflate(R.c.debugger_view, null);
        removeAllViews();
        addView(inflate);
        ListView listView = getListView();
        listView.addHeaderView(from.inflate(R.c.browser_header, null), null, false);
        ListAdapter bVar = new b();
        this.j6 = bVar;
        listView.setAdapter(bVar);
        listView.setOnItemClickListener(new 1(this, listView));
        listView.setOnItemLongClickListener(new 2(this));
    }

    public void j6() {
        ListView listView = getListView();
        TextView textView = (TextView) listView.findViewById(R.b.browserHeaderLabel);
        ImageView imageView = (ImageView) listView.findViewById(R.b.browserHeaderIcon);
        ImageView imageView2 = (ImageView) listView.findViewById(R.b.browserHeaderMenuButton);
        if (e.Sf().u7()) {
            if (e.Sf().j3() != null) {
                if (e.Sf().j3().endsWith("()")) {
                    imageView.setImageResource(R.drawable.box_red);
                } else {
                    imageView.setImageResource(R.drawable.box_blue);
                }
                textView.setText(e.Sf().j3());
                imageView2.setVisibility(8);
            } else {
                imageView.setImageResource(R.drawable.debugger_suspended);
                String str = "at " + qh.Zo(e.Sf().J8());
                Object obj = str + ":" + e.Sf().Ws();
                textView.setText(obj, BufferType.SPANNABLE);
                DW(textView, str.length(), obj.length(), getResources().getColor(2131230745));
                imageView2.setVisibility(8);
            }
        } else if (e.Sf().we()) {
            imageView.setImageResource(R.drawable.debugger_run);
            textView.setText(R.f.view_debugger_running);
            imageView2.setVisibility(8);
        } else if (e.Sf().tp()) {
            imageView.setImageResource(R.drawable.debugger_stopped);
            textView.setText(R.f.view_debugger_stopped);
            imageView2.setVisibility(8);
        } else {
            imageView.setImageResource(R.drawable.debugger_stopped);
            textView.setText(R.f.view_debugger_not_running);
            imageView2.setVisibility(8);
        }
        List arrayList = new ArrayList();
        if (!e.Sf().u7() || e.Sf().j3() == null) {
            List QX = e.Sf().QX();
            if (QX.size() > 0) {
                arrayList.add(new a((com.aide.ui.debugger.Debugger.b) QX.get(0)));
            }
            for (c aVar : e.Sf().aM()) {
                arrayList.add(new a(aVar));
            }
            for (int i = 1; i < QX.size(); i++) {
                arrayList.add(new a((com.aide.ui.debugger.Debugger.b) QX.get(i)));
            }
            for (com.aide.ui.debugger.Debugger.a aVar2 : e.Sf().EQ()) {
                arrayList.add(new a(aVar2));
            }
            if (arrayList.size() == 0 && !e.Sf().we()) {
                arrayList.add(new a(getContext().getResources().getString(R.f.view_debugger_breakpoints_text)));
            }
        } else {
            for (c aVar3 : e.Sf().XL()) {
                arrayList.add(new a(aVar3));
            }
        }
        this.j6.j6(arrayList);
        if ((this.DW != null && !this.DW.equals(e.Sf().j3())) || (this.DW == null && e.Sf().j3() != null)) {
            this.DW = e.Sf().j3();
            listView.setSelection(0);
        }
    }

    private ListView getListView() {
        return (ListView) findViewById(R.b.debuggerEntryList);
    }

    private static void DW(TextView textView, int i, int i2, int i3) {
        ((Spannable) textView.getText()).setSpan(new ForegroundColorSpan(i3), i, i2, 33);
    }
}
