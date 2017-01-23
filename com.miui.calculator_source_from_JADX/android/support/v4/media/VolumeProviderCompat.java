package android.support.v4.media;

import android.support.v4.media.VolumeProviderCompatApi21.Delegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    private final int f532a;
    private final int f533b;
    private int f534c;

    /* renamed from: android.support.v4.media.VolumeProviderCompat.1 */
    class C00521 implements Delegate {
        final /* synthetic */ VolumeProviderCompat f531a;

        public void m711a(int i) {
            this.f531a.m714a(i);
        }

        public void m712b(int i) {
            this.f531a.m716b(i);
        }
    }

    public static abstract class Callback {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public final int m713a() {
        return this.f534c;
    }

    public final int m715b() {
        return this.f532a;
    }

    public final int m717c() {
        return this.f533b;
    }

    public void m714a(int i) {
    }

    public void m716b(int i) {
    }
}
