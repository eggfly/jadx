package com.igexin.sdk;

import org.android.agoo.message.MessageService;

public class PushBuildConfig {
    public static String sdk_conf_bilod_enable = null;
    public static final String sdk_conf_branch = "open";
    public static final String sdk_conf_channelid = "open";
    public static final String sdk_conf_debug_level = "none";
    public static final String sdk_conf_domain_switch_enable = "1";
    public static final String sdk_conf_version = "2.9.3.0";
    public static final String sdk_uploadapplist_enable = "1";

    static {
        sdk_conf_bilod_enable = MessageService.MSG_DB_READY_REPORT;
    }
}
