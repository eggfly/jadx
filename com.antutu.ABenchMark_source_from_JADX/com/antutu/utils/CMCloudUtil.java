package com.antutu.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.p043g.C1503b;
import com.cmcm.p074a.p075a.C1788a;
import com.cmcm.p074a.p075a.C2135b;
import com.ijinshan.cloudconfig.deepcloudconfig.C3957a;
import com.ijinshan.cloudconfig.deepcloudconfig.C3958b;
import com.ijinshan.cloudconfig.deepcloudconfig.C3961e;
import com.ijinshan.cloudconfig.p073a.C1786a;
import com.ijinshan.cloudconfig.p073a.C3950b;
import com.ijinshan.cloudconfig.p188c.C3952a;
import com.xiaomi.pushsdk.BuildConfig;

public class CMCloudUtil {

    /* renamed from: com.antutu.utils.CMCloudUtil.1 */
    static class C17871 implements C1786a {
        final /* synthetic */ String val$channelId;
        final /* synthetic */ PackageInfo val$info;

        C17871(PackageInfo packageInfo, String str) {
            this.val$info = packageInfo;
            this.val$channelId = str;
        }

        public String getApkVersion() {
            return this.val$info.versionName;
        }

        public String getChannelId() {
            return this.val$channelId;
        }

        public String getLanParams() {
            return C1503b.m5915c().m5942e();
        }

        public String getPkgName() {
            return "com.antutu.abenchmark";
        }
    }

    /* renamed from: com.antutu.utils.CMCloudUtil.2 */
    static class C17892 implements C1788a {
        C17892() {
        }

        public boolean getBoolValue(Integer num, String str, String str2, boolean z) {
            return C3958b.m16290a(num, str, str2, z);
        }

        public double getDoubleValue(Integer num, String str, String str2, double d) {
            return C3958b.m16284a(num, str, str2, d);
        }

        public int getIntValue(Integer num, String str, String str2, int i) {
            return C3958b.m16285a(num, str, str2, i);
        }

        public long getLongValue(Integer num, String str, String str2, long j) {
            return C3958b.m16286a(num, str, str2, j);
        }

        public String getStringValue(Integer num, String str, String str2, String str3) {
            return C3958b.m16287a(num, str, str2, str3);
        }
    }

    public static final void initCloudConfig(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            C3952a.m16242a(ABenchmarkApplication.getContext());
            String str = C1503b.m5915c().m5954k() + BuildConfig.FLAVOR;
            C3952a.m16244a(str, "antutu");
            C3950b.m16232a(new C17871(packageInfo, str));
            C3961e.m16292a().m16306b();
            C3952a.m16252f();
            C3961e.m16292a().m16307c();
            if (Methods.getSharedPreferencesBoolean(SPConstants.FIRST_LOAD_CLOUD_CONFIG, true)) {
                Methods.editSharedPreferences(SPConstants.FIRST_LOAD_CLOUD_CONFIG, false);
            } else {
                C3957a.m16278a().m16283b();
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initDmc(Context context) {
        try {
            C2135b.m8062a().m8063a(context, 0, new C17892());
        } catch (Exception e) {
            MLog.m6865d("hch", "dmc error");
            e.printStackTrace();
        }
    }
}
