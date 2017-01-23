package com.antutu.benchmark;

import android.content.Context;
import android.support.p012b.C0167a;
import android.support.p012b.C0168b;
import android.util.Log;
import com.antutu.benchmark.p041d.C1376c;
import com.antutu.utils.MLog;
import com.antutu.utils.PushMessageUtil;
import com.antutu.utils.Utils;
import com.antutu.utils.infoc.InfocSupportContext;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.common.inter.ITagManager.Result;
import com.umeng.message.tag.TagManager.TCallBack;
import com.xiaomi.pushsdk.MiPushUtil;

public class ABenchmarkApplication extends C0168b {
    static Context f3645a;
    static C1376c f3646b;
    public static int f3647c;

    /* renamed from: com.antutu.benchmark.ABenchmarkApplication.1 */
    class C10831 implements IUmengRegisterCallback {
        final /* synthetic */ ABenchmarkApplication f3643a;

        C10831(ABenchmarkApplication aBenchmarkApplication) {
            this.f3643a = aBenchmarkApplication;
        }

        public void onFailure(String str, String str2) {
            Log.d("PushAgent", "register onFailure");
            Log.e("PushAgent", String.valueOf(str));
            Log.e("PushAgent", String.valueOf(str2));
        }

        public void onSuccess(String str) {
            Log.d("PushAgent", "register onSuccess");
            Log.d("PushAgent", "device_token = " + str);
        }
    }

    /* renamed from: com.antutu.benchmark.ABenchmarkApplication.2 */
    class C10842 implements TCallBack {
        final /* synthetic */ ABenchmarkApplication f3644a;

        C10842(ABenchmarkApplication aBenchmarkApplication) {
            this.f3644a = aBenchmarkApplication;
        }

        public void onMessage(boolean z, Result result) {
            if (z) {
                MLog.m6865d("PushAgent", "add Tag Success!!");
            } else {
                MLog.m6865d("PushAgent", "add Tag Failure!!");
            }
            MLog.m6865d("PushAgent", String.valueOf(result));
        }
    }

    static {
        f3647c = 0;
    }

    public static Context getContext() {
        return f3645a;
    }

    public static C1376c getDatabaseProvider() {
        return f3646b;
    }

    private void initImageLoader() {
        Builder builder = new Builder(getApplicationContext());
        builder.threadPriority(3);
        builder.denyCacheImageMultipleSizesInMemory();
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        builder.diskCacheSize(52428800);
        builder.tasksProcessingOrder(QueueProcessingType.LIFO);
        ImageLoader.getInstance().init(builder.build());
    }

    public static final void setContext(Context context) {
        f3645a = context;
    }

    private void setUmengPush() {
        PushAgent.getInstance(this).setMessageChannel(String.valueOf(InfocSupportContext.getOemId(this)));
        PushAgent.getInstance(this).register(new C10831(this));
        PushAgent.getInstance(this).setNotificationClickHandler(new C1342b());
        PushAgent.getInstance(this).setMessageHandler(new C1194a());
        PushAgent.getInstance(this).getTagManager().add(new C10842(this), Utils.getLocalLanguage(this));
        PushAgent.getInstance(this).setDebugMode(false);
        PushAgent.getInstance(this).setPushCheck(false);
    }

    public void onCreate() {
        C0167a.m789a(getApplicationContext());
        super.onCreate();
        MLog.m6864d("OnCreate");
        f3645a = getApplicationContext();
        f3646b = new C1376c(f3645a);
        initImageLoader();
        MiPushUtil.initMiPush(this, InfocSupportContext.getOemId(this), "6.3.3");
        setUmengPush();
    }

    public void onLowMemory() {
        PushMessageUtil.openLiveService(this);
        super.onLowMemory();
    }
}
