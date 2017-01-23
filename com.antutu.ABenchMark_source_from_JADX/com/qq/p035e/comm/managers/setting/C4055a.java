package com.qq.p035e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.qq.p035e.comm.C4048a;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.qq.p035e.comm.constants.Constants.SETTING;
import com.qq.p035e.comm.util.C4068a;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.umeng.message.util.HttpRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.a */
public class C4055a {
    private JSONObject f13483a;

    public C4055a() {
        this.f13483a = new JSONObject();
    }

    public C4055a(String str) {
        this();
        GDTLogger.m16599d("Initialize GDTAPPSetting,Json=" + str);
        if (!StringUtil.isEmpty(str)) {
            try {
                this.f13483a = new JSONObject(str);
            } catch (Throwable e) {
                GDTLogger.m16601e("JsonException While build GDTAPPSetting Instance from JSON", e);
            }
        }
    }

    private static Pair<String, String> m16564a(Context context, String str) {
        File dir = context.getDir(SETTING.SETTINGDIR, 0);
        if (!dir.exists()) {
            return null;
        }
        File file = new File(dir, str + ".sig");
        File file2 = new File(dir, str + ".cfg");
        if (!file.exists() || !file2.exists()) {
            return null;
        }
        try {
            return new Pair(StringUtil.readAll(file), StringUtil.readAll(file2));
        } catch (IOException e) {
            return null;
        }
    }

    public static C4048a m16565a(Context context) {
        Pair a = C4055a.m16564a(context, SETTING.DEV_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (C4068a.m16605a().m16608a((String) a.first, (String) a.second)) {
                return new C4048a((String) a.first, new C4055a(new String(Base64.decode((String) a.second, 0), HttpRequest.f14548a)));
            }
            GDTLogger.m16600e("verify local dev cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.m16601e("exception while loading local dev cloud setting", th);
            return null;
        }
    }

    public static boolean m16566a(Context context, String str, String str2) {
        return C4055a.m16567a(context, SETTING.SDK_CLOUD_SETTING, str, str2);
    }

    private static boolean m16567a(Context context, String str, String str2, String str3) {
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            GDTLogger.m16600e(String.format("Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s", new Object[]{str, str2, str3}));
            return false;
        } else if (C4068a.m16605a().m16608a(str2, str3)) {
            return C4055a.m16570b(context, str, str2, str3);
        } else {
            GDTLogger.m16600e(String.format("Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s", new Object[]{str, str2, str3}));
            return false;
        }
    }

    public static C4058d m16568b(Context context) {
        Pair a = C4055a.m16564a(context, SETTING.SDK_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (C4068a.m16605a().m16608a((String) a.first, (String) a.second)) {
                return new C4058d(new C4056c(new String(Base64.decode((String) a.second, 0), HttpRequest.f14548a)), (byte) 0);
            }
            GDTLogger.m16600e("verify local sdk cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.m16601e("exception while loading local sdk cloud setting", th);
            return null;
        }
    }

    public static boolean m16569b(Context context, String str, String str2) {
        return C4055a.m16567a(context, SETTING.DEV_CLOUD_SETTING, str, str2);
    }

    private static boolean m16570b(Context context, String str, String str2, String str3) {
        Throwable th;
        FileWriter fileWriter = null;
        File dir = context.getDir(SETTING.SETTINGDIR, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, str + ".cfg");
        File file2 = new File(dir, str + ".sig");
        FileWriter fileWriter2;
        FileWriter fileWriter3;
        try {
            fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str3);
                fileWriter3 = new FileWriter(file2);
                try {
                    fileWriter3.write(str2);
                    try {
                        fileWriter2.close();
                        fileWriter3.close();
                    } catch (Exception e) {
                    }
                    return true;
                } catch (Exception e2) {
                    fileWriter = fileWriter2;
                    try {
                        file.delete();
                        file2.delete();
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e3) {
                                return false;
                            }
                        }
                        if (fileWriter3 != null) {
                            return false;
                        }
                        fileWriter3.close();
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter2 = fileWriter;
                        fileWriter = fileWriter3;
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                            } catch (Exception e4) {
                                throw th;
                            }
                        }
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter3;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileWriter3 = null;
                fileWriter = fileWriter2;
                file.delete();
                file2.delete();
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (fileWriter3 != null) {
                    return false;
                }
                fileWriter3.close();
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (fileWriter2 != null) {
                    fileWriter2.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            fileWriter3 = null;
            file.delete();
            file2.delete();
            if (fileWriter != null) {
                fileWriter.close();
            }
            if (fileWriter3 != null) {
                return false;
            }
            fileWriter3.close();
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileWriter2 = null;
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw th;
        }
    }

    final Object m16571a(String str) {
        return this.f13483a.opt(str);
    }

    final Object m16572a(String str, String str2) {
        JSONObject optJSONObject = this.f13483a.optJSONObject(KEYS.PLACEMENTS);
        optJSONObject = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        return optJSONObject != null ? optJSONObject.opt(str) : null;
    }

    final void m16573a(String str, Object obj) {
        try {
            this.f13483a.putOpt(str, obj);
        } catch (Throwable e) {
            GDTLogger.m16601e("Exception while update setting", e);
        }
    }

    final void m16574a(String str, Object obj, String str2) {
        try {
            JSONObject jSONObject;
            JSONObject optJSONObject = this.f13483a.optJSONObject(KEYS.PLACEMENTS);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                this.f13483a.putOpt(KEYS.PLACEMENTS, optJSONObject);
                jSONObject = optJSONObject;
            } else {
                jSONObject = optJSONObject;
            }
            optJSONObject = jSONObject != null ? jSONObject.optJSONObject(str2) : null;
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.putOpt(str2, optJSONObject);
            }
            if (obj == null) {
                optJSONObject.remove(str);
            } else {
                optJSONObject.putOpt(str, obj);
            }
        } catch (Throwable e) {
            GDTLogger.m16601e("Exception while update setting", e);
        }
    }
}
