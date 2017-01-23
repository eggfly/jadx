package com.antutu.redacc.service;

import android.app.Application;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1749f;
import com.antutu.redacc.p067f.C1753i;
import com.antutu.redacc.p067f.C1756m;
import com.umeng.message.entity.UMessage;

public class FxService extends Service {
    RelativeLayout f6225a;
    LayoutParams f6226b;
    WindowManager f6227c;
    Button f6228d;
    NotificationManager f6229e;
    private String f6230f;

    /* renamed from: com.antutu.redacc.service.FxService.1 */
    class C17631 implements OnTouchListener {
        final /* synthetic */ FxService f6222a;

        C17631(FxService fxService) {
            this.f6222a = fxService;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f6222a.f6226b.y = (((int) motionEvent.getRawY()) - (this.f6222a.f6225a.getMeasuredHeight() / 2)) - 40;
            this.f6222a.f6227c.updateViewLayout(this.f6222a.f6225a, this.f6222a.f6226b);
            return false;
        }
    }

    /* renamed from: com.antutu.redacc.service.FxService.2 */
    class C17642 implements OnClickListener {
        final /* synthetic */ FxService f6223a;

        C17642(FxService fxService) {
            this.f6223a = fxService;
        }

        public void onClick(View view) {
            if (this.f6223a.f6225a != null) {
                this.f6223a.f6227c.removeView(this.f6223a.f6225a);
                this.f6223a.f6225a = null;
            }
            this.f6223a.stopSelf();
        }
    }

    /* renamed from: com.antutu.redacc.service.FxService.3 */
    class C17653 implements OnClickListener {
        final /* synthetic */ FxService f6224a;

        C17653(FxService fxService) {
            this.f6224a = fxService;
        }

        public void onClick(View view) {
            this.f6224a.m6818b();
            if (this.f6224a.f6225a != null) {
                this.f6224a.f6227c.removeView(this.f6224a.f6225a);
                this.f6224a.f6225a = null;
            }
            this.f6224a.stopSelf();
        }
    }

    public FxService() {
        this.f6229e = null;
    }

    private void m6816a() {
        this.f6226b = new LayoutParams();
        Application application = getApplication();
        getApplication();
        this.f6227c = (WindowManager) application.getSystemService("window");
        Log.i("FxService", "mWindowManager--->" + this.f6227c);
        if (VERSION.SDK_INT >= 19) {
            this.f6226b.type = 2005;
        } else {
            this.f6226b.type = 2002;
        }
        this.f6226b.format = 1;
        this.f6226b.flags = 8;
        this.f6226b.gravity = 51;
        this.f6226b.x = 0;
        this.f6226b.y = 0;
        this.f6226b.width = -1;
        this.f6226b.height = -2;
        this.f6225a = (RelativeLayout) LayoutInflater.from(getApplication()).inflate(C1692R.layout.wx_note_dialog, null);
        this.f6227c.addView(this.f6225a, this.f6226b);
        this.f6228d = (Button) this.f6225a.findViewById(C1692R.id.float_id);
        this.f6225a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.f6226b.y = Integer.valueOf(C1749f.m6746a(getApplication())).intValue();
        this.f6227c.updateViewLayout(this.f6225a, this.f6226b);
        Log.i("FxService", "Width/2--->" + (this.f6228d.getMeasuredWidth() / 2));
        Log.i("FxService", "Height/2--->" + (this.f6228d.getMeasuredHeight() / 2));
        this.f6225a.setOnTouchListener(new C17631(this));
        this.f6228d.setOnClickListener(new C17642(this));
        this.f6225a.findViewById(C1692R.id.btn).setOnClickListener(new C17653(this));
    }

    private void m6818b() {
        ((ClipboardManager) getSystemService("clipboard")).setText("AnTuTu_Benchmark");
        Toast.makeText(getApplication(), C1692R.string.has_copy, 0).show();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Log.i("FxService", "oncreat");
        this.f6230f = C1756m.m6763a(getApplicationContext(), "wxVerifyCode");
        this.f6229e = (NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f6225a != null) {
            this.f6227c.removeView(this.f6225a);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if ("ACTION_CP_WXCODE".equals(intent.getAction())) {
            m6818b();
            C1753i.m6758a(this);
            this.f6229e.cancel(16);
            stopSelf();
        } else {
            m6816a();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
