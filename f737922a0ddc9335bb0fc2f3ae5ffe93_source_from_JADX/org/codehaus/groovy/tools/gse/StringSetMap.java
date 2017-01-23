package org.codehaus.groovy.tools.gse;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringSetMap extends LinkedHashMap<String, Set<String>> {
    public /* synthetic */ Object get(Object obj) {
        return j6(obj);
    }

    public Set<String> j6(Object obj) {
        String str = (String) obj;
        Set<String> set = (Set) super.get(str);
        if (set != null) {
            return set;
        }
        Set linkedHashSet = new LinkedHashSet();
        put(str, linkedHashSet);
        return linkedHashSet;
    }
}
