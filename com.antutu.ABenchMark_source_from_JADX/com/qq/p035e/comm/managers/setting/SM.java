package com.qq.p035e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.constants.Constants.SETTING;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;

/* renamed from: com.qq.e.comm.managers.setting.SM */
public class SM {
    private C4055a f13473a;
    private String f13474b;
    private C4055a f13475c;
    private C4055a f13476d;
    private String f13477e;
    private C4056c f13478f;
    private C4056c f13479g;
    private String f13480h;
    private String f13481i;
    private Context f13482j;

    public SM(Context context) {
        this.f13481i = BuildConfig.FLAVOR;
        this.f13482j = context;
        this.f13473a = new C4055a();
        this.f13476d = new C4055a();
        this.f13479g = new C4057b();
        try {
            this.f13480h = StringUtil.readAll(new File(this.f13482j.getDir(SETTING.SETTINGDIR, 0), SETTING.SUID_FILE));
        } catch (Throwable th) {
            this.f13480h = null;
            GDTLogger.m16600e("IO Exception while loading suid");
        }
        m16562a();
        m16563b();
    }

    private void m16562a() {
        C4058d b = C4055a.m16568b(this.f13482j);
        if (b != null) {
            this.f13477e = b.m16577a();
            this.f13478f = b.m16578b();
            return;
        }
        GDTLogger.m16599d("Load Local SDK Cloud setting fail");
    }

    private void m16563b() {
        C4048a a = C4055a.m16565a(this.f13482j);
        if (a != null) {
            this.f13475c = a.m16546b();
            this.f13474b = a.m16545a();
            return;
        }
        GDTLogger.m16599d("Load Local DEV Cloud setting fail");
    }

    public Object get(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            Object a;
            if (this.f13473a.m16571a(str) != null) {
                a = this.f13473a.m16571a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f13475c != null) {
                a = this.f13475c.m16571a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f13476d != null) {
                a = this.f13476d.m16571a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f13478f != null) {
                a = this.f13478f.m16575a(str);
                if (a != null) {
                    return a;
                }
            }
            return this.f13479g != null ? this.f13479g.m16575a(str) : null;
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.get Setting for key:" + str, th);
            return null;
        }
    }

    public String getDevCloudSettingSig() {
        return this.f13474b;
    }

    public Object getForPlacement(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return null;
        }
        try {
            Object a;
            if (this.f13473a != null) {
                a = this.f13473a.m16572a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            if (this.f13475c != null) {
                a = this.f13475c.m16572a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            if (this.f13476d != null) {
                a = this.f13476d.m16572a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            return get(str);
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.getForPlacement", th);
            return null;
        }
    }

    public int getInteger(String str, int i) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i : ((Integer) forPlacement).intValue();
    }

    public String getSdkCloudSettingSig() {
        return this.f13477e;
    }

    public String getSid() {
        return this.f13481i;
    }

    public String getString(String str) {
        Object obj = get(str);
        return obj == null ? null : obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        return forPlacement == null ? null : forPlacement.toString();
    }

    public String getSuid() {
        return this.f13480h;
    }

    public void setDEVCodeSetting(String str, Object obj) {
        this.f13476d.m16573a(str, obj);
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        this.f13476d.m16574a(str, obj, str2);
    }

    public void updateContextSetting(String str) {
        try {
            C4055a c4055a = new C4055a();
            if (!StringUtil.isEmpty(str)) {
                c4055a = new C4055a(new String(Base64.decode(str, 0), HttpRequest.f14548a));
            }
            this.f13473a = c4055a;
        } catch (Throwable th) {
            GDTLogger.report("Exception while update Context Setting", th);
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (C4055a.m16569b(this.f13482j, str, str2)) {
            m16563b();
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (C4055a.m16566a(this.f13482j, str, str2)) {
            m16562a();
        }
    }

    public void updateSID(String str) {
        this.f13481i = str;
    }

    public void updateSUID(String str) {
        if (!StringUtil.isEmpty(str) && !str.equals(this.f13480h)) {
            this.f13480h = str;
            try {
                StringUtil.writeTo(str, new File(this.f13482j.getDir(SETTING.SETTINGDIR, 0), SETTING.SUID_FILE));
            } catch (Throwable e) {
                GDTLogger.report("Exception while persit suid", e);
            }
        }
    }
}
