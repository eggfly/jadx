package com.miui.support.extension;

import android.util.Log;
import com.miui.support.extension.invoker.Invoker;
import com.miui.support.reflect.Constructor;

public class Extension {
    private final String f1982a;
    private final String f1983b;
    private final String f1984c;
    private Invoker f1985d;
    private boolean f1986e;

    public Extension(String str, String str2, String str3) {
        this.f1982a = str;
        this.f1983b = str2;
        this.f1984c = str3;
    }

    public String m3439a() {
        return this.f1982a;
    }

    public void m3440a(String str, Object... objArr) {
        if (this.f1983b == null || this.f1983b.equals(str)) {
            m3438b();
            if (this.f1985d != null) {
                try {
                    this.f1985d.m3445a(str, objArr);
                } catch (Throwable e) {
                    Log.e("Extension", "Fail to invoke ActivityExecutor, invoker=" + this.f1984c, e);
                }
            }
        }
    }

    private void m3438b() {
        if (!this.f1986e) {
            try {
                this.f1985d = (Invoker) Constructor.of(this.f1984c, "()V").newInstance(new Object[0]);
            } catch (Throwable e) {
                Log.e("Extension", "Fail to initialize ActivityExecutor, invoker=" + this.f1984c, e);
            } catch (Throwable e2) {
                Log.e("Extension", "Fail to initialize ActivityExecutor, invoker=" + this.f1984c, e2);
            } finally {
                this.f1986e = true;
            }
        }
    }
}
