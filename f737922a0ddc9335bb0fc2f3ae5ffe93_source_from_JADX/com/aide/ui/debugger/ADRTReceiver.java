package com.aide.ui.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public class ADRTReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("com.adrt.LOGCAT_ENTRIES".equals(intent.getAction())) {
            Debugger.j6(context).j6(context, intent.getStringArrayExtra("lines"));
        } else if ("com.adrt.CONNECT".equals(intent.getAction())) {
            Debugger.j6(context).j6(context, intent.getExtras().getString("package"));
        } else if ("com.adrt.STOP".equals(intent.getAction())) {
            Debugger.j6(context).DW(context, intent.getExtras().getString("package"));
        } else if ("com.adrt.BREAKPOINT_HIT".equals(intent.getAction())) {
            String string = intent.getExtras().getString("package");
            r6 = intent.getExtras().getStringArrayList("variables");
            ArrayList stringArrayList = intent.getExtras().getStringArrayList("variableValues");
            ArrayList stringArrayList2 = intent.getExtras().getStringArrayList("variableKinds");
            Debugger.j6(context).j6(context, string, intent.getExtras().getStringArrayList("stackMethods"), intent.getExtras().getStringArrayList("stackLocations"), intent.getExtras().getStringArrayList("stackLocationKinds"), r6, stringArrayList, stringArrayList2);
        } else if ("com.adrt.FIELDS".equals(intent.getAction())) {
            ArrayList stringArrayList3 = intent.getExtras().getStringArrayList("fields");
            ArrayList stringArrayList4 = intent.getExtras().getStringArrayList("fieldValues");
            r6 = intent.getExtras().getStringArrayList("fieldKinds");
            Debugger.j6(context).j6(context, intent.getExtras().getString("package"), intent.getExtras().getString("path"), stringArrayList3, stringArrayList4, r6);
        }
    }
}
