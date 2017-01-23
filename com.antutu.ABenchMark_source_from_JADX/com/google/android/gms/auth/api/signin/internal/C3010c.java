package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.C3512u;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* renamed from: com.google.android.gms.auth.api.signin.internal.c */
public class C3010c {
    private static final Lock f10177a;
    private static C3010c f10178b;
    private final Lock f10179c;
    private final SharedPreferences f10180d;

    static {
        f10177a = new ReentrantLock();
    }

    C3010c(Context context) {
        this.f10179c = new ReentrantLock();
        this.f10180d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static C3010c m11706a(Context context) {
        C3512u.m14580a((Object) context);
        f10177a.lock();
        try {
            if (f10178b == null) {
                f10178b = new C3010c(context.getApplicationContext());
            }
            C3010c c3010c = f10178b;
            return c3010c;
        } finally {
            f10177a.unlock();
        }
    }

    private String m11707a(String str, String str2) {
        return str + ":" + str2;
    }

    public GoogleSignInAccount m11708a() {
        return m11709a(m11710b("defaultGoogleSignInAccount"));
    }

    GoogleSignInAccount m11709a(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String b = m11710b(m11707a("googleSignInAccount", str));
            if (b != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.m11651a(b);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    protected String m11710b(String str) {
        this.f10179c.lock();
        try {
            String string = this.f10180d.getString(str, null);
            return string;
        } finally {
            this.f10179c.unlock();
        }
    }
}
