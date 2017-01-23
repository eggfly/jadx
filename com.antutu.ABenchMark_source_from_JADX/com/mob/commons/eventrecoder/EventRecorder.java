package com.mob.commons.eventrecoder;

import android.content.Context;
import android.text.TextUtils;
import com.mob.commons.C3991e;
import com.mob.tools.MobLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import org.android.agoo.message.MessageService;

public final class EventRecorder {
    private static Context f13359a;
    private static File f13360b;
    private static FileOutputStream f13361c;

    /* renamed from: com.mob.commons.eventrecoder.EventRecorder.1 */
    static class C39921 implements Runnable {
        C39921() {
        }

        public void run() {
            try {
                EventRecorder.f13360b = new File(EventRecorder.f13359a.getFilesDir(), ".mrecord");
                if (!EventRecorder.f13360b.exists()) {
                    EventRecorder.f13360b.createNewFile();
                }
                EventRecorder.f13361c = new FileOutputStream(EventRecorder.f13360b, true);
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }

    /* renamed from: com.mob.commons.eventrecoder.EventRecorder.2 */
    static class C39932 implements Runnable {
        final /* synthetic */ String f13356a;

        C39932(String str) {
            this.f13356a = str;
        }

        public void run() {
            try {
                EventRecorder.f13361c.write(this.f13356a.getBytes("utf-8"));
                EventRecorder.f13361c.flush();
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }

    /* renamed from: com.mob.commons.eventrecoder.EventRecorder.3 */
    static class C39943 implements Runnable {
        final /* synthetic */ String f13357a;
        final /* synthetic */ LinkedList f13358b;

        C39943(String str, LinkedList linkedList) {
            this.f13357a = str;
            this.f13358b = linkedList;
        }

        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(EventRecorder.f13360b), "utf-8"));
                for (Object readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine); readLine = bufferedReader.readLine()) {
                    String[] split = readLine.split(" ");
                    if (this.f13357a.equals(split[0])) {
                        if (MessageService.MSG_DB_READY_REPORT.equals(split[2])) {
                            this.f13358b.add(split[1]);
                        } else if (MessageService.MSG_DB_NOTIFY_REACHED.equals(split[2])) {
                            int indexOf = this.f13358b.indexOf(split[1]);
                            if (indexOf != -1) {
                                this.f13358b.remove(indexOf);
                            }
                        }
                    }
                }
                bufferedReader.close();
            } catch (Throwable th) {
                MobLog.getInstance().m4376d(th);
            }
        }
    }

    /* renamed from: com.mob.commons.eventrecoder.EventRecorder.4 */
    static class C39954 implements Runnable {
        C39954() {
        }

        public void run() {
            try {
                EventRecorder.f13361c.close();
                EventRecorder.f13360b.delete();
                EventRecorder.f13360b = new File(EventRecorder.f13359a.getFilesDir(), ".mrecord");
                EventRecorder.f13360b.createNewFile();
                EventRecorder.f13361c = new FileOutputStream(EventRecorder.f13360b, true);
            } catch (Throwable th) {
                MobLog.getInstance().m4388w(th);
            }
        }
    }

    private static final void m16447a(Runnable runnable) {
        C3991e.m16442a(new File(f13359a.getFilesDir(), "comm/locks/.mrlock"), runnable);
    }

    private static final void m16448a(String str) {
        m16447a(new C39932(str));
    }

    public static final synchronized void addBegin(String str, String str2) {
        synchronized (EventRecorder.class) {
            m16448a(str + " " + str2 + " 0\n");
        }
    }

    public static final synchronized void addEnd(String str, String str2) {
        synchronized (EventRecorder.class) {
            m16448a(str + " " + str2 + " 1\n");
        }
    }

    public static final synchronized String checkRecord(String str) {
        String str2;
        synchronized (EventRecorder.class) {
            LinkedList linkedList = new LinkedList();
            m16447a(new C39943(str, linkedList));
            str2 = linkedList.size() > 0 ? (String) linkedList.get(0) : null;
        }
        return str2;
    }

    public static final synchronized void clear() {
        synchronized (EventRecorder.class) {
            m16447a(new C39954());
        }
    }

    public static final synchronized void prepare(Context context) {
        synchronized (EventRecorder.class) {
            f13359a = context.getApplicationContext();
            m16447a(new C39921());
        }
    }
}
