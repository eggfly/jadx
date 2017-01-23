package com.miui.support.module;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class Repository {
    public abstract String m3873a(File file, String str);

    public Set<String> m3875a(Set<String> set) {
        Set<String> linkedHashSet = new LinkedHashSet();
        for (String str : set) {
            if (m3876a(str)) {
                linkedHashSet.add(str);
            }
        }
        return linkedHashSet;
    }

    public boolean m3876a(String str) {
        return true;
    }

    public Map<String, String> m3874a(File file, Set<String> set) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (String str : set) {
            String a = m3873a(file, str);
            if (a != null) {
                linkedHashMap.put(str, a);
            }
        }
        return linkedHashMap;
    }
}
