package com.taobao.accs;

import android.content.Context;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p193d.C4091a;
import com.taobao.accs.utl.ALog;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public final class ACCSManager {
    private static final String TAG = "ACCSManager";
    private static IACCSManager accsManager;

    public static class AccsRequest implements Serializable {
        public String businessId;
        public byte[] data;
        public String dataId;
        public URL host;
        public boolean isUnitBusiness;
        public String serviceId;
        public String tag;
        public String target;
        public String targetServiceName;
        public int timeout;
        public String userId;

        public AccsRequest(String str, String str2, byte[] bArr, String str3) {
            this.isUnitBusiness = false;
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
        }

        public AccsRequest(String str, String str2, byte[] bArr, String str3, String str4, URL url, String str5) {
            this.isUnitBusiness = false;
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
            this.target = str4;
            this.host = url;
            this.businessId = str5;
        }

        public void setBusinessId(String str) {
            this.businessId = str;
        }

        public void setHost(URL url) {
            this.host = url;
        }

        public void setIsUnitBusiness(boolean z) {
            this.isUnitBusiness = z;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTarget(String str) {
            this.target = str;
        }

        public void setTargetServiceName(String str) {
            this.targetServiceName = str;
        }

        public void setTimeOut(int i) {
            this.timeout = i;
        }
    }

    private ACCSManager() {
    }

    public static void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        getManagerImpl(context).bindApp(context, str, BuildConfig.FLAVOR, str2, iAppReceiver);
    }

    public static void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        getManagerImpl(context).bindApp(context, str, str2, str3, iAppReceiver);
    }

    public static void bindService(Context context, String str) {
        getManagerImpl(context).bindService(context, str);
    }

    public static void bindUser(Context context, String str) {
        getManagerImpl(context).bindUser(context, str);
    }

    public static void bindUser(Context context, String str, boolean z) {
        getManagerImpl(context).bindUser(context, str, z);
    }

    public static void clearLoginInfoImpl(Context context) {
        getManagerImpl(context).clearLoginInfo(context);
    }

    public static void forceDisableService(Context context) {
        getManagerImpl(context).forceDisableService(context);
    }

    public static void forceEnableService(Context context) {
        getManagerImpl(context).forceEnableService(context);
    }

    public static Map<String, Boolean> forceReConnectChannel(Context context) {
        return getManagerImpl(context).forceReConnectChannel();
    }

    public static Map<String, Boolean> getChannelState(Context context) {
        return getManagerImpl(context).getChannelState();
    }

    public static synchronized IACCSManager getManagerImpl(Context context) {
        IACCSManager iACCSManager;
        synchronized (ACCSManager.class) {
            if (accsManager == null) {
                try {
                    accsManager = (IACCSManager) C4091a.m16693a().m16696a(context).loadClass(Constants.ACCS_IMPL_NAME).newInstance();
                    if (accsManager == null) {
                        try {
                            accsManager = (IACCSManager) Class.forName(Constants.ACCS_IMPL_NAME).newInstance();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    if (accsManager == null) {
                        try {
                            accsManager = (IACCSManager) Class.forName(Constants.ACCS_IMPL_NAME).newInstance();
                        } catch (Exception e3) {
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (accsManager == null) {
                        try {
                            accsManager = (IACCSManager) Class.forName(Constants.ACCS_IMPL_NAME).newInstance();
                        } catch (Exception e4) {
                        }
                    }
                }
            }
            iACCSManager = accsManager;
        }
        return iACCSManager;
    }

    public static String getUserUnit(Context context) {
        return getManagerImpl(context).getUserUnit();
    }

    public static boolean isChannelError(Context context, int i) {
        return getManagerImpl(context).isChannelError(i);
    }

    public static boolean isNetworkReachable(Context context) {
        return getManagerImpl(context).isNetworkReachable(context);
    }

    public static void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (getManagerImpl(context) == null) {
            ALog.m16903e(TAG, "getManagerImpl null, return", new Object[0]);
        } else {
            getManagerImpl(context).registerDataListener(context, str, accsAbstractDataListener);
        }
    }

    public static void registerSerivce(Context context, String str, String str2) {
        getManagerImpl(context).registerSerivce(context, str, str2);
    }

    public static String sendData(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).sendData(context, accsRequest);
    }

    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3);
    }

    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3, str4);
    }

    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3, str4, url);
    }

    public static String sendPushResponse(Context context, AccsRequest accsRequest, ExtraInfo extraInfo) {
        return getManagerImpl(context).sendPushResponse(context, accsRequest, extraInfo);
    }

    public static String sendRequest(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).sendRequest(context, accsRequest);
    }

    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendRequest(context, str, str2, bArr, str3, null);
    }

    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).sendRequest(context, str, str2, bArr, str3, str4);
    }

    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).sendRequest(context, str, str2, bArr, str3, str4, url);
    }

    public static void setLoginInfoImpl(Context context, ILoginInfo iLoginInfo) {
        getManagerImpl(context).setLoginInfo(context, iLoginInfo);
    }

    public static void setMode(Context context, int i) {
        getManagerImpl(context).setMode(context, i);
    }

    public static void setProxy(Context context, String str, int i) {
        getManagerImpl(context).setProxy(context, str, i);
    }

    @Deprecated
    public static void setServiceListener(Context context, String str, IServiceReceiver iServiceReceiver) {
    }

    public static void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        getManagerImpl(context).startInAppConnection(context, str, AgooConstants.MESSAGE_SOURCE_ACCS, str2, iAppReceiver);
    }

    public static void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        getManagerImpl(context).startInAppConnection(context, str, str2, str3, iAppReceiver);
    }

    public static void unRegisterDataListener(Context context, String str) {
        getManagerImpl(context).unRegisterDataListener(context, str);
    }

    @Deprecated
    public static void unbindApp(Context context) {
        ALog.m16903e(TAG, "unbindApp", new Object[0]);
        getManagerImpl(context).unbindApp(context);
    }

    public static void unbindService(Context context, String str) {
        getManagerImpl(context).unbindService(context, str);
    }

    public static void unbindUser(Context context) {
        getManagerImpl(context).unbindUser(context);
    }

    public static void unregisterService(Context context, String str) {
        getManagerImpl(context).unRegisterSerivce(context, str);
    }
}
