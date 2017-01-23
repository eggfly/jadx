package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService.ExtHeaderType;
import com.taobao.accs.utl.ALog;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;
    private Context f13712a;
    private FlowCtrlInfoHolder f13713b;

    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i, long j, long j2, long j3) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i;
            this.delayTime = j;
            if (j2 <= 0) {
                j2 = 0;
            }
            this.expireTime = j2;
            if (j3 <= 0) {
                j3 = 0;
            }
            this.startTime = j3;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - (this.startTime + this.expireTime) > 0;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:").append(this.serviceId).append(" bizId:").append(this.bizId).append(" status:").append(this.status).append(" delayTime:").append(this.delayTime).append(" startTime:").append(this.startTime).append(" expireTime:").append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap;

        public FlowCtrlInfoHolder() {
            this.flowCtrlMap = null;
        }

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            Object obj;
            if (!TextUtils.isEmpty(str2)) {
                obj = str + "_" + str2;
            }
            return (FlowControlInfo) this.flowCtrlMap.get(obj);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            Object obj;
            if (!TextUtils.isEmpty(str2)) {
                obj = str + "_" + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(obj, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.f13712a = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16765a() {
        /*
        r2 = this;
        r0 = r2.f13713b;
        if (r0 == 0) goto L_0x0037;
    L_0x0004:
        r0 = r2.f13713b;
        r0 = r0.flowCtrlMap;
        if (r0 == 0) goto L_0x0037;
    L_0x000a:
        monitor-enter(r2);
        r0 = r2.f13713b;	 Catch:{ all -> 0x0033 }
        r0 = r0.flowCtrlMap;	 Catch:{ all -> 0x0033 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0033 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0033 }
    L_0x0017:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0036;
    L_0x001d:
        r0 = r1.next();	 Catch:{ all -> 0x0033 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0033 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0033 }
        r0 = (com.taobao.accs.flowcontrol.FlowControl.FlowControlInfo) r0;	 Catch:{ all -> 0x0033 }
        r0 = r0.isExpired();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0017;
    L_0x002f:
        r1.remove();	 Catch:{ all -> 0x0033 }
        goto L_0x0017;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0036:
        monitor-exit(r2);	 Catch:{ all -> 0x0033 }
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.flowcontrol.FlowControl.a():void");
    }

    private boolean m16766a(long j, long j2) {
        if (j != 0 && j2 > 0) {
            return true;
        }
        ALog.m16903e("FlowControl", "error flow ctrl info", new Object[NO_FLOW_CTRL]);
        return false;
    }

    public int m16767a(Map<ExtHeaderType, String> map, String str) {
        long j = 0;
        int i = NO_FLOW_CTRL;
        if (map != null) {
            try {
                String str2 = (String) map.get(ExtHeaderType.TYPE_STATUS);
                String str3 = (String) map.get(ExtHeaderType.TYPE_DELAY);
                String str4 = (String) map.get(ExtHeaderType.TYPE_EXPIRE);
                String str5 = (String) map.get(ExtHeaderType.TYPE_BUSINESS);
                i = TextUtils.isEmpty(str2) ? NO_FLOW_CTRL : Integer.valueOf(str2).intValue();
                j = TextUtils.isEmpty(str3) ? 0 : Long.valueOf(str3).longValue();
                long longValue = TextUtils.isEmpty(str4) ? 0 : Long.valueOf(str4).longValue();
                if ((i != STATUS_FLOW_CTRL_ALL && i != STATUS_FLOW_CTRL_CUR && i != STATUS_FLOW_CTRL_BRUSH) || !m16766a(j, longValue)) {
                    return NO_FLOW_CTRL;
                }
                synchronized (this) {
                    if (this.f13713b == null) {
                        this.f13713b = new FlowCtrlInfoHolder();
                    }
                    FlowControlInfo flowControlInfo = null;
                    if (i == STATUS_FLOW_CTRL_ALL) {
                        flowControlInfo = new FlowControlInfo(SERVICE_ALL, BuildConfig.FLAVOR, i, j, longValue, System.currentTimeMillis());
                        this.f13713b.put(SERVICE_ALL, BuildConfig.FLAVOR, flowControlInfo);
                    } else if (i == STATUS_FLOW_CTRL_BRUSH) {
                        flowControlInfo = new FlowControlInfo(SERVICE_ALL_BRUSH, BuildConfig.FLAVOR, i, j, longValue, System.currentTimeMillis());
                        this.f13713b.put(SERVICE_ALL_BRUSH, BuildConfig.FLAVOR, flowControlInfo);
                    } else if (i == STATUS_FLOW_CTRL_CUR) {
                        if (!TextUtils.isEmpty(str)) {
                            flowControlInfo = new FlowControlInfo(str, str5, i, j, longValue, System.currentTimeMillis());
                            this.f13713b.put(str, str5, flowControlInfo);
                        }
                    }
                    if (flowControlInfo != null) {
                        ALog.m16903e("FlowControl", "updateFlowCtrlInfo " + flowControlInfo.toString(), new Object[NO_FLOW_CTRL]);
                    }
                }
            } catch (Throwable th) {
                ALog.m16902e("FlowControl", "updateFlowCtrlInfo", th, new Object[NO_FLOW_CTRL]);
            }
        }
        return j > 0 ? LOW_FLOW_CTRL : j == 0 ? NO_FLOW_CTRL : STATUS_FLOW_CTRL_BRUSH == i ? HIGH_FLOW_CTRL_BRUSH : HIGH_FLOW_CTRL;
    }

    public long m16768a(String str, String str2) {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        if (!(this.f13713b == null || this.f13713b.flowCtrlMap == null || TextUtils.isEmpty(str))) {
            synchronized (this) {
                FlowControlInfo flowControlInfo = this.f13713b.get(SERVICE_ALL, null);
                FlowControlInfo flowControlInfo2 = this.f13713b.get(SERVICE_ALL_BRUSH, null);
                FlowControlInfo flowControlInfo3 = this.f13713b.get(str, null);
                FlowControlInfo flowControlInfo4 = this.f13713b.get(str, str2);
                if (flowControlInfo != null) {
                    j2 = flowControlInfo.isExpired() ? 0 : flowControlInfo.delayTime;
                }
                if (flowControlInfo2 != null) {
                    j3 = flowControlInfo2.isExpired() ? 0 : flowControlInfo2.delayTime;
                }
                if (flowControlInfo3 != null) {
                    j4 = flowControlInfo3.isExpired() ? 0 : flowControlInfo3.delayTime;
                }
                if (flowControlInfo4 != null) {
                    j = flowControlInfo4.isExpired() ? 0 : flowControlInfo4.delayTime;
                }
                if (j2 == -1 || j == -1 || j4 == -1) {
                    j5 = -1;
                } else if (j3 == -1) {
                    j5 = -1000;
                } else {
                    j5 = j2 > j ? j2 : j;
                    if (j5 <= j4) {
                        j5 = j4;
                    }
                }
                if ((flowControlInfo4 != null && flowControlInfo4.isExpired()) || (flowControlInfo != null && flowControlInfo.isExpired())) {
                    m16765a();
                }
            }
            ALog.m16903e("FlowControl", "getFlowCtrlDelay service " + str + " biz " + str2 + " result:" + j5 + " global:" + j2 + " serviceDelay:" + j4 + " bidDelay:" + j, new Object[NO_FLOW_CTRL]);
        }
        return j5;
    }
}
