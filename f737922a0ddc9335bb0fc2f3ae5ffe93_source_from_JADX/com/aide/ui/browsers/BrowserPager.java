package com.aide.ui.browsers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.aide.ui.MainActivity;
import com.aide.ui.R;
import com.aide.ui.e;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BrowserPager extends ViewPager {
    public static int DW;
    public static int FH;
    public static int Hw;
    public static int j6;
    public static int v5;
    private List<View> Zo;

    private class a extends v {
        private int DW;
        final /* synthetic */ BrowserPager j6;

        class 1 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ int j6;

            1(a aVar, int i) {
                this.DW = aVar;
                this.j6 = i;
            }

            public void run() {
                a aVar = (a) this.DW.j6.Zo.get(this.j6);
                aVar.j6();
                this.DW.j6.getActivity().Hw(this.j6);
                if (!e.J0()) {
                    aVar.DW();
                }
            }
        }

        private a(BrowserPager browserPager) {
            this.j6 = browserPager;
            this.DW = -1;
        }

        public void j6(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int DW() {
            return this.j6.Zo.size();
        }

        public int j6(Object obj) {
            return -2;
        }

        public boolean j6(View view, Object obj) {
            return view.equals(obj);
        }

        public void DW(ViewGroup viewGroup) {
        }

        public void j6(Parcelable parcelable, ClassLoader classLoader) {
        }

        public Parcelable j6() {
            return null;
        }

        public void j6(ViewGroup viewGroup) {
        }

        public void DW(ViewGroup viewGroup, int i, Object obj) {
            super.DW(viewGroup, i, obj);
            if (this.DW != i) {
                this.DW = i;
                this.j6.postDelayed(new 1(this, i), 100);
            }
        }

        public Object j6(ViewGroup viewGroup, int i) {
            View view = (View) this.j6.Zo.get(i);
            viewGroup.addView(view, 0);
            return view;
        }
    }

    static {
        j6 = 0;
        DW = 1;
        FH = 2;
        Hw = 3;
        v5 = 4;
    }

    public BrowserPager(Context context) {
        super(context);
        this.Zo = new ArrayList();
        gn();
    }

    public BrowserPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zo = new ArrayList();
        gn();
    }

    public void VH() {
        DW(getCurrentBrowser(), false);
    }

    private void gn() {
        this.Zo.add(new FileBrowser(getContext()));
        this.Zo.add(new ErrorBrowser(getContext()));
        this.Zo.add(new SearchBrowser(getContext()));
        if (!e.j6.equals("com.aide.web")) {
            this.Zo.add(new DebugBrowser(getContext()));
            this.Zo.add(new LogCatBrowser(getContext()));
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mTouchSlop");
            declaredField.setAccessible(true);
            declaredField.setInt(this, 10);
        } catch (Exception e) {
        }
        setPageMargin(1);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.a.color_page_separator});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        setPageMarginDrawable(new ColorDrawable(color));
        setAdapter(new a());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (e.VH()) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (e.VH()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    private MainActivity getActivity() {
        return (MainActivity) getContext();
    }

    public SearchBrowser getSearchBrowser() {
        return (SearchBrowser) Hw(FH);
    }

    public ErrorBrowser getErrorBrowser() {
        return (ErrorBrowser) Hw(DW);
    }

    public FileBrowser getFileBrowser() {
        return (FileBrowser) Hw(j6);
    }

    public DebugBrowser getDebugBrowser() {
        if (!e.j6.equals("com.aide.web")) {
            return (DebugBrowser) Hw(Hw);
        }
        com.aide.common.e.FH("getDebugBrowser called in AIDE_WEB. This shouldn't happen");
        return null;
    }

    public LogCatBrowser getLogCatBrowser() {
        if (!e.j6.equals("com.aide.web")) {
            return (LogCatBrowser) Hw(v5);
        }
        com.aide.common.e.FH("getLogCatBrowser called in AIDE_WEB. This shouldn't happen");
        return null;
    }

    private View Hw(int i) {
        return (View) this.Zo.get(i);
    }

    public int getCurrentBrowser() {
        return getCurrentItem();
    }

    public void DW(int i, boolean z) {
        if (z) {
            setCurrentItem(i);
            return;
        }
        int i2;
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        j6(i2, false);
        j6(i, false);
    }
}
