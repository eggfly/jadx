package com.igexin.push.util;

import java.util.Random;

/* renamed from: com.igexin.push.util.p */
public class C3937p {
    private static final String f13218b;
    private static char[] f13219c;
    public int f13220a;
    private Random f13221d;

    static {
        f13218b = C3937p.class.getName();
        f13219c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz`~!@#$%^&*()-_=+[{}];:'/?.>,<".toCharArray();
    }

    public C3937p() {
        this.f13220a = 16;
        this.f13221d = new Random(System.currentTimeMillis());
    }

    public static String m16190a(int i) {
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuilder.toString();
    }
}
