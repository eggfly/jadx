package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.view.CommonTitleView;
import com.antutu.benchmark.view.CommonTitleView.C1624a;
import com.antutu.benchmark.view.SettingTextAndToggle;
import com.antutu.utils.MLog;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.PointMark;
import com.antutu.utils.SPConstants;
import com.igexin.sdk.PushManager;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.IUmengCallback;
import com.umeng.message.PushAgent;

public class SettingsActivity extends C1197a {
    boolean f4464a;
    boolean f4465b;
    private SettingTextAndToggle f4466c;
    private SettingTextAndToggle f4467d;

    /* renamed from: com.antutu.benchmark.activity.SettingsActivity.1 */
    class C13021 implements OnCheckedChangeListener {
        final /* synthetic */ SettingsActivity f4460a;

        C13021(SettingsActivity settingsActivity) {
            this.f4460a = settingsActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4460a.f4464a = z;
            Methods.editSharedPreferences(SPConstants.SHARE_PREF_KEY_AUTO_UPDATE, this.f4460a.f4464a);
        }
    }

    /* renamed from: com.antutu.benchmark.activity.SettingsActivity.2 */
    class C13052 implements OnCheckedChangeListener {
        final /* synthetic */ SettingsActivity f4463a;

        /* renamed from: com.antutu.benchmark.activity.SettingsActivity.2.1 */
        class C13031 implements IUmengCallback {
            final /* synthetic */ C13052 f4461a;

            C13031(C13052 c13052) {
                this.f4461a = c13052;
            }

            public void onFailure(String str, String str2) {
                MLog.m6865d("PushAgent", "enable() onFailure!!");
                Log.e("PushAgent", String.valueOf(str));
                Log.e("PushAgent", String.valueOf(str2));
            }

            public void onSuccess() {
                MLog.m6865d("PushAgent", "enable() onSuccess!!");
            }
        }

        /* renamed from: com.antutu.benchmark.activity.SettingsActivity.2.2 */
        class C13042 implements IUmengCallback {
            final /* synthetic */ C13052 f4462a;

            C13042(C13052 c13052) {
                this.f4462a = c13052;
            }

            public void onFailure(String str, String str2) {
                MLog.m6865d("PushAgent", "disable() onFailure!!");
                Log.e("PushAgent", String.valueOf(str));
                Log.e("PushAgent", String.valueOf(str2));
            }

            public void onSuccess() {
                MLog.m6865d("PushAgent", "disable() onSuccess!!");
            }
        }

        C13052(SettingsActivity settingsActivity) {
            this.f4463a = settingsActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4463a.f4465b = z;
            if (this.f4463a.f4465b) {
                PushAgent.getInstance(compoundButton.getContext()).enable(new C13031(this));
                PushManager.getInstance().initialize(compoundButton.getContext());
                MobclickAgent.onEvent(compoundButton.getContext(), MobclickAgentConstants.click_push_open);
            } else {
                PushAgent.getInstance(compoundButton.getContext()).disable(new C13042(this));
                PushManager.getInstance().stopService(compoundButton.getContext());
                MobclickAgent.onEvent(compoundButton.getContext(), MobclickAgentConstants.click_push_close);
            }
            Methods.editSharedPreferences(SPConstants.SHARE_PREF_KEY_AUTO_PUSH, this.f4463a.f4465b);
        }
    }

    public SettingsActivity() {
        this.f4464a = true;
        this.f4465b = true;
    }

    private void m5279a() {
        this.f4466c.setSlideListener(new C13021(this));
        this.f4467d.setSlideListener(new C13052(this));
    }

    private void m5280b() {
        this.f4464a = Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_AUTO_UPDATE, true);
        this.f4465b = Methods.getSharedPreferencesBoolean(SPConstants.SHARE_PREF_KEY_AUTO_PUSH, true);
        this.f4466c.setState(this.f4464a);
        this.f4467d.setState(this.f4465b);
    }

    private void m5281c() {
        this.f4466c = (SettingTextAndToggle) findViewById(C1082R.id.stt_auto_update);
        this.f4467d = (SettingTextAndToggle) findViewById(C1082R.id.stt_push_msg);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.settings);
        PointMark.getInstance(this).pointThis(PointMark.K_SETTING);
        ((CommonTitleView) findViewById(C1082R.id.title_layout)).setMode(new C1624a(C1082R.drawable.main_title_icon_back, getResources().getString(C1082R.string.setting), false, this.j, null));
        m5281c();
        m5280b();
        m5279a();
    }
}
