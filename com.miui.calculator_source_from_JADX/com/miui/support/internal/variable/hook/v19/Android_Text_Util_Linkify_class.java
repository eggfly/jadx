package com.miui.support.internal.variable.hook.v19;

import android.text.Spannable;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import com.miui.support.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Android_Text_Util_Linkify_class extends com.miui.support.internal.variable.hook.v16.Android_Text_Util_Linkify_class {
    protected static final Method mGatherTelLinks;

    static {
        mGatherTelLinks = Method.of(Linkify.class, "gatherTelLinks", "(Ljava/util/ArrayList;Landroid/text/Spannable;)V");
    }

    public void gatherTelLinks(ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        mGatherTelLinks.invoke(null, null, arrayList, spannable);
    }
}
