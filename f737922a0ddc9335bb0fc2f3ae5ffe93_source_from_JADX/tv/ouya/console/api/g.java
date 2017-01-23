package tv.ouya.console.api;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.hardware.input.InputManager.InputDeviceListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.widget.EditText;
import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class g {
    private static final Uri DW;
    private static a FH;
    private static InputManager Hw;
    private static List<SparseBooleanArray> VH;
    private static SparseArray<e> Zo;
    private static b gn;
    private static final String j6;
    private static boolean u7;
    private static boolean v5;

    static class a implements InputDeviceListener {
        a() {
        }

        public void onInputDeviceAdded(int i) {
            if (g.Zo.get(i) == null) {
                d j6 = d.j6(i);
                if (j6 != null) {
                    e j62 = g.gn.j6(g.gn.j6(j6.DW()));
                    if (j62 != null) {
                        g.Zo.put(i, j62);
                        return;
                    }
                    return;
                }
                Log.e(g.j6, "onInputDeviceAdded device=" + i + " not found");
            }
        }

        public void onInputDeviceChanged(int i) {
        }

        public void onInputDeviceRemoved(int i) {
            if (g.Zo.get(i) != null) {
                g.Zo.remove(i);
            }
        }
    }

    static {
        j6 = g.class.getSimpleName();
        DW = Uri.parse("content://tv.ouya.controllerdata/");
        FH = null;
        v5 = true;
        Zo = new SparseArray();
        VH = new ArrayList();
        gn = new b();
        u7 = false;
    }

    public static void j6(Activity activity) {
        int i = 0;
        d.j6((Context) activity);
        if (FH == null) {
            FH = new a();
            Hw = (InputManager) activity.getSystemService("input");
            if (Hw != null) {
                Hw.registerInputDeviceListener(FH, null);
            }
        }
        for (int i2 = 0; i2 < 4; i2++) {
            VH.add(new SparseBooleanArray());
        }
        while (i < 4) {
            d FH = d.FH(i);
            if (FH != null) {
                String str = "null";
                if (FH.j6() != null) {
                    str = FH.j6().getName();
                }
                Log.i(j6, "OUYA Controller #" + i + ": " + str);
            }
            i++;
        }
        gn.DW(FH(activity));
    }

    public static void DW(Activity activity) {
        if (Hw != null) {
            Hw.unregisterInputDeviceListener(FH);
        }
    }

    private static String FH(Activity activity) {
        Bundle call;
        try {
            call = activity.getApplicationContext().getContentResolver().call(DW, "get_button_remap_json", null, null);
        } catch (IllegalArgumentException e) {
            Log.e(j6, "Error querying button remapping");
            call = null;
        }
        if (call != null) {
            return call.getString("button_remap");
        }
        return null;
    }

    public static void j6(boolean z) {
        v5 = z;
    }

    private static e j6(int i) {
        if (Zo.get(i) != null) {
            return (e) Zo.get(i);
        }
        FH.onInputDeviceAdded(i);
        return (e) Zo.get(i);
    }

    private static boolean DW(Activity activity, MotionEvent motionEvent) {
        if (v5) {
            d.j6(motionEvent);
        }
        u7 = true;
        boolean dispatchGenericMotionEvent = activity.dispatchGenericMotionEvent(motionEvent);
        u7 = false;
        return dispatchGenericMotionEvent;
    }

    private static boolean j6(Activity activity, KeyEvent keyEvent, boolean z) {
        boolean z2 = true;
        int keyCode = keyEvent.getKeyCode();
        switch (keyEvent.getAction()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                if (v5) {
                    d.j6(keyCode, keyEvent);
                    break;
                }
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (v5) {
                    d.DW(keyCode, keyEvent);
                    break;
                }
                break;
        }
        u7 = true;
        boolean dispatchKeyEvent = activity.dispatchKeyEvent(keyEvent);
        if (dispatchKeyEvent || !z) {
            z2 = dispatchKeyEvent;
        } else {
            int i;
            switch (keyEvent.getKeyCode()) {
                case 96:
                    i = 23;
                    break;
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                    i = 4;
                    break;
                case 99:
                case 100:
                    i = 0;
                    dispatchKeyEvent = true;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i != 0) {
                activity.dispatchKeyEvent(new KeyEvent(keyEvent.getDownTime(), keyEvent.getEventTime(), keyEvent.getAction(), i, keyEvent.getRepeatCount(), keyEvent.getMetaState(), keyEvent.getDeviceId(), 0, 1024));
            } else {
                z2 = dispatchKeyEvent;
            }
        }
        u7 = false;
        return z2;
    }

    public static boolean j6(InputEvent inputEvent) {
        return !u7;
    }

    public static boolean j6(Activity activity, MotionEvent motionEvent) {
        if (j6((InputEvent) motionEvent)) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                return DW(activity, motionEvent);
            }
            int DW = d.DW(motionEvent.getDeviceId());
            if (DW < 0) {
                Log.e(j6, "Failed to find playerNum for Controller=" + motionEvent.getDevice().getName());
                return DW(activity, motionEvent);
            }
            e j6 = j6(motionEvent.getDeviceId());
            if (j6 == null) {
                return DW(activity, motionEvent);
            }
            int j62;
            int source = motionEvent.getSource();
            Vector vector = j6.v5;
            if (vector != null) {
                int i = 0;
                int i2 = 0;
                while (i < vector.size()) {
                    d dVar = (d) vector.get(i);
                    float axisValue = motionEvent.getAxisValue(dVar.j6);
                    if (axisValue < dVar.FH || axisValue > dVar.DW) {
                        if (((SparseBooleanArray) VH.get(DW)).get(dVar.Hw)) {
                            ((SparseBooleanArray) VH.get(DW)).put(dVar.Hw, false);
                            j62 = i2 | j6(activity, new KeyEvent(0, 0, 1, dVar.Hw, 0, 0, motionEvent.getDeviceId(), 0, 1024), true);
                        }
                        j62 = i2;
                    } else {
                        if (!((SparseBooleanArray) VH.get(DW)).get(dVar.Hw)) {
                            ((SparseBooleanArray) VH.get(DW)).put(dVar.Hw, true);
                            j62 = i2 | j6(activity, new KeyEvent(0, 0, 0, dVar.Hw, 0, 0, motionEvent.getDeviceId(), 0, 1024), true);
                        }
                        j62 = i2;
                    }
                    i++;
                    i2 = j62;
                }
                DW = i2;
            } else {
                DW = 0;
            }
            if (j6.DW.size() > 0 && j6.DW.get(source)) {
                return true;
            }
            Vector vector2 = j6.FH;
            if (vector2 != null) {
                int pointerCount = motionEvent.getPointerCount();
                if (pointerCount > 0 && vector2.size() > 0) {
                    PointerProperties[] pointerPropertiesArr = new PointerProperties[]{new PointerProperties()};
                    PointerCoords[] pointerCoordsArr = new PointerCoords[]{new PointerCoords()};
                    motionEvent.getPointerProperties(0, pointerPropertiesArr[0]);
                    motionEvent.getPointerCoords(0, pointerCoordsArr[0]);
                    for (j62 = 0; j62 < vector2.size(); j62++) {
                        b bVar = (b) vector2.get(j62);
                        if (bVar.j6 != bVar.DW) {
                            pointerCoordsArr[0].setAxisValue(bVar.DW, motionEvent.getAxisValue(bVar.j6));
                        }
                    }
                    MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), 1.0f, 1.0f, motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), source, motionEvent.getFlags());
                    boolean DW2 = DW(activity, obtain) | DW;
                    obtain.recycle();
                    return DW2;
                }
            }
            return DW(activity, motionEvent) | DW;
        }
        throw new RuntimeException("Don't pass events when shouldHandleInputEvent is false");
    }

    public static boolean j6(Activity activity, KeyEvent keyEvent) {
        if (j6((InputEvent) keyEvent)) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                return j6(activity, keyEvent, false);
            }
            e j6 = j6(keyEvent.getDeviceId());
            if (j6 == null) {
                return j6(activity, keyEvent, true);
            }
            int keyCode = keyEvent.getKeyCode();
            int source = keyEvent.getSource();
            c j62 = gn.j6(j6, keyCode);
            if (j62 == null) {
                return j6(activity, keyEvent, true);
            }
            if (j62.FH.size() > 0 && j62.FH.get(source)) {
                return true;
            }
            if (keyCode != j62.DW) {
                keyEvent = new KeyEvent(keyEvent.getDownTime(), keyEvent.getEventTime(), keyEvent.getAction(), j62.DW, keyEvent.getRepeatCount(), keyEvent.getMetaState(), keyEvent.getDeviceId(), 0);
            }
            return j6(activity, keyEvent, true);
        }
        throw new RuntimeException("Don't pass events when shouldHandleInputEvent is false");
    }
}
