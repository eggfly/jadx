package android.support.v4.net;

import android.os.Build.VERSION;

public class ConnectivityManagerCompat {
    private static final ConnectivityManagerCompatImpl f626a;

    interface ConnectivityManagerCompatImpl {
    }

    static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        BaseConnectivityManagerCompatImpl() {
        }
    }

    static class GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        GingerbreadConnectivityManagerCompatImpl() {
        }
    }

    static class HoneycombMR2ConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        HoneycombMR2ConnectivityManagerCompatImpl() {
        }
    }

    static class JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        JellyBeanConnectivityManagerCompatImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f626a = new JellyBeanConnectivityManagerCompatImpl();
        } else if (VERSION.SDK_INT >= 13) {
            f626a = new HoneycombMR2ConnectivityManagerCompatImpl();
        } else if (VERSION.SDK_INT >= 8) {
            f626a = new GingerbreadConnectivityManagerCompatImpl();
        } else {
            f626a = new BaseConnectivityManagerCompatImpl();
        }
    }
}
