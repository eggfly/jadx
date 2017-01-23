package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput.Factory;

public class RemoteInput extends android.support.v4.app.RemoteInputCompatBase.RemoteInput {
    public static final Factory f375a;
    private static final Impl f376b;

    /* renamed from: android.support.v4.app.RemoteInput.1 */
    final class C00341 implements Factory {
        C00341() {
        }
    }

    public static final class Builder {
    }

    interface Impl {
    }

    static class ImplApi20 implements Impl {
        ImplApi20() {
        }
    }

    static class ImplBase implements Impl {
        ImplBase() {
        }
    }

    static class ImplJellybean implements Impl {
        ImplJellybean() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f376b = new ImplApi20();
        } else if (VERSION.SDK_INT >= 16) {
            f376b = new ImplJellybean();
        } else {
            f376b = new ImplBase();
        }
        f375a = new C00341();
    }
}
