package com.aide.appwizard.runtime;

import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.n;
import android.support.v4.app.p;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.h;
import android.support.v4.widget.DrawerLayout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.aide.appwizard.runtime.a.b;
import com.aide.appwizard.runtime.a.c;
import com.aide.appwizard.runtime.a.d;
import com.aide.appwizard.runtime.a.e;
import com.aide.uidesigner.ProxyTextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class AppWizardActivity extends FragmentActivity {
    private android.support.v4.app.a EQ;
    private int J0;
    private int J8;
    private int Ws;
    private ViewPager tp;
    private a u7;
    private int we;

    class 1 extends Fragment {
        final /* synthetic */ AppWizardActivity DW;
        final /* synthetic */ c j6;

        1(AppWizardActivity appWizardActivity, c cVar) {
            this.DW = appWizardActivity;
            this.j6 = cVar;
        }

        public View j6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            if (this.j6.DW() != null) {
                return layoutInflater.inflate(this.DW.j6("layout", this.j6.DW()), viewGroup, false);
            }
            return new LinearLayout(this.DW);
        }
    }

    class 2 implements OnSystemUiVisibilityChangeListener {
        final /* synthetic */ AppWizardActivity j6;

        2(AppWizardActivity appWizardActivity) {
            this.j6 = appWizardActivity;
        }

        public void onSystemUiVisibilityChange(int i) {
            this.j6.getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }

    class 3 implements OnNavigationListener {
        final /* synthetic */ AppWizardActivity j6;

        3(AppWizardActivity appWizardActivity) {
            this.j6 = appWizardActivity;
        }

        public boolean onNavigationItemSelected(int i, long j) {
            this.j6.Zo().j6().DW(this.j6.we, this.j6.j6((c) this.j6.QX().tp().get(i))).j6();
            return true;
        }
    }

    class 4 implements OnNavigationListener {
        final /* synthetic */ AppWizardActivity j6;

        4(AppWizardActivity appWizardActivity) {
            this.j6 = appWizardActivity;
        }

        public boolean onNavigationItemSelected(int i, long j) {
            this.j6.Zo().j6().DW(this.j6.Ws, this.j6.j6((c) this.j6.QX().tp().get(i))).j6();
            return true;
        }
    }

    class 5 extends h {
        final /* synthetic */ AppWizardActivity j6;

        5(AppWizardActivity appWizardActivity) {
            this.j6 = appWizardActivity;
        }

        public void j6(int i) {
            this.j6.getActionBar().setSelectedNavigationItem(i);
        }
    }

    class 6 implements TabListener {
        final /* synthetic */ AppWizardActivity j6;

        6(AppWizardActivity appWizardActivity) {
            this.j6 = appWizardActivity;
        }

        public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
        }

        public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
            if (this.j6.tp != null) {
                this.j6.tp.setCurrentItem(tab.getPosition());
            }
        }

        public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
        }
    }

    static /* synthetic */ class 7 {
        static final /* synthetic */ int[] DW;
        static final /* synthetic */ int[] j6;

        static {
            DW = new int[d.values().length];
            try {
                DW[d.Tabs.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                DW[d.TabsDrawer.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                DW[d.Spinner.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                DW[d.SpinnerDrawer.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                DW[d.Slider.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                DW[d.SliderDrawer.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                DW[d.Single.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                DW[d.Drawer.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            j6 = new int[e.values().length];
            try {
                j6[e.HoloDark.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                j6[e.HoloLight.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                j6[e.HoloLightHoloActionBar.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                j6[e.HoloLightDarkActionBar.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                j6[e.DeviceDefault.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                j6[e.DeviceDefaultLight.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                j6[e.DeviceDefaultLightDarkActionBar.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    private class a extends p {
        final /* synthetic */ AppWizardActivity j6;

        public a(AppWizardActivity appWizardActivity, n nVar) {
            this.j6 = appWizardActivity;
            super(nVar);
        }

        public Fragment j6(int i) {
            return this.j6.j6((c) this.j6.QX().tp().get(i));
        }

        public int DW() {
            if (this.j6.QX().DW().j6()) {
                return this.j6.QX().tp().size() - 1;
            }
            return this.j6.QX().tp().size();
        }

        public CharSequence DW(int i) {
            return ((c) this.j6.QX().tp().get(i)).Hw();
        }
    }

    protected void j6(Document document, int i) {
    }

    protected Document tp() {
        try {
            InputStream open = getAssets().open("app.xml");
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(open);
            open.close();
            return parse;
        } catch (Exception e) {
            return null;
        }
    }

    protected Fragment j6(c cVar) {
        return new 1(this, cVar);
    }

    protected int EQ() {
        View linearLayout = new LinearLayout(this);
        linearLayout.setId(1000);
        setContentView(linearLayout);
        return linearLayout.getId();
    }

    public a Ws() {
        return this.u7;
    }

    public b QX() {
        return Ws().DW();
    }

    protected void onCreate(Bundle bundle) {
        this.u7 = new a(this);
        setTheme(VH());
        super.onCreate(bundle);
        getWindow().setSoftInputMode(2);
        J0();
    }

    private int VH() {
        switch (7.j6[QX().j6().ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return 16973931;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return 16973934;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return j6("style", "Theme_Holo_Light_Holo_ActionBar");
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return 16974105;
            case 6:
                return 16974123;
            case 7:
                return 16974143;
            default:
                return 16974120;
        }
    }

    private int j6(String str, String str2) {
        try {
            return ((Integer) Class.forName(getPackageName() + ".R$" + str).getField(str2).get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.EQ != null) {
            this.EQ.j6();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.EQ != null) {
            this.EQ.j6(configuration);
        }
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (this.EQ == null || !this.EQ.j6(menuItem)) {
            return super.onMenuItemSelected(i, menuItem);
        }
        return true;
    }

    public void J0() {
        int i = 0;
        this.EQ = null;
        this.tp = null;
        this.J0 = 1001;
        this.J8 = 1002;
        this.Ws = 1003;
        this.we = EQ();
        ViewGroup viewGroup = (ViewGroup) findViewById(this.we);
        getActionBar().setDisplayShowTitleEnabled(QX().Hw());
        setTitle(QX().FH());
        if (QX().Zo()) {
            getActionBar().show();
        } else {
            getActionBar().hide();
        }
        if (QX().gn()) {
            viewGroup.setSystemUiVisibility(4);
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new 2(this));
        } else {
            viewGroup.setSystemUiVisibility(0);
        }
        switch (7.DW[QX().DW().ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                getActionBar().setNavigationMode(2);
                getActionBar().setDisplayHomeAsUpEnabled(false);
                getActionBar().setHomeButtonEnabled(false);
                FH(viewGroup);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                getActionBar().setNavigationMode(2);
                FH(j6(viewGroup));
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                getActionBar().setNavigationMode(1);
                getActionBar().setDisplayHomeAsUpEnabled(false);
                getActionBar().setHomeButtonEnabled(false);
                getActionBar().removeAllTabs();
                List arrayList = new ArrayList();
                for (c Hw : QX().tp()) {
                    arrayList.add(Hw.Hw());
                }
                getActionBar().setListNavigationCallbacks(new ArrayAdapter(getActionBar().getThemedContext(), 17367043, 16908308, arrayList), new 3(this));
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                getActionBar().setNavigationMode(1);
                j6(viewGroup);
                getActionBar().removeAllTabs();
                List arrayList2 = new ArrayList();
                int size = QX().tp().size() - 1;
                while (i < size) {
                    arrayList2.add(((c) QX().tp().get(i)).Hw());
                    i++;
                }
                getActionBar().setListNavigationCallbacks(new ArrayAdapter(getActionBar().getThemedContext(), 17367043, 16908308, arrayList2), new 4(this));
            case 5:
                getActionBar().setNavigationMode(0);
                getActionBar().setDisplayHomeAsUpEnabled(false);
                getActionBar().setHomeButtonEnabled(false);
                DW(viewGroup);
            case 6:
                getActionBar().setNavigationMode(0);
                DW(j6(viewGroup));
            case 7:
                getActionBar().setNavigationMode(0);
                getActionBar().setDisplayHomeAsUpEnabled(false);
                getActionBar().setHomeButtonEnabled(false);
                if (QX().tp().size() > 0) {
                    Zo().j6().DW(this.we, j6((c) QX().tp().get(0))).j6();
                }
            case 8:
                getActionBar().setNavigationMode(0);
                j6(viewGroup);
                if (QX().tp().size() > 0) {
                    Zo().j6().DW(this.Ws, j6((c) QX().tp().get(0))).j6();
                }
            default:
        }
    }

    private ViewGroup j6(ViewGroup viewGroup) {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        View drawerLayout = new DrawerLayout(this);
        viewGroup.addView(drawerLayout, new LayoutParams(-1, -1));
        View frameLayout = new FrameLayout(this);
        frameLayout.setId(this.Ws);
        drawerLayout.addView(frameLayout, new DrawerLayout.LayoutParams(-1, -1));
        frameLayout = new LinearLayout(this);
        frameLayout.setId(this.J8);
        LayoutParams layoutParams = new DrawerLayout.LayoutParams((int) (240.0f * getResources().getDisplayMetrics().density), -1);
        layoutParams.j6 = 8388611;
        frameLayout.setDividerDrawable(new ColorDrawable(0));
        frameLayout.setBackgroundDrawable(j6(16842836));
        drawerLayout.addView(frameLayout, layoutParams);
        this.EQ = new android.support.v4.app.a(this, drawerLayout, j6("drawable", "ic_drawer"), 17039370, 17039370);
        drawerLayout.setDrawerListener(this.EQ);
        drawerLayout.Hw(3);
        List tp = QX().tp();
        if (tp.size() > 0) {
            Zo().j6().DW(this.J8, j6((c) tp.get(tp.size() - 1))).j6();
        }
        return drawerLayout;
    }

    private Drawable j6(int i) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            return getResources().getDrawable(typedValue.resourceId);
        }
        return new ColorDrawable(typedValue.data);
    }

    private void DW(ViewGroup viewGroup) {
        this.tp = new ViewPager(this);
        this.tp.setId(this.J0);
        viewGroup.addView(this.tp);
        View pagerTitleStrip = new PagerTitleStrip(this);
        pagerTitleStrip.setPadding(0, (int) (getResources().getDisplayMetrics().density * 4.0f), 0, (int) (getResources().getDisplayMetrics().density * 4.0f));
        LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -1;
        layoutParams.DW = 48;
        this.tp.addView(pagerTitleStrip, layoutParams);
        pagerTitleStrip.setTextColor(-1);
        pagerTitleStrip.setBackgroundColor(-13388315);
        this.tp.setAdapter(new a(this, Zo()));
    }

    private void FH(ViewGroup viewGroup) {
        int size;
        this.tp = new ViewPager(this);
        this.tp.setId(this.J0);
        viewGroup.addView(this.tp);
        this.tp.setAdapter(new a(this, Zo()));
        this.tp.setOnPageChangeListener(new 5(this));
        getActionBar().removeAllTabs();
        if (QX().DW().j6()) {
            size = QX().tp().size() - 1;
        } else {
            size = QX().tp().size();
        }
        for (int i = 0; i < size; i++) {
            getActionBar().addTab(getActionBar().newTab().setText(((c) QX().tp().get(i)).Hw()).setTabListener(new 6(this)));
        }
    }
}
