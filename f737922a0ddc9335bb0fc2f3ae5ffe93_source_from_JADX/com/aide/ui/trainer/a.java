package com.aide.ui.trainer;

import android.accounts.Account;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import nx;
import ps$a;

public class a {

    static class 1 implements Runnable {
        final /* synthetic */ Runnable j6;

        1(Runnable runnable) {
            this.j6 = runnable;
        }

        public void run() {
            com.aide.analytics.a.DW("Intel Sponsorship dismissed");
            this.j6.run();
        }
    }

    static class 2 implements Runnable {
        final /* synthetic */ Activity j6;

        2(Activity activity) {
            this.j6 = activity;
        }

        public void run() {
            a.j6(this.j6);
        }
    }

    static class 3 implements Runnable {
        final /* synthetic */ Activity DW;
        final /* synthetic */ Runnable FH;
        final /* synthetic */ Account[] j6;

        class 1 implements y<String> {
            final /* synthetic */ 3 j6;

            class 1 implements OnCancelListener {
                final /* synthetic */ 1 DW;
                final /* synthetic */ AtomicBoolean j6;

                1(1 1, AtomicBoolean atomicBoolean) {
                    this.DW = 1;
                    this.j6 = atomicBoolean;
                }

                public void onCancel(DialogInterface dialogInterface) {
                    this.j6.set(true);
                }
            }

            class 2 implements Runnable {
                final /* synthetic */ AtomicBoolean DW;
                final /* synthetic */ ProgressDialog FH;
                final /* synthetic */ 1 Hw;
                final /* synthetic */ String j6;

                class 1 implements ps$a {
                    final /* synthetic */ 2 j6;

                    class 1 implements Runnable {
                        final /* synthetic */ 1 j6;

                        1(1 1) {
                            this.j6 = 1;
                        }

                        public void run() {
                            a.j6(this.j6.j6.Hw.j6.DW);
                        }
                    }

                    class 2 implements Runnable {
                        final /* synthetic */ 1 j6;

                        2(1 1) {
                            this.j6 = 1;
                        }

                        public void run() {
                            this.j6.j6.Hw.j6.FH.run();
                        }
                    }

                    1(2 2) {
                        this.j6 = 2;
                    }

                    public void j6(boolean z) {
                        if (!this.j6.DW.get()) {
                            this.j6.FH.dismiss();
                            com.aide.analytics.a.DW("Intel Sponsorship granted");
                            m nxVar = new nx(this.j6.Hw.j6.DW, "All expert features have been unlocked, sponsored by Intel!");
                            nxVar.j6("Learn more about", "Intel Android", R.drawable.intel_logo, false, new 1(this));
                            nxVar.j6("Develop your first", "Android app", R.drawable.ic_launcher, true, new 2(this));
                            m.j6(this.j6.Hw.j6.DW, nxVar);
                        }
                    }

                    public void DW(boolean z) {
                        if (!this.j6.DW.get()) {
                            this.j6.FH.dismiss();
                            m.j6(this.j6.Hw.j6.DW, "Sponsorship", "Unfortunately you did not win a sponsored license. Try again next month!", this.j6.Hw.j6.FH);
                        }
                    }

                    public void j6(String str) {
                        if (!this.j6.DW.get()) {
                            this.j6.FH.dismiss();
                            m.j6(this.j6.Hw.j6.DW, "Error", str, this.j6.Hw.j6.FH);
                        }
                    }
                }

                2(1 1, String str, AtomicBoolean atomicBoolean, ProgressDialog progressDialog) {
                    this.Hw = 1;
                    this.j6 = str;
                    this.DW = atomicBoolean;
                    this.FH = progressDialog;
                }

                public void run() {
                    e.cb().j6(this.j6, new 1(this));
                }
            }

            1(3 3) {
                this.j6 = 3;
            }

            public void j6(String str) {
                com.aide.analytics.a.DW("Intel Sponsorship requested");
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ProgressDialog show = ProgressDialog.show(this.j6.DW, null, "Requesting sponsored license...", true, true, new 1(this, atomicBoolean));
                show.getWindow().addFlags(128);
                show.getWindow().clearFlags(2);
                new Thread(new 2(this, str, atomicBoolean, show)).start();
            }
        }

        3(Account[] accountArr, Activity activity, Runnable runnable) {
            this.j6 = accountArr;
            this.DW = activity;
            this.FH = runnable;
        }

        public void run() {
            com.aide.analytics.a.DW("Intel Sponsorship clicked");
            List arrayList = new ArrayList();
            for (Account account : this.j6) {
                arrayList.add(account.name);
            }
            m.j6(this.DW, "Choose account", arrayList, new 1(this));
        }
    }

    public static void j6(Activity activity, Runnable runnable) {
        runnable.run();
    }

    protected static void j6(Activity activity) {
        com.aide.analytics.a.DW("Intel Web Page link clicked");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://intel.ly/1TOi5dz"));
        activity.startActivity(intent);
    }
}
