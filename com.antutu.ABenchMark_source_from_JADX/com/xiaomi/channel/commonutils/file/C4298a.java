package com.xiaomi.channel.commonutils.file;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: com.xiaomi.channel.commonutils.file.a */
public class C4298a {
    public static final String[] f14716a;

    static {
        f14716a = new String[]{"jpg", "png", "bmp", "gif", "webp"};
    }

    public static void m17630a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m17631a(File file, File file2) {
        IOException iOException;
        Throwable th;
        OutputStream outputStream = null;
        OutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
            try {
                C4298a.m17636a(zipOutputStream, file2, null, null);
                C4298a.m17633a(zipOutputStream);
            } catch (FileNotFoundException e) {
                C4298a.m17633a(zipOutputStream);
            } catch (IOException e2) {
                IOException iOException2 = e2;
                outputStream = zipOutputStream;
                iOException = iOException2;
                try {
                    C4302b.m17649a("zip file failure + " + iOException.getMessage());
                    C4298a.m17633a(outputStream);
                } catch (Throwable th2) {
                    th = th2;
                    C4298a.m17633a(outputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                outputStream = zipOutputStream;
                th = th4;
                C4298a.m17633a(outputStream);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            zipOutputStream = null;
            C4298a.m17633a(zipOutputStream);
        } catch (IOException e4) {
            iOException = e4;
            C4302b.m17649a("zip file failure + " + iOException.getMessage());
            C4298a.m17633a(outputStream);
        }
    }

    public static void m17632a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m17633a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
            }
            try {
                outputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public static void m17634a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m17635a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m17636a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        IOException iOException;
        Throwable th;
        InputStream inputStream = null;
        int i = 0;
        if (str == null) {
            Object obj = BuildConfig.FLAVOR;
        }
        try {
            InputStream inputStream2;
            if (file.isDirectory()) {
                File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                zipOutputStream.putNextEntry(new ZipEntry(obj + File.separator));
                String str2 = TextUtils.isEmpty(obj) ? BuildConfig.FLAVOR : obj + File.separator;
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    C4298a.m17636a(zipOutputStream, listFiles[i2], str2 + listFiles[i2].getName(), null);
                }
                File[] listFiles2 = file.listFiles(new C4299b());
                if (listFiles2 != null) {
                    int length = listFiles2.length;
                    while (i < length) {
                        File file2 = listFiles2[i];
                        C4298a.m17636a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        i++;
                    }
                }
                inputStream2 = null;
            } else {
                if (TextUtils.isEmpty(obj)) {
                    zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + ".txt"));
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(obj));
                }
                inputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                    while (true) {
                        i = inputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, i);
                    }
                } catch (IOException e) {
                    IOException iOException2 = e;
                    inputStream = inputStream2;
                    iOException = iOException2;
                    try {
                        C4302b.m17654d("zipFiction failed with exception:" + iOException.toString());
                        C4298a.m17632a(inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        C4298a.m17632a(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    inputStream = inputStream2;
                    th = th4;
                    C4298a.m17632a(inputStream);
                    throw th;
                }
            }
            C4298a.m17632a(inputStream2);
        } catch (IOException e2) {
            iOException = e2;
            C4302b.m17654d("zipFiction failed with exception:" + iOException.toString());
            C4298a.m17632a(inputStream);
        }
    }

    public static byte[] m17637b(java.io.InputStream r4) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:18:? in {6, 13, 15, 16, 17, 19, 20} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r0 = new byte[r0];
    L_0x0009:
        r2 = 0;
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2 = r4.read(r0, r2, r3);	 Catch:{ Exception -> 0x0017, all -> 0x002e }
        if (r2 <= 0) goto L_0x0023;	 Catch:{ Exception -> 0x0017, all -> 0x002e }
    L_0x0012:
        r3 = 0;	 Catch:{ Exception -> 0x0017, all -> 0x002e }
        r1.write(r0, r3, r2);	 Catch:{ Exception -> 0x0017, all -> 0x002e }
        goto L_0x0009;
    L_0x0017:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0017, all -> 0x002e }
        r0 = 0;
        com.xiaomi.channel.commonutils.file.C4298a.m17632a(r4);
        com.xiaomi.channel.commonutils.file.C4298a.m17633a(r1);
    L_0x0022:
        return r0;
    L_0x0023:
        r0 = r1.toByteArray();	 Catch:{ Exception -> 0x0017, all -> 0x002e }
        com.xiaomi.channel.commonutils.file.C4298a.m17632a(r4);
        com.xiaomi.channel.commonutils.file.C4298a.m17633a(r1);
        goto L_0x0022;
    L_0x002e:
        r0 = move-exception;
        com.xiaomi.channel.commonutils.file.C4298a.m17632a(r4);
        com.xiaomi.channel.commonutils.file.C4298a.m17633a(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.file.a.b(java.io.InputStream):byte[]");
    }
}
