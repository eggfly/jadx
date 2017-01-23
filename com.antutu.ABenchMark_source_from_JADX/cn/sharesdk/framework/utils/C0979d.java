package cn.sharesdk.framework.utils;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;

/* renamed from: cn.sharesdk.framework.utils.d */
public class C0979d extends NLog {

    /* renamed from: cn.sharesdk.framework.utils.d.1 */
    class C09781 extends LogsCollector {
        final /* synthetic */ int f3352a;
        final /* synthetic */ String f3353b;
        final /* synthetic */ C0979d f3354c;

        C09781(C0979d c0979d, Context context, int i, String str) {
            this.f3354c = c0979d;
            this.f3352a = i;
            this.f3353b = str;
            super(context);
        }

        protected String getAppkey() {
            return this.f3353b;
        }

        protected String getSDKTag() {
            return ShareSDK.SDK_TAG;
        }

        protected int getSDKVersion() {
            return this.f3352a;
        }
    }

    private C0979d(Context context, int i, String str) {
        NLog.setCollector(ShareSDK.SDK_TAG, new C09781(this, context, i, str));
    }

    public static NLog m4390a() {
        return NLog.getInstanceForSDK(ShareSDK.SDK_TAG, true);
    }

    public static NLog m4391a(Context context, int i, String str) {
        return new C0979d(context, i, str);
    }

    protected String getSDKTag() {
        return ShareSDK.SDK_TAG;
    }
}
