package cn.sharesdk.framework.p026b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.util.ErrorConstant;
import cn.sharesdk.framework.p026b.p027a.C0945c;
import cn.sharesdk.framework.p026b.p027a.C0947e;
import cn.sharesdk.framework.p026b.p028b.C0949c;
import cn.sharesdk.framework.p026b.p028b.C0951b;
import cn.sharesdk.framework.p026b.p028b.C0955f;
import cn.sharesdk.framework.p026b.p028b.C0955f.C0954a;
import cn.sharesdk.framework.utils.C0979d;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.igexin.sdk.PushBuildConfig;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.utl.BaseMonitor;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.android.agoo.common.AgooConstants;

/* renamed from: cn.sharesdk.framework.b.a */
public class C0948a {
    private static C0948a f3216a;
    private C0958c f3217b;
    private DeviceHelper f3218c;
    private C0947e f3219d;
    private boolean f3220e;

    private C0948a(Context context, String str) {
        this.f3217b = new C0958c(context, str);
        this.f3219d = C0947e.m4134a(context);
        this.f3218c = DeviceHelper.getInstance(context);
    }

    public static C0948a m4158a(Context context, String str) {
        if (f3216a == null) {
            f3216a = new C0948a(context, str);
        }
        return f3216a;
    }

    private String m4159a(Bitmap bitmap, C0957b c0957b) {
        File createTempFile = File.createTempFile("bm_tmp", ".png");
        OutputStream fileOutputStream = new FileOutputStream(createTempFile);
        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return m4160a(createTempFile.getAbsolutePath(), c0957b);
    }

    private String m4160a(String str, C0957b c0957b) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        CharSequence networkType = this.f3218c.getNetworkType();
        if (PushBuildConfig.sdk_conf_debug_level.equals(networkType) || TextUtils.isEmpty(networkType)) {
            return null;
        }
        int ceil;
        CompressFormat bmpFormat = BitmapHelper.getBmpFormat(str);
        float f = 200.0f;
        if (c0957b == C0957b.BEFORE_SHARE) {
            f = 600.0f;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i >= i2 && ((float) i2) > f) {
            ceil = (int) Math.ceil((double) (((float) options.outHeight) / f));
        } else if (i >= i2 || ((float) i) <= f) {
            return m4165c(str);
        } else {
            ceil = (int) Math.ceil((double) (((float) options.outWidth) / f));
        }
        if (ceil <= 0) {
            ceil = 1;
        }
        options = new Options();
        options.inSampleSize = ceil;
        options.inPurgeable = true;
        options.inInputShareable = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        decodeFile.getHeight();
        decodeFile.getWidth();
        File createTempFile = File.createTempFile("bm_tmp2", "." + bmpFormat.name().toLowerCase());
        OutputStream fileOutputStream = new FileOutputStream(createTempFile);
        decodeFile.compress(bmpFormat, 80, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return m4165c(createTempFile.getAbsolutePath());
    }

