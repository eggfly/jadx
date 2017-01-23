package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Status;

class aw implements b {
    private a DW;
    private Status FH;
    private b Hw;
    private d VH;
    private boolean Zo;
    private a j6;
    private a v5;

    public interface a {
        String DW();

        void j6();

        void j6(String str);
    }

    private class b extends Handler {
        private final com.google.android.gms.tagmanager.b.a DW;
        final /* synthetic */ aw j6;

        public void handleMessage(Message message) {
            switch (message.what) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    j6((String) message.obj);
                default:
                    r.j6("Don't know how to handle this message.");
            }
        }

        protected void j6(String str) {
            this.DW.j6(this.j6, str);
        }
    }

    public Status DW() {
        return this.FH;
    }

    void DW(String str) {
        if (this.Zo) {
            r.j6("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.v5.j6(str);
        }
    }

    public synchronized void FH() {
        if (this.Zo) {
            r.j6("Refreshing a released ContainerHolder.");
        } else {
            this.v5.j6();
        }
    }

    String Hw() {
        if (!this.Zo) {
            return this.j6.j6();
        }
        r.j6("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public synchronized void j6() {
        if (this.Zo) {
            r.j6("Releasing a released ContainerHolder.");
        } else {
            this.Zo = true;
            this.VH.j6(this);
            this.j6.DW();
            this.j6 = null;
            this.DW = null;
            this.v5 = null;
            this.Hw = null;
        }
    }

    public synchronized void j6(String str) {
        if (!this.Zo) {
            this.j6.j6(str);
        }
    }

    String v5() {
        if (!this.Zo) {
            return this.v5.DW();
        }
        r.j6("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }
}
