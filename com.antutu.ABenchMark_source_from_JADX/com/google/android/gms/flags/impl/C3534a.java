package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.p146b.jx;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.a */
public abstract class C3534a<T> {

    /* renamed from: com.google.android.gms.flags.impl.a.a */
    public static class C3535a extends C3534a<Boolean> {

        /* renamed from: com.google.android.gms.flags.impl.a.a.1 */
        static class C35331 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences f12216a;
            final /* synthetic */ String f12217b;
            final /* synthetic */ Boolean f12218c;

            C35331(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.f12216a = sharedPreferences;
                this.f12217b = str;
                this.f12218c = bool;
            }

            public Boolean m14738a() {
                return Boolean.valueOf(this.f12216a.getBoolean(this.f12217b, this.f12218c.booleanValue()));
            }

            public /* synthetic */ Object call() {
                return m14738a();
            }
        }

        public static Boolean m14739a(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) jx.m13581a(new C35331(sharedPreferences, str, bool));
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a.b */
    public static class C3537b extends C3534a<Integer> {

        /* renamed from: com.google.android.gms.flags.impl.a.b.1 */
        static class C35361 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences f12219a;
            final /* synthetic */ String f12220b;
            final /* synthetic */ Integer f12221c;

            C35361(SharedPreferences sharedPreferences, String str, Integer num) {
                this.f12219a = sharedPreferences;
                this.f12220b = str;
                this.f12221c = num;
            }

            public Integer m14740a() {
                return Integer.valueOf(this.f12219a.getInt(this.f12220b, this.f12221c.intValue()));
            }

            public /* synthetic */ Object call() {
                return m14740a();
            }
        }

        public static Integer m14741a(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) jx.m13581a(new C35361(sharedPreferences, str, num));
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a.c */
    public static class C3539c extends C3534a<Long> {

        /* renamed from: com.google.android.gms.flags.impl.a.c.1 */
        static class C35381 implements Callable<Long> {
            final /* synthetic */ SharedPreferences f12222a;
            final /* synthetic */ String f12223b;
            final /* synthetic */ Long f12224c;

            C35381(SharedPreferences sharedPreferences, String str, Long l) {
                this.f12222a = sharedPreferences;
                this.f12223b = str;
                this.f12224c = l;
            }

            public Long m14742a() {
                return Long.valueOf(this.f12222a.getLong(this.f12223b, this.f12224c.longValue()));
            }

            public /* synthetic */ Object call() {
                return m14742a();
            }
        }

        public static Long m14743a(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) jx.m13581a(new C35381(sharedPreferences, str, l));
        }
    }

    /* renamed from: com.google.android.gms.flags.impl.a.d */
    public static class C3541d extends C3534a<String> {

        /* renamed from: com.google.android.gms.flags.impl.a.d.1 */
        static class C35401 implements Callable<String> {
            final /* synthetic */ SharedPreferences f12225a;
            final /* synthetic */ String f12226b;
            final /* synthetic */ String f12227c;

            C35401(SharedPreferences sharedPreferences, String str, String str2) {
                this.f12225a = sharedPreferences;
                this.f12226b = str;
                this.f12227c = str2;
            }

            public String m14744a() {
                return this.f12225a.getString(this.f12226b, this.f12227c);
            }

            public /* synthetic */ Object call() {
                return m14744a();
            }
        }

        public static String m14745a(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) jx.m13581a(new C35401(sharedPreferences, str, str2));
        }
    }
}
