package com.antutu.benchmark.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.utils.Methods;
import com.antutu.utils.PointMark;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;

public class LocalizationActivity extends C1197a implements OnClickListener {
    protected OnClickListener f4261a;
    private EditText f4262b;
    private EditText f4263c;
    private Button f4264d;
    private String f4265e;
    private String f4266f;

    /* renamed from: com.antutu.benchmark.activity.LocalizationActivity.1 */
    class C12521 implements OnClickListener {
        final /* synthetic */ LocalizationActivity f4260a;

        C12521(LocalizationActivity localizationActivity) {
            this.f4260a = localizationActivity;
        }

        public void onClick(View view) {
            Methods.hideSoftKeyboard(this.f4260a, this.f4260a.f4262b);
            this.f4260a.m4961f();
        }
    }

    public LocalizationActivity() {
        this.f4261a = new C12521(this);
    }

    private void m5115a() {
        this.f4264d.setOnClickListener(this);
    }

    private void m5116b() {
        this.f4262b = (EditText) findViewById(C1082R.id.contact_edit);
        this.f4263c = (EditText) findViewById(C1082R.id.et_language);
        this.f4264d = (Button) findViewById(C1082R.id.btn_submit);
        this.f4262b.requestFocus();
    }

    private void m5118c() {
        this.f4265e = this.f4262b.getText().toString().trim();
        this.f4266f = this.f4263c.getText().toString().trim();
        if (this.f4265e == null || BuildConfig.FLAVOR.equals(this.f4265e)) {
            Methods.showToast((Context) this, (int) C1082R.string.contact_not_be_null, 0);
        } else if (this.f4266f == null || BuildConfig.FLAVOR.equals(this.f4266f)) {
            Methods.showToast((Context) this, (int) C1082R.string.please_input_language, 0);
        } else {
            Methods.sendEmail(this, "marketing@antutu.com", getResources().getString(C1082R.string.help_localization) + C4233j.f14396s + this.f4265e + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f4266f + C4233j.f14397t);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.btn_submit /*2131624094*/:
                m5118c();
            default:
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PointMark.getInstance(this).pointThis(PointMark.K_Localization);
        setContentView(C1082R.layout.activity_localization);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6414a(getResources().getString(C1082R.string.localization)).m6413a(this.f4261a).m6418b(false).m6411a());
        m5116b();
        m5115a();
    }
}
