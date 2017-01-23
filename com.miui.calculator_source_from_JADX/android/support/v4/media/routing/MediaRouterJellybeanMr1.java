package android.support.v4.media.routing;

import android.hardware.display.DisplayManager;
import android.media.MediaRouter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.Method;

class MediaRouterJellybeanMr1 extends MediaRouterJellybean {

    public static final class ActiveScanWorkaround implements Runnable {
        private final DisplayManager f540a;
        private final Handler f541b;
        private Method f542c;
        private boolean f543d;

        public void run() {
            if (this.f543d) {
                try {
                    this.f542c.invoke(this.f540a, new Object[0]);
                } catch (Throwable e) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e);
                } catch (Throwable e2) {
                    Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", e2);
                }
                this.f541b.postDelayed(this, 15000);
            }
        }
    }

    public interface Callback extends android.support.v4.media.routing.MediaRouterJellybean.Callback {
        void m728e(Object obj);
    }

    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            ((Callback) this.a).m728e(routeInfo);
        }
    }

    public static final class IsConnectingWorkaround {
        private Method f544a;
        private int f545b;

        public IsConnectingWorkaround() {
            if (VERSION.SDK_INT != 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f545b = android.media.MediaRouter.RouteInfo.class.getField("STATUS_CONNECTING").getInt(null);
                this.f544a = android.media.MediaRouter.RouteInfo.class.getMethod("getStatusCode", new Class[0]);
            } catch (NoSuchFieldException e) {
            } catch (NoSuchMethodException e2) {
            } catch (IllegalAccessException e3) {
            }
        }
    }

    public static final class RouteInfo {
    }

    MediaRouterJellybeanMr1() {
    }
}
