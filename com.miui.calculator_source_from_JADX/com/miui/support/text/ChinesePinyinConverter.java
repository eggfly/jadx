package com.miui.support.text;

import android.util.Log;
import com.miui.support.internal.util.DirectIndexedFileExtractor;
import com.miui.support.util.AppConstants;
import com.miui.support.util.DirectIndexedFile;
import com.miui.support.util.DirectIndexedFile.Reader;
import com.miui.support.util.SoftReferenceSingleton;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ChinesePinyinConverter {
    private static HashMap<String, String[]> f3567a;
    private static HashMap<Character, String> f3568b;
    private static final SoftReferenceSingleton<ChinesePinyinConverter> f3569c;
    private ChinesePinyinDictionary f3570d;

    /* renamed from: com.miui.support.text.ChinesePinyinConverter.1 */
    final class C04191 extends SoftReferenceSingleton<ChinesePinyinConverter> {
        C04191() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5240a();
        }

        protected ChinesePinyinConverter m5240a() {
            return new ChinesePinyinConverter();
        }
    }

    private static class BopomofoConvertor {
        private static final String[] f3564a;
        private static final Node f3565b;

        private static class Node {
            public char f3559a;
            public Node f3560b;
            public String f3561c;
            public Node f3562d;
            public boolean f3563e;

            private Node() {
            }
        }

        private BopomofoConvertor() {
        }

        static {
            f3564a = new String[]{"b", "\u3105", "p", "\u3106", "m", "\u3107", "f", "\u3108", "d", "\u3109", "t", "\u310a", "n", "\u310b", "l", "\u310c", "g", "\u310d", "k", "\u310e", "h", "\u310f", "j", "\u3110", "q", "\u3111", "x", "\u3112", "zh", "\u3113", "ch", "\u3114", "sh", "\u3115", "r", "\u3116", "z", "\u3117", "c", "\u3118", "s", "\u3119", "y", "\u3127", "w", "\u3128", "a", "\u311a", "o", "\u311b", "e", "\u311c", "i", "\u3127", "u", "\u3128", "v", "\u3129", "ao", "\u3120", "ai", "\u311e", "an", "\u3122", "ang", "\u3124", "ou", "\u3121", "ong", "\u3128\u3125", "ei", "\u311f", "en", "\u3123", "eng", "\u3125", "er", "\u3126", "ie", "\u3127\u311d", "iu", "\u3127\u3121", "in", "\u3127\u3123", "ing", "\u3127\u3125", "iong", "\u3129\u3125", "ui", "\u3128\u311f", "un", "\u3128\u3123", "ue", "\u3129\u311d", "ve", "\u3129\u311d", "van", "\u3129\u3122", "vn", "\u3129\u3123", "", "", "zhi", "\u3113", "chi", "\u3114", "shi", "\u3115", "ri", "\u3116", "zi", "\u3117", "ci", "\u3118", "si", "\u3119", "yi", "\u3127", "ye", "\u3127\u311d", "you", "\u3127\u3121", "yin", "\u3127\u3123", "ying", "\u3127\u3125", "wu", "\u3128", "wei", "\u3128\u311f", "wen", "\u3128\u3123", "yu", "\u3129", "yue", "\u3129\u311d", "yuan", "\u3129\u3122", "yun", "\u3129\u3123", "yong", "\u3129\u3125", "ju", "\u3110\u3129", "jue", "\u3110\u3129\u311d", "juan", "\u3110\u3129\u3122", "jun", "\u3110\u3129\u3123", "qu", "\u3111\u3129", "que", "\u3111\u3129\u311d", "quan", "\u3111\u3129\u3122", "qun", "\u3111\u3129\u3123", "xu", "\u3112\u3129", "xue", "\u3112\u3129\u311d", "xuan", "\u3112\u3129\u3122", "xun", "\u3112\u3129\u3123"};
            f3565b = m5241a();
        }

        private static Node m5241a() {
            Node node = new Node();
            node.f3561c = "";
            boolean z = false;
            for (int i = 0; i < f3564a.length; i += 2) {
                String str = f3564a[i];
                if (str.length() == 0) {
                    z = true;
                } else {
                    int length = str.length();
                    int i2 = 0;
                    Node node2 = node;
                    while (i2 < length) {
                        char toLowerCase = Character.toLowerCase(str.charAt(i2));
                        Node node3 = node2.f3560b;
                        while (node3 != null && node3.f3559a != toLowerCase) {
                            node3 = node3.f3562d;
                        }
                        if (node3 == null) {
                            node3 = new Node();
                            node3.f3559a = toLowerCase;
                            node3.f3562d = node2.f3560b;
                            node2.f3560b = node3;
                        }
                        i2++;
                        node2 = node3;
                    }
                    node2.f3563e = z;
                    node2.f3561c = f3564a[i + 1];
                }
            }
            return node;
        }
    }

    private static class ChinesePinyinDictionary {
        private Reader f3566a;

        private ChinesePinyinDictionary() {
            String a = DirectIndexedFileExtractor.m4222a(AppConstants.m4227a(), "pinyinindex.idf");
            if (a != null && new File(a).exists()) {
                try {
                    this.f3566a = DirectIndexedFile.m5369a(a);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (this.f3566a == null) {
                try {
                    this.f3566a = DirectIndexedFile.m5368a(AppConstants.m4227a().getResources().getAssets().open("pinyinindex.idf", 1));
                } catch (Exception e2) {
                    Log.e("ChinesePinyinConverter", "Init resource IOException");
                }
            }
        }

        protected void finalize() {
            if (this.f3566a != null) {
                this.f3566a.m5367b();
            }
            super.finalize();
        }
    }

    public static class Token {
    }

    static {
        f3567a = new HashMap();
        f3568b = new HashMap();
        f3569c = new C04191();
        f3567a.put("\u5355\u4e8e", new String[]{"CHAN", "YU"});
        f3567a.put("\u957f\u5b59", new String[]{"ZHANG", "SUN"});
        f3567a.put("\u5b50\u8f66", new String[]{"ZI", "JU"});
        f3567a.put("\u4e07\u4fdf", new String[]{"MO", "QI"});
        f3567a.put("\u6fb9\u53f0", new String[]{"TAN", "TAI"});
        f3567a.put("\u5c09\u8fdf", new String[]{"YU", "CHI"});
        f3568b.put(Character.valueOf('\u4e48'), "YAO");
        f3568b.put(Character.valueOf('\u4e01'), "DING");
        f3568b.put(Character.valueOf('\u4fde'), "YU");
        f3568b.put(Character.valueOf('\u8d3e'), "JIA");
        f3568b.put(Character.valueOf('\u6c88'), "SHEN");
        f3568b.put(Character.valueOf('\u535c'), "BU");
        f3568b.put(Character.valueOf('\u8584'), "BO");
        f3568b.put(Character.valueOf('\u5b5b'), "BO");
        f3568b.put(Character.valueOf('\u8d32'), "BEN");
        f3568b.put(Character.valueOf('\u8d39'), "FEI");
        f3568b.put(Character.valueOf('\u6cca'), "BAN");
        f3568b.put(Character.valueOf('\u8300'), "BI");
        f3568b.put(Character.valueOf('\u756a'), "BO");
        f3568b.put(Character.valueOf('\u891a'), "CHU");
        f3568b.put(Character.valueOf('\u4f20'), "CHUAN");
        f3568b.put(Character.valueOf('\u53c2'), "CAN");
        f3568b.put(Character.valueOf('\u5355'), "SHAN");
        f3568b.put(Character.valueOf('\u90d7'), "CHI");
        f3568b.put(Character.valueOf('\u9561'), "CHAN");
        f3568b.put(Character.valueOf('\u671d'), "CHAO");
        f3568b.put(Character.valueOf('\u555c'), "CHUAI");
        f3568b.put(Character.valueOf('\u8870'), "CUI");
        f3568b.put(Character.valueOf('\u6668'), "CHANG");
        f3568b.put(Character.valueOf('\u4e11'), "CHOU");
        f3568b.put(Character.valueOf('\u7633'), "CHOU");
        f3568b.put(Character.valueOf('\u957f'), "CHANG");
        f3568b.put(Character.valueOf('\u8f66'), "CHE");
        f3568b.put(Character.valueOf('\u7fdf'), "ZHAI");
        f3568b.put(Character.valueOf('\u4f43'), "DIAN");
        f3568b.put(Character.valueOf('\u5200'), "DIAO");
        f3568b.put(Character.valueOf('\u8c03'), "DIAO");
        f3568b.put(Character.valueOf('\u9046'), "DI");
        f3568b.put(Character.valueOf('\u660b'), "GUI");
        f3568b.put(Character.valueOf('\u82a5'), "GAI");
        f3568b.put(Character.valueOf('\u8312'), "KUANG");
        f3568b.put(Character.valueOf('\u90c7'), "HUAN");
        f3568b.put(Character.valueOf('\u5df7'), "XIANG");
        f3568b.put(Character.valueOf('\u6496'), "HAN");
        f3568b.put(Character.valueOf('\u89c1'), "JIAN");
        f3568b.put(Character.valueOf('\u964d'), "JIANG");
        f3568b.put(Character.valueOf('\u89d2'), "JIAO");
        f3568b.put(Character.valueOf('\u7f34'), "JIAO");
        f3568b.put(Character.valueOf('\u8bb0'), "JI");
        f3568b.put(Character.valueOf('\u741a'), "JU");
        f3568b.put(Character.valueOf('\u5267'), "JI");
        f3568b.put(Character.valueOf('\u96bd'), "JUAN");
        f3568b.put(Character.valueOf('\u9697'), "KUI");
        f3568b.put(Character.valueOf('\u61a8'), "KAN");
        f3568b.put(Character.valueOf('\u9760'), "KU");
        f3568b.put(Character.valueOf('\u4e50'), "YUE");
        f3568b.put(Character.valueOf('\u5587'), "LA");
        f3568b.put(Character.valueOf('\u96d2'), "LUO");
        f3568b.put(Character.valueOf('\u4e86'), "LIAO");
        f3568b.put(Character.valueOf('\u7f2a'), "MIAO");
        f3568b.put(Character.valueOf('\u4f74'), "MI");
        f3568b.put(Character.valueOf('\u8c2c'), "MIAO");
        f3568b.put(Character.valueOf('\u4e5c'), "NIE");
        f3568b.put(Character.valueOf('\u9022'), "PANG");
        f3568b.put(Character.valueOf('\u84ec'), "PENG");
        f3568b.put(Character.valueOf('\u6734'), "PIAO");
        f3568b.put(Character.valueOf('\u4ec7'), "QIU");
        f3568b.put(Character.valueOf('\u8983'), "QIN");
        f3568b.put(Character.valueOf('\u79a4'), "QIAN");
        f3568b.put(Character.valueOf('\u77bf'), "QU");
        f3568b.put(Character.valueOf('\u4ec0'), "SHI");
        f3568b.put(Character.valueOf('\u6298'), "SHE");
        f3568b.put(Character.valueOf('\u772d'), "SUI");
        f3568b.put(Character.valueOf('\u89e3'), "XIE");
        f3568b.put(Character.valueOf('\u7cfb'), "XI");
        f3568b.put(Character.valueOf('\u5df7'), "XIANG");
        f3568b.put(Character.valueOf('\u9664'), "XU");
        f3568b.put(Character.valueOf('\u5bf0'), "XIAN");
        f3568b.put(Character.valueOf('\u5458'), "YUAN");
        f3568b.put(Character.valueOf('\u8d20'), "YUAN");
        f3568b.put(Character.valueOf('\u66fe'), "ZENG");
        f3568b.put(Character.valueOf('\u67e5'), "ZHA");
        f3568b.put(Character.valueOf('\u4f20'), "CHUAN");
        f3568b.put(Character.valueOf('\u53ec'), "SHAO");
        f3568b.put(Character.valueOf('\u91cd'), "chong");
    }

    private ChinesePinyinConverter() {
        this.f3570d = new ChinesePinyinDictionary();
    }
}
