import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class of {
    public static List<String> j6(String str, Map<String, List<String>> map) {
        Set hashSet = new HashSet();
        List<String> arrayList = new ArrayList();
        j6(str, map, hashSet, arrayList);
        return arrayList;
    }

    private static void j6(String str, Map<String, List<String>> map, Set<String> set, List<String> list) {
        if (!set.contains(str)) {
            set.add(str);
            if (!list.contains(str)) {
                list.add(str);
            }
            for (String j6 : (List) map.get(str)) {
                j6(j6, map, set, list);
            }
        }
    }

    private static void j6(String str, Map<String, List<String>> map, Map<String, List<String>> map2) {
        if (!map2.containsKey(str)) {
            List<String> list = (List) map.get(str);
            map2.put(str, list);
            for (String j6 : list) {
                j6(j6, map, map2);
            }
        }
    }

    public static Map<String, List<String>> DW(String str, Map<String, List<String>> map) {
        Map<String, List<String>> hashMap = new HashMap();
        j6(str, map, hashMap);
        return hashMap;
    }
}
