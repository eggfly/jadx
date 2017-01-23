package com.aide.uidesigner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import com.aide.common.w;
import com.aide.uidesigner.h.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class j {
    private Context DW;
    private Map<Integer, SortedMap<String, Map<String, String>>> FH;
    private Map<Integer, Map<String, String>> Hw;
    private File j6;
    private Map<Integer, Map<String, String>> v5;

    public j(Context context, String str) {
        this.DW = context;
        this.j6 = str == null ? null : new File(str);
    }

    public void j6() {
        int i;
        this.v5 = new HashMap();
        this.FH = new HashMap();
        this.Hw = new HashMap();
        for (i = 0; i < 30; i++) {
            this.FH.put(Integer.valueOf(i), new TreeMap());
            this.Hw.put(Integer.valueOf(i), new HashMap());
            this.v5.put(Integer.valueOf(i), new HashMap());
        }
        if (this.j6 != null) {
            j6(0, new File(this.j6, "values"));
            for (i = 1; i < 30; i++) {
                j6(i, new File(this.j6, "values-v" + i));
            }
        }
    }

    private void j6(int i, File file) {
        try {
            for (File file2 : file.listFiles()) {
                if (file2.getName().toLowerCase().endsWith(".xml")) {
                    InputStream fileInputStream = new FileInputStream(file2);
                    Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream);
                    fileInputStream.close();
                    j6(parse, i);
                    j6(parse, i, "string");
                    j6(parse, i, "color");
                    j6(parse, i, "dimen");
                    j6(parse, i, "bool");
                    j6(parse, i, "integer");
                }
            }
        } catch (Throwable th) {
        }
    }

    private void j6(Document document, int i, String str) {
        NodeList elementsByTagName = document.getElementsByTagName(str);
        for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
            Node item = elementsByTagName.item(i2);
            Node namedItem = item.getAttributes().getNamedItem("name");
            if (namedItem instanceof Attr) {
                String value = ((Attr) namedItem).getValue();
                ((Map) this.v5.get(Integer.valueOf(i))).put("@" + str + "/" + value, item.getTextContent());
            }
        }
    }

    private void j6(Document document, int i) {
        NodeList elementsByTagName = document.getElementsByTagName("style");
        for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
            Node item = elementsByTagName.item(i2);
            Node namedItem = item.getAttributes().getNamedItem("name");
            if (namedItem instanceof Attr) {
                String value = ((Attr) namedItem).getValue();
                Object obj = "";
                if (value.contains(".")) {
                    obj = value.substring(0, value.lastIndexOf(46));
                } else {
                    namedItem = item.getAttributes().getNamedItem("parent");
                    if (namedItem instanceof Attr) {
                        String value2 = ((Attr) namedItem).getValue();
                    }
                }
                ((Map) this.Hw.get(Integer.valueOf(i))).put(value, obj);
                Map hashMap = new HashMap();
                ((SortedMap) this.FH.get(Integer.valueOf(i))).put(value, hashMap);
                NodeList childNodes = item.getChildNodes();
                for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                    Node item2 = childNodes.item(i3);
                    if (item2.getNodeName().equals("item")) {
                        namedItem = item2.getAttributes().getNamedItem("name");
                        if (namedItem instanceof Attr) {
                            hashMap.put(((Attr) namedItem).getValue(), item2.getTextContent());
                        }
                    }
                }
            }
        }
    }

    public String j6(String str) {
        return Hw(v5(str));
    }

    private String Hw(String str) {
        if (str != null && str.startsWith("@")) {
            for (int i = VERSION.SDK_INT; i >= 0; i--) {
                String str2 = (String) ((Map) this.v5.get(Integer.valueOf(i))).get(str);
                if (str2 != null) {
                    return str2;
                }
            }
        }
        return str;
    }

    private String v5(String str) {
        Object substring;
        if (str != null && str.startsWith("?attr/")) {
            substring = str.substring("?attr/".length());
        } else if (str == null || !str.startsWith("?")) {
            substring = null;
        } else {
            String substring2 = str.substring(1);
        }
        if (substring != null) {
            for (int i = VERSION.SDK_INT; i >= 0; i--) {
                for (Map map : ((Map) this.FH.get(Integer.valueOf(i))).values()) {
                    if (map.containsKey(substring)) {
                        return (String) map.get(substring);
                    }
                }
            }
        }
        return str;
    }

    public String j6(String str, a aVar) {
        if (str.startsWith("@style/")) {
            return j6(str.substring("@style/".length()), aVar, new HashSet());
        }
        return null;
    }

    private String j6(String str, a aVar, Set<String> set) {
        if (set.contains(str)) {
            return null;
        }
        set.add(str);
        for (int i = VERSION.SDK_INT; i >= 0; i--) {
            Map map = (Map) ((SortedMap) this.FH.get(Integer.valueOf(i))).get(str);
            if (map != null) {
                String str2 = (String) map.get(aVar.Hw);
                if (str2 == null) {
                    return j6((String) ((Map) this.Hw.get(Integer.valueOf(i))).get(str), aVar, (Set) set);
                }
                return str2;
            }
        }
        return null;
    }

    public Drawable DW(String str) {
        if (!(this.j6 == null || str == null || !str.startsWith("@drawable/"))) {
            String substring = str.substring("@drawable/".length());
            Drawable DW = DW(new File(new File(this.j6, "drawable-" + v5()), substring + ".png"));
            if (DW != null) {
                return DW;
            }
            DW = DW(new File(new File(this.j6, "drawable-" + v5()), substring + ".jpg"));
            if (DW != null) {
                return DW;
            }
            DW = j6(new File(new File(this.j6, "drawable-" + v5()), substring + ".9.png"));
            if (DW != null) {
                return DW;
            }
            DW = DW(new File(new File(this.j6, "drawable"), substring + ".png"));
            if (DW != null) {
                return DW;
            }
            DW = DW(new File(new File(this.j6, "drawable"), substring + ".jpg"));
            if (DW != null) {
                return DW;
            }
            DW = j6(new File(new File(this.j6, "drawable"), substring + ".9.png"));
            if (DW != null) {
                return DW;
            }
            for (String str2 : new String[]{"xxhpdi", "xhdpi", "hdpi", "mdpi", "ldpi"}) {
                DW = DW(new File(new File(this.j6, "drawable-" + str2), substring + ".png"));
                if (DW != null) {
                    return DW;
                }
            }
            for (String str22 : new String[]{"xxhpdi", "xhdpi", "hdpi", "mdpi", "ldpi"}) {
                DW = DW(new File(new File(this.j6, "drawable-" + str22), substring + ".jpg"));
                if (DW != null) {
                    return DW;
                }
            }
            for (String str222 : new String[]{"xxhpdi", "xhdpi", "hdpi", "mdpi", "ldpi"}) {
                DW = j6(new File(new File(this.j6, "drawable-" + str222), substring + ".9.png"));
                if (DW != null) {
                    return DW;
                }
            }
        }
        return null;
    }

    private String v5() {
        switch (this.DW.getResources().getDisplayMetrics().densityDpi) {
            case 120:
                return "ldpi";
            case 160:
                return "mdpi";
            case 240:
                return "hdpi";
            case 320:
                return "xhdpi";
            default:
                return "";
        }
    }

    private Drawable j6(File file) {
        Drawable drawable = null;
        if (file != null) {
            try {
                if (file.isFile()) {
                    drawable = NinePatchDrawable.createFromStream(new FileInputStream(file), null);
                }
            } catch (Exception e) {
            }
        }
        return drawable;
    }

    private Drawable DW(File file) {
        if (file == null) {
            return null;
        }
        try {
            if (!file.isFile()) {
                return null;
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            InputStream fileInputStream = new FileInputStream(file);
            BitmapFactory.decodeStream(fileInputStream, null, options);
            fileInputStream.close();
            int i = options.outWidth;
            int i2 = options.outHeight;
            float f = ((float) i) / ((float) i2);
            int i3 = i;
            i = i2;
            i2 = 1;
            while (true) {
                if (i3 / 2 < 500 && i / 2 < 500) {
                    break;
                }
                i /= 2;
                i2 *= 2;
                i3 /= 2;
            }
            if (i > 500) {
                i3 = (int) (((float) 500) * f);
            }
            if (i3 > 500) {
                i3 = (int) (((float) 500) / f);
            }
            Options options2 = new Options();
            options2.inSampleSize = i2;
            InputStream fileInputStream2 = new FileInputStream(file);
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options2);
            fileInputStream2.close();
            if (decodeStream != null) {
                return new BitmapDrawable(this.DW.getResources(), decodeStream);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> DW() {
        Collection hashSet = new HashSet();
        for (Map keySet : this.FH.values()) {
            for (String str : keySet.keySet()) {
                hashSet.add("@style/" + str);
            }
        }
        return new ArrayList(hashSet);
    }

    public List<String> FH() {
        Collection hashSet = new HashSet();
        if (this.j6 != null) {
            for (File file : this.j6.listFiles()) {
                if (file.isDirectory() && file.getName().startsWith("drawable")) {
                    for (File name : file.listFiles()) {
                        String name2 = name.getName();
                        if (name2.toLowerCase().endsWith(".png") || name2.toLowerCase().endsWith(".jpg") || name2.toLowerCase().endsWith(".xml")) {
                            hashSet.add("@drawable/" + name2.substring(0, name2.length() - 4));
                        }
                    }
                }
            }
        }
        return new ArrayList(hashSet);
    }

    public String FH(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("@style/")) {
            return j6(str.substring("@style/".length()), new HashSet());
        }
        return str;
    }

    private String j6(String str, Set<String> set) {
        if (set.contains(str)) {
            return null;
        }
        set.add(str);
        for (int i = VERSION.SDK_INT; i >= 0; i--) {
            String str2 = (String) ((Map) this.Hw.get(Integer.valueOf(i))).get(str);
            if (str2 != null && str2.length() > 0) {
                return j6(str2, (Set) set);
            }
        }
        if (str.startsWith("android:")) {
            return "@android:style/" + str.substring("android:".length());
        }
        return "@style/" + str;
    }

    public String Hw() {
        for (int i = 1; i < 1000; i++) {
            if (DW("@drawable/image_" + i) == null) {
                return "image_" + i;
            }
        }
        return "image";
    }

    public void j6(String str, Intent intent) {
        try {
            File file = new File(this.j6, "drawable");
            file.mkdirs();
            w.j6(this.DW.getContentResolver().openInputStream(intent.getData()), new FileOutputStream(new File(file, str + ".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
