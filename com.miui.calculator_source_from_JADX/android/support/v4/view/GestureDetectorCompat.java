package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class GestureDetectorCompat {

    interface GestureDetectorCompatImpl {
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int f760a;
        private static final int f761b;
        private static final int f762c;
        private final Handler f763d;
        private final OnGestureListener f764e;
        private OnDoubleTapListener f765f;
        private boolean f766g;
        private boolean f767h;
        private boolean f768i;
        private MotionEvent f769j;

        private class GestureHandler extends Handler {
            final /* synthetic */ GestureDetectorCompatImplBase f759a;

            public void handleMessage(Message message) {
                switch (message.what) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        this.f759a.f764e.onShowPress(this.f759a.f769j);
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        this.f759a.m1212a();
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        if (this.f759a.f765f == null) {
                            return;
                        }
                        if (this.f759a.f766g) {
                            this.f759a.f767h = true;
                        } else {
                            this.f759a.f765f.onSingleTapConfirmed(this.f759a.f769j);
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        static {
            f760a = ViewConfiguration.getLongPressTimeout();
            f761b = ViewConfiguration.getTapTimeout();
            f762c = ViewConfiguration.getDoubleTapTimeout();
        }

        private void m1212a() {
            this.f763d.removeMessages(3);
            this.f767h = false;
            this.f768i = true;
            this.f764e.onLongPress(this.f769j);
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
    }
}
