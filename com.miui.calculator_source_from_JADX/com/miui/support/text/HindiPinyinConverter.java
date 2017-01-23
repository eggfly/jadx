package com.miui.support.text;

import com.miui.support.reflect.Field;
import com.miui.support.util.Pools;
import com.miui.support.util.Pools.Manager;
import com.miui.support.util.Pools.SimplePool;
import com.miui.support.util.SoftReferenceSingleton;
import java.util.ArrayList;
import java.util.HashMap;

public class HindiPinyinConverter {
    private static final SoftReferenceSingleton<HindiPinyinConverter> f3572n;
    private static SimplePool<StringBuilder> f3573o;
    private static SimplePool<ArrayList<String>> f3574p;
    private String[] f3575a;
    private String[] f3576b;
    private String[] f3577c;
    private String[] f3578d;
    private String[] f3579e;
    private String[] f3580f;
    private String[] f3581g;
    private String[] f3582h;
    private String[] f3583i;
    private String[] f3584j;
    private HashMap<String, String> f3585k;
    private HashMap<String, String> f3586l;
    private HashMap<String, String> f3587m;

    /* renamed from: com.miui.support.text.HindiPinyinConverter.1 */
    final class C04201 extends SoftReferenceSingleton<HindiPinyinConverter> {
        C04201() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5245a();
        }

