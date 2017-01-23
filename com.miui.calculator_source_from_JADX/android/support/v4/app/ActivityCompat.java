package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat21.SharedElementCallback21;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {

    /* renamed from: android.support.v4.app.ActivityCompat.1 */
    final class C00061 implements Runnable {
        final /* synthetic */ String[] f52a;
        final /* synthetic */ Activity f53b;
        final /* synthetic */ int f54c;

        C00061(String[] strArr, Activity activity, int i) {
            this.f52a = strArr;
            this.f53b = activity;
            this.f54c = i;
        }

        public void run() {
            int[] iArr = new int[this.f52a.length];
            PackageManager packageManager = this.f53b.getPackageManager();
            String packageName = this.f53b.getPackageName();
            int length = this.f52a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f52a[i], packageName);
            }
            ((OnRequestPermissionsResultCallback) this.f53b).onRequestPermissionsResult(this.f54c, this.f52a, iArr);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    private static class SharedElementCallback21Impl extends SharedElementCallback21 {
        private SharedElementCallback f55a;

        public void m73a(List<String> list, List<View> list2, List<View> list3) {
            this.f55a.m488a((List) list, (List) list2, (List) list3);
        }

        public void m75b(List<String> list, List<View> list2, List<View> list3) {
            this.f55a.m490b(list, list2, list3);
        }

        public void m72a(List<View> list) {
            this.f55a.m487a((List) list);
        }

        public void m74a(List<String> list, Map<String, View> map) {
            this.f55a.m489a((List) list, (Map) map);
        }

        public Parcelable m70a(View view, Matrix matrix, RectF rectF) {
            return this.f55a.m485a(view, matrix, rectF);
        }

        public View m71a(Context context, Parcelable parcelable) {
            return this.f55a.m486a(context, parcelable);
        }
    }

    public static void m79a(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.m76a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m80a(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        if (VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.m82a(activity, strArr, i);
        } else if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new C00061(strArr, activity, i));
        }
    }
}
