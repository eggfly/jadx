package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.StringUtils;

/* renamed from: anet.channel.strategy.dispatch.a */
public class C0714a {
    public static final String ANDROID = "android";
    public static final String APPKEY = "appkey";
    public static final String APP_NAME = "appName";
    public static final String APP_VERSION = "appVersion";
    public static final String BSSID = "bssid";
    public static final String CHANNEL = "channel";
    public static final String CONFIG_VERSION = "cv";
    public static final String CONN_MSG = "connMsg";
    public static final String DEVICEID = "deviceId";
    public static final String DOMAIN = "domain";
    public static final String HOSTS = "hosts";
    public static final String LATITUDE = "lat";
    public static final String LONGTITUDE = "lng";
    public static final String MACHINE = "machine";
    public static final String NET_TYPE = "netType";
    public static final String OTHER = "lng";
    public static final String PLATFORM = "platform";
    public static final String PLATFORM_VERSION = "platformVersion";
    public static final String PRE_IP = "preIp";
    public static final String SID = "sid";
    public static final String SIGN = "sign";
    public static final String SIGNTYPE = "signType";
    public static final String TIMESTAMP = "t";
    public static final String VERSION = "v";
    public static final String VER_CODE = "3.1";
    public static String[] f2352a = null;
    public static String[] f2353b = null;
    public static String[][] f2354c = null;
    public static final String serverPath = "/amdc/mobileDispatch";

    static {
        f2352a = new String[]{"h5.m.taobao.com", "gw.alicdn.com", "g.tbcdn.cn", "hws.m.taobao.com", "api.m.taobao.com", "upload.m.taobao.com", "www.taobao.com", "gtms03.alicdn.com", "img.alicdn.com", "dorangesource.alicdn.com", "adash.m.taobao.com", "g.alicdn.com", "mobilegw.alipay.com", "ynuf.alipay.com", "log.mmstat.com"};
        f2353b = new String[]{"amdc.m.taobao.com", "amdc.wapa.taobao.com", "api.waptest.taobao.com"};
        r0 = new String[3][];
        r0[0] = new String[]{StringUtils.longToIP(140205163087L), StringUtils.longToIP(140205160063L), StringUtils.longToIP(106011012092L)};
        r0[1] = new String[]{StringUtils.longToIP(106011052006L)};
        r0[2] = new String[]{StringUtils.longToIP(10218134029L)};
        f2354c = r0;
    }

    public static String m2914a() {
        return f2353b[GlobalAppRuntimeInfo.getEnv().getEnvMode()];
    }

    public static boolean m2915a(String str) {
        return TextUtils.isEmpty(str) ? false : str.equalsIgnoreCase(C0714a.m2914a());
    }

    public static String[] m2916b() {
        return f2354c[GlobalAppRuntimeInfo.getEnv().getEnvMode()];
    }
}
