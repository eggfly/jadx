package com.miui.support.module;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.miui.support.internal.component.module.BuiltinRepository;
import com.miui.support.internal.component.module.CombinedRepository;
import com.miui.support.internal.component.module.ModuleFolder;
import com.miui.support.internal.component.module.ModuleLoadException;
import com.miui.support.internal.component.module.ModuleLoader;
import com.miui.support.internal.component.module.ModuleUtils;
import com.miui.support.internal.component.module.PrebuiltRepository;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.os.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ModuleManager {
    private static final ModuleManager f3382a;
    private Context f3383b;
    private File f3384c;
    private File f3385d;
    private ModuleLoader f3386e;
    private ModuleLoadListener f3387f;

    public interface ModuleLoadListener {
        void m5067a();

        void m5068a(String str, int i);

        void m5069a(String str, String str2);
    }

    public static ModuleManager m5070a() {
        return f3382a;
    }

    static {
        f3382a = new ModuleManager(PackageConstants.f2564a);
    }

    private ModuleManager(Context context) {
        this.f3383b = context;
        this.f3384c = m5071a(this.f3383b);
        this.f3384c.mkdirs();
        this.f3385d = m5077b(this.f3383b);
        this.f3385d.mkdirs();
        this.f3386e = new ModuleLoader(new ModuleFolder(this.f3384c, this.f3384c));
    }

    private File m5071a(Context context) {
        return new File(PackageConstants.m4228a(context), "modules");
    }

    private File m5072a(String str) {
        return new File(this.f3384c, str + ".apk");
    }

    private File m5077b(Context context) {
        return new File(PackageConstants.m4228a(context), "modules-temp");
    }

    public void m5080a(String... strArr) {
        m5079a(null, strArr);
    }

    public void m5079a(Repository repository, String... strArr) {
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            Repository combinedRepository;
            String str;
            Map emptyMap;
            BuiltinRepository builtinRepository = new BuiltinRepository(this.f3383b);
            PrebuiltRepository prebuiltRepository = new PrebuiltRepository(this.f3383b);
            if (repository == null) {
                combinedRepository = new CombinedRepository(builtinRepository, prebuiltRepository);
            } else {
                combinedRepository = new CombinedRepository(builtinRepository, prebuiltRepository, repository);
            }
            Set linkedHashSet = new LinkedHashSet();
            for (String str2 : strArr) {
                if (!m5072a(str2).exists()) {
                    linkedHashSet.add(str2);
                }
            }
            if (linkedHashSet.isEmpty()) {
                emptyMap = Collections.emptyMap();
            } else {
                emptyMap = combinedRepository.m3874a(this.f3385d, combinedRepository.m3875a(linkedHashSet));
            }
            int length = strArr.length;
            while (i < length) {
                str2 = strArr[i];
                Log.i("miuisdk", "loading module: " + str2);
                if (!emptyMap.containsKey(str2) || m5075a(this.f3385d, this.f3384c, (String) emptyMap.get(str2), str2)) {
                    File a = m5072a(str2);
                    if (a.exists()) {
                        try {
                            if (!m5076a(this.f3384c, str2)) {
                                m5073a(str2, 2);
                            }
                        } catch (IOException e) {
                            m5073a(str2, 2);
                        }
                    }
                    new Dependency().m5058a(str2);
                    try {
                        this.f3386e.m3899a(new Dependency());
                        m5074a(str2, a.getAbsolutePath());
                    } catch (ModuleLoadException e2) {
                        if (!linkedHashSet.contains(str2) || emptyMap.containsKey(str2)) {
                            m5073a(str2, 3);
                        } else {
                            m5073a(str2, 1);
                        }
                    } catch (Exception e3) {
                        m5073a(str2, 3);
                    }
                } else {
                    m5073a(str2, 2);
                }
                i++;
            }
            m5078b();
        }
    }

    private boolean m5075a(File file, File file2, String str, String str2) {
        String str3 = str2 + ".apk";
        File file3 = new File(file, str);
        File file4 = new File(file2, str3);
        if (!file3.exists()) {
            return false;
        }
        file4.delete();
        return file3.renameTo(file4);
    }

    private boolean m5076a(File file, String str) {
        File a = m5072a(str);
        File a2 = ModuleUtils.m3907a(a.getAbsolutePath());
        if (!a2.exists()) {
            a2.mkdirs();
            ZipFile zipFile = new ZipFile(a);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (!zipEntry.isDirectory()) {
                    String name = zipEntry.getName();
                    if (!name.contains("..") && (name.startsWith("lib/" + Build.CPU_ABI) || name.startsWith("lib/" + Build.CPU_ABI2))) {
                        File file2 = new File(a2, FileUtils.m5183b(name));
                        if (!file2.exists()) {
                            FileUtils.m5181a(zipFile.getInputStream(zipEntry), file2);
                        }
                    }
                }
            }
        }
        return true;
    }

    private void m5074a(String str, String str2) {
        Log.d("miuisdk", "process " + str + " successful");
        if (this.f3387f != null) {
            this.f3387f.m5069a(str, str2);
        }
    }

    private void m5073a(String str, int i) {
        Log.w("miuisdk", "process " + str + " failed: " + i);
        if (this.f3387f != null) {
            this.f3387f.m5068a(str, i);
        }
    }

    private void m5078b() {
        Log.d("miuisdk", "process modules finished");
        if (this.f3387f != null) {
            this.f3387f.m5067a();
        }
    }
}
