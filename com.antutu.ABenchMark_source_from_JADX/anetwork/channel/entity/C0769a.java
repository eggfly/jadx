package anetwork.channel.entity;

import anetwork.channel.C0750a;

/* renamed from: anetwork.channel.entity.a */
public class C0769a implements C0750a {
    private final String f2510a;
    private final String f2511b;

    public C0769a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f2510a = str;
        this.f2511b = str2;
    }

    public String m3050a() {
        return this.f2510a;
    }

    public String m3051b() {
        return this.f2511b;
    }
}
