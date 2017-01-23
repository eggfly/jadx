package com.miui.support.internal.component.module;

import com.miui.support.core.ManifestParser;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.internal.util.PackageHelper;
import com.miui.support.module.Dependency;
import com.miui.support.module.Module;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ModuleLoader {
    private ModuleFolder[] f2307a;
    private Set<String> f2308b;
    private Set<String> f2309c;

    private static class ModuleEntry {
        public Module f2302a;
        public String f2303b;
        public String f2304c;
        public String f2305d;
        public boolean f2306e;

        public ModuleEntry(Module module, String str, String str2, String str3, boolean z) {
            this.f2302a = module;
            this.f2303b = str;
            this.f2304c = str2;
            this.f2305d = str3;
            this.f2306e = z;
        }
    }

    public ModuleLoader(ModuleFolder... moduleFolderArr) {
        this.f2308b = new LinkedHashSet();
        this.f2309c = new LinkedHashSet();
        this.f2307a = moduleFolderArr;
    }

    public void m3899a(Dependency... dependencyArr) {
        List<ModuleEntry> arrayList = new ArrayList();
        List<ModuleEntry> arrayList2 = new ArrayList();
        for (Dependency dependency : dependencyArr) {
            if (!this.f2308b.contains(dependency.m5055a())) {
                String absolutePath;
                boolean z = (dependency.m5059b() & 1) != 0;
                Object obj = null;
                for (ModuleFolder moduleFolder : this.f2307a) {
                    File file = new File(moduleFolder.m3892a(), dependency.m5055a() + ".apk");
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                        arrayList.add(new ModuleEntry(m3894a(absolutePath), absolutePath, ModuleUtils.m3907a(absolutePath).getAbsolutePath(), moduleFolder.m3893b().getAbsolutePath(), z));
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    File file2 = new File(PackageHelper.m4231a(PackageConstants.f2564a, dependency.m5055a(), null));
                    if (file2.exists()) {
                        absolutePath = file2.getAbsolutePath();
                        arrayList2.add(new ModuleEntry(m3894a(absolutePath), absolutePath, ModuleUtils.m3907a(absolutePath).getAbsolutePath(), null, z));
                    } else if (!z) {
                        throw new ModuleLoadException("no such module found: " + dependency.m5055a());
                    }
                } else {
                    continue;
                }
            }
        }
        for (ModuleEntry moduleEntry : arrayList) {
            if (ModuleUtils.m3908b(moduleEntry.f2303b)) {
                m3895a(moduleEntry, moduleEntry.f2305d);
            } else if (!moduleEntry.f2306e) {
                throw new ModuleLoadException("invalid signature: " + moduleEntry.f2302a.m5061a());
            }
        }
        for (ModuleEntry moduleEntry2 : arrayList2) {
            m3895a(moduleEntry2, null);
        }
    }

    private void m3895a(ModuleEntry moduleEntry, String str) {
        String str2;
        String str3;
        Object obj;
        String str4 = null;
        if ((moduleEntry.f2302a.m5066c() & 1) != 0) {
            str2 = moduleEntry.f2303b;
        } else {
            str2 = null;
        }
        if ((moduleEntry.f2302a.m5066c() & 2) != 0) {
            str3 = moduleEntry.f2304c;
        } else {
            str3 = null;
        }
        if ((moduleEntry.f2302a.m5066c() & 4) != 0) {
            str4 = moduleEntry.f2303b;
        }
        if (str2 == null && str3 == null) {
            obj = null;
        } else {
            if (m3897a(str, str2, str3)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (!(obj == null || moduleEntry.f2306e)) {
                throw new ModuleLoadException("encounter error when load dex for module: " + moduleEntry.f2302a.m5061a());
            }
        }
        if (str4 != null && obj == null) {
            m3898b(str4);
            if (obj == null || moduleEntry.f2306e) {
                this.f2309c.add(moduleEntry.f2303b);
            } else {
                throw new ModuleLoadException("encounter error when load res for module: " + moduleEntry.f2302a.m5061a());
            }
        }
        if (obj == null) {
            this.f2308b.add(moduleEntry.f2302a.m5061a());
        }
    }

    private Module m3894a(String str) {
        return ManifestParser.m3341a(PackageConstants.f2564a.getPackageManager(), str).m3355a(null).m3333a();
    }

    private boolean m3897a(String str, String str2, String str3) {
        return ModuleClassLoader.m3889a(str2, str, str3, PackageConstants.f2564a.getClassLoader(), PackageConstants.f2564a);
    }

    private void m3898b(String str) {
        ModuleResourceLoader.m3903a(Arrays.asList(new String[]{str}), new ArrayList(this.f2309c));
    }

    public static void m3896a(String... strArr) {
        ModuleResourceLoader.m3902a(Arrays.asList(strArr));
    }
}
