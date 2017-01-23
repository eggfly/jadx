package com.aide.uidesigner;

import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.aide.common.TextToSpeechHelper;
import com.aide.common.UndoManager;
import com.aide.common.c;
import com.aide.common.d;
import com.aide.common.m;
import com.aide.common.x;
import com.aide.common.y;
import com.aide.ui.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlLayoutDesignActivity extends Activity {
    private LinearLayout DW;
    private boolean EQ;
    private boolean FH;
    private android.support.v4.app.a Hw;
    private SoundPool J0;
    private int J8;
    private String VH;
    private UndoManager Zo;
    private String gn;
    private LinearLayout j6;
    private boolean tp;
    private boolean u7;
    private l v5;
    private TextToSpeechHelper we;

    class 10 implements Runnable {
        final /* synthetic */ XmlLayoutDesignActivity DW;
        final /* synthetic */ String j6;

        10(XmlLayoutDesignActivity xmlLayoutDesignActivity, String str) {
            this.DW = xmlLayoutDesignActivity;
            this.j6 = str;
        }

        public void run() {
            new File(this.j6).delete();
            if (this.DW.VH.equals(this.j6)) {
                this.DW.VH = d.Hw(this.DW.gn);
                if (this.DW.EQ) {
                    this.DW.Hw(this.DW.VH);
                }
                this.DW.v5();
                return;
            }
            this.DW.Zo();
        }
    }

    class 1 implements com.aide.analytics.b {
        final /* synthetic */ XmlLayoutDesignActivity j6;

        1(XmlLayoutDesignActivity xmlLayoutDesignActivity) {
            this.j6 = xmlLayoutDesignActivity;
        }

        public boolean j6() {
            if (this.j6.getPackageName().startsWith("com.aide.designer")) {
                return true;
            }
            return PreferenceManager.getDefaultSharedPreferences(this.j6).getBoolean("send_analytics_data", true);
        }
    }

    class 2 implements y<String> {
        final /* synthetic */ XmlLayoutDesignActivity j6;

        2(XmlLayoutDesignActivity xmlLayoutDesignActivity) {
            this.j6 = xmlLayoutDesignActivity;
        }

        public void j6(String str) {
            this.j6.DW(true);
            this.j6.VH = d.j6(this.j6.gn, str);
            if (this.j6.EQ) {
                this.j6.Hw(this.j6.VH);
            }
            this.j6.v5();
        }
    }

    class 3 implements OnNavigationListener {
        final /* synthetic */ XmlLayoutDesignActivity j6;

        3(XmlLayoutDesignActivity xmlLayoutDesignActivity) {
            this.j6 = xmlLayoutDesignActivity;
        }

        public boolean onNavigationItemSelected(int i, long j) {
            if (this.j6.FH && i != this.j6.u7()) {
                this.j6.j6(i);
            }
            return true;
        }
    }

    class 4 extends TranslateAnimation {
        final /* synthetic */ XmlLayoutDesignActivity DW;
        final /* synthetic */ View j6;

        4(XmlLayoutDesignActivity xmlLayoutDesignActivity, float f, float f2, float f3, float f4, View view) {
            this.DW = xmlLayoutDesignActivity;
            this.j6 = view;
            super(f, f2, f3, f4);
        }

        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            this.j6.invalidate();
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ XmlLayoutDesignActivity j6;

        5(XmlLayoutDesignActivity xmlLayoutDesignActivity) {
            this.j6 = xmlLayoutDesignActivity;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_TRAINER_ACTION", 1);
            this.j6.setResult(-1, intent);
            this.j6.finish();
        }
    }

    class 6 implements OnFocusChangeListener {
        final /* synthetic */ XmlLayoutDesignActivity DW;
        final /* synthetic */ TextView j6;

        6(XmlLayoutDesignActivity xmlLayoutDesignActivity, TextView textView) {
            this.DW = xmlLayoutDesignActivity;
            this.j6 = textView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                Animation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.0f, 1, 0.5f);
                scaleAnimation.setDuration((long) 400);
                scaleAnimation.setFillAfter(true);
                this.j6.startAnimation(scaleAnimation);
                return;
            }
            Animation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.0f, 1, 0.5f);
            scaleAnimation2.setDuration((long) 400);
            scaleAnimation2.setFillAfter(true);
            this.j6.startAnimation(scaleAnimation2);
        }
    }

    class 7 implements Runnable {
        final /* synthetic */ TranslateAnimation DW;
        final /* synthetic */ XmlLayoutDesignActivity FH;
        final /* synthetic */ View j6;

        7(XmlLayoutDesignActivity xmlLayoutDesignActivity, View view, TranslateAnimation translateAnimation) {
            this.FH = xmlLayoutDesignActivity;
            this.j6 = view;
            this.DW = translateAnimation;
        }

        public void run() {
            this.FH.j6();
            this.j6.setVisibility(0);
            this.j6.startAnimation(this.DW);
        }
    }

    class 8 implements OnItemClickListener {
        final /* synthetic */ XmlLayoutDesignActivity j6;

        8(XmlLayoutDesignActivity xmlLayoutDesignActivity) {
            this.j6 = xmlLayoutDesignActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a aVar = (a) adapterView.getItemAtPosition(i);
            if (aVar.FH != null) {
                this.j6.j6(aVar.FH);
            } else if (aVar.j6 != null) {
                this.j6.DW(aVar.j6.getPath());
            } else if (aVar.DW) {
                this.j6.VH();
            }
        }
    }

    class 9 extends l {
        private boolean DW;
        final /* synthetic */ XmlLayoutDesignActivity j6;

        class 1 implements y<b> {
            final /* synthetic */ 9 j6;

            1(9 9) {
                this.j6 = 9;
            }

            public void j6(b bVar) {
                this.j6.j6.v5.j6(bVar);
            }
        }

        9(XmlLayoutDesignActivity xmlLayoutDesignActivity, ViewGroup viewGroup, String str, String str2, UndoManager undoManager) {
            this.j6 = xmlLayoutDesignActivity;
            super(viewGroup, str, str2, undoManager);
            this.DW = true;
        }

        protected void j6(f fVar) {
            this.j6.j6(fVar);
        }

        protected void j6() {
            k.j6(this.j6, "Add...", new 1(this));
        }

        protected void j6(boolean z) {
            this.j6.invalidateOptionsMenu();
            if (this.j6.tp) {
                if (z && this.DW) {
                    this.DW = false;
                    c.j6(this.j6, 0, "unlock the UI designer", false, false);
                }
            } else if (this.j6.VH != null) {
                try {
                    FileWriter fileWriter = new FileWriter(this.j6.VH);
                    fileWriter.write(this.j6.v5.v5());
                    fileWriter.close();
                } catch (IOException e) {
                }
            }
        }

        protected void DW() {
            this.j6.DW.invalidate();
            if (Zo().size() > 0) {
                ((f) Zo().get(0)).requestFocus();
            }
            this.j6.Zo();
        }
    }

    private static class a {
        public boolean DW;
        public f FH;
        public File j6;

        public a(File file) {
            this.j6 = file;
        }

        public a(boolean z) {
            this.DW = true;
        }

        public a(f fVar) {
            this.FH = fVar;
        }
    }

    private class b extends ArrayAdapter<a> {
        final /* synthetic */ XmlLayoutDesignActivity j6;

        class 1 implements OnClickListener {
            final /* synthetic */ b DW;
            final /* synthetic */ a j6;

            1(b bVar, a aVar) {
                this.DW = bVar;
                this.j6 = aVar;
            }

            public void onClick(View view) {
                this.DW.j6.FH(this.j6.j6.getPath());
            }
        }

        public b(XmlLayoutDesignActivity xmlLayoutDesignActivity, Context context, List<a> list) {
            this.j6 = xmlLayoutDesignActivity;
            super(context, R.c.designer_viewlist_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2 = 0;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.c.designer_viewlist_entry, viewGroup, false);
            }
            a aVar = (a) getItem(i);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.b.designerViewlistentryViewLayout);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.b.designerViewlistentryFileLayout);
            ImageView imageView;
            if (aVar.FH != null) {
                int i3;
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
                linearLayout.setPadding((int) (((float) ((aVar.FH.getDepth() * 20) + 5)) * getContext().getResources().getDisplayMetrics().density), 0, 0, 0);
                ((TextView) view.findViewById(R.b.designerViewlistEntryName)).setText(aVar.FH.getNodeName());
                imageView = (ImageView) view.findViewById(R.b.designerViewlistEntryImage);
                if (aVar.FH.Hw()) {
                    i3 = R.drawable.objects;
                } else {
                    i3 = R.drawable.box_blue;
                }
                imageView.setImageResource(i3);
            } else if (aVar.j6 != null) {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
                linearLayout2.setPadding(0, 0, 0, 0);
                RadioButton radioButton = (RadioButton) view.findViewById(R.b.designerViewlistentryFileRadioButton);
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
                radioButton.setChecked(this.j6.VH.equals(aVar.j6.getPath()));
                radioButton.setVisibility(this.j6.u7 ? 0 : 8);
                TextView textView = (TextView) view.findViewById(R.b.designerViewlistentryFileName);
                textView.setText(aVar.j6.getName());
                if (this.j6.VH.equals(aVar.j6.getPath())) {
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    textView.setTypeface(Typeface.DEFAULT);
                }
                ((ImageView) view.findViewById(R.b.designerViewlistFileImage)).setImageResource(R.drawable.file_type_xml);
                imageView = (ImageView) view.findViewById(R.b.designerViewlistentryDelete);
                if (!this.j6.u7) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                imageView.setOnClickListener(new 1(this, aVar));
            } else {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
                linearLayout2.setPadding(0, 0, 0, (int) (10.0f * getContext().getResources().getDisplayMetrics().density));
                RadioButton radioButton2 = (RadioButton) view.findViewById(R.b.designerViewlistentryFileRadioButton);
                radioButton2.setFocusable(false);
                radioButton2.setFocusableInTouchMode(false);
                radioButton2.setVisibility(4);
                TextView textView2 = (TextView) view.findViewById(R.b.designerViewlistentryFileName);
                textView2.setText("New layout...");
                textView2.setTypeface(Typeface.DEFAULT);
                ((ImageView) view.findViewById(R.b.designerViewlistFileImage)).setImageResource(d.DW(getContext(), R.a.icon_add));
                ((ImageView) view.findViewById(R.b.designerViewlistentryDelete)).setVisibility(8);
            }
            return view;
        }
    }

    public static void j6(Activity activity, String str, String str2, boolean z, boolean z2) {
        Intent intent = new Intent(activity, XmlLayoutDesignActivity.class);
        intent.putExtra("EXTRA_FILE", str2);
        intent.putExtra("EXTRA_LANGUAGE", str);
        intent.putExtra("EXTRA_LICENSED", z);
        intent.putExtra("EXTRA_STANDALONE", z2);
        intent.putExtra("EXTRA_TRAINER", false);
        activity.startActivity(intent);
    }

    public static void j6(Activity activity, String str, String str2, int i, String[] strArr, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2) {
        Intent intent = new Intent(activity, XmlLayoutDesignActivity.class);
        intent.putExtra("EXTRA_FILE", str2);
        intent.putExtra("EXTRA_LANGUAGE", str);
        intent.putExtra("EXTRA_LICENSED", false);
        intent.putExtra("EXTRA_STANDALONE", false);
        intent.putExtra("EXTRA_TRAINER", true);
        intent.putExtra("EXTRA_TRAINER_SOUND", z2);
        intent.putExtra("EXTRA_TRAINER_TASK", str4);
        intent.putExtra("EXTRA_TRAINER_TITILE", str5);
        intent.putExtra("EXTRA_TRAINER_BUTTON", str6);
        intent.putExtra("EXTRA_HEADER", strArr);
        intent.putExtra("EXTRA_TRAINER_LOCALE", str3);
        intent.putExtra("EXTRA_TRAINER_SPEAK", z);
        intent.putExtra("EXTRA_TRAINER_RUN_BUTTON", str7);
        activity.startActivityForResult(intent, i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 3424345) {
            i.j6((Activity) this, intent);
        }
    }

    public static boolean j6(Intent intent) {
        return intent.getIntExtra("EXTRA_TRAINER_ACTION", 0) == 1;
    }

    public static boolean DW(Intent intent) {
        return intent.getIntExtra("EXTRA_TRAINER_ACTION", 0) == 2;
    }

    void j6(int i, int i2) {
        if (this.u7) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(this.VH)), "application/xml");
                startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                return;
            }
        }
        com.aide.common.a.j6(this, this.VH, i, i2);
    }

    public void j6(String str) {
        if (this.u7) {
            String str2 = "http://developer.android.com/reference/" + str;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
            startActivity(intent);
            return;
        }
        com.aide.common.b.j6(this, str, "");
    }

    protected void onCreate(Bundle bundle) {
        this.FH = false;
        if (!com.aide.analytics.a.j6()) {
            com.aide.analytics.a.j6((Context) this, new 1(this));
        }
        d.j6((Activity) this, getIntent().getStringExtra("EXTRA_LANGUAGE"));
        switch (u7()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                setTheme(R.g.ActivityThemeDesignerLight);
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                setTheme(R.g.ActivityThemeDesignerDark);
                break;
        }
        getWindow().setSoftInputMode(2);
        d.Hw((Activity) this);
        super.onCreate(bundle);
        setContentView(R.c.designer);
        d.DW((Activity) this);
        if (!FH()) {
            d.j6(findViewById(R.b.designerFrame));
        }
        if (FH() && d.DW((Context) this)) {
            getActionBar().hide();
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        if (FH()) {
            x.j6(getActionBar(), R.drawable.ic_launcher, getIntent().getStringArrayExtra("EXTRA_HEADER"));
        } else {
            getActionBar().setDisplayShowTitleEnabled(false);
            getActionBar().setNavigationMode(1);
            getActionBar().setListNavigationCallbacks(new ArrayAdapter(this, 17367049, new String[]{"Light Theme Small", "Dark Theme Small", "Light Theme", "Dark Theme"}), new 3(this));
            getActionBar().setSelectedNavigationItem(u7());
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.b.designerDrawer);
            this.Hw = new android.support.v4.app.a(this, drawerLayout, R.drawable.ic_drawer, 17039370, 17039370);
            drawerLayout.setDrawerListener(this.Hw);
        }
        if (FH()) {
            View findViewById = findViewById(R.b.designerHeaderLearnTask);
            findViewById.setVisibility(0);
            TextView textView = (TextView) findViewById.findViewById(R.b.designerHeaderLearnTaskText);
            TextView textView2 = (TextView) findViewById.findViewById(R.b.designerHeaderLearnTaskTitle);
            TextView textView3 = (TextView) findViewById.findViewById(R.b.designerHeaderLearnButton);
            textView2.setText(getIntent().getStringExtra("EXTRA_TRAINER_TITILE"));
            textView.setText(Html.fromHtml(getIntent().getStringExtra("EXTRA_TRAINER_TASK")));
            textView3.setText(getIntent().getStringExtra("EXTRA_TRAINER_BUTTON"));
            textView2.setTextSize(d.J8(this));
            textView.setTextSize(d.EQ(this));
            textView3.setTextSize(d.we(this));
            TranslateAnimation 4 = new 4(this, 0.0f, 0.0f, -(getResources().getDisplayMetrics().density * 150.0f), 0.0f, findViewById);
            4.setDuration(500);
            findViewById.setVisibility(4);
            findViewById(R.b.designerHeaderLearnTaskInner).setOnClickListener(new 5(this));
            findViewById(R.b.designerHeaderLearnTaskInner).setOnFocusChangeListener(new 6(this, textView3));
            if (DW()) {
                float f = getResources().getDisplayMetrics().density;
                findViewById(R.b.designerHeaderLearnTaskInner).setPadding((int) (48.0f * f), (int) (27.0f * f), (int) (48.0f * f), 0);
                findViewById(R.b.designerContent).setPadding((int) (48.0f * f), 0, (int) (48.0f * f), (int) (f * 27.0f));
            }
            findViewById.postDelayed(new 7(this, findViewById, 4), 500);
        } else {
            findViewById(R.b.designerHeaderLearnTask).setVisibility(8);
        }
        this.DW = new LinearLayout(this);
        ((ViewGroup) findViewById(R.b.designerContent)).addView(this.DW);
        this.DW.setClipChildren(false);
        this.DW.setGravity(17);
        this.j6 = new LinearLayout(this);
        this.DW.addView(this.j6);
        this.j6.setClipChildren(false);
        this.j6.setGravity(17);
        ((ListView) findViewById(R.b.designerViewList)).setOnItemClickListener(new 8(this));
        j6(bundle == null);
        if (bundle != null) {
            this.Zo.j6(bundle);
        }
        Hw();
        this.FH = true;
    }

    protected void j6() {
        if (getIntent().getBooleanExtra("EXTRA_TRAINER_SPEAK", false)) {
            this.we = new TextToSpeechHelper(this);
            this.we.j6(getIntent().getStringExtra("EXTRA_TRAINER_LOCALE"), getIntent().getStringExtra("EXTRA_TRAINER_TASK"));
        }
        if (getIntent().getBooleanExtra("EXTRA_TRAINER_SOUND", false)) {
            this.J0 = new SoundPool(1, 3, 0);
            this.J8 = this.J0.load(this, R.e.task, 1);
            this.J0.play(this.J8, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    private boolean DW() {
        return d.DW((Context) this) && FH();
    }

    private boolean FH() {
        return getIntent().getBooleanExtra("EXTRA_TRAINER", false);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.Hw != null) {
            this.Hw.j6();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.Hw != null) {
            this.Hw.j6(configuration);
        }
        Hw();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.Zo != null) {
            this.Zo.DW(bundle);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.Zo != null && this.v5 != null) {
            this.Zo.DW(this.v5);
        }
    }

    protected void onStart() {
        super.onStart();
        com.aide.analytics.a.j6((Activity) this, "Android UI Designer");
        File dir = getDir("installreferrerdata", 0);
        if ("com.aide.designer".equals(getPackageName())) {
            com.aide.analytics.a.j6("UI Designer installed", dir);
        }
    }

    protected void onStop() {
        super.onStop();
        com.aide.analytics.a.DW(this, "Android UI Designer");
    }

    private void Hw() {
        switch (u7()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                int i = getResources().getDisplayMetrics().heightPixels;
                int i2 = getResources().getDisplayMetrics().widthPixels;
                float f = getResources().getDisplayMetrics().density;
                this.j6.setLayoutParams(new LayoutParams(Math.min((int) (300.0f * f), (int) (((double) i2) * 0.8d)), Math.min((int) (f * 500.0f), (int) (((double) i) * 0.8d))));
                this.v5.DW(true);
            default:
                this.j6.setLayoutParams(new LayoutParams(-1, -1));
                this.v5.DW(false);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if ((intent.getFlags() & 1048576) == 0) {
            j6(false);
        }
    }

    private void j6(boolean z) {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        boolean z2 = extras != null && extras.getBoolean("EXTRA_LICENSED", false);
        this.tp = z2;
        if (extras == null || extras.getBoolean("EXTRA_STANDALONE", true)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.u7 = z2;
        if (!this.u7) {
            this.VH = extras.getString("EXTRA_FILE");
            this.gn = new File(this.VH).getParentFile().getParentFile().getPath();
            this.EQ = false;
        } else if (extras != null && "android.intent.action.SEND".equals(intent.getAction()) && (extras.get("android.intent.extra.STREAM") instanceof Uri)) {
            Uri uri = (Uri) extras.get("android.intent.extra.STREAM");
            this.gn = d.j6();
            this.EQ = true;
            this.VH = d.j6(this.gn, d.j6((Context) this, uri));
            Hw(this.VH);
            try {
                d.j6(getContentResolver().openInputStream(uri), new FileOutputStream(this.VH));
            } catch (IOException e) {
            }
        } else if (extras != null && "android.intent.action.SEND".equals(intent.getAction()) && extras.getString("android.intent.extra.TEXT") != null) {
            this.gn = d.j6();
            this.EQ = true;
            this.VH = d.j6(this.gn, d.j6(this.gn), extras.getString("android.intent.extra.TEXT"));
            Hw(this.VH);
        } else if (intent.getData() == null || intent.getData().getPath() == null) {
            this.gn = d.j6();
            this.EQ = true;
            this.VH = EQ();
            if (this.VH == null || !new File(this.VH).exists()) {
                this.VH = d.Hw(this.gn);
                Hw(this.VH);
            }
        } else {
            this.VH = intent.getData().getPath();
            this.gn = new File(this.VH).getParentFile().getParentFile().getPath();
            this.EQ = false;
        }
        if (this.u7 && z) {
            ((DrawerLayout) findViewById(R.b.designerDrawer)).Hw(3);
        }
        v5();
    }

    private void v5() {
        this.Zo = new UndoManager();
        this.v5 = new 9(this, this.j6, this.VH, this.gn, this.Zo);
        this.v5.Hw();
        this.v5.FH(gn());
        invalidateOptionsMenu();
    }

    private void Zo() {
        List<a> arrayList = new ArrayList();
        if (this.u7) {
            for (File aVar : d.FH(this.gn)) {
                arrayList.add(new a(aVar));
            }
            arrayList.add(new a(true));
        } else {
            arrayList.add(new a(new File(this.VH)));
        }
        for (f aVar2 : this.v5.Zo()) {
            arrayList.add(new a(aVar2));
        }
        ListView listView = (ListView) findViewById(R.b.designerViewList);
        b bVar = (b) listView.getAdapter();
        if (bVar == null) {
            listView.setAdapter(new b(this, this, arrayList));
            return;
        }
        bVar.clear();
        for (a add : arrayList) {
            bVar.add(add);
        }
    }

    private void j6(f fVar) {
        g.j6(this, fVar);
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.d.designer_options_menu, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.b.designerMenuRun).setVisible(FH());
        menu.findItem(R.b.designerMenuRun).setTitle(getIntent().getStringExtra("EXTRA_TRAINER_RUN_BUTTON"));
        MenuItem findItem = menu.findItem(R.b.designerMenuHideBorders);
        boolean z2 = !FH() && gn();
        findItem.setVisible(z2);
        findItem = menu.findItem(R.b.designerMenuShowBorders);
        if (FH() || gn()) {
            z2 = false;
        } else {
            z2 = true;
        }
        findItem.setVisible(z2);
        menu.findItem(R.b.designerMenuUndo).setEnabled(this.Zo.j6());
        menu.findItem(R.b.designerMenuRedo).setEnabled(this.Zo.DW());
        menu.findItem(R.b.designerMenuPaste).setEnabled(this.v5.VH());
        findItem = menu.findItem(R.b.designerMenuPaste);
        if (FH()) {
            z2 = false;
        } else {
            z2 = true;
        }
        findItem.setVisible(z2);
        findItem = menu.findItem(R.b.designerMenuCopy);
        if (this.tp || this.v5.v5().length() <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        findItem.setEnabled(z2);
        findItem = menu.findItem(R.b.designerMenuCopy);
        if (FH()) {
            z2 = false;
        } else {
            z2 = true;
        }
        findItem.setVisible(z2);
        findItem = menu.findItem(R.b.designerMenuShare);
        if (this.tp || this.v5.v5().length() <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        findItem.setEnabled(z2);
        MenuItem findItem2 = menu.findItem(R.b.designerMenuShare);
        if (!FH()) {
            z = true;
        }
        findItem2.setVisible(z);
        return true;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.Hw != null && this.Hw.j6(menuItem)) {
            return true;
        }
        if (menuItem.getItemId() == 16908332) {
            finish();
        } else if (menuItem.getItemId() == R.b.designerMenuRun) {
            com.aide.analytics.a.DW("UI Designer Menu: Run");
            Intent intent = new Intent();
            intent.putExtra("EXTRA_TRAINER_ACTION", 2);
            setResult(-1, intent);
            finish();
        } else if (menuItem.getItemId() == R.b.designerMenuShowBorders) {
            com.aide.analytics.a.DW("UI Designer Menu: Edit mode");
            DW(true);
        } else if (menuItem.getItemId() == R.b.designerMenuHideBorders) {
            com.aide.analytics.a.DW("UI Designer Menu: Preview mode");
            DW(false);
        } else if (menuItem.getItemId() == R.b.designerMenuUndo) {
            com.aide.analytics.a.DW("UI Designer Menu: Undo");
            this.Zo.Hw();
        } else if (menuItem.getItemId() == R.b.designerMenuRedo) {
            com.aide.analytics.a.DW("UI Designer Menu: Redo");
            this.Zo.FH();
        } else if (menuItem.getItemId() == R.b.designerMenuPaste) {
            com.aide.analytics.a.DW("UI Designer Menu: Paste");
            this.v5.gn();
        } else if (menuItem.getItemId() == R.b.designerMenuCopy) {
            com.aide.analytics.a.DW("UI Designer Menu: Copy");
            this.v5.tp();
        } else if (menuItem.getItemId() == R.b.designerMenuShare) {
            com.aide.analytics.a.DW("UI Designer Menu: Share");
            this.v5.EQ();
        }
        return false;
    }

    private void FH(String str) {
        m.DW(this, "Delete Layout " + new File(str).getName(), "Really delete this layout?", new 10(this, str), null);
    }

    private void VH() {
        m.j6((Activity) this, "New Layout", "File name:", d.j6(this.gn), new 2(this));
    }

    protected void DW(String str) {
        this.VH = str;
        if (this.EQ) {
            Hw(this.VH);
        }
        v5();
    }

    private boolean gn() {
        if (FH()) {
            return true;
        }
        return tp().getBoolean("PREF_XMLDESIGNER_EDITMODE", true);
    }

    private void DW(boolean z) {
        Editor edit = tp().edit();
        edit.putBoolean("PREF_XMLDESIGNER_EDITMODE", z);
        edit.commit();
        invalidateOptionsMenu();
        this.v5.FH(z);
        Hw();
        this.DW.invalidate();
    }

    private int u7() {
        if (FH()) {
            return 2;
        }
        return tp().getInt("XMLDESIGNER_VIEW", 0);
    }

    private void j6(int i) {
        Editor edit = tp().edit();
        edit.putInt("XMLDESIGNER_VIEW", i);
        edit.commit();
        recreate();
    }

    private SharedPreferences tp() {
        return getSharedPreferences("UIDesigner", 0);
    }

    private String EQ() {
        return tp().getString("PREF_XMLDESIGNER_FILE", null);
    }

    private void Hw(String str) {
        Editor edit = tp().edit();
        edit.putString("PREF_XMLDESIGNER_FILE", str);
        edit.commit();
    }
}
