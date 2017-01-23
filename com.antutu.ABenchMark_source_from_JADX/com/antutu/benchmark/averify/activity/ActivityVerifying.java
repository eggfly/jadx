package com.antutu.benchmark.averify.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.averify.logic.C1334d;
import com.antutu.benchmark.averify.logic.C1334d.C1327a;
import com.antutu.benchmark.averify.logic.Verifier.VerifiedResult;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.utils.InfocUtil;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class ActivityVerifying extends C1197a implements OnClickListener {
    private static final String f4574a;
    private ImageView f4575b;
    private TextView f4576c;
    private ImageView f4577d;
    private AnimationDrawable f4578e;
    private TextView f4579f;
    private boolean f4580g;

    /* renamed from: com.antutu.benchmark.averify.activity.ActivityVerifying.1 */
    class C13281 implements C1327a {
        final /* synthetic */ ActivityVerifying f4571a;

        C13281(ActivityVerifying activityVerifying) {
            this.f4571a = activityVerifying;
        }

        public void m5344a(VerifiedResult verifiedResult) {
            if (!this.f4571a.f4580g) {
                this.f4571a.m5350a(verifiedResult);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.averify.activity.ActivityVerifying.2 */
    class C13292 implements Runnable {
        final /* synthetic */ VerifiedResult f4572a;
        final /* synthetic */ ActivityVerifying f4573b;

        C13292(ActivityVerifying activityVerifying, VerifiedResult verifiedResult) {
            this.f4573b = activityVerifying;
            this.f4572a = verifiedResult;
        }

        public void run() {
            if (this.f4572a == null) {
                Toast.makeText(this.f4573b, C1082R.string.verifying_net_error, 0).show();
                this.f4573b.finish();
                return;
            }
            Intent intent = null;
            switch (this.f4572a.m5362b()) {
                case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                    intent = ActivityVerifyUnknown.m5337a(this.f4573b);
                    break;
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    intent = ActivityVerifyError.m5320a(this.f4573b);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    intent = ActivityVerifySuccess.m5328a(this.f4573b);
                    break;
            }
            if (intent != null) {
                intent.putExtra("Extra.Verify.Result", this.f4572a);
                this.f4573b.startActivity(intent);
                this.f4573b.finish();
            }
        }
    }

    static {
        f4574a = ActivityVerifying.class.getSimpleName();
    }

    public ActivityVerifying() {
        this.f4580g = false;
    }

    public static Intent m5345a(Context context) {
        return m5346a(context, "Action.Verify.Main");
    }

    private static Intent m5346a(Context context, String str) {
        Intent intent = new Intent(context, ActivityVerifying.class);
        intent.setAction(str);
        return intent;
    }

    private void m5347a() {
        this.f4575b = (ImageView) findViewById(C1082R.id.verifying_back);
        this.f4576c = (TextView) findViewById(C1082R.id.verifying_title);
        this.f4577d = (ImageView) findViewById(C1082R.id.verifying_iv);
        this.f4577d.setImageResource(C1082R.drawable.anim_verifying);
        this.f4578e = (AnimationDrawable) this.f4577d.getDrawable();
        this.f4578e.start();
        this.f4579f = (TextView) findViewById(C1082R.id.verifying_waiting);
        m5354b();
    }

    private void m5348a(int i) {
        InfocUtil.antutu_yanji_new(this, i);
    }

    private void m5350a(VerifiedResult verifiedResult) {
        runOnUiThread(new C13292(this, verifiedResult));
    }

    private void m5351a(boolean z) {
        new C1334d(this, z, new C13281(this)).execute(new Void[0]);
    }

    public static Intent m5353b(Context context) {
        return m5346a(context, "Action.Verify.Success");
    }

    private void m5354b() {
        this.f4575b.setOnClickListener(this);
    }

    public static Intent m5355c(Context context) {
        return m5346a(context, "Action.Verify.Error");
    }

    private void m5356c() {
        if (getIntent() != null && !TextUtils.isEmpty(getIntent().getAction())) {
            String action = getIntent().getAction();
            boolean z = true;
            switch (action.hashCode()) {
                case -2103175571:
                    if (action.equals("Action.Verify.Unknown")) {
                        z = true;
                        break;
                    }
                    break;
                case -785553173:
                    if (action.equals("Action.Verify.Error")) {
                        z = true;
                        break;
                    }
                    break;
                case -440760714:
                    if (action.equals("Action.Verify.Main")) {
                        z = false;
                        break;
                    }
                    break;
                case 609462822:
                    if (action.equals("Action.Verify.Success")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    m5351a(false);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    m5351a(true);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    m5351a(true);
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m5351a(true);
                default:
            }
        }
    }

    public static Intent m5357d(Context context) {
        return m5346a(context, "Action.Verify.Unknown");
    }

    public void onBackPressed() {
        m5348a(11);
        super.onBackPressed();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1082R.id.verifying_back /*2131624155*/:
                onBackPressed();
            default:
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_verifying);
        m5347a();
        m5356c();
        m5348a(10);
    }

    protected void onDestroy() {
        if (this.f4578e != null) {
            this.f4578e.stop();
        }
        this.f4580g = true;
        super.onDestroy();
    }
}
