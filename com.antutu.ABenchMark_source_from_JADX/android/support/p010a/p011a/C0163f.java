package android.support.p010a.p011a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p010a.p011a.C0153c.C0152b;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.handmark.pulltorefresh.library.C3628R;
import com.taobao.accs.data.Message;
import com.viewpagerindicator.C4273R;
import java.util.ArrayList;
import java.util.Stack;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* renamed from: android.support.a.a.f */
public class C0163f extends C0148e {
    static final Mode f742b;
    private C0161f f743c;
    private PorterDuffColorFilter f744d;
    private ColorFilter f745e;
    private boolean f746f;
    private boolean f747g;
    private ConstantState f748h;
    private final float[] f749i;
    private final Matrix f750j;
    private final Rect f751k;

    /* renamed from: android.support.a.a.f.d */
    private static class C0156d {
        protected C0152b[] f684m;
        String f685n;
        int f686o;

        public C0156d() {
            this.f684m = null;
        }

        public C0156d(C0156d c0156d) {
            this.f684m = null;
            this.f685n = c0156d.f685n;
            this.f686o = c0156d.f686o;
            this.f684m = C0153c.m721a(c0156d.f684m);
        }

        public void m729a(Path path) {
            path.reset();
            if (this.f684m != null) {
                C0152b.m715a(this.f684m, path);
            }
        }

        public boolean m730a() {
            return false;
        }

        public String m731b() {
            return this.f685n;
        }
    }

    /* renamed from: android.support.a.a.f.a */
    private static class C0157a extends C0156d {
        public C0157a(C0157a c0157a) {
            super(c0157a);
        }

