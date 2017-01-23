package com.antutu.benchmark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BenchmarkReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            int i = 0;
            if (action.equals("com.antutu.benchmark.marooned.FINISHED")) {
                i = 1;
            } else if (action.equals("com.antutu.benchmark.marooned.ERROR")) {
                i = 2;
            } else if (action.equals("com.antutu.benchmark.marooned.EXIT")) {
                i = 3;
            }
            BenchmarkService.m4816c(context, i);
        } catch (Exception e) {
        }
    }
}
