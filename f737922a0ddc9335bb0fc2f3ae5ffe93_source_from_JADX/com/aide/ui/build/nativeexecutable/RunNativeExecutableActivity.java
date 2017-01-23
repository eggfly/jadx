package com.aide.ui.build.nativeexecutable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.aide.ui.R;
import com.aide.ui.build.OutputConsoleActivity;
import qc;

public class RunNativeExecutableActivity extends OutputConsoleActivity {
    private qc FH;

    class 1 implements Runnable {
        final /* synthetic */ RunNativeExecutableActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.FH();
            }
        }

        1(RunNativeExecutableActivity runNativeExecutableActivity) {
            this.j6 = runNativeExecutableActivity;
        }

        public void run() {
            try {
                this.j6.FH.FH();
                int Hw = this.j6.FH.Hw();
                if (Hw != 0) {
                    this.j6.j6.getPrintStream().println("Process exited with code " + Hw);
                }
            } catch (InterruptedException e) {
            }
            this.j6.DW.post(new 1(this));
        }
    }

    public static void j6(Activity activity, boolean z, String str, int i) {
        Intent intent = new Intent(activity, RunNativeExecutableActivity.class);
        intent.putExtra("EXTRA_EXECUTABLE", str);
        intent.putExtra("EXTRA_THEME", z);
        OutputConsoleActivity.j6(activity, z, i, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected int DW() {
        return R.drawable.ic_launcher;
    }

    protected void j6() {
        this.FH = new qc(new String[]{getIntent().getExtras().getString("EXTRA_EXECUTABLE")});
        this.FH.j6(this.j6.getPrintStream());
        this.j6.setProcessOutputStream(this.FH.j6());
        new Thread(new 1(this)).start();
    }
}
