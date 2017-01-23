package com.aide.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class w {
    public static void j6(Reader reader, Writer writer) {
        char[] cArr = new char[4096];
        while (true) {
            try {
                int read = reader.read(cArr);
                if (read != -1) {
                    writer.write(cArr, 0, read);
                } else {
                    reader.close();
                    writer.close();
                    return;
                }
            } catch (Throwable th) {
                writer.close();
            }
        }
    }

    public static void j6(InputStream inputStream, OutputStream outputStream, boolean z) {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                if (z) {
                    outputStream.close();
                }
            }
        }
        if (z) {
            inputStream.close();
        }
        if (z) {
            outputStream.close();
        }
    }

    public static void j6(InputStream inputStream, OutputStream outputStream) {
        j6(inputStream, outputStream, true);
    }

    public static String j6(InputStream inputStream) {
        return j6(new InputStreamReader(inputStream));
    }

    public static String j6(Reader reader) {
        Reader bufferedReader = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[8192];
        while (true) {
            int read = bufferedReader.read(cArr, 0, cArr.length);
            if (read <= 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public static boolean j6(InputStream inputStream, InputStream inputStream2) {
        try {
            byte[] bArr = new byte[8192];
            byte[] bArr2 = new byte[8192];
            while (true) {
                int j6 = j6(inputStream, bArr);
                if (j6 != j6(inputStream2, bArr2)) {
                    inputStream.close();
                    inputStream2.close();
                    return false;
                } else if (j6 == -1) {
                    inputStream.close();
                    inputStream2.close();
                    return true;
                } else {
                    for (int i = 0; i < j6; i++) {
                        if (bArr[i] != bArr2[i]) {
                            break;
                        }
                    }
                }
            }
            return false;
        } finally {
            inputStream.close();
            inputStream2.close();
        }
    }

    public static int j6(InputStream inputStream, byte[] bArr) {
        return j6(inputStream, bArr, 0, bArr.length);
    }

    public static int j6(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                return i3 > 0 ? i3 : -1;
            } else {
                i3 += read;
            }
        }
        return i3;
    }
}
