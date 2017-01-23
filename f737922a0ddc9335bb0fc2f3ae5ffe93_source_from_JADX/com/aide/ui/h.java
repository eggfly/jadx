package com.aide.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import com.aide.common.d;
import gf;
import hh;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qh;

public class h {
    private static Context j6;

    public static boolean j6(Context context) {
        boolean z = false;
        j6 = context;
        PreferenceManager.setDefaultValues(context, 2131034114, false);
        PreferenceManager.setDefaultValues(context, 2131034116, false);
        PreferenceManager.setDefaultValues(context, 2131034119, false);
        PreferenceManager.setDefaultValues(context, 2131034117, false);
        PreferenceManager.setDefaultValues(context, 2131034113, false);
        PreferenceManager.setDefaultValues(context, 2131034115, false);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Editor edit = defaultSharedPreferences.edit();
        for (gf gfVar : gf.values()) {
            if (!defaultSharedPreferences.contains(gfVar.DW())) {
                edit.putBoolean(gfVar.DW(), gf.Hw().contains(gfVar));
            }
        }
        for (hh hhVar : hh.values()) {
            if (!defaultSharedPreferences.contains(hhVar.DW())) {
                edit.putBoolean(hhVar.DW(), hh.Hw().contains(hhVar));
            }
        }
        if (!defaultSharedPreferences.contains("git_dot_ssh_dir")) {
            edit.putString("git_dot_ssh_dir", new File(qh.j6(), ".ssh").getPath());
        }
        if (!defaultSharedPreferences.contains("editor_font_size")) {
            edit.putString("editor_font_size", Hw(context) + "");
            z = true;
        }
        if (!defaultSharedPreferences.contains("editor_tabs")) {
            edit.putBoolean("editor_tabs", true);
        }
        edit.commit();
        return z;
    }

