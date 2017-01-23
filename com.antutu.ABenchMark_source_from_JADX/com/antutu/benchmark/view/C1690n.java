package com.antutu.benchmark.view;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1522c;
import com.antutu.utils.Methods;

/* renamed from: com.antutu.benchmark.view.n */
public class C1690n extends PopupWindow {
    EditText f6026a;
    TextView f6027b;
    Button f6028c;
    String f6029d;
    C1522c f6030e;
    int f6031f;
    C1478a f6032g;

    /* renamed from: com.antutu.benchmark.view.n.a */
    public interface C1478a {
        void m5806a(EditText editText, String str, C1522c c1522c, int i);
    }

    /* renamed from: com.antutu.benchmark.view.n.1 */
    class C16881 implements OnClickListener {
        final /* synthetic */ C1690n f6024a;

        C16881(C1690n c1690n) {
            this.f6024a = c1690n;
        }

        public void onClick(View view) {
            if (this.f6024a.f6032g != null) {
                this.f6024a.f6032g.m5806a(this.f6024a.f6026a, this.f6024a.f6026a.getText().toString(), this.f6024a.f6030e, this.f6024a.f6031f);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.n.2 */
    class C16892 implements TextWatcher {
        final /* synthetic */ C1690n f6025a;

        C16892(C1690n c1690n) {
            this.f6025a = c1690n;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f6025a.m6599b();
        }
    }

    public C1690n(Activity activity) {
        super(activity);
        View inflate = View.inflate(new ContextThemeWrapper(activity.getApplicationContext(), C1082R.style.Theme_Themeday), C1082R.layout.popup_reply_window, null);
        this.f6026a = (EditText) inflate.findViewById(C1082R.id.et_comment_text);
        this.f6028c = (Button) inflate.findViewById(C1082R.id.send_btn);
        this.f6027b = (TextView) inflate.findViewById(C1082R.id.reply_title);
        this.f6028c.setOnClickListener(new C16881(this));
        this.f6026a.addTextChangedListener(new C16892(this));
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
    }

    private void m6599b() {
        String obj = this.f6026a.getText().toString();
        if (obj == null || obj.toString().trim().length() <= 0) {
            this.f6028c.setBackgroundResource(C1082R.drawable.send);
        } else {
            this.f6028c.setBackgroundResource(C1082R.drawable.send_red);
        }
        this.f6027b.setVisibility(0);
    }

    public void m6600a() {
        this.f6026a.requestFocus();
        Methods.showSoftKeyboard(this.f6026a);
    }

    public void m6601a(int i) {
        this.f6031f = i;
    }

    public void m6602a(C1522c c1522c) {
        this.f6030e = c1522c;
    }

    public void m6603a(C1478a c1478a) {
        this.f6032g = c1478a;
    }

    public void m6604a(String str) {
        this.f6029d = str;
        if (this.f6027b != null) {
            this.f6027b.setText(str);
        }
    }
}
