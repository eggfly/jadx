package com.dev.system.monitor;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

public class ActionBarDrawerToggle extends android.support.v4.app.ActionBarDrawerToggle {
    private static final String TAG;
    protected boolean animateEnabled;
    protected Activity mActivity;
    protected int mCloseDrawerContentDescRes;
    protected DrawerArrowDrawable mDrawerImage;
    protected DrawerLayout mDrawerLayout;
    protected int mOpenDrawerContentDescRes;

    static {
        TAG = ActionBarDrawerToggle.class.getName();
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int drawerImageRes, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes, closeDrawerContentDescRes);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, DrawerArrowDrawable drawerImage, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        super(activity, drawerLayout, C0133R.drawable.ic_drawer, openDrawerContentDescRes, closeDrawerContentDescRes);
        this.mActivity = activity;
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = openDrawerContentDescRes;
        this.mCloseDrawerContentDescRes = closeDrawerContentDescRes;
        this.mDrawerImage = drawerImage;
        this.animateEnabled = true;
    }

    public void syncState() {
        if (this.mDrawerImage == null) {
            super.syncState();
            return;
        }
        if (this.animateEnabled) {
            if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
                this.mDrawerImage.setProgress(1.0f);
            } else {
                this.mDrawerImage.setProgress(0.0f);
            }
        }
        setActionBarUpIndicator();
        setActionBarDescription();
    }

    public void setDrawerIndicatorEnabled(boolean enable) {
        if (this.mDrawerImage == null) {
            super.setDrawerIndicatorEnabled(enable);
            return;
        }
        setActionBarUpIndicator();
        setActionBarDescription();
    }

    public boolean isDrawerIndicatorEnabled() {
        if (this.mDrawerImage == null) {
            return super.isDrawerIndicatorEnabled();
        }
        return true;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (this.mDrawerImage == null) {
            super.onConfigurationChanged(newConfig);
        } else {
            syncState();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onDrawerSlide(View drawerView, float slideOffset) {
        if (this.mDrawerImage == null) {
            super.onDrawerSlide(drawerView, slideOffset);
        } else if (this.animateEnabled) {
            this.mDrawerImage.setVerticalMirror(!this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START));
            this.mDrawerImage.setProgress(slideOffset);
        }
    }

    public void onDrawerOpened(View drawerView) {
        if (this.mDrawerImage == null) {
            super.onDrawerOpened(drawerView);
            return;
        }
        if (this.animateEnabled) {
            this.mDrawerImage.setProgress(1.0f);
        }
        setActionBarDescription();
    }

    public void onDrawerClosed(View drawerView) {
        if (this.mDrawerImage == null) {
            super.onDrawerClosed(drawerView);
            return;
        }
        if (this.animateEnabled) {
            this.mDrawerImage.setProgress(0.0f);
        }
        setActionBarDescription();
    }

    protected void setActionBarUpIndicator() {
        if (this.mActivity != null) {
            try {
                ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class}).invoke(this.mActivity.getActionBar(), new Object[]{this.mDrawerImage});
            } catch (Exception e) {
                View home = this.mActivity.findViewById(16908332);
                if (home != null) {
                    ViewGroup parent = (ViewGroup) home.getParent();
                    if (parent.getChildCount() == 2) {
                        View up;
                        View first = parent.getChildAt(0);
                        View second = parent.getChildAt(1);
                        if (first.getId() == 16908332) {
                            up = second;
                        } else {
                            up = first;
                        }
                        if (up instanceof ImageView) {
                            ((ImageView) up).setImageDrawable(this.mDrawerImage);
                        }
                    }
                }
            }
        }
    }

    protected void setActionBarDescription() {
        if (this.mActivity != null && this.mActivity.getActionBar() != null) {
            try {
                Method setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
                ActionBar actionBar = this.mActivity.getActionBar();
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START) ? this.mOpenDrawerContentDescRes : this.mCloseDrawerContentDescRes);
                setHomeActionContentDescription.invoke(actionBar, objArr);
                if (VERSION.SDK_INT <= 19) {
                    this.mActivity.getActionBar().setSubtitle(this.mActivity.getActionBar().getSubtitle());
                }
            } catch (Exception e) {
            }
        }
    }

    public void setAnimateEnabled(boolean enabled) {
        this.animateEnabled = enabled;
    }

    public boolean isAnimateEnabled() {
        return this.animateEnabled;
    }
}
