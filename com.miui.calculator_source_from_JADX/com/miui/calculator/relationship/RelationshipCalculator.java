package com.miui.calculator.relationship;

import com.miui.support.internal.C0264R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RelationshipCalculator {
    private static final HashMap<String, String> f1768d;
    protected int f1769a;
    private JSONObject f1770b;
    private JSONArray f1771c;

    static {
        f1768d = new HashMap();
        f1768d.put("\u4e08\u592b", "h");
        f1768d.put("\u59bb\u5b50", "w");
        f1768d.put("\u7238\u7238", "f");
        f1768d.put("\u5988\u5988", "m");
        f1768d.put("\u54e5\u54e5", "ob");
        f1768d.put("\u5f1f\u5f1f", "lb");
        f1768d.put("\u59d0\u59d0", "os");
        f1768d.put("\u59b9\u59b9", "ls");
        f1768d.put("\u513f\u5b50", "s");
        f1768d.put("\u5973\u513f", "d");
    }

    public RelationshipCalculator(String str, String str2) {
        try {
            this.f1770b = new JSONObject(str);
            this.f1771c = new JSONObject(str2).getJSONArray("filter");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected List<String> m3143a(String str, int i, boolean z) {
        String a = m3134a(str);
        List arrayList = new ArrayList();
        if (Pattern.compile(",([hfs]|ob|lb),h").matcher(a).find() || Pattern.compile(",([wmd]|os|ls),w").matcher(a).find()) {
            if (Pattern.compile(",h,h").matcher(a).find()) {
                this.f1769a = 1;
            } else if (Pattern.compile(",w,w").matcher(a).find()) {
                this.f1769a = 2;
            } else {
                this.f1769a = 3;
            }
            return null;
        }
        Iterator it = new HashSet(m3135a(a, i)).iterator();
        while (it.hasNext()) {
            Collection collection;
            a = (String) it.next();
            if (z) {
                a = m3140b(a, i);
            }
            int indexOf = a.indexOf("|");
            if (indexOf != -1) {
                String str2;
                String substring = a.substring(0, indexOf);
                String str3 = "";
                if (a.lastIndexOf(",") != -1) {
                    str2 = a.substring(0, a.lastIndexOf(",")) + "," + a.substring(indexOf + 1);
                } else {
                    str2 = a.substring(indexOf + 1);
                }
                List b = m3141b(substring);
                b.addAll(m3141b(str2));
                collection = b;
            } else {
                collection = m3141b(a);
            }
            if (collection.size() > 0) {
                arrayList.addAll(collection);
            } else if (a.indexOf("w") == 0 || a.indexOf("h") == 0) {
                List b2 = m3141b(a.substring(2));
                if (b2.size() > 0) {
                    for (int i2 = 0; i2 < b2.size(); i2++) {
                        arrayList.add(b2.get(i2));
                    }
                }
            }
        }
        return m3138a(arrayList);
    }

    private List<String> m3138a(List<String> list) {
        List<String> arrayList = new ArrayList();
        Map hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            if (hashMap.get(list.get(i)) == null) {
                arrayList.add(list.get(i));
                hashMap.put(list.get(i), Boolean.valueOf(true));
            }
        }
        return arrayList;
    }

    private String m3134a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> arrayList = new ArrayList();
        for (Object obj : str.split("\u7684")) {
            arrayList.add(f1768d.get(obj));
        }
        for (String str2 : arrayList) {
            stringBuffer.append("," + str2);
        }
        return stringBuffer.toString();
    }

    private List<String> m3135a(String str, int i) {
        List arrayList = new ArrayList();
        if (i < 0) {
            if (str.indexOf(",w") == 0) {
                i = 1;
            } else if (str.indexOf(",h") == 0) {
                i = 0;
            }
        }
        if (i > -1) {
            str = "," + i + str;
        }
        if (str.matches(",[w0],w|,[h1],h")) {
            return null;
        }
        try {
            return m3137a(str, arrayList);
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    private List<String> m3137a(String str, List<String> list) {
        String str2 = "";
        HashMap hashMap = new HashMap();
        if (hashMap.get(str) == null) {
            String str3;
            boolean z;
            hashMap.put(str, Boolean.valueOf(true));
            boolean z2 = true;
            String str4 = str;
            while (true) {
                int i = 0;
                str3 = str4;
                while (i < this.f1771c.length()) {
                    JSONObject jSONObject = (JSONObject) this.f1771c.get(i);
                    str3 = str3.replaceAll(jSONObject.getString("exp"), jSONObject.getString("str"));
                    if (str3.indexOf("#") > -1) {
                        String[] split = str3.split("#");
                        for (String a : split) {
                            m3137a(a, (List) list);
                        }
                        z = false;
                        if (str4.equals(str3)) {
                            break;
                        }
                        z2 = z;
                        str4 = str3;
                    } else {
                        i++;
                    }
                }
                z = z2;
                if (str4.equals(str3)) {
                    break;
                }
                z2 = z;
                str4 = str3;
            }
            if (z && !str3.matches(",[w0],w|,[h1],h")) {
                Object replaceAll = str3.replaceAll(",[01]", "");
                if (!replaceAll.isEmpty()) {
                    replaceAll = replaceAll.substring(1);
                }
                list.add(replaceAll);
            }
        }
        return list;
    }

    public String m3142a(List list, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i < list.size() - 1) {
                stringBuilder.append(str);
            }
        }
        return list.isEmpty() ? "" : stringBuilder.toString();
    }

    private String m3140b(String str, int i) {
        int i2;
        Map hashMap = new HashMap();
        String[] strArr = new String[]{"f", "m", "h", "w", "s", "d", "lb", "ob", "xb", "ls", "os", "xs"};
        r5 = new String[12][];
        r5[0] = new String[]{"d", "s"};
        r5[1] = new String[]{"d", "s"};
        r5[2] = new String[]{"w", ""};
        r5[3] = new String[]{"", "h"};
        r5[4] = new String[]{"m", "f"};
        r5[5] = new String[]{"m", "f"};
        r5[6] = new String[]{"os", "ob"};
        r5[7] = new String[]{"ls", "lb"};
        r5[8] = new String[]{"xs", "xb"};
        r5[9] = new String[]{"os", "ob"};
        r5[10] = new String[]{"ls", "lb"};
        r5[11] = new String[]{"xs", "xb"};
        for (i2 = 0; i2 < strArr.length; i2++) {
            hashMap.put(strArr[i2], r5[i2]);
        }
        if (str.isEmpty()) {
            return "";
        }
        String replaceAll = str.replaceAll("&[ol]", "");
        i2 = i > -1 ? i > 0 ? 1 : 0 : i;
        String replaceAll2 = ("," + i2 + "," + replaceAll).replaceAll(",[fhs]|,[olx]b", ",1").replaceAll(",[mwd]|,[olx]s", ",0");
        replaceAll2 = replaceAll2.substring(0, replaceAll2.lastIndexOf(","));
        String[] a = m3139a(replaceAll.split(","));
        String[] a2 = m3139a(replaceAll2.split(","));
        List arrayList = new ArrayList();
        for (int i3 = 0; i3 < a.length; i3++) {
            Object obj = a[i3];
            int intValue = Integer.valueOf(a2[i3]).intValue();
            if (intValue == -1) {
                arrayList.add(((String[]) hashMap.get(obj))[1] + "|" + ((String[]) hashMap.get(obj))[0]);
            } else {
                arrayList.add(((String[]) hashMap.get(obj))[intValue]);
            }
        }
        return m3142a(arrayList, ",");
    }

    private String[] m3139a(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            int length = (strArr.length - 1) - i;
            if (i <= length) {
                String str = strArr[i];
                strArr[i] = strArr[length];
                strArr[length] = str;
            }
        }
        return strArr;
    }

    private List<String> m3141b(String str) {
        List<String> arrayList = new ArrayList();
        String str2 = "&[olx]";
        if (!this.f1770b.has(str) || this.f1770b.getJSONArray(str).length() <= 0) {
            arrayList = m3136a(str, str2);
            if (arrayList.size() == 0) {
                str = str.replaceAll("&[ol]", "");
                arrayList = m3136a(str, str2);
            }
            if (arrayList.size() == 0) {
                str = str.replaceAll("[ol]", "x");
                arrayList = m3136a(str, str2);
            }
            if (arrayList.size() != 0) {
                return arrayList;
            }
            List<String> a = m3136a(str.replaceAll("x", "l"), str2);
            List a2 = m3136a(str.replaceAll("x", "o"), str2);
            for (int i = 0; i < a2.size(); i++) {
                a.add(a2.get(i));
            }
            return a;
        }
        arrayList.add(this.f1770b.getJSONArray(str).getString(0));
        return arrayList;
    }

    private List<String> m3136a(String str, String str2) {
        List<String> arrayList = new ArrayList();
        Iterator keys = this.f1770b.keys();
        while (keys.hasNext()) {
            try {
                String str3 = (String) keys.next();
                if (str3.replace("&o", "").equals(str) || str3.replace("&l", "").equals(str) || str3.replace("&x", "").equals(str)) {
                    arrayList.add((String) this.f1770b.getJSONArray(str3).get(0));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    protected boolean m3144a(int i) {
        if (i == C0264R.id.btn_del || i == C0264R.id.btn_c || i == C0264R.id.btn_equal || i == C0264R.id.relationship_btn_cross_check) {
            return true;
        }
        return false;
    }
}
