package com.cmcm.support.p116a;

import android.content.Context;
import android.content.res.AssetManager;
import com.cmcm.support.C2246o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.cmcm.support.a.d */
public class C2191d {
    public static void m8236a(Context context, String str, String str2) {
        C2191d.m8238b(context, str, C2246o.m8496a(context) + "/" + str2);
    }

    public static void m8237a(String str) {
        try {
            C2191d.m8239b(str);
            new File(str.toString()).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean m8238b(Context context, String str, String str2) {
        FileOutputStream fileOutputStream = null;
        if (context == null || str2 == null || str == null) {
            return false;
        }
        try {
            InputStream open;
            AssetManager assets = context.getAssets();
            File file = new File(str2);
            if (file != null && file.exists()) {
                if (file.isFile()) {
                    String a = C2196i.m8261a(file);
                    try {
                        open = assets.open(str);
                    } catch (IOException e) {
                        open = null;
                    }
                    if (!a.equals(C2196i.m8262a(open))) {
                        if (open != null) {
                            open.close();
                        }
                        file.delete();
                    } else if (open == null) {
                        return true;
                    } else {
                        open.close();
                        return true;
                    }
                }
                C2191d.m8237a(str2);
            }
            try {
                open = assets.open(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                open = null;
            }
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e4) {
            return false;
        }
    }

    public static boolean m8239b(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        boolean z;
        String[] list = file.list();
        if (list != null) {
            int i = 0;
            z = false;
            while (i < list.length) {
                boolean z2;
                File file2 = str.endsWith(File.separator) ? new File(str + list[i]) : new File(str + File.separator + list[i]);
                if (file2.isFile()) {
                    file2.delete();
                }
                if (file2.isDirectory()) {
                    C2191d.m8239b(str + File.separatorChar + list[i]);
                    C2191d.m8237a(str + File.separatorChar + list[i]);
                    z2 = true;
                } else {
                    z2 = z;
                }
                i++;
                z = z2;
            }
        } else {
            z = false;
        }
        return z;
    }

    public static int m8240c(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return 0;
        }
        String[] list = file.list();
        return list != null ? list.length : 0;
    }
}
