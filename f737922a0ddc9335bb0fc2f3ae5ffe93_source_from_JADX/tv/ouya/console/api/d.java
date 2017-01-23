package tv.ouya.console.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.aide.uidesigner.ProxyTextView;

public class d {
    private static int[] DW;
    private static final Uri FH;
    private static Context Hw;
    private static SparseArray<Object> Zo;
    static final d[] j6;
    private static Bundle v5;
    private SparseBooleanArray EQ;
    private int VH;
    private InputDevice gn;
    private SparseArray<Float> tp;
    private String u7;
    private SparseIntArray we;

    static class 1 extends BroadcastReceiver {
        1() {
        }

        public void onReceive(Context context, Intent intent) {
            int intExtra;
            int intExtra2;
            if (intent.getAction().equals("tv.ouya.controller.added")) {
                intExtra = intent.getIntExtra("DEVICE_ID", -1);
                intExtra2 = intent.getIntExtra("PLAYER_NUM", -1);
                if (intExtra2 >= 0 && intExtra2 < 4) {
                    if (d.j6[intExtra2] != null) {
                        Log.e("OuyaController", "Controller already exists for player " + intExtra2 + "(new device id " + intExtra + ", prev device id " + d.j6[intExtra2].FH() + ")");
                    }
                    d.j6[intExtra2] = new d(intExtra);
                }
            } else if (intent.getAction().equals("tv.ouya.controller.removed")) {
                intExtra2 = intent.getIntExtra("DEVICE_ID", -1);
                intExtra = 0;
                while (intExtra < 4) {
                    d dVar = d.j6[intExtra];
                    if (dVar == null || dVar.FH() != intExtra2) {
                        intExtra++;
                    } else {
                        d.j6[intExtra] = null;
                        return;
                    }
                }
            }
        }
    }

    static {
        DW = new int[]{0, 1, 11, 14, 17, 18};
        FH = Uri.parse("content://tv.ouya.controllerdata/");
        v5 = null;
        Zo = null;
        j6 = new d[4];
    }

    public static void j6(Context context) {
        if (Hw == null) {
            Hw = context.getApplicationContext();
            for (int i = 0; i < 4; i++) {
                int v5 = v5(i);
                if (v5 != -1) {
                    Hw(v5);
                }
            }
            BroadcastReceiver 1 = new 1();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("tv.ouya.controller.added");
            intentFilter.addAction("tv.ouya.controller.removed");
            Hw.registerReceiver(1, intentFilter);
        }
    }

    public static d j6(int i) {
        for (d dVar : j6) {
            if (dVar != null && dVar.FH() == i) {
                return dVar;
            }
        }
        return null;
    }

    public static int DW(int i) {
        d Hw = Hw(i);
        if (Hw == null) {
            return -1;
        }
        return Hw.Hw();
    }

    public static d FH(int i) {
        if (i < 0 || i >= 4) {
            return null;
        }
        return j6[i];
    }

    public static boolean j6(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 16) == 0 || motionEvent.getAction() != 2) {
            return false;
        }
        d Hw = Hw(motionEvent.getDeviceId());
        if (Hw == null) {
            return false;
        }
        for (int i : DW) {
            Float f = (Float) Hw.tp.get(i);
            float axisValue = motionEvent.getAxisValue(i);
            if (f == null || f.floatValue() != axisValue) {
                Hw.tp.put(i, Float.valueOf(axisValue));
            }
        }
        return true;
    }

    public static boolean j6(int i, KeyEvent keyEvent) {
        return FH(i, keyEvent);
    }

    public static boolean DW(int i, KeyEvent keyEvent) {
        return FH(i, keyEvent);
    }

    private static boolean FH(int i, KeyEvent keyEvent) {
        d Hw = Hw(keyEvent.getDeviceId());
        if (Hw == null) {
            return false;
        }
        boolean z;
        switch (keyEvent.getAction()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                z = true;
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                z = false;
                break;
            default:
                z = false;
                break;
        }
        int keyCode = keyEvent.getKeyCode();
        if (Hw.EQ.indexOfKey(keyCode) < 0 || Hw.EQ.get(keyCode) != z) {
            Hw.we.put(keyCode, Hw.we.get(keyCode, 0) | (z ? 1 : 2));
        }
        Hw.EQ.put(keyCode, z);
        return true;
    }

    public InputDevice j6() {
        return this.gn;
    }

    public String DW() {
        return this.u7;
    }

    public int FH() {
        return this.VH;
    }

    public int Hw() {
        for (int i = 0; i < 4; i++) {
            if (j6[i] == this) {
                return i;
            }
        }
        return -1;
    }

    private static d Hw(int i) {
        d j6 = j6(i);
        if (j6 != null) {
            return j6;
        }
        int Zo = Zo(i);
        if (Zo < 0 || Zo >= 4) {
            return null;
        }
        if (j6[Zo] != null) {
            Log.e("OuyaController", "Controller for player " + Zo + " already found, but doesn't match device id " + "(expected " + i + " got " + j6[Zo].FH() + ")");
            return j6[Zo];
        }
        j6[Zo] = new d(i);
        return j6[Zo];
    }

    private static int v5(int i) {
        Cursor query = Hw.getContentResolver().query(FH, new String[]{"input_device_id"}, "player_num = ?", new String[]{String.valueOf(i)}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    int i2 = query.getInt(0);
                    if (query == null) {
                        return i2;
                    }
                    query.close();
                    return i2;
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return -1;
    }

    private static int Zo(int i) {
        if (Hw == null) {
            return -1;
        }
        Cursor query = Hw.getContentResolver().query(FH, new String[]{"player_num"}, "input_device_id = ?", new String[]{String.valueOf(i)}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    int i2 = query.getInt(0);
                    if (query == null) {
                        return i2;
                    }
                    query.close();
                    return i2;
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return -1;
    }

    private static String VH(int i) {
        Exception e;
        if (Hw == null) {
            return null;
        }
        Cursor query;
        String string;
        try {
            query = Hw.getContentResolver().query(FH, new String[]{"bt_name"}, "input_device_id = ?", new String[]{String.valueOf(i)}, null);
            if (query != null) {
                if (query.moveToNext()) {
                    string = query.getString(0);
                    if (query != null) {
                        return string;
                    }
                    try {
                        query.close();
                        return string;
                    } catch (SQLiteException e2) {
                        return string;
                    } catch (Exception e3) {
                        e = e3;
                        Log.d("OuyaController", "Exception: " + e.getMessage());
                        return string;
                    }
                }
            }
            string = null;
            if (query != null) {
                return string;
            }
            query.close();
            return string;
        } catch (SQLiteException e4) {
            return null;
        } catch (Exception e5) {
            e = e5;
            string = null;
            Log.d("OuyaController", "Exception: " + e.getMessage());
            return string;
        } catch (Throwable th) {
            if (query != null) {
                query.close();
            }
        }
    }

    d(int i) {
        this.VH = i;
        this.gn = InputDevice.getDevice(i);
        this.tp = new SparseArray();
        this.EQ = new SparseBooleanArray();
        this.we = new SparseIntArray();
        this.u7 = VH(i);
        if ((this.u7 == null || this.u7.isEmpty()) && this.gn != null) {
            this.u7 = this.gn.getName();
        }
    }
}
