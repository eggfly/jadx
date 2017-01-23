package com.mob.tools;

import com.mob.tools.log.NLog;

public class MobLog extends NLog {
    private MobLog() {
    }

    public static NLog getInstance() {
        return NLog.getInstanceForSDK("MOBTOOLS", true);
    }

    protected String getSDKTag() {
        return "MOBTOOLS";
    }
}
