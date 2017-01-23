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
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.aide.uidesigner.ProxyTextView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import r;

public class FragmentActivity extends i {
    final l DW;
    boolean FH;
    boolean Hw;
    boolean VH;
    boolean Zo;
    boolean gn;
    final Handler j6;
    boolean v5;

    class 1 extends Handler {
        final /* synthetic */ FragmentActivity j6;

        1(FragmentActivity fragmentActivity) {
            this.j6 = fragmentActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    if (this.j6.v5) {
                        this.j6.j6(false);
                    }
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.j6.DW();
                    this.j6.DW.Ws();
                default:
                    super.handleMessage(message);
            }
        }
    }

    class a extends m<FragmentActivity> {
        final /* synthetic */ FragmentActivity j6;

        public a(FragmentActivity fragmentActivity) {
            this.j6 = fragmentActivity;
            super(fragmentActivity);
        }

        public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.j6.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean j6(Fragment fragment) {
            return !this.j6.isFinishing();
        }

        public LayoutInflater DW() {
            return this.j6.getLayoutInflater().cloneInContext(this.j6);
        }

        public void FH() {
            this.j6.Hw();
        }

        public void j6(Fragment fragment, Intent intent, int i) {
            this.j6.j6(fragment, intent, i);
        }

        public boolean Hw() {
            return this.j6.getWindow() != null;
        }

        public int v5() {
            Window window = this.j6.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public void DW(Fragment fragment) {
            this.j6.j6(fragment);
        }

        public View j6(int i) {
            return this.j6.findViewById(i);
        }

        public boolean j6() {
            Window window = this.j6.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    static final class b {
        List<Fragment> DW;
        r<String, t> FH;
        Object j6;

        b() {
        }
    }

    public FragmentActivity() {
        this.j6 = new 1(this);
        this.DW = l.j6(new a(this));
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.DW.FH();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            int DW = this.DW.DW();
            if (DW == 0 || i3 < 0 || i3 >= DW) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.DW.j6(new ArrayList(DW)).get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.j6(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.DW.j6().FH()) {
            j6();
        }
    }

    public void j6() {
        d.j6(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.DW.j6(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.DW.j6(null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.DW.j6(bVar.FH);
        }
        if (bundle != null) {
            List list;
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            l lVar = this.DW;
            if (bVar != null) {
                list = bVar.DW;
            } else {
                list = null;
            }
            lVar.j6(parcelable, list);
        }
        this.DW.Zo();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.DW.j6(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View j6(View view, String str, Context context, AttributeSet attributeSet) {
        return this.DW.j6(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        j6(false);
        this.DW.J0();
        this.DW.XL();
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
        this.DW.J8();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return this.DW.j6(menuItem);
            case 6:
                return this.DW.DW(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                this.DW.DW(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.Hw = false;
        if (this.j6.hasMessages(2)) {
            this.j6.removeMessages(2);
            DW();
        }
        this.DW.tp();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.DW.FH();
    }

    public void onStateNotSaved() {
        this.DW.FH();
    }

    protected void onResume() {
        super.onResume();
        this.j6.sendEmptyMessage(2);
        this.Hw = true;
        this.DW.Ws();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.j6.removeMessages(2);
        DW();
        this.DW.Ws();
    }

    protected void DW() {
        this.DW.u7();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.gn) {
            this.gn = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return j6(view, menu) | this.DW.j6(menu);
    }

    protected boolean j6(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.v5) {
            j6(true);
        }
        Object FH = FH();
        List v5 = this.DW.v5();
        r j3 = this.DW.j3();
        if (v5 == null && j3 == null && FH == null) {
            return null;
        }
        Object bVar = new b();
        bVar.j6 = FH;
        bVar.DW = v5;
        bVar.FH = j3;
        return bVar;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable Hw = this.DW.Hw();
        if (Hw != null) {
            bundle.putParcelable("android:support:fragments", Hw);
        }
    }

    protected void onStart() {
        super.onStart();
        this.v5 = false;
        this.Zo = false;
        this.j6.removeMessages(1);
        if (!this.FH) {
            this.FH = true;
            this.DW.VH();
        }
        this.DW.FH();
        this.DW.Ws();
        this.DW.QX();
        this.DW.gn();
        this.DW.aM();
    }

    protected void onStop() {
        super.onStop();
        this.v5 = true;
        this.j6.sendEmptyMessage(1);
        this.DW.EQ();
    }

    public Object FH() {
        return null;
    }

    public void Hw() {
        if (VERSION.SDK_INT >= 11) {
            f.j6(this);
        } else {
            this.gn = true;
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
            printWriter.print(this.FH);
            printWriter.print("mResumed=");
            printWriter.print(this.Hw);
            printWriter.print(" mStopped=");
            printWriter.print(this.v5);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.Zo);
            this.DW.j6(str2, fileDescriptor, printWriter, strArr);
            this.DW.j6().j6(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            j6(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.FH);
            printWriter.print("mResumed=");
            printWriter.print(this.Hw);
            printWriter.print(" mStopped=");
            printWriter.print(this.v5);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.Zo);
            this.DW.j6(str2, fileDescriptor, printWriter, strArr);
            this.DW.j6().j6(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            j6(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String j6(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                stringBuilder.append('V');
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuilder.append('I');
                break;
            case 8:
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

    private void j6(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(j6(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    j6(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void j6(boolean z) {
        if (!this.Zo) {
            this.Zo = true;
            this.VH = z;
            this.j6.removeMessages(1);
            v5();
        }
    }

    void v5() {
        this.DW.j6(this.VH);
        this.DW.we();
    }

    public void j6(Fragment fragment) {
    }

    public n Zo() {
        return this.DW.j6();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            i2--;
            int DW = this.DW.DW();
            if (DW == 0 || i2 < 0 || i2 >= DW) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.DW.j6(new ArrayList(DW)).get(i2);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.j6(i & 255, strArr, iArr);
            }
        }
    }

    public void j6(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.QX + 1) << 16) + (65535 & i));
        }
    }
}
