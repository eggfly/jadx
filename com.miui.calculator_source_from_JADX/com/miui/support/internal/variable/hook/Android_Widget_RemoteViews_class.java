package com.miui.support.internal.variable.hook;

import android.widget.RemoteViews;
import com.miui.support.C0234R;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.variable.AbsClassFactory;
import com.miui.support.util.SoftReferenceSingleton;

public abstract class Android_Widget_RemoteViews_class extends ClassProxy<RemoteViews> implements IManagedClassProxy {
    protected static final String PROCESS_NAME_SYSTEM_UI = "com.android.systemui";
    protected static final int REMOTE_VIEWS_TEMPLATE_THEME;

    public static class Factory extends AbsClassFactory {
        private static final SoftReferenceSingleton<Factory> INSTANCE;
        private Android_Widget_RemoteViews_class Android_Widget_RemoteViews_class;

        /* renamed from: com.miui.support.internal.variable.hook.Android_Widget_RemoteViews_class.Factory.1 */
        final class C03551 extends SoftReferenceSingleton<Factory> {
            C03551() {
            }

            protected Factory createInstance() {
                return new Factory();
            }
        }

        static {
            INSTANCE = new C03551();
        }

        private Factory() {
            this.Android_Widget_RemoteViews_class = (Android_Widget_RemoteViews_class) create("Android_Widget_RemoteViews_class");
        }

        public static Factory getInstance() {
            return (Factory) INSTANCE.get();
        }

        public Android_Widget_RemoteViews_class get() {
            return this.Android_Widget_RemoteViews_class;
        }
    }

    static {
        REMOTE_VIEWS_TEMPLATE_THEME = C0234R.style.Theme_Light_RemoteViews;
    }

    public Android_Widget_RemoteViews_class() {
        super(RemoteViews.class);
    }
}
