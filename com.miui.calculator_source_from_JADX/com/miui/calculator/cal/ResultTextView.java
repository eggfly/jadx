package com.miui.calculator.cal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.miui.calculator.common.widget.ScrollTextView;
import com.miui.support.internal.C0264R;
import java.util.HashMap;

public class ResultTextView extends ScrollTextView {
    private boolean f1498a;
    private PopupMenuCallback f1499b;
    private PopupMenu f1500c;
    private OnLongClickListener f1501d;

    public interface PopupMenuCallback {
        void m2619a(int i);

        void m2620a(HashMap<Integer, String> hashMap);
    }

    /* renamed from: com.miui.calculator.cal.ResultTextView.1 */
    class C01651 implements OnLongClickListener {
        final /* synthetic */ ResultTextView f1489a;

        C01651(ResultTextView resultTextView) {
            this.f1489a = resultTextView;
        }

        public boolean onLongClick(View view) {
            if (!this.f1489a.f1498a || this.f1489a.f1499b == null) {
                return false;
            }
            if (this.f1489a.f1500c == null) {
                this.f1489a.f1500c = new PopupMenu(this.f1489a);
            }
            this.f1489a.f1500c.m2777b();
            return true;
        }
    }

    private class PopupMenu {
        final /* synthetic */ ResultTextView f1493a;
        private PopupWindow f1494b;
        private LinearLayout f1495c;
        private OnClickListener f1496d;

        /* renamed from: com.miui.calculator.cal.ResultTextView.PopupMenu.1 */
        class C01661 implements OnLayoutChangeListener {
            final /* synthetic */ PopupMenu f1490a;

            C01661(PopupMenu popupMenu) {
                this.f1490a = popupMenu;
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.f1490a.f1494b.isShowing()) {
                    float left = ((((float) (this.f1490a.f1493a.getLeft() + this.f1490a.f1493a.getWidth())) + (this.f1490a.f1493a.getPaint().measureText("0") * 1.5f)) - this.f1490a.f1493a.getPaint().measureText(this.f1490a.f1493a.getText().toString())) - ((float) this.f1490a.f1495c.getWidth());
                    if (left < 0.0f) {
                        left = 0.0f;
                    }
                    this.f1490a.f1494b.update((int) left, (int) (((View) this.f1490a.f1493a.getParent()).getY() + this.f1490a.f1493a.getY()), this.f1490a.f1495c.getWidth(), this.f1490a.f1495c.getHeight());
                }
            }
        }

        /* renamed from: com.miui.calculator.cal.ResultTextView.PopupMenu.2 */
        class C01672 implements OnDismissListener {
            final /* synthetic */ PopupMenu f1491a;

            C01672(PopupMenu popupMenu) {
                this.f1491a = popupMenu;
            }

            public void onDismiss() {
                this.f1491a.m2779c();
            }
        }

        /* renamed from: com.miui.calculator.cal.ResultTextView.PopupMenu.3 */
        class C01683 implements OnClickListener {
            final /* synthetic */ PopupMenu f1492a;

            C01683(PopupMenu popupMenu) {
                this.f1492a = popupMenu;
            }

            public void onClick(View view) {
                this.f1492a.f1493a.f1499b.m2619a(view.getId());
                this.f1492a.m2779c();
            }
        }

        public PopupMenu(ResultTextView resultTextView) {
            this.f1493a = resultTextView;
            this.f1496d = new C01683(this);
            this.f1495c = new LinearLayout(resultTextView.getContext());
        }

        private void m2774a() {
            this.f1495c.setBackgroundResource(C0264R.drawable.text_select_bg);
            this.f1495c.addOnLayoutChangeListener(new C01661(this));
        }

        private void m2777b() {
            this.f1494b = new PopupWindow(this.f1493a.getContext());
            this.f1494b.setWidth(-2);
            this.f1494b.setHeight(-2);
            this.f1494b.setOutsideTouchable(true);
            this.f1494b.setContentView(this.f1495c);
            this.f1494b.setOnDismissListener(new C01672(this));
            m2774a();
            HashMap hashMap = new HashMap();
            this.f1493a.f1499b.m2620a(hashMap);
            this.f1495c.removeAllViews();
            for (Integer num : hashMap.keySet()) {
                hashMap.get(num);
                View d = m2780d();
                d.setId(num.intValue());
                d.setText((CharSequence) hashMap.get(num));
                this.f1495c.addView(d);
            }
            this.f1494b.showAsDropDown(this.f1493a);
            this.f1493a.setBackgroundResource(C0264R.drawable.selection_bg);
        }

        private void m2779c() {
            this.f1494b.dismiss();
            this.f1493a.setBackgroundResource(0);
        }

        private TextView m2780d() {
            TextView textView = (TextView) ((LayoutInflater) this.f1493a.getContext().getSystemService("layout_inflater")).inflate(C0264R.layout.text_edit_action_popup_text, null);
            textView.setOnClickListener(this.f1496d);
            return textView;
        }
    }

    public ResultTextView(Context context) {
        this(context, null);
    }

    public ResultTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ResultTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1501d = new C01651(this);
        setOnLongClickListener(this.f1501d);
    }

    public void m2786a(boolean z) {
        this.f1498a = z;
    }

    public void setPopupMenuCallback(PopupMenuCallback popupMenuCallback) {
        this.f1499b = popupMenuCallback;
    }
}
