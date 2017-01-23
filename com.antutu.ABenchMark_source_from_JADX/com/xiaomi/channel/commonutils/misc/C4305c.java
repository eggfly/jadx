package com.xiaomi.channel.commonutils.misc;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.message.MsgConstant;

/* renamed from: com.xiaomi.channel.commonutils.misc.c */
public class C4305c {
    public static boolean m17661a(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static boolean m17662b(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra(MsgConstant.KEY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }
}
