package com.aide.uidesigner;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.aide.common.j;
import com.aide.common.j.a;
import com.aide.common.m;
import com.aide.common.t;
import com.aide.common.y;
import com.aide.uidesigner.h.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class i {
    private static a DW;
    private static f j6;

    static /* synthetic */ class 10 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[b.values().length];
            try {
                j6[b.Drawable.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[b.DrawableResource.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[b.Color.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[b.Float.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[b.Int.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                j6[b.TextSize.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                j6[b.Size.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                j6[b.FloatSize.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                j6[b.LayoutSize.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                j6[b.Bool.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                j6[b.Text.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                j6[b.Event.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                j6[b.EnumConstant.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                j6[b.IntConstant.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                j6[b.ID.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                j6[b.TextAppearance.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    static class 11 implements y<String> {
        final /* synthetic */ f DW;
        final /* synthetic */ a FH;
        final /* synthetic */ Activity j6;

        class 1 implements y<String> {
            final /* synthetic */ 11 j6;

            1(11 11) {
                this.j6 = 11;
            }

            public void j6(String str) {
                this.j6.DW.j6(this.j6.FH, null, str);
            }
        }

        11(Activity activity, f fVar, a aVar) {
            this.j6 = activity;
            this.DW = fVar;
            this.FH = aVar;
        }

        public void j6(String str) {
            if (str.equals("View...")) {
                i.gn(this.j6, this.DW, this.FH);
            } else if (str.equals("id...")) {
                List arrayList = new ArrayList(this.DW.getAllIDs());
                Collections.sort(arrayList);
                m.j6(this.j6, this.FH.j6.j6(), arrayList, new 1(this));
            } else {
                this.DW.j6(this.FH, null);
            }
        }
    }

    static class 12 implements y<f> {
        final /* synthetic */ a DW;
        final /* synthetic */ Activity FH;
        final /* synthetic */ f j6;

        12(f fVar, a aVar, Activity activity) {
            this.j6 = fVar;
            this.DW = aVar;
            this.FH = activity;
        }

        public void j6(f fVar) {
            if (fVar.getViewID() == null) {
                this.j6.j6(this.DW, fVar, fVar.FH());
            } else {
                this.j6.j6(this.DW, null, fVar.getViewID());
            }
            Toast.makeText(this.FH, "View was selected for attribute " + this.DW.j6.j6(), 0).show();
        }
    }

    static class 13 implements y<String> {
        final /* synthetic */ a DW;
        final /* synthetic */ f j6;

        13(f fVar, a aVar) {
            this.j6 = fVar;
            this.DW = aVar;
        }

        public void j6(String str) {
            this.j6.j6(this.DW, str);
        }
    }

    static class 14 implements y<Integer> {
        final /* synthetic */ f DW;
        final /* synthetic */ a FH;
        final /* synthetic */ String[] Hw;
        final /* synthetic */ ArrayList j6;

        14(ArrayList arrayList, f fVar, a aVar, String[] strArr) {
            this.j6 = arrayList;
            this.DW = fVar;
            this.FH = aVar;
            this.Hw = strArr;
        }

        public void j6(Integer num) {
            if (((String) this.j6.get(num.intValue())).equals("none")) {
                this.DW.j6(this.FH, null);
            } else {
                this.DW.j6(this.FH, this.Hw[num.intValue()]);
            }
        }
    }

    static class 15 implements y<String> {
        final /* synthetic */ f DW;
        final /* synthetic */ a FH;
        final /* synthetic */ Activity j6;

        15(Activity activity, f fVar, a aVar) {
            this.j6 = activity;
            this.DW = fVar;
            this.FH = aVar;
        }

        public void j6(String str) {
            if (str.equals("Color...")) {
                i.J8(this.j6, this.DW, this.FH);
            } else if (str.equals("Drawable...")) {
                i.J0(this.j6, this.DW, this.FH);
            } else {
                this.DW.j6(this.FH, null);
            }
        }
    }

    static class 16 implements y<Integer> {
        final /* synthetic */ f DW;
        final /* synthetic */ a FH;
        final /* synthetic */ Activity Hw;
        final /* synthetic */ List j6;
        final /* synthetic */ ArrayList v5;

        16(List list, f fVar, a aVar, Activity activity, ArrayList arrayList) {
            this.j6 = list;
            this.DW = fVar;
            this.FH = aVar;
            this.Hw = activity;
            this.v5 = arrayList;
        }

        public void j6(Integer num) {
            String str = (String) this.j6.get(num.intValue());
            if (str.equals("none")) {
                this.DW.j6(this.FH, null);
            } else if (str.equals("other...")) {
                i.DW(this.Hw, this.DW, this.FH, "@drawable/");
            } else if (str.equals("add...")) {
                i.we(this.Hw, this.DW, this.FH);
            } else {
                this.DW.j6(this.FH, (String) this.v5.get(num.intValue()));
            }
        }
    }

    static class 17 implements y<Integer> {
        final /* synthetic */ f DW;
        final /* synthetic */ a FH;
        final /* synthetic */ Activity Hw;
        final /* synthetic */ ArrayList Zo;
        final /* synthetic */ List j6;
        final /* synthetic */ String v5;

        17(List list, f fVar, a aVar, Activity activity, String str, ArrayList arrayList) {
            this.j6 = list;
            this.DW = fVar;
            this.FH = aVar;
            this.Hw = activity;
            this.v5 = str;
            this.Zo = arrayList;
        }

        public void j6(Integer num) {
            String str = (String) this.j6.get(num.intValue());
            if (str.equals("none")) {
                this.DW.j6(this.FH, null);
            } else if (str.equals("other...")) {
                i.DW(this.Hw, this.DW, this.FH, this.v5);
            } else {
                this.DW.j6(this.FH, (String) this.Zo.get(num.intValue()));
            }
        }
    }

    static class 18 implements a {
        final /* synthetic */ a DW;
        final /* synthetic */ f j6;

        18(f fVar, a aVar) {
            this.j6 = fVar;
            this.DW = aVar;
        }

        public void j6(int i, String str) {
            this.j6.j6(this.DW, str);
        }
    }

    static class 1 implements y<String> {
        final /* synthetic */ Intent j6;

        1(Intent intent) {
            this.j6 = intent;
        }

        public void j6(String str) {
            i.j6.j6(str, this.j6);
            i.j6.j6(i.DW, "@drawable/" + str);
            i.j6 = null;
            i.DW = null;
        }
    }

    static class 2 implements y<String> {
        final /* synthetic */ a DW;
        final /* synthetic */ Activity FH;
        final /* synthetic */ f j6;

        2(f fVar, a aVar, Activity activity) {
            this.j6 = fVar;
            this.DW = aVar;
            this.FH = activity;
        }

        public void j6(String str) {
            if (str.equals("Wrap Content")) {
                this.j6.j6(this.DW, "wrap_content");
            } else if (str.equals("Match Parent")) {
                this.j6.j6(this.DW, "match_parent");
            } else {
                String str2 = "10dp";
                if (!("match_parent".equals(this.DW.DW) || "wrap_content".equals(this.DW.DW))) {
                    str2 = this.DW.DW;
                }
                i.DW(this.FH, this.j6, this.DW, str2, "10dp");
            }
        }
    }

    static class 3 implements y<String> {
        final /* synthetic */ a DW;
        final /* synthetic */ f j6;

        3(f fVar, a aVar) {
            this.j6 = fVar;
            this.DW = aVar;
        }

        public void j6(String str) {
            if (str.length() == 0) {
                str = null;
            }
            this.j6.j6(this.DW, str);
        }
    }

    static class 4 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ f j6;

        4(f fVar, a aVar) {
            this.j6 = fVar;
            this.DW = aVar;
        }

        public void run() {
            this.j6.j6(this.DW, null);
        }
    }

    static class 5 implements y<String> {
        final /* synthetic */ a DW;
        final /* synthetic */ f j6;

        5(f fVar, a aVar) {
            this.j6 = fVar;
            this.DW = aVar;
        }

        public void j6(String str) {
            if (str.length() == 0) {
                str = null;
            }
            this.j6.j6(this.DW, str);
        }
    }

    static class 6 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ f j6;

        6(f fVar, a aVar) {
            this.j6 = fVar;
            this.DW = aVar;
        }

        public void run() {
            this.j6.j6(this.DW, null);
        }
    }

    static class 7 implements y<String> {
        final /* synthetic */ Activity DW;
        final /* synthetic */ f j6;

        class 1 implements y<String> {
            final /* synthetic */ 7 j6;

            1(7 7) {
                this.j6 = 7;
            }

            public void j6(String str) {
                if (str.length() == 0) {
                    this.j6.j6.setStyle(null);
                } else {
                    this.j6.j6.setStyle(str);
                }
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 7 j6;

            2(7 7) {
                this.j6 = 7;
            }

            public void run() {
                this.j6.j6.setStyle(null);
            }
        }

        7(f fVar, Activity activity) {
            this.j6 = fVar;
            this.DW = activity;
        }

        public void j6(String str) {
            if (str.equals("none")) {
                this.j6.setStyle(null);
            }
            if (str.equals("other...")) {
                m.j6(this.DW, "Style", null, "None", this.j6.getStyle(), new 1(this), new 2(this));
            } else {
                this.j6.setStyle(str);
            }
        }
    }

    static class 8 implements y<String> {
        final /* synthetic */ f j6;

        8(f fVar) {
            this.j6 = fVar;
        }

        public void j6(String str) {
            if (str.length() == 0) {
                str = null;
            }
            this.j6.setViewID(str);
        }
    }

    static class 9 implements Runnable {
        final /* synthetic */ f j6;

        9(f fVar) {
            this.j6 = fVar;
        }

        public void run() {
            this.j6.setViewID(null);
        }
    }

    public static void j6(Activity activity, Intent intent) {
        if (j6 != null) {
            m.j6(activity, "Choose Name", "Enter a name for the image", j6.DW(), new 1(intent));
        }
    }

    public static void j6(Activity activity, f fVar, a aVar) {
        switch (10.j6[aVar.j6.v5.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                EQ(activity, fVar, aVar);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                J0(activity, fVar, aVar);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                J8(activity, fVar, aVar);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                DW(activity, fVar, aVar, "1.0");
            case 5:
                DW(activity, fVar, aVar, "1");
            case 6:
                DW(activity, fVar, aVar, aVar.DW, "10sp");
            case 7:
            case 8:
                DW(activity, fVar, aVar, aVar.DW, "10dp");
            case 9:
                QX(activity, fVar, aVar);
            case 10:
                Ws(activity, fVar, aVar);
            case 11:
                DW(activity, fVar, aVar, "");
            case 12:
                DW(activity, fVar, aVar, "");
            case 13:
                tp(activity, fVar, aVar);
            case 14:
                u7(activity, fVar, aVar);
            case 15:
                VH(activity, fVar, aVar);
            case 16:
                Zo(activity, fVar, aVar);
            default:
                DW(activity, fVar, aVar, "");
        }
    }

    private static void Zo(Activity activity, f fVar, a aVar) {
        j6(activity, fVar, aVar, "?android:attr/", "?android:attr/textAppearanceSmall", "?android:attr/textAppearanceMedium", "?android:attr/textAppearanceLarge");
    }

    private static void VH(Activity activity, f fVar, a aVar) {
        if (aVar.DW == null) {
            gn(activity, fVar, aVar);
            return;
        }
        m.j6(activity, aVar.j6.j6(), Arrays.asList(new String[]{"View...", "none"}), new 11(activity, fVar, aVar));
    }

    private static void gn(Activity activity, f fVar, a aVar) {
        Toast.makeText(activity, "Select another view", 0).show();
        fVar.j6(new 12(fVar, aVar, activity));
    }

    private static void u7(Activity activity, f fVar, a aVar) {
        int i = 0;
        if ("android:visibility".equals(aVar.j6.Hw)) {
            DW(activity, fVar, aVar, "visible", "invisible", "gone");
        } else if ("android:orientation".equals(aVar.j6.Hw)) {
            DW(activity, fVar, aVar, "horizontal", "vertical");
        } else if ("android:typeface".equals(aVar.j6.Hw)) {
            DW(activity, fVar, aVar, "normal", "sans", "serif", "monospace");
        } else if ("android:alignmentMode".equals(aVar.j6.Hw)) {
            DW(activity, fVar, aVar, "alignBounds", "alignMargins");
        } else if ("android:textAlignment".equals(aVar.j6.Hw)) {
            DW(activity, fVar, aVar, "inherit", "gravity", "textStart", "textEnd", "center", "viewStart", "viewEnd");
        } else if ("android.view.Gravity".equals(aVar.j6.VH)) {
            j6(activity, fVar, aVar, "top", "bottom", "left", "right", "center", "center_vertical", "center_horizontal", "fill", "fill_vertical", "fill_horizontal", "clip_vertical", "clip_horizontal", "start", "end");
        } else if (aVar.j6.gn == null || aVar.j6.FH == null) {
            DW(activity, fVar, aVar, "");
        } else {
            List arrayList = new ArrayList();
            Field[] fields = aVar.j6.Zo.getFields();
            int length = fields.length;
            while (i < length) {
                Field field = fields[i];
                String name = field.getName();
                if ((field.getModifiers() & 8) != 0 && name.startsWith(aVar.j6.gn)) {
                    arrayList.add(name.substring(aVar.j6.gn.length()).replace("_", ""));
                }
                i++;
            }
            Collections.sort(arrayList);
            j6(activity, fVar, aVar, arrayList);
        }
    }

    private static void j6(Activity activity, f fVar, a aVar, List<String> list) {
        j6(activity, fVar, aVar, (String[]) list.toArray(new String[list.size()]));
    }

    private static void j6(Activity activity, f fVar, a aVar, String... strArr) {
        List arrayList = new ArrayList();
        for (String j6 : strArr) {
            arrayList.add(a.j6(j6));
        }
        m.j6(activity, aVar.j6.j6(), Arrays.asList(strArr), arrayList, aVar.DW, new 13(fVar, aVar));
    }

    private static void tp(Activity activity, f fVar, a aVar) {
        if ("android.widget.ImageView$ScaleType".equals(aVar.j6.VH)) {
            DW(activity, fVar, aVar, "matrix", "fitXY", "fitStart", "fitCenter", "fitEnd", "center", "centerCrop", "centerInside");
        } else if ("android.text.TextUtils$TruncateAt".equals(aVar.j6.VH)) {
            DW(activity, fVar, aVar, "start", "middle", "end", "marquee");
        } else {
            DW(activity, fVar, aVar, "");
        }
    }

    private static void DW(Activity activity, f fVar, a aVar, String... strArr) {
        List arrayList = new ArrayList();
        for (String j6 : strArr) {
            arrayList.add(a.j6(j6));
        }
        arrayList.add("none");
        m.DW(activity, aVar.j6.j6(), arrayList, new 14(arrayList, fVar, aVar, strArr));
    }

    private static void EQ(Activity activity, f fVar, a aVar) {
        if (aVar.DW == null) {
            m.j6(activity, aVar.j6.j6(), Arrays.asList(new String[]{"Color...", "Drawable...", "none"}), new 15(activity, fVar, aVar));
        } else if (aVar.DW.startsWith("#")) {
            J8(activity, fVar, aVar);
        } else {
            J0(activity, fVar, aVar);
        }
    }

    private static void we(Activity activity, f fVar, a aVar) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        activity.startActivityForResult(intent, 3424345);
        j6 = fVar;
        DW = aVar;
    }

    private static void J0(Activity activity, f fVar, a aVar) {
        ArrayList arrayList = new ArrayList(fVar.getAllUserDrawables());
        Collections.sort(arrayList);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(a.j6((String) it.next()));
        }
        arrayList2.add("other...");
        arrayList2.add("add...");
        arrayList2.add("none");
        m.DW(activity, aVar.j6.j6(), arrayList2, new 16(arrayList2, fVar, aVar, activity, arrayList));
    }

    private static void j6(Activity activity, f fVar, a aVar, String str, String... strArr) {
        j6(activity, fVar, aVar, str, Arrays.asList(strArr));
    }

    private static void j6(Activity activity, f fVar, a aVar, String str, List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(a.j6((String) it.next()));
        }
        arrayList2.add("other...");
        arrayList2.add("none");
        m.DW(activity, aVar.j6.j6(), arrayList2, new 17(arrayList2, fVar, aVar, activity, str, arrayList));
    }

    private static void J8(Activity activity, f fVar, a aVar) {
        m.j6(activity, new j(aVar.j6.j6(), aVar.DW, new 18(fVar, aVar)));
    }

    private static void Ws(Activity activity, f fVar, a aVar) {
        DW(activity, fVar, aVar, "true", "false");
    }

    private static void QX(Activity activity, f fVar, a aVar) {
        m.j6(activity, aVar.j6.j6(), Arrays.asList(new String[]{"Wrap Content", "Match Parent", "Fixed size..."}), new 2(fVar, aVar, activity));
    }

    private static void DW(Activity activity, f fVar, a aVar, String str, String str2) {
        if (str != null) {
            str2 = str;
        }
        m.j6(activity, new t(aVar.j6.j6(), str2, new 3(fVar, aVar), new 4(fVar, aVar)));
    }

    private static void DW(Activity activity, f fVar, a aVar, String str) {
        String str2 = aVar.DW;
        if (str2 == null) {
            str2 = str;
        }
        m.j6(activity, aVar.j6.j6(), null, "None", str2, new 5(fVar, aVar), new 6(fVar, aVar));
    }

    public static void j6(Activity activity, f fVar) {
        List arrayList = new ArrayList(fVar.getAllUserStyles());
        Collections.sort(arrayList);
        arrayList.add("other...");
        arrayList.add("none");
        m.j6(activity, "Style", arrayList, new 7(fVar, activity));
    }

    public static void DW(Activity activity, f fVar) {
        String viewID;
        if (fVar.getViewID() != null) {
            viewID = fVar.getViewID();
        } else {
            viewID = fVar.FH();
        }
        m.j6(activity, "ID", null, "None", viewID, new 8(fVar), new 9(fVar));
    }
}