        protected HindiPinyinConverter m5245a() {
            return new HindiPinyinConverter();
        }
    }

    /* renamed from: com.miui.support.text.HindiPinyinConverter.2 */
    final class C04212 extends Manager<StringBuilder> {
        C04212() {
        }

        public /* synthetic */ Object m5249b() {
            return m5246a();
        }

        public StringBuilder m5246a() {
            return new StringBuilder();
        }

        public void m5248a(StringBuilder stringBuilder) {
            stringBuilder.setLength(0);
        }
    }

    /* renamed from: com.miui.support.text.HindiPinyinConverter.3 */
    final class C04223 extends Manager<ArrayList<String>> {
        C04223() {
        }

        public /* synthetic */ Object m5253b() {
            return m5250a();
        }

        public ArrayList<String> m5250a() {
            return new ArrayList();
        }

        public void m5252a(ArrayList<String> arrayList) {
            arrayList.clear();
        }
    }

    private void m5254a() {
        this.f3575a = new String[12];
        this.f3576b = new String[12];
        this.f3577c = new String[15];
        this.f3578d = new String[15];
        this.f3579e = new String[35];
        this.f3580f = new String[35];
        this.f3581g = new String[8];
        this.f3582h = new String[8];
        this.f3583i = new String[3];
        this.f3584j = new String[3];
        this.f3585k = new HashMap();
        this.f3586l = new HashMap();
        this.f3587m = new HashMap();
        this.f3575a[0] = "\u0905";
        this.f3575a[1] = "\u0906";
        this.f3575a[2] = "\u0907";
        this.f3575a[3] = "\u0908";
        this.f3575a[4] = "\u0909";
        this.f3575a[5] = "\u090a";
        this.f3575a[6] = "\u090b";
        this.f3575a[7] = "\u090f";
        this.f3575a[8] = "\u0910";
        this.f3575a[9] = "\u0911";
        this.f3575a[10] = "\u0913";
        this.f3575a[11] = "\u0914";
        this.f3576b[0] = "a";
        this.f3576b[1] = "aa";
        this.f3576b[2] = "i";
        this.f3576b[3] = "ee";
        this.f3576b[4] = "u";
        this.f3576b[5] = "oo";
        this.f3576b[6] = "r";
        this.f3576b[7] = "e";
        this.f3576b[8] = "ai";
        this.f3576b[9] = "o";
        this.f3576b[10] = "o";
        this.f3576b[11] = "au";
        this.f3577c[0] = "\u093e";
        this.f3577c[1] = "\u093f";
        this.f3577c[2] = "\u0940";
        this.f3577c[3] = "\u0941";
        this.f3577c[4] = "\u0942";
        this.f3577c[5] = "\u0943";
        this.f3577c[6] = "\u0944";
        this.f3577c[7] = "\u0945";
        this.f3577c[8] = "\u0947";
        this.f3577c[9] = "\u0948";
        this.f3577c[10] = "\u0949";
        this.f3577c[11] = "\u094b";
        this.f3577c[12] = "\u094c";
        this.f3577c[13] = "\u094e";
        this.f3577c[14] = "\u094f";
        this.f3578d[0] = "aa";
        this.f3578d[1] = "i";
        this.f3578d[2] = "ee";
        this.f3578d[3] = "u";
        this.f3578d[4] = "oo";
        this.f3578d[5] = "r";
        this.f3578d[6] = "R";
        this.f3578d[7] = "e";
        this.f3578d[8] = "e";
        this.f3578d[9] = "ai";
        this.f3578d[10] = "o";
        this.f3578d[11] = "o";
        this.f3578d[12] = "au";
        this.f3578d[13] = "e";
        this.f3578d[14] = "aw";
        this.f3579e[0] = "\u0915";
        this.f3579e[1] = "\u0916";
        this.f3579e[2] = "\u0917";
        this.f3579e[3] = "\u0918";
        this.f3579e[4] = "\u0919";
        this.f3579e[5] = "\u091a";
        this.f3579e[6] = "\u091b";
        this.f3579e[7] = "\u091c";
        this.f3579e[8] = "\u091d";
        this.f3579e[9] = "\u091e";
        this.f3579e[10] = "\u091f";
        this.f3579e[11] = "\u0920";
        this.f3579e[12] = "\u0921";
        this.f3579e[13] = "\u0922";
        this.f3579e[14] = "\u0923";
        this.f3579e[15] = "\u0924";
        this.f3579e[16] = "\u0925";
        this.f3579e[17] = "\u0926";
        this.f3579e[18] = "\u0927";
        this.f3579e[19] = "\u0928";
        this.f3579e[20] = "\u0929";
        this.f3579e[21] = "\u092a";
        this.f3579e[22] = "\u092b";
        this.f3579e[23] = "\u092c";
        this.f3579e[24] = "\u092d";
        this.f3579e[25] = "\u092e";
        this.f3579e[26] = "\u092f";
        this.f3579e[27] = "\u0930";
        this.f3579e[28] = "\u0931";
        this.f3579e[29] = "\u0932";
        this.f3579e[30] = "\u0935";
        this.f3579e[31] = "\u0936";
        this.f3579e[32] = "\u0937";
        this.f3579e[33] = "\u0938";
        this.f3579e[34] = "\u0939";
        this.f3580f[0] = "k";
        this.f3580f[1] = "kh";
        this.f3580f[2] = "g";
        this.f3580f[3] = "gh";
        this.f3580f[4] = "ng";
        this.f3580f[5] = "c";
        this.f3580f[6] = "ch";
        this.f3580f[7] = "j";
        this.f3580f[8] = "jh";
        this.f3580f[9] = "ny";
        this.f3580f[10] = "T";
        this.f3580f[11] = "Th";
        this.f3580f[12] = Field.DOUBLE_SIGNATURE_PRIMITIVE;
        this.f3580f[13] = "Dh";
        this.f3580f[14] = "N";
        this.f3580f[15] = "t";
        this.f3580f[16] = "th";
        this.f3580f[17] = "d";
        this.f3580f[18] = "dh";
        this.f3580f[19] = "n";
        this.f3580f[20] = "Nn";
        this.f3580f[21] = "p";
        this.f3580f[22] = "ph";
        this.f3580f[23] = "b";
        this.f3580f[24] = "bh";
        this.f3580f[25] = "m";
        this.f3580f[26] = "y";
        this.f3580f[27] = "r";
        this.f3580f[28] = "R";
        this.f3580f[29] = "l";
        this.f3580f[30] = "v";
        this.f3580f[31] = "sh";
        this.f3580f[32] = Field.SHORT_SIGNATURE_PRIMITIVE;
        this.f3580f[33] = "s";
        this.f3580f[34] = "h";
        this.f3581g[0] = "\u0958";
        this.f3581g[1] = "\u0959";
        this.f3581g[2] = "\u095a";
        this.f3581g[3] = "\u095b";
        this.f3581g[4] = "\u095c";
        this.f3581g[5] = "\u095d";
        this.f3581g[6] = "\u095e";
        this.f3581g[7] = "\u095f";
        this.f3582h[0] = "q";
        this.f3582h[1] = "khh";
        this.f3582h[2] = "ghh";
        this.f3582h[3] = "z";
        this.f3582h[4] = "Ddh";
        this.f3582h[5] = "rh";
        this.f3582h[6] = "f";
        this.f3582h[7] = "Y";
        this.f3583i[0] = "\u0901";
        this.f3583i[1] = "\u0902";
        this.f3583i[2] = "\u0903";
        this.f3584j[0] = "an";
        this.f3584j[1] = "an";
        this.f3584j[2] = "ah";
    }

    private void m5255b() {
        int i;
        int i2;
        for (i = 0; i < 35; i++) {
            this.f3585k.put(this.f3579e[i], this.f3580f[i] + "a");
        }
        for (i = 0; i < 12; i++) {
            this.f3585k.put(this.f3575a[i], this.f3576b[i]);
        }
        for (i = 0; i < 8; i++) {
            this.f3585k.put(this.f3581g[i], this.f3582h[i]);
        }
        for (i2 = 0; i2 < 35; i2++) {
            for (i = 0; i < 15; i++) {
                this.f3586l.put(this.f3579e[i2] + this.f3577c[i], this.f3580f[i2] + this.f3578d[i]);
            }
            for (i = 0; i < 3; i++) {
                this.f3586l.put(this.f3579e[i2] + this.f3583i[i], this.f3580f[i2] + this.f3584j[i]);
            }
        }
        for (i2 = 0; i2 < 8; i2++) {
            for (i = 0; i < 15; i++) {
                this.f3586l.put(this.f3581g[i2] + this.f3577c[i], this.f3582h[i2] + this.f3578d[i]);
            }
            for (i = 0; i < 3; i++) {
                this.f3586l.put(this.f3579e[i2] + this.f3583i[i], this.f3580f[i2] + this.f3584j[i]);
            }
        }
        for (i = 0; i < 35; i++) {
            this.f3586l.put(this.f3579e[i] + "\u094d", this.f3580f[i]);
        }
        for (i = 0; i < 12; i++) {
        }
        for (int i3 = 0; i3 < 35; i3++) {
            for (i2 = 0; i2 < 15; i2++) {
                for (i = 0; i < 3; i++) {
                    this.f3587m.put(this.f3579e[i3] + this.f3577c[i2] + this.f3583i[i], this.f3580f[i3] + this.f3578d[i2] + this.f3584j[i].substring(1));
                }
            }
        }
        this.f3586l.put("\u0905\u0902", "am");
    }

    static {
        f3572n = new C04201();
        f3573o = Pools.m5431a(new C04212(), 4);
        f3574p = Pools.m5431a(new C04223(), 4);
    }

    private HindiPinyinConverter() {
        m5254a();
        m5255b();
    }
}
