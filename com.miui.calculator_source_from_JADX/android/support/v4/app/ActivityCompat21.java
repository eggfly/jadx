package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

class ActivityCompat21 {

    public static abstract class SharedElementCallback21 {
        public abstract Parcelable m64a(View view, Matrix matrix, RectF rectF);

        public abstract View m65a(Context context, Parcelable parcelable);

        public abstract void m66a(List<View> list);

        public abstract void m67a(List<String> list, List<View> list2, List<View> list3);

        public abstract void m68a(List<String> list, Map<String, View> map);

        public abstract void m69b(List<String> list, List<View> list2, List<View> list3);
    }

    private static class SharedElementCallbackImpl extends SharedElementCallback {
        private SharedElementCallback21 f56a;

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f56a.m67a((List) list, (List) list2, (List) list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f56a.m69b(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f56a.m66a(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f56a.m68a((List) list, (Map) map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f56a.m64a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f56a.m65a(context, parcelable);
        }
    }

    ActivityCompat21() {
    }

    public static void m76a(Activity activity) {
        activity.finishAfterTransition();
    }
}
