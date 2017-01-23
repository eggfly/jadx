package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static final Set<String> DW;
    private static final boolean FH;
    private static final String j6;

    private static final class a {
        private static void DW(ClassLoader classLoader, List<File> list, File file) {
            Object obj = a.DW(classLoader, "pathList").get(classLoader);
            a.DW(obj, "dexElements", j6(obj, new ArrayList(list), file));
        }

        private static Object[] j6(Object obj, ArrayList<File> arrayList, File file) {
            return (Object[]) a.DW(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }
    }

    private static final class b {
        private static void DW(ClassLoader classLoader, List<File> list, File file) {
            Object obj = a.DW(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.DW(obj, "dexElements", j6(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field j6 = a.DW(classLoader, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr = (IOException[]) j6.get(classLoader);
                if (iOExceptionArr == null) {
                    obj = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    Object obj2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                    arrayList.toArray(obj2);
                    System.arraycopy(iOExceptionArr, 0, obj2, arrayList.size(), iOExceptionArr.length);
                    obj = obj2;
                }
                j6.set(classLoader, obj);
            }
        }

        private static Object[] j6(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) a.DW(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class c {
        private static void DW(ClassLoader classLoader, List<File> list) {
            int size = list.size();
            Field j6 = a.DW(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) j6.get(classLoader));
            Object[] objArr = new String[size];
            Object[] objArr2 = new File[size];
            Object[] objArr3 = new ZipFile[size];
            Object[] objArr4 = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                objArr[previousIndex] = absolutePath;
                objArr2[previousIndex] = file;
                objArr3[previousIndex] = new ZipFile(file);
                objArr4[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            j6.set(classLoader, stringBuilder.toString());
            a.DW((Object) classLoader, "mPaths", objArr);
            a.DW((Object) classLoader, "mFiles", objArr2);
            a.DW((Object) classLoader, "mZips", objArr3);
            a.DW((Object) classLoader, "mDexs", objArr4);
        }
    }

    static {
        j6 = "code_cache" + File.separator + "secondary-dexes";
        DW = new HashSet();
        FH = j6(System.getProperty("java.vm.version"));
    }

    public static void j6(Context context) {
        Log.i("MultiDex", "install");
        if (FH) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
        } else if (VERSION.SDK_INT < 4) {
            throw new RuntimeException("Multi dex installation failed. SDK " + VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
        } else {
            try {
                ApplicationInfo DW = DW(context);
                if (DW != null) {
                    synchronized (DW) {
                        String str = DW.sourceDir;
                        if (DW.contains(str)) {
                            return;
                        }
                        DW.add(str);
                        if (VERSION.SDK_INT > 20) {
                            Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + VERSION.SDK_INT + ": SDK version higher than " + 20 + " should be backed by " + "runtime with built-in multidex capabilty but it's not the " + "case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                        }
                        try {
                            ClassLoader classLoader = context.getClassLoader();
                            if (classLoader == null) {
                                Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                                return;
                            }
                            try {
                                FH(context);
                            } catch (Throwable th) {
                                Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
                            }
                            File file = new File(DW.dataDir, j6);
                            List j6 = b.j6(context, DW, file, false);
                            if (j6(j6)) {
                                j6(classLoader, file, j6);
                            } else {
                                Log.w("MultiDex", "Files were not valid zip files.  Forcing a reload.");
                                List j62 = b.j6(context, DW, file, true);
                                if (j6(j62)) {
                                    j6(classLoader, file, j62);
                                } else {
                                    throw new RuntimeException("Zip files were not valid.");
                                }
                            }
                            Log.i("MultiDex", "install done");
                            return;
                        } catch (Throwable e) {
                            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e);
                        }
                    }
                }
            } catch (Throwable e2) {
                Log.e("MultiDex", "Multidex installation failure", e2);
                throw new RuntimeException("Multi dex installation failed (" + e2.getMessage() + ").");
            }
        }
    }

    private static ApplicationInfo DW(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, 128);
        } catch (Throwable e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    static boolean j6(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        Log.i("MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static void j6(ClassLoader classLoader, File file, List<File> list) {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                b.DW(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                a.DW(classLoader, list, file);
            } else {
                c.DW(classLoader, list);
            }
        }
    }

    private static boolean j6(List<File> list) {
        for (File j6 : list) {
            if (!b.j6(j6)) {
                return false;
            }
        }
        return true;
    }

    private static Field DW(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method DW(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void DW(Object obj, String str, Object[] objArr) {
        Field DW = DW(obj, str);
        Object[] objArr2 = (Object[]) DW.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        DW.set(obj, objArr3);
    }

    private static void FH(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
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
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            }
        }
    }
}
