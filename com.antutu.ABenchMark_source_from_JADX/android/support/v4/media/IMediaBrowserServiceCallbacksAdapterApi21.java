package android.support.v4.media;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class IMediaBrowserServiceCallbacksAdapterApi21 {
    private Method mAsBinderMethod;
    Object mCallbackObject;
    private Method mOnConnectFailedMethod;
    private Method mOnConnectMethod;
    private Method mOnLoadChildrenMethod;

    static class Stub {
        static Method sAsInterfaceMethod;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static {
            /*
            r0 = "android.service.media.IMediaBrowserServiceCallbacks$Stub";
            r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0017, NoSuchMethodException -> 0x001c }
            r1 = "asInterface";
            r2 = 1;
            r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0017, NoSuchMethodException -> 0x001c }
            r3 = 0;
            r4 = android.os.IBinder.class;
            r2[r3] = r4;	 Catch:{ ClassNotFoundException -> 0x0017, NoSuchMethodException -> 0x001c }
            r0 = r0.getMethod(r1, r2);	 Catch:{ ClassNotFoundException -> 0x0017, NoSuchMethodException -> 0x001c }
            sAsInterfaceMethod = r0;	 Catch:{ ClassNotFoundException -> 0x0017, NoSuchMethodException -> 0x001c }
        L_0x0016:
            return;
        L_0x0017:
            r0 = move-exception;
        L_0x0018:
            r0.printStackTrace();
            goto L_0x0016;
        L_0x001c:
            r0 = move-exception;
            goto L_0x0018;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.Stub.<clinit>():void");
        }

        Stub() {
        }

        static Object asInterface(IBinder iBinder) {
            ReflectiveOperationException e;
            try {
                return sAsInterfaceMethod.invoke(null, new Object[]{iBinder});
            } catch (IllegalAccessException e2) {
                e = e2;
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e = e3;
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    IMediaBrowserServiceCallbacksAdapterApi21(java.lang.Object r7) {
        /*
        r6 = this;
        r6.<init>();
        r6.mCallbackObject = r7;
        r0 = "android.service.media.IMediaBrowserServiceCallbacks";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r1 = "android.content.pm.ParceledListSlice";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r2 = "asBinder";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r2 = r0.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r6.mAsBinderMethod = r2;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r2 = "onConnect";
        r3 = 3;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r4 = 0;
        r5 = java.lang.String.class;
        r3[r4] = r5;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r4 = 1;
        r5 = android.media.session.MediaSession.Token.class;
        r3[r4] = r5;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r4 = 2;
        r5 = android.os.Bundle.class;
        r3[r4] = r5;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r2 = r0.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r6.mOnConnectMethod = r2;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r2 = "onConnectFailed";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r2 = r0.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r6.mOnConnectFailedMethod = r2;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r2 = "onLoadChildren";
        r3 = 2;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r4 = 0;
        r5 = java.lang.String.class;
        r3[r4] = r5;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r4 = 1;
        r3[r4] = r1;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r0 = r0.getMethod(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
        r6.mOnLoadChildrenMethod = r0;	 Catch:{ ClassNotFoundException -> 0x0055, NoSuchMethodException -> 0x005a }
    L_0x0054:
        return;
    L_0x0055:
        r0 = move-exception;
    L_0x0056:
        r0.printStackTrace();
        goto L_0x0054;
    L_0x005a:
        r0 = move-exception;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.<init>(java.lang.Object):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.os.IBinder asBinder() {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.mAsBinderMethod;	 Catch:{ IllegalAccessException -> 0x000f, InvocationTargetException -> 0x0015 }
        r2 = r4.mCallbackObject;	 Catch:{ IllegalAccessException -> 0x000f, InvocationTargetException -> 0x0015 }
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x000f, InvocationTargetException -> 0x0015 }
        r0 = r0.invoke(r2, r3);	 Catch:{ IllegalAccessException -> 0x000f, InvocationTargetException -> 0x0015 }
        r0 = (android.os.IBinder) r0;	 Catch:{ IllegalAccessException -> 0x000f, InvocationTargetException -> 0x0015 }
    L_0x000e:
        return r0;
    L_0x000f:
        r0 = move-exception;
    L_0x0010:
        r0.printStackTrace();
        r0 = r1;
        goto L_0x000e;
    L_0x0015:
        r0 = move-exception;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.asBinder():android.os.IBinder");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void onConnect(java.lang.String r5, java.lang.Object r6, android.os.Bundle r7) {
        /*
        r4 = this;
        r0 = r4.mOnConnectMethod;	 Catch:{ IllegalAccessException -> 0x0014, InvocationTargetException -> 0x0019 }
        r1 = r4.mCallbackObject;	 Catch:{ IllegalAccessException -> 0x0014, InvocationTargetException -> 0x0019 }
        r2 = 3;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x0014, InvocationTargetException -> 0x0019 }
        r3 = 0;
        r2[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0014, InvocationTargetException -> 0x0019 }
        r3 = 1;
        r2[r3] = r6;	 Catch:{ IllegalAccessException -> 0x0014, InvocationTargetException -> 0x0019 }
        r3 = 2;
        r2[r3] = r7;	 Catch:{ IllegalAccessException -> 0x0014, InvocationTargetException -> 0x0019 }
        r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x0014, InvocationTargetException -> 0x0019 }
    L_0x0013:
        return;
    L_0x0014:
        r0 = move-exception;
    L_0x0015:
        r0.printStackTrace();
        goto L_0x0013;
    L_0x0019:
        r0 = move-exception;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.onConnect(java.lang.String, java.lang.Object, android.os.Bundle):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void onConnectFailed() {
        /*
        r3 = this;
        r0 = r3.mOnConnectFailedMethod;	 Catch:{ IllegalAccessException -> 0x000b, InvocationTargetException -> 0x0010 }
        r1 = r3.mCallbackObject;	 Catch:{ IllegalAccessException -> 0x000b, InvocationTargetException -> 0x0010 }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x000b, InvocationTargetException -> 0x0010 }
        r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x000b, InvocationTargetException -> 0x0010 }
    L_0x000a:
        return;
    L_0x000b:
        r0 = move-exception;
    L_0x000c:
        r0.printStackTrace();
        goto L_0x000a;
    L_0x0010:
        r0 = move-exception;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.onConnectFailed():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void onLoadChildren(java.lang.String r5, java.lang.Object r6) {
        /*
        r4 = this;
        r0 = r4.mOnLoadChildrenMethod;	 Catch:{ IllegalAccessException -> 0x0011, InvocationTargetException -> 0x0016 }
        r1 = r4.mCallbackObject;	 Catch:{ IllegalAccessException -> 0x0011, InvocationTargetException -> 0x0016 }
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x0011, InvocationTargetException -> 0x0016 }
        r3 = 0;
        r2[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0011, InvocationTargetException -> 0x0016 }
        r3 = 1;
        r2[r3] = r6;	 Catch:{ IllegalAccessException -> 0x0011, InvocationTargetException -> 0x0016 }
        r0.invoke(r1, r2);	 Catch:{ IllegalAccessException -> 0x0011, InvocationTargetException -> 0x0016 }
    L_0x0010:
        return;
    L_0x0011:
        r0 = move-exception;
    L_0x0012:
        r0.printStackTrace();
        goto L_0x0010;
    L_0x0016:
        r0 = move-exception;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.onLoadChildren(java.lang.String, java.lang.Object):void");
    }
}
