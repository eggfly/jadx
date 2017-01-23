package com.antutu.benchmark.averify.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.FeedbackActivity;
import com.antutu.benchmark.averify.logic.Verifier.VerifiedResult;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.utils.DateUtil;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.NetUtils;
import com.xiaomi.pushsdk.BuildConfig;

public class ActivityVerifyError extends C1197a implements OnClickListener {
    private static final String f4519a;
    private ImageView f4520b;
    private TextView f4521c;
    private Button f4522d;
    private Button f4523e;
    private TextView f4524f;
    private TextView f4525g;
    private TextView f4526h;
    private TextView f4527i;

    static {
        f4519a = ActivityVerifyError.class.getSimpleName();
    }

    public static Intent m5320a(Context context) {
        return new Intent(context, ActivityVerifyError.class);
    }

    private void m5321a() {
        this.f4520b = (ImageView) findViewById(C1082R.id.verify_error_back);
        this.f4521c = (TextView) findViewById(C1082R.id.verify_error_title);
        this.f4522d = (Button) findViewById(C1082R.id.verify_error_again);
        this.f4523e = (Button) findViewById(C1082R.id.verify_error_feedBack);
        this.f4524f = (TextView) findViewById(C1082R.id.verify_error_result);
        this.f4525g = (TextView) findViewById(C1082R.id.verify_error_mobile);
        this.f4526h = (TextView) findViewById(C1082R.id.verify_error_no);
        this.f4527i = (TextView) findViewById(C1082R.id.verify_error_time);
        m5323b();
    }

    private void m5322a(int i) {
        InfocUtil.antutu_yanji_new(this, i);
    }

    private void m5323b() {
        this.f4520b.setOnClickListener(this);
        this.f4522d.setOnClickListener(this);
        this.f4523e.setOnClickListener(this);
    }

    private void m5324c() {
        if (getIntent() != null) {
            VerifiedResult verifiedResult = (VerifiedResult) getIntent().getParcelableExtra("Extra.Verify.Result");
            if (verifiedResult != null) {
                this.f4525g.setText(verifiedResult.m5368e() + " " + verifiedResult.m5366d());
                this.f4526h.setText(verifiedResult.m5364c());
                this.f4527i.setText(DateUtil.formatDate(verifiedResult.m5374j()));
            }
        }
    }

    private void m5325d() {
        String str = (((((((((BuildConfig.FLAVOR + getResources().getString(C1082R.string.verify_upshot)) + this.f4524f.getText().toString()) + "\n") + getResources().getString(C1082R.string.verify_id)) + this.f4526h.getText().toString()) + "\n") + getResources().getString(C1082R.string.verify_datetime)) + this.f4527i.getText().toString()) + "\n") + getResources().getString(C1082R.string.recommend_content);
        Intent a = FeedbackActivity.m5073a((Context) this);
        a.putExtra("Feedback.Extra.Content", str);
        startActivity(a);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.verify_error_back /*2131624113*/:
                super.onBackPressed();
            case C1082R.id.verify_error_again /*2131624117*/:
                m5322a(5);
                if (NetUtils.isNetworkAvailable()) {
                    startActivity(ActivityVerifying.m5355c(this));
                    finish();
                    return;
                }
                Toast.makeText(this, C1082R.string.verifying_net_error, 0).show();
            case C1082R.id.verify_error_feedBack /*2131624118*/:
                m5322a(8);
                m5325d();
            default:
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_verify_error);
        m5321a();
        m5322a(2);
        m5324c();
    }
}
