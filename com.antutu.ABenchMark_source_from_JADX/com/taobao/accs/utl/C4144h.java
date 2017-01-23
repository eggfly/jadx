package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ChannelService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.taobao.accs.utl.h */
public class C4144h {
    public static final String NAMESPACE = "accs";
    private static boolean f13897a;

    /* renamed from: com.taobao.accs.utl.h.a */
    public static class C4143a implements OrangeConfigListenerV1 {
        public void onConfigUpdate(String str, boolean z) {
            if (GlobalClientInfo.getContext() == null) {
                ALog.m16903e("OrangeAdapter", "onConfigUpdate context null", new Object[0]);
                return;
            }
            try {
                ALog.m16904i("OrangeAdapter", "onConfigUpdate", "namespace", str);
                if (str != null && C4144h.NAMESPACE.equals(str)) {
                    C4144h.m16947d();
                    Map hashMap = new HashMap();
                    hashMap.put(Constants.SP_KEY_TNET_LOG_OFF, Boolean.valueOf(C4144h.m16935a(C4144h.NAMESPACE, Constants.SP_KEY_TNET_LOG_OFF, "false")));
                    hashMap.put(Constants.SP_KEY_ELECTION_ENABLE, Boolean.valueOf(C4144h.m16935a(C4144h.NAMESPACE, Constants.SP_KEY_ELECTION_ENABLE, "true")));
                    hashMap.put(Constants.SP_KEY_HB_SMART_ENABLE, Boolean.valueOf(C4144h.m16935a(C4144h.NAMESPACE, "heartbeat_smart_enable", "true")));
                    C4144h.m16944b(GlobalClientInfo.getContext(), hashMap);
                    C4144h.m16942b(GlobalClientInfo.getContext(), ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, UtilityImpl.String2Int(C4144h.m16935a(C4144h.NAMESPACE, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, "-1")));
                }
            } catch (Throwable th) {
                ALog.m16902e("OrangeAdapter", "onConfigUpdate", th, new Object[0]);
            }
        }
    }

    static {
        f13897a = false;
        try {
            Class.forName("com.taobao.orange.OrangeConfig");
            f13897a = true;
        } catch (Exception e) {
            f13897a = false;
        }
    }

    public static String m16935a(String str, String str2, String str3) {
        if (f13897a) {
            return OrangeConfig.getInstance().getConfig(str, str2, str3);
        }
        ALog.m16906w("OrangeAdapter", "no orange sdk", new Object[0]);
        return str3;
    }

    public static void m16938a(String[] strArr, OrangeConfigListenerV1 orangeConfigListenerV1) {
        if (f13897a) {
            OrangeConfig.getInstance().registerListener(strArr, orangeConfigListenerV1);
        } else {
            ALog.m16906w("OrangeAdapter", "no orange sdk", new Object[0]);
        }
    }

    public static boolean m16939a() {
        boolean booleanValue;
        try {
            booleanValue = Boolean.valueOf(C4144h.m16935a(NAMESPACE, "main_function_enable", "true")).booleanValue();
        } catch (Throwable th) {
            ALog.m16902e("OrangeAdapter", "isAccsEnabled", th, new Object[0]);
            booleanValue = true;
        }
        ALog.m16904i("OrangeAdapter", "isAccsEnabled", "enable", Boolean.valueOf(booleanValue));
        return booleanValue;
    }

    private static boolean m16940a(Context context, String str, boolean z) {
        try {
            z = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(str, z);
        } catch (Throwable e) {
            ALog.m16902e("OrangeAdapter", "getConfigFromSP fail:", e, "key", str);
        }
        return z;
    }

