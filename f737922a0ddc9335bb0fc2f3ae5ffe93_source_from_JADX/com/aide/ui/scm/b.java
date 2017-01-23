package com.aide.ui.scm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.activities.CommitActivity;
import com.aide.ui.h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import nv;
import qh;

public class b {
    private ServiceConnection DW;
    private ThreadPoolExecutor FH;
    private a Hw;
    private c j6;
    private Object v5;

    public interface d<TResult> {
        void DW();

        void j6();

        void j6(TResult tResult);
    }

    public interface c extends d<Void> {
    }

    class 10 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ a FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ 10 j6;

            1(10 10) {
                this.j6 = 10;
            }

            public void run() {
                this.j6.FH.j6(null);
                Toast.makeText(com.aide.ui.e.tp(), "Switched to branch '" + this.j6.DW + "'", 0).show();
            }
        }

        10(b bVar, String str, String str2, a aVar) {
            this.Hw = bVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = aVar;
        }

        public void run() {
            try {
                this.Hw.tp();
                this.Hw.j6.j6(this.j6, this.DW, null, this.FH);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.FH.j6(e, null);
            }
        }
    }

    class 11 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ a Hw;
        final /* synthetic */ String j6;
        final /* synthetic */ b v5;

        class 1 implements Runnable {
            final /* synthetic */ 11 j6;

            1(11 11) {
                this.j6 = 11;
            }

            public void run() {
                this.j6.Hw.j6(null);
                Toast.makeText(com.aide.ui.e.tp(), "Switched to branch '" + this.j6.FH + "'", 0).show();
                this.j6.v5.Ws(this.j6.DW);
            }
        }

        11(b bVar, String str, String str2, String str3, a aVar) {
            this.v5 = bVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = str3;
            this.Hw = aVar;
        }

        public void run() {
            try {
                this.v5.tp();
                if (this.j6 != null) {
                    this.v5.j6.j6(this.DW, this.FH, this.j6, this.Hw);
                } else {
                    this.v5.j6.Hw(this.DW, this.FH, this.Hw);
                }
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.Hw.j6(e, null);
            }
        }
    }

    class 12 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ List Hw;
        final /* synthetic */ b VH;
        final /* synthetic */ Runnable Zo;
        final /* synthetic */ GitConfiguration j6;
        final /* synthetic */ a v5;

        class 1 implements Runnable {
            final /* synthetic */ 12 j6;

            1(12 12) {
                this.j6 = 12;
            }

            public void run() {
                this.j6.v5.j6(null);
                if (this.j6.Zo != null) {
                    this.j6.Zo.run();
                }
            }
        }

        12(b bVar, GitConfiguration gitConfiguration, String str, String str2, List list, a aVar, Runnable runnable) {
            this.VH = bVar;
            this.j6 = gitConfiguration;
            this.DW = str;
            this.FH = str2;
            this.Hw = list;
            this.v5 = aVar;
            this.Zo = runnable;
        }

        public void run() {
            try {
                this.VH.tp();
                this.VH.j6.j6(this.j6, this.DW, this.FH, this.Hw, this.v5);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.v5.j6(e, null);
            }
        }
    }

    class 13 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ String FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ b Zo;
        final /* synthetic */ GitConfiguration j6;
        final /* synthetic */ a v5;

        class 1 implements Runnable {
            final /* synthetic */ 13 j6;

            1(13 13) {
                this.j6 = 13;
            }

            public void run() {
                this.j6.v5.j6(null);
                com.aide.ui.e.er().j6(new File(this.j6.DW, this.j6.FH).getPath());
            }
        }

        13(b bVar, GitConfiguration gitConfiguration, String str, String str2, String str3, a aVar) {
            this.Zo = bVar;
            this.j6 = gitConfiguration;
            this.DW = str;
            this.FH = str2;
            this.Hw = str3;
            this.v5 = aVar;
        }

        public void run() {
            try {
                this.Zo.tp();
                this.Zo.j6.j6(this.j6, this.DW, this.FH, this.Hw, this.v5);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.v5.j6(e, null);
            }
        }
    }

    class 14 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ a FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ GitConfiguration j6;

        class 1 implements Runnable {
            final /* synthetic */ 14 j6;

            1(14 14) {
                this.j6 = 14;
            }

            public void run() {
                this.j6.FH.j6(null);
                this.j6.Hw.Ws(this.j6.DW);
            }
        }

        14(b bVar, GitConfiguration gitConfiguration, String str, a aVar) {
            this.Hw = bVar;
            this.j6 = gitConfiguration;
            this.DW = str;
            this.FH = aVar;
        }

        public void run() {
            try {
                this.Hw.tp();
                this.Hw.j6.j6(this.j6, this.DW, this.FH);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.FH.j6(e, null);
            }
        }
    }

    class 15 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ String FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ 15 DW;
            final /* synthetic */ String j6;

            class 1 implements Runnable {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public void run() {
                    this.j6.DW.Hw.J8(this.j6.DW.FH);
                }
            }

            1(15 15, String str) {
                this.DW = 15;
                this.j6 = str;
            }

            public void run() {
                this.DW.DW.j6(null);
                m.DW(com.aide.ui.e.tp(), "Git", "Push branch '" + this.DW.Hw.J0(this.j6) + "' to remote?", new 1(this), null);
            }
        }

        15(b bVar, String str, a aVar, String str2) {
            this.Hw = bVar;
            this.j6 = str;
            this.DW = aVar;
            this.FH = str2;
        }

        public void run() {
            try {
                this.Hw.tp();
                com.aide.ui.e.j6(new 1(this, this.Hw.j6.DW(this.j6, this.DW)));
            } catch (RemoteException e) {
                this.DW.j6(e, null);
            }
        }
    }

    class 16 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ a FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ GitConfiguration j6;

        class 1 implements Runnable {
            final /* synthetic */ 16 j6;

            1(16 16) {
                this.j6 = 16;
            }

            public void run() {
                this.j6.FH.j6(null);
            }
        }

        16(b bVar, GitConfiguration gitConfiguration, String str, a aVar) {
            this.Hw = bVar;
            this.j6 = gitConfiguration;
            this.DW = str;
            this.FH = aVar;
        }

        public void run() {
            try {
                this.Hw.tp();
                this.Hw.j6.DW(this.j6, this.DW, this.FH);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.FH.j6(e, null);
            }
        }
    }

    class 17 implements Runnable {
        final /* synthetic */ b j6;

        17(b bVar) {
            this.j6 = bVar;
        }

        public void run() {
            com.aide.ui.e.u7().FH(5);
        }
    }

    class 18 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ b FH;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ String DW;
            final /* synthetic */ 18 FH;
            final /* synthetic */ GitStatus j6;

            1(18 18, GitStatus gitStatus, String str) {
                this.FH = 18;
                this.j6 = gitStatus;
                this.DW = str;
            }

            public void run() {
                if (!this.FH.DW.j6(null)) {
                    return;
                }
                if (this.j6.j6()) {
                    m.j6(com.aide.ui.e.tp(), "Git", "No modified files found.", null);
                } else {
                    CommitActivity.j6(com.aide.ui.e.u7(), this.j6, this.DW);
                }
            }
        }

        18(b bVar, String str, a aVar) {
            this.FH = bVar;
            this.j6 = str;
            this.DW = aVar;
        }

        public void run() {
            try {
                this.FH.tp();
                com.aide.ui.e.j6(new 1(this, this.FH.j6.j6(this.j6, this.DW), this.FH.j6.DW(this.j6, this.DW)));
            } catch (RemoteException e) {
                this.DW.j6(e, null);
            }
        }
    }

    class 19 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ List FH;
        final /* synthetic */ String Hw;
        final /* synthetic */ b VH;
        final /* synthetic */ c Zo;
        final /* synthetic */ GitConfiguration j6;
        final /* synthetic */ a v5;

        class 1 implements Runnable {
            final /* synthetic */ 19 j6;

            1(19 19) {
                this.j6 = 19;
            }

            public void run() {
                if (!this.j6.v5.j6(this.j6.Zo)) {
                }
            }
        }

        19(b bVar, GitConfiguration gitConfiguration, String str, List list, String str2, a aVar, c cVar) {
            this.VH = bVar;
            this.j6 = gitConfiguration;
            this.DW = str;
            this.FH = list;
            this.Hw = str2;
            this.v5 = aVar;
            this.Zo = cVar;
        }

        public void run() {
            try {
                this.VH.tp();
                this.VH.j6.j6(this.j6, this.DW, this.FH, this.Hw, this.v5);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.v5.j6(e, this.Zo);
            }
        }
    }

    class 1 implements ServiceConnection {
        final /* synthetic */ b j6;

        1(b bVar) {
            this.j6 = bVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this.j6.v5) {
                this.j6.j6 = com.aide.ui.scm.c.a.j6(iBinder);
                this.j6.v5.notify();
            }
            com.aide.common.e.DW("External Git service connected");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.j6.v5) {
                this.j6.j6 = null;
            }
            com.aide.common.e.DW("External Git service disconnected");
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ List DW;
        final /* synthetic */ a FH;
        final /* synthetic */ c Hw;
        final /* synthetic */ String j6;
        final /* synthetic */ b v5;

        class 1 implements Runnable {
            final /* synthetic */ 2 j6;

            1(2 2) {
                this.j6 = 2;
            }

            public void run() {
                if (!this.j6.FH.j6(this.j6.Hw)) {
                }
            }
        }

        2(b bVar, String str, List list, a aVar, c cVar) {
            this.v5 = bVar;
            this.j6 = str;
            this.DW = list;
            this.FH = aVar;
            this.Hw = cVar;
        }

        public void run() {
            try {
                this.v5.tp();
                this.v5.j6.j6(this.j6, this.DW, this.FH);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.FH.j6(e, this.Hw);
            }
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ a FH;
        final /* synthetic */ d Hw;
        final /* synthetic */ String j6;
        final /* synthetic */ b v5;

        class 1 implements Runnable {
            final /* synthetic */ 3 DW;
            final /* synthetic */ String j6;

            1(3 3, String str) {
                this.DW = 3;
                this.j6 = str;
            }

            public void run() {
                if (!this.DW.FH.j6(this.DW.Hw, this.j6)) {
                }
            }
        }

        3(b bVar, String str, String str2, a aVar, d dVar) {
            this.v5 = bVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = aVar;
            this.Hw = dVar;
        }

        public void run() {
            try {
                this.v5.tp();
                com.aide.ui.e.j6(new 1(this, this.v5.j6.j6(this.j6, this.DW, this.FH)));
            } catch (RemoteException e) {
                this.FH.j6(e, this.Hw);
            }
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ b FH;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ String DW;
            final /* synthetic */ 4 FH;
            final /* synthetic */ List j6;

            class 1 implements y<Integer> {
                final /* synthetic */ 1 DW;
                final /* synthetic */ List j6;

                class 1 implements Runnable {
                    final /* synthetic */ 1 DW;
                    final /* synthetic */ String j6;

                    1(1 1, String str) {
                        this.DW = 1;
                        this.j6 = str;
                    }

                    public void run() {
                        this.DW.DW.FH.FH.DW(this.DW.DW.FH.j6, this.j6);
                    }
                }

                1(1 1, List list) {
                    this.DW = 1;
                    this.j6 = list;
                }

                public void j6(Integer num) {
                    String str = (String) this.j6.get(num.intValue());
                    if (!str.endsWith(" (current)")) {
                        m.DW(com.aide.ui.e.u7(), "Git", "Really delete branch '" + str + "'?", new 1(this, str), null);
                    }
                }
            }

            1(4 4, List list, String str) {
                this.FH = 4;
                this.j6 = list;
                this.DW = str;
            }

            public void run() {
                if (this.FH.DW.j6(null) && !this.j6.isEmpty()) {
                    List arrayList = new ArrayList();
                    for (int i = 0; i < this.j6.size(); i++) {
                        String str = (String) this.j6.get(i);
                        if (!str.startsWith("remotes/")) {
                            if (str.equals(this.DW)) {
                                str = str + " (current)";
                            }
                            arrayList.add(this.FH.FH.J0(str));
                        }
                    }
                    m.DW(com.aide.ui.e.u7(), "Select branch to delete", arrayList, new 1(this, arrayList));
                }
            }
        }

        4(b bVar, String str, a aVar) {
            this.FH = bVar;
            this.j6 = str;
            this.DW = aVar;
        }

        public void run() {
            try {
                List FH;
                this.FH.tp();
                String DW = this.FH.j6.DW(this.j6, this.DW);
                if (DW != null) {
                    FH = this.FH.j6.FH(this.j6, this.DW);
                } else {
                    FH = new ArrayList();
                }
                com.aide.ui.e.j6(new 1(this, FH, DW));
            } catch (RemoteException e) {
                this.DW.j6(e, null);
            }
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ a FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ 5 j6;

            1(5 5) {
                this.j6 = 5;
            }

            public void run() {
                this.j6.FH.j6(null);
            }
        }

        5(b bVar, String str, String str2, a aVar) {
            this.Hw = bVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = aVar;
        }

        public void run() {
            try {
                this.Hw.tp();
                this.Hw.j6.DW(this.j6, this.DW, this.FH);
                com.aide.ui.e.j6(new 1(this));
            } catch (RemoteException e) {
                this.FH.j6(e, null);
            }
        }
    }

    class 6 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ b FH;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ String DW;
            final /* synthetic */ 6 FH;
            final /* synthetic */ List j6;

            class 1 implements y<Integer> {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public void j6(Integer num) {
                    String str = (String) this.j6.j6.get(num.intValue());
                    if (!str.endsWith(" (current)")) {
                        this.j6.FH.FH.DW(this.j6.FH.j6, this.j6.FH.FH.J0(this.j6.DW), str);
                    }
                }
            }

            1(6 6, List list, String str) {
                this.FH = 6;
                this.j6 = list;
                this.DW = str;
            }

            public void run() {
                if (this.FH.DW.j6(null) && !this.j6.isEmpty()) {
                    for (int i = 0; i < this.j6.size(); i++) {
                        String str = (String) this.j6.get(i);
                        if (str.equals(this.DW)) {
                            str = str + " (current)";
                        }
                        this.j6.set(i, this.FH.FH.J0(str));
                    }
                    m.DW(com.aide.ui.e.u7(), "Select branch to merge", this.j6, new 1(this));
                }
            }
        }

        6(b bVar, String str, a aVar) {
            this.FH = bVar;
            this.j6 = str;
            this.DW = aVar;
        }

        public void run() {
            try {
                List FH;
                this.FH.tp();
                String DW = this.FH.j6.DW(this.j6, this.DW);
                if (DW != null) {
                    FH = this.FH.j6.FH(this.j6, this.DW);
                } else {
                    FH = new ArrayList();
                }
                com.aide.ui.e.j6(new 1(this, FH, DW));
            } catch (RemoteException e) {
                this.DW.j6(e, null);
            }
        }
    }

    class 7 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ b FH;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ 7 DW;
            final /* synthetic */ a j6;

            class 1 implements Runnable {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public void run() {
                    this.j6.j6.j6(null);
                    this.j6.DW.FH.Ws(this.j6.DW.j6);
                }
            }

            1(7 7, a aVar) {
                this.DW = 7;
                this.j6 = aVar;
            }

            public void run() {
                try {
                    this.DW.FH.j6.FH(this.DW.j6, this.DW.DW, this.j6);
                    com.aide.ui.e.j6(new 1(this));
                } catch (RemoteException e) {
                    this.j6.j6(e, null);
                }
            }
        }

        7(b bVar, String str, String str2) {
            this.FH = bVar;
            this.j6 = str;
            this.DW = str2;
        }

        public void run() {
            if (this.FH.j6("Git merge...", "Merging branches...", true)) {
                com.aide.ui.e.j3().j6(false, false);
                this.FH.FH.execute(new 1(this, this.FH.Hw));
            }
        }
    }

    class 8 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ String FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ String DW;
            final /* synthetic */ 8 FH;
            final /* synthetic */ List j6;

            class 1 implements y<Integer> {
                final /* synthetic */ 1 j6;

                class 1 implements Runnable {
                    final /* synthetic */ String DW;
                    final /* synthetic */ 1 FH;
                    final /* synthetic */ String j6;

                    1(1 1, String str, String str2) {
                        this.FH = 1;
                        this.j6 = str;
                        this.DW = str2;
                    }

                    public void run() {
                        this.FH.j6.FH.Hw.FH(this.FH.j6.FH.FH, this.j6, "refs/" + this.DW);
                    }
                }

                1(1 1) {
                    this.j6 = 1;
                }

                public void j6(Integer num) {
                    String str = (String) this.j6.j6.get(num.intValue());
                    if (!str.endsWith(" (current)")) {
                        if (str.startsWith("remotes/")) {
                            String substring = str.substring(str.lastIndexOf(47) + 1);
                            m.DW(com.aide.ui.e.u7(), "Git", "Create new local branch '" + substring + "' tracking '" + str + "'?", new 1(this, substring, str), null);
                            return;
                        }
                        this.j6.FH.Hw.FH(this.j6.FH.FH, str, null);
                    }
                }
            }

            1(8 8, List list, String str) {
                this.FH = 8;
                this.j6 = list;
                this.DW = str;
            }

            public void run() {
                if (this.FH.DW.j6(null) && !this.j6.isEmpty()) {
                    for (int i = 0; i < this.j6.size(); i++) {
                        String str = (String) this.j6.get(i);
                        if (str.equals(this.DW)) {
                            str = str + " (current)";
                        }
                        this.j6.set(i, this.FH.Hw.J0(str));
                    }
                    m.DW(com.aide.ui.e.u7(), "Select branch", this.j6, new 1(this));
                }
            }
        }

        8(b bVar, String str, a aVar, String str2) {
            this.Hw = bVar;
            this.j6 = str;
            this.DW = aVar;
            this.FH = str2;
        }

        public void run() {
            try {
                List FH;
                this.Hw.tp();
                String DW = this.Hw.j6.DW(this.j6, this.DW);
                if (DW != null) {
                    FH = this.Hw.j6.FH(this.j6, this.DW);
                } else {
                    FH = new ArrayList();
                }
                com.aide.ui.e.j6(new 1(this, FH, DW));
            } catch (RemoteException e) {
                this.DW.j6(e, null);
            }
        }
    }

    class 9 implements Runnable {
        final /* synthetic */ a DW;
        final /* synthetic */ String FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        class 1 implements Runnable {
            final /* synthetic */ 9 DW;
            final /* synthetic */ String j6;

            class 1 implements y<String> {
                final /* synthetic */ 1 j6;

                1(1 1) {
                    this.j6 = 1;
                }

                public void j6(String str) {
                    if (str.length() > 0) {
                        this.j6.DW.Hw.FH(this.j6.DW.FH, str);
                    }
                }
            }

            1(9 9, String str) {
                this.DW = 9;
                this.j6 = str;
            }

            public void run() {
                this.DW.DW.j6(null);
                m.j6(com.aide.ui.e.tp(), "Git", "Branch from current branch '" + this.DW.Hw.J0(this.j6) + "'. New branch name:", "", new 1(this));
            }
        }

        9(b bVar, String str, a aVar, String str2) {
            this.Hw = bVar;
            this.j6 = str;
            this.DW = aVar;
            this.FH = str2;
        }

        public void run() {
            try {
                this.Hw.tp();
                com.aide.ui.e.j6(new 1(this, this.Hw.j6.DW(this.j6, this.DW)));
            } catch (RemoteException e) {
                this.DW.j6(e, null);
            }
        }
    }

    private class a extends com.aide.ui.scm.d.a {
        private List<e> DW;
        private String FH;
        private String Hw;
        private int VH;
        private int Zo;
        private int gn;
        final /* synthetic */ b j6;
        private String tp;
        private boolean u7;
        private int v5;

        class 10 implements Runnable {
            final /* synthetic */ b DW;
            final /* synthetic */ a FH;
            final /* synthetic */ String j6;

            class 1 implements Runnable {
                final /* synthetic */ 10 j6;

                1(10 10) {
                    this.j6 = 10;
                }

                public void run() {
                    this.j6.DW.j6(Boolean.valueOf(true));
                    this.j6.FH.j6.J0();
                }
            }

            class 2 implements Runnable {
                final /* synthetic */ 10 j6;

                2(10 10) {
                    this.j6 = 10;
                }

                public void run() {
                    this.j6.DW.j6(Boolean.valueOf(false));
                    this.j6.FH.j6.J0();
                }
            }

            class 3 implements Runnable {
                final /* synthetic */ 10 j6;

                3(10 10) {
                    this.j6 = 10;
                }

                public void run() {
                    this.j6.DW.cancel(false);
                    this.j6.FH.j6.J0();
                }
            }

            10(a aVar, String str, b bVar) {
                this.FH = aVar;
                this.j6 = str;
                this.DW = bVar;
            }

            public void run() {
                this.FH.VH();
                m.j6(com.aide.ui.e.tp(), "Git", this.j6, new 1(this), new 2(this), new 3(this));
            }
        }

        class 11 implements Runnable {
            final /* synthetic */ b DW;
            final /* synthetic */ a FH;
            final /* synthetic */ String j6;

            class 1 implements Runnable {
                final /* synthetic */ 11 j6;

                1(11 11) {
                    this.j6 = 11;
                }

                public void run() {
                    this.j6.DW.j6(null);
                    this.j6.FH.j6.J0();
                }
            }

            class 2 implements Runnable {
                final /* synthetic */ 11 j6;

                2(11 11) {
                    this.j6 = 11;
                }

                public void run() {
                    this.j6.DW.j6(null);
                    this.j6.FH.j6.J0();
                }
            }

            11(a aVar, String str, b bVar) {
                this.FH = aVar;
                this.j6 = str;
                this.DW = bVar;
            }

            public void run() {
                this.FH.VH();
                m.j6(com.aide.ui.e.tp(), "Git", this.j6, new 1(this), new 2(this));
            }
        }

        class 1 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ int j6;

            1(a aVar, int i) {
                this.DW = aVar;
                this.j6 = i;
            }

            public void run() {
                this.DW.Zo = this.j6;
                this.DW.Zo();
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ d DW;
            final /* synthetic */ a FH;
            final /* synthetic */ RemoteException j6;

            2(a aVar, RemoteException remoteException, d dVar) {
                this.FH = aVar;
                this.j6 = remoteException;
                this.DW = dVar;
            }

            public void run() {
                this.FH.gn();
                m.j6(com.aide.ui.e.tp(), "Git", this.j6);
                com.aide.ui.e.er().FH();
                if (this.DW != null) {
                    this.DW.j6();
                }
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ a j6;

            3(a aVar) {
                this.j6 = aVar;
            }

            public void run() {
                Toast.makeText(com.aide.ui.e.gn(), "Out-of-memory exception in Git service. Make sure your VM heap size is high enough.", 1).show();
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ int DW;
            final /* synthetic */ a FH;
            final /* synthetic */ String j6;

            4(a aVar, String str, int i) {
                this.FH = aVar;
                this.j6 = str;
                this.DW = i;
            }

            public void run() {
                this.FH.Hw = this.j6;
                this.FH.VH = this.DW;
                this.FH.Zo();
            }
        }

        class 5 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ int j6;

            5(a aVar, int i) {
                this.DW = aVar;
                this.j6 = i;
            }

            public void run() {
                this.DW.gn = this.j6;
                this.DW.Zo();
            }
        }

        class 6 implements Runnable {
            final /* synthetic */ a j6;

            6(a aVar) {
                this.j6 = aVar;
            }

            public void run() {
                this.j6.v5 = this.j6.v5 + 1;
                this.j6.gn = this.j6.VH;
                this.j6.Zo();
            }
        }

        class 7 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ String j6;

            7(a aVar, String str) {
                this.DW = aVar;
                this.j6 = str;
            }

            public void run() {
                this.DW.tp = this.j6;
            }
        }

        class 8 implements Runnable {
            final /* synthetic */ b DW;
            final /* synthetic */ a FH;
            final /* synthetic */ String j6;

            class 1 implements y<String> {
                final /* synthetic */ 8 j6;

                1(8 8) {
                    this.j6 = 8;
                }

                public void j6(String str) {
                    this.j6.DW.j6(str);
                    this.j6.FH.j6.J0();
                }
            }

            class 2 implements Runnable {
                final /* synthetic */ 8 j6;

                2(8 8) {
                    this.j6 = 8;
                }

                public void run() {
                    this.j6.DW.cancel(false);
                    this.j6.FH.j6.J0();
                }
            }

            8(a aVar, String str, b bVar) {
                this.FH = aVar;
                this.j6 = str;
                this.DW = bVar;
            }

            public void run() {
                this.FH.VH();
                m.j6(com.aide.ui.e.tp(), "Git", this.j6, new 1(this), new 2(this));
            }
        }

        class 9 implements Runnable {
            final /* synthetic */ b DW;
            final /* synthetic */ a FH;
            final /* synthetic */ String j6;

            class 1 implements y<String> {
                final /* synthetic */ 9 j6;

                1(9 9) {
                    this.j6 = 9;
                }

                public void j6(String str) {
                    this.j6.DW.j6(str);
                    this.j6.FH.j6.J0();
                }
            }

            class 2 implements Runnable {
                final /* synthetic */ 9 j6;

                2(9 9) {
                    this.j6 = 9;
                }

                public void run() {
                    this.j6.DW.cancel(false);
                    this.j6.FH.j6.J0();
                }
            }

            9(a aVar, String str, b bVar) {
                this.FH = aVar;
                this.j6 = str;
                this.DW = bVar;
            }

            public void run() {
                this.FH.VH();
                m.j6(com.aide.ui.e.tp(), "Git", this.j6, "", new 1(this), new 2(this));
            }
        }

        private a(b bVar) {
            this.j6 = bVar;
            this.DW = new ArrayList();
            this.FH = "";
            this.Hw = "";
            this.v5 = 0;
            this.Zo = 1000000;
            this.VH = 1000000;
            this.gn = 0;
            this.u7 = false;
            this.tp = null;
        }

        public void j6(int i) {
            com.aide.ui.e.j6(new 1(this, i));
        }

        public int j6() {
            if (this.Zo == 0) {
                return 0;
            }
            return (this.v5 * 100) / this.Zo;
        }

        public int DW() {
            if (this.VH == 0) {
                return 0;
            }
            return (this.gn * 100) / this.VH;
        }

        public void j6(String str, int i) {
            com.aide.ui.e.j6(new 4(this, str, i));
        }

        public void DW(int i) {
            com.aide.ui.e.j6(new 5(this, i));
        }

        public void FH() {
            com.aide.ui.e.j6(new 6(this));
        }

        public void j6(String str) {
            com.aide.ui.e.j6(new 7(this, str));
        }

        public void Hw() {
        }

        public String DW(String str) {
            b bVar = new b();
            com.aide.ui.e.j6(new 8(this, str, bVar));
            try {
                return (String) bVar.get();
            } catch (CancellationException e) {
                return null;
            } catch (Throwable e2) {
                com.aide.common.e.j6(e2);
                return null;
            } catch (Throwable e22) {
                com.aide.common.e.j6(e22);
                return null;
            }
        }

        public String FH(String str) {
            b bVar = new b();
            com.aide.ui.e.j6(new 9(this, str, bVar));
            try {
                return (String) bVar.get();
            } catch (CancellationException e) {
                return null;
            } catch (Throwable e2) {
                com.aide.common.e.j6(e2);
                return null;
            } catch (Throwable e22) {
                com.aide.common.e.j6(e22);
                return null;
            }
        }

        public String Hw(String str) {
            b bVar = new b();
            com.aide.ui.e.j6(new 10(this, str, bVar));
            try {
                return ((Boolean) bVar.get()).toString();
            } catch (CancellationException e) {
                return null;
            } catch (Throwable e2) {
                com.aide.common.e.j6(e2);
                return null;
            } catch (Throwable e22) {
                com.aide.common.e.j6(e22);
                return null;
            }
        }

        public void v5(String str) {
            b bVar = new b();
            com.aide.ui.e.j6(new 11(this, str, bVar));
            try {
                bVar.get();
            } catch (CancellationException e) {
            } catch (Throwable e2) {
                com.aide.common.e.j6(e2);
            } catch (Throwable e22) {
                com.aide.common.e.j6(e22);
            }
        }

        private void Zo() {
            for (e J0 : this.DW) {
                J0.J0();
            }
        }

        private void VH() {
            for (e J8 : this.DW) {
                J8.J8();
            }
        }

        private boolean j6(c cVar) {
            return j6((d) cVar, null);
        }

        private <TResult> boolean j6(d<TResult> dVar, TResult tResult) {
            gn();
            if (this.u7) {
                Toast.makeText(com.aide.ui.e.tp(), "Git operation cancelled.", 0).show();
                if (dVar != null) {
                    dVar.DW();
                }
            } else if (this.tp != null) {
                m.j6(com.aide.ui.e.tp(), "Git", this.tp);
                if (dVar != null) {
                    dVar.j6();
                }
            } else {
                if (dVar != null) {
                    dVar.j6(tResult);
                }
                com.aide.ui.e.u7().g3();
            }
            if (this.u7 || this.tp != null) {
                return false;
            }
            return true;
        }

        private <T> void j6(RemoteException remoteException, d<T> dVar) {
            com.aide.common.e.j6((Throwable) remoteException);
            com.aide.ui.e.j6(new 2(this, remoteException, dVar));
        }

        private void gn() {
            if (this.j6.Hw == this) {
                this.j6.Hw = null;
            }
            Zo();
        }

        public void v5() {
            com.aide.ui.e.j6(new 3(this));
        }
    }

    private static class b<T> implements Future<T> {
        private boolean DW;
        private boolean FH;
        private T Hw;
        private Object j6;

        private b() {
            this.j6 = new Object();
        }

        public boolean cancel(boolean z) {
            boolean z2 = true;
            synchronized (this.j6) {
                if (this.FH) {
                    z2 = false;
                } else {
                    this.DW = true;
                    this.j6.notifyAll();
                }
            }
            return z2;
        }

        public boolean isCancelled() {
            boolean z;
            synchronized (this.j6) {
                z = this.DW;
            }
            return z;
        }

        public boolean isDone() {
            boolean z;
            synchronized (this.j6) {
                z = this.FH;
            }
            return z;
        }

        public T get() {
            try {
                return get(-1, null);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }

        public T get(long j, TimeUnit timeUnit) {
            if (timeUnit == TimeUnit.MILLISECONDS) {
                throw new IllegalArgumentException();
            }
            T t;
            synchronized (this.j6) {
                if (this.FH) {
                    t = this.Hw;
                } else if (this.DW) {
                    throw new CancellationException();
                } else {
                    if (j < 0) {
                        this.j6.wait();
                    } else {
                        this.j6.wait(j);
                    }
                    if (this.FH) {
                        t = this.Hw;
                    } else if (this.DW) {
                        throw new CancellationException();
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
            return t;
        }

        public void j6(T t) {
            synchronized (this.j6) {
                if (this.FH) {
                    throw new IllegalStateException();
                } else if (this.DW) {
                } else {
                    this.FH = true;
                    this.Hw = t;
                    this.j6.notifyAll();
                }
            }
        }
    }

    public interface e {
        void J0();

        void J8();
    }

    public b() {
        this.v5 = new Object();
    }

    public void j6() {
        this.FH = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.DW = new 1(this);
    }

    public boolean j6(String str) {
        return (str == null || com.aide.ui.e.a8().J8(str) || FH(str) || qh.tp(str)) ? false : true;
    }

    public boolean DW(String str) {
        return str != null && FH(str);
    }

    public boolean FH(String str) {
        return we(str) != null;
    }

    public String Hw(String str) {
        return we(str) + "/.git";
    }

    private String we(String str) {
        if (!qh.tp(str)) {
            for (File file = new File(str); file != null; file = file.getParentFile()) {
                if (j6(file)) {
                    return file.getPath();
                }
            }
        }
        return null;
    }

    private boolean j6(File file) {
        return new File(file, ".git").exists();
    }

    private boolean gn() {
        boolean z = true;
        synchronized (this.v5) {
            if (this.j6 != null || com.aide.ui.e.gn().bindService(new Intent(com.aide.ui.e.gn(), ExternalGitService.class), this.DW, 1)) {
            } else {
                com.aide.common.e.j6("Could not bind to Gitservice");
                z = false;
            }
        }
        return z;
    }

    public boolean j6(String str, String str2) {
        if (str2.length() == 0 || str2.contains(File.separator)) {
            return false;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            return false;
        }
        try {
            file.getCanonicalPath();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean u7() {
        if (this.FH.getActiveCount() > 0 || this.Hw != null) {
            m.j6(com.aide.ui.e.tp(), "Git", "Running multiple Git operations at once is not allowed");
            return true;
        }
        this.Hw = new a();
        return false;
    }

    private void tp() {
        synchronized (this.v5) {
            if (this.j6 == null) {
                try {
                    this.v5.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void j6(String str, String str2, List<String> list, Runnable runnable) {
        if (j6("Git create...", "Creating...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 12(this, J8(), str, str2, list, aVar, runnable));
        }
    }

    public void j6(String str, String str2, String str3) {
        if (j6("Git clone...", "Connecting...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 13(this, J8(), str, str2, str3, aVar));
        }
    }

    public void v5(String str) {
        if (j6("Git pull...", "Connecting...", true)) {
            a aVar = this.Hw;
            String we = we(str);
            this.FH.execute(new 14(this, J8(), we, aVar));
        }
    }

    public void Zo(String str) {
        if (j6("Git push...", "Getting branch...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 15(this, we(str), aVar, str));
        }
    }

    private String J0(String str) {
        if (str.startsWith("refs/heads/")) {
            return str.substring("refs/heads/".length());
        }
        if (str.startsWith("refs/")) {
            return str.substring("refs/".length());
        }
        return str;
    }

    private void J8(String str) {
        if (j6("Git push...", "Connecting...", true)) {
            com.aide.ui.e.j3().j6(false, false);
            a aVar = this.Hw;
            String we = we(str);
            this.FH.execute(new 16(this, J8(), we, aVar));
        }
    }

    public void VH(String str) {
        if (!EQ()) {
            m.j6(com.aide.ui.e.tp(), "Git", "User name and email not set in Git Source Control Settings.", new 17(this));
        } else if (j6("Git commit...", "Getting file status...", true)) {
            com.aide.ui.e.j3().j6(false, false);
            a aVar = this.Hw;
            this.FH.execute(new 18(this, we(str), aVar));
        }
    }

    private boolean EQ() {
        return h.lg() != null && h.lg().length() > 0 && h.rN() != null && h.rN().indexOf(64) > 0;
    }

    public void j6(String str, List<ModifiedFile> list, String str2, c cVar) {
        if (j6("Git commit...", "Committing changes...", true)) {
            com.aide.ui.e.nw().j6(str);
            a aVar = this.Hw;
            this.FH.execute(new 19(this, J8(), str, list, str2, aVar, cVar));
        }
    }

    public void j6(String str, List<ModifiedFile> list, c cVar) {
        if (j6("Git discard...", "Discarding changes...", true)) {
            this.FH.execute(new 2(this, str, list, this.Hw, cVar));
        }
    }

    public void j6(String str, d<String> dVar) {
        if (we()) {
            a aVar = new a();
            this.FH.execute(new 3(this, we(str), str, aVar, dVar));
        }
    }

    public void gn(String str) {
        if (j6("Git delete branch...", "Getting branches...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 4(this, we(str), aVar));
        }
    }

    private void DW(String str, String str2) {
        if (j6("Git delete branch...", "Deleting branch...", true)) {
            com.aide.ui.e.j3().j6(false, false);
            this.FH.execute(new 5(this, str, str2, this.Hw));
        }
    }

    public void u7(String str) {
        if (j6("Git merge...", "Getting branches...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 6(this, we(str), aVar));
        }
    }

    private void DW(String str, String str2, String str3) {
        m.DW(com.aide.ui.e.tp(), "Git", "Merge branch '" + str3 + "' into current branch '" + str2 + "'?", new 7(this, str, str3), null);
    }

    public void tp(String str) {
        if (j6("Git checkout...", "Getting branches...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 8(this, we(str), aVar, str));
        }
    }

    public void EQ(String str) {
        if (j6("Git branch...", "Getting branch...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 9(this, we(str), aVar, str));
        }
    }

    private void FH(String str, String str2) {
        if (j6("Git branch...", "Create branch...", true)) {
            a aVar = this.Hw;
            this.FH.execute(new 10(this, we(str), str2, aVar));
        }
    }

    private void FH(String str, String str2, String str3) {
        if (j6("Git checkout...", "Checking out branch...", true)) {
            com.aide.ui.e.j3().j6(false, false);
            a aVar = this.Hw;
            this.FH.execute(new 11(this, str3, we(str), str2, aVar));
        }
    }

    private boolean j6(String str, String str2, boolean z) {
        if (u7() || !gn()) {
            return false;
        }
        this.Hw.FH = str;
        this.Hw.Hw = str2;
        if (z) {
            J0();
        }
        return true;
    }

    private boolean we() {
        if (gn()) {
            return true;
        }
        return false;
    }

    private void J0() {
        m.j6(com.aide.ui.e.tp(), new nv());
    }

    public String DW() {
        return this.Hw == null ? "" : this.Hw.FH;
    }

    public String FH() {
        return this.Hw == null ? "" : this.Hw.Hw;
    }

    public boolean Hw() {
        return this.Hw != null;
    }

    public int v5() {
        if (this.Hw == null) {
            return 0;
        }
        return this.Hw.DW();
    }

    public int Zo() {
        if (this.Hw == null) {
            return 0;
        }
        return this.Hw.j6();
    }

    public void VH() {
        this.Hw.u7 = true;
        try {
            this.j6.j6();
        } catch (Throwable e) {
            com.aide.common.e.j6(e);
            m.j6(com.aide.ui.e.tp(), "Git", e);
        }
    }

    public void j6(e eVar) {
        if (this.Hw != null) {
            this.Hw.DW.add(eVar);
        }
    }

    public void DW(e eVar) {
        if (this.Hw != null) {
            this.Hw.DW.remove(eVar);
        }
    }

    private GitConfiguration J8() {
        return new GitConfiguration(h.lg(), h.rN(), h.a8(), h.U2());
    }

    private void Ws(String str) {
        if (com.aide.ui.e.a8().J0() && qh.FH(str, com.aide.ui.e.a8().u7())) {
            com.aide.ui.e.a8().j6(null, false);
        }
    }
}
