package com.miui.calculator.cal;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.support.internal.C0264R;
import java.util.ArrayList;
import java.util.Iterator;

public class CalculateStoreLayout extends LinearLayout {
    private static CalculatorResult f1452a;
    private ArrayList<String> f1453b;

    public static class CalculatorResult {
        ArrayList<String> f1443a;
        int f1444b;
        int f1445c;
        int f1446d;
        int f1447e;
        boolean f1448f;
        boolean f1449g;
        int f1450h;
        int f1451i;

        public CalculatorResult() {
            this.f1443a = new ArrayList();
            this.f1447e = 2;
        }

        public CalculatorResult(ArrayList<String> arrayList, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
            this.f1443a = new ArrayList();
            this.f1447e = 2;
            this.f1443a = arrayList;
            this.f1444b = i;
            this.f1445c = i2;
            this.f1446d = i3;
            this.f1447e = i4;
            this.f1448f = z;
            this.f1449g = z2;
            this.f1451i = i6;
            this.f1450h = i5;
        }
    }

    static {
        f1452a = new CalculatorResult();
    }

    public CalculateStoreLayout(Context context) {
        this(context, null);
    }

    public CalculateStoreLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CalculateStoreLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1453b = new ArrayList();
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view instanceof CalElementView) {
            this.f1453b.add(((CalElementView) view).getText());
        } else {
            this.f1453b.add("---");
        }
    }

    public void removeViewAt(int i) {
        super.removeViewAt(i);
        this.f1453b.remove(i);
        Log.d("CalculateStoreLayout", "remove view at:" + i);
    }

    public void removeViews(int i, int i2) {
        super.removeViews(i, i2);
        int size = this.f1453b.size() - i;
        int i3 = 0;
        while (i3 < i2 && i3 < size) {
            this.f1453b.remove(i);
            i3++;
        }
        Log.d("CalculateStoreLayout", "remove views: start:" + i + ", count:" + i2);
    }

    public void removeAllViews() {
        super.removeAllViews();
        this.f1453b.clear();
    }

    private void m2730a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
            if (layoutParams == null) {
                throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            }
        }
        m2728a(view, -1, layoutParams, z);
    }

    private void m2729a(View view, LayoutParams layoutParams, boolean z) {
        m2728a(view, -1, layoutParams, z);
    }

    private void m2728a(View view, int i, LayoutParams layoutParams, boolean z) {
        super.addView(view, i, layoutParams);
    }

    public void m2734a(int i, String str) {
        View childAt = getChildAt(i);
        if (childAt != null && (childAt instanceof CalElementView)) {
            ((CalElementView) childAt).setText(str);
            this.f1453b.set(i, str);
        }
    }

    public void m2736b(int i, String str) {
        View childAt = getChildAt(i);
        if (childAt != null && (childAt instanceof CalElementView)) {
            ((CalElementView) childAt).setElement(str);
            this.f1453b.set(i, ((CalElementView) childAt).getText());
        }
    }

    public void m2737c(int i, String str) {
        View childAt = getChildAt(i);
        if (childAt != null && (childAt instanceof CalElementView)) {
            ((CalElementView) childAt).setOperator(str);
            this.f1453b.set(i, ((CalElementView) childAt).getText());
        }
    }

    public void m2733a(int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
        f1452a = new CalculatorResult(this.f1453b, i, i2, i3, i4, z, z2, i5, i6);
    }

    public CalculatorResult getRestoreResult() {
        return f1452a;
    }

    public boolean m2735a() {
        ArrayList arrayList = getRestoreResult().f1443a;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.equals("---", str)) {
                m2732b();
            } else {
                m2731a(str);
            }
        }
        this.f1453b = arrayList;
        return true;
    }

    private void m2732b() {
        View imageView = new ImageView(getContext());
        imageView.setBackgroundResource(C0264R.drawable.img_cal_divider);
        imageView.setLayerType(1, null);
        m2729a(imageView, new LinearLayout.LayoutParams(-1, 100), true);
    }

    private void m2731a(String str) {
        View calElementView = new CalElementView(getContext());
        calElementView.setTextSize(getResources().getDimensionPixelSize(C0264R.dimen.cal_secondary));
        calElementView.setText(str);
        calElementView.setTypeFace(CalculatorUtils.m2817a(getContext()));
        calElementView.setTextColor(getResources().getColor(C0264R.color.cal_history));
        m2730a(calElementView, true);
    }
}
