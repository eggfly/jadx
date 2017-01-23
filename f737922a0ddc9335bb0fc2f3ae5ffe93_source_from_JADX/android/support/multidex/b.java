package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class b {
    private static Method j6;

    static class 1 implements FileFilter {
        final /* synthetic */ String j6;

        1(String str) {
            this.j6 = str;
        }

        public boolean accept(File file) {
            return !file.getName().startsWith(this.j6);
        }
    }

    static List<File> j6(Context context, ApplicationInfo applicationInfo, File file, boolean z) {
        List<File> j6;
        Log.i("MultiDex", "MultiDexExtractor.load(" + applicationInfo.sourceDir + ", " + z + ")");
        File file2 = new File(applicationInfo.sourceDir);
        long FH = FH(file2);
        if (z || j6(context, file2, FH)) {
            Log.i("MultiDex", "Detected that extraction must be performed.");
            j6 = j6(file2, file);
            j6(context, DW(file2), FH, j6.size() + 1);
        } else {
            try {
                j6 = j6(context, file2, file);
            } catch (Throwable e) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                j6 = j6(file2, file);
                j6(context, DW(file2), FH, j6.size() + 1);
            }
        }
        Log.i("MultiDex", "load found " + j6.size() + " secondary dex files");
        return j6;
    }

    private static List<File> j6(Context context, File file, File file2) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str = file.getName() + ".classes";
        int i = j6(context).getInt("dex.number", 1);
        List<File> arrayList = new ArrayList(i);
        int i2 = 2;
        while (i2 <= i) {
            File file3 = new File(file2, str + i2 + ".zip");
            if (file3.isFile()) {
                arrayList.add(file3);
                if (j6(file3)) {
                    i2++;
                } else {
                    Log.i("MultiDex", "Invalid zip file: " + file3);
                    throw new IOException("Invalid ZIP file.");
                }
            }
            throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
        }
        return arrayList;
    }

    private static boolean j6(Context context, File file, long j) {
        SharedPreferences j6 = j6(context);
        return (j6.getLong("timestamp", -1) == DW(file) && j6.getLong("crc", -1) == j) ? false : true;
    }

    private static long DW(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    private static long FH(File file) {
        long j6 = c.j6(file);
        if (j6 == -1) {
            return j6 - 1;
        }
        return j6;
    }

    private static List<File> j6(File file, File file2) {
        String str = file.getName() + ".classes";
        j6(file2, str);
        List<File> arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i = 2;
            while (entry != null) {
                File file3 = new File(file2, str + i + ".zip");
                arrayList.add(file3);
                Log.i("MultiDex", "Extraction is needed for file " + file3);
                boolean z = false;
                int i2 = 0;
                while (i2 < 3 && !z) {
                    int i3 = i2 + 1;
                    j6(zipFile, entry, file3, str);
                    boolean j6 = j6(file3);
                    Log.i("MultiDex", "Extraction " + (j6 ? "success" : "failed") + " - length " + file3.getAbsolutePath() + ": " + file3.length());
                    if (!j6) {
                        file3.delete();
                        if (file3.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + file3.getPath() + "'");
                            z = j6;
                            i2 = i3;
                        }
                    }
                    z = j6;
                    i2 = i3;
                }
                if (z) {
                    i2 = i + 1;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                    i = i2;
                } else {
                    throw new IOException("Could not create zip file " + file3.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (Throwable e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
        }
    }

    private static void j6(Context context, long j, long j2, int i) {
        Editor edit = j6(context).edit();
        edit.putLong("timestamp", j);
        edit.putLong("crc", j2);
        edit.putInt("dex.number", i);
        j6(edit);
    }

    private static SharedPreferences j6(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static void j6(File file, String str) {
        Hw(file.getParentFile());
        Hw(file);
        File[] listFiles = file.listFiles(new 1(str));
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (file2.delete()) {
                Log.i("MultiDex", "Deleted old file " + file2.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
            }
        }
    }

    private static void Hw(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create cache directory " + file.getPath());
        }
    }

    private static void j6(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Closeable inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            Log.i("MultiDex", "Renaming to " + file.getPath());
            if (createTempFile.renameTo(file)) {
                j6(inputStream);
                createTempFile.delete();
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } catch (Throwable th) {
            j6(inputStream);
            createTempFile.delete();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean j6(java.io.File r4) {
        /*
        r0 = new java.util.zip.ZipFile;	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        r0.<init>(r4);	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        r0.close();	 Catch:{ IOException -> 0x000a, ZipException -> 0x002b }
        r0 = 1;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = move-exception;
        r0 = "MultiDex";
        r1 = new java.lang.StringBuilder;	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        r1.<init>();	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        r2 = "Failed to close zip file: ";
        r1 = r1.append(r2);	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        r2 = r4.getAbsolutePath();	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        r1 = r1.append(r2);	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        r1 = r1.toString();	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
        android.util.Log.w(r0, r1);	 Catch:{ ZipException -> 0x002b, IOException -> 0x0052 }
    L_0x0029:
        r0 = 0;
        goto L_0x0009;
    L_0x002b:
        r0 = move-exception;
        r1 = "MultiDex";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "File ";
        r2 = r2.append(r3);
        r3 = r4.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = " is not a valid zip file.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        android.util.Log.w(r1, r2, r0);
        goto L_0x0029;
    L_0x0052:
        r0 = move-exception;
        r1 = "MultiDex";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Got an IOException trying to open zip file: ";
        r2 = r2.append(r3);
        r3 = r4.getAbsolutePath();
        r2 = r2.append(r3);
        r2 = r2.toString();
        android.util.Log.w(r1, r2, r0);
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.b.j6(java.io.File):boolean");
    }

    private static void j6(Closeable closeable) {
        try {
            closeable.close();
        } catch (Throwable e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    static {
        try {
            j6 = Editor.class.getMethod("apply", new Class[0]);
        } catch (NoSuchMethodException e) {
            j6 = null;
        }
    }

    private static void j6(Editor editor) {
        if (j6 != null) {
            try {
                j6.invoke(editor, new Object[0]);
                return;
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        }
        editor.commit();
    }
}
