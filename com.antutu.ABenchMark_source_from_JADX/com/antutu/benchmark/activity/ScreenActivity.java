package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.utils.PointMark;
import com.antutu.utils.widget.SystemBarTintManager;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;

public class ScreenActivity extends C1197a {
    LinearLayout f4429a;
    private C1294a f4430b;
    private int f4431c;
    private int[] f4432d;

    /* renamed from: com.antutu.benchmark.activity.ScreenActivity.1 */
    class C12931 implements OnTouchListener {
        final /* synthetic */ ScreenActivity f4427a;

        C12931(ScreenActivity screenActivity) {
            this.f4427a = screenActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4427a.f4431c < this.f4427a.f4432d.length) {
                this.f4427a.f4430b.removeMessages(0);
                this.f4427a.m5257a();
            }
            return false;
        }
    }

    /* renamed from: com.antutu.benchmark.activity.ScreenActivity.a */
    private class C1294a extends Handler {
        final /* synthetic */ ScreenActivity f4428a;

        private C1294a(ScreenActivity screenActivity) {
            this.f4428a = screenActivity;
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.f4428a.m5257a();
            } else {
                this.f4428a.finish();
            }
        }
    }

    public ScreenActivity() {
        this.f4432d = new int[]{SupportMenu.CATEGORY_MASK, -16776961, -16711936, SystemBarTintManager.DEFAULT_TINT_COLOR, -7829368, -1};
    }

    private void m5257a() {
        LinearLayout linearLayout = this.f4429a;
        int[] iArr = this.f4432d;
        int i = this.f4431c;
        this.f4431c = i + 1;
        linearLayout.setBackgroundColor(iArr[i]);
        if (this.f4431c < this.f4432d.length) {
            this.f4430b.sendEmptyMessageDelayed(0, 5000);
            return;
        }
        Toast.makeText(this, C1082R.string.screen_finish, 0).show();
        this.f4430b.sendEmptyMessageDelayed(1, 2000);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PointMark.getInstance(this).pointThis(PointMark.K_SCREEN);
        this.f4429a = new LinearLayout(this);
        setTheme(16973833);
        getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        this.f4429a.setLayoutParams(new LayoutParams(-1, -1));
        this.f4429a.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        setContentView(this.f4429a);
        this.f4429a.setOnTouchListener(new C12931(this));
        this.f4430b = new C1294a();
        this.f4431c = 0;
        LinearLayout linearLayout = this.f4429a;
        int[] iArr = this.f4432d;
        int i = this.f4431c;
        this.f4431c = i + 1;
        linearLayout.setBackgroundColor(iArr[i]);
        this.f4430b.sendEmptyMessageDelayed(0, 5000);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f4430b.removeMessages(0);
        this.f4430b.removeMessages(1);
    }
}
