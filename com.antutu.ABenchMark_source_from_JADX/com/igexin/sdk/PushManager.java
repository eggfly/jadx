package com.igexin.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.util.C3937p;
import com.igexin.sdk.p186a.C3941c;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

public class PushManager {
    private long f13223a;
    private long f13224b;
    private long f13225c;
    private byte[] f13226d;
    private String f13227e;

    private PushManager() {
        this.f13226d = null;
        this.f13227e = C3937p.m16190a(32);
    }

    private Intent m16199a() {
        Intent intent = new Intent(PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("verifyCode", this.f13227e);
        return intent;
    }

    private String m16200a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(BuildConfig.FLAVOR);
            for (int i : digest) {
                int i2;
                if (i2 < 0) {
                    i2 += AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                }
                if (i2 < 16) {
                    stringBuilder.append(MessageService.MSG_DB_READY_REPORT);
                }
                stringBuilder.append(Integer.toHexString(i2));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private byte[] m16201a(Context context) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        Throwable th;
        byte[] bArr = null;
        try {
            String str = "/data/data/" + context.getPackageName() + "/files/" + "init.pid";
            if (new File(str).exists()) {
                byte[] bArr2 = new byte[IXAdIOUtils.BUFFER_SIZE];
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Exception e) {
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileInputStream2 = fileInputStream;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                th = th3;
                            }
                        }
                        bArr = byteArrayOutputStream.toByteArray();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Exception e4) {
                        byteArrayOutputStream = bArr;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        return bArr;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream2 = fileInputStream;
                        byteArrayOutputStream2 = bArr;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e7) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e8) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    byteArrayOutputStream = bArr;
                    fileInputStream = bArr;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream2 = bArr;
                    fileInputStream2 = bArr;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
        }
        return bArr;
    }

    public static PushManager getInstance() {
        return C3946b.f13247a;
    }

    public boolean bindAlias(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f13225c <= 5000) {
            return false;
        }
        this.f13225c = currentTimeMillis;
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "bindAlias");
        a.putExtra(C4233j.f14403z, str);
        C3688a.m15097b("-> call bindAlias...");
        context.sendBroadcast(a);
        return true;
    }

    public String getClientid(Context context) {
        if (this.f13226d != null) {
            byte[] a = m16201a(context);
            if (!(this.f13226d == null || a == null || this.f13226d.length != a.length)) {
                byte[] bArr = new byte[a.length];
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (this.f13226d[i] ^ a[i]);
                }
                return new String(bArr);
            }
        }
        return null;
    }

    public String getVerifyCode() {
        return this.f13227e;
    }

    public String getVersion(Context context) {
        return PushBuildConfig.sdk_conf_version;
    }

    public void initialize(Context context) {
        try {
            String packageName = context.getApplicationContext().getPackageName();
            Intent intent = new Intent(context.getApplicationContext(), PushService.class);
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE);
            intent.putExtra("op_app", packageName);
            context.getApplicationContext().startService(intent);
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSLV2);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                Object string = applicationInfo.metaData.getString("PUSH_APPID");
                Object string2 = applicationInfo.metaData.getString("PUSH_APPSECRET");
                Object string3 = applicationInfo.metaData.getString("PUSH_APPKEY");
                if (string != null) {
                    string = string.trim();
                }
                if (string2 != null) {
                    string2 = string2.trim();
                }
                if (string3 != null) {
                    string3 = string3.trim();
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                    packageName = m16200a(string + string2 + string3 + context.getPackageName());
                    if (packageName != null) {
                        this.f13226d = packageName.getBytes();
                    }
                }
            }
        } catch (Exception e) {
            C3688a.m15097b("PushManager|" + e.toString());
        }
    }

    public boolean isPushTurnedOn(Context context) {
        return new C3941c(context).m16225c();
    }

    public boolean sendFeedbackMessage(Context context, String str, String str2, int i) {
        if (str == null || str2 == null || i < PushConsts.MIN_FEEDBACK_ACTION || i > PushConsts.MAX_FEEDBACK_ACTION) {
            return false;
        }
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "sendFeedbackMessage");
        a.putExtra("taskid", str);
        a.putExtra("messageid", str2);
        a.putExtra("actionid", String.valueOf(i));
        context.sendBroadcast(a);
        return true;
    }

    public boolean sendMessage(Context context, String str, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || bArr == null || ((long) bArr.length) > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM || currentTimeMillis - this.f13224b < 1000) {
            return false;
        }
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "sendMessage");
        a.putExtra("taskid", str);
        a.putExtra("extraData", bArr);
        context.sendBroadcast(a);
        return true;
    }

    public boolean setHeartbeatInterval(Context context, int i) {
        if (i < 0) {
            return false;
        }
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "setHeartbeatInterval");
        a.putExtra(MsgConstant.KEY_LOCATION_INTERVAL, i);
        context.sendBroadcast(a);
        return true;
    }

    public boolean setSilentTime(Context context, int i, int i2) {
        if (i < 0 || i >= 24 || i2 < 0 || i2 > 23) {
            return false;
        }
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "setSilentTime");
        a.putExtra("beginHour", i);
        a.putExtra("duration", i2);
        context.sendBroadcast(a);
        return true;
    }

    public boolean setSocketTimeout(Context context, int i) {
        if (i < 0) {
            return false;
        }
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "setSocketTimeout");
        a.putExtra("timeout", i);
        context.sendBroadcast(a);
        return true;
    }

    public int setTag(Context context, Tag[] tagArr, String str) {
        if (tagArr == null) {
            C3688a.m15097b("PushManager|tags is null");
            return PushConsts.SETTAG_ERROR_NULL;
        } else if (str == null) {
            C3688a.m15097b("PushManager|sn is null");
            return PushConsts.SETTAG_SN_NULL;
        } else if (((long) tagArr.length) > 200) {
            return PushConsts.SETTAG_ERROR_COUNT;
        } else {
            if (this.f13223a > System.currentTimeMillis() - 1000) {
                return PushConsts.SETTAG_ERROR_FREQUENCY;
            }
            Intent a = m16199a();
            a.putExtra(PushConsts.CMD_ACTION, "setTag");
            a.putExtra(IXAdRequestInfo.SN, str);
            StringBuilder stringBuilder = new StringBuilder();
            for (Tag tag : tagArr) {
                if (!(tag == null || tag.getName() == null)) {
                    stringBuilder.append(tag.getName());
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            if (stringBuilder.length() <= 0) {
                return PushConsts.SETTAG_ERROR_NULL;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            a.putExtra(MsgConstant.KEY_TAGS, stringBuilder.toString());
            context.sendBroadcast(a);
            this.f13223a = System.currentTimeMillis();
            return 0;
        }
    }

    public void stopService(Context context) {
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "stopService");
        context.sendBroadcast(a);
    }

    public void turnOffPush(Context context) {
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "turnOffPush");
        context.sendBroadcast(a);
    }

    public void turnOnPush(Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        try {
            Intent intent = new Intent(context.getApplicationContext(), PushService.class);
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
            intent.putExtra("op_app", packageName);
            intent.putExtra("isSlave", true);
            context.getApplicationContext().startService(intent);
        } catch (Exception e) {
        }
    }

    public boolean unBindAlias(Context context, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f13225c <= 5000) {
            return false;
        }
        this.f13225c = currentTimeMillis;
        Intent a = m16199a();
        a.putExtra(PushConsts.CMD_ACTION, "unbindAlias");
        a.putExtra(C4233j.f14403z, str);
        a.putExtra("isSeft", z);
        C3688a.m15097b("-> call unbindAlias...");
        context.sendBroadcast(a);
        return true;
    }
}
