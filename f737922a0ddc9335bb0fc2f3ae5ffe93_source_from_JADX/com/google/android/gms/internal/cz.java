package com.google.android.gms.internal;

import aet;
import aeu;
import aev;
import aew;
import aex;
import aey;
import aez;
import com.google.android.gms.common.internal.b;

@eh
public final class cz implements aeu, aew, aey {
    private aez DW;
    private final ct j6;

    public cz(ct ctVar) {
        this.j6 = ctVar;
    }

    public void DW(aet aet) {
        b.DW("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdOpened.");
        try {
            this.j6.Hw();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdOpened.", e);
        }
    }

    public void DW(aev aev) {
        b.DW("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdOpened.");
        try {
            this.j6.Hw();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdOpened.", e);
        }
    }

    public void DW(aex aex) {
        b.DW("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdClosed.");
        try {
            this.j6.DW();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdClosed.", e);
        }
    }

    public void FH(aet aet) {
        b.DW("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdClosed.");
        try {
            this.j6.DW();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdClosed.", e);
        }
    }

    public void FH(aev aev) {
        b.DW("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdClosed.");
        try {
            this.j6.DW();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdClosed.", e);
        }
    }

    public void FH(aex aex) {
        b.DW("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLeftApplication.");
        try {
            this.j6.FH();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLeftApplication.", e);
        }
    }

    public void Hw(aet aet) {
        b.DW("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLeftApplication.");
        try {
            this.j6.FH();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLeftApplication.", e);
        }
    }

    public void Hw(aev aev) {
        b.DW("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLeftApplication.");
        try {
            this.j6.FH();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLeftApplication.", e);
        }
    }

    public void Hw(aex aex) {
        b.DW("onAdClicked must be called on the main UI thread.");
        aez j6 = j6();
        if (j6 == null) {
            com.google.android.gms.ads.internal.util.client.b.Hw("Could not call onAdClicked since NativeAdMapper is null.");
        } else if (j6.DW()) {
            com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdClicked.");
            try {
                this.j6.j6();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdClicked.", e);
            }
        } else {
            com.google.android.gms.ads.internal.util.client.b.j6("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        }
    }

    public aez j6() {
        return this.DW;
    }

    public void j6(aet aet) {
        b.DW("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLoaded.");
        try {
            this.j6.v5();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLoaded.", e);
        }
    }

    public void j6(aet aet, int i) {
        b.DW("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.j6.j6(i);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdFailedToLoad.", e);
        }
    }

    public void j6(aev aev) {
        b.DW("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLoaded.");
        try {
            this.j6.v5();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLoaded.", e);
        }
    }

    public void j6(aev aev, int i) {
        b.DW("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.j6.j6(i);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdFailedToLoad.", e);
        }
    }

    public void j6(aex aex) {
        b.DW("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdOpened.");
        try {
            this.j6.Hw();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdOpened.", e);
        }
    }

    public void j6(aex aex, int i) {
        b.DW("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.j6.j6(i);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdFailedToLoad.", e);
        }
    }

    public void j6(aex aex, aez aez) {
        b.DW("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLoaded.");
        this.DW = aez;
        try {
            this.j6.v5();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLoaded.", e);
        }
    }

    public void v5(aet aet) {
        b.DW("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdClicked.");
        try {
            this.j6.j6();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdClicked.", e);
        }
    }

    public void v5(aev aev) {
        b.DW("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdClicked.");
        try {
            this.j6.j6();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdClicked.", e);
        }
    }
}
