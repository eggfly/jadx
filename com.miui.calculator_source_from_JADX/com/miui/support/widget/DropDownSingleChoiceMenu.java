package com.miui.support.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.miui.support.widget.DropDownPopupWindow.Controller;
import com.miui.support.widget.DropDownPopupWindow.DefaultContainerController;

public class DropDownSingleChoiceMenu implements Controller {
    private int f4088a;
    private OnMenuListener f4089b;
    private DropDownPopupWindow f4090c;

    /* renamed from: com.miui.support.widget.DropDownSingleChoiceMenu.1 */
    class C04691 extends DefaultContainerController {
        final /* synthetic */ DropDownSingleChoiceMenu f4086a;

        public void m5797a() {
            this.f4086a.m5803c();
        }
    }

    /* renamed from: com.miui.support.widget.DropDownSingleChoiceMenu.2 */
    class C04702 implements OnItemClickListener {
        final /* synthetic */ DropDownSingleChoiceMenu f4087a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f4087a.f4088a = i;
            if (this.f4087a.f4089b != null) {
                this.f4087a.f4089b.m5799a(this.f4087a, i);
            }
            this.f4087a.m5806b();
        }
    }

    public interface OnMenuListener {
        void m5798a();

        void m5799a(DropDownSingleChoiceMenu dropDownSingleChoiceMenu, int i);
    }

    public void m5806b() {
        if (this.f4090c != null) {
            this.f4090c.m5796a();
        }
    }

    private void m5803c() {
        this.f4090c = null;
    }

    public void m5804a() {
        if (this.f4089b != null) {
            this.f4089b.m5798a();
        }
    }

    public void m5805a(View view, float f) {
    }
}
