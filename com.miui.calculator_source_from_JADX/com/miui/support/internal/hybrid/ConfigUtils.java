package com.miui.support.internal.hybrid;

import java.util.Set;
import java.util.TreeSet;

public class ConfigUtils {
    private ConfigUtils() {
    }

    public static String m4008a(Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("timestamp");
        stringBuilder.append(":");
        stringBuilder.append(config.m3994a().m4075b());
        stringBuilder.append(",");
        stringBuilder.append("vendor");
        stringBuilder.append(":");
        stringBuilder.append("\"");
        stringBuilder.append(config.m4000b());
        stringBuilder.append("\"");
        stringBuilder.append(",");
        stringBuilder.append(m4010b(config));
        stringBuilder.append(",");
        stringBuilder.append(m4012d(config));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static String m4010b(Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("features");
        stringBuilder.append(":");
        stringBuilder.append("[");
        stringBuilder.append(m4011c(config));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String m4011c(Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> treeSet = new TreeSet(config.m4005d().keySet());
        if (treeSet.isEmpty()) {
            return "";
        }
        for (String str : treeSet) {
            stringBuilder.append("{");
            stringBuilder.append("name");
            stringBuilder.append(":");
            stringBuilder.append("\"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            stringBuilder.append(",");
            stringBuilder.append("params");
            stringBuilder.append(":");
            stringBuilder.append("[");
            stringBuilder.append(m4009a(config.m4002c(str)));
            stringBuilder.append("]");
            stringBuilder.append("}");
            stringBuilder.append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static String m4009a(Feature feature) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> treeSet = new TreeSet(feature.m4018b().keySet());
        if (treeSet.isEmpty()) {
            return "";
        }
        for (String str : treeSet) {
            stringBuilder.append("{");
            stringBuilder.append("name");
            stringBuilder.append(":");
            stringBuilder.append("\"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            stringBuilder.append(",");
            stringBuilder.append("value");
            stringBuilder.append(":");
            stringBuilder.append("\"");
            stringBuilder.append(feature.m4017b(str));
            stringBuilder.append("\"");
            stringBuilder.append("}");
            stringBuilder.append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static String m4012d(Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("permissions");
        stringBuilder.append(":");
        stringBuilder.append("[");
        stringBuilder.append(m4013e(config));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static Object m4013e(Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> treeSet = new TreeSet(config.m4006e().keySet());
        if (treeSet.isEmpty()) {
            return "";
        }
        for (String str : treeSet) {
            stringBuilder.append("{");
            stringBuilder.append("origin");
            stringBuilder.append(":");
            stringBuilder.append("\"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            stringBuilder.append(",");
            stringBuilder.append("subdomains");
            stringBuilder.append(":");
            stringBuilder.append(config.m4004d(str).m4069b());
            stringBuilder.append("}");
            stringBuilder.append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
