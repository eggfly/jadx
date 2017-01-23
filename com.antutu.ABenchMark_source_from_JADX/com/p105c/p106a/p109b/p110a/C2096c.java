package com.p105c.p106a.p109b.p110a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import anet.channel.strategy.dispatch.C0714a;
import com.p105c.p106a.p107a.p108a.C2091e;
import com.p105c.p106a.p109b.p110a.C2095b.C2093a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.util.Map.Entry;

/* renamed from: com.c.a.b.a.c */
public class C2096c {
    private String f7355a;
    private String f7356b;
    private boolean f7357c;
    private boolean f7358d;
    private boolean f7359e;
    private SharedPreferences f7360f;
    private C2095b f7361g;
    private Editor f7362h;
    private C2093a f7363i;
    private Context f7364j;
    private C2099d f7365k;
    private boolean f7366l;

    public C2096c(Context context, String str, String str2, boolean z, boolean z2) {
        long a;
        Editor edit;
        C2093a c;
        this.f7355a = BuildConfig.FLAVOR;
        this.f7356b = BuildConfig.FLAVOR;
        this.f7357c = false;
        this.f7358d = false;
        this.f7359e = false;
        this.f7360f = null;
        this.f7361g = null;
        this.f7362h = null;
        this.f7363i = null;
        this.f7364j = null;
        this.f7365k = null;
        this.f7366l = false;
        this.f7357c = z;
        this.f7366l = z2;
        this.f7355a = str2;
        this.f7356b = str;
        this.f7364j = context;
        long j = 0;
        long j2 = 0;
        if (context != null) {
            this.f7360f = context.getSharedPreferences(str2, 0);
            j = this.f7360f.getLong(C0714a.TIMESTAMP, 0);
        }
        String str3 = null;
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (C2091e.m7809a(str3)) {
            this.f7359e = false;
            this.f7358d = false;
        } else if (str3.equals("mounted")) {
            this.f7359e = true;
            this.f7358d = true;
        } else if (str3.equals("mounted_ro")) {
            this.f7358d = true;
            this.f7359e = false;
        } else {
            this.f7359e = false;
            this.f7358d = false;
        }
        if (!((!this.f7358d && !this.f7359e) || context == null || C2091e.m7809a(str))) {
            this.f7365k = m7835c(str);
            if (this.f7365k != null) {
                long j3;
                try {
                    this.f7361g = this.f7365k.m7869a(str2, 0);
                    a = this.f7361g.m7827a(C0714a.TIMESTAMP, 0);
                    if (z2) {
                        j2 = this.f7360f.getLong("t2", 0);
                        try {
                            j = this.f7361g.m7827a("t2", 0);
                            if (j2 < j && j2 > 0) {
                                try {
                                    m7832a(this.f7360f, this.f7361g);
                                    this.f7361g = this.f7365k.m7869a(str2, 0);
                                    a = j2;
                                } catch (Exception e2) {
                                    j3 = j;
                                    j = j2;
                                    j2 = j3;
                                    if (j == j2) {
                                    }
                                    a = System.currentTimeMillis();
                                    if (this.f7366l) {
                                    }
                                    if (this.f7360f != null) {
                                        edit = this.f7360f.edit();
                                        edit.putLong("t2", a);
                                        edit.commit();
                                    }
                                    if (this.f7361g != null) {
                                        c = this.f7361g.m7831c();
                                        c.m7822a("t2", a);
                                        c.m7825b();
                                    }
                                }
                            } else if (j2 > j && j > 0) {
                                m7833a(this.f7361g, this.f7360f);
                                this.f7360f = context.getSharedPreferences(str2, 0);
                                a = j2;
                            } else if (j2 == 0 && j > 0) {
                                m7833a(this.f7361g, this.f7360f);
                                this.f7360f = context.getSharedPreferences(str2, 0);
                                a = j2;
                            } else if (j != 0 || j2 <= 0) {
                                if (j2 == j) {
                                    m7832a(this.f7360f, this.f7361g);
                                    this.f7361g = this.f7365k.m7869a(str2, 0);
                                }
                                a = j2;
                            } else {
                                m7832a(this.f7360f, this.f7361g);
                                this.f7361g = this.f7365k.m7869a(str2, 0);
                                a = j2;
                            }
                        } catch (Exception e3) {
                            j = a;
                            j3 = j;
                            j = j2;
                            j2 = j3;
                            if (j == j2) {
                            }
                            a = System.currentTimeMillis();
                            if (this.f7366l) {
                            }
                            if (this.f7360f != null) {
                                edit = this.f7360f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            if (this.f7361g != null) {
                                c = this.f7361g.m7831c();
                                c.m7822a("t2", a);
                                c.m7825b();
                            }
                        }
                    } else if (j > a) {
                        try {
                            m7832a(this.f7360f, this.f7361g);
                            this.f7361g = this.f7365k.m7869a(str2, 0);
                            j3 = a;
                            a = j;
                            j = j3;
                        } catch (Exception e4) {
                            j2 = j;
                            j = a;
                            j3 = j;
                            j = j2;
                            j2 = j3;
                            if (j == j2) {
                            }
                            a = System.currentTimeMillis();
                            if (this.f7366l) {
                            }
                            if (this.f7360f != null) {
                                edit = this.f7360f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            try {
                                if (this.f7361g != null) {
                                    c = this.f7361g.m7831c();
                                    c.m7822a("t2", a);
                                    c.m7825b();
                                }
                            } catch (Exception e5) {
                                return;
                            }
                        }
                    } else if (j < a) {
                        m7833a(this.f7361g, this.f7360f);
                        this.f7360f = context.getSharedPreferences(str2, 0);
                        j3 = a;
                        a = j;
                        j = j3;
                    } else if (j == a) {
                        m7832a(this.f7360f, this.f7361g);
                        this.f7361g = this.f7365k.m7869a(str2, 0);
                        j3 = a;
                        a = j;
                        j = j3;
                    } else {
                        j3 = a;
                        a = j;
                        j = j3;
                    }
                    j2 = j;
                    j = a;
                } catch (Exception e6) {
                    j2 = j;
                    j = 0;
                    j3 = j;
                    j = j2;
                    j2 = j3;
                    if (j == j2) {
                    }
                    a = System.currentTimeMillis();
                    if (this.f7366l) {
                    }
                    if (this.f7360f != null) {
                        edit = this.f7360f.edit();
                        edit.putLong("t2", a);
                        edit.commit();
                    }
                    if (this.f7361g != null) {
                        c = this.f7361g.m7831c();
                        c.m7822a("t2", a);
                        c.m7825b();
                    }
                }
            }
        }
        if (j == j2 || (j == 0 && j2 == 0)) {
            a = System.currentTimeMillis();
            if (this.f7366l || (this.f7366l && j == 0 && j2 == 0)) {
                if (this.f7360f != null) {
                    edit = this.f7360f.edit();
                    edit.putLong("t2", a);
                    edit.commit();
                }
                if (this.f7361g != null) {
                    c = this.f7361g.m7831c();
                    c.m7822a("t2", a);
                    c.m7825b();
                }
            }
        }
    }

    private void m7832a(SharedPreferences sharedPreferences, C2095b c2095b) {
        if (sharedPreferences != null && c2095b != null) {
            C2093a c = c2095b.m7831c();
            if (c != null) {
                c.m7818a();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        c.m7823a(str, (String) value);
                    } else if (value instanceof Integer) {
                        c.m7821a(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        c.m7822a(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        c.m7820a(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        c.m7824a(str, ((Boolean) value).booleanValue());
                    }
                }
                c.m7825b();
            }
        }
    }

    private void m7833a(C2095b c2095b, SharedPreferences sharedPreferences) {
        if (c2095b != null && sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.clear();
                for (Entry entry : c2095b.m7830b().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        edit.putString(str, (String) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) value).booleanValue());
                    }
                }
                edit.commit();
            }
        }
    }

    private boolean m7834b() {
        if (this.f7361g == null) {
            return false;
        }
        boolean a = this.f7361g.m7829a();
        if (a) {
            return a;
        }
        m7840a();
        return a;
    }

    private C2099d m7835c(String str) {
        File d = m7837d(str);
        if (d == null) {
            return null;
        }
        this.f7365k = new C2099d(d.getAbsolutePath());
        return this.f7365k;
    }

    private void m7836c() {
        if (this.f7362h == null && this.f7360f != null) {
            this.f7362h = this.f7360f.edit();
        }
        if (this.f7359e && this.f7363i == null && this.f7361g != null) {
            this.f7363i = this.f7361g.m7831c();
        }
        m7834b();
    }

    private File m7837d(String str) {
        if (Environment.getExternalStorageDirectory() == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), File.separator, str}));
        if (file == null || file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public void m7838a(String str) {
        if (!C2091e.m7809a(str) && !str.equals(C0714a.TIMESTAMP)) {
            m7836c();
            if (this.f7362h != null) {
                this.f7362h.remove(str);
            }
            if (this.f7363i != null) {
                this.f7363i.m7819a(str);
            }
        }
    }

    public void m7839a(String str, String str2) {
        if (!C2091e.m7809a(str) && !str.equals(C0714a.TIMESTAMP)) {
            m7836c();
            if (this.f7362h != null) {
                this.f7362h.putString(str, str2);
            }
            if (this.f7363i != null) {
                this.f7363i.m7823a(str, str2);
            }
        }
    }

    public boolean m7840a() {
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f7362h != null) {
            if (!(this.f7366l || this.f7360f == null)) {
                this.f7362h.putLong(C0714a.TIMESTAMP, currentTimeMillis);
            }
            if (!this.f7362h.commit()) {
                z = false;
            }
        }
        if (!(this.f7360f == null || this.f7364j == null)) {
            this.f7360f = this.f7364j.getSharedPreferences(this.f7355a, 0);
        }
        String str = null;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!C2091e.m7809a(str)) {
            if (str.equals("mounted")) {
                if (this.f7361g == null) {
                    C2099d c = m7835c(this.f7356b);
                    if (c != null) {
                        this.f7361g = c.m7869a(this.f7355a, 0);
                        if (this.f7366l) {
                            m7833a(this.f7361g, this.f7360f);
                        } else {
                            m7832a(this.f7360f, this.f7361g);
                        }
                        this.f7363i = this.f7361g.m7831c();
                    }
                } else if (!(this.f7363i == null || this.f7363i.m7825b())) {
                    z = false;
                }
            }
            if (str.equals("mounted") || (str.equals("mounted_ro") && this.f7361g != null)) {
                try {
                    if (this.f7365k != null) {
                        this.f7361g = this.f7365k.m7869a(this.f7355a, 0);
                    }
                } catch (Exception e2) {
                }
            }
        }
        return z;
    }

    public String m7841b(String str) {
        m7834b();
        if (this.f7360f != null) {
            String string = this.f7360f.getString(str, BuildConfig.FLAVOR);
            if (!C2091e.m7809a(string)) {
                return string;
            }
        }
        return this.f7361g != null ? this.f7361g.m7828a(str, BuildConfig.FLAVOR) : BuildConfig.FLAVOR;
    }
}
