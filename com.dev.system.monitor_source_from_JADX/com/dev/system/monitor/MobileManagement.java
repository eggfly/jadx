package com.dev.system.monitor;

import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fortysevendeg.swipelistview.C0149R;
import com.github.amlcurran.showcaseview.C0158R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardView;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import org.apache.http.conn.util.InetAddressUtils;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class MobileManagement extends Fragment {
    private TextView RX;
    private TextView TX;
    private GeneralInfoCard card;
    private ConnectivityManager conman;
    private TelephonyManager data;
    private Handler handler;
    private BroadcastReceiver mobileData;
    private ImageView mobileImg;
    private View rootView;
    private Runnable runnable;
    private long startRX;
    private long startTX;

    /* renamed from: com.dev.system.monitor.MobileManagement.1 */
    class C01221 implements Runnable {
        C01221() {
        }

        public void run() {
            try {
                if (MobileManagement.this.conman.getActiveNetworkInfo().getType() == 0) {
                    long rxBytes = TrafficStats.getTotalRxBytes() - MobileManagement.this.startRX;
                    if (rxBytes / 1073741824 > 0) {
                        MobileManagement.this.RX.setText(Long.toString(rxBytes / 1073741824) + " GB/s");
                    } else if (rxBytes / 1048576 > 0) {
                        MobileManagement.this.RX.setText(Long.toString(rxBytes / 1048576) + " MB/s");
                    } else if (rxBytes / 1024 > 0) {
                        MobileManagement.this.RX.setText(Long.toString(rxBytes / 1024) + " KB/s");
                    } else {
                        MobileManagement.this.RX.setText(Long.toString(rxBytes) + " B/s");
                    }
                    long txBytes = TrafficStats.getTotalTxBytes() - MobileManagement.this.startTX;
                    MobileManagement.this.startRX = MobileManagement.this.startRX + rxBytes;
                    MobileManagement.this.startTX = MobileManagement.this.startTX + txBytes;
                    if (txBytes / 1073741824 > 0) {
                        MobileManagement.this.TX.setText(Long.toString(txBytes / 1073741824) + " GB/s");
                    } else if (txBytes / 1048576 > 0) {
                        MobileManagement.this.TX.setText(Long.toString(txBytes / 1048576) + " MB/s");
                    } else if (txBytes / 1024 > 0) {
                        MobileManagement.this.TX.setText(Long.toString(txBytes / 1024) + " KB/s");
                    } else {
                        MobileManagement.this.TX.setText(Long.toString(txBytes) + " B/s");
                    }
                }
            } catch (NullPointerException e) {
            }
            MobileManagement.this.handler.postDelayed(this, 1000);
        }
    }

    /* renamed from: com.dev.system.monitor.MobileManagement.2 */
    class C01232 extends BroadcastReceiver {
        C01232() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0).isAvailable()) {
                    MobileManagement.this.setMobileData();
                } else {
                    MobileManagement.this.mobileImg.setImageResource(C0133R.drawable.mobileoff);
                }
            } catch (Exception e) {
                MobileManagement.this.mobileImg.setImageResource(C0133R.drawable.mobileoff);
            }
        }
    }

    /* renamed from: com.dev.system.monitor.MobileManagement.3 */
    class C01243 implements OnLongClickListener {
        C01243() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onLongClick(android.view.View r15) {
            /*
            r14 = this;
            r9 = 0;
            r1 = 1;
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = "connectivity";
            r8 = r8.getSystemService(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = (android.net.ConnectivityManager) r8;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10.conman = r8;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 21;
            if (r8 >= r10) goto L_0x0203;
        L_0x001b:
            r8 = android.net.ConnectivityManager.class;
            r10 = "setMobileDataEnabled";
            r11 = 1;
            r11 = new java.lang.Class[r11];	 Catch:{ NoSuchMethodException -> 0x011c, IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r12 = 0;
            r13 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x011c, IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11[r12] = r13;	 Catch:{ NoSuchMethodException -> 0x011c, IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6 = r8.getDeclaredMethod(r10, r11);	 Catch:{ NoSuchMethodException -> 0x011c, IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x002b:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r8 == 0) goto L_0x003f;
        L_0x0033:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r8 != 0) goto L_0x0052;
        L_0x003f:
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = "connectivity";
            r8 = r8.getSystemService(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = (android.net.ConnectivityManager) r8;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10.conman = r8;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x0052:
            r8 = 1;
            r6.setAccessible(r8);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r8 == 0) goto L_0x013c;
        L_0x0062:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 0;
            r12 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r12 = r12.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r12 = r12.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r12 = r12.isConnected();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r12 == 0) goto L_0x007d;
        L_0x007c:
            r1 = r9;
        L_0x007d:
            r12 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10[r11] = r12;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6.invoke(r8, r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x0086:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r1 == 0) goto L_0x0157;
        L_0x008e:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 2131624013; // 0x7f0e004d float:1.8875194E38 double:1.0531621947E-314;
            r8 = r8.getString(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x0097:
            r11 = 1;
            r8 = android.widget.Toast.makeText(r10, r8, r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.show();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.conman;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.getType();	 Catch:{ NullPointerException -> 0x0170 }
            if (r8 != 0) goto L_0x00e2;
        L_0x00af:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.conman;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.getSubtype();	 Catch:{ NullPointerException -> 0x0170 }
            switch(r8) {
                case 1: goto L_0x0186;
                case 2: goto L_0x0162;
                case 3: goto L_0x0199;
                case 4: goto L_0x0162;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00c0;
                case 7: goto L_0x0162;
                case 8: goto L_0x01ad;
                case 9: goto L_0x01ad;
                case 10: goto L_0x0199;
                case 11: goto L_0x00c0;
                case 12: goto L_0x01ad;
                case 13: goto L_0x01d1;
                case 14: goto L_0x01ad;
                case 15: goto L_0x01c3;
                default: goto L_0x00c0;
            };	 Catch:{ NullPointerException -> 0x0170 }
        L_0x00c0:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0170 }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.TX;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = "";
            r8.setText(r10);	 Catch:{ NullPointerException -> 0x0170 }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.RX;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = "";
            r8.setText(r10);	 Catch:{ NullPointerException -> 0x0170 }
        L_0x00e2:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = "phone";
            r3 = r8.getSystemService(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r3 = (android.telephony.TelephonyManager) r3;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r3.getLine1Number();	 Catch:{ NullPointerException -> 0x01ee }
            r10 = "";
            r8 = r8.equals(r10);	 Catch:{ NullPointerException -> 0x01ee }
            if (r8 == 0) goto L_0x01df;
        L_0x00fc:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x01ee }
            r8 = r8.getActivity();	 Catch:{ NullPointerException -> 0x01ee }
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x01ee }
            r11 = 2131624009; // 0x7f0e0049 float:1.8875186E38 double:1.0531621927E-314;
            r10 = r10.getString(r11);	 Catch:{ NullPointerException -> 0x01ee }
            r8.setTitle(r10);	 Catch:{ NullPointerException -> 0x01ee }
        L_0x010e:
            r8 = new com.dev.system.monitor.MobileManagement$MobileDataGeneralTask;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.<init>();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 0;
            r10 = new java.lang.Void[r10];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.execute(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x011b:
            return r9;
        L_0x011c:
            r5 = move-exception;
            r8 = 2;
            r2 = new java.lang.Class[r8];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = 0;
            r10 = java.lang.String.class;
            r2[r8] = r10;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = 1;
            r10 = java.lang.Boolean.TYPE;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r2[r8] = r10;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = android.net.ConnectivityManager.class;
            r10 = "setMobileDataEnabled";
            r11 = 1;
            r11 = new java.lang.Class[r11];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r12 = 0;
            r13 = java.lang.Boolean.TYPE;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11[r12] = r13;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6 = r8.getDeclaredMethod(r10, r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x002b;
        L_0x013c:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 0;
            r1 = 1;
            r12 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10[r11] = r12;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6.invoke(r8, r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x0086;
        L_0x0152:
            r5 = move-exception;
            r5.printStackTrace();
            goto L_0x011b;
        L_0x0157:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 2131624012; // 0x7f0e004c float:1.8875192E38 double:1.053162194E-314;
            r8 = r8.getString(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x0097;
        L_0x0162:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = 2130837660; // 0x7f02009c float:1.728028E38 double:1.0527736847E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0170 }
            goto L_0x00e2;
        L_0x0170:
            r5 = move-exception;
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.mobileImg;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
            r8.setImageResource(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x00e2;
        L_0x017f:
            r0 = move-exception;
            r8 = com.dev.system.monitor.MobileManagement.this;
            r8.setDataManually();
            goto L_0x011b;
        L_0x0186:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = 2130837661; // 0x7f02009d float:1.7280282E38 double:1.052773685E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0170 }
            goto L_0x00e2;
        L_0x0194:
            r4 = move-exception;
            r4.printStackTrace();
            goto L_0x011b;
        L_0x0199:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = 2130837662; // 0x7f02009e float:1.7280284E38 double:1.0527736857E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0170 }
            goto L_0x00e2;
        L_0x01a7:
            r5 = move-exception;
            r5.printStackTrace();
            goto L_0x011b;
        L_0x01ad:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = 2130837658; // 0x7f02009a float:1.7280276E38 double:1.0527736837E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0170 }
            goto L_0x00e2;
        L_0x01bb:
            r5 = move-exception;
            r8 = com.dev.system.monitor.MobileManagement.this;
            r8.setDataManually();
            goto L_0x011b;
        L_0x01c3:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = 2130837663; // 0x7f02009f float:1.7280286E38 double:1.052773686E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0170 }
            goto L_0x00e2;
        L_0x01d1:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0170 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0170 }
            r10 = 2130837659; // 0x7f02009b float:1.7280278E38 double:1.052773684E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0170 }
            goto L_0x00e2;
        L_0x01df:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x01ee }
            r8 = r8.getActivity();	 Catch:{ NullPointerException -> 0x01ee }
            r10 = r3.getLine1Number();	 Catch:{ NullPointerException -> 0x01ee }
            r8.setTitle(r10);	 Catch:{ NullPointerException -> 0x01ee }
            goto L_0x010e;
        L_0x01ee:
            r5 = move-exception;
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 2131624009; // 0x7f0e0049 float:1.8875186E38 double:1.0531621927E-314;
            r10 = r10.getString(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.setTitle(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x010e;
        L_0x0203:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = "phone";
            r7 = r8.getSystemService(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r7 = (android.telephony.TelephonyManager) r7;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r7.getClass();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getName();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = java.lang.Class.forName(r8);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = "setDataEnabled";
            r11 = 1;
            r11 = new java.lang.Class[r11];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r12 = 0;
            r13 = java.lang.Boolean.TYPE;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11[r12] = r13;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6 = r8.getDeclaredMethod(r10, r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 0;
            r11 = 1;
            r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8[r10] = r11;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6.invoke(r7, r8);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r8 == 0) goto L_0x024d;
        L_0x0241:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r8 != 0) goto L_0x0260;
        L_0x024d:
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = "connectivity";
            r8 = r8.getSystemService(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = (android.net.ConnectivityManager) r8;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10.conman = r8;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x0260:
            r8 = 1;
            r6.setAccessible(r8);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r8 == 0) goto L_0x033a;
        L_0x0270:
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 0;
            r11 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = r11.conman;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = r11.getActiveNetworkInfo();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = r11.isConnected();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r11 == 0) goto L_0x0285;
        L_0x0284:
            r1 = r9;
        L_0x0285:
            r11 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8[r10] = r11;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6.invoke(r7, r8);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x028e:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            if (r1 == 0) goto L_0x034a;
        L_0x0296:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 2131624013; // 0x7f0e004d float:1.8875194E38 double:1.0531621947E-314;
            r8 = r8.getString(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
        L_0x029f:
            r11 = 1;
            r8 = android.widget.Toast.makeText(r10, r8, r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.show();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.conman;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.getType();	 Catch:{ NullPointerException -> 0x0362 }
            if (r8 != 0) goto L_0x02ea;
        L_0x02b7:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.conman;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.getSubtype();	 Catch:{ NullPointerException -> 0x0362 }
            switch(r8) {
                case 1: goto L_0x0387;
                case 2: goto L_0x0355;
                case 3: goto L_0x0395;
                case 4: goto L_0x0355;
                case 5: goto L_0x02c8;
                case 6: goto L_0x02c8;
                case 7: goto L_0x0355;
                case 8: goto L_0x03a3;
                case 9: goto L_0x03a3;
                case 10: goto L_0x0395;
                case 11: goto L_0x02c8;
                case 12: goto L_0x03a3;
                case 13: goto L_0x03bf;
                case 14: goto L_0x03a3;
                case 15: goto L_0x03b1;
                default: goto L_0x02c8;
            };	 Catch:{ NullPointerException -> 0x0362 }
        L_0x02c8:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0362 }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.TX;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = "";
            r8.setText(r10);	 Catch:{ NullPointerException -> 0x0362 }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.RX;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = "";
            r8.setText(r10);	 Catch:{ NullPointerException -> 0x0362 }
        L_0x02ea:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = "phone";
            r3 = r8.getSystemService(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r3 = (android.telephony.TelephonyManager) r3;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = new com.dev.system.monitor.MobileManagement$MobileDataGeneralTask;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.<init>();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 0;
            r10 = new java.lang.Void[r10];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.execute(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r3.getLine1Number();	 Catch:{ NullPointerException -> 0x0325 }
            r10 = "";
            r8 = r8.equals(r10);	 Catch:{ NullPointerException -> 0x0325 }
            if (r8 == 0) goto L_0x03cd;
        L_0x0311:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0325 }
            r8 = r8.getActivity();	 Catch:{ NullPointerException -> 0x0325 }
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0325 }
            r11 = 2131624009; // 0x7f0e0049 float:1.8875186E38 double:1.0531621927E-314;
            r10 = r10.getString(r11);	 Catch:{ NullPointerException -> 0x0325 }
            r8.setTitle(r10);	 Catch:{ NullPointerException -> 0x0325 }
            goto L_0x011b;
        L_0x0325:
            r5 = move-exception;
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.getActivity();	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 2131624009; // 0x7f0e0049 float:1.8875186E38 double:1.0531621927E-314;
            r10 = r10.getString(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8.setTitle(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x011b;
        L_0x033a:
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 0;
            r1 = 1;
            r11 = java.lang.Boolean.valueOf(r1);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8[r10] = r11;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r6.invoke(r7, r8);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x028e;
        L_0x034a:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r11 = 2131624012; // 0x7f0e004c float:1.8875192E38 double:1.053162194E-314;
            r8 = r8.getString(r11);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x029f;
        L_0x0355:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = 2130837660; // 0x7f02009c float:1.728028E38 double:1.0527736847E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0362 }
            goto L_0x02ea;
        L_0x0362:
            r5 = move-exception;
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.mobileImg;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = 2130837665; // 0x7f0200a1 float:1.728029E38 double:1.052773687E-314;
            r8.setImageResource(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.TX;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = "";
            r8.setText(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r8 = r8.RX;	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            r10 = "";
            r8.setText(r10);	 Catch:{ IllegalAccessException -> 0x0152, InvocationTargetException -> 0x017f, NoSuchMethodException -> 0x0194, ClassNotFoundException -> 0x01a7, SecurityException -> 0x01bb }
            goto L_0x02ea;
        L_0x0387:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = 2130837661; // 0x7f02009d float:1.7280282E38 double:1.052773685E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0362 }
            goto L_0x02ea;
        L_0x0395:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = 2130837662; // 0x7f02009e float:1.7280284E38 double:1.0527736857E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0362 }
            goto L_0x02ea;
        L_0x03a3:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = 2130837658; // 0x7f02009a float:1.7280276E38 double:1.0527736837E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0362 }
            goto L_0x02ea;
        L_0x03b1:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = 2130837663; // 0x7f02009f float:1.7280286E38 double:1.052773686E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0362 }
            goto L_0x02ea;
        L_0x03bf:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0362 }
            r8 = r8.mobileImg;	 Catch:{ NullPointerException -> 0x0362 }
            r10 = 2130837659; // 0x7f02009b float:1.7280278E38 double:1.052773684E-314;
            r8.setImageResource(r10);	 Catch:{ NullPointerException -> 0x0362 }
            goto L_0x02ea;
        L_0x03cd:
            r8 = com.dev.system.monitor.MobileManagement.this;	 Catch:{ NullPointerException -> 0x0325 }
            r8 = r8.getActivity();	 Catch:{ NullPointerException -> 0x0325 }
            r10 = r3.getLine1Number();	 Catch:{ NullPointerException -> 0x0325 }
            r8.setTitle(r10);	 Catch:{ NullPointerException -> 0x0325 }
            goto L_0x011b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dev.system.monitor.MobileManagement.3.onLongClick(android.view.View):boolean");
        }
    }

    /* renamed from: com.dev.system.monitor.MobileManagement.4 */
    class C01254 implements OnClickListener {
        C01254() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }

    /* renamed from: com.dev.system.monitor.MobileManagement.5 */
    class C01265 implements OnClickListener {
        C01265() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent();
            intent.setAction("android.settings.SETTINGS");
            MobileManagement.this.startActivityForResult(intent, 100);
            dialog.dismiss();
        }
    }

    private class MobileDataGeneralTask extends AsyncTask<Void, Void, Void> {
        ArrayList<String> info;
        private String ip;
        ArrayList<String> value;

        public MobileDataGeneralTask() {
            this.ip = BuildConfig.VERSION_NAME;
            this.info = new ArrayList();
            this.value = new ArrayList();
        }

        protected Void doInBackground(Void... params) {
            boolean done = false;
            try {
                Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                while (en.hasMoreElements()) {
                    Enumeration<InetAddress> enumIpAddr = ((NetworkInterface) en.nextElement()).getInetAddresses();
                    while (enumIpAddr.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress() && InetAddressUtils.isIPv4Address(inetAddress.getHostAddress())) {
                            this.ip = inetAddress.getHostAddress().toString();
                            done = true;
                            break;
                            continue;
                        }
                    }
                    if (done) {
                        break;
                    }
                }
                if (MobileManagement.this.data == null) {
                    MobileManagement.this.data = (TelephonyManager) MobileManagement.this.getActivity().getSystemService("phone");
                }
                this.info.add(MobileManagement.this.getString(C0133R.string.ip));
                this.value.add(this.ip);
                this.info.add("IMEI");
                this.value.add(MobileManagement.this.data.getDeviceId());
                this.info.add(MobileManagement.this.getString(C0133R.string.isp));
                this.value.add(MobileManagement.this.data.getNetworkOperatorName());
                publishProgress(new Void[0]);
            } catch (SocketException e) {
            }
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            try {
                MobileManagement.this.initCard(this.info, this.value);
            } catch (NullPointerException e) {
                new MobileDataGeneralTask().execute(new Void[0]);
            }
            super.onProgressUpdate(values);
        }
    }

    public MobileManagement() {
        this.startRX = 0;
        this.startTX = 0;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.rootView = inflater.inflate(C0133R.layout.fragment_mobile, container, false);
        this.startRX = TrafficStats.getTotalRxBytes();
        this.startTX = TrafficStats.getTotalTxBytes();
        this.RX = (TextView) this.rootView.findViewById(C0133R.id.dataDown);
        this.TX = (TextView) this.rootView.findViewById(C0133R.id.dataUp);
        this.runnable = new C01221();
        if (!(this.startRX == -1 || this.startTX == -1)) {
            this.handler = new Handler();
            this.handler.postDelayed(this.runnable, 1000);
        }
        this.mobileImg = (ImageView) this.rootView.findViewById(C0133R.id.signalMobileImg);
        setMobileData();
        this.mobileData = new C01232();
        getActivity().registerReceiver(this.mobileData, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.mobileImg.setOnLongClickListener(new C01243());
        return this.rootView;
    }

    private void setMobileData() {
        try {
            this.conman = (ConnectivityManager) getActivity().getSystemService("connectivity");
            if (this.conman.getActiveNetworkInfo().getType() == 0) {
                switch (this.conman.getActiveNetworkInfo().getSubtype()) {
                    case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                        this.mobileImg.setImageResource(C0133R.drawable.mobileg);
                        break;
                    case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY /*4*/:
                    case C0158R.styleable.ShowcaseView_sv_titleTextAppearance /*7*/:
                        this.mobileImg.setImageResource(C0133R.drawable.mobilee);
                        break;
                    case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                    case Card.CLICK_LISTENER_CONTENT_VIEW /*10*/:
                        this.mobileImg.setImageResource(C0133R.drawable.mobilehspa);
                        break;
                    case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    case C0158R.styleable.ShowcaseView_sv_tintButtonColor /*9*/:
                    case C0149R.styleable.MenuItem_android_onClick /*12*/:
                    case C0149R.styleable.MenuItem_actionLayout /*14*/:
                        this.mobileImg.setImageResource(C0133R.drawable.mobile3g);
                        break;
                    case C0149R.styleable.MenuItem_showAsAction /*13*/:
                        this.mobileImg.setImageResource(C0133R.drawable.mobile4g);
                        break;
                    case C0149R.styleable.MenuItem_actionViewClass /*15*/:
                        this.mobileImg.setImageResource(C0133R.drawable.mobilehspaplus);
                        break;
                    default:
                        this.mobileImg.setImageResource(C0133R.drawable.mobileoff);
                        this.TX.setText(BuildConfig.VERSION_NAME);
                        this.RX.setText(BuildConfig.VERSION_NAME);
                        break;
                }
            }
            this.mobileImg.setImageResource(C0133R.drawable.mobileoff);
            this.TX.setText(BuildConfig.VERSION_NAME);
            this.RX.setText(BuildConfig.VERSION_NAME);
            this.data = (TelephonyManager) getActivity().getSystemService("phone");
            new MobileDataGeneralTask().execute(new Void[0]);
            if (this.data.getLine1Number().equals(BuildConfig.VERSION_NAME)) {
                getActivity().setTitle(getString(C0133R.string.mobile));
            } else {
                getActivity().setTitle(this.data.getLine1Number());
            }
        } catch (Exception e) {
            this.mobileImg.setImageResource(C0133R.drawable.mobileoff);
            this.TX.setText(BuildConfig.VERSION_NAME);
            this.RX.setText(BuildConfig.VERSION_NAME);
        }
    }

    public void onPause() {
        getActivity().unregisterReceiver(this.mobileData);
        try {
            if (this.card != null) {
                this.card.unregisterDataSetObserver();
            }
        } catch (IllegalStateException e) {
        }
        super.onPause();
    }

    private void setDataManually() {
        new Builder(getActivity()).setMessage(getString(C0133R.string.mobile_msg)).setPositiveButton(getString(C0133R.string.ok), new C01265()).setNegativeButton(getString(C0133R.string.cancel), new C01254()).show();
    }

    public void onResume() {
        getActivity().registerReceiver(this.mobileData, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        super.onResume();
    }

    private void initCard(ArrayList<String> info, ArrayList<String> value) {
        this.card = new GeneralInfoCard(getActivity(), info, value, getString(C0133R.string.mobile_info));
        this.card.init();
        ((CardView) this.rootView.findViewById(C0133R.id.card_mobile)).setCard(this.card);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            setMobileData();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
