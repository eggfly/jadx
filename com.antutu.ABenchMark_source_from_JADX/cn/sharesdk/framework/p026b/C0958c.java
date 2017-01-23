package cn.sharesdk.framework.p026b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.strategy.dispatch.C0714a;
import cn.sharesdk.framework.p026b.p027a.C0945c;
import cn.sharesdk.framework.p026b.p027a.C0946d;
import cn.sharesdk.framework.p026b.p027a.C0947e;
import cn.sharesdk.framework.p026b.p028b.C0949c;
import cn.sharesdk.framework.utils.C0979d;
import com.igexin.sdk.PushBuildConfig;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.umeng.message.util.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import org.android.agoo.message.MessageService;

/* renamed from: cn.sharesdk.framework.b.c */
public class C0958c {
    private String f3268a;
    private Context f3269b;
    private C0947e f3270c;
    private DeviceHelper f3271d;
    private NetworkHelper f3272e;
    private Hashon f3273f;
    private String f3274g;
    private String f3275h;
    private boolean f3276i;
    private HashMap<String, String> f3277j;

    public C0958c(Context context, String str) {
        this.f3268a = str;
        this.f3269b = context.getApplicationContext();
        this.f3270c = C0947e.m4134a(this.f3269b);
        this.f3271d = DeviceHelper.getInstance(this.f3269b);
        this.f3272e = new NetworkHelper();
        this.f3273f = new Hashon();
        try {
            this.f3277j = (HashMap) this.f3270c.m4157h("buffered_server_paths");
        } catch (Throwable th) {
            this.f3277j = new HashMap();
        }
        m4235g();
    }

