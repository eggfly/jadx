package com.cmcm.support.p116a;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* renamed from: com.cmcm.support.a.c */
public class C2190c {
    public static byte[] m8234a(File file) {
        int i = IXAdIOUtils.BUFFER_SIZE;
        FileInputStream fileInputStream = new FileInputStream(file);
        int available = fileInputStream.available();
        if (available <= IXAdIOUtils.BUFFER_SIZE) {
            i = available;
        }
        if (i <= 0) {
            fileInputStream.close();
            return null;
        }
        byte[] bArr = new byte[i];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (fileInputStream.read(bArr) != -1) {
            byteArrayOutputStream.write(bArr);
        }
        fileInputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public boolean m8235a(String str, String str2, byte[] bArr) {
        boolean z = false;
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str + File.separator + str2));
        FileLock tryLock = fileOutputStream.getChannel().tryLock();
        if (tryLock != null) {
            fileOutputStream.write(bArr);
            tryLock.release();
            z = true;
        }
        fileOutputStream.close();
        return z;
    }
}
