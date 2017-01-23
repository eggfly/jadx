package com.dev.system.monitor;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.dev.system.monitor.SystemBarTintManager.SystemBarConfig;
import com.fortysevendeg.swipelistview.C0149R;
import com.github.amlcurran.showcaseview.C0158R;
import it.gmariotti.cardslib.library.internal.Card;
import java.util.ArrayList;
import uk.me.lewisdeane.lnavigationdrawer.NavigationItem;
import uk.me.lewisdeane.lnavigationdrawer.NavigationListView;
import uk.me.lewisdeane.lnavigationdrawer.NavigationListView.NavigationItemClickListener;

public class MainActivity extends Activity {
    private DrawerArrowDrawable drawerArrow;
    private DrawerLayout drawerLayout;
    private CharSequence drawerTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private TypedArray navMenuIcons;
    private String[] navMenuTitles;
    private NavigationListView navigationListView;

    /* renamed from: com.dev.system.monitor.MainActivity.1 */
    class C01201 implements OnClickListener {
        C01201() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.dev.system.monitor.pro")));
        }
    }

    /* renamed from: com.dev.system.monitor.MainActivity.2 */
    class C01212 implements OnClickListener {
        C01212() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }

    /* renamed from: com.dev.system.monitor.MainActivity.3 */
    class C02423 implements NavigationItemClickListener {
        C02423() {
        }

        public void onNavigationItemSelected(String item, ArrayList<NavigationItem> arrayList, int position) {
            Fragment fragment = null;
            switch (position) {
                case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                    fragment = new HomeFragment();
                    break;
                case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                    fragment = new WiFiManagement();
                    break;
                case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                    fragment = new MobileManagement();
                    break;
                case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                    fragment = new BluetoothManagement();
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY /*4*/:
                    fragment = new GPSManagement();
                    break;
                case FragmentManagerImpl.ANIM_STYLE_FADE_ENTER /*5*/:
                    fragment = new StorageManagement();
                    break;
                case FragmentManagerImpl.ANIM_STYLE_FADE_EXIT /*6*/:
                    fragment = new CPUManagement();
                    break;
                case C0158R.styleable.ShowcaseView_sv_titleTextAppearance /*7*/:
                    fragment = new RAMManagement();
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    fragment = new GPUManagement();
                    break;
                case C0158R.styleable.ShowcaseView_sv_tintButtonColor /*9*/:
                    fragment = new SensorManagement();
                    break;
                case Card.CLICK_LISTENER_CONTENT_VIEW /*10*/:
                    fragment = new AppManagement();
                    break;
                case C0149R.styleable.SwipeListView_swipeDrawableUnchecked /*11*/:
                    fragment = new BatteryManagement();
                    break;
                case C0149R.styleable.MenuItem_android_onClick /*12*/:
                    fragment = new SystemInfoManagement();
                    break;
            }
            if (fragment != null) {
                MainActivity.this.getFragmentManager().beginTransaction().replace(C0133R.id.frame_container, fragment).commit();
                MainActivity.this.navigationListView.setItemChecked(position, true);
                MainActivity.this.navigationListView.setSelection(position);
                MainActivity.this.drawerLayout.closeDrawer(MainActivity.this.navigationListView);
            }
        }
    }

    /* renamed from: com.dev.system.monitor.MainActivity.4 */
    class C02434 extends DrawerArrowDrawable {
        C02434(Context context) {
            super(context);
        }

        public boolean isLayoutRtl() {
            return false;
        }
    }

    /* renamed from: com.dev.system.monitor.MainActivity.5 */
    class C02685 extends ActionBarDrawerToggle {
        C02685(Activity activity, DrawerLayout drawerLayout, DrawerArrowDrawable drawerImage, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
            super(activity, drawerLayout, drawerImage, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);
            MainActivity.this.invalidateOptionsMenu();
        }

        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            MainActivity.this.invalidateOptionsMenu();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(8);
        getWindow().requestFeature(10);
        if (VERSION.SDK_INT >= 19) {
            getWindow().setFlags(67108864, 67108864);
            getWindow().setFlags(134217728, 134217728);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setNavigationBarTintEnabled(true);
            tintManager.setTintStatusBarColor(Color.parseColor("#318CE7"));
            tintManager.setTintNavigationBarColor(Color.parseColor("#ff000000"));
        }
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#318CE7")));
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#318CE7")));
        setContentView(C0133R.layout.activity_main);
        boolean firstrun = getSharedPreferences("PREFERENCE", 0).getBoolean("firstrun", true);
        int runs = getSharedPreferences("PREFERENCE", 0).getInt("RUNS", 0);
        if (runs % 6 == 0) {
            Builder builder = new Builder(this);
            builder.setTitle("System Monitor Pro is available!");
            builder.setMessage("Check it out!");
            builder.setPositiveButton("Yes!", new C01201());
            builder.setNegativeButton("Later", new C01212());
            builder.show();
        }
        getSharedPreferences("PREFERENCE", 0).edit().putInt("RUNS", runs + 1).apply();
        this.navMenuTitles = getResources().getStringArray(C0133R.array.nav_drawer_items);
        this.navMenuIcons = getResources().obtainTypedArray(C0133R.array.nav_drawer_icons);
        this.drawerLayout = (DrawerLayout) findViewById(C0133R.id.drawer_layout);
        this.navigationListView = (NavigationListView) findViewById(C0133R.id.list_slidermenu);
        this.navigationListView.setBackgroundColor(-1);
        if (VERSION.SDK_INT >= 19) {
            SystemBarConfig config = new SystemBarTintManager(this).getConfig();
            this.navigationListView.setPadding(0, config.getPixelInsetTop(true), config.getPixelInsetRight(), config.getPixelInsetBottom());
        }
        for (int i = 0; i < this.navMenuTitles.length; i++) {
            this.navigationListView.addNavigationItem(this.navMenuTitles[i], this.navMenuIcons.getResourceId(i, -1), false);
        }
        this.navigationListView.setNavigationItemClickListener(new C02423());
        this.navMenuIcons.recycle();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        this.drawerArrow = new C02434(this);
        this.mDrawerToggle = new C02685(this, this.drawerLayout, this.drawerArrow, C0133R.string.drawer_open, C0133R.string.drawer_close);
        this.drawerLayout.setDrawerListener(this.mDrawerToggle);
        this.drawerLayout.setFocusableInTouchMode(false);
        this.mDrawerToggle.syncState();
        this.mDrawerToggle.setAnimateEnabled(true);
        this.mDrawerToggle.syncState();
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(C0133R.id.frame_container, new HomeFragment()).commit();
            this.navigationListView.setItemChecked(0, true);
            this.navigationListView.setSelection(0);
            this.drawerLayout.closeDrawer(this.navigationListView);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0133R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case C0133R.id.action_settings:
                startActivity(new Intent(this, AppInfo.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(C0133R.id.action_settings).setVisible(!this.drawerLayout.isDrawerOpen(this.navigationListView));
        return super.onPrepareOptionsMenu(menu);
    }

    public void setTitle(CharSequence title) {
        getActionBar().setTitle(title);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.mDrawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(this.navigationListView)) {
            finish();
        } else {
            this.drawerLayout.openDrawer(this.navigationListView);
        }
    }
}
