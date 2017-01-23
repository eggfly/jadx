package com.miui.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.internal.C0264R;

public class FilterSortView extends LinearLayout {

    public static class TabView extends LinearLayout {
        private TextView f4164a;
        private ImageView f4165b;
        private boolean f4166c;
        private boolean f4167d;
        private FilterSortView f4168e;

        /* renamed from: com.miui.support.widget.FilterSortView.TabView.1 */
        class C04841 implements OnClickListener {
            final /* synthetic */ OnClickListener f4162a;
            final /* synthetic */ TabView f4163b;

            C04841(TabView tabView, OnClickListener onClickListener) {
                this.f4163b = tabView;
                this.f4162a = onClickListener;
            }

            public void onClick(View view) {
                boolean z = true;
                if (this.f4163b.f4166c) {
                    TabView tabView = this.f4163b;
                    if (this.f4163b.f4167d) {
                        z = false;
                    }
                    tabView.setDescending(z);
                } else {
                    this.f4163b.setFiltered(true);
                }
                this.f4162a.onClick(view);
            }
        }

        public TabView(Context context) {
            this(context, null);
        }

        public TabView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public TabView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            LayoutInflater.from(context).inflate(C0264R.layout.filter_sort_tab_view, this, true);
            this.f4164a = (TextView) findViewById(16908308);
            this.f4165b = (ImageView) findViewById(C0264R.id.arrow);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.FilterSortView, i, 0);
                CharSequence string = obtainStyledAttributes.getString(C0264R.styleable.FilterSortView_android_text);
                boolean z = obtainStyledAttributes.getBoolean(C0264R.styleable.FilterSortView_descending, true);
                obtainStyledAttributes.recycle();
                m5867a(string, z);
            }
        }

        private void m5867a(CharSequence charSequence, boolean z) {
            setGravity(17);
            if (getBackground() == null) {
                setBackground(getResources().getDrawable(C0264R.drawable.filter_sort_tab_view_bg_light));
            }
            this.f4164a.setText(charSequence);
            setDescending(z);
        }

        private void setFiltered(boolean z) {
            this.f4168e = (FilterSortView) getParent();
            if (z && this.f4168e != null) {
                int childCount = this.f4168e.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    TabView tabView = (TabView) this.f4168e.getChildAt(i);
                    if (tabView != this && tabView.f4166c) {
                        tabView.setFiltered(false);
                    }
                }
            }
            this.f4166c = z;
            this.f4164a.setSelected(z);
            this.f4165b.setSelected(z);
        }

        private void setDescending(boolean z) {
            this.f4167d = z;
            if (z) {
                this.f4165b.setRotationX(0.0f);
            } else {
                this.f4165b.setRotationX(180.0f);
            }
        }

        public void setOnClickListener(OnClickListener onClickListener) {
            super.setOnClickListener(new C04841(this, onClickListener));
        }
    }

    public FilterSortView(Context context) {
        super(context);
    }

    public FilterSortView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilterSortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setFilteredTab(TabView tabView) {
        tabView.setFiltered(true);
    }
}
