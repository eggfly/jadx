package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import l;

@TargetApi(11)
public final class zzos extends Fragment implements gy {
    private static WeakHashMap<Activity, WeakReference<zzos>> j6;
    private Map<String, gx> DW;
    private int FH;
    private Bundle Hw;

    static {
        j6 = new WeakHashMap();
    }

    public zzos() {
        this.DW = new l();
        this.FH = 0;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (gx j6 : this.DW.values()) {
            j6.j6(str, fileDescriptor, printWriter, strArr);
        }
    }

    public Activity j6() {
        return getActivity();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (gx j6 : this.DW.values()) {
            j6.j6(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.FH = 1;
        this.Hw = bundle;
        for (Entry entry : this.DW.entrySet()) {
            ((gx) entry.getValue()).j6(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.DW.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((gx) entry.getValue()).DW(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.FH = 2;
        for (gx j6 : this.DW.values()) {
            j6.j6();
        }
    }

    public void onStop() {
        super.onStop();
        this.FH = 3;
        for (gx DW : this.DW.values()) {
            DW.DW();
        }
    }
}
