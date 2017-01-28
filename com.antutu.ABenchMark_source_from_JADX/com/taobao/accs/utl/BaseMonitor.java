package com.taobao.accs.utl;

import anet.channel.statist.StatObject;
import com.igexin.sdk.PushBuildConfig;

public abstract class BaseMonitor extends StatObject {
    public static final String ALARM_MSG_ROUTING_RATE = "ele_routing_rate";
    public static final String ALARM_POINT_AUTH = "auth";
    public static final String ALARM_POINT_CONNECT = "connect";
    public static final String ALARM_POINT_REQUEST = "Request_Success_Rate";
    public static final String ALARM_POINT_REQ_ERROR = "send_fail";
    public static final String COUNT_ACK = "ack";
    public static final String COUNT_AGOO_ACK = "agoo_ack";
    public static final String COUNT_AGOO_ARRIVE = "agoo_arrive";
    public static final String COUNT_AGOO_ARRIVE_ID = "agoo_arrive_id";
    public static final String COUNT_AGOO_ARRIVE_REAL_ID = "agoo_arrive_real_id";
    public static final String COUNT_AGOO_CLICK = "agoo_click";
    public static final String COUNT_AGOO_FAIL_ACK = "agoo_fail_ack";
    public static final String COUNT_AGOO_REPORT_ID = "agoo_report_id";
    public static final String COUNT_AGOO_SUCCESS_ACK = "agoo_success_ack";
    public static final String COUNT_BUSINESS_ACK_FAIL = "bizAckFail";
    public static final String COUNT_BUSINESS_ACK_SUCC = "bizAckSucc";
    public static final String COUNT_ELECTION_OVER_MAX = "ele_over_max_times";
    public static final String COUNT_ELECTION_PKG_TIMES = "ele_pkg_times";
    public static final String COUNT_ELECTION_START_TIMES = "ele_start_times";
    public static final String COUNT_POINT_DNS = "dns";
    public static final String COUNT_POINT_RESEND = "resend";
    public static final String COUNT_POINT_SOFAIL = "sofail";
    public static final String COUNT_POINT_TO_BUSS = "to_buss";
    public static final String COUNT_SERVICE_ALIVE = "service_alive";
    public static final String MODULE = "accs";
    public static final String STAT_ELECTION_SUCC_RATE = "ele_succ_rate";
    private boolean f13827a;

    public BaseMonitor() {
        this.f13827a = false;
    }

    public boolean beforeCommit() {
        if (this.f13827a) {
            return false;
        }
        this.f13827a = true;
        return true;
    }

    public String checkString(String str) {
        return str == null ? PushBuildConfig.sdk_conf_debug_level : str;
    }
}