    private String m4161a(String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        Pattern compile = Pattern.compile(str2);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null && group.length() > 0) {
                arrayList.add(group);
            }
        }
        if (arrayList.size() == 0) {
            return str;
        }
        HashMap a = this.f3217b.m4244a(str, arrayList, i, str3);
        if (a == null || a.size() <= 0 || !a.containsKey(Constants.KEY_DATA)) {
            return str;
        }
        arrayList = (ArrayList) a.get(Constants.KEY_DATA);
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a = (HashMap) it.next();
            hashMap.put(String.valueOf(a.get(AgooConstants.MESSAGE_FROM_PKG)), String.valueOf(a.get("surl")));
        }
        Matcher matcher2 = compile.matcher(str);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        while (matcher2.find()) {
            stringBuilder.append(str.substring(i2, matcher2.start()));
            stringBuilder.append((String) hashMap.get(matcher2.group()));
            i2 = matcher2.end();
        }
        stringBuilder.append(str.substring(i2, str.length()));
        C0979d.m4390a().m4381i("> SERVER_SHORT_LINK_URL content after replace link ===  %s", stringBuilder.toString());
        return stringBuilder.toString();
    }

    private void m4162a(C0951b c0951b) {
        boolean c = this.f3219d.m4147c();
        Object obj = c0951b.f3238c;
        if (!c || TextUtils.isEmpty(obj)) {
            c0951b.f3239d = null;
            c0951b.f3238c = null;
            return;
        }
        c0951b.f3238c = Data.Base64AES(obj, c0951b.f.substring(0, 16));
    }

    private void m4163a(C0955f c0955f) {
        int i = 0;
        int e = this.f3219d.m4150e();
        boolean c = this.f3219d.m4147c();
        C0954a c0954a = c0955f.f3260d;
        if (e == 1 || (e == 0 && this.f3220e)) {
            CharSequence a;
            int size = (c0954a == null || c0954a.f3252e == null) ? 0 : c0954a.f3252e.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = m4160a((String) c0954a.f3252e.get(i2), C0957b.FINISH_SHARE);
                if (!TextUtils.isEmpty(a)) {
                    c0954a.f3251d.add(a);
                }
            }
            size = (c0954a == null || c0954a.f3253f == null) ? 0 : c0954a.f3253f.size();
            while (i < size) {
                a = m4159a((Bitmap) c0954a.f3253f.get(i), C0957b.FINISH_SHARE);
                if (!TextUtils.isEmpty(a)) {
                    c0954a.f3251d.add(a);
                }
                i++;
            }
        } else {
            c0955f.f3260d = null;
        }
        if (!c) {
            c0955f.f3261n = null;
        }
    }

    private boolean m4164a(String str, boolean z) {
        return this.f3217b.m4249a(str, z);
    }

    private String m4165c(String str) {
        HashMap b = this.f3217b.m4251b(str);
        return (b != null && b.size() > 0 && b.containsKey(MsgConstant.KEY_STATUS) && C4021R.parseInt(String.valueOf(b.get(MsgConstant.KEY_STATUS))) == Constants.COMMAND_HANDSHAKE && b.containsKey("url")) ? (String) b.get("url") : null;
    }

    private String m4166d(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = byteArrayInputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(toByteArray, 2);
            }
        }
    }

    public String m4167a(Bitmap bitmap) {
        String str = null;
        if (this.f3219d.m4155g()) {
            try {
                str = m4159a(bitmap, C0957b.BEFORE_SHARE);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return str;
    }

    public String m4168a(String str) {
        String str2 = null;
        if (this.f3219d.m4155g()) {
            try {
                str2 = m4160a(str, C0957b.BEFORE_SHARE);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return str2;
    }

    public String m4169a(String str, int i, boolean z, String str2) {
        try {
            if (!this.f3219d.m4155g() || !this.f3219d.m4149d()) {
                return str;
            }
            CharSequence networkType = this.f3218c.getNetworkType();
            if (PushBuildConfig.sdk_conf_debug_level.equals(networkType) || TextUtils.isEmpty(networkType)) {
                return str;
            }
            String a;
            if (z) {
                a = m4161a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i, str2);
                if (!(a == null || a.equals(str))) {
                    return a;
                }
            }
            a = m4161a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i, str2);
            return (a == null || a.equals(str)) ? str : a;
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return str;
        }
    }

    public void m4170a() {
        try {
            CharSequence networkType = this.f3218c.getNetworkType();
            if (!PushBuildConfig.sdk_conf_debug_level.equals(networkType) && !TextUtils.isEmpty(networkType)) {
                long longValue = this.f3219d.m4156h().longValue();
                long currentTimeMillis = System.currentTimeMillis();
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(longValue);
                int i = instance.get(5);
                instance.setTimeInMillis(currentTimeMillis);
                int i2 = instance.get(5);
                if (currentTimeMillis - longValue >= C4156a.f13948j || i != i2) {
                    HashMap a = this.f3217b.m4243a();
                    this.f3219d.m4142a(a.containsKey(Constants.SEND_TYPE_RES) ? "true".equals(String.valueOf(a.get(Constants.SEND_TYPE_RES))) : true);
                    if (a != null && a.size() > 0) {
                        this.f3219d.m4143b(System.currentTimeMillis());
                    }
                }
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
    }

    public void m4171a(C0949c c0949c) {
        try {
            if (this.f3219d.m4155g()) {
                if (c0949c instanceof C0951b) {
                    m4162a((C0951b) c0949c);
                } else if (c0949c instanceof C0955f) {
                    m4163a((C0955f) c0949c);
                }
                if (!this.f3219d.m4145b()) {
                    c0949c.f3229m = null;
                }
                long a = this.f3219d.m4135a();
                if (a == 0) {
                    a = this.f3217b.m4250b();
                }
                c0949c.f3221e = System.currentTimeMillis() - a;
                this.f3217b.m4245a(c0949c);
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
    }

    public void m4172a(HashMap<String, Object> hashMap) {
        try {
            this.f3217b.m4252b((HashMap) hashMap);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
    }

    public void m4173a(boolean z) {
        this.f3220e = z;
    }

    public HashMap<String, Object> m4174b(String str) {
        try {
            return this.f3217b.m4254c(str);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return new HashMap();
        }
    }

    public void m4175b() {
        try {
            CharSequence networkType = this.f3218c.getNetworkType();
            if (!PushBuildConfig.sdk_conf_debug_level.equals(networkType) && !TextUtils.isEmpty(networkType) && this.f3219d.m4155g()) {
                this.f3219d.m4136a(System.currentTimeMillis());
                HashMap c = this.f3217b.m4253c();
                if (c.containsKey(MsgConstant.KEY_STATUS) && C4021R.parseInt(String.valueOf(c.get(MsgConstant.KEY_STATUS))) == ErrorConstant.ERROR_NO_NETWORK) {
                    C0979d.m4390a().m4375d((String) c.get(C4233j.f14375B), new Object[0]);
                    return;
                }
                HashMap hashMap;
                if (c.containsKey("timestamp")) {
                    this.f3219d.m4139a("service_time", Long.valueOf(System.currentTimeMillis() - C4021R.parseLong(String.valueOf(c.get("timestamp")))));
                }
                if (c.containsKey("switchs")) {
                    hashMap = (HashMap) c.get("switchs");
                    if (hashMap != null) {
                        String valueOf = String.valueOf(hashMap.get("device"));
                        String valueOf2 = String.valueOf(hashMap.get("share"));
                        String valueOf3 = String.valueOf(hashMap.get(BaseMonitor.ALARM_POINT_AUTH));
                        String valueOf4 = String.valueOf(hashMap.get("backflow"));
                        this.f3219d.m4144b(valueOf);
                        this.f3219d.m4148d(valueOf2);
                        this.f3219d.m4146c(valueOf3);
                        this.f3219d.m4137a(valueOf4);
                    }
                }
                if (c.containsKey("serpaths")) {
                    hashMap = (HashMap) c.get("serpaths");
                    if (hashMap != null) {
                        Object valueOf5 = String.valueOf(hashMap.get("defhost"));
                        Object valueOf6 = String.valueOf(hashMap.get("defport"));
                        if (!(TextUtils.isEmpty(valueOf5) || TextUtils.isEmpty(valueOf6))) {
                            this.f3217b.m4246a("http://" + valueOf5 + ":" + valueOf6);
                        }
                        HashMap hashMap2 = new HashMap();
                        if (hashMap.containsKey("assigns")) {
                            hashMap = (HashMap) hashMap.get("assigns");
                            if (hashMap == null || hashMap.size() == 0) {
                                this.f3217b.m4248a(null);
                                return;
                            }
                            for (String str : hashMap.keySet()) {
                                HashMap hashMap3 = (HashMap) hashMap.get(str);
                                Object valueOf7 = String.valueOf(hashMap3.get(C4103b.ELECTION_KEY_HOST));
                                valueOf6 = String.valueOf(hashMap3.get("port"));
                                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(valueOf7) || TextUtils.isEmpty(valueOf6))) {
                                    hashMap2.put(str, "http://" + valueOf7 + ":" + valueOf6);
                                }
                            }
                            this.f3217b.m4248a(hashMap2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
    }

    public void m4176c() {
        try {
            CharSequence networkType = this.f3218c.getNetworkType();
            if (!PushBuildConfig.sdk_conf_debug_level.equals(networkType) && !TextUtils.isEmpty(networkType) && this.f3219d.m4155g()) {
                ArrayList e = this.f3217b.m4256e();
                for (int i = 0; i < e.size(); i++) {
                    C0945c c0945c = (C0945c) e.get(i);
                    if (c0945c.f3209b.size() == 1 ? m4164a(c0945c.f3208a, false) : m4164a(m4166d(c0945c.f3208a), true)) {
                        this.f3217b.m4247a(c0945c.f3209b);
                    }
                }
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
    }

    public HashMap<String, Object> m4177d() {
        try {
            return this.f3217b.m4257f();
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return new HashMap();
        }
    }

    public HashMap<String, Object> m4178e() {
        if (!this.f3219d.m4155g()) {
            return new HashMap();
        }
        try {
            return this.f3217b.m4255d();
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
            return new HashMap();
        }
    }
}
