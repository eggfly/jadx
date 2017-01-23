package com.mob.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class FakeActivity {
    private static Class<? extends Activity> shellClass;
    protected Activity activity;
    private View contentView;
    private HashMap<String, Object> result;
    private FakeActivity resultReceiver;

    /* renamed from: com.mob.tools.FakeActivity.1 */
    class C40031 implements Callback {
        final /* synthetic */ boolean val$forceNewTask;

        C40031(boolean z) {
            this.val$forceNewTask = z;
        }

        public boolean handleMessage(Message message) {
            Object[] objArr = (Object[]) message.obj;
            Context context = (Context) objArr[0];
            Intent intent = (Intent) objArr[1];
            if (this.val$forceNewTask) {
                intent.addFlags(268435456);
                intent.addFlags(134217728);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return false;
        }
    }

    /* renamed from: com.mob.tools.FakeActivity.2 */
    class C40042 implements Callback {
        final /* synthetic */ Runnable val$r;

        C40042(Runnable runnable) {
            this.val$r = runnable;
        }

        public boolean handleMessage(Message message) {
            this.val$r.run();
            return false;
        }
    }

    /* renamed from: com.mob.tools.FakeActivity.3 */
    class C40053 implements Callback {
        final /* synthetic */ Runnable val$r;

        C40053(Runnable runnable) {
            this.val$r = runnable;
        }

        public boolean handleMessage(Message message) {
            this.val$r.run();
            return false;
        }
    }

    public static void registerExecutor(String str, Object obj) {
        if (shellClass != null) {
            try {
                Method method = shellClass.getMethod("registerExecutor", new Class[]{String.class, Object.class});
                method.setAccessible(true);
                method.invoke(null, new Object[]{str, obj});
                return;
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
                return;
            }
        }
        MobUIShell.registerExecutor(str, obj);
    }

    public static void setShell(Class<? extends Activity> cls) {
        shellClass = cls;
    }

    public <T extends View> T findViewById(int i) {
        return this.activity == null ? null : this.activity.findViewById(i);
    }

    public <T extends View> T findViewByResName(View view, String str) {
        if (this.activity == null) {
            return null;
        }
        int idRes = C4021R.getIdRes(this.activity, str);
        return idRes > 0 ? view.findViewById(idRes) : null;
    }

    public <T extends View> T findViewByResName(String str) {
        if (this.activity == null) {
            return null;
        }
        int idRes = C4021R.getIdRes(this.activity, str);
        return idRes > 0 ? findViewById(idRes) : null;
    }

    public final void finish() {
        if (this.activity != null) {
            this.activity.finish();
        }
    }

    public View getContentView() {
        return this.contentView;
    }

    public Context getContext() {
        return this.activity;
    }

    public int getOrientation() {
        return this.activity.getResources().getConfiguration().orientation;
    }

    public FakeActivity getParent() {
        return this.resultReceiver;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onNewIntent(Intent intent) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onRestart() {
    }

    public void onResult(HashMap<String, Object> hashMap) {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void requestFullScreen(boolean z) {
        if (this.activity != null) {
            if (z) {
                this.activity.getWindow().addFlags(IXAdIOUtils.BUFFER_SIZE);
                this.activity.getWindow().clearFlags(com.taobao.accs.data.Message.FLAG_RET);
            } else {
                this.activity.getWindow().addFlags(com.taobao.accs.data.Message.FLAG_RET);
                this.activity.getWindow().clearFlags(IXAdIOUtils.BUFFER_SIZE);
            }
            this.activity.getWindow().getDecorView().requestLayout();
        }
    }

    public void requestLandscapeOrientation() {
        setRequestedOrientation(0);
    }

    public void requestPermissions(String[] strArr, int i) {
        if (this.activity != null && VERSION.SDK_INT >= 23) {
            try {
                ReflectHelper.invokeInstanceMethod(this.activity, "requestPermissions", strArr, Integer.valueOf(i));
            } catch (Throwable th) {
                MobLog.getInstance().m4376d(th);
            }
        }
    }

    public void requestPortraitOrientation() {
        setRequestedOrientation(1);
    }

    public void runOnUIThread(Runnable runnable) {
        UIHandler.sendEmptyMessage(0, new C40042(runnable));
    }

    public void runOnUIThread(Runnable runnable, long j) {
        UIHandler.sendEmptyMessageDelayed(0, j, new C40053(runnable));
    }

    public void sendResult() {
        if (this.resultReceiver != null) {
            this.resultReceiver.onResult(this.result);
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setContentView(View view) {
        this.contentView = view;
    }

    public void setContentViewLayoutResName(String str) {
        if (this.activity != null) {
            int layoutRes = C4021R.getLayoutRes(this.activity, str);
            if (layoutRes > 0) {
                this.activity.setContentView(layoutRes);
            }
        }
    }

    public void setRequestedOrientation(int i) {
        if (this.activity != null) {
            this.activity.setRequestedOrientation(i);
        }
    }

    public final void setResult(HashMap<String, Object> hashMap) {
        this.result = hashMap;
    }

    public void show(Context context, Intent intent) {
        showForResult(context, intent, null);
    }

    public void show(Context context, Intent intent, boolean z) {
        showForResult(context, intent, null, z);
    }

    public void showForResult(Context context, Intent intent, FakeActivity fakeActivity) {
        showForResult(context, intent, fakeActivity, false);
    }

    public void showForResult(Context context, Intent intent, FakeActivity fakeActivity, boolean z) {
        String str;
        Intent intent2;
        this.resultReceiver = fakeActivity;
        Message message = new Message();
        if (shellClass != null) {
            Intent intent3 = new Intent(context, shellClass);
            try {
                Method method = shellClass.getMethod("registerExecutor", new Class[]{Object.class});
                method.setAccessible(true);
                str = (String) method.invoke(null, new Object[]{this});
                intent2 = intent3;
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
                str = null;
                intent2 = intent3;
            }
        } else {
            intent2 = new Intent(context, MobUIShell.class);
            str = MobUIShell.registerExecutor(this);
        }
        intent2.putExtra("launch_time", str);
        intent2.putExtra("executor_name", getClass().getName());
        if (intent != null) {
            intent2.putExtras(intent);
        }
        message.obj = new Object[]{context, intent2};
        UIHandler.sendMessage(message, new C40031(z));
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.activity != null) {
            this.activity.startActivityForResult(intent, i);
        }
    }
}
