package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0439m.C0436a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0436a {
    private C0450h f1151a;
    private ImageView f1152b;
    private RadioButton f1153c;
    private TextView f1154d;
    private CheckBox f1155e;
    private TextView f1156f;
    private Drawable f1157g;
    private int f1158h;
    private Context f1159i;
    private boolean f1160j;
    private int f1161k;
    private Context f1162l;
    private LayoutInflater f1163m;
    private boolean f1164n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1162l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.MenuView, i, 0);
        this.f1157g = obtainStyledAttributes.getDrawable(C0417R.styleable.MenuView_android_itemBackground);
        this.f1158h = obtainStyledAttributes.getResourceId(C0417R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f1160j = obtainStyledAttributes.getBoolean(C0417R.styleable.MenuView_preserveIconSpacing, false);
        this.f1159i = context;
        obtainStyledAttributes.recycle();
    }

    private void m1327b() {
        this.f1152b = (ImageView) getInflater().inflate(C0417R.layout.abc_list_menu_item_icon, this, false);
        addView(this.f1152b, 0);
    }

    private void m1328c() {
        this.f1153c = (RadioButton) getInflater().inflate(C0417R.layout.abc_list_menu_item_radio, this, false);
        addView(this.f1153c);
    }

    private void m1329d() {
        this.f1155e = (CheckBox) getInflater().inflate(C0417R.layout.abc_list_menu_item_checkbox, this, false);
        addView(this.f1155e);
    }

    private LayoutInflater getInflater() {
        if (this.f1163m == null) {
            this.f1163m = LayoutInflater.from(this.f1162l);
        }
        return this.f1163m;
    }

    public void m1330a(C0450h c0450h, int i) {
        this.f1151a = c0450h;
        this.f1161k = i;
        setVisibility(c0450h.isVisible() ? 0 : 8);
        setTitle(c0450h.m1438a((C0436a) this));
        setCheckable(c0450h.isCheckable());
        m1331a(c0450h.m1451e(), c0450h.m1446c());
        setIcon(c0450h.getIcon());
        setEnabled(c0450h.isEnabled());
    }

    public void m1331a(boolean z, char c) {
        int i = (z && this.f1151a.m1451e()) ? 0 : 8;
        if (i == 0) {
            this.f1156f.setText(this.f1151a.m1448d());
        }
        if (this.f1156f.getVisibility() != i) {
            this.f1156f.setVisibility(i);
        }
    }

    public boolean m1332a() {
        return false;
    }

    public C0450h getItemData() {
        return this.f1151a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1157g);
        this.f1154d = (TextView) findViewById(C0417R.id.title);
        if (this.f1158h != -1) {
            this.f1154d.setTextAppearance(this.f1159i, this.f1158h);
        }
        this.f1156f = (TextView) findViewById(C0417R.id.shortcut);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1152b != null && this.f1160j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1152b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.f1153c != null || this.f1155e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1151a.m1452f()) {
                if (this.f1153c == null) {
                    m1328c();
                }
                compoundButton = this.f1153c;
                compoundButton2 = this.f1155e;
            } else {
                if (this.f1155e == null) {
                    m1329d();
                }
                compoundButton = this.f1155e;
                compoundButton2 = this.f1153c;
            }
            if (z) {
                compoundButton.setChecked(this.f1151a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1155e != null) {
                this.f1155e.setVisibility(8);
            }
            if (this.f1153c != null) {
                this.f1153c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1151a.m1452f()) {
            if (this.f1153c == null) {
                m1328c();
            }
            compoundButton = this.f1153c;
        } else {
            if (this.f1155e == null) {
                m1329d();
            }
            compoundButton = this.f1155e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1164n = z;
        this.f1160j = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1151a.m1454h() || this.f1164n) ? 1 : 0;
        if (i == 0 && !this.f1160j) {
            return;
        }
        if (this.f1152b != null || drawable != null || this.f1160j) {
            if (this.f1152b == null) {
                m1327b();
            }
            if (drawable != null || this.f1160j) {
                ImageView imageView = this.f1152b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1152b.getVisibility() != 0) {
                    this.f1152b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1152b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1154d.setText(charSequence);
            if (this.f1154d.getVisibility() != 0) {
                this.f1154d.setVisibility(0);
            }
        } else if (this.f1154d.getVisibility() != 8) {
            this.f1154d.setVisibility(8);
        }
    }
}
