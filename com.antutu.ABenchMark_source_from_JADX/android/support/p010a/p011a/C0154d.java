package android.support.p010a.p011a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.a.a.d */
class C0154d {
    public static float m724a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0154d.m727a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int m725a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0154d.m727a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static boolean m726a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0154d.m727a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean m727a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int m728b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0154d.m727a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
