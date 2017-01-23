package com.aide.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import com.aide.common.b;
import com.aide.common.p;
import com.aide.engine.SourceEntity;
import com.aide.ui.R;
import com.aide.ui.ThemedGotoActivity;
import com.aide.ui.e;
import com.aide.ui.j;
import com.aide.uidesigner.ProxyTextView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import qg;

public class GotoBrowserActivity extends ThemedGotoActivity {
    private static CharSequence FH;
    private static int j6;
    private p DW;

    class 1 extends com.aide.engine.service.f.a {
        final /* synthetic */ GotoBrowserActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.j6(false, null, null);
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ String DW;
            final /* synthetic */ 1 FH;
            final /* synthetic */ List j6;

            2(1 1, List list, String str) {
                this.FH = 1;
                this.j6 = list;
                this.DW = str;
            }

            public void run() {
                this.FH.j6.j6(false, this.j6, this.DW);
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ SourceEntity j6;

            3(1 1, SourceEntity sourceEntity) {
                this.DW = 1;
                this.j6 = sourceEntity;
            }

            public void run() {
                this.DW.j6.j6(this.j6.J0(), this.j6.u7(), this.j6.tp(), this.j6.u7(), this.j6.EQ());
            }
        }

        1(GotoBrowserActivity gotoBrowserActivity) {
            this.j6 = gotoBrowserActivity;
        }

        public void j6(String str) {
            this.j6.runOnUiThread(new 1(this));
        }

        public void j6(String str, List list) {
            this.j6.runOnUiThread(new 2(this, list, str));
        }

        public void j6(SourceEntity sourceEntity) {
            this.j6.runOnUiThread(new 3(this, sourceEntity));
        }
    }

    class 2 implements TextWatcher {
        final /* synthetic */ GotoBrowserActivity j6;

        2(GotoBrowserActivity gotoBrowserActivity) {
            this.j6 = gotoBrowserActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.j6.DW();
        }
    }

    class 3 implements OnCheckedChangeListener {
        final /* synthetic */ GotoBrowserActivity j6;

        3(GotoBrowserActivity gotoBrowserActivity) {
            this.j6 = gotoBrowserActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.j6.j6();
            this.j6.DW();
        }
    }

    class 4 implements OnClickListener {
        final /* synthetic */ GotoBrowserActivity j6;

        4(GotoBrowserActivity gotoBrowserActivity) {
            this.j6 = gotoBrowserActivity;
        }

        public void onClick(View view) {
            this.j6.finish();
        }
    }

    class 5 implements OnItemClickListener {
        final /* synthetic */ GotoBrowserActivity DW;
        final /* synthetic */ ListView j6;

        5(GotoBrowserActivity gotoBrowserActivity, ListView listView) {
            this.DW = gotoBrowserActivity;
            this.j6 = listView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.DW.DW.j6();
            e.XL().j6((SourceEntity) this.j6.getItemAtPosition(i));
        }
    }

    class 6 implements OnItemLongClickListener {
        final /* synthetic */ GotoBrowserActivity DW;
        final /* synthetic */ ListView j6;

        6(GotoBrowserActivity gotoBrowserActivity, ListView listView) {
            this.DW = gotoBrowserActivity;
            this.j6 = listView;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SourceEntity sourceEntity = (SourceEntity) this.j6.getItemAtPosition(i);
            if (sourceEntity == null || sourceEntity.QX() == null) {
                return false;
            }
            e.u7().sh().QX();
            b.j6(e.u7(), sourceEntity.QX(), a.EQ().toString());
            return true;
        }
    }

    class 7 implements Comparator<SourceEntity> {
        final /* synthetic */ GotoBrowserActivity DW;
        final /* synthetic */ String j6;

        7(GotoBrowserActivity gotoBrowserActivity, String str) {
            this.DW = gotoBrowserActivity;
            this.j6 = str;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((SourceEntity) obj, (SourceEntity) obj2);
        }

        public int j6(SourceEntity sourceEntity, SourceEntity sourceEntity2) {
            boolean startsWith = sourceEntity.J8().toLowerCase().startsWith(this.j6.toLowerCase());
            boolean startsWith2 = sourceEntity2.J8().toLowerCase().startsWith(this.j6.toLowerCase());
            if (startsWith && !startsWith2) {
                return -1;
            }
            if (startsWith || !startsWith2) {
                return sourceEntity.J8().compareTo(sourceEntity2.J8());
            }
            return 1;
        }
    }

