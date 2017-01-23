package com.antutu.benchmark.p036a;

import android.view.View;
import android.widget.BaseAdapter;
import com.antutu.benchmark.modelreflact.HomeFlagModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.antutu.benchmark.a.k */
public class C1122k extends BaseAdapter {
    private List<HomeFlagModel> f3778a;
    private Map<String, View> f3779b;

    /* renamed from: com.antutu.benchmark.a.k.1 */
    class C11211 implements Comparator<HomeFlagModel> {
        final /* synthetic */ C1122k f3777a;

        C11211(C1122k c1122k) {
            this.f3777a = c1122k;
        }

        public int m4877a(HomeFlagModel homeFlagModel, HomeFlagModel homeFlagModel2) {
            return homeFlagModel.getIsshow().intValue() - homeFlagModel2.getIsshow().intValue();
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4877a((HomeFlagModel) obj, (HomeFlagModel) obj2);
        }
    }

    public C1122k() {
        this(null);
    }

    public C1122k(List<HomeFlagModel> list) {
        this.f3778a = new ArrayList();
        this.f3779b = new HashMap();
        m4882a((List) list);
    }

    public HomeFlagModel m4878a(int i) {
        return (HomeFlagModel) this.f3778a.get(i);
    }

    public void m4879a() {
        m4883b().clear();
    }

    public void m4880a(HomeFlagModel homeFlagModel) {
        if (homeFlagModel != null) {
            m4883b().add(homeFlagModel);
        }
    }

    public void m4881a(HomeFlagModel homeFlagModel, int i) {
        m4883b().add(i, homeFlagModel);
    }

    public void m4882a(List<HomeFlagModel> list) {
        if (this.f3778a == null) {
            this.f3778a = new ArrayList();
        } else {
            this.f3778a.clear();
        }
        if (list != null) {
            for (HomeFlagModel homeFlagModel : list) {
                if (!(homeFlagModel == null || homeFlagModel.getIsshow().intValue() == 0)) {
                    this.f3778a.add(homeFlagModel);
                }
            }
        }
        Collections.sort(this.f3778a, new C11211(this));
    }

    protected List<HomeFlagModel> m4883b() {
        return this.f3778a;
    }

    public void m4884b(int i) {
        m4883b().remove(i);
    }

