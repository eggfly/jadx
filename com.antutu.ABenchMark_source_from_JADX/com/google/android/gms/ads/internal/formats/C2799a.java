package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import anet.channel.util.HttpConstant;
import com.google.android.gms.p146b.gb;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.a */
public class C2799a {
    static final int f9489a;
    static final int f9490b;
    private static final int f9491c;
    private static final int f9492d;
    private final String f9493e;
    private final List<Drawable> f9494f;
    private final int f9495g;
    private final int f9496h;
    private final int f9497i;
    private final int f9498j;

    static {
        f9491c = Color.rgb(12, 174, HttpConstant.SC_PARTIAL_CONTENT);
        f9492d = Color.rgb(204, 204, 204);
        f9489a = f9492d;
        f9490b = f9491c;
    }

    public C2799a(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i) {
        this.f9493e = str;
        this.f9494f = list;
        this.f9495g = num != null ? num.intValue() : f9489a;
        this.f9496h = num2 != null ? num2.intValue() : f9490b;
        this.f9497i = num3 != null ? num3.intValue() : 12;
        this.f9498j = i;
    }

    public String m10778a() {
        return this.f9493e;
    }

    public List<Drawable> m10779b() {
        return this.f9494f;
    }

    public int m10780c() {
        return this.f9495g;
    }

    public int m10781d() {
        return this.f9496h;
    }

    public int m10782e() {
        return this.f9497i;
    }

    public int m10783f() {
        return this.f9498j;
    }
}
