package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.igexin.sdk.PushBuildConfig;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import org.android.spdy.TnetStatusCode;

@Monitor(module = "accs", monitorPoint = "netperformance")
public class NetPerformanceMonitor extends BaseMonitor {
    private long f13828a;
    @Dimension
    public int accs_sdk_version;
    @Dimension
    public int accs_type;
    private long f13829b;
    private long f13830c;
    private long f13831d;
    public String data_id;
    public String device_id;
    @Dimension
    public int error_code;
    @Dimension
    public String fail_reasons;
    @Dimension
    public String host;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long in_queue_time;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long receive_to_call_back_time;
    @Dimension
    public String ret;
    @Dimension
    public int retry_times;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long send_to_receive_time;
    @Dimension
    public String service_id;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long start_to_enter_queue_time;
    public long take_date;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long talk_to_send_time;
    public long to_tnet_date;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long total_time;

    public NetPerformanceMonitor() {
        this.service_id = PushBuildConfig.sdk_conf_debug_level;
    }

    private long m16890a(long j, long j2) {
        return (j <= 0 || j2 <= 0) ? 0 : j2 - j;
    }

    public boolean beforeCommit() {
        this.accs_sdk_version = Constants.SDK_VERSION_CODE;
        this.total_time = m16890a(this.f13828a, this.f13831d);
        this.start_to_enter_queue_time = m16890a(this.f13828a, this.f13829b);
        this.in_queue_time = m16890a(this.f13829b, this.take_date);
        this.talk_to_send_time = m16890a(this.take_date, this.to_tnet_date);
        this.send_to_receive_time = m16890a(this.to_tnet_date, this.f13830c);
        this.receive_to_call_back_time = m16890a(this.f13830c, this.f13831d);
        return super.beforeCommit();
    }

    public void onEnterQueueData() {
        this.f13829b = System.currentTimeMillis();
    }

    public void onRecAck() {
        this.f13830c = System.currentTimeMillis();
    }

    public void onSend() {
        this.f13828a = System.currentTimeMillis();
    }

    public void onSendData() {
        this.to_tnet_date = System.currentTimeMillis();
    }

    public void onTakeFromQueue() {
        this.take_date = System.currentTimeMillis();
    }

    public void onToBizDate() {
        this.f13831d = System.currentTimeMillis();
    }

    public void setConnType(int i) {
        this.accs_type = i;
    }

    public void setDataId(String str) {
        this.data_id = str;
    }

    public void setDeviceId(String str) {
        this.device_id = str;
    }

    public void setFailReason(int i) {
        this.error_code = i;
        switch (i) {
            case ErrorCode.MESSAGE_TOO_LARGE /*-4*/:
                setFailReason("msg too large");
            case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                setFailReason("service not available");
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                setFailReason("param error");
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                setFailReason("network fail");
            case Constants.COMMAND_HANDSHAKE /*200*/:
            case ErrorCode.APP_NOT_BIND /*300*/:
                setFailReason("app not bind");
            default:
                setFailReason(String.valueOf(i));
        }
    }

    public void setFailReason(String str) {
        this.fail_reasons = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setRet(boolean z) {
        this.ret = z ? "y" : IXAdRequestInfo.AD_COUNT;
    }

    public void setServiceId(String str) {
        this.service_id = str;
    }
}
