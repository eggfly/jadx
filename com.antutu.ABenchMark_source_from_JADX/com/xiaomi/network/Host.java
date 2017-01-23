package com.xiaomi.network;

import java.net.InetSocketAddress;

public final class Host {
    private String f14854a;
    private int f14855b;

    public Host(String str, int i) {
        this.f14854a = str;
        this.f14855b = i;
    }

    public static Host m17913a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                lastIndexOf = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (lastIndexOf > 0) {
                    i = lastIndexOf;
                }
                str = substring;
            } catch (NumberFormatException e) {
                str = substring;
            }
        }
        return new Host(str, i);
    }

    public static InetSocketAddress m17914b(String str, int i) {
        Host a = m17913a(str, i);
        return new InetSocketAddress(a.m17916b(), a.m17915a());
    }

    public int m17915a() {
        return this.f14855b;
    }

    public String m17916b() {
        return this.f14854a;
    }

    public String toString() {
        return this.f14855b > 0 ? this.f14854a + ":" + this.f14855b : this.f14854a;
    }
}