    public int getCount() {
        return this.f3778a.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return m4878a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
        r5 = this;
        r1 = 0;
        r2 = -1;
        r0 = r5.f3778a;
        r0 = r0.get(r6);
        r0 = (com.antutu.benchmark.modelreflact.HomeFlagModel) r0;
        r3 = r0.getLabel();
        if (r3 != 0) goto L_0x001a;
    L_0x0010:
        r0 = new android.view.View;
        r1 = r8.getContext();
        r0.<init>(r1);
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = r5.f3779b;
        r0 = r0.get(r3);
        r0 = (android.view.View) r0;
        if (r0 != 0) goto L_0x014c;
    L_0x0024:
        r0 = r3.hashCode();
        switch(r0) {
            case -2100653879: goto L_0x0056;
            case 298356563: goto L_0x0042;
            case 393224934: goto L_0x004c;
            case 456361320: goto L_0x007e;
            case 1470699300: goto L_0x0060;
            case 1492060983: goto L_0x0088;
            case 1505687672: goto L_0x0038;
            case 2060647987: goto L_0x006a;
            case 2141663279: goto L_0x0074;
            default: goto L_0x002b;
        };
    L_0x002b:
        switch(r2) {
            case 0: goto L_0x0093;
            case 1: goto L_0x00a5;
            case 2: goto L_0x00b7;
            case 3: goto L_0x00c9;
            case 4: goto L_0x00de;
            case 5: goto L_0x00f0;
            case 6: goto L_0x0102;
            case 7: goto L_0x0114;
            case 8: goto L_0x0126;
            default: goto L_0x002e;
        };
    L_0x002e:
        r0 = new android.view.View;
        r1 = r8.getContext();
        r0.<init>(r1);
        goto L_0x0019;
    L_0x0038:
        r0 = "IS_SHOW_YANJI";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x0040:
        r2 = r1;
        goto L_0x002b;
    L_0x0042:
        r0 = "IS_SHOW_3D_TEST";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x004a:
        r2 = 1;
        goto L_0x002b;
    L_0x004c:
        r0 = "IS_SHOW_PINGLUN";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x0054:
        r2 = 2;
        goto L_0x002b;
    L_0x0056:
        r0 = "IS_SHOW_BAOGUANG";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x005e:
        r2 = 3;
        goto L_0x002b;
    L_0x0060:
        r0 = "IS_SHOW_3D_AD";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x0068:
        r2 = 4;
        goto L_0x002b;
    L_0x006a:
        r0 = "IS_SHOW_HOTNEWS";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x0072:
        r2 = 5;
        goto L_0x002b;
    L_0x0074:
        r0 = "IS_SHOW_MORE_TEST";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x007c:
        r2 = 6;
        goto L_0x002b;
    L_0x007e:
        r0 = "IS_SHOW_LONG_TEST";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x0086:
        r2 = 7;
        goto L_0x002b;
    L_0x0088:
        r0 = "IS_SHOW_JIASU";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x0090:
        r2 = 8;
        goto L_0x002b;
    L_0x0093:
        r0 = new com.antutu.benchmark.view.j;
        r1 = r8.getContext();
        r0.<init>(r1);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_YANJI";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x00a5:
        r0 = new com.antutu.benchmark.view.c;
        r1 = r8.getContext();
        r0.<init>(r1);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_3D_TEST";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x00b7:
        r0 = new com.antutu.benchmark.view.d;
        r1 = r8.getContext();
        r0.<init>(r1);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_PINGLUN";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x00c9:
        r0 = new com.antutu.benchmark.view.e;
        r1 = r8.getContext();
        r0.<init>(r1);
        r0.setParentAdapter(r5);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_BAOGUANG";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x00de:
        r0 = new com.antutu.benchmark.view.b;
        r1 = r8.getContext();
        r0.<init>(r1);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_3D_AD";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x00f0:
        r0 = new com.antutu.benchmark.view.f;
        r1 = r8.getContext();
        r0.<init>(r1);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_HOTNEWS";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x0102:
        r0 = new com.antutu.benchmark.view.i;
        r1 = r8.getContext();
        r0.<init>(r1);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_MORE_TEST";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x0114:
        r0 = new com.antutu.benchmark.view.h;
        r1 = r8.getContext();
        r0.<init>(r1);
        r1 = r5.f3779b;
        r2 = "IS_SHOW_LONG_TEST";
        r1.put(r2, r0);
        goto L_0x0019;
    L_0x0126:
        r1 = new com.antutu.benchmark.view.g;
        r0 = r8.getContext();
        r1.<init>(r0);
        r0 = r5.f3778a;
        r0 = r0.get(r6);
        r0 = (com.antutu.benchmark.modelreflact.HomeFlagModel) r0;
        r0 = r0.getIsshow();
        r0 = r0.intValue();
        r1.setTemperature(r0);
        r0 = r5.f3779b;
        r2 = "IS_SHOW_JIASU";
        r0.put(r2, r1);
        r0 = r1;
        goto L_0x0019;
    L_0x014c:
        r4 = r3.hashCode();
        switch(r4) {
            case 1492060983: goto L_0x0171;
            default: goto L_0x0153;
        };
    L_0x0153:
        r1 = r2;
    L_0x0154:
        switch(r1) {
            case 0: goto L_0x0159;
            default: goto L_0x0157;
        };
    L_0x0157:
        goto L_0x0019;
    L_0x0159:
        r1 = r0;
        r1 = (com.antutu.benchmark.view.C1666g) r1;
        r2 = r5.f3778a;
        r2 = r2.get(r6);
        r2 = (com.antutu.benchmark.modelreflact.HomeFlagModel) r2;
        r2 = r2.getIsshow();
        r2 = r2.intValue();
        r1.setTemperature(r2);
        goto L_0x0019;
    L_0x0171:
        r4 = "IS_SHOW_JIASU";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0153;
    L_0x0179:
        goto L_0x0154;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.benchmark.a.k.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