    public static boolean m16941a(boolean z) {
        boolean a;
        Throwable th;
        try {
            String str = "default";
            if (z) {
                str = C4144h.m16935a(NAMESPACE, Constants.SP_KEY_TNET_LOG_OFF, "default");
            }
            if (str.equals("default")) {
                a = C4144h.m16940a(GlobalClientInfo.getContext(), Constants.SP_KEY_TNET_LOG_OFF, false);
            } else {
                a = Boolean.valueOf(str).booleanValue();
                try {
                    C4144h.m16943b(GlobalClientInfo.getContext(), Constants.SP_KEY_TNET_LOG_OFF, a);
                } catch (Throwable th2) {
                    th = th2;
                    ALog.m16902e("OrangeAdapter", "isTnetLogOff", th, new Object[0]);
                    ALog.m16904i("OrangeAdapter", "isTnetLogOff", "result", Boolean.valueOf(a));
                    return a;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            a = false;
            ALog.m16902e("OrangeAdapter", "isTnetLogOff", th, new Object[0]);
            ALog.m16904i("OrangeAdapter", "isTnetLogOff", "result", Boolean.valueOf(a));
            return a;
        }
        ALog.m16904i("OrangeAdapter", "isTnetLogOff", "result", Boolean.valueOf(a));
        return a;
    }

    private static void m16942b(Context context, String str, int i) {
        if (context == null) {
            try {
                ALog.m16903e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            } catch (Throwable e) {
                ALog.m16902e("OrangeAdapter", "saveConfigToSP fail:", e, "key", str, "value", Integer.valueOf(i));
            }
        } else {
            Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(str, i);
            edit.apply();
            ALog.m16904i("OrangeAdapter", "saveConfigToSP", "key", str, "value", Integer.valueOf(i));
        }
    }

    private static void m16943b(Context context, String str, boolean z) {
        if (context == null) {
            try {
                ALog.m16903e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            } catch (Throwable e) {
                ALog.m16902e("OrangeAdapter", "saveConfigToSP fail:", e, "key", str, "value", Boolean.valueOf(z));
            }
        } else {
            Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putBoolean(str, z);
            edit.apply();
            ALog.m16904i("OrangeAdapter", "saveConfigToSP", "key", str, "value", Boolean.valueOf(z));
        }
    }

    private static void m16944b(Context context, Map<String, Boolean> map) {
        if (map != null) {
            try {
                if (map.size() != 0) {
                    Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                    for (Entry entry : map.entrySet()) {
                        edit.putBoolean((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                    }
                    edit.apply();
                    ALog.m16904i("OrangeAdapter", "saveConfigsToSP", "configs", map.toString());
                }
            } catch (Throwable e) {
                ALog.m16902e("OrangeAdapter", "saveConfigsToSP fail:", e, "configs", map.toString());
            }
        }
    }

    public static boolean m16945b() {
        boolean a;
        try {
            a = C4144h.m16940a(GlobalClientInfo.getContext(), Constants.SP_KEY_HB_SMART_ENABLE, true);
        } catch (Throwable th) {
            ALog.m16902e("OrangeAdapter", "isSmartHb", th, new Object[0]);
            a = true;
        }
        ALog.m16901d("OrangeAdapter", "isSmartHb", "result", Boolean.valueOf(a));
        return a;
    }

    public static boolean m16946c() {
        boolean a;
        boolean z = GlobalClientInfo.f13608c;
        try {
            a = C4144h.m16940a(GlobalClientInfo.getContext(), Constants.SP_KEY_ELECTION_ENABLE, GlobalClientInfo.f13608c);
        } catch (Throwable th) {
            ALog.m16902e("OrangeAdapter", "isElectionEnable", th, new Object[0]);
            a = z;
        }
        if (!a) {
            ALog.m16903e("OrangeAdapter", "isElectionEnable", "result", Boolean.valueOf(a));
        }
        return a;
    }

    public static void m16947d() {
        if (!C4144h.m16939a()) {
            ALog.m16903e("OrangeAdapter", "force disable service", new Object[0]);
            ACCSManager.forceDisableService(GlobalClientInfo.getContext());
        } else if (UtilityImpl.getFocusDisableStatus(GlobalClientInfo.getContext())) {
            ALog.m16904i("OrangeAdapter", "force enable service", new Object[0]);
            ACCSManager.forceEnableService(GlobalClientInfo.getContext());
        }
    }
}
