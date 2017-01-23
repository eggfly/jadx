package com.igexin.p156a;

import android.content.Context;
import android.util.Log;
import com.igexin.p156a.p157a.C3642j;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.igexin.a.h */
public class C3654h {
    protected final Set f12316a;
    protected final C3651e f12317b;
    protected final C3647d f12318c;
    protected boolean f12319d;
    protected boolean f12320e;
    protected C3653g f12321f;

    protected C3654h() {
        this(new C3656j(), new C3648a());
    }

    protected C3654h(C3651e c3651e, C3647d c3647d) {
        this.f12316a = new HashSet();
        if (c3651e == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (c3647d == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        } else {
            this.f12317b = c3651e;
            this.f12318c = c3647d;
        }
    }

    private void m14915c(Context context, String str, String str2) {
        if (!this.f12316a.contains(str) || this.f12319d) {
            try {
                this.f12317b.m14907a(str);
                this.f12316a.add(str);
                m14923a("%s (%s) was loaded normally!", str, str2);
                return;
            } catch (Throwable e) {
                m14923a("Loading the library normally failed: %s", Log.getStackTraceString(e));
                m14923a("%s (%s) was not loaded normally, re-linking...", str, str2);
                File a = m14919a(context, str, str2);
                if (!a.exists() || this.f12319d) {
                    if (this.f12319d) {
                        m14923a("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    m14925b(context, str, str2);
                    this.f12318c.m14902a(context, this.f12317b.m14908a(), this.f12317b.m14910c(str), a, this);
                }
                try {
                    if (this.f12320e) {
                        for (String d : new C3642j(a).m14898b()) {
                            m14920a(context, this.f12317b.m14911d(d));
                        }
                    }
                } catch (IOException e2) {
                }
                this.f12317b.m14909b(a.getAbsolutePath());
                this.f12316a.add(str);
                m14923a("%s (%s) was re-linked!", str, str2);
                return;
            }
        }
        m14923a("%s already loaded previously!", str);
    }

    public C3654h m14916a() {
        this.f12319d = true;
        return this;
    }

    public C3654h m14917a(C3653g c3653g) {
        this.f12321f = c3653g;
        return this;
    }

    protected File m14918a(Context context) {
        return context.getDir("lib", 0);
    }

    protected File m14919a(Context context, String str, String str2) {
        String c = this.f12317b.m14910c(str);
        return C3657k.m14931a(str2) ? new File(m14918a(context), c) : new File(m14918a(context), c + "." + str2);
    }

    public void m14920a(Context context, String str) {
        m14921a(context, str, null, null);
    }

    public void m14921a(Context context, String str, String str2, C3652f c3652f) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (C3657k.m14931a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        } else {
            m14923a("Beginning load of %s...", str);
            if (c3652f == null) {
                m14915c(context, str, str2);
                return;
            }
            try {
                m14915c(context, str, str2);
                c3652f.m14912a();
            } catch (Throwable e) {
                c3652f.m14913a(e);
            }
        }
    }

    public void m14922a(String str) {
        if (this.f12321f != null) {
            this.f12321f.m14914a(str);
        }
    }

    public void m14923a(String str, Object... objArr) {
        m14922a(String.format(Locale.US, str, objArr));
    }

    public C3654h m14924b() {
        this.f12320e = true;
        return this;
    }

    protected void m14925b(Context context, String str, String str2) {
        File a = m14918a(context);
        File a2 = m14919a(context, str, str2);
        File[] listFiles = a.listFiles(new C3655i(this, this.f12317b.m14910c(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.f12319d || !file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }
}
