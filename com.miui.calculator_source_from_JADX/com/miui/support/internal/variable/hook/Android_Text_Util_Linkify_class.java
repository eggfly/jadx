package com.miui.support.internal.variable.hook;

import android.text.Spannable;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.util.Patterns;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class Android_Text_Util_Linkify_class extends ClassProxy<Linkify> implements IManagedClassProxy {

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Text_Util_Linkify_class Android_Text_Util_Linkify_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Text_Util_Linkify_class.Factory.1 */
        final class C03391 extends SoftReferenceSingleton<Factory> {
            C03391() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03391();
        }

        private Factory() {
            this.Android_Text_Util_Linkify_class = (Android_Text_Util_Linkify_class) create("Android_Text_Util_Linkify_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Text_Util_Linkify_class get() {
            return this.Android_Text_Util_Linkify_class;
        }
    }

    public Android_Text_Util_Linkify_class() {
        super(Linkify.class);
    }

    public void buildProxy() {
        attachMethod("gatherLinks", "(Ljava/util/ArrayList;Landroid/text/Spannable;Ljava/util/regex/Pattern;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)V");
    }

    protected void handle() {
        handleGatherLinks(0, null, null, null, null, null, null, null);
    }

    protected void handleGatherLinks(long j, Linkify linkify, ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        Pattern pattern2;
        if (pattern == Patterns.WEB_URL) {
            pattern2 = com.miui.support.util.Patterns.f3693a;
        } else {
            pattern2 = pattern;
        }
        originalGatherLinks(j, linkify, arrayList, spannable, pattern2, strArr, matchFilter, transformFilter);
    }

    protected void originalGatherLinks(long j, Linkify linkify, ArrayList arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        throw new IllegalStateException("com.miui.internal.variable.hook.Android_Text_Util_Linkify_class.originalGatherLinks(long, Linkify, ArrayList, Spannable, Pattern, String[], MatchFilter, TransformFilter)");
    }
}
