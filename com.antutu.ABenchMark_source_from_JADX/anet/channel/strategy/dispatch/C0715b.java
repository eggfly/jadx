package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import android.util.Base64InputStream;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.p017a.C0644a;
import anet.channel.p017a.C0646b.C0645a;
import anet.channel.request.Request;
import anet.channel.request.Request.Builder;
import anet.channel.request.Request.Method;
import anet.channel.session.C0690c;
import anet.channel.session.C0690c.C0689a;
import anet.channel.statist.AmdcStatistic;
import anet.channel.statist.StatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.C0739d;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4209a;
import com.umeng.message.util.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.android.agoo.common.C4575b;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: anet.channel.strategy.dispatch.b */
class C0715b {
    C0715b() {
    }

    public static int m2917a(Map<String, String> map, IConnStrategy iConnStrategy, int i) {
        Request request;
        Throwable th;
        String message;
        Request request2 = null;
        try {
            request2 = new Builder().setMethod(Method.POST).setUrl(C0715b.m2925c(map)).setParams(map).addHeader(HttpConstant.CONNECTION, "close").addHeader(HttpRequest.f14554g, HttpRequest.f14551d).setRedirectEnable(false).setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT).setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT).build();
            if (iConnStrategy != null) {
                try {
                    request2.setDnsOptimize(iConnStrategy.getIp(), iConnStrategy.getPort());
                } catch (Throwable th2) {
                    request = request2;
                    th = th2;
                    message = th.getMessage();
                    if (TextUtils.isEmpty(message)) {
                        message = th.toString();
                    }
                    C0715b.m2921a("-1000", message, request, i, 1);
                    return 1;
                }
            }
            C0689a a = C0690c.m2820a(request2, null);
            if (a == null || a.f2270a < 0) {
                C0715b.m2921a("-1000", "request fail", request2, i, 1);
                return 1;
            }
            int i2 = a.f2270a;
            if (ALog.isPrintLog(1)) {
                ALog.m2960d("awcn.DispatchCore", "amdc response. code: " + i2, null, "\nheaders", a.f2272c);
            }
            int i3;
            if (i2 != Constants.COMMAND_HANDSHAKE) {
                i3 = (i2 == ErrorCode.DM_DEVICEID_INVALID || i2 == HttpConstant.SC_TEMPORARY_REDIRECT) ? 2 : 1;
                C0715b.m2921a(String.valueOf(i2), "response code not 200", request2, i, i3);
                return i3;
            }
            String b = C0739d.m2973b(a.f2272c, "x-am-code");
            if ("1000".equals(b)) {
                Object trim = C0739d.m2973b(a.f2272c, "x-am-sign").trim();
                if (TextUtils.isEmpty(trim)) {
                    C0715b.m2921a("-1001", "response sign is empty", request2, i, 1);
                    return 1;
                }
                String a2 = C0715b.m2918a(a.f2271b);
                if (ALog.isPrintLog(1)) {
                    ALog.m2960d("awcn.DispatchCore", "amdc response body", null, "\nbody", a2);
                }
                if (a2 == null) {
                    C0715b.m2921a("-1002", "read answer error", request2, i, 1);
                    return 1;
                } else if (!C0715b.m2923a(trim, a2)) {
                    ALog.m2960d("awcn.DispatchCore", "check ret sign failed", null, new Object[0]);
                    C0715b.m2921a("-1003", "check sign failed", request2, i, 1);
                    return 1;
                } else if (C0715b.m2922a(a2)) {
                    C0715b.m2921a(b, "request success", request2, i, 0);
                    return 0;
                } else {
                    C0715b.m2921a("-1004", "resolve answer failed", request2, i, 1);
                    return 1;
                }
            }
            i3 = ("1007".equals(b) || "1008".equals(b)) ? 2 : 1;
            C0715b.m2921a(b, "return code: " + b, request2, i, i3);
            return i3;
        } catch (Throwable th22) {
            request = request2;
            th = th22;
            message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th.toString();
            }
            C0715b.m2921a("-1000", message, request, i, 1);
            return 1;
        }
    }

    static String m2918a(byte[] bArr) {
        InputStream base64InputStream;
        InputStream inputStream;
        Throwable th;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(IXAdIOUtils.BUFFER_SIZE);
        try {
            base64InputStream = new Base64InputStream(new ByteArrayInputStream(bArr), 0);
            try {
                C0644a a = C0645a.f2174a.m2763a((int) IXAdIOUtils.BUFFER_SIZE);
                while (a.m2757a(base64InputStream) != -1) {
                    a.m2758a(byteArrayOutputStream);
                }
                a.m2762d();
                String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                if (base64InputStream == null) {
                    return str;
                }
                try {
                    base64InputStream.close();
                    return str;
                } catch (IOException e) {
                    return str;
                }
            } catch (IOException e2) {
                inputStream = base64InputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (base64InputStream != null) {
                    try {
                        base64InputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            base64InputStream = null;
            if (base64InputStream != null) {
                base64InputStream.close();
            }
            throw th;
        }
    }

    static List<IConnStrategy> m2919a() {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (NetworkStatusHelper.m2847f()) {
            return list;
        }
        List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(C0714a.m2914a());
        ListIterator listIterator = connStrategyListByHost.listIterator();
        while (listIterator.hasNext()) {
            if (!((IConnStrategy) listIterator.next()).getConnType().equals(ConnType.HTTP)) {
                listIterator.remove();
            }
        }
        return connStrategyListByHost;
    }

    static Map m2920a(Map map) {
        Set<String> set = (Set) map.remove(C0714a.HOSTS);
        if (set == null || set.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : set) {
            stringBuilder.append(append).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        map.put(C0714a.DOMAIN, stringBuilder.toString());
        return C0718d.m2932a(map);
    }

    static void m2921a(String str, String str2, Request request, int i, int i2) {
        if (i2 != 1 || i == 2) {
            StatObject amdcStatistic = new AmdcStatistic();
            amdcStatistic.errorCode = str;
            amdcStatistic.errorMsg = str2;
            if (request != null) {
                amdcStatistic.host = request.getHost();
                amdcStatistic.url = request.getUrlString();
            }
            amdcStatistic.retryTimes = i;
            AppMonitor.getInstance().commitStat(amdcStatistic);
        }
    }

    public static boolean m2922a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            if (jSONObject == null) {
                HttpDispatcher.getInstance().fireEvent(new DispatchEvent(0, null));
                return false;
            }
            HttpDispatcher.getInstance().fireEvent(new DispatchEvent(1, jSONObject));
            return true;
        } catch (Throwable e) {
            ALog.m2961e("awcn.DispatchCore", "answerJsonResolve exception", null, e, new Object[0]);
            HttpDispatcher.getInstance().fireEvent(new DispatchEvent(0, null));
            return false;
        }
    }

    static boolean m2923a(String str, String str2) {
        return C0718d.m2931a(str2).equals(str);
    }

    public static void m2924b(Map map) {
        Map a = C0715b.m2920a(map);
        if (a != null) {
            List a2 = C0715b.m2919a();
            int i = 0;
            while (i < 3) {
                IConnStrategy iConnStrategy = i != 2 ? a2.isEmpty() ? null : (IConnStrategy) a2.remove(0) : null;
                int a3 = C0715b.m2917a(new HashMap(a), iConnStrategy, i);
                if (iConnStrategy != null) {
                    StrategyCenter.getInstance().notifyConnEvent(C0714a.m2914a(), iConnStrategy, a3 == 0 ? EventType.CONNECTED : EventType.CONNECT_FAIL, null);
                }
                if (a3 != 0 && a3 != 2) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static String m2925c(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(HttpConstant.HTTP);
        stringBuilder.append(HttpConstant.SCHEME_SPLIT);
        stringBuilder.append(C0714a.m2914a());
        stringBuilder.append(C0714a.serverPath);
        Map hashMap = new HashMap();
        hashMap.put(C4209a.f14204g, map.remove(C4209a.f14204g));
        hashMap.put(IXAdRequestInfo.f6909V, map.remove(IXAdRequestInfo.f6909V));
        hashMap.put(C4575b.KEY_DEVICE_TOKEN, map.remove(C4575b.KEY_DEVICE_TOKEN));
        hashMap.put(C0714a.PLATFORM, map.remove(C0714a.PLATFORM));
        stringBuilder.append('?');
        stringBuilder.append(StringUtils.encodeQueryParams(hashMap, "utf-8"));
        return stringBuilder.toString();
    }
}
