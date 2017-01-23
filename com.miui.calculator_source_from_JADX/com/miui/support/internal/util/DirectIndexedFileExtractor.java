package com.miui.support.internal.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.miui.support.os.FileUtils;
import com.miui.support.util.DirectIndexedFile;
import com.miui.support.util.DirectIndexedFile.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DirectIndexedFileExtractor {
    public static String f2563a;

    /* renamed from: com.miui.support.internal.util.DirectIndexedFileExtractor.1 */
    final class C02901 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ String[] f2561a;
        final /* synthetic */ Context f2562b;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4221a((Void[]) objArr);
        }

        protected Void m4221a(Void... voidArr) {
            for (String str : this.f2561a) {
                if (str.endsWith(".idf")) {
                    DirectIndexedFileExtractor.m4226c(this.f2562b, str);
                }
            }
            return null;
        }
    }

    private static void m4223a(Context context) {
        if (f2563a == null) {
            try {
                Context createPackageContext = context.createPackageContext("com.miui.core", 2);
                if (createPackageContext.getFilesDir() != null) {
                    f2563a = createPackageContext.getFilesDir().getAbsolutePath() + File.separator + "idf";
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (f2563a != null) {
            File file = new File(f2563a);
            if (!file.exists() && file.mkdirs()) {
                FileUtils.m5182a(f2563a, 505);
                return;
            }
            return;
        }
        Log.w("DirectIndexedFileExtractor", "Error: Cannot locate IDF_FILES_PATH");
    }

    private static void m4226c(Context context, String str) {
        String a = m4222a(context, str);
        if (a != null && !TextUtils.isEmpty(str)) {
            AssetManager assets = context.getResources().getAssets();
            File file = new File(a);
            if (!file.exists() || m4224a(context, str, a)) {
                File file2 = new File(a + "-tmp");
                InputStream inputStream = null;
                try {
                    inputStream = assets.open(str);
                    boolean a2 = FileUtils.m5181a(inputStream, file2);
                    file.delete();
                    if (a2 && file2.renameTo(file)) {
                        FileUtils.m5182a(a, 436);
                        Log.v("DirectIndexedFileExtractor", file.getAbsolutePath() + " extraction completed.");
                    } else {
                        Log.w("DirectIndexedFileExtractor", file2.getAbsolutePath() + " copy failed.");
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (IOException e32) {
                    e32.printStackTrace();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e322) {
                            e322.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static boolean m4224a(Context context, String str, String str2) {
        boolean z = true;
        try {
            Reader a = DirectIndexedFile.m5368a(context.getAssets().open(str, 1));
            try {
                Reader a2 = DirectIndexedFile.m5369a(str2);
                if (a.m5366a() <= a2.m5366a()) {
                    z = false;
                }
                a.m5367b();
                a2.m5367b();
                return z;
            } catch (IOException e) {
                e.printStackTrace();
                a.m5367b();
                return true;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String m4222a(Context context, String str) {
        m4223a(context);
        if (f2563a == null) {
            return null;
        }
        return f2563a + File.separator + str;
    }
}