    private String m4234d(String str) {
        boolean b = this.f3270c.m4145b();
        boolean c = this.f3270c.m4147c();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Data.urlEncode(this.f3271d.getPackageName(), "utf-8")).append("|");
        stringBuilder.append(Data.urlEncode(this.f3271d.getAppVersionName(), "utf-8")).append("|");
        stringBuilder.append(Data.urlEncode(String.valueOf(60068), "utf-8")).append("|");
        stringBuilder.append(Data.urlEncode(String.valueOf(this.f3271d.getPlatformCode()), "utf-8")).append("|");
        stringBuilder.append(Data.urlEncode(this.f3271d.getDetailNetworkTypeForStatic(), "utf-8")).append("|");
        if (b) {
            stringBuilder.append(Data.urlEncode(String.valueOf(this.f3271d.getOSVersionInt()), "utf-8")).append("|");
            stringBuilder.append(Data.urlEncode(this.f3271d.getScreenSize(), "utf-8")).append("|");
            stringBuilder.append(Data.urlEncode(this.f3271d.getManufacturer(), "utf-8")).append("|");
            stringBuilder.append(Data.urlEncode(this.f3271d.getModel(), "utf-8")).append("|");
            stringBuilder.append(Data.urlEncode(this.f3271d.getCarrier(), "utf-8")).append("|");
        } else {
            stringBuilder.append("|||||");
        }
        if (c) {
            stringBuilder.append(str);
        } else {
            stringBuilder.append(str.split("\\|")[0]);
            stringBuilder.append("|||||");
        }
        C0979d.m4390a().m4381i("shorLinkMsg ===>>>>", stringBuilder.toString());
        return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", new Object[]{this.f3271d.getDeviceKey(), this.f3268a})), stringBuilder.toString()), 2);
    }

    private void m4235g() {
        String str = this.f3271d.getPackageName() + "/" + this.f3271d.getAppVersionName();
        this.f3274g = str + " " + "ShareSDK/2.7.10" + " " + ("Android/" + this.f3271d.getOSVersionInt());
        this.f3275h = "http://api.share.mob.com:80";
        this.f3276i = true;
    }

    private String m4236h() {
        return this.f3275h + "/conn";
    }

    private String m4237i() {
        return (this.f3277j == null || !this.f3277j.containsKey("/date")) ? this.f3275h + "/date" : ((String) this.f3277j.get("/date")) + "/date";
    }

    private String m4238j() {
        return this.f3275h + "/conf5";
    }

    private String m4239k() {
        return "http://up.sharesdk.cn/upload/image";
    }

    private String m4240l() {
        return (this.f3277j == null || !this.f3277j.containsKey("/log4")) ? this.f3275h + "/log4" : ((String) this.f3277j.get("/log4")) + "/log4";
    }

    private String m4241m() {
        return "http://l.mob.com/url/ShareSdkMapping.do";
    }

    private String m4242n() {
        return (this.f3277j == null || !this.f3277j.containsKey("/snsconf")) ? this.f3275h + "/snsconf" : ((String) this.f3277j.get("/snsconf")) + "/snsconf";
    }

    public HashMap<String, Object> m4243a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(C4209a.f14204g, this.f3268a));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, this.f3274g));
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = 30000;
        networkTimeOut.connectionTimeout = 30000;
        C0979d.m4390a().m4381i(" isConnectToServer response == %s", this.f3272e.httpPost(m4236h(), arrayList, null, arrayList2, networkTimeOut));
        return this.f3273f.fromJson(this.f3272e.httpPost(m4236h(), arrayList, null, arrayList2, networkTimeOut));
    }

    public HashMap<String, Object> m4244a(String str, ArrayList<String> arrayList, int i, String str2) {
        if (!this.f3276i) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair("key", this.f3268a));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(new KVPair("urls", ((String) arrayList.get(i2)).toString()));
        }
        arrayList2.add(new KVPair("deviceid", this.f3271d.getDeviceKey()));
        arrayList2.add(new KVPair("snsplat", String.valueOf(i)));
        CharSequence d = m4234d(str2);
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        arrayList2.add(new KVPair("m", d));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new KVPair(HttpRequest.f14569v, this.f3274g));
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        networkTimeOut.connectionTimeout = BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        String httpPost = this.f3272e.httpPost(m4241m(), arrayList2, null, arrayList3, networkTimeOut);
        C0979d.m4390a().m4381i("> SERVER_SHORT_LINK_URL  resp: %s", httpPost);
        if (TextUtils.isEmpty(httpPost)) {
            this.f3276i = false;
            return null;
        }
        HashMap<String, Object> fromJson = this.f3273f.fromJson(httpPost);
        return ((Integer) fromJson.get(MsgConstant.KEY_STATUS)).intValue() == Constants.COMMAND_HANDSHAKE ? fromJson : null;
    }

    public void m4245a(C0949c c0949c) {
        C0946d.m4130a(this.f3269b, c0949c.toString(), c0949c.f3221e);
    }

    public void m4246a(String str) {
        this.f3275h = str;
    }

    public void m4247a(ArrayList<String> arrayList) {
        C0946d.m4131a(this.f3269b, arrayList);
    }

    public void m4248a(HashMap<String, String> hashMap) {
        this.f3277j = hashMap;
        this.f3270c.m4140a("buffered_server_paths", this.f3277j);
    }

    public boolean m4249a(String str, boolean z) {
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals(this.f3271d.getDetailNetworkTypeForStatic())) {
                throw new IllegalStateException("network is disconnected!");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("m", str));
            arrayList.add(new KVPair(C0714a.TIMESTAMP, z ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KVPair(HttpRequest.f14569v, this.f3274g));
            NetworkTimeOut networkTimeOut = new NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            String httpPost = this.f3272e.httpPost(m4240l(), arrayList, null, arrayList2, networkTimeOut);
            C0979d.m4390a().m4381i("> Upload All Log  resp: %s", httpPost);
            return TextUtils.isEmpty(httpPost) || ((Integer) this.f3273f.fromJson(httpPost).get(MsgConstant.KEY_STATUS)).intValue() == Constants.COMMAND_HANDSHAKE;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return false;
        }
    }

    public long m4250b() {
        if (!this.f3270c.m4155g()) {
            return 0;
        }
        String str = "{}";
        try {
            str = this.f3272e.httpGet(m4237i(), null, null, null);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        HashMap fromJson = this.f3273f.fromJson(str);
        if (!fromJson.containsKey("timestamp")) {
            return this.f3270c.m4135a();
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - C4021R.parseLong(String.valueOf(fromJson.get("timestamp")));
            this.f3270c.m4139a("service_time", Long.valueOf(currentTimeMillis));
            return currentTimeMillis;
        } catch (Throwable th2) {
            C0979d.m4390a().m4376d(th2);
            return this.f3270c.m4135a();
        }
    }

    public HashMap<String, Object> m4251b(String str) {
        KVPair kVPair = new KVPair("file", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(HttpRequest.f14569v, this.f3274g));
        C0979d.m4390a().m4381i("upload file response == %s", this.f3272e.httpPost(m4239k(), null, kVPair, arrayList, null));
        return this.f3273f.fromJson(this.f3272e.httpPost(m4239k(), null, kVPair, arrayList, null));
    }

    public void m4252b(HashMap<String, Object> hashMap) {
        this.f3270c.m4141a(this.f3268a, this.f3273f.fromHashMap(hashMap));
    }

    public HashMap<String, Object> m4253c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(C4209a.f14204g, this.f3268a));
        arrayList.add(new KVPair("device", this.f3271d.getDeviceKey()));
        arrayList.add(new KVPair("plat", String.valueOf(this.f3271d.getPlatformCode())));
        arrayList.add(new KVPair("apppkg", this.f3271d.getPackageName()));
        arrayList.add(new KVPair("appver", String.valueOf(this.f3271d.getAppVersion())));
        arrayList.add(new KVPair("sdkver", String.valueOf(60068)));
        arrayList.add(new KVPair("networktype", this.f3271d.getDetailNetworkTypeForStatic()));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, this.f3274g));
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        C0979d.m4390a().m4381i(" get server config response == %s", this.f3272e.httpPost(m4238j(), arrayList, null, arrayList2, networkTimeOut));
        return this.f3273f.fromJson(this.f3272e.httpPost(m4238j(), arrayList, null, arrayList2, networkTimeOut));
    }

    public HashMap<String, Object> m4254c(String str) {
        return this.f3273f.fromJson(new String(Data.AES128Decode(Data.rawMD5(this.f3268a + ":" + this.f3271d.getDeviceKey()), Base64.decode(str, 2)), HttpRequest.f14548a).trim());
    }

    public HashMap<String, Object> m4255d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KVPair(C4209a.f14204g, this.f3268a));
        arrayList.add(new KVPair("device", this.f3271d.getDeviceKey()));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new KVPair(HttpRequest.f14569v, this.f3274g));
        NetworkTimeOut networkTimeOut = new NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        return this.f3273f.fromJson(this.f3272e.httpPost(m4242n(), arrayList, null, arrayList2, networkTimeOut));
    }

    public ArrayList<C0945c> m4256e() {
        ArrayList<C0945c> a = C0946d.m4132a(this.f3269b);
        return a == null ? new ArrayList() : a;
    }

    public HashMap<String, Object> m4257f() {
        return this.f3273f.fromJson(this.f3270c.m4151e(this.f3268a));
    }
}
