package android.support.v4.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21 {

    public interface Delegate {
        void m709a(int i);

        void m710b(int i);
    }

    /* renamed from: android.support.v4.media.VolumeProviderCompatApi21.1 */
    final class C00531 extends VolumeProvider {
        final /* synthetic */ Delegate f535a;

        public void onSetVolumeTo(int i) {
            this.f535a.m709a(i);
        }

        public void onAdjustVolume(int i) {
            this.f535a.m710b(i);
        }
    }

    VolumeProviderCompatApi21() {
    }
}