    static /* synthetic */ class 8 {
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
                j6[com.aide.engine.SourceEntity.a.Class.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[com.aide.engine.SourceEntity.a.File.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[com.aide.engine.SourceEntity.a.Package.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private class a extends ArrayAdapter<SourceEntity> {
        final /* synthetic */ GotoBrowserActivity j6;

        class 1 implements OnClickListener {
            final /* synthetic */ a DW;
            final /* synthetic */ String j6;

            1(a aVar, String str) {
                this.DW = aVar;
                this.j6 = str;
            }

            public void onClick(View view) {
                e.u7().sh().QX();
                b.j6(e.u7(), this.j6, a.EQ().toString());
            }
        }

        public a(GotoBrowserActivity gotoBrowserActivity, Context context, List<SourceEntity> list) {
            this.j6 = gotoBrowserActivity;
            super(context, R.c.gotobrowser_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.c.gotobrowser_entry, viewGroup, false);
            }
            SourceEntity sourceEntity = (SourceEntity) getItem(i);
            ImageView imageView = (ImageView) view.findViewById(R.b.gotobrowserEntryImage);
            switch (8.j6[sourceEntity.DW().ordinal()]) {
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
                    imageView.setImageResource(R.drawable.objects);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    imageView.setImageResource(j.j6(sourceEntity.J0()));
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.pakage);
                    break;
                default:
                    imageView.setImageResource(R.drawable.browser_empty);
                    break;
            }
            ((TextView) view.findViewById(R.b.gotobrowserEntryName)).setText(this.j6.DW(sourceEntity));
            ((TextView) view.findViewById(R.b.gotobrowserEntryContainerName)).setText(this.j6.j6(sourceEntity));
            View findViewById = view.findViewById(R.b.gotobrowserHelpButton);
            String QX = sourceEntity.QX();
            findViewById.setVisibility(QX != null ? 0 : 8);
            if (QX != null) {
                findViewById.setOnClickListener(new 1(this, QX));
            }
            return view;
        }
    }

    public GotoBrowserActivity() {
        this.DW = new p(this, "Analyzing...");
    }

    static {
        j6 = 50;
    }

    public static void j6(Activity activity, boolean z, int i) {
        Intent intent = new Intent(activity, GotoBrowserActivity.class);
        intent.putExtra("EXTRA_SYMBOLS", z);
        activity.startActivityForResult(intent, i);
    }

    public static void j6(Intent intent) {
        e.u7().j6(new qg(intent.getExtras().getString("FILEPATH"), intent.getExtras().getInt("STARTLINE_EXTRA"), intent.getExtras().getInt("STARTCOLUMN_EXTRA"), intent.getExtras().getInt("ENDLINE_EXTRA"), intent.getExtras().getInt("ENDCOLUMN_EXTRA")));
    }

    private void j6(String str, int i, int i2, int i3, int i4) {
        this.DW.DW();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(((EditText) findViewById(R.b.gotobrowserSearchBox)).getWindowToken(), 0);
        Intent intent = new Intent();
        intent.putExtra("FILEPATH", str);
        intent.putExtra("STARTLINE_EXTRA", i);
        intent.putExtra("STARTCOLUMN_EXTRA", i2);
        intent.putExtra("ENDLINE_EXTRA", i3);
        intent.putExtra("ENDCOLUMN_EXTRA", i4);
        setResult(-1, intent);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        setContentView(R.c.gotobrowser);
        e.XL().j6(new 1(this));
        EditText editText = (EditText) findViewById(R.b.gotobrowserSearchBox);
        editText.addTextChangedListener(new 2(this));
        if (FH != null) {
            editText.setText(FH);
        }
        editText.selectAll();
        Switch switchR = (Switch) findViewById(R.b.gotobrowserSwitch);
        if (getIntent().getExtras().getBoolean("EXTRA_SYMBOLS", true)) {
            z = false;
        }
        switchR.setChecked(z);
        switchR.setOnCheckedChangeListener(new 3(this));
        findViewById(R.b.gotobrowserBackground).setOnClickListener(new 4(this));
        j6();
        DW();
    }

    private void j6() {
        j6(true, null, null);
    }

    protected void onStart() {
        super.onStart();
        com.aide.analytics.a.j6((Activity) this, "Goto Browser");
    }

    protected void onStop() {
        FH = ((EditText) findViewById(R.b.gotobrowserSearchBox)).getText();
        super.onStop();
        com.aide.analytics.a.DW(this, "Goto Browser");
    }

    private void DW() {
        Object obj = !((Switch) findViewById(R.b.gotobrowserSwitch)).isChecked() ? 1 : null;
        String trim = ((EditText) findViewById(R.b.gotobrowserSearchBox)).getText().toString().trim();
        if (obj != null) {
            e.XL().j6(trim, j6);
        } else {
            e.XL().DW(trim, j6);
        }
    }

    private void j6(boolean z, List<SourceEntity> list, String str) {
        if (z) {
            findViewById(R.b.gotobrowserMessage).setVisibility(8);
            findViewById(R.b.gotobrowserSymbolList).setVisibility(8);
            findViewById(R.b.gotobrowserProgress).setVisibility(0);
        } else if (list == null) {
            findViewById(R.b.gotobrowserMessage).setVisibility(0);
            findViewById(R.b.gotobrowserSymbolList).setVisibility(8);
            findViewById(R.b.gotobrowserProgress).setVisibility(8);
            ((TextView) findViewById(R.b.gotobrowserMessage)).setText("> " + j6 + " matching items");
        } else if (list.size() == 0) {
            findViewById(R.b.gotobrowserMessage).setVisibility(0);
            findViewById(R.b.gotobrowserSymbolList).setVisibility(8);
            findViewById(R.b.gotobrowserProgress).setVisibility(8);
            ((TextView) findViewById(R.b.gotobrowserMessage)).setText("No matching items");
        } else {
            findViewById(R.b.gotobrowserMessage).setVisibility(8);
            findViewById(R.b.gotobrowserSymbolList).setVisibility(0);
            findViewById(R.b.gotobrowserProgress).setVisibility(8);
            j6((List) list, str);
            ListView listView = (ListView) findViewById(R.b.gotobrowserSymbolList);
            listView.setAdapter(new a(this, this, list));
            listView.setOnItemClickListener(new 5(this, listView));
            listView.setOnItemLongClickListener(new 6(this, listView));
        }
    }

    private void j6(List<SourceEntity> list, String str) {
        Collections.sort(list, new 7(this, str));
    }

    private String j6(SourceEntity sourceEntity) {
        if (sourceEntity.DW() == com.aide.engine.SourceEntity.a.File) {
            return sourceEntity.Ws();
        }
        return sourceEntity.we();
    }

    private String DW(SourceEntity sourceEntity) {
        String str = "" + sourceEntity.J8();
        if (sourceEntity.DW() == com.aide.engine.SourceEntity.a.Method) {
            return str + "()";
        }
        return str;
    }
}
