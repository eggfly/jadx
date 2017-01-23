package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.support.v7.widget.d */
class C0603d extends DataSetObservable {
    private static final String f2027a;
    private static final Object f2028b;
    private static final Map<String, C0603d> f2029c;
    private final Object f2030d;
    private final List<C0598a> f2031e;
    private final List<C0600c> f2032f;
    private final Context f2033g;
    private final String f2034h;
    private Intent f2035i;
    private C0599b f2036j;
    private int f2037k;
    private boolean f2038l;
    private boolean f2039m;
    private boolean f2040n;
    private boolean f2041o;
    private C0601d f2042p;

    /* renamed from: android.support.v7.widget.d.a */
    public final class C0598a implements Comparable<C0598a> {
        public final ResolveInfo f2020a;
        public float f2021b;
        final /* synthetic */ C0603d f2022c;

        public C0598a(C0603d c0603d, ResolveInfo resolveInfo) {
            this.f2022c = c0603d;
            this.f2020a = resolveInfo;
        }

        public int m2593a(C0598a c0598a) {
            return Float.floatToIntBits(c0598a.f2021b) - Float.floatToIntBits(this.f2021b);
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m2593a((C0598a) obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.f2021b) == Float.floatToIntBits(((C0598a) obj).f2021b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2021b) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f2020a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2021b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v7.widget.d.b */
    public interface C0599b {
        void m2594a(Intent intent, List<C0598a> list, List<C0600c> list2);
    }

    /* renamed from: android.support.v7.widget.d.c */
    public static final class C0600c {
        public final ComponentName f2023a;
        public final long f2024b;
        public final float f2025c;

        public C0600c(ComponentName componentName, long j, float f) {
            this.f2023a = componentName;
            this.f2024b = j;
            this.f2025c = f;
        }

        public C0600c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0600c c0600c = (C0600c) obj;
            if (this.f2023a == null) {
                if (c0600c.f2023a != null) {
                    return false;
                }
            } else if (!this.f2023a.equals(c0600c.f2023a)) {
                return false;
            }
            return this.f2024b != c0600c.f2024b ? false : Float.floatToIntBits(this.f2025c) == Float.floatToIntBits(c0600c.f2025c);
        }

        public int hashCode() {
            return (((((this.f2023a == null ? 0 : this.f2023a.hashCode()) + 31) * 31) + ((int) (this.f2024b ^ (this.f2024b >>> 32)))) * 31) + Float.floatToIntBits(this.f2025c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f2023a);
            stringBuilder.append("; time:").append(this.f2024b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2025c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v7.widget.d.d */
    public interface C0601d {
        boolean m2595a(C0603d c0603d, Intent intent);
    }

    /* renamed from: android.support.v7.widget.d.e */
    private final class C0602e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ C0603d f2026a;

        private C0602e(C0603d c0603d) {
            this.f2026a = c0603d;
        }

        public Void m2596a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f2026a.f2033g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument(HttpRequest.f14548a, Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C0600c c0600c = (C0600c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c0600c.f2023a.flattenToString());
                        newSerializer.attribute(null, C4233j.f14377D, String.valueOf(c0600c.f2024b));
                        newSerializer.attribute(null, "weight", String.valueOf(c0600c.f2025c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f2026a.f2038l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(C0603d.f2027a, "Error writing historical recrod file: " + this.f2026a.f2034h, e2);
                    this.f2026a.f2038l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(C0603d.f2027a, "Error writing historical recrod file: " + this.f2026a.f2034h, e22);
                    this.f2026a.f2038l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(C0603d.f2027a, "Error writing historical recrod file: " + this.f2026a.f2034h, e222);
                    this.f2026a.f2038l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f2026a.f2038l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(C0603d.f2027a, "Error writing historical recrod file: " + str, e2222);
            }
            return null;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2596a(objArr);
        }
    }

    static {
        f2027a = C0603d.class.getSimpleName();
        f2028b = new Object();
        f2029c = new HashMap();
    }

    private boolean m2598a(C0600c c0600c) {
        boolean add = this.f2032f.add(c0600c);
        if (add) {
            this.f2040n = true;
            m2607i();
            m2602d();
            m2604f();
            notifyChanged();
        }
        return add;
    }

    private void m2602d() {
        if (!this.f2039m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2040n) {
            this.f2040n = false;
            if (!TextUtils.isEmpty(this.f2034h)) {
                AsyncTaskCompat.executeParallel(new C0602e(), new ArrayList(this.f2032f), this.f2034h);
            }
        }
    }

    private void m2603e() {
        int g = m2605g() | m2606h();
        m2607i();
        if (g != 0) {
            m2604f();
            notifyChanged();
        }
    }

    private boolean m2604f() {
        if (this.f2036j == null || this.f2035i == null || this.f2031e.isEmpty() || this.f2032f.isEmpty()) {
            return false;
        }
        this.f2036j.m2594a(this.f2035i, this.f2031e, Collections.unmodifiableList(this.f2032f));
        return true;
    }

    private boolean m2605g() {
        if (!this.f2041o || this.f2035i == null) {
            return false;
        }
        this.f2041o = false;
        this.f2031e.clear();
        List queryIntentActivities = this.f2033g.getPackageManager().queryIntentActivities(this.f2035i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2031e.add(new C0598a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m2606h() {
        if (!this.f2038l || !this.f2040n || TextUtils.isEmpty(this.f2034h)) {
            return false;
        }
        this.f2038l = false;
        this.f2039m = true;
        m2608j();
        return true;
    }

    private void m2607i() {
        int size = this.f2032f.size() - this.f2037k;
        if (size > 0) {
            this.f2040n = true;
            for (int i = 0; i < size; i++) {
                C0600c c0600c = (C0600c) this.f2032f.remove(0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2608j() {
        /*
        r9 = this;
        r8 = 1;
        r0 = r9.f2033g;	 Catch:{ FileNotFoundException -> 0x00d3 }
        r1 = r9.f2034h;	 Catch:{ FileNotFoundException -> 0x00d3 }
        r1 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00d3 }
        r2 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = "UTF-8";
        r2.setInput(r1, r0);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = 0;
    L_0x0013:
        if (r0 == r8) goto L_0x001d;
    L_0x0015:
        r3 = 2;
        if (r0 == r3) goto L_0x001d;
    L_0x0018:
        r0 = r2.next();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        goto L_0x0013;
    L_0x001d:
        r0 = "historical-records";
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = r0.equals(r3);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r0 != 0) goto L_0x0052;
    L_0x0029:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r2 = "Share records file does not start with historical-records tag.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x0031:
        r0 = move-exception;
        r2 = f2027a;	 Catch:{ all -> 0x00c8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3.<init>();	 Catch:{ all -> 0x00c8 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r9.f2034h;	 Catch:{ all -> 0x00c8 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();	 Catch:{ IOException -> 0x00cf }
    L_0x0051:
        return;
    L_0x0052:
        r0 = r9.f2032f;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0.clear();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x0057:
        r3 = r2.next();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r3 != r8) goto L_0x0065;
    L_0x005d:
        if (r1 == 0) goto L_0x0051;
    L_0x005f:
        r1.close();	 Catch:{ IOException -> 0x0063 }
        goto L_0x0051;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0051;
    L_0x0065:
        r4 = 3;
        if (r3 == r4) goto L_0x0057;
    L_0x0068:
        r4 = 4;
        if (r3 == r4) goto L_0x0057;
    L_0x006b:
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = "historical-record";
        r3 = r4.equals(r3);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r3 != 0) goto L_0x00a2;
    L_0x0077:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r2 = "Share records file not well-formed.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x007f:
        r0 = move-exception;
        r2 = f2027a;	 Catch:{ all -> 0x00c8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3.<init>();	 Catch:{ all -> 0x00c8 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r9.f2034h;	 Catch:{ all -> 0x00c8 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x0051;
    L_0x009c:
        r1.close();	 Catch:{ IOException -> 0x00a0 }
        goto L_0x0051;
    L_0x00a0:
        r0 = move-exception;
        goto L_0x0051;
    L_0x00a2:
        r3 = 0;
        r4 = "activity";
        r3 = r2.getAttributeValue(r3, r4);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = 0;
        r5 = "time";
        r4 = r2.getAttributeValue(r4, r5);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r6 = 0;
        r7 = "weight";
        r6 = r2.getAttributeValue(r6, r7);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r6 = java.lang.Float.parseFloat(r6);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r7 = new android.support.v7.widget.d$c;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r7.<init>(r3, r4, r6);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0.add(r7);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        goto L_0x0057;
    L_0x00c8:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ce;
    L_0x00cb:
        r1.close();	 Catch:{ IOException -> 0x00d1 }
    L_0x00ce:
        throw r0;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x0051;
    L_0x00d1:
        r1 = move-exception;
        goto L_0x00ce;
    L_0x00d3:
        r0 = move-exception;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.d.j():void");
    }

    public int m2609a() {
        int size;
        synchronized (this.f2030d) {
            m2603e();
            size = this.f2031e.size();
        }
        return size;
    }

    public int m2610a(ResolveInfo resolveInfo) {
        synchronized (this.f2030d) {
            m2603e();
            List list = this.f2031e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0598a) list.get(i)).f2020a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo m2611a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2030d) {
            m2603e();
            resolveInfo = ((C0598a) this.f2031e.get(i)).f2020a;
        }
        return resolveInfo;
    }

    public Intent m2612b(int i) {
        synchronized (this.f2030d) {
            if (this.f2035i == null) {
                return null;
            }
            m2603e();
            C0598a c0598a = (C0598a) this.f2031e.get(i);
            ComponentName componentName = new ComponentName(c0598a.f2020a.activityInfo.packageName, c0598a.f2020a.activityInfo.name);
            Intent intent = new Intent(this.f2035i);
            intent.setComponent(componentName);
            if (this.f2042p != null) {
                if (this.f2042p.m2595a(this, new Intent(intent))) {
                    return null;
                }
            }
            m2598a(new C0600c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m2613b() {
        synchronized (this.f2030d) {
            m2603e();
            if (this.f2031e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0598a) this.f2031e.get(0)).f2020a;
            return resolveInfo;
        }
    }

    public void m2614c(int i) {
        synchronized (this.f2030d) {
            m2603e();
            C0598a c0598a = (C0598a) this.f2031e.get(i);
            C0598a c0598a2 = (C0598a) this.f2031e.get(0);
            m2598a(new C0600c(new ComponentName(c0598a.f2020a.activityInfo.packageName, c0598a.f2020a.activityInfo.name), System.currentTimeMillis(), c0598a2 != null ? (c0598a2.f2021b - c0598a.f2021b) + 5.0f : 1.0f));
        }
    }
}
