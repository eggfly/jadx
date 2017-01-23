package android.support.v4.media.routing;

import android.media.MediaRouter;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

class MediaRouterJellybean {

    public interface Callback {
        void m718a(int i, Object obj);

        void m719a(Object obj);

        void m720a(Object obj, Object obj2);

        void m721a(Object obj, Object obj2, int i);

        void m722b(int i, Object obj);

        void m723b(Object obj);

        void m724c(Object obj);

        void m725d(Object obj);
    }

    static class CallbackProxy<T extends Callback> extends android.media.MediaRouter.Callback {
        protected final T f536a;

        public void onRouteSelected(MediaRouter mediaRouter, int i, android.media.MediaRouter.RouteInfo routeInfo) {
            this.f536a.m718a(i, (Object) routeInfo);
        }

        public void onRouteUnselected(MediaRouter mediaRouter, int i, android.media.MediaRouter.RouteInfo routeInfo) {
            this.f536a.m722b(i, routeInfo);
        }

        public void onRouteAdded(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            this.f536a.m719a(routeInfo);
        }

        public void onRouteRemoved(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            this.f536a.m723b(routeInfo);
        }

        public void onRouteChanged(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            this.f536a.m724c(routeInfo);
        }

        public void onRouteGrouped(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo, android.media.MediaRouter.RouteGroup routeGroup, int i) {
            this.f536a.m721a(routeInfo, routeGroup, i);
        }

        public void onRouteUngrouped(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo, android.media.MediaRouter.RouteGroup routeGroup) {
            this.f536a.m720a((Object) routeInfo, (Object) routeGroup);
        }

        public void onRouteVolumeChanged(MediaRouter mediaRouter, android.media.MediaRouter.RouteInfo routeInfo) {
            this.f536a.m725d(routeInfo);
        }
    }

    public static final class GetDefaultRouteWorkaround {
        private Method f537a;

        public GetDefaultRouteWorkaround() {
            if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f537a = MediaRouter.class.getMethod("getSystemAudioRoute", new Class[0]);
            } catch (NoSuchMethodException e) {
            }
        }
    }

    public static final class RouteCategory {
    }

    public static final class RouteGroup {
    }

    public static final class RouteInfo {
    }

    public static final class SelectRouteWorkaround {
        private Method f538a;

        public SelectRouteWorkaround() {
            if (VERSION.SDK_INT < 16 || VERSION.SDK_INT > 17) {
                throw new UnsupportedOperationException();
            }
            try {
                this.f538a = MediaRouter.class.getMethod("selectRouteInt", new Class[]{Integer.TYPE, android.media.MediaRouter.RouteInfo.class});
            } catch (NoSuchMethodException e) {
            }
        }
    }

    public static final class UserRouteInfo {
    }

    public interface VolumeCallback {
        void m726a(Object obj, int i);

        void m727b(Object obj, int i);
    }

    static class VolumeCallbackProxy<T extends VolumeCallback> extends android.media.MediaRouter.VolumeCallback {
        protected final T f539a;

        public void onVolumeSetRequest(android.media.MediaRouter.RouteInfo routeInfo, int i) {
            this.f539a.m726a(routeInfo, i);
        }

        public void onVolumeUpdateRequest(android.media.MediaRouter.RouteInfo routeInfo, int i) {
            this.f539a.m727b(routeInfo, i);
        }
    }

    MediaRouterJellybean() {
    }
}
