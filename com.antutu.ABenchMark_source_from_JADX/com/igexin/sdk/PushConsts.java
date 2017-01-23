package com.igexin.sdk;

public class PushConsts {
    public static final String ACTION_BROADCAST_NETWORK_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String ACTION_BROADCAST_PUSHMANAGER = "com.igexin.sdk.action.pushmanager";
    public static final String ACTION_BROADCAST_REFRESHLS = "com.igexin.sdk.action.refreshls";
    public static final String ACTION_BROADCAST_TO_BOOT = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_BROADCAST_USER_PRESENT = "android.intent.action.USER_PRESENT";
    public static String ACTION_SERVICE_INITIALIZE = null;
    public static final String ACTION_SERVICE_INITIALIZE_SLAVE = "com.igexin.action.initialize.slave";
    public static final int CHECK_CLIENTID = 10005;
    public static final String CMD_ACTION = "action";
    public static final int GET_CLIENTID = 10002;
    public static final int GET_MSG_DATA = 10001;
    public static final int GET_SDKONLINESTATE = 10007;
    public static final int GET_SDKSERVICEPID = 10008;
    public static final int MAX_FEEDBACK_ACTION = 90999;
    public static final int MIN_FEEDBACK_ACTION = 90001;
    public static final String SEND_MESSAGE_ERROR = "20000";
    public static final String SEND_MESSAGE_ERROR_GENERAL = "20001";
    public static final String SEND_MESSAGE_ERROR_TIME_OUT = "20002";
    public static final int SETTAG_ERROR_COUNT = 20001;
    public static final int SETTAG_ERROR_EXCEPTION = 20005;
    public static final int SETTAG_ERROR_FREQUENCY = 20002;
    public static final int SETTAG_ERROR_NULL = 20006;
    public static final int SETTAG_ERROR_REPEAT = 20003;
    public static final int SETTAG_ERROR_UNBIND = 20004;
    public static final int SETTAG_IN_BLACKLIST = 20009;
    public static final int SETTAG_NOTONLINE = 20008;
    public static final int SETTAG_NUM_EXCEED = 20010;
    public static final int SETTAG_SN_NULL = 20007;
    public static final int SETTAG_SUCCESS = 0;
    public static final int SET_TAG_RESULT = 10009;
    public static final int THIRDPART_FEEDBACK = 10006;

    static {
        ACTION_SERVICE_INITIALIZE = "com.igexin.action.initialize";
    }
}
