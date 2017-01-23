package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater {
    private static final int[] Animator;
    private static final int[] AnimatorSet;
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int[] PropertyAnimator;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;

    static {
        int[] iArr = new int[Animator_duration];
        iArr[Animator_interpolator] = 16843490;
        AnimatorSet = iArr;
        iArr = new int[Animator_duration];
        iArr[Animator_interpolator] = 16843489;
        PropertyAnimator = iArr;
        Animator = new int[]{16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    }

    public static Animator loadAnimator(Context context, int id) throws NotFoundException {
        NotFoundException rnf;
        XmlResourceParser parser = null;
        try {
            parser = context.getResources().getAnimation(id);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, parser);
            if (parser != null) {
                parser.close();
            }
            return createAnimatorFromXml;
        } catch (XmlPullParserException ex) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex2) {
            rnf = new NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex2);
            throw rnf;
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
        }
    }

    private static Animator createAnimatorFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(c, parser, Xml.asAttributeSet(parser), null, Animator_interpolator);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.nineoldandroids.animation.Animator createAnimatorFromXml(android.content.Context r18, org.xmlpull.v1.XmlPullParser r19, android.util.AttributeSet r20, com.nineoldandroids.animation.AnimatorSet r21, int r22) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r4 = 0;
        r6 = 0;
        r7 = r19.getDepth();
    L_0x0006:
        r14 = r19.next();
        r15 = 3;
        if (r14 != r15) goto L_0x0013;
    L_0x000d:
        r15 = r19.getDepth();
        if (r15 <= r7) goto L_0x00a5;
    L_0x0013:
        r15 = 1;
        if (r14 == r15) goto L_0x00a5;
    L_0x0016:
        r15 = 2;
        if (r14 != r15) goto L_0x0006;
    L_0x0019:
        r11 = r19.getName();
        r15 = "objectAnimator";
        r15 = r11.equals(r15);
        if (r15 == 0) goto L_0x003a;
    L_0x0025:
        r0 = r18;
        r1 = r20;
        r4 = loadObjectAnimator(r0, r1);
    L_0x002d:
        if (r21 == 0) goto L_0x0006;
    L_0x002f:
        if (r6 != 0) goto L_0x0036;
    L_0x0031:
        r6 = new java.util.ArrayList;
        r6.<init>();
    L_0x0036:
        r6.add(r4);
        goto L_0x0006;
    L_0x003a:
        r15 = "animator";
        r15 = r11.equals(r15);
        if (r15 == 0) goto L_0x004c;
    L_0x0042:
        r15 = 0;
        r0 = r18;
        r1 = r20;
        r4 = loadAnimator(r0, r1, r15);
        goto L_0x002d;
    L_0x004c:
        r15 = "set";
        r15 = r11.equals(r15);
        if (r15 == 0) goto L_0x0088;
    L_0x0054:
        r4 = new com.nineoldandroids.animation.AnimatorSet;
        r4.<init>();
        r15 = AnimatorSet;
        r0 = r18;
        r1 = r20;
        r3 = r0.obtainStyledAttributes(r1, r15);
        r13 = new android.util.TypedValue;
        r13.<init>();
        r15 = 0;
        r3.getValue(r15, r13);
        r15 = r13.type;
        r16 = 16;
        r0 = r16;
        if (r15 != r0) goto L_0x0086;
    L_0x0074:
        r12 = r13.data;
    L_0x0076:
        r15 = r4;
        r15 = (com.nineoldandroids.animation.AnimatorSet) r15;
        r0 = r18;
        r1 = r19;
        r2 = r20;
        createAnimatorFromXml(r0, r1, r2, r15, r12);
        r3.recycle();
        goto L_0x002d;
    L_0x0086:
        r12 = 0;
        goto L_0x0076;
    L_0x0088:
        r15 = new java.lang.RuntimeException;
        r16 = new java.lang.StringBuilder;
        r16.<init>();
        r17 = "Unknown animator name: ";
        r16 = r16.append(r17);
        r17 = r19.getName();
        r16 = r16.append(r17);
        r16 = r16.toString();
        r15.<init>(r16);
        throw r15;
    L_0x00a5:
        if (r21 == 0) goto L_0x00cd;
    L_0x00a7:
        if (r6 == 0) goto L_0x00cd;
    L_0x00a9:
        r15 = r6.size();
        r5 = new com.nineoldandroids.animation.Animator[r15];
        r9 = 0;
        r8 = r6.iterator();
    L_0x00b4:
        r15 = r8.hasNext();
        if (r15 == 0) goto L_0x00c6;
    L_0x00ba:
        r3 = r8.next();
        r3 = (com.nineoldandroids.animation.Animator) r3;
        r10 = r9 + 1;
        r5[r9] = r3;
        r9 = r10;
        goto L_0x00b4;
    L_0x00c6:
        if (r22 != 0) goto L_0x00ce;
    L_0x00c8:
        r0 = r21;
        r0.playTogether(r5);
    L_0x00cd:
        return r4;
    L_0x00ce:
        r0 = r21;
        r0.playSequentially(r5);
        goto L_0x00cd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.AnimatorInflater.createAnimatorFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, com.nineoldandroids.animation.AnimatorSet, int):com.nineoldandroids.animation.Animator");
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attrs) throws NotFoundException {
        ObjectAnimator anim = new ObjectAnimator();
        loadAnimator(context, attrs, anim);
        TypedArray a = context.obtainStyledAttributes(attrs, PropertyAnimator);
        anim.setPropertyName(a.getString(Animator_interpolator));
        a.recycle();
        return anim;
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attrs, ValueAnimator anim) throws NotFoundException {
        TypedArray a = context.obtainStyledAttributes(attrs, Animator);
        long duration = (long) a.getInt(Animator_duration, Animator_interpolator);
        long startDelay = (long) a.getInt(Animator_startOffset, Animator_interpolator);
        int valueType = a.getInt(Animator_valueType, Animator_interpolator);
        if (anim == null) {
            anim = new ValueAnimator();
        }
        boolean getFloats = valueType == 0;
        TypedValue tvFrom = a.peekValue(Animator_valueFrom);
        boolean hasFrom = tvFrom != null;
        int fromType = hasFrom ? tvFrom.type : Animator_interpolator;
        TypedValue tvTo = a.peekValue(Animator_valueTo);
        boolean hasTo = tvTo != null;
        int toType = hasTo ? tvTo.type : Animator_interpolator;
        if ((hasFrom && fromType >= 28 && fromType <= 31) || (hasTo && toType >= 28 && toType <= 31)) {
            getFloats = false;
            anim.setEvaluator(new ArgbEvaluator());
        }
        if (getFloats) {
            float valueTo;
            float[] fArr;
            if (hasFrom) {
                float valueFrom;
                if (fromType == Animator_valueFrom) {
                    valueFrom = a.getDimension(Animator_valueFrom, 0.0f);
                } else {
                    valueFrom = a.getFloat(Animator_valueFrom, 0.0f);
                }
                if (hasTo) {
                    if (toType == Animator_valueFrom) {
                        valueTo = a.getDimension(Animator_valueTo, 0.0f);
                    } else {
                        valueTo = a.getFloat(Animator_valueTo, 0.0f);
                    }
                    fArr = new float[Animator_startOffset];
                    fArr[Animator_interpolator] = valueFrom;
                    fArr[Animator_duration] = valueTo;
                    anim.setFloatValues(fArr);
                } else {
                    fArr = new float[Animator_duration];
                    fArr[Animator_interpolator] = valueFrom;
                    anim.setFloatValues(fArr);
                }
            } else {
                if (toType == Animator_valueFrom) {
                    valueTo = a.getDimension(Animator_valueTo, 0.0f);
                } else {
                    valueTo = a.getFloat(Animator_valueTo, 0.0f);
                }
                fArr = new float[Animator_duration];
                fArr[Animator_interpolator] = valueTo;
                anim.setFloatValues(fArr);
            }
        } else if (hasFrom) {
            int valueFrom2;
            if (fromType == Animator_valueFrom) {
                valueFrom2 = (int) a.getDimension(Animator_valueFrom, 0.0f);
            } else if (fromType < 28 || fromType > 31) {
                valueFrom2 = a.getInt(Animator_valueFrom, Animator_interpolator);
            } else {
                valueFrom2 = a.getColor(Animator_valueFrom, Animator_interpolator);
            }
            if (hasTo) {
                if (toType == Animator_valueFrom) {
                    valueTo = (int) a.getDimension(Animator_valueTo, 0.0f);
                } else if (toType < 28 || toType > 31) {
                    valueTo = a.getInt(Animator_valueTo, Animator_interpolator);
                } else {
                    valueTo = a.getColor(Animator_valueTo, Animator_interpolator);
                }
                r22 = new int[Animator_startOffset];
                r22[Animator_interpolator] = valueFrom2;
                r22[Animator_duration] = valueTo;
                anim.setIntValues(r22);
            } else {
                r22 = new int[Animator_duration];
                r22[Animator_interpolator] = valueFrom2;
                anim.setIntValues(r22);
            }
        } else if (hasTo) {
            if (toType == Animator_valueFrom) {
                valueTo = (int) a.getDimension(Animator_valueTo, 0.0f);
            } else if (toType < 28 || toType > 31) {
                valueTo = a.getInt(Animator_valueTo, Animator_interpolator);
            } else {
                valueTo = a.getColor(Animator_valueTo, Animator_interpolator);
            }
            r22 = new int[Animator_duration];
            r22[Animator_interpolator] = valueTo;
            anim.setIntValues(r22);
        }
        anim.setDuration(duration);
        anim.setStartDelay(startDelay);
        if (a.hasValue(Animator_repeatCount)) {
            anim.setRepeatCount(a.getInt(Animator_repeatCount, Animator_interpolator));
        }
        if (a.hasValue(Animator_repeatMode)) {
            anim.setRepeatMode(a.getInt(Animator_repeatMode, Animator_duration));
        }
        int resID = a.getResourceId(Animator_interpolator, Animator_interpolator);
        if (resID > 0) {
            anim.setInterpolator(AnimationUtils.loadInterpolator(context, resID));
        }
        a.recycle();
        return anim;
    }
}
