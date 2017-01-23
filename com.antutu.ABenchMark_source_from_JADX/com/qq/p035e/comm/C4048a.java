package com.qq.p035e.comm;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import anet.channel.strategy.dispatch.C0714a;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.qq.p035e.comm.constants.Constants.PLUGIN;
import com.qq.p035e.comm.constants.CustomPkgConstants;
import com.qq.p035e.comm.managers.plugin.PM;
import com.qq.p035e.comm.managers.setting.C4055a;
import com.qq.p035e.comm.managers.setting.SM;
import com.qq.p035e.comm.managers.status.APPStatus;
import com.qq.p035e.comm.managers.status.DeviceStatus;
import com.qq.p035e.comm.managers.status.SDKStatus;
import com.qq.p035e.comm.util.FileUtil;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.a */
public class C4048a {
    private String f13444a;
    private C4055a f13445b;

    public C4048a(String str, C4055a c4055a) {
        this.f13444a = str;
        this.f13445b = c4055a;
    }

    public static JSONObject m16534a(PM pm) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(Constants.KEY_ELECTION_SDKV, SDKStatus.getSDKVersion());
        jSONObject.putOpt("pv", Integer.valueOf(pm.getPluginVersion()));
        return jSONObject;
    }

    public static JSONObject m16535a(SM sm) {
        JSONObject jSONObject = new JSONObject();
        if (sm != null) {
            jSONObject.putOpt("suid", sm.getSuid());
            jSONObject.putOpt(Constants.KEY_SID, sm.getSid());
        }
        return jSONObject;
    }

    public static JSONObject m16536a(APPStatus aPPStatus) {
        JSONObject jSONObject = new JSONObject();
        if (aPPStatus != null) {
            jSONObject.putOpt("an", aPPStatus.getAPPName());
            jSONObject.putOpt(C4209a.f14204g, aPPStatus.getAPPID());
            jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
        }
        return jSONObject;
    }

    public static JSONObject m16537a(DeviceStatus deviceStatus) {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
            jSONObject.putOpt("dn", deviceStatus.getDataNet());
            jSONObject.putOpt(C0714a.LATITUDE, deviceStatus.getLat());
            jSONObject.putOpt(C0714a.OTHER, deviceStatus.getLng());
            for (Entry entry : deviceStatus.getLacAndCeilId().entrySet()) {
                jSONObject.putOpt((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    public static boolean m16538a(Context context) {
        try {
            if (C4048a.m16542b(context)) {
                if (C4048a.m16540a(context, Class.forName(CustomPkgConstants.getADActivityName()))) {
                    if (C4048a.m16543b(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.m16601e("Exception While check SDK Env", th);
            return false;
        }
    }

    public static boolean m16539a(Context context, File file, File file2) {
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0) {
                return false;
            }
            String str = CustomPkgConstants.getAssetPluginDir() + File.separator + CustomPkgConstants.getAssetPluginName();
            StringUtil.writeTo("524#####" + PLUGIN.ASSET_PLUGIN_SIG, file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(str), file);
            }
            InputStream open = assets.open(str);
            OutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            int length = bytes.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    int i3 = 0;
                    while (i3 < read) {
                        int i4 = i + 1;
                        if (i >= 64) {
                            i = i2 + 1;
                            bArr[i3] = (byte) (bytes[i2 % length] ^ bArr[i3]);
                        } else {
                            i = i2;
                        }
                        i3++;
                        i2 = i;
                        i = i4;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
            return false;
        }
    }

    private static boolean m16540a(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[0]);
                if (context.getPackageManager().resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT) == null) {
                    GDTLogger.m16600e(String.format("Activity[%s] is required in AndroidManifest.xml", new Object[]{clsArr[0].getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m16601e("Exception while checking required activities", th);
                return false;
            }
        }
        return true;
    }

    public static byte[] m16541a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        Exception e;
        Throwable th;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return bArr2;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                            return bArr2;
                        }
                    }
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e222) {
                            e222.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        } catch (Exception e4) {
            e222 = e4;
            gZIPOutputStream = bArr2;
            e222.printStackTrace();
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Throwable th3) {
            gZIPOutputStream = bArr2;
            th = th3;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    private static boolean m16542b(Context context) {
        String[] strArr = new String[]{MsgConstant.PERMISSION_INTERNET, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, MsgConstant.PERMISSION_ACCESS_WIFI_STATE, MsgConstant.PERMISSION_READ_PHONE_STATE, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE};
        int i = 0;
        while (i < 5) {
            try {
                if (context.checkCallingOrSelfPermission(strArr[i]) == -1) {
                    GDTLogger.m16600e(String.format("Permission %s is required in AndroidManifest.xml", new Object[]{strArr[i]}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m16601e("Check required Permissions error", th);
                return false;
            }
        }
        return true;
    }

    private static boolean m16543b(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Class cls = clsArr[0];
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, AccessibilityNodeInfoCompat.ACTION_CUT) == null) {
                    GDTLogger.m16600e(String.format("Service[%s] is required in AndroidManifest.xml", new Object[]{cls.getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m16601e("Exception while checking required services", th);
                return false;
            }
        }
        return true;
    }

    public static byte[] m16544b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        Exception e;
        Throwable th;
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr3 = new byte[IXAdIOUtils.BUFFER_SIZE];
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            while (true) {
                try {
                    int read = gZIPInputStream.read(bArr3);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr3, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        bArr2 = byteArrayOutputStream.toByteArray();
                        try {
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                            return bArr2;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return bArr2;
                        }
                    }
                } catch (Exception e3) {
                    e2 = e3;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            gZIPInputStream = bArr2;
            try {
                e2.printStackTrace();
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        return bArr2;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e222) {
                        e222.printStackTrace();
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            gZIPInputStream = bArr2;
            th = th3;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public String m16545a() {
        return this.f13444a;
    }

    public C4055a m16546b() {
        return this.f13445b;
    }
}
