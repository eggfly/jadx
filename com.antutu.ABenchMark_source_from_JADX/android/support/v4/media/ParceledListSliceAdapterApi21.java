package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "android.content.pm.ParceledListSlice";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0015, NoSuchMethodException -> 0x001a }
        r1 = 1;
        r1 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0015, NoSuchMethodException -> 0x001a }
        r2 = 0;
        r3 = java.util.List.class;
        r1[r2] = r3;	 Catch:{ ClassNotFoundException -> 0x0015, NoSuchMethodException -> 0x001a }
        r0 = r0.getConstructor(r1);	 Catch:{ ClassNotFoundException -> 0x0015, NoSuchMethodException -> 0x001a }
        sConstructor = r0;	 Catch:{ ClassNotFoundException -> 0x0015, NoSuchMethodException -> 0x001a }
    L_0x0014:
        return;
    L_0x0015:
        r0 = move-exception;
    L_0x0016:
        r0.printStackTrace();
        goto L_0x0014;
    L_0x001a:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.ParceledListSliceAdapterApi21.<clinit>():void");
    }

    ParceledListSliceAdapterApi21() {
    }

    static Object newInstance(List<MediaItem> list) {
        ReflectiveOperationException e;
        try {
            return sConstructor.newInstance(new Object[]{list});
        } catch (InstantiationException e2) {
            e = e2;
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e = e4;
            e.printStackTrace();
            return null;
        }
    }
}
