package com.appfour.common.gcm;

import android.app.IntentService;

public class GcmIntentService extends IntentService {
    public GcmIntentService() {
        super("GcmIntentService");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onHandleIntent(android.content.Intent r9) {
        /*
        r8 = this;
        r4 = 3;
        r3 = 2;
        r2 = 1;
        r0 = 0;
        r1 = -1;
        r6 = r9.getExtras();	 Catch:{ all -> 0x00ae }
        r5 = com.google.android.gms.gcm.a.j6(r8);	 Catch:{ all -> 0x00ae }
        r7 = r5.j6(r9);	 Catch:{ all -> 0x00ae }
        if (r7 != 0) goto L_0x001d;
    L_0x0013:
        r0 = "GCM: Null message type";
        com.appfour.common.gcm.a.j6(r0);	 Catch:{ all -> 0x00ae }
        android.support.v4.content.WakefulBroadcastReceiver.j6(r9);
    L_0x001c:
        return;
    L_0x001d:
        r6.isEmpty();	 Catch:{ all -> 0x00ae }
        r5 = r7.hashCode();	 Catch:{ all -> 0x00ae }
        switch(r5) {
            case -2062414158: goto L_0x006b;
            case 102161: goto L_0x0076;
            case 814694033: goto L_0x0060;
            case 814800675: goto L_0x0055;
            default: goto L_0x0027;
        };	 Catch:{ all -> 0x00ae }
    L_0x0027:
        r5 = r1;
    L_0x0028:
        switch(r5) {
            case 0: goto L_0x0081;
            case 1: goto L_0x00b3;
            case 2: goto L_0x00b3;
            case 3: goto L_0x00db;
            default: goto L_0x002b;
        };	 Catch:{ all -> 0x00ae }
    L_0x002b:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r0.<init>();	 Catch:{ all -> 0x00ae }
        r1 = "GCM Received message of unknown type: ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r7);	 Catch:{ all -> 0x00ae }
        r1 = " extras: ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r1 = r6.toString();	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
    L_0x0051:
        android.support.v4.content.WakefulBroadcastReceiver.j6(r9);
        goto L_0x001c;
    L_0x0055:
        r5 = "send_event";
        r5 = r7.equals(r5);	 Catch:{ all -> 0x00ae }
        if (r5 == 0) goto L_0x0027;
    L_0x005e:
        r5 = r0;
        goto L_0x0028;
    L_0x0060:
        r5 = "send_error";
        r5 = r7.equals(r5);	 Catch:{ all -> 0x00ae }
        if (r5 == 0) goto L_0x0027;
    L_0x0069:
        r5 = r2;
        goto L_0x0028;
    L_0x006b:
        r5 = "deleted_messages";
        r5 = r7.equals(r5);	 Catch:{ all -> 0x00ae }
        if (r5 == 0) goto L_0x0027;
    L_0x0074:
        r5 = r3;
        goto L_0x0028;
    L_0x0076:
        r5 = "gcm";
        r5 = r7.equals(r5);	 Catch:{ all -> 0x00ae }
        if (r5 == 0) goto L_0x0027;
    L_0x007f:
        r5 = r4;
        goto L_0x0028;
    L_0x0081:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r0.<init>();	 Catch:{ all -> 0x00ae }
        r1 = "GCM Received message of type sent: ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r1 = r6.toString();	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
        r0 = com.appfour.common.gcm.b.j6();	 Catch:{ all -> 0x00ae }
        r1 = "google.message_id";
        r2 = "";
        r1 = r6.getString(r1, r2);	 Catch:{ all -> 0x00ae }
        r0.DW(r1);	 Catch:{ all -> 0x00ae }
        goto L_0x0051;
    L_0x00ae:
        r0 = move-exception;
        android.support.v4.content.WakefulBroadcastReceiver.j6(r9);
        throw r0;
    L_0x00b3:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r0.<init>();	 Catch:{ all -> 0x00ae }
        r1 = "GCM Received message of type ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r7);	 Catch:{ all -> 0x00ae }
        r1 = ": ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r1 = r6.toString();	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
        goto L_0x0051;
    L_0x00db:
        r5 = "action";
        r7 = "";
        r5 = r6.getString(r5, r7);	 Catch:{ all -> 0x00ae }
        r7 = r5.hashCode();	 Catch:{ all -> 0x00ae }
        switch(r7) {
            case -788388728: goto L_0x0122;
            case 0: goto L_0x012d;
            case 3441010: goto L_0x010d;
            case 1305744757: goto L_0x0117;
            default: goto L_0x00ec;
        };	 Catch:{ all -> 0x00ae }
    L_0x00ec:
        r0 = r1;
    L_0x00ed:
        switch(r0) {
            case 0: goto L_0x0138;
            case 1: goto L_0x0155;
            case 2: goto L_0x0174;
            case 3: goto L_0x019e;
            default: goto L_0x00f0;
        };	 Catch:{ all -> 0x00ae }
    L_0x00f0:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r0.<init>();	 Catch:{ all -> 0x00ae }
        r1 = "GCM Received message with unknown action: ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r1 = r6.toString();	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
        goto L_0x0051;
    L_0x010d:
        r2 = "ping";
        r2 = r5.equals(r2);	 Catch:{ all -> 0x00ae }
        if (r2 == 0) goto L_0x00ec;
    L_0x0116:
        goto L_0x00ed;
    L_0x0117:
        r0 = "acknowledgeRegistration";
        r0 = r5.equals(r0);	 Catch:{ all -> 0x00ae }
        if (r0 == 0) goto L_0x00ec;
    L_0x0120:
        r0 = r2;
        goto L_0x00ed;
    L_0x0122:
        r0 = "showNotification";
        r0 = r5.equals(r0);	 Catch:{ all -> 0x00ae }
        if (r0 == 0) goto L_0x00ec;
    L_0x012b:
        r0 = r3;
        goto L_0x00ed;
    L_0x012d:
        r0 = "";
        r0 = r5.equals(r0);	 Catch:{ all -> 0x00ae }
        if (r0 == 0) goto L_0x00ec;
    L_0x0136:
        r0 = r4;
        goto L_0x00ed;
    L_0x0138:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r0.<init>();	 Catch:{ all -> 0x00ae }
        r1 = "GCM Received ping action: ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r1 = r6.toString();	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
        goto L_0x0051;
    L_0x0155:
        r0 = "GCM Received acknowledge registration action";
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
        r0 = "id";
        r1 = "";
        r0 = r6.getString(r0, r1);	 Catch:{ all -> 0x00ae }
        r1 = r0.isEmpty();	 Catch:{ all -> 0x00ae }
        if (r1 != 0) goto L_0x0051;
    L_0x016b:
        r1 = com.appfour.common.gcm.b.j6();	 Catch:{ all -> 0x00ae }
        r1.j6(r0);	 Catch:{ all -> 0x00ae }
        goto L_0x0051;
    L_0x0174:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r0.<init>();	 Catch:{ all -> 0x00ae }
        r1 = "GCM Show notification action: ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r1 = r6.toString();	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
        r0 = com.appfour.common.gcm.d.j6(r6);	 Catch:{ all -> 0x00ae }
        if (r0 == 0) goto L_0x0051;
    L_0x0195:
        r1 = com.appfour.common.gcm.b.j6();	 Catch:{ all -> 0x00ae }
        r1.j6(r0);	 Catch:{ all -> 0x00ae }
        goto L_0x0051;
    L_0x019e:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
        r0.<init>();	 Catch:{ all -> 0x00ae }
        r1 = "GCM Received message without action";
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r1 = r6.toString();	 Catch:{ all -> 0x00ae }
        r0 = r0.append(r1);	 Catch:{ all -> 0x00ae }
        r0 = r0.toString();	 Catch:{ all -> 0x00ae }
        com.appfour.common.gcm.a.DW(r0);	 Catch:{ all -> 0x00ae }
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appfour.common.gcm.GcmIntentService.onHandleIntent(android.content.Intent):void");
    }
}
