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

public class ActivityVerifyUnknown extends C1197a implements OnClickListener {
    private static final String f4562a;
    private ImageView f4563b;
    private TextView f4564c;
    private Button f4565d;
    private Button f4566e;
    private TextView f4567f;
    private TextView f4568g;
    private TextView f4569h;
    private TextView f4570i;

    static {
        f4562a = ActivityVerifyUnknown.class.getSimpleName();
    }

    public static Intent m5337a(Context context) {
        return new Intent(context, ActivityVerifyUnknown.class);
    }

    private void m5338a() {
        this.f4563b = (ImageView) findViewById(C1082R.id.verify_unknown_back);
        this.f4564c = (TextView) findViewById(C1082R.id.verify_unknown_title);
        this.f4565d = (Button) findViewById(C1082R.id.verify_unknown_again);
        this.f4566e = (Button) findViewById(C1082R.id.verify_unknown_feedBack);
        this.f4567f = (TextView) findViewById(C1082R.id.verify_unknown_result);
        this.f4568g = (TextView) findViewById(C1082R.id.verify_unknown_mobile);
        this.f4569h = (TextView) findViewById(C1082R.id.verify_unknown_no);
        this.f4570i = (TextView) findViewById(C1082R.id.verify_unknown_time);
        m5340b();
    }

    private void m5339a(int i) {
        InfocUtil.antutu_yanji_new(this, i);
    }

    private void m5340b() {
        this.f4563b.setOnClickListener(this);
        this.f4565d.setOnClickListener(this);
        this.f4566e.setOnClickListener(this);
    }

    private void m5341c() {
        if (getIntent() != null) {
            VerifiedResult verifiedResult = (VerifiedResult) getIntent().getParcelableExtra("Extra.Verify.Result");
            if (verifiedResult != null) {
                this.f4568g.setText(verifiedResult.m5368e() + " " + verifiedResult.m5366d());
                this.f4569h.setText(verifiedResult.m5364c());
                this.f4570i.setText(DateUtil.formatDate(verifiedResult.m5374j()));
            }
        }
    }

    private void m5342d() {
        String str = (((((((((BuildConfig.FLAVOR + getResources().getString(C1082R.string.verify_upshot)) + this.f4567f.getText().toString()) + "\n") + getResources().getString(C1082R.string.verify_id)) + this.f4569h.getText().toString()) + "\n") + getResources().getString(C1082R.string.verify_datetime)) + this.f4570i.getText().toString()) + "\n") + getResources().getString(C1082R.string.recommend_content);
        Intent b = FeedbackActivity.m5079b((Context) this);
        b.putExtra("Feedback.Extra.Content", str);
        startActivity(b);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.verify_unknown_back /*2131624146*/:
                super.onBackPressed();
            case C1082R.id.verify_unknown_again /*2131624150*/:
                m5339a(6);
                if (NetUtils.isNetworkAvailable()) {
                    startActivity(ActivityVerifying.m5357d(this));
                    finish();
                    return;
                }
                Toast.makeText(this, C1082R.string.verifying_net_error, 0).show();
            case C1082R.id.verify_unknown_feedBack /*2131624151*/:
                m5339a(9);
                m5342d();
            default:
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_verify_unknown);
        m5338a();
        m5341c();
        m5339a(3);
    }
}
