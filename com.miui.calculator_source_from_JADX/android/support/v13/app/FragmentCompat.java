package android.support.v13.app;

import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import java.util.Arrays;

public class FragmentCompat {
    static final FragmentCompatImpl f3a;

    interface FragmentCompatImpl {
    }

    static class BaseFragmentCompatImpl implements FragmentCompatImpl {

        /* renamed from: android.support.v13.app.FragmentCompat.BaseFragmentCompatImpl.1 */
        class C00001 implements Runnable {
            final /* synthetic */ String[] f0a;
            final /* synthetic */ Fragment f1b;
            final /* synthetic */ int f2c;

            public void run() {
                int[] iArr = new int[this.f0a.length];
                Context activity = this.f1b.getActivity();
                if (activity != null) {
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = this.f0a.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(this.f0a[i], packageName);
                    }
                } else {
                    Arrays.fill(iArr, -1);
                }
                ((OnRequestPermissionsResultCallback) this.f1b).m0a(this.f2c, this.f0a, iArr);
            }
        }

        BaseFragmentCompatImpl() {
        }
    }

    static class ICSFragmentCompatImpl extends BaseFragmentCompatImpl {
        ICSFragmentCompatImpl() {
        }
    }

    static class ICSMR1FragmentCompatImpl extends ICSFragmentCompatImpl {
        ICSMR1FragmentCompatImpl() {
        }
    }

    static class MncFragmentCompatImpl extends ICSMR1FragmentCompatImpl {
        MncFragmentCompatImpl() {
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void m0a(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f3a = new MncFragmentCompatImpl();
        } else if (VERSION.SDK_INT >= 15) {
            f3a = new ICSMR1FragmentCompatImpl();
        } else if (VERSION.SDK_INT >= 14) {
            f3a = new ICSFragmentCompatImpl();
        } else {
            f3a = new BaseFragmentCompatImpl();
        }
    }
}
