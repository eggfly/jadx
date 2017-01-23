package com.aide.uidesigner;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class d {

    static class 1 implements Comparator<File> {
        1() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((File) obj, (File) obj2);
        }

        public int j6(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    public static String j6(Context context, Uri uri) {
        String DW = DW(context, uri);
        if (DW == null) {
            return null;
        }
        return DW.substring(DW.lastIndexOf("/") + 1, DW.length());
    }

    public static String DW(Context context, Uri uri) {
        if ("content".equals(uri.getScheme())) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            query.moveToFirst();
            return query.getString(columnIndexOrThrow);
        } else if ("file".equals(uri.getScheme())) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    public static long j6(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        byte[] bArr = new byte[1000];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                outputStream.close();
                return j;
            }
        }
    }

    public static String j6(String str) {
        File file = new File(str, "layout");
        file.mkdirs();
        int i = 1;
        while (true) {
            StringBuilder append = new StringBuilder().append("layout");
            int i2 = i + 1;
            File file2 = new File(file, append.append(i).append(".xml").toString());
            if (!file2.exists()) {
                return file2.getName();
            }
            i = i2;
        }
    }

    public static String j6(String str, String str2, String str3) {
        try {
            File file = new File(str, "layout");
            file.mkdirs();
            if (str2 == null || str2.trim().length() == 0) {
                str2 = j6(str);
            }
            File file2 = new File(file, str2);
            if (file2.exists()) {
                file2 = new File(file, j6(str));
            }
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write(str3);
            fileWriter.close();
            return file2.getPath();
        } catch (IOException e) {
            return null;
        }
    }

    public static String DW(String str) {
        String stringBuffer;
        Throwable th;
        if (str == null) {
            return "";
        }
        BufferedReader bufferedReader;
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuffer2.append(String.valueOf(cArr, 0, read));
                }
                bufferedReader.close();
                stringBuffer = stringBuffer2.toString();
                if (bufferedReader == null) {
                    return stringBuffer;
                }
                try {
                    bufferedReader.close();
                    return stringBuffer;
                } catch (Exception e) {
                    return stringBuffer;
                }
            } catch (IOException e2) {
                try {
                    stringBuffer = "";
                    if (bufferedReader != null) {
                        return stringBuffer;
                    }
                    try {
                        bufferedReader.close();
                        return stringBuffer;
                    } catch (Exception e3) {
                        return stringBuffer;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            bufferedReader = null;
            stringBuffer = "";
            if (bufferedReader != null) {
                return stringBuffer;
            }
            bufferedReader.close();
            return stringBuffer;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static String j6(String str, String str2) {
        return j6(str, str2, "");
    }

    public static String j6() {
        return DW() + "/AppProjects/UIDesigns/res";
    }

    public static String DW() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory.exists()) {
            return externalStorageDirectory.getPath();
        }
        return "/mnt/sdcard";
    }

    public static List<File> FH(String str) {
        List<File> arrayList = new ArrayList();
        File[] listFiles = new File(str, "layout").listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().endsWith(".xml")) {
                    arrayList.add(file);
                }
            }
        }
        Collections.sort(arrayList, new 1());
        return arrayList;
    }

    public static String Hw(String str) {
        File[] listFiles = new File(str, "layout").listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().endsWith(".xml")) {
                    return file.getPath();
                }
            }
        }
        return j6(str, j6(str));
    }
}
