package com.miui.support.os;

import com.miui.support.internal.os.Native;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

public class FileUtils {
    private static final Pattern f3487a;

    static {
        f3487a = Pattern.compile("[\\w%+,./=_-]+");
    }

    protected FileUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static boolean m5182a(String str, int i) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (i >= 0) {
            return Native.chmod(str, i, 1);
        }
        return true;
    }

    public static boolean m5180a(File file, File file2) {
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            boolean a = m5181a(fileInputStream, file2);
            fileInputStream.close();
            return a;
        } catch (IOException e) {
            return false;
        } catch (Throwable th) {
            fileInputStream.close();
        }
    }

    public static boolean m5181a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            if (file.exists() && !file.delete()) {
                return false;
            }
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e3) {
            }
            fileOutputStream.close();
        }
    }

    public static String m5179a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf < 0) {
            lastIndexOf = -1;
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        return lastIndexOf2 < 0 ? str.substring(lastIndexOf + 1) : str.substring(lastIndexOf + 1, lastIndexOf2);
    }

    public static String m5183b(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf > -1) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static String m5184c(String str) {
        return new String(m5185d(str), Charset.forName("UTF-8"));
    }

    private static byte[] m5185d(String str) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) randomAccessFile.length());
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = randomAccessFile.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                    }
                }
                return toByteArray;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }
}
