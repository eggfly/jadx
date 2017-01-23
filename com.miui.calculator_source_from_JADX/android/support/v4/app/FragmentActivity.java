package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.ActivityCompatApi23.RequestPermissionsRequestCodeValidator;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends BaseFragmentActivityHoneycomb implements OnRequestPermissionsResultCallback, RequestPermissionsRequestCodeValidator {
    final Handler f189a;
    final FragmentController f190b;
    boolean f191c;
    boolean f192d;
    boolean f193e;
    boolean f194f;
    boolean f195g;
    boolean f196h;
    boolean f197i;

    /* renamed from: android.support.v4.app.FragmentActivity.1 */
    class C00141 extends Handler {
        final /* synthetic */ FragmentActivity f175a;

        C00141(FragmentActivity fragmentActivity) {
            this.f175a = fragmentActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (this.f175a.f193e) {
                        this.f175a.m264a(false);
                    }
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    this.f175a.m266b();
                    this.f175a.f190b.m298o();
                default:
                    super.handleMessage(message);
            }
        }
    }

    class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
        final /* synthetic */ FragmentActivity f185a;

        public HostCallbacks(FragmentActivity fragmentActivity) {
            this.f185a = fragmentActivity;
            super(fragmentActivity);
        }

        public void m250a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f185a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean m252a(Fragment fragment) {
            return !this.f185a.isFinishing();
        }

        public LayoutInflater m253b() {
            return this.f185a.getLayoutInflater().cloneInContext(this.f185a);
        }

        public void m255c() {
            this.f185a.m268d();
        }

        public boolean m256d() {
            return this.f185a.getWindow() != null;
        }

        public int m257e() {
            Window window = this.f185a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public void m254b(Fragment fragment) {
            this.f185a.m263a(fragment);
        }

        @Nullable
        public View m249a(int i) {
            return this.f185a.findViewById(i);
        }

        public boolean m251a() {
            Window window = this.f185a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    static final class NonConfigurationInstances {
        Object f186a;
        List<Fragment> f187b;
        SimpleArrayMap<String, LoaderManager> f188c;

        NonConfigurationInstances() {
        }
    }

    public FragmentActivity() {
        this.f189a = new C00141(this);
        this.f190b = FragmentController.m270a(new HostCallbacks(this));
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f190b.m286c();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            int b = this.f190b.m283b();
            if (b == 0 || i3 < 0 || i3 >= b) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f190b.m273a(new ArrayList(b)).get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.m152a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f190b.m271a().m309c()) {
            m261a();
        }
    }

    public void m261a() {
        ActivityCompat.m79a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f190b.m274a(configuration);
    }

    protected void onCreate(@Nullable Bundle bundle) {
        this.f190b.m276a(null);
        super.onCreate(bundle);
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            this.f190b.m277a(nonConfigurationInstances.f188c);
        }
        if (bundle != null) {
            List list;
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            FragmentController fragmentController = this.f190b;
            if (nonConfigurationInstances != null) {
                list = nonConfigurationInstances.f187b;
            } else {
                list = null;
            }
            fragmentController.m275a(parcelable, list);
        }
        this.f190b.m289f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f190b.m281a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View m260a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f190b.m272a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m264a(false);
        this.f190b.m296m();
        this.f190b.m300q();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f190b.m297n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                return this.f190b.m282a(menuItem);
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                return this.f190b.m285b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f190b.m284b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f192d = false;
        if (this.f189a.hasMessages(2)) {
            this.f189a.removeMessages(2);
            m266b();
        }
        this.f190b.m293j();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f190b.m286c();
    }

    public void onStateNotSaved() {
        this.f190b.m286c();
    }

    protected void onResume() {
        super.onResume();
        this.f189a.sendEmptyMessage(2);
        this.f192d = true;
        this.f190b.m298o();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f189a.removeMessages(2);
        m266b();
        this.f190b.m298o();
    }

    protected void m266b() {
        this.f190b.m292i();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f196h) {
            this.f196h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m265a(view, menu) | this.f190b.m280a(menu);
    }

    protected boolean m265a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f193e) {
            m264a(true);
        }
        Object c = m267c();
        List e = this.f190b.m288e();
        SimpleArrayMap s = this.f190b.m302s();
        if (e == null && s == null && c == null) {
            return null;
        }
        Object nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.f186a = c;
        nonConfigurationInstances.f187b = e;
        nonConfigurationInstances.f188c = s;
        return nonConfigurationInstances;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable d = this.f190b.m287d();
        if (d != null) {
            bundle.putParcelable("android:support:fragments", d);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f193e = false;
        this.f194f = false;
        this.f189a.removeMessages(1);
        if (!this.f191c) {
            this.f191c = true;
            this.f190b.m290g();
        }
        this.f190b.m286c();
        this.f190b.m298o();
        this.f190b.m299p();
        this.f190b.m291h();
        this.f190b.m301r();
    }

    protected void onStop() {
        super.onStop();
        this.f193e = true;
        this.f189a.sendEmptyMessage(1);
        this.f190b.m294k();
    }

    public Object m267c() {
        return null;
    }

    public void m268d() {
        if (VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.m83a(this);
        } else {
            this.f196h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f191c);
            printWriter.print("mResumed=");
            printWriter.print(this.f192d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f193e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f194f);
            this.f190b.m278a(str2, fileDescriptor, printWriter, strArr);
            this.f190b.m271a().m307a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m259a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f191c);
            printWriter.print("mResumed=");
            printWriter.print(this.f192d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f193e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f194f);
            this.f190b.m278a(str2, fileDescriptor, printWriter, strArr);
            this.f190b.m271a().m307a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m259a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String m258a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                stringBuilder.append('V');
                break;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                stringBuilder.append('I');
                break;
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m259a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(m258a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m259a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void m264a(boolean z) {
        if (!this.f194f) {
            this.f194f = true;
            this.f195g = z;
            this.f189a.removeMessages(1);
            m269e();
        }
    }

    void m269e() {
        this.f190b.m279a(this.f195g);
        this.f190b.m295l();
    }

    public void m263a(Fragment fragment) {
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void m262a(int i) {
        if (this.f197i) {
            this.f197i = false;
        } else if ((i & -256) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            i2--;
            int b = this.f190b.m283b();
            if (b == 0 || i2 < 0 || i2 >= b) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.f190b.m273a(new ArrayList(b)).get(i2);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.m154a(i & 255, strArr, iArr);
            }
        }
    }
}
