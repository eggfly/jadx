package com.cmcm.support.p116a;

import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* renamed from: com.cmcm.support.a.i */
public class C2196i {
    public static String m8261a(File file) {
        Throwable th;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        FileInputStream fileInputStream;
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                } catch (Exception e) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return C2197j.m8263a(instance.digest());
        } catch (Exception e2) {
            fileInputStream = null;
            if (fileInputStream == null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static String m8262a(InputStream inputStream) {
        if (inputStream == null) {
            return BuildConfig.FLAVOR;
        }
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        String str = BuildConfig.FLAVOR;
        MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                instance.update(bArr, 0, read);
            } else {
                String a = C2195h.m8258a(instance.digest());
                inputStream.close();
                return a;
            }
        }
    }
}
