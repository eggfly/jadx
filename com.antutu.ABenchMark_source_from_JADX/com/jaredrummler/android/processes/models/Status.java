package com.jaredrummler.android.processes.models;

public final class Status extends ProcFile {
    private Status(String str) {
        super(str);
    }

    public static Status m16333a(int i) {
        return new Status(String.format("/proc/%d/status", new Object[]{Integer.valueOf(i)}));
    }

    public int m16334a() {
        try {
            return Integer.parseInt(m16335a("Uid").split("\\s+")[0]);
        } catch (Exception e) {
            return -1;
        }
    }

    public String m16335a(String str) {
        for (String str2 : this.b.split("\n")) {
            if (str2.startsWith(new StringBuilder(String.valueOf(str)).append(":").toString())) {
                return str2.split(new StringBuilder(String.valueOf(str)).append(":").toString())[1].trim();
            }
        }
        return null;
    }
}
