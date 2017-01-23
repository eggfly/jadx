package com.aide.appwizard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.aide.analytics.b;
import com.aide.appwizard.runtime.AppWizardActivity;
import com.aide.appwizard.runtime.a.c;
import com.aide.common.UndoManager;
import com.aide.common.UndoManager.a;
import com.aide.common.m;
import com.aide.common.o;
import com.aide.ui.R;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import org.w3c.dom.Document;

public class AppWizardDesignActivity extends AppWizardActivity implements a {
    private boolean EQ;
    private UndoManager tp;
    private b u7;

    class 1 implements b {
        final /* synthetic */ AppWizardDesignActivity j6;

        1(AppWizardDesignActivity appWizardDesignActivity) {
            this.j6 = appWizardDesignActivity;
        }

        public boolean j6() {
            return false;
        }
    }

    class 2 implements OnClickListener {
        final /* synthetic */ AppWizardDesignActivity j6;

        2(AppWizardDesignActivity appWizardDesignActivity) {
            this.j6 = appWizardDesignActivity;
        }

        public void onClick(View view) {
            this.j6.DW(!this.j6.we());
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ AppWizardDesignActivity j6;

        3(AppWizardDesignActivity appWizardDesignActivity) {
            this.j6 = appWizardDesignActivity;
        }

        public void onClick(View view) {
            this.j6.u7.j6();
        }
    }

    class 4 implements OnClickListener {
        final /* synthetic */ AppWizardDesignActivity j6;

        4(AppWizardDesignActivity appWizardDesignActivity) {
            this.j6 = appWizardDesignActivity;
        }

        public void onClick(View view) {
            this.j6.tp.Hw();
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ AppWizardDesignActivity j6;

        5(AppWizardDesignActivity appWizardDesignActivity) {
            this.j6 = appWizardDesignActivity;
        }

        public void onClick(View view) {
            this.j6.tp.FH();
        }
    }

    public AppWizardDesignActivity() {
        this.u7 = new b(this);
    }

    public String VH() {
        return gn() + "/res";
    }

    public String j6(String str) {
        if (str != null) {
            return VH() + "/layout/" + str + ".xml";
        }
        return null;
    }

    public String j6(int i) {
        c j6 = QX().j6(i);
        String str = "fragment" + (i + 1);
        j6.j6(str);
        return j6(str);
    }

    private String XL() {
        return gn() + "/assets/app.xml";
    }

    public String gn() {
        return d.j6() + "/AppProjects/AppWizard";
    }

    public void j6(String str, String str2, int i) {
        if (str.equals(XL())) {
            try {
                FH(str2);
                Ws().j6(DW(str2), i);
            } catch (Exception e) {
            }
        }
    }

    public void u7() {
        if (this.EQ) {
            j3();
        }
    }

    protected Document tp() {
        try {
            String j6 = d.j6(XL());
            this.tp.j6(XL(), j6, 0);
            return DW(j6);
        } catch (Exception e) {
            return null;
        }
    }

    private Document DW(String str) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        Document j6 = o.j6(byteArrayInputStream);
        byteArrayInputStream.close();
        return j6;
    }

    protected void j6(Document document, int i) {
        try {
            String j6 = new c().j6(document);
            this.tp.DW(XL(), j6, i);
            new File(XL()).getParentFile().mkdirs();
            FH(j6);
        } catch (Exception e) {
        }
    }

    private void FH(String str) {
        FileWriter fileWriter = new FileWriter(XL());
        fileWriter.write(str);
        fileWriter.close();
    }

    protected int EQ() {
        setContentView(R.c.appwizard);
        return R.b.appwizardContentContainer;
    }

    protected Fragment j6(c cVar) {
        return a.j6(cVar);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tp != null) {
            this.tp.DW((a) this);
        }
    }

    protected void onCreate(Bundle bundle) {
        Log.d(getPackageName(), "onCreate()");
        if (!com.aide.analytics.a.j6()) {
            com.aide.analytics.a.j6((Context) this, new 1(this));
        }
        this.tp = new UndoManager();
        this.tp.j6((a) this);
        if (bundle != null) {
            this.tp.j6(bundle);
        }
        super.onCreate(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.tp != null) {
            this.tp.DW(bundle);
        }
    }

    public boolean we() {
        return getSharedPreferences("AppWizard", 0).getBoolean("PREF_APPWIZARD_EDITMODE", true);
    }

    private void DW(boolean z) {
        Editor edit = getSharedPreferences("AppWizard", 0).edit();
        edit.putBoolean("PREF_APPWIZARD_EDITMODE", z);
        edit.commit();
        for (Fragment fragment : Zo().Hw()) {
            if (fragment instanceof a) {
                ((a) fragment).j6();
            }
        }
        j3();
    }

    private void aM() {
        j3();
        findViewById(R.b.appwizardModeButton).setOnClickListener(new 2(this));
        findViewById(R.b.appwizardEditButton).setOnClickListener(new 3(this));
        findViewById(R.b.appwizardUndoButton).setOnClickListener(new 4(this));
        findViewById(R.b.appwizardRedoButton).setOnClickListener(new 5(this));
    }

    private void j3() {
        ImageView imageView = (ImageView) findViewById(R.b.appwizardModeButton);
        if (we()) {
            imageView.setImageResource(R.drawable.ic_menu_edit);
        } else {
            imageView.setImageResource(R.drawable.ic_menu_view);
        }
        findViewById(R.b.appwizardEditButtonLayout).setVisibility(we() ? 0 : 8);
        findViewById(R.b.appwizardUndoButton).setEnabled(this.tp.j6());
        findViewById(R.b.appwizardRedoButton).setEnabled(this.tp.DW());
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void J0() {
        super.J0();
        this.EQ = true;
        aM();
    }

    public UndoManager J8() {
        return this.tp;
    }
}
