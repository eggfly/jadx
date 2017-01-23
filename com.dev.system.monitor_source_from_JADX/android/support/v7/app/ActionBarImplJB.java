package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.widget.SpinnerAdapter;

public class ActionBarImplJB extends ActionBarImplICS {
    public /* bridge */ /* synthetic */ void addOnMenuVisibilityListener(OnMenuVisibilityListener x0) {
        super.addOnMenuVisibilityListener(x0);
    }

    public /* bridge */ /* synthetic */ void addTab(Tab x0) {
        super.addTab(x0);
    }

    public /* bridge */ /* synthetic */ void addTab(Tab x0, int x1, boolean x2) {
        super.addTab(x0, x1, x2);
    }

    public /* bridge */ /* synthetic */ View getCustomView() {
        return super.getCustomView();
    }

    public /* bridge */ /* synthetic */ int getDisplayOptions() {
        return super.getDisplayOptions();
    }

    public /* bridge */ /* synthetic */ int getHeight() {
        return super.getHeight();
    }

    public /* bridge */ /* synthetic */ int getNavigationItemCount() {
        return super.getNavigationItemCount();
    }

    public /* bridge */ /* synthetic */ int getNavigationMode() {
        return super.getNavigationMode();
    }

    public /* bridge */ /* synthetic */ int getSelectedNavigationIndex() {
        return super.getSelectedNavigationIndex();
    }

    public /* bridge */ /* synthetic */ Tab getSelectedTab() {
        return super.getSelectedTab();
    }

    public /* bridge */ /* synthetic */ CharSequence getSubtitle() {
        return super.getSubtitle();
    }

    public /* bridge */ /* synthetic */ Tab getTabAt(int x0) {
        return super.getTabAt(x0);
    }

    public /* bridge */ /* synthetic */ int getTabCount() {
        return super.getTabCount();
    }

    public /* bridge */ /* synthetic */ Context getThemedContext() {
        return super.getThemedContext();
    }

    public /* bridge */ /* synthetic */ CharSequence getTitle() {
        return super.getTitle();
    }

    public /* bridge */ /* synthetic */ void hide() {
        super.hide();
    }

    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public /* bridge */ /* synthetic */ Tab newTab() {
        return super.newTab();
    }

    public /* bridge */ /* synthetic */ void removeAllTabs() {
        super.removeAllTabs();
    }

    public /* bridge */ /* synthetic */ void removeOnMenuVisibilityListener(OnMenuVisibilityListener x0) {
        super.removeOnMenuVisibilityListener(x0);
    }

    public /* bridge */ /* synthetic */ void removeTab(Tab x0) {
        super.removeTab(x0);
    }

    public /* bridge */ /* synthetic */ void removeTabAt(int x0) {
        super.removeTabAt(x0);
    }

    public /* bridge */ /* synthetic */ void selectTab(Tab x0) {
        super.selectTab(x0);
    }

    public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable x0) {
        super.setBackgroundDrawable(x0);
    }

    public /* bridge */ /* synthetic */ void setCustomView(View x0, LayoutParams x1) {
        super.setCustomView(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setDisplayHomeAsUpEnabled(boolean x0) {
        super.setDisplayHomeAsUpEnabled(x0);
    }

    public /* bridge */ /* synthetic */ void setDisplayOptions(int x0) {
        super.setDisplayOptions(x0);
    }

    public /* bridge */ /* synthetic */ void setDisplayOptions(int x0, int x1) {
        super.setDisplayOptions(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setDisplayShowCustomEnabled(boolean x0) {
        super.setDisplayShowCustomEnabled(x0);
    }

    public /* bridge */ /* synthetic */ void setDisplayShowHomeEnabled(boolean x0) {
        super.setDisplayShowHomeEnabled(x0);
    }

    public /* bridge */ /* synthetic */ void setDisplayShowTitleEnabled(boolean x0) {
        super.setDisplayShowTitleEnabled(x0);
    }

    public /* bridge */ /* synthetic */ void setDisplayUseLogoEnabled(boolean x0) {
        super.setDisplayUseLogoEnabled(x0);
    }

    public /* bridge */ /* synthetic */ void setHomeButtonEnabled(boolean x0) {
        super.setHomeButtonEnabled(x0);
    }

    public /* bridge */ /* synthetic */ void setListNavigationCallbacks(SpinnerAdapter x0, OnNavigationListener x1) {
        super.setListNavigationCallbacks(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setNavigationMode(int x0) {
        super.setNavigationMode(x0);
    }

    public /* bridge */ /* synthetic */ void setSelectedNavigationItem(int x0) {
        super.setSelectedNavigationItem(x0);
    }

    public /* bridge */ /* synthetic */ void setSplitBackgroundDrawable(Drawable x0) {
        super.setSplitBackgroundDrawable(x0);
    }

    public /* bridge */ /* synthetic */ void setStackedBackgroundDrawable(Drawable x0) {
        super.setStackedBackgroundDrawable(x0);
    }

    public /* bridge */ /* synthetic */ void show() {
        super.show();
    }

    public ActionBarImplJB(Activity activity, Callback callback) {
        super(activity, callback, false);
    }
}
