package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.base.TaoBaseService.ExtHeaderType;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.C4112a;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.C4139d.C4138a;
import com.taobao.accs.utl.C4141f;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;
import org.android.agoo.intent.IntentUtil;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.json.JSONArray;
import org.json.JSONObject;

public class Message implements Serializable {
    public static int CONTROL_MAX_RETRY_TIMES = 0;
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;
    static long f13655a;
    byte[] f13656A;
    int f13657B;
    long f13658C;
    transient NetPerformanceMonitor f13659D;
    public String appSign;
    byte f13660b;
    public String bizId;
    byte f13661c;
    public Integer command;
    public String cunstomDataId;
    short f13662d;
    public String dataId;
    public long delyTime;
    short f13663e;
    short f13664f;
    public boolean force;
    byte f13665g;
    byte f13666h;
    public URL host;
    String f13667i;
    public boolean isAck;
    public boolean isCancel;
    String f13668j;
    int f13669k;
    Map<ExtHeaderType, String> f13670l;
    String f13671m;
    Integer f13672n;
    String f13673o;
    Integer f13674p;
    String f13675q;
    String f13676r;
    public int retryTimes;
    String f13677s;
    public String serviceId;
    public long startSendTime;
    Integer f13678t;
    public int timeout;
    String f13679u;
    public String userinfo;
    String f13680v;
    String f13681w;
    String f13682x;
    String f13683y;
    String f13684z;

    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return DATA;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return ACK;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return REQ;
                case Message.MAX_RETRY_TIMES /*3*/:
                    return RES;
                default:
                    return DATA;
            }
        }
    }

    /* renamed from: com.taobao.accs.data.Message.a */
    public static class C4093a {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static int m16697a(int i) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return 0;
                default:
                    return NEED_ACK;
            }
        }

        public static String m16698b(int i) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return "NO_ACK";
                case NEED_ACK /*1*/:
                    return "NEED_ACK";
                default:
                    return "INVALID";
            }
        }
    }

    /* renamed from: com.taobao.accs.data.Message.b */
    public static class C4094b {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static int m16699a(int i) {
            switch (i) {
                case DATA /*1*/:
                    return DATA;
                case PING /*2*/:
                    return PING;
                case HANDSHAKE /*3*/:
                    return HANDSHAKE;
                default:
                    return CONTROL;
            }
        }

        public static String m16700b(int i) {
            switch (i) {
                case CONTROL /*0*/:
                    return "CONTROL";
                case DATA /*1*/:
                    return "DATA";
                case PING /*2*/:
                    return "PING";
                case HANDSHAKE /*3*/:
                    return "HANDSHAKE";
                default:
                    return "INVALID";
            }
        }
    }

    static {
        CONTROL_MAX_RETRY_TIMES = 5;
        f13655a = 1;
    }

    private Message() {
        this.isAck = false;
        this.force = false;
        this.isCancel = false;
        this.f13660b = (byte) 0;
        this.f13661c = (byte) 0;
        this.f13669k = -1;
        this.f13671m = null;
        this.command = null;
        this.f13672n = Integer.valueOf(0);
        this.f13673o = null;
        this.appSign = null;
        this.f13674p = null;
        this.f13675q = null;
        this.f13676r = null;
        this.f13677s = null;
        this.f13678t = null;
        this.f13679u = null;
        this.f13680v = null;
        this.userinfo = null;
        this.serviceId = null;
        this.f13681w = null;
        this.f13682x = null;
        this.f13683y = null;
        this.f13684z = null;
        this.delyTime = 0;
        this.retryTimes = 0;
        this.timeout = C4112a.ACCS_RECEIVE_TIMEOUT;
        this.bizId = null;
        synchronized (Message.class) {
            long j = f13655a;
            f13655a = 1 + j;
            this.dataId = String.valueOf(j);
        }
        this.startSendTime = System.currentTimeMillis();
    }

    public static Message BuildPing(boolean z, int i) {
        Message message = new Message();
        message.f13669k = 2;
        message.command = Integer.valueOf(Constants.COMMAND_PING);
        message.force = z;
        message.delyTime = (long) i;
        return message;
    }

    private void m16701a(int i, ReqType reqType, int i2) {
        this.f13669k = i;
        if (i != 2) {
            this.f13664f = (short) (((((i & 1) << 4) | (reqType.ordinal() << 2)) | i2) << 11);
        }
    }

    private static void m16702a(Context context, Message message) {
        try {
            message.host = new URL(C4112a.m16804a(context, null));
        } catch (Throwable e) {
            ALog.m16902e("Message", "setControlHost", e, new Object[0]);
        }
    }

    private static void m16703a(Context context, Message message, AccsRequest accsRequest) {
        if (accsRequest.host == null) {
            try {
                message.host = new URL(C4112a.m16804a(context, null));
                return;
            } catch (Throwable e) {
                ALog.m16902e("Message", "setUnit", e, new Object[0]);
                e.printStackTrace();
                return;
            }
        }
        message.host = accsRequest.host;
    }

    private static void m16704a(Message message, String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str5) || str3 != null) {
            message.f13670l = new HashMap();
            if (str4 != null && UtilityImpl.getByteLen(str4) <= EXT_HEADER_VALUE_MAX_LEN) {
                message.f13670l.put(ExtHeaderType.TYPE_BUSINESS, str4);
            }
            if (str != null && UtilityImpl.getByteLen(str) <= EXT_HEADER_VALUE_MAX_LEN) {
                message.f13670l.put(ExtHeaderType.TYPE_SID, str);
            }
            if (str2 != null && UtilityImpl.getByteLen(str2) <= EXT_HEADER_VALUE_MAX_LEN) {
                message.f13670l.put(ExtHeaderType.TYPE_USERID, str2);
            }
            if (str5 != null && UtilityImpl.getByteLen(str5) <= EXT_HEADER_VALUE_MAX_LEN) {
                message.f13670l.put(ExtHeaderType.TYPE_TAG, str5);
            }
            if (str3 != null && UtilityImpl.getByteLen(str3) <= EXT_HEADER_VALUE_MAX_LEN) {
                message.f13670l.put(ExtHeaderType.TYPE_COOKIE, str3);
            }
        }
    }

    private void m16705a(short s, boolean z) {
        this.f13669k = 1;
        this.f13664f = s;
        this.f13664f = (short) (this.f13664f & -16385);
        this.f13664f = (short) (this.f13664f | FLAG_REQ_BIT2);
        this.f13664f = (short) (this.f13664f & -2049);
        this.f13664f = (short) (this.f13664f & -65);
        if (z) {
            this.f13664f = (short) (this.f13664f | FLAG_ACK_TYPE);
        }
    }

    public static Message buildBindApp(Context context, Intent intent) {
        Message buildBindApp;
        Throwable e;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_USER_ID);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra4 = intent.getStringExtra(Constants.KEY_TTID);
            String stringExtra5 = intent.getStringExtra(Constants.KEY_SID);
            String stringExtra6 = intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            buildBindApp = buildBindApp(context, stringExtra3, stringExtra, stringExtra4, intent.getStringExtra(Constants.KEY_APP_VERSION), stringExtra5, stringExtra2, stringExtra6);
            try {
                m16702a(context, buildBindApp);
            } catch (Exception e2) {
                e = e2;
                ALog.m16902e("Message", "buildBindApp", e, new Object[0]);
                e.printStackTrace();
                return buildBindApp;
            }
        } catch (Throwable e3) {
            e = e3;
            buildBindApp = null;
            ALog.m16902e("Message", "buildBindApp", e, new Object[0]);
            e.printStackTrace();
            return buildBindApp;
        }
        return buildBindApp;
    }

    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        try {
            message.f13657B = 1;
            message.m16701a(1, ReqType.DATA, 1);
            message.f13674p = Integer.valueOf(1);
            message.f13675q = VERSION.SDK_INT + BuildConfig.FLAVOR;
            message.f13671m = str2;
            message.f13667i = Constants.TARGET_CONTROL;
            message.command = Integer.valueOf(1);
            message.f13673o = str;
            message.appSign = UtilityImpl.getAppsign(context, str, UtilityImpl.getDeviceId(context), null, null);
            message.f13678t = Integer.valueOf(Constants.SDK_VERSION_CODE);
            message.f13677s = str4;
            message.f13671m = str2;
            message.f13679u = str3;
            message.f13681w = Build.MODEL;
            message.f13682x = Build.BRAND;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            message.f13683y = telephonyManager != null ? telephonyManager.getDeviceId() : null;
            if (telephonyManager != null) {
                str8 = telephonyManager.getSubscriberId();
            }
            message.f13684z = str8;
            message.cunstomDataId = KEY_BINDAPP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public static Message buildBindService(Context context, Intent intent) {
        Message buildBindService;
        Throwable e;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
            buildBindService = buildBindService(context, stringExtra, intent.getStringExtra(Constants.KEY_APP_KEY), stringExtra2, intent.getStringExtra(Constants.KEY_SID), stringExtra3, intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE));
            try {
                m16702a(context, buildBindService);
            } catch (Exception e2) {
                e = e2;
                ALog.m16902e("Message", "buildBindService", e, new Object[0]);
                e.printStackTrace();
                return buildBindService;
            }
        } catch (Throwable e3) {
            e = e3;
            buildBindService = null;
            ALog.m16902e("Message", "buildBindService", e, new Object[0]);
            e.printStackTrace();
            return buildBindService;
        }
        return buildBindService;
    }

    public static Message buildBindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        Message message = new Message();
        message.f13657B = 1;
        message.m16701a(1, ReqType.DATA, 1);
        message.f13671m = str;
        message.serviceId = str3;
        message.f13667i = Constants.TARGET_CONTROL;
        message.command = Integer.valueOf(5);
        message.f13671m = str;
        message.serviceId = str3;
        message.f13678t = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDSERVICE;
        return message;
    }

    public static Message buildBindUser(Context context, Intent intent) {
        Message buildBindUser;
        Throwable e;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_USER_ID);
            buildBindUser = buildBindUser(context, stringExtra, intent.getStringExtra(Constants.KEY_APP_KEY), intent.getStringExtra(Constants.KEY_SID), stringExtra2, intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE));
            try {
                m16702a(context, buildBindUser);
            } catch (Exception e2) {
                e = e2;
                ALog.m16902e("Message", "buildBindUser", e, new Object[0]);
                e.printStackTrace();
                return buildBindUser;
            }
        } catch (Throwable e3) {
            e = e3;
            buildBindUser = null;
            ALog.m16902e("Message", "buildBindUser", e, new Object[0]);
            e.printStackTrace();
            return buildBindUser;
        }
        return buildBindUser;
    }

    public static Message buildBindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.f13657B = 1;
        message.m16701a(1, ReqType.DATA, 1);
        message.f13671m = str;
        message.userinfo = str4;
        message.f13667i = Constants.TARGET_CONTROL;
        message.command = Integer.valueOf(MAX_RETRY_TIMES);
        message.f13671m = str;
        message.userinfo = str4;
        message.f13678t = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDUSER;
        return message;
    }

    public static Message buildElection(String str, Map<String, Integer> map) {
        if (map == null) {
            return null;
        }
        Message message = new Message();
        try {
            message.m16701a(1, ReqType.DATA, 1);
            message.f13657B = 1;
            message.f13671m = str;
            message.f13667i = Constants.TARGET_ELECTION;
            message.command = Integer.valueOf(Constants.COMMAND_ELECTION);
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : map.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.KEY_ELECTION_PKG, entry.getKey());
                jSONObject.put(Constants.KEY_ELECTION_SDKV, entry.getValue());
                jSONArray.put(jSONObject);
            }
            message.f13656A = new C4138a().m16921a(Constants.KEY_ELECTION_SDKV, Integer.valueOf(Constants.SDK_VERSION_CODE)).m16923a(Constants.KEY_ELECTION_PACKS, jSONArray).m16924a().toString().getBytes("utf-8");
        } catch (Throwable th) {
            ALog.m16902e("Message", "buildElection", th, new Object[0]);
        }
        return message;
    }

    public static Message buildHandshake(String str) {
        Message message = new Message();
        message.m16701a((int) MAX_RETRY_TIMES, ReqType.DATA, 1);
        message.f13671m = str;
        message.f13667i = Constants.TARGET_CONTROL;
        message.command = Integer.valueOf(Constants.COMMAND_HANDSHAKE);
        return message;
    }

    public static Message buildParameterError(String str, int i) {
        Message message = new Message();
        message.m16701a(1, ReqType.ACK, 0);
        message.command = Integer.valueOf(i);
        message.f13671m = str;
        return message;
    }

    public static Message buildPushAck(String str, String str2, String str3, boolean z, short s, String str4, Map<ExtHeaderType, String> map) {
        Message message = new Message();
        message.f13657B = 1;
        message.m16705a(s, z);
        message.f13668j = str;
        message.f13667i = str2;
        message.dataId = str3;
        message.isAck = true;
        message.f13670l = map;
        try {
            if (TextUtils.isEmpty(str4)) {
                message.host = new URL(C4112a.m16804a(GlobalClientInfo.getContext(), null));
            } else {
                message.host = new URL(str4);
            }
            if (message.host == null) {
                try {
                    message.host = new URL(C4112a.m16804a(GlobalClientInfo.getContext(), null));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (message.host == null) {
                try {
                    message.host = new URL(C4112a.m16804a(GlobalClientInfo.getContext(), null));
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return message;
    }

    public static Message buildRequest(Context context, String str, String str2, AccsRequest accsRequest) {
        return buildRequest(context, str, str2, accsRequest, true);
    }

    public static Message buildRequest(Context context, String str, String str2, AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.f13657B = 1;
        message.m16701a(1, ReqType.REQ, 1);
        message.command = Integer.valueOf(100);
        message.f13671m = str;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.f13656A = accsRequest.data;
        message.f13667i = Constants.TARGET_SERVICE_PRE + (TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName) + "|" + (accsRequest.target == null ? BuildConfig.FLAVOR : accsRequest.target);
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        if (accsRequest.timeout > 0) {
            message.timeout = accsRequest.timeout;
        }
        if (z) {
            m16703a(context, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        m16704a(message, GlobalClientInfo.getInstance(context).getSid(), GlobalClientInfo.getInstance(context).getUserId(), GlobalClientInfo.f13606a, accsRequest.businessId, accsRequest.tag);
        message.f13659D = new NetPerformanceMonitor();
        message.f13659D.setDataId(accsRequest.dataId);
        message.f13659D.setServiceId(accsRequest.serviceId);
        message.f13659D.setHost(message.host.toString());
        return message;
    }

    public static Message buildSendData(Context context, String str, String str2, AccsRequest accsRequest) {
        return buildSendData(context, str, str2, accsRequest, true);
    }

    public static Message buildSendData(Context context, String str, String str2, AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.f13657B = 1;
        message.m16701a(1, ReqType.DATA, 1);
        message.command = Integer.valueOf(100);
        message.f13671m = str;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.f13656A = accsRequest.data;
        message.f13667i = Constants.TARGET_SERVICE_PRE + (TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName) + "|" + (accsRequest.target == null ? BuildConfig.FLAVOR : accsRequest.target);
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        if (accsRequest.timeout > 0) {
            message.timeout = accsRequest.timeout;
        }
        if (z) {
            m16703a(context, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        m16704a(message, GlobalClientInfo.getInstance(context).getSid(), GlobalClientInfo.getInstance(context).getUserId(), GlobalClientInfo.f13606a, accsRequest.businessId, accsRequest.tag);
        message.f13659D = new NetPerformanceMonitor();
        message.f13659D.setDataId(accsRequest.dataId);
        message.f13659D.setServiceId(accsRequest.serviceId);
        message.f13659D.setHost(message.host.toString());
        return message;
    }

    public static Message buildStatist(String str, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Message message = new Message();
        message.m16701a(1, ReqType.DATA, 1);
        message.f13657B = 1;
        message.f13656A = bArr;
        message.f13671m = str;
        message.f13667i = Constants.TARGET_STATIST;
        message.command = Integer.valueOf(Constants.COMMAND_SEND_STATIST);
        return message;
    }

    public static Message buildUnbindApp(Context context, Intent intent) {
        Message buildUnbindApp;
        Throwable e;
        ALog.m16903e("Message", "buildUnbindApp1" + UtilityImpl.getStackMsg(new Exception()), new Object[0]);
        try {
            buildUnbindApp = buildUnbindApp(context, intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SID), intent.getStringExtra(Constants.KEY_USER_ID), intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE));
            try {
                m16702a(context, buildUnbindApp);
            } catch (Exception e2) {
                e = e2;
                ALog.m16902e("Message", "buildUnbindApp1", e, new Object[0]);
                e.printStackTrace();
                return buildUnbindApp;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            buildUnbindApp = null;
            e = th;
            ALog.m16902e("Message", "buildUnbindApp1", e, new Object[0]);
            e.printStackTrace();
            return buildUnbindApp;
        }
        return buildUnbindApp;
    }

    public static Message buildUnbindApp(Context context, String str, String str2, String str3, String str4) {
        Throwable e;
        Message message;
        try {
            ALog.m16903e("Message", "buildUnbindApp" + UtilityImpl.getStackMsg(new Exception()), new Object[0]);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            message = new Message();
            try {
                message.f13657B = 1;
                message.m16701a(1, ReqType.DATA, 1);
                message.f13671m = str;
                message.f13667i = Constants.TARGET_CONTROL;
                message.command = Integer.valueOf(2);
                message.f13671m = str;
                message.f13678t = Integer.valueOf(Constants.SDK_VERSION_CODE);
                message.cunstomDataId = KEY_UNBINDAPP;
                m16702a(context, message);
                return message;
            } catch (Exception e2) {
                e = e2;
                ALog.m16902e("Message", "buildUnbindApp", e, new Object[0]);
                e.printStackTrace();
                return message;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            message = null;
            e = th;
            ALog.m16902e("Message", "buildUnbindApp", e, new Object[0]);
            e.printStackTrace();
            return message;
        }
    }

    public static Message buildUnbindService(Context context, Intent intent) {
        Message buildUnbindService;
        Throwable e;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
            buildUnbindService = buildUnbindService(context, stringExtra, intent.getStringExtra(Constants.KEY_APP_KEY), stringExtra2, intent.getStringExtra(Constants.KEY_SID), stringExtra3, intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE));
            try {
                m16702a(context, buildUnbindService);
            } catch (Exception e2) {
                e = e2;
                ALog.m16902e("Message", "buildUnbindService", e, new Object[0]);
                e.printStackTrace();
                return buildUnbindService;
            }
        } catch (Throwable e3) {
            e = e3;
            buildUnbindService = null;
            ALog.m16902e("Message", "buildUnbindService", e, new Object[0]);
            e.printStackTrace();
            return buildUnbindService;
        }
        return buildUnbindService;
    }

    public static Message buildUnbindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        Message message = new Message();
        message.f13657B = 1;
        message.m16701a(1, ReqType.DATA, 1);
        message.f13671m = str;
        message.serviceId = str3;
        message.f13667i = Constants.TARGET_CONTROL;
        message.command = Integer.valueOf(6);
        message.f13671m = str;
        message.serviceId = str3;
        message.f13678t = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDSERVICE;
        return message;
    }

    public static Message buildUnbindUser(Context context, Intent intent) {
        Message buildUnbindUser;
        Throwable e;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_USER_ID);
            buildUnbindUser = buildUnbindUser(context, stringExtra, intent.getStringExtra(Constants.KEY_APP_KEY), intent.getStringExtra(Constants.KEY_SID), stringExtra2, intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE));
            try {
                m16702a(context, buildUnbindUser);
            } catch (Exception e2) {
                e = e2;
                ALog.m16902e("Message", "buildUnbindUser", e, new Object[0]);
                e.printStackTrace();
                return buildUnbindUser;
            }
        } catch (Throwable e3) {
            e = e3;
            buildUnbindUser = null;
            ALog.m16902e("Message", "buildUnbindUser", e, new Object[0]);
            e.printStackTrace();
            return buildUnbindUser;
        }
        return buildUnbindUser;
    }

    public static Message buildUnbindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.f13657B = 1;
        message.m16701a(1, ReqType.DATA, 1);
        message.f13671m = str;
        message.f13667i = Constants.TARGET_CONTROL;
        message.command = Integer.valueOf(4);
        message.f13678t = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDUSER;
        return message;
    }

    short m16706a(Map<ExtHeaderType, String> map) {
        short s = (short) 0;
        if (map != null) {
            try {
                for (ExtHeaderType extHeaderType : map.keySet()) {
                    String str = (String) map.get(extHeaderType);
                    s = !TextUtils.isEmpty(str) ? (short) ((((short) (str.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN)) + 2) + s) : s;
                }
            } catch (Exception e) {
                e.toString();
            }
        }
        return s;
    }

    void m16707a() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        GZIPOutputStream gZIPOutputStream = null;
        try {
            if (this.f13656A == null) {
                if (null != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e) {
                        return;
                    }
                }
                if (null != null) {
                    byteArrayOutputStream3.close();
                    return;
                }
                return;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f13656A);
                    gZIPOutputStream.finish();
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    if (toByteArray != null && toByteArray.length < this.f13656A.length) {
                        this.f13656A = toByteArray;
                        this.f13660b = (byte) 1;
                    }
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    void m16708a(byte[] bArr) {
        String str = BuildConfig.FLAVOR;
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("Message", "len:" + bArr.length, new Object[0]);
            if (bArr.length < AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY) {
                String str2 = str;
                for (byte b : bArr) {
                    str2 = str2 + Integer.toHexString(b & MotionEventCompat.ACTION_MASK) + " ";
                }
                ALog.m16901d("Message", str2, new Object[0]);
            }
        }
    }

    void m16709b() {
        if (this.command != null && this.command.intValue() != 100 && this.command.intValue() != Constants.COMMAND_SEND_STATIST && this.command.intValue() != Constants.COMMAND_ELECTION) {
            this.f13656A = new C4138a().m16921a(IntentUtil.AGOO_COMMAND, this.command.intValue() == 100 ? null : this.command).m16922a(Constants.KEY_APP_KEY, this.f13673o).m16921a(Constants.KEY_OS_TYPE, this.f13674p).m16922a(Constants.KEY_SECURITY_SIGN, this.appSign).m16921a(Constants.KEY_SDK_VERSION, this.f13678t).m16922a(Constants.KEY_APP_VERSION, this.f13677s).m16922a(Constants.KEY_TTID, this.f13679u).m16922a(Constants.KEY_MODEL, this.f13681w).m16922a(Constants.KEY_BRAND, this.f13682x).m16922a(Constants.KEY_IMEI, this.f13684z).m16922a(Constants.KEY_IMSI, this.f13684z).m16922a(Constants.KEY_OS_VERSION, this.f13675q).m16924a().toString().getBytes("utf-8");
        }
    }

    public byte[] build(Context context, int i) {
        byte[] bytes;
        try {
            m16709b();
        } catch (Throwable e) {
            ALog.m16902e("Message", "build1", e, new Object[0]);
        } catch (Throwable e2) {
            ALog.m16902e("Message", "build2", e2, new Object[0]);
        }
        String str = this.f13656A != null ? new String(this.f13656A) : BuildConfig.FLAVOR;
        m16707a();
        if (!this.isAck) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(UtilityImpl.getDeviceId(context)).append("|").append(this.f13671m).append("|").append(this.serviceId == null ? BuildConfig.FLAVOR : this.serviceId).append("|").append(this.userinfo == null ? BuildConfig.FLAVOR : this.userinfo);
            this.f13668j = stringBuilder.toString();
        }
        try {
            bytes = (this.dataId + BuildConfig.FLAVOR).getBytes("utf-8");
            this.f13666h = (byte) this.f13668j.getBytes("utf-8").length;
            this.f13665g = (byte) this.f13667i.getBytes("utf-8").length;
        } catch (Throwable e22) {
            e22.printStackTrace();
            ALog.m16902e("Message", "build3", e22, new Object[0]);
            bytes = (this.dataId + BuildConfig.FLAVOR).getBytes();
            this.f13666h = (byte) this.f13668j.getBytes().length;
            this.f13665g = (byte) this.f13667i.getBytes().length;
        }
        short a = m16706a(this.f13670l);
        this.f13663e = (short) ((((this.f13656A == null ? 0 : this.f13656A.length) + (bytes.length + ((((this.f13665g + MAX_RETRY_TIMES) + 1) + this.f13666h) + 1))) + a) + 2);
        this.f13662d = (short) (this.f13663e + 2);
        C4141f c4141f = new C4141f((this.f13662d + 2) + 4);
        ALog.m16901d("Message", "Build Message", new Object[0]);
        try {
            c4141f.m16929a((byte) (this.f13660b | FLAG_ACK_TYPE));
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\tversion:2 compress:" + this.f13660b, new Object[0]);
            }
            if (i == 0) {
                c4141f.m16929a(Byte.MIN_VALUE);
                ALog.m16901d("Message", "\tflag: 0x80", new Object[0]);
            } else {
                c4141f.m16929a((byte) 64);
                ALog.m16901d("Message", "\tflag: 0x40", new Object[0]);
            }
            c4141f.m16930a(this.f13662d);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\ttotalLength:" + this.f13662d, new Object[0]);
            }
            c4141f.m16930a(this.f13663e);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\tdataLength:" + this.f13663e, new Object[0]);
            }
            c4141f.m16930a(this.f13664f);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\tflags:" + Integer.toHexString(this.f13664f), new Object[0]);
            }
            c4141f.m16929a(this.f13665g);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\ttargetLength:" + this.f13665g, new Object[0]);
            }
            c4141f.write(this.f13667i.getBytes("utf-8"));
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\ttarget:" + new String(this.f13667i), new Object[0]);
            }
            c4141f.m16929a(this.f13666h);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\tsourceLength:" + this.f13666h, new Object[0]);
            }
            c4141f.write(this.f13668j.getBytes("utf-8"));
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\tsource:" + new String(this.f13668j), new Object[0]);
            }
            c4141f.m16929a((byte) bytes.length);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            c4141f.write(bytes);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\tdataId:" + new String(bytes), new Object[0]);
            }
            c4141f.m16930a(a);
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\textHeader len:" + a, new Object[0]);
            }
            if (this.f13670l != null) {
                for (ExtHeaderType extHeaderType : this.f13670l.keySet()) {
                    String str2 = (String) this.f13670l.get(extHeaderType);
                    if (!TextUtils.isEmpty(str2)) {
                        c4141f.m16930a((short) ((((short) extHeaderType.ordinal()) << 10) | ((short) (str2.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN))));
                        c4141f.write(str2.getBytes("utf-8"));
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.m16901d("Message", "\textHeader key:" + extHeaderType + " value:" + str2, new Object[0]);
                        }
                    }
                }
            }
            if (this.f13656A != null) {
                c4141f.write(this.f13656A);
            }
            if (ALog.isPrintLog(Level.D)) {
                ALog.m16901d("Message", "\toriData:" + str, new Object[0]);
            }
            c4141f.flush();
        } catch (Throwable e222) {
            ALog.m16902e("Message", "build4", e222, new Object[0]);
        }
        bytes = c4141f.toByteArray();
        m16708a(bytes);
        try {
            c4141f.close();
        } catch (Throwable e3) {
            ALog.m16902e("Message", "build5", e3, new Object[0]);
        }
        return bytes;
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getDelyTime() {
        return this.delyTime;
    }

    public int getIntDataId() {
        try {
            return !this.isAck ? Integer.valueOf(this.dataId).intValue() : -((int) f13655a);
        } catch (Exception e) {
            ALog.m16906w("Message", "parse int dataId error " + this.dataId, new Object[0]);
            return -1;
        }
    }

    public NetPerformanceMonitor getNetPermanceMonitor() {
        return this.f13659D;
    }

    public int getNode() {
        return this.f13657B;
    }

    public String getPackageName() {
        return this.f13671m == null ? BuildConfig.FLAVOR : this.f13671m;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getType() {
        return this.f13669k;
    }

    public boolean isControlFrame() {
        return Constants.TARGET_CONTROL.equals(this.f13667i);
    }

    public boolean isTimeOut() {
        boolean z = (System.currentTimeMillis() - this.startSendTime) + this.delyTime >= ((long) this.timeout);
        if (z) {
            ALog.m16903e("Message", "delay time:" + this.delyTime + " beforeSendTime:" + (System.currentTimeMillis() - this.startSendTime) + " timeout" + this.timeout, new Object[0]);
        }
        return z;
    }

    public void setSendTime(long j) {
        this.f13658C = j;
    }
}
