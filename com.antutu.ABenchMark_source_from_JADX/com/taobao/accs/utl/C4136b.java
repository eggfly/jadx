package com.taobao.accs.utl;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;

/* renamed from: com.taobao.accs.utl.b */
public class C4136b {
    public static void m16915a(String str, String str2, String str3) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = str;
        alarmObject.modulePoint = str2;
        alarmObject.arg = str3;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
    }

    public static void m16916a(String str, String str2, String str3, double d) {
        CountObject countObject = new CountObject();
        countObject.module = str;
        countObject.modulePoint = str2;
        countObject.arg = str3;
        countObject.value = d;
        AppMonitor.getInstance().commitCount(countObject);
    }

    public static void m16917a(String str, String str2, String str3, String str4, String str5) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = str;
        alarmObject.modulePoint = str2;
        alarmObject.arg = str3;
        alarmObject.errorCode = str4;
        alarmObject.errorMsg = str5;
        alarmObject.isSuccess = false;
        AppMonitor.getInstance().commitAlarm(alarmObject);
    }
}