        private void m732a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = C0153c.m720a(string);
            }
        }

        public void m733a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0154d.m727a(xmlPullParser, "pathData")) {
                TypedArray b = C0148e.m705b(resources, theme, attributeSet, C0144a.f666d);
                m732a(b);
                b.recycle();
            }
        }

        public boolean m734a() {
            return true;
        }
    }

    /* renamed from: android.support.a.a.f.b */
    private static class C0158b extends C0156d {
        int f687a;
        float f688b;
        int f689c;
        float f690d;
        int f691e;
        float f692f;
        float f693g;
        float f694h;
        float f695i;
        Cap f696j;
        Join f697k;
        float f698l;
        private int[] f699p;

        public C0158b() {
            this.f687a = 0;
            this.f688b = 0.0f;
            this.f689c = 0;
            this.f690d = 1.0f;
            this.f692f = 1.0f;
            this.f693g = 0.0f;
            this.f694h = 1.0f;
            this.f695i = 0.0f;
            this.f696j = Cap.BUTT;
            this.f697k = Join.MITER;
            this.f698l = 4.0f;
        }

        public C0158b(C0158b c0158b) {
            super(c0158b);
            this.f687a = 0;
            this.f688b = 0.0f;
            this.f689c = 0;
            this.f690d = 1.0f;
            this.f692f = 1.0f;
            this.f693g = 0.0f;
            this.f694h = 1.0f;
            this.f695i = 0.0f;
            this.f696j = Cap.BUTT;
            this.f697k = Join.MITER;
            this.f698l = 4.0f;
            this.f699p = c0158b.f699p;
            this.f687a = c0158b.f687a;
            this.f688b = c0158b.f688b;
            this.f690d = c0158b.f690d;
            this.f689c = c0158b.f689c;
            this.f691e = c0158b.f691e;
            this.f692f = c0158b.f692f;
            this.f693g = c0158b.f693g;
            this.f694h = c0158b.f694h;
            this.f695i = c0158b.f695i;
            this.f696j = c0158b.f696j;
            this.f697k = c0158b.f697k;
            this.f698l = c0158b.f698l;
        }

        private Cap m735a(int i, Cap cap) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return Cap.BUTT;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return Cap.ROUND;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m736a(int i, Join join) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return Join.MITER;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return Join.ROUND;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        private void m737a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f699p = null;
            if (C0154d.m727a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0153c.m720a(string);
                }
                this.f689c = C0154d.m728b(typedArray, xmlPullParser, "fillColor", 1, this.f689c);
                this.f692f = C0154d.m724a(typedArray, xmlPullParser, "fillAlpha", 12, this.f692f);
                this.f696j = m735a(C0154d.m725a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f696j);
                this.f697k = m736a(C0154d.m725a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f697k);
                this.f698l = C0154d.m724a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f698l);
                this.f687a = C0154d.m728b(typedArray, xmlPullParser, "strokeColor", 3, this.f687a);
                this.f690d = C0154d.m724a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f690d);
                this.f688b = C0154d.m724a(typedArray, xmlPullParser, "strokeWidth", 4, this.f688b);
                this.f694h = C0154d.m724a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f694h);
                this.f695i = C0154d.m724a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f695i);
                this.f693g = C0154d.m724a(typedArray, xmlPullParser, "trimPathStart", 5, this.f693g);
            }
        }

        public void m738a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0148e.m705b(resources, theme, attributeSet, C0144a.f665c);
            m737a(b, xmlPullParser);
            b.recycle();
        }
    }

    /* renamed from: android.support.a.a.f.c */
    private static class C0159c {
        final ArrayList<Object> f700a;
        private final Matrix f701b;
        private float f702c;
        private float f703d;
        private float f704e;
        private float f705f;
        private float f706g;
        private float f707h;
        private float f708i;
        private final Matrix f709j;
        private int f710k;
        private int[] f711l;
        private String f712m;

        public C0159c() {
            this.f701b = new Matrix();
            this.f700a = new ArrayList();
            this.f702c = 0.0f;
            this.f703d = 0.0f;
            this.f704e = 0.0f;
            this.f705f = 1.0f;
            this.f706g = 1.0f;
            this.f707h = 0.0f;
            this.f708i = 0.0f;
            this.f709j = new Matrix();
            this.f712m = null;
        }

        public C0159c(C0159c c0159c, ArrayMap<String, Object> arrayMap) {
            this.f701b = new Matrix();
            this.f700a = new ArrayList();
            this.f702c = 0.0f;
            this.f703d = 0.0f;
            this.f704e = 0.0f;
            this.f705f = 1.0f;
            this.f706g = 1.0f;
            this.f707h = 0.0f;
            this.f708i = 0.0f;
            this.f709j = new Matrix();
            this.f712m = null;
            this.f702c = c0159c.f702c;
            this.f703d = c0159c.f703d;
            this.f704e = c0159c.f704e;
            this.f705f = c0159c.f705f;
            this.f706g = c0159c.f706g;
            this.f707h = c0159c.f707h;
            this.f708i = c0159c.f708i;
            this.f711l = c0159c.f711l;
            this.f712m = c0159c.f712m;
            this.f710k = c0159c.f710k;
            if (this.f712m != null) {
                arrayMap.put(this.f712m, this);
            }
            this.f709j.set(c0159c.f709j);
            ArrayList arrayList = c0159c.f700a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0159c) {
                    this.f700a.add(new C0159c((C0159c) obj, arrayMap));
                } else {
                    C0156d c0158b;
                    if (obj instanceof C0158b) {
                        c0158b = new C0158b((C0158b) obj);
                    } else if (obj instanceof C0157a) {
                        c0158b = new C0157a((C0157a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f700a.add(c0158b);
                    if (c0158b.f685n != null) {
                        arrayMap.put(c0158b.f685n, c0158b);
                    }
                }
            }
        }

        private void m740a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f711l = null;
            this.f702c = C0154d.m724a(typedArray, xmlPullParser, "rotation", 5, this.f702c);
            this.f703d = typedArray.getFloat(1, this.f703d);
            this.f704e = typedArray.getFloat(2, this.f704e);
            this.f705f = C0154d.m724a(typedArray, xmlPullParser, "scaleX", 3, this.f705f);
            this.f706g = C0154d.m724a(typedArray, xmlPullParser, "scaleY", 4, this.f706g);
            this.f707h = C0154d.m724a(typedArray, xmlPullParser, "translateX", 6, this.f707h);
            this.f708i = C0154d.m724a(typedArray, xmlPullParser, "translateY", 7, this.f708i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f712m = string;
            }
            m742b();
        }

        private void m742b() {
            this.f709j.reset();
            this.f709j.postTranslate(-this.f703d, -this.f704e);
            this.f709j.postScale(this.f705f, this.f706g);
            this.f709j.postRotate(this.f702c, 0.0f, 0.0f);
            this.f709j.postTranslate(this.f707h + this.f703d, this.f708i + this.f704e);
        }

        public String m744a() {
            return this.f712m;
        }

        public void m745a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0148e.m705b(resources, theme, attributeSet, C0144a.f664b);
            m740a(b, xmlPullParser);
            b.recycle();
        }
    }

    /* renamed from: android.support.a.a.f.e */
    private static class C0160e {
        private static final Matrix f713j;
        float f714a;
        float f715b;
        float f716c;
        float f717d;
        int f718e;
        String f719f;
        final ArrayMap<String, Object> f720g;
        private final Path f721h;
        private final Path f722i;
        private final Matrix f723k;
        private Paint f724l;
        private Paint f725m;
        private PathMeasure f726n;
        private int f727o;
        private final C0159c f728p;

        static {
            f713j = new Matrix();
        }

        public C0160e() {
            this.f723k = new Matrix();
            this.f714a = 0.0f;
            this.f715b = 0.0f;
            this.f716c = 0.0f;
            this.f717d = 0.0f;
            this.f718e = MotionEventCompat.ACTION_MASK;
            this.f719f = null;
            this.f720g = new ArrayMap();
            this.f728p = new C0159c();
            this.f721h = new Path();
            this.f722i = new Path();
        }

        public C0160e(C0160e c0160e) {
            this.f723k = new Matrix();
            this.f714a = 0.0f;
            this.f715b = 0.0f;
            this.f716c = 0.0f;
            this.f717d = 0.0f;
            this.f718e = MotionEventCompat.ACTION_MASK;
            this.f719f = null;
            this.f720g = new ArrayMap();
            this.f728p = new C0159c(c0160e.f728p, this.f720g);
            this.f721h = new Path(c0160e.f721h);
            this.f722i = new Path(c0160e.f722i);
            this.f714a = c0160e.f714a;
            this.f715b = c0160e.f715b;
            this.f716c = c0160e.f716c;
            this.f717d = c0160e.f717d;
            this.f727o = c0160e.f727o;
            this.f718e = c0160e.f718e;
            this.f719f = c0160e.f719f;
            if (c0160e.f719f != null) {
                this.f720g.put(c0160e.f719f, this);
            }
        }

        private static float m746a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m747a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0160e.m746a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            return hypot > 0.0f ? Math.abs(a) / hypot : 0.0f;
        }

        private void m750a(C0159c c0159c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0159c.f701b.set(matrix);
            c0159c.f701b.preConcat(c0159c.f709j);
            for (int i3 = 0; i3 < c0159c.f700a.size(); i3++) {
                Object obj = c0159c.f700a.get(i3);
                if (obj instanceof C0159c) {
                    m750a((C0159c) obj, c0159c.f701b, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0156d) {
                    m751a(c0159c, (C0156d) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        private void m751a(C0159c c0159c, C0156d c0156d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f716c;
            float f2 = ((float) i2) / this.f717d;
            float min = Math.min(f, f2);
            Matrix b = c0159c.f701b;
            this.f723k.set(b);
            this.f723k.postScale(f, f2);
            f = m747a(b);
            if (f != 0.0f) {
                c0156d.m729a(this.f721h);
                Path path = this.f721h;
                this.f722i.reset();
                if (c0156d.m730a()) {
                    this.f722i.addPath(path, this.f723k);
                    canvas.clipPath(this.f722i, Op.REPLACE);
                    return;
                }
                Paint paint;
                C0158b c0158b = (C0158b) c0156d;
                if (!(c0158b.f693g == 0.0f && c0158b.f694h == 1.0f)) {
                    float f3 = (c0158b.f693g + c0158b.f695i) % 1.0f;
                    float f4 = (c0158b.f694h + c0158b.f695i) % 1.0f;
                    if (this.f726n == null) {
                        this.f726n = new PathMeasure();
                    }
                    this.f726n.setPath(this.f721h, false);
                    float length = this.f726n.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.f726n.getSegment(f3, length, path, true);
                        this.f726n.getSegment(0.0f, f4, path, true);
                    } else {
                        this.f726n.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f722i.addPath(path, this.f723k);
                if (c0158b.f689c != 0) {
                    if (this.f725m == null) {
                        this.f725m = new Paint();
                        this.f725m.setStyle(Style.FILL);
                        this.f725m.setAntiAlias(true);
                    }
                    paint = this.f725m;
                    paint.setColor(C0163f.m774b(c0158b.f689c, c0158b.f692f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f722i, paint);
                }
                if (c0158b.f687a != 0) {
                    if (this.f724l == null) {
                        this.f724l = new Paint();
                        this.f724l.setStyle(Style.STROKE);
                        this.f724l.setAntiAlias(true);
                    }
                    paint = this.f724l;
                    if (c0158b.f697k != null) {
                        paint.setStrokeJoin(c0158b.f697k);
                    }
                    if (c0158b.f696j != null) {
                        paint.setStrokeCap(c0158b.f696j);
                    }
                    paint.setStrokeMiter(c0158b.f698l);
                    paint.setColor(C0163f.m774b(c0158b.f687a, c0158b.f690d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * c0158b.f688b);
                    canvas.drawPath(this.f722i, paint);
                }
            }
        }

        public int m755a() {
            return this.f718e;
        }

        public void m756a(float f) {
            m757a((int) (255.0f * f));
        }

        public void m757a(int i) {
            this.f718e = i;
        }

        public void m758a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m750a(this.f728p, f713j, canvas, i, i2, colorFilter);
        }

        public float m759b() {
            return ((float) m755a()) / 255.0f;
        }
    }

    /* renamed from: android.support.a.a.f.f */
    private static class C0161f extends ConstantState {
        int f729a;
        C0160e f730b;
        ColorStateList f731c;
        Mode f732d;
        boolean f733e;
        Bitmap f734f;
        ColorStateList f735g;
        Mode f736h;
        int f737i;
        boolean f738j;
        boolean f739k;
        Paint f740l;

        public C0161f() {
            this.f731c = null;
            this.f732d = C0163f.f742b;
            this.f730b = new C0160e();
        }

        public C0161f(C0161f c0161f) {
            this.f731c = null;
            this.f732d = C0163f.f742b;
            if (c0161f != null) {
                this.f729a = c0161f.f729a;
                this.f730b = new C0160e(c0161f.f730b);
                if (c0161f.f730b.f725m != null) {
                    this.f730b.f725m = new Paint(c0161f.f730b.f725m);
                }
                if (c0161f.f730b.f724l != null) {
                    this.f730b.f724l = new Paint(c0161f.f730b.f724l);
                }
                this.f731c = c0161f.f731c;
                this.f732d = c0161f.f732d;
                this.f733e = c0161f.f733e;
            }
        }

        public Paint m760a(ColorFilter colorFilter) {
            if (!m763a() && colorFilter == null) {
                return null;
            }
            if (this.f740l == null) {
                this.f740l = new Paint();
                this.f740l.setFilterBitmap(true);
            }
            this.f740l.setAlpha(this.f730b.m755a());
            this.f740l.setColorFilter(colorFilter);
            return this.f740l;
        }

        public void m761a(int i, int i2) {
            this.f734f.eraseColor(0);
            this.f730b.m758a(new Canvas(this.f734f), i, i2, null);
        }

        public void m762a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f734f, null, rect, m760a(colorFilter));
        }

        public boolean m763a() {
            return this.f730b.m755a() < MotionEventCompat.ACTION_MASK;
        }

        public void m764b(int i, int i2) {
            if (this.f734f == null || !m767c(i, i2)) {
                this.f734f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f739k = true;
            }
        }

        public boolean m765b() {
            return !this.f739k && this.f735g == this.f731c && this.f736h == this.f732d && this.f738j == this.f733e && this.f737i == this.f730b.m755a();
        }

        public void m766c() {
            this.f735g = this.f731c;
            this.f736h = this.f732d;
            this.f737i = this.f730b.m755a();
            this.f738j = this.f733e;
            this.f739k = false;
        }

        public boolean m767c(int i, int i2) {
            return i == this.f734f.getWidth() && i2 == this.f734f.getHeight();
        }

        public int getChangingConfigurations() {
            return this.f729a;
        }

        public Drawable newDrawable() {
            return new C0163f();
        }

        public Drawable newDrawable(Resources resources) {
            return new C0163f();
        }
    }

    /* renamed from: android.support.a.a.f.g */
    private static class C0162g extends ConstantState {
        private final ConstantState f741a;

        public C0162g(ConstantState constantState) {
            this.f741a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f741a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f741a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable c0163f = new C0163f();
            c0163f.a = (VectorDrawable) this.f741a.newDrawable();
            return c0163f;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0163f = new C0163f();
            c0163f.a = (VectorDrawable) this.f741a.newDrawable(resources);
            return c0163f;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0163f = new C0163f();
            c0163f.a = (VectorDrawable) this.f741a.newDrawable(resources, theme);
            return c0163f;
        }
    }

    static {
        f742b = Mode.SRC_IN;
    }

    private C0163f() {
        this.f747g = true;
        this.f749i = new float[9];
        this.f750j = new Matrix();
        this.f751k = new Rect();
        this.f743c = new C0161f();
    }

    private C0163f(C0161f c0161f) {
        this.f747g = true;
        this.f749i = new float[9];
        this.f750j = new Matrix();
        this.f751k = new Rect();
        this.f743c = c0161f;
        this.f744d = m776a(this.f744d, c0161f.f731c, c0161f.f732d);
    }

    private static Mode m769a(int i, Mode mode) {
        switch (i) {
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return Mode.SRC_OVER;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return Mode.SRC_IN;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return Mode.SRC_ATOP;
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return Mode.MULTIPLY;
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return Mode.SCREEN;
            case SpdyProtocol.CUSTOM /*16*/:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    public static C0163f m770a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            C0163f c0163f = new C0163f();
            c0163f.a = ResourcesCompat.getDrawable(resources, i, theme);
            c0163f.f748h = new C0162g(c0163f.a.getConstantState());
            return c0163f;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0163f.m771a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static C0163f m771a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0163f c0163f = new C0163f();
        c0163f.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0163f;
    }

    private void m772a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0161f c0161f = this.f743c;
        C0160e c0160e = c0161f.f730b;
        c0161f.f732d = C0163f.m769a(C0154d.m725a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0161f.f731c = colorStateList;
        }
        c0161f.f733e = C0154d.m726a(typedArray, xmlPullParser, "autoMirrored", 5, c0161f.f733e);
        c0160e.f716c = C0154d.m724a(typedArray, xmlPullParser, "viewportWidth", 7, c0160e.f716c);
        c0160e.f717d = C0154d.m724a(typedArray, xmlPullParser, "viewportHeight", 8, c0160e.f717d);
        if (c0160e.f716c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0160e.f717d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0160e.f714a = typedArray.getDimension(3, c0160e.f714a);
            c0160e.f715b = typedArray.getDimension(2, c0160e.f715b);
            if (c0160e.f714a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0160e.f715b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0160e.m756a(C0154d.m724a(typedArray, xmlPullParser, "alpha", 4, c0160e.m759b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0160e.f719f = string;
                    c0160e.f720g.put(string, c0160e);
                }
            }
        }
    }

    private boolean m773a() {
        return false;
    }

    private static int m774b(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (ViewCompat.MEASURED_SIZE_MASK & i);
    }

    private void m775b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0161f c0161f = this.f743c;
        C0160e c0160e = c0161f.f730b;
        Stack stack = new Stack();
        stack.push(c0160e.f728p);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0159c c0159c = (C0159c) stack.peek();
                if ("path".equals(name)) {
                    C0158b c0158b = new C0158b();
                    c0158b.m738a(resources, attributeSet, theme, xmlPullParser);
                    c0159c.f700a.add(c0158b);
                    if (c0158b.m731b() != null) {
                        c0160e.f720g.put(c0158b.m731b(), c0158b);
                    }
                    obj2 = null;
                    c0161f.f729a = c0158b.o | c0161f.f729a;
                } else if ("clip-path".equals(name)) {
                    C0157a c0157a = new C0157a();
                    c0157a.m733a(resources, attributeSet, theme, xmlPullParser);
                    c0159c.f700a.add(c0157a);
                    if (c0157a.m731b() != null) {
                        c0160e.f720g.put(c0157a.m731b(), c0157a);
                    }
                    c0161f.f729a |= c0157a.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0159c c0159c2 = new C0159c();
                        c0159c2.m745a(resources, attributeSet, theme, xmlPullParser);
                        c0159c.f700a.add(c0159c2);
                        stack.push(c0159c2);
                        if (c0159c2.m744a() != null) {
                            c0160e.f720g.put(c0159c2.m744a(), c0159c2);
                        }
                        c0161f.f729a |= c0159c2.f710k;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    PorterDuffColorFilter m776a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object m777a(String str) {
        return this.f743c.f730b.f720g.get(str);
    }

    void m778a(boolean z) {
        this.f747g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            DrawableCompat.canApplyTheme(this.a);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.f751k);
        if (this.f751k.width() > 0 && this.f751k.height() > 0) {
            ColorFilter colorFilter = this.f745e == null ? this.f744d : this.f745e;
            canvas.getMatrix(this.f750j);
            this.f750j.getValues(this.f749i);
            float abs = Math.abs(this.f749i[0]);
            float abs2 = Math.abs(this.f749i[4]);
            float abs3 = Math.abs(this.f749i[1]);
            float abs4 = Math.abs(this.f749i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f751k.height()));
            int min = Math.min(Message.FLAG_RET, (int) (abs * ((float) this.f751k.width())));
            height = Math.min(Message.FLAG_RET, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f751k.left, (float) this.f751k.top);
                if (m773a()) {
                    canvas.translate((float) this.f751k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f751k.offsetTo(0, 0);
                this.f743c.m764b(min, height);
                if (!this.f747g) {
                    this.f743c.m761a(min, height);
                } else if (!this.f743c.m765b()) {
                    this.f743c.m761a(min, height);
                    this.f743c.m766c();
                }
                this.f743c.m762a(canvas, colorFilter, this.f751k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.a != null ? DrawableCompat.getAlpha(this.a) : this.f743c.f730b.m755a();
    }

    public int getChangingConfigurations() {
        return this.a != null ? this.a.getChangingConfigurations() : super.getChangingConfigurations() | this.f743c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new C0162g(this.a.getConstantState());
        }
        this.f743c.f729a = getChangingConfigurations();
        return this.f743c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a != null ? this.a.getIntrinsicHeight() : (int) this.f743c.f730b.f715b;
    }

    public int getIntrinsicWidth() {
        return this.a != null ? this.a.getIntrinsicWidth() : (int) this.f743c.f730b.f714a;
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a != null ? this.a.getOpacity() : -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            DrawableCompat.inflate(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0161f c0161f = this.f743c;
        c0161f.f730b = new C0160e();
        TypedArray b = C0148e.m705b(resources, theme, attributeSet, C0144a.f663a);
        m772a(b, xmlPullParser);
        b.recycle();
        c0161f.f729a = getChangingConfigurations();
        c0161f.f739k = true;
        m775b(resources, xmlPullParser, attributeSet, theme);
        this.f744d = m776a(this.f744d, c0161f.f731c, c0161f.f732d);
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.a != null ? this.a.isStateful() : super.isStateful() || !(this.f743c == null || this.f743c.f731c == null || !this.f743c.f731c.isStateful());
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.f746f && super.mutate() == this) {
            this.f743c = new C0161f(this.f743c);
            this.f746f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        C0161f c0161f = this.f743c;
        if (c0161f.f731c == null || c0161f.f732d == null) {
            return false;
        }
        this.f744d = m776a(this.f744d, c0161f.f731c, c0161f.f732d);
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else if (this.f743c.f730b.m755a() != i) {
            this.f743c.f730b.m757a(i);
            invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.f745e = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.a != null) {
            DrawableCompat.setTint(this.a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            DrawableCompat.setTintList(this.a, colorStateList);
            return;
        }
        C0161f c0161f = this.f743c;
        if (c0161f.f731c != colorStateList) {
            c0161f.f731c = colorStateList;
            this.f744d = m776a(this.f744d, colorStateList, c0161f.f732d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            DrawableCompat.setTintMode(this.a, mode);
            return;
        }
        C0161f c0161f = this.f743c;
        if (c0161f.f732d != mode) {
            c0161f.f732d = mode;
            this.f744d = m776a(this.f744d, c0161f.f731c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.a != null ? this.a.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
