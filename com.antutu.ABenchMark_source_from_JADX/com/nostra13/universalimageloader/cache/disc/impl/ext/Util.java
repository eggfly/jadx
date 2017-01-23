package com.nostra13.universalimageloader.cache.disc.impl.ext;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.umeng.message.proguard.C4218e;
import com.umeng.message.util.HttpRequest;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

final class Util {
    static final Charset US_ASCII;
    static final Charset UTF_8;

    static {
        US_ASCII = Charset.forName(C4218e.f14337b);
        UTF_8 = Charset.forName(HttpRequest.f14548a);
    }

    private Util() {
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    static void deleteContents(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    static String readFully(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            return stringWriter2;
        } finally {
            reader.close();
        }
    }
}
