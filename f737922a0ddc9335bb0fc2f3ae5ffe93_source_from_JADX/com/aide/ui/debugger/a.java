package com.aide.ui.debugger;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public class a {
    public static void j6(Context context, String str, ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.SET_BREAKPOINTS");
        intent.putStringArrayListExtra("breakpoints", arrayList);
        context.sendBroadcast(intent);
    }

    public static void j6(Context context, String str) {
        DW(context, str, null);
    }

    public static void DW(Context context, String str, ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.RESUME");
        intent.putExtra("breakpoints", arrayList);
        context.sendBroadcast(intent);
    }

    public static void DW(Context context, String str) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.STEP_OVER");
        context.sendBroadcast(intent);
    }

    public static void FH(Context context, String str) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.STEP_OUT");
        context.sendBroadcast(intent);
    }

    public static void Hw(Context context, String str) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.STEP_IN");
        context.sendBroadcast(intent);
    }

    public static void v5(Context context, String str) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.DISCONNECT");
        context.sendBroadcast(intent);
    }

    public static void Zo(Context context, String str) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.KILL");
        context.sendBroadcast(intent);
    }

    public static void j6(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction("com.adrt.GET_FIELDS");
        intent.putExtra("path", str2);
        context.sendBroadcast(intent);
    }
}
