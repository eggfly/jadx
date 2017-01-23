package com.miui.support.internal.variable.hook.v16;

import android.text.Spannable;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.util.Patterns;
import com.miui.support.reflect.Field;
import com.miui.support.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Android_Text_Util_Linkify_class extends com.miui.support.internal.variable.hook.Android_Text_Util_Linkify_class {
    protected static final Method mApplyLink;
    protected static final Field mEnd;
    protected static final Method mGatherLinks;
    protected static final Method mGatherMapLinks;
    protected static final Method mPruneOverlaps;
    protected static final Field mStart;
    protected static final Field mUrl;

    static {
        mGatherLinks = Method.of(Linkify.class, "gatherLinks", "(Ljava/util/ArrayList;Landroid/text/Spannable;Ljava/util/regex/Pattern;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V");
        mGatherMapLinks = Method.of(Linkify.class, "gatherMapLinks", "(Ljava/util/ArrayList;Landroid/text/Spannable;)V");
        mPruneOverlaps = Method.of(Linkify.class, "pruneOverlaps", "(Ljava/util/ArrayList;)V");
        mApplyLink = Method.of(Linkify.class, "applyLink", "(Ljava/lang/String;IILandroid/text/Spannable;)V");
        mUrl = Field.of("android.text.util.LinkSpec", "url", "Ljava/lang/String;");
        mStart = Field.of("android.text.util.LinkSpec", "start", Field.INT_SIGNATURE_PRIMITIVE);
        mEnd = Field.of("android.text.util.LinkSpec", "end", Field.INT_SIGNATURE_PRIMITIVE);
    }

    public void buildProxy() {
        attachMethod("addLinks", "(Landroid/text/Spannable;I)Z");
        super.buildProxy();
    }

    protected void handle() {
        handleAddLinks(0, null, null, 0);
    }

    protected boolean handleAddLinks(long j, Linkify linkify, Spannable spannable, int i) {
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList arrayList = new ArrayList();
        if ((com.miui.support.text.util.Linkify.f3598a & i) != 0) {
            Method method = mGatherLinks;
            r4 = new Object[6];
            r4[3] = new String[]{"time:"};
            r4[4] = null;
            r4[5] = null;
            method.invoke(null, null, r4);
            method = mGatherLinks;
            r4 = new Object[6];
            r4[3] = new String[]{"time:"};
            r4[4] = null;
            r4[5] = null;
            method.invoke(null, null, r4);
        }
        if ((i & 1) != 0) {
            method = mGatherLinks;
            r4 = new Object[6];
            r4[3] = new String[]{"http://", "https://", "rtsp://"};
            r4[4] = Linkify.sUrlMatchFilter;
            r4[5] = null;
            method.invoke(null, null, r4);
        }
        if ((i & 2) != 0) {
            method = mGatherLinks;
            r4 = new Object[6];
            r4[3] = new String[]{"mailto:"};
            r4[4] = null;
            r4[5] = null;
            method.invoke(null, null, r4);
        }
        if ((i & 4) != 0) {
            Spannable spannable2 = spannable;
            gatherTelLinks(arrayList, spannable2, Patterns.PHONE, new String[]{"tel:"}, Linkify.sPhoneNumberMatchFilter, Linkify.sPhoneNumberTransformFilter);
        }
        if ((i & 8) != 0) {
            mGatherMapLinks.invoke(null, null, arrayList, spannable);
        }
        mPruneOverlaps.invoke(null, null, arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            mApplyLink.invoke(null, null, (String) mUrl.get(obj), Integer.valueOf(mStart.getInt(obj)), Integer.valueOf(mEnd.getInt(obj)), spannable);
        }
        return true;
    }

    protected boolean originalAddLinks(long j, Linkify linkify, Spannable spannable, int i) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Text_Util_Linkify_class.originalAddLinks(long, Linkify, Spannable, int)");
    }

    protected void gatherTelLinks(ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        Method method = mGatherLinks;
        r1 = new Object[6];
        r1[3] = new String[]{"tel:"};
        r1[4] = Linkify.sPhoneNumberMatchFilter;
        r1[5] = Linkify.sPhoneNumberTransformFilter;
        method.invoke(null, null, r1);
    }
}
