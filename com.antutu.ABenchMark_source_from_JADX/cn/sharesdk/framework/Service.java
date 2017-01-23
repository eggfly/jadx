package cn.sharesdk.framework;

import android.content.Context;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.umeng.message.common.C4209a;
import java.util.HashMap;

public abstract class Service {
    private Context f3169a;
    private String f3170b;

    public static abstract class ServiceEvent {
        private final int PLATFORM;
        protected Service service;

        public ServiceEvent(Service service) {
            this.PLATFORM = 1;
            this.service = service;
        }

        protected HashMap<String, Object> filterShareContent(int i, ShareParams shareParams, HashMap<String, Object> hashMap) {
            C0954a filterShareContent = ShareSDK.getPlatform(ShareSDK.platformIdToName(i)).filterShareContent(shareParams, hashMap);
            HashMap<String, Object> hashMap2 = new HashMap();
            hashMap2.put("shareID", filterShareContent.f3248a);
            hashMap2.put("shareContent", new Hashon().fromJson(filterShareContent.toString()));
            C0979d.m4390a().m4381i("filterShareContent ==>>%s", hashMap2);
            return hashMap2;
        }

        protected HashMap<String, Object> toMap() {
            HashMap<String, Object> hashMap = new HashMap();
            DeviceHelper instance = DeviceHelper.getInstance(this.service.f3169a);
            hashMap.put("deviceid", instance.getDeviceKey());
            hashMap.put(C4209a.f14204g, this.service.getAppKey());
            hashMap.put("apppkg", instance.getPackageName());
            hashMap.put("appver", Integer.valueOf(instance.getAppVersion()));
            hashMap.put("sdkver", Integer.valueOf(this.service.getServiceVersionInt()));
            hashMap.put("plat", Integer.valueOf(1));
            hashMap.put("networktype", instance.getDetailNetworkTypeForStatic());
            hashMap.put("deviceData", instance.getDeviceDataNotAES());
            return hashMap;
        }

        public final String toString() {
            return new Hashon().fromHashMap(toMap());
        }
    }

    void m4070a(Context context) {
        this.f3169a = context;
    }

    void m4071a(String str) {
        this.f3170b = str;
    }

    public String getAppKey() {
        return this.f3170b;
    }

    public Context getContext() {
        return this.f3169a;
    }

    public String getDeviceKey() {
        return DeviceHelper.getInstance(this.f3169a).getDeviceKey();
    }

    protected abstract int getServiceVersionInt();

    public abstract String getServiceVersionName();

    public void onBind() {
    }

    public void onUnbind() {
    }
}