    public static void j6(Context context, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        FH(j6).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static void DW(Context context, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        FH(j6).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private static SharedPreferences ef() {
        return FH(j6);
    }

    private static SharedPreferences FH(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean j6() {
        return ef().getBoolean("send_analytics_data", true);
    }

    public static boolean DW(Context context) {
        return FH(context).getBoolean("send_analytics_data", true);
    }

    public static String DW() {
        return ef().getString("local_doc_dir_path", null);
    }

    public static boolean FH() {
        return ef().getBoolean("git_create_for_projects", false);
    }

    public static void j6(String str) {
        Editor edit = ef().edit();
        edit.putString("local_doc_dir_path", str);
        edit.commit();
    }

    private static int Hw(Context context) {
        return d.j6(context, 14);
    }

    public static int Hw() {
        try {
            return Integer.parseInt(ef().getString("editor_font_size", ""));
        } catch (NumberFormatException e) {
            return Hw(j6);
        }
    }

    public static boolean v5() {
        return ef().getBoolean("optimze_dex", false);
    }

    public static boolean Zo() {
        return ef().getBoolean("native_build_parallel", false);
    }

    public static int VH() {
        if (e.VH()) {
            return 5;
        }
        try {
            return Integer.parseInt(ef().getString("autosafe_time", "-1"));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean gn() {
        return ef().getBoolean("force_soft_keyboard", false);
    }

    public static boolean u7() {
        return ef().getBoolean("complete_all_types", true);
    }

    public static boolean tp() {
        return ef().getBoolean("complete_after_dot", true);
    }

    public static boolean EQ() {
        return ef().getBoolean("run_as_root", true);
    }

    public static boolean we() {
        return ef().getBoolean("complete_after_letter", true);
    }

    public static int J0() {
        try {
            return Integer.parseInt(ef().getString("tabsize", "4"));
        } catch (NumberFormatException e) {
            return 4;
        }
    }

    public static boolean J8() {
        return ef().getBoolean("use_spaces_for_tabs", false);
    }

    public static boolean Ws() {
        return ef().getBoolean("auto_sync_dropbox", true);
    }

    public static void DW(String str) {
        Editor edit = ef().edit();
        edit.putString("user_androidjar", str);
        edit.commit();
    }

    public static boolean QX() {
        return ef().getBoolean("trainer_voice", false);
    }

    public static void j6(boolean z) {
        Editor edit = ef().edit();
        edit.putBoolean("trainer_voice", z);
        edit.commit();
    }

    public static boolean XL() {
        return ef().getBoolean("trainer_sound", true);
    }

    public static void DW(boolean z) {
        Editor edit = ef().edit();
        edit.putBoolean("trainer_sound", z);
        edit.commit();
    }

    public static String aM() {
        return ef().getString("user_androidjar", "");
    }

    public static String j3() {
        return ef().getString("user_m2repositories", "");
    }

    public static String Mr() {
        if (ef().getBoolean("use_user_keystore", false)) {
            return ef().getString("user_keystore", "").trim();
        }
        return "";
    }

    public static void FH(String str) {
        Editor edit = ef().edit();
        edit.putString("user_keystore", str);
        edit.commit();
    }

    public static boolean U2() {
        return ef().getBoolean("git_keep_ssh_session_info", false);
    }

    public static String a8() {
        return ef().getString("git_dot_ssh_dir", "");
    }

    public static String lg() {
        return ef().getString("git_user_name", "");
    }

    public static String rN() {
        return ef().getString("git_user_email", "");
    }

    public static int er() {
        try {
            return Integer.parseInt(ef().getString("max_single_imports", "0"));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int yS() {
        return 1000;
    }

    public static List<String> gW() {
        List<String> arrayList = new ArrayList();
        for (hh hhVar : hh.values()) {
            if (ef().getBoolean(hhVar.DW(), false)) {
                arrayList.add(hhVar.name());
            }
        }
        return arrayList;
    }

    public static List<String> BT() {
        List<String> arrayList = new ArrayList();
        for (gf gfVar : gf.values()) {
            if (ef().getBoolean(gfVar.DW(), false)) {
                arrayList.add(gfVar.name());
            }
        }
        return arrayList;
    }

    public static int vy() {
        try {
            return Integer.parseInt(ef().getString("js_indentation_size", "4"));
        } catch (NumberFormatException e) {
            return 4;
        }
    }

    public static int P8() {
        try {
            return Integer.parseInt(ef().getString("cpp_indentation_size", "4"));
        } catch (NumberFormatException e) {
            return 4;
        }
    }

    public static int ei() {
        try {
            return Integer.parseInt(ef().getString("java_indentation_size", "4"));
        } catch (NumberFormatException e) {
            return 4;
        }
    }

    public static int nw() {
        try {
            return Integer.parseInt(ef().getString("xml_indentation_size", "4"));
        } catch (NumberFormatException e) {
            return 4;
        }
    }

    public static int SI() {
        try {
            return Integer.parseInt(ef().getString("css_indentation_size", "2"));
        } catch (NumberFormatException e) {
            return 2;
        }
    }

    public static int KD() {
        try {
            return Integer.parseInt(ef().getString("html_indentation_size", "2"));
        } catch (NumberFormatException e) {
            return 2;
        }
    }

    public static String ro() {
        return ef().getString("app_language", "default");
    }

    public static boolean cn() {
        if (e.VH()) {
            return true;
        }
        return ef().getBoolean("light_theme", true);
    }

    public static boolean sh() {
        return ef().getBoolean("browser_swipe", true);
    }

    public static boolean cb() {
        return ef().getBoolean("editor_tabs", false);
    }

    public static Map<String, Integer> dx() {
        Map<String, Integer> hashMap = new HashMap();
        hashMap.put("Java", Integer.valueOf(ei()));
        hashMap.put("JavaScript", Integer.valueOf(vy()));
        hashMap.put("XML", Integer.valueOf(nw()));
        hashMap.put("HTML", Integer.valueOf(KD()));
        return hashMap;
    }

    public static void j6(String str, List<String> list) {
        int i = 0;
        Editor edit = PreferenceManager.getDefaultSharedPreferences(j6).edit();
        if ("Java".equals(str)) {
            for (gf gfVar : gf.values()) {
                edit.putBoolean(gfVar.DW(), list.contains(gfVar.j6()));
            }
        }
        if ("JavaScript".equals(str)) {
            hh[] values = hh.values();
            int length = values.length;
            while (i < length) {
                hh hhVar = values[i];
                edit.putBoolean(hhVar.DW(), list.contains(hhVar.j6()));
                i++;
            }
        }
        edit.commit();
    }

    public static Map<String, List<String>> sG() {
        Map<String, List<String>> hashMap = new HashMap();
        hashMap.put("Java", BT());
        hashMap.put("JavaScript", gW());
        return hashMap;
    }

    public static boolean Hw(String str) {
        return ef().getStringSet("intel_libs_warned_projects", Collections.emptySet()).contains(str);
    }

    public static void v5(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(j6);
        Editor edit = defaultSharedPreferences.edit();
        Set stringSet = defaultSharedPreferences.getStringSet("intel_libs_warned_projects", new HashSet());
        stringSet.add(str);
        edit.putStringSet("intel_libs_warned_projects", stringSet);
        edit.commit();
    }
}
