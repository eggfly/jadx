package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.igexin.sdk.PushBuildConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;

@Monitor(module = "accs", monitorPoint = "ele_succ_rate")
public class ElectionRateMonitor extends BaseMonitor {
    @Dimension
    public int eleVer;
    @Dimension
    public int errorCode;
    @Dimension
    public String errorMsg;
    @Dimension
    public String reason;
    @Dimension
    public int ret;
    @Dimension
    public int sdkVer;
    @Measure(constantValue = 0.0d, max = 15000.0d, min = 0.0d)
    public long time;
    @Dimension
    public String type;

    public ElectionRateMonitor() {
        this.type = PushBuildConfig.sdk_conf_debug_level;
        this.eleVer = 1;
        this.sdkVer = Constants.SDK_VERSION_CODE;
    }
}
