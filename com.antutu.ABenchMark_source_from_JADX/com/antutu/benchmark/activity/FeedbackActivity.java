package com.antutu.benchmark.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1519k;
import com.antutu.benchmark.model.C1523d;
import com.antutu.benchmark.model.C1529i;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1625b;
import com.antutu.utils.DownloadJob;
import com.antutu.utils.DownloadJobListener;
import com.antutu.utils.Methods;
import com.antutu.utils.NetUtils;
import com.antutu.utils.PointMark;
import com.antutu.utils.Utils;
import com.antutu.utils.jni;
import com.facebook.ads.AdError;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.pushsdk.C4459R;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class FeedbackActivity extends C1197a implements OnClickListener {
    private final int f4207a;
    private EditText f4208b;
    private EditText f4209c;
    private Button f4210d;
    private Button f4211e;
    private String f4212f;
    private String f4213g;
    private TextView f4214h;
    private ProgressDialog f4215i;
    private OnClickListener f4216k;
    private TextWatcher f4217l;
    private Handler f4218m;

    /* renamed from: com.antutu.benchmark.activity.FeedbackActivity.1 */
    class C12391 implements OnClickListener {
        final /* synthetic */ FeedbackActivity f4203a;

        C12391(FeedbackActivity feedbackActivity) {
            this.f4203a = feedbackActivity;
        }

        public void onClick(View view) {
        }
    }

    /* renamed from: com.antutu.benchmark.activity.FeedbackActivity.2 */
    class C12402 implements TextWatcher {
        final /* synthetic */ FeedbackActivity f4204a;

        C12402(FeedbackActivity feedbackActivity) {
            this.f4204a = feedbackActivity;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f4204a.f4214h == null) {
                return;
            }
            if (editable.length() > Constants.COMMAND_HANDSHAKE) {
                this.f4204a.f4214h.setTextColor(SupportMenu.CATEGORY_MASK);
            } else {
                this.f4204a.f4214h.setTextColor(-7829368);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f4204a.f4214h != null) {
                this.f4204a.f4214h.setText(charSequence.length() + "/" + Constants.COMMAND_HANDSHAKE);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.activity.FeedbackActivity.3 */
    class C12413 extends Handler {
        final /* synthetic */ FeedbackActivity f4205a;

        C12413(FeedbackActivity feedbackActivity) {
            this.f4205a = feedbackActivity;
        }

        public void handleMessage(Message message) {
            if (this.f4205a.f4215i != null) {
                this.f4205a.f4215i.dismiss();
                this.f4205a.f4215i = null;
            }
            this.f4205a.finish();
        }
    }

    /* renamed from: com.antutu.benchmark.activity.FeedbackActivity.4 */
    class C12424 implements DownloadJobListener {
        final /* synthetic */ FeedbackActivity f4206a;

        C12424(FeedbackActivity feedbackActivity) {
            this.f4206a = feedbackActivity;
        }

        public void downloadEnded(C1519k c1519k) {
            if (c1519k != null) {
                if (((C1529i) c1519k).m6073a() == 1) {
                    Methods.showToast(this.f4206a, (int) C1082R.string.feedback_successful, (int) AdError.NETWORK_ERROR_CODE);
                }
                this.f4206a.f4218m.sendEmptyMessage(0);
            }
        }
    }

    public FeedbackActivity() {
        this.f4207a = Constants.COMMAND_HANDSHAKE;
        this.f4216k = new C12391(this);
        this.f4217l = new C12402(this);
        this.f4218m = new C12413(this);
    }

    public static Intent m5073a(Context context) {
        return m5074a(context, "Action.Feedback.Verify.Error");
    }

    private static Intent m5074a(Context context, String str) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        intent.setAction(str);
        return intent;
    }

    private void m5076a() {
        CharSequence charSequence = BuildConfig.FLAVOR;
        if (!(getIntent() == null || getIntent().getAction() == null)) {
            String action = getIntent().getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case 769457574:
                    if (action.equals("Action.Feedback.Verify.Unknown")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1907935844:
                    if (action.equals("Action.Feedback.Verify.Error")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    charSequence = getIntent().getStringExtra("Feedback.Extra.Content");
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    charSequence = getIntent().getStringExtra("Feedback.Extra.Content");
                    break;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f4208b.setText(charSequence);
        }
    }

    private void m5077a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fbemail=").append(str).append("&").append("feedback=").append(str2).append("&").append(C1503b.m5915c().m5953j(this));
        String dataSafe = jni.getDataSafe(stringBuilder.toString(), BuildConfig.FLAVOR);
        HashMap hashMap = new HashMap();
        hashMap.put("gpv", dataSafe);
        DownloadJob downloadJob = new DownloadJob(this, "http://autovote.antutu.net/proMoudule/index.php?action=feedback&data=1&act=feedback&st=123&do=1", new C1529i(), hashMap);
        downloadJob.setDownloadJobListener(new C12424(this));
        downloadJob.start(true);
    }

    public static Intent m5079b(Context context) {
        return m5074a(context, "Action.Feedback.Verify.Unknown");
    }

    private boolean m5080b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ((ScrollView) findViewById(C1082R.id.feedback_scroll_view)).smoothScrollTo(this.f4208b.getLeft(), this.f4208b.getTop());
            this.f4208b.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(str)) {
            Methods.showToast((Context) this, (int) C1082R.string.email_null, (int) AdError.NETWORK_ERROR_CODE);
            this.f4209c.requestFocus();
            return false;
        } else {
            String language = getResources().getConfiguration().locale.getLanguage();
            String country = getResources().getConfiguration().locale.getCountry();
            if (language != null && language.contains("zh") && country != null && country.contains("CN") && TextUtils.isDigitsOnly(str)) {
                int length = str.length();
                if (length >= 5 && length <= 11) {
                    return true;
                }
                Methods.showToast((Context) this, (int) C1082R.string.qq_number_wrong, (int) AdError.NETWORK_ERROR_CODE);
                this.f4209c.requestFocus();
                return false;
            } else if (Utils.isEmail(str)) {
                return true;
            } else {
                this.f4209c.requestFocus();
                Methods.showToast((Context) this, (int) C1082R.string.email_format_wrong, (int) AdError.NETWORK_ERROR_CODE);
                return false;
            }
        }
    }

    public void onClick(View view) {
        this.f4212f = this.f4208b.getEditableText().toString().trim();
        this.f4213g = this.f4209c.getEditableText().toString().trim();
        switch (view.getId()) {
            case C1082R.id.btn_submit /*2131624094*/:
                if (!NetUtils.isNetworkAvailable()) {
                    Methods.showToast((Context) this, (int) C1082R.string.prompt_net, (int) AdError.NETWORK_ERROR_CODE);
                } else if (this.f4213g == null || BuildConfig.FLAVOR.equals(this.f4213g.trim())) {
                    Methods.showToast((Context) this, (int) C1082R.string.contact_not_be_null, 0);
                } else if (this.f4212f == null || BuildConfig.FLAVOR.equals(this.f4212f.trim())) {
                    Methods.showToast((Context) this, (int) C1082R.string.content_not_be_null, 0);
                } else if (m5080b(this.f4213g, this.f4212f)) {
                    this.f4215i = new ProgressDialog(this);
                    this.f4215i.setProgressStyle(0);
                    this.f4215i.setCancelable(true);
                    this.f4215i.show();
                    Methods.editSharedPreferences("last_feedback_contact", this.f4213g);
                    m5077a(this.f4213g, this.f4212f);
                }
            case C1082R.id.btn_submit_email /*2131624267*/:
                if (this.f4212f == null || BuildConfig.FLAVOR.equals(this.f4212f.trim())) {
                    Methods.showToast((Context) this, (int) C1082R.string.content_not_be_null, 0);
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(getString(C1082R.string.feedback_msg));
                if (!(this.f4213g == null || BuildConfig.FLAVOR.equals(this.f4213g))) {
                    stringBuffer.append(this.f4213g + "--");
                }
                stringBuffer.append(this.f4212f + "--");
                String string = getResources().getString(C4459R.string.app_name);
                try {
                    PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                    string = (string + " v" + packageInfo.versionName) + " versioncode" + packageInfo.versionCode;
                } catch (Exception e) {
                }
                stringBuffer.append(string);
                Methods.sendEmail(this, "support@antutu.com", stringBuffer.toString());
            default:
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.feedback);
        PointMark.getInstance(this).pointThis(PointMark.K_FEEDBACK);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1625b().m6414a(getResources().getString(C1082R.string.feedback)).m6413a(this.j).m6418b(false).m6411a());
        this.f4208b = (EditText) findViewById(C1082R.id.feedback_content_edit);
        this.f4210d = (Button) findViewById(C1082R.id.btn_submit);
        this.f4209c = (EditText) findViewById(C1082R.id.contact_edit);
        this.f4211e = (Button) findViewById(C1082R.id.btn_submit_email);
        this.f4209c.requestFocus();
        this.f4214h = (TextView) findViewById(C1082R.id.edit_counter);
        this.f4214h.setText("0/200");
        this.f4208b.addTextChangedListener(this.f4217l);
        Object sharedPreferencesString = Methods.getSharedPreferencesString("last_feedback_contact", BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(sharedPreferencesString)) {
            this.f4209c.setText(sharedPreferencesString);
            this.f4209c.setSelection(sharedPreferencesString.length());
        } else if (!TextUtils.isEmpty(C1523d.f5233d)) {
            this.f4209c.setText(C1523d.f5233d);
            this.f4209c.setSelection(C1523d.f5233d.length());
        }
        this.f4210d.setOnClickListener(this);
        this.f4211e.setOnClickListener(this);
        m5076a();
    }

    protected void onPause() {
        super.onPause();
        Methods.hideSoftKeyboard(this, getCurrentFocus());
    }
}
